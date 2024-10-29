package testing;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic_utility.ExcelUtility;
import com.comcast.objectrepository.CreateNewOrgPage;
import com.comcast.objectrepository.OrganisationPage;
import com.comcast.web_driver_utility.JavaUtility;
import com.comcast.web_driver_utility.UtilityClassObject;
import com.comcast.web_driver_utility.WebDriverUtility;

@Listeners(listeners.ListenerImp.class)
public class orgnisation_with_full extends BaseClass {
	
	@Test
	public void orgfull() throws EncryptedDocumentException, IOException {
		hp.getOrgbutton().click();
		a.assertTrue(UtilityClassObject.getDriver().getCurrentUrl().contains("module=Accounts"));
		Reporter.log("Organisation page opened");
		UtilityClassObject.getTest().log(Status.INFO, "Organisation page opened");
		
		
		OrganisationPage op = new OrganisationPage(UtilityClassObject.getDriver());
		op.getCreateorgbutton().click();
//		a.assertEquals(driver.getCurrentUrl(), driver.getCurrentUrl().contains("module=Accounts&action=EditView"));
		Reporter.log("Organisation creation page");
		UtilityClassObject.getTest().log(Status.INFO, "Organisation creation page");
		
		CreateNewOrgPage cno = new CreateNewOrgPage(UtilityClassObject.getDriver());
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		cno.getName().sendKeys(eu.getDataFromExcel("org", 1, 0)+ ju.getRandomNumber());
//		a.assertEquals("a", "aa");
		
		
		WebDriverUtility wu = new WebDriverUtility();
		wu.selecttheDropDownByText(cno.getIndustry(), eu.getDataFromExcel("org", 1, 1));
		
		wu.selecttheDropDownByText(cno.getType(), eu.getDataFromExcel("org", 1, 2));
		
		
		cno.getSave().click();
//		a.assertEquals(driver.getCurrentUrl(), driver.getCurrentUrl().contains("action=DetailView"));
		Reporter.log("Organisation created");
		UtilityClassObject.getTest().log(Status.INFO, "Organisation created");
		
		
	}
//	
//	@Test(groups = "odd")
//	public void test3() {
//		System.out.println("This is test 3 ");
//	}
//	
//	@Test(groups = "even")
//	public void test4() {
//		System.out.println("This is test 4");
//	}
	
	
	
}
