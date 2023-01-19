package com.framework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyCatalogPage;
import com.ui.pages.ShopifyCheckoutPage;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;

public class ShopifyCatalogPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommonOperation op;
	ShopifyCatalogPage scp;
	
	@BeforeMethod
	public void setup() {
		op = new WebpageCommonOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickCatalog();
	}
	
	@Test
	public ShopifyCheckoutPage verifyProducisGettinSelected() {
		scp.clickItemFloralWhiteTop();
		return new ShopifyCheckoutPage();
	}
}