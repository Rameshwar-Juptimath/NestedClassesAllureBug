package org.cimm2touch.pageobjects.uom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.products.ProductsPageObjects;
import org.cimm2touch.pageobjects.subset.SubsetPageObjects;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class UOMPageObjects extends PageFactoryInitializer {

	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());

	@FindAll(value = { @FindBy(xpath = "//div[@class='breadCrumbs']/span") })
	private List<WebElement> breadCrumbsLink;

	@FindBy(xpath = "//div[contains(text(),'Display ')]")
	private WebElement displayRecordsLocator;

	@FindBy(xpath = "//a[@title='New Unit Of Measure']")
	private WebElement addNewUOMLocator;

	@FindAll(value = {
			@FindBy(xpath = "//form[@id='addNewUnitOfMeasureForm']/descendant::div[@class='cimm_formLabel']") })
	private List<WebElement> allAddNewUOMFieldsLocator;

	@FindBy(xpath = "//div[@class='search list-search']/descendant::i[@class='list-search-icn fa fa-search']")
	private WebElement searchButton;

	@FindAll(value = { @FindBy(xpath = "//thead[@class='rich-table-thead']/descendant::span") })
	private List<WebElement> headerLink;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter UOM Name to Search')]")
	private WebElement uomSearchPlaceHolder;

	@FindBy(xpath = "//input[@id='addNewUnitOfMeasureForm:uomName']")
	private WebElement uOMNameTextBox;

	@FindBy(xpath = "//textarea[@id='addNewUnitOfMeasureForm:UOMDesc']")
	private WebElement uOMDescriptionTextBox;

	@FindBy(xpath = "//span[contains(text(),'New Unit Of Measure saved Successfully')]")
	private WebElement welcomeMessagelocator;

	@FindBy(xpath = "//form[@id='addNewUnitOfMeasureForm']/descendant::input[@title='Save New Unit Of Measure']")
	private WebElement uOMsaveLink;

	@FindAll(value = {
			@FindBy(xpath = "//form[@id='addNewUnitOfMeasureForm']/descendant::div[@class='cimm_formLabel']") })
	private List<WebElement> allEditUOMFieldsLocator;

	@FindBy(xpath = "//input[@title='Update Unit Of Measure']")
	private WebElement updateUomLocator;

	@FindBy(xpath = "//a[@title='History']/descendant::img[@src='/CIMM2Touch/images/small/history.png']")
	private WebElement historyLinkLocator;

	@FindBy(xpath = "//span[contains(text(),'Total Count :')]")
	private WebElement totalCountLocator;

	@FindBy(xpath = "//span[contains(text(),'Total Count :')]/following-sibling::span")
	private WebElement numberOfUomCountLocator;

	/*@FindAll(value = { @FindBy(xpath = "//input[@title='Edit Unit Of Measure']") })
	private List<WebElement> editButtonsLocator;*/

	@FindBy(xpath = "//div[contains(text(),'Display ')]/select")
	private WebElement selectRecordsDropdownLocator;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement updateWelcomeMessage;

	@FindBy(xpath = "//input[@id='EditUnitOfMeasureForm:umName']")
	private WebElement updatedUomNameTextBoxLocator;

	@FindBy(xpath = "//span[contains(text(),'No results Found')]")
	private WebElement noResultFoundLocator;
	
	@FindAll(value={@FindBy(xpath="//tbody[@id='listUnitOfMeasureForm:unitOfMeasureTableId:tb']/tr")})
	private List<WebElement> numberOfRowCountLocator;

	@Step("This method verify  bread crumbs of UOM page")
	public UOMPageObjects verifyTheUOMPageBreadCrumbs(String breadCrumbsList) {
		String breadcrumbsList[] = breadCrumbsList.split(",");
		waiting.explicitWaitVisibilityOfElements(breadCrumbsLink, 45);
		for (int i = 0; i < breadCrumbsLink.size(); i++)
			Assert.assertEquals(breadCrumbsLink.get(i).getText().trim(), breadcrumbsList[i].trim());
		return this;
	}

	@Step("verify header part of UOM page")
	public UOMPageObjects verifyTheUOMPageHeaderPortion(String headerList) {
		String headerList1[] = headerList.split(",");
		waiting.explicitWaitVisibilityOfElements(headerLink, 35);
		for (int i = 0; i < headerLink.size(); i++) {
			Assert.assertEquals(headerLink.get(i).getText().trim(), headerList1[i].trim());
		}
		return this;
	}

	@Step("verify fields when click on add link of UOM page")
	public UOMPageObjects verifyAllAddNewUOMFields(String addNewUOMField) {
		String addNewUOMField1[] = addNewUOMField.split(",");
		waiting.explicitWaitVisibilityOfElements(allAddNewUOMFieldsLocator, 45);
		for (int i = 0; i < allAddNewUOMFieldsLocator.size(); i++) {
			Assert.assertEquals(allAddNewUOMFieldsLocator.get(i).getText().trim(), addNewUOMField1[i].trim());
		}
		return this;
	}

	@Step("This method is used verify the TotalCount In UOMPage")
	public UOMPageObjects verifyTotalCountInUOMPage() {
		waiting.explicitWaitVisibilityOfElement(totalCountLocator, 40);
		Assert.assertTrue(totalCountLocator.isDisplayed(), "TotalCount name is not displayed.");
		return this;
	}

	@Step("verify search field of UOM ")
	public UOMPageObjects verifySearchFieldInUOMPage(String placeHolderText) {
		waiting.explicitWaitVisibilityOfElement(uomSearchPlaceHolder, 40);
		Assert.assertTrue(uomSearchPlaceHolder.isDisplayed(), "SearchField is not displayed.");
		Assert.assertEquals(uomSearchPlaceHolder.getAttribute("placeholder"), placeHolderText);
		return this;
	}

	@Step("This method is used verify the AddNewUOM Link In ProductsPage")
	public UOMPageObjects verifyAddNewProductLinkInUOMPage() {
		waiting.explicitWaitVisibilityOfElement(addNewUOMLocator, 40);
		Assert.assertTrue(addNewUOMLocator.isDisplayed(), "Add New UOM Link is not displayed.");
		return this;
	}

	@Step("This method is used verify the DisplayRecords In UOMPage")
	public UOMPageObjects verifyDisplayRecordsInUOMPage() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(displayRecordsLocator, 40);
		Assert.assertTrue(displayRecordsLocator.isDisplayed(), "DisplayRecords is not displayed.");
		return this;
	}

	@Step("click on add new product")
	public UOMPageObjects clickOnAddNewUOMLink() throws Exception {
		waiting.explicitWaitVisibilityOfElement(addNewUOMLocator, 65);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", addNewUOMLocator);
		Thread.sleep(1500);
		return this;
	}

	@Step("search for uom {0} name")
	public UOMPageObjects searchForUOM(String uomName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(uomSearchPlaceHolder, 50);
		uomSearchPlaceHolder.clear();
		uomSearchPlaceHolder.sendKeys(uomName);
		return this;
	}

	@Step("click on search field")
	public UOMPageObjects clickOnUomSearchCategory() throws InterruptedException {
		Thread.sleep(2500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchButton);
		Thread.sleep(2500);
		return this;
	}

	@Step("veify uom {0} present or not")
	public UOMPageObjects verifyUomPresent(String uomName) {

		Assert.assertFalse(assertVerifyUomPresent(uomName),
				"UOM :" + uomName + "  is already present, please remove to create it again.");
		return this;
	}

	@Step("verify created uom name{0}")
	public UOMPageObjects verifyCreatedUom(String uomName) throws InterruptedException {
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifyUomPresent(uomName), "UOM :" + uomName + "  is not present.");
		return this;
	}

	private boolean assertVerifyUomPresent(String uomName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(
					By.xpath("//tbody[@id='listUnitOfMeasureForm:unitOfMeasureTableId:tb']/descendant::td[text()='"
							+ uomName + "']"))
					.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	@Step("create new uom  name: {0} , Description {1}")
	public UOMPageObjects createUom(String uomName, String uomDescription) throws Exception {
		clickOnAddNewUOMLink();

		enterTheUomName(uomName)
		.enterTheUomDescription(uomDescription)
		.clickOnSaveLink();
		return this;
	}

	@Step("enter UOM Name:{0}")
	public UOMPageObjects enterTheUomName(String uomName) {
		waiting.explicitWaitVisibilityOfElement(uOMNameTextBox, 30);
		uOMNameTextBox.clear();
		uOMNameTextBox.sendKeys(uomName);
		return this;
	}

	@Step("enter UOM Des:{0}")
	public UOMPageObjects enterTheUomDescription(String uomDescription) {
		uOMDescriptionTextBox.sendKeys(uomDescription);
		return this;
	}

	@Step("click on save link of UOM")
	public UOMPageObjects clickOnSaveLink() throws InterruptedException {
		uOMsaveLink.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("verify welcome message:{0}")
	public UOMPageObjects verifySuccessMessage(String welcomeMessage) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(welcomeMessagelocator.getText(), welcomeMessage);
		return this;
	}

	@Step("click on edit link of UOM page")
	public UOMPageObjects clickOnEditUom(String uomName) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath(
						"//td[text()='" + uomName + "']/ancestor::tr/descendant::input[@title='Edit Unit Of Measure']"),
				30);
		getDriver()
				.findElement(By.xpath(
						"//td[text()='" + uomName + "']/ancestor::tr/descendant::input[@title='Edit Unit Of Measure']"))
				.click();
		return this;
	}

	@Step("click on edit link of UOM page that match part of String also")
	public UOMPageObjects clickOnEditUomPartialMatch(String uomName) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//td[contains(text(),'" + uomName
				+ "')]/ancestor::tr/descendant::input[@title='Edit Unit Of Measure']"), 30);
		getDriver().findElement(By.xpath("//td[contains(text(),'" + uomName
				+ "')]/ancestor::tr/descendant::input[@title='Edit Unit Of Measure']")).click();
		return this;
	}

	@Step("verify fields of edit in UOM page")
	public UOMPageObjects verifyAllEditUOMFields(String editFieldOfUOM) throws InterruptedException {
		String editFieldOfUOM1[] = editFieldOfUOM.split(",");
		// Thread.sleep(3500);
		waiting.explicitWaitVisibilityOfElements(allEditUOMFieldsLocator, 55);
		for (int i = 0; i < allEditUOMFieldsLocator.size(); i++) {
			Assert.assertEquals(allEditUOMFieldsLocator.get(i).getText().trim(), editFieldOfUOM1[i].trim());
		}
		return this;
	}

	@Step("click on update link")
	public UOMPageObjects clickOnUpdateUomLink() {
		waiting.explicitWaitVisibilityOfElement(updateUomLocator, 30);
		updateUomLocator.click();
		return this;
	}

	@Step("verifying update  welcome message {0}")
	public UOMPageObjects verifyUpdateWelcomeMessage(String welcomeMessage) {
		waiting.explicitWaitVisibilityOfElement(updateWelcomeMessage, 15);
		Assert.assertEquals(updateWelcomeMessage.getText(), welcomeMessage,
				"Invalid update welcome message.Getting" + updateWelcomeMessage.getText() + ".");
		return this;
	}

	@Step("selecting {0} number of records to display.")
	public UOMPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay)
			throws Exception {
		Select select = new Select(selectRecordsDropdownLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(4000);
		return this;
	}
	
	

	@Step("verifying whether {0} is the number of records that is displayed.")
	public UOMPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception {
		Thread.sleep(3500);
		try {

			waiting.explicitWaitVisibilityOfElements(numberOfRowCountLocator, 60);
			Assert.assertTrue(
					assertForNumberOfRowsDisplayed(numberOfRowCountLocator.size(),
							Integer.parseInt(getNumberOfRecordsToDisplay)),
					"DISPLAYED RECORDS WERE MORE THAN EXPECTED");
		} catch (StaleElementReferenceException e) {

			getDriver().navigate().refresh();
			verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
		}
		return this;
	}

	private boolean assertForNumberOfRowsDisplayed(int rowCount, int numberOfRecordsToDisplay) {
		if (rowCount <= numberOfRecordsToDisplay) {
			return true;
		} else {
			return false;
		}
	}

	public UOMPageObjects verifyWhetherSearchedUomNameCountIsOne(String countOfUomName) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(numberOfUomCountLocator, 45);

		Assert.assertEquals(numberOfUomCountLocator.getText(), countOfUomName, "count was not equal to expected: "
				+ numberOfUomCountLocator.getText() + " but found " + countOfUomName + "");

		return this;

	}

	public UOMPageObjects verifyErrorTotalCount(String countOfUomName) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(numberOfUomCountLocator, 45);

		Assert.assertEquals(numberOfUomCountLocator.getText(), countOfUomName, "count was not equal to expected: "
				+ numberOfUomCountLocator.getText() + " but found " + countOfUomName + "");
		return this;

	}

	@Step("verify history icon of UOM page")
	public UOMPageObjects verifyWhetherHistoryIconPresent() throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(historyLinkLocator, 30);
		Assert.assertTrue(historyLinkLocator.isDisplayed(), "History Icon of the UOM edit page doesn't present");
		return this;

	}

	@Step("click on history link")
	public UOMPageObjects clickOnUomHistoryLink() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(historyLinkLocator, 30);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", historyLinkLocator);
		Thread.sleep(1500);
		return this;
	}

	public boolean assertAlertMsg(String alertText) throws InterruptedException {
		waiting.explicitWaitForAlert(5);
		boolean t = tu.getAlertText().trim().equals(alertText.trim());
		tu.alertAccept();
		Thread.sleep(2000);
		return t;

	}

	@Step("verify alert mseeage")
	public UOMPageObjects verifyAlertMsg(String alertText) throws InterruptedException {
		Assert.assertTrue(assertAlertMsg(alertText));
		utility.switchToRecentWindow();
		return this;

	}

	@Step("verify no result found error message")
	public UOMPageObjects verifyErrorMessage(String errorMessage) {
		waiting.explicitWaitVisibilityOfElement(noResultFoundLocator, 35);
		Assert.assertEquals(noResultFoundLocator.getText(), errorMessage);
		return this;
	}

	@Step("enter updated UOM Name:{0}")
	public UOMPageObjects enterTheUpdatedUomName(String updatedUomName) {

		waiting.explicitWaitVisibilityOfElement(updatedUomNameTextBoxLocator, 30);
		updatedUomNameTextBoxLocator.clear();
		updatedUomNameTextBoxLocator.sendKeys(updatedUomName);
		return this;
	}

	@Step("create updated uom name:{0}")
	public UOMPageObjects createUpdatedUom(String updatedUomName) throws InterruptedException {

		enterTheUpdatedUomName(updatedUomName);
		return this;

	}

}
