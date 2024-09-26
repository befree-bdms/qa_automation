package com.befreebdms.qa.administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.FoodMasterPage;
import com.bdms.qa.pageobject.HomePage;

public class FoodMaster extends Base {
	
	public FoodMaster() {
		
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
	homePage.setUserName("admin");
	homePage.setPassword("123456");
	homePage.clickLogin();
	PopupHandler();
	Thread.sleep(3000);
	homePage.Administrator();
	Thread.sleep(3000);
	homePage.FoodMaster();
	}
	
	@AfterMethod
	public void tearDown() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
	
	
	@Test
	public void verifyAddFoodMaster() throws InterruptedException {
		
		FoodMasterPage foodMasterPage = new FoodMasterPage(driver);
		foodMasterPage.clickOnAddRecord();
		foodMasterPage.selectMenuDate();
		selectDateIncalendar("16", "October", "2025");
		foodMasterPage.selectMenu();
		foodMasterPage.selectLocation();
		foodMasterPage.addMenuComment("Test By Nagnath");
		foodMasterPage.saveFoodMenu();
		
		
		 WebElement testMsg=driver.findElement(By.xpath("//div[contains(text(), 'Food already')]"));
		 
		 String  msg=testMsg.getText();
		 System.out.println(msg);
		  Assert.assertEquals(msg, "Food already added for selected date");
		  
		 
		
		
	}
	
	@Test
	public void verifyEmployeeCountFoodMaster() throws InterruptedException {
		
		FoodMasterPage foodMasterPage = new FoodMasterPage(driver);
		
		foodMasterPage.clickOnFilter();
		foodMasterPage.clickOnDateFilter();
		selectDateIncalendar("15", "October", "2025");
		//foodMasterPage.clickOnToday();
		foodMasterPage.clickOnlocationFilter("GIFT SEZ");
		foodMasterPage.employeeCountforFood();
	}
}
