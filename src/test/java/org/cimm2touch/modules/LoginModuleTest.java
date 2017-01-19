package org.cimm2touch.modules;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.ApplicationSetUpPropertyFile;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	TestUtilityMethods utility=new TestUtilityMethods(getDriver());

	

	@Features("Login Module")
	@Description("This a test case which verifies login for cimm2touch.")
	@TestCaseId("TC_LOGIN_001")
	@Test(groups="regression")
	public void login() {

		landingPage()
		.loginToCimm2Touch();
	}
}

