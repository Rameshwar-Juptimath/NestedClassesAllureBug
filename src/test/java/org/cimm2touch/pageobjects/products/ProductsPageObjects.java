package org.cimm2touch.pageobjects.products;

import java.util.List;


import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.cimm2touch.pageobjects.items.EditItemsPageObjects;

import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductsPageObjects extends PageFactoryInitializer {

	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());

	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_formLabel']")})
	private List<WebElement> allFieldsLocator;
	
	@FindBy(xpath="//input[@id='newProductForm:productNameId']")
	private WebElement productNameTextBoxLocator;
	
	@FindBy(xpath="//input[@id='newProductForm:productNumberId']")
	private WebElement productNumberTextBoxLocator;
	
	@FindBy(xpath="//textarea[@name='newProductForm:productDesc1Id']")
	private WebElement productDescription1TextBoxLocator;
	
	@FindBy(xpath="//textarea[@name='newProductForm:productDesc2Id']")
	private WebElement productDescription2TextBoxLocator;
	
	@FindBy(xpath="//textarea[@name='newProductForm:productFeaturesId']")
	private WebElement productFeaturesTextBoxLocator;
	
	@FindBy(xpath="//textarea[@name='newProductForm:productMarketingDescId']")
	private WebElement productMarketingDescriptionTextBoxLocator;
	
	@FindBy(xpath="//textarea[@name='newProductForm:productCustomKeywordsId']")
	private WebElement productCustomKeywordsTextBoxLocator;
	
	@FindBy(xpath="//input[@title='Save New Product']")
	private WebElement productSaveButtonLocator;
	
	@FindBy(xpath="//span[contains(text(),'New Product saved successfully')]")
	private WebElement productSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//input[@title='Edit Product']")
	private WebElement editProductLocator;
	
	@FindBy(xpath="(//div[@class='search list-search']/ul/li)[2]")
	private WebElement searchButton;
	 
	 @FindBy(xpath="//input[@title='Remove Product']")
	 private WebElement removeProductLink;
	 
	 @FindBy(xpath="//td[contains(text(),'example')]")
	 private WebElement productNameColumn;
	 
	 @FindBy(xpath="//span[contains(text(),'Product deleted successfully')]")
	 private WebElement deletedSuccessfulMessageOfProductLocator;
	 
	 @FindBy(xpath="//object[@id='editProductImageTabForm:productImageUploadId:flashContainer']")
	 private WebElement uploadImageLocator;
	 
	 @FindAll(value={@FindBy(xpath="//div[@class='breadCrumbs']/span")})
	 private List<WebElement> breadCrumbsLink;
	 
	 @FindBy(xpath="//span[contains(text(),'Total Count : ')]")
	 private WebElement totalCountLocator;
	 
	 @FindBy(xpath="(//input[@placeholder='Enter Product Name/Number to Search'])[1]")
	 private WebElement productSearchPlaceHolder;
		
	 @FindBy(xpath="//span[@id='listProductForm:productTableID:ACTION']")
	 private WebElement actionLocator;
	 
	 @FindBy(xpath="//span[@id='listProductForm:productTableID:SL']")
	 private WebElement siNoLocator;
	 
	 @FindBy(xpath="//span[@id='listProductForm:productTableID:ITMIMGH']")
	 private WebElement productImageLocator;
	  
	 @FindBy(xpath="//th[contains(text(),'Product Name')]")
	 private WebElement productNameLocator;
	 
	 @FindBy(xpath="//th[contains(text(),'Product Number')]")
	 private WebElement productNumberLocator;
	 
	 @FindBy(xpath="//th[contains(text(),'Product Desc1')]")
	 private WebElement productDesc1Locator;
	 
	 @FindBy(xpath="(//input[@title='Edit Product'])[1]")
	 private WebElement productEditLinkLocator;
	 
	 @FindBy(xpath="(//input[@title='Remove Product'])[1]")
	 private WebElement productRemoveLinkLocator;
	 
	 @FindBy(xpath="(//a[@id='listProductForm:productTableID:0:listItemsId'])[1]")
	 private WebElement previewProductsItemsLocator;
	 
	 @FindBy(xpath="//a[@title='Add New Product']")
	 private WebElement addNewProductLocator;
	 
	 @FindBy(xpath="//div[contains(text(),'Display ')]/select")
	 private WebElement displayRecordsLocator;
	 
	
	   @Step("click on add new product")
		public ProductsPageObjects clickOnAddNewProductLink() throws Exception {

		   	waiting.explicitWaitVisibilityOfElement(addNewProductLocator, 15);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",addNewProductLocator);
			return this;
		}
	   
	   @Step("This method is used to enter the product number in search field {0}")
	   public ProductsPageObjects enterTheProductNameInSearchField(String productName) {

	    waiting.explicitWaitVisibilityOfElement(productSearchPlaceHolder, 15);

	    productSearchPlaceHolder.sendKeys(productName);
	    return this;
	   }
	   
	   @Step("This method is used to clickon search buton in products page")
	   public ProductsPageObjects clickOnSearchButton() throws InterruptedException {

	    waiting.explicitWaitVisibilityOfElement(searchButton, 15);
	    searchButton.click(); 
	    return this;
	   }
	   
	   @Step("This method is used to remove the product")
	   public ProductsPageObjects clickOnRemoveProduct() {

	    waiting.explicitWaitVisibilityOfElement(removeProductLink, 15);
	    removeProductLink.click();
	    return this;
	   }
	    
	   @Step("This method is used accept the alert popup")
	   public ProductsPageObjects alertToAccept() {

	    waiting.explicitWaitForAlert(15);
	    tu.alertAccept();
	    return this;  
	   }
	   
	   	   
	   @Step("This method is used verify the message after deleting the product")
	   public ProductsPageObjects verifySuccessfulMessageAfterDeletionProduct(String productRemovedSuccessfulMessage) {

	    waiting.explicitWaitVisibilityOfElement(deletedSuccessfulMessageOfProductLocator, 15);
	    Assert.assertTrue(deletedSuccessfulMessageOfProductLocator.getText().trim().equals(productRemovedSuccessfulMessage),"Invalid  message. Getting "+deletedSuccessfulMessageOfProductLocator.getText().trim()+"."); 
	    return this;
	   }
	   
	   @Step("This method is used verify the product name")
	   public ProductsPageObjects verifyProduct(String productName) {

	    waiting.explicitWaitVisibilityOfElement(productNameColumn, 15);
	   // System.out.println(productNameColumn.getText());
	    Assert.assertEquals(productNameColumn.getText(), productName);
	    return this;
	   }
	   
	   @Step("This method is used to enter the product number in search field {0}")
	   public ProductsPageObjects enterTheUpdateProductNameInSearchField(String updateProductName) {

	    waiting.explicitWaitVisibilityOfElement(productSearchPlaceHolder, 15);
	    productSearchPlaceHolder.sendKeys(updateProductName);
	    return this;
	   }
	   
	   @Step("This method is used verify the product name")
	   public ProductsPageObjects verifyUpdateProduct(String updateProductName) {

	    waiting.explicitWaitVisibilityOfElement(productNameColumn, 15);
	   // System.out.println(productNameColumn.getText());
	    Assert.assertEquals(productNameColumn.getText(), updateProductName);
	    return this;
	   }
	   
	   @Step("This method is used to remove the product")
	   public ProductsPageObjects clickOnRemoveUpdateProduct() {

	    waiting.explicitWaitVisibilityOfElement(removeProductLink, 15);

	    removeProductLink.click();
	    return this;
	   }
	   
		@Step("verify whether non mandatory are {0}")
		public ProductsPageObjects verifyAllFields(String[] allFieldsAddNewProductsPage) {

			waiting.explicitWaitVisibilityOfElements(allFieldsLocator, 10);
			for(int i=0;i<allFieldsLocator.size();i++)
			{
				Assert.assertEquals(allFieldsLocator.get(i).getText().replace("*", "").trim(), allFieldsAddNewProductsPage[i]);
			}

			return this;	
		}

		

		@Step("This method is used verify the product name field")
		public ProductsPageObjects enterProductNameField(String productName) {


			 waiting.explicitWaitVisibilityOfElement(productNameTextBoxLocator, 15);
			 productNameTextBoxLocator.sendKeys(productName);	 
			 return this;
		}

		@Step("enter product number {0}")
		public ProductsPageObjects enterProductNumberField(String textToBeEnterInTheProductNumberTextbox) {

			 waiting.explicitWaitVisibilityOfElement(productNumberTextBoxLocator, 15);
			 RandomGenerator generateRand=new RandomGenerator();
			 productNumberTextBoxLocator.sendKeys(textToBeEnterInTheProductNumberTextbox+generateRand.random(8, PermittedCharacters.NUMERIC));
			 
			 return this;
		}

	
		@Step("This method is used verify the product Description1 field")
		public ProductsPageObjects enterProductDescription1Field(String textToBeEnterInTheProductDescription1Textbox) {
			 productDescription1TextBoxLocator.sendKeys(textToBeEnterInTheProductDescription1Textbox); 
			 return this;
		}
		@Step("enter product description2 {0}")


		public ProductsPageObjects enterProductDescription2Field(String textToBeEnterInTheProductDescription2Textbox) {
			 productDescription1TextBoxLocator.sendKeys(textToBeEnterInTheProductDescription2Textbox);
			 return this;
		}

		@Step("enter product features {0}")
		public ProductsPageObjects enterProductFeaturesField(String textToBeEnterInTheProductFeaturesTextbox) {
			 productFeaturesTextBoxLocator.sendKeys(textToBeEnterInTheProductFeaturesTextbox); 
			 return this;
		}

		
		@Step("This method is used verify the product MarketingDescription field")

		public ProductsPageObjects enterProductMarketingDescriptionField(String textToBeEnterInTheProductMarketingDescriptionTextbox) {
			 productMarketingDescriptionTextBoxLocator.sendKeys(textToBeEnterInTheProductMarketingDescriptionTextbox); 
			 return this;
		}

		
		@Step("This method is used verify the product CustomKeywords field")
		public ProductsPageObjects enterProductCustomKeywordsField(String textToBeEnterInTheProductCustomKeywordsTextbox) {
			 productCustomKeywordsTextBoxLocator.sendKeys(textToBeEnterInTheProductCustomKeywordsTextbox); 
			 return this;
		}

	
	

		@Step("This method is used verify the product SaveButtonLink ")
		 public ProductsPageObjects clickOnProducSaveButtonLink() {

			 waiting.explicitWaitVisibilityOfElement(productSaveButtonLocator, 60);
			 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",productSaveButtonLocator); 
		     return this;
		}
		 
		@Step("This method is used verify the product SavedSuccessfulMessage ")
		 public ProductsPageObjects verifyProductSavedSuccessfulMessage(String poductSavedSuccessfulMessage) { 

		   	 waiting.explicitWaitVisibilityOfElement(productSavedSuccessfulMessageLocator, 6);
		     Assert.assertTrue(productSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(poductSavedSuccessfulMessage),"Invalid  message. Getting "+productSavedSuccessfulMessageLocator.getText().trim()+".");
		     return this;
		}
		 
		@Step("This method is used verify the EditProduct link ")
		 public EditItemsPageObjects clickOnEditProduct() {

			 waiting.explicitWaitVisibilityOfElement(editProductLocator, 30);
			 editProductLocator.click();
		     return new EditItemsPageObjects();
		}
		 
		@Step("This method is used verify the UploadImage link ")
		 public ProductsPageObjects clickOnUploadImageLink() {

			 waiting.explicitWaitVisibilityOfElement(uploadImageLocator, 15);
			 uploadImageLocator.click();
			 return this;
	    }
		 
		 @Step("This method is used verify the breadCrums of the Products page")
		 public ProductsPageObjects verifyTheProductsPageBreadCrumbs() {
			 
			 String breadcrumpsList[] =data.getBreadcrumpsList().split(",");

		     waiting.explicitWaitVisibilityOfElements(breadCrumbsLink, 15);  
		     for(int i=0;i<breadCrumbsLink.size();i++)
		     Assert.assertEquals(breadCrumbsLink.get(i).getText().trim(),breadcrumpsList[i].trim());
		     return this;
		 }
		 
		 @Step("This method is used verify the TotalCount In ProductsPage")
			public ProductsPageObjects verifyTotalCountInProductsPage() {	
			Assert.assertTrue(totalCountLocator.isDisplayed(),"TotalCount name is not displayed.");
			return this;
		 }

		 @Step("This method is used verify the SearchField In ProductsPage")
			public ProductsPageObjects verifySearchFieldInProductsPage() {	
			Assert.assertTrue(productSearchPlaceHolder.isDisplayed(),"SearchField is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the Action In ProductsPage")
			public ProductsPageObjects verifyActionInProductsPage() {	
			Assert.assertTrue(actionLocator.isDisplayed(),"Action is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the Si.No In ProductsPage")
			public ProductsPageObjects verifySiNoInProductsPage() {	
			Assert.assertTrue(siNoLocator.isDisplayed(),"Si.No is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the productImage In ProductsPage")
			public ProductsPageObjects verifyProductImageInProductsPage() {	
			Assert.assertTrue(productImageLocator.isDisplayed(),"productImage is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the product name In ProductsPage")
			public ProductsPageObjects verifyProductNameInProductsPage() {	
			Assert.assertTrue(productNameLocator.isDisplayed(),"product name is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the product number In ProductsPage")
			public ProductsPageObjects verifyProductNumberInProductsPage() {	
			Assert.assertTrue(productNumberLocator.isDisplayed(),"product number is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the product Desc1 In ProductsPage")
			public ProductsPageObjects verifyProductDesc1InProductsPage() {	
			Assert.assertTrue(productDesc1Locator.isDisplayed(),"product Desc1 is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the product EditLink In ProductsPage")
			public ProductsPageObjects verifyProductEditLinkInProductsPage() {	
			Assert.assertTrue(productEditLinkLocator.isDisplayed(),"product EditLink is not displayed.");
			return this;
		 }
		 
		 @Step("This method is used verify the product Remove Link In ProductsPage")
			public ProductsPageObjects verifyProductRemoveLinkInProductsPage() {	
			Assert.assertTrue(productRemoveLinkLocator.isDisplayed(),"product Remove Link is not displayed.");
		    return this;
		 }
		 
		 @Step("This method is used verify the PreviewProductsItems In ProductsPage")
			public ProductsPageObjects verifyPreviewProductsItemsInProductsPage() {	
			Assert.assertTrue(previewProductsItemsLocator.isDisplayed(),"PreviewProductsItems is not displayed.");
			return this;
		 }

		 @Step("This method is used verify the AddNewProduct Link In ProductsPage")
			public ProductsPageObjects verifyAddNewProductLinkInProductsPage() {	
			Assert.assertTrue(addNewProductLocator.isDisplayed(),"AddNewProduct Link is not displayed.");
			return this;
		 }
		
		 @Step("This method is used verify the DisplayRecords In ProductsPage")
			public ProductsPageObjects verifyDisplayRecordsInProductsPage() {	
			Assert.assertTrue(displayRecordsLocator.isDisplayed(),"DisplayRecords is not displayed.");
			return this;
		 }
}
