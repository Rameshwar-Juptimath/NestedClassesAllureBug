package org.cimm2touch.pageobjects.products;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.items.EditItemsPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductsPageObjects extends PageFactoryInitializer {

	Waiting waiting = new Waiting(getDriver());
	TestUtility tu = new TestUtility(getDriver());

	SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindAll(value = { @FindBy(xpath = "//div[@class='cimm_formLabel']") })
	private List<WebElement> allFieldsLocator;

	@FindBy(xpath = "//input[@id='newProductForm:productNameId']")
	private WebElement productNameTextBoxLocator;

	@FindBy(xpath = "//input[@id='newProductForm:productNumberId']")
	private WebElement productNumberTextBoxLocator;

	@FindBy(xpath = "//textarea[@name='newProductForm:productDesc1Id']")
	private WebElement productDescription1TextBoxLocator;

	@FindBy(xpath = "//textarea[@name='newProductForm:productDesc2Id']")
	private WebElement productDescription2TextBoxLocator;

	@FindBy(xpath = "//textarea[@name='newProductForm:productFeaturesId']")
	private WebElement productFeaturesTextBoxLocator;

	@FindBy(xpath = "//textarea[@name='newProductForm:productMarketingDescId']")
	private WebElement productMarketingDescriptionTextBoxLocator;

	@FindBy(xpath = "//textarea[@name='newProductForm:productCustomKeywordsId']")
	private WebElement productCustomKeywordsTextBoxLocator;

	@FindBy(xpath = "//input[@title='Save New Product']")
	private WebElement productSaveButtonLocator;

	@FindBy(xpath = "//span[contains(text(),'New Product saved successfully')]")
	private WebElement productSavedSuccessfulMessageLocator;

	@FindBy(xpath = "//input[@title='Edit Product']")
	private WebElement editProductLocator;

	@FindBy(xpath = "(//div[@class='search list-search']/ul/li)[2]")
	private WebElement searchButton;

	@FindBy(xpath = "//span[contains(text(),'Product deleted successfully')]")
	private WebElement deletedSuccessfulMessageOfProductLocator;

	@FindBy(xpath = "//object[@id='editProductImageTabForm:productImageUploadId:flashContainer']")
	private WebElement uploadImageLocator;

	@FindAll(value = { @FindBy(xpath = "//div[@class='breadCrumbs']/span") })
	private List<WebElement> breadCrumbsLink;

	@FindBy(xpath = "//span[contains(text(),'Total Count : ')]")
	private WebElement totalCountLocator;

	@FindBy(xpath = "//input[@placeholder='Enter Product Name/Number to Search'][@type='text']")
	private WebElement productSearchPlaceHolder;

	@FindBy(xpath = "//span[@id='listProductForm:productTableID:ACTION']")
	private WebElement actionLocator;

	@FindBy(xpath = "//span[@id='listProductForm:productTableID:SL']")
	private WebElement siNoLocator;

	@FindBy(xpath = "//span[@id='listProductForm:productTableID:ITMIMGH']")
	private WebElement productImageLocator;

	@FindBy(xpath = "//th[contains(text(),'Product Name')]")
	private WebElement productNameLocator;

	@FindBy(xpath = "//th[contains(text(),'Product Number')]")
	private WebElement productNumberLocator;

	@FindBy(xpath = "//th[contains(text(),'Product Desc1')]")
	private WebElement productDesc1Locator;

	@FindBy(xpath = "//input[@title='Edit Product']")
	private WebElement productEditLinkLocator;

	@FindBy(xpath = "//input[@title='Remove Product']")
	private WebElement productRemoveLinkLocator;

	@FindBy(xpath = "//a[contains(@title,'Preview Product')]")
	private WebElement previewProductsItemsLocator;

	@FindBy(xpath = "//a[@title='Add New Product']")
	private WebElement addNewProductLocator;

	@FindBy(xpath = "//div[contains(text(),'Display ')]/select")
	private WebElement displayRecordsLocator;

	@FindBy(xpath = "//a[contains(@title,'Preview')]")
	private WebElement itemPreviewLink;

	@FindBy(xpath = "//input[@title='delink Item']")
	private WebElement delinkItemLink;

	@FindBy(xpath = "//input[@title='Edit Item']")
	private WebElement productItemsEditItemLink;

	@FindBy(xpath = "//input[@title='Copy Of Item']")
	private WebElement productItemsCopyItemLink;

	@FindBy(xpath = "//a[@title='Add New Product']")
	private WebElement creatingProductLink;

	@FindBy(xpath = "//div[contains(@class,'centerPanelRightIcons')]/select")
	private WebElement selectRecordsDropdownInProductsLocator;

	@FindAll(value = {
			@FindBy(xpath = "//tbody[@id='listProductForm:productTableID:tb']//tr[contains(@class,'rich-table-row')]") })
	private List<WebElement> productsListLocator;

	@Step("Click on add new product")
	public ProductsPageObjects clickOnAddNewProductLink() throws Exception {

		waiting.explicitWaitVisibilityOfElement(addNewProductLocator, 15);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", addNewProductLocator);
		return this;
	}

	@Step("Enter the product number as \'{0}\' in search field")
	public ProductsPageObjects enterTheProductNameInSearchField(String productName) {

		waiting.explicitWaitVisibilityOfElement(productSearchPlaceHolder, 15);
		productSearchPlaceHolder.sendKeys(productName);
		return this;
	}

	@Step("Click on search button")
	public ProductsPageObjects clickOnSearchButton() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(searchButton, 15);
		searchButton.click();
		return this;
	}

	@Step("Accept alert popup")
	public ProductsPageObjects acceptAlert() {
		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
	}

	@Step("Verify the Product removal message is \'{0}\'")
	public ProductsPageObjects verifySuccessMessageAfterDeletionProduct(String productRemovedSuccessfulMessage) {

		waiting.explicitWaitVisibilityOfElement(deletedSuccessfulMessageOfProductLocator, 20);
		Assert.assertEquals(deletedSuccessfulMessageOfProductLocator.getText().trim().toLowerCase(),
				productRemovedSuccessfulMessage.trim().toLowerCase(),
				"Message was displayed incorrectly for Product removal.");
		return this;
	}

	/*
	 * @Step("Verify the Product name is \'{0}\'") public ProductsPageObjects
	 * verifyProduct(String productName) {
	 * 
	 * waiting.explicitWaitVisibilityOfElement(By.xpath("//td[contains(text(),'"
	 * + productName + "')]"), 15); Assert.assertEquals(
	 * getDriver().findElement(By.xpath("//td[contains(text(),'" + productName +
	 * "')]")).getText(), productName,"Searching for product has failed.");
	 * return this; }
	 */

	@Step("Enter the Product Name in search field as \'{0}\'")
	public ProductsPageObjects enterProductNameInSearchField(String productName) {

		waiting.explicitWaitVisibilityOfElement(productSearchPlaceHolder, 20);
		productSearchPlaceHolder.sendKeys(productName);
		return this;
	}

	@Step("Verify the product name is \'{0}\'")
	public ProductsPageObjects verifyProductNameAfterSearchingIt(String productName) {

		waiting.explicitWaitVisibilityOfElement(By.xpath("//td[contains(text(),'" + productName + "')]"), 25);
		Assert.assertEquals(getDriver().findElement(By.xpath("//td[contains(text(),'" + productName + "')]")).getText(),
				productName, "Searching for product has failed.");
		return this;
	}

	@Step("Click on Remove Product of product: {0}")
	public ProductsPageObjects clickOnRemoveProduct(String productName) throws InterruptedException {

		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElement(getDriver()
				.findElement(By.xpath("//td[text()='" + productName + "']/..//input[@title='Remove Product']")), 20);
		getDriver().findElement(By.xpath("//td[text()='" + productName + "']/..//input[@title='Remove Product']"))
				.click();
		return this;
	}

	@Step("Verify Text of the following fields: {0}")
	public ProductsPageObjects verifyAllFields(String[] allFieldsAddNewProductsPage) {

		waiting.explicitWaitVisibilityOfElements(allFieldsLocator, 10);
		for (int i = 0; i < allFieldsLocator.size(); i++) {
			Assert.assertEquals(allFieldsLocator.get(i).getText().trim(), allFieldsAddNewProductsPage[i].trim(),
					"Field '" + allFieldsAddNewProductsPage[i].trim() + "' displayed incorrectly");
		}

		return this;
	}

	@Step("Enter product name as \'{0}\'")
	public ProductsPageObjects enterProductName(String productName) {

		waiting.explicitWaitVisibilityOfElement(productNameTextBoxLocator, 15);
		productNameTextBoxLocator.sendKeys(productName);
		return this;
	}

	@Step("Enter product number as \'{0}\'")
	public ProductsPageObjects enterProductNumber(String textToBeEnterInTheProductNumberTextbox) {

		waiting.explicitWaitVisibilityOfElement(productNumberTextBoxLocator, 15);
		productNumberTextBoxLocator
				.sendKeys(textToBeEnterInTheProductNumberTextbox);
		return this;
	}

	@Step("Enter product Description1 as \'{0}\'")
	public ProductsPageObjects enterProductDescription1Field(String textToBeEnterInTheProductDescription1Textbox) {
		productDescription1TextBoxLocator.sendKeys(textToBeEnterInTheProductDescription1Textbox);
		return this;
	}

	@Step("Enter product description2 as \'{0}\'")

	public ProductsPageObjects enterProductDescription2Field(String textToBeEnterInTheProductDescription2Textbox) {
		productDescription1TextBoxLocator.sendKeys(textToBeEnterInTheProductDescription2Textbox);
		return this;
	}

	@Step("Enter product features as \'{0}\'")
	public ProductsPageObjects enterProductFeaturesField(String textToBeEnterInTheProductFeaturesTextbox) {
		productFeaturesTextBoxLocator.sendKeys(textToBeEnterInTheProductFeaturesTextbox);
		return this;
	}

	@Step("Enter product Marketing Description as \'{0}\'")
	public ProductsPageObjects enterProductMarketingDescriptionField(
			String textToBeEnterInTheProductMarketingDescriptionTextbox) {
		productMarketingDescriptionTextBoxLocator.sendKeys(textToBeEnterInTheProductMarketingDescriptionTextbox);
		return this;
	}

	@Step("Enter product Custom Keywords as \'{0}\'")
	public ProductsPageObjects enterProductCustomKeywordsField(String textToBeEnterInTheProductCustomKeywordsTextbox) {
		productCustomKeywordsTextBoxLocator.sendKeys(textToBeEnterInTheProductCustomKeywordsTextbox);
		return this;
	}

	@Step("Click on product Save Button Link")
	public ProductsPageObjects clickOnProducSaveButtonLink() {

		waiting.explicitWaitVisibilityOfElement(productSaveButtonLocator, 60);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", productSaveButtonLocator);
		return this;
	}

	@Step("Verify the product Save Success Message")
	public ProductsPageObjects verifyProductSavedSuccessMessage(String poductSavedSuccessfulMessage) {

		waiting.explicitWaitVisibilityOfElement(productSavedSuccessfulMessageLocator, 6);
		Assert.assertEquals(productSavedSuccessfulMessageLocator.getText().trim().toLowerCase(),
				poductSavedSuccessfulMessage.trim().toLowerCase(), "Product Save message was displayed incorrectly");
		return this;
	}

	@Step("Click on First Product's Edit link")
	public ProductEditPageObjects clickOnFirstEditProduct() {

		waiting.explicitWaitVisibilityOfElement(editProductLocator, 30);
		editProductLocator.click();
		return editProductPage();
	}

	@Step("Click on Upload Image link")
	public ProductsPageObjects clickOnUploadImageLink() {

		waiting.explicitWaitVisibilityOfElement(uploadImageLocator, 15);
		uploadImageLocator.click();
		return this;
	}

	@Step("Verify the Bread Crumbs of the Products page has: {0}")
	public ProductsPageObjects verifyTheProductsPageBreadCrumbs(String[] breadCrumbsList) {

		waiting.explicitWaitVisibilityOfElements(breadCrumbsLink, 15);
		for (int i = 0; i < breadCrumbsLink.size(); i++)
			Assert.assertEquals(breadCrumbsLink.get(i).getText().trim(), breadCrumbsList[i].trim(),
					"Bread Crumbs are displayed incorrectly");
		return this;
	}

	@Step("Verify the if Total Count label is displayed in Products Page")
	public ProductsPageObjects verifyTotalCountInProductsPage() {
		Assert.assertTrue(totalCountLocator.isDisplayed(), "Total Count label is not displayed.");
		return this;
	}

	@Step("Verify the Search Field is displayed in Products Page")
	public ProductsPageObjects verifySearchFieldInProductsPage() {
		Assert.assertTrue(productSearchPlaceHolder.isDisplayed(), "SearchField is not displayed.");
		return this;
	}

	@Step("Verify the Action is displayed in ProductsPage")
	public ProductsPageObjects verifyActionInProductsPage() {
		Assert.assertTrue(actionLocator.isDisplayed(), "Action is not displayed.");
		return this;
	}

	@Step("Verify the Si.No is displayed in ProductsPage")
	public ProductsPageObjects verifySlNoInProductsPage() {
		Assert.assertTrue(siNoLocator.isDisplayed(), "Si.No is not displayed.");
		return this;
	}

	@Step("Verify the Product Image is displayed in Products Page")
	public ProductsPageObjects verifyProductImageInProductsPage() {
		Assert.assertTrue(productImageLocator.isDisplayed(), "productImage is not displayed.");
		return this;
	}

	@Step("Verify the product name is displayed in Products Page")
	public ProductsPageObjects verifyProductNameInProductsPage() {
		Assert.assertTrue(productNameLocator.isDisplayed(), "product name is not displayed.");
		return this;
	}

	@Step("Verify the product number is displayed in Products Page")
	public ProductsPageObjects verifyProductNumberInProductsPage() {
		Assert.assertTrue(productNumberLocator.isDisplayed(), "product number is not displayed.");
		return this;
	}

	@Step("Verify the product Desc1 is displayed in Products Page")
	public ProductsPageObjects verifyProductDesc1InProductsPage() {
		Assert.assertTrue(productDesc1Locator.isDisplayed(), "product Desc1 is not displayed.");
		return this;
	}

	@Step("Verify the product Edit Link is displayed in Products Page")
	public ProductsPageObjects verifyProductEditLinkInProductsPage() {
		Assert.assertTrue(productEditLinkLocator.isDisplayed(), "product EditLink is not displayed.");
		return this;
	}

	@Step("Verify the product Remove Link is displayed in Products Page")
	public ProductsPageObjects verifyProductRemoveLinkInProductsPage() {
		Assert.assertTrue(productRemoveLinkLocator.isDisplayed(), "product Remove Link is not displayed.");
		return this;
	}

	@Step("Verify the PreviewProductsItems is displayed in Products Page")
	public ProductsPageObjects verifyPreviewProductsItemsInProductsPage() {
		Assert.assertTrue(previewProductsItemsLocator.isDisplayed(), "PreviewProductsItems is not displayed.");
		return this;
	}

	@Step("Verify the AddNewProduct Link is displayed in Products Page")
	public ProductsPageObjects verifyAddNewProductLinkInProductsPage() {
		Assert.assertTrue(addNewProductLocator.isDisplayed(), "AddNewProduct Link is not displayed.");
		return this;
	}

	@Step("Verify the DisplayRecords is displayed in Products Page")
	public ProductsPageObjects verifyDisplayRecordsInProductsPage() {
		Assert.assertTrue(displayRecordsLocator.isDisplayed(), "DisplayRecords is not displayed.");
		return this;
	}

	@Step("Verify Unavailable Product's Search message")
	public String fetchProductNameAfterSearchingIt(String productName) {
		waiting.explicitWaitVisibilityOfElement(
				getDriver().findElement(
						By.xpath("//table[@id='listProductForm:productTableID']//td[text()='" + productName + "']")),
				8);
		return getDriver()
				.findElement(
						By.xpath("//table[@id='listProductForm:productTableID']//td[text()='" + productName + "']"))
				.getText();
	}

	@Step("Verify remove produt alert text for product {0}")
	public ProductsPageObjects verifyAlert(String productName) {
		Assert.assertEquals(getDriver().switchTo().alert().getText().toLowerCase(),
				("Are you sure you want to remove the " + productName + "?").toLowerCase(),
				"Alert message for remove product was displayed incorrectly");
		return this;
	}

	@Step("Cancel the alert")
	public ProductsPageObjects cancelAlert() {
		getDriver().switchTo().alert().dismiss();
		return this;
	}

	@Step("click on the preview items.")
	public ProductsPageObjects clickOnPreviewItemLink() {
		waiting.explicitWaitVisibilityOfElement(itemPreviewLink, 15);
		itemPreviewLink.click();
		return this;
	}

	@Step("click on the delink item from product.")
	public ProductsPageObjects clickOnDelinkItemIcon() {
		waiting.explicitWaitVisibilityOfElement(delinkItemLink, 15);
		delinkItemLink.click();
		return this;
	}

	@Step("click on edit Item icon link.")
	public EditItemsPageObjects clickOnFirstItemEditIcon() {
		waiting.explicitWaitVisibilityOfElement(productItemsEditItemLink, 15);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", productItemsEditItemLink);
		return editItemsPage();
	}

	@Step("Verification of Item \"{0}\" is displayed")
	public ProductsPageObjects verifyItemName(String itemName) throws InterruptedException {
		Thread.sleep(10000);
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath("//td[text()='" + itemName + "']")),
				15);
		Assert.assertEquals(getDriver().findElement(By.xpath("//td[text()='" + itemName + "']")).getText(), itemName,
				"Assciated item is displayed incorrectly");
		return this;
	}

	@Step("click on copy Item icon link.")
	public ItemsPageObjects clickOnCopyIcon() {
		waiting.explicitWaitVisibilityOfElement(productItemsCopyItemLink, 15);
		productItemsCopyItemLink.click();
		return itemsPage();
	}

	@Step("selecting \"{0}\"  as number of records to be displayed.")
	public ProductsPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay)
			throws Exception {
		Select select = new Select(selectRecordsDropdownInProductsLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(3000);
		return this;
	}

	@Step("verifying whether {0} is the number of records that is displayed.")
	public ProductsPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception {
		Thread.sleep(2800);
		waiting.explicitWaitVisibilityOfElements(productsListLocator, 15);
		Assert.assertTrue(productsListLocator.size() <= Integer.parseInt(getNumberOfRecordsToDisplay));
		return this;
	}
	
	@Step("Verify if product \'{0}\' already exists")
	public ProductsPageObjects verifyProductAlreadyExists(String productName) throws Exception {
		Thread.sleep(2800);
		waiting.explicitWaitVisibilityOfElement(By.xpath("//td[contains(text(),'" + productName + "')]"), 25);
		Assert.assertNotEquals(getDriver().findElement(By.xpath("//td[contains(text(),'" + productName + "')]")).getText(),
				productName, "Product \'"+productName+"\' already exists. Kindly delete it before proceeding ahead.");
		return this;
	}
}
