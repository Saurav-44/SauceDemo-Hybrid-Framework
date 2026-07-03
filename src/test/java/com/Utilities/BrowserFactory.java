package com.Utilities;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	static WebDriver driver;

	public static WebDriver BrowserOptions(WebDriver driver, String browserName, String AppUrl) {
		

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");

		options.setExperimentalOption("prefs", Map.of(
		"credentials_enable_service", false,
		"profile.password_manager_enabled", false
		));

		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else {
			System.out.println("Browser Does Not Support....");
		}

		driver.manage().window().maximize();
		driver.get(AppUrl);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
