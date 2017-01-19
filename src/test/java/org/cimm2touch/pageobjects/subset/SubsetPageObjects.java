package org.cimm2touch.pageobjects.subset;
/**

 * @author Thiruveedhi Chinna
 *
 */

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.pageobjects.uom.UOMPageObjects;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;


public class SubsetPageObjects extends PageFactoryInitializer
{

	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());
	
	public void FluentWaitForVisibilityOfElement(int TotalTimeInSeconds, int PollingTimeInMilliSeconds, WebElement element)
	{
		
		FluentWait<RemoteWebDriver> waitForElement = new FluentWait<RemoteWebDriver>((RemoteWebDriver) getDriver());
		waitForElement	.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliSeconds,TimeUnit.MILLISECONDS)
				.ignoring(ElementNotVisibleException.class);
		
		waitForElement.until(ExpectedConditions.visibilityOf(element));
	}



	SearchDataPropertyFile data = new SearchDataPropertyFile();

	

	

	@FindBy(xpath="//a[@title='History']/img")
	private WebElement editSubset_ViewHistory;

	@FindBy(xpath="//div[@class='cimm_closeBtn']/img[@id='EditSubsetForm:closebtnId']")
	private WebElement editSubset_CloseForm;

	@FindBy(xpath="//span[@id='EditSubsetForm:subsetUpdateMsg']")
	private WebElement editSubset_UpdateMessage;

	@FindBy(xpath="//input[@title='Catalog Builder View']")
	private WebElement catalogBuilderView;

	
	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:AH']")
	private WebElement actionLocator;

	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:SL']")
	private WebElement slLocator;

	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:SID']")
	private WebElement SubsetIDLocator;

	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:SN']")
	private WebElement subsetNameLocator;

	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:SD']")
	private WebElement subsetDescriptionLocator;

	@FindBy(xpath="//textarea[@id='EditSubsetForm:sDes']")
	private WebElement subsetEditDescriptionLocator;


	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:PH']")
	private WebElement purposeLocator;

	@FindBy(xpath="//span[@id='subsetForm:subsetTableId:st']")
	private WebElement statusLocator;

	@FindBy(xpath="//span[@id='searchFormId:countVal']")
	private WebElement totalSubsetCountLocator;

	@FindBy(xpath="//td[contains(@id,'subsetID')]")
	private WebElement subsetIDLocator;

	@FindBy(xpath="//select[@id='searchFormId:nrpp']")
	private WebElement displayRecordLocator;

	@FindAll(value = {@FindBy(xpath="//table[@id='subsetForm:subsetTableId']/tbody/tr")})
	private List<WebElement> subsetTableRowCountLocator;

	

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchLocator;

	@FindBy(xpath="//a[@id='searchFormId:goBtn']/i")
	private WebElement subsetFormgobuttonLocator;

	@FindBy(xpath="//div[contains(text(),'Add New Subset')]")
	private WebElement addNewSubsetformLocator;

	@FindBy(xpath="//input[@id='addNewSubsetForm:sName']")
	private WebElement subsetFormNameLocator;

	@FindBy(id="addNewSubsetForm:subDes")
	private WebElement subsetFormDescriptionLocator;

	@FindBy(id="addNewSubsetForm:pId")
	private WebElement subsetFormPurposeLocator;

	@FindBy(id="addNewSubsetForm:status")
	private WebElement subsetFormStatusLocator;

	@FindBy(xpath="//input[@title='Save New Subset']")
	private WebElement subsetFormSaveLocator;

	@FindBy(xpath="//span[@id='addNewSubsetForm:subsetSaveMsg']")
	private WebElement subsetformSuccessMessageLocator;

	@FindAll(value={@FindBy(xpath="//input[@value='Remove']")})
	private List<WebElement> deleteButtons;

	@FindAll(value={@FindBy(xpath="//input[@value='Edit']")})
	private List<WebElement> editButtons;

	@FindAll(value={@FindBy(xpath="//input[@title='Catalog Builder View']")})
	private List<WebElement> catalogBuilderButtons;

	@FindBy(xpath="subsetForm:removeMsg")
	private WebElement verifyErrorMessageLocator;

	@FindBy(id="subsetForm:removeMsg")
	private WebElement subsetRemoveMessage;

	@FindBy(xpath="//span[contains(text(),'Subset Name')]")
	private WebElement addNewSubnetFormFields;

	@FindBy(xpath="//div[contains(text(),'Subset Description')]")
	private WebElement addNewSubnetFormFieldsSD;

	@FindBy(xpath="//div[contains(text(),'Purpose')]")
	private WebElement addNewSubsetFrompurpose;

	@FindBy(xpath="//div[contains(text(),'Status')]")
	private WebElement addNewSubsetFromStatus;

	@FindBy(xpath="//div[contains(text(),'Banner Text')]")
	private WebElement addNewSubsetFromBannertext;

	@FindBy(xpath="//span[contains(text(),'Subset Name required')]")
	private WebElement subsetRequiredmsg;

	@FindBy(xpath="//span[@id='EditSubsetForm:subsetUpdateMsg']")
	private WebElement subsetupdatemsg;

	@FindBy(xpath="//input[@title='Update Subset']")
	private WebElement updatesubsetbuttonLocator;

	@FindBy(xpath="//div[@class='manufacturer-search-header1']/span[contains(text(),'Manufacturer')]")
	private WebElement manufacturerLocator;

	@FindBy(xpath="//span[contains(text(),'Brand')]")
	private WebElement brandLocator;

	@FindBy(xpath="//td[contains(text(),'All Items')]")
	private WebElement allItemsLocator;

	@FindBy(xpath="//td[contains(text(),'Excluded Items')]")
	private WebElement excludedItemsLocator;

	

	@FindBy(xpath="//div[@class='manufacturer-search-header1']")
	private WebElement manufacturerExpandLocator;

	

	@FindAll(value={@FindBy(xpath="//span[@class='chkBxicon']/i")})
	private List<WebElement> manufacturerCheckbox;

	@FindBy(xpath="//input[@title='Save Rules']")
	private WebElement saveRulesIconLocator;
	
	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[1]/span")
	private WebElement selectedActionLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[2]/span")
	private WebElement selectedEntityNameLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[3]/span")
	private WebElement selectedEntityTypeLocator;

	

	@FindBy(xpath="//input[@title='Refresh Catalog']")
	private WebElement refreshCatalogLocator;

	
	@FindBy(xpath="//span[@id='subsetForm:removeMsg']")
	private WebElement succesfulMessageForDeleteSubset;
	
	@Step("verify the action label is {0} in subset page")
	public SubsetPageObjects verifyAction(String actionLabel) {
		Assert.assertEquals(actionLocator.getText().trim(),actionLabel );
		return this;
	}
	@Step("verify the Sl No. label is {0} in subset page")
	public SubsetPageObjects verifySlno(String SlNo) {
		Assert.assertEquals(slLocator.getText().trim(), SlNo);
		return this;
	}
	@Step("verify the subset id label is {0} in subset page")
	public SubsetPageObjects verifySubsetid(String subsetIdLabel) {
		Assert.assertEquals(SubsetIDLocator.getText().trim(),subsetIdLabel );
		return this;
	}

	@Step("verify the subset name label is {0} in subset page")
	public SubsetPageObjects verifySubsetName(String subsetNameLabel) {
		Assert.assertEquals(subsetNameLocator.getText().trim(),subsetNameLabel);
		return this;
	}
	@Step("verify the subset description label is {0} in subset page")
	public SubsetPageObjects verifySubsetDescription(String subsetDescription) {

		Assert.assertEquals(subsetDescriptionLocator.getText().trim(), subsetDescription);
		return this;
	}
	@Step("verify the subset purpose label is {0} in subset page")
	public SubsetPageObjects verifypurpose(String purposeLabel) {

		Assert.assertEquals(purposeLocator.getText().trim(), purposeLabel);
		return this;
	}
	@Step("verify the subset status label is {0} in subset page")
	public SubsetPageObjects verifystatus(String statusLabel) {

		Assert.assertEquals(statusLocator.getText().trim(), statusLabel);
		return this;
	}

	public String getOverallCount(){
		waiting.explicitWaitVisibilityOfElement(totalSubsetCountLocator, 5);
		String count = totalSubsetCountLocator.getText();
		return count;	
	}

	@Step("selecting {0} number of records to display")
	public SubsetPageObjects selectNumberOfRecordsToDisplay(String numberOfRecordsToDisplay){
		Select se = new Select(displayRecordLocator);
		se.selectByVisibleText(numberOfRecordsToDisplay);
		return this;
	}

	@Step("verify the pagination in subset page")
	public SubsetPageObjects verifyPagination(String numberOfRecordsToDisplay) throws Exception {
		Thread.sleep(3000);
		if (Integer.parseInt(getOverallCount()) >= Integer.parseInt(numberOfRecordsToDisplay)){
			Assert.assertEquals(subsetTableRowCountLocator.size(), Integer.parseInt(numberOfRecordsToDisplay));
		}
		return this;
	}

	@Step("Searching an subset in subset page")
	public SubsetPageObjects serchSubset(String subsetName) throws InterruptedException{
		Thread.sleep(1500);
		searchLocator.clear();
		searchLocator.sendKeys(subsetName);
		subsetFormgobuttonLocator.click();
		return this;
	}
	@Step("cick on add new subset link")
	public SubsetPageObjects clickOnnewSubsetLink() throws InterruptedException{
		Thread.sleep(1500);
		addNewSubsetLocator.click();
		return this;
	}
	@Step("click asserting the add new subset form")
	public SubsetPageObjects verifySubsetForm(String subsetFormLabel){
		Assert.assertEquals(addNewSubsetformLocator.getText(),subsetFormLabel);
		return this;
	}
	@Step("Entering the subset name")
	public SubsetPageObjects enterSubsetName(String subsetName) throws InterruptedException{
		Thread.sleep(1500);
		subsetFormNameLocator.sendKeys(subsetName);
		return this;
	}
	@Step("Entering the subset description")
	public SubsetPageObjects enterSubsetDesc(String subsetDescription){  
		subsetFormDescriptionLocator.sendKeys(subsetDescription);
		return this;
	}
	@Step("Selecting purpose on subset")
	public SubsetPageObjects selectPurpose(String purpose){
		Select se= new Select(subsetFormPurposeLocator);
		se.selectByVisibleText(purpose);
		return this;	
	}
	@Step("Selecting status on subset")
	public SubsetPageObjects selectstatus(String status){
		Select se1= new Select(subsetFormStatusLocator);
		se1.selectByVisibleText(status);  
		return this;	
	}
	@Step("click on save button in subset form")
	public SubsetPageObjects clickSave(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",subsetFormSaveLocator);
		return this;
	}
	@Step("verifying add new subset page")
	public SubsetPageObjects verifySuccessMessage(String successmsg) throws Exception{
		Thread.sleep(3000);
		Assert.assertEquals(subsetformSuccessMessageLocator.getText(), successmsg);
		return this;
	}
	@Step("Reading the subset id for asserting")
	public String getsubsetId(){
		return subsetIDLocator.getText().trim();
	}

	public  SubsetPageObjects addNewSubset(String addNewSubset,String subsetName,String subsetDescription,String purpose,String status,String successmsg) throws Exception {
		serchSubset(subsetName);
		try
		{
			Thread.sleep(1500);

			if(getDriver().findElement(By.xpath("//span[@id='subsetForm:noResults']")).isDisplayed())
			{
				clickOnnewSubsetLink();
				verifySubsetForm(addNewSubset);
				enterSubsetName(subsetName);
				enterSubsetDesc(subsetDescription);
				selectPurpose(purpose);
				selectstatus(status);
				clickSave();
				verifySuccessMessage(successmsg);
			}
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return this;
	}


	public SubsetPageObjects subsetDelete(String subsetName) throws Exception {
		Thread.sleep(1500);
		serchSubset(subsetName);
		Thread.sleep(1500);

		WebElement verifySubsetNameLocator= getDriver().findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]"));
		if(subsetName.trim().equals(verifySubsetNameLocator.getText().trim())){
			String substId = getsubsetId();
			clickOnSpecificDeleteButton(1);
			tu.alertAccept();
			Thread.sleep(2000);
			Assert.assertEquals(subsetRemoveMessage.getText(),"Subset - : '"+subsetName+"'with Subset Id -'"+substId+"' removed Successfully");
		}
		return this;
	}
	@Step("Deleting the created subset")
	public SubsetPageObjects clickOnSpecificDeleteButton(int specificDeleteButton){
		deleteButtons.get(specificDeleteButton-1).click();
		return this;
	}
	@Step("Verifying the search field for invalid data")
	public HomePageObjects searchSubsetInvlaidData(String subsetName,String subsetErrorMessage) throws InterruptedException {
		serchSubset(subsetName);
		Thread.sleep(1500);

		Assert.assertEquals(getDriver().findElement(By.xpath("//span[@id='subsetForm:noResults']")).getText().trim(), subsetErrorMessage.trim());	
		return new HomePageObjects();
	}
	@Step("Verifying the subset name field in add new subset form")
	public SubsetPageObjects VerifySubsetNameAddNewSubset(String AddsubsetFormsubsetname){
		Assert.assertEquals(addNewSubnetFormFields.getText().trim(), AddsubsetFormsubsetname);
		return this;
	}
	@Step("Verifying the subset description field in add new subset form")
	public SubsetPageObjects verifySubsetFromsD(String SubsetDescriptionForm){
		Assert.assertEquals(addNewSubnetFormFieldsSD.getText().trim(), SubsetDescriptionForm);
		return this;
	}
	@Step("Verifying the subset purpose dropdown in add new subset form")
	public SubsetPageObjects verifySubsetFromPurpose(String SubsetPurposeForm){
		Assert.assertEquals(addNewSubsetFrompurpose.getText().trim(), SubsetPurposeForm);
		return this;
	}
	@Step("Verifying the subset status dropdown in add new subset form")
	public SubsetPageObjects verifySubsetFromStatus(String AddNewSubSetFormStatus){
		Assert.assertEquals(addNewSubsetFromStatus.getText().trim(), AddNewSubSetFormStatus);
		return this;
	}
	@Step("Verifying the subset banner text dropdown in add new subset form")
	public SubsetPageObjects verifySubsetFromBannertext(String AddNewSubSetFormBannertext){
		Assert.assertEquals(addNewSubsetFromBannertext.getText().trim(), AddNewSubSetFormBannertext);
		return this;
	}

	
	@Step("Verifying the subset name required message in add new subset form")
	public SubsetPageObjects verifyErrorMsg(String subsetRequiredMsg) throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(subsetRequiredmsg.getText().trim(), subsetRequiredMsg);
		return this;
	}
	@Step("clicking edit button of searched subset")
	public SubsetPageObjects clickOnSpecificEditButton(int specificEditButton) throws InterruptedException{
		Thread.sleep(1500);
		editButtons.get(specificEditButton-1).click();
		return this;
	}
	@Step("clicking catalogbuilder button of searched subset")
	public SubsetPageObjects clickOnSpecificCatelogBuilderButton(int specificCatlogBuilderButton) throws InterruptedException{
		Thread.sleep(1500);
		catalogBuilderButtons.get(specificCatlogBuilderButton-1).click();
		return this;
	}

	
	@Step("clicking on update subset button in update subset form")
	public SubsetPageObjects clickOnUpdateSubset(){
		updatesubsetbuttonLocator.click();
		return this;
	}
	@Step("Verifies update of subsets")
	public SubsetPageObjects updateSubset(String newSubsetDescription,String subsetsucmsg) throws InterruptedException {
		Thread.sleep(2000);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",subsetEditDescriptionLocator);
		subsetEditDescriptionLocator.sendKeys(newSubsetDescription);
		clickOnUpdateSubset();
		Thread.sleep(2000);
		Assert.assertEquals(subsetupdatemsg.getText().trim(), subsetsucmsg);
		return this;
	}
	
	
	
	@FindBy(xpath="//td[contains(text(),'Selected')]")
	private WebElement selectedLocator;
	public SubsetPageObjects clickOnSelectedLink() throws InterruptedException {
		Thread.sleep(2000);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",selectedLocator);
		return this;
	}
	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/tbody/tr[1]/td[2]")
	private WebElement selectedManufactrerLocator;
	
	public SubsetPageObjects verifySelectedManufacturer(String Manufacturername) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(selectedManufactrerLocator.getText().trim(), Manufacturername);
		return this;
	}
	public SubsetPageObjects verifyingcontentSelectedTabs(String action,String EntityName,String EntityType) {

		waiting.explicitWaitVisibilityOfElement(selectedActionLocator, 3);
		Assert.assertEquals(selectedActionLocator.getText().trim(), action);
		Assert.assertEquals(selectedEntityNameLocator.getText().trim(), EntityName);
		Assert.assertEquals(selectedEntityTypeLocator.getText().trim(), EntityType);
		return this;
	}
	@FindBy(xpath="//input[@title='Remove Manufacturer / Brand from Rule Book']")
	private WebElement deleteIconLocator;
	
	public SubsetPageObjects clickOnSpecificManufacturer(String getmanufacturername) {

		getDriver().findElement(By.xpath("//td[contains(text(),'"+getmanufacturername+"')]/preceding-sibling::td/label")).click();
		return this;
	}
	public SubsetPageObjects clickOnRefreshCatalog() throws InterruptedException {
		Thread.sleep(2000);
		refreshCatalogLocator.click();
		return this;
	}
	
	@FindBy(xpath="//div[@class='tabContentWrap']/form/div/table/tbody/tr[1]/td[3]")
	private WebElement ItemPartnumberLocator;

	public SubsetPageObjects verifyItemInAllItems(String partNumberField) {
		Assert.assertEquals(ItemPartnumberLocator.getText(), partNumberField);
		return this;
	}

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchkeywordLocator;

	public SubsetPageObjects enterSearchkeyword(String partNumberField) throws InterruptedException {
		Thread.sleep(2000);
		searchkeywordLocator.sendKeys(partNumberField);
		return this;
	}
	
	@FindBy(xpath="//table[@id='searchFormId:searchedItemTableId']/tbody/tr[1]/td[3]")
	private WebElement searchedItemlocator;  
	public SubsetPageObjects verifySearchedResults(String partNumberField) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(searchedItemlocator.getText().trim(), partNumberField);
		return this;
	}
	public SubsetPageObjects clickOnSearchButton() {
		searchButtonLocator.click();
		return this;
	}
	@FindBy(xpath="//td[contains(text(),'Additional Items')]")
	private WebElement additionalItemsLocator;
	public SubsetPageObjects clickOnAdditionalItemsLink() throws InterruptedException {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",additionalItemsLocator);
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath="//td[contains(text(),'123123123123')]/ancestor::td/preceding-sibling::td/table/descendant::span")
	private WebElement sourceItemLocator;
	
	@FindBy(xpath="//div[@class='tableLayout']")
	private WebElement additionalItemsTableLocator;
	
	public SubsetPageObjects dragDropAnItem() throws InterruptedException {
		Thread.sleep(3000);

		Actions builder = new Actions(getDriver());
		builder.clickAndHold(sourceItemLocator).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(additionalItemsTableLocator, 0, 0).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 5).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 10).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 15).build().perform();
		builder.release().build().perform();
		return this;
	}
	@FindBy(xpath="//input[@title='Remove Included Items']")
	private WebElement itemRemoveFromAdditionalItemsTab;

	public SubsetPageObjects clickOnRemoveItem() {
		itemRemoveFromAdditionalItemsTab.click();

		tu.alertAccept();
		return this;
	}
	
	@FindBy(xpath="//a[contains(text(),'Subset Items')]")
	private WebElement subsetItemsLinkLocator;

	public SubsetPageObjects clickOnSubsetItemsLink() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(subsetItemsLinkLocator, 10);
		subsetItemsLinkLocator.click();
		Thread.sleep(2000);
		return this;	
	}
	@FindBy(xpath="//input[@id='listSubsetItems:subsetCombocomboboxField']")
	private WebElement subsetDropdownLocator;
	
	public SubsetPageObjects selectSubset(String getsubsetNamedata) throws InterruptedException {
		subsetDropdownLocator.clear();
		subsetDropdownLocator.sendKeys(getsubsetNamedata);
		Thread.sleep(2500);
		return this;
	}
	

	@FindBy(xpath="//table[@id='searchFormId:subsetItemTableId']/tbody/tr/td[5]")
	private WebElement subsetItemsLocator;
	
	public SubsetPageObjects verifySubsetItems(String partNumberField) {
		Assert.assertEquals(subsetItemsLocator.getText().trim(), partNumberField);
		return this;
	}
	
	
	
	
	
	
	
	@FindBy(xpath="//div[@class='breadCrumbs']/descendant::a[text()='Subset']")
	private static WebElement subsetbreadcrumb;

	@Step("check whether page is subset page")
	public  SubsetPageObjects checkSubsetPage() throws Exception{


		utility.assertElementPresent(subsetbreadcrumb);
		Thread.sleep(2000);
		return this;
	}

	

	@Step("veify subset {0} present or not")
	public SubsetPageObjects verifySubsetPresent(String subsetname) throws Exception
	{
		Assert.assertFalse(assertVerifySubsetPresent(subsetname),"subset:---"+ subsetname+"is already present, please remove to create it again.");
		return this;

	}
	private boolean assertVerifySubsetPresent(String subsetname) throws Exception
	{
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getDriver().findElement(By.xpath(" //tbody[@id='subsetForm:subsetTableId:tb']/descendant::span[text()='"+subsetname+"']")).isDisplayed())
			{
				return true;
			}
		}
		catch(NoSuchElementException e) {
			return false;

		}
		return false;		    
	}
	
	
	@Step("verify created subset name{0}")
	public SubsetPageObjects verifyCreatedSubset(String subsetname) throws Exception {
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifySubsetPresent(subsetname), "UOM :" + subsetname + "  is not present.");
		return this;
	}
	
	
	public SubsetPageObjects verifySubsetBeforeRemove(String subsetName) throws Exception {
		Assert.assertFalse(assertVerifySubsetPresent(subsetName),"subset is not available, Please create before remove");
		return this;
	}
	
	
	

	@FindBy(xpath="//*[@title='Add New Subset']")
	private static WebElement addnewsubsetbutton;

	@Step("click on add subset button")
	public  SubsetPageObjects clickOnSubsetButton() throws InterruptedException{

		addnewsubsetbutton.click();
		Thread.sleep(2000);
		return this;
	}

	@FindBy(id="addNewSubsetForm:sName")
	private static WebElement subsetnamefield;

	@Step("click on add subset button")
	public  SubsetPageObjects typeInSubsetNameField(String subsetname){
		subsetnamefield.clear();
		subsetnamefield.sendKeys(subsetname);
		return this;
	}

	@FindBy(xpath="//form[@id='addNewSubsetForm']/div[4]/div[11]/input")
	private static WebElement savenewsubsetbutton ;

	@Step("click on save subset button")
	public  SubsetPageObjects clickOnSubsetSave() throws InterruptedException{
		savenewsubsetbutton.click();
		Thread.sleep(3000);
		return this;
	}

	@FindBy(xpath="//span[contains(text(),'New Subset saved Successfully')]")
	private  WebElement subsetSaveMessageLocator ;

	@Step("check whether subset got saved successfully")
	public  SubsetPageObjects verifySubsetCreationMessage(String subsetSaveMessage) throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(subsetSaveMessageLocator.getText(),subsetSaveMessage);

		return this;
	}

	

	@Step("To Click On Add new Subset")
	public SubsetPageObjects clickOnAddNewSubset() throws InterruptedException 
	{
		waiting.explicitWaitVisibilityOfElement(addNewSubsetLocator, 65);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", addNewSubsetLocator);
		Thread.sleep(1500);
		return this;
	}

	

	

	@Step("To Search for Subset {0}.")
	public SubsetPageObjects searchForAnSubset(String subsetName) throws InterruptedException 
	{

		waiting.explicitWaitVisibilityOfElement(searchFieldLocator, 40);
		searchFieldLocator.clear();
		searchFieldLocator.sendKeys(subsetName);
		searchButtonLocator.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("To Verify the Search Results After Searching for an Subset {0}.")
	public SubsetPageObjects verifyAfterSearchingForSubset(String subsetName) throws Exception 
	{
		Thread.sleep(5000);

		Assert.assertTrue(getDriver().findElement(By.xpath("//table[@id='subsetForm:subsetTableId']//span[contains(.,'"+subsetName+"')]")).isDisplayed());
		return this;
	}

	
	
	

	@Step("To Click On 'Edit Subset' {0}.")
	public SubsetPageObjects clickOnEditSubset(String subsetName) throws Exception 
	{
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[text()='"+subsetName+"']/ancestor::tr/descendant::input[@title='Edit Subset']"), 45);

		getDriver().findElement(By.xpath("//span[text()='"+subsetName+"']/ancestor::tr/descendant::input[@title='Edit Subset']")).click();
		return this;
	}

	
	@Step("To Verify the Message after Updating Subset.")
	public SubsetPageObjects verifyMessageAfterUpdatingSubset(String updateMessage) 
	{
		FluentWaitForVisibilityOfElement(10, 500, editSubset_UpdateMessage);
		assertThat(editSubset_UpdateMessage.getText(), containsString(updateMessage));
		return this;
	}

	@Step("To Verify the Message after Updating Subset.")
	public SubsetPageObjects clickOnCatalogBuilderView(String subsetName) throws Exception 
	{
		Thread.sleep(7000);
		try
		{

			new Actions(getDriver()).doubleClick(catalogBuilderView).build().perform();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",catalogBuilderView);
		Thread.sleep(7000);
		return this;
	}


	
	
	
	
	
	
	public String verifyandDeleteSubset(String subsetName) throws Exception {
		
		Thread.sleep(3000);
		
		WebElement wb=getDriver().findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]/ancestor::td//preceding-sibling::td/descendant::input[@value='Remove']"));
		
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]")).getText(), subsetName,""+subsetName+" is not available");
		
		String subsetId=getDriver().findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]/ancestor::td//preceding-sibling::td[1]")).getText();
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",wb);
		tu.alertAccept();
		return subsetId;
	}
	public SubsetPageObjects verifySuccessMessageForDeletionOfSubset( String subsetName,String subsetId) throws InterruptedException {
	
		Thread.sleep(3000);
		Assert.assertEquals(succesfulMessageForDeleteSubset.getText(), "Subset - : '"+subsetName+"'with Subset Id -'"+subsetId+"' removed Successfully");	
		
		
		return this;
	}
	
	
	
	@FindAll(value={@FindBy(xpath="//thead[@class='rich-table-thead']/descendant::th")})
	private List<WebElement> headerPartLinkLocator;
	
	public SubsetPageObjects verifyHeaderPartOfSubsetPage(String headerList) {
		         String[] headerList1 = headerList.split(",");
		         waiting.explicitWaitVisibilityOfElements(headerPartLinkLocator, 35);
		         for(int i=0; i<headerPartLinkLocator.size();i++)
		         {
		        	 Assert.assertEquals(headerPartLinkLocator.get(i).getText().trim(), headerList1[i].trim());
		         }
		return this;
		
	}
	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchFieldLocator;
	
	public SubsetPageObjects verifySearchFieldOfSubsetPage(String placeHolderText) {
		waiting.explicitWaitVisibilityOfElement(searchFieldLocator, 40);
		Assert.assertTrue(searchFieldLocator.isDisplayed(), "Search field in Subset page is not displayed");
		Assert.assertEquals(searchFieldLocator.getAttribute("placeholder"), placeHolderText);
	
		return this;
		
	}
	
	@FindBy(xpath="//a[@title='Add New Subset']")
	private WebElement addNewSubsetLocator;
	
	public SubsetPageObjects verifyAddNewSubsetButtonInSubsetpage() {
		waiting.explicitWaitVisibilityOfElement(addNewSubsetLocator, 40);
		Assert.assertTrue(addNewSubsetLocator.isDisplayed(), "Add New Subset is not displayed");
		return this;
	}
	@FindBy(xpath="//a[@id='searchFormId:goBtn']/i[@class='list-search-icn fa fa-search']")
	private WebElement searchButtonLocator;
	
	@Step("click on subsetsearch button")
	public SubsetPageObjects clickOnSubsetSearchGoButton() throws InterruptedException {
		Thread.sleep(2500);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchButtonLocator);
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'No results Found')]")
	private WebElement noResultFoundLocator;
	
	@Step("verify no result found error message")
	public SubsetPageObjects verifyErrorMessage(String errorMessage) {
		waiting.explicitWaitVisibilityOfElement(noResultFoundLocator, 35);
		Assert.assertEquals(noResultFoundLocator.getText(), errorMessage);
		return this;
	}
	
	@FindAll(value={@FindBy(xpath="//form[@id='addNewSubsetForm']/descendant::div[@class='cimm_formLabel']")})
	private List<WebElement> allAddNewSubsetFieldsLocator;
	
	@Step("verify fields when click on add link of Subset page")
	public SubsetPageObjects verifyAllAddNewSubsetFields(String addNewSubsetField) {
		String[] addNewSubsetField1 = addNewSubsetField.split(",");
		waiting.explicitWaitVisibilityOfElements(allAddNewSubsetFieldsLocator, 45);
		for(int i =0; i<allAddNewSubsetFieldsLocator.size();i++)
		{
			Assert.assertEquals(allAddNewSubsetFieldsLocator.get(i).getText().trim(), addNewSubsetField1[i].trim());
			
		}
		return this;
	}
	
	@FindBy(xpath = "//form[@id='addNewSubsetForm']/descendant::input[@title='Save New Subset']")
	private WebElement subsetSaveLink;
	
	@Step("verify save link of add new subset page")
	public SubsetPageObjects verifySaveLinkInAddNewSubsetPage() {
		waiting.explicitWaitVisibilityOfElement(subsetSaveLink, 40);
		Assert.assertTrue(subsetSaveLink.isDisplayed(), "save link of add new subset page doesn't display");
		return this;
	}
	
	
	@Step("click on save link of subset")
	public SubsetPageObjects clickOnSaveLink() throws InterruptedException {
		subsetSaveLink.click();
		Thread.sleep(2500);
		return this;
	}
	public SubsetPageObjects createSubset(String subsetName, String subsetDescription) throws InterruptedException {
		
		clickOnAddNewSubset();
		enterTheSubsetName(subsetName)
		.enterTheSubsetDescription(subsetDescription)
		.clickOnSaveLink();
		return this;
		
	}
	@Step("enter UOM Name:{0}")
	public SubsetPageObjects enterTheSubsetName(String subsetName) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(subsetNameTextBox, 30);
		
		subsetNameTextBox.clear();
		
		subsetNameTextBox.sendKeys(subsetName);
		return this;
	}
	@Step("enter UOM Des:{0}")
	public SubsetPageObjects enterTheSubsetDescription(String subsetDescription) {
		
		waiting.explicitWaitVisibilityOfElement(subsetDescriptionTextBox, 40);
		subsetDescriptionTextBox.clear();
		
		subsetDescriptionTextBox.sendKeys(subsetDescription);
		
		return this;
	}
	@FindBy(xpath = "//input[@id='addNewSubsetForm:sName']")
	private WebElement subsetNameTextBox;
	
	
	
	@FindBy(xpath = "//textarea[@id='addNewSubsetForm:subDes']")
	private WebElement subsetDescriptionTextBox;
	
	@Step("create updated subset name:{0}")
	public SubsetPageObjects createUpdatedUom(String updatedSubsetName) {
		
		enterTheUpdatedSubsetName(updatedSubsetName);
		return this;
	}
	
	@Step("enter updated Subset Name:{0}")
	public SubsetPageObjects enterTheUpdatedSubsetName(String updatedSubsetName) {

		waiting.explicitWaitVisibilityOfElement(updatedSubsetNameTextBoxLocator, 30);
		updatedSubsetNameTextBoxLocator.clear();
		updatedSubsetNameTextBoxLocator.sendKeys(updatedSubsetName);
		return this;
	}

	
	@FindBy(xpath = "//input[@id='EditSubsetForm:sName']")
	private WebElement updatedSubsetNameTextBoxLocator;
	
	@Step("click on update link")
	public SubsetPageObjects clickOnUpdateSubsetLink() {
		waiting.explicitWaitVisibilityOfElement(updateSubsetLocator, 30);
		updateSubsetLocator.click();
             return this;		
	}
	
	
	@FindBy(xpath = "//input[@title='Update Subset']")
	private WebElement updateSubsetLocator;
	
	@Step("verifying update  welcome message {0}")
	public SubsetPageObjects verifyUpdateWelcomeMessage(String updateMessage) {
		waiting.explicitWaitVisibilityOfElement(updateMessageLocator, 15);
		
		Assert.assertEquals(updateMessageLocator.getText(), updateMessage,
				"Invalid update welcome message.Getting" + updateMessageLocator.getText() + ".");
		return this;
		
	}
	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement updateMessageLocator;
	
	@Step("verify fields of edit in Subset page")
	public SubsetPageObjects verifyAllEditSubsetFields(String editFieldOfSubset) {
		String editFieldOfSubset1[] = editFieldOfSubset.split(",");
		waiting.explicitWaitVisibilityOfElements(allEditSubsetFieldsLocator, 55);
		for (int i = 0; i < allEditSubsetFieldsLocator.size(); i++) {
			
			Assert.assertEquals(allEditSubsetFieldsLocator.get(i).getText().trim(), editFieldOfSubset1[i].trim());
		}
		return this;
	}
	
	@FindAll(value = {
			@FindBy(xpath = "//form[@id='EditSubsetForm']/descendant::div[@class='cimm_formLabel']") })
	private List<WebElement> allEditSubsetFieldsLocator;
	
	@Step("selecting {0} number of records to display.")
	public SubsetPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay) throws InterruptedException {
		Select select = new Select(selectRecordsDropdownLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(4000);
		return this;
		
	}
	@FindBy(xpath = "//div[contains(text(),'Display ')]/select")
	private WebElement selectRecordsDropdownLocator;
	
	@Step("verifying whether {0} is the number of records that is displayed.")
	public SubsetPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception {
		Thread.sleep(3500);
		try {

			waiting.explicitWaitVisibilityOfElements(numberOfRowCountLocator, 60);
			Assert.assertTrue(
					assertForNumberOfRowsDisplayed(numberOfRowCountLocator.size(),
							Integer.parseInt(getNumberOfRecordsToDisplay)),
					"DISPLAYED RECORDS WERE MORE THAN EXPECTED");
		} catch (StaleElementReferenceException e) {

			getDriver().navigate().refresh();
			verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
		}
		return this;
	}



private boolean assertForNumberOfRowsDisplayed(int rowCount, int numberOfRecordsToDisplay) {
		if (rowCount <= numberOfRecordsToDisplay) {
			return true;
		} else {
			return false;
		}
	}
@FindAll(value={@FindBy(xpath="//tbody[@id='subsetForm:subsetTableId:tb']/tr")})
private List<WebElement> numberOfRowCountLocator;

public SubsetPageObjects createSubsetWithoutMandatoryField(String subsetDescription) throws InterruptedException {
	                 enterTheSubsetDescription(subsetDescription)
	                        .clickOnSaveLink();
                                return this;	
}
public SubsetPageObjects verifySubsetNameIsRequired(String requiredMessage) throws InterruptedException {
	                Thread.sleep(2000);
	                     Assert.assertEquals(requiredMessageLocator.getText(), requiredMessage);
	                                    return this;
	
}
@FindBy(xpath="//span[contains(text(),'Subset Name required')]")
private WebElement requiredMessageLocator;


@FindBy(xpath="//a[contains(text(),'Featured Products Disp Pricing')]")
private WebElement featuredProductPriceLink;






public SubsetPageObjects clickOnFeaturedProductsDispPricingLink() throws InterruptedException {
	
	waiting.explicitWaitVisibilityOfElement(featuredProductPriceLink, 10);
	featuredProductPriceLink.click();
	Thread.sleep(2000);
	return this;	
}
	
}	