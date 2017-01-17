package org.cimm2touch.pageobjects.products;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductsListPageObjects extends PageFactoryInitializer{


	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());

	
	@FindAll(value={@FindBy(xpath="//div[@class='breadCrumbs']/span")})
	private List<WebElement> breadCrumbsLink;
	
	@FindBy(xpath="//div[@class='topContent']/descendant::input[contains(@name,'searchKeywordId')]")
	private WebElement productSearchPlaceHolder;
	
	@FindBy(xpath="//div[@class='search list-search']/descendant::i[contains(@class,'list-search-icn')]")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@title='Remove Product']")
	private WebElement removeProductLink;
	
	@FindBy(xpath="//td[contains(text(),'testBy')]")
	private WebElement productNameColumn;
	
	@FindBy(xpath="//span[contains(text(),'Product deleted successfully')]")
	private WebElement actualSuccessfulMessageAfterDeletionOfProduct;
	
	@FindBy(xpath="(//a[contains(@title,'Preview')])[1]")
	private WebElement itemPreviewLink;
	
	@FindBy(xpath="//input[@title='delink Item']")
	private WebElement delinkItemLink;
	
	@FindBy(xpath="//div[contains(@class,'centerPanelRightIcons')]/select")
	private WebElement selectRecordsDropdownInProductsLocator;
	
	@FindAll(value={@FindBy(xpath="//input[@title='Edit Product']")})
	private List<WebElement> editButtonsLocator; 
	
	@FindBy(xpath="//span[@id='listProductForm:noResults']")
	private WebElement removeCreatedProductSuccessMessageLocator;
	
	@Step("verify the breadcrumbs of the Products page is {0}")
	public ProductsListPageObjects verifyTheProductsPageBreadCrumbs(String breadcrumpsList[]) {

		waiting.explicitWaitVisibilityOfElements(breadCrumbsLink, 15);	 
		for(int i=0;i<breadCrumbsLink.size();i++)
			 Assert.assertEquals(breadCrumbsLink.get(i).getText().trim(),breadcrumpsList[i].trim());
			 return this;
	}
	
	@Step("enter the product number in search field {0}")
	public ProductsListPageObjects enterTheProductNameInSearchField(String productName) {

		waiting.explicitWaitVisibilityOfElement(productSearchPlaceHolder, 45);
		productSearchPlaceHolder.clear();
		productSearchPlaceHolder.sendKeys(productName);
		return this;
	}
	@Step("click on search buton in products page")
	public ProductsListPageObjects clickOnSearchButton() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(searchButton, 45);
		searchButton.click();
		
		return this;
	}
	
	@Step("Click on delete icon for the product group name {0}")
	public ProductsListPageObjects clickOnRemoveProduct(String productName) throws Exception {
		Thread.sleep(2500);
		

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//td[contains(text(),'"+productName+"')]/preceding-sibling::td/descendant::input[@title='Remove Product']")));
		
		return this;
	}
		
	@Step("accept the alert popup to remove")
	public ProductsListPageObjects acceptAlert() {

		waiting.explicitWaitForAlert(15);
		tu.alertAccept();
		return this;
		
	}
	@Step(" verify the Successful {0} message after deleting the product")
	public ProductsListPageObjects verifySuccessfulMessageAfterDeletion(String expectedSuccessfulMessageAfterDeletionOfProduct) {

		waiting.explicitWaitVisibilityOfElement(actualSuccessfulMessageAfterDeletionOfProduct, 15);
		Assert.assertEquals(actualSuccessfulMessageAfterDeletionOfProduct.getText(), expectedSuccessfulMessageAfterDeletionOfProduct);
		//System.out.println(actualSuccessfulMessageAfterDeletionOfProduct.getText());
		return this;
	}
	
	@Step("verify the {0} product")
	public ProductsListPageObjects searchForCreatedProduct(String productName) throws InterruptedException {

		Thread.sleep(3000);
		Assert.assertFalse(assertVerifyProduct(productName),"Product : "+productName+"is not available, Please create it to perform delete");
		
		return this;
	}
	@Step("verify the {0} product")
	public ProductsListPageObjects verifyProductPresent(String productName) throws InterruptedException {

		Assert.assertTrue(assertVerifyProduct(productName),"Product product not present");
		
		return this;
	}
	private boolean assertVerifyProduct(String productName)
	{
		try{
			waiting.explicitWaitVisibilityOfElement(By.xpath("//tbody[@id='listProductForm:productTableID:tb']/descendant::td[contains(text(),'"+productName+"')]"), 30);
			if(getDriver().findElement(By.xpath("//tbody[@id='listProductForm:productTableID:tb']/descendant::td[contains(text(),'"+productName+"')]")).isDisplayed()){
			return true;
		}
		}
		catch(NoSuchElementException e) {
		return false;

	}
		return false;
	}
	@Step("verify the alert text {0} to remove.")
	public  ProductsListPageObjects veryfyAlert() {

		waiting.explicitWaitForAlert(15);
		Alert alert = getDriver().switchTo().alert();
		alert.getText();
		return this;
		
	}
	@Step("cancel the alert to remove.")
	public ProductsListPageObjects cancelAlert() {

		waiting.explicitWaitForAlert(15);
		Alert alert = getDriver().switchTo().alert();
		alert.dismiss();
		return this;
	}

	@Step("selecting {0} number of records to display.")
	public ProductsListPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay) throws Exception{
	
	Select select = new Select(selectRecordsDropdownInProductsLocator);
	select.selectByVisibleText(selectNumberOfRecordsToDisplay);
	Thread.sleep(3000);
	return this;
	
}
@Step("verifying whether {0} is the number of records that is displayed.")
public ProductsListPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception{
	try
	{
		Thread.sleep(2800);
		Assert.assertTrue(assertForNumberOfRowsDisplayed(editButtonsLocator.size(),Integer.parseInt(getNumberOfRecordsToDisplay)));
	}
	catch(StaleElementReferenceException e)
	{

		getDriver().navigate().refresh();
		verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
	}
	return this;
}

private boolean assertForNumberOfRowsDisplayed(int editButtons, int numberOfRecordsToDisplay) {
	if(editButtons<=numberOfRecordsToDisplay)
	{
		return true;
	}
	else
	{
	return false;
	}	
}
	@Step("remove created product {0}")
	public ProductsListPageObjects removeCreatedProduct(String productName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//td[text()='"+productName+"']/preceding-sibling::td/descendant::input[@title='Remove Product']"), 50);
		getDriver().findElement(By.xpath("//td[text()='"+productName+"']/preceding-sibling::td/descendant::input[@title='Remove Product']")).click();
		waiting.explicitWaitForAlert(5);
		tu.alertAccept();
		Thread.sleep(2500);

	
	return this;
	}
	@Step("verify remove created product succeess message {0}")
	public ProductsListPageObjects verifyRemoveSuccessMessage(String expRemoveSuccessMessage) {
		waiting.explicitWaitVisibilityOfElement(removeCreatedProductSuccessMessageLocator, 50);
		Assert.assertEquals(removeCreatedProductSuccessMessageLocator.getText().trim(), expRemoveSuccessMessage.trim());
		return this;
	}
}
