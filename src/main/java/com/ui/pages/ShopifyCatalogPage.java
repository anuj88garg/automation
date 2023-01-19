package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyCatalogPage {
	
	
	public ShopifyCatalogPage() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}


	@FindBy(xpath="//a[contains(text(),'Chequered Red Shirt')]")
	public WebElement itemRedChequeredTShirt;
	

	
	public ShopifyCheckoutPage clickItemFloralWhiteTop() {
		itemRedChequeredTShirt.click();
		return new ShopifyCheckoutPage();
	}
	
}



