package org.cimm2touch.pageobjects.taxonomymanagement;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TaxonomyDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManageTaxonomyPageObjects extends PageFactoryInitializer
{
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	TaxonomyDataPropertyFile taxData = new TaxonomyDataPropertyFile();
	TestUtility tu = new TestUtility();

	@FindAll(value={@FindBy(xpath="//tr[@class='rich-table-subheader']/th/div")})
	private List<WebElement> taxonomyTableHeadersLocator;

	@FindBy(xpath="//td[@id='categoryAndAttributes_lbl']")
	private  WebElement categoryandattributesLocator;

	@FindBy(xpath="//td[@id='attributeGroups_lbl']")
	private  WebElement attributesgroupsLocator;

	@FindBy(xpath="//td[@id='attributes_lbl']")
	private  WebElement attributesLocator;

	@FindBy(xpath=".//*[@id='searchFormId']/div/div/div[2]/div")
	private  WebElement leftarrowLocator;

	@FindBy(xpath="//input[@id='searchFormId:searchITId']")
	private  WebElement searchfieldLocator;

	@FindBy(xpath="//div[@class='cimmSearchTxt']/input[@id='searchFormId:searchITId']")
	private  WebElement CategorysearchfieldLocator;

	@FindBy(xpath="//a[@title='Search']")
	private  WebElement searchiconlocator;

	@FindBy(xpath="//a[@title='Search ']/i")
	private  WebElement categorysearchiconlocator;

	@FindBy(xpath="//input[@title='Refresh Search']")
	private  WebElement refreshlocator;

	@FindBy(xpath="//a[@class='rich-tree-node-handle']/img[1]")
	private  WebElement plusicon;

	@FindAll(value={@FindBy(xpath="//a[@class='rich-tree-node-handle']/img[1]")})
	private List<WebElement> plusiconlocator;

	@FindAll(value={@FindBy(xpath="//span[contains(@id,'treeNodeDataId')]")})
	private  List<WebElement> categoryLocator;

	@FindBy(xpath="//div[@class='sliderLeftArrow sliderRightArrow']")
	private  WebElement leftArrow;

	@FindBy(id="'categoryid:save'")
	private  WebElement savebutton;

	@FindBy(xpath="//span[@id='categoryid:ctgMsgId']")
	private  WebElement successmesssage;

	@FindBy(id="categoryid:addnewCategory")
	private  WebElement saveButtonForCategorySave;

	@FindBy(xpath="//input[@name='editcategory:cCode']")
	private  WebElement editcategoryCodelocator;

	@FindBy(xpath="//span[contains(text(),'Category Code must be Numeric')]")
	private  WebElement errorMessagelocator;

	@FindBy(xpath="//span[contains(text(),'Category Name required')]")
	private  WebElement errorMessagelocatorForcategoryName;

	@FindBy(id="//input[@id='editcategory:cName']")
	private  WebElement categoryNameTextfield;

	@FindBy(id="'categoryid:ctgMsgId'")
	private  WebElement ErrorMessageafterenteringmorthan100characters;

	@FindBy(xpath="//input[@id='editcategory:dSeq']")
	private  WebElement displaySequencefieldloctor;

	@FindBy(xpath="//span[contains(text(),'Display Sequence required')]")
	private  WebElement errorMessagefordisplaysequence;

	@FindBy(xpath="//input[@id='editcategory:removeStoredItem']")
	private  WebElement deletincategory;

	@FindBy(xpath="//a[@title='Category']")
	private  WebElement plusiconForCreatingNewCategory;

	@FindAll(value={@FindBy(xpath="//span[@class='cimmEditCategoryLabel']")})
	private List<WebElement> categoryFields;

	@FindBy(xpath="//input[@id='editcategory:dSeq']")
	private  WebElement DisplaySequence;

	@FindBy(xpath=".//*[@id='editcategory:categoryDesc']")
	private  WebElement CategoryDescription;

	@FindBy(xpath="//a[@title='Category']")
	private WebElement addNewCategoryButton;

	@FindBy(xpath="//a[@title='Child Category']")
	private WebElement addNewChildCategoryButton;

	@FindBy(xpath="//ul[@class='buttonList']/li/input[@title='Save New Category']")
	private WebElement saveNewCategoryButton;

	@FindBy(xpath="//input[contains(@name,'editcategory:cCode')]")
	private WebElement categoryCode;

	@FindBy(id="editcategory:cName")
	private WebElement categoryName;

	@FindBy(id="editcategory:dSeq")
	private WebElement displaySequence;

	@FindBy(id="editcategory:lNum")
	private WebElement levelNumber;

	@FindBy(xpath="//li/input[contains(@id,'addnewCategory') and @title='Save New Category']")
	private WebElement saveCategory;

	@FindBy(xpath="//select[@id='editcategory:locidUp1']")
	private WebElement localeSelect;

	@FindBy(xpath="//textarea[@id='editcategory:categoryDesc']")
	private WebElement categoryDescriptionTextArea;

	@FindBy(xpath="//textarea[@id='editcategory:marketingDesc']")
	private WebElement marketingDescriptionTextArea;

	@FindBy(xpath="//select[@id='editcategory:vlbanner']")
	private WebElement editTopBanner;

	@FindBy(xpath="//select[@id='editcategory:vlbanner2']")
	private WebElement editRightBanner;

	@FindBy(xpath="//select[@id='editcategory:vlbanner3']")
	private WebElement editLeftBanner;

	@FindBy(xpath="//select[@id='editcategory:vlbanner4']")
	private WebElement editBottomBanner;

	@FindBy(xpath="//input[@title='Delete Category']")
	private WebElement deleteCategory;
	
	@FindBy(xpath="//input[@title='History']")
	private WebElement viewHistoryButton;


	public ManageTaxonomyPageObjects verifyTabsPresentInManageTaxonomyPage() throws InterruptedException 
	{
		Assert.assertTrue(categoryandattributesLocator.isDisplayed());
		Assert.assertTrue(attributesLocator.isDisplayed());
		Assert.assertTrue(attributesgroupsLocator.isDisplayed());
		return this;
	}

	public ManageTaxonomyPageObjects clickOnLeftArrow() 
	{
		Waiting.explicitWaitElementToBeClickable(leftarrowLocator, 5);
		leftarrowLocator.click();
		return this;
	}

	public ManageTaxonomyPageObjects doubleClickOnCategory(int specificCategory) throws InterruptedException 
	{
		Thread.sleep(2000);
		TestUtility.doubleClick(categoryLocator.get(specificCategory-1));
		return this;


	}
	public ManageTaxonomyPageObjects enterTheCategoryName(String categoryname) throws InterruptedException {

		Thread.sleep(3000);
		CategorysearchfieldLocator.sendKeys(Keys.ENTER);
		CategorysearchfieldLocator.sendKeys(categoryname);
		return this;
	}
	public ManageTaxonomyPageObjects clickOnSearchIcon() {
		Waiting.explicitWaitElementToBeClickable(searchiconlocator, 5);
		categorysearchiconlocator.click();
		return this;


	}
	public ManageTaxonomyPageObjects clickOnRefreshIcon() {
		Waiting.explicitWaitElementToBeClickable(refreshlocator, 3);
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
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen(String categoryName1) throws Exception 
	{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+categoryName1+"')]")).getAttribute("style").trim().contains("green"));
		return this;
	}

	@Step("verify whether {0} in the left navigation bar is not  highlighted with green colour.")
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsInNotGreen(String categoryName1) throws Exception {

		Thread.sleep(3000);
		Assert.assertFalse((driver.findElement(By.xpath("//span[contains(text(),'"+categoryName1+"')]")).getAttribute("style").trim().contains("green")));
		return this;
	}

	@Step("verify the Expand/Collapse Feature in Manage Taxonomy Feature.")
	public ManageTaxonomyPageObjects verifyUserIsAblToViewTheHierarchyLevelsOfTheCategories(String categoryName) throws Exception 
	{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+categoryName+"')]//ancestor::tr[contains(@title,'"
				+categoryName+"')]/td/div/a/img[contains(@id,'collapsed')]")).isEnabled());

		driver.findElement(By.xpath("//span[contains(text(),'"+categoryName+"')]//ancestor::tr[contains(@title,'"
				+categoryName+"')]/td/div/a/img[contains(@id,'collapsed')]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+categoryName+"')]//ancestor::tr[contains(@title,'"
				+categoryName+"')]/td/div/a/img[contains(@id,'collapsed')]")).isDisplayed());

		return this;

	}


	public ManageTaxonomyPageObjects clickOnPlusIcon() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",plusiconForCreatingNewCategory);
		return this;
	}
	public ManageTaxonomyPageObjects enterTheCategoryDescription(String getcategoryDescription) throws InterruptedException {
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
		/*	Waiting.explicitWaitElementToBeClickable(savebutton, 5);
		savebutton.click();*/
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", savebutton); 
		return this;


	}

	@Step("To Verify the Error Message on Creating the Category with Invalid Details")
	public ManageTaxonomyPageObjects verifyDifferentMessageDisplayedAfterSavinCategory(String errorMessage) throws Exception 
	{
		Thread.sleep(7000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/span[@style='color:red;' and contains(text(),'"+errorMessage+"')]")).isDisplayed());
		return this;	 
	}


	public ManageTaxonomyPageObjects clickOnSaveButtonForCategorySave() throws InterruptedException {
		Thread.sleep(2500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",saveButtonForCategorySave);

		return this;
	}
	public ManageTaxonomyPageObjects validatingCategoryCodeFieldByEnteringAlphanumericcharacters(String alphanumericcharacters) throws InterruptedException {
		Thread.sleep(3000);
		editcategoryCodelocator.clear();
		editcategoryCodelocator.sendKeys(alphanumericcharacters);
		return this;
	}
	public ManageTaxonomyPageObjects verifyErrorMessage() 
	{
		Assert.assertEquals(errorMessagelocator.getText().trim(), "Category Code must be Numeric"); 
		return this;
	}

	public ManageTaxonomyPageObjects enteringgMoreThan100characters(String moreThan100Characters) throws InterruptedException 
	{
		Thread.sleep(5000);
		categoryNameTextfield.sendKeys(Keys.ENTER);
		categoryNameTextfield.sendKeys(moreThan100Characters);
		return this;


	}
	public ManageTaxonomyPageObjects validatingCategoryNameFieldByLeavingEmpty(String ErrorMessageAfterClickingSaveButton)
	{
		Waiting.explicitWaitElementToBeClickable(errorMessagelocatorForcategoryName, 5);
		Assert.assertEquals(errorMessagelocatorForcategoryName.getText().trim(), ErrorMessageAfterClickingSaveButton);
		return this;


	}
	public void verifyErrorMessageAfterEnteringMoreThan100Characters() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertTrue(ErrorMessageafterenteringmorthan100characters.isDisplayed());

	}
	public ManageTaxonomyPageObjects enteringCategoryCode(String categoryCode) {
		Waiting.explicitWaitElementToBeClickable(editcategoryCodelocator, 5);
		editcategoryCodelocator.clear();
		editcategoryCodelocator.sendKeys(categoryCode);
		return this;
	}
	public ManageTaxonomyPageObjects enterNumericCharactersInDisplaySequenceField(String getnumaricCharacter) throws InterruptedException {
		Thread.sleep(2500);
		displaySequencefieldloctor.clear();
		displaySequencefieldloctor.sendKeys(getnumaricCharacter);
		return this;
	}


	public ManageTaxonomyPageObjects verifytheMessageByleavingDisplaySequenceFieldEmpty() throws InterruptedException 
	{
		Thread.sleep(3500);
		Assert.assertEquals(errorMessagefordisplaysequence.getText().trim(), "Display Sequence required");
		return this;
	}

	public ManageTaxonomyPageObjects clearTheDisplaySequenceField() 
	{
		Waiting.explicitWaitElementToBeClickable(displaySequencefieldloctor, 5);
		displaySequencefieldloctor.clear();
		return this;
	}

	public ManageTaxonomyPageObjects deleteCategory() 
	{
		Waiting.explicitWaitElementToBeClickable(deletincategory, 5);
		deletincategory.click();
		String text = driver.switchTo().alert().getText();
		Assert.assertEquals(text, "Are sure you want remove this Category ?");
		System.out.println("Popup " +text);
		return this;


	}

	@Step("To Verify the Fields Present Upon Clicking the 'Add New Category' Button")
	public ManageTaxonomyPageObjects verifyCategoryFields() throws InterruptedException 
	{
		Thread.sleep(2000);
		Assert.assertTrue(categoryName.isDisplayed());
		Assert.assertTrue(categoryCode.isDisplayed());
		Assert.assertTrue(displaySequence.isDisplayed());
		Assert.assertTrue(levelNumber.isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//td/span[contains(text(),'Category Static')]//following::select[@class='cimmEditCategoryText'][1]")).isDisplayed());
		Assert.assertTrue(editTopBanner.isDisplayed());
		Assert.assertTrue(editRightBanner.isDisplayed());
		Assert.assertTrue(editLeftBanner.isDisplayed());
		Assert.assertTrue(editBottomBanner.isDisplayed());
		return this;	
	}
	
	@Step("To Verify the Fields Present Upon Clicking the 'Add New Child Category' Button")
	public ManageTaxonomyPageObjects verifyChildCategoryFields() throws InterruptedException 
	{
		Thread.sleep(2000);
		Assert.assertTrue(categoryName.isDisplayed());
		Assert.assertTrue(categoryCode.isDisplayed());
		Assert.assertTrue(displaySequence.isDisplayed());
		Assert.assertTrue(levelNumber.isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//td/span[contains(text(),'Category Static')]//following::select[@class='cimmEditCategoryText'][1]")).isDisplayed());
		Assert.assertTrue(editTopBanner.isDisplayed());
		Assert.assertTrue(editRightBanner.isDisplayed());
		Assert.assertTrue(editLeftBanner.isDisplayed());
		Assert.assertTrue(editBottomBanner.isDisplayed());
		return this;	
	}

	public ManageTaxonomyPageObjects verifyLeftPanelTaxonomyName(String taxonomyname) 
	{
		WebElement ele = driver.findElement(By.xpath("//div[@class='editTaxonomyWrap']/ul/li/div/div/div/div/input[contains(@value,'"+taxonomyname+"')]"));
		Assert.assertTrue(ele.isDisplayed(), "Taxonomy "+taxonomyname+" is not Present in the Left Side Panel");
		return this;
	}

	public ManageTaxonomyPageObjects clickOnAddNewCategory() throws InterruptedException 
	{
		Thread.sleep(5000);
		try
		{
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'CARS')]"));
			ele.click();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		Thread.sleep(5000);
		addNewCategoryButton.click();
		Thread.sleep(5000);
		return this;
	}


	public ManageTaxonomyPageObjects addNewCategory(String categoryCodeforParentCategory, String categoryNameforParentCategory,  
			String displaySequenceforParentCategory) throws Exception 
	{	
		Thread.sleep(5000);
		categoryCode.clear();
		categoryCode.sendKeys(categoryCodeforParentCategory);
		categoryName.clear();
		categoryName.sendKeys(categoryNameforParentCategory);
		displaySequence.clear();
		displaySequence.sendKeys(displaySequenceforParentCategory);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnAddNewChildCategory() throws Exception 
	{
		Thread.sleep(5000);
		addNewChildCategoryButton.click();
		Thread.sleep(5000);
		return this;
	}

	public ManageTaxonomyPageObjects clickOnCategory(String categoryName2) 
	{
		return this;
	}

	public ManageTaxonomyPageObjects addNewChildCategory(String categoryCodeofChild1, 
			String childCategoryName1, String displaySequence1) throws Exception 
	{
		categoryCode.clear();
		categoryCode.sendKeys(categoryCodeofChild1);
		categoryName.clear();
		categoryName.sendKeys(childCategoryName1);
		displaySequence.clear();
		displaySequence.sendKeys(displaySequence1);	
		Thread.sleep(5000);
		return this;
	}

	@Step("To Save Category")
	public ManageTaxonomyPageObjects saveNewCategory() 
	{
		saveCategory.click();
		return this;		
	}

	@Step("To Click on {0} Category")
	public ManageTaxonomyPageObjects clickOnRespectiveCategory(String categoryName) throws Exception 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'"+categoryName+"')]")).click();
		return this;
	}


	@Step("To Verify 500 Characters Limit in Category Description Field")
	public ManageTaxonomyPageObjects verifyCharacterLimitInCategoryDescField() throws Exception 
	{
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(5000);
		categoryDescriptionTextArea.clear();
		for (int i=0; i< 525; i++)
		{
			categoryDescriptionTextArea.sendKeys("i");
		}
		Thread.sleep(2000);
		String enteredText = categoryDescriptionTextArea.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Verify 500 Characters Limit in Marketing Description Field")
	public ManageTaxonomyPageObjects verifyCharacterLimitInMarketingDescField() throws Exception 
	{
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(5000);
		marketingDescriptionTextArea.clear();
		for (int i=0; i< 525; i++)
		{
			marketingDescriptionTextArea.sendKeys("i");
		}
		Thread.sleep(2000);
		String enteredText = marketingDescriptionTextArea.getAttribute("value");
		int enteredTextLength = enteredText.length();
		softassert.assertEquals(enteredTextLength, 500);
		softassert.assertAll();
		return this;
	}

	@Step("To Verify the Message Displayed after succesfully saving a Category")
	public ManageTaxonomyPageObjects verifySuccessMessageAfterSavingCategory() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='categoryid:ctgMsgId' and contains(text(),'New Category Saved Successfully')]")).isDisplayed());
		return this;
	}

	@Step("To Verify the Message Displayed after succesfully saving a Category")
	public ManageTaxonomyPageObjects verifySuccessMessageAfterDeletingCategory() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='categoryid:ctgMsgId' and contains(text(),'Category Deleted Successfully')]")).isDisplayed());
		return this;
	}

	@SuppressWarnings("static-access")
	public ManageTaxonomyPageObjects clickOnDeleteCategoryButton() throws Exception 
	{
		Thread.sleep(5000);
		deleteCategory.click();
		Thread.sleep(2000);
		tu.alertAccept();
		return this;
	}

	@Step("To Click on '+' image for the {0} Category")
	public ManageTaxonomyPageObjects clickOnExpandViewForRespectiveCategory(String categoryName) throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'"+categoryName+"')]/../../../..//a/img[contains(@src,'plus')]")).click();
		return null;
	}

	@Step("To Verify the Fields Present Upon Clicking the 'Add New Category' Button")
	public ManageTaxonomyPageObjects editCategoryFields(String editCategoryName, String displaySequence2) throws Exception 
	{
		Thread.sleep(5000);
		categoryName.clear();
		categoryName.sendKeys(editCategoryName);
		displaySequence.clear();
		displaySequence.sendKeys(displaySequence2);
		return this;
	}

	@Step("To Save the Category upon Editing")
	public ManageTaxonomyPageObjects saveEditedCategory() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on the 'View History' Button")
	public ManageTaxonomyPageObjects clickOnViewHistoryButton()  throws Exception
	{
		Thread.sleep(5000);
		viewHistoryButton.click();
		tu.alertAccept();
		return this;
	}

	@SuppressWarnings("static-access")
	public ManageTaxonomyPageObjects switchToNewlyOpenedWindowAndVerifyCategoryName(String categoryName1) throws Exception 
	{
		Thread.sleep(5000);
		tu.switchToRecentWindow();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/span[contains(.,'"+categoryName1+"')]")).isDisplayed());
		return this;
	}
	
}
