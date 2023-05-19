package com.sevenmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;


public GeneralUtility(WebDriver driver) {
	this.driver=driver;
	}
public String getTextOfElement(WebElement element){
	return element.getText();
}
public boolean is_Selected(WebElement element) {
	return element.isSelected();
}

public boolean is_Displayed(WebElement element) {
	return element.isDisplayed();
	
}
public boolean is_TextasExpected(WebElement element,String expectedtext) {
	String text=element.getText();
	return text.equals(expectedtext);
	
}
public List<String>getTextofElements(List<WebElement> names){
List<String>nameText=new ArrayList<String>();
for(int i=0;i<names.size();i++) {
	nameText.add(names.get(i).getText());
}
	return nameText;
}
public static String  getTimeStammp() {
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	return timeStamp;
}

}