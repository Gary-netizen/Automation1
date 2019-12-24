package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AccountPage;

import com.crm.qa.pages.LoginPage;


public class AccountPageTest extends TestBase {
     LoginPage loginPage;
     AccountPage accountPage;
     
     AccountPageTest(){
	 super();
	}
		
	@BeforeMethod
	public void setup() {
	intialization();
	loginPage =new LoginPage();
	accountPage=new AccountPage();
	accountPage=loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
	}
		
	@Test(priority=1)
	public void AccountTitleTest() {
	String Act=accountPage.AccountPageTitle();
	String Expt="Account Setup|Hubspot";
	Assert.assertEquals(Act,Expt);
	}
	
	
	@Test(priority=2)
	public void HomePageLogoTest() {
	boolean	flag=accountPage.ValidateHomePageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void HomePageLogoClick() {
    accountPage.ClickLogo();
	}
	
	@Test(priority=4)
	public void ContactPageClickTest() {
	accountPage.ClickContact();
	}
	
	@Test(priority=5)  
	public void NotificationTest() {
	accountPage.ClickNotification();	
	}
	
	@Test(enabled=false) 
	public void clickSignoutTest() {
	accountPage.clickSignout();
	}
	
	@Test(priority=6)
	public void ValidateSearchTest() {
	accountPage.ValidateSearch();
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();
}
}

