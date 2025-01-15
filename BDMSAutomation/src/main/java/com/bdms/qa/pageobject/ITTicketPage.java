package com.bdms.qa.pageobject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ITTicketPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public ITTicketPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Type Master']")
	private WebElement typeMaster;

	public void clicktypeMaster() {
		typeMaster.click();
	}

	@FindBy(xpath = "//span[text()='Add Record']")
	private WebElement addRecord;

	public void clickOnAddRecord() {
		addRecord.click();
	}

	@FindBy(id = "p-highlighted-option")
	private WebElement selectTypeMaster;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputTypeMaster;

	@FindBy(xpath = "//div[@id='id']")
	private WebElement clickTypeMaster;

	public void clickOnSelectMaster(String typemaster) {
		selectTypeMaster.click();
		inputTypeMaster.sendKeys(typemaster);
		clickTypeMaster.click();
	}

	@FindBy(xpath = "//input[@formcontrolname='type_name']")
	WebElement TypeName;

	public void inputTypename(String name) {
		TypeName.sendKeys(name);
	}

	@FindBy(xpath = "//span[text()='Add']")
	WebElement Add;

	public void clickOnAdd() {
		Add.click();
	}

	public void currentTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(currentDateTime.format(formatter));
	}

	@FindBy(id = "masterRef")
	WebElement subtypeMaster;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputsubtypeMaster;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clicksubtypeMaster;

	public void selectMasterName(String type) {
		subtypeMaster.click();
		inputsubtypeMaster.sendKeys(type);
		clicksubtypeMaster.click();
	}

	@FindBy(id = "typeRef")
	private WebElement selectTypeName;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputTypeName;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clickTypeName;

	public void clickOnTypeName(String typename) {
		selectTypeName.click();
		inputTypeName.sendKeys(typename);
		clickTypeName.click();
	}

	@FindBy(xpath = "//span[text()='Sub Type']")
	WebElement subType;

	public void clickOnSubType() {
		subType.click();
	}

	@FindBy(id = "subTypeName")
	WebElement selectSubType;

	public void inputSubTypeName(String name) {
		selectSubType.sendKeys(name);
	}

	@FindBy(id = "approval_type")
	WebElement approvalType;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputApprovalType;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clickApprovalType;

	public void selectApprovaltype(String type) {
		approvalType.click();
		inputApprovalType.sendKeys(type);
		clickApprovalType.click();
	}

	@FindBy(xpath = "//span[text()='Quick Action']")
	private WebElement quickAction;

	public void clickOnQuickAction() {
		quickAction.click();

	}

}
