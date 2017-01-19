package org.cimm2touch.modules;
import java.awt.ItemSelectable;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.framework.utils.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ItemsModuleTest extends PageFactoryInitializer 
{
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TestUtilityMethods utility=new TestUtilityMethods(getDriver());
	TestUtility tu=new TestUtility(getDriver());
	RandomGenerator random=new RandomGenerator();
	
HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public ItemsModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}

	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies display of records per page based on the filter chosen. 25,50,75,100 are the filter values.")
	@TestCaseId("TC_ITEMS_002")
	@Test(groups={"smoke","regression"}, dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyDisplayOfNumRecordsChosen(String testCaseId, String userName, String password, String welComeMessage ) throws Exception
	{
		
		data.setNumberOfRecordsToDisplay("10");
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyShowFieldsInItemsPage(String testCaseId, String userName, String password, String dynamicSettingTableHeader, String dynamicSettingsTableFieldName , String displayNamesInDynamicSettingsTableLocators) throws Exception{
		
		String [] dynamicSettingsTableHeadings = dynamicSettingTableHeader.split(",");
		String [] dynamicSettingsTableFieldNames = dynamicSettingsTableFieldName.split(",");
		String [] displayNamesInDynamicSettingsTableLocator =displayNamesInDynamicSettingsTableLocators.split(",");
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifySelectedFieldIsDisplayed(String testCaseId, String userName, String password,String welcomeMessage) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAttributesInTaxonomyTree(String testCaseId, String userName, String password,String welcomeMessage) throws Exception {
		
		String defaultTaxonomy = landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnItemsLink()
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
		.itemsPage()
		.verifyDefaultTaxonomyInTaxonomyTree(defaultTaxonomy);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the search functionality in the taxonomy tree.")
	@TestCaseId("TC_ITEMS_007")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifySearchInTaxonomyTree(String testCaseId, String userName, String password,String welcomeMessage, String category) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnItemsLink()
		.itemsPage()
		.enterSearchCategory(category)
		.clickOnSearchCategory()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(category);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the refresh functionality in the taxonomy tree.")
	@TestCaseId("TC_ITEMS_008")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyRefreshInTaxonomyTree(String testCaseId, String userName, String password,String welcomeMessage,String category, String taxonomy ) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnItemsLink()
		.itemsPage()
		.searchForTaxonomy(taxonomy)
		.clickOnFilter()
		.enterSearchCategory(category)
		.clickOnSearchCategory()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(category)
	//	.verifyWhetherValueContainsTextInsideTheTextbox(category)
	//	.clickOnRefresh()
		.verifyWhetherSearchedTaxonomyStyleIsNotGreen(category)
		.verifyClearingOfSearchTextbox(category);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies adding and clearing filter functionality in the taxonomy tree completely.")
	@TestCaseId("TC_ITEMS_013,TC_ITEMS_014")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddingAndClearingOfFilter(String testCaseId,String categoryName) throws Exception {
		
		 landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.clickOnSpecificCategory(categoryName)
		.clickOnFilter()
		.itemsPage()
		.verifyCategoryChosenIsSelected(categoryName)
		.verifyCategoryChosenIsNotSelected(categoryName)
		.clickOnSpecificCategory(categoryName)
		.clickOnFilter()
		.clickOnSpecificEditButton(1)
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyWhetherTheProductBelongsToTheCategory(categoryName)
		.itemsPage()
		.verifyWhetherTheCategoryIsHighLighted(categoryName);
	}
	
	@Features(value = {"Items Module"})
	@Description("verification of general search in Item List page {0}")
	@TestCaseId("TC_ITEMS_016,TC_ITEMS_017,TC_ITEMS_020,TC_ITEMS_021,TC_ITEMS_022")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyGenralSearch(String testCaseId,@Parameter("Drop down value") String Dropdownvalue,@Parameter("Searchable data") String Searchabledata) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void validationOfTextboxes(String testCaseId,@Parameter("Field Name") String fieldName,@Parameter("maximum number of characters that the textbox") String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		String  textToBeEnteredInTheTextbox=random.random(52, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyRightNavigationBar(String testCaseId,String allMandotoryFieldsInAddItem, String AttributesInRightNavigationBarOfAddNewItemsPage) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.verifyEnableAndDisableOfTabs()
		.verifyAllMandatoryFields(allMandotoryFieldsInAddItem.split(","))
		.verifyAttributtesInTheRightNavigationBar(AttributesInRightNavigationBarOfAddNewItemsPage.split(","));
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the error message when save is clicked without entering details.")
	@TestCaseId("{0}")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddingNewItem_ES(String testCaseId,String manufacturerPartNumber,String partNumber, String brand, String errorMessage) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		 .enterPassword(loginData.get("password"))
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
	@TestCaseId("TC_ITEMS_032")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyItemStatusDropdown(String testCaseId, String statusOptions, String valueForEachStatus) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))

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
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyCheckboxes(String testCaseId,String checkbox) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		 .enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.verifyCheckboxes(checkbox);
	}
	
	@Features(value = {"Items Module"})
	@Description("Verification of 'Select Workbook' drop down")
	@TestCaseId("TC_ITEMS_044")
	@Test(groups="regression")
	public void VerificationOfSelectWorkbookDropDown() throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator();
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding and rename of new workbook")
	@TestCaseId(" TC_ITEMS_45,TC_ITEMS_45")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addNewWorkbook(String testCaseId, String workBookName, String workBookSuccesMsg, String reNameErroMsg,String workBookRemoveMsg) throws Exception {
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.verifyWorkBookExist(workBookName, workBookRemoveMsg)
		//.verifyWorkBookName(workBookName,workBookRemoveMsg)
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifySuccessMsg(workBookName,workBookSuccesMsg)
		.clickOnWorkbookDropdown()
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifyErrorMessageForReName(workBookName,reNameErroMsg)
		.deleteWorkbook(workBookName,workBookRemoveMsg);
	
	}finally
		{
		itemsPage().verifyWorkBookName(workBookName,workBookRemoveMsg);
		}
	}
	
	
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding items to workbook")
	@TestCaseId("TC_ITEMS_47")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addItemsToWorkbook(String testCaseId, String workBookName, String workBookSuccesMsg, String noOfItemsToBeSelect, String workbookRemovemsg) throws Exception {
	
		try{ 
			landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.verifyWorkBookName(workBookName,workbookRemovemsg)
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifySuccessMsg(workBookName,workBookSuccesMsg)
		.clickOnSpecficCheckBoxes(noOfItemsToBeSelect)
		.clickOnWorkbookDropdown()
		.selectWorkbook(workBookName)
		.clickOnWorkbookName()
		.verifyAddItemSucessMsg(noOfItemsToBeSelect,workBookName)
		.clickOnWorkbookDropdown()
		.verifyWorkbookItemCount(noOfItemsToBeSelect)
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteWorkbook(workBookName,workbookRemovemsg);
		
		}finally
		{
		itemsPage()
		.verifyWorkBookName(workBookName,workbookRemovemsg);
		}
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies message in add items to workbook alert popup")
	@TestCaseId("TC_ITEMS_49")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void MessageofAddItemsToWorkbook(String testCaseId, String alertTextMessage) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSelectAllCheckBox()
		.verifyAlertMessage(alertTextMessage);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of item edit page")
	@TestCaseId("TC_ITEMS_51")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfEditItemPage(String testCaseId, String alertTextMessage) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSelectAllCheckBox()
		.verifyAlertMessage(alertTextMessage);
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies the fields of right panel in edit item page")
	@TestCaseId("TC_ITEMS_52")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfRightPanel(String testCaseId, String manufacturerName,String brandName, String partNumber,
			String manufacturerPartNumber, String listPrice, String costPrice, String itemSaveSuccessMsg,String userRating, String hits, String popularity) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(manufacturerName)
		.enterPartNumberField(partNumber)
		.clickOnBrandDropdown()
		.selectBrandField(brandName)
		.enterManufactrerPartNumber(manufacturerPartNumber)
		.enterListPrice(listPrice)
		.enterCostPrice(costPrice)
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(itemSaveSuccessMsg)
		.editItemsPage()
		.verifyRightPanelItemFieds(manufacturerPartNumber,partNumber,listPrice,costPrice,userRating,hits,popularity)
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(partNumber);	
	}
	
	@Features(value = {"Items Module"})
	@Description("Verification of 'Results' link functionality in item edit page")
	@TestCaseId("TC_ITEMS_053")
	@Test(groups="regression")
	public void verifyResultsLinkInEditItemsPage() throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSpecificEditButton(1)
		.editItemsPage()
		.clickOnResultsLink()
		.itemsPage()
		.verifyItemsPageBreadCrump();
	}
	@Features(value = {"Items Module"})
	@Description("verification of clicking the item link in the right navigation bar of edit items page opens edit items list page.")
	@TestCaseId("TC_ITEMS_054")
	@Test(groups="regression")
	public void verifyItemLinkInEditItemsPage() throws Exception {
	String itemId =	landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
		.editItemsPage()
		.clickOnItemLink()
		.editItemsPage()
		.verifyEditItemsBreadCrumbAndCimmItemIdValue(getBreadCrump,itemId);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Search' icon functionality in item edit page")
	@TestCaseId("TC_ITEMS_55")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifySearchFnEditItem(String testCase, String partNumber) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.searchForItem(partNumber)
		.clckOnSearchButton()
		.itemsPage()
		.verifyItemSearchResults(partNumber);
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of previous item displayed when 'Previous Item'and 'Next Item' icon is clicked")
	@TestCaseId("TC_ITEMS_56, TC_ITEMS_57")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyNextPreviousEditItem(String testCaseId, String partNumber) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink();
		String searchResults=itemsPage()
		.searchItem(partNumber)
		.clickOnFirstEditButton()
		.editItemsPage()
		.getTheItemPartNumber(partNumber);
		editItemsPage()
		.clickOnNextItemIcon()
		.verifyTheResultsForNextItem(searchResults)
		.clickOnPreviousItemIcon()
		.verifyTheResultsForPrevious(searchResults);
	}
	@Features(value = {"Items Module"})
	@Description("verification 'General Info' tab in item edit page")
	@TestCaseId("TC_ITEMS_58")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyGeneralInfoTab(String testCaseId, String partNumber, String manufacturerName, String brandName, String mpn) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink();
		itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.verifyGeneralInfoTabWithPreFilledData(partNumber, manufacturerName,brandName,mpn);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of updating item information")
	@TestCaseId("TC_ITEMS_59")
	@Issue("")
	@Test(enabled=false,groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyItemUpdateFunctionality(String testCaseId, String partNumber, String manufacturerName,
			String brandName, String mpn, String itemSaveSuccessMsg, String updatedPartNumber, String updateSuccessMessage) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnAddNewItem()
		.addNewItemPage()
		.clickOnManufacturerDropdown()
		.selectManufacturerField(manufacturerName)
		.enterPartNumberField(partNumber)
		.clickOnBrandDropdown()
		.selectBrandField(brandName)
		.enterManufactrerPartNumber(mpn)
		.clickOnSaveButtonLink()
		.verifyItemSavedSuccessfulMessage(itemSaveSuccessMsg);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.updateThePartNumber(updatedPartNumber)
		.clickonUpdateItemButton()
		.VerifyUpdateitemSuccessMsg(updateSuccessMessage)
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteItem(updatedPartNumber);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Reset' icon functionality")
	@TestCaseId("TC_ITEMS_60")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyResetFunctionality(String testCaseId, String partNumber, String manufacturerName,
			String brandName, String mpn, String dataUpdate) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.updateThefields(dataUpdate)
		.clickOnResetButton()
		.verifyGeneralInfoTabWithPreFilledData(partNumber, manufacturerName,brandName,mpn);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Histoty' icon ")
	@TestCaseId("TC_ITEMS_61")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyHistory(String testCaseId, String partNumber, String alertTextWhenHistoryIsClicked,String expectedHistoryPageTitle) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnHistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		historyPage()
		.verifyPageTitle(expectedHistoryPageTitle);
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Histoty' icon ")
	@TestCaseId("TC_ITEMS_62")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyDescriptionTab(String testCaseId, String partNumber,String descriptionFields) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyDescriptionFields(descriptionFields);
		
         
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Tiny MCE' editor display")
	@TestCaseId("TC_ITEMS_63")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyTinyMceEditorDisplay(String testCaseId, String partNumber,String descriptionFields) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyDescriptionFields(descriptionFields)
		.verifyTinyMceEditor();
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of updating descriptions")
	@TestCaseId("TC_ITEMS_64")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfUpdatingDesc(String testCaseId, String partNumber,String descriptionFields, String descOptions, String testData, String itemUpdateMessage) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verificationOfDescription(descOptions,testData)
		.clickonSavedescriptionButton()
		.verifyDacriptionUpdateMsg(itemUpdateMessage);
		
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of description display in the selected language")
	@TestCaseId("TC_ITEMS_65")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfDescLang(String testCaseId, String partNumber, String languageCode) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyLanguageOptions(languageCode);
	}
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies history link in description tab. ")
	@TestCaseId("TC_ITEMS_66")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyHistoryLinkInDesc(String testCaseId, String partNumber, String alertTextWhenHistoryIsClicked, String itemDesctiptionHistorypagetitle) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()		
		.clickOnHistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		historyPage()
		.verifyPageTitle(itemDesctiptionHistorypagetitle);
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies contents in Products tab in item edit")
	@TestCaseId("TC_ITEMS_67")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOFProductsTab(String testCaseId, String partnumber, String productFields) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partnumber)
		.clickOnEditButton(partnumber)
		.editItemsPage()
		.clickOnProductsTabLink()
		.verifyProductFields(productFields)
		.verifyFieldsProductsFields();
	}
	@Features(value = {"Items Module"})
	@Description("Verification of saving the item to the product, Verification of Search functionality, Verification of saving the item to the product, Verification of delink the saved item from the product")
	@TestCaseId("TC_ITEMS_68_69_70")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyProductSave(String testCaseId, String partnumber, String productName, String succesMessage, String delinkSuccessMessage) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partnumber)
		.clickOnEditButton(partnumber)
		.editItemsPage()
		.clickOnProductsTabLink()
		.serchForItemInProductsTab(productName)
		.clickOnSaveThisProductLink(productName)
		.verifySuccessMessageForProductAssign(succesMessage);
		editItemsPage()
		.clickOnDelinkProductLink()
		.verifySuccessMessageForDelink(delinkSuccessMessage);
	}
	@Features(value = {"Items Module"})
	@Description("Verification of 'Keywords' page in item edit")
	@TestCaseId("TC_ITEMS_71")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyKeywordsTab(String testCaseId, String partnumber) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partnumber)
		.clickOnEditButton(partnumber)
		.editItemsPage()
		.clickOnKeywordsTab()
		.verifyKeywordsTabFields();
		
	}
	@Features(value = {"Items Module"})
	@Description("To validate meta keyword field")
	@TestCaseId("TC_ITEMS_72")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyKeywordsTabMeta(String testCaseId, String partNumber, String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		String metaKeywordText=random.random(2005, PermittedCharacters.ALPHANUMERIC);
	
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnKeywordsTab()
		.verifyKeywordsTabFields()
		.enterDataToMetaKeywordsField(metaKeywordText)
		.verifyMetaKeywordEnteredData(metaKeywordText, Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
	}
	@Features(value = {"Items Module"})
	@Description("To validate custom keyword field")
	@TestCaseId("TC_ITEMS_73")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyKeywordsTabCustom(String testCaseId, String partNumber, String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		String customKeyword=random.random(2005, PermittedCharacters.ALPHANUMERIC);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnKeywordsTab()
		.verifyKeywordsTabFields()
		.enterDataToCustomKeywordsField(customKeyword)
		.verifyCustomFieldEnteredData(customKeyword, Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of updating keywords")
	@TestCaseId("TC_ITEMS_74")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyKeywordsUpdate(String testCaseId, String partNumber, String updateSuccessMessageForKeywords) throws Exception {
		String testData=random.random(200, PermittedCharacters.ALPHANUMERIC);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnKeywordsTab()
		.verifyKeywordsTabFields()
		.enterDataToCustomKeywordsField(testData)
		.enterDataToMetaKeywordsField(testData)
		.clickOnSaveKeywordsButton()
		.verifyUpdateKeywordSuccessMessage(updateSuccessMessageForKeywords);
		
		
		
	}
	@Features(value = {"Items Module"})
	@Description("Verification of History icon")
	@TestCaseId("TC_ITEMS_75")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyKeywordsHistory(String testCaseId, String partNumber, String updateSuccessMessageForKeywords, String alertTextWhenHistory, String itemKeywordsHistorypagetitle) throws Exception {
		String testData=random.random(15, PermittedCharacters.ALPHANUMERIC);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		 .homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnKeywordsTab()
		.verifyKeywordsTabFields()
		.enterDataToCustomKeywordsField(testData)
		.enterDataToMetaKeywordsField(testData)
		.clickOnSaveKeywordsButton()
		.verifyUpdateKeywordSuccessMessage(updateSuccessMessageForKeywords)		
		.clickOnHistoryLinkInKeywordsTab()
		.verifyAlertMsg(alertTextWhenHistory);
		utility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(itemKeywordsHistorypagetitle);
	}
	String resourceLocation = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
	@Features(value={"Items Module"})
	@Description("adding the document to item(s)")
	@TestCaseId("TC_ITEMS_76_77")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addDocumenttoItems(String testCaseId, String partNumber, String documentCaption,String documentLocation) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.enterDocumentCaption(documentCaption)
		.UploadDocument(documentLocation)
		.assignDocument();
	}finally{
		editItemsPage().removeAssignedDocument();
	}
	}

	@Features(value={"Items Module"})
	@Description("Verification of adding new document page")
	@TestCaseId("TC_ITEMS_78_83")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddNewDocument(String testCaseId, String partNumber, String documentCategory) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.verifySelectingDocumentCategory(documentCategory);
	}
	finally{
		editItemsPage().removeAssignedDocument();
	}
	}
	@Features(value={"Items Module"})
	@Description("adding the image url to item(s)")
	@TestCaseId("TC_ITEMS_79_80_84")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addDocumentURLtoItems(String testCaseId,String partNumber, String documentCaption, String documentURL, String successMessageForUrlAdded) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.addNewDocumentURL(documentCaption, documentURL)
		.clickOnAddnewDocumentUrlButton()
		.verifysuccessMessageForUrlAdded(successMessageForUrlAdded)
		.removeAssignedDocumentByTheUrl(documentCaption,documentURL);
	}
	finally{
		editItemsPage().verifyAssignedDocumentByTheUrl(documentCaption, documentURL);
	}
	

}
	
	@Features(value={"Items Module"})
	@Description("Verification of updating the document caption")
	@TestCaseId("TC_ITEMS_81")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void updateDocCationToItems(String testCaseId,String partNumber, String documentCaption, String documentURL, String successMessageForUrlAdded, String successMessageForUpdate) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.verifyAssignedDocumentByTheUrl(documentCaption, documentURL)
		.clickOnAddNewDocumentButton()
		.addNewDocumentURL(documentCaption, documentURL)
		.clickOnAddnewDocumentUrlButton()
		.verifysuccessMessageForUrlAdded(successMessageForUrlAdded)
		.clickOnEditCaptionIcon(documentURL)
		.addNewDocumentURL(documentCaption, documentURL)
		.clickOnAddnewDocumentUrlButton()
		.verifySuccessMSgDocumentUpdate(successMessageForUpdate)
		.removeAssignedDocumentByTheUrl(documentCaption,documentURL);
		}
		finally{
			editItemsPage().verifyAssignedDocumentByTheUrl(documentCaption, documentURL);
		}
		
	
	}
	@Features(value={"Items Module"})
	@Description("Verification of cancel(x) icon")
	@TestCaseId("TC_ITEMS_82")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfCancel(String testCaseId,String partNumber, String documentCaption, String documentURL, String successMessageForUrlAdded, String successMessageForUpdate) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.verifyAssignedDocumentByTheUrl(documentCaption, documentURL)
		.clickOnAddNewDocumentButton()
		.addNewDocumentURL(documentCaption, documentURL)
		.clickOnAddnewDocumentUrlButton()
		.verifysuccessMessageForUrlAdded(successMessageForUrlAdded)
		.clickOnEditCaptionIcon(documentURL)
		.clickCancelButton()
		.verifyCancelFunctionality();
		}
		finally{
			editItemsPage().verifyAssignedDocumentByTheUrl(documentCaption, documentURL);
		}
	}
	@Features(value={"Items Module"})
	@Description("Verification of error messages")
	@TestCaseId("TC_ITEMS_85")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addDocumentURL_ES(String testCaseId,String partNumber, String documentCaption, String documentURL, String fieldName, String errorMessage) throws Exception
	{
	
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.addNewDocumentURL(documentCaption, documentURL)
		.clickOnAddnewDocumentUrlButton()
		.verifyErrorMessages(fieldName, errorMessage);
		
		
	}
	@Features(value={"Items Module"})
	@Description("To validate category description field")
	@TestCaseId("TC_ITEMS_86_89")
	@Test(enabled=false,groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addNewItemDocDescription(String testCaseId,String partNumber, String documentCategoryName, String documentCategoryDescription, String documentSaveSuccessMessage) throws Exception
	{
	
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.clickOnAddNewItemDocumentCategoryLink()
		.addNewDocumentCategoryName(documentCategoryName)
		.addNewDocumentCategoryDescription(documentCategoryDescription)
		.clickOnDocumentCatSaveButton()
		.verifySuccessMessageForDocumentCategorySave(documentSaveSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("To validate document caption field")
	@TestCaseId("TC_ITEMS_87")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void validateDocCategoryName(String testCaseId,String partNumber, String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception
	{
	String documentCategoryName=random.random(110, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.clickOnAddNewItemDocumentCategoryLink()
		.addNewDocumentCategoryName(documentCategoryName)
		.clickOnDocumentCatSaveButton()
		.verifyDocCategoryName(documentCategoryName, Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
}
	
	@Features(value={"Items Module"})
	@Description("To validate category description field")
	@TestCaseId("TC_ITEMS_88")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void validateDocCategoryDescription(String testCaseId,String partNumber, String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception
	{
		String documentCategoryDescription=random.random(510, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.clickOnAddNewItemDocumentCategoryLink()
		.addNewDocumentCategoryDescription(documentCategoryDescription)
		.validateDocCategoryDescription(documentCategoryDescription, Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
}
	@Features(value={"Items Module"})
	@Description("To validate category description field")
	@TestCaseId("TC_ITEMS_90")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyDocDescriptionHistory(String testCaseId,String partNumber, String alertTextWhenHistoryIsClicked, String documentHistoryPageTitle) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnDocumentHistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		Thread.sleep(3000);
		utility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(documentHistoryPageTitle);
}
	@Features(value={"Items Module"})
	@Description("Verification of 'Videos' page")
	@TestCaseId("TC_ITEMS_98")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyItemVideosTab(String testCaseId,String partNumber) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickonVideosTabLink()
		.verifyContentofVideosTab();
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Add New Item Video window' page")
	@TestCaseId("TC_ITEMS_99")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddNewVideoWindow(String testCaseId,String partNumber) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.verifyAddnewVideoForm();
	}
	@Features(value={"Items Module"})
	@Description("Verification of adding new video")
	@TestCaseId("TC_ITEMS_100_102")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddNewVideo(String testCaseId,String partNumber, String videoCaption, String videoURl, String videoSaveMessage, String videoRemoveSuccessMessage) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickonVideosTabLink()
		.clickAddNewVideoButton()
		.addNewVideoURL(videoCaption,videoURl)
		.clickOnSaveVideoButton()
		.verifyAddVideoSaveMsg(videoSaveMessage);
		
	}
	finally{
		editItemsPage().removeAssignedVideoFromItem(videoCaption,videoRemoveSuccessMessage);
	}
	}
	@Features(value={"Items Module"})
	@Description("Verification of adding new video")
	@TestCaseId("TC_ITEMS_101")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyAddNewVideo_ES(String testCaseId,String partNumber, String videoCaption, String videoURl, String videoSaveMessage, String videoRemoveSuccessMessage, String alertMessageText) throws Exception
	{
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickonVideosTabLink()
		.removeAssignedVideoFromItem(videoCaption,videoRemoveSuccessMessage)
		.clickAddNewVideoButton()
		.addNewVideoURL(videoCaption,videoURl)
		.clickOnSaveVideoButton()
		.verifyAddVideoSaveMsg(videoSaveMessage)
		.verifyAlertCheckBoxNotChecked(videoCaption,alertMessageText);
		}
		finally{
			editItemsPage().removeAssignedVideoFromItem(videoCaption,videoRemoveSuccessMessage);
		}
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Linked Items' page")
	@TestCaseId("TC_ITEMS_103")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyLinkedItems(String testCaseId,String partNumber) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.verifyTabsUnderLinkedItemsTab();
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Linked Items' page")
	@TestCaseId("TC_ITEMS_104")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyLinkedItemsFields(String testCaseId,String partNumber, String exepectedSearchInDropdownValues) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.verifySetUpLinkedItemsTab(exepectedSearchInDropdownValues.split(","));
	}
	String getItemId;
	@Issue("STAC-227")
	@Features(value={"Items Module"})
	@Description("Verification of assigning linked items")
	@TestCaseId("TC_ITEMS_105 to TC_ITEMS_115")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	
	public void verifyAssignedLinkedItems(String testCaseId,String partNumber, String partNumbersForSearch, String itemLinkTypeName, String linkedItemSaveMessage, String assignedSaveMessage) throws Exception
	{
		
		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		getItemId=	homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.verifyItemLinkType(itemLinkTypeName)
		.clickonAddnewLinkTypeButton()
		.enterItemLinkTypeName(itemLinkTypeName,linkedItemSaveMessage)
		.clickOnSetupLinkedItemsTab()
		.searchForItems(partNumbersForSearch)
		.assignLinkedItems(partNumber)
		.clickOnSaveAssignedLinkedListIcon()
		.verifySuccessMessageForSaveAssignedList(assignedSaveMessage);
		
	}
		
	finally{
		editItemsPage()
		.clickOnSetupLinkedItemsTab()
		.removeAssignedLinkedItems(partNumber,itemLinkTypeName,getItemId);
	}
	}
	
	@Features(value={"Items Module"})
	@Description("Verification of content in Available Linked Items tab in lineked list items tab")
	@TestCaseId("TC_ITEMS_107 ")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	
	public void verifyAvailableLinkedItems(String testCaseId,String partNumber,  String availableLinkedItemsHeaders) throws Exception
	{
		
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnAvailableLinkedItems()
		.verifyContentunderAvailableLinkedItems(availableLinkedItemsHeaders);
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of  'List Item Link Types' tab ")
	@TestCaseId("TC_ITEMS_108")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	
	public void verifyListItemLinkType(String testCaseId,String partNumber,  String listItemLinkTypeHeaders) throws Exception
	{
		
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.verifyListItemLinkTypeHeaders(listItemLinkTypeHeaders);
	}
	@Features(value={"Items Module"})
	@Description("Verification of updating Item Link Type")
	@TestCaseId("TC_ITEMS_114")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	
	public void updateItemLinkType(String testCaseId,String partNumber,  String itemLinkTypeName,String itemLinkTypeNameUpdate, String linkedItemSaveMessage, String linkedItemUpdateMessage) throws Exception
	{


		try{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		getItemId=	homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.verifyItemLinkType(itemLinkTypeName)
		.clickonAddnewLinkTypeButton()
		.enterItemLinkTypeName(itemLinkTypeNameUpdate,linkedItemSaveMessage)
		.clickOnLinkedItemsTab()
		.clickOnListItemLinkTypes()
		.clickOnEditItemLinkType(itemLinkTypeName)
		.enterItemLinkTypeName(itemLinkTypeName,linkedItemUpdateMessage);
	}
		
	finally{
		editItemsPage()
		.verifyItemLinkType(itemLinkTypeNameUpdate);
	}
	}
	@Features(value={"Items Module"})
	@Description("Verification of attributes page")
	@TestCaseId("TC_ITEMS_115")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	
	public void verifyAttributesPage(String testCaseId,String partNumber,  String  attributeHeaders, String taxonomyName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyAttributesTabFileds(attributeHeaders, taxonomyName);
		
		}
	@Features(value={"Items Module"})
	@Description("Verification of saving the attributes")
	@TestCaseId("TC_ITEMS_116")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySaveAttribute(String testCaseId,String partNumber,  String  attributeListName, String taxonomyName, String expSuccessMessageForAttributeSave) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnAttributesTab()
		.searchForAttibuteList(attributeListName)
		.verifyAndAssignAttribute(attributeListName)
		.verifySuccessMessageForAttributeAssign(attributeListName,expSuccessMessageForAttributeSave);
		
		}
	@Features(value={"Items Module"})
	@Description("Verification of 'Back' button")
	@TestCaseId("TC_ITEMS_117")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCancelAttribute(String testCaseId,String partNumber,  String  attributeListName, String taxonomyName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnAttributesTab()
		.searchForAttibuteList(attributeListName)
		.verifyCancelFuctionality(attributeListName);
	}
	@Features(value={"Items Module"})
	@Description("Verification of Custom Prices page")
	@TestCaseId("TC_ITEMS_118")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCustomPricesTab(String testCaseId,String partNumber,  String  customePriceHeaders) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.verifyCustomPriceTabHeaders(customePriceHeaders);
	}
	@Features(value={"Items Module"})
	@Description("Verification of custome price tab Checkbox")
	@TestCaseId("TC_ITEMS_119,TC_ITEMS_120,TC_ITEMS_121")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCustomPriceCheckBox(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.verifyCustomPriceTabCheckBoxes();
	}
	@Features(value={"Items Module"})
	@Description("Verification of custome price tab input text fields")
	@TestCaseId("TC_ITEMS_121 to TC_ITEMS_130")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCustomPriceTextFields(String testCaseId,String partNumber) throws Exception
	{
		String testData=random.random(10, PermittedCharacters.ALPHABETS);

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.verifyCustomPriceTabInputTextFields(testData);
	}
	@Features(value={"Items Module"})
	@Description("validation of custome price tab input text fields")
	@TestCaseId("TC_ITEMS_121 to TC_ITEMS_132")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void validateCustomPriceTextFields(String testCaseId,String partNumber, String fields, String noOfChars, String testCharecters) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.validateCustomPriceInputTextFields(fields,noOfChars, testCharecters);
	}
	@Features(value={"Items Module"})
	@Description("To validate item status")
	@TestCaseId("TC_ITEMS_131")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySubsetStatus(String testCaseId,String partNumber, String itemStatus, String subsetName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.getTheItemId(partNumber);
		itemsPage()
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.selectingItemStatus(itemStatus,subsetName);

	}
	@Features(value={"Items Module"})
	@Description("update custom price")
	@TestCaseId("TC_ITEMS_133")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void updateCustomPrice(String testCaseId,String partNumber, String price, String subset) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.updateItemPriceInSubset(subset,price)
		.verifyCustomePriceUpdateSuccessMessage(subset);
	}
	@Features(value={"Items Module"})
	@Description("verification history link of Custom prices tab")
	@TestCaseId("TC_ITEMS_135")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCPHistory(String testCaseId,String partNumber, String alertTextWhenHistoryIsClicked, String customPriceHistoryTitle) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomPricesTab()
		.clickOnCPhistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		utility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(customPriceHistoryTitle);

	}
	@Features(value={"Items Module"})
	@Description("Verification of history page of Categorization tab")
	@TestCaseId("TC_ITEMS_141")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCategoryHistory(String testCaseId,String partNumber, String alertTextWhenHistoryIsClicked, String categorizationTabHistoryTitle) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCategorizationTab()
		.clickOnHistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		utility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(categorizationTabHistoryTitle);
	}
	@Features(value={"Items Module"})
	@Description("Verification of Custom Fields tab")
	@TestCaseId("TC_ITEMS_142")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCustomFieldsTab(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomFieldsTab()
		.verifyCustomFieldsSimpleTab()
		.verifyCustomFieldsTableTab();
	}
	@Features(value={"Items Module"})
	@Description("Verification of Custom Fields table data.")
	@TestCaseId("TC_ITEMS_142")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCFTable(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomFieldsTab()
		.verifyCustomFieldsTableTab();
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of Custom Fields simple data")
	@TestCaseId("TC_ITEMS_143")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCFSimpleData(String testCaseId,String partNumber, String expSimpleData) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnCustomFieldsTab()
		.verifySimpleDataAvailable(expSimpleData);
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Customer part number' page")
	@TestCaseId("TC_ITEMS_150")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCPTab(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyCustomerPartNumberTab();
		
		
	}
	@Features(value={"Items Module","Integration scenario"})
	@Description("Verification of 'Add Customer part number' page")
	@TestCaseId("TC_ITEMS_151")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyAddNewCPNPage(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyCustomerPartNumberTab()
		.clickonCpnTab()
		.verifyCreateNewCPFields();
		
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Customer' drop down")
	@TestCaseId("TC_ITEMS_153")
	@Test(enabled=false,groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCustomerDropDown(String testCaseId,String partNumber, String customerName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyCustomerPartNumberTab()
		.clickonCpnTab()
		.selectCustomerFromDropDown(customerName);
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Reset' Icon")
	@TestCaseId("TC_ITEMS_158")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCPNReset(String testCaseId,String partNumber, String customerName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyCustomerPartNumberTab()
		.clickonCpnTab()
		.clickOnAddNewCpn()
		.enterDataToCustomerField(customerName)
		.clickOnCPNResetButton()
		.verifyCPNResetFunctionality();
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of 'Warehouse' page")
	@TestCaseId("TC_ITEMS_159")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyWarehouse(String testCaseId,String partNumber) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.verifyWarehousePage();
	}
	@Features(value={"Items Module"})
	@Description("Verification of search text box")
	@TestCaseId("TC_ITEMS_160")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyWarehouseSearch(String testCaseId,String partNumber, String warehouseName) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.searchForwareHouse(warehouseName)
		.verifySearchResults(warehouseName);
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of search text box for invalid name")
	@TestCaseId("TC_ITEMS_161")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyWarehouseSearch_ES(String testCaseId,String partNumber, String warehouseNameInvalid) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.searchForwareHouse(warehouseNameInvalid)
		.verifySearchResultsInvalid(warehouseNameInvalid);
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of saving a selected item to warehouse")
	@TestCaseId("TC_ITEMS_162")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySaveWarehouse(String testCaseId,String partNumber, String warehouseName, String expSuccessMessage) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.searchForwareHouse(warehouseName)
		.selectWarehouseToSave(warehouseName)
		.saveWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of saving an item to multiple warehouses")
	@TestCaseId("TC_ITEMS_163")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySaveMultiWarehouses(String testCaseId,String partNumber, String noOfWareHosesToBeSelect, String expSuccessMessage) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.selectMultipleWarehouses(noOfWareHosesToBeSelect)
		.saveWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of saving an item to All warehouses")
	@TestCaseId("TC_ITEMS_164")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySaveAllWarehouses(String testCaseId,String partNumber,  String expSuccessMessage) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.selectSelectAllWarehouses()
		.saveWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of Removing an item from warehouse")
	@TestCaseId("TC_ITEMS_165")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyRemoveWarehouse(String testCaseId,String partNumber, String warehouseName, String expRemoveSuccessMessage) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.searchForwareHouse(warehouseName)
		.selectWarehouseToSave(warehouseName)
		.removeWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expRemoveSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of Removing an item from multiple warehouses")
	@TestCaseId("TC_ITEMS_166")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyRemoveMultiWarehouses(String testCaseId,String partNumber, String noOfWareHosesToBeSelect, String expRemoveSuccessMessage) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.selectMultipleWarehouses(noOfWareHosesToBeSelect)
		.removeWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expRemoveSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of Removing an item from all the warehouses")
	@TestCaseId("TC_ITEMS_167")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyRemoveAllWarehouses(String testCaseId,String partNumber, String expRemoveSuccessMessage) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.selectSelectAllWarehouses()
		.removeWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expRemoveSuccessMessage);
	}
	@Features(value={"Items Module"})
	@Description("Verification of History of the items & the warehouses")
	@TestCaseId("TC_ITEMS_168")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyHistoryWarehouses(String testCaseId,String partNumber, String warehouseName,String expSuccessMessage, String alertText, String expTitle) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.verifyWarehouseTabPresent()
		.clickOnWarehouseTab()
		.verifyWarehousePage()
		.searchForwareHouse(warehouseName)
		.selectWarehouseToSave(warehouseName)
		.saveWarehouseToItem()
		.verifyWarehouseSaveSuccessMessage(expSuccessMessage)
		.clickOnWareHouseHistoryLink()
		.verifyAlertMsg(alertText);
		utility.switchToRecentWindow();
		historyPage()
		.verifyPageTitle(expTitle)
		.verifyrecentWareHouseActivity(warehouseName);
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of Copy of Item page")
	@TestCaseId("TC_ITEMS_169")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyCopyOfItem(String testCaseId,String partNumber, String inputFieldNames,String itemInfoTabs) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemCopyButton(partNumber)
		.copyItemPage()
		.verifyCopyItemInputFields(inputFieldNames)
		.verifyItemInFormationTabs(itemInfoTabs);
		
		
	}
	@Features(value={"Items Module"})
	@Description(" validating 'New Part Number'/'no of copies' field(s)")
	@TestCaseId("TC_ITEMS_170,TC_ITEMS_171")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void validateInputFields(String testCaseId,String partNumber, String inputFieldNames,String itemInfoTabs,String fieldName, String testData) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemCopyButton(partNumber)
		.copyItemPage()
		.verifyCopyItemInputFields(inputFieldNames)
		.verifyItemInFormationTabs(itemInfoTabs)
		.enterSearchDataForRespectiveField(fieldName,testData)
		.validateInputFields(fieldName,testData);
		
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of error message  'New Part Number'/'no of copies' field(s)")
	@TestCaseId("TC_ITEMS_172,TC_ITEMS_173")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verificationOfInputFields(String testCaseId,String partNumber, String inputFieldNames,String itemInfoTabs,String fieldName, String testData, String expErrorMessage) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemCopyButton(partNumber)
		.copyItemPage()
		.verifyCopyItemInputFields(inputFieldNames)
		.verifyItemInFormationTabs(itemInfoTabs)
		.enterSearchDataForRespectiveField(fieldName,testData)
		.clickOnSaveCopyItem()	
		.verifyErrorMessage(expErrorMessage);
		
		
		
	}
	@Features(value={"Items Module"})
	@Description("Verification of reset functionality")
	@TestCaseId("TC_ITEMS_174")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifyResetCopyItem(String testCaseId,String partNumber, String fieldName, String testData) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemCopyButton(partNumber)
		.copyItemPage()
		.enterSearchDataForRespectiveField(fieldName,testData)
		.clickOnResetCopyItemsLink()
		.verifyResetFunctionality(fieldName,testData);
}
	@Features(value={"Items Module"})
	@Description("Verification of copying the item")
	@TestCaseId("TC_ITEMS_175")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)	
	public void verifySaveCopyItem(String testCaseId,String partNumber, String fieldName, String testData, String saveSuccessMessage) throws Exception
	{
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemCopyButton(partNumber)
		.copyItemPage()
		.enterSearchDataForRespectiveField(fieldName,testData)
		.clickOnSaveCopyItem()
		.verifySaveSuccessMessage(saveSuccessMessage);
		editItemsPage()
		.removeCopiedItem(testData);
		itemsPage()
		.verifyRemoveItemSuccessMessage(testData);
	}
}
