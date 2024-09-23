package com.befreebdms.qa.myprofile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.utils.Utilities;

public class TestDataLogins extends Base{

	public TestDataLogins() {
		
		super();
	}
	
	public WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeMethod
	public void setUp(){
	
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		//driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); //from get properties field
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] SupplyTestData() {
		
		Object[][] data=Utilities.getTestDataFromExcel("Login_First");
		return data;
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//HomePage homePage=new HomePage(driver);
		//homePage.clickOnLogout();
		driver.quit();
	}
	
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void firstLoginTest(String email, String password) {
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName(email);
	homePage.setPassword(password);
	homePage.clickLogin();
	

	

	
	
	}
}
