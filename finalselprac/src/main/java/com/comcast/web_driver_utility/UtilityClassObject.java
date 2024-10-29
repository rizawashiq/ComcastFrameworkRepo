package com.comcast.web_driver_utility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	
	public static void setTest(ExtentTest atest) {
		test.set(atest);
	}
}
