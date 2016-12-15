package org.cimm2touch.modules;

import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;



public class TaxonomyManagementModuleTest extends PageFactoryInitializer{
	
HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public TaxonomyManagementModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TestUtilityMethods utility=new TestUtilityMethods(getDriver());
	RandomGenerator random=new RandomGenerator();
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the category edit/modification")
	@TestCaseId("TC_T-Mgmt_31")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verificationOfCategoryUpdation(String testCaseId, String userName, String password, String taxonomyName, String categoryName,String expSuccessMessge) throws InterruptedException{
		landingPage()
		.enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
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
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
		.enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnTaxonomyLink().taxonomyPage().searchForTaxonomy(taxonomyName).clickOnManageTaxonomy();
		categoryAndAttributesPage()
		.clickOnLeftPanel()
		.searchForTheCategory(categoryName)
		.doubleClickOnCategoryName(categoryName)
		.categoryAndAttributesPage()
		.enterTheCategoryName(categoryName)
		.clickOnSave()
		.clickOnHistoryLink().
		verifyHistoryPage(expHistoryPageTitleForCategory,categoryName);

		
	}
	
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which gives Verification of 'Display Records' in Taxonomy page")
	@TestCaseId("TC_T-Mgmt_39")
	@Test(groups={"regression"}, dataProvider="TaxonomyManagementModuleTest", dataProviderClass=SearchData.class)
	public void verifyDisplayRecordsChosenTax(String testCaseId, String userName, String password) throws Exception{
		data.setNumberOfRecordsToDisplay("10");
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
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
	public void verificationOfErrorMessage(String testCaseId, String expErrorMessage) throws InterruptedException{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnAttributesLink();
		attributesPage()
		.clickOnNewAttributeToCreate()
		.clickOnSaveAttribute()
		.verifyErrorMessage(expErrorMessage);
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if attribue name exceeds 50 chars")
	@TestCaseId("TC_T-Mgmt_44")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForAttributeName(String testCaseId, String attributeDescription,String  successfulMessageAfterCreationAttribute) throws InterruptedException{
		
		String attributename= random.random(54, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage().clickOnAttributesLink();
		attributesPage().clickOnNewAttributeToCreate()
		.enterAttributeName(attributename)
		.enterAttributeDescription(attributeDescription)
		.clickOnSaveAttribute()
		.verifyErrorMessageMoreAttributeName(attributename)
		.verifyCreatedAttribute(attributename.substring(0, 20))
		.removeAttribute(attributename.substring(0, 20));
		
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies error message if description exceeds 500 chars")
	@TestCaseId("TC_T-Mgmt_45")
	@Test(groups={"regression"})
	public void verificationOfErrorMessageForDescription(String testCaseId,  String attributeName, String expectedErrorMessage) throws InterruptedException{
		String attributeDescription= random.random(504, PermittedCharacters.ALPHABETS);
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnAttributesLink();
		attributesPage()
		.clickOnNewAttributeToCreate()
		.enterAttributeName(attributeName)
		.enterAttributeDescription(attributeDescription)
		.clickOnSaveAttribute()
		.verifyErrorMessageMoreDescription(expectedErrorMessage.trim());
		
		
	}
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies the pagination functionality for Attributes in T-Management")
	@TestCaseId("TC_T-Mgmt_46_47_48_49")
	@Test(groups={"regression"})
	public void verificationPaginationInAttributesPage() throws InterruptedException{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
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
	  .enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
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
	public void VerifyAddNewAttributes(String testCaseId, String attributeName, String attributeDescription, String attributeSavedSuccessfulMessage,
			String attributeUpdateSuccessfulMessage, String updateAttributeNameField, String alertTextWhenRemoveAttributeIsClicked, String attributetRemoveSuccessfulMessage) throws Exception{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(attributeName)
		.enterAttributeDescriptionField(attributeDescription)
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(attributeSavedSuccessfulMessage)
		.enterTheAttributeNameInSearchField(attributeName)
		.clickOnSearchButton()
		.clickOnEditAttribute()
		.editAttributeNameField(attributeName)
		.clickOnAttributeUpdateButtonLink()
		.verifyAttributeUpdateSavedSuccessfulMessage(attributeUpdateSuccessfulMessage)
		.homePage()
		.clickOnAttributesLink()
		.attributesPage()
		.enterTheUpdateAttributeNameInSearchField(updateAttributeNameField)
		.clickOnSearchButton()
		.clickOnRemoveUpdateAttribute(updateAttributeNameField)
		.verifyRemoveAlertMsg(alertTextWhenRemoveAttributeIsClicked)
		.verifySuccessfulMessageAfterDeletionAttribute(attributetRemoveSuccessfulMessage)
		.verifyUpdateAttributeDeletion(updateAttributeNameField);
	}
		
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies creating new Attribute Group")
	@TestCaseId("TC_T-Mgmt_55_56_58_59_68_69")
	@Test(groups={"regression"})
	public void VerifyAddingNewAttributeGroup(String testCaseId, String fieldsNamesInAddNewAttributeGroup, String attributeGroupName, 
			String attributeGroupDescription, String attributeGroupSavedSuccessfulMessage, String editAttributeGroupName, 
			String attributeUpdateSuccessfulMessage, String alertTextWhenRemoveAttributeGroup, String attributeGroupRemoveSuccessfulMessage) throws Exception{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.verifyActionInAttributeGroupsPage()
		.verifySiNoInAttributeGroupsPage()
		.verifyAttributeGroupNameInAttributeGroupsPage()
		.verifyAttributeGroupDescInAttributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.verifyFieldNamesInAddNewAttributeGroup(fieldsNamesInAddNewAttributeGroup)
		.verifySaveLinkIconInAddNewAttributeGroup()
		.verifyResetLinkIconInAddNewAttributeGroup()
		.enterAttributeGroupField(attributeGroupName)
		.enterAttributeGroupDescriptionField(attributeGroupDescription)
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupSavedSuccessfulMessage(attributeGroupSavedSuccessfulMessage)
		.enterTheAttributeGroupNameInSearchField(attributeGroupName)
		.clickOnSearchButton()
		.clickOnEditGroupAttributeGroup()
		.enterEditAttributeGroupField(editAttributeGroupName)
		.clickOnAttributeGroupUpdateButtonLink()
		.verifyAttributeGroupUpdateSavedSuccessfulMessage(attributeUpdateSuccessfulMessage)
		.homePage()
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.enterTheUpdateAttributeGroupNameInSearchField(editAttributeGroupName)
		.clickOnSearchButton()
		.clickOnRemoveUpdateAttributeGroup(editAttributeGroupName)
		.verifyRemoveAttributeGroupsAlertMsg(alertTextWhenRemoveAttributeGroup)
		.verifySuccessfulMessageAfterDeletionAttributeGroup(attributeGroupRemoveSuccessfulMessage)
		.verifyUpdateAttributeGroupDeletion(editAttributeGroupName);
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies InvalidSearch Attribute Group")
	@TestCaseId("TC_T-Mgmt_57_60")
	@Test(groups={"regression"})
	public void VerifyInvalidSearchAttributeGroup(String testCaseId, String attributeGroupDescription , String attributeGroupNameRequiredMessage,
			String invalidAttributeGroupName, String noResultsFoundMessage) throws Exception{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.enterAttributeGroupDescriptionField(attributeGroupDescription)
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupNameRequiredMessage(attributeGroupNameRequiredMessage)
		.enterInvalidAttributeGroupNameInSearchField(invalidAttributeGroupName)
		.clickOnSearchButton()
		.verifyNoResultsFoundMessage(noResultsFoundMessage);
		
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Pagination InAttributeGroups Page")
	@TestCaseId("TC_T-Mgmt_63_64_65_66")
	@Test(groups={"regression"})
	public void VerifyPaginationInAttributeGroupsPage() throws Exception{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.verifyPaginationInAttributeGroupsPage();	
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies Pagination InAttributeGroups Page")
	@TestCaseId("TC_T-Mgmt_63_64_65_66")
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void validationOfTextboxesInAttributeGroupsPage(String testCaseId,  String fieldName, String textToBeEnteredInTheTextbox,String maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.verifyTextboxValidation(fieldName,textToBeEnteredInTheTextbox,Integer.parseInt(maximumNumberOfCharactersAcceptedByTheTexbox));
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies history link in AttributeGroups ")
	@TestCaseId("TC_T-Mgmt_70")
	@Test(groups="regression")
	public void verifyAttributeGroupHistoryLink(String testCaseId, String attributeGroupName, String attributeGroupDescription, 
			String attributeGroupSavedSuccessfulMessage, String alertTextWhenHistoryIsClicked, String expectedAttributeGroupHistoryPageTitle,
			String alertTextForRemoveAttributeGroup, String attributeGroupRemoveSuccessfulMessage) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.clickOnAddNewAttributeGroupLink()
		.enterAttributeGroupField(attributeGroupName)
		.enterAttributeGroupDescriptionField(attributeGroupDescription)
		.clickOnAttributeGroupSaveButtonLink()
		.verifyAttributeGroupSavedSuccessfulMessage(attributeGroupSavedSuccessfulMessage)
		.enterTheAttributeGroupNameInSearchField(attributeGroupName)
		.clickOnSearchButton()
		.clickOnEditGroupAttributeGroup()
		.clickOnHistoryLinkInAttributeGroup()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		utility.switchToRecentWindow();
		historyPage()
	    .verifyPageTitle(expectedAttributeGroupHistoryPageTitle)
	    .homePage()
		.clickOnAttributeGroupsLink()
		.attributeGroupsPage()
		.enterTheAttributeGroupNameInSearchField(attributeGroupName)
		.clickOnSearchButton()
		.clickOnRemoveAttributeGroup(attributeGroupName)
		.verifyRemoveAttributeGroupsAlertMsg(alertTextForRemoveAttributeGroup)
		.verifySuccessfulMessageAfterDeletionAttributeGroup(attributeGroupRemoveSuccessfulMessage)
		.verifyAttributeGroupDeletion(attributeGroupName);
	}
	
	@Features(value = {"Taxonomy Management Module"})
	@Description("This is a test case which verifies history link in AttributeGroups ")
	@TestCaseId("TC_T-Mgmt_53")
	@Test(groups="regression")
	public void verifyAttributeHistoryLink(String testCaseId, String attributeName, String attributeDescription, String attributeSavedSuccessfulMessage,
			String alertTextWhenHistoryIsClicked, String expectedAttributeHistoryPageTitle, String alertTextWhenRemoveAttributeIsClicked, String attributetRemoveSuccessfulMessage) throws Exception {
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(loginData.get("welcomeMessage"))
		.clickOnAttributesLink()
		.attributesPage()
		.clickOnAddNewAttributeLink()
		.enterAttributeNameField(attributeName)
		.enterAttributeDescriptionField(attributeDescription)
		.clickOnAttributeSaveButtonLink()
		.verifyAttributeSavedSuccessfulMessage(attributeSavedSuccessfulMessage)
		.enterTheAttributeNameInSearchField(attributeName)
		.clickOnSearchButton()
		.clickOnEditAttribute()
		.clickOnHistoryLink()
		.verifyAlertMsg(alertTextWhenHistoryIsClicked);
		utility.switchToRecentWindow();
		historyPage()
	    .verifyPageTitle(expectedAttributeHistoryPageTitle)
	    .homePage()
		.clickOnAttributesLink()
		.attributesPage()
		.enterTheAttributeNameInSearchField(attributeName)
		.clickOnSearchButton()
		.clickOnRemoveAttribute(attributeName)
		.verifyRemoveAlertMsg(alertTextWhenRemoveAttributeIsClicked)
		.verifySuccessfulMessageAfterDeletionAttribute(attributetRemoveSuccessfulMessage)
		.verifyeAttributeDeletion(attributeName);
	}
	
	
}
