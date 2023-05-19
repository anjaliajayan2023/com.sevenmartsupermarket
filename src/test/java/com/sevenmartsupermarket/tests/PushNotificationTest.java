package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelUtility;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushNotificationPage;
	ExcelUtility excelUtility;

	@Test(groups = "smoke")
	
	public void verifyPushNotification() {
		loginpage = new LoginPage(driver);
		pushNotificationPage = new PushNotificationPage(driver);
		loginpage.login();
		pushNotificationPage.clickOnPushNotification("test", "Sending values for testing...");
		Assert.assertTrue(pushNotificationPage.isSuccessAlertPresent());
	}
}



