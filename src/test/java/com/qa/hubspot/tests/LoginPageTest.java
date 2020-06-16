package com.qa.hubspot.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {	
	
					//POM2 Session
	
	WebDriver driver;
	
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeTest
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);			//I had MISSED (driver) here,did NOT work two days.	
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page title is not matched");
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.verifySignUpLink(), "Sign up Link is not displayed");
	}
	
	@Test(priority=3) 
	public void loginTest() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
