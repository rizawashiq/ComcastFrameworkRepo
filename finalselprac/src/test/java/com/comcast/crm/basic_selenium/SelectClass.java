package com.comcast.crm.basic_selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		
		driver.findElement(By.xpath("(//main[@data-aos='zoom-in'])[2]")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/ui/dropdown']")));
		
		driver.findElement(By.xpath("//a[@href='/ui/dropdown']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.id("phone")));
		
		System.out.println(driver.findElement(By.xpath("//h1[text()='Checkout Page']")).getText());
		
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		
		Select s = new Select(driver.findElement(By.id("select2")));
		s.selectByValue("male");
		System.out.println(s.isMultiple());
		System.out.println("=============================");
		
		s = new Select(driver.findElement(By.id("select3")));
		s.selectByVisibleText("India");
		List<WebElement> list = s.getOptions();
		for(WebElement x : list)
			System.out.println(x.getText());
		System.out.println("=============================");
		
		s = new Select(driver.findElement(By.id("select5")));
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption());
		System.out.println("=============================");
		
		s = new Select(driver.findElement(By.xpath("(//div[@class='relative w-full mb-3'])[5]/select")));
		s.selectByIndex(5);
		
		
		
		
		
	}
}
