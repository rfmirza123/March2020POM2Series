	package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	
	//POM2 Session
	
	private WebDriver driver;
	
	//1. Need to maintain By locators--called OR-object Repositories. 
	//The locators on the hubspot page are: username, password & login button	
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. Create constructor of Page class:	
	
	public LoginPage(WebDriver driver){
		this.driver = driver; 
	}
	
	//3. Page actions:
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	 // added this Imp wait
		return driver.findElement(signUpLink).isDisplayed();	
		}
	
	public HomePage doLogin(String username, String password){
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);	
		driver.findElement(this.loginButton).click();
	
		return new HomePage(driver);
	}
	
}
