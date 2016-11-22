package org.cimm2touch.modules;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
/**
 * 
 * @author thiruveedhi Chinna
 *
 */
public class RemoveDataConfigTest extends PageFactoryInitializer{
	@Features("RemoveDataConfig Module")
	@Description("delete the created item(s)")
	@Test(priority=0,groups="regression",dataProvider ="RemoveDataConfigTest", dataProviderClass=SearchData.class)
	public void deleteCreatedItem(String testCaseId, String userName, String password, String welcomeMessage, String partNumber, String expSuccesfulMessageForDeletion, String noOfItemsToBeDelete) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage);
		homePage()
		.clickOnItemsLink();
		itemsPage()
		.typeinadvancedSearchTopSearchField(partNumber)
		.clickOnbottomSeacrhButton()
		.verifyAndRemoveCreatedItem(partNumber,noOfItemsToBeDelete);
		
		
	}
	@Features("RemoveDataConfig Module")
	@Description("delete the created subset")
	@Test(priority=1,groups="regression",dataProvider ="RemoveDataConfigTest", dataProviderClass=SearchData.class)
	public void deleteCreatedSubset(String testCaseId, String userName, String password, String welcomeMessage,String subsetName) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonSubsetlink();
		String subsetId=subsetPage()
		.searchForAnSubset(subsetName)
		.verifyandDeleteSubset(subsetName);
		subsetPage()
		.verifySuccessMessageForDeletionOfSubset(subsetName,subsetId);
		
		
	}
	@Features("RemoveDataConfig Module")
	@Description("delete the created Brand")
	@Test(priority=2,groups="regression",dataProvider ="RemoveDataConfigTest", dataProviderClass=SearchData.class)
	public void deleteCreatedBrand(String testCaseId, String userName, String password, String welcomeMessage,String manufacturerName,String brandName) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.clickOnlisticon()
		.verifyAndRemoveBrand(brandName);
	
	}
	@Features("RemoveDataConfig Module")
	@Description("delete the created manufacturer")
	@Test(priority=3,groups="regression",dataProvider ="RemoveDataConfigTest", dataProviderClass=SearchData.class)
	public void deleteCreatedManufactures(String testCaseId, String userName, String password, String welcomeMessage,String manufacturerName,String brandName, String successMessage) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickonManufactureBrandsLink()
		.manufacturersAndBrandsPage()
		.assrtManufacturerbrandtextLocator()
		.typeonMBsearch(manufacturerName)
		.clickonMBsearch()
		.removeAndVerifyManufacturer(manufacturerName)
		.verifySuccessMessageAfterRemove(successMessage);
	}
	@Features("RemoveDataConfig Module")
	@Description("delete the created vendor")
	@Test(priority=4,groups="regression",dataProvider ="RemoveDataConfigTest", dataProviderClass=SearchData.class)
	public void deleteCreatedVendor(String testCaseId, String userName, String password, String welcomeMessage,String title,String vendorName) throws Exception{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.checkVendorPage(title)
		.typeVendorNameInSearch(vendorName)
		.verifyAndRemoveVendore(vendorName)
		.verifySuccessMessageForRemove(vendorName);
	}
	@Features(value = {"RemoveDataConfig Module"})
	@Description(" remove Categoryies {0}")
	@Test(priority=5, groups={"regression"},dataProvider="RemoveDataConfigTest",dataProviderClass=SearchData.class)
	public void removeCategories(String testCaseNo, String userName, String password, String welcomeMessage,String taxonomy, String categoryName, String expSuccessMsgForRemoveCategory, String noOfCategories) throws Exception
	{
		landingPage()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLogin()
		.homePage()
		.verifyWelcomeMessage(welcomeMessage)
		.clickOnTaxonomyLink()
		.taxonomyPage()
		.searchForTaxonomy(taxonomy)
		.verifyTaxonomyPresent(taxonomy)
		.clickOnManageTaxonomy()
		.manageTaxonomyPage()
		.verifyLeftPanelTaxonomyName(taxonomy)
		.removeCreatedCategory(categoryName,noOfCategories,expSuccessMsgForRemoveCategory);
}

}
