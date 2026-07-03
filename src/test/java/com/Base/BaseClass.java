package com.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Reports.ExtentManager;
import com.Utilities.BrowserFactory;
import com.Utilities.ConfigDataProvider;
import com.Utilities.ExcelDataProvider;
import com.Utilities.ScreenshotUtil;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@BeforeSuite
	public void setUp() {
		logger.info("Initializing Excel and Config files");
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void BrowserTest() {
		driver = BrowserFactory.BrowserOptions(driver, config.getBrowser(), config.getAppUrl());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void screenshotFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.error("Test Failed: " + result.getName());
			ScreenshotUtil.captureScreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.flushReport();
	}
}
