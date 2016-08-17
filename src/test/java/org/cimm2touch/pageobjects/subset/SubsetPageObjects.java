package org.cimm2touch.pageobjects.subset;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;


	public class SubsetPageObjects extends PageFactoryInitializer{
		

		SearchDataPropertyFile data = new SearchDataPropertyFile();
		
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
	}	