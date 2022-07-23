package com.framework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommomOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;

public class ShopifyHomePageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommomOperation op;
	
	@BeforeMethod
	public void setup() {
		op = new WebpageCommomOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
	//	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("drisho");
		shp = slp.loginToShopify("drisho");
		
	}
	
	@Test
	public void verifyNavigationToCatalogPage() {
		shp.clickShopAll();
	}
}