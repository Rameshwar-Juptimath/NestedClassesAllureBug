package org.cimm2touch.pageobjects.subset;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class SubsetItemsPageObjects extends PageFactoryInitializer {

	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());

	@FindBy(xpath = "//span/descendant::a[contains(text(),'Subset Items')]")
	private static WebElement subsetItem;

	@Step("check whether page is subset page Item")
	public SubsetItemsPageObjects checkSubsetPageItem() throws Exception {

		waiting.explicitWaitVisibilityOfElement(subsetItem, 20);

		utility.assertElementPresent(subsetItem);
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath = "//input[@id='listSubsetItems:subsetCombocomboboxField']")
	private static WebElement dropDownLocator;

	/*@FindBy(xpath = "//input[@id='listSubsetItems:subsetCombocomboboxButton']")
	private static WebElement dropDownClickLocator;*/

	public SubsetItemsPageObjects selectSubset(String subsetName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(dropDownLocator, 10);
		dropDownLocator.clear();
		dropDownLocator.sendKeys(subsetName);
		
		//Thread.sleep(4000);
		waiting.explicitWaitVisibilityOfElement(getDriver()
				.findElement(By.xpath("//div[@id='listSubsetItems:subsetCombolistDecoration']/descendant::span[text()='"
						+ subsetName + "']")),
				10);

		WebElement selectedItem = getDriver()
				.findElement(By.xpath("//div[@id='listSubsetItems:subsetCombolistDecoration']/descendant::span[text()='"
						+ subsetName + "']"));

		
		selectedItem.click();
		Thread.sleep(7000);
		return this;

	}

	@FindBy(xpath = "//input[@id='searchFormId:subsetBtn']")
	private static WebElement searchButtonLocator;

	public SubsetItemsPageObjects clickOnSearchButtonOfSubsetItem() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(searchButtonLocator, 20);
		searchButtonLocator.click();
		//((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchButtonLocator);
		Thread.sleep(7000);
		System.out.println("enter inside the click On Search ButtonOfSubsetItem");
		return this;

	}

	public SubsetItemsPageObjects verifyNumberOfItem(String totalNoOfItem) {
		waiting.explicitWaitVisibilityOfElement(getDriver()
				.findElement(By.xpath("//span[contains(text(),'Total no. of Items : ')]/following-sibling::span")), 20);
		WebElement numberOfItemPresent = getDriver()
				.findElement(By.xpath("//span[contains(text(),'Total no. of Items : ')]/following-sibling::span"));
		System.out.println(numberOfItemPresent.getText());
		Assert.assertEquals(numberOfItemPresent.getText(), totalNoOfItem);
		return this;

	}

	@FindBy(xpath = "//select[@id='searchFormId:searchInId']")
	private static WebElement searchDropDownLocator;;

	public SubsetItemsPageObjects verifyFieldsFromDropDown(String dropDownFields) throws InterruptedException {

		String[] dropDownFields1 = dropDownFields.split(",");
         waiting.explicitWaitVisibilityOfElement(searchDropDownLocator, 10);
         
		Select sel = new Select(searchDropDownLocator);
		
		List<WebElement> lst = sel.getOptions();
		
		for (int i = 0; i < lst.size(); i++) {
			
			Assert.assertEquals(lst.get(i).getText().trim(), dropDownFields1[i].trim());
		}

		return this;
	}

	public SubsetItemsPageObjects selectParticularItemBasedOnTheDropDownField(String particularFieldName) throws InterruptedException {
		  waiting.explicitWaitVisibilityOfElement(searchDropDownLocator, 10);
		Select sel = new Select(searchDropDownLocator);
		//sel.deselectByVisibleText(particularFieldName);
		sel.selectByVisibleText(particularFieldName);
		Thread.sleep(2000);
		return this;
		
	}
	
	@FindBy(xpath = "//input[@id='searchFormId:searchKeywordId']")
	private static WebElement searchItemLocator;;


	public SubsetItemsPageObjects enterParticularNumberOfItem(String itemNumber) {
		waiting.explicitWaitVisibilityOfElement(searchItemLocator, 20);
		
		searchItemLocator.clear();
		searchItemLocator.sendKeys(itemNumber);
		return this;		
	}

	public SubsetItemsPageObjects verifyNumberOfItemAfterSearched(String itemNumber) {
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath("//tbody[@id='searchFormId:subsetItemTableId:tb']/descendant::td[text()='"+itemNumber+"']")), 10);
		WebElement itemNumberA = getDriver().findElement(By.xpath("//tbody[@id='searchFormId:subsetItemTableId:tb']/descendant::td[text()='"+itemNumber+"']"));
		Assert.assertEquals(itemNumberA.getText(), itemNumber, "Item number doesn't match");
		return this;		
	}

	
}
