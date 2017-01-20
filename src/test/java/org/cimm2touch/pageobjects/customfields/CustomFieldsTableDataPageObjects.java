package org.cimm2touch.pageobjects.customfields;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;

public class CustomFieldsTableDataPageObjects extends PageFactoryInitializer{
	
	// Chinna Code Begins
	Waiting waiting=new Waiting(getDriver());
	
	
	@FindBy(xpath="//td[@id='customFieldsForm:tableFieldsCfgId_lbl']")
	private WebElement tableFieldConfigureTabLocator;
	
	@FindBy(xpath="//input[@id='customFieldsForm:searchKeywordId']")
	private WebElement customTableSearchFieldLocator;
	
	@FindBy(xpath="")
	private WebElement customTableSearchButtonLocator;
	
	@Step("click on table field configure tab")
	public CustomFieldsTableDataPageObjects clickOnTableFieldConfigurationTab() {
		waiting.explicitWaitElementToBeClickable(tableFieldConfigureTabLocator, 50);
		tableFieldConfigureTabLocator.click();

		return this;
	}
	@Step("search for custom table data {0}")
	public CustomFieldsTableDataPageObjects SearchForCustomTableField(String customTableField) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customTableSearchFieldLocator, 40);
		customTableSearchFieldLocator.clear();
		customTableSearchFieldLocator.sendKeys(customTableField);
		customTableSearchButtonLocator.click();
		Thread.sleep(2500);

		return this;
	}
	@Step("verify custom table field: {0} present or not ")
	public CustomFieldsTableDataPageObjects verifyTableFieldPresent(String customTableField) {
		

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
