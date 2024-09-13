package com.befreebdms.qa.administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
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
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

	driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
	//driver.get("http://10.10.20.41/auth/login");
	driver.get(prop.getProperty("url")); //from get properties field	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	driver.findElement(By.xpath("//span[@class=\"p-button-label\"][1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Administrator']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Designation']")).click();
	Thread.sleep(1000);
	
	
	
	
	}
	
	@AfterMethod
	public void tearDown() {
	
		driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
		driver.findElement(By.xpath("//li[@id='LOGOUT']")).click();
	
		driver.quit();
	
	}
	
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void verifyGroupManagerRights(String page_rights) throws InterruptedException{
		
		
		driver.findElement(By.xpath("//button[@icon='pi pi-filter']")).click();
		driver.findElement(By.xpath("//div[@class='filter-field flex-grow-1']//input")).sendKeys("Group Manager");
		driver.findElement(By.xpath("//div[@class='flex gap-2 ng-star-inserted']")).click();	
		driver.findElement(By.xpath("//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//input[@class='p-inputtext p-component p-element w-full']")).sendKeys(page_rights);
		Thread.sleep(2000);
		
		boolean view=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).isSelected();
		//Add Validation for checkBoxes
		if(view!=true) 
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).click();
		
		boolean addedit=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).isSelected();
		if(addedit!=true)
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		Thread.sleep(1000);
	}
	
	@Test (priority=2, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateTechnicalHead(String page_rights) throws InterruptedException{
		
		
		driver.findElement(By.xpath("//button[@icon='pi pi-filter']")).click();
		driver.findElement(By.xpath("//div[@class='filter-field flex-grow-1']//input")).sendKeys("Associate Technical Head");
		driver.findElement(By.xpath("//span[@class='pi pi-wrench p-button-icon ng-star-inserted']")).click();	
		driver.findElement(By.xpath("//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//input[@class='p-inputtext p-component p-element w-full']")).sendKeys(page_rights);
		Thread.sleep(2000);
		
		boolean view=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).isSelected();
		//Add Validation for checkBoxes
		if(view!=true) 
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).click();
		
		boolean addedit=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).isSelected();
		if(addedit!=true)
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		Thread.sleep(1000);
	}
	
	
	@Test (priority=3, dataProvider="validCredentialsSupplier")
 	public void verifyAssociateReviewLead(String page_rights) throws InterruptedException{
		
		
		driver.findElement(By.xpath("//button[@icon='pi pi-filter']")).click();
		driver.findElement(By.xpath("//div[@class='filter-field flex-grow-1']//input")).sendKeys("Associate Review Lead");
		driver.findElement(By.xpath("//span[@class='pi pi-wrench p-button-icon ng-star-inserted']")).click();	
		driver.findElement(By.xpath("//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//input[@class='p-inputtext p-component p-element w-full']")).sendKeys(page_rights);
		Thread.sleep(1000);
		
		boolean view=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).isSelected();
		//Add Validation for checkBoxes
		if(view!=true) 
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsView']")).click();
		
		boolean addedit=driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).isSelected();
		if(addedit!=true)
		driver.findElement(By.xpath("//p-checkbox[@id='selectAllIsAddEdit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		Thread.sleep(1000);
	}
	
	
	
}
