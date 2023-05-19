package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base{
	LoginPage loginpage;
	ManageUsersPage manageuserspage;

	@Test(groups = {"smoke","bug retest"})
	public void verifyStatusChangingButton() {
		loginpage = new LoginPage(driver);
		manageuserspage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		boolean status=manageuserspage.deactivateUser("Abhiramkrishnakumarsreenatest d");
		Assert.assertTrue(status);
	}
	@Test(groups = "regression")
	public void verifySearchUser() {
		loginpage = new LoginPage(driver);
		manageuserspage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		boolean status=manageuserspage.isSearchUserFound("Anandhu Prakash");
		Assert.assertTrue(status);
	}

}



