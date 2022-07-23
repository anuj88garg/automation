package com.framework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommomOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.ShopifyCatalogPage;
import com.ui.pages.ShopifyCheckoutPage;
import com.ui.pages.ShopifyHomePage;
import com.ui.pages.ShopifyLoginPage2;
import com.ui.pages.SimplLoginPage;

public class SimpLoginPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommomOperation op;
	ShopifyCatalogPage scp;
	ShopifyCheckoutPage sCheckout;
	SimplLoginPage simplLogin;
	
	@BeforeClass
	public void setup(){
		op = new WebpageCommomOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickShopAll();
		sCheckout = scp.clickItemFloralWhiteTop();
		simplLogin = sCheckout.clickBuyNowWithSimpl();
		driver.switchTo().frame("simpl-checkout-iframe");
	}
	
	@Test
	public void verifySimplLoginWorking() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		simplLogin.loginToSimpl("9011624625");
	}
	
	@Test
	public void verifyApplyCoupons() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		simplLogin.enterCoupon("MONSOON10");
	}
}