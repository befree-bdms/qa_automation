package com.befreebdms.qa.workflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.ClientPage;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.WorksheetPage;
import com.bdms.qa.utils.Utilities;

public class AddWorksheet extends Base {

	public AddWorksheet() {

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

	@DataProvider(name = "clientList")
	public Object[][] SupplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcel("ClientTest");
		return data;

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		/*
		 * HomePage homePage=new HomePage(driver); Thread.sleep(1000);
		 * homePage.clickOnLogout(); Thread.sleep(1000);
		 */

		driver.quit();
	}

	@Test(priority = 3, dataProvider = "clientList")
	public void verifyApplicableFlagwithBookkeeping(String client, String MasterAct, String TaskName)
			throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("admin");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(1500);
		homePage.clickOnWorkflow();
		Thread.sleep(1500);
		homePage.clickWorksheet();
		Thread.sleep(1500);
		WorksheetPage worksheet = new WorksheetPage(driver);
		worksheet.clickAddWoksheet();
		Thread.sleep(1500);
		worksheet.tradingName(client);
		Thread.sleep(1500);
		worksheet.masterActivity(MasterAct);
		Thread.sleep(1500);
		worksheet.setTask(TaskName);
		Thread.sleep(1500);
		worksheet.setCriticalTask("No");
		Thread.sleep(1500);
		worksheet.clickStartDate();
		Thread.sleep(1500);
		selectDateIncalendar("1", "November", "2024");
		Thread.sleep(1500);
		worksheet.clickEndDate();
		Thread.sleep(1500);
		selectDateIncalendar("25", "November", "2024");
		Thread.sleep(1500);
		worksheet.setFrequency("Weekly");
		Thread.sleep(1500);
		worksheet.setDay("Monday");
		Thread.sleep(1000);
		worksheet.clickAfterDay();
		Thread.sleep(1500);
		worksheet.clickAfterDays("-2");
		Thread.sleep(1500);
		worksheet.addNotes("Test Worksheet");
		Thread.sleep(1500);
		worksheet.clickSaveandNext();
		worksheet.getIndexCount();
		Thread.sleep(2000);
		worksheet.clickcreateWorksheet();
		Thread.sleep(2000);
		/*
		 * worksheet.ClickFileterStartDate(); Thread.sleep(1500);
		 * selectDateIncalendar("1", "November", "2024"); Thread.sleep(1500);
		 * worksheet.clickFileterEndtDate(); selectDateIncalendar("25", "November",
		 * "2024"); Thread.sleep(1500); worksheet.clickFilterClientName(client);
		 * Thread.sleep(1500);
		 * 
		 * worksheet.checklistIcon(); Thread.sleep(1500); worksheet.checkEditIcon();
		 * Thread.sleep(1000);
		 */
	}

	@Test(priority = 1)
	public void verifyApplicableFlag() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("vasant");
		homePage.setPassword("123456");
		homePage.clickLogin();
		Thread.sleep(3000);
		PopupHandler();
		Thread.sleep(3000);
		homePage.clickOnWorkflow();
		Thread.sleep(3000);
		homePage.clickWorksheet();
		Thread.sleep(3000);
		WorksheetPage worksheet = new WorksheetPage(driver);
		worksheet.clickAddWoksheet();
		Thread.sleep(2000);
		worksheet.tradingName("ERATOS (AUST) PTY LTD");
		Thread.sleep(2000);
		worksheet.masterActivity("Bookkeeping");
		Thread.sleep(2000);
		worksheet.setTask("Bookkeeping Processing");
		Thread.sleep(3000);
		worksheet.setCriticalTask("No");
		Thread.sleep(2000);
		worksheet.clickStartDate();
		selectDateIncalendar("1", "October", "2024");
		Thread.sleep(2000);
		worksheet.clickEndDate();
		selectDateIncalendar("31", "December", "2024");
		Thread.sleep(2000);
		worksheet.setFrequency("Weekly");
		Thread.sleep(2000);
		worksheet.setDay("Friday");
		Thread.sleep(2000);
		worksheet.clickAfterDay();
		Thread.sleep(2000);
		worksheet.clickAfterDays("-3");
		Thread.sleep(2000);
		worksheet.addNotes("Test Preparation of Super Report");
		Thread.sleep(2000);
		worksheet.clickSaveandNext();
		Thread.sleep(2000);
		worksheet.getIndexCount();
		Thread.sleep(2000);
		worksheet.clickcreateWorksheet();
		Thread.sleep(2000);

		worksheet.ClickFileterStartDate();
		selectDateIncalendar("1", "October", "2024");
		Thread.sleep(2000);
		worksheet.clickFileterEndtDate();
		selectDateIncalendar("31", "December", "2024");
		Thread.sleep(2000);
		worksheet.clickFilterClientName("ERATOS (AUST) PTY LTD");
		Thread.sleep(2000);
		worksheet.checklistIcon();
		Thread.sleep(2000);
		worksheet.checkEditIcon();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void turnOnApplicableFlag() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("vasant");
		homePage.setPassword("123456");
		homePage.clickLogin();
		Thread.sleep(1000);
		PopupHandler();
		Thread.sleep(1000);
		homePage.clickClient();
		Thread.sleep(2000);

		homePage.clickClientList();
		ClientPage client = new ClientPage(driver);
		Thread.sleep(1000);
		client.clickFilter();
		Thread.sleep(1000);
		// client.clientCode("ALOTCOTU");

		Thread.sleep(1000);
		client.billingName("ERATOS (AUST) PTY LTD");
		Thread.sleep(1000);
		// client.legalName("ERATOS (AUST) PTY LTD");
		Thread.sleep(1000);
		client.clickEdit();
		Thread.sleep(1000);
		client.clickClientChecklist();
		Thread.sleep(1000);
		client.clickSearch("Bookkeeping");
		Thread.sleep(1000);
		client.clickOptionApplicable();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void verifyApplicableFlagfordifferentClient() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("vasant");
		homePage.setPassword("123456");
		homePage.clickLogin();
		Thread.sleep(1000);
		PopupHandler();
		Thread.sleep(1000);
		homePage.clickOnWorkflow();
		Thread.sleep(1000);
		homePage.clickWorksheet();

		WorksheetPage worksheet = new WorksheetPage(driver);
		Thread.sleep(1000);
		worksheet.clickOnIncompleteWorksheet();
		Thread.sleep(1000);

		worksheet.ClickFileterStartDate();
		selectDateIncalendar("1", "October", "2024");
		Thread.sleep(1000);
		worksheet.clickFileterEndtDate();
		selectDateIncalendar("31", "December", "2024");
		Thread.sleep(1000);
		worksheet.clickFilterClientName("ERATOS (AUST) PTY LTD");
		Thread.sleep(1000);
		worksheet.clickOnMCheckList("Bookkeeping");
		Thread.sleep(1000);

		worksheet.checklistIcon();
		Thread.sleep(1000);

		// worksheet.checkEditIcon();
		// Thread.sleep(2000);

		worksheet.deleteworksheet();

		Thread.sleep(6000);

	}

}
