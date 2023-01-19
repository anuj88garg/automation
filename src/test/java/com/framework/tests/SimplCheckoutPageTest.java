package com.framework.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyCatalogPage;
import com.ui.pages.ShopifyCheckoutPage;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;
import com.ui.pages.SimplCheckoutPage;
import com.ui.pages.SimplLoginPage;

public class SimplCheckoutPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommonOperation op;
	ShopifyCatalogPage scp;
	ShopifyCheckoutPage sCheckout;
	SimplLoginPage simplLogin;
	SimplCheckoutPage simplCheckout;
	
	@BeforeClass
	public void setup() throws IOException{
		op = new WebpageCommonOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickCatalog();
		sCheckout = scp.clickItemFloralWhiteTop();
		simplLogin = sCheckout.clickBuyNowWithSimpl();
		op.switchToFrame("simpl-checkout-iframe");
		simplCheckout = simplLogin.loginToSimpl("8904085621");
	}
	
	@Test()
	public void placeOrderByPayLater(){
		simplCheckout.clickPayLater();
		
	}
	
}