package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	
	@FindBy(xpath ="//img[@title='Create Contact...']")
	private WebElement createContact ;

	public WebElement getCreateContact() {
		return createContact;
	}

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
}