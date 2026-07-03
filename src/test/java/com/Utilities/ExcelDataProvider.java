package com.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
    public ExcelDataProvider() {
    	File src = new File("./testData/login.xlsx");
    	
    	try {
    		FileInputStream fis = new FileInputStream(src);
    		wb = new XSSFWorkbook(fis);
    	}
    	
    	catch(Exception e) {
    		System.out.println("Unable to load Xls file " + e.getMessage());
    	}
    }
    
    public String getStringData(int sheetIdx, int row, int col) {
    	return wb.getSheetAt(sheetIdx).getRow(row).getCell(col).getStringCellValue();
    }
	
}
