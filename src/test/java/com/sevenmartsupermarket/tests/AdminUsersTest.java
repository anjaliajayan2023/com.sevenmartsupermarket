package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginPage;
	AdminUsersPage adminUserPage;
	

	@Test(groups = "bug retest")
	public void verifyNewUserAdd() {
		loginPage = new LoginPage(driver);
		adminUserPage=new AdminUsersPage(driver);
		loginPage.login();
		adminUserPage.clickOnAdminUser();
		String userName="Siya"+ GeneralUtility.getTimeStammp();
		
	}
}