package org.cimm2touch.modules;
/**
 * @author Gladson Antony
 *
 */
import org.cimm2touch.dataprovider.SearchData;
/**
 * @author Gladson Antony
 *
 */
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class VendorsModuleTest extends PageFactoryInitializer 
{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Method that Creates Vendors.")
	@Test(enabled=false, groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void createVendors(String testCaseID, String vendorsName, String shortName, String address1, String city, 
			String state, String zip, String country, String email, String subset, String url, String taxID, String status, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.addNewVendor(vendorsName, shortName, address1, city, state, zip, country, email, subset, url, taxID, status)
		.clickOnSaveButtonForAddNewVendors()
		.verifyMessageAfterAddingNewVendor(saveMessage);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the Vendors Page Items.")
	@TestCaseId("TC_Vendors_001")
	@Test(enabled=false, groups={"regression"})
	public void TC_Vendors_001()
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems();		
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to verify Vendor Creation and Message after saving Vendor")
	@TestCaseId("TC_Vendors_002, TC_Vendors_015")
	@Test(enabled=true, groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_002(String testCaseID, String vendorsName, String shortName, String address1, String city, 
			String state, String zip, String country, String email, String subset, String url, String taxID, String status, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.addNewVendor(vendorsName, shortName, address1, city, state, zip, country, email, subset, url, taxID, status)
		.clickOnSaveButtonForAddNewVendors()
		.verifyMessageAfterAddingNewVendor(saveMessage);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the Vendors Page Items.")
	@TestCaseId("TC_Vendors_003, TC_Vendors_004, TC_Vendors_005, TC_Vendors_014")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_003(String testCaseID, String nameErrorMessage, String shortNameErrorMessage, 
			String address1ErrorMessage, String emailErrorMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.clickOnSaveButtonForAddNewVendors()
		.verifyMessageAfterSavingVendorWithoutVendorName(nameErrorMessage)
		.verifyMessageAfterSavingVendorWithoutShortName(shortNameErrorMessage)
		.verifyMessageAfterSavingVendorWithoutAddress1(address1ErrorMessage)
		.verifyMessageAfterSavingVendorWithoutEmail(emailErrorMessage);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test Case is to Verify the Character Limit for Vendors Name, Short Name,  Email")
	@TestCaseId("TC_Vendors_003, TC_Vendors_006, TC_Vendors_007, TC_Vendors_008, TC_Vendors_010, TC_Vendors_012, TC_Vendors_013")
	@Test(groups={"regression"})
	public void TC_Vendors_003_1() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifyCharacterLimitForVendorsNameField()
		.verifyCharacterLimitForShortNameField()
		//.verifyCharacterLimitForAddress1Field()
		.verifyCharacterLimitForEmailAddressField()
		.verifyCharacterLimitForCityField()
		.verifyCharacterLimitForStateField()
		.verifyCharacterLimitForZipField()
		.verifyCharacterLimitForURLField()
		.verifyCharacterLimitForTaxIDField();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to verify  the Text Fields after Reset Button is Pressed.")
	@TestCaseId("TC_Vendors_016")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_016(String testCaseID, String vendorsName, String shortName, String address1, String city, 
			String state, String zip, String country, String email, String subset, String url, String taxID, String status, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.addNewVendor(vendorsName, shortName, address1, city, state, zip, country, email, subset, url, taxID, status)
		.clickOnResetButton()
		.verifyFieldsAfterResetButtonIsPressed();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to search for an Vendor and verify the Search Result.")
	@TestCaseId("TC_Vendors_017, TC_Vendors_018")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_017(String testCaseID, String vendorsName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.searchForAnVendor(vendorsName)
		.verifySearchResultForVendors(vendorsName);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to verify Error Messages on Clearing Mandatory Fields in Edit vendors Page.")
	@TestCaseId("TC_Vendors_019, TC_Vendors_020, TC_Vendors_021, TC_Vendors_022, TC_Vendors_023, TC_Vendors_024")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_019(String testCaseID, String vendorsName, String vendorNameMessage, String shortNameMessage, String address1Message, String emailMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.searchForAnVendor(vendorsName)
		.verifySearchResultForVendors(vendorsName)
		.clickOnEditVendors(vendorsName)
		.editVendorsPage()
		.verifyEditVendorsPageItems()
		.verifyMessageOnUpdatingVendorsWithoutName(vendorNameMessage)
		.verifyMessageOnUpdatingVendorsWithoutShortName(shortNameMessage)
		.verifyMessageOnUpdatingVendorsWithoutAddress1(address1Message)
		.verifyMessageOnUpdatingVendorsWithoutEmail(emailMessage);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to search for an Vendor and verify the Search Result.")
	@TestCaseId("TC_Vendors_026")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_026(String testCaseID, String vendorsName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.searchForAnVendor(vendorsName)
		.verifySearchResultForVendors(vendorsName)
		.clickOnEditVendors(vendorsName)
		.editVendorsPage()
		.verifyEditVendorsPageItems()
		.clickOnHistoryButton()
		.switchToNewlyOpenedWindowAndVerifyVendorName(vendorsName);
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This Test case is to verify the Working of 'Back' Button in Edit Vendors Page")
	@TestCaseId("TC_Vendors_027")
	@Test(groups={"regression"},dataProvider="VendorsModuleTest",dataProviderClass=SearchData.class)
	public void TC_Vendors_027(String testCaseID, String vendorsName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.searchForAnVendor(vendorsName)
		.verifySearchResultForVendors(vendorsName)
		.clickOnEditVendors(vendorsName)
		.editVendorsPage()
		.verifyEditVendorsPageItems()
		.clickOnBackButtonInEditVendorsPage()
		.vendorsPage()
		.verifyVendorsPageItems();		
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the working of 'Previous' Button in Vendors Page")
	@TestCaseId("TC_Vendors_032")
	@Test(groups={"regression"})
	public void TC_Vendors_032() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifytheWorkingOfThePreviousPageOption();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the working of 'Next' Button in Vendors Page")
	@TestCaseId("TC_Vendors_033")
	@Test(groups={"regression"})
	public void TC_Vendors_033() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifytheWorkingOfTheNextPageOption();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the working of 'First' Button in Vendors Page")
	@TestCaseId("TC_Vendors_034")
	@Test(groups={"regression"})
	public void TC_Vendors_034() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifytheWorkingOfTheFirstPageOption();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the working of 'Last' Button in Vendors Page")
	@TestCaseId("TC_Vendors_035")
	@Test(groups={"regression"})
	public void TC_Vendors_035() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifytheWorkingOfTheLastPageOption();
	}
	
	@Features(value = {"Vendors Module"})
	@Description("This is a Test Case to Verify the working of 'Display Items Per Page' in Vendors Page")
	@TestCaseId("TC_Vendors_036")
	@Test(groups={"regression"})
	public void TC_Vendors_036() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.verifyVendorsPageItems()
		.verifytheWorkingOfTheLastPageOption()
		.verifyDisplayNoOfItemsDropdown();
	}
	
}

