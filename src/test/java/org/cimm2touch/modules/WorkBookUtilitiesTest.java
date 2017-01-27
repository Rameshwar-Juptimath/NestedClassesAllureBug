package org.cimm2touch.modules;

import java.io.File;
import java.util.Hashtable;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.ExcelWriter;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class WorkBookUtilitiesTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	Hashtable<String, String> creationData=new Hashtable<String,String>();
	
	final static String workBookUtilitiesDependent = "WorkBookUtilitiesDependent";
	final static String workBookUtilitiesCreation = "WorkBookUtilitiesCreation";
	final static String importItemsToWorkbook = "ImportItemsToWorkbook";
	final static String removeItemsFromWorkbook = "RemoveItemFromWorkbook";
	final static String importDependent = "ItemImportDependent";
	
	@Test(groups = {"regression"})
	public class IndependentMentods extends PageFactoryInitializer{
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Workbook Utilities' page")
		@TestCaseId("TC_WU_001")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_001(String tabsList) throws Exception{
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
			workBookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);	
			updatedWorkbookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
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
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnAddNewWorkbookButton()
			.enterWorkbookName(data.getWorkbookName())
			.clickOnSaveWorkbookButton()
			.verifyWorkbookCreationSuccessMessage(data.getWorkbookName(),data.getWorkbookCreationSuccessMsg());
		}
	
	}
	
	@Test(groups = { "regression",workBookUtilitiesDependent })//,dependsOnGroups= {workBookUtilitiesCreation})
	public class WorkBookUtilitiesCreationDependent extends PageFactoryInitializer {
		
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Reset' functionality")
		@TestCaseId("TC_WU_005")
		public void TC_WU_005() throws Exception{
			
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
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnEditWorkbookButton(data.getWorkbookName())
			.clickOnListItemsInWorkbookButton(data.getWorkbookName())
			.verifyAllItemListHeaders(itemListHeaders);
		}
		
	}
	
	@Test(groups = { "regression", importItemsToWorkbook })//,dependsOnGroups= {workBookUtilitiesCreation})
	public class ImportItemsToWorkBook extends PageFactoryInitializer{
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of downloading template and 'Import Items to Workbook' functionality using file format as 'Part Number'")
		@TestCaseId("TC_WU_013_014")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class,enabled=false)
		public void TC_WU_013_14(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] itemPartNumbers = { "Auto TestPN 1", "Auto TestPN 2", "Auto TestPN 3" };
			String templateFilePath = System.getProperty("user.home") + "\\Downloads\\WorkbookItemsTemplate.xlsx";

			File file = new File(templateFilePath);
			file.delete();
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab()
			.clickOnDownloadTemplateButton();
			
			Thread.sleep(10000);
			
			workBookUtilitiesPage()
			.verifyTemplateFileDownload(templateFilePath);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < itemPartNumbers.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, itemPartNumbers[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath);
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnUploadFileButton()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,itemPartNumbers.length);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as Part Number, Manufacturer Name' ")
		@TestCaseId("TC_WU_015")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_015(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] itemPartNumbers = { "Auto TestPN 1", "Auto TestPN 2", "Auto TestPN 3" };
			String[] manufacturerNames = { "Auto TestManufacturer 2212", "Auto TestManufacturer 2212", "Auto TestManufacturer 2212" };

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(10000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < itemPartNumbers.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, itemPartNumbers[i]);
				workBookTemplateFile.writeToCell(i + 1, 1, manufacturerNames[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Part Number, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,itemPartNumbers.length);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Part Number, Brand Name, Manufacturer Name'")
		@TestCaseId("TC_WU_016")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_016(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] itemPartNumbers = { "Auto TestPN 1", "Auto TestPN 2", "Auto TestPN 3" };
			String[] brandNames = { "Auto TestBrand 2212", "Auto TestBrand 2212", "Auto TestBrand 2212" };
			String[] manufacturerNames = { "Auto TestManufacturer 2212", "Auto TestManufacturer 2212", "Auto TestManufacturer 2212" };

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(10000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < itemPartNumbers.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, itemPartNumbers[i]);
				workBookTemplateFile.writeToCell(i + 1, 1, brandNames[i]);
				workBookTemplateFile.writeToCell(i + 1, 2, manufacturerNames[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Part Number, Brand Name, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,itemPartNumbers.length);
		}
	
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Manufacturer Name'")
		@TestCaseId("TC_WU_017")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_017(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] manufacturerPartNumbers = { "Auto TestMPN 1", "Auto TestMPN 2", "Auto TestMPN 3" };
			String[] manufacturerNames = { "Auto TestManufacturer 2212", "Auto TestManufacturer 2212", "Auto TestManufacturer 2212" };

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(10000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < manufacturerPartNumbers.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, manufacturerPartNumbers[i]);
				workBookTemplateFile.writeToCell(i + 1, 1, manufacturerNames[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Manufacturer Part Number, Manufacturer Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,manufacturerPartNumbers.length);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'Manufacturer Part Number, Brand Name'")
		@TestCaseId("TC_WU_018")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_018(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] manufacturerPartNumbers = { "Auto TestMPN 1", "Auto TestMPN 2", "Auto TestMPN 3" };
			String[] brandNames = { "Auto TestBrand 2212", "Auto TestBrand 2212", "Auto TestBrand 2212" };

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(10000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < manufacturerPartNumbers.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, manufacturerPartNumbers[i]);
				workBookTemplateFile.writeToCell(i + 1, 1, brandNames[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("Manufacturer Part Number, Brand Name")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,manufacturerPartNumbers.length);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Import Items to Workbook' functionality using file format as 'UPC'")
		@TestCaseId("TC_WU_019")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, enabled = false)
		public void TC_WU_019(String excelSheetPath, String excelSheetName,String itemAddedSuccessMsg) throws Exception{
			
			String projectPath = System.getProperty("user.dir");
			excelSheetPath = projectPath + "/" + excelSheetPath;

			String[] uPCs = { "Auto UPC 1", "Auto UPC 2", "Auto UPC 3" };

			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnImportItemsToWorkbookTab();
			
			Thread.sleep(10000);
			
			ExcelWriter workBookTemplateFile = new ExcelWriter(excelSheetPath, excelSheetName);
			for (int i = 0; i < uPCs.length; i++) {
				workBookTemplateFile.writeToCell(i + 1, 0, uPCs[i]);
			}
			
			workBookUtilitiesPage()
			.selectWorkbook(data.getWorkbookName())
			.selectFileFormat("UPC")
			.clickOnUploadButton()
			.enterFileLocationInUploadDialogbox(excelSheetPath)
			.clickOnUploadFileButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyItemsAddedToWorkbookMsg(itemAddedSuccessMsg,uPCs.length);
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing all items from the workbook ")
		@TestCaseId("TC_WU_009")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class, dependsOnMethods = { "TC_WU_013_14" }, alwaysRun=true)
		public void TC_WU_009(String allItemsRemoveMsg) throws Exception {
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
			.verifyItemRemoveMsg(allItemsRemoveMsg);
		}
	
	}
		
	@Test(groups = { "regression", importDependent })//, dependsOnGroups = { importItemsToWorkbook },alwaysRun=true)
	public class ImportDependent extends PageFactoryInitializer{

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Attach Selected category'")
		@TestCaseId("TC_WU_022")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)
		public void TC_WU_022(String itemAssignToCategorySuccessMsg) throws Exception {
			
			String taxonomyName = "Automation_Taxonomy";
			String categoryName = "BIKES_Automation";
			
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
			.verifyItemAssignToCategoryMsg(itemAssignToCategorySuccessMsg);
			
		}
	
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove old and assign selected category'")
		@TestCaseId("TC_WU_023")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods={"TC_WU_022"},alwaysRun=true)
		public void TC_WU_023(String itemAssignToCategorySuccessMsg) throws Exception {
			
			String taxonomyName = "Automation_Taxonomy";
			String categoryName = "BOOKS_Automation";
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab()
			.selectForWorkbookItems("Remove Old and Assign Selected Category")
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
			.verifyItemAssignToCategoryMsg(itemAssignToCategorySuccessMsg);
			
		}
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Bulk Item Categorization' functionality by selecting 'For WorkBook Items' option as 'Remove items from selected category'")
		@TestCaseId("TC_WU_024")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class,dependsOnMethods={"TC_WU_023"},alwaysRun=true)
		public void TC_WU_024(String itemRemoveFromCategorySuccessMsg) throws Exception {
			
			String taxonomyName = "Automation_Taxonomy";
			String categoryName = "BOOKS_Automation";
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnBulkItemCategorizationTab()
			.selectForWorkbookItems("Remove Items From Selected Category")
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
			.verifyItemAssignToCategoryMsg(itemRemoveFromCategorySuccessMsg);
			
		}

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of adding items to subset")
		@TestCaseId("TC_WU_026")
		@Test(dataProvider = "WorkbookUtilitiesModuleTest", dataProviderClass = SearchData.class)
		public void TC_WU_026(String itemsToSubsetSuccessMsg) throws Exception {
			
			String subsetName="AutomationTestSubset";
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
			.verifyItemsToSubsetMsg(itemsToSubsetSuccessMsg);
			
		}
		
	}
	
	@Test(groups = { "regression", removeItemsFromWorkbook }, dependsOnGroups = importDependent, alwaysRun = true)
	public class RemoveItemFromWorkbook extends PageFactoryInitializer{
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of removing items from the workbook")
		@TestCaseId("TC_WU_008")
		public void TC_WU_008() throws Exception {
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnListItemsInWorkbook(data.getWorkbookName())
			.clickOnRemoveButtonOfItem("AutoTestPN 1")
			.acceptAlert();
			Thread.sleep(6000);
			workBookUtilitiesPage()
			.verifyItemNotPresentInList("AutoTestPN 1");
		}
		
		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Purge all items in this workbook' functionality")
		@TestCaseId("TC_WU_010")
		@Test(dependsOnMethods = { "TC_WU_008" }, alwaysRun=true)
		public void TC_WU_010() throws Exception{
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnPurgeAllItemsInThisWorkbookButton(data.getWorkbookName())
			.acceptAlert()
			.verifyPurgeAllItemsInThisWorkbookSuccessMsg(data.getWorkbookName());
		}
		
	}
	
	@Test(groups = { "regression" }, dependsOnGroups = { removeItemsFromWorkbook }, alwaysRun = true)
	public class WorkBookUtilitiesRemoval extends PageFactoryInitializer{

		@Features(value = { "Workbook Utitlites Module" })
		@Description("Verification of 'Remove this workbook' functionality")
		@TestCaseId("TC_WU_011")
		public void TC_WU_011() throws Exception {
			
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
