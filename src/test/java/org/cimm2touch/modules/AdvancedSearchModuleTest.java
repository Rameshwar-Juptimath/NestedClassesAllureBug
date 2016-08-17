package org.cimm2touch.modules;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AdvancedSearchModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Test(priority=0,groups="regression")
	public void adv001executeFirst() throws Exception
	{ 
		create_Manufacturer();
		createBrand();
		createSubset();
		createVendor();
		createItems();
	}

	public void create_Manufacturer() throws Exception {
		landingPage()
		.enterUsername(data.getUserNameVadirajTest())
		.enterPassword(data.getPasswordVadirajTest())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi());  
		 homePage()
		.clickonMB()
		.manufacturerPage().assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.manufacturername())
		.clickonMBsearch()
		.manufacturerSearchResult(data.manufacturername())
		.homePage().clickonMB().manufacturerPage()
		.assrtManufacturerbrandtextLocator()
		.clickonmanufacturerbutton()
		.typeinmanufield(data.manufacturername())
		.typeinmanucodefield(data.manufacturercode())
		.checkmanufactureractive()
		.clickonmanufacturersave()
		.verifymessage(data.manufacturername()+" "+data.manufacturerSuccessmessage());
							
	}
	
	public void createBrand() throws Exception {
		homePage()
		.clickonMB()
		.manufacturerPage().assrtManufacturerbrandtextLocator()
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

	public void createSubset() throws InterruptedException, Exception {
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi());
		 homePage().clickonsubset()
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
	
	public void createVendor() throws InterruptedException, Exception {
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi())
		 .homePage().clickOnVendorLink()
		 .vendorsPage().checkVendorPage()
		 /*.typeInVendorSearch(data.vendorname())
		 .clickOnVendorSearchButton(data.vendorname())
		 .vendorSearchResult(data.vendorname())*/
		 .typeInVendorName(data.vendorname())
		 .typeInVendorshortname(data.vendorshortname())
		 .typeInVendorAddress(data.vendoraddress())
		 .typeInVendorEmailAddress(data.vendoremailaddress())
		 .selectVendorSubset(data.subsetname())
		 .vendorSave()
		 .checkVendorSavemessg(data.vendorsavemsg());
		 
	}

	public void createItems() throws InterruptedException {
		
		homePage()
		.verifyWelcomeMessage(data.getwelcomeMessagevadi()).clickOnItemsLink()
		.itemsPage()
		.createItemsinside(data.manufacturername(), data.brandname(),
				data.itemnametemplate(), data.manufacturernametemplate(),
				data.vendorname(), data.savenewItemMessage(), data.subsetname(), data.Noofitemstobecreated());
	}
	
	@Features("Advanced Search")
	@Description("Items - Advanced Search - Part No or Keyword search")
	@TestCaseId("AdvSe003")
	@Test(groups="regression",dependsOnMethods={"adv001executeFirst"})
	public void advSe003() throws Exception {
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
}
	