package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public HomePageTest()
	{
		super();
	}
@BeforeMethod
	public void setUp() throws InterruptedException
	{
	   
	    initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginpage=new LoginPage();
		Thread.sleep(2000);	
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
		
	}

@Test(priority=3)
public void homePageTitleTest() throws InterruptedException
{
	test=rep.startTest("homePageTitleTest");   
    test.log(LogStatus.INFO, "verification home page title test in-progress");
    String title=homepage.validateHomePageTitle();
    Assert.assertEquals(title, "123CRMPRO","Home page title not matched");

}


@Test(priority=1)
public void verifyUserNameTest() throws InterruptedException
{   test=rep.startTest("verifyUserNameTest");   
    test.log(LogStatus.INFO, "verification username in-progress");
	testUtil.switchToFrame();
	Assert.assertTrue(homepage.verifyUserName());
}


@Test(priority=2)
public void verifyContactsLinkTest() throws InterruptedException
{
	test=rep.startTest("verifyContactsLinkTest");   
    test.log(LogStatus.INFO, "verification Contacts link in-progress");
    testUtil.switchToFrame();
    contactsPage =homepage.clickOnContactsLink();

}


@AfterMethod
public void closetest(ITestResult result) throws Exception
{
		testUtil.teardown(result);
}

}
