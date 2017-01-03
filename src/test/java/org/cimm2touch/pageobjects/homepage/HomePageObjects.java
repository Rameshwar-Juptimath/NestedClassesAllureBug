package org.cimm2touch.pageobjects.homepage;
import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.adminstration.SystemSettingsPageObjects;
import org.cimm2touch.pageobjects.items.AddNewItemPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.manufacturer.ManufacturerPageObjects;
import org.cimm2touch.pageobjects.products.ProductsListPageObjects;
import org.cimm2touch.pageobjects.subset.SubsetPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributeGroupsPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyPageObjects;
import org.cimm2touch.pageobjects.uom.UOMPageObjects;
import org.framework.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePageObjects extends PageFactoryInitializer{
	
	 Waiting waiting = new Waiting(getDriver());
	
	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::span[contains(.,'Product Master')]/following-sibling::ul/descendant::a[contains(.,'Products')]")
	private WebElement productslinkLocator;
	

	@FindBy(xpath="//div[@title='User Options']")
	private WebElement userOptionsLink;
	
	@FindBy(xpath="//div[contains(@class,'rightSliderRightArrow')]")
	private WebElement rightNavigationArrowLocator;
	
	@FindBy(xpath="//a[@title='Search']/i")
	private WebElement searchButton;

	@FindBy(xpath="//div[@title='User Options']/descendant::a[contains(.,'User Configuration')]")
	private WebElement userConfigurationLink;

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

	@FindAll(value={@FindBy(xpath="//div[@title='User Options']/descendant::li")})
	private List<WebElement> linksUnderUserOptions;

	@Step("clicking on PIM link")
	public HomePageObjects clickonPIM() {
		pimlinkLocator.click();
		return this;
	}
	
	@Step("clicking on items link")
	public ItemsPageObjects clickOnItemsLink() {

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",itemslinkLocator);
		return itemsPage();
	}

	@Step("clicking on subset/catelog link")
	public SubsetPageObjects clickonSubsetlink(){

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",subsetlinkLocator);

		return new SubsetPageObjects();
	}
	
	
	@Step("click on left navigation bar")
	public HomePageObjects clickOnLeftNavigationbar() {

		waiting.explicitWaitVisibilityOfElement(leftNavigationArrowLocator, 5);

		leftNavigationArrowLocator.click();
		return this;
	}

	@Step("click on system settings link")
	public SystemSettingsPageObjects clickOnSystemSettingsLink() {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",systemSettingsLinkLocator);
		return new SystemSettingsPageObjects();
	}

	 @Step("click on right navigation bar")
		public AddNewItemPageObjects clickOnRightNavigationBar() throws Exception {

		 waiting.explicitWaitVisibilityOfElement(rightNavigationArrowLocator, 20);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",rightNavigationArrowLocator);
			return new AddNewItemPageObjects();
		}

	

	@Step("click on the manufacturer and brands link")
	public ManufacturerPageObjects clickOnManufacturerAndBrands() throws Exception {

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",ManufacturerlinkLocator);
		return new ManufacturerPageObjects();
	}

	@Step("Click on Products link in Home page")
	public ProductsListPageObjects clickOnProductsLink() {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",productslinkLocator);
		return new ProductsListPageObjects();
	}
	
	@Step("enter the created item part number {0} in  advanced search field & click on search ")
	public HomePageObjects searchForCreatedItem(String partNumber){

		waiting.explicitWaitVisibilityOfElement(seachInputTextField, 10);
		seachInputTextField.clear();
		seachInputTextField.sendKeys(partNumber);
		searchButton.click();
		
		
		return this;
	}

	
	
	@FindBy(xpath="(//a[contains(text(),'Subset/Catalog')])[2]")
	private WebElement subsetlink;
		
	@FindBy(xpath="//form[@id='menuFmId:headerForm']/descendant::div[contains(@class,'loggedInUser')]") //css="div.header-right > ul.cimm_boxShadow > li > div.header-right-icons > ul > li > div.loggedInUser"
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
	//========================================
	@FindBy(xpath="//div[@id='clientLogoId']/following-sibling::div/descendant::a[contains(text(),'PIM')]/following-sibling::ul/descendant::a[contains(text(),'UOM')]")
	private WebElement uomLinkLocator;
	
	
	@Step("clicking on Manufacturers & Brands link")
		public HomePageObjects clickonManufactureBrandsLink() throws InterruptedException {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",MBlinkLocator);
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

		waiting.explicitWaitVisibilityOfElement(welcomeMessageLocator, 15);
		Assert.assertEquals(welcomeMessageLocator.getText(), welcomeMessage,"Invalid welcome message. Getting "+welcomeMessageLocator.getText()+".");
		return this;
	}

	@Step("clicking on subset link")
	public HomePageObjects clickOnSubset(){


		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",subsetlink);
		return this;
	}

	@Step("clicking on vendors link")
	public HomePageObjects clickOnVendorLink() {


	((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",vendorlinkLocator);
	return this;
}
	@Step("clicking on taxonomy link")
	public TaxonomyPageObjects clickOnTaxonomyLink() {

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",taxonomylinkLocator);
		return new TaxonomyPageObjects();
	}
	
	@Step("clicking on attributes link")
	public AttributesPageObjects clickOnAttributesLink()
	{

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",attributeslinkLocator);
		return new AttributesPageObjects();
	}
	
	@Step("clicking on attribute Groups link")
	public AttributeGroupsPageObjects clickOnAttributeGroupsLink() {

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",attributesGroupsLinkLocator);
		return new AttributeGroupsPageObjects();
	}

	public HomePageObjects clickOnUserOptionsIcon() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(userOptionsLink, 15);
		Thread.sleep(3000);
		userOptionsLink.click();
		return this;
	}

	public HomePageObjects verifyUserUserConfigurationLink() {

		waiting.explicitWaitVisibilityOfElement(userConfigurationLink, 15);
		Assert.assertTrue(userConfigurationLink.isDisplayed());
		return this;
		
		
	}

	public HomePageObjects verifytheLinksUnderUserOptions() {

		waiting.explicitWaitVisibilityOfElements(linksUnderUserOptions, 20);
			Assert.assertNotNull(linksUnderUserOptions,"user options list are :"+linksUnderUserOptions+"");
		
		return this;
	}

	public HomePageObjects clickOnUserConfigurationLink() {

		waiting.explicitWaitVisibilityOfElement(userConfigurationLink, 15);
		userConfigurationLink.click();
		return this;
	}

	@Step("clicking on uom link")
	public UOMPageObjects clickOnUomLink() {

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",uomLinkLocator);
		return uomPage();
	}
	
}

