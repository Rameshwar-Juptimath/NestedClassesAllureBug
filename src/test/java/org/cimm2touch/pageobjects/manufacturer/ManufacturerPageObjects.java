package org.cimm2touch.pageobjects.manufacturer;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManufacturerPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//div[@class='float-right']/input[@title='Save New Manufacturer']")
	private WebElement saveButtonLocator;

	@FindBy(xpath="//div[@class='topNav_rightIcons']/ul/li[3]/a")
	private WebElement addNewManufacturerButtonLocator;

	@FindBy(xpath="//span[@id='addNewManufacturerForm:hmsgId']")
	private WebElement manufacturerUnsuccessfullMessageLocator;

	@FindBy(xpath="//input[@id='addNewManufacturerForm:manfName']")
	private WebElement manufacturerNewNameLocator;

	@FindBy(xpath="//span[@id='listManufacturerForm:saveMsgId']")
	private WebElement verifySuccessMessageNewManuCreationLocator;

	@FindBy(xpath="//div[@class='list-search']/ul/li/input[1]")
	private WebElement enterCreatedManufacturerToDeleteLocator;

	@FindBy(xpath="//i[@class='list-search-icn fa fa-search']")
	private WebElement clickOnSearchManufacturerListLocator;

	@FindBy(xpath="//tr[@class='rich-table-row rich-table-firstrow']/td/div/input[2]")
	private WebElement clickOnDeleteManufacturerButtonLocator;

	@FindBy(xpath="//span[@id='listManufacturerForm:noResults']")
	private WebElement verifyManufacturerDeletionLocator;

	@FindBy(xpath="//span[@id='listManufacturerForm:selectNo']")
	private WebElement verifyZeroManufacturersFoundLocator;

	@FindBy(xpath="//span[contains(text(),'Total Count')]/following-sibling::span")
	private WebElement totalCountValueLocator;

	@FindBy(xpath="//input[@id='listManufacturerForm:pageNumId']")
	private WebElement storeThePageNumberLocator;

	@FindBy(xpath="//a[@id='listManufacturerForm:nextBtnId']/i")
	private WebElement clickOnNextButtonLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:lastBtnId']/i")
	private WebElement clickOnLastButtonLocator;


	@FindBy(xpath=".//*[@id='listManufacturerForm:tnpId']")
	private WebElement storeTotalNumberOfPagesLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:firstBtnId']/i")
	private WebElement clickOnFirstButtonLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:prevBtnId']/i")
	private WebElement clickOnPreviousButtonLocator;

	@FindBy(xpath=".//*[@id='addNewManufacturerForm:btnReset']")
	private WebElement clickOnResetButtonLocator;

	@FindBy(xpath=".//*[@id='addNewManufacturerForm:manfCode']")
	private WebElement manufacturerCodeLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:manufacturerTableId:ACTION']")
	private WebElement clickOnActionLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:manufacturerTableId:SL']")
	private WebElement clickOnSiLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:manufacturerTableId:SL']")
	private WebElement clickOnManufacturerNameLocator;

	@FindBy(xpath=".//*[@id='listManufacturerForm:manufacturerTableId']/thead/tr/th[4]")
	private WebElement clickOnNumberofBrandsLocator;

	@FindBy(xpath="//div[@class='setting-icon']/img")
	private WebElement clickOnGenericColumnnSettingsLocator;

	@FindBy(xpath="//li[@class='show-dyna-table-setting']/a")
	private WebElement verifyShowFieldsTextLocator;


	@FindBy(xpath="//li[@class='show-sort-settings']/a")
	private WebElement verifySortOrderTextLocator;
	
	@FindBy(xpath="//span[contains(@class,'breadCrumb')]/span/span/a[contains(text(),'Manufacturers & Brands')]")
	private static WebElement manufacturerbrandtextLocator;

	
	@FindBy(xpath="//div/div/ul/li/input")
	private WebElement manufacturerbrandsearchfield;
	

	@FindBy(xpath="//div/div/ul/li[2]/a/i")
	private WebElement manufacturerbrandsearchbutton;
	
	

	@FindBy(xpath="//table[@id='listManufacturerForm:manufacturerTableId']/tbody/tr[1]/td[3]")
	private WebElement manufacturersearchres;

	
	@FindBy(xpath="//form/table/tbody/tr/td[4]/a")
	private WebElement brandList;

	@FindBy(xpath="//form[@id='listManufacturerForm']//div[1]//div[1]//div[@class='box-header']")
	private WebElement verifyDynamicSettingsFieldLocator;

	@FindBy(xpath="//div[contains(text(),'Field Names')]")
	private WebElement verifyFieldNamesFieldLocator;

	@FindBy(xpath="//div[contains(text(),'Desktop View')]")
	private WebElement verifyDesktopViewFieldLocator;

	@FindBy(xpath="//div[contains(text(),'Mobile View')]")
	private WebElement verifyMobileViewFieldLocator;

	@FindBy(xpath="//div[contains(text(),'Tablet View')]")
	private WebElement verifyTabletViewFieldLocator;

	@FindBy(xpath="//div[contains(text(),'Display Names')]")
	private WebElement verifyDisplayNamesFieldLocator;


	@FindBy(xpath="//input[@id='addNewManufacturerForm:manfName']")
	private WebElement verifyEmptyFieldAfterResetLocator;

	@FindBy(xpath="//div[@class='custom-col-settings']/table/tbody//tr[td//text()[contains(.,'Manufacturer Logo')]]/td[2]/label/span")
	private WebElement clickOnManufacturerLogoCheckBoxLocator;

	@FindBy(xpath="//table[@id='listManufacturerForm:manufacturerTableId']/thead/tr/th/div[text()[contains(.,'Manufacturer Logo')]]")
	private WebElement verifyManufacturerLogoPresentLocator;

	@FindBy(xpath="//div[@class='pull-right']/input")
	private WebElement clickOnSaveFieldsLocator;

	@FindBy(xpath="//div[@class='closeColSettTable closeColSetTable  pull-right']")
	private WebElement clickOnCancelButtonLocator;

	@FindBy(xpath="//li[@class='show-sort-settings']/a")
	private WebElement clickOnSortOrderLocator;

	@FindBy(xpath="//input[@class='addIcon pull-left']")
	private WebElement clickOnAddNewSortOrderLocator;

	@FindBy(xpath="//select[@id='listManufacturerForm:sortLevelTableId:0:selOneId']")
	private WebElement enterSortFieldNameLocator;

	@FindBy(xpath="//select[@id='listManufacturerForm:sortLevelTableId:0:sortById']")
	private WebElement descendingOrderTextLocator;

	@FindBy(xpath="//form[@id='listManufacturerForm']/div[2]/div/div[3]/input[2]")
	private WebElement clickOnSaveSortOrderLocator;

	@FindBy(xpath="//table[@id='listManufacturerForm:sortLevelTableId']/tbody/tr//td[3]/div/input")
	private WebElement clickOnDeleteSortOrderLocator;

	@FindBy(xpath="//div[@class='closeColSorTable closeSortTable pull-right']")
	private WebElement clickOnCloseSortOrderLocator;

