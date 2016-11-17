package org.cimm2touch.pageobjects.products;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ProductEditPageObjects extends PageFactoryInitializer{
	Waiting waiting=new Waiting(getDriver());
	
	@FindBy(xpath="(//input[@title='Edit Product'])[1]")
	private WebElement editProductIcon;
	
	@FindBy(xpath="//td[contains(text(),'Item List')]")
	private WebElement itemsListTab;
	
	
	@FindBy(xpath="(//table[@id='col1 tbid1']/tbody/tr/td)[1]")
	private WebElement sourceElement;
	
	@FindBy(xpath="//th/span[text()='Action']") 
	private WebElement destinationElement;
	
	@FindBy(xpath="//input[@title='Save Items To Product ']")
	private WebElement saveItemsToProductLink;
	
	@FindBy(xpath="//span[contains(text(),'Assigned Items Saved Successfully')]")
	private WebElement actualSuccesMessageItemAssignedToProduct;
	
	@Step("click on edit icon.")
	public ProductEditPageObjects clickOnEditIcon() {
		waiting.explicitWaitVisibilityOfElement(editProductIcon, 15);
		editProductIcon.click();
		return this;
	}
	@Step("Click on items list tab.")
	public ProductEditPageObjects clickOnItemsListTab() {
		waiting.explicitWaitVisibilityOfElement(itemsListTab, 15);
		itemsListTab.click();
		return this;
	}
	@Step("declaration for drag and drop operation.")
	public void elementHighlight(WebElement element) {
		  for (int i = 0; i < 2; i++) {
		   JavascriptExecutor js = (JavascriptExecutor) getDriver();
		   js.executeScript(
		     "arguments[0].setAttribute('style', arguments[1]);",
		     element, "color: red; border: 3px solid red;");
		   js.executeScript(
		     "arguments[0].setAttribute('style', arguments[1]);",
		     element, "");
		  }
		 }
	@Step("performing drad and drop")
	public ProductEditPageObjects dragAndDropTheItemsToProduct() throws Exception {
	
		waiting.explicitWaitVisibilityOfElement(sourceElement, 15);
			  
			  Actions builder = new Actions(getDriver());
			  
			  elementHighlight(sourceElement);
			  builder.clickAndHold(sourceElement).build().perform();
			  Thread.sleep(2000);
			  elementHighlight(destinationElement);
			  builder.moveToElement(destinationElement, 0, 0).build().perform();
			  builder.moveToElement(destinationElement, 0, 5).build().perform();
			  builder.moveToElement(destinationElement, 0, 10).build().perform();
			  builder.moveToElement(destinationElement, 0, 11).build().perform();
			  builder.moveToElement(destinationElement, 0, 12).build().perform();
			  builder.moveToElement(destinationElement, 0, 13).build().perform();
			  builder.moveToElement(destinationElement, 0, 14).build().perform();
			  builder.moveToElement(destinationElement, 0, 25).build().perform();
			  
			  Thread.sleep(1000);
			 builder.release().build().perform();
			  Thread.sleep(4000);
		
		/*waiting.explicitWaitVisibilityOfElement(sourceElement, 15);
		new Actions(getDriver()).dragAndDrop(sourceElement, destinationElement).build().perform();
		Thread.sleep(6000);
		
		Actions builder1 = new Actions(getDriver());
		Action dragAndDrop = builder1.clickAndHold(sourceElement) 
		.moveToElement(destinationElement)
		.release(destinationElement)
		.build(); // Get the action
		dragAndDrop.perform();
		Thread.sleep(6000);
		
		*/
		
		
		/*WebElement src = getDriver().findElement(By.xpath("(//div[contains(@class,'draggable')])[1]"));
		WebElement target  = getDriver().findElement(By.xpath("(//div[contains(@class,'dropTargetPanel')])[1]"));
		new Actions(getDriver()).dragAndDrop(src, target).build().perform();
		Thread.sleep(6000);*/
		
		
		
		/*Actions action = new Actions(getDriver());  // Configure the Action
		action.clickAndHold(sourceElement);
		  Thread.sleep(5000);
		  action.moveToElement(destinationElement);
		  Thread.sleep(8000);
		  action.release(destinationElement);
		  Thread.sleep(6000);
		  action .build().perform();  // Get the action
		  Thread.sleep(6000);*/
		
		
		
		/*Actions action = new Actions(getDriver());
		
		try {
			waiting.explicitWaitVisibilityOfElement(sourceElement, 15);
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(getDriver());
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
					System.out.println("Element was not displayed to drag");
					}
			} catch (Exception e) {
				System.out.println("Error occurred while performing drag and drop operation for items"+ e.getStackTrace());
		}*/
		return this;
	}
	@Step("click on save button.")
	public ProductEditPageObjects clickOnSaveButton() {
		waiting.explicitWaitVisibilityOfElement(saveItemsToProductLink, 15);
		saveItemsToProductLink.click();
		waiting.explicitWaitVisibilityOfElement(actualSuccesMessageItemAssignedToProduct, 10);
		//System.out.println(actualSuccesMessageItemAssignedToProduct.getText());
		return this;
	}
	@Step("verify Successful {0} message after item assigned to products..")
	public ProductEditPageObjects verifySuccesfulMessageAfterItemAssign(String productName) {
		
		Assert.assertEquals(actualSuccesMessageItemAssignedToProduct.getText().trim(), "Assigned Items Saved Successfully to Product "+productName);
		return this;
	}
	
	
}
