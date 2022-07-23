package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommomOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopifyLoginPage2Test {
	
	WebpageCommomOperation op;
	ShopifyLoginPage2 slp;
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("I am in Shopify Login setup");
		op = new WebpageCommomOperation();
		slp = new ShopifyLoginPage2();
		//op.openApplication("https://testing-simpl.myshopify.com");
		driver.get("https://testing-simpl.myshopify.com");
		
		
	}
	
	@Test
	public ShopifyHomePage verifyShopifyLogin() {
		System.out.println("I am in Shopify Login page to enter password");
		return slp.loginToShopify("drisho");

	}
}
