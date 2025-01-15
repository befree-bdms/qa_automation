package com.befreebdms.qa.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.PendinTicketPage;

public class PendingTicket extends Base {

	public PendingTicket() {

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
	public void tearDown() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyPendingTicketForIssueBefree() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Sivanisilpam");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.ticketType("Issue - Befree");

		PendinTicket.inputSubject("Test Issue Befree");

		PendinTicket.inputDescription("Test Issue Befree");

		PendinTicket.reasonOccurred("Test Issue Befree");

		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(500);
		PendinTicket.setParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(500);
		PendinTicket.setClientName("Appleyard Group Pty Ltd (ZG Services)");
		Thread.sleep(500);
		PendinTicket.setTeam("Billing");
		Thread.sleep(500);
		PendinTicket.setService("IAS");
		Thread.sleep(500);
		PendinTicket.setTypeOfMistake("Email response delay");
		Thread.sleep(500);
		PendinTicket.setIsThisProblemOnOurSide("Yes");
		Thread.sleep(3000);
		PendinTicket.uploadFile();
		Thread.sleep(2000);
		PendinTicket.setStaffInvolvedInIssue("Purvesh Shah");
		Thread.sleep(500);
		PendinTicket.setCategoryOfMistakeName("Medium");
		Thread.sleep(1000);
		PendinTicket.setActionRequiredDetails("Test123456");
		Thread.sleep(1000);
		PendinTicket.setAssignStaff1("Purvesh Shah");
		Thread.sleep(1000);

		PendinTicket.addComment("Test Done");
		// Thread.sleep(1000);
		PendinTicket.clkOnSave();

	}

	@Test(priority = 2)
	public void verifyPendingTicketForInternalBefree() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Sivanisilpam");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.ticketType("Internal - Befree");

		PendinTicket.inputSubject("Test  Internal - Befree");

		PendinTicket.inputDescription("Test  Internal - Befree");

		PendinTicket.reasonOccurred("Test  Internal - Befree");

		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(500);
		PendinTicket.setParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(500);
		PendinTicket.setClientName("Asinus Group Pty Ltd ATF Asinus Trust");
		Thread.sleep(500);
		PendinTicket.setTeam("Billing");
		Thread.sleep(500);
		PendinTicket.setService("IAS");
		Thread.sleep(500);
		PendinTicket.setTypeOfMistake("Email response delay");
		Thread.sleep(500);
		PendinTicket.setIsThisProblemOnOurSide("Yes");
		Thread.sleep(500);
		PendinTicket.uploadFile();
		Thread.sleep(500);
		PendinTicket.setStaffInvolvedInIssue("Purvesh Shah");
		Thread.sleep(500);
		PendinTicket.setCategoryOfMistakeName("Medium");
		Thread.sleep(1000);
		PendinTicket.setActionRequiredDetails("Test123456");
		Thread.sleep(1000);
		PendinTicket.setAssignStaff1("Purvesh Shah");
		Thread.sleep(1000);
		PendinTicket.addComment("Test Done");

