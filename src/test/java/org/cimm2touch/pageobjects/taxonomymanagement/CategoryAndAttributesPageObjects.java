package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.Iterator;
import java.util.Set;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CategoryAndAttributesPageObjects extends PageFactoryInitializer{

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
		Waiting.explicitWaitVisibilityOfElement(uploadImgLocator, 10);
		Thread.sleep(5000);
		uploadImgLocator.click();
		Thread.sleep(5000);
		
		return this;
	}
	
	
	@Step("click on left panel section to see Taxonomy & Categories")
	public CategoryAndAttributesPageObjects clickOnLeftPanel(){
		Waiting.explicitWaitVisibilityOfElement(leftsideSectionLocator, 10);
		leftsideSectionLocator.click();
		return this;
	}
	@Step("enter the category name {0} to search")
	public CategoryAndAttributesPageObjects searchForTheCategory(String categoryName) throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(searchFieldForCategory, 10);
		searchFieldForCategory.clear();
		searchFieldForCategory.sendKeys(categoryName);
		searchButtonForCatalog.click();
		Thread.sleep(4000);
		return this;
	}
	@Step("double click on category name{0} to edit/modify")
	public CategoryAndAttributesPageObjects doubleClickOnCategoryName(String categoryName) throws InterruptedException{
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("(//span[contains(text(),'"+categoryName+"')])[1]")));
		;	
		/*WebElement categoryname=driver.findElement(By.xpath("(//span[contains(text(),'"+categoryName+"')])[1]"));
		Actions action=new Actions(driver).doubleClick(categoryname);
		action.build().perform();*/
		return this;
	}
	@Step("enter the category name{0} ")
	public CategoryAndAttributesPageObjects enterTheCategoryName(String categoryName){
		Waiting.explicitWaitVisibilityOfElement(categoryNameTextFieldLocator, 10);
		categoryNameTextFieldLocator.clear();
		categoryNameTextFieldLocator.sendKeys(categoryName);
		
		return this;
		
	}
	@Step("click on save link.")
	public CategoryAndAttributesPageObjects clickOnSave() throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(categorySaveLink, 10);
		categorySaveLink.click();
		Thread.sleep(4000);
		
		return this;
		
	}
	@Step("verify succesful message {0} category creation.")
	public CategoryAndAttributesPageObjects verifySuccesfulMessage(String expSuccesfulMessageForCatelog) {
		Waiting.explicitWaitVisibilityOfElement(actSucMessageCat, 10);
		Assert.assertEquals(actSucMessageCat.getText().trim(), expSuccesfulMessageForCatelog);
		return this;
	}
	@Step("click on remove category.")
	public CategoryAndAttributesPageObjects clickOnRemove() {
		Waiting.explicitWaitVisibilityOfElement(removeCategoryLink, 10);
		removeCategoryLink.click();
		return this;
	}
	@Step("verify tha alert message while remove.")
	public CategoryAndAttributesPageObjects verifyAlertAndAccept(String expAlertText) {
		Alert alert = driver.switchTo().alert();
		String ActalertText=alert.getText();
		Assert.assertEquals(ActalertText.trim(), expAlertText);
		alert.dismiss();
		//TestUtility.alertAccept();
		return this;
		
	}

	@Step("click on history link.")
	public CategoryAndAttributesPageObjects clickOnHistoryLink() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(historyLink, 10);
		historyLink.click();
		TestUtility.alertAccept();
		Thread.sleep(5000);
		
		return this;
		
	}

	@Step("verify history page.")
	public CategoryAndAttributesPageObjects verifyHistoryPage(String expPageHistory) {
		
		
		Set<String> set=driver.getWindowHandles();
		//System.out.println(set.size());
		
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();
		driver.switchTo().window(cId);
		Waiting.explicitWaitVisibilityOfElement(actCategoryHistPageName, 10);
		Assert.assertEquals(actCategoryHistPageName.getText().trim(), expPageHistory+data.getCategoryName());
		driver.close();
		driver.switchTo().window(pId);
		
		return this;
	}
	
	
}
