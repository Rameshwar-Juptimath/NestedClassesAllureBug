package org.cimm2touch.modules;

import java.io.File;
import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
/**
 * 
 * @author thiruveedhi.Chinna
 *
 */


public class CreateDataConfigTest extends PageFactoryInitializer{
HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public CreateDataConfigTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	
	@Description("create a new subset.")
	@Features(value={"CreateDataConfigTest"})
	@Test(groups={"regression"},priority=0,dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createNewSubset(String testCaseId, String userName, String password,String welComeMessage,String subsetName, String ExpSuccessfulMessageForCreatedSubset) throws InterruptedException, Exception 
	{
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickOnSubset()
		.subsetPage()
		.checkSubsetPage()
		//.typeInSubsetSearch(subsetName)
		.searchForAnSubset(subsetName)
		.clickOnSubsetSearchGoButton()
		.verifySubsetPresent(subsetName)//checks whether subset already exists
		.clickOnSubsetButton()
		.typeInSubsetNameField(subsetName)
		.clickOnSubsetSave()
		.verifySubsetCreationMessage(ExpSuccessfulMessageForCreatedSubset);

	}
	@Description("Create new vendor.")
	@Features(value={"CreateDataConfigTest"})
	@Test(groups={"regression"},priority=1,dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createVendor(String testCaseId, String userName, String password,String welComeMessage, String title,String vendorName, String vendorShortName, String customerType, String vendorAddress, String vendorEmailAddress,String subsetName, String vendorSavemessage) throws InterruptedException, Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.checkVendorPage(title)
		.typeVendorNameInSearch(vendorName)
		.verifyVendorSearchResults(vendorName)
		.typeInVendorName(vendorName)
		.typeInVendorshortname(vendorShortName)
		//.selectCustomerType(customerType)
		.typeInVendorAddress(vendorAddress)
		.typeInVendorEmailAddress(vendorEmailAddress)
		.selectVendorSubset(subsetName)
		.vendorSave()
		.checkCreatedVendorSaveMessage(vendorSavemessage);
	}
	@Features(value = {"CreateDataConfigTest"})
	@Description("Create new Taxonomy {0}")
	@Test(enabled=true,priority=2, groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createTaxonomy(String testCaseId,String userName, String password,String welcomeMessage, String taxonomyName,String taxonomyDesc,String supplier, String saveAs) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyAlreadyPresent(taxonomyName)
		.clickOnAddnewTaxonomy()
		.enterTaxonomyName(taxonomyName)
		.enterTaxonomyDesciption(taxonomyDesc)
		.selectSupplier(supplier)
		.saveAs(saveAs)
		.saveTaxanomy()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName);
	}

