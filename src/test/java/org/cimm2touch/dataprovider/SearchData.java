package org.cimm2touch.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.cimm2touch.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class SearchData {

	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}

	@DataProvider(name="TaxonomyModuleTest")
	public static Object[][] taxonomyModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/TaxonomyModuleTest.xlsx");
		Object data[][] = ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
}