package com.befreebdms.qa.workflow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.ITTicketPage;
import com.bdms.qa.utils.Utilities;

public class ITTicket extends Base {

	public ITTicket() {

		super(); // This method will get the all properties from Base class

	}

	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] SupplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcel("ITTicketITIssue");
		return data;

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		// driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); // from get properties field

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("nagnathg");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		homePage.clickOnWorkflow();
		homePage.clickOnITTicket();
	}

	@AfterMethod
	public void tearDown() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}

	// @Test (priority=1, dataProvider="validCredentialsSupplier")

	// public void verifyTypeMasterwithITIssue(String TypeName) throws
	// InterruptedException {
	@Test(priority = 1)
	public void verifyTypeMasterwithITIncident() throws InterruptedException {

		ITTicketPage ITticket = new ITTicketPage(driver);
		ITticket.clickOnQuickAction();
		ITticket.clickOnSubType();
		ITticket.clickOnAddRecord();
		ITticket.clickOnSelectMaster("IT Incident");

		// Generate a dynamic type name using a timestamp
		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		 * String uniqueTypeName = TypeName + LocalDateTime.now().format(formatter);
		 * 
		 * ITticket.inputTypename(uniqueTypeName);
		 * //ITticket.inputTypename("IT Issue"+"Test12:52");
		 */
		ITticket.clickOnAdd();

	}

	@Test(priority = 2, dataProvider = "validCredentialsSupplier")
	public void verifyTypeMasterwithITServiceRequest(String TypeName) throws InterruptedException {

		ITTicketPage ITticket = new ITTicketPage(driver);
		ITticket.clicktypeMaster();
		ITticket.clickOnAddRecord();
		ITticket.clickOnSelectMaster("IT Service Request");

		// Generate a dynamic type name using a timestamp
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String uniqueTypeName = TypeName + LocalDateTime.now().format(formatter);

		ITticket.inputTypename(uniqueTypeName);
		ITticket.clickOnAdd();
	}

	@Test(priority = 3, dataProvider = "validCredentialsSupplier")
	public void verifySubTypewithITIssue(String SubTypeName) throws InterruptedException {

		ITTicketPage ITticket = new ITTicketPage(driver);
		ITticket.clickOnSubType();
		ITticket.clickOnAddRecord();
		ITticket.selectMasterName("IT Incident");
		Thread.sleep(500);
		ITticket.clickOnTypeName("Google WorkSpace");
		Thread.sleep(500);
		// Generate a dynamic type name using a timestamp
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String uniqueTypeName = SubTypeName + LocalDateTime.now().format(formatter);
		ITticket.inputSubTypeName(uniqueTypeName);
		Thread.sleep(500);
		ITticket.selectApprovaltype("N/A");
		Thread.sleep(500);
		ITticket.clickOnAdd();

	}

}
