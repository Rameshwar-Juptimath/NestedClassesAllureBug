package org.cimm2touch.modules;

import java.io.File;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.BeanDescription;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;
/**
 * 
 * @author Thiruveedhi Chinna
 *
 */
public class AdvancedSearchModuleTest extends PageFactoryInitializer {

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	
	
	@Description("pre setting for Desktop view - show fields for Automation.")
	@Features(value={"AdvancedSearch Module"})
	@Test(groups={"regression"}, dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
	public void genericFieldsSettingForItems(String testCaseId, String userName, String password, String welComeMessage, String genericColumnSettingType, String fields) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickOnItemsLink()
		.itemsPage()
		.clickOnGenricColumnSetting(genericColumnSettingType)
		.verifyGenericColumnSettingTable(genericColumnSettingType)
		.setTheShowFieldsForDesktopView(fields);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyItemsPageWithRequiredFields(fields);
		
		
	}
	
	@Description("creation of new manufacturer.")
	@Features(value={"AdvancedSearch Module"})
	@Test(enabled=false,priority=0,groups={"regression"}, dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
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
	@Features(value={"AdvancedSearch Module"})
	@Test(enabled=false,groups={"regression"},priority=1,dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
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
		.clickOnlisticon()
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
	
	@Description("create a new subset.")
	@Features(value={"AdvancedSearch Module"})
	@Test(enabled=false,priority=2,groups={"regression"},dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
	public void createNewSubset(String testCaseId, String userName, String password,String welComeMessage,String subsetName, String ExpSuccessfulMessageForCreatedSubset) throws InterruptedException, Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(welComeMessage);
		homePage()
		.clickOnSubset()
		.subsetPage()
		.checkSubsetPage()
		.typeInSubsetSearch(subsetName)
		.clickOnSubsetSearchButton()
		.subsetSearchResult(subsetName)//checks whether subset already exists
		.clickOnSubsetButton()
		.typeInSubsetNameField(subsetName)
		.clickOnSubsetSave()
		.verifySubsetCreationMessage(ExpSuccessfulMessageForCreatedSubset);

	}
	@Description("Create new vendor.")
	@Features(value={"AdvancedSearch Module"})
	@Test(groups={"regression"},dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
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
		.selectCustomerType(customerType)
		.typeInVendorAddress(vendorAddress)
		.typeInVendorEmailAddress(vendorEmailAddress)
		.selectVendorSubset(subsetName)
		.vendorSave()
		.checkCreatedVendorSaveMessage(vendorSavemessage);
	}
	
	@Description("This method is used to create a new item.")
	@Features(value={"AdvancedSearch Module"})
	@Test(enabled=false,priority=3,groups={"regression"},dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
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
		.createNewItemsinside(manufactureName, brandName,itemNameTemplate, mfgNameTemplate,
				vendorName, succesfulMessageForCreatedItem, subsetName, numberOfItemsToCreate);
	}
	
	
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No or Keyword search")
	@TestCaseId("TC_ADV SEARCH_003")
	@Test(groups="regression", dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class) //dependsOnMethods={"createNewManufacturer","createNewBrand","createNewSubset","createNewItem"}
	public void advSearch_003(String testCaseId,String userName, String password,String searchInput) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchInput)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe003Searchresult(searchInput);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No or Keyword search- Negative Test case")
	@TestCaseId("TC_ADV SEARCH_004")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_004(String testCaseId,String userName, String password,String searchData, String expMessage) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult(expMessage);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No or Keyword search- Partial Search")
	@TestCaseId("TC_ADV SEARCH_005")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_005(String testCaseId,String userName, String password,String searchData) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe005Searchresult(searchData);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Invalid keyword")
	@TestCaseId("TC_ADV SEARCH_006")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_006(String testCaseId,String userName, String password,String searchData, String expMessage) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult(expMessage);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No search")
	@TestCaseId("TC_ADV SEARCH_007")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_007(String testCaseId,String userName, String password,String searchData, String selectValue) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe007Searchresult(searchData);		
	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No search- Partial search")
	@TestCaseId("TC_ADV SEARCH_008")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_008(String testCaseId,String userName, String password,String searchData, String selectValue) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe008Searchresult(searchData);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Part No search- Invalid Part Number")
	@TestCaseId("TC_ADV SEARCH_009")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_009(String testCaseId,String userName, String password,String searchData, String selectValue, String expMessage) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult(expMessage);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Manufacturer Part No search")
	@TestCaseId("TC_ADV SEARCH_010")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_010(String testCaseId,String userName, String password,String searchData, String selectValue,String noOfItemsTobeVerify, String itemNameTemplate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe010Searchresult(itemNameTemplate,searchData,noOfItemsTobeVerify);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Manufacturer Part No search- Invalid MPN")
	@TestCaseId("TC_ADV SEARCH_011")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_011(String testCaseId,String userName, String password,String searchData, String selectValue, String expMessage) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		landingPage().homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(searchData).selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult(expMessage);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - CIMM Item ID")
	@TestCaseId("TC_ADV SEARCH_014")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_014(String testCaseId,String userName, String password,String searchData, String selectValue) throws Exception {
			landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe003Searchresult(searchData)
		.typeinadvancedSearchTopSearchField(itemsPage()
		.getCIMMItemID(searchData))
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe014Searchresult(itemsPage()
		.getCIMMItemID(searchData));

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - CIMM Item ID- Invalid input")
	@TestCaseId("TC_ADV SEARCH_015")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_015(String testCaseId,String userName, String password,String searchData, String selectValue, String expMessage) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(searchData)
		.selectDropdownTop(selectValue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult(expMessage);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Manufacturer filter- without search")
	@TestCaseId("TC_ADV SEARCH_016")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_016(String testCaseId,String userName, String password,String mfgName, String brandName,String noOfItemsTobeCreate) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Manufacturerfilter()
		.selectTheCreatedManufacturerfilterWithoutSearch(mfgName)
		.clcikOnas_Manufacturerfiltersearchbutton()
		.verifyadvSe016(mfgName,brandName,noOfItemsTobeCreate);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Manufacturer filter- with search")
	@TestCaseId("TC_ADV SEARCH_017")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_017(String testCaseId,String userName, String password,String mfgName, String brandName,String noOfItemsTobeCreate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Manufacturerfilter()
		.enterTheManufactureNameInSearchField(mfgName)
		.selectTheManufacturersFromList(mfgName).
		clcikOnas_Manufacturerfiltersearchbutton().
		verifyadvSe016(mfgName,brandName,noOfItemsTobeCreate);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Brand filter- without search")
	@TestCaseId("TC_ADV SEARCH_018")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_018(String testCaseId,String userName, String password,String mfgName, String brandName,String noOfItemsTobeCreate) throws InterruptedException {

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Brandfilter()
		.brandfilterWithoutSearch(brandName)
		.clickOnas_Brandfiltersearchbutton()
		.verifyadvSe016(mfgName,brandName,noOfItemsTobeCreate);

	}


	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Brand filter- with search")
	@TestCaseId("advSe019")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_019(String testCaseId,String userName, String password,String mfgName, String brandName,String noOfItemsTobeCreate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Brandfilter()
		.typeIn_as_Brandfiltersearchfield(brandName)
		.brandfilterWithSearch(brandName).
		clickOnas_Brandfiltersearchbutton().
		verifyadvSe016(mfgName,brandName,noOfItemsTobeCreate);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Subset filter- without search")
	@TestCaseId("AdvSe020")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_020(String testCaseId,String userName, String password,String subsetName, String itemNameTemplate,String noOfOtemsTobeCreated, String mfgNameTemplate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Subsetfilter()
		.subsetfilterWithoutSearch(subsetName)
		.clickOnas_Subsetfiltersearchbutton()
		.verifyadvsearchForSubset(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,subsetName);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Subset filter- with search")
	@TestCaseId("AdvSe021")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_021(String testCaseId,String userName, String password,String subsetName, String itemNameTemplate,String noOfOtemsTobeCreated, String mfgNameTemplate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.clickOnas_Subsetfilter()
		.typeIn_as_Subsetfiltersearchfield(subsetName)
		.subsetfilterWithSearch(subsetName)
		.clickOnas_Subsetfiltersearchbutton()
		.verifyadvsearchForSubset(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,subsetName);		
	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -vendor filter- without search")
	@TestCaseId("AdvSe022")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_022(String testCaseId,String userName, String password,String vendorName, String itemNameTemplate,String noOfOtemsTobeCreated, String mfgNameTemplate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_vendorfilter()
		.vendorfilterWithoutSearch(vendorName)
		.clickOnas_vendorfiltersearchbutton()
		.verifyadvseVendorFilter(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,vendorName);

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -vendor filter- with search")
	@TestCaseId("AdvSe023")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_023(String testCaseId,String userName, String password,String vendorName, String itemNameTemplate,String noOfOtemsTobeCreated, String mfgNameTemplate) throws InterruptedException {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_vendorfilter()
		.typeIn_as_Vendorfiltersearchfield(vendorName)
		.vendorfilterWithSearch(vendorName)
		.clickOnas_vendorfiltersearchbutton()
		.verifyadvseVendorFilter(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,vendorName);

	}

	
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Item status - Active/InActive")
	@TestCaseId("AdvSe024")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_024(String testCaseId, String userName, String password, String selectItemStatus, String expStatus) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink()
		.itemsPage()
		.selectDropdownitemstatusDropdown(selectItemStatus)
		.clickOnbottomSeacrhButton()
		.verifyresultsadvSe024(selectItemStatus,expStatus);

	}
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Display Online - yes/No/OR")
	@TestCaseId("AdvSe025, AdvSe026, AdvSe027")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_025_026_027(String testCaseId, String userName, String password, String displayOnlineStatus, String noOfItemsToBeVerify) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(displayOnlineStatus)
		.clickOnbottomSeacrhButton()
		.verifyadvSearchForDispayOnineStatus(noOfItemsToBeVerify,displayOnlineStatus);

	}
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - veriifcation of grayed out fields in Subset Item dropdown")
	@TestCaseId("AdvSe028")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_028(String testCaseId,String userName, String password) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyadvse028();

	}	
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when searched for Active Subset Item")
	@TestCaseId("AdvSe029")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_29(String testCaseId,String userName, String password,String welComeMessage, String subsetName,String subsetStatus, String expectedItems) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage)
		.clickOnItemsLink()
		.itemsPage()
		.clickOnSubsetFilterDropdown()
		.clcikOnSubsetitemStatusFromTheDropdown(subsetName)
		.selectSubsetItemStatus(subsetStatus)
		.clickOnbottomSeacrhButton()
		.verifySubsetItemResults(expectedItems);
		}
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
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

	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void addImageURLtoItems(String testCaseId, String userName,String password,String expWelcomeMsg,String partNumber, String imageURL) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(expWelcomeMsg)
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnImagesTab()
		.clickOnAddNewImageButton()
		.enterImageURL(imageURL)
		.enterImageCaption()
		.clickSaveImageURL();
	}

	String resourceLocation = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void addDocumenttoItems(String testCaseId, String userName,String password,String expWelcomeMsg,String partNumber, String documentLocation) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(expWelcomeMsg)
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.enterDocumentCaption()
		.UploadDocument(documentLocation)
		.assignDocument();
	}
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - veriifcation of Attribute items")
	@TestCaseId("advSearch_30, advSearch_31, advSearch_32")
	@Test(groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_30_31_32(String testCaseId, String userName, String password, String welcomeMessage,String attributeValue, String expMsgForNoAttribute) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectAttributesFromDropDown(attributeValue)
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyAttributesSection(attributeValue,expMsgForNoAttribute);
		
	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when 'Images' is selected under Image dropdown")
	@TestCaseId("AdvSe033")
	@Test(groups="regression", dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_033_034_035(String testCaseId, String userName,String password,String expWelcomeMsg, String advSearchinput, String imageStatus ) throws Exception


	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(expWelcomeMsg);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyImagesStatus()
		.typeinadvancedSearchTopSearchField(advSearchinput)
		.clickOnImagesSubFilter(imageStatus)
		.clickOnbottomSeacrhButton()
		.verifyPartNumbers();
	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate search result displays when 'LongDesc' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe040")
	@Test(groups="regression", dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_039_040_041(String testcaseID, String userName, String password, String welcomeMessage,String partNumber, String itemnametemplate,String longDescription) throws Exception
	{
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(itemnametemplate)
		.clickOnLongDescriptionSubFilter(longDescription)
		.clickOnbottomSeacrhButton()
		.verifylongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyLongDescription(longDescription);
	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays for Categorized/unCategorized/Ignore is selected under Categorized dropdown")
	@TestCaseId("AdvSe042")
	@Test(groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_042_043_044(String testCaseId, String userName, String password, String welcomeMessage,String categoryStatus, String noOfItemsToBeVerify) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectCategorizedDropdown(categoryStatus)
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyadvsearchResultsForCategory(categoryStatus,noOfItemsToBeVerify);
	}

	
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when attributes, images and (AND) is searched under Attribute, "
			+ "Image and Combine Above 'Items With' dropdown'")
	@TestCaseId("advSearch_045 , advSearch_046")
	@Test(groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class) //dependsOnMethods="addImageToItem, addAttributeToItem"
	public void advSearch_045_46(String testCaseId, String userName, String password, String welcomeMessage, String itemnametemplate, String imageStatus,String operator, String attributeValue, String expErrormsgForNoAttribute) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		//.typeinadvancedSearchTopSearchField(itemnametemplate)
		.clickOnImagesSubFilter(imageStatus)
		.clickOnWithAttributesSubFilter()
		.clickOnCombine(operator)
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyItemAttributeAndImage(operator);
	}
	@Features("AdvancedSearch Module")
	@Description("delete the created item(s)")
	@Test(enabled=false,groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void deleteCreatedItem(String testCaseId, String userName, String password, String welcomeMessage, String partNumber, String expSuccesfulMessageForDeletion, String noOfItemsToBeDelete) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink();
		itemsPage()
		.typeinadvancedSearchTopSearchField(partNumber)
		.clickOnbottomSeacrhButton()
		.verifyAndRemoveCreatedItem(partNumber,noOfItemsToBeDelete);
		
		
	}
	@Features("AdvancedSearch Module")
	@Description("delete the created subset")
	@Test(enabled=false,groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void deleteCreatedSubset(String testCaseId, String userName, String password, String welcomeMessage,String subsetName) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonSubsetlink();
		String subsetId=subsetPage()
		.searchForAnSubset(subsetName)
		.verifyandDeleteSubset(subsetName);
		subsetPage()
		.verifySuccessMessageForDeletionOfSubset(subsetName,subsetId);
		
		
	}
	@Features("AdvancedSearch Module")
	@Description("delete the created Brand")
	@Test(enabled=false,groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void deleteCreatedBrand(String testCaseId, String userName, String password, String welcomeMessage,String manufacturerName,String brandName) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.clickOnlisticon()
		.verifyAndRemoveBrand(brandName);
	
	}
	@Features("AdvancedSearch Module")
	@Description("delete the created manufacturer")
	@Test(enabled=false,groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void deleteCreatedManufactures(String testCaseId, String userName, String password, String welcomeMessage,String manufacturerName,String brandName, String successMessage) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.removeAndVerifyManufacturer(manufacturerName)
		.verifySuccessMessageAfterRemove(successMessage);
	}
	@Features("AdvancedSearch Module")
	@Description("delete the created vendor")
	@Test(enabled=true,groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void deleteCreatedVendor(String testCaseId, String userName, String password, String welcomeMessage,String title,String vendorName,String expSuccessMessageForRemove) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.checkVendorPage(title)
		.typeVendorNameInSearch(vendorName)
		.verifyAndRemoveVendore(vendorName)
		.verifySuccessMessageForRemove(vendorName);
	}
	/*@Test(priority=1,dependsOnMethods={"deleteCreatedItem","deleteCreatedSubset","deleteCreatedBrand","deleteCreatedManufactures"})
	public void methodToRemoveAllCreatedTestData(){
		System.out.println("deleted All test data.");
	}*/
}

