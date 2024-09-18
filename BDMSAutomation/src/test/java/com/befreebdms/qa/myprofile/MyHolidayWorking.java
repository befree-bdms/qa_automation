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
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		//driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); //from get properties field	
		//driver=initializeBrowserAndOpenApplicationURL("chrome");  //This Line is setup in Base Class [If any doubt go and check the Base class]
		//driver.get("http://10.10.20.41/auth/login");
		
		HomePage homePage=new HomePage(driver);
		homePage.setUserName("darshant");
		homePage.setPassword("123456");
		homePage.clickLogin();
		Thread.sleep(2000);
		homePage.clickOnMyProfile();
		homePage.clickOnMyHolidayWorking();
		
	/*	
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		driver.findElement(By.xpath("//span[text()='My Holiday Working']")).click();
		driver.findElement(By.xpath("//span[text()='Add Record']")).click();
	*/
	}
	
	@AfterMethod
	public void tearDown() {
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	
	}
	
	@Test (priority=1)
 	public void verifyAddRecordForHolidayWorking() throws InterruptedException {
	
		MyHolidayWorkingPage myHolidayWorkingPage=new MyHolidayWorkingPage(driver);
		myHolidayWorkingPage.clickOnAddRecord();
		myHolidayWorkingPage.selectLocation("Baroda");
		myHolidayWorkingPage.selectHolidayDate();
		Thread.sleep(500);
		selectDateIncalendar("15", "August", "2025");
		myHolidayWorkingPage.selectEstimatedArrivalTime("20:00");
		myHolidayWorkingPage.selectEstimatedDepartureTime("05:00");
		myHolidayWorkingPage.selectTradingName("Brightgreen Pty Ltd");
		myHolidayWorkingPage.enterReasonForHolidayWorking("Test by Nagnath");
		
		myHolidayWorkingPage.saveHolidayWorking();
	}
		
		/*
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='location_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Pune");
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']")).click();
		Thread.sleep(2000);
		selectDateIncalendar("15", "August", "2025");
		
		
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='start_time']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='start_time']//input[contains(@class, 'ng-tns-')]")).sendKeys("20:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='end_time']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='end_time']//input[contains(@class, 'ng-tns-')]")).sendKeys("22:00");
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='entity_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Brightgreen Pty Ltd");
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		driver.findElement(By.xpath("//textarea[@formcontrolname='notes']")).sendKeys("Yes");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
	}
*/
}

