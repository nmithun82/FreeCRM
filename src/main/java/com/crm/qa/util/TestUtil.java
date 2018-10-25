package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH = "/Users/mithun_pc/eclipse-workspace/CRMTest/src"
			+"/main/java/com/crm/qa/testdata/demo.xlsx";
	static Workbook book;
	static Sheet sheet;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	 //with method name - refer weblistener for method name public static void takeScreenshot(name)
//	public  void takeScreenshot()
//	{
//		// fileName of the screenshot
//		        Date d=new Date();
//		        
//		        //FileUtils.copyFile(scrFile, new File("E:\\selenium logs\\"+name+"-"+dateFormat.format(date)+".png"));
//		 
//		        //System.out.println("***************************"+name);
//				String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
//				// store screenshot in that file
//				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//				try {
//					//FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Failed_Screenshot"+"/"+name+"-"+screenshotFile));
//					FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Failed_Screenshot"+"/"+screenshotFile));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				//put screenshot file in reports
//				//test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"/Screenshot/"+screenshotFile));
//				//test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture("/Users/mithun_pc/MyMavenProject/Screenshot/"+screenshotFile));
//				
//	
//	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception 
	{
        //below line is just to append the date format with the screenshot name to avoid duplicate names 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = "/Users/mithun_pc/Documents/Project_Reports/FreeCRM"+"/FailedTestsScreenshots/"+screenshotName+".png";
		//String destination = System.getProperty("user.dir")+"/FailedTestsScreenshots/"+screenshotName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		//Returns the captured file path
		return destination;
}
	
	public static String generateScreenShotName(ITestResult result) 
	{
        Date date=new Date();
		String fileName = result.getName()+ "_" +dateFormat.format(date);
		return fileName;
	}
	
	
	
	public void teardown(ITestResult result) throws Exception
	//public void teardown()
	    {
			
		 screenshotName=TestUtil.getScreenshot(driver, TestUtil.generateScreenShotName(result));
			
		
		{
			if (result.getStatus() == ITestResult.FAILURE) {
		        test.log(LogStatus.FAIL, result.getName());
		        test.log(LogStatus.FAIL,result.getThrowable());
		    
				test.log(LogStatus.FAIL,"Screenshot-> "+ test.addScreenCapture(screenshotName));
		    //	test.log(LogStatus.FAIL,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+".png"));	
		   
		    } else if (result.getStatus() == ITestResult.SUCCESS) {
		        test.log(LogStatus.PASS, result.getName());
		        test.log(LogStatus.PASS,"Screenshot-> "+ test.addScreenCapture(screenshotName));
		    } else if (result.getStatus() == ITestResult.SKIP) {
		      	test.log(LogStatus.SKIP, result.getName());
		    }
			}
		rep.endTest(test);
		rep.flush();
		driver.quit();
		
	      }
	
}
