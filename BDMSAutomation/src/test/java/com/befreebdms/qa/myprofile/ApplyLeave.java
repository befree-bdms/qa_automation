package com.befreebdms.qa.myprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyLeavesPage;

public class ApplyLeave extends Base {

	// To get the properties file from config.properties
	public ApplyLeave() {
		super(); // This method will get the all properties from Base class
	}

	public WebDriver driver;
	// SoftAssert softAssert=new SoftAssert();

	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		// driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); // from get properties field

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("darshant");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		homePage.clickOnMyProfile();
		homePage.clickOnMyLeaves();
		MyLeavesPage myLeavesPage = new MyLeavesPage(driver);
		myLeavesPage.clickOnApplyLeave();
	}

	@AfterMethod
	public void tearDown() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyApplyCasualLeave() throws InterruptedException {

		MyLeavesPage myLeavesPage = new MyLeavesPage(driver);
		myLeavesPage.clickOnLeaveType("Casual");
		Thread.sleep(100);
		myLeavesPage.clickOnFromDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(100);
		myLeavesPage.clickOnToDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(100);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();

		String msg = driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}

	@Test(priority = 2)
	public void verifyApplyCompOffLeave() throws InterruptedException {

		MyLeavesPage myLeavesPage = new MyLeavesPage(driver);

		myLeavesPage.clickOnLeaveType("Comp-off");
		Thread.sleep(100);
		myLeavesPage.clickOnFromDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(100);
		myLeavesPage.clickOnToDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(100);
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(100);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();

		String msg = driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}

	@Test(priority = 3)
	public void verifyApplySickLeave() throws InterruptedException {

		MyLeavesPage myLeavesPage = new MyLeavesPage(driver);

		myLeavesPage.clickOnLeaveType("Sick");
		Thread.sleep(100);
		myLeavesPage.clickOnFromDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2024");
		Thread.sleep(100);
		myLeavesPage.clickOnToDate();
		Thread.sleep(100);
		selectDateIncalendar("18", "October", "2024");
		Thread.sleep(100);
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(100);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();

		String msg = driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}

	@Test(priority = 4)
	public void verifyApplyMaternityLeave() throws InterruptedException {

		MyLeavesPage myLeavesPage = new MyLeavesPage(driver);

		myLeavesPage.clickOnLeaveType("Maternity");
		Thread.sleep(100);
		myLeavesPage.clickOnFromDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(200);
		myLeavesPage.clickOnToDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		Thread.sleep(200);
		myLeavesPage.clickOnInformTeamIncharge("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnWeeklyTaskList("No");
		Thread.sleep(100);
		myLeavesPage.clickOnWasThereAnythingDue("Yes");
		Thread.sleep(100);
		myLeavesPage.clickOnIfDue("Test");
		myLeavesPage.clickOnReasonForLeave("Test By Nagnath");
		myLeavesPage.clickOnSave();

		String msg = driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
	}

	/*
	 * @Test (priority=4) public void verifyLeaveTracker() {
	 * 
	 * driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
	 * driver.findElement(By.xpath("//span[text()='My Leaves']")).click();
	 * 
	 * driver.findElement(By.
	 * xpath("//button[@label='Leave Trackers']/span[text()='Leave Trackers']")).
	 * click();
	 * 
	 * softAssert.assertTrue(driver.findElement(By.xpath(
	 * "//span[text()='bdmsdeveloper@befree.com.au']")).isDisplayed(),
	 * "bdmsdeveloper@befree.com.au Not Display on the Leave Tracker");
	 * softAssert.assertAll(); }
	 */

}
