package com.framework.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverInitialization {
	
	static WebDriver driver;
	
	static String webdriverPath = "C:\\Users\\anuj88garg\\.m2\\repository\\org\\seleniumhq\\selenium";
	
	public static WebDriver chromeDriver(){
		
		//System.setProperty("webdriver.chrome.driver", webdriverPath +"\\selenium-chrome-driver\\4.1.2\\selenium-chrome-driver-4.1.2.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		return driver;
		
	}
	
public static WebDriver firefoxDriver(){
		
		System.setProperty("webdriver.gecko.driver", webdriverPath +"\\selenium-firefox-driver\\4.1.2\\selenium-firefox-driver-4.1.2.exe");
		driver = new FirefoxDriver();
		
		return driver;
		
	}

}
