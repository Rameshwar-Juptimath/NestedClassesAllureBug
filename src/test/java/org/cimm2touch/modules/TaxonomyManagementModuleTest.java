package org.cimm2touch.modules;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class TaxonomyManagementModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginObj = new LoginModuleTest();
	
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category edit/modification")
	@TestCaseId("TC_T-Mgmt_31")
	@Test(groups={"regression"})
	public void verificationOfCategoryUpdation() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(data.getTaxonomyName()).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(data.getCategoryName())
		.doubleClickOnCategoryName(data.getCategoryName())
		.categoryAndAttributesPage()
		.enterTheCategoryName(data.getCategoryName())
		.clickOnSave().verifySuccesfulMessage(data.expSuccesfulMessageForCate());
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category remove")
	@TestCaseId("TC_T-Mgmt_32")
	@Test(groups={"regression"})
	public void verificationOfCategoryRemove() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(data.getTaxonomyName()).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(data.getCategoryName())
		.doubleClickOnCategoryName(data.getCategoryName())
		.categoryAndAttributesPage()
		.enterTheCategoryName(data.getCategoryName()).clickOnSave()
		.clickOnRemove().verifyAlertAndAccept(data.getexpAlertTextForCatDel().trim());
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category image upload")
	@TestCaseId("TC_T-Mgmt_33")
	@Test(enabled = false,priority=1,groups={"regression"})
	public void verificationCategoryImageUpload() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(data.getTaxonomyName()).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(data.getCategoryName())
		.doubleClickOnCategoryName(data.getCategoryName())
		.categoryAndAttributesPage()
		.enterTheCategoryName(data.getCategoryName())
		.clickOnSave()
		.clickOnImageUpload();
		imageUploadPage()
		.clickOnImageToSelectFromRep().SelectImageFromRepo().categoryAndAttributesPage();
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category Revision History activities")
	@TestCaseId("TC_T-Mgmt_34")
	@Test(groups={"regression"})
	public void verificationRevisionHistory() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(data.getTaxonomyName()).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(data.getCategoryName())
		.doubleClickOnCategoryName(data.getCategoryName())
		.categoryAndAttributesPage()
		.enterTheCategoryName(data.getCategoryName())
		.clickOnSave()
		.clickOnHistoryLink().verifyHistoryPage(data.getExpectedHistoryPageTitleForCategory());
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the pagination functionality in T-Management")
	@TestCaseId("TC_T-Mgmt_35_36_37_38")
	@Test(groups={"regression"})
	public void verificationPagination() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.verifyPagination();
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which gives Verification of 'Display Records' in Taxonomy page")
	@TestCaseId("TC_T-Mgmt_39")
	@Test(groups={"regression"})
	public void verifyDisplayOfNumberRecordsChosenInTaxonomyPage() throws Exception{
		data.setNumberOfRecordsToDisplay("10");
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("25");
		taxonomyPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("50");
		taxonomyPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("75");
		taxonomyPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("100");
		taxonomyPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Attributes list page")
	@TestCaseId("TC_T-Mgmt_40")
	@Test(groups={"regression"})
	public void verificationOfAttributesListPage() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage().clickOnAttributesLink();
		attributesPage().verifyAttributesTableHeaders(data.expectedAttributsTableHeaders());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute")
	@TestCaseId("TC_T-Mgmt_41_42")
	@Test(groups={"regression"})
	public void verificationOfCreatingNewAttributes() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site();
		homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(data.getAttributeName())
		.enterAttributeDescription(data.getAttributeDescription())
		.clickOnSaveAttribute().verifyCreatedAttribute(data.getAttributeName()).removeAttribute(data.getAttributeName());	
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error messageif attribute name left as blank")
	@TestCaseId("TC_T-Mgmt_43")
	@Test(groups={"regression"})
	public void verificationOfErrorMessage() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.clickOnSaveAttribute().verifyErrorMessage(data.expErrorMessage());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if attribue name exceeds 50 chars")
	@TestCaseId("TC_T-Mgmt_44")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForAttributeName() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(data.getAttributeNameMoreThan50Chars())
		.enterAttributeDescription(data.getAttributeDescription())
		.clickOnSaveAttribute().verifyErrorMessageMoreAttributeName(data.getAttributeNameMoreThan50Chars()+data.getSuccessfulMessageAfterCreationAttribute().trim())
		.verifyCreatedAttribute(data.getAttributeNameMoreThan50CharsPartial()).removeAttribute(data.getAttributeNameMoreThan50CharsPartial());
		
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if description exceeds 500 chars")
	@TestCaseId("TC_T-Mgmt_45")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForDescription() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(data.getAttributeName())
		.enterAttributeDescription(data.getAttributeDescriptionMoreText())
		.clickOnSaveAttribute().verifyErrorMessageMoreDescription(data.expErrorMessageIfDesc().trim());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the pagination functionality for Attributes in T-Management")
	@TestCaseId("TC_T-Mgmt_46_47_48_49")
	@Test(groups={"regression"})
	public void verificationPaginationInAttributesPage() throws InterruptedException{
		landingPage()
		.loginToCimm2v4Site()
		.homePage()
		.clickOnAttributesLink();
		attributesPage()
		.verifyPaginationInAttributesPage();
	}
	
	
	@Features(value = {"Taxonomy Management Module"})
	 @Description("This is a test case which gives Verification of 'Display Records' in Attributes page")
	 @TestCaseId("TC_T-Mgmt_50")
	 @Test(groups={"regression"})
	 public void verifyDisplayOfNumberRecordsChosenInAttributesPage() throws Exception{
	  data.setNumberOfRecordsToDisplay("10");
	  landingPage()
	  .loginToCimm2v4Site()
	  .homePage()
	  .clickOnAttributesLink();
	  attributesPage()
	  .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
	  .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	  data.setNumberOfRecordsToDisplay("25");
	  attributesPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
	  .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	  data.setNumberOfRecordsToDisplay("50");
	  attributesPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
	  .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	  data.setNumberOfRecordsToDisplay("75");
	  attributesPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
	  .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	  data.setNumberOfRecordsToDisplay("100");
	  attributesPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
	  .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	}
	
	
	/*
	 * @author:Anusha
	 * 
	 */

	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute")
	@TestCaseId("TC_T-Mgmt_51_52_54")
	@Test(groups={"regression"})
	public void VerifyAddNewAttributes() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(data.getAttributeName())
		.enterAttributeDescriptionField(data.getAttributeDescription())
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(data.getAttributeSavedSuccessfulMessage())
		.enterTheAttributeNameInSearchField(data.getAttributeName())
		.clickOnSearchButton()
		.clickOnEditAttribute()
		.editAttributeNameField(data.getEditAttributeNameField())
		.clickOnAttributeUpdateButtonLink()
		.verifyAttributeUpdateSavedSuccessfulMessage(data.getAttributeUpdateSuccessfulMessage())
		.homePage()
		.clickOnAttributesLink()
		.attributesPage()
		.enterTheUpdateAttributeNameInSearchField(data.getUpdateAttributeNameField())
		.clickOnSearchButton()
		.clickOnRemoveUpdateAttribute(data.getUpdateAttributeNameField())
		.verifyRemoveAlertMsg(data.getAlertTextWhenRemoveAttributeIsClicked())
		.verifySuccessfulMessageAfterDeletionAttribute(data.getAttributetRemoveSuccessfulMessage())
		.verifyUpdateAttributeDeletion(data.getUpdateAttributeNameField());
	}
		
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute Group")
	@TestCaseId("TC_T-Mgmt_55_56_58_59_68_69")
	@Test(groups={"regression"})
	public void VerifyAddingNewAttributeGroup() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.verifyActionInAttributeGroupsPage()
		.verifySiNoInAttributeGroupsPage()
		.verifyAttributeGroupNameInAttributeGroupsPage()
		.verifyAttributeGroupDescInAttributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.verifyFieldNamesInAddNewAttributeGroup()
		.verifySaveLinkIconInAddNewAttributeGroup()
		.verifyResetLinkIconInAddNewAttributeGroup()
		.enterAttributeGroupField(data.getAttributeGroupNameField())
		.enterAttributeGroupDescriptionField(data.getAttributeGroupDescriptionField())
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupSavedSuccessfulMessage(data.getAttributeGroupSavedSuccessfulMessage())
		.enterTheAttributeGroupNameInSearchField(data.getAttributeGroupNameField())
		.clickOnSearchButton()
		.clickOnEditGroupAttributeGroup()
		.enterEditAttributeGroupField(data.getAttributeGroupNameField()+data.getEditAttributeGroupNameField())
		.clickOnAttributeGroupUpdateButtonLink()
		.verifyAttributeGroupUpdateSavedSuccessfulMessage(data.getAttributeUpdateSuccessfulMessage())
		.homePage()
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.enterTheUpdateAttributeGroupNameInSearchField(data.getUpdateAttributeGroupNameField())
		.clickOnSearchButton()
		.clickOnRemoveUpdateAttributeGroup(data.getUpdateAttributeGroupNameField())
		.verifyRemoveAttributeGroupsAlertMsg(data.getAlertTextWhenRemoveAttributeGroupIsClicked())
		.verifySuccessfulMessageAfterDeletionAttributeGroup(data.getAttributeGroupRemoveSuccessfulMessage())
		.verifyUpdateAttributeGroupDeletion(data.getUpdateAttributeGroupNameField());
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies InvalidSearch Attribute Group")
	@TestCaseId("TC_T-Mgmt_57_60")
	@Test(groups={"regression"})
	public void VerifyInvalidSearchAttributeGroup() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.enterAttributeGroupDescriptionField(data.getAttributeGroupDescriptionField())
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupNameRequiredMessage(data.getAttributeGroupNameRequiredMessage())
		.enterInvalidAttributeGroupNameInSearchField(data.getInvalidAttributeGroupName())
		.clickOnSearchButton()
		.verifyNoResultsFoundMessage(data.getNoResultsFoundMessage());
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Pagination InAttributeGroups Page")
	@TestCaseId("TC_T-Mgmt_63_64_65_66")
	@Test(groups={"regression"})
	public void VerifyPaginationInAttributeGroupsPage() throws Exception{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.verifyPaginationInAttributeGroupsPage();	
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Pagination InAttributeGroups Page")
	@TestCaseId("TC_T-Mgmt_63_64_65_66")
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void validationOfTextboxesInAttributeGroupsPage(String testCaseId,@Parameter("Field Name") String fieldName,@Parameter("Text to be entered in the textbox") String textToBeEnteredInTheTextbox,@Parameter("maximum number of characters that the textbox") String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.verifyTextboxValidation(fieldName,textToBeEnteredInTheTextbox,Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies history link in AttributeGroups ")
	@TestCaseId("TC_T-Mgmt_70")
	@Test(groups="regression")
	public void verifyAttributeGroupHistoryLink() throws Exception {
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.enterAttributeGroupField(data.getAttributeGroupNameField())
		.enterAttributeGroupDescriptionField(data.getAttributeGroupDescriptionField())
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupSavedSuccessfulMessage(data.getAttributeGroupSavedSuccessfulMessage())
		.enterTheAttributeGroupNameInSearchField(data.getAttributeGroupNameField())
		.clickOnSearchButton()
		.clickOnEditGroupAttributeGroup()
		.clickOnHistoryLinkInAttributeGroup()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		TestUtility.switchToRecentWindow();
		historyPage()
	    .verifyPageTitle(data.getExpectedAttributeGroupHistoryPageTitle())
	    .homePage()
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.enterTheAttributeGroupNameInSearchField(data.getAttributeGroupNameField())
		.clickOnSearchButton()
		.clickOnRemoveAttributeGroup(data.getAttributeGroupNameField())
		.verifyRemoveAttributeGroupsAlertMsg(data.getAlertTextWhenRemoveAttributeGroupIsClicked())
		.verifySuccessfulMessageAfterDeletionAttributeGroup(data.getAttributeGroupRemoveSuccessfulMessage())
		.verifyAttributeGroupDeletion(data.getAttributeGroupNameField());
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies history link in AttributeGroups ")
	@TestCaseId("TC_T-Mgmt_53")
	@Test(groups="regression")
	public void verifyAttributeHistoryLink() throws Exception {
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(data.getAttributeName())
		.enterAttributeDescriptionField(data.getAttributeDescription())
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(data.getAttributeSavedSuccessfulMessage())
		.enterTheAttributeNameInSearchField(data.getAttributeName())
		.clickOnSearchButton()
		.clickOnEditAttribute()
		.clickOnHistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		TestUtility.switchToRecentWindow();
		historyPage()
	    .verifyPageTitle(data.getExpectedAttributeHistoryPageTitle())
	    .homePage()
		.clickOnAttributesLink()
		.attributesPage()
		.enterTheAttributeNameInSearchField(data.getAttributeName())
		.clickOnSearchButton()
		.clickOnRemoveAttribute(data.getAttributeName())
		.verifyRemoveAlertMsg(data.getAlertTextWhenRemoveAttributeIsClicked())
		.verifySuccessfulMessageAfterDeletionAttribute(data.getAttributetRemoveSuccessfulMessage())
		.verifyeAttributeDeletion(data.getAttributeName());
	}
	
	
}
