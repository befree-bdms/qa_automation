package com.bdms.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	
	public  Base() {
		
		prop=new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bdms\\qa\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		
	if(browserName.equalsIgnoreCase("chrome")) {
		
		driver= new ChromeDriver();
	
	}else if (browserName.equalsIgnoreCase("firefox")) {
	
		driver = new FirefoxDriver();
		
	}else if (browserName.equalsIgnoreCase("edge")) {
		
		driver = new EdgeDriver();
	}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
	
	return driver;
		
	}
	
	//+++++++++++++++++++++++++++++ Calendar ++++++++++++++++++++++++++++++++++++++++++++++//
	
		public void selectDateIncalendar(String day, String month, String year) {
		
		String fromCurrentMonth=driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-month')]")).getText();
		String fromCurrentYear=driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-year')]")).getText();
		while(!(fromCurrentMonth.equals(month) && fromCurrentYear.equals(year))) {

			driver.findElement(By.xpath("//button[contains(@class,'p-ripple p-element p-datepicker-next')]")).click();
			fromCurrentMonth=driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-month')]")).getText();
			fromCurrentYear=driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-year')]")).getText();
		}
		
		String xpathTxt="//td[contains(@class, 'ng-star-inserted')]/span[text()=\'"+day+"\']";
		try {
		driver.findElement(By.xpath(xpathTxt)).click();
		}catch(Exception e) {
			
			System.out.println("You have Selected the Invalid Date "+day+"/"+month+"/"+year+"/");
		}
		
	}
		public void selectTodaysDate() {
			String todaysdate=driver.findElement(By.xpath("//td[contains(@class, 'today')]")).getText();
			
		}
			
		public void workLocation(String Wlocation, String NWlocation, String foodType) {
									
			driver.findElement(By.xpath("//span[@id='pn_id_4_label']")).click();
			driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys(Wlocation);
			driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
			
			driver.findElement(By.xpath("//span[@id='pn_id_7_label']")).click();
			driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys(NWlocation);
			driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
			
			driver.findElement(By.xpath("//span[@id='pn_id_9_label']")).click();
			driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys(foodType);
			driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
			
			
			driver.findElement(By.xpath("//button[@label='Book my lunch']")).click();
		}
	
}
