package com.bdms.qa.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Work Location']")
	private WebElement workLocation;

	@FindBy(xpath = "//span[text()='Book my lunch']")
	public WebElement bookMyLunch;

	public void clickOnBookLunch() {
		bookMyLunch.click();
	}

	public void clickOnSaveLocation() {
		workLocation.click();
	}

	@FindBy(xpath = "//span[text()='Save Location']")
	public WebElement saveLocation;

	@FindBy(xpath = "//h5[text()='Daily Motivation']")
	private WebElement txtDailyMotivation;

	// Locators
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	public void setUserName(String user) {
		userName.sendKeys(user);
	}

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement Login;

	public void clickLogin() {
		Login.click();
	}

	@FindBy(xpath = "//button[@pstyleclass='@next']")
	private WebElement ClickonLogoutOption;
	@FindBy(xpath = "//li[@id='LOGOUT']")
	private WebElement ClickonLogout;

	public void clickOnLogout() {

		ClickonLogoutOption.click();
		ClickonLogout.click();
	}

	@FindBy(xpath = "//li[@id='LOGOUT_WITH_PUNCH_OUT']")
	private WebElement ClickonLogoutwithPunchoutOption;

	public void clickonLogoutwithPunchoutOption() {

		ClickonLogoutwithPunchoutOption.click();

	}

	@FindBy(xpath = "//span[text()='My Profile'][1]")
	private WebElement myProfile;

	public void clickOnMyProfile() {
		myProfile.click();
	}

	@FindBy(xpath = "//span[contains(text(),'My Leaves')]")
	private WebElement myLeaves;

	public void clickOnMyLeaves() {
		myLeaves.click();
	}

	@FindBy(xpath = "//span[text()='My Holiday Working']")
	private WebElement myHolidayWorking;

	public void clickOnMyHolidayWorking() {
		myHolidayWorking.click();
	}

	@FindBy(xpath = "(//span[text()='Workflow'])[1]")
	private WebElement workflow;

	public void clickOnWorkflow() {
		workflow.click();
	}

	@FindBy(xpath = "(//span[text()='Conference Room'])[1]")
	WebElement conferenceRoom;

	public void clickOnConferenceRoom() {
		conferenceRoom.click();
	}

	@FindBy(xpath = "(//span[text()='No Job'])[1]")
	WebElement noJob;

	public void clickOnNoJob() {
		noJob.click();
	}

	@FindBy(xpath = "(//span[text()='Bulk Allocation'])")
	WebElement bulkAllocation;

	public void clickOnBulkAllocation() {
		wait.until(ExpectedConditions.visibilityOf(bulkAllocation));
		bulkAllocation.click();

	}

	@FindBy(xpath = "(//span[text()='Administrator'])[1]")
	WebElement administrator;

	public void Administrator() {
		wait.until(ExpectedConditions.visibilityOf(administrator));
		administrator.click();
	}

	@FindBy(xpath = "(//span[text()='Designation'])[1]")
	WebElement designation;

	public void Designation() {
		wait.until(ExpectedConditions.visibilityOf(designation));
		designation.click();
	}

	@FindBy(xpath = "(//span[text()='Food Master'])[1]")
	WebElement foodMaster;

	public void FoodMaster() {
		foodMaster.click();
	}

	@FindBy(xpath = "(//span[text()='My Lunch'])[1]")
	WebElement myLunch;

	public void MyLunch() {
		myLunch.click();
	}

	@FindBy(xpath = "(//span[text()='Workflow'])[1]")
	WebElement workFlow;

	public void WorkFlow() {
		wait.until(ExpectedConditions.visibilityOf(workFlow));
		workFlow.click();
	}

	@FindBy(xpath = "//span[text()='Pending Ticket']")
	WebElement pendingTicket;

	public void PendingTicket() {
		wait.until(ExpectedConditions.visibilityOf(pendingTicket));
		pendingTicket.click();
	}

	@FindBy(xpath = "//span[text()='Worksheet']")
	WebElement worksheet;

	public void clickWorksheet() {
		wait.until(ExpectedConditions.visibilityOf(worksheet));
		worksheet.click();
	}

	@FindBy(xpath = "//span[text()='Client']")
	WebElement client;

	public void clickClient() {
		wait.until(ExpectedConditions.visibilityOf(client));
		client.click();
	}

	@FindBy(xpath = "//span[text()='Client List']")
	WebElement clientList;

	public void clickClientList() {
		wait.until(ExpectedConditions.visibilityOf(clientList));
		clientList.click();
	}

	@FindBy(xpath = "//span[text()='HR']")
	WebElement HR;

	public void clickHR() {
		wait.until(ExpectedConditions.visibilityOf(HR));
		HR.click();
	}

	@FindBy(xpath = "//span[text()='Attendance Summary']")
	WebElement attendanceSummary;

	public void clickAttendanceSummary() {
		wait.until(ExpectedConditions.visibilityOf(attendanceSummary));
		attendanceSummary.click();
	}

	@FindBy(xpath = "//span[contains(text(), 'Change In Out Time')]")
	WebElement changeInOut;

	public void clickOnChangeInOut() {

		changeInOut.click();
	}

	@FindBy(xpath = "//span[text()='IT HelpDesk']")
	WebElement ITTicket;

	public void clickOnITTicket() {
		ITTicket.click();
	}

	@FindBy(xpath = "(//div[text()='HR']/following::span[text()='HRMS Dashboard'])[1]")
	WebElement HRMSDashboard;

	public void clickOnHRMSDashboard() {
		HRMSDashboard.click();
	}

	@FindBy(xpath = "//p-checkbox[@id='mark_as_complete']")
	WebElement termsandConditionsCheckbox;

	public void clickTermsandConditionsCheckbox() {
		termsandConditionsCheckbox.click();
	}

	@FindBy(xpath = "//button[@label='AGREE']")
	WebElement termsandConditionsButton;

	public void clickTermsandConditionsButton() {
		termsandConditionsButton.click();
	}

}
