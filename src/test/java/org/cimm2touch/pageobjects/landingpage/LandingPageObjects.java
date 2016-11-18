package org.cimm2touch.pageobjects.landingpage;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import ru.yandex.qatools.allure.annotations.Step;

public class LandingPageObjects extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(id="login:userName")
	private WebElement usernameLocator;
	
	@FindBy(id="login:password")
	private WebElement passwordLocator;
	
	@FindBy(id="login:submit")
	private WebElement loginButtonLocator;

	@FindBy(css="div.header-right > ul.cimm_boxShadow > li > div.header-right-icons > ul > li > div.loggedInUser")
	private WebElement welcomeMessageLocator;
	
	@Step("entering username {0}")
	public LandingPageObjects enterUsername(String userName){
		usernameLocator.clear();
		usernameLocator.sendKeys(userName);
		return this;
	}
	
	@Step("entering password {0}")
	public LandingPageObjects enterPassword(String password){
		passwordLocator.clear();
		passwordLocator.sendKeys(password);
		return this;
	}
	
	@Step("clicking on login")
	public HomePageObjects clickOnLogin(){
		loginButtonLocator.click();
		return new HomePageObjects();
	}

	@Step("login to cimm2v4 site with username{0}, password{1}")
	public LandingPageObjects loginToCimm2v4Site(){
		landingPage()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLogin();
		return this;
	}

}
