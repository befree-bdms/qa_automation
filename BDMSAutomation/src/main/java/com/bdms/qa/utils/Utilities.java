package com.bdms.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	
	
	public static String genrateTimestamp() {
		
		Date date=new Date();
		String Timestamp= date.toString().replace(" ", " ").replace(":", "_");
		return "BDMS"+Timestamp+"";
	}

	
	/*___________________________Test Data by Using Excel_________________________*/
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		
		File excelFile = new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\bdms\\qa\\testdata\\TestData.xlsx");
		XSSFWorkbook workbook = null;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		 workbook=new XSSFWorkbook(fisExcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols= sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			
			XSSFRow row= sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				
				XSSFCell  cell=row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[i][j]=cell.getStringCellValue(); break;
					
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue()); break;
										
				case BOOLEAN:
					data[i][j]=cell.getCellType(); break;
					
				default:
					break;
	

				
				}
				
					
				
			}
		}
		
		return data;
	}
	
	
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath= System.getProperty("user.dir")+"\\screenshots\\"+ testName +".png";
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();	
		}
		
		return destinationScreenshotPath;

		
		/*File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String destinationScreenShotPath=System.getProperty("user.dir")+"\\screenshots"+testName+".png";
			try {
				FileHandler.copy(srcScreenshot, new File(destinationScreenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		return destinationScreenShotPath;*/
	}
}
