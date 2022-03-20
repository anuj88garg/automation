package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.configuration.WebdriverInitialization;

public class AutomateBasicComponentsTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
		driver = WebdriverInitialization.chromeDriver();
	}
	
	@Test
	public void testxyz(){
		driver.get("https://www.google.com");
	}

}


