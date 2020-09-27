
package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
private static final String WorkBookFactory = null;
public static long page_load_timeout =20;
public static long implicit_wait =20;
//static String filePath = "C:\\Users\\kunal\\Desktop\\exceldrivendata.xlsx";

static Sheet sheet;
static Workbook work;
public static Object[][] testData(String sheetname) {
	
	//ArrayList<Object[]> testdata = new ArrayList<Object[]>();
	FileInputStream file = null;
	try {
		file = new FileInputStream(prop.getProperty("dataSheetPath"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		work = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet = work.getSheet(sheetname);
	Object[][] objArray = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(i+1).getLastCellNum();j++)
		{
			objArray[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	//testdata.add(objArray);
	return objArray;
		}
	

}
