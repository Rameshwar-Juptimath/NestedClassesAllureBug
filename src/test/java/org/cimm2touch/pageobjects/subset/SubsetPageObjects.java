package org.cimm2touch.pageobjects.subset;
/**
 * @author Gladson Antony
 *
 */

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;


public class SubsetPageObjects extends PageFactoryInitializer
{
	public void FluentWaitForVisibilityOfElement(int TotalTimeInSeconds, int PollingTimeInMilliSeconds, WebElement element)
	{
		org.openqa.selenium.support.ui.FluentWait<WebDriver> waitForElement = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliSeconds,TimeUnit.MILLISECONDS)
				.ignoring(ElementNotVisibleException.class);
		
		waitForElement.until(ExpectedConditions.visibilityOf(element));
	}


	TestUtility tu = new TestUtility();
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(xpath="//div[@id='left-nav-container']//a[text()='Subset']")
	private WebElement leftSlider_Subset;

	@FindBy(xpath="//div[@id='left-nav-container']//a[text()='Subset Items']")
	private WebElement leftSlider_SubsetItems;

	@FindBy(xpath="//div[@id='left-nav-container']//a[text()='Featured Products Disp Pricing']")
	private WebElement leftSlider_FeaturedProducts;

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId' and @placeholder='Enter Subset Name to Search']")
	private WebElement subset_SearchBox;

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId' and @placeholder='Enter Subset Name to Search']//following::a[@id='searchFormId:goBtn']")
	private WebElement subset_SearchIcon;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_Action;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_SlNo;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_SubsetID;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_SubsetName;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_SubsetDescription;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_Purpose;

	@FindBy(id="subsetForm:subsetTableId:actionCol")
	private WebElement col_Status;

	@FindBy(xpath="//a[@id='subsetForm:nextBtnId']/i")
	private WebElement subsetPagination_NextButton;

	@FindBy(xpath="//a[@id='subsetForm:prevBtnId']/i")
	private WebElement subsetPagination_PreviousButton;

	@FindBy(xpath="//a[@id='subsetForm:lastBtnId']/i")
	private WebElement subsetPagination_LastButton;

	@FindBy(xpath="//a[@id='subsetForm:firstBtnId']/i")
	private WebElement subsetPagination_FirstButton;

	@FindBy(xpath="//div[@class='total-count']/span[@id='subsetForm:selectNo']")
	private WebElement subsetPagination_CurrentPageCount;

	@FindBy(xpath="//div[@class='total-count']/span[@id='subsetForm:tnpId']")
	private WebElement subsetPagination_TotalPagesCount;

	@FindBy(xpath="//div[@class='topNav_rightIcons']//a[@title='Add New Subset']")
	private WebElement subset_AddNewSubsetButton;

	@FindBy(xpath="//form[@id='addNewSubsetForm']//input[@id='addNewSubsetForm:sName']")
	private WebElement addSubset_SubsetName;

	@FindBy(xpath="//form[@id='addNewSubsetForm']//textarea[@id='addNewSubsetForm:subDes']")
	private WebElement addSubset_SubsetDescription;

	@FindBy(xpath="//select[@id='addNewSubsetForm:pId']")
	private WebElement addSubset_SubsetPurpose;

	@FindBy(xpath="//select[@id='addNewSubsetForm:status']")
	private WebElement addSubset_SubsetStatus;

	@FindBy(xpath="//iframe[@id='addNewSubsetForm:addNewbannerEditorIdTextArea_ifr']")
	private WebElement addSubset_BannerText;

	@FindBy(xpath="//input[@title='Save New Subset']")
	private WebElement addSubset_SaveNewSubset;

	@FindBy(xpath="//input[@id='addNewSubsetForm:btnReset']")
	private WebElement addSubset_ResetSubset;

	@FindBy(xpath="//div[@class='cimm_closeBtn']")
	private WebElement addSubset_CloseSubsetForm;

	@FindBy(xpath="//span[@id='addNewSubsetForm:subsetSaveMsg' and contains(@style,'green')]")
	private WebElement addSubset_SaveMessageLocator;

	@FindBy(xpath="//input[@id='EditSubsetForm:sName']")
	private WebElement editSubset_SubsetName;

	@FindBy(xpath="//textarea[@id='EditSubsetForm:sDes']")
	private WebElement editSubset_SubsetDesc;

	@FindBy(xpath="//select[@id='EditSubsetForm:pId2']")
	private WebElement editSubset_Purpose;

	@FindBy(xpath="//select[@id='EditSubsetForm:status']")
	private WebElement editSubset_Status;

	@FindBy(xpath="//iframe[@id='EditSubsetForm:bannerEditorIdTextArea_ifr']")
	private WebElement editSubset_BannerText;

	@FindBy(xpath="//input[@title='Update Subset']")
	private WebElement editSubset_UpdateSubset;

	@FindBy(xpath="//a[@title='History']/img")
	private WebElement editSubset_ViewHistory;

	@FindBy(xpath="//div[@class='cimm_closeBtn']/img[@id='EditSubsetForm:closebtnId']")
	private WebElement editSubset_CloseForm;

	@FindBy(xpath="//span[@id='EditSubsetForm:subsetUpdateMsg']")
	private WebElement editSubset_UpdateMessage;

	@FindBy(xpath="//input[@title='Catalog Builder View']")
	private WebElement catalogBuilderView;

	@FindBy(xpath="//form[@id='subsetList']/descendant::td[contains(@class,'rich-tabhdr')]/descendant::tr/td[text()='Available']")
	private WebElement CBV_Available;

	@FindBy(xpath="//form[@id='subsetList']/descendant::td[contains(@class,'rich-tabhdr')]/descendant::tr/td[text()='Selected']")
	private WebElement CBV_Selected;

	@FindBy(xpath="//div[@class='manufacturer-search-header1']//span[contains(.,'Manufacturer')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_Available_AddManufacurer;

	@FindBy(xpath="//div[@class='attr-search-header1']//span[contains(.,'Brand')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_Available_AddBrand;

	//@FindBy(xpath="//div[@class='manufacturer-search-body1 hideMe']/div[@class='searchTxtWrap']/input[@class='manufacturerSearchTextBox' and @Placeholder='Enter Manufacturer to Search']")
	@FindBy(xpath="//form[@id='subsetList']//descendant::input[@class='manufacturerSearchTextBox']")
	private WebElement CBV_Available_AddManufacurer_SearchBox;

	@FindBy(xpath="//form[@id='subsetList']//descendant::input[@class='brandSearchTextBox']")
	private WebElement CBV_Available_AddBrand_SearchBox;

	@FindBy(xpath="//div[@class='cimmSearchTxt']/input[@id='searchFormId:searchKeywordId']")
	private WebElement CBV_SearchItem;

	@FindBy(xpath="//select[@id='searchFormId:searchInId']/option[text()='Part Number or Keywords']")
	private WebElement CBV_SearchType_PartNumberOrKeywords;

	@FindBy(xpath="//select[@id='searchFormId:searchInId']/option[text()='Part Number ']")
	private WebElement CBV_SearchType_PartNumber;

	@FindBy(xpath="//select[@id='searchFormId:searchInId']/option[text()='Manufacturer Part Number']")
	private WebElement CBV_SearchType_ManufacturerPartNumber;

	@FindBy(xpath="//select[@id='searchFormId:searchInId']/option[text()='Customer Part Number']")
	private WebElement CBV_SearchType_CustomerPartNumber;

	@FindBy(xpath="//select[@id='searchFormId:searchInId']/option[text()='CIMM Item Id']")
	private WebElement CBV_SearchType_CIMMItemID;

	@FindBy(xpath="//div[@class='attr-search-header']//span[contains(.,'Brand')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_AddBrand;

	@FindBy(xpath="//div[@class='attr-search-body hideMe']/div[@class='searchTxtWrap']/input[@class='brandSearchTextBox']")
	private WebElement CBV_AddBrand_SearchBox;

	@FindBy(xpath="//div[@class='manufacturer-search-header']//span[contains(.,'Manufacturer')]//following-sibling::div[@class='togglePlusIcon']")
	private WebElement CBV_AddManufacturer;

	@FindBy(xpath="//div[@class='manufacturer-search-body hideMe']/div[@class='searchTxtWrap']/input[@class='manufacturerSearchTextBox']")
	private WebElement CBV_AddManufacturer_SearchBox;

	@FindBy(xpath="//form[@id='tabs:_form']/descendant::td[contains(@class,'rich-tab-header') and contains(.,'All Items')]")
	private WebElement CBV_TAB_AllItems;

	@FindBy(xpath="//form[@id='tabs:_form']/descendant::td[contains(@class,'rich-tab-header') and contains(.,'Excluded Items')]")
	private WebElement CBV_TAB_ExcludedItems;

	@FindBy(xpath="//form[@id='tabs:_form']/descendant::td[contains(@class,'rich-tab-header') and contains(.,'Additional Items')]")
	private WebElement CBV_TAB_AdditionalItems;

	@FindBy(xpath="//input[@title='Refresh Catalog']")
	private WebElement CBV_RefreshCatalogButton;

	@FindBy(xpath="//input[@title='Save Rules']")
	private WebElement CBV_SaveRulesButton;









	/*	********************************************************************************************************************************************
	 ****************************************************************************************************************************************/
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

	@FindBy(xpath="//a[@class='cimm_addNewIcon' and @title='Add New Subset']")
	private WebElement addNewSubsetLocator;

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

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchfieldLocator;

	@FindBy(xpath="//div[@class='attr-search-header']")
	private WebElement brandSearchheaderLocator;

	@FindBy(xpath="//div[@class='manufacturer-search-header']")
	private WebElement manuSearchheader;

	@FindBy(xpath="//td[contains(text(),'All Items')]")
	private WebElement allItemsLocator;

	@FindBy(xpath="//td[contains(text(),'Excluded Items')]")
	private WebElement excludedItemsLocator;

	@FindBy(xpath="//td[contains(text(),'Additional Items')]")
	private WebElement additionalItemsLocator;

	@FindBy(xpath="//div[@class='manufacturer-search-header1']")
	private WebElement manufacturerExpandLocator;

	@FindBy(xpath="(//div[@class='searchTxtWrap']/input[@class='manufacturerSearchTextBox'])[1]")
	private WebElement ManufacturerSearchAllItemsLocator;

	@FindAll(value={@FindBy(xpath="//span[@class='chkBxicon']/i")})
	private List<WebElement> manufacturerCheckbox;

	@FindBy(xpath="//input[@title='Save Rules']")
	private WebElement saveRulesIconLocator;

	@FindBy(xpath="//span[@id='saveMessage']")
	private WebElement saveRulesSuccessMsg;

	@FindBy(xpath="//td[contains(text(),'Selected')]")
	private WebElement selectedLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/tbody/tr[1]/td[2]")
	private WebElement selectedManufactrerLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[1]/span")
	private WebElement selectedActionLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[2]/span")
	private WebElement selectedEntityNameLocator;

	@FindBy(xpath="//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/thead/tr/th[3]/span")
	private WebElement selectedEntityTypeLocator;

	@FindBy(xpath="//input[@title='Remove Manufacturer / Brand from Rule Book']")
	private WebElement deleteIconLocator;

	@FindBy(xpath="//input[@title='Refresh Catalog']")
	private WebElement refreshCatalogLocator;

	@FindBy(xpath="//div[@class='tabContentWrap']/form/div/table/tbody/tr[1]/td[3]")
	private WebElement ItemPartnumberLocator;

	@FindBy(xpath="//table[@id='searchFormId:searchedItemTableId']/tbody/tr[1]/td[3]")
	private WebElement searchedItemlocator;  

	@FindBy(xpath="//input[@id='searchFormId:searchKeywordId']")
	private WebElement searchkeywordLocator;

	@FindBy(xpath="//input[@id='searchFormId:subgoBtn11']")
	private WebElement searchButtonLocator;

	@FindBy(xpath="//div[@class='tableLayout']")
	private WebElement additionalItemsTableLocator;

	@FindBy(xpath="//td[contains(text(),'123123123123')]/ancestor::td/preceding-sibling::td/table/descendant::span")
	private WebElement sourceItemLocator;

	@FindBy(xpath="//input[@title='Remove Included Items']")
	private WebElement itemRemoveFromAdditionalItemsTab;

	@FindBy(xpath="//li/a[contains(text(),'Subset Items')]")
	private WebElement subsetItemsLinkLocator;

	@FindBy(xpath="//input[@id='listSubsetItems:subsetCombocomboboxField']")
	private WebElement subsetDropdownLocator;

	@FindBy(xpath="//table[@id='searchFormId:subsetItemTableId']/tbody/tr/td[5]")
	private WebElement subsetItemsLocator;

	@FindBy(xpath="//a[contains(text(),'Featured Products Disp Pricing')]")
	private WebElement featuredProductPriceLink;

	@FindBy(xpath="//div[contains(text(),'Subset List For Display Pricing')]")
	private WebElement FeaturedProductPageLocator;

	@FindBy(xpath="//td[contains(text(),'subset_qa')]/following-sibling::td/div/input[@type='checkbox']")
	private WebElement featuredProductDisplayPricingCheckbox;

	@FindBy(xpath="//form[@id='displayPricingFPId']/div[1]/input")
	private WebElement saveIconFeaturedProductdisplayprice;

	@FindBy(xpath="//span[@id='displayPricingFPId:msgId']")
	private WebElement displayPricesaveLocator;

	@FindBy(xpath="//span[@id='subsetForm:removeMsg']")
	private WebElement succesfulMessageForDeleteSubset;
	
	@Step("verify the action label is {0} in subset page")
	public SubsetPageObjects verifyAction(String actionLabel) {
		Assert.assertEquals(actionLocator.getText().trim(),actionLabel );
		return this;
	}
	@Step("verify the Sl No. label is {0} in subset page")
	public SubsetPageObjects verifySlno(String SlNo) {
		// TODO Auto-generated method stub
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
		Waiting.explicitWaitVisibilityOfElement(totalSubsetCountLocator, 5);
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
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",subsetFormSaveLocator);
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
			if(driver.findElement(By.xpath("//span[@id='subsetForm:noResults']")).isDisplayed())
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
		WebElement verifySubsetNameLocator= driver.findElement(By.xpath("//span[contains(text(),'"+data.getsubsetNamedata()+"')]"));
		if(subsetName.trim().equals(verifySubsetNameLocator.getText().trim())){
			String substId = getsubsetId();
			clickOnSpecificDeleteButton(1);
			TestUtility.alertAccept();
			Thread.sleep(2000);
			Assert.assertEquals(subsetRemoveMessage.getText(),"Subset - : '"+data.getsubsetNamedata()+"'with Subset Id -'"+substId+"' removed Successfully");
			//'subset_qa'with Subset Id -'1039' removed Successfully
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
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='subsetForm:noResults']")).getText().trim(), subsetErrorMessage.trim());	
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

	public SubsetPageObjects verifySubsetformfields(String AddsubsetFormsubsetname,String SubsetDescriptionForm,String SubsetPurposeForm,String AddNewSubSetFormStatus,String AddNewSubSetFormBannertext) {
		VerifySubsetNameAddNewSubset(AddsubsetFormsubsetname);
		verifySubsetFromsD(SubsetDescriptionForm);
		verifySubsetFromPurpose(SubsetPurposeForm);
		verifySubsetFromStatus(AddNewSubSetFormStatus);
		verifySubsetFromBannertext(AddNewSubSetFormBannertext);
		Assert.assertTrue(subsetFormSaveLocator.isDisplayed(), "Save button is not displayed");
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

	public SubsetPageObjects clickOnEditButtonsubset(String AddsubsetFormsubsetname,String SubsetDescriptionForm,String SubsetPurposeForm,String AddNewSubSetFormStatus,String AddNewSubSetFormBannertext) throws InterruptedException {
		clickOnSpecificEditButton(1);
		VerifySubsetNameAddNewSubset(AddsubsetFormsubsetname);
		verifySubsetFromsD(SubsetDescriptionForm);
		verifySubsetFromPurpose(SubsetPurposeForm);
		verifySubsetFromStatus(AddNewSubSetFormStatus);
		verifySubsetFromBannertext(AddNewSubSetFormBannertext);
		Assert.assertTrue(subsetFormSaveLocator.isDisplayed(), "Save button is not displayed");
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
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",subsetEditDescriptionLocator);
		subsetEditDescriptionLocator.sendKeys(newSubsetDescription);
		clickOnUpdateSubset();
		Thread.sleep(2000);
		Assert.assertEquals(subsetupdatemsg.getText().trim(), subsetsucmsg);
		return this;
	}
	@Step("Verifies all the fields present in catalog builder page")
	public SubsetPageObjects verifyCatelogBuilderPage() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(manufacturerLocator.isDisplayed(),"Manufacturer block is displayed in catelog builder page");
		Assert.assertTrue(brandLocator.isDisplayed(),"Brand block is displayed in catelog builder page");
		Assert.assertTrue(searchfieldLocator.isDisplayed(),"Search field is displayed in catelog builder page");
		Assert.assertTrue(brandSearchheaderLocator.isDisplayed(),"brand filed is displayed in search bolck of catelog builder page");
		Assert.assertTrue(manuSearchheader.isDisplayed(),"Manufacturer filed is displayed in search bolck of catelog builder page");
		Assert.assertTrue(allItemsLocator.isDisplayed(),"all items field is displayed in catelog builder page");
		Assert.assertTrue(additionalItemsLocator.isDisplayed(),"additional field is displayed in catelog builder page");
		Assert.assertTrue(excludedItemsLocator.isDisplayed(),"exclude field is displayed in catelog builder page");
		return this;
	}
	public SubsetPageObjects clickOnManufacturer() throws InterruptedException {
		Thread.sleep(2000);
		manufacturerExpandLocator.click();
		return this;
	}

	public SubsetPageObjects selectAnManufacturer(String ManufactrerName) throws InterruptedException {
		ManufacturerSearchAllItemsLocator.sendKeys(ManufactrerName);
		Thread.sleep(1000);
		return this;
	}

	public SubsetPageObjects clickOnsaveRules() {
		saveRulesIconLocator.click();
		return this;
	}
	
	public SubsetPageObjects VerifySuccessMessagecatalog(String successmsg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(saveRulesSuccessMsg.getText().trim(),successmsg);
		return this;
	}
	public SubsetPageObjects clickOnSelectedLink() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",selectedLocator);
		return this;
	}
	public SubsetPageObjects verifySelectedManufacturer(String Manufacturername) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(selectedManufactrerLocator.getText().trim(), Manufacturername);
		return this;
	}
	public SubsetPageObjects verifyingcontentSelectedTabs(String action,String EntityName,String EntityType) {
		Waiting.explicitWaitVisibilityOfElement(selectedActionLocator, 3);
		Assert.assertEquals(selectedActionLocator.getText().trim(), action);
		Assert.assertEquals(selectedEntityNameLocator.getText().trim(), EntityName);
		Assert.assertEquals(selectedEntityTypeLocator.getText().trim(), EntityType);
		return this;
	}
	public SubsetPageObjects clickonRemoveMB(String Manufacturername) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",deleteIconLocator);		
		//deleteIconLocator.click();
		TestUtility.alertAccept();
		Assert.assertEquals(saveRulesSuccessMsg.getText().trim(), "Entity With Name - : '"+Manufacturername+"' removed Successfully.");
		return this;
	}
	public SubsetPageObjects clickOnSpecificManufacturer(String getmanufacturername) {
		driver.findElement(By.xpath("//td[contains(text(),'"+getmanufacturername+"')]/preceding-sibling::td/label")).click();
		return this;
	}
	public SubsetPageObjects clickOnRefreshCatalog() throws InterruptedException {
		Thread.sleep(2000);
		refreshCatalogLocator.click();
		return this;
	}
	public SubsetPageObjects verifySuccessMsg(String subsetRuleSaveMsg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(saveRulesSuccessMsg.getText().trim(),subsetRuleSaveMsg);
		return this;
	}
	public SubsetPageObjects verifyItemInAllItems(String partNumberField) {
		Assert.assertEquals(ItemPartnumberLocator.getText(), partNumberField);
		return this;
	}
	public SubsetPageObjects enterSearchkeyword(String partNumberField) throws InterruptedException {
		Thread.sleep(2000);
		searchkeywordLocator.sendKeys(partNumberField);
		return this;
	}
	public SubsetPageObjects verifySearchedResults(String partNumberField) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(searchedItemlocator.getText().trim(), partNumberField);
		return this;
	}
	public SubsetPageObjects clickOnSearchButton() {
		searchButtonLocator.click();
		return this;
	}
	public SubsetPageObjects clickOnAdditionalItemsLink() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",additionalItemsLocator);
		//additionalItemsLocator.click();
		Thread.sleep(2000);
		return this;
	}
	public SubsetPageObjects dragDropAnItem() throws InterruptedException {
		Thread.sleep(3000);
		//WebElement src = driver.findElement(By.xpath("//td[contains(text(),'123123123123')]/ancestor::td/preceding-sibling::td/table/descendant::span"));
		//WebElement Target = driver.findElement(By.xpath("//div[@class='tableLayout']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(sourceItemLocator).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(additionalItemsTableLocator, 0, 0).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 5).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 10).build().perform();
		builder.moveToElement(additionalItemsTableLocator, 0, 15).build().perform();
		builder.release().build().perform();
		return this;
	}

	public SubsetPageObjects clickOnRemoveItem() {
		itemRemoveFromAdditionalItemsTab.click();
		TestUtility.alertAccept();
		return this;
	}
	public SubsetPageObjects VerifyItemRemoveSuccessMsg(String partNumberField) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(saveRulesSuccessMsg.getText().trim(),"Item With Part Number - : '"+partNumberField+"' removed Successfully.");
		return this;
	}
	public SubsetPageObjects clickOnSubsetItemsLink() {
		subsetItemsLinkLocator.click();
		return this;	
	}
	public SubsetPageObjects selectSubset(String getsubsetNamedata) throws InterruptedException {
		subsetDropdownLocator.clear();
		subsetDropdownLocator.sendKeys(getsubsetNamedata);
		Thread.sleep(2500);
		return this;
	}
	public SubsetPageObjects verifySubsetItems(String partNumberField) {
		Assert.assertEquals(subsetItemsLocator.getText().trim(), partNumberField);
		return this;
	}

	public SubsetPageObjects verifySearchTemplate(){
		Assert.assertTrue(searchfieldLocator.isDisplayed(),"Search field is displayed in catelog builder page");
		Assert.assertTrue(brandSearchheaderLocator.isDisplayed(),"brand filed is displayed in search bolck of catelog builder page");
		Assert.assertTrue(manuSearchheader.isDisplayed(),"Manufacturer filed is displayed in search bolck of catelog builder page");
		return this;
	}
	public SubsetPageObjects clickOnFeaturedProductsDispPricingLink(String subsetdisplayepricing) {
		featuredProductPriceLink.click();
		Assert.assertEquals(FeaturedProductPageLocator.getText().trim(), subsetdisplayepricing);
		return this;
	}

	public SubsetPageObjects clickSubsetCheckbox(String subsetname) {
		featuredProductDisplayPricingCheckbox.click();
		return this;
	}
	public SubsetPageObjects clickOnSaveIcon() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",saveIconFeaturedProductdisplayprice);
		return this;
	}

	public SubsetPageObjects verifyDisplayPriceSuccessMsg(String diasplyPriceSucessMsg) {
		Assert.assertEquals(displayPricesaveLocator.getText().trim(), diasplyPriceSucessMsg);
		return this;
	}

	public SubsetPageObjects clickOnSpecificDeleteButton(String subsetName) {
		driver.findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]/ancestor::td/preceding-sibling::td/input[@title='Remove Subset Item']")).click();
		return this;
	}

	public SubsetPageObjects specificSubsetDelete(String subsetName) throws Exception{
		Thread.sleep(1500);
		serchSubset(subsetName);
		Thread.sleep(1500);
		WebElement verifySubsetNameLocator= driver.findElement(By.xpath("//span[contains(text(),'"+data.getsubsetNamedata()+"')]"));
		if(subsetName.trim().equals(verifySubsetNameLocator.getText().trim())){
			String substId = getsubsetId();
			Thread.sleep(1500);
			clickOnSpecificDeleteButton(subsetName);
			TestUtility.alertAccept();
			Thread.sleep(3000);
			Assert.assertEquals(subsetRemoveMessage.getText(),"Subset - : '"+data.getsubsetNamedata()+"'with Subset Id -'"+substId+"' removed Successfully");
			//'subset_qa'with Subset Id -'1039' removed Successfully
		}
		return this;

	}

	@FindBy(xpath="(//a[contains(text(),'Subset')])[3]")
	private static WebElement subsetbreadcrumb;

	@Step("check whether page is subset page")
	public  SubsetPageObjects checkSubsetPage() throws Exception{

		TestUtility.assertElementPresent(subsetbreadcrumb);
		return this;
	}

	@FindBy(id="searchFormId:searchKeywordId")
	private static WebElement subsetsearchbox;

	@Step("type in subset search box")
	public  SubsetPageObjects typeInSubsetSearch(String subsetname){
		subsetsearchbox.clear();
		subsetsearchbox.sendKeys(subsetname);
		return this;
	}

	@FindBy(xpath="//a[@id='searchFormId:goBtn']/i")
	private static WebElement subsetsearchbutton;

	@Step("click on subsetsearch button")
	public  SubsetPageObjects clickOnSubsetSearchButton() throws InterruptedException{
		subsetsearchbutton.click();
		Thread.sleep(3000);
		return this;
	}

	public boolean subsetSearchResultHelp(String subsetname) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(driver.findElement(By.xpath("//tr[td[4]='"+subsetname+"']")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e) {
			return true;

		}
		return false;		    
	}

	public SubsetPageObjects subsetSearchResult(String subsetname) throws Exception
	{
		Assert.assertTrue(subsetSearchResultHelp(subsetname),"Subset is Present. Please delete for creating again.");
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

	@FindBy(id="addNewSubsetForm:subsetSaveMsg")
	private static WebElement subsetsavemsg ;

	@Step("check whether subset got saved successfully")
	public  SubsetPageObjects verifySubsetCreationMessage(String subsetsavemsgexpected){
		Assert.assertEquals(subsetsavemsg.getText(),subsetsavemsgexpected);

		return this;
	}

	/*	********************************************************************************************************************************************
	 ****************************************************************************************************************************************/
	@Step("To Verify the Subset Page Items")
	public SubsetPageObjects verifySubsetPageItems() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(leftSlider_Subset.isDisplayed(),"'Subset' Option in the Left Slider is not Displayed");
		Assert.assertTrue(leftSlider_SubsetItems.isDisplayed(),"'Subset Items' Option in the Left Slider is not Displayed");
		Assert.assertTrue(leftSlider_FeaturedProducts.isDisplayed(),"'Featured Products' Option in the Left Slider is not Displayed");
		Assert.assertTrue(subset_SearchBox.isDisplayed(),"Subset 'Search Box' is not Displayed");
		Assert.assertTrue(subset_SearchIcon.isDisplayed(),"Subset 'Search Icon' is not Displayed");
		Assert.assertTrue(subset_AddNewSubsetButton.isDisplayed(),"'Add New Subset Button' is not Displayed");
		Assert.assertTrue(subsetPagination_CurrentPageCount.isDisplayed());
		Assert.assertTrue(subsetPagination_TotalPagesCount.isDisplayed());
		Assert.assertTrue(subsetPagination_NextButton.isDisplayed());
		Assert.assertTrue(subsetPagination_PreviousButton.isDisplayed());
		Assert.assertTrue(subsetPagination_FirstButton.isDisplayed());
		Assert.assertTrue(subsetPagination_LastButton.isDisplayed());
		Assert.assertTrue(col_Action.isDisplayed());
		Assert.assertTrue(col_SlNo.isDisplayed());
		Assert.assertTrue(col_SubsetID.isDisplayed());
		Assert.assertTrue(col_SubsetName.isDisplayed());
		Assert.assertTrue(col_SubsetDescription.isDisplayed());
		Assert.assertTrue(col_Purpose.isDisplayed());
		Assert.assertTrue(col_Status.isDisplayed());
		return this;
	}

	@Step("To Click On Add new Subset")
	public SubsetPageObjects clickOnAddNewSubset() 
	{
		subset_AddNewSubsetButton.click();
		return this;
	}

	@Step("To Verify the Add New Subset Form Items.")
	public SubsetPageObjects verifyAddNewSubsetFormItems() throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(addSubset_SubsetName.isDisplayed(),"'Subset Name' Field is not Displayed");
		Assert.assertTrue(addSubset_SubsetDescription.isDisplayed(),"'Subset Description Field' is not Displayed");
		Assert.assertTrue(addSubset_SubsetPurpose.isDisplayed(),"'Subset Purpose Field' is not Displayed");
		Assert.assertTrue(addSubset_SubsetStatus.isDisplayed(),"'Subset Status Field' is not Displayed");
		Assert.assertTrue(addSubset_SaveNewSubset.isDisplayed(),"'Save New Subset Button' is not Displayed");
		Assert.assertTrue(addSubset_ResetSubset.isDisplayed(),"'Reset Button' is not Displayed");
		Assert.assertTrue(addSubset_CloseSubsetForm.isDisplayed(),"'Close Subset Button' is not Displayed");
		return this;
	}

	@Step("To Add new Subset {0} ")
	public SubsetPageObjects addNewSubset(String subsetName, String subsetDesc, String bannerText) throws Exception 
	{
		addSubset_SubsetName.clear();
		addSubset_SubsetName.sendKeys(subsetName);
		addSubset_SubsetDescription.clear();
		addSubset_SubsetDescription.sendKeys(subsetDesc);
		driver.switchTo().frame(addSubset_BannerText);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(bannerText);
		driver.switchTo().defaultContent();		
		return this;
	}

	@Step("To Save new Subset ")
	public SubsetPageObjects clickOnSaveNewSubset() 
	{
		Waiting.explicitWaitElementToBeClickable(addSubset_SaveNewSubset, 5);
		addSubset_SaveNewSubset.click();
		return this;
	}

	@Step("To Verify the Add New Subset Form Items.")
	public SubsetPageObjects verifyMessageAfterSavingSubset(String saveMessage) throws Exception
	{
		Thread.sleep(5000);
		assertThat(addSubset_SaveMessageLocator.getText(), containsString(saveMessage));
		return this;
	}

	@Step("To Search for an Subset {0}.")
	public SubsetPageObjects searchForAnSubset(String subsetName) 
	{
		Waiting.explicitWaitVisibilityOfElement(subset_SearchBox, 5);
		subset_SearchBox.clear();
		subset_SearchBox.sendKeys(subsetName);
		subset_SearchIcon.click();
		return this;
	}

	@Step("To Verify the Search Results After Searching for an Subset {0}.")
	public SubsetPageObjects verifyAfterSearchingForSubset(String subsetName) throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//table[@id='subsetForm:subsetTableId']//span[contains(.,'"+subsetName+"')]")).isDisplayed());
		return this;
	}

	@Step("To Click on 'NoOfItems Dropdown' and verify contents dispalyed.")
	public SubsetPageObjects verifyDisplayNoOfItemsDropdown() throws Exception
	{
		driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']/option[@value='25']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']"))).getFirstSelectedOption().getText(), "25");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']/option[@value='50']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']"))).getFirstSelectedOption().getText(), "50");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']/option[@value='75']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']"))).getFirstSelectedOption().getText(), "75");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']/option[@value='100']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']"))).getFirstSelectedOption().getText(), "100");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']/option[@value='10']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@id='searchFormId:nrpp']"))).getFirstSelectedOption().getText(), "10");
		Thread.sleep(5000);
		return this;
	}

	@Step("To Verify the Character Limit for Subset Name Field.")
	public SubsetPageObjects verifyCharacterLimitForSubsetName() 
	{
		Waiting.explicitWaitVisibilityOfElement(addSubset_SubsetName, 5);
		//addSubset_SubsetName.clear();
		for (int i=0; i< 50; i++)
		{
			addSubset_SubsetName.sendKeys("0");
		}
		String enteredText=addSubset_SubsetName.getAttribute("value");
		int enteredTextLength=enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(addSubset_SubsetName.getAttribute("maxlength")));
		return this;
	}

	@Step("To Click On 'Edit Subset' {0}.")
	public SubsetPageObjects clickOnEditSubset(String subsetName) throws Exception 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='subsetForm:subsetTableId']//span[contains(.,'"+subsetName+"')]//preceding::input[@title='Edit Subset']")).click();
		return this;
	}

	@Step("To Verify the Edit Subset Form Items.")
	public SubsetPageObjects verifyEditSubsetFormItems(String subsetName) throws Exception 
	{
		Thread.sleep(5000);
		Assert.assertTrue(editSubset_SubsetName.isDisplayed());
		Assert.assertTrue(editSubset_SubsetDesc.isDisplayed());
		Assert.assertTrue(editSubset_Purpose.isDisplayed());
		Assert.assertTrue(editSubset_Status.isDisplayed());
		Assert.assertTrue(editSubset_BannerText.isDisplayed());
		Assert.assertTrue(editSubset_UpdateSubset.isDisplayed());
		Assert.assertTrue(editSubset_ViewHistory.isDisplayed());
		Assert.assertTrue(editSubset_CloseForm.isDisplayed());

		Assert.assertEquals(editSubset_SubsetName.getAttribute("value"), subsetName);
		return this;
	}

	@Step("To Edit Subset Form Items.")
	public SubsetPageObjects editSubset(String editedSubsetName, String subsetDesc) 
	{
		editSubset_SubsetName.clear();
		editSubset_SubsetName.sendKeys(editedSubsetName);
		editSubset_SubsetDesc.clear();
		editSubset_SubsetDesc.sendKeys(subsetDesc);
		editSubset_UpdateSubset.click();
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
		Thread.sleep(5000);
		try
		{
			TestUtility.doubleClick(catalogBuilderView);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		catalogBuilderView.click();
		Thread.sleep(5000);
		return this;
	}

	@Step("To Verify the 'Catalog Builder' Page Items.")
	public SubsetPageObjects verifyCatalogBuilderPageItems() throws Exception 
	{
		Thread.sleep(5000);
		//FluentWaitForVisibilityOfElement(30, 1000, CBV_Available);
		Assert.assertTrue(CBV_Available.isDisplayed(), "Left Side Bar -> Available Tab is Absent");
		Assert.assertTrue(CBV_Selected.isDisplayed(), "Left Side Bar -> Selected Tab is Absent");
		Assert.assertTrue(CBV_Available_AddManufacurer.isDisplayed(), "Left Side Bar -> Add New Manufacturer is Absent under 'Available' Tab");
		Assert.assertTrue(CBV_Available_AddBrand.isDisplayed(), "Left Side Bar -> Add New Brand is Absent under 'Available' Tab");
		Assert.assertTrue(CBV_SearchItem.isDisplayed(), "'Search Item' Search Box is Absent");
		Assert.assertTrue(CBV_AddManufacturer.isDisplayed(), "Add New Manufacturer is Absent");
		Assert.assertTrue(CBV_AddBrand.isDisplayed(), "Add New Brand is Absent");
		Assert.assertTrue(CBV_RefreshCatalogButton.isDisplayed(), "'Refresh Catalog' Button is Absent");
		Assert.assertTrue(CBV_SaveRulesButton.isDisplayed(), "'Save Catalog' Button is Absent");
		return this;
	}

	@Step("To Select Manufacturer and Brands to the 'Catalog Builder' Page Items.")
	public SubsetPageObjects addManufacturerAndBrand(String manufacturerName, String brandName) throws Exception 
	{
		Thread.sleep(5000);
		CBV_Available_AddManufacurer.click();
		//Thread.sleep(5000);
		CBV_Available_AddManufacurer_SearchBox.click();
		CBV_Available_AddManufacurer_SearchBox.sendKeys(manufacturerName);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(@id,'subsetList:MnfListTabId') and contains(text(),'"+manufacturerName+"')]/preceding-sibling::td/label")).click();
		//Thread.sleep(2000);

		CBV_Available_AddBrand.click();
		CBV_Available_AddBrand_SearchBox.click();
		CBV_Available_AddBrand_SearchBox.sendKeys(brandName);
		driver.findElement(By.xpath("//td[contains(@id,'subsetList:brandTableId') and contains(text(),'"+brandName+"')]/preceding-sibling::td/label")).click();
		return this;
	}
	
	@Step("To click on Save Rules in 'Catalog Builder' Page Items.")
	public SubsetPageObjects clickOnSaveRules()
	{
		FluentWaitForVisibilityOfElement(10, 500, CBV_SaveRulesButton);
		CBV_SaveRulesButton.click();
		return this;
	}
	
	@Step("To click on 'Selected' Tab in the left SideBar.")
	public SubsetPageObjects clickOnSelectedTab() 
	{
		FluentWaitForVisibilityOfElement(10, 500, CBV_Selected);
		CBV_Selected.click();
		return this;
	}
	
	@Step("To Verify the click on 'Selected' Tab in the left SideBar.")
	public SubsetPageObjects verifySelectedManufacturerInCatalogBuilder(String manufacturerName) throws Exception 
	{
		Thread.sleep(5000);
		FluentWaitForVisibilityOfElement(20, 500, CBV_Selected);
		Assert.assertTrue(driver.findElement(By.xpath("//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/descendant::td[contains(.,'"+manufacturerName+"')]")).isDisplayed());
		return this;
	}
	
	@Step("To click on Delete Button of the Selected Manufacturer in  'Selected' Tab in the left SideBar.")
	public SubsetPageObjects clickOnDeleteSelectedManufacturerInCatalogBuilder(String manufacturerName)
	{
		driver.findElement(By.xpath("//table[@id='subsetList:SelectedMfrAndBrandForCatalogList1']/descendant::td[contains(.,'"+manufacturerName+"')]/preceding-sibling::td/input")).click();
		Waiting.explicitWaitForAlert(5);
		TestUtility.alertAccept();
		return this;
	}
	
	@Step("To Verify the Message after deleting Manufacturer in Catalog Builder")
	public SubsetPageObjects verifyMessageAfterDeletingManufacturerInCatalogBuilder(String saveMessage) throws Exception 
	{
		Thread.sleep(5000);
		assertThat(driver.findElement(By.xpath("//span[@id='saveMessage']")).getText(),containsString(saveMessage));
		return this;
	}
	public String verifyandDeleteSubset(String subsetName) throws Exception {
		WebElement wb=driver.findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]/ancestor::td//preceding-sibling::td/descendant::input[@value='Remove']"));
		Waiting.explicitWaitVisibilityOfElement(wb, 10);
		TestUtility.assertElementPresent(wb);
		String subsetId=driver.findElement(By.xpath("//span[contains(text(),'"+subsetName+"')]/ancestor::td//preceding-sibling::td[1]")).getText();
		wb.click();
		TestUtility.alertAccept();
		return subsetId;
	}
	public SubsetPageObjects verifySuccessMessageForDeletionOfSubset( String subsetName,String subsetId) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(succesfulMessageForDeleteSubset, 10);
		Assert.assertEquals(succesfulMessageForDeleteSubset.getText(), "Subset - : '"+subsetName+"'with Subset Id -'"+subsetId+"' removed Successfully");	
		//String expMsg="Subset - : 'test'with Subset Id -'"+subsetId+"' removed Successfully";
		
		return this;
	}


	
	
	
	
}	