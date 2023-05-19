package com.sevenmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

public PageUtility(WebDriver driver) {
	this.driver=driver;
}
public void scrollIntoElement(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}
public void scrollAndClick(WebElement element) {
	int index = 0;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	while (isClicked(element)) {
		js.executeScript("window.scrollBy(0," + index + ")");
		index = index + 3;
	}
}

public boolean isClicked(WebElement element) {
	try {
		element.click();
		return false;
	} catch (Exception e) {
		// TODO: handle exception
		return true;
	}
}
	
public void select_ByIndex(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
}

public void select_ByVisibleText(WebElement element, String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
}

public void select_ByValue(WebElement element,String value) {
	Select select = new Select(element);
	select.selectByValue(value);
}
}

