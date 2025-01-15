package com.befreebdms.qa.hr;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HRPage;
import com.bdms.qa.pageobject.HomePage;

public class AttendanceSummary extends Base {

	public AttendanceSummary() {

		super(); // This method will get the all properties from Base class

	}

	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		// driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); // from get properties field

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		/*
		 * HomePage homePage=new HomePage(driver); Thread.sleep(1000);
		 * homePage.clickOnLogout(); Thread.sleep(1000);
		 */

		driver.quit();
	}

	@Test(priority = 1)
	public void verifyAddInOut() throws InterruptedException {

		// Step 1: Login and navigate to Attendance Summary
		HomePage homePage = new HomePage(driver);
		homePage.setUserName("chetan");
		homePage.setPassword("123456");

		homePage.clickLogin();
		Thread.sleep(500);
		PopupHandler();
		homePage.clickHR();
		Thread.sleep(1000);
		homePage.clickOnHRMSDashboard();
		Thread.sleep(500);

		// Step 2: Use HRPage methods for filtering and processing entries
		HRPage HrPage = new HRPage(driver);
		HrPage.checkAndClickMissingInOut();
		Thread.sleep(500);
		// HrPage.clickStaffName("Nagnath Gejage");
		// Thread.sleep(1000);
		// HrPage.applyFilters("Leave");
		// HrPage.verifyFinalRemark();
		Thread.sleep(500);
		HrPage.clickOnAddOutTime();
		Thread.sleep(500);
		HrPage.changeInOutwindow("18:00");
		Thread.sleep(500);
		HrPage.inputReason("Test By Nagnath");
		Thread.sleep(500);
		HrPage.clickOnSubmit();
		Thread.sleep(500);
	}

	@Test(priority = 2)
	public void verifyApproveByFirstApproval() throws InterruptedException {

		// Step 1: Login and navigate to Attendance Summary
		HomePage homePage = new HomePage(driver);
		homePage.setUserName("darshant");
		homePage.setPassword("123456");

		homePage.clickLogin();
		Thread.sleep(500);
		PopupHandler();
		homePage.clickHR();
		Thread.sleep(500);
		homePage.clickOnChangeInOut();
		Thread.sleep(500);

		// Step 2: Use HRPage methods for filtering and processing entries
		HRPage HrPage = new HRPage(driver);
		HrPage.clickOnApprove();
		Thread.sleep(500);
		HrPage.firstApprovalComment("Test by Pankaj Mam");
		Thread.sleep(500);
		HrPage.clickApproval();

		Thread.sleep(500);

	}

	@Test(priority = 3)
	public void verifyApproveBySecondApproval() throws InterruptedException {

		// Step 1: Login and navigate to Attendance Summary
		HomePage homePage = new HomePage(driver);
		homePage.setUserName("dilip");
		homePage.setPassword("123456");

		homePage.clickLogin();
		Thread.sleep(500);
		PopupHandler();
		homePage.clickHR();
		Thread.sleep(500);
		homePage.clickOnChangeInOut();
		Thread.sleep(500);

		// Step 2: Use HRPage methods for filtering and processing entries
		HRPage HrPage = new HRPage(driver);
		HrPage.clickOnApprove();
		Thread.sleep(500);
		HrPage.firstApprovalComment("Test by Vasant Sir");
		Thread.sleep(500);
		HrPage.clickApproval();

		Thread.sleep(500);

	}

	@Test(priority = 4)
	public void verifyAddTimesheet() throws InterruptedException {

		// Step 1: Login and navigate to Attendance Summary
		HomePage homePage = new HomePage(driver);
		homePage.setUserName("chetan");
		homePage.setPassword("123456");

		homePage.clickLogin();
		Thread.sleep(500);
		PopupHandler();
		homePage.clickHR();
		Thread.sleep(500);
		homePage.clickOnHRMSDashboard();
		Thread.sleep(500);

		// Step 2: Use HRPage methods for filtering and processing entries
		HRPage HrPage = new HRPage(driver);
		HrPage.checkAndClickMissingTimesheet();
		Thread.sleep(1000);
		HrPage.clickOnClearFilter();
		Thread.sleep(1000);
		HrPage.clickOnFilter();
		HrPage.applyFilters("Leave");
		// Thread.sleep(5000);
		HrPage.clickOnAddTimesheet();
		Thread.sleep(500);
		HrPage.clickOntradingName("be FREE Pty Limited");
		Thread.sleep(500);
		HrPage.clickOnMasterActivity("IT Web Development");
		Thread.sleep(500);
		HrPage.clickOnTask("Web Development General");
		Thread.sleep(500);
		HrPage.clickOnFrequency("Yearly");
		Thread.sleep(500);
		HrPage.clickOnPeriod("01-07-2022 To 30-06-2023");
		Thread.sleep(500);
		HrPage.clickOnSubActivity("1024-Server setup / Upload / Testing");
		Thread.sleep(500);
		HrPage.AddUnit("80");
		Thread.sleep(500);
		HrPage.AddNote("Test Only");
		Thread.sleep(500);
		HrPage.AddReason("Test by Nagnath");
		Thread.sleep(500);
		HrPage.clickOnSendForApproval();

	}

}
