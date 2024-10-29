package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement usernameEdt ;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEdt ;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn ;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}

	/**
	 * 
	 * @param un
	 * @param pwd
	 */
	public void loginToAPp(String un , String pwd)
	{
		usernameEdt.sendKeys(un);
		userpasswordEdt.sendKeys(pwd);
		loginbtn.click();
	}
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}