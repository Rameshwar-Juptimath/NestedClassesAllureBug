package org.cimm2touch.pageobjects.homepage;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.pageobjects.adminstration.SystemSettingsPageObjects;
import org.cimm2touch.pageobjects.items.AddNewItemPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.manufacturer.ManufacturerPageObjects;
import org.cimm2touch.pageobjects.products.ProductsListPageObjects;
import org.cimm2touch.pageobjects.subset.SubsetPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributeGroupsPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyPageObjects;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePageObjects extends PageFactoryInitializer{
	
	 
	
	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::span[contains(.,'Product Master')]/following-sibling::ul/descendant::a[contains(.,'Products')]")
	private WebElement productslinkLocator;
	


	
	@FindBy(xpath="//div[contains(@class,'rightSliderRightArrow')]")
	private WebElement rightNavigationArrowLocator;
	
	@FindBy(xpath="//a[@title='Search']/i")
	private WebElement searchButton;



	@FindBy(xpath="//li/a[contains(text(),'Manufacturers & Brands')]")
	private WebElement ManufacturerlinkLocator;

	@FindBy(xpath="//li/a[contains(text(),'Subset/Catalog')]")
	private WebElement subsetlinkLocator;
	
	@FindBy(xpath="(//input[@placeholder='Enter Text to Search'])[2]")
	private WebElement seachInputTextField;

	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::a[contains(.,'Taxonomy Management')]/following-sibling::ul/descendant::a[contains(.,'Taxonomy')][1]")
	private WebElement taxonomylinkLocator;
	
	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::a[contains(.,'Taxonomy Management')]/following-sibling::ul/descendant::a[contains(.,'Attributes')]")
	private WebElement attributeslinkLocator;
	
	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::a[contains(.,'Taxonomy Management')]/following-sibling::ul/descendant::a[contains(.,'Attribute Groups')]")
	private WebElement attributesGroupsLinkLocator;

	

	@Step("clicking on PIM link")
	public HomePageObjects clickonPIM() {
		pimlinkLocator.click();
		return this;
	}
	
	@Step("clicking on items link")
	public ItemsPageObjects clickOnItemsLink() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",itemslinkLocator);
		return new ItemsPageObjects();
	}

	@Step("clicking on subset/catelog link")
	public SubsetPageObjects clickonSubsetlink(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",subsetlinkLocator);
		return new SubsetPageObjects();
	}
	
	
	@Step("click on left navigation bar")
	public HomePageObjects clickOnLeftNavigationbar() {
		Waiting.explicitWaitVisibilityOfElement(leftNavigationArrowLocator, 5);
		leftNavigationArrowLocator.click();
		return this;
	}

	@Step("click on system settings link")
	public SystemSettingsPageObjects clickOnSystemSettingsLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",systemSettingsLinkLocator);
		return new SystemSettingsPageObjects();
	}

	 @Step("click on right navigation bar")
		public AddNewItemPageObjects clickOnRightNavigationBar() throws Exception {
			Waiting.explicitWaitVisibilityOfElement(rightNavigationArrowLocator, 17);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",rightNavigationArrowLocator);
			return new AddNewItemPageObjects();
		}

	

	@Step("click on the manufacturer and brands link")
	public ManufacturerPageObjects clickOnManufacturerAndBrands() throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",ManufacturerlinkLocator);
		return new ManufacturerPageObjects();
	}

	@Step("Click on Products link in Home page")
	public ProductsListPageObjects clickOnProductsLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",productslinkLocator);
		return new ProductsListPageObjects();
	}
	
	@Step("enter the created item part number {0} in  advanced search field & click on search ")
	public HomePageObjects searchForCreatedItem(String partNumber){
		Waiting.explicitWaitVisibilityOfElement(seachInputTextField, 10);
		seachInputTextField.clear();
		seachInputTextField.sendKeys(partNumber);
		searchButton.click();
		
		
		return this;
	}

	
	
	@FindBy(xpath="//a[contains(text(),'Subset/Catalog')]")
	private WebElement subsetlink;
		
	@FindBy(css="div.header-right > ul.cimm_boxShadow > li > div.header-right-icons > ul > li > div.loggedInUser")
	private WebElement welcomeMessageLocator;
	
	@FindBy(xpath="(//li/a[contains(text(),'Manufacturers & Brands')])[1]")
	private WebElement MBlinkLocator;
	
	@FindBy(xpath="//span/li/a[contains(text(),'Items')]")
	private WebElement itemslinkLocator;
	
	
	@FindBy(xpath="//li/a[contains(text(),'Vendors')]")
	private WebElement vendorlinkLocator;
	
	
	@FindBy(xpath="//div[contains(@class,'sliderLeftArrow')]")
	private WebElement leftNavigationArrowLocator;
	
	@FindBy(xpath="(//a[contains(.,'ADMINISTRATION')])[1]/ancestor::li/descendant::a[contains(text(),'System Settings')]")
	private WebElement systemSettingsLinkLocator;

	@FindBy(linkText="PIM")
	private WebElement pimlinkLocator;
	
	@FindBy(xpath="(//li/span[contains(text(),'Product Master')])[1]")
	private WebElement productmasterlinkLocator;
	
	
	@Step("clicking on Manufacturers & Brands link")
		public HomePageObjects clickonManufactureBrandsLink() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",MBlinkLocator);
		return this;
		}
	

	@Step("clicking on Product master link")
	public HomePageObjects clickonProductMaster() {
		
		productmasterlinkLocator.click();
		return this;
	}
	


	
	@Step("verifying welcome message {0}")
	public HomePageObjects verifyWelcomeMessage(String welcomeMessage)
	{
		Assert.assertEquals(welcomeMessageLocator.getText(), welcomeMessage,"Invalid welcome message. Getting "+welcomeMessageLocator.getText()+".");
	//	Assert.assertTrue(welcomeMessageLocator.getText().equalsIgnoreCase(welcomeMessage),"Invalid welcome message. Getting "+welcomeMessageLocator.getText()+".");
		return this;
	}

	@Step("clicking on subset link")
	public HomePageObjects clickOnSubset(){
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",subsetlink);
		return this;
	}

	@Step("clicking on vendors link")
	public HomePageObjects clickOnVendorLink() {

	((JavascriptExecutor) driver).executeScript("arguments[0].click();",vendorlinkLocator);
	return this;
}
	@Step("clicking on taxonomy link")
	public TaxonomyPageObjects clickOnTaxonomyLink() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",taxonomylinkLocator);
		return new TaxonomyPageObjects();
	}
	
	@Step("clicking on attributes link")
	public AttributesPageObjects clickOnAttributesLink()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",attributeslinkLocator);
		return new AttributesPageObjects();
	}
	
	@Step("clicking on attribute Groups link")
	public AttributeGroupsPageObjects clickOnAttributeGroupsLink() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",attributesGroupsLinkLocator);
		return new AttributeGroupsPageObjects();
	}
	
}

