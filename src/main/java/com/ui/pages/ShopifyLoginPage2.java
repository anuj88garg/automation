package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class ShopifyLoginPage2 {
	
	
	public ShopifyLoginPage2() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}


	@FindBy(xpath="//input[@type='password']")
	public WebElement storePassword;

	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	
	public ShopifyHomePage loginToShopify(String pwd) {
		System.out.println();
		storePassword.sendKeys(pwd);
		submit.click();
		return new ShopifyHomePage();
	}
		
	
	
}



