package com.TestCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.Base.TestBase;

import com.Pages.RegisterPage;
import com.TestData.TestData;

public class RegisterTCs extends TestBase {

	RegisterPage registerobj;

	@BeforeTest
	public void beforeMethod() throws InterruptedException {

		registerobj = new RegisterPage(driver);

	}

	// Positive Register scenario
	@Test(priority = 1, dataProvider = "Authentication" )
	public void verifyUsercanRegistersuccessfully(String First , String Last , String Email ,
			String phone , String Company , String add1 , String add2 , String city,
			String Country ,
			String whatsappphone , String pass1 , String pass2,
			String ExpectedText) throws InterruptedException {
		registerobj.clickCreateAccount();
		registerobj.setFirstnamevalue(First);
		registerobj.setLastnamevalue(Last);
		registerobj.setEmailvalue(Email);
		//registerobj.chooseCountryvalue("+20");
		registerobj.setPhonevalue(phone);
		registerobj.setCompanyvalue(Company);
		registerobj.setAddress1value(add1);
		registerobj.setAddress2value(add2);
		registerobj.setCityvalue(city);
		registerobj.chooseCountry2value(Country);
		registerobj.setWhatsappMobvalue(whatsappphone);
		registerobj.setPassowrd1value(pass1);
		registerobj.setPassowrd2value(pass2);
		registerobj.clickonrecaptchaCheck();
		registerobj.clickRegister();
		
		String actualText = registerobj.verifyUserRegisterSuccessfully();
		String expectedText = ExpectedText ; 
		Assert.assertTrue(actualText.contains(expectedText));
			

	}
	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = TestData.fetchData("verifyUsercanRegistersuccessfully");
		return (testObjArray);
	}

//	// negative login scenario
//	@Test(priority = 2)
//	public void verifyUsernotloggedinUsingwrongPassword() throws InterruptedException {
//		loginobj.clickLogout();
//		loginobj.setUsernamevalue("Admin");
//		loginobj.setPassowrdvalue("admin1");
//		loginobj.clickLogin();
//		String actualMsg = loginobj.verifyInvalidCredentailsMsg();
//		String expectedMsg = "Invalid credentials";
//		Assert.assertEquals(actualMsg, expectedMsg);
//
//	}

	@AfterTest
	public void afterMethod() {
		CloseBrowser();
	}

}
