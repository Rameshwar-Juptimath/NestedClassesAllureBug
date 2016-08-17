package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.Iterator;
import java.util.List;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManageTaxonomyPageObjects extends PageFactoryInitializer {
	SearchDataPropertyFile data = new SearchDataPropertyFile();

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
	
	@FindBy(xpath="//a[@id='searchFormId:goBtn1']/i")
	private  WebElement categorysearchiconlocator;
	
	@FindBy(xpath="//input[@id='searchFormId:j_id764']")
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
	//*[@id='editcategory:cCode']
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
	
	@FindBy(xpath="//input[@id='editcategory:cName']")
	private  WebElement categoryName;
	
	@FindBy(xpath="//input[@id='editcategory:dSeq']")
	private  WebElement DisplaySequence;
	
	@FindBy(xpath=".//*[@id='editcategory:categoryDesc']")
	private  WebElement CategoryDescription;
	
	
	public ManageTaxonomyPageObjects verifyTabsPresentInManageTaxonomyPage() throws InterruptedException {
		Assert.assertTrue(categoryandattributesLocator.isDisplayed());
		Assert.assertTrue(attributesLocator.isDisplayed());
		Assert.assertTrue(attributesgroupsLocator.isDisplayed());
		return this;
		 
	 
		
	}
	@Step("verify whether {0} in the left navigation bar is highlighted with green colour.")
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen( ) throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='searchFormId:taxonomyTreeId:120379::treeNodeDataId']")).getAttribute("style").trim().contains("green"));
		return this;
	}
	public ManageTaxonomyPageObjects clickOnLeftArrow() {
		Waiting.explicitWaitElementToBeClickable(leftarrowLocator, 5);
		leftarrowLocator.click();
		return this;
		 
		
	}
	
	public ManageTaxonomyPageObjects doubleClickOnCategory(int specificCategory) throws InterruptedException {
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
	
	public ManageTaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsInNotGreen( ) throws Exception {
		 
		Thread.sleep(3000);
		Assert.assertFalse((driver.findElement(By.xpath("//span[@id='searchFormId:taxonomyTreeId:120379::treeNodeDataId']")).getAttribute("style").trim().contains("green")));
		return this;
	}
	 
	public ManageTaxonomyPageObjects verifyUserIsAblToViewTheHierarchyLevelsOfTheCategories() throws InterruptedException {
		Thread.sleep(3000);
		Iterator<WebElement> expand=driver.findElements(By.xpath("//a[@class='rich-tree-node-handle']/img[1]")).iterator();
	    expand.next();
	    while(expand.hasNext())
	    {
	        expand.next().click();
	        Thread.sleep(2500);
			Assert.assertTrue((driver.findElement(By.xpath("//div[@class='taxonomyCount']/span")).getAttribute("style").trim().contains("red")));
	        
	    }
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
	public ManageTaxonomyPageObjects verifySuccessMessageAfterSavinCategory() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(successmesssage.isDisplayed());
		if(successmesssage.getText().trim().equals(data.getCategorySavedSuccessfulMessage())) {
			Assert.assertEquals(successmesssage.getText().trim(), "New Category Saved Successfully"); 
		} else {
			successmesssage.getText().trim().equals("Category Code already exists");
			Assert.assertEquals(successmesssage.getText().trim(), "Category Code already exists");
		}
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
	public ManageTaxonomyPageObjects verifyErrorMessage() {
		Assert.assertEquals(errorMessagelocator.getText().trim(), "Category Code must be Numeric"); 
		return this;
	}
	public ManageTaxonomyPageObjects enteringgMoreThan100characters(String moreThan100Characters) throws InterruptedException {
	/*	Waiting.explicitWaitElementToBeSelected(categoryNameTextfield, 10); 
		categoryNameTextfield.clear();*/
		Thread.sleep(5000);
		categoryNameTextfield.sendKeys(Keys.ENTER);
		categoryNameTextfield.sendKeys(moreThan100Characters);
		return this;
		 
		
	}
	public ManageTaxonomyPageObjects validatingCategoryNameFieldByLeavingEmpty(String ErrorMessageAfterClickingSaveButton){
		Waiting.explicitWaitElementToBeClickable(errorMessagelocatorForcategoryName, 5);
		Assert.assertEquals(errorMessagelocatorForcategoryName.getText().trim(), ErrorMessageAfterClickingSaveButton);
		return this;
		 
		
	}
	public void verifyErrorMessageAfterEnteringMoreThan100Characters() throws InterruptedException {
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
		//		Waiting.explicitWaitElementToBeClickable(displaySequencefieldloctor, 5);
		displaySequencefieldloctor.clear();
		displaySequencefieldloctor.sendKeys(getnumaricCharacter);
		return this;
	}
	public ManageTaxonomyPageObjects verifytheMessage() {
		
		return this;
	 
		
	}
	 
	public ManageTaxonomyPageObjects verifytheMessageByleavingDisplaySequenceFieldEmpty() throws InterruptedException {
		Thread.sleep(3500);
		
		Assert.assertEquals(errorMessagefordisplaysequence.getText().trim(), "Display Sequence required");
		return this;
		 
		
	}
	public ManageTaxonomyPageObjects clearTheDisplaySequenceField() {
		Waiting.explicitWaitElementToBeClickable(displaySequencefieldloctor, 5);
		displaySequencefieldloctor.clear();
		return this;
	}
	public ManageTaxonomyPageObjects enterMorethanFIveHundredCharactersInCategoryDescriptionField(String getenteringMoretha500characters) {
		Waiting.explicitWaitElementToBeClickable(CategoryDescription, 5);
		CategoryDescription.sendKeys(getenteringMoretha500characters);	
		
		return this;
	}
	public ManageTaxonomyPageObjects deleteCategory() {
		Waiting.explicitWaitElementToBeClickable(deletincategory, 5);
		deletincategory.click();
		String text = driver.switchTo().alert().getText();
		Assert.assertEquals(text, "Are sure you want remove this Category ?");
		System.out.println("Popup " +text);
		return this;
	 
		
	}
	
	public ManageTaxonomyPageObjects verifyCategoryFields(String [] categoryFIelds) throws InterruptedException {
		Thread.sleep(2000);
		for(int i = 0 ; i < categoryFields.size() ; i++)
		{
			 
			Assert.assertTrue(categoryFields.get(i).isDisplayed()," not displayed");
			Assert.assertEquals(categoryFields.get(i).getText().trim(), categoryFIelds[i]);
 
		}
		return this;	
	}
	 
}
