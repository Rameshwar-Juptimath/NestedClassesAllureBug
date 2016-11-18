/*package org.cimm2touch.modules;

import java.io.File;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;


 * @author:Anusha.Y
 * 
 
public class ProductsModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginObj = new LoginModuleTest();
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies 'Products' page")
	@TestCaseId("TC_PRODUCTS_001")
	@Test(groups={"regression"})
	public void verifyProductsPage() throws Exception{
	

		landingPage().loginToCimm2v4Site().

	
		homePage()
		.clickOnProductsLink()
		.productsPage()
		.verifyTheProductsPageBreadCrumbs()
		.verifyTotalCountInProductsPage()
		.verifySearchFieldInProductsPage()
		.verifyActionInProductsPage()
		.verifySiNoInProductsPage()
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
	@Description("This is a test case which verifies all the fields in Add New Product tab.")
	@TestCaseId("TC_PRODUCTS_002")
	@Test(groups={"regression"})
	public void verifyAddNewProductFields(String allFieldsInAddNewProduct) throws Exception{

		landingPage().loginToCimm2v4Site().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.verifyAllFields(allFieldsInAddNewProduct.split(","));//data.getAllFieldsAddNewProductsPage().split(","));	
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies Adding New Product.")
	@TestCaseId("TC_PRODUCTS_003")
	@Test(groups={"regression"})
	public void verifyAddingNewProduct(String productName,String productNumber, String productDescription1, String productDescription2, 
			String productFeatures,String  productMarketingDescription, String productCustomKeywords, String successMessageProductCreation, String successMessageProductRemove ) throws Exception {
	

		landingPage().loginToCimm2v4Site().

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductNameField(productName)
		.enterProductNumberField(productNumber)
		.enterProductDescription1Field(productDescription1)//data.getProductDescription1Field())
		.enterProductDescription2Field(productDescription2)//data.getProductDescription2Field())
		.enterProductFeaturesField(productFeatures)
		.enterProductMarketingDescriptionField(productMarketingDescription)
		.enterProductCustomKeywordsField(productCustomKeywords)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessfulMessage(successMessageProductCreation)
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessfulMessageAfterDeletionProduct(successMessageProductRemove);
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies click on edit icon of any product.")
	@TestCaseId("TC_PRODUCTS_004")
	@Test(groups={"regression"})
	public void verifyEditProductPage() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.clickOnEditProduct()
		.editProductsPage()
		.verifyProductsPageTabs();
	}

	
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies assigned items to product")
	@TestCaseId("TC_PRODUCTS_013")
	@Test(groups={"regression"})
	public void verificationOfAssigningItemsToProduct() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.cancelAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
	
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of alert message when remove icon is clicked in the product list page")
	@TestCaseId("TC_PRODUCTS_014")
	@Test(groups={"regression"})
	public void VerificationOfAlertMessageWhenRemoveIconIsClickedInTheProductListPage() throws InterruptedException, Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.veryfyAlert()
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
			
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies 'General Info' tab in  'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_005")
	@Test(groups={"regression"})
	public void verifyGeneralInfoInEditProductPage() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnGeneralInfoTab()
		.verifyFieldNamesInGeneralInfoTab();
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies update product info in  'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_006")
	@Test(groups={"regression"})
	public void verifyUpdateProductInfo() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductNameField(productName)
		.enterProductNumberField(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessfulMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnEditProduct()
		.editProductsPage()
		.editProductNameField(data.getEditProductNameField())
		.clickOnProducUpdateButtonLink()
		.verifyProductUpdateSavedSuccessfulMessage(data.getProductUpdateSuccessfulMessage())
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheUpdateProductNameInSearchField(data.getUpdateProductNameField())
		.clickOnSearchButton()
		.verifyUpdateProduct(data.getUpdateProductNameField())
		.clickOnRemoveUpdateProduct()
		.alertToAccept()
		.verifySuccessfulMessageAfterDeletionProduct(successMessageProductRemove);
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies Product Images tab in  'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_007")
	@Test(groups={"regression"})
	public void verifyProductImagesTab() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.verifyFieldNamesInProductImagesTab()
		.verifyProductImageCheckbox()
		.verifyAddNewProductImage();
		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies Add New Product Image in  'Edit Product' page")
	@TestCaseId("TC_PRODUCTS_008")
	@Test(groups={"regression"})
	public void verifyAddNewProductImage() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.verifyFieldNamesInAddNewProductImage()
		.verifySaveURIconInAddNewProductImage()
		.verifyResetIconInAddNewProductImage()
		.verifyORTextInAddNewProductImage()
		.verifyOverwriteImageTextInAddNewProductImage();
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies adding product image using image URL")
	@TestCaseId("TC_PRODUCTS_009")
	@Test(groups={"regression"})
	public void verifyAddProductImageUsingURL() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductNameField(productName)
		.enterProductNumberField(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessfulMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.enterImageDescField(data.getImageDescField())
		.enterProductImageURLField(data.getProductImageURLField())
		.clickOnSaveImageURLLink()
		.verifyImageURLSavedSuccessfulMessage(data.getimageURLSuccessfulMessage())
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessfulMessageAfterDeletionProduct(successMessageProductRemove);	
	}
	

	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of creation and removing the product from the list")
	@TestCaseId("TC_PRODUCTS_015")
	@Test(groups={"regression"})
	public void verificationOfRemovingTheProductFromTheList() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of cancel the alert")
	@TestCaseId("TC_PRODUCTS_016")
	@Test(groups={"regression"})
	public void verificationOfCancelTheAlert() throws Exception{
		landingPage().loginToCimm2v4Site()
		
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.cancelAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of preview product's item page")
	@TestCaseId("TC_PRODUCTS_017")
	@Test(groups={"regression"})
	public void verificationOfPreviewProductsItems() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.clickOnEditItemIcon()
		.verifyItemsPage(data.getExpectedItemsPageTitle())
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
		
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of 'Edit Item' icon in product's item page")
	@TestCaseId("TC_PRODUCTS_018_019")
	@Test(groups={"regression"})
	public void verificationOfEditItemIconInProductItemsPage() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.verifyItemsTableHeaders(data.getExpectedItemsTableHeaderTitles())
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
		
		
		
		
		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification Copy of Item' icon in product's item page")
	@TestCaseId("TC_PRODUCTS_020")
	@Test(priority=1,groups={"regression"})
	public void verificationOfCopyOfItemIconInProductItemPage() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickPreviewItemLink()
		.productItemPage()
		.clickOnCopyIcon()
		.enterPartNumber(itemPartNumber)
		.enterNumerOfCopies(data.getNumberOfCopiesForItem())
		.clickOnsaveIconFoCopiedItem()
		.productsListPage().acceptAlert()
		.homePage().searchForCreatedItem(itemPartNumber)
		.itemsPage().verifyAndRemoveItem(itemPartNumber)
		.homePage().clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
		
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification Delink of Item from products")
	@TestCaseId("TC_PRODUCTS_021")
	@Test(groups={"regression"})
	public void verificationOfEditIconInProductItemsPage() throws Exception{
		landingPage().loginToCimm2v4Site()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.clickOnPlusSymbolToCreateProduct()
		.addNewProductPage()
		.enterTheProductName(productName)
		.enterTheProductNumber(productNumber)
		.clickOnSaveButton()
		.verifySuccesfulMessageAfterCreationOfNewProduct(data.getNewProductCreationSuccesfulMessage())
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
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
		.verifyProduct(productName)
		.clickPreviewItemLink()
		.clickOnDelinkItemIcon()
		.acceptAlert()
		.homePage()
		.clickOnProductsLink()
		.productsListPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct(productName)
		.acceptAlert()
		.verifySuccessfulMessageAfterDeletion(data.getExpectedSuccessfulMessageAfterDeletionOfProduct());
		
		
	}
	@Features(value = {"Products Module"})
	@Description("This is a test case which gives Verification of 'Display Records' in Products page")
	@TestCaseId("TC_PRODUCTS_022")
	@Test(groups={"regression"})
	public void verifyDisplayOfNumberRecordsChosenInProductsPage() throws Exception{
	data.setNumberOfRecordsToDisplay("10");
	landingPage().loginToCimm2v4Site()
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

	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies adding product image using 'Upload Product Image")
	@TestCaseId("TC_PRODUCTS_010")
	@Test(groups={"regression"})
	public void verifyAddProductImageUsingUploadImage() throws Exception{
		File file = new File(data.getImageFilePath());
		System.out.println(file.getAbsolutePath());

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductNameField(productName)
		.enterProductNumberField(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessfulMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnEditProduct()
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
		.verifyProduct(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessfulMessageAfterDeletionProduct(successMessageProductRemove);		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies removing the added product image")
	@TestCaseId("TC_PRODUCTS_011")
	@Test(groups={"regression"})
	public void verifyRemoveAddedProductImage() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnAddNewProductLink()
		.enterProductNameField(productName)
		.enterProductNumberField(productNumber)
		.clickOnProducSaveButtonLink()
		.verifyProductSavedSuccessfulMessage(successMessageProductCreation)
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnProductImagesTab()
		.clickOnAddNewProductImage()
		.enterImageDescField(data.getImageDescField())
		.enterProductImageURLField(data.getProductImageURLField())
		.clickOnSaveImageURLLink()
		.verifyImageURLSavedSuccessfulMessage(data.getimageURLSuccessfulMessage())
		.clickOnRemoveProductImage()
		.alertToAccept()
		.homePage()
		.clickOnProductsLink()
		.productsPage()
		.enterTheProductNameInSearchField(productName)
		.clickOnSearchButton()
		.verifyProduct(productName)
		.clickOnRemoveProduct()
		.alertToAccept()
		.verifySuccessfulMessageAfterDeletionProduct(successMessageProductRemove);		
	}
	
	@Features(value = {"Products Module"})
	@Description("This is a test case which verifies Item List")
	@TestCaseId("TC_PRODUCTS_012")
	@Test(groups={"regression"})
	public void verifyItemListTab() throws Exception{

		landingPage().loginToCimm2v4Site().

		

		homePage()
		.clickOnProductsLink()
		.productsPage()
		.clickOnEditProduct()
		.editProductsPage()
		.clickOnItemListTab()
		.verifySearchIconLocator()
		.verifySearchForItemsListField()
		.verifyManufacturerDropDown()
		.verifyBrandDropDown()
		.verifySaveIcon()
		.verifyitemListTab();
	}
	
}
*/