@Step("click on brand list icon under manufacturer")
public ManufacturerPageObjects clickOnlisticon() throws InterruptedException {
	brandList.click();
	Thread.sleep(2000);
	return this;
}
	
public boolean isBrandpresentHelp(String brandname) throws Exception
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	try {
		
		
		if(driver.findElement(By.xpath("//span[contains(text(),'Brand')]/ancestor::a/following-sibling::table/descendant::td[contains(text(),'"+brandname+"')]")).isDisplayed())
		{
		return false;
		}
		}
	catch(NoSuchElementException e) {
		return true;
	   
	}
	return false;		    
}

@Step("check whether brand is already created")
public ManufacturerPageObjects isBrandpresent(String brandname) throws Exception
{
	Assert.assertTrue(isBrandpresentHelp(brandname),"Brand is Present Already. Please delete to create.");
	return this;
}

	@Step("assert element present manufacturerbrandtextLocator ")
	public  ManufacturerPageObjects assrtManufacturerbrandtextLocator() throws Exception{
		
		TestUtility.assertElementnotPresent(manufacturerbrandtextLocator);
		return this;
	}
	
	@Step("type in manufacturerbrandsearchfield")
	public ManufacturerPageObjects clickonMBsearch() throws InterruptedException {
		
		manufacturerbrandsearchbutton.click();
		Thread.sleep(3000);
	return this;
	}
	
	@Step("check whether searched result is desired manufactuer")
	public ManufacturerPageObjects checkManufacturerAlreadyExist(String manufacturername) throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertEquals(manufacturersearchres.getText(),manufacturername);
		return this;
	}
	
	
	@Step("type in manufacturerbrandsearchfield")
	public ManufacturerPageObjects typeonMBsearch(String manufacturername){
	manufacturerbrandsearchfield.clear();
	manufacturerbrandsearchfield.sendKeys(manufacturername);
	return this;
	}

	
	@Step("Click on save button")
	public ManufacturerPageObjects clickOnSaveButton() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(saveButtonLocator, 5);
		saveButtonLocator.click();
		return this;
	}

	@Step("click on add new add new manufacturer button")
	public ManufacturerPageObjects clickOnAddNewManufacturerButton() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(addNewManufacturerButtonLocator, 5);
		addNewManufacturerButtonLocator.click();
		return this;
	}
	@Step("Verify whether unsuccessful message is  {0}")
	public ManufacturerPageObjects verifyUnsuccessfullMessage(String unsuccessfullMessageOfManufacturerSave)throws Exception {
		Waiting.explicitWaitVisibilityOfElement(manufacturerUnsuccessfullMessageLocator, 8);
		Assert.assertEquals(manufacturerUnsuccessfullMessageLocator.getText().trim(), "Manufacturer Name required");
		return this;
	}


	@Step("Enter manufacturer name as {0}")
	public ManufacturerPageObjects enterNewManufacturerNames(String manufacturerNewName) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(manufacturerNewNameLocator, 5);
		manufacturerNewNameLocator.sendKeys(manufacturerNewName);
		return this;

	}
	@Step("verify creation of new manufacturer name contains {0}")
	public ManufacturerPageObjects verifySuccessMessageNewManuCreation(String manufacturerName)throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifySuccessMessageNewManuCreationLocator, 8);
		Assert.assertEquals(verifySuccessMessageNewManuCreationLocator.getText().trim(),manufacturerName.substring(0,Math.min(manufacturerName.length(),60))+" Manufacturer saved Successfully");
		return this;
	}

	@Step("Enter manufacturer name {0} to delete")
	public ManufacturerPageObjects enterCreatedManufacturerToDelete(String createdManufacturerToDelete) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(enterCreatedManufacturerToDeleteLocator, 5);
		enterCreatedManufacturerToDeleteLocator.sendKeys(createdManufacturerToDelete);
		return this;

	}

	@Step("click on search button")
	public ManufacturerPageObjects clickOnSearchManufacturerList()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnSearchManufacturerListLocator, 5);
		clickOnSearchManufacturerListLocator.click();
		return this;
	}

	@Step("click on delete manufacturer button")
	public ManufacturerPageObjects clickOnDeleteManufacturerButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnDeleteManufacturerButtonLocator, 5);
		clickOnDeleteManufacturerButtonLocator.click();
		return this;
	}


	public boolean assertAlertText(String alertTextToDeleteManufacturer)throws Exception
	{
		boolean returnStatus = TestUtility.getAlertText().trim().equals(alertTextToDeleteManufacturer);
		TestUtility.alertAccept();
		return returnStatus;

	}

	@Step("verify alert text is {0}")
	public ManufacturerPageObjects verifyAlertText(String alertTextToDeleteManufacturer)throws Exception {
		Assert.assertTrue(assertAlertText(alertTextToDeleteManufacturer));
	return this;
	}



	@Step("verify success message on removal of manufacturer")
	public ManufacturerPageObjects verifyManufacturerDeletion() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyManufacturerDeletionLocator, 8);
		Assert.assertEquals(verifyManufacturerDeletionLocator.getText().trim(),
				"Manufacturer removed Successfully(No Brands and Items were present under this manufacturer).");
		return this;

	}


	@Step("Verify no items displayed when wrong manufacturer name entered")
	public ManufacturerPageObjects verifyZeroManufacturersFound() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyZeroManufacturersFoundLocator, 8);
		Assert.assertEquals(verifyZeroManufacturersFoundLocator.getCssValue("color").trim(),"rgba(98, 98, 98, 1)");
		Thread.sleep(2000);
		Assert.assertEquals(Integer.parseInt(totalCountValueLocator.getText().trim()),0);
		return this;
	}

	@Step("Verify the pagination of manufacturers and brands")
	public boolean clickOnNextButton() throws Exception {
		boolean returnflag = false;

		int totalNumberOfPages = Integer.parseInt(storeTotalNumberOfPagesLocator.getText().trim());
		if(totalNumberOfPages>1)
		{
			Waiting.explicitWaitVisibilityOfElement(storeThePageNumberLocator, 3);
			int currentPageNumber = Integer.parseInt(storeThePageNumberLocator.getAttribute("value").trim());
			Assert.assertEquals(currentPageNumber, 1);
			clickOnNextButtonLocator.click();
			Thread.sleep(4000);
			int nextPageNumber = Integer.parseInt(storeThePageNumberLocator.getAttribute("value").trim());
			Assert.assertEquals(nextPageNumber, 2);
			clickOnPreviousButtonLocator.click();
			Thread.sleep(4000);
			Assert.assertEquals(currentPageNumber, 1);
			clickOnLastButtonLocator.click();
			Thread.sleep(4000);
			int lastPageNumber = Integer.parseInt(storeThePageNumberLocator.getAttribute("value").trim());
			Assert.assertEquals(lastPageNumber, totalNumberOfPages);
			clickOnFirstButtonLocator.click();
			Thread.sleep(4000);
			int firstPageNumber = Integer.parseInt(storeThePageNumberLocator.getAttribute("value").trim());
			Assert.assertEquals(firstPageNumber, 1);
		}
		return returnflag;
	}

	@Step("click on reset button")
	public ManufacturerPageObjects clickOnResetButton()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnResetButtonLocator, 8);
		clickOnResetButtonLocator.click();
		return this;
	}

	@Step("click on new manufacturer field")
	public ManufacturerPageObjects clickOnNewManufacturerName()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(manufacturerNewNameLocator, 8);
		manufacturerNewNameLocator.click();
		return this;
	}

	@Step("click on manufacturer code")
	public ManufacturerPageObjects clickOnManufacturerCode()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(manufacturerCodeLocator, 8);
		manufacturerCodeLocator.click();
		return this;
	}

	@Step("verify presence of action field")
	public ManufacturerPageObjects clickOnAction() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnActionLocator, 8);
		Assert.assertTrue(clickOnActionLocator.isDisplayed(),"the text 'action' is not displayed");
		return this;
	}
	@Step("verify presence of SI.No field")
	public ManufacturerPageObjects clickOnSiNumber() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(clickOnSiLocator, 8);
		Assert.assertTrue(clickOnSiLocator.isDisplayed(),"the text 'SI.No' is not displayed");
		return this;
	}
	@Step("verify presence of manufacturer name field")
	public ManufacturerPageObjects clickOnManufacturerName()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnManufacturerNameLocator, 8);
		Assert.assertTrue(clickOnManufacturerNameLocator.isDisplayed(),"the text 'manufacturer name' is not displayed");
		return this;
	}

	@Step("verify presence of brands field")
	public ManufacturerPageObjects clickOnNumberOfBrands() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(clickOnNumberofBrandsLocator, 8);
		Assert.assertTrue(clickOnNumberofBrandsLocator.isDisplayed(),"the text 'manufacturer name' is not displayed");
		return this;
	}

	@Step("click on generic column settings button")
	public ManufacturerPageObjects clickOnGenericColumnnSettings() throws Exception{
		Thread.sleep(5000);
		clickOnGenericColumnnSettingsLocator.click();
		return this;
	}

	@Step("verify presence of show fields")
	public ManufacturerPageObjects verifyShowFieldsText()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyShowFieldsTextLocator, 8);
		Assert.assertEquals(verifyShowFieldsTextLocator.getText().trim(), "Show Fields");
		return this;
	}

	@Step("verify presence of sort order field")
	public ManufacturerPageObjects verifySortOrderText()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifySortOrderTextLocator, 8);
		Assert.assertEquals(verifySortOrderTextLocator.getText().trim(), "Sort Order");
		return this;
	}

	
	@FindBy(xpath="//form/table/tbody/tr[2]/td/span/a[@title='Add New Brand']")
	private WebElement addnewbrandbutton ;
		
	@Step("click on add new brand button")
	public ManufacturerPageObjects clickOnaddnewbrandbutton() throws InterruptedException {
		Thread.sleep(2000);
		addnewbrandbutton.click();
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath="//form[@id='addBrandForm']/div")
	private WebElement addnewbrandform ;
		
	@Step("check whether add new brand form got enabled")
	public ManufacturerPageObjects checkBrandFormEnabled() {
		Assert.assertEquals(addnewbrandform.getText(),"Add New Brand");
		return this;
	}

	@FindBy(id="addBrandForm:manufacturerListComboId")
	private WebElement manufacturerdropdown; //manufactuer drop down under Add new Brand form
		
	@Step("select manufactuer from dropdown")
	public ManufacturerPageObjects selectmanufacturerfromdropdown(String manufacturername) throws InterruptedException {
		Thread.sleep(3000);
		new Select(manufacturerdropdown).selectByVisibleText(manufacturername);
		return this;
	}

	@FindBy(id="addBrandForm:brandId")
	private WebElement brandnamefield;
		
	@Step("type in brandname")
	public ManufacturerPageObjects typeinbrandname(String brandname) {
		brandnamefield.clear();
		brandnamefield.sendKeys(brandname);
		return this;
	}

	@FindBy(id="addBrandForm:bDesc")
	private WebElement branddescfield;
		
	@Step("type in brand desc field")
	public ManufacturerPageObjects typeinBrandDescField(String branddesc) {
		branddescfield.clear();
		branddescfield.sendKeys(branddesc);
		return this;
	}

	@FindBy(xpath="//input[@id='addBrandForm:statusBooleanId']")
	private WebElement brandactivecheckbox;
		
	@Step("check on brandactive checkbox")
	public ManufacturerPageObjects checkOnBrandActive() {
		if(!(brandactivecheckbox).isSelected()) {
			brandactivecheckbox.click();
		}
		return this;
	}

	@FindBy(xpath="//input[@id='addBrandForm:itemsStatusId:0']")
	private WebElement itemactivecheckbox;
		
	@Step("check on itemactivecheckbox")
	public ManufacturerPageObjects checkOnItemActive() {
		if(!(itemactivecheckbox).isSelected()) {
			itemactivecheckbox.click();
		}
		return this;
	}

	@FindBy(xpath="//form[@id='addBrandForm']/div[4]/div[15]/input")
	private WebElement brandsavebutton;
		
	@Step("click on brand save button")
	public ManufacturerPageObjects clickonbrandsave() throws InterruptedException {
		brandsavebutton.click();
		Thread.sleep(6000);
		return this;
	}

	@FindBy(id="addBrandForm:saveMsgBrandId")
	private WebElement brandsavemsgloc;
		
	@Step("check brand is saved succesfully")
	public ManufacturerPageObjects checkBrandSaveMessage(String brandsavemsg) {
		Assert.assertEquals(brandsavemsgloc.getText(), brandsavemsg);
		return this;
	}
	
	public boolean manufacturerSearchResultHelp(String manufacturername) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
				if(driver.findElement(By.xpath("//form/table/tbody/tr[td[3]='"+manufacturername+"']/td[3]")).isDisplayed())
				{
					return false;
				}
			}
		catch(NoSuchElementException e) {
			return true;
		}
		return false;		    
	}

	public ManufacturerPageObjects manufacturerSearchResult(String manufacturername) throws Exception
	{	
		Thread.sleep(3000);
		Assert.assertTrue(manufacturerSearchResultHelp(manufacturername),"Manufacturer is Present. Please delete for creating again.");
		return this;
			    
	}
	
	@FindBy(xpath="//form/div/ul/li[3]/a")
	private WebElement createmanufacturerbutton;
	
	
	@Step("click on createmanufacturer button")
	public ManufacturerPageObjects clickonmanufacturerbutton() {
		createmanufacturerbutton.click();
		return this;
	}
	
	@FindBy(id="addNewManufacturerForm:manfName")
	private WebElement manufacturernamefield;

	@Step("type in manufacturer name field")
	public ManufacturerPageObjects typeinmanufield(String manufacturername) throws InterruptedException {
		manufacturernamefield.sendKeys(manufacturername);
		return this;
	}

	@FindBy(id="addNewManufacturerForm:manfCode")
	private WebElement manufacturecodefield;

	@Step("type in manufacturer code field")
	public ManufacturerPageObjects typeinmanucodefield(String manufacturercode) throws InterruptedException {
		manufacturecodefield.sendKeys(manufacturercode);
		return this;
	}

	@FindBy(xpath="//form[@id='addNewManufacturerForm']/div[4]/div[7]/input")
	private WebElement newmanufacturecheckbox;

	@Step("check new manufacture checkbox")
	public ManufacturerPageObjects checkmanufactureractive() {
		newmanufacturecheckbox.click();
		return this;
	}


	@FindBy(xpath="//form[@id='addNewManufacturerForm']/div[4]/div[9]/input")
	private WebElement newmanufacturersave;

	@Step("click on manufacturer save button")
	public ManufacturerPageObjects clickonmanufacturersave() {
		newmanufacturersave.click();
		return this;
	}


