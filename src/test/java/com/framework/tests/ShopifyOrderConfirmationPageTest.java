package com.framework.tests;

import java.io.IOException;

import static org.testng.Assert.*;

import org.json.JSONObject;
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
import com.ui.pages.SimplOrderConfirmationPage;

public class ShopifyOrderConfirmationPageTest extends WebdriverInitialization{

	ShopifyLoginPage2 slp;
	ShopifyHomePage shp;
	WebpageCommonOperation op;
	ShopifyCatalogPage scp;
	ShopifyCheckoutPage sCheckout;
	SimplLoginPage simplLogin;
	SimplCheckoutPage simplCheckout;
	SimplOrderConfirmationPage orderConfirmation;
	
	
	@BeforeClass
	public void setup() throws IOException{
		op = new WebpageCommonOperation();
		slp = new ShopifyLoginPage2();
		//op.readStoredCookies();
		op.openApplication("https://testing-simpl.myshopify.com");
		shp = slp.loginToShopify("drisho");
		scp = shp.clickCatalog();
		sCheckout = scp.clickItemFloralWhiteTop();
		simplLogin= sCheckout.clickBuyNowWithSimpl();
		op.readStoredCookies();
		op.switchToFrame("simpl-checkout-iframe");
		simplCheckout = simplLogin.loginToSimpl("8904085621");
		orderConfirmation = simplCheckout.clickPayLater();
	}
	
	@Test
	public void verifyOrderIsPlacedSuccessfully() throws IOException {
		String confirmationText = orderConfirmation.verifyorderIsSuccessfulAndTextIsDisplayed();
		boolean tickIsVisible = orderConfirmation.verifyorderIsSuccessfulAndGifIsDisplayed();
		JSONObject orderJson = orderConfirmation.fetchOMSOrderDetails();
		assertEquals(confirmationText,"Order placed, thank you!", "Order is not placed successfully");
		assertTrue(tickIsVisible,"Order is not placed successfully");
		assertEquals(orderJson.getJSONObject("data").getString("id"),op.fetchOMSOrderID(),"OMS Order ID is not matching");
		assertEquals(orderJson.getJSONObject("data").getString("status"),"CONFIRMED", "Order is not confirmed in OMS");
		assertNotNull(orderJson.getJSONObject("data").getJSONArray("taxes"),"Taxes are not getting stored in OMS");
		assertNotNull(orderJson.getJSONObject("data").getJSONArray("fees"),"Shipping charges is not getting stored in OMS");
		assertNotNull(orderJson.getJSONObject("data").getJSONArray("line_items")
				.getJSONObject(0).getJSONObject("metadata").getString("product_url"),"Product URL in line items Metabse is not getting stored in OMS");
		assertNotNull(orderJson.getJSONObject("data").getJSONArray("line_items")
				.getJSONObject(0).getJSONObject("metadata").getString("image_url"),"Image URL in line items Metabse is not getting stored in OMS");
		assertEquals(orderJson.getJSONObject("data").getString("display_status"),"CONFIRMED", "Display status is not confirmed in OMS");
		assertEquals(orderJson.getJSONObject("data").getString("payment_method"),"PAY_LATER", "Payment Method is wrongly captured in OMS");
		
		//orderConfirmation.clickLogOut();
		
	}
}