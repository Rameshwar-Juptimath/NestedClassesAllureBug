package org.cimm2touch.pageobjects.customfields;

import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.taxonomymanagement.ManageTaxonomyPageObjects;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.jayway.restassured.specification.Argument;

import ru.yandex.qatools.allure.annotations.Step;

public class CustomFieldsSimpleDataPageObjects extends PageFactoryInitializer{
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	
	
	@FindBy(xpath="//input[@id='customFieldsForm:searchKeywordId']")
	private WebElement customSimpleSearchField;
	
	
	@FindBy(xpath="//input[@id='addNewCustomFieldFormId:cfNmId']")
	private WebElement customFieldNameLoactor;
	
	@FindBy(xpath="//textarea[@id='addNewCustomFieldFormId:customFieldDescId']")
	private WebElement customFieldDescriptionLoactor;
	
	
	@FindBy(xpath="//select[@id='addNewCustomFieldFormId:cfDataTypeId']")
	private WebElement customFieldDataTypeLoactor;
	
	
	@FindBy(xpath="//select[@id='addNewCustomFieldFormId:cfUITypeId']")
	private WebElement customFieldUITypeLoactor;
	
	
	@FindBy(xpath="//select[@id='addNewCustomFieldFormId:cfVlId']")
	private WebElement listNameLoactor;
	
	@FindBy(xpath="//form[@name='addNewCustomFieldFormId']/descendant::div[contains(text(),'Data Entity')]/following-sibling::div/descendant::select")
	private WebElement dataEntiryTypeLoactor;
	
	@FindBy(xpath="//form[@name='addNewCustomFieldFormId']/descendant::input[@title='Save New Custom Field']")
	private WebElement savenewCustomFieldLocator;
	
	
	@FindBy(xpath="//a[@id='customFieldsForm:goBtn']/i")
	private WebElement customSimpleGoButton;
	
	@FindBy(xpath="//a[@title='Add New Custom Field']")
	private WebElement addNewCustomFieldLocator;

	
	@Step("search for simple data{0}")
	public CustomFieldsSimpleDataPageObjects searchForSimpleData(String simpleCreatedData) {
		waiting.explicitWaitVisibilityOfElement(customSimpleSearchField, 50);
		customSimpleSearchField.clear();
		customSimpleSearchField.sendKeys(simpleCreatedData);
		customSimpleGoButton.click();
		return this;		
	}

	@Step("verify custom simple data{0} present or not")
	public CustomFieldsSimpleDataPageObjects verifySimpleDataCreated(String simpleCreatedData) throws InterruptedException {
		Thread.sleep(2500);
		Assert.assertFalse(assertVerifySimpleDataPresent(simpleCreatedData),"created  simple data :"+simpleCreatedData+" is not available");

		return this;
	}
	@Step("verify custom simple data{0} present or not")
	public CustomFieldsSimpleDataPageObjects verifySimpleDataPresent(String simpleCreatedData) throws InterruptedException {
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifySimpleDataPresent(simpleCreatedData),"simple data :"+simpleCreatedData+" is already present, please remove to create it again.");

		return this;
	}

	private boolean assertVerifySimpleDataPresent(String simpleCreatedData) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			if(getDriver().findElement(By.xpath("//tbody[@id='customFieldsForm:customFieldsListTable:tb']/descendant::td[contains(text(),'"+simpleCreatedData+"')]")).isDisplayed())
			{
				return false;
			}
		}catch(NoSuchElementException e){
			return true;
		}

		return false;
	}
	@Step("click on add new custom field link")
	public CustomFieldsSimpleDataPageObjects clickOnAddNewCustomField() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(addNewCustomFieldLocator, 40);
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", addNewCustomFieldLocator);
		addNewCustomFieldLocator.click();
		Thread.sleep(2500);

		return this;
	}
	@Step("enter all the mandatory fields{0}{1}{2}{3}{4}{5}{6}")
	public CustomFieldsSimpleDataPageObjects enterAllTheMandatoryFields(String customFieldName, String customFieldDescription,
			String customFieldDataType, String customFieldUIType,String listName,String dataEntiryType) {
	
		enterCustomFieldName(customFieldName);
		enterCustomFieldDescription(customFieldDescription);
		selectCustomFieldDataType(customFieldDataType);
		selectCustomFieldUiType(customFieldUIType);
		selectValueListName(listName);
		selectDataEntityType(dataEntiryType);
		
		
		
		return this;
	}
	@Step("select dataEntiryType {0}")
	public CustomFieldsSimpleDataPageObjects selectDataEntityType(String dataEntiryType) {
		waiting.explicitWaitVisibilityOfElement(dataEntiryTypeLoactor, 30);
		tu.selectByVisibleText(dataEntiryTypeLoactor, dataEntiryType);

		return this;
		
	}
	@Step("select list name{0}")
	public CustomFieldsSimpleDataPageObjects selectValueListName(String listName) {
		waiting.explicitWaitVisibilityOfElement(listNameLoactor, 30);
		tu.selectByVisibleText(listNameLoactor, listName);
		return this;
		
	}
	@Step("select customFieldUIType {0}")
	public CustomFieldsSimpleDataPageObjects selectCustomFieldUiType(String customFieldUIType) {
		waiting.explicitWaitVisibilityOfElement(customFieldUITypeLoactor, 30);
		tu.selectByVisibleText(customFieldUITypeLoactor, customFieldUIType);
		return this;
		
	}
	@Step("select customFieldDataType{0}")
	public CustomFieldsSimpleDataPageObjects selectCustomFieldDataType(String customFieldDataType) {
		waiting.explicitWaitVisibilityOfElement(customFieldDataTypeLoactor, 30);
		tu.selectByVisibleText(customFieldDataTypeLoactor, customFieldDataType);
		return this;
		
	}
	@Step("enter customFieldDescription {0}")
	public CustomFieldsSimpleDataPageObjects enterCustomFieldDescription(String customFieldDescription) {
		waiting.explicitWaitVisibilityOfElement(customFieldDescriptionLoactor, 30);
		customFieldDescriptionLoactor.clear();
		customFieldDescriptionLoactor.sendKeys(customFieldDescription);
		return this;
	}
	@Step("enter customFieldName{0}")
	public CustomFieldsSimpleDataPageObjects enterCustomFieldName(String customFieldName) {
		waiting.explicitWaitVisibilityOfElement(customFieldNameLoactor, 30);
		customFieldNameLoactor.clear();
		customFieldNameLoactor.sendKeys(customFieldName);
		return this;
		
	}
	@Step("click on save button")
	public CustomFieldsSimpleDataPageObjects clickOnSaveButton() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(savenewCustomFieldLocator, 50);
		savenewCustomFieldLocator.click();
		Thread.sleep(2500);
		return this;
		
	}
	
	
	
	
	
	
	
	

}
