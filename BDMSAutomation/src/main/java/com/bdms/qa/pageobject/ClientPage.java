package com.bdms.qa.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public ClientPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@accesskey='.']")
	private WebElement filter;

	public void clickFilter() {
		filter.click();
	}

	@FindBy(xpath = "(//app-filter-table[@class='ng-star-inserted'])[3]")
	private WebElement billing;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputbilling;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement selectbilling;

	public void billingName(String billingname) {
		billing.click();
		inputbilling.sendKeys(billingname);
		selectbilling.click();
		;
	}

	@FindBy(xpath = "(//app-filter-table[@class='ng-star-inserted'])[4]")
	private WebElement legalNameFilter;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputLegalName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement selectLegalName;

	public void legalName(String TradingName) throws InterruptedException {
		// legalNameFilter.click();
		Thread.sleep(3000);
		legalNameFilter.sendKeys(TradingName);
		// selectLegalName.click();;
	}

	@FindBy(xpath = "(//div[@class=\"filter-field flex-grow-1\"])[1]")
	private WebElement code;

	public void clientCode(String addcode) {
		code.sendKeys(addcode);
	}

	@FindBy(xpath = "//button[@ptooltip='Edit']")
	private WebElement edit;

	public void clickEdit() {
		edit.click();
	}

	@FindBy(xpath = "//span[text()='Client Checklist']")
	private WebElement clientChecklist;

	public void clickClientChecklist() {
		clientChecklist.click();
	}

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement search;

	public void clickSearch(String checklistName) {
		search.sendKeys(checklistName);
	}

	@FindBy(xpath = "//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid p-inputwrapper-filled']")
	private WebElement OptionApplicable;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputOptionApplicable;
	@FindBy(xpath = "(//p-dropdownitem[@class='p-element ng-star-inserted'])[2]")
	private WebElement selectOptionApplicable;

	public void clickOptionApplicable() {
		OptionApplicable.click();
		// inputOptionApplicable.sendKeys(checklistName);
		selectOptionApplicable.click();
	}

	@FindBy(xpath = "//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid p-inputwrapper-filled']")
	private WebElement OptionNotApplicable;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputNotApplicable;
	@FindBy(xpath = "(//p-dropdownitem[@class='p-element ng-star-inserted'])[3]")
	private WebElement selectOptionNotApplicable;

	public void clickOptionNotApplicable(String checklistName) {
		OptionNotApplicable.click();
		inputNotApplicable.sendKeys(checklistName);
		selectOptionNotApplicable.click();
	}

	// p-dropdown[@class="p-element p-inputwrapper ng-untouched ng-pristine ng-valid
	// p-inputwrapper-filled"]

	@FindBy(xpath = "//div[@class='p-datatable-wrapper']")
	private WebElement scrollableElement;

	public void scrollElement() {

		// Scroll from right to left (move to the beginning of the element)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = 0;", scrollableElement);

	}

}
