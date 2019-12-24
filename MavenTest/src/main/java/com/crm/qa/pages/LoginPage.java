package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {

	//Page Factory-OR
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
    WebElement login;

    @FindBy(css="//i18n-string[contains(text(),'Privacy Policy')]")
    WebElement Privacy;
    
    @FindBy(xpath="//div[@class='auth-box marketing-box']")
    WebElement logo;

    
    //intialization
    public LoginPage() {
    PageFactory.initElements(driver, this);
    }
	
    //Action
    public String validateTitle() {
    return driver.getTitle();	
    }
    
    public void PrivacyP() {
    Privacy.click();
    }
    
    public boolean MarkLogo() {
    return	logo.isDisplayed();
    	
    }
    
	public  AccountPage validatelogin(String un, String pd) {
	    username.sendKeys(un);
		password.sendKeys(pd);
		login.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    return new AccountPage();
	   

 }
 }
