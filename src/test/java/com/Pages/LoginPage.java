package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.ScreenshotUtil;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement user;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "login-button")
	WebElement btn;
	
	
	public void loginSauceDemo(String username, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
		ScreenshotUtil.captureScreenshot(driver, "LoginPage");
		btn.click();
	}
	
	
	
}
