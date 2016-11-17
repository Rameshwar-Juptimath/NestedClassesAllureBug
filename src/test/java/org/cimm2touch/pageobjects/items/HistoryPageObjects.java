package org.cimm2touch.pageobjects.items;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.testng.Assert;

public class HistoryPageObjects extends PageFactoryInitializer
{

	public boolean assertPageTitle(String expectedHistoryPageTitle) throws Exception 
	{
		TestUtility utility = new TestUtility(getDriver());
		boolean t = getDriver().getTitle().replace(" ", "").trim().equals(expectedHistoryPageTitle.replace(" ", "").trim());
		utility.closeCurrentTab();
		Thread.sleep(2000);
		//utility.switchBackToFirstWindow();
		return t;
	}
	
	public HistoryPageObjects verifyPageTitle(String expectedHistoryPageTitle) throws Exception
	{
		Assert.assertTrue(assertPageTitle(expectedHistoryPageTitle),"Actual Title : "+getDriver().getTitle().trim()+" but expecting "+expectedHistoryPageTitle);
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
	
}