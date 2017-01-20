package org.cimm2touch.pageobjects.manufacturer;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManufacturerBrandPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());

	@FindBy(xpath = "//span[contains(@class,'breadCrumb')]/span/span/a[contains(text(),'Manufacturers & Brands')]")
	private static WebElement manufacturerbrandtextLocator;

	@Step("assert element present manufacturerbrandtextLocator ")
	public ManufacturerBrandPageObjects assrtManufacturerbrandtextLocator() throws Exception {

		utility.assertElementPresent(manufacturerbrandtextLocator);
		return this;
	}

	@FindBy(xpath = "//span[contains(@class,'breadCrumb')]/span/span/a[contains(text(),'Manufacturers & Brands')]")
	private WebElement asmanufacturerbrandtextLocator;

	@Step("assert element present manufacturerbrandtextLocator ")
	public ManufacturerBrandPageObjects assrtasManufacturerbrandtextLocatornp() throws Exception {
		// Thread.sleep(2500);

		utility.assertElementPresent(asmanufacturerbrandtextLocator);
		return this;
	}

	@FindBy(xpath = "//div/div/ul/li/input")
	private WebElement manufacturerbrandsearchfield;

	@Step("type in manufacturerbrandsearchfield")
	public ManufacturerBrandPageObjects typeonMBsearch(String manufacturername) {
		manufacturerbrandsearchfield.sendKeys(manufacturername);
		return this;
	}

	@FindBy(xpath = "//div/div/ul/li[2]/a/i")
	private WebElement manufacturerbrandsearchbutton;

	@Step("click on manufacturer search button")
	public ManufacturerBrandPageObjects clickonMBsearch() throws InterruptedException {
		manufacturerbrandsearchbutton.click();
		Thread.sleep(3000);
		return this;
	}

	public boolean manufacturerSearchResultHelp(String manufacturername) throws Exception {

		String count = "count(//form/table/thead/tr/th/div/span[text()='Manufacturer Name']/../../preceding-sibling::*)+1";
		System.out.println("count is" + count);
		try {

			if (getDriver()
					.findElement(By.xpath(
							"//form/table/tbody/tr[td[" + count + "]='" + manufacturername + "']/td[" + count + "]"))
					.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;

		}
		return false;
	}

	public ManufacturerBrandPageObjects manufacturerSearchResult(String manufacturername) throws Exception {

		Assert.assertTrue(manufacturerSearchResultHelp(manufacturername),
				"Manufacturer is Present. Please delete for creating again.");
		return this;

	}

	@FindBy(xpath = "//form/div/ul/li[3]/a")
	private WebElement createmanufacturerbutton;

	@Step("click on createmanufacturer button")
	public ManufacturerBrandPageObjects clickonmanufacturerbutton() {
		createmanufacturerbutton.click();
		return this;
	}

	@FindBy(id = "addNewManufacturerForm:manfName")
	private WebElement manufacturernamefield;

	@Step("type in manufacturer name field")
	public ManufacturerBrandPageObjects typeinmanufield(String manufacturername) throws InterruptedException {
		manufacturernamefield.sendKeys(manufacturername);
		return this;
	}

	@FindBy(id = "addNewManufacturerForm:manfCode")
	private WebElement manufacturecodefield;

	@Step("type in manufacturer code field")
	public ManufacturerBrandPageObjects typeinmanucodefield(String manufacturercode) throws InterruptedException {
		manufacturecodefield.sendKeys(manufacturercode);
		return this;
	}

	@FindBy(xpath = "//form[@id='addNewManufacturerForm']/div[4]/div[7]/input")
	private WebElement newmanufacturecheckbox;

	@Step("check new manufacture checkbox")
	public ManufacturerBrandPageObjects checkmanufactureractive() {
		newmanufacturecheckbox.click();
		return this;
	}

	@FindBy(xpath = "//form[@id='addNewManufacturerForm']/div[4]/div[9]/input")
	private WebElement newmanufacturersave;

	@Step("click on manufacturer save button")
	public ManufacturerBrandPageObjects clickonmanufacturersave() {
		newmanufacturersave.click();
		return this;
	}

	@FindBy(id = "listManufacturerForm:saveMsgId")
	private WebElement manufacturermessagesaveph;

	@Step("verify manufacturer save message")
	public ManufacturerBrandPageObjects verifymessage(String message) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(manufacturermessagesaveph, 10);
		Assert.assertEquals(manufacturermessagesaveph.getText().trim(), message);
		return this;
	}

	@FindBy(xpath = "//form/table/tbody/tr[1]/td[3]")
	private WebElement manufacturersearchres;

	@Step("check whether searched result is desired manufactuer")
	public ManufacturerBrandPageObjects checkManufacturerAlreadyExist(String manufacturername) {
		Assert.assertEquals(manufacturersearchres.getText(), manufacturername);
		return this;
	}

	@FindBy(xpath = "//form/table/tbody/tr/td[4]/a")
	private WebElement brandList;

	@Step("click on brand list icon under manufacturer")
	public ManufacturerBrandPageObjects clickOnlisticon() throws Exception {
		brandList.click();
		// Thread.sleep(4000);

		utility.waitforElementPresent("//th/div[contains(text(),'Brand Name')]", 10);
		return this;
	}

	public boolean isBrandpresentHelp(String brandname) throws Exception {

		try {

			if (getDriver().findElement(By.xpath("//td[contains(text(),'" + brandname + "')]")).isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;

		}
		return false;
	}

	@Step("check whether brand is already created")
	public ManufacturerBrandPageObjects isBrandpresent(String brandname) throws Exception {
		Assert.assertTrue(isBrandpresentHelp(brandname), "Brand is Present Already. Please delete to create.");
		return this;

	}

	@FindBy(xpath = "//form/table/tbody/tr[2]/td/span/a[@title='Add New Brand']")
	private WebElement addnewbrandbutton;

	@Step("click on add new brand button")
	public ManufacturerBrandPageObjects clickOnaddnewbrandbutton() throws Exception {
		addnewbrandbutton.click();

		// tu.waitforElementPresent("//form/div[contains(text(),'Add New
		// Brand')]", 10);
		Thread.sleep(4000);

		return this;
	}

	@FindBy(xpath = "//form[@id='addBrandForm']/div")
	private WebElement addnewbrandform;

	@Step("check whether add new brand form got enabled")
	public ManufacturerBrandPageObjects checkBrandFormEnabled() {
		Assert.assertEquals(addnewbrandform.getText(), "Add New Brand");
		return this;
	}

	@FindBy(id = "addBrandForm:manufacturerListComboId")
	private WebElement manufacturerdropdown; // manufactuer drop down under Add
												// new Brand form

	@Step("select manufactuer from dropdown")
	public ManufacturerBrandPageObjects selectmanufacturerfromdropdown(String manufacturername) {
		new Select(manufacturerdropdown).selectByVisibleText(manufacturername);
		return this;
	}

	@FindBy(id = "addBrandForm:brandId")
	private WebElement brandnamefield;

	@Step("type in brandname")
	public ManufacturerBrandPageObjects typeinbrandname(String brandname) {
		brandnamefield.clear();
		brandnamefield.sendKeys(brandname);
		return this;
	}

	@FindBy(id = "addBrandForm:bDesc")
	private WebElement branddescfield;

	@Step("type in brand desc field")
	public ManufacturerBrandPageObjects typeinBrandDescField(String branddesc) {
		branddescfield.clear();
		branddescfield.sendKeys(branddesc);
		return this;
	}

	@FindBy(xpath = "//input[@id='addBrandForm:statusBooleanId']")
	private WebElement brandactivecheckbox;

	@Step("check on brandactive checkbox")
	public ManufacturerBrandPageObjects checkOnBrandActive() {
		if (!(brandactivecheckbox).isSelected()) {
			brandactivecheckbox.click();
		}
		return this;
	}

	@FindBy(xpath = "//input[@id='addBrandForm:itemsStatusId:0']")
	private WebElement itemactivecheckbox;

	@Step("check on itemactivecheckbox")
	public ManufacturerBrandPageObjects checkOnItemActive() {
		if (!(itemactivecheckbox).isSelected()) {
			itemactivecheckbox.click();
		}
		return this;
	}

	@FindBy(xpath = "//form[@id='addBrandForm']/div[4]/div[15]/input")
	private WebElement brandsavebutton;

	@Step("click on brand save button")
	public ManufacturerBrandPageObjects clickonbrandsave() throws InterruptedException {
		brandsavebutton.click();
		// Thread.sleep(6000);
		return this;
	}

	@FindBy(id = "addBrandForm:saveMsgBrandId")
	private WebElement brandsavemsgloc;

	@Step("check brand is saved succesfully")
	public ManufacturerBrandPageObjects checkBrandSaveMessage(String brandsavemsg) throws Exception {

		utility.waitforElementPresent(
				"//*[@id='addBrandForm:saveMsgBrandId' and contains(text(),'" + brandsavemsg + "')]", 10);
		Assert.assertEquals(brandsavemsgloc.getText(), brandsavemsg);
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
