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
 	public void PopupHandler(String email, String password) {
		
	HomePage homePage=new HomePage(driver);
	homePage.setUserName(email);
	homePage.setPassword(password);
	homePage.clickLogin();
	PopupHandler();
	//workLocation("SEZ - Brigade","SEZ - Brigade","regular");
	/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	 
     try {
         // Check for popups
         boolean bookLunchPresent = isElementPresent(driver, wait, By.xpath("//span[text()='Book my lunch']"));
         boolean saveLocationPresent = isElementPresent(driver, wait, By.xpath("//span[text()='Save Location']"));

         if (bookLunchPresent) {
             driver.findElement(By.xpath("//span[text()='Book my lunch']")).click();
             System.out.println("Clicked on 'Book Lunch' button.");
         }

         if (saveLocationPresent) {
             driver.findElement(By.xpath("//span[text()='Save Location']")).click();
             System.out.println("Clicked on 'Save Location' button.");
         }

         if (!bookLunchPresent && !saveLocationPresent) {
             proceedToNextMethod();
         }

     } catch (Exception e) {
         e.printStackTrace();
     } 
 }

 private static boolean isElementPresent(WebDriver driver, WebDriverWait wait, By locator) {
     try {
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
         return true;
     } catch (Exception e) {
         return false; // Return false immediately if not found
     }
 }

 private static void proceedToNextMethod() {
     System.out.println("No popups detected, proceeding to the next method.");
     // Add your logic for the next method here
 }
}*/

    /* try {
         // Check for "Book Lunch" popup
         if (isElementPresent(driver, wait, By.xpath("//span[text()='Book my lunch']"))) {
             WebElement bookLunchButton = driver.findElement(By.xpath("//span[text()='Book my lunch']"));
             bookLunchButton.click();
             System.out.println("Clicked on 'Book Lunch' button.");
         }

         // Check for "Save Location" popup
         if (isElementPresent(driver, wait, By.xpath("//span[text()='Save Location']"))) {
             WebElement saveLocationButton = driver.findElement(By.xpath("//span[text()='Save Location']"));
             saveLocationButton.click();
             System.out.println("Clicked on 'Save Location' button.");
         }

         // If no popups were handled, proceed to the next method
         if (!isElementPresent(driver, wait, By.xpath("//span[text()='Book my lunch']")) &&
             !isElementPresent(driver, wait, By.xpath("//span[text()='Save Location']"))) {
        	 proceedToNextMethod();
         }

     } catch (Exception e) {
         e.printStackTrace();
     } 
 }

 private static boolean isElementPresent(WebDriver driver, WebDriverWait wait, By locator) {
     try {
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
         return true;
     } catch (Exception e) {
         return false;
     }
 }

 private static void proceedToNextMethod() {
     System.out.println("No popups detected, proceeding to the next method.");
     // Add your logic for the next method here
 }
}
*/
       
	}}
	