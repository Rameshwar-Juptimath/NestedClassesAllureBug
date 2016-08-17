package org.cimm2touch.modules;


import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.PropertyFileReader;
import org.cimm2touch.utils.RandomNumberGenerator;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.openqa.selenium.support.FindAll;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

	

public class ManufacturerBrandModuleTest extends PageFactoryInitializer {

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	ItemsModuleTest createItemNew = new ItemsModuleTest();

	@Features("Create Manufacturers")
	@Description("This a test case which creates Manufacturers")
	@Test(groups="regression",priority=1)
	public void create_Manufacturer() throws Exception {
		/*
		 * @author:yogish.mt
		 */
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.clickOnManufacturerAndBrands()
		.manufacturerPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.getmanufacturername1())
		.clickonMBsearch()
		.manufacturerSearchResult(data.getmanufacturername1())
		.homePage().clickOnManufacturerAndBrands().manufacturerPage()
		.assrtManufacturerbrandtextLocator()
		.clickonmanufacturerbutton()
		.typeinmanufield(data.getmanufacturername1())
		.typeinmanucodefield(data.getmanufacturername1())
		.checkmanufactureractive()
		.clickonmanufacturersave()
		.verifymessage(data.getmanufacturername1()+" "+data.getmanufacturerSuccessmessage());
		}

	@Features("Create Brand Under Manufacturer")
	@Description("This a test case which creates Brand under a Manufacturer")
	@Test(groups="regression",priority=2)
	public void createBrand() throws Exception {

		/*
		 * @author:yogish.mt
		 */
		
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(data.getwelcomeMessage())
		.homePage()
		.clickOnManufacturerAndBrands()
		.manufacturerPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(data.getmanufacturername1())
		.clickonMBsearch()
		.checkManufacturerAlreadyExist(data.getmanufacturername1())
		.clickOnlisticon()
		.isBrandpresent(data.getBrnadName())
		.clickOnaddnewbrandbutton()
		.checkBrandFormEnabled()
		.selectmanufacturerfromdropdown(data.getmanufacturername1())
		.typeinbrandname(data.getBrnadName())
		.typeinBrandDescField(data.getbrandDesc())
		.checkOnBrandActive().checkOnItemActive()
		.clickonbrandsave()
		.checkBrandSaveMessage(data.getbrandsavemsg());			
	}
	
	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies validity of manufacturer name field, creation of new manufacturer and search of new manufacturer and deletion of the same")
	@TestCaseId("TC_MB_2,TC_MB_3,TC_MB_7,TC_MB_8")
	@Test(groups = {"regression"})
	public void createManufacturer() throws Exception {
		

/*
 * @author:Ashray Ramesh
 * 
 */
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnAddNewManufacturerButton()
				.clickOnSaveButton()
				.verifyUnsuccessfullMessage(data.getunsuccessfullMessageOfManufacturerSave())
				.enterNewManufacturerNames(data.getmanufacturerNewName())
				.clickOnSaveButton()
				.verifySuccessMessageNewManuCreation(data.getmanufacturerNewName())
				.enterCreatedManufacturerToDelete(data.getcreatedManufacturerToDelete())
				.clickOnSearchManufacturerList()
				.clickOnDeleteManufacturerButton()
				.verifyAlertText(data.getAlertTextToDeleteManufacturer())
				.verifyManufacturerDeletion();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies no results for non-existing manufacturer search")
	@TestCaseId("TC_MB_9")
	@Test(groups = {"regression"})
	public void searchManufacturerNoResultsFound() throws Exception {
		

/*
 * @author:Ashray Ramesh
 * 
 */
				landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.enterCreatedManufacturerToDelete(Integer.toString(RandomNumberGenerator.generateEightRandomNumbers()))
				.clickOnSearchManufacturerList()
				.verifyZeroManufacturersFound();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies the pagination for manufacturer and brands page")
	@TestCaseId("TC_MB_10, TC_MB_11,TC_MB_12,TC_MB_13")
	@Test(groups = {"regression"})
	public void clickOnNavigation() throws Exception{

/*
 * @author:Ashray Ramesh
 * 
 */
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnNextButton();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies all the fields are present after clicking on add manufacturer")
	@TestCaseId("TC_MB_1")
	@Test(groups = {"regression"})
	public void verifyAllFieldsPresent() throws Exception{

/*
 * @author:Ashray Ramesh
 * 
 */
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnAddNewManufacturerButton()
				.clickOnSaveButton()
				.clickOnResetButton()
				.clickOnNewManufacturerName()
				.clickOnManufacturerCode();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which verifies all the fields are present in the table of the manufacturers page ")
	@TestCaseId("TC_MB_5")
	@Test(groups = {"regression"})
	public void verifyAllFieldsPresentInTable() throws Exception{

/*
 * @author:Ashray Ramesh
 * 
 */
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnAction()
				.clickOnSiNumber()
				.clickOnManufacturerName()
				.clickOnNumberOfBrands()
				.enterCreatedManufacturerToDelete(data.getcreatedManufacturerToDelete());
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_14")
	@Test(groups = {"regression"})
	public void verifyGenericColumnSettings() throws Exception{

/*
 * @author:Ashray Ramesh
 * 
 */
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnGenericColumnnSettings()
				.verifyShowFieldsText()
				.verifySortOrderText();
	}



	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_15")
	@Test(groups = {"regression"})
	public void verifyShowFieldsFields() throws Exception{
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnGenericColumnnSettings()
				.clickOnShowFieldsText()
				.verifyDynamicSettingsField()
				.verifyFieldNamesField()
				.verifyDesktopViewField()
				.verifyMobileViewField()
				.verifyTabletViewField()
				.verifyDisplayNamesField();
	}


	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case which generic column settings button and the options Show Fields and Sort Order")
	@TestCaseId("TC_MB_4")
	@Test(groups = {"regression"})
	public void verifyResetButton() throws Exception {
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnAddNewManufacturerButton()
				.enterNewManufacturerNames(data.getmanufacturerNewName())
				.clickOnResetButton()
				.verifyEmptyFieldAfterReset();
	}

	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case to display fields in manufacturer list page")
	@TestCaseId("TC_MB_16, TC_MB_17, TC_MB_18")
	@Test(groups = {"regression"})
	public void viewSelectedFieldInManufacturerList() throws Exception {
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnGenericColumnnSettings()
				.clickOnShowFieldsText()
				.clickOnManufacturerLogoCheckBox()
				.clickOnSaveFields()
				.verifyManufacturerLogoPresent()
				.clickOnGenericColumnnSettings()
				.clickOnShowFieldsText()
				.clickOnManufacturerLogoCheckBox()
				.clickOnSaveFields()
				.clickOnGenericColumnnSettings()
				.clickOnShowFieldsText()
				.clickOnCancelButton();
	}

	@Features(value = {"manufacturer and brands Module"})
	@Description("This is a test case to display fields in manufacturer list page")
	@TestCaseId("TC_MB_19, TC_MB_20, TC_MB_21")
	@Test(groups = {"regression"})
	public void viewSortOrderSettings() throws Exception {
		landingPage()
				.enterUsername(data.getUserName())
				.enterPassword(data.getPassword())
				.clickOnLogin()
				.homePage()
				.clickOnManufacturerAndBrands()
				.manufacturerPage()
				.clickOnGenericColumnnSettings()
				.clickOnSortOrder()
				.clickOnAddNewSortOrder()
				.enterSortFieldName(data.getSortFieldName())
				.enterDescendingOrder(data.getDescendingOrderText())
				.clickOnSaveSortOrder()
				.clickOnGenericColumnnSettings()
				.clickOnSortOrder()
				.clickOnDeleteSortOrder()
				.clickOnCloseSortOrder();

	}


}


