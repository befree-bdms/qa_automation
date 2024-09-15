package com.befreebdms.qa.myprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;

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
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		driver.findElement(By.xpath("//span[text()='My Holiday Working']")).click();
		driver.findElement(By.xpath("//span[text()='Add Record']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		
	driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
	driver.findElement(By.xpath("//li[@id='LOGOUT']")).click();
	driver.quit();
	
	}
	
	@Test (priority=1)
 	public void verifyAddRecordForHolidayWorking() throws InterruptedException {
	
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='location_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Pune");
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']")).click();
//		Thread.sleep(2000);
		selectDateIncalendar("15", "August", "2025");
		
		/******************************************************/
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='start_time']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='start_time']//input[contains(@class, 'ng-tns-')]")).sendKeys("20:00");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='end_time']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='end_time']//input[contains(@class, 'ng-tns-')]")).sendKeys("22:00");
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='entity_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Brightgreen Pty Ltd");
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		driver.findElement(By.xpath("//textarea[@formcontrolname='notes']")).sendKeys("Yes");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
	}

}

