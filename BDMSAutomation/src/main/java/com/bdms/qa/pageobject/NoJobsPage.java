package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoJobsPage {
	WebDriver driver;

	// Constructor
	public NoJobsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Record']")
	WebElement addRecord;

	public void clickOnAddRecord() {
		addRecord.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='start_time']")
	WebElement selectStartTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='start_time']//input[contains(@class, 'ng-tns-')]")
	WebElement StartTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='start_time']//button[contains(@class, 'ng-tns-')]")
	WebElement selectstartTime;

	public void inputStartTime(String start) {
		selectStartTime.click();
		StartTime.sendKeys(start);
		selectstartTime.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='end_time']")
	WebElement selectEndTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='end_time']//input[contains(@class, 'ng-tns-')]")
	WebElement endTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='end_time']//button[contains(@class, 'ng-tns-')]")
	WebElement selectendTime;

	public void inputEndTime(String end) {
		selectEndTime.click();
		endTime.sendKeys(end);
		selectendTime.click();
	}

	@FindBy(xpath = "//button[@label='Save']")
	WebElement save;

	public void clickSave() {
		save.click();
	}

	@FindBy(xpath = "//p-button[@icon='pi pi-user' or @class='p-element ng-star-inserted']")
	WebElement booked;

	public void clickOnBooked() {
		booked.click();
	}

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement clickOnYesButton;

	public void clickOnYes() {
		clickOnYesButton.click();
	}

	@FindBy(xpath = "//span[text()='No']")
	WebElement clickOnNoButton;

	public void clickOnNo() {
		clickOnNoButton.click();
	}

}
