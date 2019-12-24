package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AccountPage extends TestBase {
	
	
	@FindBy(id="hs-nav-v4--logo")
	  WebElement logo;
	
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contact; 
	
	@FindBy(id="nav-primary-conversations-branch")
	WebElement conversation;
	
	@FindBy(id="navNotifications")
	WebElement notification;

	
	@FindBy(id="account-menu")
	WebElement accountTab;
	//	Initialization	
	
	
	@FindBy(xpath="//*[@id=\"navSearch-input\"]")
	WebElement searchIcon;
	
		
	//*[@id="navSearch-input"]
public AccountPage() {
PageFactory.initElements(driver, this);
}

///Actions

public String AccountPageTitle() {
 return driver.getTitle();
}

public boolean ValidateHomePageLogo() {
return	logo.isDisplayed();
}


public ReportPage ClickLogo() {
logo.click();
return new ReportPage();
}


public ContactPage ClickContact() {
	contact.click();
	Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(By.id("nav-secondary-contacts"))).click();
    return new ContactPage();
}

public void ClickConversationInBox() {
    conversation.click();
	Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(By.id("nav-secondary-inbox"))).click();
    }

public NotificationPage ClickNotification() {
	notification.click();
	return new NotificationPage();
	}

public void clickSignout()	{

	
	accountTab.click();
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("signout"))).click();
    }
	
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(accountTab)));
		 */
	////xPath=a[@id='signout']
	//CSS=#signout
	//linkText=Sign out
	
	//Id=signout --//*[@id="navSearch-input"]

    public SearchPage ValidateSearch() {
	searchIcon.click();
    //manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	searchIcon.sendKeys("Test");
    return new SearchPage();
		
   
}
}