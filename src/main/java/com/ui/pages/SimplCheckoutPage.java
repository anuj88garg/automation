package com.ui.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.framewrok.testUtils.ApiUtils;

public class SimplCheckoutPage {
	
	WebpageCommonOperation co = new WebpageCommonOperation();
	String omsOrderID;
	
	
	public SimplCheckoutPage() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}

	
	@FindBy(xpath="//div/h5[text()='Payment Options']")
	public WebElement paymentOptions;
	
	
	@FindBy(xpath="//button[@id='PAY_LATER-payment-cta']")
	public WebElement payLaterBuy;
	
	
	
	public SimplOrderConfirmationPage clickPayLater() {
		co.setOrderIDFromNetworkTab();
		co.applyWaitFor(20, "xpath","//div/h5[text()='Payment Options']");
		payLaterBuy.click();
		return new SimplOrderConfirmationPage();
	}
	
}



