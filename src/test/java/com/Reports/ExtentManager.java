package com.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	static ExtentReports extent;

	public static ExtentReports getInstance() {
		
		if (extent == null) {
			
			String path = System.getProperty("user.dir") + "/Reports/ExtentReport.html";
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("SauceDemo Test Automation");
			reporter.config().setDocumentTitle("Test Results");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}

		return extent;
	}
	
	public static void flushReport() {
		extent.flush();
	}

}
