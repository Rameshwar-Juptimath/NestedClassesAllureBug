package org.cimm2touch.pageobjects.warehouse;

import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class WareHousePageObjects extends PageFactoryInitializer{
	Waiting waiting= new Waiting(getDriver());
	TestUtility utility=new TestUtility(getDriver());
	
	
	
	@FindBy(xpath="//div[@class='list-search']/descendant::input[contains(@name,'searchKeywordId')]")
	private WebElement warehouseSearchInputFieldLocator;
	
	@FindBy(xpath="//a[contains(@id,'goBtn')]")
	private WebElement warehouseSearchButtonLocator;
	
	@FindBy(xpath="//input[@id='addWarehouseForm:whName']")
	private WebElement wareHouseNameInputField;
	
	
	@FindBy(xpath="//input[@id='addWarehouseForm:whcode']")
	private WebElement wareHouseCodeInputField;
	
	@FindBy(xpath="//textarea[@id='addWarehouseForm:addr1']")
	private WebElement warehouseAddress1InputLocator;
	
	@FindBy(xpath="//select[@id='addWarehouseForm:country']")
	private WebElement warehouseCountrySelectLocator;
	
	@FindBy(xpath="//input[@id='addWarehouseForm:city']")
	private WebElement warehouseCityInputField;
	
	@FindBy(xpath="//input[@id='addWarehouseForm:state']")
	private WebElement warehouseStateInputField;
	
	@FindBy(xpath="//input[@id='addWarehouseForm:zipcode']")
	private WebElement warehouseZipCodeInputField;
	
	@FindBy(xpath="//a[@title='Add New Warehouse']")
	private WebElement addNewWareHouseLocator;
	
	@FindBy(xpath="//form[@id='addWarehouseForm']/descendant::input[contains(@title,'Save')]")
	private WebElement saveWarehouseLocator;
	
	
	@FindBy(xpath="//span[@id='addWarehouseForm:success']")
	private WebElement	successfulMessageForSaveNewWarehouse;
	
	
	@Step("verify ware house page title {0}")
	public WareHousePageObjects verifyWareHousePage(String wareHousePageTitle) {
	
	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Assert.assertEquals(getDriver().getTitle().trim(), wareHousePageTitle.trim());
	return this;
	}


	@Step("search for ware house {0}")
	public WareHousePageObjects searchForWareHouse(String warehouseName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(warehouseSearchInputFieldLocator, 40);
		warehouseSearchInputFieldLocator.clear();
		warehouseSearchInputFieldLocator.sendKeys(warehouseName);
		warehouseSearchButtonLocator.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("verify ware house{0} is already present or not")
	public WareHousePageObjects verifyWarehouseAlreadyExist(String warehouseName)
	{
		Assert.assertTrue(assertVerifyWarehousePresent(warehouseName),"ware house: "+warehouseName+" is already present, Please delete to create again");
		return this;
		
	}


	private boolean assertVerifyWarehousePresent(String warehouseName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{
		if(getDriver().findElement(By.xpath("//tbody[@id='listWarehouseForm:warehouseDataTable:tb']/descendant::span[text()='"+warehouseName+"']")).isDisplayed())
		{
			return false;
		}
		}catch(Exception e)
		{
			return true;
		}
		
		return false;
	}


	
	@Step("enter details to create new warehouse")
	public WareHousePageObjects createNewWarehouse(String warehouseName, String warehouseCode, 
			String address1, String selectCountry, String cityName, String stateName , String zipCode) {
		warehousePage()
		.enterWarehouseName(warehouseName)
		.enterWarehouseCode(warehouseCode)
		.enterWarehouseAddress1(address1)
		.selectCountry(selectCountry)
		.enterCity(cityName)
		.enterState(stateName)
		.enterZip(zipCode);

		return this;
	}

	@Step("click on add new warehouse locaor")
	public WareHousePageObjects clickOnAddNewWareHouseLink() {
	waiting.explicitWaitElementToBeClickable(addNewWareHouseLocator, 30);
	addNewWareHouseLocator.click();
		return this;
	}

	@Step("enter warehouse name{0}")
	public WareHousePageObjects enterWarehouseName(String warehouseName) {
		waiting.explicitWaitVisibilityOfElement(wareHouseNameInputField, 30);
		wareHouseNameInputField.sendKeys(warehouseName);
		return this;
	}

	@Step("enter warehouse code")
	public WareHousePageObjects enterWarehouseCode(String warehouseCode) {
		waiting.explicitWaitVisibilityOfElement(wareHouseCodeInputField, 30);
		wareHouseCodeInputField.sendKeys(warehouseCode);
		return this;
	}

	@Step("enter warehouse address 1{0}")
	public WareHousePageObjects enterWarehouseAddress1(String address1) {
		waiting.explicitWaitVisibilityOfElement(warehouseAddress1InputLocator, 30);
		warehouseAddress1InputLocator.clear();
		warehouseAddress1InputLocator.sendKeys(address1);

		return this;
	}

	@Step("select country {0}")
	public WareHousePageObjects selectCountry(String selectCountry) {
		waiting.explicitWaitVisibilityOfElement(warehouseCountrySelectLocator, 30);
		utility.selectByVisibleText(warehouseCountrySelectLocator, selectCountry);
		
		return this;
	}

	@Step("enter city name{0}")
	public WareHousePageObjects enterCity(String cityName) {
		waiting.explicitWaitVisibilityOfElement(warehouseCityInputField, 30);
		warehouseCityInputField.clear();
		warehouseCityInputField.sendKeys(cityName);

		return this;
	}

	@Step("enter state name{0}")
	public WareHousePageObjects enterState(String stateName) {
		waiting.explicitWaitVisibilityOfElement(warehouseStateInputField, 30);
		warehouseStateInputField.sendKeys(stateName);

		return this;
	}

	@Step("enter warehouse zip code{0}")
	public WareHousePageObjects enterZip(String zipCode) {
		waiting.explicitWaitVisibilityOfElement(warehouseZipCodeInputField, 30);
		warehouseZipCodeInputField.sendKeys(zipCode);

		return this;
	}

	@Step("click on save new warehouse")
	public WareHousePageObjects clickOnSaveNewWarehouseLink() throws InterruptedException {
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()", saveWarehouseLocator);
		
		Thread.sleep(2500);

		return this;
	}

	@Step("verify success message {0}for save")
	public WareHousePageObjects verifySuccessMessage(String expSuccessMessage) {
		wareHouseCodeInputField.click();
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,+2000)","");
		Assert.assertEquals(successfulMessageForSaveNewWarehouse.getText().trim(), expSuccessMessage.trim(),"warehouse was not getting saved. exp: "+expSuccessMessage+" but actual: "+successfulMessageForSaveNewWarehouse.getText()+"");

		return this;
	}

	@Step("verify weather created warehouse {0} is displayed or not.")
	public WareHousePageObjects searchForCreatedWarehouse(String warehouseName) {
		Assert.assertFalse(assertVerifyWarehousePresent(warehouseName),"ware house: "+warehouseName+" is not showing in list page");

		return this;
	}
	
	
	
	

}
