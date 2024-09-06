package com.bdms.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports genrateReport() {
		
		ExtentReports extentReport=new ExtentReports();
		File extentreportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter extentSparkReporter=new  ExtentSparkReporter(extentreportFile);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("BDMS Report");
		extentSparkReporter.config().setDocumentTitle("Regression Suite for BDMS Report");
		extentSparkReporter.config().setTimeStampFormat("dd/mm/yy hh:mm:ss");
		
		extentReport.attachReporter(extentSparkReporter);
		
		Properties configProp=new Properties();
		File configPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bdms\\qa\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(configPropFile);
		configProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Application Browser", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;

		

	}

}
