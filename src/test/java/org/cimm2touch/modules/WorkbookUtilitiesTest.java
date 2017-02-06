package org.cimm2touch.modules;

import java.io.File;
import java.util.Hashtable;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.ExcelWriter;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class WorkbookUtilitiesTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	Hashtable<String, String> creationData=new Hashtable<String,String>();
	
	final static String workBookUtilitiesDependent = "WorkBookUtilitiesDependent";
	final static String workBookUtilitiesCreation = "WorkBookUtilitiesCreation";
	final static String importItemsToWorkbook = "ImportItemsToWorkbook";
	final static String itemImportByUPCAndPurgeItemsFromWorkbook = "ItemImportByUPCAndPurgeItemsFromWorkbook";
	final static String importDependent = "ItemImportDependent";
	final static String itemImportByPNAndRemoveAll = "ItemImportByPNAndRemoveAll";
	
	String[] itemPartNumbers = { "Auto TestPN 3311", "Auto TestPN 3312", "Auto TestPN 3313", "Auto TestPN 3314",
			"Auto TestPN 3315", "Auto TestPN 3316" };
	String manufacturerName = "Auto TestManufacturer 3313";
	String brandName = "Auto TestBrand 3313";
	String[] manufacturerPartNumbers = { "Auto TestMPN 3311", "Auto TestMPN 3312", "Auto TestMPN 3313",
			"Auto TestMPN 3314", "Auto TestMPN 3315", "Auto TestMPN 3316" };
	String[] uPCs = { "Auto UPC 3311", "Auto UPC 3312", "Auto UPC 3313", "Auto UPC 3314", "Auto UPC 3315",
			"Auto UPC 3316" };
	
	String newManufacturerName="Auto TestManufacturer 2212";
	String newBrandName="Auto TestBrand 2212";
	String subsetName="Auto TestSubset 3313";
	
	String taxonomyName = "Automation_Taxonomy";
	String categoryName = "BIKES_Automation";
	String newCategoryName = "BOOKS_Automation";
	String assignedCategoryName; 
	static int itemsCount = 0;
	
	
	
	@Test(groups = {"regression"})
	public class IndependentMentods extends PageFactoryInitializer{
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Workbook Utilities' page")
		@TestCaseId("TC_WU_001")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_001(String tabsList) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.verifyAllTabs(tabsList);
		}
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of Fields in 'Workbook' tab")
		@TestCaseId("TC_WU_002")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_002(String fieldsList) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.verifyAllWorkBookFieldHeaders(fieldsList)
			.verifyItemsInWorkbookDropDown();
		}
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Edit Workbook Name' functionality")
		@TestCaseId("TC_WU_003")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_003(String workBookName,String workBookCreationSuccessMsg, String updatedWorkbookName) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			workBookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);	
			updatedWorkbookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink();
			
			try {
				workBookUtilitiesPage()
				.verifyWorkbookAlreadyExists(workBookName)
				.clickOnRemoveButtonOfWorkbook(workBookName)
				.acceptAlert();
			} catch (TimeoutException e) {
			}
			
			workBookUtilitiesPage()
			.clickOnAddNewWorkbookButton()
			.enterWorkbookName(workBookName)
			.clickOnSaveWorkbookButton()
			.verifyWorkbookCreationSuccessMessage(workBookName,workBookCreationSuccessMsg)
			.clickOnEditWorkbookButton(workBookName)
			.enterWorkbookName(updatedWorkbookName)
			.clickOnSaveWorkbookButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyWorkbookCreationSuccessMessage(updatedWorkbookName,workBookCreationSuccessMsg)
			.clickOnRemoveButtonOfWorkbook(updatedWorkbookName)
			.acceptAlert()
			.verifyWorkbookNameNotPresentInDropDown(updatedWorkbookName);
		}
	
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of alert message when 'Save' icon is clicked without entering workbook name")
		@TestCaseId("TC_WU_004")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_004(String saveBlankWorkBookErrorMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnAddNewWorkbookButton();
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnSaveWorkbookButton()
			.verifyBlankWorkbookErrorMessage(saveBlankWorkBookErrorMsg);
		}
	
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Import Items to Workbook' page")
		@TestCaseId("TC_WU_012")
		public void TC_WU_012() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab()
			.verifySelectWorkBookDropDown()
			.verifyDownloadTemplateLink()
			.verifySelectFileFormatDropDown()
			.verifyUploadButton()
			.verifyItemsInWorkbookDropDown();
		}

		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Bulk Item Categorization' page")
		@TestCaseId("TC_WU_021")
		public void TC_WU_021() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			String taxonomyName="Automation_Taxonomy";
			String[] categoriesList = { "BIKES_Automation", "BOOKS_Automation", "CARS_Automation123",
					"MOBILES_Automation" };
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab();
			Thread.sleep(6000);
			workBookUtilitiesPage()
			.verifyForWorkbookItemsDropDown()
			.verifyMakeSelectedCategoryAsDefaultCheckbox()
			.verifyItemsInWorkbookDropDown()
			.verifyDoChangesForWorkbookItemsButton()
			.enterTaxonomyName(taxonomyName)
			.clickOnTaxonomyName(taxonomyName);
			Thread.sleep(3000);
			workBookUtilitiesPage()
			.verifyCategoriesList(categoriesList);
			
		}

		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Items to Subset' page")
		@TestCaseId("TC_WU_025")
		public void TC_WU_025() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.clickOnItemsToSubsetTab();
			Thread.sleep(6000);
			workBookUtilitiesPage()
			.verifyForWorkbookItemsDropDown()
			.verifySusbsetNameDropDown()
			.verifyDoChangesForWorkbookItemsButton()
			.verifyItemsInWorkbookDropDown()
			.verifyRemoveSelectedItemsFromWorkbookIcon();			
		}

	}
	
	
	@Test(groups={"regression", workBookUtilitiesCreation})
	public class WorkBookUtilitiesCreation extends PageFactoryInitializer{

		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Add New Work Book' functionality")
		@TestCaseId("TC_WU_006")
		public void TC_WU_006() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink();
			
			try {
				workBookUtilitiesPage()
				.verifyWorkbookAlreadyExists(data.getWorkbookName())
				.clickOnRemoveButtonOfWorkbook(data.getWorkbookName())
				.acceptAlert();
			} catch (TimeoutException e) {
			}
			
			workBookUtilitiesPage()
			.clickOnAddNewWorkbookButton()
			.enterWorkbookName(data.getWorkbookName())
			.clickOnSaveWorkbookButton()
			.verifyWorkbookCreationSuccessMessage(data.getWorkbookName(),data.getWorkbookCreationSuccessMsg());
		}
	
	}
	
	@Test(groups = { "regression", workBookUtilitiesDependent }, dependsOnGroups = { workBookUtilitiesCreation })
	public class WorkBookUtilitiesCreationDependent extends PageFactoryInitializer {
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Reset' functionality")
		@TestCaseId("TC_WU_005")
		public void TC_WU_005() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnEditWorkbookButton(data.getWorkbookName())
			.enterWorkbookName(data.getWorkbookName()+new RandomGenerator().randomAlphabetic(6))
			.clickOnResetButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyWorkbookNameAfterReset(data.getWorkbookName());
		}
	
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'List items in this workbook' functionality")
		@TestCaseId("TC_WU_007")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_007(String itemListHeaders) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnEditWorkbookButton(data.getWorkbookName())
			.clickOnListItemsInWorkbookButton(data.getWorkbookName())
			.verifyAllItemListHeaders(itemListHeaders);
		}
		
	}
	
	@Test(groups = { "regression", importItemsToWorkbook }, dependsOnGroups = { workBookUtilitiesCreation })
	public class ImportItemsToWorkBook extends PageFactoryInitializer{
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as Part Number, Manufacturer Name' ")
		@TestCaseId("TC_WU_015")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)//, enabled = false)
		public void TC_WU_015(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(5000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			workBookTemplateFile.writeToCell(1, 0, itemPartNumbers[itemsCount]);
			workBookTemplateFile.writeToCell(1, 1, manufacturerName);
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Part Number, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			try {
				workBookUtilitiesPage()
				.clickOnUploadFileButton();
			} catch (TimeoutException e) {
				workBookUtilitiesPage()
				.clickOnUploadButton()
				.enterFileLocationInUploadDialogbox(excelSheetPath)
				.clickOnUploadFileButton();
			}
			Thread.sleep(4000);
			
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
			itemsCount++;
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Part Number, Brand Name, Manufacturer Name'")
		@TestCaseId("TC_WU_016")
		@Issue(value = "Functionality not working")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,enabled=false)
		public void TC_WU_016(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(5000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			
			workBookTemplateFile.writeToCell(1, 0, itemPartNumbers[itemsCount]);
			workBookTemplateFile.writeToCell(1, 1, brandName);
			workBookTemplateFile.writeToCell(1, 2, manufacturerName);

			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Part Number, Brand Name, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			try {
				workBookUtilitiesPage()
				.clickOnUploadFileButton();
			} catch (TimeoutException e) {
				workBookUtilitiesPage()
				.clickOnUploadButton()
				.enterFileLocationInUploadDialogbox(excelSheetPath)
				.clickOnUploadFileButton();
			}
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
			itemsCount++;
		}
	
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Manufacturer Name'")
		@TestCaseId("TC_WU_017")
		@Issue(value = "Functionality not working")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,enabled=false)
		public void TC_WU_017(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(5000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			workBookTemplateFile.writeToCell(1, 0, manufacturerPartNumbers[itemsCount]);
			workBookTemplateFile.writeToCell(1, 1, manufacturerName);
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Manufacturer Part Number, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			try {
				workBookUtilitiesPage()
				.clickOnUploadFileButton();
			} catch (TimeoutException e) {
				workBookUtilitiesPage()
				.clickOnUploadButton()
				.enterFileLocationInUploadDialogbox(excelSheetPath)
				.clickOnUploadFileButton();
			}
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
			itemsCount++;
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Brand Name'")
		@TestCaseId("TC_WU_018")
		@Issue(value = "Functionality not working")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,enabled=false)
		public void TC_WU_018(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(5000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			workBookTemplateFile.writeToCell(1, 0, manufacturerPartNumbers[itemsCount]);
			workBookTemplateFile.writeToCell(1, 1, brandName);
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Manufacturer Part Number, Brand Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			try {
				workBookUtilitiesPage()
				.clickOnUploadFileButton();
			} catch (TimeoutException e) {
				workBookUtilitiesPage()
				.clickOnUploadButton()
				.enterFileLocationInUploadDialogbox(excelSheetPath)
				.clickOnUploadFileButton();
			}
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
			itemsCount++;
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing Single Item from the workbook")
		@TestCaseId("TC_WU_008")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods="TC_WU_015",enabled=false)
		public void TC_WU_008(String itemRemoveMessage) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnListItemsInWorkbook(data.getWorkbookName())
			.clickOnRemoveButtonOfItem(itemPartNumbers[0])
			.acceptAlert();
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemRemoveMsg(1, itemRemoveMessage);
			itemsCount--;
		}
	}
	
	@Test(groups = { "regression", importDependent }, dependsOnGroups = { importItemsToWorkbook },alwaysRun=true)
	public class ImportDependent extends PageFactoryInitializer{

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of Items in the workbook")
		@TestCaseId("TC_WU_020")
		public void TC_WU_020() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab()
			.selectItemsInWorkbook(data.getWorkbookName());
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsInWorkbook(itemsCount);
			
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Attach Selected category'")
		@TestCaseId("TC_WU_022")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,alwaysRun=true)
		public void TC_WU_022(String itemAssignToCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab()
			.selectForWorkbookItems("Attach Selected Category")
			.enterTaxonomyName(taxonomyName)
			.clickOnTaxonomyName(taxonomyName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.selectItemsInWorkbook(data.getWorkbookName())
			.doubleClickOnCategoryName(categoryName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnDoChangesForWorkbookItemsButton()
			.acceptAlert()
			.verifyItemAssignToCategoryMsg(itemsCount, itemAssignToCategorySuccessMsg);
			assignedCategoryName = categoryName;
		}
	
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove old and assign selected category'")
		@TestCaseId("TC_WU_023")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods={"TC_WU_022"},alwaysRun=true)
		public void TC_WU_023(String itemAssignToCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab()
			.selectForWorkbookItems("Remove Old and Assign Selected Category")
			.enterTaxonomyName(taxonomyName)
			.clickOnTaxonomyName(taxonomyName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.selectItemsInWorkbook(data.getWorkbookName())
			.doubleClickOnCategoryName(newCategoryName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnDoChangesForWorkbookItemsButton()
			.acceptAlert()
			.verifyItemAssignToCategoryMsg(itemsCount, itemAssignToCategorySuccessMsg);
			assignedCategoryName = newCategoryName;
		}
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove items from selected category'")
		@TestCaseId("TC_WU_024")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods={"TC_WU_023"},alwaysRun=true)
		public void TC_WU_024(String itemRemoveFromCategorySuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab()
			.selectForWorkbookItems("Remove Items From Selected Category")
			.enterTaxonomyName(taxonomyName)
			.clickOnTaxonomyName(taxonomyName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.selectItemsInWorkbook(data.getWorkbookName())
			.doubleClickOnCategoryName(assignedCategoryName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnDoChangesForWorkbookItemsButton()
			.acceptAlert()
			.verifyItemRemoveFromCategoryMsg(itemRemoveFromCategorySuccessMsg);
			
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of adding items to subset and Verification of removing items from the subset")
		@TestCaseId("TC_WU_026_27")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,alwaysRun=true)
		public void TC_WU_026_27(String itemsToSubsetSuccessMsg,String itemsToSubsetRemoveMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnItemsToSubsetTab()
			.selectSubsetName(subsetName);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.selectItemsInWorkbook(data.getWorkbookName());
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnDoChangesForWorkbookItemsButton()
			.acceptAlert();
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsToSubsetMsg(itemsCount, itemsToSubsetSuccessMsg);
			
			workBookUtilitiesPage()
			.selectForWorkbookItems("Remove Items From Selected Subset")
			.selectSubsetName(subsetName)
			.selectItemsInWorkbook(data.getWorkbookName());
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnDoChangesForWorkbookItemsButton()
			.acceptAlert();
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.verifyItemsToSubsetMsg(itemsCount, itemsToSubsetRemoveMsg);
			
		}
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of adding items to new brand")
		@TestCaseId("TC_WU_028")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,alwaysRun=true)
		public void TC_WU_028(String itemsToNewBrandSuccessMsg) throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		
			try {
				landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
				.clickOnWorkbookUtilitiesLink()
				.clickOnItemsToNewBrandTab();
				Thread.sleep(4000);
				workBookUtilitiesPage()
				.enterAndSelectManufacturerName(newManufacturerName);
				Thread.sleep(2000);
				workBookUtilitiesPage()
				.enterAndSelectBrandName(newBrandName)
				.selectItemsInWorkbook(data.getWorkbookName());
				Thread.sleep(4000);
				
				workBookUtilitiesPage()
				.clickOnBulkItemsToNewBrand()
				.acceptAlert();
				Thread.sleep(4000);
				workBookUtilitiesPage()
				.verifyItemsToNewBrandMsg(itemsCount, itemsToNewBrandSuccessMsg);
			} finally{
				try{
					workBookUtilitiesPage()
					.enterAndSelectManufacturerName(manufacturerName);
					Thread.sleep(2000);
					workBookUtilitiesPage()
					.enterAndSelectBrandName(brandName)
					.selectItemsInWorkbook(data.getWorkbookName());
					Thread.sleep(2000);
					
					workBookUtilitiesPage()
					.clickOnBulkItemsToNewBrand()
					.acceptAlert();
				}catch(Exception e){
					
				}
			}
			
		}

	}
	
	@Test(groups = { "regression", itemImportByPNAndRemoveAll }, dependsOnGroups = { importDependent },alwaysRun=true)
	public class ImportItemsByPNAndRemoveAll extends PageFactoryInitializer{
		
	@Features(value = {"Workbook Utitlites Module"})
	@Description("Verification of downloading template and 'Import Items to Workbook' functionality using file format as 'Part Number'")
	@TestCaseId("TC_WU_013_14")
	@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class,alwaysRun=true)//,enabled=false)
		public void TC_WU_013_14(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		String projectPath = System.getProperty("user.dir");
		excelSheetPath = projectPath + "/" + excelSheetPath;
		String templateFilePath = System.getProperty("user.home") + "\\Downloads\\WorkbookItemsTemplate.xlsx";

		File file = new File(templateFilePath);
		file.delete();
		
		landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
		.clickOnWorkbookUtilitiesLink()
		.clickOnImportItemsToWorkbookTab()
		.clickOnDownloadTemplateButton();
		
		Thread.sleep(5000);
		
		workBookUtilitiesPage()
		.verifyTemplateFileDownload(templateFilePath);
		
		ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
		workBookTemplateFile.writeToCell(1, 0, itemPartNumbers[itemsCount]);
		
		workBookUtilitiesPage()
		.selectWorkbook(data.getWorkbookName())
		.clickOnUploadButton()
		.enterFileLocationInUploadDialogbox(excelSheetPath);
		Thread.sleep(4000);
		try {
			workBookUtilitiesPage()
			.clickOnUploadFileButton();
		} catch (TimeoutException e) {
			workBookUtilitiesPage()
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton();
		}
		Thread.sleep(4000);
		workBookUtilitiesPage()
		.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
		itemsCount++;
	}

	@Features(value = { "Workbook Utitlites Module" })
	@Description("Verification of removing all items from the workbook ")
	@TestCaseId("TC_WU_009")
	@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods="TC_WU_013_14",alwaysRun=true)
		public void TC_WU_009(String allItemsRemoveMsg) throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
		.clickOnWorkbookUtilitiesLink()
		.clickOnListItemsInWorkbook(data.getWorkbookName())
		.clickOnSelectAllCheckbox();
		Thread.sleep(3000);
		workBookUtilitiesPage()
		.clickOnRemoveSelectedItemsFromWorkbook()
		.acceptAlert();
		Thread.sleep(6000);
		workBookUtilitiesPage()
		.verifyItemRemoveMsg(itemsCount, allItemsRemoveMsg);
	}
	
	}
	
	@Test(groups = { "regression", itemImportByUPCAndPurgeItemsFromWorkbook }, dependsOnGroups = itemImportByPNAndRemoveAll, alwaysRun = true)
	public class ItemImportByUPCAndPurgeItemFromWorkbook extends PageFactoryInitializer{
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'UPC'")
		@TestCaseId("TC_WU_019")
		@Issue(value = "Functionality not working, Items are being uploaded even when they are not mentioned in the excel sheet")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,alwaysRun = true)//,enabled=false)
		public void TC_WU_019(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(5000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			workBookTemplateFile.writeToCell(1, 0, uPCs[itemsCount]);
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("UPC")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			try {
				workBookUtilitiesPage()
				.clickOnUploadFileButton();
			} catch (TimeoutException e) {
				workBookUtilitiesPage()
				.clickOnUploadButton()
				.enterFileLocationInUploadDialogbox(excelSheetPath)
				.clickOnUploadFileButton();
			}
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,1);
			itemsCount++;
		}
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Purge all items in this workbook' functionality")
		@TestCaseId("TC_WU_010")
		@Test(dependsOnMethods = { "TC_WU_019" },alwaysRun = true)
		public void TC_WU_010() throws Exception{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnPurgeAllItemsInThisWorkbookButton(data.getWorkbookName())
			.acceptAlert()
			.verifyPurgeAllItemsInThisWorkbookSuccessMsg(data.getWorkbookName());
		}
		
	}
	
	@Test(groups = { "regression" }, dependsOnGroups = { itemImportByUPCAndPurgeItemsFromWorkbook }, alwaysRun = true)
	public class WorkBookUtilitiesRemoval extends PageFactoryInitializer{

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Remove this workbook' functionality")
		@TestCaseId("TC_WU_011")
		@Test(groups = { "regression" }, dependsOnGroups = { itemImportByUPCAndPurgeItemsFromWorkbook }, alwaysRun = true)
		public void TC_WU_011() throws Exception {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnRemoveButtonOfWorkbook(data.getWorkbookName())
			.acceptAlert();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyWorkbookNameNotPresentInDropDown(data.getWorkbookName());
		}
		
	}

}
