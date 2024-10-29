package testing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic_utility.ExcelUtility;
import com.comcast.crm.generic_utility.FileUtility;
import com.comcast.objectrepository.ContactPage;
import com.comcast.objectrepository.CreateNewContact;
import com.comcast.objectrepository.CreateNewOrgPage;
import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.LoginPage;
import com.comcast.objectrepository.OrganisationPage;
import com.comcast.web_driver_utility.JavaUtility;
import com.comcast.web_driver_utility.UtilityClassObject;
import com.comcast.web_driver_utility.WebDriverUtility;
@Listeners(listeners.ListenerImp.class)
public class Contact_WIth_Org extends BaseClass {
	
	@Test
	public void testContactWithOrg() throws InterruptedException, IOException {

		WebDriverUtility wu = new WebDriverUtility();

		hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrgbutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on organisationn button");

		OrganisationPage op = new OrganisationPage(UtilityClassObject.getDriver());
		op.getCreateorgbutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on organisationn create button");

		CreateNewOrgPage cno = new CreateNewOrgPage(UtilityClassObject.getDriver());		
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		String name = eu.getDataFromExcel("org", 2, 0)  + ju.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "added name");

		cno.getName().sendKeys(name);
		//		cno..click();
		cno.getIndustry().click();

		wu.selecttheDropDownByText(cno.getIndustry(), eu.getDataFromExcel("org", 2, 1));
		UtilityClassObject.getTest().log(Status.INFO, "selected industry");
		
		wu.selecttheDropDownByText(cno.getType(), eu.getDataFromExcel("org", 2, 2));
		UtilityClassObject.getTest().log(Status.INFO, "seleccted type of industry");
		cno.getSave().click();
		UtilityClassObject.getTest().log(Status.INFO, "Created an organisationn");

		Thread.sleep(5000);

		hp.getContactbutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on contact button");

		ContactPage cp = new ContactPage(UtilityClassObject.getDriver());
		cp.getCreateContact().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on create contact button");

		CreateNewContact cnc = new CreateNewContact(UtilityClassObject.getDriver());
		cnc.getFirstname().click();
		wu.selecttheDropDownByText(cnc.getFirstname(), eu.getDataFromExcel("contact", 2, 0));
		UtilityClassObject.getTest().log(Status.INFO, "added first name");
		
		cnc.getLastname().sendKeys(eu.getDataFromExcel("contact", 2, 1));
		UtilityClassObject.getTest().log(Status.INFO, "added last name");
		
		cnc.getStartdate().clear();
		cnc.getStartdate().sendKeys(ju.getDateInFormat("YYYY-MM-dd"));
		UtilityClassObject.getTest().log(Status.INFO, "added start date");

		cnc.getEnddate().clear();
		cnc.getEnddate().sendKeys(ju.getDateAfterDays("YYYY-MM-dd", 23));
		UtilityClassObject.getTest().log(Status.INFO, "added end date");

		cnc.getOrg_integrate_click_button().click();
		UtilityClassObject.getTest().log(Status.INFO, "Sent to integration");

		wu.switchToNewBrowserWithUrl(UtilityClassObject.getDriver(), "module=Accounts");
		UtilityClassObject.getTest().log(Status.INFO, "switched to org page");

		cnc.getSearch_in_integrate().sendKeys(name);
		cnc.getSearchbutton_in_integrate().click();
		Thread.sleep(3000);
		cnc.getSelect_Integrated_Org().click();
		UtilityClassObject.getTest().log(Status.INFO, "added org");

		wu.switchToNewBrowserWithUrl(UtilityClassObject.getDriver(), "module=Contacts&action");
		UtilityClassObject.getTest().log(Status.INFO, "Moved back to contact page");
		cnc.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Contact created sucesfully");

		//		
		if(UtilityClassObject.getDriver().findElement(By.id("mouseArea_First Name")).getText().contains(eu.getDataFromExcel("contact", 2, 0)))
			System.out.println("Frst name " + eu.getDataFromExcel("contact", 2, 0) + "is true");
		else
			System.out.println("first name "+ eu.getDataFromExcel("contact", 2, 0) + " is wrong");


		if(UtilityClassObject.getDriver().findElement(By.id("dtlview_Last Name")).getText().contains(eu.getDataFromExcel("contact", 2, 1)))
			System.out.println("The org_name has the value  " +  eu.getDataFromExcel("contact", 2, 1) + " is Pass");
		else
			System.out.println("The org_name has the value  " +  eu.getDataFromExcel("contact", 2, 1) + " is Fail");

		
//		// validate organisation name
//		if(BaseClass.driver.findElement(By.cssSelector("a[href=\"index.php?module=Accounts&action=DetailView&record=210\"]")).getText().contains(name))
//			System.out.println("organistaion name " + name + "is true");
//		else
//			System.out.println("organistaion name " + name + "is false");
//		
		
		// validate of start date
		if(UtilityClassObject.getDriver().findElement(By.id("dtlview_Support Start Date")).getText().equals(ju.getDateInFormat("YYYY-MM-dd")))
			System.out.println("The Start Date has the value  " +  ju.getDateInFormat("YYYY-MM-dd") + " is Pass");
		else
			System.out.println("The Start Date has the value  " +  ju.getDateInFormat("YYYY-MM-dd") + " is Fail");

		
		// validate of end date
		if(UtilityClassObject.getDriver().findElement(By.id("dtlview_Support End Date")).getText().equals(ju.getDateAfterDays("YYYY-MM-dd", 23)))
			System.out.println("The  End Date has the value  " +  ju.getDateAfterDays("YYYY-MM-dd", 23) + " is Pass");
		else
			System.out.println("The  End Date has the value  " +  ju.getDateAfterDays("YYYY-MM-dd", 23) + " is Fail");

	}
	
//	@Test(groups = "odd")
//	public void test1() {
//		System.out.println("This is test 1 ");
//	}
//	
//	@Test(groups = "even")
//	public void test2() {
//		System.out.println("This is test 2 ");
//	}
	
	
	
	
}
