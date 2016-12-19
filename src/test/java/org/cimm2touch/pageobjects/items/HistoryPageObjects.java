package org.cimm2touch.pageobjects.items;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.testng.Assert;

public class HistoryPageObjects extends PageFactoryInitializer
{
	TestUtilityMethods tu= new TestUtilityMethods(getDriver());
	public boolean assertPageTitle(String expectedHistoryPageTitle) throws Exception 
	{
		
		boolean t = getDriver().getTitle().replace(" ", "").trim().equals(expectedHistoryPageTitle.replace(" ", "").trim());
		Thread.sleep(2000);
	
		return t;
	}
	
	public HistoryPageObjects verifyPageTitle(String expectedHistoryPageTitle) throws Exception
	{
		tu.switchToRecentWindow(1);
		
		Assert.assertTrue(assertPageTitle(expectedHistoryPageTitle),"Actual Title : "+getDriver().getTitle().trim()+" but expecting "+expectedHistoryPageTitle);
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
	
}