package org.cimm2touch.pageobjects.manufacturer;
/**

 * @author Thiruveedhi Chinna
=======
 * @author Gladson Antony
>>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74
 *
 */
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;


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
import org.testng.asserts.SoftAssert;

import ru.yandex.qatools.allure.annotations.Step;

public class ManufacturerPageObjects extends PageFactoryInitializer
{

	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting=new Waiting(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());

	@FindBy(xpath="//input[contains(@id,searchKeywordId) and @placeholder='Enter Manufacturer Name to Search' and @type='text']")
	private WebElement manufacturersSearchBox;

	@FindBy(xpath="//input[contains(@id,searchKeywordId) and @placeholder='Enter Manufacturer Name to Search' and @type='text']//following::a[contains(@id,'goBtn')]/i")
	private WebElement manufacturersSearchIcon;

	@FindBy(xpath="//li/span[contains(@id,'countVal')][2]")
	private WebElement manufacturersTotalCount;

	@FindBy(xpath="//select[contains(@id,'nrpp')]")
	private WebElement itemsPerPageDropdown;

	@FindBy(xpath="//div/img[@class='gearIcon']")
	private WebElement manufacturers_GenericColumnSettings;

	@FindBy(xpath="//div[@title='Generic Column Settings']/..//li/a[contains(.,'Sort Order')]")
	private WebElement genericColumnSettings_SortOrder;

	@FindBy(xpath="//div/input[@class='addIcon pull-left']")
	private WebElement sortOrder_AddNewSortOrder;

	@FindBy(xpath="(//div/input[@title='Remove'])[1]")
	private WebElement sortOrder_RemoveSortOrder;

	@FindBy(xpath="//div[@title='Generic Column Settings']/..//li/a[contains(.,'Show Fields')]")
	private WebElement genericColumnSettings_ShowFields;

	@FindBy(xpath="//table[@id='listManufacturerForm:manufacturerTableId']")
	private WebElement manufacturersTableContents;

	@FindBy(xpath="//a[@id='listManufacturerForm:nextBtnId']/i")
	private WebElement manufacturersPaginationNextButton;

	@FindBy(xpath="//a[@id='listManufacturerForm:prevBtnId']")
	private WebElement manufacturersPaginationPreviousButton;

	@FindBy(xpath="//a[@id='listManufacturerForm:lastBtnId']/i")
	private WebElement manufacturersPaginationLastButton;

	@FindBy(xpath="//a[@id='listManufacturerForm:firstBtnId']/i")
	private WebElement manufacturersPaginationFirstButton;

	@FindBy(xpath="//span[@id='listManufacturerForm:selectNo']")
	private WebElement manufacturersPagination_CurrentPageCount;

	@FindBy(xpath="//span[@id='listManufacturerForm:tnpId']")
	private WebElement manufacturersPagination_TotalPageCount;

	@FindBy(xpath="//a[@title='Add New Manufacturer']")
	private WebElement addNewManufacturerButton;

	@FindBy(xpath="//input[@id='addNewManufacturerForm:manfName']")
	private WebElement newManufacturersNameLocator;

	@FindBy(xpath="//input[@id='addNewManufacturerForm:manfCode']")
	private WebElement newManufacturersCodeLocator;

	@FindBy(xpath="//input[@id='addNewManufacturerForm:checkIT']")
	private WebElement newManufacturersActiveStatus;

	@FindBy(xpath="//input[@title='Save New Manufacturer']")
	private WebElement saveNewManufacturer;

	@FindBy(xpath="//input[@id='addNewManufacturerForm:btnReset']")
	private WebElement resetAddNewManufacturerFields;

	@FindBy(xpath="//form[@id='addNewManufacturerForm']/div[@class='cimm_closeBtn']/img")
	private WebElement closeAddNewManufacturerForm;

	@FindBy(id="listManufacturerForm:saveMsgId")
	private WebElement messageAfterSavingNewManufacturerLocator;

	@FindBy(xpath="//td/a[@title='List Brand']")
	private WebElement listBrands;

	@FindBy(xpath="//span/a[@title='Add New Brand']")
	private WebElement addNewBrandLocator;

	@FindBy(xpath="//select[@id='addBrandForm:manufacturerListComboId']")
	private WebElement addNewBrand_ManufacturerName;

	@FindBy(xpath="//input[@id='addBrandForm:brandId']")
	private WebElement addNewBrand_BrandName;

	@FindBy(xpath="//textarea[@id='addBrandForm:bDesc']")
	private WebElement addNewBrand_BrandDesc;

	@FindBy(xpath="//input[@id='addBrandForm:statusBooleanId' and @type='checkbox']")
	private WebElement addNewBrand_BrandActive;

	@FindBy(xpath="//td/label[contains(.,'Items Active')]//preceding-sibling::input")
	private WebElement addNewBrand_ItemsActive;

	@FindBy(xpath="//td/label[contains(.,'Items InActive')]//preceding-sibling::input")
	private WebElement addNewBrand_ItemsInActive;

	@FindBy(xpath="//form[@id='addBrandForm']//div[contains(.,'Brand URL')]//following::div[@class='cimm_formInput']/input[@maxlength='300']")
	private WebElement addNewBrand_BrandURL;

	@FindBy(xpath="//input[@title='Save New Brand']")
	private WebElement addNewBrand_SaveBrand;

	@FindBy(xpath="//input[@title='Reset' and @id='addBrandForm:btnReset']")
	private WebElement addNewBrand_ResetBrandFields;

	@FindBy(xpath="//form[@id='addBrandForm']//div[@class='cimm_closeBtn']")
	private WebElement addNewBrand_CloseForm;

