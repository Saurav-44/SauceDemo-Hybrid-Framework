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
import com.Utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;




public class SauceDemoTest extends BaseClass{
	
	@Test
	public void loginTest() {
		
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
		ScreenshotUtil.captureScreenshot(driver, "ProductsPage");
		product.clickCart();
		
		CartPage cart = new CartPage(driver);
		ScreenshotUtil.captureScreenshot(driver, "CartPage");
//		Assert.assertEquals(cart.getCartTitle(), "Your Cart");
		cart.clickBtn();
		
		CheckoutPage cp = new CheckoutPage(driver);
		cp.getCheckoutInfo("Saurav", "Kumar", "500032");
//		Assert.assertEquals(cp.getCheckoutTitle(), "Checkout: Your Information");
		
		
		
		CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);
		ScreenshotUtil.captureScreenshot(driver, "OverviewPage");
//		Assert.assertEquals(cop.getCheckoutOverviewTitle(), "Checkout: Overview");
		cop.clickFinish();
	
		
		CheckoutCompletePage coop = new CheckoutCompletePage(driver);
		ScreenshotUtil.captureScreenshot(driver, "CompletePage");
		coop.getCheckoutCompleteInfo();
//		Assert.assertEquals(coop.getCheckoutCompleteInfo(), "Checkout: Complete!");
		
		

		
		

		
		
		
		

}
	
}