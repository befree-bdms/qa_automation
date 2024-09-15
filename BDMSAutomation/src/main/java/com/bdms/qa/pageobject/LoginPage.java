package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
		
	//Constructor
		public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	//Locators
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;

	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//span[@class='p-button-label'][1]")
	private WebElement Login;
	
	//Action Methods
	
	public void setUserName(String user ) {
		
		userName.sendKeys(user);		
	}
	
	public void setPassword(String pwd ) {
		
		password.sendKeys(pwd);		
	}
	
	public void clickLogin() {
		
		Login.click();		
	}
	
	
	
	
	
	

	
}
