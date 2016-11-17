package org.cimm2touch.modules;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class TaxonomyManagementModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginObj = new LoginModuleTest();
	TestUtilityMethods utility=new TestUtilityMethods(getDriver());
	RandomGenerator random=new RandomGenerator();
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category edit/modification")
	@TestCaseId("TC_T-Mgmt_31")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfCategoryUpdation(String testCaseId, String userName, String password, String taxonomyName, String categoryName,String expSuccessMessge) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(categoryName)
		.doubleClickOnCategoryName(categoryName)
		.categoryAndAttributesPage()
		.enterTheCategoryName(categoryName)
		.clickOnSave().verifySuccesfulMessage(expSuccessMessge);
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category remove")
	@TestCaseId("TC_T-Mgmt_32")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfCategoryRemove(String testCaseId, String userName, String password, String taxonomyName, String categoryName, String alertText) throws InterruptedException
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(categoryName)
		.doubleClickOnCategoryName(categoryName)
		.categoryAndAttributesPage()
		.enterTheCategoryName(categoryName)
		.clickOnSave()
		.clickOnRemove()
		.verifyAlertAndAccept(alertText.trim());
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category image upload")
	@TestCaseId("TC_T-Mgmt_33")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verificationCategoryImageUpload(String testCaseId, String userName, String password, String taxonomyName, String categoryName) throws InterruptedException{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomyName)
		.clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(categoryName)
		.doubleClickOnCategoryName(categoryName)
		.categoryAndAttributesPage()
		.enterTheCategoryName(categoryName)
		.clickOnSave()
		.clickOnImageUpload();
		imageUploadPage()
		.clickOnImageToSelectFromRep()
		.SelectImageFromRepo()
		.categoryAndAttributesPage();
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category Revision History activities")
	@TestCaseId("TC_T-Mgmt_34")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verificationRevisionHistory(String testCaseId, String userName, String password, String taxonomyName, String categoryName, String expHistoryPageTitleForCategory) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(taxonomyName).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(categoryName)
		.doubleClickOnCategoryName(categoryName)
		.categoryAndAttributesPage()
		.enterTheCategoryName(categoryName)
		.clickOnSave()
		.clickOnHistoryLink().verifyHistoryPage(expHistoryPageTitleForCategory);
		
	}
	
