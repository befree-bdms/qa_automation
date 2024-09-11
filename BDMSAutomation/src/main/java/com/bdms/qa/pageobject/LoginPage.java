package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
		public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;

	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//span[@class='p-button-label'][1]")
	private WebElement Login;
	
	

	
}
