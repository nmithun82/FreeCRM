package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.crm.qa.ExtentReportListener.ExtentReporterNG;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactDetailsPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	ContactDetailsPage contactDetailsPage;
	String sheetName="newContact";
	
	
	 
	public ContactsPageTest()
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
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
		testUtil.switchToFrame();
		contactsPage =homepage.clickOnContactsLink();
		
	}


@Test(priority=1)
public void verifyContactsPageLabel() throws InterruptedException
{    test=rep.startTest("Verifying the Contacts Page Label Test");   
	 test.log(LogStatus.INFO, "verify Contacts Page Label in-progress");
    Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact label is missing");
     	
	
}


@Test(priority=2)
public void selectContactsTest() throws InterruptedException
{
	test=rep.startTest("Verifying verify selectContacts Check box");   
	test.log(LogStatus.INFO, "verify selectContacts Check box done");
    contactsPage.selectContactsByName("test mithun");
   
}

@Test(priority=3)
public void selectMultiContactsTest() throws InterruptedException
{
	test=rep.startTest("selectMultiContactsTest");   
	test.log(LogStatus.INFO, "verify selectMultiContactsTest Check box done");
	throw new SkipException("TEST FOR SKIPPING");
//   contactsPage.selectContactsByName("test aaru");
//   contactsPage.selectContactsByName("test mithun");
//   Thread.sleep(3000);
}

//@DataProvider
//public Object[][] getCRMContactTestData()
//{
//	Object data[][]=	TestUtil.getTestData(sheetName);
//	return data;
//
//}
//
//
//@Test(priority=2, dataProvider="getCRMContactTestData")
//public void validateCreateNewContact(String tit,String ftName, String ltName, String comp) throws InterruptedException
//{
//   homepage.clickOnNewContactLink();
//   //contactDetailsPage=contactsPage.createNewContact("Mr.", "Tommy", "Hanky", "Hollywood");
//  contactDetailsPage=contactsPage.createNewContact(tit,ftName,ltName,comp);
//  Thread.sleep(3000);
//   testUtil.switchToFrame();
//  contactDetailsPage.getnewContactName(tit, ftName, ltName);
//   Assert.assertTrue(contactDetailsPage.getnewContactName(tit, ftName, ltName));
//   
//}

@AfterMethod
public void closetest(ITestResult result) throws Exception {
	
	testUtil.teardown(result);
}

	
}
