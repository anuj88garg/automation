package com.framewrok.testUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static com.framework.configuration.PropertiesReader.*;



public class ApiData {
	
	static Map<String,String> headers = new HashMap<String,String>();

	static Map<String,String> params = new HashMap<String,String>();
	
 
  public static Map<String,String> fetchGoogleTokenHeaders() throws IOException {
	  headers.clear();
	  headers.put("Cookie", getProperty("cookieGauth"));
	  headers.put("Referer", "https://accounts.google.com/o/oauth2/iframe");
	  headers.put("X-Requested-With", "XmlHttpRequest");
	  return headers;
		
	}
  
  public static Map<String,String> fetchGoogleTokenParams() throws IOException {
	 params.clear();
	 params.put("action","issueToken");
	 params.put("response_type", "token id_token");
	 params.put("login_hint", "AJDLj6LIcaibEtePtFdpDbCYsOyr2tIBJJ7azv25nmE9CgUq99vKz7iwzXW2Hc8VGm8ACkII3hNE4EFychR4areNoJYGd1tk3M4H0qJcw176U3OEciULAVU");
	 params.put("client_id", "763237155836-hje3b4aqv9kl3kck36m3iqgbqdken1i7.apps.googleusercontent.com");
	 params.put("origin", "https://quickview.stagingsimpl.com");
	 params.put("scope", "openid profile email");
	 params.put("ss_domain", "https://quickview.stagingsimpl.com");
	 params.put("include_granted_scopes", "true");
	 return params;
		
	}
	
  public static Map<String,String> fetchMetabaseAuthHeaders() throws IOException {
	  headers.clear();
	  headers.put("Cookie","metabase.DEVICE=7251dfcb-3b78-4137-b72b-e8672575aabe; G_ENABLED_IDPS=google");
	  headers.put("Referer","https://quickview.stagingsimpl.com/auth/login?redirect=%2F");
	  headers.put("Origin", "https://quickview.stagingsimpl.com");
	  return headers;
		
	}
  
  public static String MetabaseAuthPayload(String tkn) {
	  String s = "{\"token\":"+ "\""+ tkn +"\""+"}";
	  return s;
  }
  
  public static Map<String,String> fetchOTPHeaders(String sessionID)throws IOException {
	  headers.clear();
	  headers.put("X-Metabase-Session",sessionID);
	  return headers;
		
	}
  
  public static String OTPBody(String phoneNo) {
	  return "{"
	  		+ "\"type\": \"native\","
	  		+ "\"native\": {"
	  		+ 	"\"query\":\"Select OTP_CODE from (select OTP_CODE, row_number() over(order by created_at desc) AS rw from verifications where PHONE_NUMBER = " + "'" +phoneNo +"'" + " and attempt_count = 0 ) A where rw = 1\","
	  		+ 		"\"template-tags\": {}"
	  		+ "}," 
	  		+ "\"database\":" + 22 +","
	  		+ "\"parameters\": []"
	  		+ "}";
  }
	
}


	
// static String logglyBaseURI = "https://getsimpl.loggly.com";
// static String token = "cbe599ab-3114-4650-adbb-56b1a12e5f24";
// static private ScheduledExecutorService scheduler;
// static int attempt = 0;
// static String otp;
// static String previousOTP;
// Map<String, Integer> otps;
//
//public static void retrieveOTP() {
//	scheduler = Executors.newScheduledThreadPool(1);
//    final Runnable beeper = new Runnable() {
//        public void run() {
//        	baseURI = logglyBaseURI;
//        	Response res = given()
//					.log()
//					.all()
//					.queryParam("q", "9011624625" + " AND your OTP is")
//					.queryParam("from", "-48h")
//					.header("Authorization","Bearer " + token)
//					.header("Content-Type","application/json")
//					.when()
//					.get("/apiv2/events/iterate")
//					.then()
//					.extract()
//					.response();
//	
//	
//	String respStr = res.asString();
//	int otpStrIndex = respStr.indexOf("OTP");
//	String otpStr = respStr.substring(otpStrIndex, otpStrIndex+11);
//	otp = otpStr.split(" ")[2];
//	System.out.println("OTP is : "+otp);
//	attempt++;
//			
//            if (attempt == 6 || (!otp.equals(previousOTP) && attempt != 1)) {
//                scheduler.shutdown();
//            }
//            previousOTP = otp;
//        }
//       
//    };
//    scheduler.scheduleAtFixedRate(
//            beeper, 5, 2, TimeUnit.SECONDS);
//    
// 
//   
//}
//
//public static String sendOTP() {
//	ApiData.retrieveOTP();
//	while(otp==null) {
//	System.out.println(otp);
//	}
//	return otp;
//}
//
//}
	
//	Response res = given()
//					.log()
//					.all()
//					.queryParam("q", mobNo + " AND your OTP is")
//					.queryParam("from", "-5m")
//					.header("Authorization","Bearer " + token)
//					.header("Content-Type","application/json")
//					.when()
//					.get("/apiv2/events/iterate")
//					.then()
//					.extract()
//					.response();
//	
//	
//	String respStr = res.asString();
//	int otpStrIndex = respStr.indexOf("OTP");
//	String otpStr = respStr.substring(otpStrIndex, otpStrIndex+11);
//	String otp = otpStr.split(" ")[2];
//	System.out.println("OTP is : "+otp);
//	return otp;
//	
	
	
