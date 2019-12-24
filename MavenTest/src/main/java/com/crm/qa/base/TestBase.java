package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("F:\\Selenium\\Jan2019Project\\CRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void intialization() {	
		
	String BrowserName=prop.getProperty("browser");
	
	if(BrowserName.equals("chrome")){
	System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Jan2019Project\\CRMTest\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(BrowserName.equals("FF")){
		driver=new FirefoxDriver();
		System.setProperty("webdriver.Firefox.driver","F:\\Selenium\\Jan2019Project\\CRMTest\\geckodriver.exe");
	}
	else if(BrowserName.equals("IE")){
		driver=new InternetExplorerDriver();
		
	}
	else if(BrowserName.equals("Safari")){
		driver=new SafariDriver();

	}
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Imlicit_Wait,TimeUnit.SECONDS);
	
	
	}}


