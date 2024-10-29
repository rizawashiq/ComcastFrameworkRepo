package com.comcast.crm.basic_selenium;

import java.io.File;
//import java.util.logging.FileHandler;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class TakeSS {
	public static void main(String[] args) throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://demoapps.qspiders.com/");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File x = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ss.png");
		FileHandler.copy(x, dest);
		
		
	}
}
