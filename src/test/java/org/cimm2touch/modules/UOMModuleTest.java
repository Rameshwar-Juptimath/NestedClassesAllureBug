package org.cimm2touch.modules;

import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.TestUtility;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class UOMModuleTest extends PageFactoryInitializer {
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TestUtility utility= new TestUtility(getDriver());
	HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public UOMModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	
	
	@Features(value = {"UOM Module"})
	@Description("This is a test case which verifies 'UOM' page")
	@TestCaseId("TC_UOM_001")
	@Test(groups={"regression"}, dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_001(String testCaseId, String breadCrumbsList,String headerList, String placeHolderText) throws Exception{
		                    landingPage()
		                   .enterUsername(loginData.get("userName"))
		                   .enterPassword(loginData.get("password"))
		                   .clickOnLogin();
		                    homePage()                      
		                   .clickOnUomLink()
		                   .uomPage()
		                   .verifyTheUOMPageBreadCrumbs(breadCrumbsList)
		                   .verifySearchFieldInUOMPage(placeHolderText)
		                   .verifyTotalCountInUOMPage()
		                   .verifyTheUOMPageHeaderPortion(headerList)
		                   .verifyAddNewProductLinkInUOMPage()
		                   .verifyDisplayRecordsInUOMPage();
	

}
	
	@Features(value = {"UOM Module"})
	@Description("This is a test case which verifies all the fields in Add New Product tab.")
	@TestCaseId("TC_UOM_002")
	@Test(groups={"regression"}, dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_002(String testCaseId,String addNewUOMField  ) throws Exception
	{
		                landingPage()
		                .enterUsername(loginData.get("userName"))
		                .enterPassword(loginData.get("password"))                
		                .clickOnLogin();
		                 homePage()
		                .clickOnUomLink()
		                .uomPage()
		                .clickOnAddNewUOMLink()
		                .verifyAllAddNewUOMFields(addNewUOMField);
	}
	@Features(value = {"UOM Module"})
	@Description("Creation of new UOM and Verification of 'Search field' for valid UOM")
	@TestCaseId("TC_UOM_003,TC_UOM_007")
	@Test(groups={"regression"},dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_003_007(String testCaseId, String userName, String password,String welComeMessage,String uomName, String uomDescription, String uomSaveMessage) throws Exception
	{
		                  landingPage()
		                 .enterUsername(userName)
		                 .enterPassword(password)
		                 .clickOnLogin();
			              homePage()
		                .verifyWelcomeMessage(welComeMessage)
		                .clickOnUomLink()
		                .uomPage()
		                .searchForUOM(uomName)
		                .clickOnUomSearchCategory()
		                .verifyUomPresent(uomName)
		                .createUom(uomName,uomDescription)
		                .verifySuccessMessage(uomSaveMessage)
		                .searchForUOM(uomName)
		                .clickOnUomSearchCategory()
		                .verifyCreatedUom(uomName);
	}
	
	
	
	@Features(value = {"UOM Module"})

	@Description("Verification of 'Edit UOM' Form and Verification of updating UOM info and Verification of revision history icon and Verification of revision history icon")

	@TestCaseId("TC_UOM_005,TC_UOM_010")
	@Test(groups={"regression"}, dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_004_005_009_010(String testCaseId,String uomName,String uomDescription,String uomSaveMessage,String  editFieldOfUOM,String updatedUomName,String welcomeMessage,String alertTextWhenHistoryIsClicked,String expectedHistoryPageTitle  ) throws Exception
	{
		            landingPage()
		           .enterUsername(loginData.get("userName"))
		           .enterPassword(loginData.get("password"))
		           .clickOnLogin();
		            homePage()
		           .clickOnUomLink()
		           .uomPage()
		           .searchForUOM(uomName)
		           .clickOnUomSearchCategory()
		           .verifyUomPresent(uomName)
		           .createUom(uomName,uomDescription)
		           .verifySuccessMessage(uomSaveMessage)
		           .searchForUOM(uomName)
		          .clickOnUomSearchCategory()
		           .verifyCreatedUom(uomName)
		          .clickOnEditUom(uomName)
         
		          .verifyAllEditUOMFields(editFieldOfUOM)
		          .verifyWhetherHistoryIconPresent()
		          

		          .createUpdatedUom(updatedUomName)
		          .clickOnUpdateUomLink()
		          .verifyUpdateWelcomeMessage(welcomeMessage)
		         .searchForUOM(updatedUomName)
		         .clickOnUomSearchCategory() 
		         .verifyCreatedUom(updatedUomName)
		         .clickOnEditUom(updatedUomName)
		         .clickOnUomHistoryLink()    
		         .verifyAlertMsg(alertTextWhenHistoryIsClicked)
		         .historyPage()
		        .verifyPageTitle(expectedHistoryPageTitle)
		        .verifyUpdatedUomNamePresentInHistoryPage(updatedUomName);
	}
	
	
	@Features(value = {"UOM Module"})
	@Description("This is a test case which verifies display of records per page based on the filter chosen. 25,50,75,100 are the filter values.")
	@TestCaseId("TC_UOM_006")
	@Test(groups={"regression"}, dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_006(String testCaseId ) throws Exception
	{
		
		           data.setNumberOfRecordsToDisplay("10");
		           landingPage()
		          .enterUsername(loginData.get("userName"))
		          .enterPassword(loginData.get("password"))
		          .clickOnLogin()
		          .homePage()
		          .clickOnUomLink()
		          .uomPage()
		          .selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		          .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		           data.setNumberOfRecordsToDisplay("25");
		           uomPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		          .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		           data.setNumberOfRecordsToDisplay("50");
		           uomPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())     
		           .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		           data.setNumberOfRecordsToDisplay("75");
		           uomPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		          .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		           data.setNumberOfRecordsToDisplay("100");
		           uomPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
		           .verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	}
	
	@Features(value = {"UOM Module"})
	@Description("Verification of 'Search field' for invalid UOM")
	@TestCaseId("TC_UOM_008")
	@Test(groups={"regression"}, dataProvider="UOMModuleTest",dataProviderClass=SearchData.class)
	public void tc_UOM_008(String testCaseId,String uomName,String countOfUomName,String errorMessage) throws InterruptedException
	{
		         landingPage()
		        .enterUsername(loginData.get("userName"))
		        .enterPassword(loginData.get("password"))
		        .clickOnLogin();
		         homePage()
		       .clickOnUomLink()
		       .uomPage()
		       .searchForUOM(uomName)
		       .clickOnUomSearchCategory()
		       .verifyUomPresent(uomName)
		       .verifyErrorTotalCount(countOfUomName)
		       .verifyErrorMessage(errorMessage);
}

	
	
	
	
}
