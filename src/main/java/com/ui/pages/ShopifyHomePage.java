package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyHomePage extends WebdriverInitialization{
	
	
	public ShopifyHomePage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[text()='Shop all']")
	public WebElement shopAll;

	
	public ShopifyCatalogPage clickShopAll() {
		shopAll.click();
		return new ShopifyCatalogPage();
	}
	
}



