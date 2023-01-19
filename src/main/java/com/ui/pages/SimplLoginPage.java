package com.ui.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.framewrok.testUtils.ApiUtils;

public class SimplLoginPage {
	
	WebpageCommonOperation co = new WebpageCommonOperation();
	
	
	public SimplLoginPage() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}


	@FindBy(id="coupon")
	public WebElement coupon;
	
	@FindBy(xpath="//button[contains(text(),'APPLY')]")
	public WebElement applyCoupon;
	
	@FindBy(id="phone-number")
	public WebElement phoneNo;
	
	@FindBy(xpath="//button[contains(text(),'GET OTP')]")
	public WebElement getOtp;
	
	@FindBy(id="otp")
	public WebElement OTP;

	
	public SimplCheckoutPage loginToSimpl(String mobNo) throws IOException {
		co.applyWaitFor(25,"xpath","//div/p[text()='Enter Mobile Number']");
		phoneNo.click();
		phoneNo.sendKeys(mobNo);
		getOtp.click();
		enterOTP(mobNo);
		co.storeCookies();
		return new SimplCheckoutPage();
	}
	
//	public void enterCoupon(String cpn) {
//		coupon.sendKeys(cpn);
//		applyCoupon.click();
//	}
//	
	public void enterOTP(String mobNo) throws IOException {
		String oneTimePwd = ApiUtils.fetchOTP(mobNo);
		OTP.sendKeys(oneTimePwd);
	}
	
}



