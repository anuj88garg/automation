package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyCatalogPage extends WebdriverInitialization{
	
	
	public ShopifyCatalogPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[contains(text(),'Floral White Top')]")
	public WebElement itemFloralWhiteTop;

	
	public ShopifyCheckoutPage clickItemFloralWhiteTop() {
		itemFloralWhiteTop.click();
		return new ShopifyCheckoutPage();
	}
	
}



