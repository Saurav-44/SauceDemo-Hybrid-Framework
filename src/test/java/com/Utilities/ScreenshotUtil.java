package com.Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static Logger logger = LogManager.getLogger(ScreenshotUtil.class);
	
	public static String captureScreenshot(WebDriver driver, String pageName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String filePath = "./Screenshots/SauceDemo_" + pageName + "_" +getCurrentDateTime() + ".png";

			FileUtils.copyFile(source, new File(filePath));
			logger.info("Screenshot captured successfully: " + filePath);
			return filePath;

		} catch (Exception e) {
			logger.info("Exception while taking screenshot", e);
			return null;
		}
		
		
		
		
	}

	public static String getCurrentDateTime() {

		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}




//public static void captureScreenshot(WebDriver driver) {
//
//       try {
//           TakesScreenshot ts = (TakesScreenshot) driver;
//           File source = ts.getScreenshotAs(OutputType.FILE);
//           String filePath = "./Screenshots/SauceDemo_" + getCurrentDateTime() + ".png";
//
//           FileUtils.copyFile(source, new File("./Screenshots/SauceDemo_" + getCurrentDateTime() + ".png"));
//           logger.info("Screenshot captured successfully: " + filePath);
//
//       } catch (Exception e) {
//       	logger.info("Exception while taking screenshot", e);
//           
//       }
//   }
//
//   public static String getCurrentDateTime() {
//
//       DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
//       Date currentDate = new Date();
//       return customFormat.format(currentDate);
//   }
//}