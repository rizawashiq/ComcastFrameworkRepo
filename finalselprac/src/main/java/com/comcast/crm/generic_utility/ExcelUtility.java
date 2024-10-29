package com.comcast.crm.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheet , int row , int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream("./test_data/data.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		return wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public void setDataToExcel(String sheet , int row , int cell , String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream("./test_data/data.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
		
	}
	
	public  int numberOfRows(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream("./test_data/data.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		return wb.getSheet(sheet).getPhysicalNumberOfRows();
		
	}
	
	public  int numberOfColumns(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream("./test_data/data.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		return wb.getSheet(sheet).getRow(0).getPhysicalNumberOfCells()	;	
	}
	
	
}
