package com.comcast.crm.baseclass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic_utility.DataBaseUtility;
import com.comcast.crm.generic_utility.FileUtility;
import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.LoginPage;
import com.comcast.web_driver_utility.UtilityClassObject;
import com.comcast.web_driver_utility.WebDriverUtility;

import listeners.ListenerImp;

public class BaseClass {
	FileUtility f = new FileUtility();
	DataBaseUtility db = new DataBaseUtility();
	WebDriverUtility wu = new WebDriverUtility();
	public HomePage hp;
	WebDriver edriver ;
	public SoftAssert a = new  SoftAssert();
	
//	@Parameters("browser")
	@BeforeClass
	public void openBrowser() throws IOException {
		String browser = f.getDataFromPropertyFile("browser");
		if(browser.equals("chrome"))
		edriver = new ChromeDriver();
		else if(browser.equals("firefox"))
			edriver = new FirefoxDriver();
		else if(browser.equals("edge"))
			edriver = new EdgeDriver();
		else
			edriver = new SafariDriver();
		
//		ListenerImp.test.log(Status.INFO, edriver+"browser opened");
		UtilityClassObject.setDriver(edriver);
//		driver = edriver;
		
		edriver.manage().window().maximize();
		
		edriver.get(f.getDataFromPropertyFile("url"));
		
		wu.waitToLoad(edriver);
		
		hp = new HomePage(edriver);
	}
	
	
	@AfterClass
	public void closeBrowser() {
//		UtilityClassObject.getDriver().close();
//		UtilityClassObject.getTest().log(Status.INFO, UtilityClassObject.getDriver()+"browser CLOSED");
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new  LoginPage(UtilityClassObject.getDriver());
		lp.loginToAPp(f.getDataFromPropertyFile("un"), f.getDataFromPropertyFile("pwd"));
//		a.assertEquals(driver.getCurrentUrl(), driver.getCurrentUrl().contains("Home"));
		Reporter.log("Logged In succesfully");
		Assert.assertTrue(edriver.getCurrentUrl().contains("module=Home"));
		Assert.assertEquals(edriver.getCurrentUrl(), "http://localhost:8888/index.php?action=index&module=Home");
		
//		ListenerImp.test.log(Status.PASS, "Logged in sucesfully");
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(4000);
		wu.waitForElement(UtilityClassObject.getDriver(), hp.getAdminicon());
		Actions ac = new Actions(UtilityClassObject.getDriver());
		ac.moveToElement(hp.getAdminicon()).click().perform();
//		hp.getAdminicon().click();
		hp.getSignout().click();
//		a.assertEquals(driver.getCurrentUrl(), driver.getCurrentUrl().contains("index.php"));
		Reporter.log("Logged out sucesfully");
		UtilityClassObject.getTest().log(Status.INFO, "Logged out sucesfully");
		a.assertAll();
		
	}
	
	@BeforeSuite
	public void connectToDb() throws SQLException {
		db.connectToDB();
//		ListenerImp.test.log(Status.INFO, "Connected to DB");
	}
	
	@AfterSuite
	public void closeConnection() throws SQLException {
		db.closeConnection();
		UtilityClassObject.getTest().log(Status.INFO, "Connection closed");
		a.assertAll();
	}
	
}
