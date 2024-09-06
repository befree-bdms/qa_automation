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


		
		
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
	@Test (priority=1)
 	public void verifyAddRecordForHolidayWorking() throws InterruptedException {
	
		
		driver.findElement(By.xpath("//span[text()='My Profile'][1]")).click();
		
		driver.findElement(By.xpath("//span[text()='My Holiday Working']")).click();
		
		driver.findElement(By.xpath("//span[text()='Add Record']")).click();
		
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='location_id']")).click();
		
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Pune");
		
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']")).click();
		
		Thread.sleep(2000);
		selectDateIncalendar("15", "August", "2025");
		
		/******************************************************/
		
		
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='start_time']")).click();
		
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='end_time']")).click();
		
				
		driver.findElement(By.xpath("//p-dropdown[@formcontrolname='entity_id']")).click();
				
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys("Brightgreen Pty Ltd");
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//textarea[@formcontrolname='notes']")).sendKeys("Yes");
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
	}

}














/* For Time Picker Logic
 
 
 If the time input field has up and down buttons (like a spinner or a time picker), you'll need to interact with these buttons programmatically using Selenium. Here's a basic approach to handle this scenario:

### Java Example with Selenium WebDriver

Assuming the time picker has two buttons for increasing and decreasing the time, you can use Selenium to interact with them. Here's a general example of how you might achieve this:

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimePickerExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("your_website_url");

        // Locate the input field for the time picker
        WebElement timeInput = driver.findElement(By.id("timeInputId"));

        // Locate the up and down buttons for the time picker
        WebElement upButton = driver.findElement(By.id("timeUpButtonId")); // Replace with actual ID
        WebElement downButton = driver.findElement(By.id("timeDownButtonId")); // Replace with actual ID

        // Define the target time
        String targetTime = "13:00";
        // Assuming the initial time is known or can be retrieved
        String currentTime = getCurrentTime(timeInput); // You need to implement this method
        
        // Parse the target time
        String[] targetTimeParts = targetTime.split(":");
        int targetHour = Integer.parseInt(targetTimeParts[0]);
        int targetMinute = Integer.parseInt(targetTimeParts[1]);

        // Adjust the time to reach the target time
        while (currentHour != targetHour || currentMinute != targetMinute) {
            if (shouldIncrementHour(currentHour, targetHour)) {
                upButton.click(); // Click the up button to increment time
                currentHour++; // Update current hour
            } else if (shouldDecrementHour(currentHour, targetHour)) {
                downButton.click(); // Click the down button to decrement time
                currentHour--; // Update current hour
            }
            // Add similar logic for minutes if needed
            // Update current time after each adjustment
            currentTime = getCurrentTime(timeInput);
        }

        // Optionally, close the browser
        driver.quit();
    }

    // Method to retrieve the current time from the input field
    private static String getCurrentTime(WebElement timeInput) {
        return timeInput.getAttribute("value");
    }

    // Method to determine if the hour should be incremented
    private static boolean shouldIncrementHour(int currentHour, int targetHour) {
        return currentHour < targetHour;
    }

    // Method to determine if the hour should be decremented
    private static boolean shouldDecrementHour(int currentHour, int targetHour) {
        return currentHour > targetHour;
    }
}
```

### Explanation:

1. **Locate Elements**: Find the time input field and the up/down buttons using their IDs or other locators.
2. **Define Target Time**: Set the time you want to achieve.
3. **Adjust Time**: Click the up or down buttons to increment or decrement the time until you reach the desired time.
4. **Retrieve Current Time**: Implement a method to get the current time value from the input field.

### Notes:

- **Implement `getCurrentTime`**: You'll need to define how to extract the current time from the input field.
- **Adjust for Minutes**: If the time picker allows you to change minutes separately, you'll need to add similar logic for minutes.
- **Edge Cases**: Consider edge cases like time wrap-arounds (e.g., incrementing from 23:59 to 00:00).

You may need to adjust this approach based on the specific behavior and structure of your time picker component.*/