	@FindBy(xpath="//span[@id='addBrandForm:saveMsgBrandId']")
	private WebElement addNewBrand_SaveMessageArea;

	@FindBy(xpath="//span[@id='listManufacturerForm:noResults']")
	private WebElement successMessageRemoveMfgLocator;

	@FindBy(xpath="//span[contains(text(),'Total Count : ')]/following-sibling::span")
	private WebElement manufacturersearchresultcount;

	/*****************************************************************************************************************************************************************
	 *****************************************************************************************************************************************************************/

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
	
	@FindBy(xpath="//a[contains(text(),'Show Fields')]")
	private WebElement showfieldlistLocator;
	
	@FindBy(xpath="//div[contains(text(),'Dynamic Table Settings')]")
	private WebElement DynamicTable;
	
	@FindBy(xpath="//div[@class='box-footer']/div/input[contains(@title,'Save')]")
	private WebElement saveFieldSettings;
	
	
	@Step("click on brand list icon under manufacturer")
	public ManufacturerPageObjects clickOnlisticon(String manufacturerName) throws InterruptedException {
		WebElement wb= getDriver().findElement(By.xpath("//td[contains(text(),'"+manufacturerName+"')]/following-sibling::td/a[@title='List Brand']"));
		waiting.explicitWaitElementToBeClickable(wb, 20);
		wb.click();
		return this;
	}

	public boolean isBrandpresentHelp(String brandname) throws Exception
	{

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {


			if(getDriver().findElement(By.xpath("//span[contains(text(),'Brand')]/ancestor::a/following-sibling::table/descendant::td[contains(text(),'"+brandname+"')]")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e) {
			return true;

		}
		return false;		    
	}

	@Step("check whether brand is created or not {}")
	public ManufacturerPageObjects verifyBrandBeforeRemove(String brandname) throws Exception
	{
		Assert.assertFalse(isBrandpresentHelp(brandname),"Brand is Present Already. Please delete to create.");
		return this;
	}
	
	@Step("check whether brand is already created")
	public ManufacturerPageObjects isBrandpresent(String brandname) throws Exception
	{
		Assert.assertTrue(isBrandpresentHelp(brandname),"Brand is Present Already. Please delete to create.");
		return this;
	}


	@Step("assert element present manufacturerbrandtextLocator ")
	public  ManufacturerPageObjects assrtManufacturerbrandtextLocator() throws Exception{


		utility.assertElementnotPresent(manufacturerbrandtextLocator);
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
		waiting.explicitWaitVisibilityOfElement(By.xpath("//table[@id='listManufacturerForm:manufacturerTableId']/descendant::td[contains(text(),'"+manufacturername+"')]"), 15);
		WebElement wb= getDriver().findElement(By.xpath("//table[@id='listManufacturerForm:manufacturerTableId']/descendant::td[contains(text(),'"+manufacturername+"')]"));
		Assert.assertEquals(wb.getText(),manufacturername);
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

		waiting.explicitWaitVisibilityOfElement(saveButtonLocator, 5);
		saveButtonLocator.click();
		return this;
	}



	@Step("Verify whether unsuccessful message is  {0}")
	public ManufacturerPageObjects verifyUnsuccessfullMessage(String unsuccessfullMessageOfManufacturerSave)throws Exception {

		waiting.explicitWaitVisibilityOfElement(manufacturerUnsuccessfullMessageLocator, 8);
		Assert.assertEquals(manufacturerUnsuccessfullMessageLocator.getText().trim(), "Manufacturer Name required");
		return this;
	}


	@Step("Enter manufacturer name as {0}")
	public ManufacturerPageObjects enterNewManufacturerNames(String manufacturerNewName) throws Exception {

		waiting.explicitWaitVisibilityOfElement(manufacturerNewNameLocator, 5);
		manufacturerNewNameLocator.sendKeys(manufacturerNewName);
		return this;

	}
	@Step("verify creation of new manufacturer name contains {0}")
	public ManufacturerPageObjects verifySuccessMessageNewManuCreation(String manufacturerName)throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifySuccessMessageNewManuCreationLocator, 8);
		Assert.assertEquals(verifySuccessMessageNewManuCreationLocator.getText().trim(),manufacturerName.substring(0,Math.min(manufacturerName.length(),60))+" Manufacturer saved Successfully");
		return this;
	}

	@Step("Enter manufacturer name {0} to delete")
	public ManufacturerPageObjects enterCreatedManufacturerToDelete(String createdManufacturerToDelete) throws Exception {

		waiting.explicitWaitVisibilityOfElement(enterCreatedManufacturerToDeleteLocator, 5);
		enterCreatedManufacturerToDeleteLocator.sendKeys(createdManufacturerToDelete);
		return this;

	}

