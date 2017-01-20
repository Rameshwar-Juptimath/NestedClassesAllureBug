package org.cimm2touch.pageobjects.subset;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class FeaturedProductsDispPricingPageObjects extends PageFactoryInitializer {
	
	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());
	
	
	@FindBy(xpath = "//span/descendant::a[contains(text(),'Featured Products Disp Pricing')]")
	private static WebElement featuredProductsPageLocator;
	
	@FindBy(xpath="//div[contains(text(),'Subset List For Display Pricing')]")
	private WebElement subsetListDisplayPricingLocator;
	
	@FindBy(xpath="//span[@id='displayPricingFPId:msgId']")
	private WebElement displayPriceSaveLocator;
	
	@FindBy(xpath="//input[@title='Save ' and @class='actionIcon']")
	private WebElement saveIconFeaturedProductdisplayprice;
	
	@Step("check whether page is Featured Products Disp Pricing")
	public FeaturedProductsDispPricingPageObjects checkFeaturedProductsDispPricingPage(String subsetDisplayePricing) throws Exception {
		waiting.explicitWaitVisibilityOfElement(featuredProductsPageLocator, 10);
		utility.assertElementPresent(featuredProductsPageLocator);
		waiting.explicitWaitVisibilityOfElement(subsetListDisplayPricingLocator, 10);
		Assert.assertEquals(subsetListDisplayPricingLocator.getText().trim(), subsetDisplayePricing.trim());
		Thread.sleep(2000);
		return this;
	}
	
	@Step("click on subset name checkbox:{0}")
	public FeaturedProductsDispPricingPageObjects clickSubsetCheckbox(String subsetName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,500)");
		waiting.explicitWaitVisibilityOfElement(getDriver().findElement(By.xpath("//td[text()='"+subsetName+"']/following-sibling::td/div/input[@type='checkbox']")), 10);
		WebElement featuredProductDisplayPricingCheckbox = getDriver().findElement(By.xpath("//td[text()='"+subsetName+"']/following-sibling::td/div/input[@type='checkbox']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",featuredProductDisplayPricingCheckbox);
		Thread.sleep(2000);
		return this;		
	}
	
	@Step("click on save icon")
	public FeaturedProductsDispPricingPageObjects clickOnSaveIcon() throws InterruptedException {
		
          waiting.explicitWaitVisibilityOfElement(saveIconFeaturedProductdisplayprice, 10);
          
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",saveIconFeaturedProductdisplayprice);
		Thread.sleep(4000);
		return this;
	}
	
	@Step("verify display price success message:{0}")
	public FeaturedProductsDispPricingPageObjects verifyDisplayPriceSuccessMsg(String diasplyPriceSucessMsg) {
		waiting.explicitWaitVisibilityOfElement(displayPriceSaveLocator, 10);
		Assert.assertEquals(displayPriceSaveLocator.getText().trim(), diasplyPriceSucessMsg.trim());
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
