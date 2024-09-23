package com.befreebdms.qa.workflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.ConferenceRoomPage;
import com.bdms.qa.pageobject.HomePage;

public class ConferenceRoom extends Base{

	public ConferenceRoom() {
		
		super();  //This method will get the all properties from Base class
	
	}
	
	public WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	


	@BeforeMethod
	public void setUp() throws InterruptedException {
	
	driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
	//driver.get("http://10.10.20.41/auth/login");
	driver.get(prop.getProperty("url")); //from get properties field	
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName("ajay");
	homePage.setPassword("123456");
	homePage.clickLogin();
	Thread.sleep(2000);
	homePage.clickOnWorkflow();
	homePage.clickOnConferenceRoom();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	
	@Test (priority=1)
 	public void verifyBookRecord() throws InterruptedException{
	
		ConferenceRoomPage conferenceRoom=new ConferenceRoomPage(driver);
		conferenceRoom.clickOnBookRecord();
		conferenceRoom.addLocation("SEZ - brigade");
		conferenceRoom.addconferenceRoom("kailash");
		conferenceRoom.addpurposeOfBook();
		conferenceRoom.addDate();
		conferenceRoom.inputStartTime("02:00");
		conferenceRoom.inputEndTime("03:00");
		conferenceRoom.meetingMemeber();
		conferenceRoom.clickSave();		
		
	}	
}
