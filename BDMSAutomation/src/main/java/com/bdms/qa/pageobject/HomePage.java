package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
		
	//Constructor
		public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy (xpath="//span[text()='Work Location']")
	private WebElement workLocation;
	
	@FindBy (xpath="//span[text()='Book my lunch']")
	public WebElement bookMyLunch;
	
	@FindBy (xpath="//span[text()='Save Location']")
	private WebElement saveLocation;
	
	@FindBy (xpath="//h5[text()='Daily Motivation']")
	private WebElement txtDailyMotivation;
	
	
		
	//Locators
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;
	
	public void setUserName(String user) {		
		userName.sendKeys(user);		
	}

	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	public void setPassword(String pwd ) {		
		password.sendKeys(pwd);		
	}
	
	@FindBy(xpath="//span[@class='p-button-label'][1]")
	private WebElement Login;
	
	public void clickLogin() {		
		Login.click();		
	}
	
	@FindBy (xpath="//button[@pstyleclass='@next']")
	private WebElement ClickonLogoutOption;
	@FindBy (xpath="//li[@id='LOGOUT']")
	private WebElement ClickonLogout;
	
	public void clickOnLogout() {
		
		ClickonLogoutOption.click();
		ClickonLogout.click();
	}
	
	
	@FindBy (xpath="//span[text()='My Profile'][1]")
	private WebElement myProfile;
	
	public void clickOnMyProfile() {
		myProfile.click();
	}
	
	
	@FindBy (xpath="//span[contains(text(),'My Leaves')]")
	private WebElement myLeaves;
	
	public void clickOnMyLeaves() {
		myLeaves.click();
	}
	
	@FindBy (xpath="//span[text()='My Holiday Working']")
	private WebElement myHolidayWorking;
	
	public void clickOnMyHolidayWorking() {
		myHolidayWorking.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
}
