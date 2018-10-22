package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactDetailsPage extends TestBase{
		
	public WebElement newContactLabel;
	
	
	//Initialization
		public ContactDetailsPage()
		{
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
		
		}
		
		public boolean getnewContactName(String tit,String ftName, String ltName)
		{
		StringBuilder sb= new StringBuilder(14);
		System.out.println(tit);
		System.out.println(ftName);
		System.out.println(ltName);
		String sb1="//td[contains(text(),'";
		String sb6="')]";
		
		StringBuilder sb5 = sb.append(sb1).append(tit).append(" ").append(ftName).append(" ").append(ltName).append(sb6);
//		 System.out.println("\""+sb5+"\"");	
//		 newContactLabel=driver.findElement(By.xpath("\""+sb5+"\""));
		 String out= sb5.toString();
		 System.out.println(out);
      	 newContactLabel=driver.findElement(By.xpath(out));
      	 WebDriverWait wait = new WebDriverWait(driver, 10);
		 newContactLabel = wait.until(ExpectedConditions.visibilityOf(newContactLabel));
		 return newContactLabel.isDisplayed();
		}
		
//		public boolean verifynewContactName() 
//				{
//					ContactDetailsPage 	obj;
//					newContactLabel= obj.getnewContactName(tit, ftName, ltName);
//					System.out.println(newContactLabel);
//					return newContactLabel.isDisplayed();
//					
//					
//				}
}
