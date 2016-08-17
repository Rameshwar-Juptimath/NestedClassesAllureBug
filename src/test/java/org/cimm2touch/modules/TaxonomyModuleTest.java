package org.cimm2touch.modules;
import org.cimm2touch.maincontroller.MainController;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/*
 * @author:Shivaraj.jack
 * 
 */
 
public class TaxonomyModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies taxonomy table headers.")
	@TestCaseId("TC_T-Mgmt_001")
	@Test(groups={"regression"})
	public void verifyDisplayOfTaxonomyListandAddNewTaxonomytab() throws Exception{
	
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
	@Description("This is a test case which verifies searchFunctionalityinTaxonomypageForValidAndInvalidKey.")
	@TestCaseId("TC_T-Mgmt_002,TC_T-Mgmt_003")
	@Test(groups={"regression"})
	public void verificationOfSearchFunctionalityinTaxonomypageForValidAndInvalidKey () throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.enterSearchTaxonomy(data.getTaxonomyToSearch())
		.clickOnSearchTaxonomy()
		.verifyNameIsPresent(data.getTaxonomyToSearch())
		.enterSearchTaxonomy(data.getTaxonomyToSearch())
		.enterInvalidTaxonomy(data.getInavalidTaxonomyName())
		.clickOnSearchTaxonomy()
		.verifyForinavalidInput(data.getInavalidTaxonomyName());
	}

	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies verificationOfTaxonomyFieldsAfterclickingOnAddnewTaxonomyIconInTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_004")
	@Test(groups={"regression"})
