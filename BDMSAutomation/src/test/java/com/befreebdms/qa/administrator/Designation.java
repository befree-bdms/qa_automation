package com.befreebdms.qa.administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.DesignationPage;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.utils.Utilities;

public class Designation extends Base{
	
	//To get the properties file from config.properties
	public Designation() {
		
		super();  //This method will get the all properties from Base class
	
	}
	
	public WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] SupplyTestData() {
		
		Object[][] data=Utilities.getTestDataFromExcel("Page_Rights");
		return data;
		
	} 	

	@BeforeMethod 
	public void setUp() throws InterruptedException {
	
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		driver.get(prop.getProperty("url")); //from get properties field	
			
		HomePage homePage=new HomePage(driver);
		homePage.setUserName("Admin");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(1000);
		homePage.Administrator();
		homePage.Designation();
	
	}
	
	@AfterMethod
	public void tearDown() {
	
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
		
	}
	
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void verifyGroupManagerRights(String page_rights) throws InterruptedException{
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Group Manager");
		Thread.sleep(100);
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		Thread.sleep(100);
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
		
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}
	
		designationPage.update();
		
	
	}
	
	@Test (priority=2, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateTechnicalHead(String page_rights) throws InterruptedException{
		
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Associate Technical Head");
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
		
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}else {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}else {
			designationPage.selectView();
		}
	
		designationPage.update();
		
	}
	
	
	@Test (priority=3, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateReviewLead(String page_rights) throws InterruptedException{
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Associate Review Lead");
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
		
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}else {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}else {
			designationPage.selectAddOrEdit();
		}
	
		designationPage.update();
		
	}
	
	@Test (priority=4, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateQCLead(String page_rights) throws InterruptedException{
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Associate QC Lead");
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
		
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}else {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}else {
			designationPage.selectAddOrEdit();
		}
	
		designationPage.update();
		
	
	}
	
	@Test (priority=5, dataProvider="validCredentialsSupplier")
 	public void verifyTechnicalHead(String page_rights) throws InterruptedException{
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Technical Head");
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
	
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}else {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}else {
			designationPage.selectAddOrEdit();
		}
	
		designationPage.update();
	
	}
	
	@Test (priority=6, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateQCManager(String page_rights) throws InterruptedException{
		
		DesignationPage designationPage=new DesignationPage(driver);
		designationPage.clickOnFilter();
		designationPage.inputDesignationName("Associate QC Manager");
		designationPage.editDesignationName();
		designationPage.clickRights(page_rights);
		
		WebElement chkBoxView=driver.findElement(By.id("selectAllIsView"));
	
		if(!chkBoxView.isSelected()) {
			designationPage.selectView();
		}else {
			designationPage.selectView();
		}
		
		WebElement chkBoxAddEdit=driver.findElement(By.id("selectAllIsAddEdit"));
		
		if(!chkBoxAddEdit.isSelected()) {
			designationPage.selectAddOrEdit();
		}else {
			designationPage.selectAddOrEdit();
		}
	
		designationPage.update();
		
		
	}
	
	
	
}
