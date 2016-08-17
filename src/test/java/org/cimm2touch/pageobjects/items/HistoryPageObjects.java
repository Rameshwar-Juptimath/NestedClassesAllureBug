package org.cimm2touch.pageobjects.items;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtility;
import org.testng.Assert;

public class HistoryPageObjects extends PageFactoryInitializer{

	public boolean assertPageTitle(String expectedHistoryPageTitle) throws Exception {

		boolean t = driver.getTitle().replace(" ", "").trim().equals(expectedHistoryPageTitle.replace(" ", "").trim());
		TestUtility.closeCurrentTab();
		Thread.sleep(2000);
		TestUtility.switchBackToFirstWindow();
		return t;
	}
	
	public HistoryPageObjects verifyPageTitle(String expectedHistoryPageTitle) throws Exception {
		Assert.assertTrue(assertPageTitle(expectedHistoryPageTitle),"Actual Title : "+driver.getTitle().trim()+" but expecting "+expectedHistoryPageTitle);
		return this;
	}
	
	public HistoryPageObjects verifyAttributesHistoryPageTitle(String expectedAttributesHistoryPageTitle) throws Exception {
		Assert.assertTrue(assertPageTitle(expectedAttributesHistoryPageTitle),"Actual Title : "+driver.getTitle().trim()+" but expecting "+expectedAttributesHistoryPageTitle);
		return this;
	}
	
	public HistoryPageObjects verifyAttributeGroupHistoryPageTitle(String expectedAttributeGroupHistoryPageTitle) throws Exception {

		Assert.assertTrue(assertPageTitle(expectedAttributeGroupHistoryPageTitle),"Actual Title : "+driver.getTitle().trim()+" but expecting "+expectedAttributeGroupHistoryPageTitle);
		return this;
	}
	
}