@FindBy(id="listManufacturerForm:saveMsgId")
private WebElement manufacturermessagesaveph;

@Step("verify manufacturer save message")
public ManufacturerPageObjects verifymessage(String message) throws InterruptedException {
	Waiting.explicitWaitVisibilityOfElement(manufacturermessagesaveph, 10);
	Assert.assertEquals(manufacturermessagesaveph.getText().trim(),message );
	return this;
}

	@Step("click on show fields")
	public ManufacturerPageObjects clickOnShowFieldsText()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyShowFieldsTextLocator, 8);
		verifyShowFieldsTextLocator.click();
		return this;
	}

	@Step("verify the dynamic field settings text field")
	public ManufacturerPageObjects verifyDynamicSettingsField()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyDynamicSettingsFieldLocator, 8);
		Assert.assertEquals(verifyDynamicSettingsFieldLocator.getText().trim(), "Dynamic Table Settings");
		return this;
	}

	@Step("verify the field names text")
	public ManufacturerPageObjects verifyFieldNamesField()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyFieldNamesFieldLocator, 8);
		Assert.assertEquals(verifyFieldNamesFieldLocator.getText().trim(), "Field Names");
		return this;
	}

	@Step("verify the desktop view text field")

	public ManufacturerPageObjects verifyDesktopViewField()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyDesktopViewFieldLocator, 8);
		Assert.assertEquals(verifyDesktopViewFieldLocator.getText().trim(), "Desktop View");
		return this;
	}

	@Step("verify the mobile view text field")
	public ManufacturerPageObjects verifyMobileViewField() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(verifyMobileViewFieldLocator, 8);
		Assert.assertEquals(verifyMobileViewFieldLocator.getText().trim(), "Mobile View");
		return this;
	}


	@Step("verify the tablet view text field")

	public ManufacturerPageObjects verifyTabletViewField()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyTabletViewFieldLocator, 8);
		Assert.assertEquals(verifyTabletViewFieldLocator.getText().trim(), "Tablet View");
		return this;
	}


	@Step("verify the display names text field")
	public ManufacturerPageObjects verifyDisplayNamesField()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyDisplayNamesFieldLocator, 8);
		Assert.assertEquals(verifyDisplayNamesFieldLocator.getText().trim(), "Display Names");
		return this;

	}

	@Step("verify the reset functionality")
	public ManufacturerPageObjects verifyEmptyFieldAfterReset()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(verifyEmptyFieldAfterResetLocator, 8);
		Assert.assertEquals(verifyEmptyFieldAfterResetLocator.getText().trim(), "");
		return this;
	}

	@Step("click on checkbox")
	public ManufacturerPageObjects clickOnManufacturerLogoCheckBox()throws Exception {
		Thread.sleep(3000);
		clickOnManufacturerLogoCheckBoxLocator.click();
		return this;
	}

	@Step("verify manufacturer logo in mfr list page")
	public ManufacturerPageObjects verifyManufacturerLogoPresent() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(verifyManufacturerLogoPresentLocator, 8);
		Assert.assertEquals(verifyManufacturerLogoPresentLocator.getText().trim(), "Manufacturer Logo");
		return this;
	}

	@Step("click on save fields")
	public ManufacturerPageObjects clickOnSaveFields()throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnSaveFieldsLocator, 8);
		clickOnSaveFieldsLocator.click();
		return this;
	}

	@Step("click on cancel button")
	public ManufacturerPageObjects clickOnCancelButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnCancelButtonLocator, 8);
		clickOnCancelButtonLocator.click();
		return this;
	}

	@Step("click on sort order")
	public ManufacturerPageObjects clickOnSortOrder() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnSortOrderLocator, 8);
		clickOnSortOrderLocator.click();
		return this;
	}

	@Step("click on add new sort order")
	public ManufacturerPageObjects clickOnAddNewSortOrder() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clickOnAddNewSortOrderLocator, 8);
		clickOnAddNewSortOrderLocator.click();
		return this;
	}

	@Step("enter sort field name")
	public ManufacturerPageObjects enterSortFieldName(String SortFieldName) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(enterSortFieldNameLocator, 8);
		enterSortFieldNameLocator.sendKeys(SortFieldName);
		return this;
	}

	@Step("enter descending order option")
	public ManufacturerPageObjects enterDescendingOrder(String descendingOrderText) throws Exception{
		Waiting.explicitWaitVisibilityOfElement(descendingOrderTextLocator, 8);
		descendingOrderTextLocator.sendKeys(descendingOrderText);
		return this;
	}

	@Step("click on save fields")
	public ManufacturerPageObjects clickOnSaveSortOrder()throws Exception {
		Thread.sleep(4000);
		clickOnSaveSortOrderLocator.click();
		return this;
	}

	@Step("click on delete sort order")
	public ManufacturerPageObjects clickOnDeleteSortOrder() {
		Waiting.explicitWaitVisibilityOfElement(clickOnDeleteSortOrderLocator, 8);
		clickOnDeleteSortOrderLocator.click();
		return this;

	}

	@Step("click on close sort order")
	public ManufacturerPageObjects clickOnCloseSortOrder() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(clickOnCloseSortOrderLocator, 8);
		clickOnCloseSortOrderLocator.click();
		return this;
	}
}




