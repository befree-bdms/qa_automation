package com.bdms.qa.listenes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bdms.qa.utils.ExtentReport;
import com.bdms.qa.utils.Utilities;

public class MyListner implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	

	@Override
	public void onStart(ITestContext context) {
		
		 extentReport = ExtentReport.genrateReport();
		// extentReport= ExtentReporter.generateExtentReport();
		 //please check once
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+"Started Executing");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.PASS, result.getName() + "Got Successfully Executed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		/*File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath= System.getProperty("user.dir")+"\\Screenshots"+".png";
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		
		String destinationScreenshotPath= Utilities.captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() +"Test Got Failed");
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
			
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() +"Got Skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
		//Auto Launch the Extent Report
		String PathOfExtendReport= System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport=new File(PathOfExtendReport);
		try {
			
			Desktop.getDesktop().browse(extentReport.toURI());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
