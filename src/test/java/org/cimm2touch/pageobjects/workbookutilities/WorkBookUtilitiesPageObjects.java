package org.cimm2touch.pageobjects.workbookutilities;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath(
				"//span[contains(text(),'" + workBookName + "')]/../..//input[@title='Edit this WorkBookName']")), 10);
		getDriver().findElement(By
				.xpath("//span[contains(text(),'" + workBookName + "')]/../..//input[@title='Edit this WorkBookName']"))
				.click();
		return this;
	}

	@Step("Click On Remove Workbook button of workbook:{0}")
	public WorkBookUtilitiesPageObjects clickOnRemoveButtonOfWorkbook(String workBookName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(
				getDriver().findElement(By.xpath(
						"//span[contains(text(),'" + workBookName + "')]/../..//input[@title='Remove this WorkBook']")),
				10);
		getDriver()
				.findElement(By.xpath(
						"//span[contains(text(),'" + workBookName + "')]/../..//input[@title='Remove this WorkBook']"))
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

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}
