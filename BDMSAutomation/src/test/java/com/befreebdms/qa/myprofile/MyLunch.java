package com.befreebdms.qa.myprofile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bdms.qa.base.Base;

public class MyLunch extends Base {
	
	public MyLunch() {
		
		super();
		
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		//driver.get("http://10.10.20.41/auth/login");
		
		driver.get(prop.getProperty("url")); //from get properties field	
		//driver=initializeBrowserAndOpenApplicationURL("chrome");  //This Line is setup in Base Class [If any doubt go and check the Base class]
		//driver.get("http://10.10.20.41/auth/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("darshant");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		driver.findElement(By.xpath("//span[text()='My Lunch']")).click();
		driver.findElement(By.xpath("//span[text()='Add Record']")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		
	driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
	driver.findElement(By.xpath("//li[@id='LOGOUT']")).click();
	driver.quit();
	}
	
	@Test (priority=1)
 	public void verifyAddRecordForMyLunch() throws InterruptedException   {
				
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']")).click();
		selectDateIncalendar("19", "September", "2024");
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='user_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Ajay Tanna");
		driver.findElement(By.xpath("//li[@class='p-ripple p-element p-dropdown-item']")).click();
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='location_id']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Indore");
		driver.findElement(By.xpath("//li[@class='p-ripple p-element p-dropdown-item']")).click();
		driver.findElement(By.xpath("//button[@label='Save']")).click();
		Thread.sleep(2000);

	}
	
	

}