		PendinTicket.clkOnSave();

	}

	@Test(priority = 3)
	public void verifyPendingTicketForBillingBefree() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Sivanisilpam");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.ticketType("Billing - Befree");

		PendinTicket.inputSubject("Test  Billing - Befree");

		PendinTicket.inputDescription("Test Billing - Befree");

		PendinTicket.reasonOccurred("Test  Billing - Befree");

		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(500);
		PendinTicket.setParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(500);
		PendinTicket.setClientName("Coesha Park");
		Thread.sleep(500);

		PendinTicket.setIsThisProblemOnOurSide("Yes");
		Thread.sleep(500);
		PendinTicket.uploadFile();
		Thread.sleep(500);
		PendinTicket.setStaffInvolvedInIssue("Purvesh Shah");
		Thread.sleep(500);
		PendinTicket.setCategoryOfMistakeName("Medium");
		Thread.sleep(1000);
		PendinTicket.setActionRequiredDetails("Test123456");
		Thread.sleep(1000);
		PendinTicket.setAssignStaff1("Purvesh Shah");
		Thread.sleep(1000);

		PendinTicket.addComment("Test Done");
		// Thread.sleep(1000);
		PendinTicket.clkOnSave();

	}

	@Test(priority = 4)
	public void verifyPendingTicketForAppraisalBefree() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Sivanisilpam");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.ticketType("Appraisal - Befree");

		PendinTicket.inputSubject("J56656 - Didn't receive the Job type change notification");

		PendinTicket.inputDescription("Imagine Accounting - Practice submitted Accounts");

		Thread.sleep(500);
		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(500);
		PendinTicket.setParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(500);
		PendinTicket.setClientName("BIM Surveys Pty Ltd");
		Thread.sleep(500);
		PendinTicket.setTeam("Billing");
		Thread.sleep(500);
		PendinTicket.setService("IAS");
		Thread.sleep(500);

		PendinTicket.setActionRequiredDetails("Test123456");
		Thread.sleep(1000);
		PendinTicket.setAssignStaff1("Purvesh Shah");
		Thread.sleep(1000);

		PendinTicket.addComment("Test Done");
		// Thread.sleep(1000);
		PendinTicket.clkOnSave();

	}

	@Test(priority = 5)
	public void verifyPendingTicketForITDevelopmentBDMS() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("Sivanisilpam");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.ticketType("IT Development -BDMS");
		Thread.sleep(3000);
		PendinTicket.setTicketPriority("Low");
		Thread.sleep(1000);
		PendinTicket.selectTicketTracker("Bug");
		Thread.sleep(500);

		PendinTicket.inputSubject("Test  IT Development -BDMS");
		Thread.sleep(500);
		PendinTicket.inputDescription("Test IT Development -BDMS");
		Thread.sleep(500);
		PendinTicket.reasonOccurred("Test  IT Development -BDMS");
		Thread.sleep(500);
		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(500);

		PendinTicket.setActionRequiredDetails("Test123456");
		Thread.sleep(1000);
		PendinTicket.setAssignStaff1("Purvesh Shah");
		Thread.sleep(1000);

		PendinTicket.addComment("Test Done");
		// Thread.sleep(1000);
		PendinTicket.clkOnSave();

	}

	@Test(priority = 6)
	public void moveTicketRaisedToInProgress() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("admin");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickTicketRaised();
		Thread.sleep(3000);
		PendinTicket.clickOnParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(3000);
		PendinTicket.clickOnEdit();
		Thread.sleep(3000);

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.setStaus("In progress");

		Thread.sleep(1000);
		PendinTicket.uploadFile();
		Thread.sleep(1000);

		PendinTicket.clickOnCompletionDate();
		Thread.sleep(5000);

		PendinTicket.addAssignStaff();
		Thread.sleep(5000);

		PendinTicket.setActionRequiredDetails2("Test inprogress");
		Thread.sleep(5000);

		PendinTicket.setAssignStaff2("Bhaumik Shah");
		Thread.sleep(1000);

		PendinTicket.addComment("test inprogress");
		Thread.sleep(1000);

		PendinTicket.clkOnSave();

	}

	@Test(priority = 6)
	public void moveinProgresstoSentForApproval() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.setUserName("admin");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnWorkflow();
		homePage.PendingTicket();

		PendinTicketPage PendinTicket = new PendinTicketPage(driver);
		PendinTicket.clickInProgress();
		Thread.sleep(3000);
		PendinTicket.clickOnParentTradingName("Fortview Group Pty Ltd (Superrecords)");
		Thread.sleep(3000);
		PendinTicket.clickOnEdit();
		Thread.sleep(3000);

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList(windowIDs);

		for (String windowsId : windowIDsList) {

			String title = driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}

		PendinTicket.setStaus("Sent for approval");

		Thread.sleep(1000);
		PendinTicket.uploadFile();
		Thread.sleep(1000);

		PendinTicket.clickOnCompletionDate();
		Thread.sleep(5000);

		PendinTicket.addAssignStaff();
		Thread.sleep(5000);

		PendinTicket.setActionRequiredDetails2("Test inprogress");
		Thread.sleep(5000);

		PendinTicket.setAssignStaff3("Dilip Parmar");
		Thread.sleep(1000);

		PendinTicket.addComment("test Send For Approval");
		Thread.sleep(1000);

		// PendinTicket.clkOnSave();

	}

}
