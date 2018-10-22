package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
//	ExtentReports report;
//	ExtentTest test;
	public LoginPageTest()
	{
		super();
	}
@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		Thread.sleep(2000);
	}

@Test(priority=2)
public void loginPageTitleTest()
{
String title=loginpage.validateLoginPageTitle();
Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
}

@Test(priority=3)
public void crmLogoImageTest()
{
 boolean flag=loginpage.validateCRMImage();
Assert.assertTrue(flag);
}

@Test(priority=1)
public void LoginTest()
{
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password") );

}


@AfterMethod
public void teardown() {
	driver.quit();
}


}
