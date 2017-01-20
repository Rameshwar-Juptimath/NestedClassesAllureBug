package org.cimm2touch.pageobjects.products;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class AddNewProductPageObjects extends PageFactoryInitializer{


	// Chinna Code Begins
	Waiting waiting= new Waiting(getDriver());
	@FindBy(id="newProductForm:productNameId")
	private WebElement productNameTextField;
	
	@FindBy(id="newProductForm:productNumberId")

	private WebElement productNumberTextField;	
	
	@FindBy(xpath="//input[@title='Save New Product']")
	private WebElement clickOnSaveButtonLink;
	
	@FindBy(xpath="//span[@id='newProductForm:prodSavemsg']")
	private WebElement succesfulMessageTextForNewProductCreation;
	
	
	@Step("enter product name {0}")
	public AddNewProductPageObjects enterTheProductName(String productName) {

		waiting.explicitWaitVisibilityOfElement(productNameTextField, 15);
		productNameTextField.sendKeys(productName);
		return this;
	}
	@Step("enter the product number {0}")
	public AddNewProductPageObjects enterTheProductNumber(String productNumber) {

		waiting.explicitWaitVisibilityOfElement(productNumberTextField, 15);
		productNumberTextField.sendKeys(productNumber);
		return this;
	}
	@Step(" click on save button")
	public AddNewProductPageObjects clickOnSaveButton() {

		waiting.explicitWaitVisibilityOfElement(clickOnSaveButtonLink, 15);
		clickOnSaveButtonLink.click();
		return this;
		
	}
	@Step("verify the successful message after creation of new product {0}")
	public ProductsListPageObjects verifySuccesfulMessageAfterCreationOfNewProduct(String expectedSuccesfulMessageForNewProductCreation){

		waiting.explicitWaitVisibilityOfElement(succesfulMessageTextForNewProductCreation, 15);

		//System.out.println(succesfulMessageTextForNewProductCreation.getText());
		Assert.assertEquals(succesfulMessageTextForNewProductCreation.getText(), expectedSuccesfulMessageForNewProductCreation);
		return new ProductsListPageObjects();
	}
	
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins
	
	// Rameshwar Code Ends
	
	// Vadi Code Begins
	
	// Vadi Code Ends
	
}
