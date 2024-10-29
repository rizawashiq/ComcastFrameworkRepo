package test_NG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic_utility.ExcelUtility;

public class DataProviderss {
	
	@Test(dataProvider = "getData")
	public void demo(String fn , String ln)
	{
		System.out.println("First name " + fn + "  last name " + ln );
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu = new ExcelUtility();
		int r = eu.numberOfRows("data")  ;
		int c =  eu.numberOfColumns("data") ;
		Object[][] obj = new Object[r][c];
		for(int i = 1; i<r; i++)
		{
			for(int j=0;j<c;j++ )
			{
				obj[i][j]= eu.getDataFromExcel("data", i, j);
			}
		}
		return obj ;
	}
	
	
	
}
