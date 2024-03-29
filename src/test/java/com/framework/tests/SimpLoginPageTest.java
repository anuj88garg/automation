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
import com.ui.pages.SimplLoginPage;

public class SimpLoginPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommonOperation op;
	ShopifyCatalogPage scp;
	ShopifyCheckoutPage sCheckout;
	SimplLoginPage simplLogin;
	
	@BeforeClass
	public void setup(){
		op = new WebpageCommonOperation();
		slp = new ShopifyLoginPage2();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickCatalog();
		sCheckout = scp.clickItemFloralWhiteTop();
		simplLogin = sCheckout.clickBuyNowWithSimpl();
		op.switchToFrame("simpl-checkout-iframe");
		
	}
	
	@Test()
	public void verifySimplLoginWorking() throws IOException {
		simplLogin.loginToSimpl("8904085621");
		
	}
	
	
//	public void verifyApplyCoupons() {
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		simplLogin.enterCoupon("MONSOON10");
//	}
	
	
	public void zverifyOTPIsGettingEntered() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//simplLogin.enterOTP("9011624625");
	}
}