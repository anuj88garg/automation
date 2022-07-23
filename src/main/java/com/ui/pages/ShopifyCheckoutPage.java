package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyCheckoutPage extends WebdriverInitialization{
	
	
	public ShopifyCheckoutPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="simpl_checkout-product_div")
	public WebElement buyNowWithSimpl;

	
	public SimplLoginPage clickBuyNowWithSimpl() {
		buyNowWithSimpl.click();
		return new SimplLoginPage();
	}
	
}



