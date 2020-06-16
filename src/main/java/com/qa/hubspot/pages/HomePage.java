package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	//POM2 Session
	
	private WebDriver driver; 
		
	By header = By.xpath("//i18n-string[@data-key='app.header.title']");
	By accountName = By.xpath("//img[@class=' nav-avatar ']");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String  getHomePageTitle(){
		return driver.getTitle();
	}
		
	public String getHomePageHeaderText(){
		if(driver.findElement(header).isDisplayed()){
		return driver.findElement(header).getText();			
	}
		return null;		
	}
	
	public String getLoggedInUser(){
		if(driver.findElement(accountName).isDisplayed()){
		return driver.findElement(accountName).getText();			
	}
		return null;
		
	}	
}
	