	@Features(value = {"Taxonomy Module", "CreateDataConfigTest"})
	@Description(" Create Categoryies {0}")
	@Test(enabled=true,priority=3, groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createCategories(String testCaseNo, String userName, String password, String welcomeMessage,String taxonomy,String categoryCode, String categoryName,String displaySequence, String expSuccessMsgForNewCategoryCreation, String noOfCategories) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomy)
		.verifyTaxonomyPresent(taxonomy)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomy)
		.verifyCategoryPresent(categoryName)
		.addNewCategoryAndVerify(categoryCode, categoryName, displaySequence, noOfCategories,expSuccessMsgForNewCategoryCreation);

	}

	@Features(value = {"Taxonomy Module", "CreateDataConfigTest"})
	@Description(" Create L1 Child Category to the Above Created Categories")
	@Test(enabled=true,priority=4, groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)

	public void createChildCategories(String testCaseNo, String userName, String password, String welcomeMessage,String taxonomyName, String categoryName,  

			String childCategoryName, String childCategoryCode, String displaySequence) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.addNewChildCategory(categoryName,childCategoryCode, childCategoryName, displaySequence);
		
	}
	@Description("creation of new manufacturer.")
	@Features(value={"CreateDataConfigTest"})
	@Test(enabled=true,priority=5,groups={"regression"}, dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createNewManufacturer(String testCaseId, String userName, String password, String welComeMessage,String manufacturerName, String manufacturerCode, String SuccessMessageAfterCreate) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.manufacturerSearchResult(manufacturerName)
		.homePage()
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.clickonmanufacturerbutton()
		.typeinmanufield(manufacturerName)
		.typeinmanucodefield(manufacturerCode)
		.checkmanufactureractive()
		.clickonmanufacturersave()
		.verifymessageAfterManufacturerCreate(manufacturerName,SuccessMessageAfterCreate);

	}
	@Description("Creation of new brand.")
	@Features(value={"CreateDataConfigTest"})
	@Test(enabled=true,priority=6,groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createNewBrand(String testCaseId, String userName, String password,String welComeMessage,String manufacturerName, String brandName, String brandDescription, String SuccesfulMessageForCreatedBrand) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.checkManufacturerAlreadyExist(manufacturerName)
		.clickOnlisticon(manufacturerName)
		.isBrandpresent(brandName)
		.clickOnaddnewbrandbutton()
		.checkBrandFormEnabled()
		.selectmanufacturerfromdropdown(manufacturerName)
		.typeinbrandname(brandName)
		.typeinBrandDescField(brandDescription)
		.checkOnBrandActive()
		.checkOnItemActive()
		.clickonbrandsave()
		.checkBrandSaveMessage(SuccesfulMessageForCreatedBrand);
	}
	
	
	
	
	@Description("create a new item(s).")
	@Features(value={"CreateDataConfigTest"})
	@Test(enabled=true,priority=7,groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createNewItem(String testcaseId,String userName, String password, String welcomMessage, String manufactureName, String brandName,
			String itemNameTemplate,String mfgNameTemplate,String vendorName, String succesfulMessageForCreatedItem, String subsetName, String numberOfItemsToCreate ) throws InterruptedException 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(welcomMessage)
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(itemNameTemplate)
		.verifyItemsPresent(itemNameTemplate)
		.createNewItemsinside(manufactureName, brandName,itemNameTemplate, mfgNameTemplate,
				vendorName, succesfulMessageForCreatedItem, subsetName, numberOfItemsToCreate);
	}
	@Description("Assign Items to category.")
	@Features(value={"CreateDataConfigTest"})
	@Test(enabled=true,priority=8,groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void itemCategorization(String testcaseId,String userName, String password, String welcomMessage,
			String itemNameTemplate,String taxonomyName,String categoryName, String succesfulMessageForCategorization, String noOfitemsToBeCategorized ) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(welcomMessage)
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(itemNameTemplate)
		.clickOnEditButton(itemNameTemplate)
		.editItemsPage()
		.assignItemToCategory(categoryName, noOfitemsToBeCategorized, taxonomyName, succesfulMessageForCategorization);
		

}
	@Features(value={"CreateDataConfigTest"})
	@Description("Create new product")
	@Test(groups="regression",dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)
	public void createNewProduct(String testCaseId, String userName,String password,String expWelcomeMsg,String productName, String productNumber, String expectedSuccesfulMessageForNewProductCreation) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(expWelcomeMsg)
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductAlreadyExists(productName)
		.clickOnAddNewProductLink()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(expectedSuccesfulMessageForNewProductCreation);
		
	}
	
	@Features(value={"CreateDataConfigTest"})
	@Description("adding the description to item(s)")
	@Test(groups="regression",priority=9,dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void addDescriptiontoItems(String testCaseId, String userName,String password,String expWelcomeMsg,String partNumberDesc, String longDesc1, String longDesc2) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(expWelcomeMsg)
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumberDesc)
		.clickOnSpecificItemEditButton(partNumberDesc)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.editLongDescription(longDesc1)
		.editLongDescription2(longDesc2)
		.saveDescription();
	}


	@Description("Creation of new brand.")
	@Features(value={"CreateDataConfigTest"})
	@Test(enabled=true,priority=10,groups={"regression"},dataProvider="CreateDataConfigTest",dataProviderClass=SearchData.class)
	public void createNewUOM(String testCaseId, String userName, String password,String welComeMessage,String uomName, String uomDescription, String uomSaveMessage) throws Exception
	{
		 landingPage()
		 .enterUsername(userName)
		 .enterPassword(password)
		 .clickOnLogin();
			homePage()
		 .verifyWelcomeMessage(welComeMessage)
		 .clickOnUomLink()
		 .uomPage()
		 .searchForUOM(uomName)
		 .clickOnUomSearchCategory()
		 .verifyUomPresent(uomName)
		 .createUom(uomName,uomDescription)
		 .verifySuccessMessage(uomSaveMessage)
		 .searchForUOM(uomName)
		 .clickOnUomSearchCategory()
		  .verifyCreatedUom(uomName);


	}
	@Features(value={"CreateDataConfigTest"})
	@Description("add new custom fields (simple data type)")
	@Test(groups="regression",priority=10,dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)
	public void addNewManageList(String testCaseId,  String manageListName, String valueListDataType,
			String valueListDescription, String successMessage) throws Exception
	{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnManageListLink()
		.manageListPage()
		.searchForManageList(manageListName)
		.verifyManageListPresent(manageListName)
		.clickOnAddNewManageList()
		.createNewValueList(manageListName,valueListDataType,valueListDescription)
		.verifySuccessMessageForNewlyCreatedList(successMessage);

	}
	
	
	@Features(value={"CreateDataConfigTest"})
	@Description("add new custom fields (simple data type)")
	@Test(groups="regression",priority=11,dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)
	public void addNewCustomFields(String testCaseId,  String customFieldName, String customFieldDescription,
			String customFieldDataType, String customFieldUIType,String listName,String dataEntiryType) throws Exception
	{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnCustomFieldsLink()
		.customSimpleDataPage()
		.searchForSimpleData(customFieldName)
		.verifySimpleDataPresent(customFieldName)
		.clickOnAddNewCustomField()
		.enterAllTheMandatoryFields(customFieldName,customFieldDescription,customFieldDataType,customFieldUIType,listName,dataEntiryType)
		.clickOnSaveButton()
		.searchForSimpleData(customFieldName)
		.verifySimpleDataCreated(customFieldName);
		
		
		
	}
	@Features(value={"CreateDataConfigTest"})
	@Description("add new custom fields (simple data type)")
	@Test(groups="regression",priority=12,dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)
	public void addNewCustomTableFields(String testCaseId,  String customTableField, String customFieldDescription,
			String customFieldDataType, String customFieldUIType,String listName,String dataEntiryType) throws Exception
	{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnCustomFieldsLink()
		.customSimpleDataPage()
		.searchForSimpleData(customTableField)
		.verifySimpleDataPresent(customTableField)
		.clickOnAddNewCustomField();
		
		
		
	}
	/*@Features(value={"CreateDataConfigTest"})
	@Description("create new e-commerce customer")
	@TestCaseId("TC_ITEMS_152")
	@Test(groups="regression",dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)	
	public void CreateNewCustomer(String testCaseId,String partNumber, String customerName, String customerShortName, String customerType, String customerAddress1, String generalCatelogAccess) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnCustomerHeaderLink()
		.customersPage()
		.searchForCustomer(customerName)
		.verifyCustomerPresent(customerName)
		.createNewCustomer(customerName, customerShortName, customerType, customerAddress1, generalCatelogAccess);
			
	}*/
	@Features(value={"CreateDataConfigTest"})
	@Description("Verification of 'Customer' drop down")
	@TestCaseId("TC_ITEMS_152")
	@Test(groups="regression",dataProvider="CreateDataConfigTest", dataProviderClass=SearchData.class)	
	public void CreateNewWareHouse(String testCaseId,String wareHousePageTitle, String warehouseName, String warehouseCode, 
			String address1, String selectCountry, String cityName, String stateName , String zipCode, String expSuccessMessage) throws Exception
	{

		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"));
		homePage()
		.clickOnWarehouseLink()
		.warehousePage()
		.verifyWareHousePage(wareHousePageTitle)
		.searchForWareHouse(warehouseName)
		.verifyWarehouseAlreadyExist(warehouseName)
		.clickOnAddNewWareHouseLink()
		.createNewWarehouse(warehouseName, warehouseCode, address1, selectCountry, cityName, stateName, zipCode)
		.clickOnSaveNewWarehouseLink()
		.verifySuccessMessage(expSuccessMessage)
		.searchForCreatedWarehouse(warehouseName);
		
		
		
		
		
		
		
		
	}
}
