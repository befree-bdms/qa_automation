package com.bdms.qa.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesignationPage {
	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public DesignationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@icon='pi pi-filter']")
	WebElement filter;

	public void clickOnFilter() {
		filter.click();
	}

	@FindBy(xpath = "//button[@icon='pi pi-filter']")
	WebElement addDesignationName;

	public void inputDesignationName(String designation) {
		wait.until(ExpectedConditions.visibilityOf(addDesignationName));
		addDesignationName.sendKeys(designation);
	}

	@FindBy(xpath = "//div[@class='flex gap-2 ng-star-inserted']")
	WebElement clickEditDesignationName;

	public void editDesignationName() {
		clickEditDesignationName.click();
	}

	@FindBy(xpath = "//input[@class='p-inputtext p-component p-element w-full']")
	WebElement inputtxtInSearch;

	public void clickRights(String addPageRights) {
		wait.until(ExpectedConditions.visibilityOf(inputtxtInSearch));
		inputtxtInSearch.sendKeys(addPageRights);
	}

	@FindBy(id = "selectAllIsView")
	WebElement clickOnView;

	public void selectView() {
		clickOnView.click();
	}

	@FindBy(id = "selectAllIsAddEdit")
	WebElement clickOnAddOrEdit;

	public void selectAddOrEdit() {
		clickOnAddOrEdit.click();
	}

	@FindBy(id = "selectAllIsDelete")
	WebElement clickOnDelete;

	public void selectDelete() {
		clickOnDelete.click();
	}

	@FindBy(id = "selectAllIsExport")
	WebElement clickOnExport;

	public void selectExport() {
		clickOnExport.click();
	}

	@FindBy(id = "selectAllIsDownload")
	WebElement clickOnDownload;

	public void selectDownload() {
		clickOnDownload.click();
	}

	@FindBy(xpath = "//span[text()='Update']")
	WebElement clickOnUpdate;

	public void update() {
		clickOnUpdate.click();
	}

	@FindBy(xpath = "//td[text()='5']/following-sibling::td//p-checkbox")
	WebElement changepasswordAddView;

}
