package com.ui.pages;

import java.io.IOException;

import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.framewrok.testUtils.ApiUtils;

import io.restassured.response.Response;

public class SimplOrderConfirmationPage {
	
	WebpageCommonOperation co = new WebpageCommonOperation();
	ApiUtils utility = new ApiUtils();
	
	
	public SimplOrderConfirmationPage() {
		PageFactory.initElements(WebdriverInitialization.driver, this);
	}

	
	@FindBy(xpath="//div/img[contains(@src,'gifs/SUCCESS')]")
	public WebElement orderSuccessGIF;
	
	
	@FindBy(xpath="//div/h5[text()='Order placed, thank you!']")
	public WebElement orderSuccessfulText;
	
	@FindBy(xpath="//button/span[text()='DONE']")
	public WebElement done;
		
	@FindBy(xpath="//div[contains(@class,'logout')]")
	public WebElement logOutIcom;
	
	@FindBy(xpath="//button/span[text()='Logout']")
	public WebElement logOutText;
	
	
	public String verifyorderIsSuccessfulAndTextIsDisplayed() {
		co.applyWaitFor(20, "xpath", "//div/h5[text()='Order placed, thank you!']");
		return orderSuccessfulText.getText();
		
	}
	
	public boolean verifyorderIsSuccessfulAndGifIsDisplayed() {
		co.applyWaitFor(20, "xpath", "//div/h5[text()='Order placed, thank you!']");
		return orderSuccessGIF.isDisplayed();
	}
	
	public void clickDone() {
		co.applyWaitFor(20, "xpath", "//div/h5[text()='Order placed, thank you!']");
		done.click();
	}
	
	public void clickLogOut() {
		co.applyWaitFor(20, "xpath", "//div/h5[text()='Order placed, thank you!']");
		logOutIcom.click();
		logOutText.click();
	}
	
	public JSONObject fetchOMSOrderDetails() throws IOException {
		 String res = utility.getOMSOrderDetails().asString();
		 JSONObject js = new JSONObject(res);
		 return js;
		 
	}
	
	
}