public void	verificationOfTaxonomyFieldsAfterclickingOnAddnewTaxonomyIconInTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage() 
		.clickOnAddnewTaxonomy()
 	 	.verifyTaxonomyfieldsAfterclickingOnAddNewTaxonomyIcon(data.getTaxonomyHeaders().split(","));
		
	}
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies ErrorMessageWhenTaxonomyNameAndTaxonomyDescFieldsLeftBlankInTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_006,TC_T-Mgmt_007")
	@Test(groups={"regression"})
	public void	verificationOfErrorMessageWhenTaxonomyNameFieldLeftBlankInTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enterTaxonomyDesciption(data.getTaxonomyDescription())
		.clickOnSaveInTaxonomypage()
		.verifyErrormessage(data.getErrormessge())
		.clearTaxonomyDesciptionField()
 		.enterTaxonomyName(data.getTaxonomyname())
		.clickOnSaveInTaxonomypage()
		.verifyTaxonomyErrormessage(data.getTaxonomynameerror());
 	
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies User Is Able To EnterOnly Thirtycharacters InTaxonomyNameField In Taxonomypage.")
	@TestCaseId("TC_T-Mgmt_8")
	@Test(groups={"regression"})
	public void	verifyUserIsAbleToEnterOnlyThirtycharactersInTaxonomyNameFieldInTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enteringMorethathirtycharactersinTaxonomyNameField(data.getenteringMorethathirtycharacters())
		.verifyEnterdCharactersInTaxonomynamefield();
		 
 		}
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies User Is  Able ToEnter 500character In TaxonomyNameField In Taxonomypage.")
	@TestCaseId("TC_T-Mgmt_9")
	@Test(groups={"regression"})
	public void	verifyUserIsaAbleToEnter500characterInTaxonomyNameFieldInTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnAddnewTaxonomy()
		.enteringMoretha500charactersinTaxonomyDescField(data.getenteringMoretha500characters())
		.verifyEnterdCharactersInTaxonomyDescfield();
		 
 		}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Form filled With Existing Details Of Editing Taxonomypage.")
	@TestCaseId("TC_T-Mgmt_11")
	@Test(groups={"regression"})
	public void	verifyFormfilledWithExistingDetailsOfEditingTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnEditIconInTaxonomypage()
		.verifyFormfilledWithExistingDetailsOfEditingeaxonomy();
		 
 		}
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies  Of Navigation To ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_14")
	@Test(groups={"regression"})
	public void	verifyOfNavigationToManageTaxonomypage() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.verifyTabsPresentInManageTaxonomyPage();
	}
	
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Searched Categories Are Displaying In Green In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_15 TC_T-Mgmt_16 ")
	@Test(groups={"regression"})
	public void	verifySearchedCategoriesAreDisplayingInGreenInTaxonomypage() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
		.enterTheCategoryName(data.getsearchCategory1())
		.clickOnSearchIcon()
		.verifyWhetherSearchedTaxonomyStyleIsGreen()
		.clickOnRefreshIcon()
		.verifyWhetherSearchedTaxonomyStyleIsInNotGreen();
		
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Trees Are Collapsing Expanding In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_17 TC_T-Mgmt_18")
	@Test(groups={"regression"})
	public void	verifyTreesAreCollapsingExpandingInManageTaxonomypage() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
		.verifyUserIsAblToViewTheHierarchyLevelsOfTheCategories();
		
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Category Details formis Is displayed In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_19 TC_T-Mgmt_20 TC_T-Mgmt_21")
	@Test(groups={"regression"})
	public void	verifyCategoryDetailsformisIsdisplayedInManageTaxonomypage() throws Exception{
		String [] CategoryFields = data.getCategoryFields().split(",");
		
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
 		.doubleClickOnCategory(1) 
 		.clickOnPlusIcon()
 		.clickOnLeftArrow()
 		.verifyCategoryFields(CategoryFields)
 		.enterTheNewCategoryName(data.getCategoryName())
 		.enterTheCategorySequence(data.getcategorySequence())
 		.enterTheCategoryDescription(data.getcategoryDescription())
 		.clickOnSaveButtonForCategorySave()
 		.verifySuccessMessageAfterSavinCategory();
 		
		
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Category Details formis Is displayed Validating Fields In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_22 TC_T-Mgmt_23")
	@Test(groups={"regression"})
	public void	verifyCategoryDetailsformisIsdisplayedAndValidatingFieldsInManageTaxonomypage() throws Exception{
		 
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
 		.doubleClickOnCategory(1) 
 		.clickOnPlusIcon()
 		.clickOnLeftArrow()
 		.validatingCategoryCodeFieldByEnteringAlphanumericcharacters(data.getAlphanumericcharacters())
 		.clickOnSaveButtonForCategorySave()
 		.verifyErrorMessage() 
// 		.enteringgMoreThan100characters(data.getMoreThan100Characters())
 		.enteringCategoryCode(data.getCategoryCode())
 		.enterTheNewCategoryName(data.getCategoryName())
 		.clickOnSaveButtonForCategorySave()
 		.verifyErrorMessageAfterEnteringMoreThan100Characters();
 		 
	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies Category Details formis Is displayed Validating Fields In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_24")
	@Test(groups={"regression"})
	public void	verifyCategoryDetailsformisIsdisplayedAndValidatingCategoryNamefieldByLeavingemptyInManageTaxonomypage() throws Exception{
		 
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
 		.doubleClickOnCategory(1) 
 		.clickOnPlusIcon()
 		.clickOnLeftArrow()
 		.clickOnSaveButtonForCategorySave()
 		.validatingCategoryNameFieldByLeavingEmpty(data.getErrorMessageAfterClickingSaveButton());

	}
	
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies By Entering Numeric Characters In Display Sequence And Leave The Display SequenceField Empty In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_25 TC_T-Mgmt_26")
	@Test(groups={"regression"})
	public void	verifyByEnteringNumeriCharactersInDisplaySequenceAndLeaveTheDisplaySequenceFieldEmptyInManageTaxonomypage() throws Exception{
		 
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
 		.doubleClickOnCategory(1) 
 		.clickOnPlusIcon()
 		.clickOnLeftArrow()
 		.enterNumericCharactersInDisplaySequenceField(data.getNumaricCharacters())
 		.clickOnSaveButtonForCategorySave()
 		.enterTheNewCategoryName(data.getCategoryName())
 		.clearTheDisplaySequenceField()
 		.clickOnSaveButtonForCategorySave()
  		.verifytheMessageByleavingDisplaySequenceFieldEmpty();
		
	}
	@Features(value = {"Taxonomy Module"})
	@Description("This is a test case which verifies By Entering Numeric Characters In Level Number Field and 500 Characters In CategoryDescriptionField In ManageTaxonomypage.")
	@TestCaseId("TC_T-Mgmt_27 TC_T-Mgmt_28")
	@Test(groups={"regression"})
	public void	verifyByEnteringNumeriCharactersInLevelNumberFieldAnd500charactersInCategoryDescriptionFieldInManageTaxonomypage() throws Exception{
		 
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.clickOnGoToManageTaxonomyIcon()
		.manageTaxonomyPage()
		.clickOnLeftArrow()
 		.doubleClickOnCategory(1) 
 		.clickOnPlusIcon()
 		.clickOnLeftArrow()
 		.enterTheNewCategoryName(data.getCategoryName())
 		.enterNumericCharactersInDisplaySequenceField(data.getNumaricCharacters())
 		.enterMorethanFIveHundredCharactersInCategoryDescriptionField(data.getenteringMoretha500characters())
 		.clickOnSaveButtonForCategorySave();
 		 
		
}
}
