package com.befreebdms.qa.administrator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait wait;
	


	@BeforeMethod
	public void setUp() throws InterruptedException {
	
	driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
	//driver.get("http://10.10.20.41/auth/login");
	driver.get(prop.getProperty("url")); //from get properties field	
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName("admin");
	homePage.setPassword("123456");
	homePage.clickLogin();
	/*
	 * PopupHandlerPage PopupHandler=new PopupHandlerPage(driver);
	 * PopupHandler.handlePopups();
	 */
	PopupHandler();
	Thread.sleep(2000);
	homePage.Administrator();
	
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
		Thread.sleep(100);
		foodMasterPage.selectMenuDate();
		Thread.sleep(100);
		selectDateIncalendar("15", "September", "2025");
		foodMasterPage.selectMenu();
		foodMasterPage.selectLocation();
		foodMasterPage.addMenuComment("Test By Nagnath");
		foodMasterPage.saveFoodMenu();
		
		
		 WebElement testMsg=driver.findElement(By.xpath("//div[contains(text(), 'Food already')]"));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.visibilityOf(testMsg));
		 
		 String  msg=testMsg.getText();
		 System.out.println(msg);
		 // Assert.assertEquals(msg, "Food already added for selected date");
		 softAssert.assertTrue(msg.contains("Food already added for selected date"), "Expected message 'Food already added for selected date' not found.");
		  
		
		
		
	}
	
	/*@Test
	public void verifyEmployeeCountFoodMaster() throws InterruptedException {
		
		FoodMasterPage foodMasterPage = new FoodMasterPage(driver);
		
		foodMasterPage.clickOnFilter();
		Thread.sleep(1000);
		foodMasterPage.clickOnDateFilter();
		Thread.sleep(100);
		selectDateIncalendar("15", "October", "2025");
		//foodMasterPage.clickOnToday();
		foodMasterPage.clickOnlocationFilter("GIFT SEZ");
		foodMasterPage.employeeCountforFood();
	}*/
}
