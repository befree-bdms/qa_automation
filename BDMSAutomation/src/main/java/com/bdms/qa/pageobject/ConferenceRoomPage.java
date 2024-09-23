package com.bdms.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConferenceRoomPage {
	
	WebDriver driver;
	
	//Constructor
		public ConferenceRoomPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Book Record']")
	WebElement bookRecord;
	
	public void clickOnBookRecord() {
		bookRecord.click();
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='location_id']")
	WebElement location;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement txtlocation;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectlocation;
	
	public void addLocation(String inputLocation) {
		location.click();
		txtlocation.sendKeys(inputLocation);
		selectlocation.click();
		
	}
	
	@FindBy (xpath="//p-dropdown[@formcontrolname='conference_room']")
	WebElement clickconferenceRoom;
	@FindBy (xpath="//input[@class='p-dropdown-filter p-inputtext p-component']")
	WebElement txtconferenceRoom;
	@FindBy (xpath="//p-dropdownitem[@class='p-element ng-star-inserted']")
	WebElement selectconferenceRoom;
	
	public void addconferenceRoom(String inputconferenceRoom) {
		clickconferenceRoom.click();
		txtconferenceRoom.sendKeys(inputconferenceRoom);
		selectconferenceRoom.click();
		
	}
	
	@FindBy (xpath="//input[@formcontrolname='purpose']")
	WebElement purposeOfBook;
	
	public void addpurposeOfBook() {
		purposeOfBook.sendKeys("Test");
	}
	
	@FindBy (xpath="//p-calendar[@formcontrolname='date']")
	WebElement date;
	@FindBy (xpath="//span[text()='Today']")
	WebElement today;
	
	public void addDate() {
		date.click();
		today.click();
	}
	
	@FindBy (xpath="//p-calendar[@formcontrolname='start_time']")
	WebElement selectStartTime;
	@FindBy (xpath="//p-calendar[@formcontrolname='start_time']//input[contains(@class, 'ng-tns-')]")
	WebElement StartTime;
	@FindBy (xpath="//p-calendar[@formcontrolname='end_time']//button[contains(@class, 'ng-tns-')]")
	WebElement selectstartTime;
	
	public void inputStartTime(String start) {
		selectStartTime.click();
		StartTime.sendKeys(start);
		selectstartTime.click();
	}
	
	@FindBy (xpath="//p-calendar[@formcontrolname='end_time']")
	WebElement selectEndTime;
	@FindBy (xpath="//p-calendar[@formcontrolname='end_time']//input[contains(@class, 'ng-tns-')]")
	WebElement endTime;
	@FindBy (xpath="//p-calendar[@formcontrolname='end_time']//button[contains(@class, 'ng-tns-')]")
	WebElement selectendTime;
	
	
	public void inputEndTime(String end) {
		selectEndTime.click();
		endTime.sendKeys(end);
		selectendTime.click();
	}
	
	@FindBy(xpath="//div[@class='p-element p-multiselect-label-container']")
	WebElement clickOnMeetingMember;
	@FindBy(xpath="//div[@class='p-checkbox p-component ng-star-inserted']")
	WebElement clickInput;
	@FindBy(xpath="//input[@class='p-multiselect-filter p-inputtext p-component']")
	WebElement txtMeetingMember;
	@FindBy(xpath="//p-multiselectitem[@class='p-element ng-star-inserted']")
	WebElement selectMeetingMember;
	
	public void meetingMemeber() {
		clickOnMeetingMember.click();
		clickInput.click();
		//clickOnMeetingMember.sendKeys(name);
		//clickOnMeetingMember.click();
	}
	
	@FindBy(xpath="//button[@label='Save']")
	WebElement save;
	
	public void clickSave() {
		save.click();
	}
}
