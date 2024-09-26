package com.befreebdms.qa.workflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.NoJobsPage;

public class NoJob extends Base {
	
	public NoJob() {
		
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
	PopupHandler();
	homePage.clickOnWorkflow();
	homePage.clickOnNoJob();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	@Test
	public void verifyNoJobs() throws InterruptedException {
		
		NoJobsPage noJob=new NoJobsPage(driver);
		noJob.clickOnAddRecord();
		noJob.inputStartTime("21:00");
		noJob.inputEndTime("06:00");
		noJob.clickSave();
		Thread.sleep(2000);
		noJob.clickOnBooked();
		noJob.clickOnYes();
	}
	

}
