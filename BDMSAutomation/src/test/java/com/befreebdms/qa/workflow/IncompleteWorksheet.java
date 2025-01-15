package com.befreebdms.qa.workflow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.bdms.qa.base.Base;

public class IncompleteWorksheet extends Base {

	public IncompleteWorksheet() {

		super(); // This method will get the all properties from Base class

	}

	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));// from get properties Class
		// driver.get("http://10.10.20.41/auth/login");
		driver.get(prop.getProperty("url")); // from get properties field

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		driver.quit();
	}

}
