package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ScreenshotUtil;

public class CheckoutPage {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(className="title")
	WebElement title;
	
	public void getCheckoutInfo(String fname, String lname, String pin) {
				
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(pin);
		ScreenshotUtil.captureScreenshot(driver, "CheckoutPage");
		continueBtn.click();
	}
	
	public String getCheckoutTitle() {
		return title.getText();
	}
	
}
