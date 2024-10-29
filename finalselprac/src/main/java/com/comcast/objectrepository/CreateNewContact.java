package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	WebDriver driver ;
	
	@FindBy(name = "lastname")
	private WebElement lastname ;
	
	@FindBy(name = "support_start_date")
		private WebElement startdate ;
	
	@FindBy(name = "support_end_date")
	private WebElement enddate ;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement org_integrate_click_button;

	@FindBy(id = "search_txt")
	private WebElement search_in_integrate;
	
	@FindBy(css = "input[name='search']")
	private WebElement searchbutton_in_integrate;
	
	@FindBy(id = "1")
	private WebElement select_Integrated_Org ;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement savebutton ;
	
	@FindBy(name = "salutationtype")
	private WebElement firstname ;
	

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getStartdate() {
		return startdate;
	}


	public WebElement getEnddate() {
		return enddate;
	}


	public WebElement getOrg_integrate_click_button() {
		return org_integrate_click_button;
	}


	public WebElement getSearch_in_integrate() {
		return search_in_integrate;
	}


	public WebElement getSearchbutton_in_integrate() {
		return searchbutton_in_integrate;
	}


	public WebElement getSelect_Integrated_Org() {
		return select_Integrated_Org;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getFirstname() {
		return firstname;
	}


	public CreateNewContact(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
