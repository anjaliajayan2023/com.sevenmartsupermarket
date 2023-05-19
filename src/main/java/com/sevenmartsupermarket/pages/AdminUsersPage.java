package com.sevenmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v108.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;



public class AdminUsersPage {
	WebDriver driver;
	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement adminUserElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newUserElement;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameElement;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordElement;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement userTypeElement;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveElement;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement userInTableElement;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUser() {
		adminUserElement.click();
	}

	public boolean addNewUser(String userName, String password, String userType) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUtility pageUtility = new PageUtility(driver);
		newUserElement.click();
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		pageUtility.select_ByVisibleText(userTypeElement, userType);
		saveElement.click();
		return generalUtility.is_TextasExpected(userInTableElement,  userName);
	}
}