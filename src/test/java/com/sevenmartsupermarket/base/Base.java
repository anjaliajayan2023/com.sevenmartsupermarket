package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.ScreenShot;
import com.sevenmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;

	Properties properties = new Properties();
	ScreenShot screenShot = new ScreenShot();

	public Base() {
		try {
			FileInputStream fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialise(String browser, String url) {
		if (browser.equals("chrome")) {

			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);

		} else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}

	
	@BeforeMethod(alwaysRun = true, enabled = true)
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialise(browser, url);
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true, enabled = false)
	public void launchBrowser(String browserValue) {
		String urlValue = properties.getProperty("url");
		initialise(browserValue, urlValue);
	}

	@AfterMethod(alwaysRun = true, enabled = true)

	public void terminateBrowser(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenShot.takeScreenShot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}
