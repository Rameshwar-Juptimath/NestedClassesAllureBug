package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManageTaxonomyPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	Waiting waiting = new Waiting(getDriver());
	TestUtility tu = new TestUtility(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());

	@FindAll(value = { @FindBy(xpath = "//tr[@class='rich-table-subheader']/th/div") })
	private List<WebElement> taxonomyTableHeadersLocator;

	@FindBy(xpath = "//td[@id='categoryAndAttributes_lbl']")
	private WebElement categoryandattributesLocator;

	@FindBy(xpath = "//td[@id='attributeGroups_lbl']")
	private WebElement attributesgroupsLocator;

	@FindBy(xpath = "//td[@id='attributes_lbl']")
	private WebElement attributesLocator;

	@FindBy(xpath = ".//*[@id='searchFormId']/div/div/div[2]/div")
	private WebElement leftarrowLocator;

	@FindBy(xpath = "//input[@id='searchFormId:searchITId']")
	private WebElement searchfieldLocator;

	@FindBy(xpath = "//div[@class='cimmSearchTxt']/input[@id='searchFormId:searchITId']")
	private WebElement CategorysearchfieldLocator;

	@FindBy(xpath = "//a[@title='Search']")
	private WebElement searchiconlocator;

	@FindBy(xpath = "//a[@title='Search ']/i")
	private WebElement categorysearchiconlocator;

	@FindBy(xpath = "//input[@title='Refresh Search']")
	private WebElement refreshlocator;

	@FindBy(xpath = "//a[@class='rich-tree-node-handle']/img[1]")
	private WebElement plusicon;

	@FindAll(value = { @FindBy(xpath = "//a[@class='rich-tree-node-handle']/img[1]") })
	private List<WebElement> plusiconlocator;

	@FindAll(value = { @FindBy(xpath = "//span[contains(@id,'treeNodeDataId')]") })
	private List<WebElement> categoryLocator;

	@FindBy(xpath = "//div[@class='sliderLeftArrow sliderRightArrow']")
	private WebElement leftArrow;

	@FindBy(id = "'categoryid:save'")
	private WebElement savebutton;

	@FindBy(xpath = "//span[@id='categoryid:ctgMsgId']")
	private WebElement successmesssage;

	@FindBy(id = "categoryid:addnewCategory")
	private WebElement saveButtonForCategorySave;

	@FindBy(xpath = "//input[@name='editcategory:cCode']")
	private WebElement editcategoryCodelocator;

	@FindBy(xpath = "//span[contains(text(),'Category Code must be Numeric')]")
	private WebElement errorMessagelocator;

	@FindBy(xpath = "//span[contains(text(),'Category Name required')]")
	private WebElement errorMessagelocatorForcategoryName;

	@FindBy(id = "//input[@id='editcategory:cName']")
	private WebElement categoryNameTextfield;

	@FindBy(id = "'categoryid:ctgMsgId'")
	private WebElement ErrorMessageafterenteringmorthan100characters;

	@FindBy(xpath = "//input[@id='editcategory:dSeq']")
	private WebElement displaySequencefieldloctor;

	@FindBy(xpath = "//span[contains(text(),'Display Sequence required')]")
	private WebElement errorMessagefordisplaysequence;

	@FindBy(xpath = "//input[@id='editcategory:removeStoredItem']")
	private WebElement deletincategory;

	@FindBy(xpath = "//a[@title='Category']")
	private WebElement plusiconForCreatingNewCategory;

	@FindAll(value = { @FindBy(xpath = "//span[@class='cimmEditCategoryLabel']") })
	private List<WebElement> categoryFields;

	@FindBy(xpath = "//input[@id='editcategory:dSeq']")
	private WebElement DisplaySequence;

	@FindBy(xpath = ".//*[@id='editcategory:categoryDesc']")
	private WebElement CategoryDescription;

	@FindBy(xpath = "//a[@title='Category']")
	private WebElement addNewCategoryButton;

	@FindBy(xpath = "//a[@title='Child Category']")
	private WebElement addNewChildCategoryButton;

	@FindBy(xpath = "//ul[@class='buttonList']/li/input[@title='Save New Category']")
	private WebElement saveNewCategoryButton;

	@FindBy(xpath = "//input[contains(@name,'editcategory:cCode')]")
	private WebElement categoryCode;

	@FindBy(id = "editcategory:cName")
	private WebElement categoryName;

	@FindBy(id = "editcategory:dSeq")
	private WebElement displaySequence;

	@FindBy(id = "editcategory:lNum")
	private WebElement levelNumber;

	@FindBy(xpath = "//li/input[contains(@id,'addnewCategory') and @title='Save New Category']")
	private WebElement saveCategory;

	@FindBy(xpath = "//select[@id='editcategory:locidUp1']")
	private WebElement localeSelect;

	@FindBy(xpath = "//textarea[@id='editcategory:categoryDesc']")
	private WebElement categoryDescriptionTextArea;

	@FindBy(xpath = "//textarea[@id='editcategory:marketingDesc']")
	private WebElement marketingDescriptionTextArea;

	@FindBy(xpath = "//select[@id='editcategory:vlbanner']")
	private WebElement editTopBanner;

	@FindBy(xpath = "//select[@id='editcategory:vlbanner2']")
	private WebElement editRightBanner;

	@FindBy(xpath = "//select[@id='editcategory:vlbanner3']")
	private WebElement editLeftBanner;

	@FindBy(xpath = "//select[@id='editcategory:vlbanner4']")
	private WebElement editBottomBanner;

	@FindBy(xpath = "//input[@title='Delete Category']")
	private WebElement deleteCategory;

	@FindBy(xpath = "//input[@title='History']")
	private WebElement viewHistoryButton;

	@FindBy(xpath = "//td[@id='attributes_lbl']")
	private WebElement attributesTab;

	@FindBy(xpath = "//td[@id='attributeGroups_lbl']")
	private WebElement attributesGroupsTab;

	@FindBy(xpath = "//input[@title='New Attribute']")
	private WebElement addNewAttributesButton;

	@FindBy(xpath = "//form[@id='addnewAttribute']/div/div[contains(.,'Attribute Name')]//following::input[contains(@id,'attrName')]")
	private WebElement attributeNameField;

	@FindBy(xpath = "//form[@id='addnewAttribute']//textarea[contains(@id,'attrbuteDesc')]")
	private WebElement attributeDescField;

	@FindBy(xpath = "//input[contains(@id,'searchKeywordId') and @placeholder='Enter Attribute Name to Search ']")
	private WebElement attributeSearchBox;

	@FindBy(xpath = "//input[contains(@id,'searchKeywordId') and @placeholder='Enter Attribute Name to Search ']//following::a[contains(@id,'goBtn')]")
	private WebElement attributeSearchIcon;

	@FindBy(xpath = "//form[@id='addnewAttribute']//select[contains(@id,'attrType')]")
	private WebElement attributeTypeSelector;

	@FindBy(xpath = "//form[@id='addnewAttribute']//div/img[@title='Close']")
	private WebElement closeAttributesFormButton;

	@FindBy(xpath = "//form[@id='addnewAttribute']//input[@title='Save Attribute']")
	private WebElement saveAttributesButton;

	@FindBy(xpath = "//form[@id='addnewAttribute']//input[@title='Reset']")
	private WebElement resetAttributesButton;

	@FindBy(xpath = "//td/span[@id='listAttribute1:countVal']")
	private WebElement attributesCount;

	@FindBy(xpath = "//table[contains(@id,'attributeDataTableId')]//tr[@class='rich-table-subheader ']")
	private WebElement attributesTableHeader;

	@FindBy(xpath = "//a[@id='listAttribute1:nextBtnId']")
	private WebElement attributesNextButton;

	@FindBy(xpath = "//a[@id='listAttribute1:prevBtnId']")
	private WebElement attributesPreviousButton;

	@FindBy(xpath = "//a[@id='listAttribute1:firstBtnId']")
	private WebElement attributesFirstButton;

	@FindBy(xpath = "//a[@id='listAttribute1:lastBtnId']")
	private WebElement attributesLastButton;

	@FindBy(xpath = "//span[@id='listAttribute1:tnpId']")
	private WebElement attributesTotalPagesCount;

	@FindBy(xpath = "//span[@id='listAttribute1:selectNo']")
	private WebElement attributesCurrentPageCount;

	@FindBy(xpath = "//input[@id='addnewAttribute:attrName1']")
	private WebElement editAttributeNameField;

	@FindBy(xpath = "//textarea[@id='addnewAttribute:attrbuteDesc1']")
	private WebElement editAttributeDescField;

	@FindBy(xpath = "//input[@title='Update Attribute']")
	private WebElement editAttributeSaveButton;

	@FindBy(xpath = "//form[@id='addnewAttribute']//a[@title='History']")
	private WebElement editAttributeHistoryButton;

	@FindBy(xpath = "//input[@title='New Attribute Group']")
	private WebElement addNewAttributesGroupButton;

	@FindBy(xpath = "//input[contains(@id,'searchKeywordId') and @placeholder='Enter Attribute Group Name to Search ']")
	private WebElement attributesGroupSearchBox;

	@FindBy(xpath = "//input[contains(@id,'searchKeywordId') and @placeholder='Enter Attribute Group Name to Search ']//following::a[contains(@id,'goBtn')]")
	private WebElement attributesGroupSearchIcon;

	@FindBy(xpath = "//tr[@class='rich-table-subheader ']")
	private WebElement attributesGroupTableHeader;

	@FindBy(xpath = "//input[@id='addNewAttrGroup:attrgrpName']")
	private WebElement attributeGroupNameField;

	@FindBy(xpath = "//textarea[@id='addNewAttrGroup:attrGrpTextArea']")
	private WebElement attributeGroupDescField;

	@FindBy(xpath = "//input[@title='Save Attribute Group']")
	private WebElement attributeGroupSaveButton;

	@FindBy(xpath = "//input[@title='Reset']")
	private WebElement attributeGroupResetButton;

	@FindBy(xpath = "//img[@title='Close']")
	private WebElement attributeGroupFormCloseButton;

	@FindBy(xpath = "//div[@class='leftSliderToggleImg']/div")
	private WebElement leftSliderToggleImgLocator;

	@FindBy(xpath = "//*[@id='categoryid:ctgMsgId' and contains(text(),'Category Deleted Successfully')]")
	private WebElement successfulMessageLocatorForDelCatecory;

	@FindBy(xpath = "//span[@id='categoryid:ctgMsgId']")
	private WebElement categoryRemoveSuccesMessage;

	public ManageTaxonomyPageObjects verifyTabsPresentInManageTaxonomyPage() throws InterruptedException {
		Assert.assertTrue(categoryandattributesLocator.isDisplayed());
		Assert.assertTrue(attributesLocator.isDisplayed());
		Assert.assertTrue(attributesgroupsLocator.isDisplayed());
		return this;
	}

	public ManageTaxonomyPageObjects clickOnLeftArrow() {

		waiting.explicitWaitElementToBeClickable(leftarrowLocator, 5);
		leftarrowLocator.click();
		return this;
	}

	public ManageTaxonomyPageObjects doubleClickOnCategory(int specificCategory) throws InterruptedException {
		Thread.sleep(2000);

		new Actions(getDriver()).doubleClick(categoryLocator.get(specificCategory - 1)).build().perform();

		return this;
	}

	public ManageTaxonomyPageObjects enterTheCategoryName(String categoryname) throws InterruptedException {
		Thread.sleep(3000);
		CategorysearchfieldLocator.sendKeys(Keys.ENTER);
		CategorysearchfieldLocator.sendKeys(categoryname);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnSearchIcon() {

		waiting.explicitWaitElementToBeClickable(searchiconlocator, 5);
		categorysearchiconlocator.click();
		return this;

	}

	public ManageTaxonomyPageObjects clickOnRefreshIcon() {

		waiting.explicitWaitElementToBeClickable(refreshlocator, 3);
		refreshlocator.click();
		return this;

	}

	public ManageTaxonomyPageObjects allcategoryLocators() {
		leftArrow.click();
		return this;
	}

	public ManageTaxonomyPageObjects verifyWhetherSearchedISEmpty() {
		return this;
	}

	@Step("verify whether {0} in the left navigation bar is highlighted with green colour.")
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen(String categoryName1) throws Exception {
		Thread.sleep(3000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName1 + "')]"))
				.getAttribute("style").trim().contains("green"));
		return this;
	}

	@Step("verify whether {0} in the left navigation bar is not  highlighted with green colour.")
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsInNotGreen(String categoryName1)
			throws Exception {

		Thread.sleep(3000);

		Assert.assertFalse((getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName1 + "')]"))
				.getAttribute("style").trim().contains("green")));
		return this;
	}

	@Step("verify the Expand/Collapse Feature in Manage Taxonomy Feature.")
	public ManageTaxonomyPageObjects verifyUserIsAblToViewTheHierarchyLevelsOfTheCategories(String categoryName)
			throws Exception {
		Thread.sleep(3000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName
				+ "')]//ancestor::tr[contains(@title,'" + categoryName + "')]/td/div/a/img[contains(@id,'collapsed')]"))
				.isEnabled());

		getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName
				+ "')]//ancestor::tr[contains(@title,'" + categoryName + "')]/td/div/a/img[contains(@id,'collapsed')]"))
				.click();

		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName
				+ "')]//ancestor::tr[contains(@title,'" + categoryName + "')]/td/div/a/img[contains(@id,'collapsed')]"))
				.isDisplayed());

		return this;

	}

	public ManageTaxonomyPageObjects clickOnPlusIcon() throws InterruptedException {
		Thread.sleep(3000);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", plusiconForCreatingNewCategory);
		return this;
	}

	public ManageTaxonomyPageObjects enterTheCategoryDescription(String getcategoryDescription)
			throws InterruptedException {
		Thread.sleep(1500);
		CategoryDescription.sendKeys(Keys.ENTER);
		CategoryDescription.sendKeys(getcategoryDescription);
		return this;

	}

	public ManageTaxonomyPageObjects enterTheCategorySequence(String getcategorySequence) throws InterruptedException {
		Thread.sleep(1500);
		DisplaySequence.clear();
		DisplaySequence.sendKeys(Keys.ENTER);
		DisplaySequence.sendKeys(getcategorySequence);
		return this;

	}

	public ManageTaxonomyPageObjects enterTheNewCategoryName(String getCategoryName) throws InterruptedException {
		Thread.sleep(1500);
		categoryName.sendKeys(Keys.ENTER);
		categoryName.sendKeys(getCategoryName);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnSaveButton() throws InterruptedException {

		/*
		 * waiting.explicitWaitElementToBeClickable(savebutton, 5);
		 * savebutton.click();
		 */
		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", savebutton);

		return this;

	}

	@Step("To Verify the Error Message on Creating the Category with Invalid Details")
	public ManageTaxonomyPageObjects verifyDifferentMessageDisplayedAfterSavinCategory(String errorMessage)
			throws Exception {
		Thread.sleep(7000);

		Assert.assertTrue(getDriver()
				.findElement(By.xpath("//td/span[@style='color:red;' and contains(text(),'" + errorMessage + "')]"))
				.isDisplayed());

		return this;
	}

	public ManageTaxonomyPageObjects clickOnSaveButtonForCategorySave() throws InterruptedException {
		Thread.sleep(2500);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", saveButtonForCategorySave);

		return this;
	}

	public ManageTaxonomyPageObjects validatingCategoryCodeFieldByEnteringAlphanumericcharacters(
			String alphanumericcharacters) throws InterruptedException {
		Thread.sleep(3000);
		editcategoryCodelocator.clear();
		editcategoryCodelocator.sendKeys(alphanumericcharacters);
		return this;
	}

	public ManageTaxonomyPageObjects verifyErrorMessage() {
		Assert.assertEquals(errorMessagelocator.getText().trim(), "Category Code must be Numeric");
		return this;
	}

	public ManageTaxonomyPageObjects enteringgMoreThan100characters(String moreThan100Characters)
			throws InterruptedException {
		Thread.sleep(5000);
		categoryNameTextfield.sendKeys(Keys.ENTER);
		categoryNameTextfield.sendKeys(moreThan100Characters);
		return this;

	}

	public ManageTaxonomyPageObjects validatingCategoryNameFieldByLeavingEmpty(
			String ErrorMessageAfterClickingSaveButton) {

		waiting.explicitWaitElementToBeClickable(errorMessagelocatorForcategoryName, 5);
		Assert.assertEquals(errorMessagelocatorForcategoryName.getText().trim(), ErrorMessageAfterClickingSaveButton);
		return this;

	}

	public void verifyErrorMessageAfterEnteringMoreThan100Characters() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(ErrorMessageafterenteringmorthan100characters.isDisplayed());

	}

	public ManageTaxonomyPageObjects enteringCategoryCode(String categoryCode) {

		waiting.explicitWaitElementToBeClickable(editcategoryCodelocator, 5);
		editcategoryCodelocator.clear();
		editcategoryCodelocator.sendKeys(categoryCode);
		return this;
	}

	public ManageTaxonomyPageObjects enterNumericCharactersInDisplaySequenceField(String getnumaricCharacter)
			throws InterruptedException {
		Thread.sleep(2500);
		displaySequencefieldloctor.clear();
		displaySequencefieldloctor.sendKeys(getnumaricCharacter);
		return this;
	}

	public ManageTaxonomyPageObjects verifytheMessageByleavingDisplaySequenceFieldEmpty() throws InterruptedException {
		Thread.sleep(3500);
		Assert.assertEquals(errorMessagefordisplaysequence.getText().trim(), "Display Sequence required");
		return this;
	}

	public ManageTaxonomyPageObjects clearTheDisplaySequenceField() {

		waiting.explicitWaitElementToBeClickable(displaySequencefieldloctor, 5);
		displaySequencefieldloctor.clear();
		return this;
	}

	public ManageTaxonomyPageObjects deleteCategory() {

		waiting.explicitWaitElementToBeClickable(deletincategory, 5);
		deletincategory.click();
		String text = getDriver().switchTo().alert().getText();
		Assert.assertEquals(text, "Are sure you want remove this Category ?");
		System.out.println("Popup " + text);
		return this;

	}

	@Step("To Verify the Fields Present Upon Clicking the 'Add New Category' Button")
	public ManageTaxonomyPageObjects verifyCategoryFields() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(categoryName.isDisplayed());
		Assert.assertTrue(categoryCode.isDisplayed());
		Assert.assertTrue(displaySequence.isDisplayed());
		Assert.assertTrue(levelNumber.isDisplayed());

		Assert.assertTrue(getDriver()
				.findElement(By
						.xpath("//td/span[contains(text(),'Category Static')]//following::select[@class='cimmEditCategoryText'][1]"))
				.isDisplayed());
		Assert.assertTrue(editTopBanner.isDisplayed());
		Assert.assertTrue(editRightBanner.isDisplayed());
		Assert.assertTrue(editLeftBanner.isDisplayed());
		Assert.assertTrue(editBottomBanner.isDisplayed());
		return this;
	}

	@Step("To Verify the Fields Present Upon Clicking the 'Add New Child Category' Button")
	public ManageTaxonomyPageObjects verifyChildCategoryFields() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(categoryName.isDisplayed());
		Assert.assertTrue(categoryCode.isDisplayed());
		Assert.assertTrue(displaySequence.isDisplayed());
		Assert.assertTrue(levelNumber.isDisplayed());

		Assert.assertTrue(getDriver()
				.findElement(By
						.xpath("//td/span[contains(text(),'Category Static')]//following::select[@class='cimmEditCategoryText'][1]"))
				.isDisplayed());
		Assert.assertTrue(editTopBanner.isDisplayed());
		Assert.assertTrue(editRightBanner.isDisplayed());
		Assert.assertTrue(editLeftBanner.isDisplayed());
		Assert.assertTrue(editBottomBanner.isDisplayed());
		return this;
	}

	public ManageTaxonomyPageObjects verifyLeftPanelTaxonomyName(String taxonomyname) throws InterruptedException {

		Thread.sleep(2000);

		WebElement ele = getDriver().findElement(By
				.xpath("//div[@class='editTaxonomyWrap']/descendant::input[contains(@value,'" + taxonomyname + "')]"));
		Assert.assertTrue(ele.isDisplayed(), "Taxonomy " + taxonomyname + " is not Present in the Left Side Panel");
		return this;
	}

	public ManageTaxonomyPageObjects clickOnAddNewCategory(String categoryName) throws InterruptedException {

		try {
			waiting.explicitWaitVisibilityOfElement(By.xpath("//span[text()='" + categoryName + "']"), 15);
			// getDriver().findElement(By.xpath("//span[text()='"+categoryName+"']")).click();
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
					getDriver().findElement(By.xpath("//span[text()='" + categoryName + "']")));

		} catch (Exception e) {
			System.out.println(e);
		}

		waiting.explicitWaitElementToBeClickable(addNewCategoryButton, 30);
		addNewCategoryButton.click();
		Thread.sleep(2000);
		return this;
	}

	public ManageTaxonomyPageObjects addNewCategory(String categoryCodeforParentCategory,
			String categoryNameforParentCategory, String displaySequenceforParentCategory) throws Exception {

		clickOnAddNewCategory(categoryNameforParentCategory);
		enterParentCategoryCode(categoryCodeforParentCategory);
		enterParentCategoryName(categoryNameforParentCategory);
		enterDisplaySequenceOfParentCategory(displaySequenceforParentCategory);

		return this;
	}

	public ManageTaxonomyPageObjects addNewCategoryAndVerify(String categoryCodeforParentCategory,
			String categoryNameforParentCategory, String displaySequenceforParentCategory,
			String NoOfCategoriesToCreate, String expMsg) throws Exception {
		int var = Integer.parseInt(NoOfCategoriesToCreate);

		for (int i = 1; i <= var; i++) {
			clickOnAddNewCategory(categoryNameforParentCategory);
			enterParentCategoryCode(categoryCodeforParentCategory + i);
			enterParentCategoryName(categoryNameforParentCategory + i);
			enterDisplaySequenceOfParentCategory(displaySequenceforParentCategory);
			saveNewCategory();
			verifySuccessMessageAfterSavingCategory(expMsg);
		}
		return this;
	}

	@Step("enter parent category code {0}")
	public ManageTaxonomyPageObjects enterParentCategoryCode(String categoryCodeforParentCategory)
			throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(categoryCode, 15);
		categoryCode.click();
		categoryCode.clear();
		categoryCode.sendKeys(categoryCodeforParentCategory);
		return this;
	}

	@Step("enter parent category name {0}")
	public ManageTaxonomyPageObjects enterParentCategoryName(String categoryNameforParentCategory)
			throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(categoryName, 20);
		categoryName.click();
		categoryName.clear();
		categoryName.sendKeys(categoryNameforParentCategory);
		return this;
	}

	@Step("enter parent category name {0}")
	public ManageTaxonomyPageObjects enterDisplaySequenceOfParentCategory(String displaySequenceforParentCategory)
			throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(displaySequence, 20);
		displaySequence.click();
		displaySequence.clear();
		displaySequence.sendKeys(displaySequenceforParentCategory);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnAddNewChildCategory() throws Exception {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(addNewChildCategoryButton, 20);
		addNewChildCategoryButton.click();
		Thread.sleep(4000);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnCategory(String categoryName) {
		verifyCategoryBeforeRemove(categoryName);
		// Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='treeCategoryName']/descendant::span[contains(@id,'treeNodeDataId')
		// and text()='"+categoryName+"']")).getText(), categoryName);
		// waiting.explicitWaitElementToBeClickable(By.xpath("//div[@class='treeCategoryName']/descendant::span[contains(@id,'treeNodeDataId')
		// and text()='"+categoryName+"']"), 15);
		getDriver().findElement(
				By.xpath("//div[@class='treeCategoryName']/descendant::span[contains(@id,'treeNodeDataId') and text()='"
						+ categoryName + "']"))
				.click();
		return this;
	}

	public ManageTaxonomyPageObjects addNewChildCategory(String categoryname, String categoryCodeofChild,
			String childCategoryName, String displaySequence) throws Exception {
		for (int i = 1; i < 3; i++) {
			Thread.sleep(2000);
			clickOnRespectiveCategory(categoryname);
			clickOnAddNewChildCategory();
			waiting.explicitWaitVisibilityOfElement(categoryCode, 20);
			Thread.sleep(3000);
			categoryCode.click();
			categoryCode.clear();
			categoryCode.sendKeys(categoryCodeofChild + i);
			categoryName.clear();
			categoryName.sendKeys(childCategoryName + i);
			DisplaySequence.clear();
			DisplaySequence.sendKeys(displaySequence + i);
			saveNewCategory();
			Thread.sleep(1000);
		}
		return this;
	}

	@Step("To Save Category")
	public ManageTaxonomyPageObjects saveNewCategory() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(saveCategory, 20);
		saveCategory.click();
		Thread.sleep(3000);
		// ((JavascriptExecutor)
		// getDriver()).executeScript("arguments[0].click();",saveCategory);
		return this;
	}

	@Step("To Click on {0} Category")
	public ManageTaxonomyPageObjects clickOnRespectiveCategory(String categoryName) throws Exception {
		waiting.explicitWaitVisibilityOfElement(By.xpath(
				"//div[@id='searchFormId:taxonomyTreeId']/descendant::span[contains(text(),'" + categoryName + "')]"),
				30);
		Assert.assertTrue(getDriver().findElement(By.xpath(
				"//div[@id='searchFormId:taxonomyTreeId']/descendant::span[contains(text(),'" + categoryName + "')]"))
				.isDisplayed(), "Category name is not available");
		getDriver().findElement(By.xpath(
				"//div[@id='searchFormId:taxonomyTreeId']/descendant::span[contains(text(),'" + categoryName + "')]"))
				.click();
		return this;
	}

	@Step("To Verify 500 Characters Limit in Category Description Field")

	public ManageTaxonomyPageObjects verifyCharacterLimitInCategoryDescField(String description) throws Exception {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(5000);
		categoryDescriptionTextArea.clear();

		categoryDescriptionTextArea.sendKeys(description);
		String enteredText = categoryDescriptionTextArea.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Verify 500 Characters Limit in Marketing Description Field")

	public ManageTaxonomyPageObjects verifyCharacterLimitInMarketingDescField(String marketingDescription)
			throws Exception {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(5000);
		marketingDescriptionTextArea.clear();

		marketingDescriptionTextArea.sendKeys(marketingDescription);
		String enteredText = marketingDescriptionTextArea.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Verify the Message Displayed after succesfully saving a Category")
	public ManageTaxonomyPageObjects verifySuccessMessageAfterSavingCategory(
			String expectedNewSavedCategorySuccesfulMessage) throws Exception {

		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[@id='categoryid:ctgMsgId' and contains(text(),'"
				+ expectedNewSavedCategorySuccesfulMessage + "')]"), 20);
		Assert.assertEquals(
				getDriver().findElement(By.xpath("//span[@id='categoryid:ctgMsgId' and contains(text(),'"
						+ expectedNewSavedCategorySuccesfulMessage + "')]")).getText(),
				expectedNewSavedCategorySuccesfulMessage);
		return this;
	}

	@Step("To Verify the Message Displayed after succesfully saving a Category")
	public ManageTaxonomyPageObjects verifySuccessMessageAfterDeletingCategory() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(successfulMessageLocatorForDelCatecory.isDisplayed());
		return this;
	}

	@SuppressWarnings("static-access")
	public ManageTaxonomyPageObjects clickOnDeleteCategoryButton() throws Exception {
		Thread.sleep(5000);
		deleteCategory.click();
		Thread.sleep(2000);
		tu.alertAccept();
		return this;
	}

	@Step("To Click on '+' image for the {0} Category")
	public ManageTaxonomyPageObjects clickOnExpandViewForRespectiveCategory(String categoryName) throws Exception {
		Thread.sleep(5000);

		getDriver()
				.findElement(By.xpath(
						"//span[contains(text(),'" + categoryName + "')]/../../../..//a/img[contains(@src,'plus')]"))
				.click();
		return null;
	}

	@Step("To Verify the Fields Present Upon Clicking the 'Add New Category' Button")
	public ManageTaxonomyPageObjects editCategoryFields(String editCategoryName, String displaySequence2)
			throws Exception {
		Thread.sleep(5000);
		categoryName.clear();
		categoryName.sendKeys(editCategoryName);
		displaySequence.clear();
		displaySequence.sendKeys(displaySequence2);
		return this;
	}

	@Step("To Save the Category upon Editing")
	public ManageTaxonomyPageObjects saveEditedCategory() throws Exception {
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//input[@title='Save']")).click();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on the 'View History' Button")
	public ManageTaxonomyPageObjects clickOnViewHistoryButton() throws Exception {
		Thread.sleep(5000);
		viewHistoryButton.click();
		tu.alertAccept();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Verify the Contents On clicking 'View History' Button opened on the New Tab.")
	public ManageTaxonomyPageObjects switchToNewlyOpenedWindowAndVerifyCategoryName(String categoryName1)
			throws Exception {
		Thread.sleep(5000);

		utility.switchToRecentWindow();
		Thread.sleep(5000);
		Assert.assertTrue(
				getDriver().findElement(By.xpath("//td/span[contains(.,'" + categoryName1 + "')]")).isDisplayed());
		Thread.sleep(5000);
		utility.switchBackToFirstWindow();
		return this;
	}

	@Step("To Click on 'Attributes' tab from the Manage Taxonomy Page.")
	public ManageTaxonomyPageObjects clickOnAttributesTabFromManageTaxonomyPage() throws Exception {
		Thread.sleep(5000);
		attributesTab.click();
		return this;
	}

	@Step("To Click on 'Add New Attribute' Button in the Attributes Page.")
	public ManageTaxonomyPageObjects clickOnAddNewAttribute() throws Exception {
		Thread.sleep(5000);
		addNewAttributesButton.click();
		return this;
	}

	@Step("To Verify 'Add New Attributes' Form Items")
	public ManageTaxonomyPageObjects verifyTheFieldsOfAddNewAttributeForm() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(attributeNameField.isDisplayed());
		Assert.assertTrue(attributeTypeSelector.isDisplayed());
		Assert.assertTrue(attributeDescField.isDisplayed());
		Assert.assertTrue(closeAttributesFormButton.isDisplayed());
		Assert.assertTrue(saveAttributesButton.isDisplayed());
		Assert.assertTrue(resetAttributesButton.isDisplayed());
		return this;
	}

	@Step("To Verify 'Attributes' Page Items")
	public ManageTaxonomyPageObjects verifyAttributesPageItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(attributeSearchBox.isDisplayed());
		Assert.assertTrue(attributeSearchIcon.isDisplayed());
		Assert.assertTrue(attributesCount.isDisplayed());
		Assert.assertTrue(attributesTableHeader.isDisplayed());
		return this;
	}

	@Step("To Add a New 'Attribute'")
	public ManageTaxonomyPageObjects addNewAttribute(String attributeName, String attributeDesc) throws Exception {
		Thread.sleep(1000);
		attributeNameField.clear();
		attributeNameField.sendKeys(attributeName);
		attributeDescField.clear();
		attributeDescField.sendKeys(attributeDesc);
		return this;
	}

	@Step("To Save a New 'Attribute'")
	public ManageTaxonomyPageObjects saveAttributes() {
		saveAttributesButton.click();
		return this;
	}

	@Step("To Verify the Message Upon Saving a new 'Attribute''")
	public ManageTaxonomyPageObjects verifyMessageAfterSavingAttributes(String saveMessage) throws Exception {
		Thread.sleep(5000);
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(.,'" + saveMessage + "') and contains(@style,'red')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(@style,'green') and contains(.,'" + saveMessage + "')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	@Step("To Verify the Characters Limit of Attribute Name Field''")
	public ManageTaxonomyPageObjects verifyCharactersLimitOfAttributeNameField() {
		for (int i = 0; i < 60; i++) {
			attributeNameField.sendKeys("a");
		}
		String enteredText = attributeNameField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(attributeNameField.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Characters Limit of Attribute Desc Field''")
	public ManageTaxonomyPageObjects verifyCharactersLimitOfAttributeDescField() throws Exception {
		SoftAssert softassert = new SoftAssert();
		attributeDescField.clear();
		for (int i = 0; i < 525; i++) {
			attributeDescField.sendKeys("a");
		}
		Thread.sleep(2000);
		String enteredText = attributeDescField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Click on Next Page Option and Verify the Functionality.")
	public ManageTaxonomyPageObjects verifytheWorkingOfTheNextPageOption() throws Exception {
		int currentPageNumber1 = Integer.parseInt(attributesCurrentPageCount.getText());
		attributesNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 = Integer.parseInt(attributesCurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on Previous Page Option and Verify the Functionality.")
	public ManageTaxonomyPageObjects verifytheWorkingOfThePreviousPageOption() throws Exception {
		attributesNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber1 = Integer.parseInt(attributesCurrentPageCount.getText());
		attributesPreviousButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 = Integer.parseInt(attributesCurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on Last Page Option and Verify the Functionality.")
	public ManageTaxonomyPageObjects verifytheWorkingOfTheLastPageOption() throws Exception {
		int totalPagesCount = Integer.parseInt(attributesTotalPagesCount.getText());
		attributesLastButton.click();
		Thread.sleep(5000);
		int currentPageNumber = Integer.parseInt(attributesCurrentPageCount.getText());
		Assert.assertEquals(totalPagesCount, currentPageNumber);
		return this;
	}

	@Step("To Click on First Page Option and Verify the Functionality.")
	public ManageTaxonomyPageObjects verifytheWorkingOfTheFirstPageOption() throws Exception {
		attributesNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber1 = Integer.parseInt(attributesCurrentPageCount.getText());
		attributesFirstButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 = Integer.parseInt(attributesCurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on 'NoOfItems Dropdown' and verify contents dispalyed.")
	public ManageTaxonomyPageObjects verifyDisplayNoOfItemsDropdown() throws Exception {
		SoftAssert sa = new SoftAssert();

		List<WebElement> itemsDisplayed = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		Assert.assertEquals(itemsDisplayed.size(), 10);

		getDriver().findElement(By.xpath("//select[@id='listAttribute1:nrpp']/option[@value='25']")).click();
		Thread.sleep(5000);
		List<WebElement> itemsDisplayed1 = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		sa.assertEquals(itemsDisplayed1.size(), 25);

		getDriver().findElement(By.xpath("//select[@id='listAttribute1:nrpp']/option[@value='50']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed2 = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		sa.assertEquals(itemsDisplayed2.size(), 50);

		getDriver().findElement(By.xpath("//select[@id='listAttribute1:nrpp']/option[@value='75']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed3 = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		sa.assertEquals(itemsDisplayed3.size(), 75);

		getDriver().findElement(By.xpath("//select[@id='listAttribute1:nrpp']/option[@value='100']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed4 = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		sa.assertEquals(itemsDisplayed4.size(), 100);

		getDriver().findElement(By.xpath("//select[@id='listAttribute1:nrpp']/option[@value='10']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed5 = getDriver()
				.findElements(By.xpath("(//div[@class='cimmAttributesColumn1']//tbody)[2]/tr"));
		sa.assertEquals(itemsDisplayed5.size(), 10);
		sa.assertAll();
		return this;
	}

	@Step("To Search for an Attribute.")
	public ManageTaxonomyPageObjects searchForAnAttribute(String attributeName) throws Exception {
		attributeSearchBox.clear();
		attributeSearchBox.sendKeys(attributeName);
		attributeSearchIcon.click();
		return this;
	}

	@Step("To verify an Attribute after Search.")
	public ManageTaxonomyPageObjects verifyAfterAttributeSearch(String attributeName) throws Exception {
		Thread.sleep(5000);

		Assert.assertTrue(getDriver()
				.findElement(
						By.xpath("//td[contains(@id,'attributeNameCol') and contains(text(),'" + attributeName + "')]"))
				.isDisplayed());
		return this;
	}

	@Step("To Click on 'Edit' button of an Atribute")
	public ManageTaxonomyPageObjects clickOnEditAttributeButton(String attributeName) throws Exception {

		getDriver().findElement(By.xpath("//td[contains(@id,'attributeNameCol') and contains(text(),'" + attributeName
				+ "')]//preceding-sibling::td/div/input[@title='Edit Attribute']")).click();
		return this;
	}

	@Step("To verify the Form Contents of Edit Attribute.")
	public ManageTaxonomyPageObjects verifyEditAttributeFormItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(editAttributeNameField.isDisplayed());
		Assert.assertTrue(editAttributeDescField.isDisplayed());
		Assert.assertTrue(editAttributeSaveButton.isDisplayed());
		return this;
	}

	@Step("To Edit Attribute.")
	public ManageTaxonomyPageObjects editAnAttribute(String attributeName, String attributeDesc) {
		editAttributeNameField.clear();
		editAttributeNameField.sendKeys(attributeName);
		editAttributeDescField.clear();
		editAttributeDescField.sendKeys(attributeDesc);
		return this;
	}

	@Step("To Save Edited Attribute.")
	public ManageTaxonomyPageObjects saveEditedAttribute() {
		editAttributeSaveButton.click();
		return this;
	}

	@Step("To Verify the Message after Editing Attribute.")
	public ManageTaxonomyPageObjects verifyMessageAfterEditingAnAttribute(String saveMessage) throws Exception {
		Thread.sleep(5000);
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(.,'" + saveMessage + "') and contains(@style,'red')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(@style,'green') and contains(.,'" + saveMessage + "')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	@Step("To Verify the Characters Limit in Edit Attributes Name Field.")
	public ManageTaxonomyPageObjects verifyCharactersLimitOfEditAttributeNameField() throws Exception {
		Thread.sleep(5000);
		for (int i = 0; i < 60; i++) {
			editAttributeNameField.sendKeys("a");
		}
		String enteredText = editAttributeNameField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(editAttributeNameField.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Characters Limit in Edit Attributes Desc Field.")
	public ManageTaxonomyPageObjects verifyCharactersLimitOfEditAttributeDescField() throws Exception {
		Thread.sleep(5000);
		SoftAssert softassert = new SoftAssert();
		editAttributeDescField.clear();
		for (int i = 0; i < 525; i++) {
			editAttributeDescField.sendKeys("a");
		}
		Thread.sleep(2000);
		String enteredText = editAttributeDescField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on History Button in Edit Attribute Form.")
	public ManageTaxonomyPageObjects clickOnViewAttributeHistoryButton() throws Exception {
		Thread.sleep(2000);
		editAttributeHistoryButton.click();
		tu.alertAccept();
		return null;
	}

	@SuppressWarnings("static-access")
	@Step("To Switch to Newly Opened Window and Verify the Presence of an Attribute.")
	public ManageTaxonomyPageObjects switchToNewlyOpenedWindowAndVerifyAttributeName(String attributeName)
			throws Exception {
		Thread.sleep(5000);

		utility.switchToRecentWindow();
		Assert.assertTrue(
				getDriver().findElement(By.xpath("//td/span[contains(.,'" + attributeName + "')]")).isDisplayed());
		Thread.sleep(5000);
		utility.switchBackToFirstWindow();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on Delete of the Respective Attribute")
	public ManageTaxonomyPageObjects clickOnDeleteAttributeButton(String attributeName) throws Exception {
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//td[contains(@id,'attributeNameCol') and contains(text(),'" + attributeName
				+ "')]//preceding-sibling::td/div/input[contains(@src,'delete')]")).click();
		tu.alertAccept();
		Thread.sleep(5000);
		Assert.assertTrue(getDriver()
				.findElement(
						By.xpath("//span[contains(@style,'green') and contains(.,'Attribute Removed Successfully')]"))
				.isDisplayed());
		return this;
	}

	@Step("To Click on Attributes Group Tab from Manage Taxonomy Page")
	public ManageTaxonomyPageObjects clickOnAttributesGroupsTabFromManageTaxonomyPage() throws Exception {
		Thread.sleep(5000);
		attributesGroupsTab.click();
		return this;
	}

	@Step("To Verify Page contents of Attributes Group Page")
	public ManageTaxonomyPageObjects verifyAttrbuteGroupsPageItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(attributesGroupSearchBox.isDisplayed());
		Assert.assertTrue(attributesGroupSearchIcon.isDisplayed());
		Assert.assertTrue(attributesGroupTableHeader.isDisplayed());
		Assert.assertTrue(addNewAttributesGroupButton.isDisplayed());
		return this;
	}

	@Step("To Verify Form contents of 'Add New Attributes Group' Form.")
	public ManageTaxonomyPageObjects verifyAddNewAttributeGroupFormItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(attributeGroupNameField.isDisplayed());
		Assert.assertTrue(attributeGroupDescField.isDisplayed());
		Assert.assertTrue(attributeGroupSaveButton.isDisplayed());
		Assert.assertTrue(attributeGroupResetButton.isDisplayed());
		Assert.assertTrue(attributeGroupFormCloseButton.isDisplayed());
		return this;
	}

	@Step("To Verify Form contents of 'Add New Attributes Group' Form.")
	public ManageTaxonomyPageObjects clickOnAddNewAttributeGroupButton() {
		addNewAttributesGroupButton.click();
		return this;
	}

	@Step("To Add contents to 'Add New Attributes Group' Form.")
	public ManageTaxonomyPageObjects addNewAttributeGroup(String attributeGroupName, String attributeGroupDesc)
			throws Exception {
		Thread.sleep(5000);
		attributeGroupNameField.clear();
		attributeGroupNameField.sendKeys(attributeGroupName);
		attributeGroupDescField.clear();
		attributeGroupDescField.sendKeys(attributeGroupDesc);
		return this;
	}

	@Step("To Click on 'Save' Attribute Group Button.")
	public ManageTaxonomyPageObjects clickOnAttributeGroupsSaveButton() throws Exception {
		Thread.sleep(1000);
		attributeGroupSaveButton.click();
		return this;
	}

	@Step("To Verify Success/Failure Message after saving Attribute Groups.")
	public ManageTaxonomyPageObjects verifyMessageAfterSavingAttributeGroup(String saveMessage) throws Exception {
		Thread.sleep(5000);
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(.,'" + saveMessage + "') and contains(@style,'red')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(@style,'green') and contains(.,'" + saveMessage + "')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	@Step("To Verify Character Limit for Attribute Name Field.")
	public ManageTaxonomyPageObjects verifyCharacterLimitForAttributesGroupNameField() throws Exception {
		Thread.sleep(5000);
		for (int i = 0; i < 65; i++) {
			attributeGroupNameField.sendKeys("a");
		}
		String enteredText = attributeGroupNameField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(attributeGroupNameField.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify Character Limit for Attribute Name Field.")
	public ManageTaxonomyPageObjects verifyCharacterLimitForAttributesGroupDescField() throws Exception {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(5000);
		attributeGroupDescField.clear();
		for (int i = 0; i < 525; i++) {
			attributeGroupDescField.sendKeys("i");
		}
		Thread.sleep(2000);
		String enteredText = attributeGroupDescField.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Search for an Attribute Group Item.")
	public ManageTaxonomyPageObjects searchForAttributeGroup(String attributeGroupName) throws Exception {

		waiting.explicitWaitVisibilityOfElement(attributesGroupSearchBox, 15);
		attributesGroupSearchBox.clear();
		attributesGroupSearchBox.sendKeys(attributeGroupName);
		attributesGroupSearchIcon.click();
		return this;
	}

	@Step("To Verify after Searching for an Attribute Group Item.")
	public ManageTaxonomyPageObjects verifyAfterSearchingForAttributeGorup(String attributeGroupName) throws Exception {
		Thread.sleep(5000);

		Assert.assertTrue(getDriver()
				.findElement(By.xpath(
						"//td[contains(@id,'attributeGroupNameCol') and contains(.,'" + attributeGroupName + "')]"))
				.isDisplayed());
		return this;
	}

	@Step("To Click on the Edit Button of a Specific Attribute Group.")
	public ManageTaxonomyPageObjects clickOnEditSpecificAttributeGroup(String attributeGroupName) throws Exception {
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//td[contains(@id,'attributeGroupNameCol') and contains(.,'"
				+ attributeGroupName + "')]//preceding::input[@title='Edit Attribute Group']")).click();
		return this;
	}

	@Step("To Verify after Searching for an Attribute Group Item.")
	public ManageTaxonomyPageObjects editAttributeGroup(String editedAttributedGroupName, String attributeGroupDesc)
			throws InterruptedException {
		Thread.sleep(5000);
		attributeGroupNameField.clear();
		attributeGroupNameField.sendKeys(editedAttributedGroupName);
		attributeGroupDescField.clear();
		attributeGroupDescField.sendKeys(attributeGroupDesc);
		return this;
	}

	@Step("To Click on Save Button after Editing an Attribute Group.")
	public ManageTaxonomyPageObjects saveEditedAttributeGroup() throws Exception {
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//input[@title='Update Attribute Group']")).click();
		return this;
	}

	@Step("To Verify the Message displayed after Saving an Attribute Groups.")
	public ManageTaxonomyPageObjects verifyMessageAfterEditingAnAttributeGroup(String saveMessage) throws Exception {
		Thread.sleep(5000);
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(.,'" + saveMessage + "') and contains(@style,'red')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			Assert.assertTrue(getDriver()
					.findElement(By.xpath("//span[contains(@style,'green') and contains(.,'" + saveMessage + "')]"))
					.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on Delete Button of an Attribute Group.")
	public ManageTaxonomyPageObjects clickOnDeleteAttributeGroupButton(String attributeGroupName) throws Exception {
		Thread.sleep(3000);

		getDriver().findElement(By.xpath("//td[contains(@id,'attributeGroupNameCol') and contains(.,'"
				+ attributeGroupName + "')]//preceding::input[contains(@src,'delete.png')]")).click();
		Thread.sleep(2000);
		tu.alertAccept();
		return this;
	}

	@Step("To Verify the Message After Deleting an Attribute Group Click on Delete Button of an Attribute Group.")
	public ManageTaxonomyPageObjects verifyMessageAfterDeletingAttributeGroup() throws Exception {
		Thread.sleep(5000);

		Assert.assertTrue(getDriver()
				.findElement(By.xpath("//span[contains(@style,'green') and contains(.,'removed successfully')]"))
				.isDisplayed());

		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on History Button of an Attribute Group.")
	public ManageTaxonomyPageObjects clickOnViewHistoryButtonForAttributesGroup() throws Exception {
		Thread.sleep(2000);

		getDriver().findElement(By.xpath("//a[@title='History']")).click();
		Thread.sleep(2000);
		tu.alertAccept();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Verify the Attribute Group Name Present in the Newly Opened Windows.")
	public ManageTaxonomyPageObjects switchToNewlyOpenedWindowAndVerifyAttributeGroupName(String attributeGroupName)
			throws Exception {
		Thread.sleep(2000);

		utility.switchToRecentWindow();
		Thread.sleep(3000);
		Assert.assertTrue(getDriver()
				.findElement(By.xpath("//span[contains(@style,'bold') and contains(.,'" + attributeGroupName + "')]"))
				.isDisplayed());
		Thread.sleep(5000);
		utility.switchBackToFirstWindow();
		return this;
	}

	public ManageTaxonomyPageObjects removeCreatedCategory(String categoryName, String noOfCategories,
			String errorChildCatMessage, String expSuccessMsgForRemoveCategory) {
		int var = Integer.parseInt(noOfCategories);

		for (int i = 1; i <= var; i++) {
			clickOnCategory(categoryName + i);
			clickOnRemoveCategory(categoryName + i);
			verifySuccessMessageForRemoveCategory(errorChildCatMessage, expSuccessMsgForRemoveCategory);
		}
		return this;

	}

	@Step("verify success message for remove category{0}")
	public ManageTaxonomyPageObjects verifySuccessMessageForRemoveCategory(String errorChildCatMessage,
			String expSuccessMsgForRemoveCategory) {
		waiting.explicitWaitVisibilityOfElement(categoryRemoveSuccesMessage, 15);
		if (categoryRemoveSuccesMessage.getText().contains(errorChildCatMessage)) {
			removeChildCategories(expSuccessMsgForRemoveCategory);
		}

		Assert.assertEquals(categoryRemoveSuccesMessage.getText(), expSuccessMsgForRemoveCategory);

		return this;

	}

	public ManageTaxonomyPageObjects removeChildCategories(String successMessageForRemove) {
		waiting.explicitWaitElementToBeClickable(deletincategory, 20);
		deleteCategory.click();
		tu.alertAccept();
		waiting.explicitWaitVisibilityOfElement(successmesssage, 30);
		Assert.assertEquals(successmesssage.getText(), successMessageForRemove);

		return this;

	}

	public ManageTaxonomyPageObjects clickOnRemoveCategory(String categoryName) {
		waiting.explicitWaitElementToBeClickable(By.xpath("//input[@value='" + categoryName
				+ "']/ancestor::tr/descendant::td/descendant::input[@id='editcategory:removeStoredItem']"), 15);
		getDriver()
				.findElement(By.xpath("//input[@value='" + categoryName
						+ "']/ancestor::tr/descendant::td/descendant::input[@id='editcategory:removeStoredItem']"))
				.click();
		tu.alertAccept();
		return this;
	}

	@Step("remove child category {0}, {1}")
	public ManageTaxonomyPageObjects removeAndVerifyChildCategory(String childCategoryName,
			String successMessageForRemove, String noOfChildCategoriesTobeDelete) throws InterruptedException {
		Thread.sleep(4000);
		verifyChildCategoryBeforeRemove(childCategoryName);
		int noOfChildCat = Integer.parseInt(noOfChildCategoriesTobeDelete);
		for (int i = 1; i < noOfChildCat; i++) {

			waiting.explicitWaitVisibilityOfElement(
					By.xpath("//div[@id='searchFormId:taxonomyTreeId:childs']/descendant::span[contains(text(),'"
							+ childCategoryName + i + "')]"),
					20);
			getDriver().findElement(
					By.xpath("//div[@id='searchFormId:taxonomyTreeId:childs']/descendant::span[contains(text(),'"
							+ childCategoryName + "')]"))
					.click();
			Thread.sleep(2500);
			getDriver().findElement(
					By.xpath("//div[@id='searchFormId:taxonomyTreeId:childs']/descendant::span[contains(text(),'"
							+ childCategoryName + "')]"))
					.click();
			removeChildCategories(successMessageForRemove);
		}

		return this;
	}

	public ManageTaxonomyPageObjects clickOnRespectiveCategoryPlusIcon(String categoryName) {
		waiting.explicitWaitElementToBeClickable(
				By.xpath("//tr[contains(@title,'" + categoryName + "')]/descendant::img[contains(@src,'plus.png')]"),
				20);
		getDriver()
				.findElement(By.xpath(
						"//tr[contains(@title,'" + categoryName + "')]/descendant::img[contains(@src,'plus.png')]"))
				.click();
		return this;
	}

	public ManageTaxonomyPageObjects verifyCategoryBeforeRemove(String categoryName) {
		Assert.assertFalse(assertVerifyCategory(categoryName), "Category is not present, please create before remove");
		return this;
	}

	public ManageTaxonomyPageObjects verifyChildCategoryBeforeRemove(String childCategoryName) {
		Assert.assertTrue(assertVerifyChildCategory(childCategoryName),
				"child category is not present, please create before remove");
		return this;
	}

	public ManageTaxonomyPageObjects verifyCategoryPresent(String categoryName) {
		Assert.assertTrue(assertVerifyCategory(categoryName),
				"Category is already present, lease delete category to create again");
		return this;
	}

	private boolean assertVerifyChildCategory(String categoryName) {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			if (getDriver()
					.findElement(By.xpath(
							"//tr[contains(@title,'" + categoryName + "')]/descendant::img[contains(@src,'plus.png')]"))
					.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;

		}

		return false;
	}

	private boolean assertVerifyCategory(String categoryName) {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			if (getDriver().findElement(By
					.xpath("//div[@class='treeCategoryName']/descendant::span[contains(@id,'treeNodeDataId') and text()='"
							+ categoryName + "']"))
					.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;

		}

		return false;
	}
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}