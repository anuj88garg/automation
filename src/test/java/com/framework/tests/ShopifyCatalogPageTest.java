package com.framework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommomOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyCatalogPage;
import com.ui.pages.ShopifyCheckoutPage;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;

public class ShopifyCatalogPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommomOperation op;
	ShopifyCatalogPage scp;
	
	@BeforeMethod
	public void setup() {
		op = new WebpageCommomOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickShopAll();
	}
	
	@Test
	public ShopifyCheckoutPage verifyProducisGettinSelected() {
		scp.clickItemFloralWhiteTop();
		return new ShopifyCheckoutPage();
	}
}