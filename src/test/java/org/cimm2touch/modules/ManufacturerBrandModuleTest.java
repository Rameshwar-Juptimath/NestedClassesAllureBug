package org.cimm2touch.modules;
/**
 * @author Thiruveedhi Chinna
 *
 */
import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ManufacturerBrandModuleTest extends PageFactoryInitializer 
{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	RandomGenerator random=new RandomGenerator();

	

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to verify the 'Add New Manufacturer' Form Items")
	@TestCaseId("TC_MB_001, TC_MB_005")
	@Test( groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_001(String testCaseID,String userName,String password) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to verify the 'Add New Manufacturer' Form Items")
	@TestCaseId("TC_MB_002, TC_MB_003, TC_MB_007, TC_MB_008")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_002(String testCaseID,String userName,String password, String manufacturersName, String manufacturersCode, String manufacturerActiveStatus, String saveMessage) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.addNewManufacture(manufacturersName, manufacturersCode, manufacturerActiveStatus)
		.clickOnSaveNewManufacturer()
		.verifyMessageAfterSavingManufacturer(saveMessage)
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to verify the 'Add New Manufacturer' Form Items")
	@TestCaseId("TC_MB_002")
	@Test(priority=5,groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_002_1(String testCaseID,String userName,String password, String manufacturersName, String manufacturersCode, String manufacturerActiveStatus, String errorMessage) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.addNewManufacture(manufacturersName, manufacturersCode, manufacturerActiveStatus)
		.clickOnSaveNewManufacturer()
		.verifyErrorMessageAfterSavingManufacturer(errorMessage);
	}

	@Features(value = {"Manufacturers & Brands"})
	@Description("This Test Case is to verify the 'Reset' Option in  'Add New Manufacturer' Form.")
	@TestCaseId("TC_MB_004")
	@Test(priority=6,groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_004(String testCaseID,String userName,String password, String manufacturersName, String manufacturersCode, String manufacturerActiveStatus) throws Exception 
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.addNewManufacture(manufacturersName, manufacturersCode, manufacturerActiveStatus)
		.clickOnResetManufacturersFieldsButton()
		.verifyManufacturersFormItemsAfterClickingResetButton();
	}


	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Display No. Of Items' in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_006")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_006(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.verifyDisplayNoOfItemsDropdown();
	}


	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Previous Option' in Pagination in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_010")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_010(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.verifytheWorkingOfThePreviousPageOption();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Next Option' in Pagination in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_011")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_011(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.verifytheWorkingOfTheNextPageOption();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Last Option' in Pagination in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_012")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_012(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.verifytheWorkingOfTheLastPageOption();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'First Option' in Pagination in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_013")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_013(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.verifytheWorkingOfTheFirstPageOption();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Generic Column Settings' in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_014, TC_MB_015 ")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_014(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnGenericColumnSettings()
		.verifyGenericColumnSettingsItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to Verify the Working of the 'Sort Order' Option under 'Generic Column Settings'  in Manufacturers & Brands Page.")
	@TestCaseId("TC_MB_019, TC_MB_020, TC_MB_022")
	@Test(groups = {"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_019(String testCaseID,String userName,String password) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnGenericColumnSettings()
		.verifyGenericColumnSettingsItems()
		.clickOnSortOrder()
		.clickOnAddNewSortOrder()
		.verifyItemsDisplayedAfterClickingSortOrder()
		.clickOnRemoveSortOrder();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case Verifies the Add New Brand Fields.")
	@TestCaseId("TC_MB_023, TC_MB_024, TC_MB_025, TC_MB_026, TC_MB_027, TC_MB_028")
	@Test(priority=14,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_023(String testCaseID,String userName,String password, String manufacturersName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnAddNewBrand()
		.verifyAddNewBrandFormItems()
		.verifyPreSelectedManufacturerWhenAddingBrand(manufacturersName)
		.verifyCharacterLimitForBrandNameField()
		.verifyCharacterLimitForBrandDescField()
		.verifyCharacterLimitForBrandURL()
		.clickOnResetBrandFields()
		.verifyBrandsFieldsAfterClickingResetButton();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the message after saving a Brand without Name.")
	@TestCaseId("TC_MB_026, TC_MB_029")
	@Test(priority=15,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_026_1(String testCaseID,String userName,String password, String manufacturersName, String brandName, String brandDesc, String brandURL, String brandActiveStatus, String errorMessage) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnAddNewBrand()
		.verifyAddNewBrandFormItems()
		.addNewBrand(brandName, brandDesc, brandActiveStatus, brandURL)
		.clickOnSaveNewBrand()
		.verifyErrorMessageOnSavingBrand(errorMessage);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case Verify 'Edit Manufacturer Page' Items.")
	@TestCaseId("TC_MB_030, TC_MB_031")
	@Test(priority=16,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_030(String testCaseID,String userName,String password, String manufacturersName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnEditManufacturer(manufacturersName)
		.editManufacturersPage()
		.verifyEditManufacturersAndBrandsPageItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is verify message after Updating Manufacturer without Name.")
	@TestCaseId("TC_MB_032")
	@Test(priority=17,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_032(String testCaseID,String userName,String password, String manufacturersName, String errorMessage) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnEditManufacturer(manufacturersName)
		.editManufacturersPage()
		.verifyEditManufacturersAndBrandsPageItems()
		.clearEditManufacturerNameField()
		.clickOnUpdateEditedManufacturer()
		.verifyMessageAfterUpdatingManufacturer(errorMessage);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the working of 'BACK Button' in Edit Manufacturer's Page.")
	@TestCaseId("TC_MB_033, TC_MB_034")
	@Test(priority=18,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_033(String testCaseID,String userName,String password, String manufacturersName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnEditManufacturer(manufacturersName)
		.editManufacturersPage()
		.verifyEditManufacturersAndBrandsPageItems()
		.clickOnBackButtonInEditPage()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the working of 'Custom Fields' in Edit Manufacturer's Page.")
	@TestCaseId("TC_MB_035")
	@Test(priority=19,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_035(String testCaseID,String userName,String password, String manufacturersName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnEditManufacturer(manufacturersName)
		.editManufacturersPage()
		.verifyEditManufacturersAndBrandsPageItems()
		.clickOnCustomFieldsTab();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the 'Edit Brands' Page Items.")
	@TestCaseId("TC_MB_036, TC_MB_037, TC_MB_038")
	@Test(priority=20,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_036(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the Message On Updating an Brand without Name.")
	@TestCaseId("TC_MB_039, TC_MB_040")
	@Test(priority=21,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_039(String testCaseID,String userName,String password, String brandName, String errorMessage) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.clearEditBrandsField()
		.clickOnUpdateBrand()
		.verifyTheMessageAfterSavingBrandWithoutName(errorMessage);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the Character Limit for 'Edit BrandName'.")
	@TestCaseId("TC_MB_039")
	@Test(priority=22,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_039_1(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.verifyCharacterLimitForEditBrandName();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the Character Limit for 'Edit BrandName'.")
	@TestCaseId("TC_MB_041")
	@Test(priority=23,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_041(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.clickOnBackButtonInEditBrandsPage()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the 'Custom Fields' Tab in Edit Brands Page.")
	@TestCaseId("TC_MB_042")
	@Test(priority=24,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_042(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.clickOnCustomFieldsTab();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to add 'new Manufacturer and Brand'")
	@TestCaseId("TC_MB_043")
	@Test(priority=25,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_043(String testCaseID,String userName,String password, String manufacturersName, String manufacturersCode, String manufacturerActiveStatus, 
			String manufacturerSaveMessage, String brandName, String brandDesc, String brandActiveStatus, String brandURL, String brandSaveMessage) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.addNewManufacture(manufacturersName, manufacturersCode, manufacturerActiveStatus)
		.clickOnSaveNewManufacturer()
		.verifyMessageAfterSavingManufacturer(manufacturerSaveMessage);
		Thread.sleep(5000);
		manufacturersAndBrandsPage()
		.searchForManufacturer(manufacturersName)
		.verifyAfterSearchingForManufacturer(manufacturersName)
		.clickOnAddNewBrand()
		.verifyAddNewBrandFormItems()
		.verifyPreSelectedManufacturerWhenAddingBrand(manufacturersName)
		.addNewBrand(brandName, brandDesc, brandActiveStatus, brandURL)
		.clickOnSaveNewBrand()
		.verifyMessageAfterSavingBrands(brandSaveMessage);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to remove newly added 'Manufacturer and Brand'")
	@TestCaseId("TC_MB_043_1")
	@Test(priority=26,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_043_1(String testCaseID,String userName,String password, String manufacturerName, String brandName, String manuDelMessage, String brandDelMessage) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.searchForBrand(brandName)
		.verifyAfterSearchingForBrand(brandName)
		.clickOnDeleteBrand()
		.verifyMessageAfterDeletingBrand(brandDelMessage);
		Thread.sleep(5000);
		manufacturersAndBrandsPage()
		.searchForManufacturer(manufacturerName)
		.verifyAfterSearchingForManufacturer(manufacturerName)
		.clickOnDeleteManufacturer()
		.verifyMessageAfterDeletingManufacturer(manuDelMessage);
	}


	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to verify the Character Limit for 'Manufacturer Name' ")
	@TestCaseId("TC_MB_045")
	@Test(groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void verifyCharLimitManuName(String testcaseId, String userName, String password) throws Exception 
	{
		
		String maxChars=random.random(100, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.verifyCharacterLimitForManufacturersName(maxChars);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This Test Case is to verify the Character Limit for 'Manufacturer Code' ")
	@TestCaseId("TC_MB_046")
	@Test(groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void verifyCharLimitManuCode(String testcaseId, String userName, String password) throws Exception 
	{
		String maxNums=random.random(100, PermittedCharacters.NUMERIC);
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.clickOnAddNewManufacturerButton()
		.verifyAddNewManufacturerFormItems()
		.verifyCharacterLimitForManufacturersCode(maxNums);
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the Character Limit for 'Edit BrandDesc'.")
	@TestCaseId("TC_MB_047")
	@Test(priority=29,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_047(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.verifyCharacterLimitForEditBrandDesc();
	}

	@Features(value = {"Manufacturers & Brands Module"})
	@Description("This test case is to Verify the Character Limit for 'Edit Brand URL'.")
	@TestCaseId("TC_MB_048")
	@Test(priority=30,groups={"regression"},dataProvider="ManufacturerBrandModuleTest",dataProviderClass=SearchData.class)
	public void TC_MB_048(String testCaseID,String userName,String password, String brandName) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.verifyManufacturersAndBrandsPageItems()
		.searchForBrand(brandName)
		.clickOnEditBrand(brandName)
		.editBrandsPage()
		.verifyEditBrandsPageItems()
		.verifyCharacterLimitForEditBrandURL();
	}

	/*@Features("Create Manufacturers")
	@Description("This a test case which creates Manufacturers")
	@Test(groups="regression",priority=1)
	public void create_Manufacturer() throws Exception {

	 * @author:yogish.mt

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.getmanufacturername1())
		.clickonMBsearch()
		.manufacturerSearchResult(data.getmanufacturername1())
		.homePage().clickOnManufacturerAndBrands().manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.clickonmanufacturerbutton()
		.typeinmanufield(data.getmanufacturername1())
		.typeinmanucodefield(data.getmanufacturername1())
		.checkmanufactureractive()
		.clickonmanufacturersave()
		.verifymessage(data.getmanufacturername1()+" "+data.getmanufacturerSuccessmessage());
	}

	@Features("Create Brand Under Manufacturer")
	@Description("This a test case which creates Brand under a Manufacturer")
	@Test(groups="regression",priority=2)
	public void createBrand() throws Exception {


	 * @author:yogish.mt


		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.getmanufacturername1())
		.clickonMBsearch()
		.checkManufacturerAlreadyExist(data.getmanufacturername1())
		.clickOnlisticon()
		.isBrandpresent(data.getBrnadName())
		.clickOnaddnewbrandbutton()
		.checkBrandFormEnabled()
		.selectmanufacturerfromdropdown(data.getmanufacturername1())
		.typeinbrandname(data.getBrnadName())
		.typeinBrandDescField(data.getbrandDesc())
		.checkOnBrandActive().checkOnItemActive()
		.clickonbrandsave()
		.checkBrandSaveMessage(data.getbrandsavemsg());			
	}

	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies validity of manufacturer name field, creation of new manufacturer and search of new manufacturer and deletion of the same")
	@TestCaseId("TC_MB_2,TC_MB_3,TC_MB_7,TC_MB_8")
	@Test(groups = {"regression"})
	public void createManufacturer() throws Exception {



	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnAddNewManufacturerButton()
		.clickOnSaveButton()
		.verifyUnsuccessfullMessage(data.getunsuccessfullMessageOfManufacturerSave())
		.enterNewManufacturerNames(data.getmanufacturerNewName())
		.clickOnSaveButton()
		.verifySuccessMessageNewManuCreation(data.getmanufacturerNewName())
		.enterCreatedManufacturerToDelete(data.getcreatedManufacturerToDelete())
		.clickOnSearchManufacturerList()
		.clickOnDeleteManufacturerButton()
		.verifyAlertText(data.getAlertTextToDeleteManufacturer())
		.verifyManufacturerDeletion();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies no results for non-existing manufacturer search")
	@TestCaseId("TC_MB_9")
	@Test(groups = {"regression"})
	public void searchManufacturerNoResultsFound() throws Exception {



	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.enterCreatedManufacturerToDelete(Integer.toString(RandomNumberGenerator.generateEightRandomNumbers()))
		.clickOnSearchManufacturerList()
		.verifyZeroManufacturersFound();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies the pagination for manufacturer and brands page")
	@TestCaseId("TC_MB_10, TC_MB_11,TC_MB_12,TC_MB_13")
	@Test(groups = {"regression"})
	public void clickOnNavigation() throws Exception{


	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnNextButton();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies all the fields are present after clicking on add manufacturer")
	@TestCaseId("TC_MB_1")
	@Test(groups = {"regression"})
	public void verifyAllFieldsPresent() throws Exception{


	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnAddNewManufacturerButton()
		.clickOnSaveButton()
		.clickOnResetButton()
		.clickOnNewManufacturerName()
		.clickOnManufacturerCode();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies all the fields are present in the table of the manufacturers page ")
	@TestCaseId("TC_MB_5")
	@Test(groups = {"regression"})
	public void verifyAllFieldsPresentInTable() throws Exception{


	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnAction()
		.clickOnSiNumber()
		.clickOnManufacturerName()
		.clickOnNumberOfBrands()
		.enterCreatedManufacturerToDelete(data.getcreatedManufacturerToDelete());
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_14")
	@Test(groups = {"regression"})
	public void verifyGenericColumnSettings() throws Exception{


	 * @author:Ashray Ramesh
	 * 

		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnGenericColumnnSettings()
		.verifyShowFieldsText()
		.verifySortOrderText();
	}



	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_15")
	@Test(groups = {"regression"})
	public void verifyShowFieldsFields() throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnGenericColumnnSettings()
		.clickOnShowFieldsText()
		.verifyDynamicSettingsField()
		.verifyFieldNamesField()
		.verifyDesktopViewField()
		.verifyMobileViewField()
		.verifyTabletViewField()
		.verifyDisplayNamesField();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_4")
	@Test(groups = {"regression"})
	public void verifyResetButton() throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnAddNewManufacturerButton()
		.enterNewManufacturerNames(data.getmanufacturerNewName())
		.clickOnResetButton()
		.verifyEmptyFieldAfterReset();
	}

	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case to display fields in manufacturer list page")
	@TestCaseId("TC_MB_16, TC_MB_17, TC_MB_18")
	@Test(groups = {"regression"})
	public void viewSelectedFieldInManufacturerList() throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnGenericColumnnSettings()
		.clickOnShowFieldsText()
		.clickOnManufacturerLogoCheckBox()
		.clickOnSaveFields()
		.verifyManufacturerLogoPresent()
		.clickOnGenericColumnnSettings()
		.clickOnShowFieldsText()
		.clickOnManufacturerLogoCheckBox()
		.clickOnSaveFields()
		.clickOnGenericColumnnSettings()
		.clickOnShowFieldsText()
		.clickOnCancelButton();
	}

	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case to display fields in manufacturer list page")
	@TestCaseId("TC_MB_19, TC_MB_20, TC_MB_21,TC_MB_22")
	@Test(groups = {"regression"})
	public void viewSortOrderSettings() throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturersAndBrandsPage()
		.clickOnGenericColumnnSettings()
		.clickOnSortOrder()
		.clickOnAddNewSortOrder()
		.enterSortFieldName(data.getSortFieldName())
		.enterDescendingOrder(data.getDescendingOrderText())
		.clickOnSaveSortOrder()
		.clickOnGenericColumnnSettings()
		.clickOnSortOrder()
		.clickOnDeleteSortOrder()
		.clickOnCloseSortOrder();

	}
	 */

}


