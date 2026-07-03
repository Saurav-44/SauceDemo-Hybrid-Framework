package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Base.BaseClass;

public class ConfigDataProvider {
	
	public static Logger logger = LogManager.getLogger(ConfigDataProvider.class);
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File("src/test/resources/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			logger.info("Configuration file loaded successfully.");

		}
		
		catch(Exception e) {
			logger.error("Unable to load config file", e);
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
