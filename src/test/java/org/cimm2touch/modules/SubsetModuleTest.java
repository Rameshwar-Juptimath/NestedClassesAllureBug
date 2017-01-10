package org.cimm2touch.modules;
/**
 * @author Thiruveedhi Chinna
 *
 */

import java.util.HashMap;
import java.util.Hashtable;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SubsetModuleTest extends PageFactoryInitializer {

	RandomGenerator random = new RandomGenerator();
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	//Hashtable<String, String> loginData;
	//Hashtable<String, String> creationData;
	
	HashMap<String, String> loginData;
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public SubsetModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	

	/*@Factory(dataProvider = "SubsetCreationTestData", dataProviderClass = SearchData.class)
	public SubsetModuleTest(String userName, String password, String welcomMessage, String subsetName,
			String subsetDescription, String subsetSaveMessage) {
		loginData = new Hashtable<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
		
		creationData = new Hashtable<String, String>();
		
		creationData.put("subsetName", subsetName);
		creationData.put("subsetDescription", subsetDescription);
		creationData.put("subsetSaveMessage", subsetSaveMessage);
	}

	// ====================================================

	// ===========================================
*/	/*@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@BeforeClass(groups = { "regression" })
	public void createSubset() throws InterruptedException, Exception {
		
		        landingPage()
		        .enterUsername(loginData.get("userName"))
		        .enterPassword(loginData.get("password"))
		        .clickOnLogin()
				.homePage()
				.clickOnSubset()
				.subsetPage()
				.searchForAnSubset(creationData.get("subsetName"))
				.clickOnSubsetSearchGoButton().verifySubsetPresent(creationData.get("subsetName"))
				.createSubset(creationData.get("subsetName"), creationData.get("subsetDescription"))
				.verifySubsetCreationMessage(creationData.get("subsetSaveMessage"))
				.searchForAnSubset(creationData.get("subsetName")).clickOnSubsetSearchGoButton()
				.verifyCreatedSubset(creationData.get("subsetName"));
	}
	// ===============================================
	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@AfterClass(groups = { "regression" })
	public void deleteSubset()
	{
		 landingPage()
	        .enterUsername(loginData.get("userName"))
	        .enterPassword(loginData.get("password"))
	        .clickOnLogin()
			.homePage()
			.clickOnSubset();
	}
	*/
	//======================================================

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@TestCaseId("TC_Subset_001,TC_Subset_004, TC_Subset_005")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	// completed by me
	public void tc_Subset_001_004_005(String testCaseID, String headerList, String placeHolderText, String subsetName,
			String errorMessage, String addNewSubsetField) throws Exception {
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
				.homePage().clickOnSubset().subsetPage().verifyHeaderPartOfSubsetPage(headerList)
				.verifySearchFieldOfSubsetPage(placeHolderText).searchForAnSubset(subsetName)
				.clickOnSubsetSearchGoButton().verifySubsetPresent(subsetName).verifyErrorMessage(errorMessage)
				.verifyAddNewSubsetButtonInSubsetpage().clickOnAddNewSubset()
				.verifyAllAddNewSubsetFields(addNewSubsetField).verifySaveLinkInAddNewSubsetPage();

		/*
		 * .subsetPage() .verifySubsetPageItems() .clickOnAddNewSubset()
		 * .verifyAddNewSubsetFormItems() .addNewSubset(subsetName, subsetDesc,
		 * bannerText) .clickOnSaveNewSubset()
		 * .verifyMessageAfterSavingSubset(saveMessage)
		 * .searchForAnSubset(subsetName)
		 * .verifyAfterSearchingForSubset(subsetName);
		 */
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@TestCaseId("")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	// completed by me
	public void tc_Subset_002(String testCaseID) throws Exception {
		data.setNumberOfRecordsToDisplay("10");
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
				.homePage().clickOnSubset().subsetPage()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("25");
		subsetPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("50");
		subsetPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("75");
		subsetPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		data.setNumberOfRecordsToDisplay("100");
		subsetPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());

	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@TestCaseId("")
	// completed by me
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_007(String testCaseID, String subsetDescription, String requiredMessage)
			throws InterruptedException {
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
				.homePage().clickOnSubset().subsetPage().clickOnAddNewSubset()
				.createSubsetWithoutMandatoryField(subsetDescription).verifySubsetNameIsRequired(requiredMessage);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@TestCaseId("")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	// created by me
	public void tc_Subset_006_003_008_009(String testCaseID, String subsetName, String subsetDescription,
			String subsetSaveMessage, String editFieldOfSubset, String updatedSubsetName, String updateMessage)
			throws Exception {

		        landingPage()
		       .enterUsername(loginData.get("userName"))
		        .enterPassword(loginData.get("password"))
		        .clickOnLogin()
				.homePage()
				.clickOnSubset()
				.subsetPage()
				.checkSubsetPage()
				.searchForAnSubset(subsetName)
				.clickOnSubsetSearchGoButton()
				.verifySubsetPresent(subsetName)
				.createSubset(subsetName, subsetDescription)
				.verifySubsetCreationMessage(subsetSaveMessage)
				.searchForAnSubset(subsetName)
				.clickOnSubsetSearchGoButton()
				.verifyCreatedSubset(subsetName)
				.clickOnEditSubset(subsetName)
				.verifyAllEditSubsetFields(editFieldOfSubset)
				.createUpdatedUom(updatedSubsetName)
				.clickOnUpdateSubsetLink()
				.verifyUpdateWelcomeMessage(updateMessage);
		String subsetId = subsetPage()
				        .searchForAnSubset(updatedSubsetName)
				       .clickOnSubsetSearchGoButton()
				       .verifyCreatedSubset(updatedSubsetName)
				        .verifyandDeleteSubset(updatedSubsetName);
		                 subsetPage()
		                .verifySuccessMessageForDeletionOfSubset(updatedSubsetName, subsetId);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset.")
	@TestCaseId("")
	//done by me(doubt)
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_010(String testCaseID,String subsetName, String subsetDescription,String subsetSaveMessage,String allItemTab,String excludedItemTab,String additionalItemTab) throws InterruptedException, Exception {
		               landingPage()
		              .enterUsername(loginData.get("userName"))
		              .enterPassword(loginData.get("password"))
		              .clickOnLogin()
				      .homePage()
				      .clickOnSubset()
				      .subsetPage()
				      .checkSubsetPage()
					  .searchForAnSubset(subsetName)
					  .clickOnSubsetSearchGoButton()
					  .verifySubsetPresent(subsetName)
					  .createSubset(subsetName, subsetDescription)
					  .verifySubsetCreationMessage(subsetSaveMessage)
					  .searchForAnSubset(subsetName)
					  .clickOnSubsetSearchGoButton()
					  .verifyCreatedSubset(subsetName)
					  .clickOnCatalogBuilderView(subsetName)
					  .catalogBuilderPage()
					  .verifyCatalogBuilderPageItems()
					  .verifyAllItemTab(allItemTab)
					  .verifyExcludedItemTab(excludedItemTab)
					  .verifyAdditionalItemTab(additionalItemTab);
	}

	

	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to Verify the 'Edit Subset' Form Items")
	@TestCaseId("TC_Subset_08")
	@Test(priority = 4, groups = {
			"regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_08(String testCaseID, String userName, String password, String subsetName) throws Exception {
		landingPage().enterUsername(userName).enterPassword(password).clickOnLogin().homePage().clickOnSubset()
				.subsetPage().verifySubsetPageItems().searchForAnSubset(subsetName)
				.verifyAfterSearchingForSubset(subsetName).clickOnEditSubset(subsetName)
				.verifyEditSubsetFormItems(subsetName);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to Verify the  working of 'Edit Subset' Form Items")
	@TestCaseId("TC_Subset_09")
	@Test(priority = 5, groups = {
			"regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_09(String testCaseID, String userName, String password, String subsetName,
			String editedSubsetName, String subsetDesc, String updateMessage) throws Exception {
		landingPage().enterUsername(userName).enterPassword(password).clickOnLogin().homePage().clickOnSubset()
				.subsetPage().verifySubsetPageItems().searchForAnSubset(subsetName)
				.verifyAfterSearchingForSubset(subsetName).clickOnEditSubset(subsetName)
				.verifyEditSubsetFormItems(subsetName).editSubset(editedSubsetName, subsetDesc)
				.verifyMessageAfterUpdatingSubset(updateMessage);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to Verify 'Catalog Builder View' Form Items")
	@TestCaseId("TC_Subset_10")
	@Test(priority = 6, groups = {
			"regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_10(String testCaseID, String userName, String password, String subsetName) throws Exception {
		landingPage().enterUsername(userName).enterPassword(password).clickOnLogin().homePage().clickOnSubset()
				.subsetPage().verifySubsetPageItems().searchForAnSubset(subsetName)
				.verifyAfterSearchingForSubset(subsetName).clickOnCatalogBuilderView(subsetName)
				.verifyCatalogBuilderPageItems();
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to add Manufacturer and Brands under 'Catalog Builder View'")
	@TestCaseId("TC_Subset_11")
	@Test(priority = 7, groups = {
			"regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_11(String testCaseID, String userName, String password, String subsetName,
			String manufacturerName, String brandName) throws Exception {
		    landingPage()
		     .enterUsername(userName)
		    .enterPassword(password)
		     .clickOnLogin()
		       .homePage()
		         .clickOnSubset()
				.subsetPage()
				.verifySubsetPageItems()
				.searchForAnSubset(subsetName)
				.verifyAfterSearchingForSubset(subsetName)
				.clickOnCatalogBuilderView(subsetName)
				.verifyCatalogBuilderPageItems()
				
				.addManufacturerAndBrand(manufacturerName, brandName)
				.clickOnSaveRules();
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to verify previously added Manufacturer and Brands under 'Catalog Builder View'")
	@TestCaseId("TC_Subset_12, TC_Subset_13")
	@Test(priority = 8, groups = {
			"regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_12(String testCaseID, String userName, String password, String subsetName,
			String manufacturerName, String brandName, String saveMessage) throws Exception {
		landingPage().enterUsername(userName).enterPassword(password).clickOnLogin().homePage().clickOnSubset()
				.subsetPage().verifySubsetPageItems().searchForAnSubset(subsetName)
				.verifyAfterSearchingForSubset(subsetName).clickOnCatalogBuilderView(subsetName)
				.verifyCatalogBuilderPageItems().clickOnSelectedTab()
				.verifySelectedManufacturerInCatalogBuilder(manufacturerName)
				.clickOnDeleteSelectedManufacturerInCatalogBuilder(manufacturerName)
				.verifyMessageAfterDeletingManufacturerInCatalogBuilder(saveMessage);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This test case Verifies the Character Limit for ' Subset Name' Field.")
	@TestCaseId("TC_Subset_24")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void TC_Subset_24(String testCaseID, String userName, String password) throws Exception {
		String moreThanAccept = random.random(51, PermittedCharacters.ALPHABETS);
		landingPage().enterUsername(userName).enterPassword(password).clickOnLogin().homePage().clickOnSubset()
				.subsetPage().verifySubsetPageItems().clickOnAddNewSubset().verifyAddNewSubsetFormItems()
				.verifyCharacterLimitForSubsetName(moreThanAccept);
	}

	/*
	 * SearchDataPropertyFile data = new SearchDataPropertyFile();
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case Verifies fields in subset page")
	 * 
	 * @TestCaseId("TC_Subset_01")
	 * 
	 * @Test(groups="regression") public void verifySubsetTableContent() {
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage() .verifyAction(data.getactionlabel())
	 * .verifySlno(data.getslnolabel()) .verifySubsetid(data.getsubsetIdlabel())
	 * .verifySubsetName(data.getsubsetNamelabel())
	 * .verifySubsetDescription(data.getsubsetdescriptionlabel())
	 * .verifypurpose(data.getPurposelabel())
	 * .verifystatus(data.getStatuslabel()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case Verifies the pagination in subset page")
	 * 
	 * @TestCaseId("TC_Subset_02")
	 * 
	 * @Test(groups="regression") public void verifyPaginationSubset() throws
	 * Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * data.setTheNumberofRecordsToDisplay("10"); landingPage() <<<<<<< HEAD
	 * .enterUsername(userName) .enterPassword(password) =======
	 * .enterUsername(data.getUserName()) .enterPassword(data.getPassword())
	 * >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin()
	 * .homePage() .verifyWelcomeMessage(data.getwelcomeMessage())
	 * .clickonSubsetlink() .subsetPage()
	 * .selectNumberOfRecordsToDisplay(data.getNumberOfRecordsToDisplay())
	 * .verifyPagination(data.getNumberOfRecordsToDisplay());
	 * data.setTheNumberofRecordsToDisplay("25"); subsetPage()
	 * .selectNumberOfRecordsToDisplay(data.getNumberOfRecordsToDisplay())
	 * .verifyPagination(data.getNumberOfRecordsToDisplay());
	 * data.setTheNumberofRecordsToDisplay("50"); subsetPage()
	 * .selectNumberOfRecordsToDisplay(data.getNumberOfRecordsToDisplay())
	 * .verifyPagination(data.getNumberOfRecordsToDisplay());
	 * data.setTheNumberofRecordsToDisplay("100"); subsetPage()
	 * .selectNumberOfRecordsToDisplay(data.getNumberOfRecordsToDisplay())
	 * .verifyPagination(data.getNumberOfRecordsToDisplay()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case Verifies search functionality for valid inputs in subset page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_03")
	 * 
	 * @Test(groups="regression") public void verificationOfValidSearch() throws
	 * Exception{ landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage())
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case Verifies search functionality for invalid inputsin subset page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_04")
	 * 
	 * @Test(groups="regression") public void verificationOfInvalidSearch()
	 * throws InterruptedException{ landingPage() <<<<<<< HEAD
	 * .enterUsername(userName) .enterPassword(password) =======
	 * .enterUsername(data.getUserName()) .enterPassword(data.getPassword())
	 * >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin()
	 * .homePage() .verifyWelcomeMessage(data.getwelcomeMessage())
	 * .clickonSubsetlink() .subsetPage()
	 * .searchSubsetInvlaidData(data.getsubsetNameinvalid(),data.
	 * getSubsetsearchErrorMsg()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case Verifies fields of add new subset form")
	 * 
	 * @TestCaseId("TC_Subset_05")
	 * 
	 * @Test(groups="regression") public void VerificationOfAddNewSubsetForm()
	 * throws InterruptedException{ landingPage() <<<<<<< HEAD
	 * .enterUsername(userName) .enterPassword(password) =======
	 * .enterUsername(data.getUserName()) .enterPassword(data.getPassword())
	 * >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin()
	 * .homePage() .verifyWelcomeMessage(data.getwelcomeMessage())
	 * .clickonSubsetlink() .subsetPage() .clickOnnewSubsetLink()
	 * .verifySubsetForm(data.getSubsetFormLabel())
	 * .verifySubsetformfields(data.getsubsetNamelabel(),
	 * data.getsubsetdescriptionlabel(),data.getPurposelabel(),data.
	 * getStatuslabel(),data.getubsetformfildbannerText()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified add new subset in subset page")
	 * 
	 * @TestCaseId("TC_Subset_06")
	 * 
	 * @Test(groups="regression") public void verificationOfAddNewSubset()
	 * throws Exception{ landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage())
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified validation of subset name field")
	 * 
	 * @TestCaseId("TC_Subset_07")
	 * 
	 * @Test(groups="regression") public void verificationofSubsetName() throws
	 * InterruptedException{ landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage() .clickOnnewSubsetLink()
	 * .verifySubsetForm(data.getSubsetFormLabel()) .clickSave()
	 * .verifyErrorMsg(data.getsubsetRequiredMsg()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified  subset form fields when open for editing the subset"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_08")
	 * 
	 * @Test(groups="regression") public void verificationofEditSubsetFields()
	 * throws Exception{ landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage())
	 * .clickOnEditButtonsubset(data.getsubsetNamelabel(),
	 * data.getsubsetdescriptionlabel(),data.getPurposelabel(),data.
	 * getStatuslabel(),data.getubsetformfildbannerText())
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified  subset form fields when open for editing the subset"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_09")
	 * 
	 * @Test(groups="regression") public void verificationofupdateSubset()
	 * throws Exception{ landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificEditButton(1)
	 * .updateSubset(data.getUpdateSubsetDescription(),data.getSubsetUpdatemsg()
	 * ) .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified all the fileds of catelog builder view page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_10")
	 * 
	 * @Test(groups="regression") public void
	 * VerificationOfCatalogBuilderViewPage() throws Exception{ landingPage()
	 * <<<<<<< HEAD .enterUsername(userName) .enterPassword(password) =======
	 * .enterUsername(data.getUserName()) .enterPassword(data.getPassword())
	 * >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin()
	 * .homePage() .verifyWelcomeMessage(data.getwelcomeMessage())
	 * .clickonSubsetlink() .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .verifyCatelogBuilderPage()
	 * .homePage() .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies building catalog")
	 * 
	 * @TestCaseId("TC_Subset_11")
	 * 
	 * @Test(groups="regression") public void verifyingcatlogmaking() throws
	 * Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .verifyCatelogBuilderPage()
	 * .clickOnManufacturer() .selectAnManufacturer(data.getmanufacturername())
	 * .clickOnSpecificManufacturer(data.getmanufacturername())
	 * .clickOnsaveRules()
	 * .VerifySuccessMessagecatalog(data.getSubsetSuccessmsg())
	 * .clickOnSelectedLink()
	 * .verifySelectedManufacturer(data.getmanufacturername())
	 * .clickonRemoveMB(data.getmanufacturername()) .homePage()
	 * .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies selected tab contents")
	 * 
	 * @TestCaseId("TC_Subset_12")
	 * 
	 * @Test(groups="regression") public void VerifyingSelectedTabContent()
	 * throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .clickOnManufacturer()
	 * .selectAnManufacturer(data.getmanufacturername())
	 * .clickOnSpecificManufacturer(data.getmanufacturername())
	 * .clickOnsaveRules()
	 * .VerifySuccessMessagecatalog(data.getSubsetSuccessmsg())
	 * .clickOnSelectedLink()
	 * .verifySelectedManufacturer(data.getmanufacturername())
	 * .verifyingcontentSelectedTabs(data.getSelectAction(),data.
	 * getSelectEntityName(),data.getSelectEntityType())
	 * .clickonRemoveMB(data.getmanufacturername()) .homePage()
	 * .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies removing manufacturer from selected tab"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_13")
	 * 
	 * @Test(groups="regression") public void verifyingtheRemoveSelectedMB()
	 * throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .clickOnManufacturer()
	 * .selectAnManufacturer(data.getmanufacturername())
	 * .clickOnSpecificManufacturer(data.getmanufacturername())
	 * .clickOnsaveRules()
	 * .VerifySuccessMessagecatalog(data.getSubsetSuccessmsg())
	 * .clickOnSelectedLink()
	 * .verifySelectedManufacturer(data.getmanufacturername())
	 * .clickonRemoveMB(data.getmanufacturername()) .homePage()
	 * .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies item should be displayed under allitems tab"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_14")
	 * 
	 * @Test(groups="regression") public void verifyingtheItemInAllItems()
	 * throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .clickOnManufacturer()
	 * .selectAnManufacturer(data.getmanufacturername())
	 * .clickOnSpecificManufacturer(data.getmanufacturername())
	 * .clickOnsaveRules()
	 * .VerifySuccessMessagecatalog(data.getSubsetSuccessmsg())
	 * .clickOnRefreshCatalog() .verifySuccessMsg(data.getSubsetRuleSaveMsg())
	 * .verifyItemInAllItems(data.getPartNumberField()) .clickOnSelectedLink()
	 * .verifySelectedManufacturer(data.getmanufacturername())
	 * .clickonRemoveMB(data.getmanufacturername()) .clickOnRefreshCatalog()
	 * .homePage() .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies searching results in catalogbuilder page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_15")
	 * 
	 * @Test(groups="regression") public void
	 * verifySearchItemsInCatalogBuilder() throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1)
	 * .enterSearchkeyword(data.getPartNumberField()) .clickOnSearchButton()
	 * .verifySearchedResults(data.getPartNumberField()) .homePage()
	 * .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies searching results in catalogbuilder page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_16")
	 * 
	 * @Test(groups="test") public void addingItemsToAdditionalItemsTab() throws
	 * Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1)
	 * .enterSearchkeyword(data.getPartNumberField()) .clickOnSearchButton()
	 * .verifySearchedResults(data.getPartNumberField())
	 * .clickOnAdditionalItemsLink() .dragDropAnItem() .clickOnRefreshCatalog()
	 * .verifySuccessMsg(data.getSubsetRuleSaveMsg()) .clickOnRemoveItem()
	 * .VerifyItemRemoveSuccessMsg(data.getPartNumberField()) .homePage()
	 * .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies subset items page")
	 * 
	 * @TestCaseId("TC_Subset_18")
	 * 
	 * @Test(groups="regression") public void veririfySubsetItemsPage() throws
	 * Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage() .clickOnSubsetItemsLink(); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies item present in subset in Subset items page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_19")
	 * 
	 * @Test(groups="regression") public void verifyItemsInListOfSubset() throws
	 * Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage()) .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .clickOnManufacturer()
	 * .selectAnManufacturer(data.getmanufacturername())
	 * .clickOnSpecificManufacturer(data.getmanufacturername())
	 * .clickOnsaveRules()
	 * .VerifySuccessMessagecatalog(data.getSubsetSuccessmsg())
	 * .clickOnRefreshCatalog() .verifySuccessMsg(data.getSubsetRuleSaveMsg())
	 * .verifyItemInAllItems(data.getPartNumberField()) .homePage()
	 * .clickonSubsetlink() .subsetPage() .clickOnSubsetItemsLink()
	 * .selectSubset(data.getsubsetNamedata())
	 * .verifySubsetItems(data.getPartNumberField()) .homePage()
	 * .clickonSubsetlink() .subsetPage() .serchSubset(data.getsubsetNamedata())
	 * .clickOnSpecificCatelogBuilderButton(1) .clickOnSelectedLink()
	 * .verifySelectedManufacturer(data.getmanufacturername())
	 * .clickonRemoveMB(data.getmanufacturername()) .clickOnRefreshCatalog()
	 * .homePage() .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verified search fields in subset items page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_20")
	 * 
	 * @Test(groups="regression") public void
	 * verifySearchFieldsInSubsetItemsPage() throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage() .clickOnSubsetItemsLink() .verifySearchTemplate(); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies search fields in subset items page"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_21")
	 * 
	 * @Test(groups="regression") public void verifySearchInSubsetItemsPage()
	 * throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage() .clickOnSubsetItemsLink() .verifySearchTemplate(); }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies subset items page")
	 * 
	 * @TestCaseId("TC_Subset_22")
	 * 
	 * @Test(groups="regression") public void
	 * veririfyFeaturedProductsDispPricing() throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .clickOnFeaturedProductsDispPricingLink(data.getsubsetdisplayepricing());
	 * }
	 * 
	 * @Features("Subset Module")
	 * 
	 * @Description("This test case verifies saving the featured product display pricing"
	 * )
	 * 
	 * @TestCaseId("TC_Subset_23")
	 * 
	 * @Test(groups="regression") public void
	 * veririfySavingFeaturedProductsDispPricing() throws Exception{
	 * 
	 * @author:yogish.mt
	 * 
	 * landingPage() <<<<<<< HEAD .enterUsername(userName)
	 * .enterPassword(password) ======= .enterUsername(data.getUserName())
	 * .enterPassword(data.getPassword()) >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 .clickOnLogin() .homePage()
	 * .verifyWelcomeMessage(data.getwelcomeMessage()) .clickonSubsetlink()
	 * .subsetPage()
	 * .addNewSubset(data.getSubsetFormLabel(),data.getsubsetNamedata(),data.
	 * getSubsetDescription(),data.getpurpose(),data.getsubsetstatus(),data.
	 * getSubsetsuccessmessage())
	 * .clickOnFeaturedProductsDispPricingLink(data.getsubsetdisplayepricing())
	 * .clickSubsetCheckbox(data.getsubsetNamedata()) .clickOnSaveIcon()
	 * .verifyDisplayPriceSuccessMsg(data.getDiasplyPriceSucessMsg())
	 * .homePage() .clickonSubsetlink() .subsetPage()
	 * .specificSubsetDelete(data.getsubsetNamedata()); }
	 */
}