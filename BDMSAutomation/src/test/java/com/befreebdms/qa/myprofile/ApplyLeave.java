package com.befreebdms.qa.myprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyLeavesPage;

public class ApplyLeave extends Base{
	
	//To get the properties file from config.properties
	public ApplyLeave() {
		
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
	homePage.setUserName("darshant");
	homePage.setPassword("123456");
	homePage.clickLogin();
	Thread.sleep(2000);
	homePage.clickOnMyProfile();	
	homePage.clickOnMyLeaves();
	MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
	myLeavesPage.clickOnApplyLeave();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	
	@Test (priority=1)
 	public void verifyApplyCasualLeave() throws InterruptedException{
	
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		
		myLeavesPage.clickOnLeaveType("Casual");
		myLeavesPage.clickOnFromDate();
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(500);
		myLeavesPage.clickOnToDate();
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(500);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(500);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();
		
		
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}	
	

	
	
	/*driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Casual");

	driver.findElement(By.xpath("//span[text()='Casual']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	//-------------------------Select time for To Date------------------------------
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
	Assert.assertEquals(msg, "Successfully created");
	}
	
	*/
	
	@Test (priority=2)
 	public void verifyApplyCompOffLeave() throws InterruptedException  {
		
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		
		myLeavesPage.clickOnLeaveType("Comp-off");
		myLeavesPage.clickOnFromDate();
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(500);
		myLeavesPage.clickOnToDate();
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(500);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(500);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();
		
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	
	/*driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Comp-off");
	driver.findElement(By.xpath("//li[@aria-label='Comp-off']//span[text()='Comp-off']")).click();
	
	//------------------Select time for From Date-----------------------------------
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	//Keep waiting time for 10 second because calendar Load
	
	selectDateIncalendar("15", "October", "2024");
	
	//-------------------------Select time for To Date------------------------------
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();*/
	}
	
	@Test (priority=3)
 	public void verifyApplySickLeave() throws InterruptedException {
		
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		
		myLeavesPage.clickOnLeaveType("Sick");
		myLeavesPage.clickOnFromDate();
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(500);
		myLeavesPage.clickOnToDate();
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(500);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(500);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();
		
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}/*
	driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Sick");
	driver.findElement(By.xpath("//li[@aria-label='Sick']//span[text()='Sick']")).click();
	
	//-----------------------------Select time for From Date---------------------------------
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	
	selectDateIncalendar("24", "October", "2025");
	
	Thread.sleep(2000);
	//------------------------------Select time for To Date--------------------------------------
	
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	
	selectDateIncalendar("25", "October", "2025");
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	}*/
	
	@Test (priority=4)
	public void verifyApplyMaternityLeave() throws InterruptedException{
		
		MyLeavesPage myLeavesPage=new MyLeavesPage(driver);
		
		myLeavesPage.clickOnLeaveType("Maternity");
		myLeavesPage.clickOnFromDate();
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(500);
		myLeavesPage.clickOnToDate();
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(500);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(500);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();
		
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}
	/*
		driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
		driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Maternity");
		driver.findElement(By.xpath("//span[text()='Maternity']")).click();
		
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
		selectDateIncalendar("6", "December", "2025");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
		selectDateIncalendar("10", "December", "2025");
		
		driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
		driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
		
		driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
		driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
		driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
		}*/
	
	/*@Test (priority=4)
	public void verifyLeaveTracker() {
		
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		driver.findElement(By.xpath("//span[text()='My Leaves']")).click();
		
		driver.findElement(By.xpath("//button[@label='Leave Trackers']/span[text()='Leave Trackers']")).click();
		
		softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='bdmsdeveloper@befree.com.au']")).isDisplayed(), "bdmsdeveloper@befree.com.au Not Display on the Leave Tracker");
		softAssert.assertAll();
	}*/

}
