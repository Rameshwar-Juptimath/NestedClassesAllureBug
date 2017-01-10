package org.cimm2touch.pageobjects.subset;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CatalogBuilderPageObjects extends PageFactoryInitializer{
	
	
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	
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
	
	@FindBy(xpath="//td[Contains(text(),'All Items')]")
	private WebElement allItemtabLocator;

	public CatalogBuilderPageObjects verifyAllItemTab(String allItemTab) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(allItemtabLocator, 55);
		System.out.println(allItemtabLocator.getText());
		Assert.assertEquals(allItemtabLocator.getText().trim(), allItemTab.trim());
		return this;
	}
	@FindBy(xpath="//td[Contains(text(),'Excluded Items')]")
	private WebElement excludedItemtabLocator;

	public CatalogBuilderPageObjects verifyExcludedItemTab(String excludedItemTab) {
		waiting.explicitWaitVisibilityOfElement(excludedItemtabLocator, 40);
		System.out.println(excludedItemtabLocator.getText());
		Assert.assertEquals(excludedItemtabLocator.getText().trim(), excludedItemTab.trim());
		return this;
	}
	
	@FindBy(xpath="//td[Contains(text(),'Additional Items')]")
	private WebElement additionalItemtabLocator;

	public CatalogBuilderPageObjects verifyAdditionalItemTab(String additionalItemTab) {
		waiting.explicitWaitVisibilityOfElement(additionalItemtabLocator, 40);
		System.out.println(additionalItemtabLocator.getText());
		Assert.assertEquals(additionalItemtabLocator.getText().trim(), additionalItemTab.trim());
		return this;
		
	}

}
