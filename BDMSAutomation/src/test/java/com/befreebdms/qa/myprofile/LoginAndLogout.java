package com.befreebdms.qa.myprofile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;
import com.bdms.qa.pageobject.HomePage;
import com.bdms.qa.utils.Utilities;


public class LoginAndLogout extends Base {
	
	public LoginAndLogout() {
		
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
		
		Object[][] data=Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLogout();
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void verifyLoginWithValidCredential(String email, String password) {
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName(email);
	homePage.setPassword(password);
	homePage.clickLogin();
	boolean element=driver.findElement(By.xpath("//span[text()='Book my lunch']")).isDisplayed();
	System.out.println(element);
	if(element)
	homePage.bookMyLunch.click();
	else
	//loginPage.clickLogoutOption();
	homePage.clickOnLogout();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@data-pc-section='detail']/preceding-sibling::div")).isDisplayed());
	//workLocation("GIFT", "GIFT", "Regular");
	}
		
	@Test (priority=2)
	public void verifyLoginWithInValidCredential() {
	
		HomePage loginPage=new HomePage(driver);
		loginPage.setUserName("adminA");
		loginPage.setPassword("123789");
		loginPage.clickLogin();
		
	/*driver.findElement(By.xpath("//input[@id='username']")).sendKeys("adminA");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123789");
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
	*/
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-pc-section='detail']/preceding-sibling::div")).isDisplayed());
	//softAssert.assertAll();
	}
	
	@Test (priority=3)
	public void verifyLoginWithoutCredential() {
		HomePage loginPage=new HomePage(driver);
		loginPage.setUserName("");
		loginPage.setPassword("");
		loginPage.clickLogin();
		/*
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
	softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='Username is required.']")).isDisplayed());
	*/
	softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='Password is required.']")).isDisplayed());
	softAssert.assertAll();
	}
	
	@Test (priority=4)
	public void verifyLoginWithInvalidUserName() {
		HomePage loginPage=new HomePage(driver);
		loginPage.setUserName("Admin12345");
		loginPage.setPassword("123456");
		loginPage.clickLogin();
		/*
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin12345");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();*/
	softAssert.assertTrue(driver.findElement(By.xpath("//div[@data-pc-section='detail']/preceding-sibling::div")).isDisplayed());
	softAssert.assertAll();
	}
	
	@Test (priority=5)
	public void verifyLoginWithInvalidPassword() {
		HomePage loginPage=new HomePage(driver);
		loginPage.setUserName("Prakharj");
		loginPage.setPassword("123456666666666");
		loginPage.clickLogin();
		
		/*
		
		boolean txt1=driver.findElement(By.xpath("//label[text()='Menu List']")).isDisplayed();
		String url=driver.getCurrentUrl();
		
		if(txt1)
		{//loginPage.bookMyLunch.click();	
		workLocation("GIFT", "GIFT", "Regular");
		}
		else
		
		if(url=="http://10.10.20.41/auth/login")
		//homePage.bookMyLunch.click();
		
		workLocation("GIFT", "GIFT", "Regular");
		
		
		}
	/*driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234566666666666");
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
	*/
	//softAssert.assertTrue(driver.findElement(By.xpath("//div[@data-pc-section='detail']/preceding-sibling::div")).isDisplayed());
	//softAssert.assertAll();
	
	}
	
	@Test (priority=6 )
 	public void verifyLogout()  {
		HomePage homePage=new HomePage(driver);
		
		homePage.setUserName("nagnathg");
		homePage.setPassword("123456");
		homePage.clickLogin();
		boolean element=driver.findElement(By.xpath("//span[text()='Book my lunch']")).isDisplayed();
		System.out.println(element);
		if(element)
		homePage.bookMyLunch.click();
		else
		//loginPage.clickLogoutOption();
		homePage.clickOnLogout();
		/*
		
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
	driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
	driver.findElement(By.xpath("//li[@id='LOGOUT']")).click();
	softAssert.assertTrue(driver.findElement(By.xpath("//p[text()='Welcome to the ']")).isDisplayed());
	softAssert.assertAll();*/
	
	}
	
	/*@Test (priority=7, dataProvider="validCredentialsSupplier")//
 	public void verifyLogoutWithPunchout(String email, String password) {
		//public void verifyLogoutWithPunchout() {	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
	if(driver.findElement(By.xpath("//button[@label='Save Location']/span")).isDisplayed()) {
		
		driver.findElement(By.xpath("//button[@label='Save Location']/span")).click();
		
	}
	else {	
			driver.findElement(By.xpath("//button[@pstyleclass='@next']")).click();
			driver.findElement(By.xpath("//span[text()='Logout with Punch Out']")).click();
			softAssert.assertTrue(driver.findElement(By.xpath("//span[text()='Yes, Punch Out']")).isDisplayed());
			driver.findElement(By.xpath("//span[text()='Yes, Punch Out']")).click();
			softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'successfully logged out')]")).isDisplayed());
			softAssert.assertAll();
		 }
	
	}*/
}
