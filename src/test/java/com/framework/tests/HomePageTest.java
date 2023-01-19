package com.framework.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.HomePage;

public class HomePageTest extends WebdriverInitialization{
	
	HomePage home;
	WebpageCommonOperation op = new WebpageCommonOperation();
	
	@BeforeMethod
	public void setup() {
		System.out.println("HomePasgeTest constructor is triggered");
		op.openApplication("https://www.rahulshettyacademy.com/");
		home = new HomePage();
	}
	
	@Test
	public void verifyLogoVisible(){
		System.out.println("Started execution of Method 2");
		boolean isVisible = home.LogoVisible();
		Assert.assertEquals(isVisible,true,"Rahul Shetty Logo not visible");	

	}
	
	@Test
	public void verifyClickOnPracticeTabWorking(){
		System.out.println("Started execution of Method 1");
		home.clickPracticePage();
	}

}


