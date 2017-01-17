package org.cimm2touch.pageobjects.managelists;

import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManageListsPageObjets extends PageFactoryInitializer{
	
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	
	@FindBy(xpath="//input[@id='valueListInfo:searchKeywordId']")
	private WebElement manageListSearchInputField;
	
	@FindBy(xpath="//a[@id='valueListInfo:goBtn']/i")
	private WebElement manageListSearchButtonLocator;
	
	@FindBy(xpath="//a[@title='New Value List']")
	private WebElement addNewValueListLocator;
	
	@FindBy(xpath="//input[@id='addNewValueListFormId:vlnId']")
	private WebElement manageValueListNameLocator;
	
	@FindBy(xpath="//textarea[@id='addNewValueListFormId:valueListDescId']")
	private WebElement manageValueListDescriptionLocator;
	
	@FindBy(xpath="//form[@name='addNewValueListFormId']/descendant::div[contains(text(),'Value List Description')]/preceding-sibling::div/select")
	private WebElement selectValueListDataType;
	
	@FindBy(xpath="//form[@name='addNewValueListFormId']/descendant::div[contains(text(),'Value List Description')]/following-sibling::div/descendant::input[@title='Save New Value List']")
	private WebElement saveManageValueLIstLocator;
	
	@FindBy(xpath="//span[contains(@id,'valueListForm:savmsg')]")
	private WebElement successMessageForSaveNewValueList;
	
	@Step("search for manage list presents {0}")
	public ManageListsPageObjets searchForManageList(String manageListName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(manageListSearchInputField, 50);
		manageListSearchInputField.clear();
		manageListSearchInputField.sendKeys(manageListName);
		manageListSearchButtonLocator.click();
		Thread.sleep(2500);

		return this;
	}

	@Step("verify manage list present or not")
	public ManageListsPageObjets verifyManageListPresent(String manageListName) 
	{
		
		Assert.assertTrue(assertVerifymanageListPresent(manageListName),"manage list :"+manageListName+" is already present please delete before create.");
		
		return this;
	}

	private boolean assertVerifymanageListPresent(String manageListName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			if(getDriver().findElement(By.xpath("//tbody[@id='valueListForm:valueListTable:tb']/descendant::td[contains(text(),'"+manageListName+"')]")).isDisplayed())
			{
				return false;
			}
		}catch(NoSuchElementException e){
			return true;
		}
		return false;
	}
	@Step("click on add new value list locator")
	public ManageListsPageObjets clickOnAddNewManageList() {
		waiting.explicitWaitVisibilityOfElement(addNewValueListLocator, 50);
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()", addNewValueListLocator);
		

		return this;
	}
	@Step("create new value list")
	public ManageListsPageObjets createNewValueList(String manageListName, String valueListDataType, String valueListDescription) {
		enterValueListName(manageListName);
		selectValueListType(valueListDataType);
		enterValueListDescription(valueListDescription);
		clickonSaveNewValueList();
		
		return this;
	}
	@Step("click on save new value list")
	public ManageListsPageObjets clickonSaveNewValueList() {
		waiting.explicitWaitVisibilityOfElement(saveManageValueLIstLocator, 50);
		saveManageValueLIstLocator.click();

		return this;
	}

	@Step("enter the manage value list description {0}")
	public ManageListsPageObjets enterValueListDescription(String valueListDescription) {
		waiting.explicitWaitVisibilityOfElement(manageValueListDescriptionLocator, 50);
		manageValueListDescriptionLocator.clear();
		manageValueListDescriptionLocator.sendKeys(valueListDescription);
		return this;
		
	}
	@Step("select value list type {0} from the dropdown")
	public ManageListsPageObjets selectValueListType(String valueListDataType) {
		waiting.explicitWaitVisibilityOfElement(selectValueListDataType, 50);
		
		tu.selectByVisibleText(selectValueListDataType, valueListDataType);
		

		return this;
		
	}
	@Step("enter the manage value list name{0}")
	public ManageListsPageObjets enterValueListName(String manageListName) {
		waiting.explicitWaitVisibilityOfElement(manageValueListNameLocator, 50);
		manageValueListNameLocator.clear();
		manageValueListNameLocator.sendKeys(manageListName);

		return this;
		
	}
	@Step("verify success message {0} for save new value list")
	public ManageListsPageObjets verifySuccessMessageForNewlyCreatedList(String successMessage) {
		waiting.explicitWaitVisibilityOfElement(successMessageForSaveNewValueList, 50);
		Assert.assertEquals(successMessageForSaveNewValueList.getText().trim(), successMessage.trim());

		return this;
	}

}
