package org.cimm2touch.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.framework.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class SearchData
{

	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	@DataProvider(name="CreateDataConfigTest")
	public static Object[][] createDataConfigTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/CreateDataConfigTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/CreateDataConfigTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	@DataProvider(name="RemoveDataConfigTest")
	public static Object[][] removeDataConfigTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/RemoveDataConfigTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/RemoveDataConfigTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	@DataProvider(name="AdvancedSearchModuleTest")
	public static Object[][] advancedSearchModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/AdvancedSearchModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/AdvancedSearchModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	
	@DataProvider(name="ItemsModuleTest")
	public static Object[][] itemsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ItemsModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/ItemsModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	@DataProvider(name="TaxonomyModuleTest")
	public static Object[][] taxonomyModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/TaxonomyModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/TaxonomyModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

	@DataProvider(name="ManufacturerBrandModuleTest")
	public static Object[][] manufacturerBrandModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ManufacturerBrandModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/ManufacturerBrandModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

	@DataProvider(name="SubsetModuleTest")
	public static Object[][] SubsetModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/SubsetModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/SubsetModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

	@DataProvider(name="VendorsModuleTest")
	public static Object[][] VendorsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/VendorsModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/VendorsModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}

}