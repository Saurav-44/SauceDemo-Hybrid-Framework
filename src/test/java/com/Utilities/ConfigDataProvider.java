package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File("src/test/resources/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		
		catch(Exception e) {
			System.out.println("Unable to load config file " + e.getMessage());
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getAppUrl() {
		return pro.getProperty("url");
	}
	
	public int getExplicitWait() {
		return Integer.parseInt(pro.getProperty("explicitWait"));
	}
	
	
	
}
