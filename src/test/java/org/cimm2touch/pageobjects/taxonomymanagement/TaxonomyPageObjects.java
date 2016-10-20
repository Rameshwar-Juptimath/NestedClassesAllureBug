package org.cimm2touch.pageobjects.taxonomymanagement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

import java.util.Arrays;
import java.util.List;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class TaxonomyPageObjects extends PageFactoryInitializer {
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindAll(value={@FindBy(xpath="//tr[@class='rich-table-subheader']/th/div")})
	private List<WebElement> taxonomyTableHeadersLocator;

	@FindBy(xpath="//input[@id='searchId:searchKeywordId']")
	private  WebElement searchsuccesfullMessageLocator;

	@FindBy(xpath="//input[@id='searchId:searchKeywordId']")
	private  WebElement searchTextboxInTaxonomySectionLocator;

	@FindBy(xpath="//*[@id='searchId:goBtn']/i")
	private  WebElement searchIconInTaxonomySectionLocator;

	@FindBy(xpath="//*[@id='taxonomyAddEditForm']/div")
	private  WebElement taxonomyFieldLocator;

	@FindBy(xpath="//input[@id='taxonomyAddEditForm:saveTaxonomy']")
	private  WebElement savebuttonintaxonomypage;

	@FindBy(xpath="//div[@class='cimm_formInput']/textarea[@id='taxonomyAddEditForm:taxonomyDesc']")
	private  WebElement taxonomyDesctextarea;

	@FindBy(xpath="//div[contains(@class,'topNav_rightIcons')]//li/a[contains(@title,'New')]")
	private  WebElement addnewtaxonomyFieldLocator;

	@FindBy(xpath="//span[contains(text(),'Taxonomy Name Required')]")
	private  WebElement errormessage;

	@FindBy(xpath="//input[@id='taxonomyAddEditForm:taxonomyName']")
	private  WebElement taxonomynametextfield;

	@FindBy(xpath="//span[contains(text(),'Taxonomy Desc Required')]")
	private  WebElement taxerrormessage;

	@FindBy(xpath="//input[@id='taxonomyTableForm:taxonomyDataTable:0:editTaxonomy']")
	private  WebElement taxonomyEditlocator;

	@FindBy(xpath="//input[@id='taxonomyTableForm:taxonomyDataTable:0:manageTaxonomy']")
	private  WebElement gotomanagetaxonomyLocator;

	@FindAll(value={@FindBy(xpath="//form[@id='taxonomyAddEditForm']/descendant::div[@class='cimm_formLabel']")})
	private List<WebElement> taxonomyheaderslocator;

	@FindBy(xpath="//input[contains(@placeholder,'Enter Taxonomy Name to Search')]")
	private WebElement taxonomySearchField;

	@FindBy(xpath="//a[@id='searchId:goBtn']/i")
	private WebElement taxonomySearchButton;

	@FindBy(xpath="//input[contains(@title,'Goto Manage Taxonomy')]")
	private WebElement manageTaxonomyLink;

	@FindBy(xpath="//li/a[@title='Previous']/i")
	private WebElement paginationPreviousButton;
	
	@FindBy(xpath="//li/a[@title='Next']/i")
	private WebElement paginationNextButton;
	
	@FindBy(xpath="//li/a[@title='Last']/i")
	private WebElement paginationLastButton;
	
	@FindBy(xpath="//li/a[@title='First']/i")
	private WebElement paginationFirstButton;

	@FindBy(xpath="//div[contains(@class,'pull-right comboBoxGrey')]/select")
	private WebElement selectRecordsDropdownInTaxonomyLocator;

	@FindAll(value={@FindBy(xpath="//input[@title='Edit this Taxonomy']")})
	private List<WebElement> editThisTaxonomyLocator; 

	@Step("verifying the table headings are {0} (After clicking on taxonomy).")
	public TaxonomyPageObjects verifyTaxonomyTableHeadingsInTaxonomyManagementPage(String [] taxonomyTableHeadings) throws Exception {
		Thread.sleep(2500);
		for(int i=0;i<taxonomyTableHeadersLocator.size();i++)
		{
			Assert.assertEquals(taxonomyTableHeadersLocator.get(i).getText().trim(), taxonomyTableHeadings[i]);
		}
		return this;
	}

	@Step("enter {0} in the search textbox of the taxonomy tree.")
	public TaxonomyPageObjects enterSearchTaxonomy(String searchTaxonomy) 
	{
		Waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchTaxonomy);
		return this;
	}

	public TaxonomyPageObjects enterInvalidTaxonomy(String searchInvalidTaxonomy) 
	{
		Waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchInvalidTaxonomy);
		return this;
	}


	public TaxonomyPageObjects verifysearchfunctionalityforValidAndInvalidKey(String expectedErrorMessage) 
	{
		Waiting.explicitWaitVisibilityOfElement(searchsuccesfullMessageLocator, 8);
		Assert.assertEquals(searchsuccesfullMessageLocator.getText().trim(), "Manufacturer Name required");
		return this;
	}

	public TaxonomyPageObjects clickOnSearchTaxonomy() 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",searchIconInTaxonomySectionLocator);
		return this;
	}

	public TaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen(String searchTaxonomy) throws Exception 
	{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+searchTaxonomy+"']")).getAttribute("style").trim().contains("green"));
		return this;
	}

	public TaxonomyPageObjects verifyNameIsPresent(String taxonomyToSearch) 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+taxonomyToSearch+"']")).isDisplayed(),"Searched taxonomy is not present. Searched for "+taxonomyToSearch+".");
		return this;
	}

	public TaxonomyPageObjects verifyForinavalidInput(String inavalidTaxonomyName) throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='searchId:savmsg2']")).isDisplayed(),"Searched taxonomy is not present. Searched for "+inavalidTaxonomyName+".");
		return this;
	}

	public TaxonomyPageObjects clickOnAddnewTaxonomy() 
	{
		Waiting.explicitWaitVisibilityOfElement(addnewtaxonomyFieldLocator, 5);
		addnewtaxonomyFieldLocator.click();
		return this;

	}
	public TaxonomyPageObjects enterTaxonomyDesciption(String taxonomyDescription) throws InterruptedException 
	{
		Thread.sleep(3000);
		taxonomyDesctextarea.sendKeys(taxonomyDescription);
		return this;			
	}

	public TaxonomyPageObjects clearTaxonomyDesciptionField() 
	{
		Waiting.explicitWaitVisibilityOfElement(taxonomyDesctextarea, 10);
		taxonomyDesctextarea.clear();
		return this;
	}

	public TaxonomyPageObjects clickOnSaveInTaxonomypage() throws InterruptedException 
	{
		Thread.sleep(3000);
		savebuttonintaxonomypage.click();
		return this;
	}

	public TaxonomyPageObjects verifyErrormessage(String errormessge) throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertEquals(errormessage.getText().trim(), errormessge);
		return this;

	}

	public TaxonomyPageObjects verifyTaxonomyErrormessage(String errormessge) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(taxerrormessage.getText().trim(), errormessge);
		return this;
	}

	public TaxonomyPageObjects enterTaxonomyName(String taxonomyname) throws Exception
	{
		Thread.sleep(3000);
		taxonomynametextfield.sendKeys(taxonomyname);
		return this;
	}

	public TaxonomyPageObjects enteringMorethathirtycharactersinTaxonomyNameField(String getenteringMorethathirtycharacters) throws InterruptedException
	{
		Thread.sleep(3000);
		taxonomynametextfield.sendKeys(getenteringMorethathirtycharacters);
		return this;
	}

	public TaxonomyPageObjects verifyEnterdCharactersInTaxonomynamefield(String message) throws InterruptedException 
	{
		Thread.sleep(3000);
		String OriginalText = message;
		@SuppressWarnings("unused")
		int OriginalTextLength=message.length();
		String enteredText=taxonomynametextfield.getAttribute("value");
		System.out.println("Original Message -> "+message);
		System.out.println("Entered Message -> "+taxonomynametextfield.getAttribute("value"));
		int enteredTextLength=enteredText.length();
		Assert.assertNotEquals(OriginalText, enteredText);
		Assert.assertEquals(enteredTextLength, Integer.parseInt(taxonomynametextfield.getAttribute("maxlength")));
		return this; 
	}
	
	public TaxonomyPageObjects enteringMoretha500charactersinTaxonomyDescField() throws Exception 
	{
		Thread.sleep(5000);
		for (int i=0; i< 525; i++)
		{
			taxonomyDesctextarea.sendKeys("i");
		}
		return this;
	}

	public TaxonomyPageObjects verifyEnterdCharactersInTaxonomyDescfield() throws Exception 
	{
		Thread.sleep(3000);
		String enteredText = taxonomyDesctextarea.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, 500);
		return this;

	}

	public TaxonomyPageObjects verifyTaxonomyfieldsAfterclickingOnAddNewTaxonomyIcon(String[] taxonomyheaderslocators) throws Exception 
	{
		Thread.sleep(3000);
		List<WebElement> taxonomyTableContents = driver.findElements(By.xpath("//div[@class='rightHalfColumn']/div/form/div/div[@class='cimm_formLabel']"));
		System.out.println(Arrays.toString(taxonomyheaderslocators));
		for(WebElement we:taxonomyTableContents) //(int i=0; i< taxonomyheaderslocators.length; i++)
		{
			for(int i=0; i< taxonomyheaderslocators.length; i++)
			{
				we.getText();
				assertThat(we.getText().trim(),containsInAnyOrder(taxonomyheaderslocators[i]) != null);
			}
		}
		return this;

	}
	public TaxonomyPageObjects clickOnEditIconInTaxonomypage() 
	{
		taxonomyEditlocator.click();
		return this;
	}

	public TaxonomyPageObjects verifyFormfilledWithExistingDetailsOfEditingeaxonomy(String taxonomyName, String taxonomyDesc, String supplier, 
			String topBanner, String rightBanner, String leftBanner, String bottomBanner) throws Exception 
	{
		Thread.sleep(3500);
		//String taxonomydescription = taxonomyDesctextarea.getText();
		Assert.assertEquals(taxonomynametextfield.getAttribute("value"), taxonomyName);
		Assert.assertEquals(taxonomyDesctextarea.getAttribute("value"), taxonomyDesc);
		Assert.assertEquals(new Select(driver.findElement(By.id("taxonomyAddEditForm:supplierId"))).getFirstSelectedOption().getText(),supplier);
		Assert.assertEquals(new Select(driver.findElement(By.id("taxonomyAddEditForm:vlbanner"))).getFirstSelectedOption().getText(),topBanner);
		Assert.assertEquals(new Select(driver.findElement(By.id("taxonomyAddEditForm:vlbanner2"))).getFirstSelectedOption().getText(),rightBanner);
		Assert.assertEquals(new Select(driver.findElement(By.id("taxonomyAddEditForm:vlbanner3"))).getFirstSelectedOption().getText(),leftBanner);
		Assert.assertEquals(new Select(driver.findElement(By.id("taxonomyAddEditForm:vlbanner4"))).getFirstSelectedOption().getText(),bottomBanner);
		return this;

	}
	public TaxonomyPageObjects clickOnGoToManageTaxonomyIcon() {
		Waiting.explicitWaitElementToBeClickable(gotomanagetaxonomyLocator, 5);
		gotomanagetaxonomyLocator.click();
		return this;
	}

	@Step("search for taxonomy{0}.")
	public TaxonomyPageObjects searchForTaxonomy(String taxonomyName){
		Waiting.explicitWaitVisibilityOfElement(taxonomySearchField, 10);
		taxonomySearchField.clear();
		taxonomySearchField.sendKeys(taxonomyName);
		Waiting.explicitWaitVisibilityOfElement(searchIconInTaxonomySectionLocator, 10);
		taxonomySearchButton.click();
		return this;
	}
	
	

	@Step("click on manage taxonomy link.")
	public TaxonomyPageObjects clickOnManageTaxonomy() throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(manageTaxonomyLink, 10);
		manageTaxonomyLink.click();
		Thread.sleep(5000);
		return this;
	}
	/*
	@Step("verify pagination in taxonomy page")
	public boolean verifyPagination() throws InterruptedException {
		int totalCount = Integer.parseInt(totalCountTextLocator.getText());
		boolean pagination=false;
		if(totalCount>1){
			int currentPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			Assert.assertEquals(currentPageCount, 1);
			paginationNextLinkLocator.click();
			Thread.sleep(3000);

			int nextPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			System.out.println(nextPageCount);
			Thread.sleep(3000);

			paginationPreviousLinkLocator.click();
			Thread.sleep(3000);
			Assert.assertEquals(currentPageCount, 1);
			Thread.sleep(3000);

			paginationLastPageLocator.click();
			Thread.sleep(3000);
			int lastPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			Assert.assertEquals(lastPageCount, totalCount);
			Thread.sleep(3000);

			paginationFirstPageLocator.click();
			Thread.sleep(3000);
			Assert.assertEquals(currentPageCount, 1);


		}
		return pagination;
	}*/

	@Step("selecting {0} number of records to display.")
	public TaxonomyPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay) throws Exception{
		Waiting.explicitWaitVisibilityOfElement(selectRecordsDropdownInTaxonomyLocator, 15);
		Select select = new Select(selectRecordsDropdownInTaxonomyLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(3000);
		return this;

	}

	@Step("verifying whether {0} is the number of records that is displayed.")
	public TaxonomyPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception{
		try
		{
			Thread.sleep(2800);
			Assert.assertTrue(assertForNumberOfRowsDisplayed(editThisTaxonomyLocator.size(),Integer.parseInt(getNumberOfRecordsToDisplay)));
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
		}
		return this;
	}

	private boolean assertForNumberOfRowsDisplayed(int editButtons, int numberOfRecordsToDisplay) {
		if(editButtons<=numberOfRecordsToDisplay)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Step("To Select the Supplier Name")
	public TaxonomyPageObjects selectSupplier(String supplierName) throws InterruptedException 
	{
		WebElement ele = driver.findElement(By.xpath("//select[@id='taxonomyAddEditForm:supplierId']//option[contains(.,'"+supplierName+"')]"));
		ele.click();
		return this;
	}

	@Step("To Select the Top Banner")
	public TaxonomyPageObjects selectTopBanner(String topBannerName) 
	{
		WebElement ele = driver.findElement(By.xpath("//select[@id='taxonomyAddEditForm:vlbanner']//option[contains(.,'"+topBannerName+"')]"));
		ele.click();
		return this;
	}

	@Step("To Select the Right Banner")
	public TaxonomyPageObjects selectRightBanner(String rightBannerName) 
	{
		WebElement ele = driver.findElement(By.xpath("//select[@id='taxonomyAddEditForm:vlbanner2']//option[contains(.,'"+rightBannerName+"')]"));
		ele.click();
		return this;
	}

	@Step("To Select the Left Banner")
	public TaxonomyPageObjects selectLeftBanner(String leftBannerName) 
	{
		WebElement ele = driver.findElement(By.xpath("//select[@id='taxonomyAddEditForm:vlbanner3']//option[contains(.,'"+leftBannerName+"')]"));
		ele.click();
		return this;
	}

	@Step("To Select the Bottom Banner")
	public TaxonomyPageObjects selectBottomBanner(String bottomBannerName) 
	{
		WebElement ele = driver.findElement(By.xpath("//select[@id='taxonomyAddEditForm:vlbanner4']//option[contains(.,'"+bottomBannerName+"')]"));
		ele.click();
		return this;
	}
	
	public TaxonomyPageObjects saveAs(String saveAsType) throws Exception
	{
		WebElement ele = driver.findElement(By.xpath("//td/label[contains(.,'"+saveAsType+"')]//preceding-sibling::input"));
		ele.click();
		return this;
	}
	
	public TaxonomyPageObjects saveTaxanomy() 
	{
		savebuttonintaxonomypage.click();
		return this;
	}

	@Step("To Verify If Taxonomy is  Present")
	public TaxonomyPageObjects verifyTaxonomyPresent(String taxonomyName) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//table[@id='taxonomyTableForm:taxonomyDataTable']//span[contains(@id,'taxonomyName') and contains(.,'"+taxonomyName+"')]"));
		Assert.assertTrue(ele.isDisplayed(), "Taxonomy "+taxonomyName+" is not Present");
		return this;
	}

	@Step("To Verify If Taxonomy is Not Present")
	public TaxonomyPageObjects verifyTaxonomyisNotPresent(String invalidTaxonomyName) throws Exception 
	{
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.id("searchId:savmsg2"));
		Assert.assertTrue(ele.isDisplayed(), "Taxonomy "+invalidTaxonomyName+" is Present");
		return this;
	}

	@Step("To Verify the Error Mesage On Saving Taxonomy without Taxonomy Name")
	public TaxonomyPageObjects verifyTaxonomyNameErrorMessageInTaxonomyPage(String message) throws Exception 
	{
		Thread.sleep(5000);
		assertThat(driver.findElement(By.xpath("//span[@id='taxonomyAddEditForm:txnme']")).getText().trim(),containsString(message));
		return this;
	}

	@Step("To Verify the Error Mesage On Saving Taxonomy without Taxonomy Desc")
	public TaxonomyPageObjects verifyTaxonomyDescErrorMessageInTaxonomyPage(String message) throws Exception
	{
		Thread.sleep(3000);
		assertThat(driver.findElement(By.xpath("//span[@id='taxonomyAddEditForm:txndesc']")).getText().trim(),containsString(message));
		return this;
	}

	@Step("To Clear the Taxonomy Name Field in the Edit Taxonomy Page")
	public TaxonomyPageObjects clearTaxonomyNameField() throws Exception
	{
		Thread.sleep(3000);
		taxonomynametextfield.clear();
		return this;
	}

	@Step("To Clear the Taxonomy Desc Field in the Edit Taxonomy Page")
	public TaxonomyPageObjects clearTaxonomyDescField() throws Exception 
	{
		Thread.sleep(3000);
		taxonomyDesctextarea.clear();
		return this;
	}

	@Step("To Click On 'Previous' Button in Taxonomy Pagination")
	public TaxonomyPageObjects clickOnPreviousButtonInPagination() throws Exception
	{
		Thread.sleep(5000);
		paginationPreviousButton.click();
		return this;
	}
	
	@Step("To Click On 'Previous' Button in Taxonomy Pagination")
	public TaxonomyPageObjects clickOnNextButtonInPagination() throws Exception
	{
		Thread.sleep(5000);
		paginationNextButton.click();
		return this;
	}
	
	@Step("To Click On 'Previous' Button in Taxonomy Pagination")
	public TaxonomyPageObjects clickOnFirstButtonInPagination() throws Exception
	{
		Thread.sleep(5000);
		paginationFirstButton.click();
		return this;
	}
	
	@Step("To Click On 'Previous' Button in Taxonomy Pagination")
	public TaxonomyPageObjects clickOnLastButtonInPagination() throws Exception
	{
		Thread.sleep(5000);
		paginationLastButton.click();
		return this;
	}

}
