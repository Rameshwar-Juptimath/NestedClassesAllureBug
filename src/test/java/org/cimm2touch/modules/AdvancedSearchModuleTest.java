package org.cimm2touch.modules;

import java.io.File;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AdvancedSearchModuleTest extends PageFactoryInitializer {

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Description("This method is used to create Manufacturer, brand, subset, item")
	@Features(value={"AdvancedSearch Module"})
	@Test(priority=0,groups="regression")
	public void adv001ExecuteFirst() throws Exception
	{ 
		//createManufacturer();
		createBrand();
		createSubset();
		//createVendor();
		createItems();
	}
	
	@Description("This method is used to create new manufacturer.")
	@Features(value={"AdvancedSearch Module"})
	@Test(groups={"regression"}, dataProvider="AdvancedSearchModuleTest",dataProviderClass=SearchData.class)
	public void createManufacturer(String testCaseId, String userName, String password, String welComeMessage,String manufacturerName, String manufacturerCode, String SuccessMessageAfterCreate) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welComeMessage);  
		homePage()
		.clickonMB()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.manufacturerSearchResult(manufacturerName)
		.homePage()
		.clickonMB()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.clickonmanufacturerbutton()
		.typeinmanufield(manufacturerName)
		.typeinmanucodefield(manufacturerCode)
		.checkmanufactureractive()
		.clickonmanufacturersave()
		.verifymessageAfterManufacturerCreate(manufacturerName,SuccessMessageAfterCreate);

	}
	@Description("This method is used to create new brand.")
	@Features(value={"AdvancedSearch Module"})
	@Test(groups={"regression"})
	public void createBrand() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin();
		homePage()
		.clickonMB()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.manufacturername())
		.clickonMBsearch()
		.checkManufacturerAlreadyExist(data.manufacturername())
		.clickOnlisticon()
		.isBrandpresent(data.brandname())
		.clickOnaddnewbrandbutton()
		.checkBrandFormEnabled()
		.selectmanufacturerfromdropdown(data.manufacturername())
		.typeinbrandname(data.brandname())
		.typeinBrandDescField(data.branddesc())
		.checkOnBrandActive().checkOnItemActive()
		.clickonbrandsave()
		.checkBrandSaveMessage(data.brandsavemsg());
	}

	@Test(groups={"regression"})
	public void createSubset() throws InterruptedException, Exception 
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi());
		homePage().clickOnSubset()
		.subsetPage()
		.checkSubsetPage()
		.typeInSubsetSearch(data.subsetname())
		.clickOnSubsetSearchButton()
		.subsetSearchResult(data.subsetname())//checks whether subset already exists
		.clickOnSubsetButton()
		.typeInSubsetNameField(data.subsetname())
		.clickOnSubsetSave()
		.verifySubsetCreationMessage(data.subsetsavemsgexpected());

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

	@Test()
	public void createItems() throws InterruptedException 
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin();
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi()).clickOnItemsLink()
		.itemsPage()
		.createItemsinside(data.manufacturername(), data.brandname(),
				data.itemnametemplate(), data.manufacturernametemplate(),
				data.vendorname(), data.savenewItemMessage(), data.subsetname(), data.Noofitemstobecreated());
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


	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No or Keyword search")
	@TestCaseId("AdvSe003")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe003() throws Exception 
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe003searchinput())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe003Searchresult(data.advSe003searchinput());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No or Keyword search- Negative Test case")
	@TestCaseId("AdvSe004")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe004() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe004searchinput())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No or Keyword search- Partial Search")
	@TestCaseId("AdvSe005")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe005() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe005searchinput())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe005Searchresult(data.advSe005searchinput());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Invalid keyword")
	@TestCaseId("AdvSe006")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe006() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe006searchinput())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No search")
	@TestCaseId("AdvSe007")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe007() throws InterruptedException {
		String selectvalue="Part Number";
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe007searchinput()).selectDropdownTop(selectvalue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe007Searchresult(data.advSe007searchinput());		
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No search- Partial search")
	@TestCaseId("AdvSe008")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe008() throws InterruptedException {
		String selectvalue="Part Number";
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe008searchinput()).selectDropdownTop(selectvalue)
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe008Searchresult(data.advSe008searchinput());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No search- Invalid Part Number")
	@TestCaseId("AdvSe009")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe009() throws InterruptedException {
		data.setSelectValue("Part Number");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe009searchinput()).selectDropdownTop(data.getSelectValue())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Manufacturer Part No search")
	@TestCaseId("AdvSe010")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe010() throws InterruptedException {
		data.setSelectValue("Manufacturer Part Number");
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe010searchinput()).selectDropdownTop(data.getSelectValue())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe010Searchresult(data.advSe010searchinput());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Manufacturer Part No search- Invalid MPN")
	@TestCaseId("AdvSe011")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe011() throws InterruptedException {
		data.setSelectValue("Manufacturer Part Number");
		new LoginModuleTest().login();
		landingPage().homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe011searchinput()).selectDropdownTop(data.getSelectValue())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - CIMM Item ID")
	@TestCaseId("AdvSe014")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe014() throws Exception {
		data.setSelectValue("CIMM Item Id");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe014searchinput())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe003Searchresult(data.advSe014searchinput())
		.typeinadvancedSearchTopSearchField(itemsPage().getCIMMItemID(data.advSe014searchinput())).selectDropdownTop(data.getSelectValue())
		.clickOnadvancedSearchTopSearchButton().verifyadvSe014Searchresult(itemsPage().getCIMMItemID(data.advSe014searchinput()));

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - CIMM Item ID- Invalid input")
	@TestCaseId("AdvSe015")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe015() throws InterruptedException {
		data.setSelectValue("CIMM Item Id");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.typeinadvancedSearchTopSearchField(data.advSe015searchinput()).selectDropdownTop(data.getSelectValue())
		.clickOnadvancedSearchTopSearchButton()
		.verifyadvSe004Searchresult();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Manufacturer filter- without search")
	@TestCaseId("AdvSe016")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe016() throws Exception {

		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Manufacturerfilter().manufacturerfilterWithoutSearch(data.manufacturername())
		.clcikOnas_Manufacturerfiltersearchbutton().
		verifyadvSe016(data.manufacturername(),data.brandname(),data.Noofitemstobecreated());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Manufacturer filter- with search")
	@TestCaseId("AdvSe017")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe017() throws InterruptedException {

		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Manufacturerfilter().
		typeInas_Manufacturerfiltersearchfield(data.manufacturername()).
		manufacturerfilterWithSearch(data.manufacturername()).
		clcikOnas_Manufacturerfiltersearchbutton().
		verifyadvSe016(data.manufacturername(),data.brandname(),data.Noofitemstobecreated());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Brand filter- without search")
	@TestCaseId("advSe018")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe018() throws InterruptedException {

		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Brandfilter().
		brandfilterWithoutSearch(data.brandname()).
		clickOnas_Brandfiltersearchbutton()
		.verifyadvSe016(data.manufacturername(),data.brandname(),data.Noofitemstobecreated());

	}


	@Features("Advanced Search")
	@Description("Items - Advanced Search -Brand filter- with search")
	@TestCaseId("advSe019")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe019() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Brandfilter().
		typeIn_as_Brandfiltersearchfield(data.brandname())
		.brandfilterWithSearch(data.brandname()).
		clickOnas_Brandfiltersearchbutton().
		verifyadvSe016(data.manufacturername(),data.brandname(),data.Noofitemstobecreated());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Subset filter- without search")
	@TestCaseId("AdvSe020")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe020() throws InterruptedException {

		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Subsetfilter()
		.subsetfilterWithoutSearch(data.subsetname())
		.clickOnas_Subsetfiltersearchbutton()
		.verifyadvse020(data.itemnametemplate(),data.Noofitemstobecreated(),data.manufacturernametemplate(),data.subsetname());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Subset filter- with search")
	@TestCaseId("AdvSe021")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe021() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_Subsetfilter().typeIn_as_Subsetfiltersearchfield(data.subsetname())
		.subsetfilterWithSearch(data.subsetname())
		.clickOnas_Subsetfiltersearchbutton()
		.verifyadvse020(data.itemnametemplate(),data.Noofitemstobecreated(),data.manufacturernametemplate(),data.subsetname());		
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -vendor filter- without search")
	@TestCaseId("AdvSe022")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe022() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_vendorfilter()
		.vendorfilterWithoutSearch(data.vendorname())
		.clickOnas_vendorfiltersearchbutton()
		.verifyadvseVendorFilter(data.itemnametemplate(),data.Noofitemstobecreated(),data.manufacturernametemplate(),data.vendorname());

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -vendor filter- with search")
	@TestCaseId("AdvSe023")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe023() throws InterruptedException {
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.clickOnas_vendorfilter().typeIn_as_Vendorfiltersearchfield(data.vendorname())
		.vendorfilterWithSearch(data.vendorname())
		.clickOnas_vendorfiltersearchbutton()
		.verifyadvseVendorFilter(data.itemnametemplate(),data.Noofitemstobecreated(),data.manufacturernametemplate(),data.vendorname());

	}

	//
	@Features("Advanced Search")
	@Description("Items - Advanced Search -Item status - Active")
	@TestCaseId("AdvSe024")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe024() throws Exception {
		data.setSelectValue("Active");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdownitemstatusDropdown(data.getSelectValue())
		.clickOnbottomSeacrhButton()
		.verifyresultsadvSe024(data.getSelectValue());

	}


	@Features("Advanced Search")
	@Description("Items - Advanced Search -Display Online - Yes")
	@TestCaseId("AdvSe025")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe025() throws Exception {
		data.setSelectValue("Yes");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(data.getSelectValue())
		.clickOnbottomSeacrhButton()
		.verifyadvse025();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Display Online - No")
	@TestCaseId("AdvSe026")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe026() throws Exception {
		data.setSelectValue("No");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(data.getSelectValue())
		.clickOnbottomSeacrhButton()
		.verifyadvse026();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search -Display Online - All")
	@TestCaseId("AdvSe027")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe027() throws Exception {
		data.setSelectValue("All");
		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.selectDropdowndisplayOnlineDropdown(data.getSelectValue())
		.clickOnbottomSeacrhButton()
		.verifyadvse027();

	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - veriifcation of grayed out fields in Subset Item dropdown")
	@TestCaseId("AdvSe028")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe028() throws Exception {

		new LoginModuleTest().login();
		homePage().clickOnItemsLink().itemsPage()
		.verifyadvse028();

	}	

	@Test(dataProvider="partNumbersforDescription")
	public void addDescriptiontoItems(@Parameter("partNumber")String partNumberDesc) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getWelcomeMessage())
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumberDesc)
		.clickOnSpecificItemEditButton(partNumberDesc)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.editLongDescription(data.getLongDescription1())
		.editLongDescription2(data.getLongDescription2())
		.saveDescription();
	}

	@Test(dataProvider="partNumbersforDescription")
	public void addImageURLtoItems(@Parameter("partNumber")String partNumber) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getWelcomeMessage())
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnImagesTab()
		.clickOnAddNewImageButton()
		.enterImageURL(data.getImageURL())
		.enterImageCaption()
		.clickSaveImageURL();
	}

	String resourceLocation = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
	@Test(dataProvider="partNumbersforDescription")
	public void addDocumenttoItems(@Parameter("partNumber")String partNumber) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getWelcomeMessage())
		.clickOnItemsLink()
		.itemsPage()
		.searchItem(partNumber)
		.clickOnSpecificItemEditButton(partNumber)
		.editItemsPage()
		.clickOnDocumentsTab()
		.clickOnAddNewDocumentButton()
		.enterDocumentCaption()
		.UploadDocument(data.getdocumentLocation())
		.assignDocument();
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when 'Images' is selected under Image dropdown")
	@TestCaseId("AdvSe033")
	@Test(groups="regression")//,dependsOnMethods={"adv001executeFirst"})
	public void advSe033() throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.verifyImagesStatus()
		.typeinadvancedSearchTopSearchField("Automation_PN")
		.clickOnImagesSubFilter()
		.clickOnbottomSeacrhButton()
		.verifyPartNumbers();
	}


	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate search result displays when 'LongDesc' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe039")
	@Test(groups="regression",dataProvider ="partNumberswithLongDescriptionVerification")
	public void advSe039(@Parameter("Part Number")String partNumber) throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.itemnametemplate())
		.clickOnLongDescSubFilter()
		.clickOnbottomSeacrhButton()
		.verifylongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyLongDescription();
	}


	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate search result displays when 'LongDesc' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe040")
	@Test(groups="regression",dataProvider ="partNumberswithoutLongDescriptionVerification")
	public void advSe040(@Parameter("Part Number")String partNumber) throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.itemnametemplate())
		.clickOnNoLongDescSubFilter()
		.clickOnbottomSeacrhButton()
		.verifyNolongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyNoLongDescription();
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when 'Ignore' is selected under LongDesc dropdown")
	@TestCaseId("AdvSe041")
	@Test(groups="regression",dataProvider ="partNumbersIgnoreLongDescriptionVerification")
	public void advSe041(@Parameter("Part Number1")String partNumber) throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.itemnametemplate())
		.clickOnbottomSeacrhButton()
		.verifyIgnorelongDescPartNumbers(partNumber)
		.clickOnEditButton(partNumber)
		.editItemsPage()
		.clickOnDescriptionTabLink()
		.verifyIgnorelongDescPartNumbers();
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when attributes, images and (AND) is searched under Attribute, "
			+ "Image and Combine Above 'Items With' dropdown'")
	@TestCaseId("AdvSe045")
	@Test(groups="regression")//,dataProvider ="partNumbersIgnoreLongDescriptionVerification")
	public void advSe045(/*@Parameter("Part Number")String partNumber*/) throws Exception
	{
		new LoginModuleTest().login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.typeinadvancedSearchTopSearchField(data.itemnametemplate())
		.clickOnImagesSubFilter()
		.clickOnWithAttributesSubFilter()
		.clickOnCombinewithAND()
		.clickOnbottomSeacrhButton();
	}


	@Features("Advanced Search")
	@Description("Items - Advanced Search - Verification of appropriate  search result displays when attributes, images and (OR) is searched for Combine Above 'Items With'")
	@TestCaseId("AdvSe046")
	@Test(groups="regression")//,dataProvider ="partNumbersIgnoreLongDescriptionVerification")
	public void advSe046(/*@Parameter("Part Number")String partNumber*/) throws Exception
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
	}

	@DataProvider(name="Select Value For Attributes")
	public Object[][] selectValueForAttributes() throws Exception
	{
		return new Object[][] {
			new Object[] {"Automation_PN_1"}
			//new Object[] {"Automation_PN_2"}
		};
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - veriifcation of Attribute items")
	@TestCaseId("AdvSe030")
	@Test()
	public void advSe030() throws Exception 
	{
		new LoginModuleTest()
		.login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectWithAttributesDropdown()
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnAttributesTab()
		.verifyadvse030();
	}



	@Features("Advanced Search")
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

	@Features("Advanced Search")
	@Description("Items - Advanced Search - veriifcation of Attribute items")
	@TestCaseId("AdvSe042")
	@Test()
	public void advSe042() throws Exception 
	{
		new LoginModuleTest()
		.login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectWithCategorizedDropdown()
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyadvse042();
	}

	@Features("Advanced Search")
	@Description("Items - Advanced Search - veriifcation of Attribute items")
	@TestCaseId("AdvSe043")
	@Test()
	public void advSe043() throws Exception 
	{
		new LoginModuleTest()
		.login();
		homePage()
		.clickOnItemsLink()
		.itemsPage()
		.selectWithOutCategorizedDropdown()
		.clickOnbottomSeacrhButton()
		.clickOnFirstEditButton()
		.editItemsPage()
		.clickOnCategorizationTab()
		.verifyadvse043();
	}
}

