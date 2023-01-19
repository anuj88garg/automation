package com.framework.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.framewrok.testUtils.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.framework.common.*;

public class WebdriverInitialization {
//	
	public static WebDriver driver;
	public static int i = 0;
	public static EventFiringWebDriver eFiringDriver;
	public static WebEventListener event;
	public static DevTools nwTools;
	
//	
//	static String webdriverPath = "C:\\Users\\anuj88garg\\.m2\\repository\\org\\seleniumhq\\selenium";
//	
//	public static WebDriver chromeDriver(){
//		
//		//System.setProperty("webdriver.chrome.driver", webdriverPath +"\\selenium-chrome-driver\\4.1.2\\selenium-chrome-driver-4.1.2.exe");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		
//		return driver;
//		
//	}
//	
//public static WebDriver firefoxDriver(){
//		
//		System.setProperty("webdriver.gecko.driver", webdriverPath +"\\selenium-firefox-driver\\4.1.2\\selenium-firefox-driver-4.1.2.exe");
//		driver = new FirefoxDriver();
//		
//		return driver;
//		
//	}
	
	@BeforeTest
	public WebDriver launchBrowser(){
		if(System.getProperty("app.browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("disable-features=IsolateOrigins","https://checkout-api.stagingsimpl.com/api/v1/order/initiate");
			//options.addArguments("disable-web-security","user-data-dir=/Users/Simpl/Library/ApplicationSupport/Google/Chrome");
			options.addArguments("--disable-site-isolation-trials");
			options.setHeadless(Boolean.valueOf(System.getProperty("headless.browser")));
			//options.addArguments("start-maximized");
			options.addArguments("window-size=1920,1080");
			//options.setExperimentalOption("args", Arrays.asList("disable-web-security"));
			driver = new ChromeDriver(options);	
			
				
		}
		else if(System.getProperty("app.browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		eFiringDriver = new EventFiringWebDriver(driver);
		event = new WebEventListener();
		eFiringDriver.register(event);
		//driver=eFiringDriver;
		WrapsDriver wrapperAccess = (WrapsDriver)eFiringDriver;
		WebDriver driver = wrapperAccess.getWrappedDriver();

//		nwTools = ((ChromeDriver)driver).getDevTools();
//		nwTools.createSession();
//		nwTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));	
//		nwTools.addListener(Network.responseReceived(), response ->
//		{
//		String s = response.getResponse().getUrl();
//		System.out.println("URL is: "+ s);
//	
//		});

		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		return driver;
	}
	
	
	
//	public WebdriverInitialization(){
//		if(System.getProperty("app.browser").equalsIgnoreCase("chrome")){
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://www.rahulshettyacademy.com/");
//		}
//		else if(System.getProperty("app.browser").equalsIgnoreCase("firefox")){
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//	}
	
	//@AfterTest
	public void quitBrowser() {
		System.out.println("quit browser is triggered; " + ++i);
		driver.quit();
	}
	


}
