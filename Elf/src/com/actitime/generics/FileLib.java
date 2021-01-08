package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Note: Generic class for data driven testing
 * @author SOUMYASANTA SAHOO
 *
 */

public class FileLib {

	/**
	 * Note: This is generic method to read the data from Property File
	 * @param path
	 * @param key
	 * @return String Value
	 * @throws IOException
	 */

	public String getPropertyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

	/**
	 *Note: This is generic method to read the data from Excel File
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return String Value
	 * @throws IOException
	 */

	public String getExcelValue(String sheetname,int row,int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Data/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	/**
	 * Note: This is Generic method to Write data into Excel File
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws IOException
	 */

	public void setExcelValue(String sheetname,int row,int cell,String value) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Data/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./Data/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
