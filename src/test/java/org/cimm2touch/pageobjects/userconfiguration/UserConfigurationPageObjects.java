package org.cimm2touch.pageobjects.userconfiguration;

import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UserConfigurationPageObjects {
	
	@FindBy(xpath="//div[contains(text(),'Session Timeout')]/following-sibling::div[contains(.,'In Minutes') ]/table")
	private WebElement sessionTimeoutDropDown;

	public UserConfigurationPageObjects verifySessionTimeOutDropDown() {
		Waiting.explicitWaitVisibilityOfElement(sessionTimeoutDropDown, 10);
		Assert.assertTrue(sessionTimeoutDropDown.isDisplayed(),"session time out dropdown is not available");
		return this;
		
	}

	public UserConfigurationPageObjects verifyTheTimeRange() {
		Waiting.FluentWaitForVisibilityOfElement(30, 5, sessionTimeoutDropDown);
		System.out.println(sessionTimeoutDropDown.getText());
		
		
		
		return this;
		
	}

}
