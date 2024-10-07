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

public class PendingTicket extends Base{
	
	public PendingTicket() {
		
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
	homePage.setUserName("pankajn");
	homePage.setPassword("123456");
	homePage.clickLogin();
	PopupHandler();
	Thread.sleep(2000);
	homePage.clickOnWorkflow();
	homePage.PendingTicket();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	
	@Test (priority=1)
 	public void verifyPendingTicket() throws InterruptedException{
	
		
		PendinTicketPage PendinTicket=new PendinTicketPage(driver);
		PendinTicket.clickAddTicket();
		
		
		Set<String>windowIDs =driver.getWindowHandles();
		List<String> windowIDsList=new ArrayList(windowIDs);
		
		for(String windowsId:windowIDsList) {
			
			String title=driver.switchTo().window(windowsId).getTitle();
			System.out.println(title);
		}
		
		
		PendinTicket.ticketType("Issue - Befree");
		Thread.sleep(1000);		
		PendinTicket.inputSubject("Test Issue Befree");
		Thread.sleep(1000);
		PendinTicket.inputDescription("Test Issue Befree");
		Thread.sleep(1000);
		PendinTicket.reasonOccurred("Test Issue Befree");
		Thread.sleep(1000);
		PendinTicket.setStaus("Ticket raised");
		Thread.sleep(1000);
		PendinTicket.setParentTradingName("Worldwide Printing Taren Point");
		Thread.sleep(1000);
		PendinTicket.setClientName("Crossover Symmetry Australia");
		Thread.sleep(1000);
		PendinTicket.setTeam("Billing");
		Thread.sleep(1000);
		PendinTicket.setService("IAS");
		Thread.sleep(1000);
		PendinTicket.setTypeOfMistake("Email response delay");
		Thread.sleep(1000);
		PendinTicket.setIsThisProblemOnOurSide("Yes");
		Thread.sleep(1000);
		PendinTicket.setStaffInvolvedInIssue("Rahul Patel");
		Thread.sleep(1000);
		PendinTicket.setCategoryOfMistakeName("Medium");
		
		Thread.sleep(2000);
			
		
		PendinTicket.setActionRequiredDetails("Test123456");
		//Thread.sleep(5000);
		//PendinTicket.setAssignStaff("pankaj nahar");
		Thread.sleep(2000);
		PendinTicket.addAssignStaff("Test2323");
		Thread.sleep(1000);
		
		
		//Thread.sleep(2000);
		PendinTicket.addComment("Test Done");
		
		Thread.sleep(2000);
		PendinTicket.clkOnSave();
		
	}	

}
