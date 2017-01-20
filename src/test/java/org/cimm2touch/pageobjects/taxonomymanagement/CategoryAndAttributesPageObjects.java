package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.Iterator;
import java.util.Set;


import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CategoryAndAttributesPageObjects extends PageFactoryInitializer{

	// Chinna Code Begins
	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//div[@class='sliderLeftArrow']")
	private WebElement leftsideSectionLocator;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter Category to Search')]")
	private WebElement searchFieldForCategory;
	
	@FindBy(xpath="//input[@id='editcategory:cName']")
	private WebElement categoryNameTextFieldLocator;
	
	@FindBy(xpath="//input[@id='categoryid:save']")
	private WebElement categorySaveLink;
	
	@FindBy(xpath="//span[contains(text(),'Category Updated Successfully')]")
	private WebElement actSuccessfulMesgAfterCreationCat;
	
	@FindBy(xpath="(//a[contains(@title,'Search')]/i)[2]")
	private WebElement searchButtonForCatalog;
	
	@FindBy(xpath="//span[contains(text(),'Category Updated Successfully')]")
	private WebElement actSucMessageCat;
	
	@FindBy(xpath="(//input[contains(@title,'Delete Category')])[2]")
	private WebElement removeCategoryLink;
	
	@FindBy(xpath="((//span[contains(@id,'editcategory:categoryImage3')]/ul)/li)[2]/a")
	private WebElement uploadImgLocator;
	
	@FindBy(xpath="//input[@title='History']")
	private WebElement historyLink;
	
	@FindBy(xpath="//span[contains(text(),'Following are changes made for Category ')]")
	private WebElement actCategoryHistPageName;
	
	@Step("click on Category image upload")
	public CategoryAndAttributesPageObjects clickOnImageUpload() throws InterruptedException{

		waiting.explicitWaitVisibilityOfElement(uploadImgLocator, 10);
		Thread.sleep(5000);
		uploadImgLocator.click();
		Thread.sleep(5000);
		
		return this;
	}
	
	
	@Step("click on left panel section to see Taxonomy & Categories")
	public CategoryAndAttributesPageObjects clickOnLeftPanel(){

		waiting.explicitWaitVisibilityOfElement(leftsideSectionLocator, 10);
		leftsideSectionLocator.click();
		return this;
	}
	@Step("enter the category name {0} to search")
	public CategoryAndAttributesPageObjects searchForTheCategory(String categoryName) throws InterruptedException{

		waiting.explicitWaitVisibilityOfElement(searchFieldForCategory, 10);
		searchFieldForCategory.clear();
		searchFieldForCategory.sendKeys(categoryName);
		searchButtonForCatalog.click();
		Thread.sleep(4000);
		return this;
	}
	@Step("double click on category name{0} to edit/modify")
	public CategoryAndAttributesPageObjects doubleClickOnCategoryName(String categoryName) throws InterruptedException{
		Thread.sleep(4000);

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("(//span[contains(text(),'"+categoryName+"')])[1]")));
		;	
		/*WebElement categoryname=getDriver().findElement(By.xpath("(//span[contains(text(),'"+categoryName+"')])[1]"));
		Actions action=new Actions(getDriver()).doubleClick(categoryname);

		action.build().perform();*/
		return this;
	}
	@Step("enter the category name{0} ")
	public CategoryAndAttributesPageObjects enterTheCategoryName(String categoryName){

		waiting.explicitWaitVisibilityOfElement(categoryNameTextFieldLocator, 10);

		categoryNameTextFieldLocator.clear();
		categoryNameTextFieldLocator.sendKeys(categoryName);
		
		return this;
		
	}
	@Step("click on save link.")
	public CategoryAndAttributesPageObjects clickOnSave() throws InterruptedException{

		waiting.explicitWaitVisibilityOfElement(categorySaveLink, 10);
		categorySaveLink.click();
		Thread.sleep(4000);
		
		return this;
		
	}
	@Step("verify succesful message {0} category creation.")
	public CategoryAndAttributesPageObjects verifySuccesfulMessage(String expSuccesfulMessageForCatelog) {

		waiting.explicitWaitVisibilityOfElement(actSucMessageCat, 10);
		Assert.assertEquals(actSucMessageCat.getText().trim(), expSuccesfulMessageForCatelog);
		return this;
	}
	@Step("click on remove category.")
	public CategoryAndAttributesPageObjects clickOnRemove() {

		waiting.explicitWaitVisibilityOfElement(removeCategoryLink, 10);
		removeCategoryLink.click();
		return this;
	}
	@Step("verify tha alert message while remove.")
	public CategoryAndAttributesPageObjects verifyAlertAndAccept(String expAlertText) {

		Alert alert = getDriver().switchTo().alert();
		String ActalertText=alert.getText();
		Assert.assertEquals(ActalertText.trim(), expAlertText);
		alert.dismiss();
		//TestUtility.alertAccept();
		return this;
		
	}

	@Step("click on history link.")
	public CategoryAndAttributesPageObjects clickOnHistoryLink() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(historyLink, 10);
		historyLink.click();
		tu.alertAccept();
		Thread.sleep(5000);
		
		return this;
		
	}

	@Step("verify history page.")
	public CategoryAndAttributesPageObjects verifyHistoryPage(String expPageHistory, String categoryName) {
		
		

		Set<String> set=getDriver().getWindowHandles();
		//System.out.println(set.size());
		
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();

		getDriver().switchTo().window(cId);
		waiting.explicitWaitVisibilityOfElement(actCategoryHistPageName, 10);
		Assert.assertEquals(actCategoryHistPageName.getText().trim(), expPageHistory+categoryName);
		getDriver().close();
		getDriver().switchTo().window(pId);
		
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
