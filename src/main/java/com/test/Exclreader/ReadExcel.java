package com.test.Exclreader;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	FileInputStream fis;
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ReadExcel(String ExcelFile_Path)
	{
		try 
		{
			fis= new FileInputStream(ExcelFile_Path);
			wbook=new XSSFWorkbook(fis);
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public Object [][] getDataFromExcel(String sheetname)
	{
		XSSFSheet sheet=wbook.getSheet(sheetname); //get the sheet from workbook
		int totalRow=sheet.getLastRowNum()+1; // count total no of active rows
		int totalColumn=sheet.getRow(0).getLastCellNum(); //count no. active columns in row
		
         // now we are create 2 D array 
		Object LoginData[][]=new Object[totalRow-1][totalColumn];
		
		//Now Run for loop and store data in above array
		
		for(int i=1;i<totalRow;i++) // Run for loop for rows
		{
			XSSFRow row=sheet.getRow(i);
			
			for(int j=0;j<totalColumn;j++) // this for loop run on column of that row
			{
				XSSFCell cell=row.getCell(j);
				
				
			     LoginData[i-1][j]=cell.getStringCellValue();
			     	
			}
		}
		
		return LoginData;
	  
	}

}
