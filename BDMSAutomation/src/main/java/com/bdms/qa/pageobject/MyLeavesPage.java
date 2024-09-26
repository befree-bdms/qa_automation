package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLeavesPage  {
	
	WebDriver driver;
	
	//Constructor
		public MyLeavesPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	//Locators
	@FindBy (xpath="//span[text()='My Profile'][1]")
	private WebElement myProfile;
	
	@FindBy (xpath="//span[contains(text(),'My Leaves')]")
	private WebElement myLeaves;
	
	@FindBy (xpath="//span[text()='Apply Leave']")
	private WebElement applyLeave;
	
	//@FindBy(xpath="//windowmaximizeicon[@class='p-element p-icon-wrapper ng-tns-c647991600-96 ng-star-inserted']")
	//@FindBy(xpath="//button[@class='ng-tns-c647991600-95 p-dialog-header-icon p-dialog-header-maximize p-link ng-star-inserted']")
	//private WebElement maximize;
	
	
	@FindBy (xpath="//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")
	private WebElement leaveType;
	
	@FindBy (xpath="//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")
	private WebElement enterLeaveType;
	
	@FindBy(xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clickOnLeaveType;
	
	@FindBy (xpath="//p-calendar[@formcontrolname='from_date']")
	private WebElement fromDate;
	
	@FindBy (xpath="//p-calendar[@formcontrolname='to_date']")
	private WebElement toDate;
	
	@FindBy (xpath="//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")
	private WebElement informTeamIncharge;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputInformTeamIncharge;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement drpInformTeamIncharge;
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='weekly_task']")
	private WebElement weeklyTaskList;
	@FindBy(xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputWeeklyTaskList;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement drpWeeklyTaskList;
	
	@FindBy (xpath="//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")
	private WebElement wasThereAnything;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement inputWasThereAnything;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement drpWasThereAnything;
	
	@FindBy (xpath="//input[@formcontrolname='anything_due_comments']")
	private WebElement ifDue;
	
	@FindBy (xpath="//textarea[@formcontrolname='leave_reason']")
	private WebElement reasonforLeave;
	
	@FindBy (xpath="//span[text()='Save']")
	private WebElement btnSave;
	
	//Action Methods
	
	public void clickOnApplyLeave() {
		
		applyLeave.click();
	}
	
	/*public void clickOnMaximizeWindow() {
		maximize.click();
	}*/
	public void clickOnLeaveType(String typeOfLeave) {
		
		leaveType.click();
		enterLeaveType.sendKeys(typeOfLeave);
		clickOnLeaveType.click();
		
	}
	
	public void clickOnFromDate() {
		
		fromDate.click();
		
	}
	
	public void clickOnToDate() {
		
		toDate.click();
	}
	
	public void clickOnInformTeamIncharge(String selectOption) {
		
		informTeamIncharge.click();
		inputInformTeamIncharge.sendKeys(selectOption);
		drpInformTeamIncharge.click();	
	}
	
	public void clickOnWeeklyTaskList(String selectOption) {
		
		weeklyTaskList.click();
		inputWeeklyTaskList.sendKeys(selectOption);
		drpWeeklyTaskList.click();
		
	}
	
	public void clickOnWasThereAnythingDue(String selectOption) {
		
		wasThereAnything.click();
		inputWasThereAnything.sendKeys(selectOption);
		drpWasThereAnything.click();
	}
	
	public void clickOnIfDue(String dueComment) {
		ifDue.sendKeys(dueComment);
	}
	
	public void clickOnReasonForLeave(String ReasonForLeaveComment) {
		reasonforLeave.sendKeys(ReasonForLeaveComment);
	}
	
	public void clickOnSave() {
		btnSave.click();
	}
	
	@FindBy (xpath="//p-dropdown[@class='p-element p-inputwrapper ng-untouched ng-pristine ng-valid ng-star-inserted p-inputwrapper-filled']")
	private WebElement employeeNameFilter;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement enterEmployeeName;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	private WebElement clickOnEmployeeName;
	
	public void applyEmployeeNameFileter(String employeeName) {
		employeeNameFilter.click();
		enterEmployeeName.sendKeys(employeeName);
		clickOnEmployeeName.click();
	}
	
	
	
	
	
	@FindBy (xpath="//p-dropdown[@class='p-element p-inputwrapper ng-pristine ng-valid ng-star-inserted ng-touched']")
	private WebElement leaveTypeFilter;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	private WebElement eneterLeaveType;
	@FindBy (id="p-highlighted-option")
	private WebElement clickOnLeaveTypeFilter;
	
	public void applyLeaveTypeFilter(String selectLeaveType)  {
		leaveTypeFilter.click();
		eneterLeaveType.sendKeys(selectLeaveType);
		clickOnLeaveTypeFilter.click();
	}
	
	@FindBy (xpath="//p-calendar[contains(@class, 'ng-tns-c3918063748-595')]")
	private WebElement fromLeavePeriod;
	@FindBy (xpath="//p-calendar[@class=\"p-element p-inputwrapper min-w-7rem ng-tns-c3918063748-82 ng-untouched ng-pristine ng-valid ng-star-inserted\"]")
	private WebElement toLeavePeriod;
	
	public void clickOnStartDateCalendar() {
		fromLeavePeriod.click();
	}
	
	public void clickOnEndDateCalendar() {
		toLeavePeriod.click();
	}
	
	@FindBy(xpath="//p-button[@class=\"p-element ng-star-inserted\"]")
	private WebElement actionEdit;
	
	public void clickOnEdit() {
		actionEdit.click();
	}
	
	@FindBy(xpath="//textarea[@formcontrolname=\"comment\"]")
	private WebElement firstApprovalComment;
	
	public void addComment(String txtfirstApprovalComment) {
		firstApprovalComment.sendKeys(txtfirstApprovalComment);
	}
	
	@FindBy(xpath="//span[text()='Approve']")
	private WebElement approve;
	
	public void clickOnApprove() {
		approve.click();
	}
	
	
	
	
	

}
