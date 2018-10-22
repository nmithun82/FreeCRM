package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class ContactsPage extends TestBase{
			
	@FindBy(xpath="123//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	@FindBy(xpath="//*[@id='first_name']")
	WebElement firstName;
		
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initialization
	public ContactsPage()
	{
	//PageFactory.initElements(driver, LoginPage.class);
	PageFactory.initElements(driver, this);
	
	}
	
	//Actions:
		
	
		public boolean verifyContactsLabel() 
		{
			test.log(LogStatus.INFO, "verify Contacts Page Label completed");
			return contactsLabel.isDisplayed();
									
		}
		
		public void selectContactsByName(String name)
		{
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		//test.log(LogStatus.INFO, "selectContactsByName");		
		}
		
	public ContactDetailsPage createNewContact(String tit,String ftName, String ltName, String comp) throws InterruptedException
	{
		// example of identifying element without page factory - ie writing directly.
		Select drpTitle=new Select(driver.findElement(By.name("title")));
		drpTitle.selectByVisibleText(tit);
		
	firstName.sendKeys(ftName);
	lastName.sendKeys(ltName);
	company.sendKeys(comp);
	saveBtn.click();
	return new ContactDetailsPage();
		
		
	}

}
