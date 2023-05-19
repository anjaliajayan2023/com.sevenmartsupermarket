package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	WebElement enterTitle;
	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	WebElement enterDescription;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement send;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement notficationSuccessAlert;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPushNotification(String title, String description) {
		pushNotification.click();
		enterTitle(title);
		enterDescription(description);
		clickOnSend();
	}

	public void enterTitle(String title) {
		enterTitle.sendKeys(title);
	}

	public void enterDescription(String description) {
		enterDescription.sendKeys(description);
	}

	public void clickOnSend() {
		send.click();
	}

	public boolean isSuccessAlertPresent() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(notficationSuccessAlert);

	}

}


