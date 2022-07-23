package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class CaptureDetailsPage extends WebdriverInitialization{

	@FindBy(id="name")
	@CacheLookup
	public WebElement name;
	
	@FindBy(id="email")
	@CacheLookup
	public WebElement email;
	
	@FindBy(id="agreeTerms")
	@CacheLookup
	public WebElement promotionCheckbox;
	
	@FindBy(id="form-submit")
	@CacheLookup
	public WebElement submit;
	
	public CaptureDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterName(String fullName) {
		name.sendKeys(fullName);
	}
	
	public void enterEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}
	
	public void clickPromotionCheckbox(){
		promotionCheckbox.click();
	}
	
	public void clickSubmitButton() {
		submit.click();
	}
	
	
}
