package com.framewrok.testUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ApiUtilsCommon {
	
	public Response getRequest(String baseURL,String resource, Map<String,String> headers, Map<String,String> params) throws IOException {
		baseURI = baseURL;
		Response resAccount = given()
						.log()
						.all()
						.queryParams(params)
						.headers(headers)
						.when()
						.get(resource)
						.then()
						.extract()
						.response();
		return resAccount;
	}
	
	public Response postRequest(String baseURL,String resource, Map<String,String> headers, Map<String,String> params,String body) throws IOException {
		baseURI = baseURL;
		Response resMetabase = given()
				.log()
				.all()
				.headers(headers)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.and()
				.body(body)
				.when()
				.post(resource)
				.then()
				.extract()
				.response();
		return resMetabase;
	}
}
	
// String logglyBaseURI = "https://accounts.google.com/o/oauth2/iframerpc";
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
//        	RestAssured.baseURI = logglyBaseURI;
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
//	ApiUtilsCommon.retrieveOTP();
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
	
	
