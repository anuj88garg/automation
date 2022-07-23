package com.framework.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverInitialization {
//	
	protected static WebDriver driver;
	static int i = 0;
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
			driver = new ChromeDriver();
				
		}
		else if(System.getProperty("app.browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
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
	
	@AfterTest
	public void quitBrowser() {
		System.out.println("quit browser is triggered; " + ++i);
		driver.quit();
	}
	


}
