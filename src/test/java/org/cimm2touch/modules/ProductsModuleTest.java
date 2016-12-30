package org.cimm2touch.modules;

import java.io.File;
import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.products.ProductsPageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;


 
public class ProductsModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	HashMap<String, String> loginData;
	Boolean deletionStatus=false;
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public ProductsModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}


		
	@Features(value = {"Products Module"})
	@Description("Verification of 'Products' page")
	@TestCaseId("TC_PRODUCTS_001")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_001(String breadCrumbsList) throws Exception{
	

		
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin();
		homePage()
		.clickOnProductsLink()
		.productsPage()
		.verifyTheProductsPageBreadCrumbs(breadCrumbsList.split(","))
		.verifyTotalCountInProductsPage()
		.verifySearchFieldInProductsPage()
		.verifyActionInProductsPage()
		.verifySlNoInProductsPage()
		.verifyProductImageInProductsPage()
		.verifyProductNameInProductsPage()
		.verifyProductNumberInProductsPage()
		.verifyProductDesc1InProductsPage()
		.verifyProductEditLinkInProductsPage()
		.verifyProductRemoveLinkInProductsPage()
		.verifyPreviewProductsItemsInProductsPage()
		.verifyAddNewProductLinkInProductsPage()
		.verifyDisplayRecordsInProductsPage();		
	}
	
	@Features(value = {"Products Module"})
	@Description("Verification of Add New Product tab.")
	@TestCaseId("TC_PRODUCTS_002")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_002(String allFieldsInAddNewProduct) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin();
		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.verifyAllFields(allFieldsInAddNewProduct.split(","));	
	}
	
	@Features(value = {"Products Module"})
	@Description("Verification of 'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_004")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_004(String productsTabNames ) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.clickOnFirstEditProduct()
		.editProductsPage()
		.verifyProductsPageTabs(productsTabNames.split(","));
	}

	@Features(value = {"Products Module"})
	@Description("Verification of 'General Info' tab in 'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_005")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_005(String generalInFoFieldNames) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.clickOnFirstEditProduct()
		.verifyFieldNamesInGeneralInfoTab(generalInFoFieldNames.split(","));
	}

	@Features(value = {"Products Module"})
	@Description("Verification of Product info Updation")
	@TestCaseId("TC_PRODUCTS_006")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_006(String productName, String productNumber,
			String successMessageProductCreation,String editProductName, String productUpdateSuccessMessage,
			String successMessageProductRemove) throws Exception{

			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

			homePage()
			.clickOnProductsLink()
			.productsPage()
			.clickOnAddNewProductLink()
			.enterProductName(productName)
			.enterProductNumber(productNumber)
			.clickOnProducSaveButtonLink()
			.verifyProductSavedSuccessMessage(successMessageProductCreation)
			.enterTheProductNameInSearchField(productName)
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(productName)
			.clickOnFirstEditProduct()
			.clearUpdateProductName()
			.enterUpdatedProductName(editProductName)
			.clickOnProductUpdateButtonLink()
			.verifyProductUpdateSavedSuccessMessage(productUpdateSuccessMessage);
			homePage()
			.clickOnProductsLink()
			.enterProductNameInSearchField(editProductName)
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(editProductName)
			.clickOnRemoveProduct()
			.alertToAccept();
	}
	
	@Features(value = {"Products Module"})
	@Description("Verification of 'Product Images' tab in 'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_007")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_007(String fieldNamesOfProductImagesTab) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnFirstEditProduct()
		.clickOnProductImagesTab()
		.verifyFieldNamesInProductImagesTab(fieldNamesOfProductImagesTab.split(","))
		.verifyProductImageCheckbox()
		.verifyAddNewProductImage();
	}
	
	@Features(value = {"Products Module"})
	@Description("Verification of 'Add New Product Image' page in edit product page")
	@TestCaseId("TC_PRODUCTS_008")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_008(String fieldNameProductImagesTab) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnFirstEditProduct()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.verifyFieldNamesInAddNewProductImage(fieldNameProductImagesTab.split(","))
		.verifySaveURLconInAddNewProductImage()
		.verifyResetIconInAddNewProductImage()
		.verifyORTextInAddNewProductImage()
		.verifyOverwriteImageTextInAddNewProductImage();
	}
	
	@Features(value = {"Products Module"})
	@Description("Verification of adding product image using image URL")
	@TestCaseId("TC_PRODUCTS_009")
	@Test(groups={"regression"}, dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
	public void TC_PRODUCTS_009(String productName, String productNumber,
			String successMessageProductCreation,String imageDescription, String productImageURL,String imageURLSuccessfulMessage,
			String successMessageProductRemove) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductName(productName)
		.enterProductNumber(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnFirstEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.enterImageDescField(imageDescription)
		.enterProductImageURLField(productImageURL)
		.clickOnSaveImageURLLink()
		.verifyImageURLSavedSuccessfulMessage(imageURLSuccessfulMessage)
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessMessageAfterDeletionProduct(successMessageProductRemove);	
	}
	

	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies adding product image using 'Upload Product Image")
	@TestCaseId("TC_PRODUCTS_010")
	@Test(groups={"regression"})
	public void verifyAddProductImageUsingUploadImage(String testCaseId, String productName,String productNumber, String successMessageProductCreation, String imageFilePath,
			String successMessageProductRemove) throws Exception{
		File file = new File(imageFilePath);
		//System.out.println(file.getAbsolutePath());

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductName(productName)
		.enterProductNumber(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnFirstEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.verifyFileUpload(file.getAbsolutePath())
		.clickOnUploadImageLink()
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessMessageAfterDeletionProduct(successMessageProductRemove);		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies removing the added product image")
	@TestCaseId("TC_PRODUCTS_011")
	@Test(groups={"regression"})
	public void verifyRemoveAddedProductImage(String testCaseId, String productName,String productNumber, String successMessageProductCreation, String imageDescription,
			String productImageURLField,String imageURLSuccessfulMessage,String successMessageProductRemove) throws Exception{

		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductName(productName)
		.enterProductNumber(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnFirstEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.enterImageDescField(imageDescription)
		.enterProductImageURLField(productImageURLField)
		.clickOnSaveImageURLLink()
		.verifyImageURLSavedSuccessfulMessage(imageURLSuccessfulMessage)
		.clickOnRemoveProductImage()
		.alertToAccept()
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductNameAfterSearchingIt(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessMessageAfterDeletionProduct(successMessageProductRemove);		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies Item List")
	@TestCaseId("TC_PRODUCTS_012")
	@Test(groups={"regression"})
	public void verifyItemListTab() throws Exception{

		landingPage()
		.enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin();
		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnFirstEditProduct()
		.editProductsPage()
		.clickOnItemListTab()
		.verifySearchIconLocator()
		.verifySearchForItemsListField()
		.verifyManufacturerDropDown()
		.verifyBrandDropDown()
		.verifySaveIcon()
		.verifyitemListTab();
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies assigned items to product")
	@TestCaseId("TC_PRODUCTS_013")
	@Test(groups={"regression"})
	public void verificationOfAssigningItemsToProduct(String testCaseId, String productName, String productNumber,
			String newProductCreationSuccesfulMessage, String expectedSuccessfulMessageAfterDeletionOfProduct) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(newProductCreationSuccesfulMessage)
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.cancelAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(expectedSuccessfulMessageAfterDeletionOfProduct);
	
	}

	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of alert message when remove icon is clicked in the product list page")
	@TestCaseId("TC_PRODUCTS_014")
	@Test(groups={"regression"})
	public void VerificationOfAlertMessage(String testCaseId, String productName, String productNumber,
			String newProductCreationSuccesfulMessage, String expectedSuccessfulMessageAfterDeletionOfProduct) throws InterruptedException, Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(newProductCreationSuccesfulMessage)
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.veryfyAlert()
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(expectedSuccessfulMessageAfterDeletionOfProduct);
			
	}

	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of creation and removing the product from the list")
	@TestCaseId("TC_PRODUCTS_015")
	@Test(groups={"regression"})
	public void verificationOfRemovingTheProductFromTheList(String testCaseId, String productName, String productNumber,
			String successMessageProductCreation,String editProductName, String successMessageProductRemove) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(successMessageProductCreation)
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(successMessageProductRemove);
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of cancel the alert")
	@TestCaseId("TC_PRODUCTS_016")
	@Test(groups={"regression"})
	public void verificationOfCancelTheAlert(String testCaseId, String productName, String productNumber,
			String successMessageProductCreation,String editProductName, String successMessageProductRemove) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(successMessageProductCreation)
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.cancelAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(successMessageProductRemove);
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of preview product's item page")
	@TestCaseId("TC_PRODUCTS_017")
	@Test(groups={"regression"})
	public void verificationOfPreviewProductsItems(String testCaseId, String productName, String expectedItemsPageTitle) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.clickOnEditItemIcon()
		.verifyItemsPage(expectedItemsPageTitle);
		
		
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of 'Edit Item' icon in product's item page")
	@TestCaseId("TC_PRODUCTS_018_019")
	@Test(groups={"regression"})
	public void verificationOfEditItemIconInProductItemsPage(String testCaseId, String productName, String expectedItemsTableHeaderTitles) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.verifyItemsTableHeaders(expectedItemsTableHeaderTitles.split(","));
		
		
		
		
		
		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification Copy of Item' icon in product's item page")
	@TestCaseId("TC_PRODUCTS_020")
	@Test(priority=1,groups={"regression"})
	public void verificationOfCopyOfItemIconInProductItemPage(String testCaseId, String productName, String itemPartNumber, String numberOfCopiesForItem) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.clickOnCopyIcon()
		.enterPartNumber(itemPartNumber)
		.enterNumerOfCopies(numberOfCopiesForItem)
		.clickOnsaveIconFoCopiedItem()
		.productsListPage().acceptAlert()
		.homePage().searchForCreatedItem(itemPartNumber)
		.itemsPage().verifyAndRemoveItem(itemPartNumber);
		
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification Delink of Item from products")
	@TestCaseId("TC_PRODUCTS_021")
	@Test(groups={"regression"})
	public void verificationOfEditIconInProductItemsPage(String testCaseId, String productName,String productNumber, String newProductCreationSuccesfulMessage, String expectedSuccessfulMessageAfterDeletionOfProduct) throws Exception{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(newProductCreationSuccesfulMessage)
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.editProductPage()
		.clickOnEditIcon()
		.clickOnItemsListTab()
		.dragAndDropTheItemsToProduct()
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterItemAssign(productName)
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickPreviewItemLink()
		.clickOnDelinkItemIcon()
		.acceptAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProductPresent(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(expectedSuccessfulMessageAfterDeletionOfProduct);
		
		
	}
	
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of 'Display Records' in Products page")
	@TestCaseId("TC_PRODUCTS_022")
	@Test(groups={"regression"})
	public void verifyDisplayOfNumberRecordsChosenInProductsPage() throws Exception
	{	
			data.setNumberOfRecordsToDisplay("10");
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			.homePage()
			.clickOnProductsLink()
			.productsListPage()
			.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
			.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
			data.setNumberOfRecordsToDisplay("25");
			productsListPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
			.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
			data.setNumberOfRecordsToDisplay("50");
			productsListPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
			.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
			data.setNumberOfRecordsToDisplay("75");
			productsListPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
			.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
			data.setNumberOfRecordsToDisplay("100");
			productsListPage().selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
			.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
	}

	
}
