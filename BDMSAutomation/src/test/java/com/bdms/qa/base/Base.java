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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver;
	public Properties prop;

	public Base() {

		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\bdms\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		return driver;

	}

	// ############################ Pophandler ##################################
	public void PopupHandler() {

		// workLocation("SEZ - Brigade","SEZ - Brigade","regular");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

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

	// +++++++++++++++++++++++++++++ Calendar
	// ++++++++++++++++++++++++++++++++++++++++++++++//

	/*
	 * public void selectDateIncalendar(String day, String month, String year) {
	 * 
	 * String fromCurrentMonth=driver.findElement(By.
	 * xpath("//button[contains(@class, 'p-datepicker-month')]")).getText(); String
	 * fromCurrentYear=driver.findElement(By.
	 * xpath("//button[contains(@class, 'p-datepicker-year')]")).getText();
	 * while(!(fromCurrentMonth.equals(month) && fromCurrentYear.equals(year))) {
	 * 
	 * driver.findElement(By.
	 * xpath("//button[contains(@class,'p-ripple p-element p-datepicker-next')]")).
	 * click(); fromCurrentMonth=driver.findElement(By.
	 * xpath("//button[contains(@class, 'p-datepicker-month')]")).getText();
	 * fromCurrentYear=driver.findElement(By.
	 * xpath("//button[contains(@class, 'p-datepicker-year')]")).getText(); }
	 * 
	 * String
	 * xpathTxt="//td[contains(@class, 'ng-star-inserted')]/span[text()=\'"+day+
	 * "\']"; try { driver.findElement(By.xpath(xpathTxt)).click(); }catch(Exception
	 * e) {
	 * 
	 * System.out.println("You have Selected the Invalid Date "+day+"/"+month+"/"+
	 * year+"/"); }
	 * 
	 * }
	 */

	public void selectDateIncalendar(String day, String month, String year) {
		String fromCurrentMonth = driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-month')]"))
				.getText();
		String fromCurrentYear = driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-year')]"))
				.getText();

		// Loop until the displayed month and year match the target month and year
		while (!(fromCurrentMonth.equals(month) && fromCurrentYear.equals(year))) {
			int currentYear = Integer.parseInt(fromCurrentYear);
			int targetYear = Integer.parseInt(year);

			// Check if we need to go forward or backward
			if (currentYear < targetYear
					|| (currentYear == targetYear && getMonthIndex(fromCurrentMonth) < getMonthIndex(month))) {
				// Move forward
				driver.findElement(By.xpath("//button[contains(@class,'p-ripple p-element p-datepicker-next')]"))
						.click();
			} else {
				// Move backward
				driver.findElement(By.xpath("//button[contains(@class,'p-ripple p-element p-datepicker-prev')]"))
						.click();
			}

			// Update the month and year after each navigation
			fromCurrentMonth = driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-month')]"))
					.getText();
			fromCurrentYear = driver.findElement(By.xpath("//button[contains(@class, 'p-datepicker-year')]")).getText();
		}

		// Select the day after reaching the correct month and year
		String xpathTxt = "//td[contains(@class, 'ng-star-inserted')]/span[text()='" + day + "']";
		try {
			driver.findElement(By.xpath(xpathTxt)).click();
		} catch (Exception e) {
			System.out.println("You have selected : " + day + "/" + month + "/" + year);
		}
	}

	// Helper method to convert month name to index
	private int getMonthIndex(String month) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < months.length; i++) {
			if (months[i].equalsIgnoreCase(month)) {
				return i;
			}
		}
		return -1; // Return -1 if month is invalid
	}

	public void selectTodaysDate() {
		String todaysdate = driver.findElement(By.xpath("//td[contains(@class, 'today')]")).getText();
		System.out.println(todaysdate);
	}

	public void workLocation(String Wlocation, String NWlocation, String foodType) {

		driver.findElement(By.xpath("//span[@id='pn_id_4_label']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys(Wlocation);
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();

		driver.findElement(By.xpath("//span[@id='pn_id_7_label']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']"))
				.sendKeys(NWlocation);
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();

		driver.findElement(By.xpath("//span[@id='pn_id_9_label']")).click();
		driver.findElement(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")).sendKeys(foodType);
		driver.findElement(By.xpath("//p-dropdownitem[@class='p-element ng-star-inserted']")).click();

		driver.findElement(By.xpath("//button[@label='Book my lunch']")).click();
	}

	// +++++++++++++++++++++++Attendance Summary
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static String getLeaveType(int units) {
		if (units == 0) {
			return "Leave";
		} else if (units >= 1 && units <= 39) {
			return "Leave";
		} else if (units >= 40 && units <= 69) {
			return "Half Day";
		} else if (units >= 70 && units <= 79) {
			return "Early Leaving";
		} else if (units == 80) {
			return "Full Day";
		} else {
			return "Invalid Unit"; // Optional: Handle units outside the specified range
		}
	}

}
