package com.befreebdms.qa.myprofile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyHolidayWorkingPage;
import com.bdms.qa.pageobject.MyLeavesPage;

public class ApproveAndReject extends Base{
	
	public ApproveAndReject() {
		
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
	homePage.setUserName("dilip");
	homePage.setPassword("123456");
	homePage.clickLogin();
	PopupHandler();
	Thread.sleep(1000);
	homePage.clickOnMyProfile();	
	
	
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifyApproveLeave() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyLeaves();
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		myLeavesPage.applyEmployeeNameFileter("Darshan Trivedi");
		myLeavesPage.clickOnEdit();
		myLeavesPage.addComment("Approved By DP");
		myLeavesPage.clickOnApprove();
	
	}
	
	@Test (priority=2)
 	public void verifyPendingforFirstApproveHolidayWorking() throws InterruptedException {
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyHolidayWorking();
		MyHolidayWorkingPage myHolidayWorkingPage=new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.applyEmployeeNameFileter("Darshan Trivedi");
		myHolidayWorkingPage.clickOnFirstApporve();
		myHolidayWorkingPage.inputFirstApproveComment("Test Approve");
		myHolidayWorkingPage.clickOnApprove();
		
	}
	
	@Test (priority=3)
 	public void verifyPendingforSecondApproveHolidayWorking() throws InterruptedException {
	
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyHolidayWorking();
		MyHolidayWorkingPage myHolidayWorkingPage=new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.applyEmployeeNameFileter("Darshan Trivedi");
		myHolidayWorkingPage.clickOnFirstApporve();
		myHolidayWorkingPage.inputFirstApproveComment("Test Approve");
		myHolidayWorkingPage.clickOnApprove();
	}
	
	
}
