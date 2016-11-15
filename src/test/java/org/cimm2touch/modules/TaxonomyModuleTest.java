package org.cimm2touch.modules;
import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TaxonomyDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/*
 * @author: Gladson Antony
 * 
 */

public class TaxonomyModuleTest extends PageFactoryInitializer 
{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TaxonomyDataPropertyFile taxData = new TaxonomyDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	

	@Features(value = {"Taxonomy Module"})
	@Description("This is a Test Case to Verify the Taxonomy Page Items.")
	@TestCaseId("TC_TaxMgt_001")
	@Test(groups={"regression"})
	public void TC_TaxMgt_001() throws Exception
	{	
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.verifyTaxonomyTableHeadingsInTaxonomyManagementPage(data.getTaxonomyTableHeaders().split(","));
	}


	@Features(value = {"Taxonomy Module"})
	@Description("This is a Test Case to Verify the Search Feature in the Taxonomy Page for Both Valid & Invalid Data.")
	@TestCaseId("TC_TaxMgt_002, TC_TaxMgt_003")
	@Test(groups={"regression"})
	public void TC_TaxMgt_002() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxData.getTaxonomyName())
		.verifyTaxonomyPresent(taxData.getTaxonomyName())
		.searchForTaxonomy(taxData.getInvalidTaxonomyName())
		.verifyTaxonomyisNotPresent(taxData.getInvalidTaxonomyName());
	}


	@Features(value = {"Taxonomy Module"})
	@Description("This is a Test Case to Verify to Verify the Fields Present in the Taxonomy Page after clicking on 'Add New Category' Button.")
	@TestCaseId("TC_TaxMgt_004")
	@Test(groups={"regression"})
	public void TC_TaxMgt_004() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage() 
		.clickOnAddnewTaxonomy()
		.verifyTaxonomyfieldsAfterclickingOnAddNewTaxonomyIcon(taxData.getTaxonomyTableHeaders().split(","));
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to verify the Error Message when Taxonomy Name is Left Blank on Creating a New Taxonomy.")
	@TestCaseId("TC_TaxMgt_004")
	@Test(groups={"regression"})
	public void	TC_TaxMgt_006() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enterTaxonomyDesciption(taxData.getTaxonomyDescription())
		.saveTaxanomy()
		.verifyTaxonomyNameErrorMessageInTaxonomyPage(taxData.getErrorOnTaxonomyCreationWithoutName());
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to verify the Error Message when Taxonomy Name is Left Blank on Creating a New Taxonomy.")
	@TestCaseId("TC_TaxMgt_007")
	@Test(groups={"regression"})
	public void	TC_TaxMgt_007() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enterTaxonomyName(taxData.getTaxonomyName())
		.saveTaxanomy()
		.verifyTaxonomyDescErrorMessageInTaxonomyPage(taxData.getErrorOnTaxonomyCreationWithoutDesc());
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is verify the Character Limit for Taxonomy Name Field (30 Characters).")
	@TestCaseId("TC_TaxMgt_008")
	@Test(groups={"regression"})
	public void TC_TaxMgt_008() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enterTaxonomyName(taxData.getEnterMoreThan30CharactersForTaxonomyName())
		.verifyEnterdCharactersInTaxonomynamefield(taxData.getEnterMoreThan30CharactersForTaxonomyName());

	}
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is verify the Character Limit for Taxonomy Desc Field (500 Characters).")
	@TestCaseId("TC_TaxMgt_009")
	@Test(groups={"regression"})
	public void TC_TaxMgt_009() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enteringMoretha500charactersinTaxonomyDescField()
		.verifyEnterdCharactersInTaxonomyDescfield();
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Contents Present in the 'Edit Taxonomy' form.")
	@TestCaseId("TC_TaxMgt_011")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void	TC_TaxMgt_011(String testCaseId,String taxonomyName,String taxonomyDesc,String supplier,String topBanner, String rightBanner, 
			String leftBanner, String bottomBanner, String saveAs) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxData.getTaxonomyName())
		.verifyTaxonomyPresent(taxData.getTaxonomyName())
		.clickOnEditIconInTaxonomypage()
		.verifyFormfilledWithExistingDetailsOfEditingeaxonomy(taxonomyName,taxonomyDesc,supplier,topBanner,rightBanner,leftBanner,bottomBanner);
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Save Taxonomy in 'Edit Taxonomy' form upon Clearing Taxonomy Name.")
	@TestCaseId("TC_TaxMgt_012")
	@Test(groups={"regression"})
	public void TC_TaxMgt_012() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxData.getTaxonomyName())
		.verifyTaxonomyPresent(taxData.getTaxonomyName())
		.clickOnEditIconInTaxonomypage()
		.clearTaxonomyNameField()
		.saveTaxanomy()
		.verifyTaxonomyNameErrorMessageInTaxonomyPage(taxData.getErrorOnTaxonomyCreationWithoutName());
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Save Taxonomy in 'Edit Taxonomy' form upon Clearing Taxonomy Desc.")
	@TestCaseId("TC_TaxMgt_013")
	@Test(groups={"regression"})
	public void TC_TaxMgt_013() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxData.getTaxonomyName())
		.verifyTaxonomyPresent(taxData.getTaxonomyName())
		.clickOnEditIconInTaxonomypage()
		.clearTaxonomyDescField()
		.saveTaxanomy()
		.verifyTaxonomyDescErrorMessageInTaxonomyPage(taxData.getErrorOnTaxonomyCreationWithoutDesc());
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies  Of Navigation To Manage Taxonomypage.")
	@TestCaseId("TC_TaxMgt_014")
	@Test(groups={"regression"})
	public void TC_TaxMgt_014() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxData.getTaxonomyName())
		.verifyTaxonomyPresent(taxData.getTaxonomyName())
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyTabsPresentInManageTaxonomyPage();
	}


	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Searched Categories Are Displaying In Green In Manage Taxonomypage.")
	@TestCaseId("TC_TaxMgt_015, TC_TaxMgt_016")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_015(String TestCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.enterTheCategoryName(categoryName)
		.clickOnSearchIcon()
		.verifyWhetherSearchedTaxonomyStyleIsGreen(categoryName)
		.clickOnRefreshIcon()
		.verifyWhetherSearchedTaxonomyStyleIsInNotGreen(categoryName);
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This test case verifies the Collapsing/Expanding Feature in Manage Taxonomy Page.")
	@TestCaseId("TC_TaxMgt_017, TC_TaxMgt_018")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_017(String TestCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyUserIsAblToViewTheHierarchyLevelsOfTheCategories(categoryName);
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to verify Category Form Details and to Verify the Inputs to the Fields.")
	@TestCaseId("TC_T-Mgmt_19, TC_T-Mgmt_20,TC_T-Mgmt_21,TC_T-Mgmt_22,TC_T-Mgmt_24,TC_T-Mgmt_25,TC_T-Mgmt_26 ")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_019(String testCaseID, String taxonomyName, String categoryName, 
			String categoryCode, String displaySequence, String errorMessage, String noOfCategoriestoBeCreate) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.clickOnAddNewCategory(categoryName)
		.verifyCategoryFields()
		.addNewCategory(categoryCode, categoryName, displaySequence)
		.saveNewCategory()
		.verifyDifferentMessageDisplayedAfterSavinCategory(errorMessage);
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category DescriptionField in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_27")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_027(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.clickOnAddNewCategory(categoryName)
		.verifyCategoryFields()
		.verifyCharacterLimitInCategoryDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Marketing Description Field in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_28")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_028(String testCaseID, String taxonomyName,String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.clickOnAddNewCategory(categoryName)
		.verifyCategoryFields()
		.verifyCharacterLimitInMarketingDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Marketing Description Field in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_29,TC_T-Mgmt_30,TC_T-Mgmt_31,TC_T-Mgmt_32,TC_T-Mgmt_34,TC_T-Mgmt_35,TC_T-Mgmt_36,TC_T-Mgmt_37,TC_T-Mgmt_38")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_029(String testCaseID, String taxonomyName, String categoryName, 
			String childCategoryCode, String childCategoryName, String displaySequence, String errorMessage) throws Exception, Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnAddNewChildCategory()
		.verifyChildCategoryFields()
		.addNewChildCategory(childCategoryCode, childCategoryName, displaySequence)
		.saveNewCategory()
		.verifyDifferentMessageDisplayedAfterSavinCategory(errorMessage);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category Description Field Of the Child Category in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_39")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_39(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnAddNewChildCategory()
		.verifyChildCategoryFields()
		.verifyCharacterLimitInCategoryDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category Description Field Of the Child Category in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_39")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_39_1(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnAddNewChildCategory()
		.verifyChildCategoryFields()
		.verifyCharacterLimitInMarketingDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Save a Child Category and Verify the Success Message in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_40")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_40(String testCaseID, String taxonomyName, String categoryName, String childCategoryCode, 
			String childCategoryName, String displaySequence, String expectedSuccesfulMessageForNewCategoryCreation) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnAddNewChildCategory()
		.verifyChildCategoryFields()
		.addNewChildCategory(childCategoryCode, childCategoryName, displaySequence)
		.saveNewCategory()
		.verifySuccessMessageAfterSavingCategory(expectedSuccesfulMessageForNewCategoryCreation);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Delete a Child Category and Verify the Success Message in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_40")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_40_1(String testCaseID, String taxonomyName, String categoryName,	String childCategoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName);
		Thread.sleep(5000);
		manageTaxonomyPage()
		.clickOnExpandViewForRespectiveCategory(categoryName);
		Thread.sleep(5000);
		manageTaxonomyPage()
		.clickOnRespectiveCategory(childCategoryName);
		Thread.sleep(5000);
		manageTaxonomyPage()
		.clickOnDeleteCategoryButton()
		.verifySuccessMessageAfterDeletingCategory();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category Description Field Of the Child Category in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_41, TC_TaxMgt_42, TC_TaxMgt_45, TC_TaxMgt_46, TC_TaxMgt_47, TC_TaxMgt_48, TC_TaxMgt_49, TC_TaxMgt_50")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_41(String testCaseID, String taxonomyName, String categoryName, String editCategoryName, 
			String displaySequence, String errorMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.verifyCategoryFields()
		.editCategoryFields(editCategoryName, displaySequence)
		.saveEditedCategory()
		.verifyDifferentMessageDisplayedAfterSavinCategory(errorMessage);		
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category Description Field On Editing in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_51")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_51(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.verifyCharacterLimitInCategoryDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Marketing Description Field On Editing in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_51")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_51_1(String testCaseID, String taxonomyName, String categoryName,String numberOfCharactersAcceptedInTheTextbox) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.verifyCharacterLimitInMarketingDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Save a Category and Verify the SuccessMessage in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_52")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_52(String testCaseID, String taxonomyName, String categoryCode, String categoryNameForAddNewCategoryClick, String categoryName, String displaySequence, String expectedSuccesfulMessageForNewCategoryCreation, String noOfCategoriestoBeCreate) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAddNewCategory(categoryNameForAddNewCategoryClick)
		.addNewCategory(categoryCode, categoryName, displaySequence)
		.saveNewCategory()
		.verifySuccessMessageAfterSavingCategory(expectedSuccesfulMessageForNewCategoryCreation); 
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Delete a Category and Verify the Success Message in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_52")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_52_1(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnDeleteCategoryButton()
		.verifySuccessMessageAfterDeletingCategory();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'View HIstory' Functionality")
	@TestCaseId("TC_T-Mgmt_54")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_54(String testCaseID, String taxonomyName, String categoryName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnRespectiveCategory(categoryName)
		.clickOnViewHistoryButton()
		.switchToNewlyOpenedWindowAndVerifyCategoryName(categoryName);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'Previous' Button Functionality in Taxonomy Page")
	@TestCaseId("TC_T-Mgmt_55")
	@Test(groups={"regression"})
	public void TC_TaxMgt_55() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnPreviousButtonInPagination();
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'Next' Button Functionality in Taxonomy Page")
	@TestCaseId("TC_T-Mgmt_56")
	@Test(groups={"regression"})
	public void TC_TaxMgt_56() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnNextButtonInPagination();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'First' Button Functionality in Taxonomy Page")
	@TestCaseId("TC_T-Mgmt_57")
	@Test(groups={"regression"})
	public void TC_TaxMgt_57() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnFirstButtonInPagination();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'Last' Button Functionality in Taxonomy Page")
	@TestCaseId("TC_T-Mgmt_58")
	@Test(groups={"regression"})
	public void TC_TaxMgt_58() throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnLastButtonInPagination();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the working of 'Attributes' Page and its Contents")
	@TestCaseId("TC_T-Mgmt_60, TC_T-Mgmt_61")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_60(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.clickOnAddNewAttribute()
		.verifyTheFieldsOfAddNewAttributeForm();
		}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 'Add New Attributes' Form Features")
	@TestCaseId("TC_T-Mgmt_62, TC_T-Mgmt_63")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_62(String testCaseID, String taxonomyName, String attributeName, String attributeDesc, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.clickOnAddNewAttribute()
		.verifyTheFieldsOfAddNewAttributeForm()
		.addNewAttribute(attributeName, attributeDesc)
		.saveAttributes()
		.verifyMessageAfterSavingAttributes(saveMessage);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limits of 'Attribute Name' Field")
	@TestCaseId("TC_T-Mgmt_64")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_64(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.clickOnAddNewAttribute()
		.verifyTheFieldsOfAddNewAttributeForm()
		.verifyCharactersLimitOfAttributeNameField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limits of 'Attribute Desc' Field")
	@TestCaseId("TC_T-Mgmt_65")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_65(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.clickOnAddNewAttribute()
		.verifyTheFieldsOfAddNewAttributeForm()
		.verifyCharactersLimitOfAttributeDescField();	
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the 'Next Option' in Pagination in Attributes Page.")
	@TestCaseId("TC_T-Mgmt_66")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_66(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.verifytheWorkingOfTheNextPageOption();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the 'Previous Option' in Pagination in Attributes Page.")
	@TestCaseId("TC_T-Mgmt_67")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_67(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.verifytheWorkingOfThePreviousPageOption();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the 'Last Option' in Pagination in Attributes Page.")
	@TestCaseId("TC_T-Mgmt_68")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_68(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.verifytheWorkingOfTheLastPageOption();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the 'First Option' in Pagination in Attributes Page.")
	@TestCaseId("TC_T-Mgmt_69")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_69(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.verifytheWorkingOfTheFirstPageOption();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the 'No. Of Items Dropdown' in Attributes Page.")
	@TestCaseId("TC_T-Mgmt_70")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_70(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.verifyDisplayNoOfItemsDropdown();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Working of the Search Feature and Edit Feature Attributes Page.")
	@TestCaseId("TC_T-Mgmt_71,TC_T-Mgmt_72,TC_T-Mgmt_73")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_71(String testCaseID, String taxonomyName, String attributeName, 
			String editAttributeName, String attributeDesc, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.searchForAnAttribute(attributeName)
		.verifyAfterAttributeSearch(attributeName)
		.clickOnEditAttributeButton(attributeName)
		.verifyEditAttributeFormItems()
		.editAnAttribute(editAttributeName, attributeDesc)
		.saveEditedAttribute()
		.verifyMessageAfterEditingAnAttribute(saveMessage);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Characters Limit in Edit Attributes Name Field.")
	@TestCaseId("TC_T-Mgmt_74")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_74(String testCaseID, String taxonomyName, String attributeName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.searchForAnAttribute(attributeName)
		.verifyAfterAttributeSearch(attributeName)
		.clickOnEditAttributeButton(attributeName)
		.verifyEditAttributeFormItems()
		.verifyCharactersLimitOfEditAttributeNameField();
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Characters Limit in Edit Attributes Name Field.")
	@TestCaseId("TC_T-Mgmt_75")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_75(String testCaseID, String taxonomyName, String attributeName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.searchForAnAttribute(attributeName)
		.verifyAfterAttributeSearch(attributeName)
		.clickOnEditAttributeButton(attributeName)
		.verifyEditAttributeFormItems()
		.verifyCharactersLimitOfEditAttributeDescField();
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Characters Limit in Edit Attributes Name Field.")
	@TestCaseId("TC_T-Mgmt_76")
	@Test(enabled=false,groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_76(String testCaseID, String taxonomyName, String attributeName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.searchForAnAttribute(attributeName)
		.verifyAfterAttributeSearch(attributeName)
		.clickOnEditAttributeButton(attributeName)
		.verifyEditAttributeFormItems()
		.clickOnViewAttributeHistoryButton()
		.switchToNewlyOpenedWindowAndVerifyAttributeName(attributeName);
	}	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Delete an Attribute")
	@TestCaseId("TC_T-Mgmt_77")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_77(String testCaseID, String taxonomyName, String attributeName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesTabFromManageTaxonomyPage()
		.verifyAttributesPageItems()
		.searchForAnAttribute(attributeName)
		.verifyAfterAttributeSearch(attributeName)
		.clickOnDeleteAttributeButton(attributeName);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This  Test Case is to Click on 'Attribute Groups' tab and Verify the page contents")
	@TestCaseId("TC_T-Mgmt_78, TC_T-Mgmt_81")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_78(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.clickOnAddNewAttributeGroupButton()
		.verifyAddNewAttributeGroupFormItems();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Save a Attribute Group and Verify the Success Message.")
	@TestCaseId("TC_T-Mgmt_81, TC_T-Mgmt_82, TC_T-Mgmt_83")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_81(String testCaseID, String taxonomyName, String attributeGroupName, String attributeGroupDesc, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.clickOnAddNewAttributeGroupButton()
		.addNewAttributeGroup(attributeGroupName, attributeGroupDesc)
		.clickOnAttributeGroupsSaveButton()
		.verifyMessageAfterSavingAttributeGroup(saveMessage);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limit for Attribute Groups Name Field.")
	@TestCaseId("TC_T-Mgmt_84")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_84(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.clickOnAddNewAttributeGroupButton()
		.verifyCharacterLimitForAttributesGroupNameField();
	}	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limit for Attribute Groups Name Field.")
	@TestCaseId("TC_T-Mgmt_85")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_85(String testCaseID, String taxonomyName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.clickOnAddNewAttributeGroupButton()
		.verifyCharacterLimitForAttributesGroupDescField();
	}	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify Search Feature in Attribute Groups Page and Edit Feature of Attribute Groups.")
	@TestCaseId("TC_TaxMgt_79, TC_TaxMgt_91, TC_TaxMgt_92, TC_TaxMgt_93")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_79(String testCaseID, String taxonomyName, String attributeGroupName, String editedAttributedGroupName, 
			String editedAttributeGroupDesc, String saveMessage) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.searchForAttributeGroup(attributeGroupName)
		.verifyAfterSearchingForAttributeGorup(attributeGroupName)
		.clickOnEditSpecificAttributeGroup(attributeGroupName)
		.editAttributeGroup(editedAttributedGroupName, editedAttributeGroupDesc)
		.saveEditedAttributeGroup()
		.verifyMessageAfterEditingAnAttributeGroup(saveMessage);
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limit for Edit Attribute Groups Name Field.")
	@TestCaseId("TC_TaxMgt_94")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_94(String testCaseID, String taxonomyName, String attributeGroupName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.searchForAttributeGroup(attributeGroupName)
		.verifyAfterSearchingForAttributeGorup(attributeGroupName)
		.clickOnEditSpecificAttributeGroup(attributeGroupName)
		.verifyCharacterLimitForAttributesGroupNameField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the Character Limit for Edit Attribute Groups Desc Field.")
	@TestCaseId("TC_T-Mgmt_95")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_95(String testCaseID, String taxonomyName, String attributeGroupName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.searchForAttributeGroup(attributeGroupName)
		.verifyAfterSearchingForAttributeGorup(attributeGroupName)
		.clickOnEditSpecificAttributeGroup(attributeGroupName)
		.verifyCharacterLimitForAttributesGroupDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to View History of a Attribute Group.")
	@TestCaseId("TC_T-Mgmt_96")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_96(String testCaseID, String taxonomyName, String attributeGroupName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.searchForAttributeGroup(attributeGroupName)
		.verifyAfterSearchingForAttributeGorup(attributeGroupName)
		.clickOnEditSpecificAttributeGroup(attributeGroupName)
		.clickOnViewHistoryButtonForAttributesGroup()
		.switchToNewlyOpenedWindowAndVerifyAttributeGroupName(attributeGroupName);
	}
		
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Delete already created Attribute Group.")
	@TestCaseId("TC_T-Mgmt_97")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_97(String testCaseID, String taxonomyName, String attributeGroupName) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomyName)
		.clickOnAttributesGroupsTabFromManageTaxonomyPage()
		.verifyAttrbuteGroupsPageItems()
		.searchForAttributeGroup(attributeGroupName)
		.verifyAfterSearchingForAttributeGorup(attributeGroupName)
		.clickOnDeleteAttributeGroupButton(attributeGroupName)
		.verifyMessageAfterDeletingAttributeGroup();
	}
}
