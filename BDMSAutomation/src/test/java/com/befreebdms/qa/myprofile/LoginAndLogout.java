package com.befreebdms.qa.myprofile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		//HomePage homePage=new HomePage(driver);
		//homePage.clickOnLogout();
		//Thread.sleep(3000);
		driver.quit();
	}
	
	
	@Test (priority=1, dataProvider="validCredentialsSupplier")
 	public void verifyLoginWithValidCredential(String email, String password) {
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName(email);
	homePage.setPassword(password);
	homePage.clickLogin();
	PopupHandler();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@data-pc-section='detail']/preceding-sibling::div")).isDisplayed());
	//workLocation("GIFT", "GIFT", "Regular");
	}
		
	@Test (priority=2)
	public void verifyLoginWithInValidCredential() throws InterruptedException {
	
		HomePage loginPage=new HomePage(driver);
		loginPage.setUserName("darshant");
		loginPage.setPassword("123456");
		loginPage.clickLogin();
		
		PopupHandler();
		//loginPage.clickOnMyProfile();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='View Profile']")).click();
		driver.findElement(By.xpath("//span[text()='Team Details']")).click();

		
		
		
		
		WebElement body = driver.findElement(By.tagName("body"));

        // Retrieve the text from the body and print it
        String allText = body.getText();
        System.out.println(allText);
		PopupHandler();
		       
		
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
		
		
	}
	
	@Test (priority=6 )
 	public void verifyLogout()  {
		HomePage homePage=new HomePage(driver);
		
		homePage.setUserName("nagnathg");
		homePage.setPassword("123456");
		homePage.clickLogin();
		PopupHandler();
		
		softAssert.assertTrue(driver.findElement(By.xpath("//p[text()='Welcome to the ']")).isDisplayed());
		softAssert.assertAll();
	
	}
	
	
}
