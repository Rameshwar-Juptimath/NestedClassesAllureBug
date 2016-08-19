package org.cimm2touch.modules;
import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.RandomNumberGenerator;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ItemsModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies display of records per page based on the filter chosen. 25,50,75,100 are the filter values.")
	@TestCaseId("TC_ITEMS_002")
	@Test(groups={"smoke","regression"})
	public void verifyDisplayOfNumberRecordsChosen() throws Exception{
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		data.setNumberOfRecordsToDisplay("10");
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("25");
		itemsPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("50");
		itemsPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("75");
		itemsPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("100");
		itemsPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	}

	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the fields in items page when we click show fields under the settings button.")
	@TestCaseId("TC_ITEMS_003")
	@Test(groups="regression")
	public void verifyShowFieldsInItemsPage() throws Exception{
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		String [] dynamicSettingsTableHeadings = data.getDynamicSettingsTableHeadings().split(",");
		String [] dynamicSettingsTableFieldNames = data.getDynamicSettingsTableFieldNames().split(",");
		String [] displayNamesInDynamicSettingsTableLocator = data.getDisplayNamesInDynamicSettingsTableLocator().split(",");
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSettingsIcon()
		.clickShowFields()
		.verifyShowFieldsTableHeadingsInItemsPage(dynamicSettingsTableHeadings)
		.verifyFieldNames(dynamicSettingsTableFieldNames)
		.verifyDisplayNames(displayNamesInDynamicSettingsTableLocator);
	}

	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the field that is selected is getting displayed as a column in the items list page. It also verifies that when the field is deselected the column should not get displayed.")
	@TestCaseId("TC_ITEMS_004")
	@Test(groups="regression")
	public void verifySelectedFieldIsDisplayedInItemsPage() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSettingsIcon()
		.clickShowFields()
		.selectCheckboxOfManufacturerPartNumberInDesktopViewForAdding()
		.clickOnSaveButton()
		.verifyDisplayOfManufacturerPartNumberColumn()
		.clickShowFields()
		.selectCheckboxOfManufacturerPartNumberInDesktopViewForRemoving()
		.clickOnSaveButton()
		.verifyManufacturerPartNumberColumnIsNotDisplayed();
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the taxonomy tree in the left side of the items list page")
	@TestCaseId("TC_ITEMS_006")
	@Test(groups="regression")
	public void verifyAttributesInTaxonomyTree() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		String defaultTaxonomy = landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.verifySearchTextboxInLeftNavigationbar()
		.verifyEditTaxonomyTree()
		.verifyFilterTaxonomyTree()
		.verifyClearTaxonomyTree()
		.verifyCollapseTaxonomyTree()
		.verifyRefreshTaxonomyTree()
		.verifySearchIconTaxonomyTree()
		.verifyDisplayOfLevelOneCategories()
		.homePage()
		.clickOnSystemSettingsLink()
		.systemSettingsPage()
		.getDefaultTaxonomy();
		homePage()
		.clickOnItemsLink()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.verifyDefaultTaxonomyInTaxonomyTree(defaultTaxonomy);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the search functionality in the taxonomy tree.")
	@TestCaseId("TC_ITEMS_007")
	@Test(groups="regression")
	public void verifySearchInTaxonomyTree() throws Exception {
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.enterSearchCategory(data.getCategoryToSearch())
		.clickOnSearchCategory()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(data.getCategoryToSearch());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the refresh functionality in the taxonomy tree.")
	@TestCaseId("TC_ITEMS_008")
	@Issues(value = { @Issue(value = "CIM-901") })
	@Test(groups="regression")
	public void verifyRefreshInTaxonomyTree() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.enterSearchCategory(data.getCategoryToSearch())
		.clickOnSearchCategory()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(data.getCategoryToSearch())
		.verifyWhetherValueContainsTextInsideTheTextbox(data.getCategoryToSearch())
		.clickOnRefresh()
		.verifyWhetherSearchedTaxonomyStyleIsNotGreen(data.getCategoryToSearch())
		.verifyClearingOfSearchTextbox(data.getCategoryToSearch());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies adding and clearing filter functionality in the taxonomy tree completely.")
	@TestCaseId("TC_ITEMS_013,TC_ITEMS_014")
	@Test(groups="regression")
	public void verifyAddingAndClearingOfFilter() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		 landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.clickOnSpecificCategory(data.getCategoryToSearch())
		.clickOnFilter()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.verifyCategoryChosenIsSelected(data.getCategoryToSearch())
		.homePage().clickOnLeftNavigationbar()
		.itemsPage()
		.clickOnRemoveFilter()
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.verifyCategoryChosenIsNotSelected(data.getCategoryToSearch())
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.clickOnSpecificCategory(data.getCategoryToSearch())
		.clickOnFilter()
		.clickOnSpecificEditButton(1)
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyWhetherTheProductBelongsToTheCategory(data.getCategoryToSearch())
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.verifyWhetherTheCategoryIsHighLighted(data.getCategoryToSearch());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies searching an item general search in Item List page")
	@TestCaseId("TC_ITEMS_016,TC_ITEMS_017,TC_ITEMS_020,TC_ITEMS_021,TC_ITEMS_022")
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verifyGenralSearch(String testCaseId,@Parameter("Drop down value") String Dropdownvalue,@Parameter("Searchable data") String Searchabledata) throws Exception {
		/*
		 * @author:yogish.mt
		 */
		 landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyGeneralSearch(Dropdownvalue, Searchabledata);	
	}
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which validates of list price,cost price, Quantity available, Data source, Length, Width, Height, Weight textboxes in General Info Tab.")
	@TestCaseId("{0}")
	//TC_ITEMS_028-to-TC_ITEMS_031,TC_ITEMS_36-to-TC_ITEMS_43
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void validationOfTextboxesInGeneralInfoTab(String testCaseId,@Parameter("Field Name") String fieldName,@Parameter("Text to be entered in the textbox") String textToBeEnteredInTheTextbox,@Parameter("maximum number of characters that the textbox") String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.verifyTextboxValidation(fieldName,textToBeEnteredInTheTextbox,Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies add new items page.")
	@TestCaseId("TC_ITEMS_023")
	@Test(groups="regression")
	public void verifyRightNavigationBarInAddNewItemsPage() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.verifyEnableAndDisableOfTabs()
		.verifyAllMandatoryFields(data.getAllMandatoryFieldsInAddNewItemsPage().split(","))
		//.homePage()
		//.clickOnRightNavigationBar()
		//.addNewItemPage()
		.verifyAttributtesInTheRightNavigationBar(data.getAttributesInRightNavigationBarOfAddNewItemsPage().split(","));
	}
	
	 @Features(value = {"Items Module"})
	 @Description("This is a test case which verifies adding new items")
	 @TestCaseId("TC_ITEMS_024")
	 @Test(groups={"regression"})
		public void verifyAddingNewItem() throws Exception
		{
		 /*
		  * @author:hemanth.sridhar
		  * 
		  */
		  landingPage()
		   .enterUsername( data.getUserName())
		   .enterPassword(data.getPassword())
		   .clickOnLogin()
		   .homePage()
		   .clickOnItemsLink()
		   .itemsPage()
		   .clickOnAddNewItem()
		   .addNewItemPage()
		   .clickOnManufacturerDropdown()
		   .selectManufacturerField(data.getmanufacturername())
		   .enterPartNumberField(data.getPartNumberField())
		   .clickOnBrandDropdown()
		   .selectBrandField(data.getBrnadName())
		   .clickOnSaveButtonLink()
		   .verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage()); 
		} 
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the error message when save is clicked without entering details.")
	@TestCaseId("{0}")
	//TC_ITEMS_025,26,27
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verifyErrorMessageWhenSaveIsClickedWithoutEnteringMandatoryFields(String testCaseId,@Parameter("manufacturer Part Number") String manufacturerPartNumber,@Parameter("Part Number")String partNumber,@Parameter("Brand") String brand,@Parameter("Error Message") String errorMessage) throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.enterManufacturerPartNumber(manufacturerPartNumber)
		.enterPartNumber(partNumber)
		.enterBrand(brand)
		.clickOnSave()
		.verifyErrorMessage(errorMessage.split(","));
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies Item status dropdown.")
	@TestCaseId("{0}")
	//TC_ITEMS_032
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verifyItemStatusDropdown(String testCaseId,@Parameter("Item Status Options") String statusOptions,@Parameter("Corresponding values for each status") String valueForEachStatus) throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.selectAndVerifyItemStatusOptions(statusOptions.split(","),valueForEachStatus.split(","));
	}
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the existence of display online,drop ship and print checkboxes.")
	@TestCaseId("{0}")
	//TC_ITEMS_033,TC_ITEMS_034,TC_ITEMS_035
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verifyCheckboxesInAddNewItemsPage(String testcase,@Parameter("Checkbox under test")String checkbox) throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.verifyCheckboxes(checkbox);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies that on clicking the results link in the right navigation bar of edit items page opens items list page.")
	@TestCaseId("TC_ITEMS_053")
	@Test(groups="regression")
	public void verifyResultsLinkInEditItemsPage() throws Exception {
		/*
		 * @author:hemanth.sridhar
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSpecificEditButton(1)
		.homePage()
		.clickOnRightNavigationBar()
		.editItemsPage()
		.clickOnResultsLink()
		.itemsPage()
		.verifyItemsPageBreadCrump();
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Select Workbook drop down")
	@TestCaseId("TC_ITEMS_44")
	//TC_ITEMS_44
	@Test(groups="regression")
	public void verificationOfSelectWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator();	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding of new workbook")
	@TestCaseId("TC_ITEMS_45")
	@Test(groups="regression")
	public void addNewWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getWorkbookSuccessmsg())
		.deleteWorkbook(data.getworkbookRemovemsg());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding existing workbook")
	@TestCaseId("TC_ITEMS_46")
	@Test(groups="regression")
	public void addExistingNewWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getWorkbookSuccessmsg())
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getworkbookexistingmsg())
		.deleteWorkbook(data.getworkbookRemovemsg());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding items to workbook")
	@TestCaseId("TC_ITEMS_47")
	@Test(groups="regression")
	public void addItemsToWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getWorkbookSuccessmsg())
		.clickOnSelectAllCheckBox();
		TestUtility.alertDismiss();
		itemsPage()
		.clickOnWorkbookDropdown()
		.selectWorkbook()
		.clickOnWorkbookName()
		.verifyAddItemSucessMsg(data.getadditemWorkbooksuccessmsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnWorkbookDropdown()
		.verifyWorkbookItemCount(data.getworkbookitemcount())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteWorkbook(data.getworkbookRemovemsg());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Add already existing items to workbook")
	@TestCaseId("TC_ITEMS_48")
	@Test(groups="regression")
	public void addExistItemsToWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getWorkbookSuccessmsg())
		.clickOnSelectAllCheckBox();
		TestUtility.alertDismiss();
		itemsPage()
		.clickOnWorkbookDropdown()
		.selectWorkbook()
		.clickOnWorkbookName()
		.verifyAddItemSucessMsg(data.getadditemWorkbooksuccessmsg())
		.clickOnWorkbookDropdown()
		.selectWorkbook()
		.clickOnWorkbookName()
		.verifyExistingerrormsg(data.getworkbookerrormsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteWorkbook(data.getworkbookRemovemsg());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies message in add items to workbook alert popup")
	@TestCaseId("TC_ITEMS_49")
	@Test(groups="regression")
	public void MessageofAddItemsToWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSelectAllCheckBox();
		String alertmsg = TestUtility.getAlertText();
		TestUtility.alertAccept();
		Assert.assertEquals(alertmsg, data.getWorkbookPopupMsg());
		itemsPage()
		.clickOnSelectAllCheckBox()
		.clickOnSelectAllCheckBox();
		TestUtility.alertDismiss();
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Add already existing items to workbook")
	@TestCaseId("TC_ITEMS_50")
	@Test(groups="regression")
	public void addAllItemsToWorkbook() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(data.getworkbookname())
		.clickOnSaveIcon()
		.verifySuccessMsg(data.getWorkbookSuccessmsg())
		.clickOnSelectAllCheckBox();
		TestUtility.alertAccept();
		itemsPage()
		.clickOnWorkbookDropdown()
		.selectWorkbook()
		.clickOnWorkbookName()
		.verifyAllItemsSuccessMsg(data.getworkbookname())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnWorkbookDropdown()
		.verifyAllItemsCount(data.getworkbookname())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteWorkbook(data.getworkbookRemovemsg());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the fields of edit item page")
	@TestCaseId("TC_ITEMS_51")
	@Test(groups="regression")
	public void verificationOfItemEditPage() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(data.getPartNumberField())
		.clickOnSpecificItemEditButton(data.getPartNumberField())
		.addNewItemPage()
		.verifyEnableTabsOfItemEdit()
		.editItemsPage()
		.VerifyPartnumber(data.getPartNumberField())
		.verifSaveResethistory()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the fields of right panel in edit item page")
	@TestCaseId("TC_ITEMS_52")
	@Test(groups="regression")
	public void verificationOfRightPanelItemEditPage() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.enterManufactrerPartNumber(data.getmanufacturerPartNumber())
		.enterListPrice(data.getlistPrice())
		.enterCostPrice(data.getcostPrice())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.verifyRightPanelItemFieds(data.getmanufacturerPartNumber(),data.getPartNumberField(),data.getlistPrice(),data.getcostPrice(),data.getuserrating(),data.getHits(),data.getPopularity())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies that on clicking the item link in the right navigation bar of edit items page opens edit items list page.")
	@TestCaseId("TC_ITEMS_054")
	@Test(groups="regression")
	public void verifyItemLinkInEditItemsPage() throws Exception {
	String itemId =	landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSpecificEditButton(1)
		.editItemsPage()
		.getCimmItemId();
		String getBreadCrump = editItemsPage()
		.getEditItemsBreadCrump();
		homePage()
		.clickOnRightNavigationBar()
		.editItemsPage()
		.clickOnItemLink()
		.editItemsPage()
		.verifyEditItemsBreadCrumbAndCimmItemIdValue(getBreadCrump,itemId);
	}
		
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the general info tab in edit item page")
	@TestCaseId("TC_ITEMS_58")
	@Test(groups="regression")
	public void verificationGenralInfoOfItemEditPage() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.addNewItemPage()
		.verifyEnableTabsOfItemEdit()
		.editItemsPage()
		.VerifyPartnumber(data.getPartNumberField())
		.verificationBrandManufacturerdropdown()
		.verifSaveResethistory()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the updating an item")
	@TestCaseId("TC_ITEMS_59")
	@Test(groups="regression")
	public void verificationUpdateItem() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.addNewItemPage()
		.verifyEnableTabsOfItemEdit()
		.editItemsPage()
		.reenterPartnumber(data.getupdatepartnumber())
		.clickonUpdateItemButton()
		.VerificationOfUpdateItemMsg(data.getItemUpdateMSG())
		.VerifyPartnumber(data.getupdatepartnumber())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getupdatepartnumber());	
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the reset button in item edit")
	@TestCaseId("TC_ITEMS_60")
	@Test(groups="regression")
	public void verificationresetButtoninitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.reenterPartnumber(data.getupdatepartnumber())
		.clickOnResetButton()
		.VerifyPartnumber(data.getPartNumberField())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link. ")
	@TestCaseId("TC_ITEMS_61")
	@Test(groups="regression")
	public void verifyHistoryLink() throws Exception {
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSpecificEditButton(1)
		.editItemsPage()
		.clickOnHistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		TestUtility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(data.getExpectedHistoryPageTitle());
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies contents in Description tab in item edit")
	@TestCaseId("TC_ITEMS_62")
	@Test(groups="regression")
	public void verificationOFDescriptionTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyFieldsDescriptionFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies tinyMCE editor in Description tab in item edit")
	@TestCaseId("TC_ITEMS_63")
	@Test(groups="regression")
	public void verificationOFTinyMCEDescriptionTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyTinyMceEditor()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies update description in Description tab in item edit")
	@TestCaseId("TC_ITEMS_64")
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verificationOFUpdateDescriptionTabitemEdit(String testCaseId,@Parameter("Description Tab name") String DescOptions,@Parameter("Test data") String TestData) throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verificationOfDescription(DescOptions,TestData)
		.clickonSavedescriptionButton()
		.verifyDacriptionUpdateMsg(data.getItemUpdateMSG())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link in description tab. ")
	@TestCaseId("TC_ITEMS_66")
	@Test(groups="regression")
	public void verifyHistoryLinkinDescriptions() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDescriptionTabLink()		
		.clickOnHistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		Thread.sleep(3000);
		TestUtility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(data.getItemDesctiptionHistorypagetitle())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies contents in Products tab in item edit")
	@TestCaseId("TC_ITEMS_67")
	@Test(groups="regression")
	public void verificationOFProductsTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnProductsTabLink()
		.verifyFieldsProductsFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies contents in Keywords tab in item edit")
	@TestCaseId("TC_ITEMS_71")
	@Test(groups="regression")
	public void verificationOFKeywordsTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnKeywordsTabLink()
		.verifyKeywordsTabFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies enter the value to custom keyword field in keyword tab in item edit")
	@TestCaseId("TC_ITEMS_72")
	@Test(groups="regression")
	public void verificationCustomFieldKeywordsTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnKeywordsTabLink()
		.enterDataToCustomKeywordsField(data.getcustomKeyword())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies enter the value to Meta keyword field in keyword tab in item edit")
	@TestCaseId("TC_ITEMS_73")
	@Test(groups="regression")
	public void verificationMetaFieldKeywordsTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnKeywordsTabLink()
		.enterDataToMetaKeywordsField(data.getMetaKeywordText())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());	
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies saving the values of custom,meta keyword in keywords tab in item edit")
	@TestCaseId("TC_ITEMS_74")
	@Test(groups="regression")
	public void verificationsavingValuesOfKeywordsTabitemEdit() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnKeywordsTabLink()
		.enterDataToCustomKeywordsField(data.getcustomKeyword())
		.enterDataToMetaKeywordsField(data.getMetaKeywordText())
		.clickOnKeywordSaveIcon()
		.VerifyItemupdateSuccessMsg(data.getItemUpdateMSG())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link in keywords tab. ")
	@TestCaseId("TC_ITEMS_75")
	@Test(groups="regression")
	public void verifyHistoryLinkinKeywords() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnKeywordsTabLink()
		.enterDataToCustomKeywordsField(data.getcustomKeyword())
		.enterDataToMetaKeywordsField(data.getMetaKeywordText())
		.clickOnKeywordSaveIcon()
		.VerifyItemupdateSuccessMsg(data.getItemUpdateMSG())
		.clickOnHistoryLinkInKeywordsTab()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		Thread.sleep(3000);
		TestUtility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(data.getItemKeywordsHistorypagetitle())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies content in Documents tab. ")
	@TestCaseId("TC_ITEMS_76")
	@Test(groups="regression")
	public void verifyContentInDocument() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.verifyDocumentTabFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies selecting an category from document category dropdown in Documents tab. ")
	@TestCaseId("TC_ITEMS_77")
	@Test(groups="regression")
	public void verifySelectingDocumentCatrory() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.verifySelectingDocumentCategory(data.getdocumentcategory())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies the content in add new document form in Documents tab. ")
	@TestCaseId("TC_ITEMS_78")
	@Test(groups="regression")
	public void verifyContentInAddNewDocumentFrom() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.verifyAddnewDocumentFormFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies uploading an document using document URL and removing the assigned document")
	@TestCaseId("TC_ITEMS_79,80")
	@Test(groups="regression")
	public void verifyAddNewDocumentURL() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.addNewDocumentURL(data.getdocumentCaption(),data.getdocumentURL())
		.verifySuccessMSG(data.getdocumentSuccessmsg())
		.removeAssignedDocument(data.getdocumentremoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies uploadating caption of assgined document")
	@TestCaseId("TC_ITEMS_81")
	@Test(groups="regression")
	public void verifyUpdateDocumentCaption() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.addNewDocumentURL(data.getdocumentCaption(),data.getdocumentURL())
		.verifySuccessMSG(data.getdocumentSuccessmsg())
		.clickOnEditCaption()
		.updateDocumentCaption(data.getupdateddocumentCaption())
		.clickOnUpdateDocumentButton()
		.verifySuccessMSgDocumentUpdate(data.getupdateDocumentCaptionMsg())
		.removeAssignedDocument(data.getdocumentremoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies uploadating caption of assgined document")
	@TestCaseId("TC_ITEMS_82")
	@Test(groups="regression")
	public void verifyCacelUpdateDocumentCaption() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.addNewDocumentURL(data.getdocumentCaption(),data.getdocumentURL())
		.verifySuccessMSG(data.getdocumentSuccessmsg())
		.clickOnEditCaption()
		.clickCancelButton()
		.removeAssignedDocument(data.getdocumentremoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case verifies content in docuement in category popup")
	@TestCaseId("TC_ITEMS_84")
	@Test(groups="regression")
	public void verifyDocumentCategoryPopUp() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.clickOnDocumentCatLink()
		.enterdocumentname(data.getDocumentcategoryname())
		.enterdocumentdescription(data.getDocumentCatDescription())
		.closeCatPopUp()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case validate the category name field in docuement category popup")
	@TestCaseId("TC_ITEMS_85")
	@Test(groups="regression")
	public void verifyDocumentCategoryNameField() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.clickOnDocumentCatLink()
		.clickOnDocumentCatSaveButton()
		.verifyDocmentCatNameErrorMsg(data.getDocumentCatErrorMsg())
		.enterdocumentname(data.getDocumentcategoryname())
		.closeCatPopUp()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This test case validate the docuement category description in document category popup")
	@TestCaseId("TC_ITEMS_86")
	@Test(groups="regression")
	public void verifyDocumentCategoryDescriptionField() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.clickOnDocumentCatLink()
		.enterdocumentdescription(data.getDocumentCatDescription())
		.closeCatPopUp()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This test case validate the docuement caption in document add new")
	@TestCaseId("TC_ITEMS_87")
	@Test(groups="regression")
	public void verifyDocumentCaptionField() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.verifyDocumentCaption(data.getDocumentRequiredCaptionMsg(),data.getdocumentCaption())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This test case validate the docuement URL field in document add new")
	@TestCaseId("TC_ITEMS_88")
	@Test(groups="regression")
	public void verifyDocumentURLField() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.verifyDocumentURL(data.getdocumentCaption(),data.getDocumentRequiredURLMsg(),data.getdocumentURL())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link in documents ")
	@TestCaseId("TC_ITEMS_90")
	@Test(groups="regression")
	public void verifyDocumentHistoryLink() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnDoucmentsTabLink()
		.clickOnAddnewDocumentIcon()
		.addNewDocumentURL(data.getdocumentCaption(),data.getdocumentURL())
		.verifySuccessMSG(data.getdocumentSuccessmsg())
		.clickOnDocumentHistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		Thread.sleep(3000);
		TestUtility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(data.getDocumentHistoryPageTitle())
		.editItemsPage()
		.removeAssignedDocument(data.getdocumentremoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies content in Videos tab ")
	@TestCaseId("TC_ITEMS_98")
	@Test(groups="regression")
	public void verificationOfVideosTab() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickonVideosTabLink()
		.verifyContentofVideosTab()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies content in add new videos form ")
	@TestCaseId("TC_ITEMS_99")
	@Test(groups="regression")
	public void verificationOfAddNewVideosForm() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.verifyAddnewVideoForm()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies adding new video")
	@TestCaseId("TC_ITEMS_100")
	@Test(groups="regression")
	public void verificationOfAddNewVideos() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.addNewVideoURL(data.getvideoCaption(),data.getvideoURl())
		.clickOnSaveVideoButton()
		.verifyAddVideoSaveMsg(data.getvideoSaveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies adding new video")
	@TestCaseId("TC_ITEMS_101")
	@Test(groups="regression")
	public void AlertMessageOfRemove() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.addNewVideoURL(data.getvideoCaption(),data.getvideoURl())
		.clickOnSaveVideoButton()
		.verifyAddVideoSaveMsg(data.getvideoSaveMsg())
		.clickOnAllVideoDeleteButton()
		.verifyDeleteVideoAlertMsg(data.getdeleteVideoMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies removing the assigned video")
	@TestCaseId("TC_ITEMS_102")
	@Test(groups="regression")
	public void RemovingAssignedVideo() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.addNewVideoURL(data.getvideoCaption(),data.getvideoURl())
		.clickOnSaveVideoButton()
		.verifyAddVideoSaveMsg(data.getvideoSaveMsg())
		.clickOnVideoCheckbox()
		.clickOnAssignedVideoDeleteButton()
		.VerifyVideoRemoveSuccessMsg(data.getVideotRemoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies 3 tabs - Setup Linked items, Available Linked items,List Item Link Types. ")
	@TestCaseId("TC_ITEMS_103")
	@Test(groups="regression")
	public void verifyTabsUnderLinkedItems() throws Exception {
		/*
		 * @author:hemanth.sridhar,yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.verifyTabsUnderLinkedItemsTab()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies set up linked items tab. ")
	@TestCaseId("TC_ITEMS_104")
	@Test(groups="regression")
	public void verifyTabsSetUpLinkedItemsTab() throws Exception {
		/*
		 * @author:hemanth.sridhar,yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.verifySetUpLinkedItemsTab(data.getExepectedSearchInDropdownValues().split(","))
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the content in Available Linked Items tab in lineked list items tab")
	@TestCaseId("TC_ITEMS_107")
	@Test(groups="regression")
	public void verifyTabsUnderAvailableLinkedItems() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnAvailableLinkedItems()
		.verifyContentunderAvailableLinkedItems()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the content in List Item Link Types tab in lineked list items tab")
	@TestCaseId("TC_ITEMS_108")
	@Test(groups="regression")
	public void verifyTabsUnderListItemLinkTypes() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.verifyContentunderListItemLinkTypes()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the content of add new link type form")
	@TestCaseId("TC_ITEMS_109")
	@Test(groups="regression")
	public void verifyContentInLinkTypeForm() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.clickonAddnewLinkTypeButton()
		.verifyContentAddNewLinkTypeForm()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies adding,updating,removing link type and link type alert cancel")
	@TestCaseId("TC_ITEMS_110,111,112,13,14")
	@Test(groups="regression")
	public void addingRemovinglinkType() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.clickonAddnewLinkTypeButton()
		.savingNewlinkType(data.getlinktypename(),data.getlinktypedescription())
		.verifyLinktypeSuccessMsg(data.getlinktypeSuccessMsg())
		.verificationEditingLinkTypeForm()
		.updatelinktype(data.getlinktypeupdatedescription(),data.getlinktypeupdatemsg())
		.deletelinktype(data.getlinktypename())
		.verifyLinkTypeDeleteSuccessMsg(data.getlinktypename())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies add item to subset and validating all fields in custom prices tab")
	@TestCaseId("TC_ITEMS_118,")
	@Test(groups="regression")
	public void CustomPricesTab() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnCustomPricesTab()
		.verifyCustomPricesTabFields()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies fields in attributes tab")
	@TestCaseId("TC_ITEMS_115,")
	@Test(groups="regression")
	public void ItemAttributesTab() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyAttributesTabFileds()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies adding and assinging attributes values tab")
	@TestCaseId("TC_ITEMS_116,")
	@Test(groups="regression")
	public void AddingAttributeValue() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnAttributesTab()
		.AddingValueToAttributes(data.getAttributeValue(),data.getattributeUOM(),data.getattributegroup())
		.VerifyAttributeValueMsg(data.getattributesaveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies adding data to all the fileds in custom prices tab")
	@TestCaseId("TC_ITEMS_119,120.121,122,123,124,125,126,127,128,129,130")
	@Test(groups="regression")
	public void CustomPricesdataVerificationTab() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnCustomPricesTab()
		.CheckuncheckOverpricecheckbox()
		.CheckuncheckIFPcheckbox()
		.EnterNetPrice(data.getItemNetPrice())
		.EnterpackageDescription(data.getitemPackDesc())
		.EnterItemUOM(data.getitemUom())
		.EnterPricePer(data.getPricePer())
		.EnterMinorderQTY(data.getminorderQty())
		.EnterQtyInteral(data.getQtyinterval())
		.EnterCPN(data.getCPN())
		.EnterMaterialGroup(data.getMaterialGroup())
		.EnterMaterialNumber(data.getMaterialNumber())
		.EnterUnspsc(data.getUnspsc())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies selecting item status in custom prices tab")
	@TestCaseId("TC_ITEMS_131,132,133,134")
	@Test(groups="regression")
	public void AddingItemToSubset() throws Exception {
		/*
		 * @author:yogish.mt
		 * 
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnCustomPricesTab()
		.selectingItemStatus(data.getItemStatus())
		.ClickonAddsubsetItem()
		.verifysucessmsg()
		.verifyaddandDeleteIcons()
		.EnterCPN(data.getCPN())
		.clickonSaveButtonCustomPrices()
		.VerifyUpdateitemSuccessMsg()
		.deleteItemFromSubset()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link of Custom prices tab ")
	@TestCaseId("TC_ITEMS_135")
	@Test(groups="regression")
	public void verifyHistoryLinkCustomPrices() throws Exception {
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(data.getmanufacturername())
		.enterPartNumberField(data.getPartNumberField())
		.clickOnBrandDropdown()
		.selectBrandField(data.getBrnadName())
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(data.getItemSavedSuccessfulMessage())
		.editItemsPage()
		.clickOnCustomPricesTab()
		.ClickonAddsubsetItem()
		.verifysucessmsg()
		.verifyaddandDeleteIcons()
		.clickOnCPhistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		Thread.sleep(3000);
		TestUtility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(data.getCPHistoryTitle())
		.editItemsPage()
		.removeAssignedDocument(data.getdocumentremoveMsg())
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(data.getPartNumberField());
	}
	
}
