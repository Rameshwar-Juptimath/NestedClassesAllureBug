package org.cimm2touch.pageobjects.landingpage;

import java.util.HashMap;

import org.cimm2touch.dataprovider.SearchData;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * 
 * @author thiruveedhi.chinna
 *
 */
public class LandingPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	HashMap<String, String> loginData;

	@Factory(dataProvider = "loginTestData", dataProviderClass = SearchData.class)
	public LandingPageObjects(String userName, String password, String welcomMessage) {
		loginData = new HashMap<String, String>();
		loginData.put("userName", userName);
		loginData.put("password", password);
		loginData.put("welcomeMessage", welcomMessage);
	}

	public LandingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login:userName")
	private WebElement usernameLocator;

	@FindBy(id = "login:password")
	private WebElement passwordLocator;

	@FindBy(id = "login:submit")
	private WebElement loginButtonLocator;

	@FindBy(css = "div.header-right > ul.cimm_boxShadow > li > div.header-right-icons > ul > li > div.loggedInUser")
	private WebElement welcomeMessageLocator;

	@Step("Enter username as \'{0}\'")
	public LandingPageObjects enterUsername(String userName) {
		//getDriver().findElement(By.xpath("//input[@id='menuFmId:headerForm:searchKeywordId']")).sendKeys("1234");
		usernameLocator.clear();
		usernameLocator.sendKeys(userName);
		return this;
	}

	@Step("Enter password \'{0}\'")
	public LandingPageObjects enterPassword(String password) {
		passwordLocator.clear();
		passwordLocator.sendKeys(password);
		return this;
	}

	@Step("Click on login")
	public HomePageObjects clickOnLogin() {
		loginButtonLocator.click();
		return homePage();
	}

	@Step("login to cimm2touch site with username{0}, password{1}")
	public LandingPageObjects loginToCimm2Touch() {

		enterUsername(loginData.get("userName"));
		enterPassword(loginData.get("password"));
		clickOnLogin();
		return this;
	}
	
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins
	
	// Rameshwar Code Ends
	
	// Vadi Code Begins
	
	// Vadi Code Ends

}
