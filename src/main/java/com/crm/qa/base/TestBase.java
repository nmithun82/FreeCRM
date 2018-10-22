package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.ExtentReportListener.ExtentManager;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
	
	public class TestBase {
		
		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver edriver;
		public static WebEventListener eventListener;
		public static ExtentReports rep= ExtentManager.getInstance();
		public static ExtentTest test;
		public static String screenshotName; 
		public TestBase()
		{
			if(prop==null)
			{
				prop = new Properties();
				try {
					FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
				
					prop.load(ip);
						
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	
		}
		
		public static void initialization() 
		
		{
			String type=prop.getProperty("browser");
			
			try {
				if(type.equals("Chrome"))
				{
					
					System.setProperty("webdriver.chrome.driver","/Users/mithun_pc/Documents/JarSoftware/chromedriver");
					driver= new ChromeDriver();
			
				}
				else if (type.equals("Firefox"))
				{
					driver= new FirefoxDriver();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			 edriver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			edriver.register(eventListener);
			driver=edriver;
			
			driver.manage().window().fullscreen();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));	
			
		}
		
		
		
	}
