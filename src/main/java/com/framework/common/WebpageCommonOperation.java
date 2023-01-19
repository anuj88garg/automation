package com.framework.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.Headers;
import org.openqa.selenium.devtools.v108.network.model.Request;
import org.openqa.selenium.devtools.v108.network.model.RequestId;
import org.openqa.selenium.devtools.v108.network.model.Response;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.configuration.WebdriverInitialization;
import com.framewrok.testUtils.ApiUtils;
import com.framewrok.testUtils.ApiUtilsCommon;


public class WebpageCommonOperation{
	
	WebDriver driver = WebdriverInitialization.driver;
	DevTools nwTools;
	RequestId reqId;
	String initiatePayload;
	static String orderID;
	boolean flag = true;
	String url;
	ApiUtilsCommon apiUtils = new ApiUtilsCommon();

	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void openApplication(String url ) {
		driver.get(url);	
	}
	
//	public String fetchOTP(String MobileNo) {
//		return ApiUtils.sendOTP();
//	}
	
	public void switchToFrame(String id) {
		applyWaitFor(15,"id","simpl-checkout-iframe");
		driver.switchTo().frame(id);
	}
	
	@SuppressWarnings("deprecation")
	public void applyWaitFor(long timeInSeconds, String locator, String uniqueIdentity) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		
		if(locator.equals("xpath")) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uniqueIdentity)));
		}
		
		if(locator.equals("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(uniqueIdentity)));
		}
	}
	
	public void setOrderIDFromNetworkTab() {
		nwTools = ((ChromeDriver)driver).getDevTools();
		nwTools.createSession();
		nwTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		nwTools.addListener(Network.requestWillBeSent(), request ->
//		{
//		String reqURL = request.getRequest().getUrl();
//		if(reqURL.contains("https://checkout-api.stagingsimpl.com/api/v1/order/initiate")) {
//			reqId = request.getRequestId();
//			String url = request.getRequest().getUrl();
//			System.out.println("Request Id is :" + reqId.toString());
//			System.out.println("Request URL is :" + url);
//		}
//			
//		System.out.println("URL is: "+ reqURL);
//		});
//		
		nwTools.addListener(Network.responseReceived(), response ->
		{
	     url = response.getResponse().getUrl();
	     if(url.equalsIgnoreCase("https://checkout-api.stagingsimpl.com/api/v1/order/initiate")){
			 initiatePayload = nwTools.send(Network.getResponseBody(response.getRequestId())).getBody();
			//if(orderInitiateApiCount++ == 1) {
			System.out.println("Order Initiate payload is: "+ initiatePayload);
			//}
		if(flag) {
			 JSONObject payload = new JSONObject(initiatePayload);
			 orderID = payload.getJSONObject("data").getString("order_id");
		     System.out.println("Order ID: "+ orderID);
			 flag = false;
			}
		}		
	});
//		 JSONObject payload = new JSONObject(initiatePayload);
//		 orderID = payload.getJSONObject("data").getString("order_id");
//		 System.out.println("Order ID: "+ orderID);
		

	}
	
	public String fetchOMSOrderID() {
		return WebpageCommonOperation.orderID;
	}
	
	public void storeCookies() {
		 File file = new File("/Users/simpl/Eclipse-PersonalWorkSpace/automation/src/main/resources/Cookies.data");							
	        try		
	        {	  
	            // Delete old file if exists
				file.delete();		
	            file.createNewFile();			
	            FileWriter fileWrite = new FileWriter(file);							
	            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
	            // loop for getting the cookie information 		
	            	
	            // loop for getting the cookie information 
	            Cookie ck = driver.manage().getCookieNamed("_iidt");
	            						
	            Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
	            Bwrite.newLine();             
	            		
	            Bwrite.close();			
	            fileWrite.close();	
	            
	        }
	        catch(Exception ex)					
	        {		
	            ex.printStackTrace();			
	        }		
	    }	
	
	public void readStoredCookies() {
		try {
		File file = new File("/Users/simpl/Eclipse-PersonalWorkSpace/automation/src/main/resources/Cookies.data");							
        FileReader fileReader = new FileReader(file);							
        BufferedReader Buffreader = new BufferedReader(fileReader);							
        String strline;			
        while((strline=Buffreader.readLine())!=null){									
        StringTokenizer token = new StringTokenizer(strline,";");									
        while(token.hasMoreTokens()){					
        String name = token.nextToken();					
        String value = token.nextToken();					
        String domain = token.nextToken();					
        String path = token.nextToken();					
        Date expiry = null;					
        		
        String val;			
        if(!(val=token.nextToken()).equals("null"))
		{		
        	expiry = new Date(val);					
        }		
        Boolean isSecure = new Boolean(token.nextToken()).								
        booleanValue();		
        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
        System.out.println(ck);
        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
        }		
        }		
        }catch(Exception ex){					
        ex.printStackTrace();			
        }		
	}
	
	
	
	
}
