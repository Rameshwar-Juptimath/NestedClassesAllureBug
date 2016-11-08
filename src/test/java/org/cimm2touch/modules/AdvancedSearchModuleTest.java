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

public class AdvancedSearchModuleTest extends PageFactoryInitializer {

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	
	
	@Description("This method is used to create new manufacturer.")
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
	@Description("This method is used to create a new brand.")
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
	
	@Description("This method is used to create a new subset.")
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

/*	@Test()
	public void createVendor() throws InterruptedException, Exception 
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi())
		.homePage().clickOnVendorLink()
		.vendorsPage().checkVendorPage()
		.typeInVendorName(data.vendorname())
		.typeInVendorshortname(data.vendorshortname())
		.typeInVendorAddress(data.vendoraddress())
		.typeInVendorEmailAddress(data.vendoremailaddress())
		.selectVendorSubset(data.subsetname())
		.vendorSave()
		.checkVendorSavemessg(data.vendorsavemsg());
	}*/
	
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
	
	@DataProvider(name = "partNumbersforDescription")
	public static Object[][] partNumbersforDescription()
	{
		return new Object[ ][ ] {
			new Object[] {"Automation_PN_1"},
			new Object[] {"Automation_PN_2"}
		};
	}

	@DataProvider(name = "partNumberswithLongDescriptionVerification")
	public static Object[][] partNumberswithLongDescription()
	{
		return new Object[ ][ ] {
			new Object[] {"Automation_PN_1"},
			new Object[] {"Automation_PN_2"}
		};
	}

	@DataProvider(name = "partNumberswithoutLongDescriptionVerification")
	public static Object[][] partNumberswithoutLongDescription()
	{
		return new Object[ ][ ] {
			new Object[] {"Automation_PN_3"},
			new Object[] {"Automation_PN_4"},
			new Object[] {"Automation_PN_5"}
		};
	}

	@DataProvider(name = "partNumbersIgnoreLongDescriptionVerification")
	public static Object[][] partNumbersIgnoreLongDescription()
	{
		return new Object[ ][ ] {
			new Object[] {"Automation_PN_1"},
			new Object[] {"Automation_PN_2"},
			new Object[] {"Automation_PN_3"},
			new Object[] {"Automation_PN_4"},
			new Object[] {"Automation_PN_5"}
		};
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
	public void advSearch_010(String testCaseId,String userName, String password,String searchData, String selectValue) throws InterruptedException {
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
		.verifyadvSe010Searchresult(searchData);

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
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Subsetfilter()
		.subsetfilterWithoutSearch(subsetName)
		.clickOnas_Subsetfiltersearchbutton()
		.verifyadvse020(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,subsetName);

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
		.verifyadvse020(itemNameTemplate,noOfOtemsTobeCreated,mfgNameTemplate,subsetName);		
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

	//
	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Item status - Active")
	@TestCaseId("AdvSe024")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_024(String testCaseId, String userName, String password, String selectItemStatus) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdownitemstatusDropdown(selectItemStatus)
		.clickOnbottomSeacrhButton()
		.verifyresultsadvSe024(selectItemStatus);

	}


	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Display Online - Yes")
	@TestCaseId("AdvSe025")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_025(String testCaseId, String userName, String password, String displayOnlineStatus) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectDropdowndisplayOnlineDropdown(displayOnlineStatus)
		.clickOnbottomSeacrhButton()
		.verifyadvse025();

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Display Online - No")
	@TestCaseId("AdvSe026")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_026(String testCaseId, String userName, String password, String displayOnlineStatus) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(displayOnlineStatus)
		.clickOnbottomSeacrhButton()
		.verifyadvse026();

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search -Display Online - All")
	@TestCaseId("AdvSe027")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_027(String testCaseId, String userName, String password, String displayOnlineStatus) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(displayOnlineStatus)
		.clickOnbottomSeacrhButton()
		.verifyadvse027();

	}

	@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - veriifcation of grayed out fields in Subset Item dropdown")
	@TestCaseId("AdvSe028")
	@Test(groups="regression",dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_028(String userName, String password) throws Exception {
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


	/*@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate search result displays when 'LongDesc' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe039")
	@Test(groups="regression", dataProvider="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_039(String testcaseID, String userName, String password, String welcomeMessage,String partNumber, String itemnametemplate) throws Exception
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
		.clickOnLongDescSubFilter()
		.clickOnbottomSeacrhButton()
		.verifylongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyLongDescription();
	}*/


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

	/*@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when 'Ignore' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe041")
	@Test(groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSearch_041(String testcaseID, String userName, String password, String welcomeMessage, String partNumber, String itemTemplate) throws Exception
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
		.typeinadvancedSearchTopSearchField(itemTemplate)
		.clickOnbottomSeacrhButton()
		.verifyIgnorelongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyIgnorelongDescPartNumbers();
	}
*/
	


	/*@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when attributes, images and (OR) is searched for Combine Above 'Items With'")
	@TestCaseId("AdvSe046")
	@Test(groups="regression")//,dataProvider ="partNumbersIgnoreLongDescriptionVerification")
	public void advSe046(@Parameter("Part Number")String partNumber) throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.itemnametemplate())
		.clickOnImagesSubFilter()
		.clickOnWithAttributesSubFilter()
		.clickOnCombinewithOR()
		.clickOnbottomSeacrhButton();
	}*/

	@DataProvider(name="Select Value For Attributes")
	public Object[][] selectValueForAttributes() throws Exception
	{
		return new Object[][] {
			new Object[] {"Automation_PN_1"}
			//new Object[] {"Automation_PN_2"}
		};
	}

	



	/*@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - veriifcation of No Attribute items")
	@TestCaseId("AdvSe031")
	@Test()
	public void advSe031() throws Exception 
	{
		new LoginModuleTest()
		.login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectWithoutAttributesDropdown()
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyadvse031();
	}
*/
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

	/*@Features("AdvancedSearch Module")
	@Description("Items - Advanced Search - veriifcation of Attribute items")
	@TestCaseId("AdvSe043")
	@Test(groups="regression",dataProvider ="AdvancedSearchModuleTest", dataProviderClass=SearchData.class)
	public void advSe043(String testCaseId, String userName, String password, String welcomeMessage) throws Exception 
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
		.selectWithOutCategorizedDropdown()
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyadvse043();
	}*/
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
	@Description("This method is used to delete the created item(s)")
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
	/*@Test(priority=1,dependsOnMethods={"deleteCreatedItem","deleteCreatedSubset","deleteCreatedBrand","deleteCreatedManufactures"})
	public void methodToRemoveAllCreatedTestData(){
		System.out.println("deleted All test data.");
	}*/
}

