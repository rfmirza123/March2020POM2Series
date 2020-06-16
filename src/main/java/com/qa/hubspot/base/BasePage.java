package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	//POM2 Session
	
	WebDriver driver;
	Properties prop; 
	
	public WebDriver init_driver(Properties prop){
		
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}		
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();		
	}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	/**
	 * this Method is used to initialize properties from config properties file
	 * @return prop
	 */		
	public Properties init_prop(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) 
			{ e.printStackTrace();	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			
		return prop;
	}
	
}
