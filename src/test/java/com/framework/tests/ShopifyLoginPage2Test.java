package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopifyLoginPage2Test extends WebdriverInitialization{
	
	WebpageCommonOperation op;
	ShopifyLoginPage2 slp;
	
	@BeforeClass
	public void setup() {
		System.out.println("I am in Shopify Login setup");
		op = new WebpageCommonOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		
		
	}
	
	@Test
	public ShopifyHomePage verifyShopifyLogin() {
		System.out.println("I am in Shopify Login page to enter password");
		return slp.loginToShopify("drisho");

	}
}
