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
 * @author:Shivaraj.jack
 * 
 */

public class TaxonomyModuleTest extends PageFactoryInitializer 
{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TaxonomyDataPropertyFile taxData = new TaxonomyDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@Features(value = {"Taxonomy Module"})
	@Description("This Method is used to Create a Taxonomy {0}")
	@Test(enabled=false, groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void createTaxonomy(String testCaseId,String taxonomyName,String taxonomyDesc,String supplier,String topBanner, String rightBanner, 
			String leftBanner, String bottomBanner, String saveAs) throws Exception
	{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enterTaxonomyName(taxonomyName)
		.enterTaxonomyDesciption(taxonomyDesc)
		.selectSupplier(supplier)
		.selectTopBanner(topBanner)
		.selectRightBanner(rightBanner)
		.selectLeftBanner(leftBanner)
		.selectBottomBanner(bottomBanner)
		.saveAs(saveAs)
		.saveTaxanomy()
		.searchForTaxonomy(taxonomyName)
		.verifyTaxonomyPresent(taxonomyName);
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Method is used to Create Categoryies {0}")
	@Test(enabled=false, groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void createCategories(String testCaseNo, String categoryCode, String categoryName,String displaySequence) throws Exception
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
		.verifyLeftPanelTaxonomyName(taxData.getTaxonomyName())
		.clickOnAddNewCategory()
		.addNewCategory(categoryCode, categoryName, displaySequence)
		.saveNewCategory()
		.verifySuccessMessageAfterSavingCategory();
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Method is used to Create L1 Child Category to the Above Created Categories")
	@Test(enabled=false, groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void createChildCategories(String testCaseNo, String categoryName,  
			String childCategoryName, String childCategoryCode, String displaySequence) throws Exception
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
		.verifyLeftPanelTaxonomyName(taxData.getTaxonomyName())
		.clickOnRespectiveCategory(categoryName)
		.clickOnAddNewChildCategory()
		.addNewChildCategory(childCategoryCode, childCategoryName, displaySequence)
		.saveNewCategory();
	}


	@Features(value = {"Taxonomy Module"})
	@Description("This is a Test Case to Verify the Taxonomy Page Items.")
	@TestCaseId("TC_T-Mgmt_001")
	@Test(groups={"regression"})
	public void verifyDisplayOfTaxonomyListandAddNewTaxonomytab() throws Exception
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
	@TestCaseId("TC_T-Mgmt_002,TC_T-Mgmt_003")
	@Test(groups={"regression"})
	public void verificationOfSearchFunctionalityinTaxonomypageForValidAndInvalidData() throws Exception
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
	@TestCaseId("TC_T-Mgmt_004")
	@Test(groups={"regression"})
	public void verificationOfTaxonomyFieldsAfterclickingOnAddnewTaxonomyIconInTaxonomypage() throws Exception
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
	@TestCaseId("TC_T-Mgmt_006")
	@Test(groups={"regression"})
	public void	verificationOfErrorMessageWhenTaxonomyNameFieldLeftBlankInTaxonomypage() throws Exception
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
	@TestCaseId("TC_T-Mgmt_007")
	@Test(groups={"regression"})
	public void	verificationOfErrorMessageWhenTaxonomyDescFieldLeftBlankInTaxonomypage() throws Exception
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
	@TestCaseId("TC_T-Mgmt_8")
	@Test(groups={"regression"})
	public void verifyCharacterLimitInTaxonomyName() throws Exception
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
	@TestCaseId("TC_T-Mgmt_9")
	@Test(groups={"regression"})
	public void verifyCharactersLimitInTaxonomyDescField() throws Exception
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
	@TestCaseId("TC_T-Mgmt_11")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void	verifyEditTaxonomyForm(String testCaseId,String taxonomyName,String taxonomyDesc,String supplier,String topBanner, String rightBanner, 
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
	@TestCaseId("TC_T-Mgmt_12")
	@Test(groups={"regression"})
	public void verifyEditTaxonomyFormSaveWithoutName() throws Exception
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
	@TestCaseId("TC_T-Mgmt_13")
	@Test(groups={"regression"})
	public void verifyEditTaxonomyFormSaveWithoutDesc() throws Exception
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
	@TestCaseId("TC_T-Mgmt_14")
	@Test(groups={"regression"})
	public void verifyOfNavigationToManageTaxonomypage() throws Exception
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
	@TestCaseId("TC_T-Mgmt_15,TC_T-Mgmt_16 ")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void verifyCategoriesInTaxonomyPage(String TestCaseID, String taxonomyName, String categoryName) throws Exception
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
	@TestCaseId("TC_T-Mgmt_17, TC_T-Mgmt_18")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void verifyTreeCollapsingFeature(String TestCaseID, String taxonomyName, String categoryName) throws Exception
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
	public void verifyCategoryDetailsForm(String testCaseID, String taxonomyName, String categoryName, 
			String categoryCode, String displaySequence, String errorMessage) throws Exception
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
		.clickOnAddNewCategory()
		.verifyCategoryFields()
		.addNewCategory(categoryCode, categoryName, displaySequence)
		.saveNewCategory()
		.verifyDifferentMessageDisplayedAfterSavinCategory(errorMessage);
	}

	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Category DescriptionField in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_27")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void verifyCharLimitInCatDescFields(String testCaseID, String taxonomyName) throws Exception
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
		.clickOnAddNewCategory()
		.verifyCategoryFields()
		.verifyCharacterLimitInCategoryDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Marketing Description Field in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_28")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void verifyCharLimitInMarDescFields(String testCaseID, String taxonomyName) throws Exception
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
		.clickOnAddNewCategory()
		.verifyCategoryFields()
		.verifyCharacterLimitInMarketingDescField();
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This Test Case is to Verify the 500 Characters Limit in Marketing Description Field in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_29,TC_T-Mgmt_30,TC_T-Mgmt_31,TC_T-Mgmt_32,TC_T-Mgmt_34,TC_T-Mgmt_35,TC_T-Mgmt_36,TC_T-Mgmt_37,TC_T-Mgmt_38")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void verifyChildCategoryFields(String testCaseID, String taxonomyName, String categoryName, 
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
			String childCategoryName, String displaySequence) throws Exception
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
		.verifySuccessMessageAfterSavingCategory();
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
	public void TC_TaxMgt_51_1(String testCaseID, String taxonomyName, String categoryName) throws Exception
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
	@Description("This Test Case is to Save a Category and Verify the Success Message in Manage Taxonomy page.")
	@TestCaseId("TC_T-Mgmt_52")
	@Test(groups={"regression"},dataProvider="TaxonomyModuleTest",dataProviderClass=SearchData.class)
	public void TC_TaxMgt_52(String testCaseID, String taxonomyName, String categoryCode, String categoryName, String displaySequence) throws Exception
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
		.clickOnAddNewCategory()
		.addNewCategory(categoryCode, categoryName, displaySequence)
		.saveNewCategory()
		.verifySuccessMessageAfterSavingCategory();
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
	
}
