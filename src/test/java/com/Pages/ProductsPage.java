package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	WebElement productTitle;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCart;
	
	@FindBy(className="shopping_cart_link")
	WebElement cart;
	
	public String getProductsTitle() {
		return productTitle.getText();
	}
	
	public void addProduct() {
		addToCart.click();
	}
	
	public void clickCart() {
		cart.click();
	}
	
}
