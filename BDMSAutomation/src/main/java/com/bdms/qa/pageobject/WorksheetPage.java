package com.bdms.qa.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorksheetPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public WorksheetPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Worksheet']")
	private WebElement addWorksheet;

	public void clickAddWoksheet() {
		addWorksheet.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='entity_id']")
	private WebElement clickTradingName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputTradingName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmTradingName;

	public void tradingName(String clientName) {
		clickTradingName.click();
		inputTradingName.sendKeys(clientName);
		confirmTradingName.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='master_activity_id']")
	private WebElement clickMasterActivity;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputMasterActivity;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmMasterActivity;

	public void masterActivity(String masterActivity) {
		clickMasterActivity.click();
		inputMasterActivity.sendKeys(masterActivity);
		confirmMasterActivity.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='task_id']")
	private WebElement clickTask;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputTask;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmTask;

	public void setTask(String task) {
		clickTask.click();
		inputTask.sendKeys(task);
		confirmTask.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='critical_task']")
	private WebElement clickCriticalTask;
	@FindBy(xpath = "//input[@aria-activedescendant='p-highlighted-option']")
	private WebElement inputCriticalTask;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmCriticalTask;

	// input[@class='p-dropdown-filter p-inputtext p-component']

	public void setCriticalTask(String YesNO) throws InterruptedException {
		clickCriticalTask.click();
		Thread.sleep(1000);
		inputCriticalTask.sendKeys(YesNO);
		confirmCriticalTask.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='start_date']")
	private WebElement startDate;

	public void clickStartDate() {
		startDate.click();
	}

	@FindBy(xpath = "//p-calendar[@formcontrolname='end_date']")
	private WebElement endDate;

	public void clickEndDate() {
		endDate.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='frequency_id']")
	private WebElement clickFrequency;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputFrequency;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmFrequency;

	public void setFrequency(String period) {
		clickFrequency.click();
		inputFrequency.sendKeys(period);
		confirmFrequency.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='expert_day']")
	private WebElement clickDay;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputDay;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmDay;

	public void setDay(String day) {
		clickDay.click();
		inputDay.sendKeys(day);
		confirmDay.click();
	}

	@FindBy(xpath = "//span[text()='After Days']")
	private WebElement afterDay;

	public void clickAfterDay() {
		afterDay.click();
	}

	@FindBy(xpath = "//input[@inputmode='decimal']")
	private WebElement afterDays;

	public void clickAfterDays(String Days) {
		afterDays.sendKeys(Days);
	}

	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	private WebElement Notes;

	public void addNotes(String Comment) {
		Notes.sendKeys(Comment);
	}

	@FindBy(xpath = "//span[text()='Save & Next']")
	private WebElement SaveandNext;

	public void clickSaveandNext() {
		SaveandNext.click();
	}

	@FindBy(xpath = "//span[text()='Set Rule & Create Worksheet']")
	private WebElement createWorksheet;

	public void clickcreateWorksheet() {
		createWorksheet.click();
	}

	@FindBy(xpath = "//p-calendar[@id='due_date_end_date']")
	private WebElement fileterStartDate;

	public void ClickFileterStartDate() {
		fileterStartDate.click();
	}

	@FindBy(xpath = "//p-calendar[@ptooltip='Reminder / Due Date']")
	private WebElement fileterEndtDate;

	public void clickFileterEndtDate() {
		fileterEndtDate.click();
	}

	@FindBy(xpath = "(//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	private WebElement filterClientName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputfilterClientName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmfilterClientName;

	public void clickFilterClientName(String clientName) {
		filterClientName.click();
		inputfilterClientName.sendKeys(clientName);
		confirmfilterClientName.click();
	}

	@FindBy(xpath = "(//p-calendar[@ptooltip='Reminder / Due Date'])[2]")
	private WebElement checklistIcon;

	public void checklistIcon() {
		List<WebElement> checklistButtons = driver.findElements(By.xpath("//button[@icon='fa-solid fa-list-check']"));
		int totalElements = checklistButtons.size();

		for (int i = 1; i <= totalElements; i++) {
			String dynamicXPath = "(//button[@icon='fa-solid fa-list-check'])[" + i + "]";
			WebElement checklistButton = driver.findElement(By.xpath(dynamicXPath));

			// Check if the button is displayed
			if (checklistButton.isDisplayed()) {
				System.out.println(i + "  Checklist button is visible.");
			} else {
				System.out.println(i + "  Checklist button is not visible.");
			}
		}
	}

	public void checkEditIcon() {
		List<WebElement> checklistButtons = driver.findElements(By.xpath("//button[@icon='pi pi-ellipsis-v']"));
		int totalElements = checklistButtons.size();

		for (int i = 1; i <= totalElements; i++) {
			String dynamicXPath = "(//button[@icon='pi pi-ellipsis-v'])[" + i + "]";
			WebElement checklistButton = driver.findElement(By.xpath(dynamicXPath));

			// Check if the button is displayed
			if (checklistButton.isDisplayed()) {
				System.out.println(i + "  Edit button is visible.");
			} else {
				System.out.println(i + "  Edit button is not visible.");
			}
		}
	}

	public void getIndexCount() {

		List<WebElement> tableRows = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']//tr"));
		int rowCount = tableRows.size();

		System.out.println("The number of rows after wait: " + rowCount);
	}

	@FindBy(xpath = "//span[text()='Incomplete Worksheet']")
	private WebElement IncompleteWorksheet;

	public void clickOnIncompleteWorksheet() {
		IncompleteWorksheet.click();
	}

	@FindBy(xpath = "(//p-multiselect[@class='p-element p-inputwrapper p-multiselect-clearable ng-untouched ng-pristine ng-valid ng-star-inserted'])[1]")
	private WebElement IncompleteWorksheetfilterformasterchecklist;
	@FindBy(xpath = "//input[@class='p-multiselect-filter p-inputtext p-component']")
	private WebElement inputIncompleteWorksheetfilterformasterchecklist;
	@FindBy(xpath = "//div[@id='id']")
	private WebElement checkBoxOption;

	public void clickOnMCheckList(String masterActivity) {
		IncompleteWorksheetfilterformasterchecklist.click();
		inputIncompleteWorksheetfilterformasterchecklist.sendKeys(masterActivity);
		checkBoxOption.click();
	}

	@FindBy(xpath = "//p-tableheadercheckbox[@class='p-element ng-star-inserted']")
	private WebElement checkBoxIndex;
	@FindBy(xpath = "//span[text()='Delete Selected Worksheet']")
	private WebElement DeleteSelectedWorksheet;
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement confirm;

	public void deleteworksheet() {
		checkBoxIndex.click();
		DeleteSelectedWorksheet.click();
		confirm.click();

	}

}
