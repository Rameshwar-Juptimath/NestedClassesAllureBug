package org.cimm2touch.pageobjects.taxonomymanagement;
import java.util.List;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.pageobjects.adminstration.SystemSettingsPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.vendors.VendorPageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	@FindBy(xpath="//a[@id='j_id773:j_id775']") //please change this
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

	@FindBy(xpath="(//ul[@class='pagination-container']/li)[1]")
	private WebElement paginationFirstPageLocator;
	
	@FindBy(xpath="(//span[@class='total-count-size'])[2]") 
	private  WebElement totalCountTextLocator;
	
	@FindBy(xpath="(//span[@class='total-count-size'])[1]") 
	private  WebElement currentPageCountTextLocator;
	
	@FindBy(xpath="//a[@title='Next']")
	private WebElement paginationNextLinkLocator;
	
	@FindBy(xpath="//a[@title='Previous']")
	private WebElement paginationPreviousLinkLocator;
	
	@FindBy(xpath="(//ul[@class='pagination-container']/li)[5]")
	private WebElement paginationLastPageLocator;
	
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
	public TaxonomyPageObjects enterSearchTaxonomy(String searchTaxonomy) {
		Waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchTaxonomy);
		return this;
	}

	public TaxonomyPageObjects enterInvalidTaxonomy(String searchInvalidTaxonomy) {
		Waiting.explicitWaitVisibilityOfElement(searchTextboxInTaxonomySectionLocator, 5);
		searchTextboxInTaxonomySectionLocator.clear();
		searchTextboxInTaxonomySectionLocator.sendKeys(searchInvalidTaxonomy);
		return this;
	}
	public TaxonomyPageObjects verifysearchfunctionalityforValidAndInvalidKey() {
		Waiting.explicitWaitVisibilityOfElement(searchsuccesfullMessageLocator, 8);
		Assert.assertEquals(searchsuccesfullMessageLocator.getText().trim(), "Manufacturer Name required");
		return this;
	}

	public TaxonomyPageObjects clickOnSearchTaxonomy() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",searchIconInTaxonomySectionLocator);
		return this;
	}
	public TaxonomyPageObjects verifyWhetherSearchedTaxonomyStyleIsGreen(String searchTaxonomy) throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+searchTaxonomy+"']")).getAttribute("style").trim().contains("green"));
		return this;
	}
	public TaxonomyPageObjects verifyNameIsPresent(String taxonomyToSearch) {

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+taxonomyToSearch+"']")).isDisplayed(),"Searched taxonomy is not present. Searched for "+taxonomyToSearch+".");
		return this;
	}
	public TaxonomyPageObjects verifyForinavalidInput(String inavalidTaxonomyName) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='searchId:savmsg2']")).isDisplayed(),"Searched taxonomy is not present. Searched for "+inavalidTaxonomyName+".");
		return this;

	}

	public TaxonomyPageObjects clickOnAddnewTaxonomy() {
		Waiting.explicitWaitVisibilityOfElement(addnewtaxonomyFieldLocator, 5);
		addnewtaxonomyFieldLocator.click();
		return this;

	}
	public TaxonomyPageObjects enterTaxonomyDesciption(String taxonomyDescription) throws InterruptedException {
		Thread.sleep(3000);
		taxonomyDesctextarea.sendKeys(taxonomyDescription);
		return this;			
	}
	
	public TaxonomyPageObjects clearTaxonomyDesciptionField() {
		Waiting.explicitWaitVisibilityOfElement(taxonomyDesctextarea, 10);
		taxonomyDesctextarea.clear();
		return this;
	}

	public TaxonomyPageObjects clickOnSaveInTaxonomypage() throws InterruptedException {
		Thread.sleep(3000);
		savebuttonintaxonomypage.click();
		return this;
	}
	public TaxonomyPageObjects verifyErrormessage(String errormessge) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(errormessage.getText().trim(), errormessge);
		return this;

	}
	public TaxonomyPageObjects verifyTaxonomyErrormessage(String errormessge) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(taxerrormessage.getText().trim(), errormessge);
		return this;
	}
	public TaxonomyPageObjects enterTaxonomyName(String taxonomyname) {
		taxonomynametextfield.sendKeys(taxonomyname);
		return this;

	}
	public TaxonomyPageObjects enteringMorethathirtycharactersinTaxonomyNameField(String getenteringMorethathirtycharacters) throws InterruptedException {
		Thread.sleep(3000);
		taxonomynametextfield.sendKeys(getenteringMorethathirtycharacters);
		return this;
		
	}
	public boolean verifyEnterdCharactersInTaxonomynamefield() throws InterruptedException {
		 Thread.sleep(3000);
		 Assert.assertTrue(taxonomynametextfield.getText().trim()!=data.getenteringMorethathirtycharacters());
		return true; 
		
	}
	public TaxonomyPageObjects enteringMoretha500charactersinTaxonomyDescField(String getenteringMoretha500characters) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(taxonomyDesctextarea, 10);
		taxonomyDesctextarea.sendKeys(getenteringMoretha500characters);
		return this;
	}
	public TaxonomyPageObjects verifyEnterdCharactersInTaxonomyDescfield() throws InterruptedException {
		By x = By.xpath("//div[@class='cimm_formInput']/textarea[@id='taxonomyAddEditForm:taxonomyDesc']");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(x));
		Assert.assertTrue(taxonomyDesctextarea.getText().trim()!=data.getenteringMoretha500characters());
		return this;
		
	}
	 
	public TaxonomyPageObjects verifyTaxonomyfieldsAfterclickingOnAddNewTaxonomyIcon(String[] taxonomyheaderslocators) throws InterruptedException {
		Thread.sleep(2500);
		for(int i=0;i<taxonomyheaderslocator.size();i++)
		{
			System.out.println(taxonomyheaderslocator.get(i).getText());
 		Assert.assertEquals(taxonomyheaderslocator.get(i).getText().trim(), taxonomyheaderslocators[i]);
			
		}
		return this;
		 
	}
	public TaxonomyPageObjects clickOnEditIconInTaxonomypage() {
		taxonomyEditlocator.click();
		return this;
	}
	public boolean verifyFormfilledWithExistingDetailsOfEditingeaxonomy() throws InterruptedException {
		boolean contains =false;
		Thread.sleep(2500);
		String taxonomydescription = taxonomyDesctextarea.getText();
		 contains = taxonomydescription.contains(taxonomydescription);
		System.out.println(taxonomynametextfield.getText() +"taxonomydescription "+taxonomydescription);
		return contains;
		
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
	}
	
	@Step("selecting {0} number of records to display.")
	public TaxonomyPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay) throws Exception{
	
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

}
