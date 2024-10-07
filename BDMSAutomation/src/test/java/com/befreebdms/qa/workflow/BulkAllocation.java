package com.befreebdms.qa.workflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.BulkAllocationPage;
import com.bdms.qa.pageobject.HomePage;

public class BulkAllocation extends Base{
	
	public BulkAllocation() {
		
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
	homePage.clickOnBulkAllocation();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	
	@Test (priority=1)
 	public void verifyBulkAllocation() throws InterruptedException{
	
		
		BulkAllocationPage BulkAllocation= new BulkAllocationPage(driver);
		BulkAllocation.clickAllocateUser("Rahul patel");
		BulkAllocation.clickClientList();
		BulkAllocation.clickReAllocateUser("Nagnath Gejage");
		BulkAllocation.clickServices();
		BulkAllocation.Save();
		
		
	}
	
	@Test (priority=2)
 	public void verifyBulkAllocation2() throws InterruptedException{
	
		
		BulkAllocationPage BulkAllocation= new BulkAllocationPage(driver);
		BulkAllocation.clickAllocateUser("Nagnath Gejage");
		BulkAllocation.clickClientList();
		BulkAllocation.clickReAllocateUser("Rahul Patel");
		BulkAllocation.clickServices();
		BulkAllocation.Save();
		
		
	}
	
	@Test (priority=3)
 	public void verifyBulkDeAllocation() throws InterruptedException{
	
		
		BulkAllocationPage BulkAllocation= new BulkAllocationPage(driver);
		BulkAllocation.ClickBulkDeallocation();
		BulkAllocation.ClickDeallocateUser("Nagnath Gejage");
		BulkAllocation.clickClientList();
		BulkAllocation.clickServices();
		BulkAllocation.Save();
		
		
	}

}
