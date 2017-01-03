package org.cimm2touch.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.framework.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;



public class SearchData
{

	@DataProvider(name="loginTestData",parallel = true)
	public static Object[][] loginCredentials(){
		return new  Object[][]{
			{"automationUser","unilog123##","Welcome, Automation !"}
		};
		
	}
	
	@DataProvider(name="excelSheetDataRead",parallel = true)
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());

		return data;
	}
	@DataProvider(name="ProductsModuleTest")
	public static Object[][] productsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ProductsModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/ProductsModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}
	@DataProvider(name="CreateDataConfigTest")
	public static Object[][] createDataConfigTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/CreateDataConfigTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/CreateDataConfigTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}
	@DataProvider(name="RemoveDataConfigTest")
	public static Object[][] removeDataConfigTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/RemoveDataConfigTest.xlsx");

		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/RemoveDataConfigTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	
	
	@DataProvider(name="AdvancedSearchModuleTest",parallel = true)
	public static Object[][] advancedSearchModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/AdvancedSearchModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/AdvancedSearchModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}
	
	@DataProvider(name="ItemsModuleTest",parallel = true)
	public static Object[][] itemsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ItemsModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/ItemsModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}
	@DataProvider(name="TaxonomyModuleTest",parallel = true)
	public static Object[][] taxonomyModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/TaxonomyModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/TaxonomyModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}

	@DataProvider(name="ManufacturerBrandModuleTest",parallel = true)
	public static Object[][] manufacturerBrandModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/ManufacturerBrandModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/ManufacturerBrandModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}
	

	@DataProvider(name="SubsetModuleTest",parallel = true)
	public static Object[][] SubsetModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/SubsetModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/SubsetModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}

	@DataProvider(name="VendorsModuleTest",parallel = true)
	public static Object[][] VendorsModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/VendorsModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/VendorsModuleTest.xlsx");
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
	@DataProvider(name="UOMModuleTest")
	public static Object[][] UOMModuleTest(Method methodName) throws Exception
	{
		File file = new File("resources/ExcelSheetData/UOMModuleTest.xlsx");
		ExcelLibrary excel = new ExcelLibrary("resources/ExcelSheetData/UOMModuleTest.xlsx",methodName.getName());
		Object data[][] = excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());

		return data;
	}

}