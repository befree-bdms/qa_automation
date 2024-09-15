package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLeavesPage {
	
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
	
	@FindBy (xpath="//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")
	private WebElement leaveType;
	
	@FindBy (xpath="//p-calendar[@formcontrolname='from_date']")
	private WebElement fromDate;
	
	@FindBy (xpath="//p-calendar[@formcontrolname='to_date']")
	private WebElement toDate;
	
	@FindBy (xpath="//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")
	private WebElement informTeamIncharge;
	
	@FindBy (xpath="//span[text()='Yes'] [@class='ng-star-inserted']")
	private WebElement drpInformTeamInchargeYes;
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='weekly_task']")
	private WebElement weeklyTaskList;
	
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")
	private WebElement drpWeeklyTaskListNo;
	
	@FindBy (xpath="//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")
	private WebElement wasThereAnything;
	
	@FindBy (xpath="//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")
	private WebElement drpWasThereAnythingYes;
	
	@FindBy (xpath="//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")
	private WebElement txtIfDueComment;
	
	@FindBy (xpath="//textarea[@formcontrolname='leave_reason']")
	private WebElement reasonforLeave;
	
	@FindBy (xpath="//span[text()='Save']")
	private WebElement btnSave;
	
	

}
