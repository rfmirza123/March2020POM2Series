package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	
	//POM2 Session
	
		WebDriver driver;
		Properties prop; 
		
		BasePage basePage;
		LoginPage loginPage;
		HomePage homePage;
		
		@BeforeTest
		public void setup(){
			basePage = new BasePage();
			prop = basePage.init_prop();
					
			driver = basePage.init_driver(prop);			//I had MISSED (driver) here,did NOT work two days.	
			loginPage = new LoginPage(driver);
			homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test(priority=3)
		public void verifyHomePageTitle(){
			String title = homePage.getHomePageTitle();
			System.out.println("home page title is :" + title );
			Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page title does not match...");
		}
		
		@Test(priority=1)
		public void verifyHomePageHeader(){
			String header = homePage.getHomePageHeaderText();
			System.out.println("Home Page Header is " + header );
			Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home Page is NOT present...");
		}
		//Commented below as my name do NOT appears
		@Test(priority=2)
		public void verifyLoggedInUserTest(){
			String loggedInuser = homePage.getLoggedInUser();
			System.out.println("Logged in User is : " + loggedInuser );
			Assert.assertEquals(loggedInuser, prop.getProperty("accountname"), "logged in User is not matched");
		}
				
		@AfterTest
		public void teardown(){
			driver.quit();
		}	
	}	