package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyHomePage {
	
	
	public ShopifyHomePage() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}


	@FindBy(xpath="//a/span[contains(text(),'Catalog')]")
	public WebElement catalog;

	
	public ShopifyCatalogPage clickCatalog(){
		catalog.click();
		return new ShopifyCatalogPage();
	}
	
}



