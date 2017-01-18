package org.cimm2touch.pageobjects.subset;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Get;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CatalogBuilderPageObjects extends PageFactoryInitializer{
	
	
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	public void FluentWaitForVisibilityOfElement(int TotalTimeInSeconds, int PollingTimeInMilliSeconds, WebElement element)
	{
		
		FluentWait<RemoteWebDriver> waitForElement = new FluentWait<RemoteWebDriver>((RemoteWebDriver) getDriver());
		waitForElement	.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliSeconds,TimeUnit.MILLISECONDS)
				.ignoring(ElementNotVisibleException.class);
		
		waitForElement.until(ExpectedConditions.visibilityOf(element));
	}
	@FindBy(xpath="//form[@id='subsetList']/descendant::td[contains(@class,'rich-tabhdr')]/descendant::tr/td[text()='Available']")
	private WebElement CBV_Available;
	
	@FindBy(xpath="//form[@id='subsetList']/descendant::td[contains(@class,'rich-tabhdr')]/descendant::tr/td[text()='Selected']")
	private WebElement CBV_Selected;
	@FindBy(xpath="//div[@class='manufacturer-search-header1']//span[contains(.,'Manufacturer')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_Available_AddManufacurer;
	@FindBy(xpath="//div[@class='attr-search-header1']//span[contains(.,'Brand')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_Available_AddBrand;
	@FindBy(xpath="//div[@class='cimmSearchTxt']/input[@id='searchFormId:searchKeywordId']")
	private WebElement CBV_SearchItem;
	@FindBy(xpath="//div[@class='manufacturer-search-header']//span[contains(.,'Manufacturer')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_AddManufacturer;
	@FindBy(xpath="//div[@class='attr-search-header']//span[contains(.,'Brand')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_AddBrand;
	@FindBy(xpath="//input[@title='Refresh Catalog']")
	private WebElement CBV_RefreshCatalogButton;

	@FindBy(xpath="//input[@title='Save Rules']")
	private WebElement CBV_SaveRulesButton;
	
	@Step("To Verify the 'Catalog Builder' Page Items.")
	public CatalogBuilderPageObjects verifyCatalogBuilderPageItems() throws Exception 
	{
		Thread.sleep(5000);
		//FluentWaitForVisibilityOfElement(30, 1000, CBV_Available);
		Assert.assertTrue(CBV_Available.isDisplayed(), "Left Side Bar -> Available Tab is Absent");
		
		Assert.assertTrue(CBV_Selected.isDisplayed(), "Left Side Bar -> Selected Tab is Absent");
		
		Assert.assertTrue(CBV_Available_AddManufacurer.isDisplayed(), "Left Side Bar -> Add New Manufacturer is Absent under 'Available' Tab");
		
		Assert.assertTrue(CBV_Available_AddBrand.isDisplayed(), "Left Side Bar -> Add New Brand is Absent under 'Available' Tab");
		
		Assert.assertTrue(CBV_SearchItem.isDisplayed(), "'Search Item' Search Box is Absent");
		
		Assert.assertTrue(CBV_AddManufacturer.isDisplayed(), "Add New Manufacturer is Absent");
		
		Assert.assertTrue(CBV_AddBrand.isDisplayed(), "Add New Brand is Absent");
		
		Assert.assertTrue(CBV_RefreshCatalogButton.isDisplayed(), "'Refresh Catalog' Button is Absent");
		
		Assert.assertTrue(CBV_SaveRulesButton.isDisplayed(), "'Save Catalog' Button is Absent");
		return this;
	}
	
	

	public CatalogBuilderPageObjects verifyAllItemTab(String allItemTab) throws InterruptedException {
		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElement(allItemtabLocator, 55);
		allItemtabLocator.click();
		//System.out.println(allItemtabLocator.getText());
		Assert.assertEquals(allItemtabLocator.getText().trim(), allItemTab.trim());
		return this;
	}
	@FindBy(xpath="//td[contains(text(),'Excluded Items')]")
	private WebElement excludedItemtabLocator;

	public CatalogBuilderPageObjects verifyExcludedItemTab(String excludedItemTab) {
		waiting.explicitWaitVisibilityOfElement(excludedItemtabLocator, 40);
		System.out.println(excludedItemtabLocator.getText());
		Assert.assertEquals(excludedItemtabLocator.getText().trim(), excludedItemTab.trim());
		return this;
	}
	
	@FindBy(xpath="//td[contains(text(),'Additional Items')]")
	private WebElement additionalItemtabLocator;

	public CatalogBuilderPageObjects verifyAdditionalItemTab(String additionalItemTab) {
		waiting.explicitWaitVisibilityOfElement(additionalItemtabLocator, 40);
		System.out.println(additionalItemtabLocator.getText());
		Assert.assertEquals(additionalItemtabLocator.getText().trim(), additionalItemTab.trim());
		return this;
		
	}
	@FindBy(xpath="//form[@id='subsetList']//descendant::input[@class='brandSearchTextBox']")
	private WebElement CBV_Available_AddBrand_SearchBox;
	@FindBy(xpath="//form[@id='subsetList']//descendant::input[@class='manufacturerSearchTextBox']")
	private WebElement CBV_Available_AddManufacurer_SearchBox;
	@Step("To Select Manufacturer and Brands to the 'Catalog Builder' Page Items.")
	public CatalogBuilderPageObjects addManufacturerAndBrand(String manufacturerName, String brandName) throws Exception 
	{
		Thread.sleep(5000);
		CBV_Available_AddManufacurer.click();
		//Thread.sleep(5000);
		CBV_Available_AddManufacurer_SearchBox.click();
		CBV_Available_AddManufacurer_SearchBox.sendKeys(manufacturerName);
		//Thread.sleep(2000);

		getDriver().findElement(By.xpath("//td[contains(@id,'subsetList:MnfListTabId') and (text()='"+manufacturerName+"')]/preceding-sibling::td/label")).click();
		//Thread.sleep(2000);
		//getDriver().findElement(By.xpath("//td[contains(@id,'subsetList:MnfListTabId') and (text()='"+manufacturerName+"')]/preceding-sibling::td/label"));
		CBV_Available_AddBrand.click();
		CBV_Available_AddBrand_SearchBox.click();
		CBV_Available_AddBrand_SearchBox.sendKeys(brandName);

		getDriver().findElement(By.xpath("//td[contains(@id,'subsetList:brandTableId') and (text()='"+brandName+"')]/preceding-sibling::td/label")).click();
		return this;
	}
	@Step("To click on Save Rules in 'Catalog Builder' Page Items.")
	public CatalogBuilderPageObjects clickOnSaveRules()
	{
		FluentWaitForVisibilityOfElement(10, 500, CBV_SaveRulesButton);
		CBV_SaveRulesButton.click();
		return this;
	}
	@FindBy(xpath="//td[contains(text(),'Selected')]")
	private WebElement selectedLocator;
	
	@Step("To click on 'Selected' Tab in the left SideBar.")
	public CatalogBuilderPageObjects clickOnSelectedTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(selectedLocator, 55);
		Thread.sleep(4000);
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", selectedLocator);
		return this;
		
	}
	
	
	@FindAll(value={@FindBy(xpath="//thead[@class='rich-table-thead']/descendant::th[@class='rich-table-subheadercell']/span")})
	private List<WebElement> selectedTabFieldlocator;
	
	public CatalogBuilderPageObjects verifySelectedTabField(String selectedTabField) {
		String[] selectedTabField1= selectedTabField.split(",");
		waiting.explicitWaitVisibilityOfElements(selectedTabFieldlocator, 45);
		for(int i =0;i<selectedTabFieldlocator.size();i++)
		{
			Assert.assertEquals(selectedTabFieldlocator.get(i).getText().trim(), selectedTabField1[i].trim());
		}
		
		return this;
		
	}
	public CatalogBuilderPageObjects verifyBrandNameUnderSelectedTab(String brandName) {
		WebElement brand =getDriver().findElement(By.xpath("//td[contains(text(),'BRAND')]/preceding-sibling::td[text()='"+brandName+"']"));
		waiting.explicitWaitVisibilityOfElement(brand, 30);
		System.out.println(brand.getText());
		Assert.assertEquals(brand.getText(), brandName);
		return this;
		
	}
	public CatalogBuilderPageObjects verifyManufacturerNameUnderSelectedTab(String manufacturerName) {
		
		WebElement manufacturer =getDriver().findElement(By.xpath("//td[contains(text(),'MANUFACTURER')]/preceding-sibling::td[text()='"+manufacturerName+"']"));
		waiting.explicitWaitVisibilityOfElement(manufacturer, 30);
		System.out.println(manufacturer.getText());
		Assert.assertEquals(manufacturer.getText(), manufacturerName);
		return this;
		
	}
	public CatalogBuilderPageObjects verifyManufacturerCountAndBrandCount(String brandCount, String manufacturerCount,String messageOfCount) {
		
		WebElement count =getDriver().findElement(By.xpath("//span[contains(text(),'"+brandCount+" Brand(s) , "+manufacturerCount+" Manufacturer Saved In Rules')]"));
		waiting.explicitWaitVisibilityOfElement(count, 30);
		Assert.assertEquals(count.getText(), messageOfCount);
		//Assert.assertTrue(count.isDisplayed());
		
		return this;
	}
	@FindBy(xpath="//td[contains(text(),'BRAND')]/preceding-sibling::td[@class='rich-table-cell']/descendant::input")
	private WebElement deleteBrandUnderSelectedTab;
	@FindBy(xpath="//span[@id='saveMessage']")
	private WebElement deleteBrandMessageLocator;
	
	public CatalogBuilderPageObjects verifySuccessMessageForDeletionOfBrand(String brandName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(deleteBrandUnderSelectedTab, 20);
		//deleteBrandUnderSelectedTab.click();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",deleteBrandUnderSelectedTab);
		tu.alertAccept();
		Thread.sleep(2000);
		//getDriver().findElement(By.xpath(""))
		waiting.explicitWaitVisibilityOfElement(deleteBrandMessageLocator, 20);
		Assert.assertEquals(deleteBrandMessageLocator.getText(), "Entity With Name - : '"+brandName+"' removed Successfully.");
		return this;
	}
	/*@FindBy(xpath="//td[contains(text(),'MANUFACTURER')]/preceding-sibling::td[@class='rich-table-cell']/descendant::input")
	private WebElement deleteManufacturerUnderSelectedTab;*/
	@FindBy(xpath="//td[contains(text(),'MANUFACTURER')]/preceding-sibling::td/descendant::input")
	private WebElement deleteManufacturerUnderSelectedTab;
	
	@FindBy(xpath="//span[@id='saveMessage']")
	private WebElement deleteManufacturerMessageLocator;
	
	public CatalogBuilderPageObjects verifySuccessMessageForDeletionOfManufacturer(String manufacturerName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(deleteManufacturerUnderSelectedTab, 10);
		//deleteManufacturerUnderSelectedTab.click();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",deleteManufacturerUnderSelectedTab);
		   tu.alertAccept();
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(deleteManufacturerMessageLocator, 20);
		Assert.assertEquals(deleteManufacturerMessageLocator.getText(), "Entity With Name - : '"+manufacturerName+"' removed Successfully.");
		return this;
	}
	@FindBy(xpath="//input[@title='Refresh Catalog']")
	private WebElement refreshCatalogLocator;
	
	public CatalogBuilderPageObjects clickOnRefreshCatalog() throws InterruptedException {
		//Thread.sleep(2000);
		//refreshCatalogLocator.click();
		waiting.explicitWaitVisibilityOfElement(refreshCatalogLocator, 30);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",refreshCatalogLocator);
		Thread.sleep(5000);
		return this;
	}
	@FindBy(xpath="//span[@id='saveMessage']")
	private WebElement refreshCatalogMessageLocator;
	
	public CatalogBuilderPageObjects verifyWetherCatalogRefreshed() throws InterruptedException {
		Thread.sleep(4000);
		
		waiting.explicitWaitVisibilityOfElement(refreshCatalogMessageLocator, 68);
		
		Assert.assertEquals(refreshCatalogMessageLocator.getText(), "Catalog Refresh Completed Successfully");
		return this;
		
	}
	@FindBy(xpath="//div[@class='tabContentTopStrip']/descendant::p")
	private WebElement totalNumberOfItemLocator;
	
	public CatalogBuilderPageObjects verifyWhetherItemDisplayed(String noOfItem) {
		waiting.explicitWaitVisibilityOfElement(totalNumberOfItemLocator, 30);
		System.out.println(totalNumberOfItemLocator.getText());
		
		Assert.assertEquals(totalNumberOfItemLocator.getText(), "Total Items :"+noOfItem);
		return this;
		
	}
	
	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchkeywordLocator;

	
	public CatalogBuilderPageObjects enterSearchkeyword(String partNumber) throws InterruptedException {
		Thread.sleep(2000);
		searchkeywordLocator.sendKeys(partNumber);
		return this;
		
	}
	
	@FindBy(xpath="//div[@class='attribute-search-panel']/descendant::div[@align='center']/descendant::input[@title='Item Search']")
	private WebElement searchButtonLocator;
	
	public CatalogBuilderPageObjects clickOnSearchItemButton() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(searchButtonLocator, 30);
		searchButtonLocator.click();
		Thread.sleep(4000);
		return this;
		
	}
	
	@FindBy(xpath="//table[@id='searchFormId:searchedItemTableId']/tbody/tr/td[3]/descendant::td")
	private WebElement searchedItemPartNumberlocator;  
	
	public CatalogBuilderPageObjects verifySearchedItemResults(String partNumber) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(searchedItemPartNumberlocator, 30);
		Thread.sleep(3000);
		Assert.assertEquals(searchedItemPartNumberlocator.getText().trim(), partNumber);
		System.out.println("verify Searched Item   Results:==================== " + searchedItemPartNumberlocator.getText().trim());
		
		return this;
		
	}
	
	@FindBy(xpath="//td[contains(text(),'Additional Items')]")
	private WebElement additionalItemsLocator;
	
	public CatalogBuilderPageObjects clickOnAdditionalItemsLink() throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",additionalItemsLocator);
		Thread.sleep(2000);
		return this;		
	}
	/*@FindBy(xpath="//td[text()='1652458']")
	private WebElement sourceItemLocator;*/
	
	@FindBy(xpath="//span[text()='Action']")
	private WebElement additionalItemsTableLocator;
	
	public CatalogBuilderPageObjects dragDropAnItem(String partNumber) throws InterruptedException {
		Thread.sleep(3000);

		//System.out.println("drag and drop done");
		  WebElement sourceItemLocator = getDriver().findElement(By.xpath("//td[text()='"+partNumber+"']"));
		 elementHighlight(sourceItemLocator);
		Actions builder = new Actions(getDriver());
		builder.clickAndHold(sourceItemLocator).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(additionalItemsTableLocator, 0, 0).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 5).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 10).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 15).build().perform();
		builder.release().build().perform();
		Thread.sleep(4000);
		System.out.println("drag and drop done");
		return this;
	}
	@FindBy(xpath="//span[@id='saveMessage']")
	private WebElement saveRulesSuccessMsgAfterAdditionOfItem;
	
	public CatalogBuilderPageObjects verifySuccessMsgAfterAdditionOfTem(String msgAfterAdditionOfItem) throws InterruptedException {
		Thread.sleep(3000);
		//waiting.explicitWaitVisibilityOfElement(saveRulesSuccessMsgAfterAdditionOfItem, 30);
		System.out.println(saveRulesSuccessMsgAfterAdditionOfItem.getText());
		Assert.assertEquals(saveRulesSuccessMsgAfterAdditionOfItem.getText().trim(),msgAfterAdditionOfItem);
		
		return this;
		
	}
	@Step("declaration for drag and drop operation.")
	public void elementHighlight(WebElement element) {
		  for (int i = 0; i < 2; i++) {

		   JavascriptExecutor js = (JavascriptExecutor) getDriver();
		   js.executeScript(
		     "arguments[0].setAttribute('style', arguments[1]);",
		     element, "color: red; border: 3px solid red;");
		   js.executeScript(
		     "arguments[0].setAttribute('style', arguments[1]);",
		     element, "");
		  }
		 }
	@FindBy(xpath="//td[contains(text(),'All Items')]")
	private WebElement allItemtabLocator;
	
	public CatalogBuilderPageObjects clickOnAllItemTab() throws InterruptedException {
		
		//waiting.explicitWaitVisibilityOfElement(allItemtabLocator, 30);
		  Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",allItemtabLocator);
		Thread.sleep(4000);
		System.out.println("reached inside clickOnAllItemTab");
		return this;
		
	}

	@FindBy(xpath="//div[@class='tabContentTopStrip']/descendant::p")
	private WebElement itemPresentMessageUnderAllItemLocator;

	public CatalogBuilderPageObjects verifyItemUnderAllItemTab(String partNumber,String msgUnderAllTabAfterAdditionOfItem) {
		
		waiting.explicitWaitVisibilityOfElement(itemPresentMessageUnderAllItemLocator, 20);
		
		Assert.assertEquals(itemPresentMessageUnderAllItemLocator.getText(),msgUnderAllTabAfterAdditionOfItem );
		System.out.println(itemPresentMessageUnderAllItemLocator.getText());
		  WebElement itempartNumber =  getDriver().findElement(By.xpath("//td[text()='"+partNumber+"']"));
		waiting.explicitWaitVisibilityOfElement(itempartNumber, 30);
		System.out.println(itempartNumber.getText());
		Assert.assertEquals(itempartNumber.getText(), partNumber);
		
		return this;
		
	}


	@FindBy(xpath="//td[contains(text(),'Excluded Items')]")
	private WebElement excludedItemsLocator;
	
	public CatalogBuilderPageObjects clickOnExcludedItemsLink() throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",excludedItemsLocator);
		Thread.sleep(2000);
		return this;		
	}



	public CatalogBuilderPageObjects verifyItemUnderAllItemTab(String msgUnderAllTabAfterDeletionOfItem) {
           waiting.explicitWaitVisibilityOfElement(itemPresentMessageUnderAllItemLocator, 20);
		
		Assert.assertEquals(itemPresentMessageUnderAllItemLocator.getText(),msgUnderAllTabAfterDeletionOfItem );
		System.out.println(itemPresentMessageUnderAllItemLocator.getText());
		return this;		
	}

}
