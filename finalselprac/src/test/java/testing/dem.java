package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic_utility.DataBaseUtility;
import com.comcast.crm.generic_utility.ExcelUtility;
import com.comcast.crm.generic_utility.FileUtility;
import com.comcast.web_driver_utility.JavaUtility;
import com.comcast.web_driver_utility.WebDriverUtility;

public class dem extends BaseClass {
//	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, SQLException, InterruptedException {
//		System.out.println("==========");
////		System.out.println(FileUtility.getDataFromJsonFile("un"));
////		System.out.println();
////		DataBaseUtility.getDataFromDB("actor", "first_name", 1);
////		System.out.println(JavaUtility.getDateInFormat("YYYY-MM-dd"));
////		System.out.println(JavaUtility.getDateAfterDays("YYYY-MM-dd", 8));
//
////		WebDriver driver ;
////		
////		FileUtility f = new FileUtility();
////		String browser = f.getDataFromPropertyFile("browser");
////		
////		if(browser.equals("chrome"))
////			driver = new ChromeDriver();
////		else if(browser.equals("firefox"))
////			driver = new FirefoxDriver();
////		else
////			driver = new EdgeDriver();
////		
////		WebDriverUtility wu = new WebDriverUtility();
////		wu.waitToLoad(driver);
////		driver.get(f.getDataFromPropertyFile("url"));
////		WebElement e1 = driver.findElement(By.name("user_name"));
////		WebElement e2 = driver.findElement(By.name("user_password"));
////		e1.sendKeys(f.getDataFromPropertyFile("un"));
////		e2.sendKeys(f.getDataFromPropertyFile("pwd"));
////		driver.navigate().refresh();
////		e1.sendKeys(f.getDataFromPropertyFile("un"));
////		e2.sendKeys(f.getDataFromPropertyFile("pwd"));
////		
////		System.out.println(ExcelUtility.numberOfColumns("data"));
////		System.out.println(ExcelUtility.numberOfRows("data"));
//		
////		ExcelUtility eu = new ExcelUtility();
////		//obj[4][1]
////		Object[][] obj = new Object[eu.numberOfRows("data")][eu.numberOfColumns("data")];
////		//5 2 
////		int r = eu.numberOfRows("data")  ;
////		int c =  eu.numberOfColumns("data") ;
////		System.out.println(r+ " " + c);
////		for(int i = 1; i<r; i++)
////		{
////			for(int j=0;j<c;j++ )
////			{
////				System.out.print(eu.getDataFromExcel("data", i, j) + "   ");
////				obj[i][j]= eu.getDataFromExcel("data", i, j);
////			}
////			System.out.println();
////		}
//		
////		DataBaseUtility d = new DataBaseUtility();
////		d.connectToDB();
////		String x = d.getDataFromDB("actor", "First_Name", 25);
////		System.out.println(x);
////		d.closeConnection();
////		
////		x = d.getDataFromDB("actor", "First_Name", 25);
////		System.out.println(x);
//		
//		
//		
//	}
	
	@Test
	public void testt() {
		System.out.println("test demo started");
	}
	
	
	
}
