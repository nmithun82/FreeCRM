package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
//Page factory - OR:
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="input[value='Login']")
	//@FindBy(xpath="//div[@class='input-group']/div/input")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='navbar-collapse']/ul/li[2]/a")
	WebElement signUp;
	
	@FindBy(xpath="//div[@class='navbar-header']/a")
	WebElement crmLogo;
	
	//Initialization
	public LoginPage()
	{
	//PageFactory.initElements(driver, LoginPage.class);
	PageFactory.initElements(driver, this);
	
	}
	//Actions:
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() 
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String usr,String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(loginBtn).click().build().perform();
//		 WebDriverWait wait = new WebDriverWait(driver, 10);
//		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		//loginBtn.click();
		
		return new HomePage();
		
	}
	
}
