package com.befreebdms.qa.myprofile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.pageobject.MyLunchPage;
import com.bdms.qa.utils.Utilities;

public class MyLunch extends Base {
	
	public MyLunch() {
		
		super();
		
	}
	
	public WebDriver driver;
		
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] SupplyTestData() {
		
		Object[][] data=Utilities.getTestDataFromExcel("Team_Darshant");
		return data;
		
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		//driver.get("http://10.10.20.41/auth/login");
		
		driver.get(prop.getProperty("url")); //from get properties field	
		//driver=initializeBrowserAndOpenApplicationURL("chrome");  //This Line is setup in Base Class [If any doubt go and check the Base class]
		//driver.get("http://10.10.20.41/auth/login");
		HomePage homePage=new HomePage(driver);
		homePage.setUserName("admin");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		Thread.sleep(2000);
		homePage.clickOnMyProfile();
		Thread.sleep(1000);
		
		homePage.MyLunch();
		Thread.sleep(1000);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		driver.quit();
	}
	
		
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void verifyAddRecordForMyLunch(String empname) throws InterruptedException   {
		
		MyLunchPage myLunch= new MyLunchPage(driver);
		myLunch.clickOnAddRecord();
		myLunch.clickOnMenuDate();
		selectDateIncalendar("26", "September", "2024");
		myLunch.clickOnUserName(empname);
		myLunch.clickOnLocation("Sez - Brigade");
		myLunch.LunchType("jain");
		myLunch.clickOnSave();
		
	}
	
}
	
	