/*	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the pagination functionality in T-Management")
	@TestCaseId("TC_T-Mgmt_35_36_37_38")
	@Test(groups={"regression"})
	public void verificationPagination() throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.verifyPagination();
	}*/
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which gives Verification of 'Display Records' in Taxonomy page")
	@TestCaseId("TC_T-Mgmt_39")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verifyDisplayRecordsChosenTax(String testCaseId, String userName, String password) throws Exception{
		data.setNumberOfRecordsToDisplay("10");
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
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
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verifyOfAttributListPage(String testCaseId, String userName, String password, String expAttributesTableHeader ) throws InterruptedException{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.clickOnAttributesLink();
		attributesPage()
		.verifyAttributesTableHeaders(expAttributesTableHeader);
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute")
	@TestCaseId("TC_T-Mgmt_41_42")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verifyOfCreateNewAttribute(String testCaseId, String userName, String password, String attributeName, String attributeDescription) throws InterruptedException{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin();
		homePage()
		.clickOnAttributesLink();
		attributesPage()
		.clickOnNewAttributeToCreate()
		.enterAttributeName(attributeName)
		.enterAttributeDescription(attributeDescription)
		.clickOnSaveAttribute().verifyCreatedAttribute(attributeName).removeAttribute(attributeName);	
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error messageif attribute name left as blank")
	@TestCaseId("TC_T-Mgmt_43")
	@Test(groups={"regression"})
	public void verificationOfErrorMessage(String testCaseId, String userName, String password) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.clickOnSaveAttribute().verifyErrorMessage(data.expErrorMessage());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if attribue name exceeds 50 chars")
	@TestCaseId("TC_T-Mgmt_44")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForAttributeName(String testCaseId, String userName, String password, String attributeDescription) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(data.getAttributeNameMoreThan50Chars())
		.enterAttributeDescription(attributeDescription)
		.clickOnSaveAttribute().verifyErrorMessageMoreAttributeName(data.getAttributeNameMoreThan50Chars()+data.getSuccessfulMessageAfterCreationAttribute().trim())
		.verifyCreatedAttribute(data.getAttributeNameMoreThan50CharsPartial()).removeAttribute(data.getAttributeNameMoreThan50CharsPartial());
		
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if description exceeds 500 chars")
	@TestCaseId("TC_T-Mgmt_45")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForDescription(String testCaseId, String userName, String password, String attributeName) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(attributeName)
		.enterAttributeDescription(data.getAttributeDescriptionMoreText())
		.clickOnSaveAttribute().verifyErrorMessageMoreDescription(data.expErrorMessageIfDesc().trim());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the pagination functionality for Attributes in T-Management")
	@TestCaseId("TC_T-Mgmt_46_47_48_49")
	@Test(groups={"regression"})
	public void verificationPaginationInAttributesPage(String testCaseId, String userName, String password) throws InterruptedException{
		landingPage()
		.enterUsername(userName).enterPassword(password).clickOnLogin()
		.homePage()
		.clickOnAttributesLink();
		attributesPage()
		.verifyPaginationInAttributesPage();
	}
	
	
	@Features(value = {"Taxonomy Management Module"})
	 @Description("This is a test case which gives Verification of 'Display Records' in Attributes page")
	 @TestCaseId("TC_T-Mgmt_50")
	 @Test(groups={"regression"})
	 public void verifyDisplayOfNumberRecordsChosenInAttributesPage(String testCaseId, String userName, String password) throws Exception{
	  data.setNumberOfRecordsToDisplay("10");
	  landingPage()
	  .enterUsername(userName).enterPassword(password).clickOnLogin()
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
	

	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute")
	@TestCaseId("TC_T-Mgmt_51_52_54")
	@Test(groups={"regression"})
	public void VerifyAddNewAttributes(String testCaseId, String userName, String password, String welcomeMessage, String attributeName, String attributeDescription) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(attributeName)
		.enterAttributeDescriptionField(attributeDescription)
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(data.getAttributeSavedSuccessfulMessage())
		.enterTheAttributeNameInSearchField(attributeName)
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
	public void VerifyAddingNewAttributeGroup(String testCaseId, String userName, String password, String welcomeMessage) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
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
	public void VerifyInvalidSearchAttributeGroup(String testCaseId, String userName, String password, String welcomeMessage) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
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
	public void VerifyPaginationInAttributeGroupsPage(String testCaseId, String userName, String password, String welcomeMessage) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.verifyPaginationInAttributeGroupsPage();	
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Pagination InAttributeGroups Page")
	@TestCaseId("TC_T-Mgmt_63_64_65_66")
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void validationOfTextboxesInAttributeGroupsPage(String testCaseId, String userName, String password, String welcomeMessage,@Parameter("Field Name") String fieldName,@Parameter("Text to be entered in the textbox") String textToBeEnteredInTheTextbox,@Parameter("maximum number of characters that the textbox") String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.verifyTextboxValidation(fieldName,textToBeEnteredInTheTextbox,Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies history link in AttributeGroups ")
	@TestCaseId("TC_T-Mgmt_70")
	@Test(groups="regression")
	public void verifyAttributeGroupHistoryLink(String testCaseId, String userName, String password, String welcomeMessage) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
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
		utility.switchToRecentWindow();
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
	public void verifyAttributeHistoryLink(String testCaseId, String userName, String password, String welcomeMessage, String attributeName, String attributeDescription) throws Exception {
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(attributeName)
		.enterAttributeDescriptionField(attributeDescription)
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(data.getAttributeSavedSuccessfulMessage())
		.enterTheAttributeNameInSearchField(attributeName)
		.clickOnSearchButton()
		.clickOnEditAttribute()
		.clickOnHistoryLink()
		.verifyAlertMsg(data.getAlertTextWhenHistoryIsClicked());
		utility.switchToRecentWindow();
		historyPage()
	    .verifyPageTitle(data.getExpectedAttributeHistoryPageTitle())
	    .homePage()
		.clickOnAttributesLink()
		.attributesPage()
		.enterTheAttributeNameInSearchField(attributeName)
		.clickOnSearchButton()
		.clickOnRemoveAttribute(attributeName)
		.verifyRemoveAlertMsg(data.getAlertTextWhenRemoveAttributeIsClicked())
		.verifySuccessfulMessageAfterDeletionAttribute(data.getAttributetRemoveSuccessfulMessage())
		.verifyeAttributeDeletion(attributeName);
	}
	
	
}
