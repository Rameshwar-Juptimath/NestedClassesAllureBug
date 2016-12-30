package org.cimm2touch.pageobjects.products;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class EditProductsPageObjects extends PageFactoryInitializer {

	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

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

	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement imageDescTextBoxLocator;

	@FindBy(xpath = "(//input[@type='text'])[4]")
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

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:manufacturerListComboIdcomboboxButton']")
	private WebElement manufacturerDropDownLocator;

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:brandListComboIdcomboboxButton']")
	private WebElement brandDropDownLocator;

	@FindBy(xpath = "//input[@title='Save Items To Product ']")
	private WebElement saveIconLocator;

	@FindBy(xpath = "//td[contains(text(),'Item List')]")
	private WebElement itemListTabLocator;

	@FindBy(xpath = "//input[@title='???delPrdctImg???']")
	private WebElement removeProductImageLocator;

	@FindBy(id = "editProductImageTabForm:productImageUploadId:flashContainer")
	private WebElement productUploadImageLocator;

	@Step("Verify Product Page tabs are displayed as follows: {0}")
	public EditProductsPageObjects verifyProductsPageTabs(String[] productsTabNames) throws Exception {

		for (int i = 0; i < productPageTabsLocator.size(); i++) {
			Assert.assertEquals(productPageTabsLocator.get(i).getText().trim(), productsTabNames[i].trim(),
					"Edit product Tabs displayed incorrectly.");
		}
		return this;
	}

	@Step("This method is used verify General Info tab")
	public EditProductsPageObjects clickOnGeneralInfoTab() throws Exception {

		waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 6);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", generalInfoTabLocator);
		return this;
	}

	@Step("Verify Field Names In General Info Tab")
	public EditProductsPageObjects verifyFieldNamesInGeneralInfoTab(String[] generalInFoFieldNames) throws Exception {

		waiting.explicitWaitVisibilityOfElements(fieldNamesInGeneralInfoTabLocator, 6);
		for (int i = 0; i < fieldNamesInGeneralInfoTabLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInGeneralInfoTabLocator.get(i).getText().trim(),
					generalInFoFieldNames[i].trim());
		}
		return this;
	}

	@Step("Click on Product Images tab")
	public EditProductsPageObjects clickOnProductImagesTab() throws Exception {

		waiting.explicitWaitVisibilityOfElement(productImagesTabLocator, 6);

		productImagesTabLocator.click();
		return this;
	}

	@Step("Verify Field Names In Product Images Tab")
	public EditProductsPageObjects verifyFieldNamesInProductImagesTab(String[] fieldNameProductImagesTab)
			throws Exception {

		for (int i = 0; i < fieldNamesInProductImagesTabLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInProductImagesTabLocator.get(i).getText().trim(),
					fieldNameProductImagesTab[i].trim());
		}

		return this;
	}

	@Step("Verify if Product image checkbox is displayed in Product Images Tab")
	public EditProductsPageObjects verifyProductImageCheckbox() {

		waiting.explicitWaitVisibilityOfElement(productImageCheckboxLocator, 6);
		Assert.assertTrue(productImageCheckboxLocator.isDisplayed(), "Product Image Checkbox link is not displayed.");
		return this;
	}

	@Step("Verify if Add New Product Image button is displayed in Product Images Tab")
	public EditProductsPageObjects verifyAddNewProductImage() {
		Assert.assertTrue(productImageLocator.isDisplayed(), "Add New Product Image link is not displayed.");
		return this;
	}

	@Step("Click on Add New Product Image")
	public EditProductsPageObjects clickOnAddNewProductImage() throws Exception {

		waiting.explicitWaitVisibilityOfElement(addNewProductImageLocator, 15);
		addNewProductImageLocator.click();
		return this;
	}

	@Step("Verify Field Names In Add New Product Image")
	public EditProductsPageObjects verifyFieldNamesInAddNewProductImage(String[] fieldsNameInAddNewProductImage)
			throws Exception {


		for (int i = 0; i < fieldNamesInAddNewProductImageLocator.size(); i++) {
			Assert.assertEquals(fieldNamesInAddNewProductImageLocator.get(i).getText().trim(),
					fieldsNameInAddNewProductImage[i].trim());
		}

		return this;
	}

	@Step("Verify if save URL Icon is displayed in Add New Product Image")
	public EditProductsPageObjects verifySaveURLconInAddNewProductImage() {

		Assert.assertTrue(saveURLIconLocator.isDisplayed(), "saveURL Icon is not displayed.");
		return this;
	}

	@Step("Verify if Reset Icon is displayed in Add New Product Image")
	public EditProductsPageObjects verifyResetIconInAddNewProductImage() {
		Assert.assertTrue(resetIconLocator.isDisplayed(), " Reset Icon is not displayed.");
		return this;
	}

	@Step("Verify if '(OR)' Text is displayed in Add New Product Image")
	public EditProductsPageObjects verifyORTextInAddNewProductImage() {
		Assert.assertTrue(orTextLocator.isDisplayed(), "(OR) text is not displayed.");
		return this;
	}

	@Step("Verify if Overwrite Image text is displayed in Add New Product Image")
	public EditProductsPageObjects verifyOverwriteImageTextInAddNewProductImage() {
		Assert.assertTrue(overwriteImageTextLocator.isDisplayed(), " Overwrite Image text is not displayed.");
		return this;
	}

	@Step("This method is used verify Item List tab")
	public EditProductsPageObjects clickOnItemListTab() throws Exception {

		waiting.explicitWaitVisibilityOfElement(itemListTabLocator, 15);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", itemListTabLocator);
		return this;
	}

	@Step("Clear Product Name")
	public EditProductsPageObjects clearUpdateProductName() {

		waiting.explicitWaitVisibilityOfElement(updateProductNameTextBoxLocator, 15);
		updateProductNameTextBoxLocator.clear();
		return this;
	}
	
	@Step("Enter Product Name as \'{0}\'")
	public EditProductsPageObjects enterUpdatedProductName(String updateProductName) {

		waiting.explicitWaitVisibilityOfElement(updateProductNameTextBoxLocator, 15);
		updateProductNameTextBoxLocator.sendKeys(updateProductName);
		return this;
	}

	@Step("Click on Update Product Button")
	public EditProductsPageObjects clickOnProductUpdateButtonLink() {

		waiting.explicitWaitVisibilityOfElement(productUpdateButtonLocator, 60);
		productUpdateButtonLocator.click();
		return this;
	}

	@Step("Verify Product Update Success Message is \'{0}\'")
	public EditProductsPageObjects verifyProductUpdateSavedSuccessMessage(String productUpdateSuccessMessage) {

		waiting.explicitWaitVisibilityOfElement(productUpdateSavedSuccessMessageLocator, 6);
		Assert.assertEquals(productUpdateSavedSuccessMessageLocator.getText().trim().toLowerCase(),
				productUpdateSuccessMessage.toLowerCase(),
				"Product updation message was displayed incorrectly.");
		return this;
	}

	@Step("This method is used verify Product ImageDesc Field ")
	public EditProductsPageObjects enterImageDescField(String textToBeEnterInImageDesc) {

		waiting.explicitWaitVisibilityOfElement(imageDescTextBoxLocator, 15);
		imageDescTextBoxLocator.sendKeys(textToBeEnterInImageDesc);
		return this;
	}

	@Step("This method is used verify Product ImageURL Field")
	public EditProductsPageObjects enterProductImageURLField(String textToBeEnterInProductImageURL) {

		waiting.explicitWaitVisibilityOfElement(productImageURLTextBoxLocator, 15);
		productImageURLTextBoxLocator.sendKeys(textToBeEnterInProductImageURL);
		return this;
	}

	@Step("This method is used verify Product SaveImageURL Link ")
	public EditProductsPageObjects clickOnSaveImageURLLink() {

		waiting.explicitWaitVisibilityOfElement(saveProductImageURLLocator, 60);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", saveProductImageURLLocator);
		return this;
	}

	@Step("This method is used verify Product UploadImage Link ")
	public EditProductsPageObjects clickOnUploadImageLink() throws Exception {

		waiting.explicitWaitVisibilityOfElement(uploadImageLinkLocator, 15);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", uploadImageLinkLocator);
		Thread.sleep(10000);
		return this;
	}

	@Step("This method is used verify Product FileUpload")
	public EditProductsPageObjects verifyFileUpload(String fileLocation) throws Exception {
		Thread.sleep(2000);

		WebElement imageButton = getDriver()
				.findElement(By.xpath("//td/div[contains(@class,'fileupload')]/descendant::div[text()='Image']"));
		Actions action = new Actions(getDriver());
		action.click(imageButton).build().perform();
		Thread.sleep(2500);
		Robot robot = new Robot();
		StringSelection ss = new StringSelection(fileLocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		return this;
	}

	@Step("This method is used verify Product UpdateButton Link ")
	public EditProductsPageObjects verifyImageURLSavedSuccessfulMessage(String imageURLSuccessfulMessage) {

		waiting.explicitWaitVisibilityOfElement(ImageURLSavedSuccessfulMessageLocator, 6);
		Assert.assertTrue(
				ImageURLSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(imageURLSuccessfulMessage),
				"Invalid  message. Getting " + ImageURLSavedSuccessfulMessageLocator.getText().trim() + ".");
		return this;
	}

	@Step("This method is used verify the searchForItemsList Field")
	public EditProductsPageObjects verifySearchForItemsListField() {

		waiting.explicitWaitVisibilityOfElement(searchForItemsListFieldLocator, 10);
		Assert.assertTrue(searchForItemsListFieldLocator.isDisplayed(), "searchForItemsList Field is not displayed.");
		return this;
	}

	@Step("This method is used verify the SearchIcon ")
	public EditProductsPageObjects verifySearchIconLocator() {

		waiting.explicitWaitVisibilityOfElement(searchIconLocator, 10);
		Assert.assertTrue(searchIconLocator.isDisplayed(), "searchForItemsList Field is not displayed.");
		return this;
	}

	@Step("This method is used verify the manufacturerDropDown")
	public EditProductsPageObjects verifyManufacturerDropDown() {
		Assert.assertTrue(manufacturerDropDownLocator.isDisplayed(), "manufacturerDropDown is not displayed.");
		return this;
	}

	@Step("This method is used verify the brandDropDown")
	public EditProductsPageObjects verifyBrandDropDown() {
		Assert.assertTrue(brandDropDownLocator.isDisplayed(), "brandDropDown is not displayed.");
		return this;
	}

	@Step("This method is used verify the saveIcon")
	public EditProductsPageObjects verifySaveIcon() {
		Assert.assertTrue(saveIconLocator.isDisplayed(), "saveIcon is not displayed.");
		return this;
	}

	@Step("This method is used verify the itemListTab")
	public EditProductsPageObjects verifyitemListTab() {
		Assert.assertTrue(itemListTabLocator.isDisplayed(), "itemListTab is not displayed.");
		return this;
	}

	@Step("This method is used to remove the product image")
	public EditProductsPageObjects clickOnRemoveProductImage() {

		waiting.explicitWaitVisibilityOfElement(removeProductImageLocator, 10);
		removeProductImageLocator.click();
		return this;
	}

	@Step("This method is used accept the alert popup")
	public EditProductsPageObjects alertToAccept() {

		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
	}

}
