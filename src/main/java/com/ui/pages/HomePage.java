package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configuration.WebdriverInitialization;

public class HomePage {
	
	
	@FindBy(xpath="//a/img[@src='assets/images/rs_logo.png'][1]")
	public WebElement rsLogo;
	
	@FindBy(xpath="//li/a[text()='Practice'][1]")
	public WebElement practiceTab;
	
	 public HomePage(){
		 PageFactory.initElements(WebdriverInitialization.driver, this);
	 }
	 
	 public boolean LogoVisible(){
		 return rsLogo.isDisplayed();
	 }
	 
	 public CaptureDetailsPage clickPracticePage(){
		practiceTab.click();
		return new CaptureDetailsPage();
	 }

}
