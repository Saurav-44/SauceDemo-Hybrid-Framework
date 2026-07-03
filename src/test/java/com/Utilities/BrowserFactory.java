package com.Utilities;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Base.BaseClass;

public class BrowserFactory {
	
	
	static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BrowserFactory.class);

	public static WebDriver BrowserOptions(WebDriver driver, String browserName, String AppUrl) {
		

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");

		options.setExperimentalOption("prefs", Map.of(
		"credentials_enable_service", false,
		"profile.password_manager_enabled", false
		));

		
		if (browserName.equalsIgnoreCase("chrome")) {
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver(options);
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			logger.info("Launching Edge Browser");
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			logger.info("Launching Firefox Browser");
			driver = new FirefoxDriver();
		}
		
		else {
			logger.info("Browser Does Not Support");
		}

		driver.manage().window().maximize();
		logger.info("Opening URL: " + AppUrl);
		driver.get(AppUrl);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		logger.info("Closing Browser");
		driver.quit();
	}
	
}
