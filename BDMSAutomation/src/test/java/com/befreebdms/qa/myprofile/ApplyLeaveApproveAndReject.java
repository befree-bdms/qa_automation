package com.befreebdms.qa.myprofile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyLeavesPage;

public class ApplyLeaveApproveAndReject extends Base{
	
	public ApplyLeaveApproveAndReject() {
		
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
	Thread.sleep(2000);
	homePage.clickOnMyProfile();	
	homePage.clickOnMyLeaves();
	
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	@Test 
	public void verifyApproveLeave() throws InterruptedException {
		
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		myLeavesPage.applyEmployeeNameFileter("Darshan Trivedi");
		/*myLeavesPage.applyLeaveTypeFilter("Sick");
		myLeavesPage.clickOnStartDateCalendar();
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnEndDateCalendar();
		selectDateIncalendar("15", "October", "2025");*/
		myLeavesPage.clickOnEdit();
		myLeavesPage.addComment("Approved By DP");
		myLeavesPage.clickOnApprove();
		
		
	}
}
