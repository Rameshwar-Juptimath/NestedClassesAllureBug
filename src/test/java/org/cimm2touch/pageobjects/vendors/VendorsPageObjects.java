package org.cimm2touch.pageobjects.vendors;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;
/**
 * 
 * @author thiruveedhi Chinna
 *
 */
public class VendorsPageObjects extends PageFactoryInitializer
{

	
	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());
	@FindBy(xpath="//input[@id='addNewSupplierForm:supplierName']")
	private WebElement addVendor_VendorName;

	@FindBy(xpath="//input[@id='addNewSupplierForm:shortName']")
	private WebElement addVendor_ShortName;

	@FindBy(xpath="//textarea[@id='addNewSupplierForm:address1']")
	private WebElement addVendor_Address1;

	@FindBy(xpath="//input[@id='addNewSupplierForm:city']")
	private WebElement addVendor_City;

	@FindBy(xpath="//input[@id='addNewSupplierForm:state']")
	private WebElement addVendor_State;

	@FindBy(xpath="//input[@id='addNewSupplierForm:zip']")
	private WebElement addVendor_Zip;

	@FindBy(xpath="//select[@id='addNewSupplierForm:country']")
	private WebElement addVendor_Country;

	@FindBy(xpath="//input[@id='addNewSupplierForm:email']")
	private WebElement addVendor_Email;

	@FindBy(xpath="//select[@id='addNewSupplierForm:subsetId']")
	private WebElement addVendor_SubsetName;

	@FindBy(xpath="//input[@id='addNewSupplierForm:url']")
	private WebElement addVendor_URL;

	@FindBy(xpath="//input[@id='addNewSupplierForm:taxid']")
	private WebElement addVendor_TaxID;

	@FindBy(xpath="//select[@id='addNewSupplierForm:status']")
	private WebElement addVendor_Status;

	@FindBy(xpath="//input[@title='Save New Vendor']")
	private WebElement addVendor_SaveNewVendor;

	@FindBy(xpath="//input[@title='Reset']")
	private WebElement addVendor_ResetVendor;

	@FindBy(xpath="//span[@id='addNewSupplierForm:supplierSaveMsgId']")
	private WebElement addVendor_SaveMessage;

	@FindBy(xpath="//input[contains(@id,'searchKeywordId') and @placeholder='Enter Vendor Name to Search']")
	private WebElement vendors_SearchBox;

	@FindBy(xpath="//a[contains(@id,'goBtn') and @class='go']")
	private WebElement vendors_SearchIcon;

	@FindBy(xpath="//span[contains(text(),'Total Count')]/following-sibling::span")
	private WebElement vendors_TotalVendorsCount;

	@FindBy(xpath="//div[@title='Generic Column Settings']/img")
	private WebElement vendors_GenericColumnSettings;

	@FindBy(xpath="//span[@id='listSupplierForm:tnpId']")
	private WebElement pagination_TotalPagesCount;

	@FindBy(xpath="//span[@id='listSupplierForm:selectNo']")
	private WebElement pagination_CurrentPageCount;

	@FindBy(xpath=".//*[@id='listSupplierForm:nextBtnId']/i")
	private WebElement pagination_NextButton;

	@FindBy(xpath="//a[@id='listSupplierForm:lastBtnId']/i")
	private WebElement pagination_LastButton;

	@FindBy(xpath="//a[@id='listSupplierForm:prevBtnId']/i")
	private WebElement pagination_PreviousButton;

	@FindBy(xpath="//a[@id='listSupplierForm:firstBtnId']/i")
	private WebElement pagination_FirstButton;

	@FindBy(xpath="//title")
	private WebElement vendorsPageTitle;
	
	@FindBy(xpath="//select[@id='addNewSupplierForm:customerType']")
	private WebElement selectCustomerTypeLocator; 
	
	@FindBy(xpath="//select[@id='addNewSupplierForm:subsetId']")
	private WebElement selectSubsetName;
	
	
	@FindBy(xpath="//input[@title='Save New Vendor']")
	private WebElement saveVendorLocator;
	
	@FindBy(xpath="//span[@id='addNewSupplierForm:supplierSaveMsgId']")
	private WebElement successfulMessageForNewlyCreatedVendorLocator;
	
	@FindBy(xpath="//span[@id='listSupplierForm:noResults']")
	private WebElement successfulMessageRemoveVendorLocator;
	
	@FindBy(xpath="//div[@title='Generic Column Settings']/descendant::img[@class='gearIcon']")
	private WebElement genericColumnSettingIconLocator; 
	
	@FindBy(xpath="//li[@class='show-dyna-table-setting']/a")
	private WebElement showFieldsSettingLoc;
	
	@FindBy(xpath="//li[@class='show-sort-settings']/a")
	private WebElement showSortSettingLoc;
	
	@FindBy(xpath="//div[contains(text(),'Dynamic Table Settings')]")
	private WebElement dynamicTableSettingSection;
	
	@FindBy(xpath="//div[contains(text(),'Sort Order Settings')]")
	private WebElement sortOrderSettingSection;
	
	@Step("To Verify Vendors Page Items")
	public VendorsPageObjects verifyVendorsPageItems() 
	{

		waiting.explicitWaitVisibilityOfElement(vendors_SearchBox, 20);
		Assert.assertTrue(vendors_SearchBox.isDisplayed(),"Search Box is not Displayed");
		Assert.assertTrue(vendors_SearchIcon.isDisplayed(),"Search Icon is not Displayed");
		Assert.assertTrue(vendors_TotalVendorsCount.isDisplayed(),"Total Vendors Count is not Displayed");
		Assert.assertTrue(pagination_CurrentPageCount.isDisplayed(),"Current Page Count is not Displayed");
		Assert.assertTrue(pagination_TotalPagesCount.isDisplayed(),"Total Pages Count is not Displayed");
		Assert.assertTrue(pagination_NextButton.isDisplayed(),"Pagination -> Next Button is not Displayed");
		Assert.assertTrue(pagination_LastButton.isDisplayed(),"Pagination -> Last Button is not Displayed");
		Assert.assertTrue(pagination_PreviousButton.isDisplayed(),"Pagination -> Previous Button is not Displayed");
		Assert.assertTrue(pagination_FirstButton.isDisplayed(),"Pagination -> First Button is not Displayed");
		Assert.assertTrue(vendors_GenericColumnSettings.isDisplayed(),"General Column Settings is not Displayed");
		return this;
	}

	@Step("To Add new Vendor")
	public VendorsPageObjects addNewVendor(String vendorsName, String shortName, String address1, String city, String state,
			String zip, String country, String email, String subset, String url, String taxID, String status) 
	{
		addVendor_VendorName.clear();
		addVendor_VendorName.sendKeys(vendorsName);
		addVendor_ShortName.clear();
		addVendor_ShortName.sendKeys(shortName);
		addVendor_Address1.clear();
		addVendor_Address1.sendKeys(address1);
		addVendor_City.clear();
		addVendor_City.sendKeys(city);
		addVendor_State.clear();
		addVendor_State.sendKeys(state);
		addVendor_Zip.clear();
		addVendor_Zip.sendKeys(zip);

		getDriver().findElement(By.xpath("//select[@id='addNewSupplierForm:country']/option[text()='"+country+"']")).click();
		addVendor_Email.clear();
		addVendor_Email.sendKeys(email);
		getDriver().findElement(By.xpath("//select[@id='addNewSupplierForm:subsetId']/option[text()='"+subset+"']")).click();
		addVendor_URL.clear();
		addVendor_URL.sendKeys(url);
		addVendor_TaxID.clear();
		addVendor_TaxID.sendKeys(taxID);

		getDriver().findElement(By.xpath("//select[@id='addNewSupplierForm:status']/option[text()='"+status+"']")).click();
		return this;
	}

	@Step("To Add new Vendor")
	public VendorsPageObjects clickOnSaveButtonForAddNewVendors() 
	{
		addVendor_SaveNewVendor.click();
		return this;
	}

	@Step("To Verify the Message after Adding a New Vendor")
	public VendorsPageObjects verifyMessageAfterAddingNewVendor(String saveMessage) 
	{

		waiting.explicitWaitVisibilityOfElement(addVendor_SaveMessage, 15);
		assertThat(addVendor_SaveMessage.getText(), containsString(saveMessage));
		return this;
	}

	@Step("To Verify the Error Message after saving Vendor without Vendor Name ")
	public VendorsPageObjects verifyMessageAfterSavingVendorWithoutVendorName(String nameErrorMessage) throws Exception 
	{
		Thread.sleep(5000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//input[@id='addNewSupplierForm:supplierName']/following-sibling::span[contains(@style,'red')]")).isDisplayed());
		assertThat(getDriver().findElement(By.xpath("//input[@id='addNewSupplierForm:supplierName']/following-sibling::span[contains(@style,'red')]")).getText(),
				containsString(nameErrorMessage));
		return this;
	}

	@Step("To Verify the Error Message after saving Vendor without Short Name ")
	public VendorsPageObjects verifyMessageAfterSavingVendorWithoutShortName(String shortNameErrorMessage) 
	{

		assertThat(getDriver().findElement(By.xpath("//input[@id='addNewSupplierForm:shortName']/following-sibling::span[contains(@style,'red')]")).getText(),
				containsString(shortNameErrorMessage));
		return this;
	}

	@Step("To Verify the Error Message after saving Vendor without Address")
	public VendorsPageObjects verifyMessageAfterSavingVendorWithoutAddress1(String address1ErrorMessage) 
	{

		assertThat(getDriver().findElement(By.xpath("//textarea[@id='addNewSupplierForm:address1']/following-sibling::span[contains(@style,'red')]")).getText(),
				containsString(address1ErrorMessage));
		return this;
	}

	@Step("To Verify the Error Message after saving Vendor without E-Mail ID")
	public VendorsPageObjects verifyMessageAfterSavingVendorWithoutEmail(String emailErrorMessage) 
	{

		assertThat(getDriver().findElement(By.xpath("//input[@id='addNewSupplierForm:email']/following-sibling::span[contains(@style,'red')]")).getText(),
				containsString(emailErrorMessage));
		return this;
	}

	@Step("To Verify the Character Limit for Vendors Name Field")
	public VendorsPageObjects verifyCharacterLimitForVendorsNameField() 
	{
		addVendor_VendorName.click();
		addVendor_VendorName.sendKeys(RandomStringUtils.randomAlphabetic(150));
		String enteredText=addVendor_VendorName.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_VendorName.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for Short Name Field")
	public VendorsPageObjects verifyCharacterLimitForShortNameField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_ShortName.click();
		addVendor_ShortName.sendKeys(RandomStringUtils.randomAlphabetic(50));
		String enteredText=addVendor_ShortName.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_ShortName.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for Address 1 Field")
	public VendorsPageObjects verifyCharacterLimitForAddress1Field() throws Exception
	{
		Thread.sleep(5000);
		addVendor_Address1.click();
		addVendor_Address1.sendKeys(RandomStringUtils.randomAlphabetic(550));
		String enteredText=addVendor_Address1.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, 500);
		return this;
	}

	@Step("To Verify the Character Limit for EMail Field")
	public VendorsPageObjects verifyCharacterLimitForEmailAddressField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_Email.click();
		addVendor_Email.sendKeys(RandomStringUtils.randomAlphabetic(150));
		String enteredText=addVendor_Email.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_Email.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for City Field")
	public VendorsPageObjects verifyCharacterLimitForCityField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_City.click();
		addVendor_City.sendKeys(RandomStringUtils.randomAlphabetic(150));
		String enteredText=addVendor_City.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_City.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for State Field")
	public VendorsPageObjects verifyCharacterLimitForStateField() throws Exception
	{
		Thread.sleep(5000);
		addVendor_State.click();
		addVendor_State.sendKeys(RandomStringUtils.randomAlphabetic(100));
		String enteredText=addVendor_State.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_State.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for ZIP Field")
	public VendorsPageObjects verifyCharacterLimitForZipField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_Zip.click();
		addVendor_Zip.sendKeys(RandomStringUtils.randomAlphabetic(100));
		String enteredText=addVendor_Zip.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_Zip.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for URL Field")
	public VendorsPageObjects verifyCharacterLimitForURLField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_URL.click();
		addVendor_URL.sendKeys(RandomStringUtils.randomAlphabetic(450));
		String enteredText=addVendor_URL.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_URL.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for TAXID Field")
	public VendorsPageObjects verifyCharacterLimitForTaxIDField() throws Exception 
	{
		Thread.sleep(5000);
		addVendor_TaxID.click();
		addVendor_TaxID.sendKeys(RandomStringUtils.randomAlphabetic(100));
		String enteredText=addVendor_TaxID.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addVendor_TaxID.getAttribute("maxlength")));
		return this;
	}

	@Step("To Click On Reset Button")
	public VendorsPageObjects clickOnResetButton() throws Exception 
	{
		Thread.sleep(2000);
		addVendor_ResetVendor.click();
		return this;
	}

	@Step("To Verify the TextFields after clicking on Reset Button")
	public VendorsPageObjects verifyFieldsAfterResetButtonIsPressed() throws Exception 
	{
		Thread.sleep(3000);
		assertThat(addVendor_VendorName.getAttribute("value"), isEmptyString());
		assertThat(addVendor_ShortName.getAttribute("value"), isEmptyString());
		assertThat(addVendor_Address1.getAttribute("value"), isEmptyString());
		assertThat(addVendor_City.getAttribute("value"), isEmptyString());
		assertThat(addVendor_State.getAttribute("value"), isEmptyString());
		assertThat(addVendor_Zip.getAttribute("value"), isEmptyString());
		assertThat(addVendor_Email.getAttribute("value"), isEmptyString());
		assertThat(addVendor_TaxID.getAttribute("value"), isEmptyString());
		assertThat(addVendor_URL.getAttribute("value"), isEmptyString());
		return this;
	}

	@Step("To Search for an Vendor")
	public VendorsPageObjects searchForAnVendor(String vendorsName) 
	{
		vendors_SearchBox.click();
		vendors_SearchBox.sendKeys(vendorsName);
		vendors_SearchIcon.click();
		return this;
	}

	@Step("To Verify the TextFields after clicking on Reset Button")
	public VendorsPageObjects verifySearchResultForVendors(String vendorsName) throws Exception 
	{
		Thread.sleep(5000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//table[@id='listSupplierForm:listSupplierTableId']/descendant::td[contains(.,'"+vendorsName+"')]")).isDisplayed());
		return this;
	}

	@Step("To Click on Specific Vendors Name {0}")
	public VendorsPageObjects clickOnEditVendors(String vendorsName)
	{

		getDriver().findElement(By.xpath("//table[@id='listSupplierForm:listSupplierTableId']/descendant::td[contains(.,'"+vendorsName+"')]/preceding::input[@title='Edit Vendor']")).click();
		return this;
	}

	@Step("To Click on Previous Page Option and Verify the Functionality.")
	public VendorsPageObjects verifytheWorkingOfThePreviousPageOption() throws Exception 
	{
		Thread.sleep(5000);
		pagination_NextButton.click();
		Thread.sleep(5000);
		int currentPageNumber1 =  Integer.parseInt(pagination_CurrentPageCount.getText());
	
		pagination_PreviousButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 =  Integer.parseInt(pagination_CurrentPageCount.getText());
		
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;		
	}

	@Step("To Click on Next Page Option and Verify the Functionality.")
	public VendorsPageObjects verifytheWorkingOfTheNextPageOption() throws Exception 
	{
		Thread.sleep(5000);
		int currentPageNumber1 = Integer.parseInt(pagination_CurrentPageCount.getText());
		pagination_NextButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 = Integer.parseInt(pagination_CurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on Last Page Option and Verify the Functionality.")
	public VendorsPageObjects verifytheWorkingOfTheLastPageOption() throws Exception
	{
		int totalPagesCount = Integer.parseInt(pagination_CurrentPageCount.getText());

		Actions action = new Actions(getDriver());
		action.click(pagination_LastButton).build().perform();
		pagination_LastButton.click();
		Thread.sleep(5000);
		int currentPageNumber =  Integer.parseInt(pagination_CurrentPageCount.getText());
		Assert.assertEquals(totalPagesCount, currentPageNumber);
		return this;
	}

	@Step("To Click on First Page Option and Verify the Functionality.")
	public VendorsPageObjects verifytheWorkingOfTheFirstPageOption() throws Exception
	{

		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",pagination_NextButton);
		Thread.sleep(5000);
		int currentPageNumber1 =  Integer.parseInt(pagination_CurrentPageCount.getText());
		pagination_FirstButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 =  Integer.parseInt(pagination_CurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}
	
	@Step("To Click on 'NoOfItems Dropdown' and verify contents dispalyed.")
	public VendorsPageObjects verifyDisplayNoOfItemsDropdown() throws Exception
	{

		getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select/option[@value='25']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select"))).getFirstSelectedOption().getText(), "25");
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select/option[@value='50']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select"))).getFirstSelectedOption().getText(), "50");
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select/option[@value='75']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select"))).getFirstSelectedOption().getText(), "75");
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select/option[@value='100']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select"))).getFirstSelectedOption().getText(), "100");
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select/option[@value='10']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(getDriver().findElement(By.xpath("//div[@class='centerPanelRightIcons ']/select"))).getFirstSelectedOption().getText(), "10");
		Thread.sleep(5000);
		return this;
	}
	@Step("verify vendor's page title {0}")
	public VendorsPageObjects checkVendorPage(String title) throws InterruptedException {
		Thread.sleep(3000);

		Assert.assertEquals(getDriver().getTitle(), title.trim());
		return this;
	}
	@Step("enter vendor name: {0}")
	public VendorsPageObjects typeVendorNameInSearch(String vendorName) {


			waiting.explicitWaitVisibilityOfElement(vendors_SearchBox, 10);
			vendors_SearchBox.sendKeys(vendorName);
			vendors_SearchIcon.click();
		
		return this;
		
	}
	
	public boolean vendorSearchResultHelp(String vendorName) throws Exception
	{

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getDriver().findElement(By.xpath("//tbody[@id='listSupplierForm:listSupplierTableId:tb']/tr/descendant::td[contains(text(),'"+vendorName+"')]")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e) {
			return true;

		}
		return false;		    
	}@Step("verify vendor search results: {0}")
	public VendorsPageObjects verifyVendorBeforeRemove(String vendorName) throws Exception {
		
		Assert.assertFalse(vendorSearchResultHelp(vendorName),"vendor is not available, please create before remove.");

		
		return this;
	}
	
	@Step("verify vendor search results: {0}")
	public VendorsPageObjects verifyVendorSearchResults(String vendorName) throws Exception {
		
		Assert.assertTrue(vendorSearchResultHelp(vendorName),"vendor is Present. Please delete for creating again.");

		
		return this;
	}
	@Step("enter the vendor name as {0}")
	public VendorsPageObjects typeInVendorName(String vendorName) {

		waiting.explicitWaitVisibilityOfElement(addVendor_VendorName, 10);
		addVendor_VendorName.clear();
		addVendor_VendorName.sendKeys(vendorName);
		return this;
	}
	@Step("enter vendor short name : {0}")
	public VendorsPageObjects typeInVendorshortname(String vendorshortname) {

		waiting.explicitWaitVisibilityOfElement(addVendor_ShortName, 10);
		addVendor_ShortName.clear();
		addVendor_ShortName.sendKeys(vendorshortname);
		
		return this;
	}
	@Step("select customer type {0}")
	public VendorsPageObjects selectCustomerType(String customerType) {
		

		waiting.explicitWaitVisibilityOfElement(selectCustomerTypeLocator, 20);
		
		new Select(selectCustomerTypeLocator).selectByVisibleText(customerType);
		
		return this;
	}
	@Step("enter vendor address {0}")
	public VendorsPageObjects typeInVendorAddress(String vendorAddress) {

		waiting.explicitWaitVisibilityOfElement(addVendor_Address1, 10);
		addVendor_Address1.clear();
		addVendor_Address1.sendKeys(vendorAddress);
		
		return this;
	}
	@Step("enter vendor email addres as : {0}")
	public VendorsPageObjects typeInVendorEmailAddress(String vendorEmailAddress) {

		waiting.explicitWaitVisibilityOfElement(addVendor_Email, 10);
		addVendor_Email.clear();
		addVendor_Email.sendKeys(vendorEmailAddress);
		return this;
	}
	@Step("select vendor subseet {0}")
	public VendorsPageObjects selectVendorSubset(String subsetname) {
		new Select(selectSubsetName).selectByVisibleText(subsetname);
		return this;
	}
	@Step("save the vendor details")
	public VendorsPageObjects vendorSave() {
		saveVendorLocator.click();
		return this;
	}
	@Step("verify  newly created vendor success message: {0}")
	public VendorsPageObjects checkCreatedVendorSaveMessage(String vendorSavemessage) {

		waiting.explicitWaitVisibilityOfElement(successfulMessageForNewlyCreatedVendorLocator, 10);
		
		Assert.assertEquals(successfulMessageForNewlyCreatedVendorLocator.getText(), vendorSavemessage);

		return this;
	}
	@Step("verify and remove the {0} vendor ")
	public VendorsPageObjects verifyAndRemoveVendore(String vendorName) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'Vendor Name')]/ancestor::table/descendant::td[contains(text(),'"+vendorName+"')]"), 30);
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'Vendor Name')]/ancestor::table/descendant::td[contains(text(),'"+vendorName+"')]")).isDisplayed(),"Vendor :"+vendorName+" is not available.");
		WebElement wb=getDriver().findElement(By.xpath("//span[contains(text(),'Vendor Name')]/ancestor::table/descendant::td[contains(text(),'"+vendorName+"')]/preceding-sibling::td/descendant::input[@title='Remove Vendor']"));
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",wb);
		tu.alertAccept();
		return this;
		
	}

	public VendorsPageObjects verifySuccessMessageForRemove(String vendorName) {

		waiting.explicitWaitVisibilityOfElement(successfulMessageRemoveVendorLocator, 30);
		Assert.assertEquals(successfulMessageRemoveVendorLocator.getText(), "Vendor : '"+vendorName+"' removed Successfully");

		return this;
	}

	@Step("to check the required checkboxes in {0} for desktop view")
	public VendorsPageObjects clickOnGenricColumnSetting(String genericColumnSetting) throws Exception {

		waiting.explicitWaitVisibilityOfElement(genericColumnSettingIconLocator, 10);
		Assert.assertTrue(genericColumnSettingIconLocator.isDisplayed(), "generic column setting is not available ");
		genericColumnSettingIconLocator.click();
		switch(genericColumnSetting)
		{

			case "Show fields": waiting.explicitWaitVisibilityOfElement(showFieldsSettingLoc, 5);
								Assert.assertTrue(showFieldsSettingLoc.isDisplayed(),"Show fields table setting option is not available");
								showFieldsSettingLoc.click();
				break;
				

			case "Sort Order":	 waiting.explicitWaitVisibilityOfElement(showSortSettingLoc, 5);
								Assert.assertTrue(showSortSettingLoc.isDisplayed(),"Sort order setting option is not available");
								showSortSettingLoc.click();
			break;
			default: throw new Exception("invalid selection for dynamic table setting");
		}
		return this;
	}

	public VendorsPageObjects verifyGenericColumnSettingTable(String genericColumnSettingType) throws Exception {
		
		switch(genericColumnSettingType)
		{

		case "Show fields" :	waiting.explicitWaitVisibilityOfElement(dynamicTableSettingSection, 5);
								Assert.assertTrue(dynamicTableSettingSection.isDisplayed(), "dynamic table setting table is not available");
		break;
		
		case "Sort Order" :	waiting.explicitWaitVisibilityOfElement(sortOrderSettingSection, 5);
							Assert.assertTrue(sortOrderSettingSection.isDisplayed(), "sort order setting section is not displayed.");
		break;
		
		default: throw new Exception("invalid selection for dynamic table setting");
		}
		return this;
	}

	public VendorsPageObjects setTheShowFieldsForDesktopView(String requiredfields) throws Exception {
		String[] fields=requiredfields.split(",");
		Thread.sleep(2500);
		for(int i=0;i<fields.length;i++) {
		
		

				//Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='"+fields[i]+"']/ancestor::td/following-sibling::td/descendant::label/input[contains(@name,'ITMSLCT1')]/following-sibling::span")).isDisplayed(),"Manufacturer part number field is not available");
	
			Assert.assertTrue(getDriver().findElement(By.xpath("//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='"+fields[i]+"']")).isDisplayed(),fields[i]+" -> not available");
			
					WebElement wb1=getDriver().findElement(By.xpath("//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='"+fields[i]+"']/following-sibling::td[1]/label/span"));
					
					WebElement wb2=getDriver().findElement(By.xpath("//tr/th/div[text()='Field Names']/../../../../tbody/tr/td[span='"+fields[i]+"']/following-sibling::td[1]/label/input"));
					if(!(wb2.isSelected()))
					{
						wb1.click();
						Thread.sleep(1000);
					}		
	}

		getDriver().findElement(By.xpath("//div[contains(text(),'Dynamic Table Settings')]/following-sibling::div/descendant::input[contains(@title,'Save')]")).click();
	
		return this;
	}

	public VendorsPageObjects verifyVendorsPageWithRequiredFields(String requiredfields) throws InterruptedException {
		String[] fields=requiredfields.split(",");
		Thread.sleep(3000);
		for(int i=0; i<fields.length; i++)
		{

		Assert.assertTrue(getDriver().findElement(By.xpath("//thead[@class='rich-table-thead']/descendant::*[text()='"+fields[i]+"']")).isDisplayed());
		}
		
		return this;
	}

}