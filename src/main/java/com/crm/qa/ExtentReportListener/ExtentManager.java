package com.crm.qa.ExtentReportListener;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
public class ExtentManager 

{
		private static final String Extent = null;
		private static ExtentReports extent;
		//private static String fileName;
		public static ExtentReports getInstance() 
		{
	    if (extent == null ) {
	    Date d=new Date();
	    String fileName =d.toString().replace(":", "_").replace(" ", "_")+".html";
		extent = new ExtentReports("/Users/mithun_pc/Documents/Project_Reports/FreeCRM"+"/"+fileName, true, DisplayOrder.NEWEST_FIRST);
		//extent = new ExtentReports(System.getProperty("user.dir")+"/"+fileName, true, DisplayOrder.NEWEST_FIRST);
		//extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/Extent.html", true, DisplayOrder.NEWEST_FIRST);
		extent.loadConfig(new File(System.getProperty("user.dir")+"/ReportsConfig.xml"));
		extent.addSystemInfo("Selenium Version", "3.14.0").addSystemInfo(	"Environment", "QA");
		
		}
		 return extent;
		
		}

}



