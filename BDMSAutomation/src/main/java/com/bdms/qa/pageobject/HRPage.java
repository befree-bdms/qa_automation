package com.bdms.qa.pageobject;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HRPage {

	WebDriver driver;
	WebDriverWait wait;
	DateTimeFormatter timeFormatterNoColon = DateTimeFormatter.ofPattern("HHmmss");
	DateTimeFormatter timeFormatterWithColon = DateTimeFormatter.ofPattern("HH:mm:ss");

	// Constructor
	public HRPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@accesskey='.']")
	private WebElement filter;

	public void clickFilter() {
		filter.click();
	}

	@FindBy(xpath = "(//app-filter-table[@class='ng-star-inserted'])[2]")
	private WebElement staffName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputStaffName;
	@FindBy(xpath = "//p-dropdownitem[@class=\"p-element ng-star-inserted\"]")
	private WebElement selectStaffName;

	public void clickStaffName(String name) {
		staffName.click();

		inputStaffName.sendKeys(name);

		selectStaffName.click();
	}

	@FindBy(xpath = "(//div[@class=\"filter-field flex-grow-1\"])[4]")
	private WebElement datefilter;

	public void clickDateFilter() {
		datefilter.click();
	}

	@FindBy(xpath = "//span[@class='badge badge-info text-12 p-badge mb-1 ng-star-inserted']")
	WebElement timeBadge;

	@FindBy(xpath = "//span[@class='badge badge-primary mr-2 cursor-pointer p-tag p-component']")
	WebElement workUnitBadge;

	@FindBy(xpath = "(//td[@class=\"p-element ng-star-inserted\"])[8]")
	WebElement actualRemarkField;

	// Method to fetch total hours from time string
	public double getTotalHours() {
		String timeString = timeBadge.getText();
		String[] timeParts = timeString.split(":");
		int hours = Integer.parseInt(timeParts[0]);
		int minutes = Integer.parseInt(timeParts[1]);
		int seconds = Integer.parseInt(timeParts[2]);
		return hours + (minutes / 60.0) + (seconds / 3600.0);
	}

	// Method to fetch work units
	public int getWorkUnit() {
		return Integer.parseInt(workUnitBadge.getText());
	}

	// Method to get the actual remark text
	public String getActualRemark() {
		return actualRemarkField.getText();
	}

	// Method to determine expected remark based on conditions
	public String determineExpectedRemark(double totalHours, int workUnit) {
		if (workUnit == 0 || (workUnit >= 0 && workUnit <= 39)) {
			return "Leave";
		} else if (workUnit >= 40 && workUnit <= 69) {
			return "Half Day";
		} else if (workUnit >= 70 && workUnit <= 79) {
			return "Early Leaving";
		} else if (workUnit == 80) {
			return "Full Day";
		}
		return "Leave";
	}

	// Method to verify if the actual remark matches the expected remark
	public void verifyFinalRemark() {
		double totalHours = getTotalHours();
		int workUnit = getWorkUnit();
		String expectedRemark = determineExpectedRemark(totalHours, workUnit);
		String actualRemark = getActualRemark();
		Assert.assertEquals(actualRemark, expectedRemark, "Final Remark verification failed.");
	}

	/****************************************
	 * Approval Flow
	 **********************************************/

	@FindBy(xpath = "(//app-filter-table[@class='ng-star-inserted'])[8]")
	WebElement selectRemarkFilter;

	@FindBy(xpath = "//input[@class=\"p-multiselect-filter p-inputtext p-component\"]")
	WebElement inputLeaveRemark;

	@FindBy(xpath = " (//div[@class='p-checkbox-box'])[2]")
	WebElement confirmLeaveRemark;

	@FindBy(xpath = "//td[@class='p-element py-2 ng-star-inserted']/app-data-format/span")
	List<WebElement> attendanceRows;

	// td[@class='p-element py-2 ng-star-inserted']//app-data-format/span

	// Separate locators for Add In Time and Add Out Time buttons
	By addInTimeButton = By.xpath("//span[contains(text(), 'Add In Time')]");
	By addOutTimeButton = By.xpath("//span[contains(text(), 'Add Out time ')]");

	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editUnitButton;
	@FindBy(xpath = " //div[contains(text(), 'Action')]")
	WebElement Action;

	public void applyFilters(String leaveType) throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.moveToElement(Action).sendKeys(Keys.ARROW_RIGHT).perform();
		Thread.sleep(5000);
		selectRemarkFilter.click();
		inputLeaveRemark.sendKeys(leaveType);
		confirmLeaveRemark.click();
	}

	public void checkAndEditAttendance() {
		for (WebElement row : attendanceRows) {
			WebElement inTime = row.findElement(By.xpath("//span[contains(text(), 'I :')]"));
			WebElement outTime = row.findElement(By.xpath("//span[contains(text(), 'O :')]"));
			// WebElement unit = row.findElement(By.xpath(".//td[@class='unit']"));

			// Check if the in-time or out-time is missing and click the appropriate edit
			// button
			if (inTime.getText().equals(" I : 00:00:00 ") && row.findElements(addInTimeButton).size() > 0) {
				row.findElement(addInTimeButton).click();
			}
			if (outTime.getText().equals(" O : 00:00:00 ") && row.findElements(addOutTimeButton).size() > 0) {
				row.findElement(addOutTimeButton).click();
			}

			/*
			 * //Edit unit if it is zero if (unit.getText().equals("0")) {
			 * editUnitButton.click(); }
			 */
		}
	}

	// @FindBy(xpath = "//span[contains(text(),'Add Out time')]")
	@FindBy(xpath = "(//span[contains(text(),  'Add Out time' )])[1]")
	WebElement addOutTime;

	public void clickOnAddOutTime() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addOutTime);

		addOutTime.click();
	}

	@FindBy(xpath = "//p-button[@ptooltip='Add timesheet']")
	WebElement AddTimesheet;

	public void clickOnAddTimesheet() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddTimesheet);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// AddTimesheet);
		AddTimesheet.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='punch_time']")
	WebElement clickPunchTime;

	@FindBy(xpath = "//p-calendar[@formcontrolname='punch_time']//input[contains(@class, 'ng-tns-')]")
	WebElement punchTime;
	@FindBy(xpath = "//p-calendar[@formcontrolname='punch_time']//button[contains(@class, 'ng-tns-')]")
	WebElement selectPunchTime;

	public void changeInOutwindow(String time) {
		clickPunchTime.click();
		punchTime.sendKeys(time);
		selectPunchTime.click();

	}

	@FindBy(xpath = "//input[@formcontrolname='reason']")
	WebElement reason;

	public void inputReason(String inputreason) {

		reason.sendKeys(inputreason);
	}

	@FindBy(xpath = "//span[text()='Send for approval']")
	WebElement submit;

	public void clickOnSubmit() {
		submit.click();
	}

	@FindBy(xpath = "(//p-button[@ptooltip='Change In Out Approval'])[1]")
	WebElement approve;

	public void clickOnApprove() {
		approve.click();
	}

	@FindBy(xpath = "//input[@formcontrolname='comment']")
	WebElement firstApprovalComment;

	public void firstApprovalComment(String comment) {
		firstApprovalComment.sendKeys(comment);
	}

	@FindBy(xpath = "//span[text()='Approved']")
	WebElement approveByFirstApproval;

	public void clickApproval() {
		approveByFirstApproval.click();
	}

	// Locators for Missing In Out and Missing Timesheet buttons
	@FindBy(xpath = "//span[@class='block text-indigo-500 white-space-nowrap']")
	private WebElement missingInOutButton;

	@FindBy(xpath = "//span[@class='block font-bold text-3xl text-indigo-500']")
	private WebElement missingInOutCount;

	@FindBy(xpath = "//span[@class='block text-green-500 white-space-nowrap']")
	private WebElement missingTimesheetButton;

	@FindBy(xpath = "(//span[@class='block font-bold text-3xl text-green-500'])[3]")
	private WebElement missingTimesheetCount;

	// Method to check and click Missing In Out button
	public void checkAndClickMissingInOut() {
		int count = Integer.parseInt(missingInOutCount.getText());
		if (count > 0) {

			missingInOutButton.click();

		}
	}

	// Method to check and click Missing Timesheet button
	public void checkAndClickMissingTimesheet() {
		int count = Integer.parseInt(missingTimesheetCount.getText());
		if (count > 0) {
			missingTimesheetButton.click();
		}
	}

	@FindBy(xpath = "//button[@ptooltip='Clear Filter']")
	WebElement clearFilter;

	public void clickOnClearFilter() {
		clearFilter.click();
	}

	@FindBy(xpath = "//button[@accesskey='.']")
	WebElement Filter;

	public void clickOnFilter() {
		Filter.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='entity_id']")
	WebElement tradingName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTradingName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectTradingName;

	public void clickOntradingName(String Name) {
		tradingName.click();
		inputTradingName.sendKeys(Name);
		SelectTradingName.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='master_activity_id']")
	WebElement MasterActivity;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputMasterActivity;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectMasterActivity;

	public void clickOnMasterActivity(String Name) {
		MasterActivity.click();
		inputMasterActivity.sendKeys(Name);
		SelectMasterActivity.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='task_id']")
	WebElement Task;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTask;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectTask;

	public void clickOnTask(String Name) {
		Task.click();
		inputTask.sendKeys(Name);
		SelectTask.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='frequency_id']")
	WebElement Frequency;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputFrequency;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectFrequency;

	public void clickOnFrequency(String Name) {
		Frequency.click();
		inputFrequency.sendKeys(Name);
		SelectFrequency.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='period_id']")
	WebElement Period;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputPeriod;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectPeriod;

	public void clickOnPeriod(String Name) {
		Period.click();
		inputPeriod.sendKeys(Name);
		SelectPeriod.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='subactivity_code']")
	WebElement SubActivity;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputSubActivity;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement SelectSubActivity;

	public void clickOnSubActivity(String Name) {
		SubActivity.click();
		inputSubActivity.sendKeys(Name);
		SelectSubActivity.click();
	}

	@FindBy(xpath = "//input[@inputmode='decimal']")
	WebElement unit;

	public void AddUnit(String msg) {
		unit.sendKeys(msg);
	}

	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	WebElement Notes;

	public void AddNote(String msg) {
		Notes.sendKeys(msg);
	}

	@FindBy(xpath = "//textarea[@formcontrolname='reason']")
	WebElement Reason;

	public void AddReason(String msg) {
		Reason.sendKeys(msg);
	}

	@FindBy(xpath = "//span[text()='Send for approval']")
	WebElement sendForApproval;

	public void clickOnSendForApproval() {
		sendForApproval.click();
	}

	/******************************
	 * New *****************************
	 * 
	 * // Locate rows in the table
	 * 
	 * @FindBy(xpath = "//div[@class='p-datatable-wrapper']/table//tr")
	 *               List<WebElement> filteredEntries;
	 * 
	 *               // Get all filtered entries public List<WebElement>
	 *               getFilteredEntries() { return filteredEntries; }
	 * 
	 * 
	 *               // Check if In/Out Time is missing public boolean
	 *               isInOrOutMissing(WebElement entry) { WebElement inOutColumn =
	 *               entry.findElement(By.xpath("//span[@class='p-badge badge
	 *               badge-success text-12 justify-content-center flex
	 *               align-items-center ng-star-inserted']")); String inOutText =
	 *               inOutColumn.getText().trim(); return inOutText.contains("Add In
	 *               Time") || inOutText.contains("Add Out Time"); }
	 * 
	 *               // Check if Work Unit is missing public boolean
	 *               isWorkUnitMissing(WebElement entry) { WebElement workUnitColumn
	 *               = entry.findElement(By.xpath("//p-button[@ptooltip='Add
	 *               timesheet']")); String workUnitText =
	 *               workUnitColumn.getText().trim(); return
	 *               workUnitText.contains("Add Work Unit"); }
	 * 
	 * 
	 * 
	 *               // Click Add In/Out Time button public void
	 *               clickAddInOut(WebElement entry) { WebElement addInOutButton =
	 *               entry.findElement(By.xpath(".//span[contains(text(), 'Add In
	 *               time') or contains(text(), 'Add Out time')]"));
	 *               addInOutButton.click();
	 * 
	 * 
	 *               }
	 * 
	 *               // Click Add Work Unit button public void
	 *               clickAddWorkUnit(WebElement entry) { WebElement
	 *               addWorkUnitButton =
	 *               entry.findElement(By.xpath("//p-button[@ptooltip='Add
	 *               timesheet']")); addWorkUnitButton.click(); }
	 */
}
