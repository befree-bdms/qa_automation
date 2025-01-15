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

	// Constructor
	public PendinTicketPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Ticket']")
	private WebElement addTicket;

	public void clickAddTicket() {
		addTicket.click();
	}

	@FindBy(xpath = "//textarea[@formcontrolname='subject']")
	WebElement subject;

	public void inputSubject(String subjecttext) {
		subject.sendKeys(subjecttext);

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='type_id']")
	WebElement clkTicketType;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTicketType;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclickTicketType;

	public void ticketType(String type) {

		clkTicketType.click();
		inputTicketType.sendKeys(type);
		confirmclickTicketType.click();

	}

	@FindBy(xpath = "//textarea[@formcontrolname='issue_detail']")
	WebElement description;

	public void inputDescription(String descr) {
		description.sendKeys(descr);
	}

	@FindBy(xpath = "//textarea[@formcontrolname='reason_why_this_has_occurred']")
	WebElement explainWhyOccurred;

	public void reasonOccurred(String WhyOccurred) {
		explainWhyOccurred.sendKeys(WhyOccurred);
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='status_id']")
	WebElement clkstatus;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputStatus;

	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclkstatus;

	public void setStaus(String statusInput) {
		wait.until(ExpectedConditions.visibilityOf(clkstatus));
		clkstatus.click();
		inputStatus.sendKeys(statusInput);
		confirmclkstatus.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='problem_our_side']")
	WebElement isThisProblemOnOurSide;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputIsThisProblemOnOurSide;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmisThisProblemOnOurSide;

	public void setIsThisProblemOnOurSide(String yesORNot) {
		wait.until(ExpectedConditions.visibilityOf(isThisProblemOnOurSide));
		isThisProblemOnOurSide.click();
		inputIsThisProblemOnOurSide.sendKeys(yesORNot);
		confirmisThisProblemOnOurSide.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='parent_id']")
	WebElement parentTradingName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputparentTradingName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmisparentTradingName;

	public void setParentTradingName(String name) {
		wait.until(ExpectedConditions.visibilityOf(parentTradingName));
		parentTradingName.click();
		inputparentTradingName.sendKeys(name);
		confirmisparentTradingName.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='entity_id']")
	WebElement clientName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputclientName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmclientName;

	public void setClientName(String name) {
		wait.until(ExpectedConditions.visibilityOf(clientName));
		clientName.click();
		inputclientName.sendKeys(name);
		confirmclientName.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='team_id']")
	WebElement Team;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTeam;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmTeam;

	public void setTeam(String name) {
		wait.until(ExpectedConditions.visibilityOf(Team));
		Team.click();
		inputTeam.sendKeys(name);
		confirmTeam.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='master_id']")
	WebElement Service;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputService;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmService;

	public void setService(String name) {
		wait.until(ExpectedConditions.visibilityOf(Service));
		Service.click();
		inputService.sendKeys(name);
		confirmService.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='mistake_id']")
	WebElement typeOfMistake;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTypeOfMistake;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmTypeOfMistake;

	public void setTypeOfMistake(String name) {
		wait.until(ExpectedConditions.visibilityOf(typeOfMistake));
		typeOfMistake.click();
		inputTypeOfMistake.sendKeys(name);
		confirmTypeOfMistake.click();

	}

	@FindBy(xpath = "//p-multiselect[@formcontrolname='staff_involved_issue']")
	WebElement StaffInvolvedInIssue;
	@FindBy(xpath = "//input[@class='p-multiselect-filter p-inputtext p-component']")
	WebElement inputStaffInvolvedInIssue;
	@FindBy(xpath = "//p-multiselectitem[@class='p-element ng-star-inserted']")
	WebElement confirmStaffInvolvedInIssue;

	public void setStaffInvolvedInIssue(String name1) {
		wait.until(ExpectedConditions.visibilityOf(StaffInvolvedInIssue));
		StaffInvolvedInIssue.click();
		inputStaffInvolvedInIssue.sendKeys(name1);
		confirmStaffInvolvedInIssue.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='type_of_mistake']")
	WebElement categoryOfMistakeName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputCategoryOfMistakeName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmCategoryOfMistakeName;

	public void setCategoryOfMistakeName(String name) {
		wait.until(ExpectedConditions.visibilityOf(categoryOfMistakeName));
		categoryOfMistakeName.click();
		inputCategoryOfMistakeName.sendKeys(name);
		confirmCategoryOfMistakeName.click();
		// confirmCategoryOfMistakeName.sendKeys(Keys.PAGE_DOWN);

	}

	@FindBy(xpath = "(//textarea[@rows=\"1\"])[1]")
	WebElement actionRequiredDetails1;
	@FindBy(xpath = "(//textarea[@rows=\"1\"])[2]")
	WebElement actionRequiredDetails2;
	@FindBy(xpath = "(//textarea[@rows=\"1\"])[3]")
	WebElement actionRequiredDetails3;
	@FindBy(xpath = "(//textarea[@rows=\"1\"])[4]")
	WebElement actionRequiredDetails4;
	@FindBy(xpath = "(//textarea[@rows=\"1\"])[5]")
	WebElement actionRequiredDetails5;
	@FindBy(xpath = "(//textarea[@rows=\"1\"])[6]")
	WebElement actionRequiredDetails6;

	public void setActionRequiredDetails(String details) {
		wait.until(ExpectedConditions.visibilityOf(actionRequiredDetails1));
		actionRequiredDetails1.sendKeys(details);
	}

	public void setActionRequiredDetails2(String details) {
		wait.until(ExpectedConditions.visibilityOf(actionRequiredDetails1));
		actionRequiredDetails2.sendKeys(details);
	}

	@FindBy(xpath = "//p-dropdown[contains(@id,'ticket_assignee_dropdown')]")
	WebElement assignStaff1;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputassignStaff;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement confirmassignStaff;

	public void setAssignStaff1(String Name) {
		wait.until(ExpectedConditions.visibilityOf(assignStaff1));
		assignStaff1.click();
		inputassignStaff.sendKeys(Name);
		confirmassignStaff.click();
	}

	@FindBy(xpath = "//p-dropdown[contains(@id,'ticket_assignee_dropdown2')]")
	WebElement assignStaff3;

	public void setAssignStaff3(String Name) {
		wait.until(ExpectedConditions.visibilityOf(assignStaff2));
		assignStaff2.click();
		inputassignStaff.sendKeys(Name);
		confirmassignStaff.click();
	}

	@FindBy(xpath = "//p-dropdown[contains(@id,'ticket_assignee_dropdown1')]")
	WebElement assignStaff2;

	public void setAssignStaff2(String Name) {
		wait.until(ExpectedConditions.visibilityOf(assignStaff2));
		assignStaff2.click();
		inputassignStaff.sendKeys(Name);
		confirmassignStaff.click();
	}

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-plus-circle']")
	WebElement addStaff;

	public void addAssignStaff() {

		// for(int i=1;i<=6;i++) {
		wait.until(ExpectedConditions.visibilityOf(addStaff));
		addStaff.click();

		// }
	}

	@FindBy(xpath = "//textarea[@formcontrolname='resolution']")
	WebElement comment;

	public void addComment(String Comment) {
		wait.until(ExpectedConditions.visibilityOf(comment));
		comment.sendKeys(Comment);

	}

	@FindBy(xpath = "//span[text()='Save']")
	WebElement save;

	public void clkOnSave() {
		wait.until(ExpectedConditions.visibilityOf(save));
		save.click();
	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='priority']")
	WebElement ticketPriority;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTicketPriority;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectTicketPriority;

	public void setTicketPriority(String priority) {
		ticketPriority.click();
		inputTicketPriority.sendKeys(priority);
		selectTicketPriority.click();

	}

	@FindBy(xpath = "//p-dropdown[@formcontrolname='severity']")
	WebElement ticketTracker;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputTicketTracker;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectTicketTracker;

	public void selectTicketTracker(String severity) {
		ticketTracker.click();
		inputTicketTracker.sendKeys(severity);
		selectTicketTracker.click();

	}

	@FindBy(xpath = "//p-fileupload[@chooselabel='Upload']//span[text()='Upload']")
	WebElement upload;
	@FindBy(xpath = "//input[@type='file']")
	WebElement inputupload;

	public void uploadFile() {

		inputupload.sendKeys("C:\\Users\\nagnath.g\\Desktop\\New.png \n C:\\Users\\nagnath.g\\Desktop\\Old.png");
		// inputupload.sendKeys("C:\\Users\\nagnath.g\\Desktop\\Old.png"
		// "C:\\Users\\nagnath.g\\Desktop\\New.png \n
		// C:\\Users\\nagnath.g\\Desktop\\Old.png");
		// inputupload.sendKeys("C:\\Users\\nagnath.g\\Desktop\\Old.png");
	}

	@FindBy(xpath = "//a[@id='1']")
	WebElement ticketRaised;

	public void clickTicketRaised() {
		ticketRaised.click();
	}

	@FindBy(xpath = "//a[@id='2']")
	WebElement inProgress;

	public void clickInProgress() {
		inProgress.click();
	}

	@FindBy(xpath = "//a[@id='3']")
	WebElement sentForApproval;

	public void clickSentForApproval() {
		sentForApproval.click();
	}

	@FindBy(xpath = "//a[@id='5']")
	WebElement completed;

	public void clickCompleted() {
		completed.click();
	}

	@FindBy(xpath = "(//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid ng-star-inserted'])[3]")
	WebElement filterParentTradingName;
	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement inputParentTradingName;
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectParentTradingName;

	public void clickOnParentTradingName(String parentTradingName) {

		filterParentTradingName.click();
		inputParentTradingName.sendKeys(parentTradingName);
		selectParentTradingName.click();

	}

	@FindBy(xpath = "(//p-button[@ptooltip='Edit'])[1]")
	WebElement edit;

	public void clickOnEdit() {
		edit.click();

	}

	@FindBy(xpath = "//p-checkbox[@id='mark_as_complete']")
	WebElement completionDate;

	public void clickOnCompletionDate() {
		completionDate.click();
	}

}
