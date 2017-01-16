package org.cimm2touch.modules;

import java.io.File;
import java.util.Hashtable;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;


 
public class ProductsModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	Hashtable<String, String> loginData;
	Hashtable<String, String> creationData;
	
	final static String productCreationDependent="ProductCreationDependent";
	final static String productCreation="ProductCreation";
	
	@Factory(dataProvider="ProductCreationTest", dataProviderClass=SearchData.class)
	public ProductsModuleTest(String userName, String password, String welcomMessage, String productName, String productNumber, String successMessageProductCreation,
			String prodcutSearchErrorMessage){
		loginData=new Hashtable<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
		
		creationData=new Hashtable<String, String>();
		creationData.put("productName", productName);
		creationData.put("productNumber", productNumber+new RandomGenerator().random(6, PermittedCharacters.NUMERIC));
		creationData.put("successMessageProductCreation", successMessageProductCreation);
		creationData.put("prodcutSearchErrorMessage", prodcutSearchErrorMessage);
	}
	
	@Test(groups = {"regression"})
	public class IndependentMentods extends PageFactoryInitializer{
	

		@Features(value = {"Products Module"})
		@Description("Verification of 'Products' page")
		@TestCaseId("TC_PRODUCTS_001")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
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
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
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
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
		public void TC_PRODUCTS_004(String productsTabNames ) throws Exception{

			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

			homePage()
			.clickOnProductsLink()
			.productsPage()
			.clickOnAddNewProductLink()
			.clickOnFirstEditProduct()
			.verifyProductsPageTabs(productsTabNames.split(","));
		}

		@Features(value = {"Products Module"})
		@Description("Verification of 'General Info' tab in 'Edit Product' page")
		@TestCaseId("TC_PRODUCTS_005")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
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
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
		public void TC_PRODUCTS_006(String productName, String productNumber,
				String successMessageProductCreation,String editProductName, String productUpdateSuccessMessage,
				String successMessageProductRemove) throws Exception{

				productName+=new RandomGenerator().random(3, PermittedCharacters.NUMERIC);
				productNumber+=new RandomGenerator().random(6, PermittedCharacters.NUMERIC);
				editProductName+=new RandomGenerator().randomAlphabetic(3);
				
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
				.clickOnRemoveProduct(productNumber)
				.acceptAlert();
		}
		
		@Features(value = {"Products Module"})
		@Description("Verification of 'Product Images' tab in 'Edit Product' page")
		@TestCaseId("TC_PRODUCTS_007")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
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
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
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
		@Description("Verification of 'Item List' tab")
		@TestCaseId("TC_PRODUCTS_012")
		@Test()
		public void TC_PRODUCTS_012() throws Exception{

			landingPage()
			.enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin();
			homePage()
			.clickOnProductsLink()
			.clickOnFirstEditProduct()
			.clickOnItemListTab()
			.verifySearchIconLocator()
			.verifySearchForItemsListField()
			.verifySearchInDropDown()
			.verifyManufacturerDropDown()
			.verifyBrandDropDown()
			.verifySaveIcon()
			.verifyItemList();
		}

		@Features(value = {"Products Module"})
		@Description("Verification of 'Display Records' in Products page")
		@TestCaseId("TC_PRODUCTS_022")
		@Test()
		public void TC_PRODUCTS_022() throws Exception
		{	
				data.setNumberOfRecordsToDisplay("10");
				landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
				.homePage()
				.clickOnProductsLink()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
				
				data.setNumberOfRecordsToDisplay("25");
				productsPage()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
				
				data.setNumberOfRecordsToDisplay("50");
				productsPage()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
				
				data.setNumberOfRecordsToDisplay("75");
				productsPage()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
				
				data.setNumberOfRecordsToDisplay("100");
				productsPage()
				.selectNumberOfRecordsToDisplayInThePage(data.getNumberOfRecordsToDisplay())
				.verifyTheNumberOfRecordsDisplayed(data.getNumberOfRecordsToDisplay());
		}

	}
	
	@Test(groups={"regression", productCreation})
	public class ProductCreation extends PageFactoryInitializer{
		
		@Features(value = {"Products Module"})
		@Description("Verification of adding new product")
		@TestCaseId("TC_PRODUCTS_003")
		@Test()
		public void TC_PRODUCTS_003() throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().
			
			homePage()
			.clickOnProductsLink()
			.clickOnAddNewProductLink()
			.enterProductName(creationData.get("productName"))
			.enterProductNumber(creationData.get("productNumber"))
			.clickOnProducSaveButtonLink()
			.verifyProductSavedSuccessMessage(creationData.get("successMessageProductCreation"));
		}
	}
	
	@Test(groups = { "regression",productCreationDependent },dependsOnGroups= {productCreation})
	public class ProductCreationDependent extends PageFactoryInitializer {


		@Features(value = {"Products Module"})
		@Description("Verification of adding product image using image URL")
		@TestCaseId("TC_PRODUCTS_009")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class )
		public void TC_PRODUCTS_009(String imageDescription, String productImageURL,String imageURLSuccessfulMessage) throws Exception{

			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().
			
			homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnFirstEditProduct()
			.clickOnProductImagesTab()
			.clickOnAddNewProductImage()
			.enterImageDescField(imageDescription)
			.enterProductImageURLField(productImageURL)
			.clickOnSaveImageURLLink()
			.verifyImageMessage(imageURLSuccessfulMessage);
		}

		@Features(value = {"Products Module"})
		@Description("Verification of adding product image using 'Upload Product Image'")
		@TestCaseId("TC_PRODUCTS_010")
		@Issue("Need to implement Auto IT scripts")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class,enabled=false)
		public void TC_PRODUCTS_010(String imageFilePath,String imageUploadSuccessfulMessage) throws Exception{
			
			File file = new File(imageFilePath);

			System.out.println(file.getAbsolutePath());
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

			homePage()
			.clickOnProductsLink()
			.clickOnAddNewProductLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnFirstEditProduct()
			.clickOnProductImagesTab()
			.clickOnAddNewProductImage()
			.clickOnProductImageFileUpload()
			.enterFileLocationInUploadDialogbox(file.getAbsolutePath())
			.clickOnUploadImageLink()
			.verifyImageMessage(imageUploadSuccessfulMessage);
		}

		@Features(value = {"Products Module"})
		@Description("Verification of removing the added product image")
		@TestCaseId("TC_PRODUCTS_011")
		@Issue("Added product Image doesn't show up")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class, dependsOnMethods={"TC_PRODUCTS_009"})
		public void TC_PRODUCTS_011(String imageRemoveSuccessMessage) throws Exception{

			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin().

			homePage()
			.clickOnProductsLink()
			.productsPage()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnFirstEditProduct()
			.clickOnProductImagesTab()
			.clickOnRemoveProductImage()
			.acceptAlert()
			.verifyImageMessage(imageRemoveSuccessMessage);
		}
		
		@Features(value = {"Products Module"})
		@Description("Verification of assigning items to product")
		@TestCaseId("TC_PRODUCTS_013")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class)
		public void TC_PRODUCTS_013(String expectedItemAssignSuccessMessage) throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin();
			
			String itemAdded=homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnFirstEditProduct()
			.clickOnItemsListTab()
			.dragAndDropTheItemsToProduct()
			.clickOnSaveButton()
			.verifyItemsAssignSuccessMessage(expectedItemAssignSuccessMessage.trim(),creationData.get("productName"))
			.fetchTheAddedItem();	
			creationData.put("associatedItem", itemAdded);
		}

		@Features(value = {"Products Module"})
		@Description("Verification of alert message when remove icon is clicked in the product list page")
		@TestCaseId("TC_PRODUCTS_014")
		@Test()
		public void TC_PRODUCTS_014() throws InterruptedException, Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.clickOnRemoveProduct(creationData.get("productName"))
			.verifyAlert(creationData.get("productName"));
				
		}
		
		@Features(value = {"Products Module"})
		@Description("Verification of 'Cancel' button in alert message")
		@TestCaseId("TC_PRODUCTS_016")
		@Test()
		public void TC_PRODUCTS_016() throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnRemoveProduct(creationData.get("productName"))
			.cancelAlert()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"));		
		}

		@Features(value = {"Products Module"})
		@Description("Verification of preview product's item page")
		@TestCaseId("TC_PRODUCTS_017")
		@Test(dependsOnMethods= {"TC_PRODUCTS_013"})
		public void TC_PRODUCTS_017() throws Exception{
		
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnPreviewItemLink()
			.verifyItemName(creationData.get("associatedItem"));
			
		}
		
		@Features(value = {"Products Module"})
		@Description("Verification of 'Edit Item' icon in product's item page")
		@TestCaseId("TC_PRODUCTS_018")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class, dependsOnMethods= {"TC_PRODUCTS_013"})
		public void TC_PRODUCTS_018(String expectedItemsTableHeaderTitles) throws Exception{
			
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnPreviewItemLink()
			.clickOnFirstItemEditIcon()
			.verifyItemsTableHeaders(expectedItemsTableHeaderTitles.split(","));
		}
		
		@Features(value = {"Products Module"})
		@Description("Verification of 'Copy of Item' icon in product's item page")
		@TestCaseId("TC_PRODUCTS_020")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class, dependsOnMethods= {"TC_PRODUCTS_013"})
		public void TC_PRODUCTS_020(String itemPartNumber, String numberOfCopiesForItem) throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnPreviewItemLink()
			.clickOnCopyIcon()
			.enterPartNumber(itemPartNumber)
			.enterNumerOfCopies(numberOfCopiesForItem)
			.clickOnSaveIconOfCopiedItem()
			.acceptAlert();
			
			int numberOfItems=Integer.parseInt(numberOfCopiesForItem);
			
			homePage()
			.enterTextInSearchField(itemPartNumber)
			.clickOnSearchIcon();
			
			for(int i=1;i<=numberOfItems;i++){
				itemsPage()
				.verifyItemSearchResults(itemPartNumber + " - Copy" + i)
				.clickOnRemoveItem(itemPartNumber + " - Copy" + i)
				.acceptAlert();
			}
		}

		@Features(value = {"Products Module"})
		@Description("Verification of 'Delink Item' from the assigned product")
		@TestCaseId("TC_PRODUCTS_021")
		@Test(dependsOnMethods= {"TC_PRODUCTS_013"})
		public void TC_PRODUCTS_021() throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			
			.homePage()
			.clickOnProductsLink()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductNameAfterSearchingIt(creationData.get("productName"))
			.clickOnPreviewItemLink()
			.clickOnDelinkItemIcon()
			.acceptAlert();
		}
		
	}
		
	@Test(groups={"regression"},dependsOnGroups = {},alwaysRun=true)
	public class ProductRemoval extends PageFactoryInitializer{

		@Features(value = {"Products Module"})
		@Description("Verification of removing the product from the list")
		@TestCaseId("TC_PRODUCTS_015")
		@Test(dataProvider="ProductsModuleTest",dataProviderClass=SearchData.class,alwaysRun=true)
		public void TC_PRODUCTS_015(String successMessageProductRemove) throws Exception{
			landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
			.homePage()
			.clickOnProductsLink()
			.productsListPage()
			.enterTheProductNameInSearchField(creationData.get("productName"))
			.clickOnSearchButton()
			.verifyProductPresent(creationData.get("productName"))
			.clickOnRemoveProduct(creationData.get("productName"))
			.acceptAlert()
			.verifySuccessfulMessageAfterDeletion(successMessageProductRemove);
		}
			

	}
		
}
