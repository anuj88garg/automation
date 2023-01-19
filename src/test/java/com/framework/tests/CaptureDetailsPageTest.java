package com.framework.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.common.WebpageCommonOperation;
import com.framework.configuration.WebdriverInitialization;
import com.framewrok.testUtils.ReadExcelUtility;
import com.ui.pages.CaptureDetailsPage;
import com.ui.pages.HomePage;

public class CaptureDetailsPageTest extends WebdriverInitialization{
	
	CaptureDetailsPage cd;
	HomePage hp;
	int i = 0;
	WebpageCommonOperation op = new WebpageCommonOperation();

	
	@BeforeMethod
	public void setup() {
		System.out.println("CaptureDetailsPageTest constructor is triggered");
		op.openApplication("https://www.rahulshettyacademy.com/");
		hp = new HomePage();
		cd = hp.clickPracticePage();
	}
	
	@Test(dataProvider="supplylogindetails")
	public void filltheForm(String name,String email){
		cd.enterName(name);
		cd.enterEmail(email);
		cd.clickPromotionCheckbox();
		cd.clickSubmitButton();
		System.out.println("Completed execution for capture details test for test data " + ++i);
	}
	
	@DataProvider(name="supplylogindetails")
	public Object[][] details() {
		return ReadExcelUtility.getTestData("practiceFormRegistration");
	}

}
