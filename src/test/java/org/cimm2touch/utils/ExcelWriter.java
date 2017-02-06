package org.cimm2touch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.framework.utils.ExcelLibrary;

public class ExcelWriter {

	// xls
	HSSFSheet hssfwrksheet;
	HSSFWorkbook hssfwrkbook = null;

	// xlsx
	XSSFSheet xssfwrksheet;
	XSSFWorkbook xssfwrkbook = null;
	String ExcelSheetPath;
	String sheetName;

	public ExcelWriter(String ExcelSheetPath) throws IOException {
		this.ExcelSheetPath = ExcelSheetPath;
		if (ExcelSheetPath.endsWith(".xls")) {// Initialize
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			hssfwrkbook = new HSSFWorkbook(fis);
			hssfwrksheet = hssfwrkbook.getSheet("Sheet1");
			fis.close();
		} else if (ExcelSheetPath.endsWith(".xlsx")) {
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			xssfwrkbook = new XSSFWorkbook(fis);
			xssfwrksheet = xssfwrkbook.getSheet("Sheet1");
			fis.close();
		} else {
			System.out.println("Format is invalid. The file format not supported by the custom library");
		}
	}

	public ExcelWriter(String ExcelSheetPath, String sheetName) throws IOException {
		this.ExcelSheetPath = ExcelSheetPath;
		this.sheetName = sheetName;
		// Initialize
		if (ExcelSheetPath.endsWith(".xls")) {
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			hssfwrkbook = new HSSFWorkbook(fis);
			hssfwrksheet = hssfwrkbook.getSheet(sheetName);
			fis.close();
		} else if (ExcelSheetPath.endsWith(".xlsx")) {
			File file = new File(ExcelSheetPath);
			FileInputStream fis = new FileInputStream(file);
			xssfwrkbook = new XSSFWorkbook(fis);
			xssfwrksheet = xssfwrkbook.getSheet(sheetName);
			fis.close();
		}

		else {
			System.out.println("Format is invalid. The file format not supported by the custom library");
		}
	}

	public void writeToCell(int rowNumber, int cellNumber, String textToBeWritten) throws IOException {

		FileOutputStream output_file = new FileOutputStream(new File(ExcelSheetPath));

		if (xssfwrkbook != null) {
			XSSFRow sheetrow = xssfwrksheet.getRow(rowNumber);
			if (sheetrow == null) {
				sheetrow = xssfwrksheet.createRow(rowNumber);
			}
			Cell cell = sheetrow.getCell(cellNumber);
			if (cell == null) {
				cell = sheetrow.createCell(cellNumber);
			}
			cell.setCellValue(textToBeWritten);
			xssfwrkbook.write(output_file);
		}
		if (hssfwrkbook != null) {
			HSSFRow sheetrow = hssfwrksheet.getRow(rowNumber);
			if (sheetrow == null) {
				sheetrow = hssfwrksheet.createRow(rowNumber);
			}
			Cell cell = sheetrow.getCell(cellNumber);
			if (cell == null) {
				cell = sheetrow.createCell(cellNumber);
			}
			cell.setCellValue(textToBeWritten);
			hssfwrkbook.write(output_file);
		}
		output_file.close();
	}

	public void removeAllSheetsExcludingOne(String excludedSheetName) throws IOException {
		FileOutputStream output_file = new FileOutputStream(new File(ExcelSheetPath));
		boolean sheetFound = false;
		if (xssfwrkbook != null) {
			while (xssfwrkbook.getNumberOfSheets() > 1) {
				if (xssfwrkbook.getSheetName(0).equalsIgnoreCase(excludedSheetName)) {
					sheetFound = true;
				}
				if (sheetFound) {
					xssfwrkbook.removeSheetAt(1);
				} else {
					xssfwrkbook.removeSheetAt(0);
				}
			}
			xssfwrkbook.write(output_file);
		}
		if (hssfwrkbook != null) {
			while (xssfwrkbook.getNumberOfSheets() != 1) {
				if (!hssfwrkbook.getSheetName(0).equals(excludedSheetName)) {
					sheetFound = true;
					xssfwrkbook.removeSheetAt(0);
				}
				if (sheetFound) {
					xssfwrkbook.removeSheetAt(1);
				}
			}
			hssfwrkbook.write(output_file);
		}
		output_file.close();
	}

}
