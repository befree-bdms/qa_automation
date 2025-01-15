package com.bdms.qa.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BulkAllocationPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public BulkAllocationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='user_id']")
	private WebElement allocateUser;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputAllocateUser;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmAllocateUser;

	public void clickAllocateUser(String Name) {
		allocateUser.click();
		inputAllocateUser.sendKeys(Name);
		confirmAllocateUser.click();
	}

	@FindBy(xpath = "//p-multiselect[@formcontrolname='entity_id']")
	private WebElement clientList;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[1]")
	private WebElement clkClientList;

	public void clickClientList() {
		clientList.click();
		clkClientList.click();
		clientList.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='new_user_id']")
	private WebElement reAllocateUser;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputReAllocateUser;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement confirmReAllocateUser;

	public void clickReAllocateUser(String Name) {
		reAllocateUser.click();
		inputReAllocateUser.sendKeys(Name);
		confirmReAllocateUser.click();
	}

	@FindBy(xpath = "//p-multiselect[@formcontrolname='services']")
	private WebElement services;

	@FindBy(xpath = "((//div[@class='p-checkbox-box'])[1]")
	private WebElement clkservices;

	public void clickServices() {
		services.click();
		clkClientList.click();
		clientList.click();

	}

	@FindBy(xpath = "//button[@label='Save']")
	WebElement save;

	public void Save() {
		save.click();
	}

	@FindBy(xpath = "//a[@id='bulkDeallocation']")
	WebElement bulkDeallocation;

	public void ClickBulkDeallocation() {
		bulkDeallocation.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='user_id']")
	WebElement deallocateUser;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputDeallocateUser;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectDeallocateUser;

	public void ClickDeallocateUser(String name) {
		deallocateUser.click();
		inputDeallocateUser.sendKeys(name);
		selectDeallocateUser.click();
	}

}
