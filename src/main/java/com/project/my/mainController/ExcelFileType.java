package com.project.my.mainController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileType {

	public static Workbook getWorkbook(String filePath) throws Exception {

		FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = null;

        if(filePath.toUpperCase().endsWith(".XLS")) {
        	wb = new HSSFWorkbook(fis);
        }
        else if(filePath.toUpperCase().endsWith(".XLSX")) {
        	wb = new XSSFWorkbook(fis);
        }

        return wb;

    }
}
