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
import org.framework.utils.TestUtility;
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
	TestUtility utility= new TestUtility(getDriver());
	HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public SubsetModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	

	

	
	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that verify subset page and Verification of search functionality for invalid keyword in Subset page and Verification of Add New Subset page")
	@TestCaseId("TC_Subset_001,TC_Subset_004, TC_Subset_005")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_001_004_005(String testCaseID, String headerList, String placeHolderText, String subsetName,String errorMessage, String addNewSubsetField) throws Exception
   {
		
		              landingPage()
		             .enterUsername(loginData.get("userName"))
		             .enterPassword(loginData.get("password"))
		             .clickOnLogin()
				     .homePage()
				     .clickOnSubset()
				     .subsetPage()
				     .verifyHeaderPartOfSubsetPage(headerList)
				     .verifySearchFieldOfSubsetPage(placeHolderText)
				     .searchForAnSubset(subsetName)
				     .clickOnSubsetSearchGoButton()
				     .verifySubsetPresent(subsetName)
				     .verifyErrorMessage(errorMessage)
				     .verifyAddNewSubsetButtonInSubsetpage()
				     .clickOnAddNewSubset()
				     .verifyAllAddNewSubsetFields(addNewSubsetField)
				     .verifySaveLinkInAddNewSubsetPage();

	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Click On Display sequence drop down and and select number of rows needed.")
	@TestCaseId("TC_Subset_002")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_002(String testCaseID) throws Exception {
		
		           data.setNumberOfRecordsToDisplay("10");
		                          landingPage()
		                         .enterUsername(loginData.get("userName"))
		                         .enterPassword(loginData.get("password"))
		                         .clickOnLogin()
				                 .homePage()
				                 .clickOnSubset()
				                 .subsetPage()
				                 .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				                 .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		          data.setNumberOfRecordsToDisplay("25");
		                        subsetPage()
		                       .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				               .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		          data.setNumberOfRecordsToDisplay("50");
		                       subsetPage()
		                       .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				               .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		         data.setNumberOfRecordsToDisplay("75");
		                        subsetPage()
		                      .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				              .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		         data.setNumberOfRecordsToDisplay("100");
		                      subsetPage()
		                     .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				             .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());

	}

	@Features(value = { "Subset/Catlog Module" })

	@Description("This is a Method that Validate of Subset Name field.")
	@TestCaseId("TC_Subset_007")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_007(String testCaseID, String subsetDescription, String requiredMessage)throws InterruptedException
	{
		                        landingPage()
		                        .enterUsername(loginData.get("userName"))
		                        .enterPassword(loginData.get("password"))
		                        .clickOnLogin()
				                .homePage()
				                .clickOnSubset()
				                .subsetPage()
				                .clickOnAddNewSubset()
				                .createSubsetWithoutMandatoryField(subsetDescription)
				                .verifySubsetNameIsRequired(requiredMessage);
	}

	@Features(value = { "Subset/Catlog Module" })
	@Description("This is a Method that Creates Subset, Verify of search functionality in Subset page,Verify edit subset page and verify  Subset details should be edited and should be saved in DB Successfully")
	@TestCaseId("")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_006_003_008_009(String testCaseID, String subsetName, String subsetDescription,String subsetSaveMessage, String editFieldOfSubset, String updatedSubsetName, String updateMessage)throws Exception
		{

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

	@Description("This is a Method that Verify Catalog Builder View page.")
	@TestCaseId("TC_Subset_10")
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
	@Description("This Test Case is to add Manufacturer and Brands under 'Catalog Builder View',Selected Manufacturer list should display along with fields,Manufacturer and Brand should be removed")
	@TestCaseId("TC_Subset_11,TC_Subset_12,TC_Subset_13")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_011_012_013(String testCaseID, String subsetName,String subsetDescription,String subsetSaveMessage, String manufacturerName, String brandName,String selectedTabField,String brandCount,String manufacturerCount,String messageOfCount)throws Exception 
	{
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
			  .addManufacturerAndBrand(manufacturerName, brandName)
			   .clickOnSaveRules()
			   .verifyManufacturerCountAndBrandCount(brandCount,manufacturerCount,messageOfCount)
			   .clickOnSelectedTab()
			   .verifySelectedTabField(selectedTabField)
			    .verifyBrandNameUnderSelectedTab(brandName)
			    .verifyManufacturerNameUnderSelectedTab(manufacturerName)
			    .verifySuccessMessageForDeletionOfBrand(brandName)
			    .verifySuccessMessageForDeletionOfManufacturer(manufacturerName);
			   
		   
		   String subsetId = homePage().clickOnSubset()
			        .searchForAnSubset(subsetName)
			       .clickOnSubsetSearchGoButton()
			       .verifyCreatedSubset(subsetName)
			        .verifyandDeleteSubset(subsetName);
	                 subsetPage()
	                .verifySuccessMessageForDeletionOfSubset(subsetName, subsetId);
	}

	

	
	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case verify that Item should displayed in the table Under the All Item Tab")
	@TestCaseId("TC_Subset_14")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_014(String testCaseID,String subsetName,String subsetDescription,String subsetSaveMessage,String manufacturerName,String brandName,String brandCount,String manufacturerCount,String messageOfCount,String noOfItem) throws InterruptedException, Exception
	{
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
			  .addManufacturerAndBrand(manufacturerName, brandName)
			   .clickOnSaveRules() 
			   .verifyManufacturerCountAndBrandCount(brandCount,manufacturerCount,messageOfCount)
			   .clickOnRefreshCatalog()
			   .verifyWetherCatalogRefreshed()
			   .verifyWhetherItemDisplayed(noOfItem);
	}
	
	
	@Features(value = { "Subset/Catlog Module" })
	@Description("Click on Additional Item tab and Verify the drag and dropped item should be saved and the item should display under 'All Items' tab ")
	@TestCaseId("TC_Subset_15,TC_Subset_16")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_015_016(String testCaseID,String subsetName,String subsetDescription,String subsetSaveMessage,String partNumber
			                        ,String msgAfterAdditionOfItem,String msgUnderAllTabAfterAdditionOfItem) throws InterruptedException, Exception
	{
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
		  .enterSearchkeyword(partNumber)
		  .clickOnSearchItemButton()
		  .verifySearchedItemResults(partNumber)
		  .clickOnAdditionalItemsLink()
		  .dragDropAnItem(partNumber)
		  .verifySuccessMsgAfterAdditionOfTem(msgAfterAdditionOfItem)
		  .clickOnRefreshCatalog()
		  .verifyWetherCatalogRefreshed()
		  .clickOnAllItemTab()
		  .verifyItemUnderAllItemTab(partNumber,msgUnderAllTabAfterAdditionOfItem);
		
	}
	
	
	
	
	@Features(value = { "Subset/Catlog Module" })
	@Description("Click on Excluded Item tab and Verify the drag and dropped item should be saved and the item should not display under 'All Items' tab")
	@TestCaseId("TC_Subset_17")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_017(String testCaseID,String subsetName,String subsetDescription,String subsetSaveMessage,String partNumber,String msgAfterAdditionOfItem,String msgUnderAllTabAfterDeletionOfItem) throws InterruptedException, Exception
			                        
	{
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
		  .enterSearchkeyword(partNumber)
		  .clickOnSearchItemButton()
		  .verifySearchedItemResults(partNumber)
		  .clickOnExcludedItemsLink()
		  . dragDropAnItem(partNumber) 
		  .verifySuccessMsgAfterAdditionOfTem(msgAfterAdditionOfItem)
		  .clickOnRefreshCatalog()
		  .verifyWetherCatalogRefreshed().clickOnAllItemTab().verifyItemUnderAllItemTab(msgUnderAllTabAfterDeletionOfItem);
		 
		  String subsetId = homePage().clickOnSubset()
			        .searchForAnSubset(subsetName)
			       .clickOnSubsetSearchGoButton()
			       .verifyCreatedSubset(subsetName)
			        .verifyandDeleteSubset(subsetName);
	                 subsetPage()
	                .verifySuccessMessageForDeletionOfSubset(subsetName, subsetId);
		
	}
	
	@Features(value = { "Subset/Catlog Module" })
	@Description("List Subset page should be display,verify Items assigned to subset should displayed,items search result should display based on field")
	@TestCaseId("TC_Subset_18,TC_Subset_19,TC_Subset_21")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_018_019_021(String testCaseID,String subsetName,String totalNoOfItem,String particularFieldName,String itemNumber,String noOfItemAfterSearch) throws InterruptedException, Exception
			                        
	{
		       landingPage()
              .enterUsername(loginData.get("userName"))
              .enterPassword(loginData.get("password"))
              .clickOnLogin()
		      .homePage()
		    .clickOnSubset()
		    .subsetPage()
		    .checkSubsetPage()
		    .clickOnSubsetItemsLink()
		    .subsetItem()
		    .checkSubsetPageItem()
		    .selectSubset(subsetName)
		    .verifyNumberOfItem(totalNoOfItem)
		    .selectParticularItemBasedOnTheDropDownField(particularFieldName)
		    .enterParticularNumberOfItem(itemNumber)
		    .clickOnSearchButtonOfSubsetItem()
		    .verifyNumberOfItem(noOfItemAfterSearch)
		    .verifyNumberOfItemAfterSearched(itemNumber);
	
	}
	
	@Features(value = { "Subset/Catlog Module" })
	@Description("Select the fields to search from the drop down")
	@TestCaseId("TC_Subset_20")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_020(String testCaseID,String dropDownFields) throws InterruptedException, Exception
	{
		 landingPage()
        .enterUsername(loginData.get("userName"))
        .enterPassword(loginData.get("password"))
        .clickOnLogin()
	      .homePage()
	    .clickOnSubset()
	    .subsetPage()
	    .checkSubsetPage()
	    .clickOnSubsetItemsLink()
	    .subsetItem()
	    .checkSubsetPageItem()
	    .verifyFieldsFromDropDown(dropDownFields);
	}
	
	@Features(value = { "Subset/Catlog Module" })
	@Description("This Test Case is to verify Featured Products Disp Pricing page should display")
	@TestCaseId("TC_Subset_22")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_022(String testCaseID,String subsetDisplayePricing) throws InterruptedException, Exception
	{
		      landingPage()
	        .enterUsername(loginData.get("userName"))
	        .enterPassword(loginData.get("password"))
	        .clickOnLogin()
		      .homePage()
		    .clickOnSubset()
		    .subsetPage()
		    .checkSubsetPage()
		    .clickOnFeaturedProductsDispPricingLink()
		    .featuredPricing()
		    .checkFeaturedProductsDispPricingPage(subsetDisplayePricing);
		   
	}
	@Features(value = { "Subset/Catlog Module" })
	@Description("Click on user subset name check box and verify success message")
	@TestCaseId("TC_Subset_23")
	@Test(groups = { "regression" }, dataProvider = "SubsetModuleTest", dataProviderClass = SearchData.class)
	public void tc_Subset_023(String testCaseID,String subsetDisplayePricing,String subsetName,String diasplyPriceSucessMsg) throws InterruptedException, Exception
	{
		        landingPage()
	        .enterUsername(loginData.get("userName"))
	        .enterPassword(loginData.get("password"))
	        .clickOnLogin()
		      .homePage()
		    .clickOnSubset()
		    .subsetPage()
		    .checkSubsetPage()
		    .clickOnFeaturedProductsDispPricingLink()
		    .featuredPricing()
		    .checkFeaturedProductsDispPricingPage(subsetDisplayePricing)
		    .clickSubsetCheckbox(subsetName)
		    .clickOnSaveIcon()
		    .verifyDisplayPriceSuccessMsg(diasplyPriceSucessMsg);
	}


}