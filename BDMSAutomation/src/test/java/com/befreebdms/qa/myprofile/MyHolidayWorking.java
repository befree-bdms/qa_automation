package com.befreebdms.qa.myprofile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyHolidayWorkingPage;

public class MyHolidayWorking extends Base {

	public MyHolidayWorking() {
		super();
	}

	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		// driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); // from get properties field
		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Ajay");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(1000);
		homePage.clickOnMyProfile();
		homePage.clickOnMyHolidayWorking();

	}

	@AfterMethod
	public void tearDown() {

		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();

	}

	@Test(priority = 1)
	public void verifyAddRecordForHolidayWorking() throws InterruptedException {

		MyHolidayWorkingPage myHolidayWorkingPage = new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.clickOnAddRecord();
		myHolidayWorkingPage.selectLocation("Baroda");
		Thread.sleep(1000);
		myHolidayWorkingPage.selectHolidayDate();
		Thread.sleep(1000);
		selectDateIncalendar("15", "August", "2024");
		myHolidayWorkingPage.selectEstimatedArrivalTime("20:00");
		myHolidayWorkingPage.selectEstimatedDepartureTime("05:00");
		myHolidayWorkingPage.selectTradingName("be FREE Pty Limited");
		myHolidayWorkingPage.enterReasonForHolidayWorking("Test by Nagnath");
		myHolidayWorkingPage.saveHolidayWorking();
	}

	@Test(priority = 2)
	public void verifyDeleteRecordHolidayWorking() throws InterruptedException {

		MyHolidayWorkingPage myHolidayWorkingPage = new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.applyEmployeeNameFileter("Darshan Trivedi");
		myHolidayWorkingPage.deleteRequest();

	}

	@Test(priority = 1)
	public void verifyAddRecordrHolidayWorking() throws InterruptedException {

		MyHolidayWorkingPage myHolidayWorkingPage = new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.clickOnAddRecord();
		myHolidayWorkingPage.selectLocation("Sez - brigade");
		Thread.sleep(100);
		myHolidayWorkingPage.selectHolidayDate();
		Thread.sleep(200);
		selectDateIncalendar("18", "August", "2025");
		myHolidayWorkingPage.selectEstimatedArrivalTime("22:00");
		myHolidayWorkingPage.selectEstimatedDepartureTime("05:00");
		myHolidayWorkingPage.selectTradingName("be FREE Pty Limited");
		myHolidayWorkingPage.enterReasonForHolidayWorking("Test by Nagnath");
		myHolidayWorkingPage.saveHolidayWorking();
	}

}
