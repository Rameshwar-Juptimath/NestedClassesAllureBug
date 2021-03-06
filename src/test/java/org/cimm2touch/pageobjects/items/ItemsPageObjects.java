package org.cimm2touch.pageobjects.items;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
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

public class ItemsPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());

	@FindBy(xpath = "//input[@title='Add New Item']")
	private WebElement addNewItemLinkLocator;

	@FindBy(xpath = "//div[@class='rightSliderRightArrow']")
	private WebElement rightArrowLocator;

	@FindBy(xpath = "//input[@name='searchFormId:searchKeywordId']")
	private WebElement advanceSearchInputTextField;

	@FindBy(xpath = "(//div[@class='advancedSearchBtn']/input)[1]")
	private WebElement advancedSearchButtonLocator;

	@FindBy(xpath = "//span[@class='breadCrumb_LastChild']/descendant::a[text()='Items']")
	private WebElement itemsBreadCrumpWhenInItemsLandingPageLocator;

	@FindBy(xpath = "//select[@id='headerForm:moduleCmBxId']")
	private WebElement generalSearchDropDown;

	@FindBy(xpath = "//input[@id='headerForm:searchKeywordId']")
	private WebElement searchTextBoxLocator;

	@FindBy(xpath = "//a[@id='headerForm:mainGoBtn']/i")
	private WebElement searchButtonLocator;

	@FindBy(xpath = "//table[@id='searchFormId:itemListTableId']/tbody/tr[1]/td[5]")
	private WebElement itemVerifyLocator;

	@FindBy(xpath = "//table[@id='listUsersForm:userDataTable']/tbody/tr[1]/td[3]")
	private WebElement cimmUserVerify;

	@FindBy(xpath = "//table[@id='subsetForm:subsetTableId']/tbody/tr[1]/td[4]/span")
	private WebElement subsetVerifyLocator;

	@FindAll(value = { @FindBy(xpath = "//tbody[@id='staticPagesListFormId:staticPagesTableId:tb']/tr") })
	private List<WebElement> staticPageVerifyLocator;

	@FindBy(xpath = "//table[@id='listWarehouseForm:warehouseDataTable']/tbody/tr[1]/td[3]/span")
	private WebElement warehouseVerifyLocator;

	@FindBy(xpath = "//div[@class='custDropDownHeader']")
	private WebElement workbookDropDownLocator;

	@FindBy(xpath = "//span[@id='searchFormId:wrkbookListId']/div/div[1]")
	private WebElement WorkbookDropDownLocator;

	@FindBy(xpath = "//input[@id='searchFormId:workBookNameId']")
	private WebElement WorkbookTextBoxLocator;

	@FindBy(xpath = "//input[@title='Add New Workbook']")
	private WebElement WorkbookSaveLocator;

	@FindBy(xpath = "//span[@id='searchFormId:addNewWrkBookMes']")
	private WebElement workbookSuccessmsgLocator;

	@FindBy(xpath = "//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::input[@title='Remove this WorkBook']")
	private WebElement workbookDeleteIcon;

	@FindBy(xpath = "//span[@id='searchFormId:smid1']")
	private WebElement workbookdeleteSuccessMsg;

	@FindBy(xpath = "//input[@id='searchFormId:searchKeywordId']")
	private WebElement itemSearchLocator;

	@FindBy(xpath = "//input[@id='searchFormId:subgoBtn11']")
	private WebElement itemSearchButtonLocator;

	@FindBy(xpath = "//table[@id='searchFormId:itemListTableId']/tbody/tr[1]/td[1]/div/input[@title='Remove Item']")
	private WebElement itemDeleteLocator;

	@FindBy(xpath = "//table[@id='searchFormId:itemListTableId']/tbody/tr[1]/td[5]")
	private WebElement itemPartnumberLocator;

	@FindBy(xpath = "//input[@id='searchFormId:itemListTableId:SALL']")
	private WebElement selectAllLocator;

	@FindBy(xpath = "//a[contains(text(),'aaaaa')]")
	private WebElement selectWorkbookLocator;

	@FindBy(xpath = "//input[@id='generalInfoFormId:partNumberId']")
	private WebElement partNumberInputFieldItemEditPage;

	@FindBy(xpath = "//a[@id='searchFormId:selectedWBId']")
	private WebElement clickOnWorkbookLocator;

	@FindBy(xpath = "//span[@id='searchFormId:addNewWrkBookMes']")
	private WebElement itemAddedSuccessMsgLocator;

	@FindBy(xpath = "//a[@id='searchFormId:selectedWBId']")
	private WebElement itemcountinLocator;

	@FindBy(xpath = "//span[@id='searchFormId:addNewWrkBookMes']")
	private WebElement workbookalreadyExitingMsgLocator;

	@FindBy(xpath = "//span[@id='searchFormId:smid']")
	private WebElement itemsCountLocator;

	@FindBy(xpath = "//table[@id='searchFormId:workBookDataTable']/tbody/tr[1]/td[1]/a")
	private WebElement WorkbookItemsCountLocator;

	@FindBy(xpath = "//div[contains(@class,'displayRecords')]/select")
	private WebElement selectRecordsDropdownLocator;

	@FindAll(value = { @FindBy(xpath = "//input[@title='Edit Item']") })
	private List<WebElement> editButtonsLocator;

	@FindBy(xpath = "//div[@class='setting-icon']")
	private WebElement settingsIconLocator;

	@FindBy(xpath = "//li[@class='show-dyna-table-setting']")
	private WebElement showFieldsLocator;

	@FindBy(xpath = "//div[contains(text(),'Dynamic Table Settings')]")
	private WebElement dynamicTableSettingsHeadingLocator;

	@FindAll(value = {
			@FindBy(xpath = "//div[contains(text(),'Dynamic Table Settings')]/following-sibling::div/descendant::th") })
	private List<WebElement> dynamicTableSettingsTableHeadersLocator;

	@FindAll(value = {
			@FindBy(xpath = "//div[contains(text(),'Field Names')]/ancestor::thead/following-sibling::tbody/tr/descendant::span[1]") })
	private List<WebElement> fieldNamesDynamicSettingsTableLocator;

	@FindAll(value = {
			@FindBy(xpath = "//div[contains(text(),'Display Names')]/ancestor::thead/following-sibling::tbody/tr/descendant::td/input") })

	@FindBy(xpath = "//input[@id='searchFormId:taxonomyListComboIdcomboboxField']")
	private WebElement taxonomySearchInLeftPanel;

	@FindBy(xpath = "//input[@id='searchFormId:applyFilterId']")
	private WebElement filterTaxonomyLink;

	@FindAll(value = {
			@FindBy(xpath = "//div[contains(text(),'Display Names')]/ancestor::thead/following-sibling::tbody/tr/descendant::td/input") })
	private List<WebElement> displayNamesInDynamicSettingsTableLocator;

	@FindBy(xpath = "(//span[contains(text(),'Manufacturer Part Number')]/ancestor::td/following-sibling::td/descendant::label)[1]")
	private WebElement mPNCheckboxDesktopViewLocator;

	@FindBy(xpath = "//div[@class='pull-right']/input")
	private WebElement saveButtonLocator;

	@FindBy(xpath = "//span[@id='searchFormId:itemListTableId:MPN' and contains(text(),'Manufacturer Part Number')]")
	private WebElement mpnColumnLocator;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter Category to Search')]")
	private WebElement searchTextboxInTaxonomySectionLocator;

	@FindBy(xpath = "//input[@title='Edit Taxonomy']")
	private WebElement editTaxonomyLinkLocator;

	@FindBy(xpath = "//input[@title='Filter']")
	private WebElement filterTaxonomyLinkLocator;

	@FindBy(xpath = "//input[@title='Clear']")
	private WebElement clearTaxonomyLinkLocator;

	@FindBy(xpath = "//input[@title='Collapse Tree']")
	private WebElement collapseTreeLocator;

	@FindBy(xpath = "//input[@title='Refresh Search']")
	private WebElement refreshSearchLocator;

	@FindBy(xpath = "//div[@class='cimmSearch']/descendant::a[contains(@title,'Search')]")
	private WebElement searchIconLocator;

	@FindBy(xpath = "//input[@name='searchFormId:taxonomyListComboIdcomboboxField']")
	private WebElement defaultTaxonomyLocator;

	@FindAll(value = {
			@FindBy(xpath = "//div[@class='treeCategoryName']/descendant::span[contains(@id,'treeNodeDataId')]") })
	private List<WebElement> listOnLevelOneCategoriesLocator;

	@FindBy(xpath = "//span[@class='breadCrumb_LastChild']/span/span/a")
	private WebElement itembreadcrumb;

	@FindBy(xpath = "//div[@class='supplier-search-header']")
	private WebElement as_vendorfilter;

	@FindBy(xpath = "//input[@class='supplierSearchTextBox']")
	private WebElement as_Vendorfiltersearchfield;

	@FindBy(xpath = "//input[@class='manufacturerSearchTextBox']")
	private WebElement as_Manufacturerfiltersearchfield;

	@FindBy(id = "searchFormId:supgoBtn")
	private WebElement as_vendorfiltersearchbutton;

	@FindBy(id = "searchFormId:searchInId")
	private WebElement advancedSearchselectLoc;

	@FindBy(xpath = "//*[@title='Add New Item']")
	private WebElement addNewItemLinklocator;

	@FindBy(xpath = "//span[@class='breadCrumb_LastChild']/following-sibling::span[contains(text(),'Add New Item')]")
	private WebElement addNewItemsection;

	@FindBy(xpath = "//form[@id='generalInfoFormId']/descendant::input[@title='Save New Item']")
	private WebElement savenewItem;

	@FindBy(id = "searchFormId:searchKeywordId")
	private WebElement advancedSearchTopSearchField;

	@FindBy(id = "searchFormId:subgoBtn11")
	private WebElement advancedSearchTopSearchButton;

	@FindBy(xpath = "//tbody[@id='searchFormId:itemListTableId:tb']/tr[1]/td[5]")
	private WebElement searchResults;

	@FindBy(id = "generalInfoFormId:manufacturerListComboIdcomboboxField")
	private WebElement itemManufacturerfield;

	@FindBy(xpath = "//div[@class='attr-search-header']")
	private WebElement as_Brandfilter;

	@FindBy(xpath = "//div[@class='subset-search-header']")
	private WebElement as_Subsetfilter;

	@FindBy(xpath = "//div[@class='adv-search-btn']/input[@id='searchFormId:brdsearchBtn']")
	private WebElement as_Brandfiltersearchbutton;

	@FindBy(xpath = "//input[@class='subsetSearchTextBox']")
	private WebElement as_Subsetfiltersearchfield;

	@FindBy(id = "searchFormId:subgoBtn")
	private WebElement as_Subsetfiltersearchbutton;

	@FindBy(xpath = "//input[@class='brandSearchTextBox']")
	private WebElement as_Brandfiltersearchfield;

	@FindBy(id = "generalInfoFormId:brandListComboIdcomboboxField")
	private WebElement itemBrandField;

	@FindBy(xpath = "//div[@class='adv-search-btn']/input[@id='searchFormId:mfrgoBtn']")
	private WebElement as_Manufacturerfiltersearchbutton;

	@FindBy(id = "generalInfoFormId:partNumberId")
	private WebElement itemPartNumberField;

	@FindBy(xpath = "//td[@id='GInfoTab']/descendant::input[@id='generalInfoFormId:mpnTxtId']")
	private WebElement itemManufacturerPartNumberField;

	@FindBy(xpath = "//span[contains(text(),'Supplier')]/ancestor::div/following-sibling::div/descendant::input[contains(@id,'supplierListComboIdcomboboxField')]")
	private WebElement itemSupplierField;

	@FindBy(xpath = "//form[@id='generalInfoFormId']/div/span[3]")
	private WebElement savenewItemMessageLocator;

	@FindBy(xpath = "//td[@id='CPTab_lbl']")
	private WebElement customPricesTabLocator;

	@FindBy(id = "CPsaveMsgId")
	private WebElement subsetassigntoitemmessageloc;

	@FindBy(xpath = "//span[@id='searchFormId:deleteSearchItmMsg']")
	private WebElement advancedSearchErrorMessageLoc;

	@FindBy(xpath = "//div[@class='manufacturer-search-header']")
	private WebElement as_Manufacturerfilter;

	@FindBy(xpath = "//tbody[@id='searchFormId:itemListTableId:tb']/tr[1]/td[3]")
	private WebElement itemIdInTableLocator;

	@FindBy(xpath = "//select[@id='searchFormId:dispOnline']")
	private WebElement displayOnlineDropdown;

	@FindBy(id = "searchFormId:goBtn")
	private WebElement bottomSearchButton;

	@FindBy(id = "searchFormId:activeId")
	private WebElement itemstatusDropdown;

	@FindBy(xpath = "//select[@id='searchFormId:rbtAttributes']//option[text()='Ignore']")
	private WebElement ignoreAttributes_SubFilter;

	@FindBy(xpath = "//td/select[@name='searchFormId:rbtImages']/option[@value='WithImages']")
	private WebElement imageSubfilterLocator;

	@FindAll(value = { @FindBy(xpath = "//input[@title='Edit Item']") })
	private List<WebElement> editItemLink;

	@FindBy(xpath = "//div[@class='dynamic-tabel-settings customGenericAlign']/descendant::img[@class='gearIcon']")
	private WebElement genericColumnSettingIconLocator;

	@FindBy(xpath = "//li[@class='show-dyna-table-setting']/a")
	private WebElement showFieldsSettingLoc;

	@FindBy(xpath = "//li[@class='show-sort-settings']/a")
	private WebElement showSortSettingLoc;

	@FindBy(xpath = "//input[@id='itemNavigateForm:nextItemIcon']")
	private WebElement nextItemIconLocator;

	/*
	 * @FindBy(xpath =
	 * "//select[@id='searchFormId:rbtAttributes']//option[text()='Attributes ']"
	 * ) private WebElement withAttributes_SubFilter;
	 */

	@FindBy(xpath = "//select[@id='searchFormId:rbtAttributes']//option[text()='No Attributes ']")
	private WebElement noAttributes_SubFilter;

	@FindBy(xpath = "//select[@id='searchFormId:joinOpId']//option[@value='joinOperatorAND']")
	private WebElement combineOptions_AND_SubFilter;

	@FindBy(xpath = "//select[@id='searchFormId:joinOpId']//option[@value='joinOperatorOR']")
	private WebElement combineOptions_OR_SubFilter;

	@FindBy(xpath = "//select[@name= 'searchFormId:rbtCategorized']/option")
	private WebElement itemCategorizedDropdown;

	@FindBy(xpath = "//select[@name= 'searchFormId:rbtCategorized']/option[text()= 'UnCategorized ']")
	private WebElement itemUnCategorizedDropdown;

	@FindBy(xpath = "//span[@id='searchFormId:deleteSearchItmMsg']")
	private WebElement succesfulItemDeleteMessage;

	@FindBy(xpath = "//li[@class='editItem_displayOn']/descendant::input")
	private WebElement displayOnlineItemCheckBox;

	@FindBy(xpath = "//div[contains(text(),'Dynamic Table Settings')]")
	private WebElement dynamicTableSettingSection;

	@FindBy(xpath = "//div[contains(text(),'Sort Order Settings')]")
	private WebElement sortOrderSettingSection;

	@FindBy(xpath = "//input[@id='copyOfItemFormId:partNumber']")
	private WebElement enterPartNumberTextField;

	@FindBy(xpath = "//input[@id='copyOfItemFormId:noOfCopies']")
	private WebElement enterTheNumberOfCopiesTextField;

	@FindBy(xpath = "//input[@title='Reset']/following-sibling::input[contains(@title,'Save')]")
	private WebElement saveIconToCopyLink;

	@Step("select checkbox for MPN under desktop view.")
	public ItemsPageObjects selectCheckboxOfManufacturerPartNumberInDesktopViewForAdding() throws Exception {

		// ((JavascriptExecutor)
		// getDriver()).executeScript("arguments[0].click();",chooseMPNDesktopViewLocator);
		waiting.explicitWaitVisibilityOfElement(mPNCheckboxDesktopViewLocator, 5);
		if (mPNCheckboxDesktopViewLocator.getAttribute("checked") == null) {
			mPNCheckboxDesktopViewLocator.click();
		}
		return this;
	}

	@Step("select checkbox for MPN under desktop view.")
	public ItemsPageObjects selectCheckboxOfManufacturerPartNumberInDesktopViewForRemoving() throws Exception {

		// ((JavascriptExecutor)
		// getDriver()).executeScript("arguments[0].click();",chooseMPNDesktopViewLocator);
		waiting.explicitWaitVisibilityOfElement(mPNCheckboxDesktopViewLocator, 5);
		mPNCheckboxDesktopViewLocator.click();
		return this;
	}

	@Step("enter {0} in the search textbox of the taxonomy tree.")
	public ItemsPageObjects enterSearchCategory(String searchCategory) {

		waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchCategory);
		return this;
	}

	@Step("click on search category")
	public ItemsPageObjects clickOnSearchCategory() throws InterruptedException {
		Thread.sleep(2500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchIconLocator);
		Thread.sleep(3500);
		return this;
	}

	@Step("verify whether the search textbox does not contain {0} text")
	public ItemsPageObjects verifyClearingOfSearchTextbox(String searchCategory) {

		Assert.assertEquals(searchTextboxInTaxonomySectionLocator.getAttribute("value").trim(), searchCategory);
		return this;
	}

	@Step("click on filter")
	public ItemsPageObjects clickOnFilter() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(filterTaxonomyLinkLocator, 40);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", filterTaxonomyLinkLocator);
		Thread.sleep(3500);
		return this;
	}

	@Step("click on any edit button")
	public EditItemsPageObjects clickOnSpecificEditButton(int specificEditButton) throws InterruptedException {

		Thread.sleep(2500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				editButtonsLocator.get(specificEditButton - 1));
		Thread.sleep(2500);
		return new EditItemsPageObjects();
	}

	@Step("click on specific edit button")
	public EditItemsPageObjects clickOnSpecificItemEditButton(String itemPartnumber) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemPartnumber + "')]/preceding-sibling::td/descendant::input[@title='Edit Item']"),
				50);
		getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemPartnumber + "')]/preceding-sibling::td/descendant::input[@title='Edit Item']"))
				.click();
		Thread.sleep(2500);
		return new EditItemsPageObjects();
	}

	@Step("verify whether the {0} category that was filtered is highlighted in a colored background by clicking on the left navigation bar")
	public ItemsPageObjects verifyWhetherTheCategoryIsHighLighted(String categoryToSearch) {
		try {
			Thread.sleep(1700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(
				getDriver().findElement(By.xpath("//table[contains(@id,'taxonomyTreeNodeId')]/descendant::span[text()='"
						+ categoryToSearch + "']/ancestor::div[1]")).getCssValue("background"),
				"rgb(241, 250, 141) none repeat scroll 0% 0%",
				"The colour of the category chosen has not turned into a different color. Colour I am expected to change is rgb(241, 250, 141) but found to be "
						+ getDriver().findElement(
								By.xpath("//table[contains(@id,'taxonomyTreeNodeId')]/descendant::span[text()='"
										+ categoryToSearch + "']/ancestor::div[1]"))
								.getCssValue("background")
						+ ".");
		return this;
	}

	@Step("click on remove filter")
	public ItemsPageObjects clickOnRemoveFilter() {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", clearTaxonomyLinkLocator);
		return this;
	}

	@Step("select the checkbox for {0}")
	public ItemsPageObjects clickOnSpecificCategory(String categoryToSearch) throws InterruptedException {
		Thread.sleep(3500);
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[text()='" + categoryToSearch
				+ "']/ancestor::div[@class='treeCategoryName']/descendant::label[@class='custChkBx']"), 30);
		WebElement specificCategory = getDriver().findElement(By.xpath("//span[text()='" + categoryToSearch
				+ "']/ancestor::div[@class='treeCategoryName']/descendant::label[@class='custChkBx']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", specificCategory);
		return this;
	}

	@Step("verify whether the checkbox associated to {0} category is ticked")
	public ItemsPageObjects verifyCategoryChosenIsSelected(String categoryToSearch) {
		String specificCategoryString = "//span[text()='" + categoryToSearch
				+ "']/ancestor::div[@class='treeCategoryName']/descendant::label[@class='custChkBx']";

		WebElement specificCategory = getDriver().findElement(By.xpath(specificCategoryString));
		waiting.explicitWaitVisibilityOfElement(specificCategory, 5);
		Assert.assertEquals(
				getDriver().findElement(By.xpath(specificCategoryString + "/input")).getAttribute("checked"), "true");
		return this;
	}

	@Step("Verify whether the checkbox that was associated to {0} category that was ticked is unticked")
	public ItemsPageObjects verifyCategoryChosenIsNotSelected(String categoryToSearch) {
		String specificCategoryString = "//span[text()='" + categoryToSearch
				+ "']/ancestor::div[@class='treeCategoryName']/descendant::label[@class='custChkBx']";

		WebElement specificCategory = getDriver().findElement(By.xpath(specificCategoryString));
		waiting.explicitWaitVisibilityOfElement(specificCategory, 5);
		Assert.assertEquals(
				getDriver().findElement(By.xpath(specificCategoryString + "/input")).getAttribute("checked"), null);
		return this;
	}

	@Step("click on add new Item")
	public AddNewItemPageObjects clickOnAddNewItem() throws Exception {
		waiting.explicitWaitElementToBeClickable(addNewItemLinkLocator, 30);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", addNewItemLinkLocator);

		return new AddNewItemPageObjects();
	}

	public ItemsPageObjects verifyItemsPageBreadCrump() throws Exception {
		Thread.sleep(3000);
		Assert.assertEquals(itemsBreadCrumpWhenInItemsLandingPageLocator.getText().trim(), "Items");
		return this;
	}

	@Step("select item option from the drop down & search ")
	public ItemsPageObjects verifyGeneralSearch(String dropdownvalue, String searchabledata) throws Exception {
		waiting.explicitWaitVisibilityOfElement(generalSearchDropDown, 15);
		Select s = new Select(generalSearchDropDown);
		switch (dropdownvalue) {

		case "Items":
			s.selectByVisibleText(dropdownvalue);
			enterValueToSearchField(searchabledata);
			clickOnGoButton();
			Thread.sleep(3000);
			verifyItemSearchResults(searchabledata);
			break;

		case "CIMM User":
			s.selectByVisibleText(dropdownvalue);
			enterValueToSearchField(searchabledata);
			clickOnGoButton();
			Thread.sleep(3000);
			verifyCIMMUserName(searchabledata);
			break;

		case "Subset":
			s.selectByVisibleText(dropdownvalue);
			enterValueToSearchField(searchabledata);
			clickOnGoButton();
			Thread.sleep(3000);
			verifySearchedsubset(searchabledata);
			break;

		case "Static Pages":
			s.selectByVisibleText(dropdownvalue);
			enterValueToSearchField(searchabledata);
			clickOnGoButton();
			Thread.sleep(3000);
			verifySearchedstaticPage(searchabledata);
			break;

		case "Warehouse":
			s.selectByVisibleText(dropdownvalue);
			enterValueToSearchField(searchabledata);
			clickOnGoButton();
			Thread.sleep(3000);
			verifySearchedWarehouse(searchabledata);
			break;

		default:
			throw new Exception("invalid input");
		}
		return this;
	}

	private void verifySearchedWarehouse(String searchabledata) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(warehouseVerifyLocator.getText().trim(), searchabledata);
	}

	private void verifySearchedstaticPage(String searchabledata) throws InterruptedException {
		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElements(staticPageVerifyLocator, 50);
		Assert.assertTrue(staticPageVerifyLocator.get(0).isDisplayed(), "Static data is not avaiable");

	}

	private void verifySearchedsubset(String searchabledata) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(subsetVerifyLocator.getText().trim(), searchabledata);

	}

	public ItemsPageObjects clickOnGoButton() throws InterruptedException {
		Thread.sleep(3000);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchButtonLocator);
		return this;
	}

	@Step("Click on delete icon for the item name {0}")
	public ItemsPageObjects verifyAndRemoveItem(String CreatedpartNumber) throws Exception {
		Thread.sleep(2500);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				getDriver().findElement(By.xpath("//td[contains(text(),'" + CreatedpartNumber
						+ "')]/preceding-sibling::td/descendant::input[@title='Remove Item']")));

		tu.alertAccept();
		return this;
	}

	@Step("Click on delete icon for the item name {0}")
	public ItemsPageObjects verifyAndRemoveCreatedItem(String CreatedpartNumber, String noOfItemsTobeDelete)
			throws Exception {

		int items = Integer.parseInt(noOfItemsTobeDelete);
		String partNuber = null;
		for (int i = 1; i <= items; i++) {
			waiting.explicitWaitVisibilityOfElement(By.xpath("//td[contains(text(),'" + CreatedpartNumber + i + "')]"),
					30);
			WebElement wb = getDriver().findElement(By.xpath("//td[contains(text(),'" + CreatedpartNumber + i + "')]"));
			Assert.assertTrue(wb.isDisplayed(), "Item is not available");
			partNuber = getDriver().findElement(By.xpath("//td[contains(text(),'" + CreatedpartNumber + i
					+ "')]/preceding-sibling::td/descendant::span[contains(@id,'ITMID')]")).getText();
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
					getDriver().findElement(By.xpath("//td[contains(text(),'" + CreatedpartNumber + i
							+ "')]/preceding-sibling::td/descendant::input[@title='Remove Item']")));

			tu.alertAccept();
			Thread.sleep(2000);
			waiting.explicitWaitVisibilityOfElement(succesfulItemDeleteMessage, 30);
			Assert.assertEquals(succesfulItemDeleteMessage.getText().trim(),
					"Item with Part No. : '" + CreatedpartNumber + i + "' removed Successfully");
			Thread.sleep(3000);
		}
		return this;

	}

	private void enterValueToSearchField(String searchabledata) {
		searchTextBoxLocator.clear();
		searchTextBoxLocator.sendKeys(searchabledata);
	}

	public ItemsPageObjects verifyItemSearchResults(String partNumberField) throws InterruptedException {
		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'"
						+ partNumberField + "')]"),
				20);
		WebElement wb = getDriver()
				.findElement(By.xpath("//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'"
						+ partNumberField + "')]"));
		Assert.assertEquals(wb.getText().trim(), partNumberField);
		return this;
	}

	public ItemsPageObjects verifyCIMMUserName(String userName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//table[@id='listUsersForm:userDataTable']/descendant::span[contains(text(),'" + userName + "')]"),
				30);
		WebElement wb = getDriver().findElement(By.xpath(
				"//table[@id='listUsersForm:userDataTable']/descendant::span[contains(text(),'" + userName + "')]"));
		Assert.assertEquals(wb.getText().trim(), userName);
		return this;
	}

	public ItemsPageObjects verifyWorkbookDropdownLocator() throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(workbookDropDownLocator, 40);
		Assert.assertTrue(workbookDropDownLocator.isDisplayed(), "Select workbook drop down is not displayed");
		return this;
	}

	public ItemsPageObjects clickOnWorkbookDropdown() {
		waiting.explicitWaitElementToBeClickable(WorkbookDropDownLocator, 30);
		WorkbookDropDownLocator.click();
		return this;
	}

	public ItemsPageObjects enterWorkbookName(String getworkbookname) throws InterruptedException {

		try {
			if (WorkbookTextBoxLocator.isDisplayed()) {

				WorkbookTextBoxLocator.clear();
				WorkbookTextBoxLocator.sendKeys(getworkbookname);
			}
		} catch (Exception e) {
			clickOnWorkbookDropdown();
			Thread.sleep(2500);
			enterWorkbookName(getworkbookname);
		}
		return this;

	}

	public ItemsPageObjects clickOnSaveIcon() {
		waiting.explicitWaitElementToBeClickable(WorkbookSaveLocator, 20);
		WorkbookSaveLocator.click();
		return this;

	}

	public ItemsPageObjects verifySuccessMsg(String workBookName, String workbookSuccessmsg)
			throws InterruptedException {
		Thread.sleep(4000);
		waiting.explicitWaitVisibilityOfElement(workbookSuccessmsgLocator, 40);
		Assert.assertEquals(workbookSuccessmsgLocator.getText().trim(), "'" + workBookName + "' " + workbookSuccessmsg);
		return this;
	}

	public ItemsPageObjects deleteWorkbook(String workBookName, String workbookRemovemsg) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitElementToBeClickable(WorkbookDropDownLocator, 20);
		WorkbookDropDownLocator.click();
		waiting.explicitWaitVisibilityOfElement(workbookDeleteIcon, 20);
		workbookDeleteIcon.click();

		tu.alertAccept();
		Thread.sleep(2000);
		Assert.assertEquals(workbookdeleteSuccessMsg.getText().trim(), "'" + workBookName + "' " + workbookRemovemsg);
		try {
			if (getDriver()
					.findElement(By.xpath("//a[contains(text(),'" + workBookName
							+ "')]/ancestor::tr[contains(@class,'rich-table-row')]/descendant::input[@title='Remove this WorkBook']"))
					.isDisplayed()) {
				getDriver()
						.findElement(By.xpath("//a[contains(text(),'" + workBookName
								+ "')]/ancestor::tr[contains(@class,'rich-table-row')]/descendant::input[@title='Remove this WorkBook']"))
						.click();
				waiting.explicitWaitForAlert(6);
				tu.alertAccept();
				Thread.sleep(2000);
				Assert.assertEquals(workbookdeleteSuccessMsg.getText().trim(),
						"'" + workBookName + "' " + workbookRemovemsg);
				Thread.sleep(2500);
				clickOnWorkbookDropdown();
			}
		} catch (Exception e) {
			clickOnWorkbookDropdown();
			deleteWorkbook(workBookName, workbookRemovemsg);
		}
		return this;
	}

	public ItemsPageObjects deleteItem(String partnumber) throws InterruptedException {
		searchItem(partnumber);
		Thread.sleep(5000);

		String itemPartnumber = getDriver().findElement(By.xpath(
				"//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'" + partnumber + "')]"))
				.getText().trim();
		if (partnumber.trim().equalsIgnoreCase((itemPartnumber))) {
			waiting.explicitWaitElementToBeClickable(itemDeleteLocator, 20);
			itemDeleteLocator.click();
			tu.alertAccept();
			Thread.sleep(2000);
			WebElement itemSuccessMsg = getDriver()
					.findElement(By.xpath("//span[@id='searchFormId:deleteSearchItmMsg']"));
			Assert.assertEquals(itemSuccessMsg.getText().trim(),
					"Item with Part No. : '" + partnumber + "' removed Successfully");
			Thread.sleep(3000);
		}
		return this;
	}

	public ItemsPageObjects searchItem(String partnumber) throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(itemSearchLocator, 40);
		itemSearchLocator.click();
		itemSearchLocator.clear();
		itemSearchLocator.sendKeys(partnumber);
		itemSearchButtonLocator.click();
		Thread.sleep(2000);
		return this;
	}

	public ItemsPageObjects clickOnSelectAllCheckBox() {
		selectAllLocator.click();
		return this;
	}

	public ItemsPageObjects selectWorkbook(String workBookName) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"
						+ workBookName + "')]"),
				20);
		getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"
						+ workBookName + "')]"))
				.click();
		return this;
	}

	public ItemsPageObjects clickOnWorkbookName() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(clickOnWorkbookLocator, 20);
		clickOnWorkbookLocator.click();
		Thread.sleep(2000);
		return this;
	}

	public ItemsPageObjects verifyAddItemSucessMsg(String noOfItems, String workBookName) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(itemAddedSuccessMsgLocator, 20);
		if (itemAddedSuccessMsgLocator.getText().equals("Importing...")) {
			Thread.sleep(5000);
		}
		Assert.assertEquals(itemAddedSuccessMsgLocator.getText().trim(),
				noOfItems + " " + "Items added to workbook " + workBookName);
		return this;
	}

	public ItemsPageObjects verifyWorkbookItemCount(String getworkbookitemcount) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(itemcountinLocator, 20);
		Assert.assertTrue(itemcountinLocator.getText().trim().contains(getworkbookitemcount),
				"count is not matching: " + itemcountinLocator.getText().trim() + "");
		return this;
	}

	public ItemsPageObjects verifyExistingerrormsg(String getworkbookerrormsg) throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertEquals(workbookalreadyExitingMsgLocator.getText().trim(), getworkbookerrormsg);
		return this;
	}

	public ItemsPageObjects verifyAllItemsSuccessMsg(String workbookname) throws InterruptedException {
		Thread.sleep(5000);
		String itemscount = itemsCountLocator.getText().trim();
		Assert.assertEquals(workbookSuccessmsgLocator.getText().trim(),
				"" + itemscount + " Items added to workbook " + workbookname + "");
		return this;
	}

	public ItemsPageObjects verifyAllItemsCount(String workbookname) throws InterruptedException {
		Thread.sleep(5000);
		String itemscount = itemsCountLocator.getText().trim();
		Assert.assertEquals(WorkbookItemsCountLocator.getText().trim(),
				"" + workbookname + " " + "(" + "" + itemscount + "" + ")" + "");
		return this;
	}

	@Step("selecting {0} number of records to display.")
	public ItemsPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay)
			throws Exception {
		Select select = new Select(selectRecordsDropdownLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(4000);
		return this;
	}

	@Step("verifying whether {0} is the number of records that is displayed.")
	public ItemsPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception {
		Thread.sleep(3500);
		try {

			waiting.explicitWaitVisibilityOfElements(editButtonsLocator, 60);

			Assert.assertTrue(
					assertForNumberOfRowsDisplayed(editButtonsLocator.size(),
							Integer.parseInt(getNumberOfRecordsToDisplay)),
					"DISPLAYED RECORDS WERE MORE THAN EXPECTED");
		} catch (StaleElementReferenceException e) {

			getDriver().navigate().refresh();
			verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
		}
		return this;
	}

	private boolean assertForNumberOfRowsDisplayed(int editButtons, int numberOfRecordsToDisplay) {
		if (editButtons <= numberOfRecordsToDisplay) {
			return true;
		} else {
			return false;
		}
	}

	@Step("verifying the table headings are {0} (After clicking on show fields).")
	public ItemsPageObjects verifyShowFieldsTableHeadingsInItemsPage(String[] dynamicSettingsTableHeadings) {

		waiting.explicitWaitVisibilityOfElement(dynamicTableSettingsHeadingLocator, 50);

		for (int i = 0; i < dynamicTableSettingsTableHeadersLocator.size(); i++) {

			Assert.assertEquals(dynamicTableSettingsTableHeadersLocator.get(i).getText().trim(),
					dynamicSettingsTableHeadings[i]);
		}
		return this;
	}

	@Step("clicking on settings icon.")
	public ItemsPageObjects clickOnSettingsIcon() {
		settingsIconLocator.click();
		return this;
	}

	@Step("clicking on show fields.")
	public ItemsPageObjects clickShowFields() {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", showFieldsLocator);
		return this;
	}

	@Step("verifying the table field names are {0} (After clicking on show fields).")
	public ItemsPageObjects verifyFieldNames(String[] verifyFieldNames) throws InterruptedException {

		for (int i = 0; i < fieldNamesDynamicSettingsTableLocator.size(); i++) {
			Thread.sleep(3000);
			Assert.assertEquals(fieldNamesDynamicSettingsTableLocator.get(i).getText().trim(),
					verifyFieldNames[i].trim());
		}
		return this;

	}

	@Step("verifying the table display names are {0} for the corresponding field names.")
	public ItemsPageObjects verifyDisplayNames(String[] expectedDisplayNamesInDynamicSettingsTableLocator) {
		for (int i = 0; i < fieldNamesDynamicSettingsTableLocator.size(); i++) {

			Assert.assertEquals(displayNamesInDynamicSettingsTableLocator.get(i).getAttribute("value").trim(),
					expectedDisplayNamesInDynamicSettingsTableLocator[i]);
		}
		return this;
	}

	public ItemsPageObjects selectCheckboxOfManufacturerPartNumberInDesktopView() throws Exception {

		// ((JavascriptExecutor)
		// getDriver()).executeScript("arguments[0].click();",chooseMPNDesktopViewLocator);
		waiting.explicitWaitVisibilityOfElement(mPNCheckboxDesktopViewLocator, 5);
		mPNCheckboxDesktopViewLocator.click();
		return this;
	}

	public ItemsPageObjects clickOnSaveButton() {
		saveButtonLocator.click();
		return this;
	}

	public ItemsPageObjects verifyDisplayOfManufacturerPartNumberColumn() {

		waiting.explicitWaitVisibilityOfElement(mpnColumnLocator, 10);
		Assert.assertTrue(mpnColumnLocator.isDisplayed(),
				"MPN column is not displayed eventhough we have selected the checkbox.");
		return this;
	}

	public ItemsPageObjects verifyManufacturerPartNumberColumnIsNotDisplayed() {
		Assert.assertTrue(assertManufacturerPartNumberColumnIsNotDisplayed(),
				"mpn column is displayed. Expecting it not be displayed.");
		return this;
	}

	private boolean assertManufacturerPartNumberColumnIsNotDisplayed() {
		try {
			if (mpnColumnLocator.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;
		}
		return false;
	}

	public ItemsPageObjects verifySearchTextboxInLeftNavigationbar() {

		waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		Assert.assertTrue(searchTextboxInTaxonomySectionLocator.isDisplayed(),
				"search textbox for taxonomy is not displayed.");
		return this;
	}

	public ItemsPageObjects verifyEditTaxonomyTree() {
		Assert.assertTrue(editTaxonomyLinkLocator.isDisplayed(), "Edit taxonomy link is not displayed.");
		return this;
	}

	public ItemsPageObjects verifyFilterTaxonomyTree() {
		waiting.explicitWaitVisibilityOfElement(filterTaxonomyLinkLocator, 20);
		Assert.assertTrue(filterTaxonomyLinkLocator.isDisplayed(), "Filter taxonomy link is not displayed.");
		return this;
	}

	public ItemsPageObjects verifyClearTaxonomyTree() {
		Assert.assertTrue(clearTaxonomyLinkLocator.isDisplayed(), "Clear taxonomy link is not displayed.");
		return this;
	}

	public ItemsPageObjects verifyCollapseTaxonomyTree() {
		Assert.assertTrue(collapseTreeLocator.isDisplayed(), "Collapse taxonomy link is not displayed.");
		return this;
	}

	public ItemsPageObjects verifyRefreshTaxonomyTree() {
		Assert.assertTrue(refreshSearchLocator.isDisplayed(), "Taxonomy refresh is not displayed.");
		return this;
	}

	public ItemsPageObjects verifySearchIconTaxonomyTree() {
		Assert.assertTrue(searchIconLocator.isDisplayed(), "Search icon is not displayed.");
		return this;

	}

	public ItemsPageObjects verifyDefaultTaxonomyInTaxonomyTree(String defaultTaxonomy) {

		waiting.explicitWaitVisibilityOfElement(defaultTaxonomyLocator, 5);
		Assert.assertEquals(defaultTaxonomyLocator.getAttribute("value").trim(), defaultTaxonomy.trim());
		return this;
	}

	public ItemsPageObjects verifyDisplayOfLevelOneCategories() {
		for (WebElement levelOneCategory : listOnLevelOneCategoriesLocator)
			Assert.assertTrue(levelOneCategory.isDisplayed());
		return this;
	}

	public ItemsPageObjects enterSearchTaxonomy(String searchTaxonomy) {

		waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchTaxonomy);
		return this;
	}

	public ItemsPageObjects clickOnSearchInTaxonomy() {
		searchIconLocator.click();
		return this;
	}

	public ItemsPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen(String searchTaxonomy) throws Exception {

		Thread.sleep(3500);
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[text()='" + searchTaxonomy + "']"), 30);
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='" + searchTaxonomy + "']"))
				.getAttribute("style").trim().contains("green"));
		return this;
	}

	public ItemsPageObjects clickOnRefresh() {
		refreshSearchLocator.click();
		return this;
	}

	public ItemsPageObjects verifyWhetherSearchedTaxonomyStyleIsNotGreen(String taxonomyToSearch) throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='" + taxonomyToSearch + "']"))
				.getAttribute("style").trim().contains("green"));
		return this;
	}

	public ItemsPageObjects verifyClearingOfSearchTextbox() {

		Assert.assertEquals(searchTextboxInTaxonomySectionLocator.getAttribute("value").trim(), "");
		return this;
	}

	public ItemsPageObjects verifyWhetherValueContainsTextInsideTheTextbox(String taxonomyToSearch) {
		Assert.assertEquals(searchTextboxInTaxonomySectionLocator.getAttribute("value").trim(), taxonomyToSearch);
		return this;
	}

	public ItemsPageObjects verifyBrowserisinItemsPage() {
		// System.out.println("displaying"+itembreadcrumb.getText());

		try {
			Assert.assertEquals(itembreadcrumb.getText(), "Items");
		} catch (Exception e) {
			// System.out.println(e);
		}
		return this;
	}

	@Step("click on create new item locator")
	public ItemsPageObjects clickOnAddNewItemButton() throws InterruptedException {
		Thread.sleep(3500);
		addNewItemLinklocator.click();
		return this;
	}

	public ItemsPageObjects verifyAddNewItemSectioniEnabled() {

		waiting.explicitWaitVisibilityOfElement(addNewItemsection, 20);
		Assert.assertEquals(addNewItemsection.getText().trim(), "Add New Item");
		return this;
	}

	public ItemsPageObjects typeInitemManufacturerfield(String manufacturername) {
		// itemManufacturerfield.clear();

		waiting.explicitWaitVisibilityOfElement(itemManufacturerfield, 30);
		itemManufacturerfield.sendKeys(manufacturername);
		return this;
	}

	public ItemsPageObjects typeInitemBrandfield(String brandname) {
		// itemBrandField.clear();
		itemBrandField.sendKeys(brandname);
		return this;
	}

	public ItemsPageObjects typeInitemPartNumberField(String itemnametemplate, int var) {
		itemPartNumberField.clear();
		itemPartNumberField.sendKeys(itemnametemplate + var);
		return this;
	}

	public ItemsPageObjects typeInmanufacturerPartNumberField(String manufacturernametemplate, int var) {
		itemManufacturerPartNumberField.clear();
		itemManufacturerPartNumberField.sendKeys(manufacturernametemplate + var);
		return this;
	}

	public ItemsPageObjects typeInitemSupplierField(String vendorname) {
		itemSupplierField.clear();
		itemSupplierField.sendKeys(vendorname);
		return this;
	}

	public ItemsPageObjects clickOnsavenewItem() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(savenewItem, 10);
		Thread.sleep(2500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", savenewItem);

		return this;
	}

	public ItemsPageObjects verifysavenewItemMessage(String savenewItemMessage) {
		waiting.explicitWaitVisibilityOfElement(savenewItemMessageLocator, 15);
		Assert.assertEquals(savenewItemMessageLocator.getText().trim(), savenewItemMessage);
		return this;
	}

	public ItemsPageObjects clickOncustomPricesTabLocator() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customPricesTabLocator, 50);
		customPricesTabLocator.click();
		return this;
	}

	public ItemsPageObjects assignSubsettoItems(String subsetname) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='customPricesForm:customPricesTable:tb']/tr/descendant::span[text()='"
						+ subsetname + "']/../preceding-sibling::td/descendant::input[@title='Add Item Into Subset']"),
				50);
		(getDriver().findElement(
				By.xpath("//tbody[@id='customPricesForm:customPricesTable:tb']/tr/descendant::span[text()='"
						+ subsetname + "']/../preceding-sibling::td/descendant::input[@title='Add Item Into Subset']")))
								.click();
		return this;
	}

	public ItemsPageObjects verifySubsetAssignToItemmessageloc(String subsetname) {

		waiting.explicitWaitVisibilityOfElement(subsetassigntoitemmessageloc, 50);
		Assert.assertEquals(subsetassigntoitemmessageloc.getText().trim(),
				"Item added to Subset \"" + subsetname + "\" Successfully");
		return this;
	}

	public ItemsPageObjects createNewItemsinside(String manufacturername, String brandname, String itemnametemplate,
			String manufacturernametemplate, String vendorname, String savenewItemMessage, String subsetname,
			String Noofitemstobecreated) throws InterruptedException {
		int items = Integer.parseInt(Noofitemstobecreated);
		for (int i = 1; i <= items; i++) {
			clickOnAddNewItemButton();
			verifyAddNewItemSectioniEnabled();
			typeInitemManufacturerfield(manufacturername);
			typeInitemBrandfield(brandname);
			typeInitemPartNumberField(itemnametemplate, i);
			typeInmanufacturerPartNumberField(manufacturernametemplate, i);
			typeInitemSupplierField(vendorname);
			clickOnsavenewItem();
			verifysavenewItemMessage(savenewItemMessage);
			clickOncustomPricesTabLocator();
			assignSubsettoItems(subsetname);
			verifySubsetAssignToItemmessageloc(subsetname);
		}
		return this;
	}

	@Step("Type in advanced search top field")
	public ItemsPageObjects typeinadvancedSearchTopSearchField(String advSesearchinput) {

		waiting.explicitWaitVisibilityOfElement(advancedSearchTopSearchField, 15);
		advancedSearchTopSearchField.clear();
		advancedSearchTopSearchField.sendKeys(advSesearchinput);
		return this;
	}

	@Step("click on advanced search top search button")
	public ItemsPageObjects clickOnadvancedSearchTopSearchButton() {

		waiting.explicitWaitVisibilityOfElement(advancedSearchTopSearchButton, 10);
		advancedSearchTopSearchButton.click();
		return this;
	}

	@Step("verify Part number or Keyword search result - {0} ")
	public ItemsPageObjects verifyadvSe003Searchresult(String advSesearchRes) throws Exception {

		waiting.explicitWaitVisibilityOfElements(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ advSesearchRes + "')]"),
				15);
		List<WebElement> wb = getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ advSesearchRes + "')]"));
		Assert.assertTrue(wb.get(0).getText().trim().contains(advSesearchRes),
				"Search Results not found for keyword :" + advSesearchRes + "");
		return this;

	}

	@Step("verify 'No Items Found' message is displayed when searched for Invalid part number or Keyword")
	public ItemsPageObjects verifyadvSe004Searchresult(String expMessage) throws InterruptedException {
		Thread.sleep(4000);
		waiting.explicitWaitVisibilityOfElement(advancedSearchErrorMessageLoc, 30);
		Assert.assertEquals(advancedSearchErrorMessageLoc.getText().trim(), expMessage,
				"InValid text message is :" + advancedSearchErrorMessageLoc.getText() + "Dispayed");
		return this;

	}

	@Step("verify 'part number or keyword' partial search result {0} is displayed ")
	public ItemsPageObjects verifyadvSe005Searchresult(String advSesearchRes) throws InterruptedException {
		Thread.sleep(2500);

		Assert.assertTrue(getDriver().findElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/tr/td[contains(text(),'" + advSesearchRes + "')]"))
				.isDisplayed());
		return this;

	}

	@Step("selects a value from dropdown")
	public ItemsPageObjects selectDropdownTop(String selectvalue) throws InterruptedException {
		new Select(advancedSearchselectLoc).selectByVisibleText(selectvalue);

		return this;
	}

	@Step("verify 'part number' search result {0} is displayed")
	public ItemsPageObjects verifyadvSe007Searchresult(String advSe007searchinput) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/tr/td[contains(text(),'" + advSe007searchinput + "')]"),
				15);
		Assert.assertEquals(getDriver().findElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/tr/td[contains(text(),'" + advSe007searchinput + "')]"))
				.getText().trim(), advSe007searchinput);
		return this;
	}

	@Step("verify 'Part No search- Partial search' result {0} is displayed")
	public ItemsPageObjects verifyadvSe008Searchresult(String advSe008searchinput) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/tr/td[contains(text(),'" + advSe008searchinput + "')]"),
				40);
		Assert.assertTrue(getDriver().findElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/tr/td[contains(text(),'" + advSe008searchinput + "')]"))
				.isDisplayed());
		return this;
	}

	@Step("verify 'Manufacturer Part No search' Searchresult {0} is displayed")
	public ItemsPageObjects verifyadvSe010Searchresult(String itemNameTemplate, String advSearchinput,
			String Noofitemstobecreated) throws InterruptedException {
		Thread.sleep(3500);
		int var1 = Integer.parseInt(Noofitemstobecreated);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemNameTemplate + "')]"),
				40);
		Assert.assertTrue(getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemNameTemplate + "')]"))
				.getText().contains(itemNameTemplate));
		getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemNameTemplate + "')]/preceding-sibling::td/descendant::input[@title='Edit Item']"))
				.get(0).click();
		for (int i = 1; i <= var1; i++) {
			Thread.sleep(3500);
			Assert.assertEquals(getDriver().findElement(By.xpath("//input[@id='generalInfoFormId:mpnTxtId']"))
					.getAttribute("value"), advSearchinput + i);
			nextItemIconLocator.click();
			Thread.sleep(2500);
		}

		return this;
	}

	public String getCIMMItemID(String advSe014searchinput) throws InterruptedException {
		Thread.sleep(30000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath(
						"//tbody[@id='searchFormId:itemListTableId:tb']/tr[1][td='" + advSe014searchinput + "']/td[3]"),
				50);
		String cimmItemIDtext = getDriver()
				.findElement(By.xpath(
						"//tbody[@id='searchFormId:itemListTableId:tb']/tr[1][td='" + advSe014searchinput + "']/td[3]"))
				.getText();
		return cimmItemIDtext;
	}

	@Step("clicking on Manufacturer filter")
	public ItemsPageObjects clickOnas_Manufacturerfilter() throws InterruptedException {
		as_Manufacturerfilter.click();
		Thread.sleep(4000);
		return this;
	}

	@Step("clicking on manufacturerfilter search button")
	public ItemsPageObjects clcikOnas_Manufacturerfiltersearchbutton() throws InterruptedException {
		as_Manufacturerfiltersearchbutton.click();
		Thread.sleep(4000);
		return this;
	}

	@Step("Manufacturer search without typing in text field")
	public ItemsPageObjects selectTheCreatedManufacturerfilterWithoutSearch(String mfgName) throws Exception {
		Thread.sleep(3000);

		WebElement ele = getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:MnfListTabId:tb']/descendant::td[contains(text(),'"
						+ mfgName + "')]/preceding-sibling::td"));
		if (!(ele.isSelected())) {
			ele.click();
			// System.out.println("\n \n\n "+ele+"CLicked");
		}
		return this;
	}

	@Step("Manufacturer search with typing in text field")
	public ItemsPageObjects selectTheManufacturersFromList(String manufacturername) throws InterruptedException {

		waiting.explicitWaitElementToBeClickable(
				By.xpath("//tbody[@id='searchFormId:MnfListTabId:tb']/descendant::td[contains(.,'" + manufacturername
						+ "')]/preceding-sibling::td"),
				20);
		WebElement wb = getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:MnfListTabId:tb']/descendant::td[contains(.,'"
						+ manufacturername + "')]/preceding-sibling::td"));
		if (!(wb.isSelected())) {
			wb.click();

		}

		return this;

	}

	@Step("verify Manufacturer {0} / Brand {1} Searchresult is displayed ")
	public ItemsPageObjects verifyadvSe016(String manufacturername, String brandname, String Noofitemstobecreated) {

		int var1 = Integer.parseInt(Noofitemstobecreated);
		for (int i = 1; i <= var1; i++) {

			WebElement ele = getDriver().findElement(By
					.xpath("//tbody/descendant::td[contains(text(),'" + manufacturername + " / " + brandname + "')]"));
			Assert.assertEquals(ele.getText(), manufacturername + " / " + brandname);
		}
		return this;
	}

	@Step("Type in Manufacturefilter search")
	public ItemsPageObjects enterTheManufactureNameInSearchField(String manufacturername) throws InterruptedException {
		as_Manufacturerfiltersearchfield.sendKeys(manufacturername);
		return this;
	}

	@Step("clicking on Brand filter")
	public ItemsPageObjects clickOnas_Brandfilter() throws InterruptedException {
		as_Brandfilter.click();
		Thread.sleep(4000);
		return this;
	}

	@Step("clicking on Brand filter {0} without typing in text field")
	public ItemsPageObjects brandfilterWithoutSearch(String brandname) {

		WebElement ele = getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:brandTableId:tb']/descendant::td[contains(.,'"
						+ brandname + "')]/preceding-sibling::td"));
		if (!(ele.isSelected())) {
			ele.click();
			// System.out.println("\n \n\n "+ele+"CLicked");
		}
		return this;
	}

	@Step("clicking on Brand filter search button")
	public ItemsPageObjects clickOnas_Brandfiltersearchbutton() throws InterruptedException {
		as_Brandfiltersearchbutton.click();
		Thread.sleep(8000);
		return this;
	}

	@Step("typing in brand text field")
	public ItemsPageObjects typeIn_as_Brandfiltersearchfield(String brandname) throws InterruptedException {
		as_Brandfiltersearchfield.sendKeys(brandname);
		return this;
	}

	@Step("clicking on Brand filter {0} with typing in text field")
	public ItemsPageObjects brandfilterWithSearch(String brandname) throws InterruptedException {

		WebElement wb = getDriver().findElement(
				By.xpath("//table[@id='searchFormId:brandTableId']/descendant::td[contains(.,'" + brandname + "')]"));
		waiting.explicitWaitVisibilityOfElement(wb, 20);
		Assert.assertEquals(wb.getText(), brandname);
		getDriver().findElement(By.xpath("//table[@id='searchFormId:brandTableId']/descendant::td[contains(.,'"
				+ brandname + "')]/preceding-sibling::td")).click();
		Thread.sleep(3000);
		return this;

	}

	@Step("clicking on subset filter")
	public ItemsPageObjects clickOnas_Subsetfilter() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_Subsetfilter, 15);
		as_Subsetfilter.click();
		Thread.sleep(4000);
		return this;
	}

	@Step("clicking on subset name {0} without typing in text field")
	public ItemsPageObjects subsetfilterWithoutSearch(String subsetname) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:subsetTableId:tb']/descendant::td[contains(.,'" + subsetname
						+ "')]/preceding-sibling::td"),
				15);
		WebElement ele = getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:subsetTableId:tb']/descendant::td[contains(.,'"
						+ subsetname + "')]/preceding-sibling::td"));
		if (!(ele.isSelected())) {
			ele.click();
			// System.out.println("\n \n\n "+ele+"CLicked");
		}
		return this;
	}

	@Step("clicking on subset filter search button")
	public ItemsPageObjects clickOnas_Subsetfiltersearchbutton() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_Subsetfiltersearchbutton, 20);
		as_Subsetfiltersearchbutton.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("verify search result-items belongs to the subset {2}")
	public ItemsPageObjects verifyadvsearchForSubset(String itemnametemplate, String Noofitemstobecreated,
			String manufacturernametemplate, String subsetname) throws InterruptedException {
		int var1 = Integer.parseInt(Noofitemstobecreated);
		Thread.sleep(4000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemnametemplate + "')]"),
				20);
		Assert.assertTrue(getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemnametemplate + "')]"))
				.get(0).getText().contains(itemnametemplate));
		waiting.explicitWaitVisibilityOfElements(editItemLink, 20);
		editItemLink.get(0).click();
		Thread.sleep(25000);
		for (int i = 1; i <= var1; i++) {
			getDriver().findElement(By.xpath("//td[@id='CPTab_lbl']")).click();
			Thread.sleep(2000);
			waiting.explicitWaitVisibilityOfElement(By
					.xpath("//tbody[@id='customPricesForm:customPricesTable:tb']/tr/td/*[@title='Update Item Prices in Subset']/../../*[span='"
							+ subsetname + "']"),
					20);
			Assert.assertTrue(getDriver().findElement(By
					.xpath("//tbody[@id='customPricesForm:customPricesTable:tb']/tr/td/*[@title='Update Item Prices in Subset']/../../*[span='"
							+ subsetname + "']"))
					.isDisplayed(), "subset is not available");
		}
		nextItemIconLocator.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("typing in Subsetfiltersearchfield")
	public ItemsPageObjects typeIn_as_Subsetfiltersearchfield(String subsetname) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_Subsetfiltersearchfield, 15);
		as_Subsetfiltersearchfield.sendKeys(subsetname);
		return this;
	}

	@Step("subset filter without search")
	public ItemsPageObjects subsetfilterWithSearch(String subsetname) throws InterruptedException {

		WebElement wb = getDriver().findElement(
				By.xpath("//table[@id='searchFormId:subsetTableId']/descendant::td[contains(.,'" + subsetname + "')]"));
		waiting.explicitWaitVisibilityOfElement(wb, 20);
		Assert.assertEquals(wb.getText(), subsetname);
		getDriver().findElement(By.xpath("//table[@id='searchFormId:subsetTableId']/descendant::td[contains(.,'"
				+ subsetname + "')]/preceding-sibling::td")).click();

		return this;
	}

	@Step("clicking on vendor filter")
	public ItemsPageObjects clickOnas_vendorfilter() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_vendorfilter, 10);
		as_vendorfilter.click();
		return this;
	}

	@Step("click on vendor name {0}  without typing in text field")
	public ItemsPageObjects vendorfilterWithoutSearch(String vendorname) {

		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:supplierTableId:tb']/descendant::td[contains(.,'" + vendorname
						+ "')]/preceding-sibling::td"),
				15);
		WebElement ele = getDriver()
				.findElement(By.xpath("//tbody[@id='searchFormId:supplierTableId:tb']/descendant::td[contains(.,'"
						+ vendorname + "')]/preceding-sibling::td"));
		if (!(ele.isSelected())) {
			ele.click();
			// System.out.println("\n \n\n "+ele+"CLicked");
		}
		return this;
	}

	@Step("clicking ob vendor filter search button")
	public ItemsPageObjects clickOnas_vendorfiltersearchbutton() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_vendorfiltersearchbutton, 15);
		as_vendorfiltersearchbutton.click();

		return this;
	}

	@Step("verification of vendor filter search results")
	public ItemsPageObjects verifyadvseVendorFilter(String itemnametemplate, String Noofitemstobecreated,
			String manufacturernametemplate, String vendorname) throws InterruptedException {
		Thread.sleep(3500);
		int var1 = Integer.parseInt(Noofitemstobecreated);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemnametemplate + "')]"),
				50);
		Assert.assertTrue(getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ itemnametemplate + "')]"))
				.get(0).getText().contains(itemnametemplate));
		waiting.explicitWaitVisibilityOfElements(editItemLink, 50);
		editItemLink.get(0).click();
		Thread.sleep(3500);
		for (int i = 1; i <= var1; i++) {
			waiting.explicitWaitVisibilityOfElement(
					By.xpath("//input[@id='generalInfoFormId:supplierListComboIdcomboboxField']"), 30);
			Assert.assertEquals(getDriver()
					.findElement(By.xpath("//input[@id='generalInfoFormId:supplierListComboIdcomboboxField']"))
					.getAttribute("value"), vendorname);
			if (i != var1) {
				waiting.explicitWaitVisibilityOfElement(nextItemIconLocator, 10);
				nextItemIconLocator.click();

			}

		}
		return this;
	}

	@Step("typing in vendor filter search field")
	public ItemsPageObjects typeIn_as_Vendorfiltersearchfield(String vendorname) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(as_vendorfiltersearchbutton, 15);
		as_Vendorfiltersearchfield.sendKeys(vendorname);
		return this;
	}

	@Step("vendor filter without typing in text field")
	public ItemsPageObjects vendorfilterWithSearch(String vendorname) throws InterruptedException {

		WebElement wb = getDriver().findElement(By.xpath(
				"//tbody[@id='searchFormId:supplierTableId:tb']/descendant::td[contains(.,'" + vendorname + "')]"));
		waiting.explicitWaitVisibilityOfElement(wb, 15);
		Assert.assertEquals(wb.getText(), vendorname);
		getDriver().findElement(By.xpath("//tbody[@id='searchFormId:supplierTableId:tb']/descendant::td[contains(.,'"
				+ vendorname + "')]/preceding-sibling::td")).click();

		return this;

	}

	@Step("verification of 'CIMM Item ID' search results {0} is displayed")
	public ItemsPageObjects verifyadvSe014Searchresult(String cimmItemID) throws Exception {
		Thread.sleep(2000);
		Assert.assertEquals(itemIdInTableLocator.getText().trim(), cimmItemID);
		return this;

	}

	@Step("select item status dropdown")
	public ItemsPageObjects selectDropdownitemstatusDropdown(String selectvalue) throws InterruptedException {
		new Select(itemstatusDropdown).selectByVisibleText(selectvalue);

		return this;
	}

	@Step("Click on bottom search button")
	public ItemsPageObjects clickOnbottomSeacrhButton() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(bottomSearchButton, 15);
		bottomSearchButton.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("Verify searched results which are active")
	public ItemsPageObjects verifyresultsadvSe024(String status, String expStatus) throws Exception {
		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElements(editItemLink, 50);
		editItemLink.get(0).click();
		Thread.sleep(2500);
		switch (status) {

		case "Active":
			waiting.explicitWaitVisibilityOfElement(
					By.xpath("//select[contains(@id,'generalInfoFormId:activeId')]/option[contains(@value,'Y')]"), 50);
			Assert.assertEquals(getDriver()
					.findElement(By
							.xpath("//select[contains(@id,'generalInfoFormId:activeId')]/option[contains(@value,'Y')]"))
					.getAttribute("selected"), expStatus);
			break;
		case "InActive":
			waiting.explicitWaitVisibilityOfElement(
					By.xpath("//select[contains(@id,'generalInfoFormId:activeId')]/option[contains(@value,'N')]"), 40);
			Assert.assertEquals(getDriver()
					.findElement(By
							.xpath("//select[contains(@id,'generalInfoFormId:activeId')]/option[contains(@value,'N')]"))
					.getAttribute("selected"), expStatus);

			break;
		default:
			throw new Exception("in valid selection");

		}
		return this;
	}

	@Step("select display online dropdown")
	public ItemsPageObjects selectDropdowndisplayOnlineDropdown(String selectvalue) throws Exception {
		Thread.sleep(2000);
		displayOnlineDropdown.click();

		switch (selectvalue) {

		case "Yes":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:dispOnline']/option[@value='Y']")).click();
			break;
		case "No":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:dispOnline']/option[@value='Y']")).click();
			break;
		case "All":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:dispOnline']/option[@value='']")).click();
			break;
		default:
			throw new Exception("invalid selection");
		}
		return this;
	}

	@Step("verification of display online dropdown - Yes ")
	public ItemsPageObjects verifyadvse025() {
		int i = 0;
		String count = "count(//table[@id='searchFormId:itemListTableId']/thead/tr/th/div/span/span[text()='Display Online']/../../../preceding-sibling::*)+1";
		String xpath = "//tbody[@id='searchFormId:itemListTableId:tb']/tr[" + i + "]/td[" + count + "]/label/input";
		for (i = 1; i < 10; i++) {

			Assert.assertTrue(getDriver().findElement(By.xpath(xpath)).isSelected());
		}
		return this;
	}

	@Step("verification of display online dropdown - No ")
	public ItemsPageObjects verifyadvSearchForDispayOnineStatus(String noOfItemToBeVerify, String displayOnlineStatus) {

		int var = Integer.parseInt(noOfItemToBeVerify);
		for (int i = 0; i <= var; i++)

		{
			try {

				waiting.explicitWaitVisibilityOfElement(nextItemIconLocator, 10);
				nextItemIconLocator.click();
				switch (displayOnlineStatus) {
				case "Yes":
					Assert.assertTrue(displayOnlineItemCheckBox.isSelected());
					break;
				case "No":
					Assert.assertFalse(displayOnlineItemCheckBox.isSelected());
					break;
				case "All":
					Assert.assertTrue(
							displayOnlineItemCheckBox.isSelected() || !(displayOnlineItemCheckBox.isSelected()));

					break;
				default:
					throw new Exception("invalid online status selection selection");
				}
			} catch (Exception e) {

				// System.out.println("Online status is not available");
			}

		}
		return this;
	}

	@Step("verification of display online dropdown - All")
	public ItemsPageObjects verifyadvse027() {
		int i = 1;
		String count = "count(//table[@id='searchFormId:itemListTableId']/thead/tr/th/div/span/span[text()='Display Online']/../../../preceding-sibling::*)+1";
		String xpath = "//tbody[@id='searchFormId:itemListTableId:tb']/tr[" + i + "]/td[" + count
				+ "]/label/input[@checked or not(@checked)]";
		for (i = 1; i < 10; i++) {

			getDriver().findElement(By.xpath(xpath));
		}
		return this;
	}

	@Step("verification of grayed out fields in Subset Item dropdown")
	public ItemsPageObjects verifyadvse028() {

		Assert.assertEquals(getDriver()
				.findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@disabled][1]"))
				.getText(), "Please Select Subset");
		Assert.assertEquals(getDriver()
				.findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@disabled][2]"))
				.getText(), "Active");
		Assert.assertEquals(getDriver()
				.findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@disabled][3]"))
				.getText(), "InActive");
		return this;
	}

	@Step("verification of grayed out fields in Images dropdown")
	public ItemsPageObjects verifyImagesStatus() throws InterruptedException {

		Thread.sleep(2500);
		Assert.assertEquals(
				getDriver()
						.findElement(
								By.xpath("//td/select[@name='searchFormId:rbtImages']/option[@value='WithImages']"))
						.getText().trim(),
				"Images");
		Assert.assertEquals(getDriver()
				.findElement(By.xpath("//td/select[@name='searchFormId:rbtImages']/option[@value='NoImages']"))
				.getText().trim(), "No Images");
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//td/select[@name='searchFormId:rbtImages']/option[text()='Ignore']"))
						.getText().trim(),
				"Ignore");
		return this;
	}

	public ItemsPageObjects clickOnImagesSubFilter(String imageStatus) throws Exception {

		waiting.explicitWaitVisibilityOfElement(imageSubfilterLocator, 10);
		imageSubfilterLocator.click();
		switch (imageStatus) {
		case "Images":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtImages']/option[@value='WithImages']"))
					.click();
			break;
		case "No Images":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtImages']/option[@value='NoImages']"))
					.click();
			break;
		case "Ignore":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtImages']/option[@value='']")).click();

			break;
		default:
			throw new Exception("invalid selection");
		}
		return this;
	}

	public ItemsPageObjects verifyPartNumbersBeforeRemove(String partNumber) throws InterruptedException {
		Thread.sleep(3000);

		Assert.assertFalse(assertVerifyItem(partNumber), "item(s) not available, Please create items to remove");
		// getDriver().findElements(By.xpath("//td[contains(text(),'"+partNumber+"')]")).get(0).getText(),partNumber+1,
		// "Items are not available");

		return this;
	}

	public ItemsPageObjects verifyPartNumbersForImageStatus(String partNumber) throws InterruptedException {
		Thread.sleep(3000);
		for (int i = 0; i < 5; i++) {

		}

		return this;
	}

	public ItemsPageObjects verifyPartNumbers(String partNumber) throws InterruptedException {
		Thread.sleep(3000);

		Assert.assertTrue(assertVerifyItem(partNumber), "item(s) already present, Please delete items to crete again");
		// getDriver().findElements(By.xpath("//td[contains(text(),'"+partNumber+"')]")).get(0).getText(),partNumber+1,
		// "Items are not available");

		return this;
	}

	public ItemsPageObjects clickOnLongDescSubFilter() {

		getDriver().findElement(By.xpath("//select[@name='searchFormId:rbtLongDesc']//option[text()='LongDesc ']"))
				.click();

		return this;
	}

	/*
	 * public ItemsPageObjects verifylongDescPartNumbers(String partNumber)
	 * throws Exception { Thread.sleep(3000);
	 * 
	 * 
	 * Assert.assertEquals(getDriver().findElement(By.xpath(
	 * "//tbody[@id='searchFormId:itemListTableId:tb']//td[text()='"+partNumber1
	 * +"']")).getText().trim(),partNumber1);
	 * Assert.assertEquals(getDriver().findElement(By.xpath(
	 * "//tbody[@id='searchFormId:itemListTableId:tb']//td[text()='"+partNumber2
	 * +"']")).getText().trim(),partNumber2);
	 * Assert.assertEquals(getDriver().findElement(By.xpath(
	 * "//tbody[@id='searchFormId:itemListTableId:tb']//td[text()='"+partNumber+
	 * "']")).getText().trim(),partNumber);
	 * 
	 * return this;
	 * 
	 * }
	 */

	public ItemsPageObjects clickOnLongDescriptionSubFilter(String longDescValue) throws Exception {

		getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtLongDesc']")).click();
		switch (longDescValue) {
		case "LongDesc":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtLongDesc']/option[@value='WithLongDesc']"))
					.click();
			break;
		case "No LongDesc":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtLongDesc']/option[@value='NoLongDesc']"))
					.click();
			break;
		case "Ignore":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtLongDesc']/option[@value='']")).click();
			break;
		default:
			throw new Exception("invalid selection");
		}
		return this;
	}

	public ItemsPageObjects clickOnNoLongDescSubFilter() {

		getDriver()
				.findElement(By
						.xpath("//select[@name='searchFormId:rbtLongDesc']/descendant::option[text()='No LongDesc ']"))
				.click();
		return this;
	}

	public ItemsPageObjects verifylongDescPartNumbers(String partNumber) throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> items = getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ partNumber + "')]"));
		// for(int i=0; i < items.size() ;i++)
		Assert.assertTrue(getDriver().findElements(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'" + partNumber + "')]"))
				.get(0).getText().trim().contains(partNumber));

		return this;

	}

	public ItemsPageObjects clickOnIgnoreLongDescSubFilter() {

		getDriver()
				.findElement(By.xpath("//select[@name='searchFormId:rbtLongDesc']/descendant::option[text()='Ignore']"))
				.click();
		return this;
	}

	public ItemsPageObjects verifyIgnorelongDescPartNumbers(String partNumber) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'" + partNumber + "')]"),
				15);
		Assert.assertEquals(
				getDriver()
						.findElement(By.xpath(
								"//tbody[@id='searchFormId:itemListTableId:tb']//td[text()='" + partNumber + "']"))
						.getText().trim(),
				partNumber);
		return this;
	}

	public ItemsPageObjects clickOnEditButton(String partNumber) throws Exception {

		Thread.sleep(2500);
		waiting.explicitWaitElementToBeClickable(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']//td[contains(text(),'" + partNumber
						+ "')]/..//input[@title='Edit Item']"),
				30);
		{
			getDriver().findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']//td[contains(text(),'"
					+ partNumber + "')]/..//input[@title='Edit Item']")).get(0).click();
		}
		// tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"+itemPartnumber+"')]/preceding-sibling::td/descendant::input[@title='Edit
		// Item']
		return this;
	}

	public ItemsPageObjects clickOnWithAttributesSubFilter() throws Exception {

		waiting.explicitWaitVisibilityOfElement(withAttributes_SubFilter, 40);
		withAttributes_SubFilter.click();
		return this;
	}

	public ItemsPageObjects clickOnCombinewithOR() throws Exception {

		waiting.explicitWaitVisibilityOfElement(combineOptions_OR_SubFilter, 40);
		combineOptions_OR_SubFilter.click();
		return this;
	}

	public ItemsPageObjects clickOnCombine(String operator) throws Exception {

		WebElement wb = getDriver().findElement(By.xpath(
				"//select[@id='searchFormId:joinOpId']/descendant::option[contains(text(),'" + operator + "')]"));
		waiting.explicitWaitVisibilityOfElement(wb, 10);
		wb.click();
		return this;
	}

	@Step("select Attributes dropdown")
	public ItemsPageObjects selectWithOutCategorizedDropdown() {
		itemUnCategorizedDropdown.click();
		return this;
	}

	@Step("select Attributes dropdown")
	public ItemsPageObjects selectWithAttributesDropdown() {
		withAttributes_SubFilter.click();
		return this;
	}

	@Step("click on Attributes tab")
	public ItemsPageObjects clickOnAttributesTab() throws InterruptedException {
		Thread.sleep(5000);
		attributesTabLocator.click();
		Thread.sleep(5000);
		return this;
	}

	@FindBy(xpath = "//td[@id= 'AttrTab_lbl']")
	private WebElement attributesTabLocator;

	@FindBy(xpath = "//select[@id='searchFormId:rbtAttributes']//option[text()='Attributes ']")
	private WebElement withAttributes_SubFilter;

	@Step("select Attributes dropdown")
	public ItemsPageObjects selectWithoutAttributesDropdown() {
		noAttributes_SubFilter.click();
		return this;
	}

	@Step("select Categorized dropdown")
	public ItemsPageObjects selectCategorizedDropdown(String categoryStatus) throws Exception {

		waiting.explicitWaitVisibilityOfElement(itemCategorizedDropdown, 15);
		itemCategorizedDropdown.click();
		switch (categoryStatus) {
		case "Categorized":
			Thread.sleep(2000);
			waiting.explicitWaitElementToBeClickable(
					By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='WithCategorized']"), 40);
			getDriver()
					.findElement(
							By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='WithCategorized']"))
					.click();
			break;
		case "UnCategorized":
			Thread.sleep(2000);
			waiting.explicitWaitElementToBeClickable(
					By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='UnCategorized']"), 40);
			getDriver()
					.findElement(By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='UnCategorized']"))
					.click();
			break;
		case "Ignore":
			Thread.sleep(2000);
			waiting.explicitWaitElementToBeClickable(
					By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='']"), 50);
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtCategorized']/option[@value='']")).click();
			break;
		default:
			throw new Exception("invalid Category selection selection");
		}

		return this;
	}

	public ItemsPageObjects clickOnFirstEditButton() throws Exception {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElements(
				By.xpath("//table[@id= 'searchFormId:itemListTableId']/descendant::input[@title= 'Edit Item']"), 40);
		List<WebElement> ele = getDriver().findElements(
				By.xpath("//table[@id= 'searchFormId:itemListTableId']/descendant::input[@title= 'Edit Item'][1]"));
		ele.get(0).click();
		Thread.sleep(2500);
		return this;
	}

	public ItemsPageObjects clickOnSubsetFilterDropdown() {

		waiting.explicitWaitVisibilityOfElement(as_Subsetfilter, 60);
		as_Subsetfilter.click();
		return this;
	}

	public ItemsPageObjects selectSubsetFromTheList() {

		return this;
	}

	public ItemsPageObjects clickOnTheCheckboxOfTheList() {

		return this;
	}

	@Step("click on the specific subset {0}")
	public ItemsPageObjects clcikOnSubsetitemStatusFromTheDropdown(String subsetName) {

		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:subsetTableId:tb']/descendant::td[contains(text(),'" + subsetName
						+ "')]/preceding-sibling::td"),
				15);
		getDriver().findElement(By.xpath("//tbody[@id='searchFormId:subsetTableId:tb']/descendant::td[contains(text(),'"
				+ subsetName + "')]/preceding-sibling::td")).click();
		return this;
	}

	@Step("select subset item status {0}")
	public ItemsPageObjects selectSubsetItemStatus(String subsetStatus) throws Exception {

		Thread.sleep(3000);

		getDriver().findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']")).click();
		switch (subsetStatus) {
		case "Active":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@value='A']"))
					.click();
			break;
		case "InActive":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@value='I']"))
					.click();
			break;
		case "All":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:subsetItemStatusId']/option[@value='']"))
					.click();
			break;
		default:
			throw new Exception("invalid selection");
		}

		return this;

	}

	@Step("selection of Attributes dropdown {0} ")
	public ItemsPageObjects selectAttributesFromDropDown(String attributeValue) throws Exception {
		Thread.sleep(2500);
		switch (attributeValue) {

		case "Attributes":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtAttributes']/option[text()='Attributes ']"))
					.click();
			break;

		case "No Attributes":
			getDriver()
					.findElement(By.xpath("//select[@id='searchFormId:rbtAttributes']/option[text()='No Attributes ']"))
					.click();
			break;

		case "Ignore":
			getDriver().findElement(By.xpath("//select[@id='searchFormId:rbtAttributes']/option[text()='Ignore']"))
					.click();
			break;

		default:
			throw new Exception("invalid selection");

		}
		return this;
	}

	@Step("Expected items {0}")
	public ItemsPageObjects verifySubsetItemResults(String expectedItems) throws InterruptedException {
		Thread.sleep(2500);

		List<WebElement> items = getDriver()
				.findElements(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[contains(text(),'"
						+ expectedItems + "')]"));
		for (int i = 0; i < items.size(); i++) {
			Assert.assertTrue(items.get(i).isDisplayed(), "Results not found in item list page.");
		}

		return this;

	}

	@Step("verify the succesful message after deletion {0}")
	public ItemsPageObjects vefifySuccesfulMessage(String partNumber, String expSuccesfulMessageForDeletion,
			String Noofitemstobecreated) throws InterruptedException {
		Thread.sleep(2500);
		int items = Integer.parseInt(Noofitemstobecreated);
		for (int i = 1; i <= items; i++) {

			Assert.assertEquals(
					getDriver().findElement(By.xpath("//span[@id='searchFormId:deleteSearchItmMsg']")).getText().trim(),
					"Item with Part No. : '" + partNumber + i + "' removed Successfully");
		}
		return this;

	}

	@Step("to check the required checkboxes in {0} for desktop view")
	public ItemsPageObjects clickOnGenricColumnSetting(String genericColumnSetting) throws Exception {

		waiting.explicitWaitVisibilityOfElement(genericColumnSettingIconLocator, 10);
		Assert.assertTrue(genericColumnSettingIconLocator.isDisplayed(), "generic column setting is not available ");
		genericColumnSettingIconLocator.click();
		switch (genericColumnSetting) {

		case "Show fields":
			waiting.explicitWaitVisibilityOfElement(showFieldsSettingLoc, 5);
			Assert.assertTrue(showFieldsSettingLoc.isDisplayed(), "Show fields table setting option is not available");
			showFieldsSettingLoc.click();
			break;

		case "Sort Order":
			waiting.explicitWaitVisibilityOfElement(showSortSettingLoc, 5);

			Assert.assertTrue(showSortSettingLoc.isDisplayed(), "Sort order setting option is not available");
			showSortSettingLoc.click();
			break;
		default:
			throw new Exception("invalid selection for dynamic table setting");
		}
		return this;
	}

	public ItemsPageObjects setTheShowFieldsForDesktopView(String requiredfields) throws Exception {
		String[] fields = requiredfields.split(",");
		Thread.sleep(2500);
		for (int i = 0; i < fields.length; i++) {

			// Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='"+fields[i]+"']/ancestor::td/following-sibling::td/descendant::label/input[contains(@name,'ITMSLCT1')]/following-sibling::span")).isDisplayed(),"Manufacturer
			// part number field is not available");

			Assert.assertTrue(getDriver()
					.findElement(By.xpath(
							"//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='" + fields[i] + "']"))
					.isDisplayed(), fields[i] + " -> not available");

			WebElement wb1 = getDriver()
					.findElement(By.xpath("//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='" + fields[i]
							+ "']/following-sibling::td[1]/label/span"));

			WebElement wb2 = getDriver()
					.findElement(By.xpath("//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='" + fields[i]
							+ "']/following-sibling::td[1]/label/input"));
			if (!(wb2.isSelected())) {
				wb1.click();
				Thread.sleep(1000);
			}

		}

		getDriver()
				.findElement(By
						.xpath("//div[contains(text(),'Dynamic Table Settings')]/following-sibling::div/descendant::input[contains(@title,'Save')]"))
				.click();

		return this;
	}

	public ItemsPageObjects verifyGenericColumnSettingTable(String genericColumnSettingType) throws Exception {

		switch (genericColumnSettingType) {

		case "Show fields":
			waiting.explicitWaitVisibilityOfElement(dynamicTableSettingSection, 5);
			Assert.assertTrue(dynamicTableSettingSection.isDisplayed(), "dynamic table setting table is not available");
			break;

		case "Sort Order":
			waiting.explicitWaitVisibilityOfElement(sortOrderSettingSection, 5);

			Assert.assertTrue(sortOrderSettingSection.isDisplayed(), "sort order setting section is not displayed.");
			break;

		default:
			throw new Exception("invalid selection for dynamic table setting");
		}
		return this;
	}

	public ItemsPageObjects verifyItemsPageWithRequiredFields(String requiredfields) throws InterruptedException {
		String[] fields = requiredfields.split(",");
		Thread.sleep(3000);
		for (int i = 0; i < fields.length; i++) {

			Assert.assertTrue(getDriver()
					.findElement(
							By.xpath("//thead[@class='rich-table-thead']/descendant::span[text()='" + fields[i] + "']"))
					.isDisplayed());
		}

		return this;
	}

	@Step("verify error message while given same name {0} for workbook")
	public ItemsPageObjects verifyErrorMessageForReName(String workBookName, String reNameErroMsg) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//span[@id='searchFormId:addNewWrkBookMes' and contains(text(),'" + reNameErroMsg + "')]"),
				20);
		WebElement wb = getDriver().findElement(
				By.xpath("//span[@id='searchFormId:addNewWrkBookMes' and contains(text(),'" + reNameErroMsg + "')]"));
		Assert.assertEquals(wb.getText().trim(), "'" + workBookName + "' " + reNameErroMsg);

		return this;
	}

	@Step("select items {0} from list to work book ")
	public ItemsPageObjects clickOnSpecficCheckBoxes(String noOfItemsToBeSelect) throws InterruptedException {
		int itemsToSelect = Integer.parseInt(noOfItemsToBeSelect);
		waiting.explicitWaitVisibilityOfElements(
				By.xpath(
						"//tbody[@id='searchFormId:itemListTableId:tb']/descendant::input[contains(@id,'ITMSLCT')]/ancestor::label"),
				20);
		for (int i = 0; i < itemsToSelect; i++) {

			List<WebElement> ls = getDriver().findElements(By.xpath(
					"//tbody[@id='searchFormId:itemListTableId:tb']/descendant::input[contains(@id,'ITMSLCT')]/ancestor::label"));
			ls.get(i).click();
			Thread.sleep(2000);
		}

		return this;
	}

	@Step("verifies the alert text {0}")
	public ItemsPageObjects verifyAlertMessage(String alertTextMessage) {
		waiting.explicitWaitForAlert(20);
		String actualText = tu.getAlertText();
		Assert.assertEquals(actualText, alertTextMessage, "exp alert message" + alertTextMessage + "");
		tu.alertDismiss();

		return this;
	}

	public String getTheItemPartNumber(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 20);
		String getPartNumber = partNumberInputFieldItemEditPage.getAttribute("value");
		return getPartNumber;
	}

	@Step("verify work book {0}")
	public ItemsPageObjects verifyWorkBookName(String workBookName, String workbookRemovemsg)
			throws InterruptedException {
		Thread.sleep(2500);
		// waiting.explicitWaitVisibilityOfElement(By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"+workBookName+"')]"),
		// 20);
		Assert.assertTrue(assertVerifyWorkBook(workBookName, workbookRemovemsg),
				"unable to delete created workBook :" + workBookName + "");
		try {

			if (getDriver().findElement(
					By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"
							+ workBookName + "')]"))
					.isDisplayed())

			{
				deleteWorkbook(workBookName, workbookRemovemsg);
				// Assert.assertTrue(assertVerifyWorkBook(workBookName,workbookRemovemsg),"unable
				// to delete created workBook :"+workBookName+"");
			}
		} catch (Exception e) {
			clickOnWorkbookDropdown();
			verifyWorkBookName(workBookName, workbookRemovemsg);
		}
		return this;
	}

	private boolean assertVerifyWorkBook(String workBookName, String workbookRemovemsg) throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			if (getDriver().findElement(
					By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"
							+ workBookName + "')]"))
					.isDisplayed()) {
				deleteWorkbook(workBookName, workbookRemovemsg);
				return true;
			}
		} catch (NoSuchElementException e) {
			return true;
		}
		return false;
	}

	@Step("verification of item(s) {0}")
	public ItemsPageObjects verifyItemsPresent(String itemNameTemplate) {

		Assert.assertTrue(assertVerifyItem(itemNameTemplate),
				"items are already Present, Please delete items to create");

		return this;
	}

	private boolean assertVerifyItem(String itemNameTemplate) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			if (getDriver()
					.findElement(By.xpath("//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'"
							+ itemNameTemplate + "')]"))
					.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;

		}
		return false;
	}

	@Step("get the item id from the item list page{0}")
	public String getTheItemId(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath(
						"//td[contains(text(),'AutomationTestPN1')]/preceding-sibling::td/descendant::span[contains(@id,'ITMID')]"),
				70);
		String itemId = getDriver()
				.findElement(By
						.xpath("//td[contains(text(),'AutomationTestPN1')]/preceding-sibling::td/descendant::span[contains(@id,'ITMID')]"))
				.getText();

		return itemId;
	}

	public CopyOfItemPageObjects clickOnSpecificItemCopyButton(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[text()='" + partNumber
						+ "']/preceding-sibling::td/descendant::input[@title='Copy Of Item']"),
				50);
		getDriver().findElement(By.xpath("//tbody[@id='searchFormId:itemListTableId:tb']/descendant::td[text()='"
				+ partNumber + "']/preceding-sibling::td/descendant::input[@title='Copy Of Item']")).click();
		return new CopyOfItemPageObjects();
	}

	@Step("verify the remoe success message{0}")
	public ItemsPageObjects verifyRemoveItemSuccessMessage(String testData) {
		waiting.explicitWaitVisibilityOfElement(succesfulItemDeleteMessage, 30);
		Assert.assertEquals(succesfulItemDeleteMessage.getText().trim(),
				"Item with Part No. : '" + testData + "' removed Successfully");

		return this;
	}

	public ItemsPageObjects verifyWorkBookExist(String workBookName, String workbookRemovemsg)
			throws InterruptedException {
		Thread.sleep(2500);
		try {

			if (getDriver().findElement(
					By.xpath("//tbody[@id='searchFormId:workBookDataTable:tb']/descendant::a[contains(text(),'"
							+ workBookName + "')]"))
					.isDisplayed())

			{

				deleteWorkbook(workBookName, workbookRemovemsg);
				// Assert.assertTrue(assertVerifyWorkBook(workBookName,workbookRemovemsg),"unable
				// to delete created workBook :"+workBookName+"");
			} else {
				return this;
			}
		} catch (Exception e) {

		}

		return this;
	}

	@Step("search for taxonomy{0} in items list page")
	public ItemsPageObjects searchForTaxonomy(String taxonomy) {
		waiting.explicitWaitVisibilityOfElement(taxonomySearchInLeftPanel, 30);
		taxonomySearchInLeftPanel.clear();
		taxonomySearchInLeftPanel.sendKeys(taxonomy);

		return this;
	}

	public ItemsPageObjects clickOnRemoveItem(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'" + partNumber
						+ "')]/..//input[@title='Remove Item']"),
				20);
		getDriver().findElement(By.xpath("//table[@id='searchFormId:itemListTableId']/descendant::td[contains(text(),'"
				+ partNumber + "')]/..//input[@title='Remove Item']")).click();
		return this;
	}

	@Step("click on save icon to copy the Item")
	public ItemsPageObjects clickOnSaveIconOfCopiedItem() {
		waiting.explicitWaitVisibilityOfElement(saveIconToCopyLink, 15);
		saveIconToCopyLink.click();
		return this;
	}

	@Step("enter the item part number {0} .")
	public ItemsPageObjects enterPartNumber(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(enterPartNumberTextField, 15);
		enterPartNumberTextField.clear();
		enterPartNumberTextField.sendKeys(partNumber);
		return this;
	}

	@Step("enter the no.of copies {0}. ")
	public ItemsPageObjects enterNumerOfCopies(String numberOfItemsCopy) {
		waiting.explicitWaitVisibilityOfElement(enterTheNumberOfCopiesTextField, 15);
		enterTheNumberOfCopiesTextField.clear();
		enterTheNumberOfCopiesTextField.sendKeys(numberOfItemsCopy);
		return this;
	}

	@Step("Accept the alert")
	public ItemsPageObjects acceptAlert() {
		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
	}
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}
