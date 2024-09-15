package com.befreebdms.qa.myprofile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;

public class ApplyLeave extends Base{
	
	//To get the properties file from config.properties
	public ApplyLeave() {
		
		super();  //This method will get the all properties from Base class
	
	}
	
	public WebDriver driver;
	SoftAssert softAssert=new SoftAssert();


	@BeforeMethod
	public void setUp() throws InterruptedException {
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

	driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
	//driver.get("http://10.10.20.41/auth/login");
	driver.get(prop.getProperty("url")); //from get properties field	
	//driver=initializeBrowserAndOpenApplicationURL("chrome");  //This Line is setup in Base Class [If any doubt go and check the Base class]
	//driver.get("http://10.10.20.41/auth/login");
	
	
	
	
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("darshant");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	driver.findElement(By.xpath("//span[@class=\"p-button-label\"][1]")).click();
	//Thread.sleep(2000);
	
	/*WebElement workLocation=driver.findElement(By.xpath("//span[@id='pn_id_5_header_title']"));
	boolean wl=workLocation.isDisplayed();
	if(wl) {
	driver.findElement(By.xpath("//span[text()=\"Don't book my lunch\"]")).click();	
	//workLocation("GIFT SEZ", "GIFT SEZ", "Jain Food");
	}*/
	//WebElement Myprofile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Profile'][1]")));
	//Myprofile.click();
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Profile'][1]")));
	driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Leaves')]")));
	//Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(text(),'My Leaves')]")).click();
	//Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apply Leave']")));
	driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
		driver.findElement(By.xpath("//li[@id='LOGOUT']")).click();
	
		driver.quit();
	}
	
	
	@Test (priority=1)
 	public void verifyApplyCasualLeave() throws InterruptedException{
	
	driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//span[text()='Casual']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	//-------------------------Select time for To Date------------------------------
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
	Assert.assertEquals(msg, "Successfully created");
	}
	
	
	
	@Test (priority=2)
 	public void verifyApplyCompOffLeave() throws InterruptedException  {
	
	driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Comp-off");
	driver.findElement(By.xpath("//li[@aria-label='Comp-off']//span[text()='Comp-off']")).click();
	
	//------------------Select time for From Date-----------------------------------
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	//Keep waiting time for 10 second because calendar Load
	
	selectDateIncalendar("15", "October", "2024");
	
	//-------------------------Select time for To Date------------------------------
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	selectDateIncalendar("15", "October", "2024");
	
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	}
	
	@Test (priority=3)
 	public void verifyApplySickLeave() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
	driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Sick");
	driver.findElement(By.xpath("//li[@aria-label='Sick']//span[text()='Sick']")).click();
	
	//-----------------------------Select time for From Date---------------------------------
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
	
	selectDateIncalendar("24", "October", "2025");
	
	Thread.sleep(2000);
	//------------------------------Select time for To Date--------------------------------------
	
	driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
	
	selectDateIncalendar("25", "October", "2025");
	
	driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
	driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
	
	driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
	
	driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
	driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
	driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	}
	@Test (priority=4)
	public void verifyApplyMaternityLeave() throws InterruptedException{
		
		
		driver.findElement(By.xpath("//*[@class='p-float-label']/child::p-dropdown[@formcontrolname='leave_type']")).click();
		driver.findElement(By.xpath("//input[@class=\"p-dropdown-filter p-inputtext p-component\"]")).sendKeys("Maternity");
		driver.findElement(By.xpath("//span[text()='Maternity']")).click();
		
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='from_date']")).click();
		selectDateIncalendar("6", "December", "2025");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='to_date']")).click();
		selectDateIncalendar("10", "December", "2025");
		
		driver.findElement(By.xpath("//p-dropdown[contains(@formcontrolname, 'inform_team')]/child::div")).click();
		driver.findElement(By.xpath("//span[text()='Yes'] [@class='ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='weekly_task']")).click();
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']//span[text()='No']")).click();
		
		driver.findElement(By.xpath("//span[@class='p-float-label']//p-dropdown[@formcontrolname='anything_due']")).click();
		driver.findElement(By.xpath("//p-dropdownitem[@class=\"p-element ng-star-inserted\"]//span[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"anything_due_comments\"]")).sendKeys("Discussed Test");
		driver.findElement(By.xpath("//textarea[@formcontrolname='leave_reason']")).sendKeys("TestByNagnath");
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String msg=driver.findElement(By.xpath("//div[text()='Successfully created']")).getText();
		Assert.assertEquals(msg, "Successfully created");
		}
	
	/*@Test (priority=4)
	public void verifyLeaveTracker() {
		
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		driver.findElement(By.xpath("//span[text()='My Leaves']")).click();
		
		driver.findElement(By.xpath("//button[@label='Leave Trackers']/span[text()='Leave Trackers']")).click();
		
		softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='bdmsdeveloper@befree.com.au']")).isDisplayed(), "bdmsdeveloper@befree.com.au Not Display on the Leave Tracker");
		softAssert.assertAll();
	}*/

}
