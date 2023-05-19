package com.sevenmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameElement;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordElement;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterUsername(String userName) {
		userNameElement.sendKeys(userName);
	}
	public void enterPassword(String passWord) {
		passwordElement.sendKeys(passWord);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public void login() {
		String userNameValue = properties.getProperty("userName");
		String passwordValue = properties.getProperty("password");
		enterUsername(userNameValue);
		enterPassword(passwordValue);
		clickOnSignInButton();
	}
	public void login(String userName,String passWord) {
		enterUsername(userName);
		enterPassword(passWord);
		clickOnSignInButton();
	}
	public boolean isErrorMessageDisplayed() {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(errorMessage);
		
	}
	public boolean isLoginButtonTextAsExpected(String expected) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.is_TextasExpected(signInButton, expected);
	}
}
