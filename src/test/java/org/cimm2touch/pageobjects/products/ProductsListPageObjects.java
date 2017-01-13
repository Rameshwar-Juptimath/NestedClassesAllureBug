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

}
