package org.cimm2touch.modules;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class VendorModuleTest extends PageFactoryInitializer {


	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Test(groups="regression")
	@Features("Vendor Module")
	@Description("This a test case which verifies login for CIMM2Touch.")
	@TestCaseId("TC_Vendor_001")
	public void vendor() {
	
		/*
		 * @author:yogish.mt
		 */
		
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin()
		.homePage()
		.clickOnVendorLink()
		.vendorsPage()
		.clickOnSave()
		.verifyEmailRequiredErrorMessage(data.getVerifyEmailRequiredErrorMessage());  
	}

}

