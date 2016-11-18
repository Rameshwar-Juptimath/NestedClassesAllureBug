package org.cimm2touch.pageobjects.userconfiguration;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.Waiting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UserConfigurationPageObjects extends PageFactoryInitializer{
		
	Waiting waiting=new Waiting(getDriver());
	
	@FindBy(xpath="//div[contains(text(),'Session Timeout')]/following-sibling::div[contains(.,'In Minutes') ]/table")
	private WebElement sessionTimeoutDropDown;

	public UserConfigurationPageObjects verifySessionTimeOutDropDown() {
		waiting.explicitWaitVisibilityOfElement(sessionTimeoutDropDown, 10);
		Assert.assertTrue(sessionTimeoutDropDown.isDisplayed(),"session time out dropdown is not available");
		return this;
		
	}

	public UserConfigurationPageObjects verifyTheTimeRange() {
		waiting.explicitWaitVisibilityOfElement(sessionTimeoutDropDown, 15);
		System.out.println(sessionTimeoutDropDown.getText());
		
		
		
		return this;
		
	}

}
