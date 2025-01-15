package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyHolidayWorkingPage {

	WebDriver driver;

	// Constructor
	public MyHolidayWorkingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Record']")
	private WebElement addRecord;

	public void clickOnAddRecord() {

		addRecord.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='location_id']")
	private WebElement clickOnLocation;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement enterLocation;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement selectLocation;

	public void selectLocation(String location) {
		clickOnLocation.click();
		enterLocation.sendKeys(location);
		selectLocation.click();
		;
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='date']")
	private WebElement holidayDate;

	public void selectHolidayDate() {
		holidayDate.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='start_time']")
	private WebElement estimatedArrivalTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='start_time']//input[contains(@class, 'ng-tns-')]")
	private WebElement addEstimatedArrivalTime;

	public void selectEstimatedArrivalTime(String arrivalTime) {
		estimatedArrivalTime.click();
		addEstimatedArrivalTime.sendKeys(arrivalTime);
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='end_time']")
	private WebElement estimatedDepartureTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='end_time']//input[contains(@class, 'ng-tns-')]")
	private WebElement addEstimatedDepartureTime;

	public void selectEstimatedDepartureTime(String departureTime) {
		estimatedDepartureTime.click();
		addEstimatedDepartureTime.sendKeys(departureTime);
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='entity_id']")
	private WebElement tradingName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement addtradingName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement selectAddtradingName;

	public void selectTradingName(String enterTradingName) {
		tradingName.click();
		addtradingName.sendKeys(enterTradingName);
		selectAddtradingName.click();
	}

	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	private WebElement reasonForHolidayWorking;

	public void enterReasonForHolidayWorking(String txtReason) {
		reasonForHolidayWorking.sendKeys(txtReason);
	}

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement btnSaveHolidayWorking;

	public void saveHolidayWorking() {
		btnSaveHolidayWorking.click();
	}

	@FindBy(xpath = "//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid ng-star-inserted p-inputwrapper-filled']")
	private WebElement employeeNameFilter;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement enterEmployeeName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clickOnEmployeeName;

	public void applyEmployeeNameFileter(String employeeName) {
		employeeNameFilter.click();
		enterEmployeeName.sendKeys(employeeName);
		clickOnEmployeeName.click();
	}

	@FindBy(xpath = "(//p-button[@ptooltip='Delete'])[1]")
	WebElement deleteIcon;
	@FindBy(xpath = "//span[text()='Yes']")
	WebElement yes;

	public void deleteRequest() {
		deleteIcon.click();
		yes.click();
	}

	@FindBy(xpath = "//p-button[@ptooltip='Leave Approval']")
	WebElement firstApprove;

	public void clickOnFirstApporve() {
		firstApprove.click();
	}

	@FindBy(xpath = "//textarea[@formcontrolname='comment']")
	WebElement firstApproveComment;

	public void inputFirstApproveComment(String test) {
		firstApproveComment.sendKeys(test);
	}

	@FindBy(xpath = "//span[text()='Approve']")
	WebElement approve;

	public void clickOnApprove() {
		approve.click();
	}

}
