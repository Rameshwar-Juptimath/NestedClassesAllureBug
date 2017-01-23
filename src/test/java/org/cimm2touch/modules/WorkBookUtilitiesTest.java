package org.cimm2touch.modules;

import java.util.Hashtable;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class WorkBookUtilitiesTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	Hashtable<String, String> creationData=new Hashtable<String,String>();
	
	final static String workBookUtilitiesDependent="WorkBookUtilitiesDependent";
	final static String workBookUtilitiesCreation="WorkBookUtilitiesCreation";
	
	@Test(groups = {"regression"})
	public class IndependentMentods extends PageFactoryInitializer{
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Workbook Utilities' page")
		@TestCaseId("TC_WU_001")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_001(String tabsList) throws Exception{
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.verifyAllTabs(tabsList);
		}
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of Fields in 'Workbook' tab")
		@TestCaseId("TC_WU_002")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_002(String fieldsList) throws Exception{
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin();
			homePage()
			.clickOnWorkbookUtilitiesLink()
			.verifyAllWorkBookFieldHeaders(fieldsList)
			.verifyItemsInWorkbookDropDown();
		}
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Edit Workbook Name' functionality")
		@TestCaseId("TC_WU_003")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_003(String workBookName,String workBookCreationSuccessMsg, String updatedWorkbookName) throws Exception{
			workBookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);	
			updatedWorkbookName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnAddNewWorkbookButton()
			.enterWorkbookName(workBookName)
			.clickOnSaveWorkbookButton()
			.verifyWorkbookCreationSuccessMessage(workBookName,workBookCreationSuccessMsg)
			.clickOnEditWorkbookButton(workBookName)
			.enterWorkbookName(updatedWorkbookName)
			.clickOnSaveWorkbookButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyWorkbookCreationSuccessMessage(updatedWorkbookName,workBookCreationSuccessMsg)
			.clickOnRemoveButtonOfWorkbook(updatedWorkbookName)
			.acceptAlert()
			.verifyWorkbookNameNotPresentInDropDown(updatedWorkbookName);
		}
	
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of alert message when 'Save' icon is clicked without entering workbook name")
		@TestCaseId("TC_WU_004")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_004(String saveBlankWorkBookErrorMsg) throws Exception{
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnAddNewWorkbookButton();
			Thread.sleep(4000);
			workBookUtilitiesPage()
			.clickOnSaveWorkbookButton()
			.verifyBlankWorkbookErrorMessage(saveBlankWorkBookErrorMsg);
		}
	
	}
	
	@Test(groups={"regression", workBookUtilitiesCreation})
	public class WorkBookUtilitiesCreation extends PageFactoryInitializer{

		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Add New Work Book' functionality")
		@TestCaseId("TC_WU_006")
		public void TC_WU_006() throws Exception{
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnAddNewWorkbookButton()
			.enterWorkbookName(data.getWorkbookName())
			.clickOnSaveWorkbookButton()
			.verifyWorkbookCreationSuccessMessage(data.getWorkbookName(),data.getWorkbookCreationSuccessMsg());
		}
	
	}
	
	@Test(groups = { "regression",workBookUtilitiesDependent })//,dependsOnGroups= {workBookUtilitiesCreation})
	public class WorkBookUtilitiesCreationDependent extends PageFactoryInitializer {
		
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'Reset' functionality")
		@TestCaseId("TC_WU_005")
		public void TC_WU_005() throws Exception{
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnEditWorkbookButton(data.getWorkbookName())
			.enterWorkbookName(data.getWorkbookName()+new RandomGenerator().randomAlphabetic(6))
			.clickOnResetButton();
			Thread.sleep(5000);
			workBookUtilitiesPage()
			.verifyWorkbookNameAfterReset(data.getWorkbookName());
		}
	
		@Features(value = {"Workbook Utitlites Module"})
		@Description("Verification of 'List items in this workbook' functionality")
		@TestCaseId("TC_WU_007")
		@Test(dataProvider="WorkbookUtilitiesModuleTest",dataProviderClass=SearchData.class)
		public void TC_WU_007(String itemListHeaders) throws Exception{
			
			landingPage().enterUsername(data.getUsername()).enterPassword(data.getPassword()).clickOnLogin()
			.clickOnWorkbookUtilitiesLink()
			.clickOnEditWorkbookButton(data.getWorkbookName())
			.clickOnListItemsInWorkbookButton(data.getWorkbookName())
			.verifyAllItemListHeaders(itemListHeaders);
		}
	}
		
	@Test(groups={"regression"},dependsOnGroups = {workBookUtilitiesDependent},alwaysRun=true)
	public class WorkBookUtilitiesRemoval extends PageFactoryInitializer{

	}
		

}
