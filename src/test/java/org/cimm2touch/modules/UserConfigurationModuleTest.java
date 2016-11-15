package org.cimm2touch.modules;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;

public class UserConfigurationModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data=new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp=new ApplicationSetUpPropertyFile();
	
	@Description("This method is used to Verify User Configuration Link under user options")
	@Test(groups={"regression"})
	public void TC_UCONFIG_01() throws InterruptedException{
		landingPage().enterUsername(data.getUserName()).enterPassword(data.getPassword()).clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.verifytheLinksUnderUserOptions();
		
	}
	@Description("This methos is used to Verify User Configuration Link")
	@Test(groups="regression")
	public void TC_UCONFIG_02() throws InterruptedException{
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.verifyUserUserConfigurationLink();
		
	}@Description("This methos is used to Verify session time out drop down")
	@Test(groups="regression")
	public void TC_UCONFIG_03() throws InterruptedException{
		landingPage().enterUsername(data.getUserName()).enterPassword(data.getPassword()).clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.clickOnUserConfigurationLink()
		.userConfigPage()
		.verifySessionTimeOutDropDown()
		.verifyTheTimeRange();
		
	}

}
