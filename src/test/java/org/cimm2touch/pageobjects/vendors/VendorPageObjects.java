package org.cimm2touch.pageobjects.vendors;


import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import ru.yandex.qatools.allure.annotations.Step;

public class VendorPageObjects extends PageFactoryInitializer{
		
	
	@FindBy(xpath="//input[@title='Save New Vendor']")
	private WebElement saveButton;
	
	@FindBy(xpath="//form[@id='addNewSupplierForm']/div[3]/div[16]/span")
	private WebElement errorMessageEmailRequired;
	
	@Step("clicking on Save link")
	public VendorPageObjects clickOnSave(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",saveButton);
		return this;
	}
	
	@Step("verifying Email Required Error Message {0}")
	public VendorPageObjects verifyEmailRequiredErrorMessage(String errorMessage){
		Waiting.explicitWaitVisibilityOfElement(errorMessageEmailRequired, 5);
		Assert.assertEquals(errorMessageEmailRequired.getText().trim(), errorMessage);
		return this;
	}
	
	@FindBy(xpath="(//a[contains(text(),'Vendors')])[3]")
	private static WebElement vendorbreadcrumb;
	
	@Step("check whether page is vendors page")
	public  VendorPageObjects checkVendorPage() throws Exception{
		
		TestUtility.assertElementPresent(vendorbreadcrumb);
		return this;
	}
	
	
	@FindBy(xpath="//div/div/ul/li/input")
	private static WebElement vendorsearchbox;
	
	@Step("type in vendor searchbox")
	public  VendorPageObjects typeInVendorSearch(String vendorname){
		vendorsearchbox.clear();
		vendorsearchbox.sendKeys(vendorname);
		return this;
	}
    
	@FindBy(xpath="//div/div/ul/li[2]/a/i")
	private static WebElement vendorsearchbutton;
	
	@Step("click on vendorsearch button")
	public  VendorPageObjects clickOnVendorSearchButton(String vendorname) throws InterruptedException{
		vendorsearchbutton.click();
		try 
		{ 
			Waiting.explicitWaitVisibilityOfElement(driver.findElement(By.xpath("//tr[td[3]='"+vendorname+"']")),10 );
		}
		catch(Exception e){
			System.out.println("Hi\n");
		}
		//Thread.sleep(8000);
		return this;
	}
	
	public boolean vendorSearchResultHelp(String vendorname) throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//tr[td[3]='"+vendorname+"']")).isDisplayed())
			{
			return false;
			}
			}
		catch(NoSuchElementException e) {
			return true;
		   
		}
		return false;		    
	}
	
	public VendorPageObjects vendorSearchResult(String vendorname) throws Exception
	{
		Assert.assertTrue(vendorSearchResultHelp(vendorname),"Vendor is Present. Please delete for creating again.");
		return this;
			    
	}
    
	@FindBy(id="addNewSupplierForm:supplierName")
	private static WebElement vendornamefield;
	
	@Step("type in vendorname")
	public VendorPageObjects typeInVendorName(String vendorname){
		vendornamefield.clear();
		vendornamefield.sendKeys(vendorname);
		return this;
	}
	
	@FindBy(id="addNewSupplierForm:shortName")
	private static WebElement vendorshortnamefield;
	
	@Step("type in vendor short name")
	public  VendorPageObjects typeInVendorshortname(String vendorshortname){
		vendorshortnamefield.clear();
		vendorshortnamefield.sendKeys(vendorshortname);
		
		return this;
	}
	
	@FindBy(id="addNewSupplierForm:address1")
	private static WebElement vendoraddressfield;
	
	@Step("type in vendor address")
	public  VendorPageObjects typeInVendorAddress(String vendoraddress){
		vendoraddressfield.clear();
		vendoraddressfield.sendKeys(vendoraddress);
		return this;
	}
	
	@FindBy(id="addNewSupplierForm:email")
	private static WebElement vendoremailaddressfield;
	
	@Step("type in vendor email address")
	public  VendorPageObjects typeInVendorEmailAddress(String vendoremailaddress){
		vendoremailaddressfield.clear();
		vendoremailaddressfield.sendKeys(vendoremailaddress);
		return this;
	}
    
	@FindBy(id="addNewSupplierForm:subsetId")
	private static WebElement vendorsubsetdropdown;
	
	@Step("select vendor subset")
	public  VendorPageObjects selectVendorSubset(String subsetname){
		new Select(vendorsubsetdropdown).selectByVisibleText(subsetname);
		return this;
	}
    
	@FindBy(xpath="//input[@title='Save New Vendor']")
	private static WebElement vendorsavebutton;
	
	@Step("click on vendor save")
	public  VendorPageObjects vendorSave() throws InterruptedException{
		vendorsavebutton.click();
		Thread.sleep(3000);
		return this;
	}
    
	@FindBy(id="addNewSupplierForm:supplierSaveMsgId")
	private static WebElement vendorsavemsgloc;
	
	@Step("verify vendor save message")
	public  VendorPageObjects checkVendorSavemessg(String vendorsavemsg){
		 Assert.assertEquals(vendorsavemsgloc.getText(), vendorsavemsg);
		return this;
	}

}