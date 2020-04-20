package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class RoughExcel {
	static Workbook book;
	static Sheet sheet;
	static FileInputStream fip;
public static void main(String[] args) throws FileNotFoundException {
 String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/crm/qa/testData/crmData.xlsx";

		File file = new File(TESTDATA_SHEET_PATH);
		fip = new FileInputStream(TESTDATA_SHEET_PATH);
		
		
	
	
}
}
