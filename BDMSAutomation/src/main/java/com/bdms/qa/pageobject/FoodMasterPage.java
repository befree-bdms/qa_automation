package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoodMasterPage {
	
		WebDriver driver;
		//Constructor
			public FoodMasterPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[text()='Add Record']")
		WebElement addRecord;
		
		public void clickOnAddRecord() {
			addRecord.click();
		}
		
		@FindBy (xpath="//p-calendar[@formcontrolname='date']")
		private WebElement menuDate;
		
		public void selectMenuDate() {
			menuDate.click();
		}
		
		@FindBy (xpath="//p-multiselect[@formcontrolname='menu_id']")
		WebElement clkmenu;
		
		@FindBy (xpath="//div[@class='p-checkbox p-component ng-star-inserted']")
		WebElement selectAllMenu;
		
		
		public void selectMenu() {
			clkmenu.click();
			selectAllMenu.click();
			clkmenu.click();			
		}
		
		@FindBy (xpath="//p-multiselect[@formcontrolname='location_id']")
		WebElement clkLocation;
		
		@FindBy (xpath="//div[@class='p-checkbox p-component ng-star-inserted']")
		WebElement selectAllLocation;
		
		
		public void selectLocation() {
			clkLocation.click();
			selectAllLocation.click();
			clkLocation.click();			
		}
		
		@FindBy (xpath="//input[@formcontrolname='comment']")
		WebElement addComment;
		
		public void addMenuComment(String commentforkitchenstaff) {
			addComment.sendKeys(commentforkitchenstaff);		
		}
		
		@FindBy (xpath="//span[text()='Save']")
		WebElement save;
		
		public void saveFoodMenu() {
			save.click();		
		}
		
		
		
		@FindBy (xpath="//span[@class='p-button-icon pi pi-filter']")
		WebElement filter;
		
		public void clickOnFilter() {
			filter.click();
		}
		
		@FindBy (xpath="//input[@class='ng-tns-c3918063748-256 p-inputtext p-component ng-star-inserted']")
		WebElement datefilter;
		
		public void clickOnDateFilter() {
			datefilter.click();
			
		}
		
		@FindBy (xpath="(//th[@class='p-element py-2 ng-star-inserted'])[3]")
		WebElement locationfilter;
		@FindBy(xpath="//input[contains(@class,'p-inputtext p-component p-element min-w-7rem')]")
		WebElement inputlocationFilter;
		
		public void clickOnlocationFilter(String location) {
			locationfilter.click();
			inputlocationFilter.sendKeys(location);
		}
		
		@FindBy (xpath="//p-badge[@ptooltip='Regular Food']")
		WebElement regularCount;
		
		public void employeeCountforFood() {
			String RegularCount=regularCount.getText();
			System.out.println(RegularCount);
		}
		
		@FindBy (xpath="//span[text()='Today']")
		WebElement today;
		
		public void clickOnToday() {
			today.click();
		}

}
