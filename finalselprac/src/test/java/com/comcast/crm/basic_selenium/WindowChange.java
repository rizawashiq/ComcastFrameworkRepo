package com.comcast.crm.basic_selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowChange {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		Set<String> w = driver.getWindowHandles();
		Iterator<String> i = w.iterator();
		while(i.hasNext())
		{
			String window = i.next();
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if(url.contains("Face"))
				break ;
		}
		
		
		
		
		
	}
}
