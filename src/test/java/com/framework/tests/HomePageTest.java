package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.configuration.WebdriverInitialization;
import com.ui.pages.HomePage;

public class HomePageTest{
	
	HomePage home = new HomePage();
	
	@Test
	public void verifyLogoVisible(){
		boolean isVisible = home.LogoVisible();
		Assert.assertEquals(isVisible,true,"Rahul Shetty Logo not visible");	
	}
	
	@Test
	public void verifyClickOnPracticeTabWorking(){
		home.clickPracticePage();
		System.out.println("Hello everyone");
	}

}


