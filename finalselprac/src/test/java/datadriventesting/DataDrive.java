package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrive {
	public static void main(String[] args) throws IOException, ParseException {
		FileInputStream f1 = new FileInputStream("./src/test/java/datadriventesting/config.properties");
		Properties p = new Properties();
		p.load(f1);
		
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pwd = p.getProperty("pwd");
		System.out.println(url + " " + un + " " + pwd);
		
		//=================================================

		f1= new FileInputStream("./src/test/java/datadriventesting/testData.xlsx");
		Workbook wb = WorkbookFactory.create(f1);
		System.out.println(wb.getSheet("org").getRow(4).getCell(0).getStringCellValue());
		
		
		Sheet s = wb.getSheet("org");
		Row r = s.getRow(3);
		Cell c = r.getCell(0);
		System.out.println(c.getStringCellValue());
	
		
		
		int norows = wb.getSheet("org").getLastRowNum();
		System.out.println(norows);
		int nocell = wb.getSheet("org").getRow(0).getLastCellNum();
		System.out.println(nocell);
		
		for(int i=1 ; i<norows ; i++)
		{
			for(int j=0;j<nocell;j++)
			{
				System.out.print(wb.getSheet("org").getRow(i).getCell(j).getStringCellValue());	
			}
			System.out.println();
		}
		wb.getSheet("org").createRow(6).createCell(0).setCellValue("Raju");
		FileOutputStream fo = new FileOutputStream("./src/test/java/datadriventesting/testData.xlsx");
		wb.write(fo);
		System.out.println(wb.getSheet("org").getRow(6).getCell(0).getStringCellValue());
	
		//========================================
	
		JSONParser parser = new JSONParser();
		Object o = parser.parse(new FileReader("./src/test/java/datadriventesting/login.json"));
		JSONObject jo = (JSONObject) o ;
		System.out.println(jo.get("un"));
		System.out.println(jo.get("pwd"));
		
		//===============================================
		
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.get(url);
//		
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		//=================================================
		
		
	}
}
