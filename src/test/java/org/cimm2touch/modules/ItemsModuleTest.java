package org.cimm2touch.modules;
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
		.homePage()
		.clickOnLeftNavigationbar()
		.itemsPage()
		.enterSearchCategory(category)
		.clickOnSearchCategory()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(category);
	}
	
	@Features(value = {"Items Module"})
	@Description("This is a test case which verifies the refresh functionality in the taxonomy tree.")
	@TestCaseId("TC_ITEMS_008")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyRefreshInTaxonomyTree(String testCaseId, String userName, String password,String welcomeMessage,String category ) throws Exception {
		
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
		.verifyWhetherSearchedTaxonomyStyleIsGreen(category)
		.verifyWhetherValueContainsTextInsideTheTextbox(category)
		.clickOnRefresh()
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
	@TestCaseId("TC_ITEMS_45, TC_ITEMS_46")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addNewWorkbook(String testCaseId, String workBookName, String workBookSuccesMsg, String reNameErroMsg,String workBookRemoveMsg) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifySuccessMsg(workBookName,workBookSuccesMsg)
		.clickOnWorkbookDropdown()
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifyErrorMessageForReName(workBookName,reNameErroMsg)
		.deleteWorkbook(workBookName,workBookRemoveMsg);
	}
	@Features(value = {"Items Module"})
	@Description("This Test case verifies Adding items to workbook")
	@TestCaseId("TC_ITEMS_47")
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void addItemsToWorkbook(String testCaseId, String workBookName, String workBookSuccesMsg, String noOfItemsToBeSelect, String additemWorkbooksuccessmsg, String workbookRemovemsg) throws Exception {
	
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyWorkbookDropdownLocator()
		.clickOnWorkbookDropdown()
		.enterWorkbookName(workBookName)
		.clickOnSaveIcon()
		.verifySuccessMsg(workBookName,workBookSuccesMsg)
		.clickOnSpecficCheckBoxes(noOfItemsToBeSelect)
		.clickOnWorkbookDropdown()
		.selectWorkbook()
		.clickOnWorkbookName()
		.verifyAddItemSucessMsg(additemWorkbooksuccessmsg)
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnWorkbookDropdown()
		.verifyWorkbookItemCount(noOfItemsToBeSelect)
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.deleteWorkbook(workBookName,workbookRemovemsg);
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
}
