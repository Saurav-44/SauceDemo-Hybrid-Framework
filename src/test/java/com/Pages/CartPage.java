package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	WebElement productTitle;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public String getCartTitle() {
		return productTitle.getText();
	}
	
	public void clickBtn() {
		checkoutBtn.click();
	}
	
	
	
}
