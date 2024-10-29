package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;
//import java.util.logging.FileHandler;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.web_driver_utility.UtilityClassObject;


public class ListenerImp implements ITestListener , ISuiteListener {
	
	ExtentReports report ;
//	public  ExtentTest test ;
	
	@Override
	public void onStart(ISuite suite) {
		String d = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter esp = new ExtentSparkReporter("./advance_report/report"+d+".html");
		esp.config().setDocumentTitle("Create Org ");
		esp.config().setReportName("Smoke Test");
		esp.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esp);
		report.setSystemInfo("os", "Windows11");
		report.setSystemInfo("browser", "chrome");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
//		test = report.createTest(result.getName());
		UtilityClassObject.setTest(report.createTest(result.getName()));
//		Assert.assertTrue(UtilityClassObject.getTest()!=null);
//		report.createTest(result.getName());
		
		Reporter.log(result.getMethod().getMethodName() + " started execution" , true);
		UtilityClassObject.getTest().log(Status.INFO, result.getName()+ " started execution");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + " ended execution", true);
		UtilityClassObject.getTest().log(Status.PASS, result.getName()+ " ended execution");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + " failed execution", true);
		
		 UtilityClassObject.getTest().log(Status.FAIL, result.getName()+ " failed execution");
		
		String method = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		
		
		
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver() ;
		
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));

		
		
		//		UtilityClassObject.getTest().addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		
		//		File src =   ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./screenshots/"+method+time+".png");
//		try {
//			FileHandler.copy(src, dest) ;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	

}
