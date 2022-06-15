package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {

	public static FileInputStream fis = null;
	public static Properties prop = null;

	public static String readProperties(String key) {
		prop = new Properties();

		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/main/resources/config.properties");
			
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
