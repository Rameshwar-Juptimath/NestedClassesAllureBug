package org.cimm2touch.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.cimm2touch.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class SearchData
{

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

	@DataProvider(name="ManufacturerBrandModuleTest")
	public static Object[][] manufacturerBrandModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ManufacturerBrandModuleTest.xlsx");
		Object data[][] = ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

	@DataProvider(name="SubsetModuleTest")
	public static Object[][] SubsetModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/SubsetModuleTest.xlsx");
		Object data[][] = ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

	@DataProvider(name="VendorsModuleTest")
	public static Object[][] VendorsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/VendorsModuleTest.xlsx");
		Object data[][] = ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

}