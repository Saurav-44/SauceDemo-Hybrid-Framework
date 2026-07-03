package com.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.CartPage;
import com.Pages.CheckoutCompletePage;
import com.Pages.CheckoutOverviewPage;
import com.Pages.CheckoutPage;
import com.Pages.LoginPage;
import com.Pages.ProductsPage;
import com.Reports.ExtentManager;
import com.Utilities.ExcelDataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;




public class SauceDemoTest extends BaseClass{
	
	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest test;
	
	@Test
	public void loginTest() throws InterruptedException {
		
		test = extent.createTest("SauceDemo Login Test");
		
		ExcelDataProvider excel = new ExcelDataProvider();
		
		String username = excel.getStringData(0, 1, 0);
		String password = excel.getStringData(0, 1, 1);
		
		
		LoginPage login = new LoginPage(driver);
		login.loginSauceDemo(username, password);
//		Assert.assertTrue(driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed(), "Error");
	
		ProductsPage product = new ProductsPage(driver);
//		Assert.assertEquals(product.getProductsTitle(), "Products");
		product.addProduct();
		product.clickCart();
		
		CartPage cart = new CartPage(driver);
//		Assert.assertEquals(cart.getCartTitle(), "Your Cart");
		cart.clickBtn();
		
		CheckoutPage cp = new CheckoutPage(driver);
//		Assert.assertEquals(cp.getCheckoutTitle(), "Checkout: Your Information");
		
		
		cp.getCheckoutInfo("Saurav", "Kumar", "500032");
		
		
		CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);
//		Assert.assertEquals(cop.getCheckoutOverviewTitle(), "Checkout: Overview");
		
		cop.clickFinish();
		Thread.sleep(3000);
		
		CheckoutCompletePage coop = new CheckoutCompletePage(driver);
		coop.getCheckoutCompleteInfo();
//		Assert.assertEquals(coop.getCheckoutCompleteInfo(), "Checkout: Complete!");
		extent.flush();
		

		
		

		
		
		
		

}
	
}