package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class SimplLoginPage extends WebdriverInitialization{
	
	
	public SimplLoginPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="coupon")
	public WebElement coupon;
	
	@FindBy(xpath="//button[contains(text(),'APPLY')]")
	public WebElement applyCoupon;
	
	@FindBy(id="phone-number")
	public WebElement phoneNo;
	
	@FindBy(xpath="//button[contains(text(),'GET OTP')]")
	public WebElement getOtp;

	
	public void loginToSimpl(String mobNo) {
		phoneNo.sendKeys(mobNo);
		getOtp.click();
	}
	
	public void enterCoupon(String cpn) {
		coupon.sendKeys(cpn);
		applyCoupon.click();
	}
	
}



