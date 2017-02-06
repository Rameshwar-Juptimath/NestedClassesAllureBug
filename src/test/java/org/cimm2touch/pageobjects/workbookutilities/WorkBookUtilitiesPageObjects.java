package org.cimm2touch.pageobjects.workbookutilities;

import java.io.File;
import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class WorkBookUtilitiesPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins

	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins

	Waiting waiting = new Waiting(getDriver());

	TestUtility tu = new TestUtility(getDriver());
	TestUtilityMethods tuExtended = new TestUtilityMethods(getDriver());

	@FindAll(value = { @FindBy(xpath = "//td[contains(@class,'rich-tab-header')]") })
	private List<WebElement> allWorkbookUtilitesTabsLocator;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Items in Workbook')]/following-sibling::select[contains(@id,'storedWBid')]")
	private WebElement itemsInWorkbookSelectLocator;

	@FindBy(how = How.XPATH, using = "//input[@id='AddEditWorkBookForm:workBookName']")
	private WebElement workBookNameTextBoxLocator;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'saveWorkBook')]")
	private WebElement saveWorkBookButtonLocator;

	@FindBy(how = How.XPATH, using = "//input[@title='Reset']")
	private WebElement resetButtonLocator;

	@FindBy(how = How.XPATH, using = "//input[@title='Add New Workbook']")
	private WebElement addNewWorkBookButtonLocator;

	@FindAll(value = { @FindBy(xpath = "//span[contains(@id,'storedItemListTableId')]") })
	private List<WebElement> allListItemHeadersLocator;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Import Items to Workbook')]")
	private WebElement importItemsToWorkbookTabLocator;

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'newWBid')]")
	private WebElement selectWorkbookLocator;

	@FindBy(how = How.XPATH, using = "//a[@id='selectWorkbookForm:sampleTamplete']")
	private WebElement downloadTemplateLinkLocator;

	@FindBy(how = How.XPATH, using = "//select[@id='selectWorkbookForm:uploadFormatSelectionId']")
	private WebElement selectFileFormatDropDownLocator;

	@FindBy(how = How.XPATH, using = "//object[@id='selectWorkbookForm:dataFileUploadId:flashContainer']")
	private WebElement uploadButtonLocator;

	@FindBy(how = How.XPATH, using = "//span[@id='selectWorkbookForm:itemsToWorkbookSessionMessage']")
	private WebElement itemAddedSuccessMsgLocator;

	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Upload File']")
	private WebElement uploadFileButtonLocator;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'AddNewWrkSaveMes')]")
	private WebElement itemRemoveMsgLocator;

	@FindBy(how = How.XPATH, using = "//input[@id='storeItemListTableFormId:storedItemListTableId:SALL']")
	private WebElement selectAllItemsLocator;

	@FindBy(how = How.XPATH, using = "//input[normalize-space(@title)='Remove Selected Items From WorkBook']")
	private WebElement removeSelectedItemsFromWorkbookLocator;

	@FindBy(how = How.XPATH, using = "//td[normalize-space(text())='workBookName']/..//input[normalize-space(@title)='Purge All Items In this WorkBook']")
	private WebElement purgeItemsInThisWorkbookLocator;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'AddNewWrkSaveMes')]")
	private WebElement purgeAllItemsInThisWorkbookSuccessMsgLocator;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Bulk Item Categorization')]")
	private WebElement bulkItemCategorizationTabLocator;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'For WorkBook Items')]//select")
	private WebElement forWorkbookItemsDropDownLocator;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Make Selected Category As Default')]/input[@id='MIUitemCtgForm:defaultCategory']")
	private WebElement makeSelectedCategoryAsDefaultLocator;

	@FindBy(how = How.XPATH, using = "//input[@value='Do Changes For Workbook Items']")
	private WebElement doChangesForWorkbookItemsLocator;

	@FindBy(how = How.XPATH, using = "//input[@id='MIUtaxonomyListId:MIUtaxonomyListComboIdcomboboxField']")
	private WebElement taxonomyLocator;

	@FindAll(@FindBy(how = How.XPATH, using = "//span[contains(@id,'ttformid:MIUtaxonomyTreeId')]"))
	private List<WebElement> taxonomyCategoriesListLocator;

	@FindBy(how = How.XPATH, using = "//div[contains(normalize-space(text()),'For WorkBook Items')]//select")
	private WebElement selectForWorkbookItemsDropDownLocator;

	@FindBy(how = How.XPATH, using = "//select[@id='miuFormId:storedWBid']")
	private WebElement selectItemsInWorkbookDropDownLocator;

	@FindBy(how = How.XPATH, using = "//span[@id='MIUitemCtgForm:MIUsmsgId']")
	private WebElement bulkItemCategorizationMsgLocator;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Items To Subset')]")
	private WebElement itemsToSubsetTabLocator;

	@FindBy(how = How.XPATH, using = "//span[normalize-space(text())='Subset Name']/following-sibling::select")
	private WebElement subsetNameDropDownLocator;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'MIUaddToSubsetForm:MIUsmsgId')]")
	private WebElement itemsToSubsetMsgLocator;

	@FindBy(how = How.XPATH, using = "//td[text()='Items To New Brand']")
	private WebElement itemsToNewBrandTabLocator;

	@FindBy(how = How.XPATH, using = "//input[@id='addItemsToNewBrandFormId:wbManufacturerListComboIdcomboboxField']")
	private WebElement manufacturerNameDropDownLocator;

	@FindBy(how = How.XPATH, using = "//input[@id='addItemsToNewBrandFormId:wbBrandListComboIdcomboboxField']")
	private WebElement brandNameDropDownLocator;

	@FindBy(how = How.XPATH, using = "//input[@value='Bulk Items To New Brand']")
	private WebElement bulkItemsToNewBrandLocator;

	@FindBy(how = How.XPATH, using = "//span[@id='addItemsToNewBrandFormId:wbItemsToBrandMessage']")
	private WebElement itemsToNewBrandMsgLocator;

	@Step("Verify if tabs \"{0}\" are present in Workbook Utilites Page")
	public WorkBookUtilitiesPageObjects verifyAllTabs(String tabsList) {
		String[] tabsTobeVerified = tabsList.split(",");
		waiting.explicitWaitVisibilityOfElements(allWorkbookUtilitesTabsLocator, 10);
		for (int i = 0; i < allWorkbookUtilitesTabsLocator.size(); i++) {
			Assert.assertEquals(tabsTobeVerified[i].trim(), allWorkbookUtilitesTabsLocator.get(i).getText().trim(),
					"A tab in Workbook Utilities page is displayed incorrectly");
		}
		return this;
	}

	@Step("Verify if header fields \"{0}\" are present in Workbook Tab")
	public WorkBookUtilitiesPageObjects verifyAllWorkBookFieldHeaders(String fieldsList) {
		String[] fieldsListTobeVerified = fieldsList.split(",");
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//span[contains(@id,'workBookDataTable')][contains(text(),'" + fieldsListTobeVerified[0] + "')]"), 10);
		for (int i = 0; i < fieldsListTobeVerified.length; i++) {
			Assert.assertEquals(fieldsListTobeVerified[i].trim(),
					getDriver().findElement(By.xpath("//span[contains(@id,'workBookDataTable')][contains(text(),'"
							+ fieldsListTobeVerified[i] + "')]")).getText().trim(),
					"A field in Workbook Tab is displayed incorrectly");
		}
		return this;
	}

	@Step("Verify if \"Items in Workbook\" select drop down is displayed")
	public WorkBookUtilitiesPageObjects verifyItemsInWorkbookDropDown() {
		waiting.explicitWaitVisibilityOfElement(itemsInWorkbookSelectLocator, 10);
		Assert.assertTrue(itemsInWorkbookSelectLocator.isDisplayed(),
				"\"Items in workbook\" select drop down is not displayed");
		return this;
	}

	@Step("Enter Workbook Name is as \"{0}\" in the text box")
	public WorkBookUtilitiesPageObjects enterWorkbookName(String workBookName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(workBookNameTextBoxLocator, 10);
		Thread.sleep(2000);
		workBookNameTextBoxLocator.clear();
		workBookNameTextBoxLocator.sendKeys(workBookName);
		return this;
	}

	@Step("Click On Save Workbook button")
	public WorkBookUtilitiesPageObjects clickOnSaveWorkbookButton() {
		waiting.explicitWaitVisibilityOfElement(saveWorkBookButtonLocator, 10);
		saveWorkBookButtonLocator.click();
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed after workbook creation")
	public WorkBookUtilitiesPageObjects verifyWorkbookCreationSuccessMessage(String workBookName,
			String workBookCreationSuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(@id,'workbookTableForm:AddNewWrkSaveMes')]"),
				10);
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//span[contains(@id,'workbookTableForm:AddNewWrkSaveMes')]"))
						.getText().trim(),
				"'" + workBookName + "' " + workBookCreationSuccessMsg.trim(),
				"Workbook creation success message was displayed incorrectly,");
		return this;
	}

	@Step("Click On Add New Workbook button")
	public WorkBookUtilitiesPageObjects clickOnAddNewWorkbookButton() {
		waiting.explicitWaitVisibilityOfElement(addNewWorkBookButtonLocator, 10);
		addNewWorkBookButtonLocator.click();
		return this;
	}

	@Step("Click On Edit Workbook button of workBook:{0}")
	public WorkBookUtilitiesPageObjects clickOnEditWorkbookButton(String workBookName) {
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath("//span[normalize-space(text())='"
				+ workBookName + "']/../..//input[@title='Edit this WorkBookName']")), 10);
		getDriver().findElement(By.xpath(
				"//span[normalize-space(text())='" + workBookName + "']/../..//input[@title='Edit this WorkBookName']"))
				.click();
		return this;
	}

	@Step("Click On Remove Workbook button of workbook:{0}")
	public WorkBookUtilitiesPageObjects clickOnRemoveButtonOfWorkbook(String workBookName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath(
				"//span[normalize-space(text())='" + workBookName + "']/../..//input[@title='Remove this WorkBook']")),
				10);
		getDriver().findElement(By.xpath(
				"//span[normalize-space(text())='" + workBookName + "']/../..//input[@title='Remove this WorkBook']"))
				.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("Accept alert popup")
	public WorkBookUtilitiesPageObjects acceptAlert() {
		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
	}

	@Step("Click On Remove Workbook button of workbook:{0}")
	public WorkBookUtilitiesPageObjects verifyWorkbookNameNotPresentInDropDown(String workBookName)
			throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(itemsInWorkbookSelectLocator, 10);
		Select itemsInWorkbookSelectElement = new Select(itemsInWorkbookSelectLocator);
		List<WebElement> allWorkbooks = itemsInWorkbookSelectElement.getOptions();
		boolean itemPresent = false;
		for (int i = 0; i < allWorkbooks.size(); i++) {
			if (allWorkbooks.get(i).getText().contains(workBookName)) {
				itemPresent = true;
			}
		}
		Assert.assertTrue(itemPresent == false, "Workbook has not been removed successfully");
		return this;
	}

	@Step("Verify if error message \"{0}\" is displayed when save button is clicked without workbook name")
	public WorkBookUtilitiesPageObjects verifyBlankWorkbookErrorMessage(String blankWorkBookErrorSuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//span[contains(@id,'AddEditWorkBookForm')][text()='" + blankWorkBookErrorSuccessMsg + "']"),
				10);
		Assert.assertEquals(
				getDriver().findElement(By.xpath(
						"//span[contains(@id,'AddEditWorkBookForm')][text()='" + blankWorkBookErrorSuccessMsg + "']"))
						.getText().trim(),
				blankWorkBookErrorSuccessMsg.trim(),
				"Error message for saving blank Workbook was displayed incorrectly,");
		return this;
	}

	@Step("Click On Reset button")
	public WorkBookUtilitiesPageObjects clickOnResetButton() {
		waiting.explicitWaitVisibilityOfElement(resetButtonLocator, 10);
		resetButtonLocator.click();
		return this;
	}

	public WorkBookUtilitiesPageObjects verifyWorkbookNameAfterReset(String workbookName) {
		waiting.explicitWaitVisibilityOfElement(workBookNameTextBoxLocator, 10);
		Assert.assertEquals(workBookNameTextBoxLocator.getAttribute("value"), workbookName.trim(),
				"Reset button is not working as expected, Workbook name");
		return this;
	}

	@Step("Click On \"List Items in Workbook\" of workbook:{0}")
	public WorkBookUtilitiesPageObjects clickOnListItemsInWorkbookButton(String workbookName) {
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath(
				"//span[contains(text(),'" + workbookName + "')]/../..//input[@title='List Items in this WorkBook']")),
				10);
		getDriver().findElement(By.xpath(
				"//span[contains(text(),'" + workbookName + "')]/../..//input[@title='List Items in this WorkBook']"))
				.click();
		return this;
	}

	@Step("Verify if Items list header fields \"{0}\" are present in Workbook Tab")
	public WorkBookUtilitiesPageObjects verifyAllItemListHeaders(String fieldsList) {
		String[] fieldsListTobeVerified = fieldsList.split(",");
		waiting.explicitWaitVisibilityOfElements(allListItemHeadersLocator, 10);
		for (int i = 0; i < fieldsListTobeVerified.length; i++) {
			Assert.assertEquals(fieldsListTobeVerified[i].trim(), allListItemHeadersLocator.get(i).getText().trim(),
					"A header in Item list Headers is displayed incorrectly");
		}
		return this;
	}

	@Step("Click On \"Import Items to Workbook\" tab")
	public WorkBookUtilitiesPageObjects clickOnImportItemsToWorkbookTab() {
		waiting.explicitWaitVisibilityOfElement(importItemsToWorkbookTabLocator, 10);
		importItemsToWorkbookTabLocator.click();
		return this;
	}

	@Step("Verify if \"Select workbook\" drop down is displayed in \"Import Items to Workbook\" tab")
	public WorkBookUtilitiesPageObjects verifySelectWorkBookDropDown() {
		waiting.explicitWaitVisibilityOfElement(selectWorkbookLocator, 10);
		Assert.assertTrue(selectWorkbookLocator.isDisplayed(),
				"\"Select workbook\" drop down is not displayed in \"Import Items to Workbook\" tab");
		return this;
	}

	@Step("Verify if \"Download Template\" link is displayed in \"Import Items to Workbook\" tab")
	public WorkBookUtilitiesPageObjects verifyDownloadTemplateLink() {
		waiting.explicitWaitVisibilityOfElement(downloadTemplateLinkLocator, 10);
		Assert.assertTrue(downloadTemplateLinkLocator.isDisplayed(),
				"\"Download Template\" link is not displayed in \"Import Items to Workbook\" tab");
		return this;
	}

	@Step("Verify if \"Select the File format\" drop down is displayed in \"Import Items to Workbook\" tab")
	public WorkBookUtilitiesPageObjects verifySelectFileFormatDropDown() {
		waiting.explicitWaitVisibilityOfElement(selectFileFormatDropDownLocator, 10);
		Assert.assertTrue(selectFileFormatDropDownLocator.isDisplayed(),
				"\"Select the File format\" drop down is not displayed in \"Import Items to Workbook\" tab");
		return this;
	}

	@Step("Verify if \"Upload\" button is displayed in \"Import Items to Workbook\" tab")
	public WorkBookUtilitiesPageObjects verifyUploadButton() {
		waiting.explicitWaitVisibilityOfElement(uploadButtonLocator, 10);
		Assert.assertTrue(uploadButtonLocator.isDisplayed(),
				"\"Upload\" button is not displayed in \"Import Items to Workbook\" tab");
		return this;
	}

	@Step("Click On \"Download template\" button in \"Import Items to Workbook\" in tab")
	public WorkBookUtilitiesPageObjects clickOnDownloadTemplateButton() {
		waiting.explicitWaitVisibilityOfElement(downloadTemplateLinkLocator, 10);
		downloadTemplateLinkLocator.click();
		return this;
	}

	@Step("Verify if template file has been downloaded at \"{0}\"")
	public WorkBookUtilitiesPageObjects verifyTemplateFileDownload(String filePath) {
		Assert.assertTrue(new File(filePath).exists(), "Unable to download template file");
		return this;
	}

	@Step("Click On Upload button in \"Import Items to Workbook\" in tab")
	public WorkBookUtilitiesPageObjects clickOnUploadButton() {
		waiting.explicitWaitVisibilityOfElement(uploadButtonLocator, 10);
		uploadButtonLocator.click();
		return this;
	}

	@Step("Enter File path as \"{0}\" in File Upload dialog box")
	public WorkBookUtilitiesPageObjects enterFileLocationInUploadDialogbox(String fileLocation) throws Exception {

		Thread.sleep(2000);

		String path = fileLocation.replaceAll("/+", "\\\\");
		tuExtended.fileUploadAutoIt(path);

		Thread.sleep(2500);
		return this;
	}

	@Step("Verify message after adding items to workbook: Msg:{0}, TotalItems:{1}")
	public WorkBookUtilitiesPageObjects verifyItemsAddedToWorkbookMsg(String itemAddedSuccessMsg, int totalItemsAdded) {
		waiting.explicitWaitVisibilityOfElement(itemAddedSuccessMsgLocator, 10);
		Assert.assertEquals(itemAddedSuccessMsgLocator.getText().trim().toLowerCase(),
				(totalItemsAdded + " " + itemAddedSuccessMsg.trim()).toLowerCase(),
				"Adding items to workbook generated an incorrect message");
		return this;
	}

	@Step("Click On Upload File button in \"Import Items to Workbook\" in tab")
	public WorkBookUtilitiesPageObjects clickOnUploadFileButton() {
		waiting.explicitWaitVisibilityOfElement(uploadFileButtonLocator, 10);
		uploadFileButtonLocator.click();
		return this;
	}

	@Step("Select Workbook \"{0}\" in \"Import Items to Workbook\" in tab")
	public WorkBookUtilitiesPageObjects selectWorkbook(String workBookName) {
		waiting.explicitWaitVisibilityOfElement(selectWorkbookLocator, 10);
		Select workBook = new Select(selectWorkbookLocator);
		List<WebElement> options = workBook.getOptions();
		int i;
		for (i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(workBookName)) {
				break;
			}
		}
		workBook.selectByIndex(i);
		return this;
	}

	@Step("Click On \"List Items in Workbook\" button of workbook:{0}")
	public WorkBookUtilitiesPageObjects clickOnListItemsInWorkbook(String workBookName) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//span[text()='" + workBookName + "']/../..//input[@title='List Items in this WorkBook']"),
				10);
		getDriver()
				.findElement(By.xpath(
						"//span[text()='" + workBookName + "']/../..//input[@title='List Items in this WorkBook']"))
				.click();
		return this;
	}

	@Step("Verify Items remove Message \"{0}\"")
	public WorkBookUtilitiesPageObjects verifyItemRemoveMsg(int itemsCount, String msgToBeVerified) {
		waiting.explicitWaitVisibilityOfElement(itemRemoveMsgLocator, 20);
		Assert.assertEquals(itemRemoveMsgLocator.getText().trim().toLowerCase(),
				itemsCount + " " + msgToBeVerified.trim().toLowerCase(),
				"Item Remove message was displayed incorrectly");
		return this;
	}

	@Step("Click On select all items checkbox in workbook page")
	public WorkBookUtilitiesPageObjects clickOnSelectAllCheckbox() {
		waiting.explicitWaitVisibilityOfElement(selectAllItemsLocator, 10);
		selectAllItemsLocator.click();
		return this;
	}

	@Step("Click On \"Remove Selected Items From WorkBook\" button in workbook page")
	public WorkBookUtilitiesPageObjects clickOnRemoveSelectedItemsFromWorkbook() {
		waiting.explicitWaitVisibilityOfElement(removeSelectedItemsFromWorkbookLocator, 10);
		removeSelectedItemsFromWorkbookLocator.click();
		return this;
	}

	@Step("Click On Remove button of Item with part number:{0}")
	public WorkBookUtilitiesPageObjects clickOnRemoveButtonOfItem(String itemPartNumber) {
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//td[normalize-space(text())='" + itemPartNumber + "']/..//input[@title='Remove from this List']"),
				10);
		getDriver().findElement(By.xpath(
				"//td[normalize-space(text())='" + itemPartNumber + "']/..//input[@title='Remove from this List']"))
				.click();
		return this;
	}

	@Step("Select file Format as:{0}")
	public WorkBookUtilitiesPageObjects selectFileFormat(String value) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(selectFileFormatDropDownLocator, 10);
		Select selectFileFormat = new Select(selectFileFormatDropDownLocator);
		Thread.sleep(2000);
		selectFileFormat.selectByVisibleText(value);
		return this;
	}

	@Step("Click On \"Purge All Items In This Workbook\" button of workbook:{0}")
	public WorkBookUtilitiesPageObjects clickOnPurgeAllItemsInThisWorkbookButton(String workbookName) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[normalize-space(text())='" + workbookName
				+ "']/../..//input[normalize-space(@title)='Purge All Items In this WorkBook']"), 10);
		getDriver().findElement(By.xpath("//span[normalize-space(text())='" + workbookName
				+ "']/../..//input[normalize-space(@title)='Purge All Items In this WorkBook']")).click();
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed after Purging All Item in a workbook")
	public WorkBookUtilitiesPageObjects verifyPurgeAllItemsInThisWorkbookSuccessMsg(String workbookName)
			throws InterruptedException {
		Thread.sleep(5000);
		waiting.explicitWaitVisibilityOfElement(purgeAllItemsInThisWorkbookSuccessMsgLocator, 10);
		Assert.assertEquals(purgeAllItemsInThisWorkbookSuccessMsgLocator.getText(),
				"All Items Purged from '" + workbookName + "' Successfully",
				"Purging All Items of a workbook is not working");
		return this;
	}

	@Step("Click On \"Bulk Item Categorization\" tab")
	public WorkBookUtilitiesPageObjects clickOnBulkItemCategorizationTab() {
		waiting.explicitWaitVisibilityOfElement(bulkItemCategorizationTabLocator, 10);
		bulkItemCategorizationTabLocator.click();
		return this;
	}

	@Step("Verify if \"For WorkBook Items\" dropdown is displayed")
	public WorkBookUtilitiesPageObjects verifyForWorkbookItemsDropDown() {
		waiting.explicitWaitVisibilityOfElement(forWorkbookItemsDropDownLocator, 10);
		Assert.assertTrue(forWorkbookItemsDropDownLocator.isDisplayed(),
				"\"For WorkBook Items\" items dropdown is not displayed");
		return this;
	}

	@Step("Verify if \"Make Selected Category As Default\" checkbox is displayed")
	public WorkBookUtilitiesPageObjects verifyMakeSelectedCategoryAsDefaultCheckbox() {
		waiting.explicitWaitVisibilityOfElement(makeSelectedCategoryAsDefaultLocator, 10);
		Assert.assertTrue(makeSelectedCategoryAsDefaultLocator.isDisplayed(),
				"\"Make Selected Category As Default\" checkbox is not displayed");
		return this;
	}

	@Step("Verify if \"Do Changes For Workbook Items\" button is displayed")
	public WorkBookUtilitiesPageObjects verifyDoChangesForWorkbookItemsButton() {
		waiting.explicitWaitVisibilityOfElement(doChangesForWorkbookItemsLocator, 10);
		Assert.assertTrue(doChangesForWorkbookItemsLocator.isDisplayed(),
				"\"Do Changes For Workbook Items\" button is not displayed");
		return this;
	}

	@Step("Enter Taxonomy name as \"{0}\" in \"Bulk Item Categorization\" Tab")
	public WorkBookUtilitiesPageObjects enterTaxonomyName(String taxonomyName) {
		waiting.explicitWaitVisibilityOfElement(taxonomyLocator, 10);
		taxonomyLocator.clear();
		taxonomyLocator.sendKeys(taxonomyName);
		return this;
	}

	@Step("Click On Taxonomy \"{0}\"")
	public WorkBookUtilitiesPageObjects clickOnTaxonomyName(String taxonomyName) {
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//div[@id='MIUtaxonomyListId:MIUtaxonomyListComboIdlist']//span[text()='" + taxonomyName + "']"), 10);
		getDriver().findElement(By.xpath(
				"//div[@id='MIUtaxonomyListId:MIUtaxonomyListComboIdlist']//span[text()='" + taxonomyName + "']"))
				.click();
		return this;
	}

	@Step("Verify if Categories:\"{0}\" are displayed")
	public WorkBookUtilitiesPageObjects verifyCategoriesList(String[] categoriesList) {
		for (int i = 0; i < categoriesList.length; i++) {
			Assert.assertEquals(taxonomyCategoriesListLocator.get(i).getText().trim().toLowerCase(),
					categoriesList[i].trim().toLowerCase(), "Taxonomy Categories are displayed incorrectly.");
		}
		return this;
	}

	@Step("Select \"{0}\" in \"For WorkBook Items\" drop down")
	public WorkBookUtilitiesPageObjects selectForWorkbookItems(String valueToBeSelected) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(selectForWorkbookItemsDropDownLocator, 10);
		Select selectFileFormat = new Select(selectForWorkbookItemsDropDownLocator);
		Thread.sleep(2000);
		selectFileFormat.selectByVisibleText(valueToBeSelected);
		return this;
	}

	@Step("Select Workbook \"{0}\" in \"Bulk Item Categorization\" in tab")
	public WorkBookUtilitiesPageObjects selectItemsInWorkbook(String workbookName) {
		waiting.explicitWaitVisibilityOfElement(selectItemsInWorkbookDropDownLocator, 10);
		Select workBook = new Select(selectItemsInWorkbookDropDownLocator);
		List<WebElement> options = workBook.getOptions();
		int i;
		for (i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(workbookName)) {
				break;
			}
		}
		workBook.selectByIndex(i);
		return this;
	}

	@Step("Click On \"Do Changes For Workbook Items\" button in \"Bulk Item Categorization\" tab")
	public WorkBookUtilitiesPageObjects clickOnDoChangesForWorkbookItemsButton() {
		waiting.explicitWaitVisibilityOfElement(doChangesForWorkbookItemsLocator, 10);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", doChangesForWorkbookItemsLocator);
		return this;
	}

	@Step("Double Click On \"{0}\" Category in \"Bulk Item Categorization\" tab")
	public WorkBookUtilitiesPageObjects doubleClickOnCategoryName(String categoryName) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[normalize-space(text())='" + categoryName + "']"), 10);
		Actions action = new Actions(getDriver());
		action.doubleClick(getDriver().findElement(By.xpath("//span[normalize-space(text())='" + categoryName + "']")))
				.build().perform();
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed")
	public WorkBookUtilitiesPageObjects verifyItemAssignToCategoryMsg(int itemsCount,
			String itemAssignToCategorySuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(bulkItemCategorizationMsgLocator, 10);
		Assert.assertEquals(bulkItemCategorizationMsgLocator.getText().trim().toLowerCase(),
				itemsCount + " " + itemAssignToCategorySuccessMsg.trim().toLowerCase(),
				"Message for \"Bulk Categorization\" is displayed incorrectly,");
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed")
	public WorkBookUtilitiesPageObjects verifyItemRemoveFromCategoryMsg(
			String itemAssignToCategorySuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(bulkItemCategorizationMsgLocator, 10);
		Assert.assertEquals(bulkItemCategorizationMsgLocator.getText().trim().toLowerCase(),
				itemAssignToCategorySuccessMsg.trim().toLowerCase(),
				"Message for \"Bulk Categorization\" is displayed incorrectly,");
		return this;
	}
	
	@Step("Click On\"Items To Subset\" tab")
	public WorkBookUtilitiesPageObjects clickOnItemsToSubsetTab() {
		waiting.explicitWaitVisibilityOfElement(itemsToSubsetTabLocator, 10);
		itemsToSubsetTabLocator.click();
		return this;
	}

	@Step("Verify if \"Susbset Name\" drop down is displayed in \"Items To Subset\" Tab")
	public WorkBookUtilitiesPageObjects verifySusbsetNameDropDown() {
		waiting.explicitWaitVisibilityOfElement(subsetNameDropDownLocator, 10);
		Assert.assertTrue(subsetNameDropDownLocator.isDisplayed(), "\"Susbset Name\" dropdown is not displayed");
		return this;
	}

	@Step("Verify if \"Remove Selected Items from this workbook\" icon is displayed in \"Items To Subset\" Tab")
	public WorkBookUtilitiesPageObjects verifyRemoveSelectedItemsFromWorkbookIcon() {
		waiting.explicitWaitVisibilityOfElement(removeSelectedItemsFromWorkbookLocator, 10);
		Assert.assertTrue(removeSelectedItemsFromWorkbookLocator.isDisplayed(),
				"\"Remove Selected Items from this workbook\" icon is not displayed");
		return this;
	}

	@Step("Select \"{0}\" in \"Subset Name\" drop down")
	public WorkBookUtilitiesPageObjects selectSubsetName(String valueToBeSelected) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(subsetNameDropDownLocator, 10);
		Select selectFileFormat = new Select(subsetNameDropDownLocator);
		selectFileFormat.selectByVisibleText(valueToBeSelected);
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed in \"Items to Subset\" tab")
	public WorkBookUtilitiesPageObjects verifyItemsToSubsetMsg(int itemsCount, String itemsToSubsetSuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(itemsToSubsetMsgLocator, 10);
		Assert.assertEquals(itemsToSubsetMsgLocator.getText().trim().toLowerCase(),
				itemsCount + " " + itemsToSubsetSuccessMsg.trim().toLowerCase(),
				"Message for \"Items to subset\" is displayed incorrectly,");
		return this;
	}

	@Step("Click\"Items To New Brand\" tab")
	public WorkBookUtilitiesPageObjects clickOnItemsToNewBrandTab() {
		waiting.explicitWaitVisibilityOfElement(itemsToNewBrandTabLocator, 10);
		itemsToNewBrandTabLocator.click();
		return this;
	}

	@Step("Enter manufacturer name as \"{0}\" in Manufacturer Name drop down and click on the manufacturer name from the list")
	public WorkBookUtilitiesPageObjects enterAndSelectManufacturerName(String newManufacturerName)
			throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(manufacturerNameDropDownLocator, 10);
		manufacturerNameDropDownLocator.clear();
		manufacturerNameDropDownLocator.sendKeys(newManufacturerName);
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//span[normalize-space(text())='" + newManufacturerName + "']"), 10);
		getDriver().findElement(By.xpath("//span[normalize-space(text())='" + newManufacturerName + "']")).click();
		return this;
	}

	@Step("Enter Brand name as \"{0}\" in Brand Name drop down and click on the Brand name from the list")
	public WorkBookUtilitiesPageObjects enterAndSelectBrandName(String newBrandName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(brandNameDropDownLocator, 10);
		brandNameDropDownLocator.clear();
		brandNameDropDownLocator.sendKeys(newBrandName);
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[normalize-space(text())='" + newBrandName + "']"), 10);
		getDriver().findElement(By.xpath("//span[normalize-space(text())='" + newBrandName + "']")).click();
		return this;
	}

	@Step("Click on \"Bulk Items To New Brand\" button in \"Items To New Brand\" Tab")
	public WorkBookUtilitiesPageObjects clickOnBulkItemsToNewBrand() {
		waiting.explicitWaitVisibilityOfElement(bulkItemsToNewBrandLocator, 10);
		bulkItemsToNewBrandLocator.click();
		return this;
	}

	@Step("Verify if message \"{0}\" is displayed in \"Items to New Brand\" tab")
	public WorkBookUtilitiesPageObjects verifyItemsToNewBrandMsg(int itemsCount, String itemsToNewBrandSuccessMsg) {
		waiting.explicitWaitVisibilityOfElement(itemsToNewBrandMsgLocator, 10);
		Assert.assertEquals(itemsToNewBrandMsgLocator.getText().trim().toLowerCase(),
				itemsCount + " " + itemsToNewBrandSuccessMsg.trim().toLowerCase(),
				"Message for \"Items to New Brand\" is displayed incorrectly,");
		return this;
	}

	@Step("Verify if workbook has {0} items")
	public WorkBookUtilitiesPageObjects verifyItemsInWorkbook(int itemsCount) {
		waiting.explicitWaitVisibilityOfElements(By.xpath("//tr[contains(@class,'rich-table-row')]"), 10);
		Assert.assertEquals(getDriver().findElements(By.xpath("//tr[contains(@class,'rich-table-row')]")).size(),
				itemsCount, "Mismatch in total number of items in workbook,");
		return this;

	}

	@Step("Verify if workbook \'{0}\' already exists")
	public WorkBookUtilitiesPageObjects verifyWorkbookAlreadyExists(String workbookName) {

		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[normalize-space(text())='" + workbookName + "']"), 10);
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//span[normalize-space(text())='" + workbookName + "']")).getText(),
				workbookName, "Workbook does not exist");
		return this;
	}

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}
