package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;


	
	public class LoginTest extends Base{
		LoginPage loginPage;
		HomePage homepage;
		
		@Test(groups="smoke")
		public void verifyUserLogin() {
			loginPage=new LoginPage(driver);
			homepage=new HomePage(driver);
			loginPage.login();
			String expectedProfileName="admin";
			String actualProfileName=homepage.getProfileName();
			Assert.assertEquals(actualProfileName, expectedProfileName);
		}
		@Test(groups="sanity")
		public void verifyErrorMessageOnInvalidUserLogin() {
			loginPage=new LoginPage(driver);
			loginPage.login("adm","ad");
			boolean status=loginPage.isErrorMessageDisplayed();
			Assert.assertTrue(status);
		}
		@Test(groups= {"smoke","regression"})
		public void verifySignInButtonText() {
			loginPage=new LoginPage(driver);
			String expectedLoginButtonText="Sign In";
			boolean status=loginPage.isLoginButtonTextAsExpected(expectedLoginButtonText);
			Assert.assertTrue(status);
		}
	}
