package com.Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	 public static void captureScreenshot(WebDriver driver) {

	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String filePath = "./Screenshots/SauceDemo_" + getCurrentDateTime() + ".png";

	            FileUtils.copyFile(source, new File("./Screenshots/SauceDemo_" + getCurrentDateTime() + ".png"));
	            System.out.println("Captured Screenshot");

	        } catch (Exception e) {
	            System.out.println("Exception while taking screenshot" + e.getMessage());
	            
	        }
	    }

	    public static String getCurrentDateTime() {

	        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	        Date currentDate = new Date();
	        return customFormat.format(currentDate);
	    }
}