	@Step("click on search button")
	public ManufacturerPageObjects clickOnSearchManufacturerList()throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnSearchManufacturerListLocator, 5);
		clickOnSearchManufacturerListLocator.click();
		return this;
	}

	@Step("click on delete manufacturer button")
	public ManufacturerPageObjects clickOnDeleteManufacturerButton() throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnDeleteManufacturerButtonLocator, 5);
		clickOnDeleteManufacturerButtonLocator.click();
		return this;
	}


	public boolean assertAlertText(String alertTextToDeleteManufacturer)throws Exception
	{

		boolean returnStatus = tu.getAlertText().trim().equals(alertTextToDeleteManufacturer);
		tu.alertAccept();
		return returnStatus;

	}

	@Step("verify alert text is {0}")
	public ManufacturerPageObjects verifyAlertText(String alertTextToDeleteManufacturer)throws Exception {
		Assert.assertTrue(assertAlertText(alertTextToDeleteManufacturer));
		return this;
	}



	@Step("verify success message on removal of manufacturer")
	public ManufacturerPageObjects verifyManufacturerDeletion() throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyManufacturerDeletionLocator, 8);
		Assert.assertEquals(verifyManufacturerDeletionLocator.getText().trim(),
				"Manufacturer removed Successfully(No Brands and Items were present under this manufacturer).");
		return this;

	}


	@Step("Verify no items displayed when wrong manufacturer name entered")
	public ManufacturerPageObjects verifyZeroManufacturersFound() throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyZeroManufacturersFoundLocator, 8);
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

			waiting.explicitWaitVisibilityOfElement(storeThePageNumberLocator, 3);
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

	@Step("click on new manufacturer field")
	public ManufacturerPageObjects clickOnNewManufacturerName()throws Exception {

		waiting.explicitWaitVisibilityOfElement(manufacturerNewNameLocator, 8);
		manufacturerNewNameLocator.click();
		return this;
	}

	@Step("click on manufacturer code")
	public ManufacturerPageObjects clickOnManufacturerCode()throws Exception {

		waiting.explicitWaitVisibilityOfElement(manufacturerCodeLocator, 8);
		manufacturerCodeLocator.click();
		return this;
	}

	@Step("verify presence of action field")
	public ManufacturerPageObjects clickOnAction() throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnActionLocator, 8);
		Assert.assertTrue(clickOnActionLocator.isDisplayed(),"the text 'action' is not displayed");
		return this;
	}
	@Step("verify presence of SI.No field")
	public ManufacturerPageObjects clickOnSiNumber() throws Exception{

		waiting.explicitWaitVisibilityOfElement(clickOnSiLocator, 8);
		Assert.assertTrue(clickOnSiLocator.isDisplayed(),"the text 'SI.No' is not displayed");
		return this;
	}
	@Step("verify presence of manufacturer name field")
	public ManufacturerPageObjects clickOnManufacturerName()throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnManufacturerNameLocator, 8);
		Assert.assertTrue(clickOnManufacturerNameLocator.isDisplayed(),"the text 'manufacturer name' is not displayed");
		return this;
	}

	@Step("verify presence of brands field")
	public ManufacturerPageObjects clickOnNumberOfBrands() throws Exception{

		waiting.explicitWaitVisibilityOfElement(clickOnNumberofBrandsLocator, 8);
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

		waiting.explicitWaitVisibilityOfElement(verifyShowFieldsTextLocator, 8);
		Assert.assertEquals(verifyShowFieldsTextLocator.getText().trim(), "Show Fields");
		return this;
	}

	@Step("verify presence of sort order field")
	public ManufacturerPageObjects verifySortOrderText()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifySortOrderTextLocator, 8);
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

	@FindBy(xpath="//select[@id='addBrandForm:manufacturerListComboId']")
	private WebElement manufacturerdropdown; //manufactuer drop down under Add new Brand form

	@Step("select manufactuer from dropdown")
	public ManufacturerPageObjects selectmanufacturerfromdropdown(String manufacturername) throws InterruptedException {
		Thread.sleep(2500);
		Select sel=new Select(manufacturerdropdown);
		sel.selectByVisibleText(manufacturername);

		//getDriver().findElement(By.xpath("//select[@id='addBrandForm:manufacturerListComboId']/option[contains(text(),'"+manufacturername+"')]")).click();//select[@id='addBrandForm:manufacturerListComboId']/option[contains(text(),'AS_Manufacturer_Automation_Testing')];
		return this;
	}

	@FindBy(id="addBrandForm:brandId")
	private WebElement brandnamefield;

	@Step("type in brandname")
	public ManufacturerPageObjects typeinbrandname(String brandname) {

		waiting.explicitWaitVisibilityOfElement(brandnamefield, 10);
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

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getDriver().findElement(By.xpath("//table[@id='listManufacturerForm:manufacturerTableId']/descendant::td[contains(text(),'"+manufacturername+"')]")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e) {
			return true;
		}
		return false;		    
	}

	public ManufacturerPageObjects manufacturerSearchBeforeRemove(String manufacturername) throws Exception
	{	
		
		Assert.assertFalse(manufacturerSearchResultHelp(manufacturername),"Manufacturer is not available. Please create before remove");
		return this;

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
	public ManufacturerPageObjects verifymessageAfterManufacturerCreate(String mfgName, String successMessageAfterCreate) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(manufacturermessagesaveph, 15);
		Assert.assertEquals(manufacturermessagesaveph.getText().trim(),mfgName+" "+successMessageAfterCreate);
		return this;
	}

	@Step("click on show fields")
	public ManufacturerPageObjects clickOnShowFieldsText()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyShowFieldsTextLocator, 8);

		verifyShowFieldsTextLocator.click();
		return this;
	}

	@Step("verify the dynamic field settings text field")
	public ManufacturerPageObjects verifyDynamicSettingsField()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyDynamicSettingsFieldLocator, 8);
		Assert.assertEquals(verifyDynamicSettingsFieldLocator.getText().trim(), "Dynamic Table Settings");
		return this;
	}

	@Step("verify the field names text")
	public ManufacturerPageObjects verifyFieldNamesField()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyFieldNamesFieldLocator, 8);
		Assert.assertEquals(verifyFieldNamesFieldLocator.getText().trim(), "Field Names");
		return this;
	}

	@Step("verify the desktop view text field")

	public ManufacturerPageObjects verifyDesktopViewField()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyDesktopViewFieldLocator, 8);
		Assert.assertEquals(verifyDesktopViewFieldLocator.getText().trim(), "Desktop View");
		return this;
	}

	@Step("verify the mobile view text field")
	public ManufacturerPageObjects verifyMobileViewField() throws Exception{

		waiting.explicitWaitVisibilityOfElement(verifyMobileViewFieldLocator, 8);
		Assert.assertEquals(verifyMobileViewFieldLocator.getText().trim(), "Mobile View");
		return this;
	}


	@Step("verify the tablet view text field")

	public ManufacturerPageObjects verifyTabletViewField()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyTabletViewFieldLocator, 8);
		Assert.assertEquals(verifyTabletViewFieldLocator.getText().trim(), "Tablet View");
		return this;
	}


	@Step("verify the display names text field")
	public ManufacturerPageObjects verifyDisplayNamesField()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyDisplayNamesFieldLocator, 8);
		Assert.assertEquals(verifyDisplayNamesFieldLocator.getText().trim(), "Display Names");
		return this;

	}

	@Step("verify the reset functionality")
	public ManufacturerPageObjects verifyEmptyFieldAfterReset()throws Exception {

		waiting.explicitWaitVisibilityOfElement(verifyEmptyFieldAfterResetLocator, 8);
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

		waiting.explicitWaitVisibilityOfElement(verifyManufacturerLogoPresentLocator, 8);
		Assert.assertEquals(verifyManufacturerLogoPresentLocator.getText().trim(), "Manufacturer Logo");
		return this;
	}

	@Step("click on save fields")
	public ManufacturerPageObjects clickOnSaveFields()throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnSaveFieldsLocator, 8);
		clickOnSaveFieldsLocator.click();
		return this;
	}

	@Step("click on cancel button")
	public ManufacturerPageObjects clickOnCancelButton() throws Exception {

		waiting.explicitWaitVisibilityOfElement(clickOnCancelButtonLocator, 8);
		clickOnCancelButtonLocator.click();
		return this;
	}

	@Step("enter sort field name")
	public ManufacturerPageObjects enterSortFieldName(String SortFieldName) throws Exception {

		waiting.explicitWaitVisibilityOfElement(enterSortFieldNameLocator, 8);
		enterSortFieldNameLocator.sendKeys(SortFieldName);
		return this;
	}

	@Step("enter descending order option")
	public ManufacturerPageObjects enterDescendingOrder(String descendingOrderText) throws Exception{

		waiting.explicitWaitVisibilityOfElement(descendingOrderTextLocator, 8);
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

		waiting.explicitWaitVisibilityOfElement(clickOnDeleteSortOrderLocator, 8);
		clickOnDeleteSortOrderLocator.click();
		return this;

	}

	@Step("click on close sort order")
	public ManufacturerPageObjects clickOnCloseSortOrder() throws Exception{

		waiting.explicitWaitVisibilityOfElement(clickOnCloseSortOrderLocator, 8);
		clickOnCloseSortOrderLocator.click();
		return this;
	}



	@Step("To Verify the Manufacturers Page Items")
	public ManufacturerPageObjects verifyManufacturersAndBrandsPageItems() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(manufacturersSearchBox.isDisplayed());
		Assert.assertTrue(manufacturersSearchIcon.isDisplayed());
		Assert.assertTrue(manufacturersTableContents.isDisplayed());
		Assert.assertTrue(manufacturers_GenericColumnSettings.isDisplayed());
		Assert.assertTrue(itemsPerPageDropdown.isDisplayed());
		Assert.assertTrue(manufacturersPaginationFirstButton.isDisplayed());
		Assert.assertTrue(manufacturersPaginationLastButton.isDisplayed());
		Assert.assertTrue(manufacturersPaginationNextButton.isDisplayed());
		Assert.assertTrue(manufacturersPaginationPreviousButton.isDisplayed());
		Assert.assertTrue(addNewManufacturerButton.isDisplayed());
		return this;
	}

	@Step("To Click on 'Add New Manufacturers' Button")
	public ManufacturerPageObjects clickOnAddNewManufacturerButton() throws Exception
	{

		waiting.explicitWaitVisibilityOfElement(addNewManufacturerButtonLocator, 5);
		addNewManufacturerButtonLocator.click();
		return this;
	}

	@Step("To Verify Form Items after clicking on  'Add New Manufacturers' Button")
	public ManufacturerPageObjects verifyAddNewManufacturerFormItems() throws Exception
	{
		Thread.sleep(5000);
		Assert.assertTrue(newManufacturersNameLocator.isDisplayed());
		Assert.assertTrue(newManufacturersCodeLocator.isDisplayed());
		Assert.assertTrue(newManufacturersActiveStatus.isDisplayed());
		Assert.assertTrue(saveNewManufacturer.isDisplayed());
		Assert.assertTrue(resetAddNewManufacturerFields.isDisplayed());
		Assert.assertTrue(closeAddNewManufacturerForm.isDisplayed());
		return this;
	}

	@Step("To Add New Manufacturers {0}")
	public ManufacturerPageObjects addNewManufacture(String manufacturersName, String manufacturersCode, String manufacturerActiveStatus) throws Exception 
	{
		Thread.sleep(5000);
		newManufacturersNameLocator.clear();
		newManufacturersNameLocator.sendKeys(manufacturersName);
		newManufacturersCodeLocator.clear();
		newManufacturersCodeLocator.sendKeys(manufacturersCode);
		if(manufacturerActiveStatus.equalsIgnoreCase("yes"))
		{
			newManufacturersActiveStatus.click();
		}
		return this;
	}

	@Step("To Save a New Manufacturer")
	public ManufacturerPageObjects clickOnSaveNewManufacturer() 
	{
		saveNewManufacturer.click();
		return this;
	}

	@Step("To Verify the Message after saving a Manufacturer")
	public ManufacturerPageObjects verifyMessageAfterSavingManufacturer(String saveMessage) throws Exception 
	{

		waiting.explicitWaitVisibilityOfElement(messageAfterSavingNewManufacturerLocator, 15);
		assertThat(messageAfterSavingNewManufacturerLocator.getText(), containsString(saveMessage));
		return this;
	}

	@Step("To Search for the Manufacturer {0}")
	public ManufacturerPageObjects searchForManufacturer(String manufacturersName) throws Exception
	{

		waiting.explicitWaitVisibilityOfElement(manufacturersSearchBox, 10);
		manufacturersSearchBox.clear();
		manufacturersSearchBox.sendKeys(manufacturersName);
		manufacturersSearchIcon.click();
		return this;
	}

	@Step("To Verify for the Manufacturer {0} after Searching")
	public ManufacturerPageObjects verifyAfterSearchingForManufacturer(String manufacturersName) throws Exception
	{
		Thread.sleep(5000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//span[@id='listManufacturerForm:noResults' and contains(.,'"+manufacturersName+"')]")).isDisplayed(),"Manufacturer Results is Not Displaying");
		Assert.assertTrue(getDriver().findElement(By.xpath("//form[@id='listManufacturerForm']//td[contains(.,'"+manufacturersName+"')]")).isDisplayed());
		return this;
	}

	@Step("To Click on Add New Brand")
	public ManufacturerPageObjects clickOnAddNewBrand() throws Exception
	{

		waiting.explicitWaitVisibilityOfElement(listBrands, 10);
		listBrands.click();
		waiting.explicitWaitVisibilityOfElement(addNewBrandLocator, 10);
		addNewBrandLocator.click();		
		return this;
	}

	@Step("To Click on Add New Brand")
	public ManufacturerPageObjects verifyAddNewBrandFormItems() throws Exception
	{
		Thread.sleep(5000);
		Assert.assertTrue(addNewBrand_ManufacturerName.isDisplayed(),"Manufacturer Name is not Dispalying");
		Assert.assertTrue(addNewBrand_BrandName.isDisplayed(), "Brand Name is not Displaying");
		Assert.assertTrue(addNewBrand_BrandDesc.isDisplayed(), "Brand Description Field is not Displaying");
		Assert.assertTrue(addNewBrand_BrandActive.isDisplayed());
		Assert.assertTrue(addNewBrand_ItemsActive.isDisplayed());
		Assert.assertTrue(addNewBrand_ItemsInActive.isDisplayed());
		Assert.assertTrue(addNewBrand_BrandURL.isDisplayed(),"Brand URL is not Displaying");
		return this;
	}

	@Step("To Verify the Pre-Selected Manufacturer when adding a Manufacturer")
	public ManufacturerPageObjects verifyPreSelectedManufacturerWhenAddingBrand(String manufacturersName) 
	{
		String selectedOption = new Select(addNewBrand_ManufacturerName).getFirstSelectedOption().getText();
		System.out.println(selectedOption);
		Assert.assertEquals(selectedOption, manufacturersName);
		return this;
	}

	@Step("To Create a New Brand {0} under the Manufacturer")
	public ManufacturerPageObjects addNewBrand(String brandName, String brandDesc, String brandActiveStatus, String brandURL) 
	{
		addNewBrand_BrandName.clear();
		addNewBrand_BrandName.sendKeys(brandName);
		addNewBrand_BrandDesc.clear();
		addNewBrand_BrandDesc.sendKeys(brandDesc);
		if(brandActiveStatus.equalsIgnoreCase("yes"))
		{
			addNewBrand_BrandActive.click();
		}
		addNewBrand_BrandURL.clear();
		addNewBrand_BrandURL.sendKeys(brandURL);
		return this;
	}

	@Step("To Save a Brand")
	public ManufacturerPageObjects clickOnSaveNewBrand() 
	{
		addNewBrand_SaveBrand.click();
		return this;
	}

	@Step("To Verify the Message {0} after saving the Brand")
	public ManufacturerPageObjects verifyMessageAfterSavingBrands(String saveMessage) throws Exception 
	{
		Thread.sleep(5000);;
		assertThat(addNewBrand_SaveMessageArea.getText(), containsString(saveMessage));
		return this;
	}

	@Step("To Verify the working of 'Reset' button")
	public ManufacturerPageObjects clickOnResetManufacturersFieldsButton()throws Exception 
	{

		waiting.explicitWaitVisibilityOfElement(resetAddNewManufacturerFields, 5);
		resetAddNewManufacturerFields.click();
		return this;
	}

	@Step("To Verify the Error Message on Saving a Manufacturer. ")
	public ManufacturerPageObjects verifyErrorMessageOnSavingBrand(String errorMessage) throws Exception 
	{
		Thread.sleep(5000);

		assertThat(getDriver().findElement(By.xpath("//span[@id='addBrandForm:hmsgBrandId']")).getText(),containsString(errorMessage));
		return this;
	}

	@Step("To Click on Previous Page Option and Verify the Functionality.")
	public ManufacturerPageObjects verifytheWorkingOfThePreviousPageOption() throws Exception 
	{
		manufacturersPaginationNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber1 =  Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		System.out.println(currentPageNumber1);
		manufacturersPaginationPreviousButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 =  Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		System.out.println(currentPageNumber2);
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;		
	}

	@Step("To Click on Next Page Option and Verify the Functionality.")
	public ManufacturerPageObjects verifytheWorkingOfTheNextPageOption() throws Exception 
	{
		int currentPageNumber1 = Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		manufacturersPaginationNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 = Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on Last Page Option and Verify the Functionality.")
	public ManufacturerPageObjects verifytheWorkingOfTheLastPageOption() throws Exception
	{
		int totalPagesCount = Integer.parseInt(manufacturersPagination_TotalPageCount.getText());
		manufacturersPaginationLastButton.click();
		Thread.sleep(5000);
		int currentPageNumber =  Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		Assert.assertEquals(totalPagesCount, currentPageNumber);
		return this;
	}

	@Step("To Click on First Page Option and Verify the Functionality.")
	public ManufacturerPageObjects verifytheWorkingOfTheFirstPageOption() throws Exception
	{
		manufacturersPaginationNextButton.click();
		Thread.sleep(5000);
		int currentPageNumber1 =  Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		manufacturersPaginationFirstButton.click();
		Thread.sleep(5000);
		int currentPageNumber2 =  Integer.parseInt(manufacturersPagination_CurrentPageCount.getText());
		Assert.assertNotEquals(currentPageNumber1, currentPageNumber2);
		return this;
	}

	@Step("To Click on 'NoOfItems Dropdown' and verify contents dispalyed.")
	public ManufacturerPageObjects verifyDisplayNoOfItemsDropdown() throws Exception
	{
		SoftAssert sa = new SoftAssert();


		List<WebElement> itemsDisplayed = getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		Assert.assertEquals(itemsDisplayed.size(), 10);

		getDriver().findElement(By.xpath("//select[@class='comboFlat']/option[@value='25']")).click();
		Thread.sleep(5000);
		List<WebElement> itemsDisplayed1= getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		sa.assertEquals(itemsDisplayed1.size(), 25);

		getDriver().findElement(By.xpath("//select[@class='comboFlat']/option[@value='50']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed2 = getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		sa.assertEquals(itemsDisplayed2.size(), 50);

		getDriver().findElement(By.xpath("//select[@class='comboFlat']/option[@value='75']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed3 = getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		sa.assertEquals(itemsDisplayed3.size(), 75);

		getDriver().findElement(By.xpath("//select[@class='comboFlat']/option[@value='100']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed4 = getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		sa.assertEquals(itemsDisplayed4.size(), 100);

		getDriver().findElement(By.xpath("//select[@class='comboFlat']/option[@value='10']")).click();
		Thread.sleep(10000);
		List<WebElement> itemsDisplayed5 = getDriver().findElements(By.xpath("//form[@id='listManufacturerForm']//table[contains(@id,'manufacturerTableId')]//tbody/tr[contains(@class,'rich-table-row')]"));
		sa.assertEquals(itemsDisplayed5.size(), 10);
		sa.assertAll();
		return this;
	}

	@Step("To Click on 'Generic Column Settings'.")
	public ManufacturerPageObjects clickOnGenericColumnSettings() throws Exception
	{

		waiting.explicitWaitVisibilityOfElement(manufacturers_GenericColumnSettings, 5);
		manufacturers_GenericColumnSettings.click();
		return this;
	}

	@Step("To Verify the Items displayed in 'Generic Column Settings'.")
	public ManufacturerPageObjects verifyGenericColumnSettingsItems() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(genericColumnSettings_ShowFields.isDisplayed(),"'Show Fields' Option is not Displayed");
		Assert.assertTrue(genericColumnSettings_SortOrder.isDisplayed(),"'Sort Order' Option is not Displayed");
		return this;
	}

	@Step("To Click on 'Sort Order'")
	public ManufacturerPageObjects clickOnSortOrder() throws Exception 
	{

		waiting.explicitWaitVisibilityOfElement(clickOnSortOrderLocator, 5);
		genericColumnSettings_SortOrder.click();
		return this;
	}

	@Step("To Verify the Options displayed on clicking 'Sort Order'")
	public ManufacturerPageObjects verifyItemsDisplayedAfterClickingSortOrder() throws InterruptedException 
	{

		waiting.explicitWaitVisibilityOfElement(sortOrder_AddNewSortOrder, 5);
		Assert.assertTrue(sortOrder_AddNewSortOrder.isDisplayed(),"Add New Sort Order Option is Not Displayed");
		try
		{
			Assert.assertTrue(getDriver().findElement(By.xpath("//select[contains(@id,'listManufacturerForm:sortLevelTableId:0:selOneId')]")).isDisplayed());
			Assert.assertTrue(getDriver().findElement(By.xpath("//select[contains(@id,'listManufacturerForm:sortLevelTableId:0:sortById')]")).isDisplayed());
			Assert.assertTrue(sortOrder_RemoveSortOrder.isDisplayed(),"Remove Sort Order Option is Not Displayed");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return this;
	}

	@Step("To Click On 'Add New Sort Order'")
	public ManufacturerPageObjects clickOnAddNewSortOrder() throws Exception 
	{

		waiting.explicitWaitVisibilityOfElement(sortOrder_AddNewSortOrder, 5);
		sortOrder_AddNewSortOrder.click();
		return this;
	}

	@Step("To Click On 'Add New Sort Order'")
	public ManufacturerPageObjects clickOnRemoveSortOrder() throws Exception
	{

		waiting.explicitWaitVisibilityOfElement(sortOrder_RemoveSortOrder, 5);
		sortOrder_RemoveSortOrder.click();
		return this;
	}

	@Step("To Verify the working of 'Reset' Button in Manufacturer and Brand")
	public ManufacturerPageObjects verifyManufacturersFormItemsAfterClickingResetButton(String manufacturerActiveStatus) throws Exception 
	{
		Thread.sleep(5000);
		String ManufacturerName = newManufacturersNameLocator.getAttribute("value");
		String ManufacturerCode = newManufacturersCodeLocator.getAttribute("value");
		Assert.assertEquals(ManufacturerName.length(), 0);
		Assert.assertEquals(ManufacturerCode.length(), 0);
		Assert.assertFalse((newManufacturersActiveStatus.isSelected()));
		return this;
	}

	@Step("To Verify the message after saving and Manufacturer without Name")
	public ManufacturerPageObjects verifyErrorMessageAfterSavingManufacturer(String errorMessage) throws Exception 
	{
		Thread.sleep(5000);

		assertThat(getDriver().findElement(By.xpath("//span[@id='addNewManufacturerForm:hmsgId']")).getText(), containsString(errorMessage));
		return this;	
	}

	@Step("To Verify the Character Limit for 'Manufacturer Name'")

	public ManufacturerPageObjects verifyCharacterLimitForManufacturersName(String maxChars) throws Exception 
	{
		waiting.explicitWaitVisibilityOfElement(newManufacturersNameLocator, 5);
		
			newManufacturersNameLocator.sendKeys(maxChars);
		
		String enteredText=newManufacturersNameLocator.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(newManufacturersNameLocator.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for 'Manufacturer Code'")

	public ManufacturerPageObjects verifyCharacterLimitForManufacturersCode(String maxLimitNum) 
	{
		waiting.explicitWaitVisibilityOfElement(newManufacturersCodeLocator, 5);
		
			newManufacturersCodeLocator.sendKeys(maxLimitNum);

		String enteredText=newManufacturersCodeLocator.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(newManufacturersCodeLocator.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand Name'")
	public ManufacturerPageObjects verifyCharacterLimitForBrandNameField() 
	{

		waiting.explicitWaitVisibilityOfElement(addNewBrand_BrandName, 5);
		for (int i=0; i< 100; i++)
		{
			addNewBrand_BrandName.sendKeys("0");
		}
		String enteredText=addNewBrand_BrandName.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addNewBrand_BrandName.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand Description'")
	public ManufacturerPageObjects verifyCharacterLimitForBrandDescField() 
	{

		waiting.explicitWaitVisibilityOfElement(addNewBrand_BrandDesc, 5);
		for (int i=0; i< 500; i++)
		{
			addNewBrand_BrandDesc.sendKeys("0");
		}
		String enteredText=addNewBrand_BrandDesc.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, 500);
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand URL'")
	public ManufacturerPageObjects verifyCharacterLimitForBrandURL() 
	{

		waiting.explicitWaitVisibilityOfElement(addNewBrand_BrandURL, 5);
		for (int i=0; i< 500; i++)
		{
			addNewBrand_BrandURL.sendKeys("0");
		}
		String enteredText=addNewBrand_BrandURL.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addNewBrand_BrandURL.getAttribute("maxlength")));
		return this;
	}

	@Step("To Click on 'Reset' button for Brands")
	public ManufacturerPageObjects clickOnResetBrandFields() 
	{

		waiting.explicitWaitVisibilityOfElement(addNewBrand_ResetBrandFields, 10);
		addNewBrand_ResetBrandFields.click();
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand URL'")
	public ManufacturerPageObjects verifyBrandsFieldsAfterClickingResetButton() throws Exception 
	{
		Thread.sleep(10000);
		String BrandName = addNewBrand_BrandName.getAttribute("value");
		String BrandDesc = addNewBrand_BrandDesc.getAttribute("value");
		String BrandURL = addNewBrand_BrandURL.getAttribute("value");
		Assert.assertEquals(BrandName.length(), 0);
		Assert.assertEquals(BrandDesc.length(), 0);
		Assert.assertEquals(BrandURL.length(), 0);
		return this;
	}

	@Step("To Click on 'Edit Manufacturer'")
	public ManufacturerPageObjects clickOnEditManufacturer(String manufacturersName) throws Exception 
	{
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//td[contains(.,'"+manufacturersName+"')]//preceding::input[@title='Edit Manufacturer']")).click();
		return this;
	}

	@Step("To Search for a 'Brand'")
	public ManufacturerPageObjects searchForBrand(String brandName) 
	{

		waiting.explicitWaitVisibilityOfElement(manufacturersSearchBox, 10);
		manufacturersSearchBox.clear();
		manufacturersSearchBox.sendKeys(brandName);
		manufacturersSearchIcon.click();
		return this;
	}

	@Step("To Click on Edit Brand Button'")
	public ManufacturerPageObjects clickOnEditBrand(String brandName) throws Exception 
	{
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//table[contains(@id,'brandTableId')]//td[contains(.,'"+brandName+"')]/..//div/input[@title='Edit Brand']")).click();
		return this;		
	}

	@Step("To Verify the Page after searching for an Brand'")
	public ManufacturerPageObjects verifyAfterSearchingForBrand(String brandName) throws Exception
	{
		Thread.sleep(5000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//table[contains(@id,'brandTableId')]//td[contains(.,'"+brandName+"')]")).isDisplayed(),"Brand Results is Displayed");
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on 'Remove Brand'")
	public ManufacturerPageObjects clickOnDeleteBrand() throws Exception 
	{
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//input[@title='Remove Brand']")).click();
		waiting.explicitWaitForAlert(10);
		tu.alertAccept();
		return this;
	}

	@Step("To Verify Message after deleting 'Brand'")
	public ManufacturerPageObjects verifyMessageAfterDeletingBrand(String brandDelMessage) throws Exception
	{
		Thread.sleep(5000);

		assertThat(getDriver().findElement(By.xpath("//form[@id='listManufacturerForm']//span[contains(@style,'green')and @id='listManufacturerForm:noResults']")).getText(),
				containsString(brandDelMessage));
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Click on 'Remove Manufacturer'")
	public ManufacturerPageObjects clickOnDeleteManufacturer() throws Exception 
	{
		Thread.sleep(5000);

		getDriver().findElement(By.xpath("//table[@id='listManufacturerForm:manufacturerTableId']//input[@title='Remove Manufacturer']")).click();
		waiting.explicitWaitForAlert(10);
		tu.alertAccept();
		return this;
	}

	@Step("To Verify Message after deleting 'Manufacturer'")
	public ManufacturerPageObjects verifyMessageAfterDeletingManufacturer(String manuDelMessage) throws Exception
	{
		Thread.sleep(5000);

		assertThat(getDriver().findElement(By.xpath("//form[@id='listManufacturerForm']//span[contains(@style,'green')and @id='listManufacturerForm:noResults']")).getText(),
				containsString(manuDelMessage));
		return this;
	}

	public ManufacturerPageObjects verifyAndRemoveBrand(String brandName) throws InterruptedException {
		Thread.sleep(4000);
		WebElement wb= getDriver().findElement(By.xpath("//td[contains(text(),'"+brandName+"')]/ancestor::td//preceding-sibling::td/descendant::input[@title='Remove Brand']"));
		waiting.explicitWaitVisibilityOfElement(wb, 20);
		wb.click();
		tu.alertAccept();
		return this;
	}

	public ManufacturerPageObjects removeAndVerifyManufacturer(String manufacturerName) throws InterruptedException {
		Thread.sleep(2000);

		WebElement wb=getDriver().findElement(By.xpath("//tbody[@id='listManufacturerForm:manufacturerTableId:tb']/descendant::td[contains(text(),'"+manufacturerName+"')]/preceding-sibling::td/descendant::input[@title='Remove Manufacturer']"));
		waiting.explicitWaitVisibilityOfElement(wb, 10);
		wb.click();
		tu.alertAccept();
		return this;
	}
	@Step("verification of success message after remove manufacturer")
	public ManufacturerPageObjects verifySuccessMessageAfterRemove(String successMessage) {

		
		waiting.explicitWaitVisibilityOfElement(successMessageRemoveMfgLocator, 20);
		Assert.assertEquals(successMessageRemoveMfgLocator.getText(), successMessage);

		return this;
	}

	public ManufacturerPageObjects clickOnListBrandItems(String brandName) {
		waiting.explicitWaitElementToBeClickable(By.xpath("//td[contains(text(),'"+brandName+"')]/preceding-sibling::td/descendant::input[@title='List BrandItems']"), 20);
		getDriver().findElement(By.xpath("//td[contains(text(),'"+brandName+"')]/preceding-sibling::td/descendant::input[@title='List BrandItems']")).click();
		

		
		return this;
	}

	public void verifyAfterSearchingForManufacturer2() throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertEquals(Integer.parseInt(manufacturersearchresultcount.getText().trim()),0);
		
		
	}

	@Step("Click on show field")
	public ManufacturerPageObjects clickOnShowField() throws InterruptedException {
		showfieldlistLocator.click();
		Thread.sleep(2000);
		return this;
	}
	
	
	@Step("clickOnRequiredFieldNames")
	public ManufacturerPageObjects clickOnRequiredFieldNames(String fieldnames) throws InterruptedException {
		
		String[] fields =  fieldnames.split(",");
		for(int i=0;i<fields.length;i++) {
			
			if(getDriver().findElement(By.xpath("//tbody[contains(@id,'listManufacturerForm')]/tr/td/span[contains(text(),'"+fields[i]+"')]/../../td[2]/*/*[1]")).isSelected()) {
				
				getDriver().findElement(By.xpath("//tbody[contains(@id,'listManufacturerForm')]/tr/td/span[contains(text(),'"+fields[i]+"')]/../../td[2]"));
			}
			else {
				getDriver().findElement(By.xpath("//tbody[contains(@id,'listManufacturerForm')]/tr/td/span[contains(text(),'"+fields[i]+"')]/../../td[2]")).click();
				Thread.sleep(1500);
			}
		}
		
		
		return this;
	}
	
	@Step("Verify Show field Table settings")
	public ManufacturerPageObjects verifyShowFieldsSettings() throws Exception {
	
		utility.assertElementPresent(getDriver().findElement(By.xpath("//table/thead/tr/th/div[contains(text(),'Field Names')]")));
		utility.assertElementPresent(getDriver().findElement(By.xpath("//table/thead/tr/th/div[contains(text(),'Desktop View')]")));
		utility.assertElementPresent(getDriver().findElement(By.xpath("//table/thead/tr/th/div[contains(text(),'Tablet View')]")));
		utility.assertElementPresent(getDriver().findElement(By.xpath("//table/thead/tr/th/div[contains(text(),'Mobile View')]")));
		utility.assertElementPresent(getDriver().findElement(By.xpath("//table/thead/tr/th/div[contains(text(),'Display Names')]")));
		return this;
	}
	
	@Step("Verify fields are reflected after saving changes")
	public ManufacturerPageObjects verifyFields(String fieldnames) throws Exception {
		Thread.sleep(2000);
		String[] fields =  fieldnames.split(",");
		for(int i=0;i<fields.length;i++) {
			if(fields[i].equals("Manufacturer Logo") ) {
				
				utility.assertElementPresent(getDriver().findElement(By.xpath("//th/div[contains(text(),'Manufacturer Logo')]")));
			}
			else {
			utility.assertElementPresent(getDriver().findElement(By.xpath("//th/div/span[contains(text(),'"+fields[i]+"')]")));
			}
		}
		return this;
	}
	
	
}