package com.sevenmartsupermarket.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fileInputStream;
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	public String getExcel(int i,int j) throws IOException {
		String excelPath = System.getProperty("user.dir")+("//ExcelFiles//Push notification data.xlsx");
		fileInputStream = new FileInputStream(excelPath);
		workBook = new XSSFWorkbook(fileInputStream);
		sheet = workBook.getSheet("notifications");
		Row row=sheet.getRow(i);
		Cell cell=row.getCell(j);
		return cell.getStringCellValue();
	}

}
