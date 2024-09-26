package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLunchPage {
	
	
		WebDriver driver;
		//Constructor
			public MyLunchPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[text()='Add Record']")
		WebElement addRecord;
		
		public void clickOnAddRecord() {
			addRecord.click();
		}
		

		@FindBy(xpath="//p-calendar[@formcontrolname='date']")
		WebElement clickOndate;
		
		public void clickOnMenuDate() {
			clickOndate.click();
		}
		
		@FindBy(xpath="//p-dropdown[@formcontrolname='user_id']")
		WebElement userName;
		@FindBy(xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
		WebElement txtuserName;
		@FindBy(xpath="//li[@class='p-ripple p-element p-dropdown-item']")
		WebElement selctuserName;
		
		
		public void clickOnUserName(String UserName) {
			userName.click();
			txtuserName.sendKeys(UserName);
			selctuserName.click();			
		}
		
		@FindBy(xpath="//p-dropdown[@formcontrolname='location_id']")
		WebElement location;
		@FindBy(xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
		WebElement txtlocation;
		@FindBy(xpath="//li[@class='p-ripple p-element p-dropdown-item']")
		WebElement selectlocation;
						
		public void clickOnLocation(String Location) {
			location.click();	
			txtlocation.sendKeys(Location);
			selectlocation.click();
			
		}
		
		@FindBy (xpath="//p-dropdown[@formcontrolname='food_type']")
		WebElement lunchType;
		@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
		WebElement txtlunchType;
		@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
		WebElement selectlunchType;
		
		public void LunchType(String addtype) {
			lunchType.click();
			txtlunchType.sendKeys(addtype);
			selectlunchType.click();
			
		}
		
		@FindBy(xpath="//button[@label='Save']")
		WebElement save;
		
		public void clickOnSave() {
			save.click();
		}
		
		
		
	}


