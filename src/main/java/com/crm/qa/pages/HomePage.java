package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: mithun lloyd')]")
	WebElement userNameLabel;
	
	
	@FindBy(css="a[title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(css="a[title='New Contact']")
	WebElement newContactLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]") 
	WebElement dealsLink;
	
	
	//Initialization
	public HomePage()
	{
	//PageFactory.initElements(driver, LoginPage.class);
	PageFactory.initElements(driver, this);
	
	}
	
	//Actions:
		public String validateHomePageTitle() 
		{
			test.log(LogStatus.INFO, "verification Home page title completed");
			return driver.getTitle();
		}
	
		public boolean verifyUserName() 
		{
			test.log(LogStatus.INFO, "verification username completed");
			return userNameLabel.isDisplayed();
			
			
		}
		
		public ContactsPage clickOnContactsLink() 
		{
			(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(contactsLink));
			Actions actions = new Actions(driver);
			actions.moveToElement(contactsLink).click().build().perform();
			//contactsLink.click();
			//test.log(LogStatus.INFO, "verification Contacts link completed");
			return new ContactsPage();
			
		}
		
		
		public ContactsPage clickOnNewContactLink() 
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(contactsLink).build().perform();
			newContactLink.click();
			return new ContactsPage();
			
		}
		
		
		public DealsPage clickOnDealsLink() 
		{
			contactsLink.click();
			return new DealsPage();
			
		}
}
