package com.framewrok.testUtils;

import static com.framework.configuration.PropertiesReader.getProperty;
import static com.framewrok.testUtils.ApiData.MetabaseAuthPayload;
import static com.framewrok.testUtils.ApiData.OTPBody;
import static com.framewrok.testUtils.ApiData.fetchGoogleTokenHeaders;
import static com.framewrok.testUtils.ApiData.fetchGoogleTokenParams;
import static com.framewrok.testUtils.ApiData.fetchMetabaseAuthHeaders;
import static com.framewrok.testUtils.ApiData.fetchOTPHeaders;

import java.io.IOException;
import java.util.Collections;

import org.json.JSONObject;

import com.framework.common.WebpageCommonOperation;

import io.restassured.response.Response;


public class ApiUtils {
	
	static ApiUtilsCommon utility = new ApiUtilsCommon();
	static String OTP;
	WebpageCommonOperation opr = new WebpageCommonOperation();
	

public static String fetchOTP(String phoneNo) throws IOException {
	
	Response resAccount = utility.getRequest(getProperty("googleTokenBaseUrl"), "/o/oauth2/iframerpc",fetchGoogleTokenHeaders(),fetchGoogleTokenParams());
	String response = resAccount.asString();
	JSONObject json = new JSONObject(response);
	String idToken = json.getString("id_token");
	System.out.println("This is token needs to be passed :" + idToken);
	
	Response resMetabaseAuth = utility.postRequest(getProperty("metabaseBaseUrl"), "api/session/google_auth", fetchMetabaseAuthHeaders(), Collections.<String, String>emptyMap(), MetabaseAuthPayload(idToken));
	//Response resMetabaseAuth = utility.postRequest(getProperty("metabaseBaseUrl"), "api/session/google_auth", fetchMetabaseAuthHeaders(), MetabaseAuthPayload(idToken));
	String respMetabase = resMetabaseAuth.asString();
	JSONObject jsonMetabase = new JSONObject(respMetabase);
	String id = jsonMetabase.getString("id");
	
	Response resOTP = utility.postRequest(getProperty("metabaseBaseUrl"), "api/dataset", fetchOTPHeaders(id), Collections.<String, String>emptyMap(),OTPBody(phoneNo));
	String respOTP = resOTP.asString();
	System.out.println("Response: "+ respOTP);
	JSONObject jsonOTP = new JSONObject(respOTP);
	//String OTP = jsonOTP.getString("id");
	if(String.valueOf(jsonOTP.getJSONObject("data").getJSONArray("rows")).equals("[]")){
		System.out.println("OTP is not getting generated...please check. Hence exiting");
		System.exit(1);
	}
	else {
		OTP= String.valueOf(jsonOTP.getJSONObject("data").getJSONArray("rows").get(0)).substring(2,6);
	}
	 return OTP;
	
	}

   public Response getOMSOrderDetails() throws IOException {
	Response orderDetailsResponse = utility.getRequest("https://checkout-gateway.stagingsimpl.com", "/api/v1/order/"+ opr.fetchOMSOrderID(), Collections.<String,String>emptyMap(), Collections.<String,String>emptyMap());
	return orderDetailsResponse;
}

}



	
	
	
	
	
	
