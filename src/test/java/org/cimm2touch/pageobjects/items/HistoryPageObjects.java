package org.cimm2touch.pageobjects.items;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class HistoryPageObjects extends PageFactoryInitializer
{
	TestUtilityMethods tu= new TestUtilityMethods(getDriver());
	Waiting waiting=new Waiting(getDriver());
	public boolean assertPageTitle(String expectedHistoryPageTitle) throws Exception 
	{
		
		boolean t = getDriver().getTitle().replace(" ", "").trim().equals(expectedHistoryPageTitle.replace(" ", "").trim());
		Thread.sleep(2000);
	
		return t;
	}
	
	public HistoryPageObjects verifyPageTitle(String expectedHistoryPageTitle) throws Exception
	{
		
		Thread.sleep(2000);
		Assert.assertEquals(getDriver().getTitle().trim(),expectedHistoryPageTitle,"Actual Title : "+getDriver().getTitle().trim()+" but expecting "+expectedHistoryPageTitle);
		getDriver().close();
		tu.switchBackToFirstWindow();
		
	
		return this;
	}
	
	public HistoryPageObjects verifyAttributesHistoryPageTitle(String expectedAttributesHistoryPageTitle) throws Exception {

		Assert.assertTrue(assertPageTitle(expectedAttributesHistoryPageTitle),"Actual Title : "+getDriver().getTitle().trim()+" but expecting "+expectedAttributesHistoryPageTitle);
		return this;
	}
	
	public HistoryPageObjects verifyAttributeGroupHistoryPageTitle(String expectedAttributeGroupHistoryPageTitle) throws Exception {


		Assert.assertTrue(assertPageTitle(expectedAttributeGroupHistoryPageTitle),"Actual Title : "+getDriver().getTitle().trim()+" but expecting "+expectedAttributeGroupHistoryPageTitle);
		return this;
	}
	@Step("verify recent activty on warehouse {0}")
	public HistoryPageObjects verifyrecentWareHouseActivity(String warehouseName) throws InterruptedException {
		Thread.sleep(3000);
		//waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'"+warehouseName+"')]"), 30);
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'"+warehouseName+"')]")).isDisplayed(),"recent activity was not shown in warehouse history page");

		return this;
	}
	
}