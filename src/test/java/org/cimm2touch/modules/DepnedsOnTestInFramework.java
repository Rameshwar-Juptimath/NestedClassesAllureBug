package org.cimm2touch.modules;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class DepnedsOnTestInFramework {

	final static String workBookUtilitiesDependent = "WorkBookUtilitiesDependent";
	final static String workBookUtilitiesCreation = "WorkBookUtilitiesCreation";
	final static String importItemsToWorkbook = "ImportItemsToWorkbook";
	final static String removeItemsFromWorkbook = "RemoveItemFromWorkbook";
	final static String importDependent = "ItemImportDependent";

	static int index = 0;

	@Test(groups = { "regression", workBookUtilitiesCreation })
	public class WorkBookUtilitiesCreation {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Add New Work Book' functionality")
		@TestCaseId("TC_WU_006")
		@Test()
		public void TC_WU_006() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Creation");
			System.out.println("Index:" + index);
			index++;
		}
	}

	@Test(groups = { "regression", workBookUtilitiesDependent }, dependsOnGroups = { workBookUtilitiesCreation })
	public class WorkBookUtilitiesCreationDependent {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Reset' functionality")
		@TestCaseId("TC_WU_005")
		@Test(groups = { "regression", workBookUtilitiesDependent }, dependsOnGroups = { workBookUtilitiesCreation })
		public void TC_WU_005() throws Exception {
			System.out.println(
					Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + workBookUtilitiesDependent
							+ " DEPENDSONGROUP-" + workBookUtilitiesCreation + " Reset' functionality");
			System.out.println("Index:" + index);
			index++;

		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'List items in this workbook' functionality")
		@TestCaseId("TC_WU_007")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, groups = {
				"regression", workBookUtilitiesDependent }, dependsOnGroups = { workBookUtilitiesCreation })
		public void TC_WU_007(String itemListHeaders) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ workBookUtilitiesDependent + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " List items in this workbook' functionality");
		}

	}

	@Test(groups = { "regression", importItemsToWorkbook }, dependsOnGroups = { workBookUtilitiesCreation })
	public class ImportItemsToWorkBook {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of downloading template and 'Import Items to Workbook' functionality using file format as 'Part Number'")
		@TestCaseId("TC_WU_013_014")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class) // ,enabled=false)
		public void TC_WU_013_14(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " downloading template and 'Import Items to Workbook' functionality using file format as 'Part Number");
			System.out.println("Index:" + index);
			index++;
			Assert.assertTrue(false);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as Part Number, Manufacturer Name' ")
		@TestCaseId("TC_WU_015")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = {
				"TC_WU_009" }, alwaysRun = true) // , enabled = false)
		public void TC_WU_015(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " DEPENDS ON 9.(ALWAYS RUN). Import Items to Workbook' functionality using file format as Part Number, Manufacturer Name");
			System.out.println("Index:" + index);
			index++;


		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Part Number, Brand Name, Manufacturer Name'")
		@TestCaseId("TC_WU_016")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_016(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " Import Items to Workbook' functionality using file format as 'Part Number, Brand Name, Manufacturer Name");

		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Manufacturer Name'")
		@TestCaseId("TC_WU_017")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_017(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Manufacturer Name");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Brand Name'")
		@TestCaseId("TC_WU_018")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_018(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Brand Name");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'UPC'")
		@TestCaseId("TC_WU_019")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_019(String excelSheetPath, String excelSheetName, String itemAddedSuccessMsg)
				throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " Import Items to Workbook' functionality using file format as 'UPC'");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing all items from the workbook ")
		@TestCaseId("TC_WU_009")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = {
				"TC_WU_013_14" }, alwaysRun = true)
		public void TC_WU_009(String allItemsRemoveMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ importItemsToWorkbook + " DEPENDSONGROUP-" + workBookUtilitiesCreation
					+ " DEPENDS ON 13_14.(Always run). removing all items from the workbook");
			System.out.println("Index:" + index);
			index++;

		}

	}

	@Test(groups = { "regression", importDependent }, dependsOnGroups = { importItemsToWorkbook }, alwaysRun = true)
	public class ImportDependent {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of Items in the workbook")
		@TestCaseId("TC_WU_020")
		@Test(groups = { "regression", importDependent }, dependsOnGroups = { importItemsToWorkbook }, alwaysRun = true)
		public void TC_WU_020() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook + " Verification of Items in the workbook");

		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Attach Selected category'")
		@TestCaseId("TC_WU_022")
		@Test(groups = { "regression", importDependent }, dependsOnGroups = {
				importItemsToWorkbook }, alwaysRun = true, dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)
		public void TC_WU_022(String itemAssignToCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook
					+ " Bulk Item Categorization - Attach Selected category");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove old and assign selected category'")
		@TestCaseId("TC_WU_023")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = {
				"TC_WU_022" }, alwaysRun = true)
		public void TC_WU_023(String itemAssignToCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook
					+ " DEPENDS ON 22(Always run). Bulk Item Categorization - Remove old and assign selected category");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove items from selected category'")
		@TestCaseId("TC_WU_024")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = {
				"TC_WU_023" })
		public void TC_WU_024(String itemRemoveFromCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook
					+ " DEPENDS ON 23. Bulk Item categorization - Remove items from selected category");

		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of adding items to subset")
		@TestCaseId("TC_WU_026")
		@Test(groups = { "regression", importDependent }, dependsOnGroups = {
				importItemsToWorkbook }, alwaysRun = true, dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)
		public void TC_WU_026(String itemsToSubsetSuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook + " Adding items to subset");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing items from the subset")
		@TestCaseId("TC_WU_027")
		@Test(groups = { "regression", importDependent }, dependsOnGroups = {
				importItemsToWorkbook }, alwaysRun = true, dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = "TC_WU_026")
		public void TC_WU_027(String itemsToSubsetRemoveMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook + " Removing items from subset");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of adding items to new brand")
		@TestCaseId("TC_WU_028")
		@Test(groups = { "regression", importDependent }, dependsOnGroups = {
				importItemsToWorkbook }, alwaysRun = true, dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)
		public void TC_WU_028(String itemsToNewBrandSuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + importDependent
					+ " DEPENDSONGROUP-" + importItemsToWorkbook + " Adding items to new brand");

		}

	}

	@Test(groups = { "regression", removeItemsFromWorkbook }, dependsOnGroups = importDependent, alwaysRun = true)
	public class RemoveItemFromWorkbook {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing items from the workbook")
		@TestCaseId("TC_WU_008")
		@Test(groups = { "regression", removeItemsFromWorkbook }, dependsOnGroups = importDependent, alwaysRun = true)
		public void TC_WU_008() throws Exception {
			System.out.println(
					Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-" + removeItemsFromWorkbook
							+ " DEPENDSONGROUP-" + importDependent + " Remove single Item from workbook");
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Purge all items in this workbook' functionality")
		@TestCaseId("TC_WU_010")
		@Test(groups = { "regression",
				removeItemsFromWorkbook }, dependsOnGroups = importDependent, dependsOnMethods = {
						"TC_WU_008" }, alwaysRun = true)
		public void TC_WU_010() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " GROUP-"
					+ removeItemsFromWorkbook + " DEPENDSONGROUP-" + importDependent
					+ " DEPENDS ON 008(ALWAYS RUN). Purge All items from workbook");
		}

	}

	@Test(groups = { "regression" }, dependsOnGroups = { removeItemsFromWorkbook + ".*" })
	public class WorkBookUtilitiesRemoval {

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Remove this workbook' functionality")
		@TestCaseId("TC_WU_011")
		public void TC_WU_011() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " DEPENDSONGROUP-"
					+ removeItemsFromWorkbook + " (ALWAYS RUN). Delete Workbook");
		}

	}
}
