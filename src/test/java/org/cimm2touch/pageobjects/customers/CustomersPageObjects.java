package org.cimm2touch.pageobjects.customers;

import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CustomersPageObjects extends PageFactoryInitializer{
	
	// Chinna Code Begins
	Waiting waiting=new Waiting(getDriver());
	TestUtility tu= new TestUtility(getDriver());
	
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name to Search']")
	private WebElement customerSearchInputField;
	
	@FindBy(xpath="//input[contains(@value,'Search')]")
	private WebElement customerSearchButton;
	
	@FindBy(xpath="//a[@class='cimm_addNewIcon']")
	private WebElement createNewCustomerIcon;
	
	@FindBy(xpath="//input[@id='addBuyingCompanyForm:customerName']")
	private WebElement customerNameLocator;
	
	@FindBy(xpath="//input[@id='addBuyingCompanyForm:shortName']")
	private WebElement customerShortNameInputField;
	
	@FindBy(xpath="//select[@id='addBuyingCompanyForm:custTypeId']")
	private WebElement customerTypeDropDownSelector;
	
	@FindBy(xpath="//textarea[@id='addBuyingCompanyForm:address1']")
	private WebElement customerAddress1Locator;
	
	@FindBy(xpath="//textarea[@id='addBuyingCompanyForm:address1']")
	private WebElement generalCatelogAccessSelector;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement continueLocator;
	
	
	
	
	@Step("search for customer {0}")
	public CustomersPageObjects searchForCustomer(String customerName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customerSearchInputField, 30);
		customerSearchInputField.clear();
		customerSearchInputField.sendKeys(customerName);
		customerSearchButton.click();
		Thread.sleep(2500);

		return this;
	}




	@Step("verify customer {0} present or not")
	public CustomersPageObjects verifyCustomerPresent(String customerName) {
		Assert.assertTrue(assertVerifyCustomerPresent(customerName), "customer : "+customerName+" is already present, please delete to create again");

		return this;
	}




	private boolean assertVerifyCustomerPresent(String customerName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			if(getDriver().findElement(By.xpath("//tbody[@id='buyingCompanyForm:buyingCompanyTable:tb']/descendant::span[contains(text(),'"+customerName+"')]")).isDisplayed()){
				return false;
			}
		}catch(Exception e){
			return true;
		}
		return false;
	}
	@Step("create new customer")
	public CustomersPageObjects createNewCustomer(String customerName, String customerShortName, String customerType, String customerAddress1, String generalCatelogAccess) throws InterruptedException {
		clickOnCreateNewCustomerIcon();
		enterCustomerName(customerName);
		enterCustomerShortName(customerShortName);
		selectCustomerType(customerType);
		enterCustomerAddress1(customerAddress1);
		selectTheGeneralCatelogAccess(generalCatelogAccess);
		clickOnContinueLink();
		return this;
	}
	@Step("click on continue locator")
	public CustomersPageObjects clickOnContinueLink() throws InterruptedException {
		Assert.assertTrue(continueLocator.isDisplayed(),"continue locator is not displayed");
		continueLocator.click();
		Thread.sleep(3500);

		return this;
	}




	@Step("select general catelog access from the dropdown{0}")
	private CustomersPageObjects selectTheGeneralCatelogAccess(String generalCatelogAccess) {
			Assert.assertTrue(generalCatelogAccessSelector.isDisplayed(),"general catelog selctor option is not available");
			tu.selectByVisibleText(generalCatelogAccessSelector, generalCatelogAccess);


		return this;
		
	}




	@Step("enter the customer address 1 {0}data")
	public CustomersPageObjects enterCustomerAddress1(String customerAddress1) {
		Assert.assertTrue(customerAddress1Locator.isDisplayed(),"customer address 1 field is not displayed");
		customerAddress1Locator.clear();
		customerAddress1Locator.sendKeys(customerAddress1);
		return this;
	}




	@Step("select Customer Type{0}")
	public CustomersPageObjects selectCustomerType(String customerType) {
		Assert.assertTrue(customerTypeDropDownSelector.isDisplayed(), "customer type selection Option is not available");
		tu.selectByVisibleText(customerTypeDropDownSelector, customerType);

		return this;
	}




	@Step("enter customer shortName{0}")
	public CustomersPageObjects enterCustomerShortName(String customerShortName) {
		Assert.assertTrue(customerShortNameInputField.isDisplayed(),"customer short name input field is not available");
		customerShortNameInputField.clear();
		customerShortNameInputField.sendKeys(customerShortName);

		return this;
	}




	@Step("emter the customer name{0}")
	public CustomersPageObjects enterCustomerName(String customerName){
	waiting.explicitWaitVisibilityOfElement(customerNameLocator, 30);
	Assert.assertTrue(customerNameLocator.isDisplayed(),"customer name field is not displayed");
	customerNameLocator.clear();
	customerNameLocator.sendKeys(customerName);
		
		return this;
	}

	@Step("click on create new customer icon")
	public CustomersPageObjects clickOnCreateNewCustomerIcon() {
		waiting.explicitWaitVisibilityOfElement(createNewCustomerIcon, 30);
		createNewCustomerIcon.click();
		return this;
	}
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins
	
	// Rameshwar Code Ends
	
	// Vadi Code Begins
	
	// Vadi Code Ends
}
