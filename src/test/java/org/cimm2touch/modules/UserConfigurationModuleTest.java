package org.cimm2touch.modules;

import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;

public class UserConfigurationModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data=new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp=new ApplicationSetUpPropertyFile();
HashMap<String, String> loginData;
	
	
	@Factory(dataProvider="loginTestData", dataProviderClass=SearchData.class)
	public UserConfigurationModuleTest(String userName, String password, String welcomMessage){
		loginData=new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}
	@Description("This method is used to Verify User Configuration Link under user options")
	@Test(groups={"regression"})
	public void TC_UCONFIG_01() throws InterruptedException{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.verifytheLinksUnderUserOptions();
		
	}
	@Description("This methos is used to Verify User Configuration Link")
	@Test(groups="regression")
	public void TC_UCONFIG_02() throws InterruptedException{
		landingPage()
		.enterUsername(loginData.get("userName"))
		.enterPassword(loginData.get("password"))
		.clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.verifyUserUserConfigurationLink();
		
	}@Description("This methos is used to Verify session time out drop down")
	@Test(groups="regression")
	public void TC_UCONFIG_03() throws InterruptedException{
		landingPage().enterUsername(loginData.get("userName")).enterPassword(loginData.get("password")).clickOnLogin()
		.homePage()
		.clickOnUserOptionsIcon()
		.clickOnUserConfigurationLink()
		.userConfigPage()
		.verifySessionTimeOutDropDown()
		.verifyTheTimeRange();
		
	}

}
