package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AccountPage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	
	
	LoginTest(){
	super();//calling constructor of super class
	}
	
	
	@BeforeMethod
	public void setup() {
		intialization();
		loginPage =new LoginPage();
	}
	
	@Test(priority=1) 
	public void LoginTitleTest() { 
    String Act=loginPage.validateTitle();
    Assert.assertEquals(Act,"HubSpot Login");
	}
	
	
	@Test(priority=2)
	public void LogoTest(){
	boolean flag=loginPage.MarkLogo();
		Assert.assertTrue(flag);
	}
	
	 @Test(enabled=false) 
	 public void PrivacyTest() { 
	 loginPage.PrivacyP();	 }
	 	 
	 @Test(priority=3)
	 public void LoginSubmitTest() {
	 accountPage=loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
	 
	 }
    
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}
    }
