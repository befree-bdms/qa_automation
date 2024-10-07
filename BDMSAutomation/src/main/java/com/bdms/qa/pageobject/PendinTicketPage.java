package com.bdms.qa.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PendinTicketPage {
	
	WebDriver driver;
	WebDriverWait wait;
		
	//Constructor
		public PendinTicketPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy (xpath="//span[text()='Add Ticket']")
	private WebElement addTicket;
	
	public void clickAddTicket() {
		addTicket.click();
	}
	
	@FindBy (xpath="//textarea[@formcontrolname='subject']")
	WebElement subject;
	
	public void inputSubject(String subjecttext) {
		subject.sendKeys(subjecttext);
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='type_id']")
	WebElement clkTicketType;
	
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTicketType;
	
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclickTicketType;
	
	public void ticketType(String type) {
		
		clkTicketType.click();
		inputTicketType.sendKeys(type);
		confirmclickTicketType.click();

		
	}
	
	@FindBy (xpath="//textarea[@formcontrolname='issue_detail']")
	WebElement 	description;
	
	public void inputDescription(String descr) {
		description.sendKeys(descr);
	}
	
	@FindBy (xpath="//textarea[@formcontrolname='reason_why_this_has_occurred']")
	WebElement 	explainWhyOccurred;
	
	public void reasonOccurred(String WhyOccurred) {
		explainWhyOccurred.sendKeys(WhyOccurred);
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='status_id']")
	WebElement clkstatus;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputStatus;
	
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclkstatus;
	
	public void setStaus(String statusInput) {
		//wait.until(ExpectedConditions.visibilityOf(clkstatus));
		clkstatus.click();
		inputStatus.sendKeys(statusInput);
		confirmclkstatus.click();

	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='problem_our_side']")
	WebElement isThisProblemOnOurSide;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputIsThisProblemOnOurSide;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmisThisProblemOnOurSide;
	
	public void setIsThisProblemOnOurSide(String yesORNot) {
		isThisProblemOnOurSide.click();
		inputIsThisProblemOnOurSide.sendKeys(yesORNot);
		confirmisThisProblemOnOurSide.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='parent_id']")
	WebElement parentTradingName;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputparentTradingName;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmisparentTradingName;
	
	public void setParentTradingName(String name) {
		parentTradingName.click();
		inputparentTradingName.sendKeys(name);
		confirmisparentTradingName.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='entity_id']")
	WebElement clientName;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputclientName;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclientName;
	
	public void setClientName(String name) {
		wait.until(ExpectedConditions.visibilityOf(clientName));
		clientName.click();
		inputclientName.sendKeys(name);
		confirmclientName.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='team_id']")
	WebElement Team;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTeam ;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmTeam ;
	
	public void setTeam(String name) {
		Team.click();
		inputTeam.sendKeys(name);
		confirmTeam.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='master_id']")
	WebElement Service;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputService;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmService;
	
	public void setService(String name) {
		Service.click();
		inputService.sendKeys(name);
		confirmService.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='mistake_id']")
	WebElement typeOfMistake;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTypeOfMistake;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmTypeOfMistake;
	
	public void setTypeOfMistake(String name) {
		typeOfMistake.click();
		inputTypeOfMistake.sendKeys(name);
		confirmTypeOfMistake.click();
		
	}
	
	
	@FindBy (xpath="//p-multiselect[@formcontrolname='staff_involved_issue']")
	WebElement StaffInvolvedInIssue;
	@FindBy (xpath="//input[@class='p-multiselect-filter p-inputtext p-component']")
	WebElement inputStaffInvolvedInIssue;
	@FindBy (xpath="//p-multiselectitem[@class='p-element ng-star-inserted']")
	WebElement confirmStaffInvolvedInIssue;
	
	public void setStaffInvolvedInIssue(String name1) {
		StaffInvolvedInIssue.click();
		inputStaffInvolvedInIssue.sendKeys(name1);
		confirmStaffInvolvedInIssue.click();
		
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='type_of_mistake']")
	WebElement categoryOfMistakeName;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputCategoryOfMistakeName;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmCategoryOfMistakeName;
	
	public void setCategoryOfMistakeName(String name) {
		categoryOfMistakeName.click();
		inputCategoryOfMistakeName.sendKeys(name);
		confirmCategoryOfMistakeName.click();
		//confirmCategoryOfMistakeName.sendKeys(Keys.PAGE_DOWN);
		
	}
	
	@FindBy (xpath="(//textarea[@rows=\"1\"])[1]")
	WebElement actionRequiredDetails1;
	@FindBy (xpath="(//textarea[@rows=\"1\"])[2]")
	WebElement actionRequiredDetails2;
	@FindBy (xpath="(//textarea[@rows=\"1\"])[3")
	WebElement actionRequiredDetails3;
	@FindBy (xpath="(//textarea[@rows=\"1\"])[4]")
	WebElement actionRequiredDetails4;
	@FindBy (xpath="(//textarea[@rows=\"1\"])[5]")
	WebElement actionRequiredDetails5;
	@FindBy (xpath="(//textarea[@rows=\"1\"])[6]")
	WebElement actionRequiredDetails6;
	
	
	
	
	public void setActionRequiredDetails(String details) {
		actionRequiredDetails1.sendKeys(details);
	}
	
	
	@FindBy (xpath="//p-dropdown[@class=\"p-element p-inputwrapper has-required-validation ng-untouched ng-pristine ng-invalid\"]/following-sibling::label")
	WebElement assignStaff;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputassignStaff;
	@FindBy(xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmassignStaff;
	
	public void setAssignStaff(String Name) {
		assignStaff.click();
		inputassignStaff.sendKeys(Name);
		confirmassignStaff.click();
	}
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-plus-circle']")
	WebElement addStaff;
	
	public void addAssignStaff(String details) throws InterruptedException {
		
		for(int i=1;i<=6;i++) {
		addStaff.click();
		Thread.sleep(2000);
		actionRequiredDetails2.sendKeys(details);
		
		}
	}
	
	@FindBy (xpath="//textarea[@formcontrolname=\"resolution\"]")
	WebElement comment;
	
	public void addComment(String Comment) {
		comment.sendKeys(Comment);
		
	}
	
	@FindBy (xpath="//span[text()='Save']")
	WebElement save;
	
	public void clkOnSave() {
		save.click();
	}

}
