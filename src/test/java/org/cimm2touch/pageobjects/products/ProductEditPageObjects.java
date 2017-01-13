package org.cimm2touch.pageobjects.products;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductEditPageObjects extends PageFactoryInitializer {

	Waiting waiting = new Waiting(getDriver());
	TestUtility tu = new TestUtility(getDriver());

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@FindBy(xpath = "(//input[@title='Edit Product'])[1]")
	private WebElement editProductIcon;

	@FindBy(xpath = "//td[contains(text(),'Item List')]")
	private WebElement itemsListTab;

	@FindBy(xpath = "(//table[@id='col1 tbid1']/tbody/tr/td)[1]")
	private WebElement firstItem;

	@FindBy(xpath = "//th/span[text()='Action']")
	private WebElement destinationElement;

	@FindBy(xpath = "//input[@title='Save Items To Product ']")
	private WebElement saveItemsToProductLink;

	@FindBy(xpath = "//span[contains(text(),'Assigned Items Saved Successfully')]")
	private WebElement actualSuccesMessageItemAssignedToProduct;

	@FindAll(value = { @FindBy(xpath = "//td[@onmouseout='RichFaces.outTab(this);']") })
	private List<WebElement> productPageTabsLocator;

	@FindBy(xpath = "//td[contains(text(),'General Info')]")
	private WebElement generalInfoTabLocator;

	@FindBy(xpath = "//td[contains(text(),'Product Images')]")
	private WebElement productImagesTabLocator;

	@FindAll(value = { @FindBy(xpath = "//div[@class='tabContainerLabel']") })
	private List<WebElement> fieldNamesInGeneralInfoTabLocator;

	@FindAll(value = { @FindBy(xpath = "//th[@class='rich-table-subheadercell']") })
	private List<WebElement> fieldNamesInProductImagesTabLocator;

	@FindAll(value = { @FindBy(xpath = "//div[@class='tabContainerLabel']") })
	private List<WebElement> fieldNamesInAddNewProductImageLocator;

	@FindBy(xpath = "//textarea[@name='editProductForm:eproductCustomKeywordsId']")
	private WebElement productEditCustomKeywordsTextBoxLocator;

	@FindBy(xpath = "//input[@title='Update Product']")
	private WebElement productUpdateButtonLocator;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement productUpdateSavedSuccessMessageLocator;

	@FindBy(xpath = "//input[@title='Add New Product Image']")
	private WebElement addNewProductImageLocator;

	@FindBy(xpath = "//div[text()='Image Desc']/following-sibling::div/input")
	private WebElement imageDescTextBoxLocator;

	@FindBy(xpath = "//div[text()='Product Image URL']/following-sibling::div/input")
	private WebElement productImageURLTextBoxLocator;

	@FindBy(xpath = "//input[@title='Save URL']")
	private WebElement saveProductImageURLLocator;

	@FindBy(xpath = "//span[contains(text(),'Product Image URL saved Successfully')]")
	private WebElement ImageURLSavedSuccessfulMessageLocator;

	@FindBy(xpath = "//input[@id='editProductForm:eproductNameId']")
	private WebElement updateProductNameTextBoxLocator;

	@FindBy(xpath = "//tr[@class='rich-table-subheader']//input[@type='checkbox']")
	private WebElement productImageCheckboxLocator;

	@FindBy(xpath = "//input[@title='Add New Product Image']")
	private WebElement productImageLocator;

	@FindBy(xpath = "//input[@title='Add New Product Image']")
	private WebElement saveURLIconLocator;

	@FindBy(xpath = "//input[@id='editProductImageTabForm:btnReset']")
	private WebElement resetIconLocator;

	@FindBy(xpath = "//span[text()='(OR)']")
	private WebElement orTextLocator;

	@FindBy(xpath = "//div[@class='cimmDocFormLabel']")
	private WebElement overwriteImageTextLocator;

	@FindBy(xpath = "//div[@id='editProductImageTabForm:productImageUploadId:upload2']")
	private WebElement uploadImageLinkLocator;

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:searchKeywordId']")
	private WebElement searchForItemsListFieldLocator;

	@FindBy(xpath = "//a[@id='lnkditmSrchIdf:goBtn']")
	private WebElement searchIconLocator;

	@FindBy(how = How.XPATH, xpath = "//select[@id='lnkditmSrchIdf:searchInId']")
	private WebElement searchInIconLocator;

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:manufacturerListComboIdcomboboxButton']")
	private WebElement manufacturerDropDownLocator;

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:brandListComboIdcomboboxButton']")
	private WebElement brandDropDownLocator;

	@FindBy(xpath = "//input[@title='Save Items To Product ']")
	private WebElement saveIconLocator;

	@FindBy(xpath = "//td[contains(text(),'Item List')]")
	private WebElement itemListTabLocator;

	@FindBy(xpath = "//input[@title='Delete Product Image']")
	private WebElement removeProductImageLocator;

	@FindBy(id = "editProductImageTabForm:productImageUploadId:flashContainer")
	private WebElement productUploadImageLocator;

	@FindBy(xpath = "//td/div[contains(@class,'fileupload')]/descendant::div[text()='Image']/following-sibling::object")
	private WebElement productImageFileUpload;

	@Step("click on edit icon.")
	public ProductEditPageObjects clickOnEditIcon() {

		waiting.explicitWaitVisibilityOfElement(editProductIcon, 15);

		editProductIcon.click();
		return this;
	}

	@Step("Click on items list tab.")
	public ProductEditPageObjects clickOnItemsListTab() {

		waiting.explicitWaitVisibilityOfElement(itemsListTab, 15);
		itemsListTab.click();
		return this;
	}

	@Step("declaration for drag and drop operation.")
	public void elementHighlight(WebElement element) {
		for (int i = 0; i < 2; i++) {

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	@Step("performing drad and drop")
	public ProductEditPageObjects dragAndDropTheItemsToProduct() throws Exception {

		waiting.explicitWaitVisibilityOfElement(firstItem, 15);

		Actions builder = new Actions(getDriver());

		elementHighlight(firstItem);
		builder.clickAndHold(firstItem).build().perform();
		Thread.sleep(2000);
		elementHighlight(destinationElement);
		builder.moveToElement(destinationElement, 0, 0).build().perform();
		builder.moveToElement(destinationElement, 0, 5).build().perform();
		builder.moveToElement(destinationElement, 0, 10).build().perform();
		builder.moveToElement(destinationElement, 0, 11).build().perform();
		builder.moveToElement(destinationElement, 0, 12).build().perform();
		builder.moveToElement(destinationElement, 0, 13).build().perform();
		builder.moveToElement(destinationElement, 0, 14).build().perform();
		builder.moveToElement(destinationElement, 0, 25).build().perform();

		Thread.sleep(1000);
		builder.release().build().perform();
		Thread.sleep(4000);
		return this;
	}

	@Step("click on save button.")
	public ProductEditPageObjects clickOnSaveButton() {

		waiting.explicitWaitVisibilityOfElement(saveItemsToProductLink, 15);
		saveItemsToProductLink.click();
		return this;
	}

	@Step("Verify Message of Items section")
	public ProductEditPageObjects verifyItemsMessage(String expectedItemsMessage) {

		waiting.explicitWaitVisibilityOfElement(
				getDriver().findElement(By.xpath("//span[contains(text(),'" + expectedItemsMessage + "')]")), 15);
		Assert.assertEquals(getDriver().findElement(By.xpath("//span[contains(text(),'" + expectedItemsMessage + "')]"))
				.getText().trim().toLowerCase(), expectedItemsMessage.toLowerCase());
		return this;
	}

	@Step("Verify Product Page tabs are displayed as follows: {0}")
	public ProductEditPageObjects verifyProductsPageTabs(String[] productsTabNames) throws Exception {

		for (int i = 0; i < productPageTabsLocator.size(); i++) {
			Assert.assertEquals(productPageTabsLocator.get(i).getText().trim(), productsTabNames[i].trim(),
					"Edit product Tabs displayed incorrectly.");
		}
		return this;
	}

	@Step("This method is used verify General Info tab")
	public ProductEditPageObjects clickOnGeneralInfoTab() throws Exception {

		waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 6);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", generalInfoTabLocator);
		return this;
	}

	@Step("Verify Field Names In General Info Tab")
	public ProductEditPageObjects verifyFieldNamesInGeneralInfoTab(String[] generalInFoFieldNames) throws Exception {

		waiting.explicitWaitVisibilityOfElements(fieldNamesInGeneralInfoTabLocator, 6);
		for (int i = 0; i < fieldNamesInGeneralInfoTabLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInGeneralInfoTabLocator.get(i).getText().trim(),
					generalInFoFieldNames[i].trim());
		}
		return this;
	}

	@Step("Click on Product Images tab")
	public ProductEditPageObjects clickOnProductImagesTab() throws Exception {

		waiting.explicitWaitVisibilityOfElement(productImagesTabLocator, 6);

		productImagesTabLocator.click();
		return this;
	}

	@Step("Verify Field Names In Product Images Tab")
	public ProductEditPageObjects verifyFieldNamesInProductImagesTab(String[] fieldNameProductImagesTab)
			throws Exception {

		for (int i = 0; i < fieldNamesInProductImagesTabLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInProductImagesTabLocator.get(i).getText().trim(),
					fieldNameProductImagesTab[i].trim());
		}

		return this;
	}

	@Step("Verify if Product image checkbox is displayed in Product Images Tab")
	public ProductEditPageObjects verifyProductImageCheckbox() {

		waiting.explicitWaitVisibilityOfElement(productImageCheckboxLocator, 15);
		Assert.assertTrue(productImageCheckboxLocator.isDisplayed(), "Product Image Checkbox link is not displayed.");
		return this;
	}

	@Step("Verify if Add New Product Image button is displayed in Product Images Tab")
	public ProductEditPageObjects verifyAddNewProductImage() {
		Assert.assertTrue(productImageLocator.isDisplayed(), "Add New Product Image link is not displayed.");
		return this;
	}

	@Step("Click on Add New Product Image")
	public ProductEditPageObjects clickOnAddNewProductImage() throws Exception {

		waiting.explicitWaitVisibilityOfElement(addNewProductImageLocator, 15);
		addNewProductImageLocator.click();
		return this;
	}

	@Step("Verify Field Names In Add New Product Image")
	public ProductEditPageObjects verifyFieldNamesInAddNewProductImage(String[] fieldsNameInAddNewProductImage)
			throws Exception {

		for (int i = 0; i < fieldNamesInAddNewProductImageLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInAddNewProductImageLocator.get(i).getText().trim(),
					fieldsNameInAddNewProductImage[i].trim());
		}

		return this;
	}

	@Step("Verify if save URL Icon is displayed in Add New Product Image")
	public ProductEditPageObjects verifySaveURLconInAddNewProductImage() {

		Assert.assertTrue(saveURLIconLocator.isDisplayed(), "saveURL Icon is not displayed.");
		return this;
	}

	@Step("Verify if Reset Icon is displayed in Add New Product Image")
	public ProductEditPageObjects verifyResetIconInAddNewProductImage() {
		Assert.assertTrue(resetIconLocator.isDisplayed(), " Reset Icon is not displayed.");
		return this;
	}

	@Step("Verify if '(OR)' Text is displayed in Add New Product Image")
	public ProductEditPageObjects verifyORTextInAddNewProductImage() {
		Assert.assertTrue(orTextLocator.isDisplayed(), "(OR) text is not displayed.");
		return this;
	}

	@Step("Verify if Overwrite Image text is displayed in Add New Product Image")
	public ProductEditPageObjects verifyOverwriteImageTextInAddNewProductImage() {
		Assert.assertTrue(overwriteImageTextLocator.isDisplayed(), " Overwrite Image text is not displayed.");
		return this;
	}

	@Step("Click on Item List tab")
	public ProductEditPageObjects clickOnItemListTab() throws Exception {
		waiting.explicitWaitVisibilityOfElement(itemListTabLocator, 15);
		itemListTabLocator.click();
		return this;
	}

	@Step("Clear Product Name")
	public ProductEditPageObjects clearUpdateProductName() {
		waiting.explicitWaitVisibilityOfElement(updateProductNameTextBoxLocator, 15);
		updateProductNameTextBoxLocator.clear();
		return this;
	}

	@Step("Enter Product Name as \'{0}\'")
	public ProductEditPageObjects enterUpdatedProductName(String updateProductName) {
		waiting.explicitWaitVisibilityOfElement(updateProductNameTextBoxLocator, 15);
		updateProductNameTextBoxLocator.sendKeys(updateProductName);
		return this;
	}

	@Step("Click on Update Product Button")
	public ProductEditPageObjects clickOnProductUpdateButtonLink() {
		waiting.explicitWaitVisibilityOfElement(productUpdateButtonLocator, 60);
		productUpdateButtonLocator.click();
		return this;
	}

	@Step("Verify Product Update Success Message is \'{0}\'")
	public ProductEditPageObjects verifyProductUpdateSavedSuccessMessage(String productUpdateSuccessMessage) {
		waiting.explicitWaitVisibilityOfElement(productUpdateSavedSuccessMessageLocator, 6);
		Assert.assertEquals(productUpdateSavedSuccessMessageLocator.getText().trim().toLowerCase(),
				productUpdateSuccessMessage.toLowerCase(), "Product updation message was displayed incorrectly.");
		return this;
	}

	@Step("Enter Product Image Description as \'{0}\'")
	public ProductEditPageObjects enterImageDescField(String textToBeEnterInImageDesc) {
		waiting.explicitWaitVisibilityOfElement(imageDescTextBoxLocator, 15);
		imageDescTextBoxLocator.clear();
		imageDescTextBoxLocator.sendKeys(textToBeEnterInImageDesc);
		return this;
	}

	@Step("Enter Product ImageURL as \'{0}\'")
	public ProductEditPageObjects enterProductImageURLField(String textToBeEnterInProductImageURL) {
		waiting.explicitWaitVisibilityOfElement(productImageURLTextBoxLocator, 15);
		productImageURLTextBoxLocator.clear();
		productImageURLTextBoxLocator.sendKeys(textToBeEnterInProductImageURL);
		return this;
	}

	@Step("Click on Product SaveImageURL Link")
	public ProductEditPageObjects clickOnSaveImageURLLink() {
		waiting.explicitWaitVisibilityOfElement(saveProductImageURLLocator, 60);
		saveProductImageURLLocator.click();
		return this;
	}

	@Step("Click on \"Upload Image\" button of produt Image file Upload")
	public ProductEditPageObjects clickOnUploadImageLink() throws Exception {
		waiting.explicitWaitElementToBeClickable(uploadImageLinkLocator, 15);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", uploadImageLinkLocator);
		Thread.sleep(10000);
		return this;
	}

	@Step("Enter File path as \"{0}\" in File Upload dialog box")
	public ProductEditPageObjects enterFileLocationInUploadDialogbox(String fileLocation) throws Exception {
		Thread.sleep(2000);

		tu.fileUpload(fileLocation);

		Thread.sleep(2500);
		return this;
	}

	@Step("Verify Product Image URL Success Message is \'{0}\'")
	public ProductEditPageObjects verifyImageMessage(String imageSavedSuccessMessage) throws InterruptedException {

		Thread.sleep(3000);

		waiting.explicitWaitVisibilityOfElement(
				getDriver().findElement(By.xpath("//span[contains(text(),'" + imageSavedSuccessMessage + "')]")), 15);
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//span[contains(text(),'" + imageSavedSuccessMessage + "')]"))
						.getText().trim().toLowerCase(),
				imageSavedSuccessMessage.toLowerCase(),
				"Success message for saving Product Image using URL displayed incorrectly");
		return this;
	}

	@Step("Verify Search For Items List Field is displayed")
	public ProductEditPageObjects verifySearchForItemsListField() {

		waiting.explicitWaitVisibilityOfElement(searchForItemsListFieldLocator, 10);
		Assert.assertTrue(searchForItemsListFieldLocator.isDisplayed(), "searchForItemsList Field is not displayed.");
		return this;
	}

	@Step("Verify if Search Icon is displayed")
	public ProductEditPageObjects verifySearchIconLocator() {

		waiting.explicitWaitVisibilityOfElement(searchIconLocator, 10);
		Assert.assertTrue(searchIconLocator.isDisplayed(), "searchForItemsList Field is not displayed.");
		return this;
	}

	@Step("Verify if Manufacturer Drop Down is displayed")
	public ProductEditPageObjects verifyManufacturerDropDown() {
		waiting.explicitWaitVisibilityOfElement(manufacturerDropDownLocator, 10);
		Assert.assertTrue(manufacturerDropDownLocator.isDisplayed(), "manufacturerDropDown is not displayed.");
		return this;
	}

	@Step("Verify If Brand Drop Down is displayed")
	public ProductEditPageObjects verifyBrandDropDown() {
		waiting.explicitWaitVisibilityOfElement(brandDropDownLocator, 10);
		Assert.assertTrue(brandDropDownLocator.isDisplayed(), "brandDropDown is not displayed.");
		return this;
	}

	@Step("Verify if Save Icon is displayed")
	public ProductEditPageObjects verifySaveIcon() {
		waiting.explicitWaitVisibilityOfElement(saveIconLocator, 10);
		Assert.assertTrue(saveIconLocator.isDisplayed(), "saveIcon is not displayed.");
		return this;
	}

	@Step("Verify if item List Tab is displayed")
	public ProductEditPageObjects verifyItemList() {
		waiting.explicitWaitVisibilityOfElement(itemListTabLocator, 10);
		Assert.assertTrue(itemListTabLocator.isDisplayed(), "itemListTab is not displayed.");
		return this;
	}

	@Step("This method is used to remove the product image")
	public ProductEditPageObjects clickOnRemoveProductImage() {
		waiting.explicitWaitVisibilityOfElement(removeProductImageLocator, 20);
		removeProductImageLocator.click();
		return this;
	}

	@Step("Click on \"Image\" button of produt Image file Upload")
	public ProductEditPageObjects clickOnProductImageFileUpload() {
		waiting.explicitWaitVisibilityOfElement(productImageFileUpload, 4);
		productImageFileUpload.click();
		return this;
	}

	@Step("Verify If Search In Drop Down is displayed")
	public ProductEditPageObjects verifySearchInDropDown() {
		waiting.explicitWaitVisibilityOfElement(searchInIconLocator, 10);
		Assert.assertTrue(searchInIconLocator.isDisplayed(), "Seach In icon is not displayed.");
		return this;
	}

	@Step("Verify Success message after Item is assigned to a product")
	public ProductEditPageObjects verifyItemsAssignSuccessMessage(String expectedItemAssignSuccessMessage,
			String productName) {
		waiting.explicitWaitVisibilityOfElement(getDriver()
				.findElement(By.xpath("//span[contains(text(),'" + expectedItemAssignSuccessMessage + "')]")), 15);
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//span[contains(text(),'" + expectedItemAssignSuccessMessage + "')]"))
						.getText().trim().toLowerCase(),
				expectedItemAssignSuccessMessage.toLowerCase() + " " + productName.toLowerCase());
		return this;
	}

	public String fetchTheAddedItem() {
		return firstItem.getText();
	}

	@Step("Accept the alert")
	public ProductEditPageObjects acceptAlert() {
		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
	}

}
