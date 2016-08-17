package org.cimm2touch.pageobjects.products;

import java.util.List;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductItemsPageObjects extends PageFactoryInitializer {

	@FindBy(xpath="//input[@title='Edit Item']")
	private WebElement productItemsEditItemLink;
	
	@FindBy(xpath="//input[@title='Copy Of Item']")
	private WebElement productItemsCopyItemLink;
	
	@FindAll(value={@FindBy(xpath="(//tr[@class='rich-table-subheader'])[3]//div")})
	private List<WebElement> itemsTableHeaderTitlesLink;
	
	@FindBy(xpath="//input[@id='copyOfItemFormId:partNumber']")
	private WebElement enterPartNumberTextField;
	
	@FindBy(xpath="//input[@id='copyOfItemFormId:noOfCopies']")
	private WebElement enterTheNumberOfCopiesTextField;
	
	@FindBy(xpath="//input[@title='Reset']/following-sibling::input[contains(@title,'Save')]")
	private WebElement saveIconToCopyLink;
	
	@Step("click on edit Item icon link.")
	public ProductItemsPageObjects clickOnEditItemIcon() {
		Waiting.explicitWaitVisibilityOfElement(productItemsEditItemLink, 15);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",productItemsEditItemLink);
		
		
	return this;
	}
	@Step("click on copy Item icon link.")
	public ProductItemsPageObjects clickOnCopyIcon() {
		Waiting.explicitWaitVisibilityOfElement(productItemsCopyItemLink, 15);
		productItemsCopyItemLink.click();
		return this;
	}

	@Step("Verification of  Items page title {0} .")
	public ProductItemsPageObjects verifyItemsPage(String expPageTitle) throws InterruptedException {
		
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), expPageTitle, expPageTitle+": is not found");
		//System.out.println(driver.getTitle());
		return this;
		
	}

	@Step("verification of product page header titles {0}.")

	public ProductItemsPageObjects verifyItemsTableHeaders(String expectedTableHeaders[]) {
		
		Waiting.explicitWaitVisibilityOfElements(itemsTableHeaderTitlesLink, 15);
			for(int i=0;i<itemsTableHeaderTitlesLink.size();i++){
				//System.out.println(itemsTableHeaderTitlesLink.get(i).getText().trim());
				 Assert.assertEquals(itemsTableHeaderTitlesLink.get(i).getText().trim(),expectedTableHeaders[i].trim());
				 
			}return this;
		}
	@Step("enter the item part number{0} .")
	public ProductItemsPageObjects enterPartNumber(String partNumber) {
		Waiting.explicitWaitVisibilityOfElement(enterPartNumberTextField, 15);
		enterPartNumberTextField.clear();
		enterPartNumberTextField.sendKeys(partNumber);
		
		return this;
		
	}
	
	@Step("enter the no.of copies {0}. ")
	public ProductItemsPageObjects  enterNumerOfCopies(String numberOfItemsCopy){
		
		Waiting.explicitWaitVisibilityOfElement(enterTheNumberOfCopiesTextField, 15);
		enterTheNumberOfCopiesTextField.clear();
		enterTheNumberOfCopiesTextField.sendKeys(numberOfItemsCopy);
		return this;
		
	}
	@Step("click on save icon to copy the Item")
	public ProductItemsPageObjects clickOnsaveIconFoCopiedItem() {
		Waiting.explicitWaitVisibilityOfElement(saveIconToCopyLink, 15);
		saveIconToCopyLink.click();
		return this;
	}
	
	}

