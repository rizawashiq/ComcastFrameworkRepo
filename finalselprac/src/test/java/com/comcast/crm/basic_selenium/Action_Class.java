package com.comcast.crm.basic_selenium;

import java.rmi.server.ExportException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Class {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		
		driver.findElement(By.xpath("(//main[@data-aos='zoom-in'])[2]")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[text()='Mouse Actions']")));
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		
		Actions a = new Actions(driver);
		System.out.println("action");
		a.moveToElement(driver.findElement(By.xpath("//section[text()='Mouse Hover']"))).click().perform();
		System.out.println(" d action");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='hjfghfh']")));
		driver.findElement(By.xpath("//input[@value='hjfghfh']")).sendKeys("tyfsdh");
		
		
		a.moveToElement(driver.findElement(By.xpath("//img[@src='/assets/show-8ThHYguo.png']"))).click().perform();
		
		
	}
}
