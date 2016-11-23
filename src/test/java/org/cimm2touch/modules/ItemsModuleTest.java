package org.cimm2touch.modules;
import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.framework.utils.TestUtility;
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

	@Test(groups={"smoke","regression"}, dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void createNewCategory(String testCaseId, String userName, String password, String welComeMessage, String taxonomyName, String categoryName) throws InterruptedException{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnGoToManageTaxonomyIcon(taxonomyName);
		
		
		
		
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
	@Issues(value = { @Issue(value = "CIM-901") })
	@Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	public void verifyRefreshInTaxonomyTree(String testCaseId, String userName, String password,String welcomeMessage,String category ) throws Exception {
		
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
		.itemsPage()
		.clickOnRemoveFilter()
		.itemsPage()
		.verifyCategoryChosenIsNotSelected(categoryName)
	
		.itemsPage()
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
	
	/* @Features(value = {"Items Module"})
	 @Description("This is a test case which verifies adding new items")
	 @TestCaseId("TC_ITEMS_024")
	 @Test(groups="regression",dataProvider="ItemsModuleTest", dataProviderClass=SearchData.class)
	 public void verifyAddingNewItem(String testCaseId, String manufacturerName,String partNumberField, String brandName, String succesMessage) throws Exception
		{
		 
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
		   .enterPartNumberField(partNumberField)
		   .clickOnBrandDropdown()
		   .selectBrandField(brandName)
		   .clickOnSaveButtonLink()
		   .verifyItemSavedSuccessfulMessage(succesMessage);
		} */
	
	
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
	@TestCaseId("{0}")
	//TC_ITEMS_032
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void verifyItemStatusDropdown(String testCaseId, String userName, String password,@Parameter("Item Status Options") String statusOptions,@Parameter("Corresponding values for each status") String valueForEachStatus) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
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
	public void verifyCheckboxesInAddNewItemsPage(String testCaseId, String userName, String password,@Parameter("Checkbox under test")String checkbox) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
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
	public void verifyResultsLinkInEditItemsPage(String testCaseId, String userName, String password) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
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
	
	
	
}
