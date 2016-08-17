package org.cimm2touch.pageobjects.items;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;

public class EditItemsPageObjects extends PageFactoryInitializer{
		
	
@FindBy(xpath="//td[contains(text(),'Categorization')]")
private WebElement categorizationTabLocator;

@FindBy(xpath="//span[contains(text(),'Results')]")
private WebElement resultsLinkLocator;

@FindBy(xpath="//div[@class='tabContentTopStrip']/descendant::span[contains(@id,'itemIdValueDisplayId')]")
private WebElement cimmItemIdValueLocator;

@FindBy(xpath="//span[contains(text(),'Edit Item')]")
private WebElement editItemsBreadcrumbLocator;

@FindBy(xpath="//a[text()='Item']")
private WebElement itemLinkLocator;

@FindBy(xpath="//td[contains(text(),'Linked Items')]")
private WebElement linkedItemsTabLocator;

@FindBy(xpath="//td[contains(text(),'Setup Linked Items')]")
private WebElement setUpLinkedItemsLocator;

@FindBy(xpath="//td[contains(text(),'Available Linked Items')]")
private WebElement availableLinkedItemsLocator;

@FindBy(xpath="//td[contains(text(),'List Item Link Types')]")
private WebElement listItemLinkTypesLocator;
	
@FindBy(xpath="//span[contains(text(),'Search Items for Item LinkType')]")
private WebElement searchItemsForItemLinkTypeTabNameLocator;

@FindBy(xpath="//input[@placeholder='Search Item LinkType']")
private WebElement searchItemLinkTypeSearchTextboxLocator;

@FindBy(xpath="//span[contains(text(),'Search Items for Item LinkType')]/ancestor::div/following-sibling::div/descendant::a[contains(@id,'goBtn')]")
private WebElement searchButtonLocator;

@FindAll(value={@FindBy(xpath="//select[@id='lnkditmSrchIdf:searchInId']/option")})
private List<WebElement> searchInDropdownValuesLocator;

@FindBy(xpath="//input[contains(@id,'manufacturerListComboIdcomboboxField')]")
private WebElement manufacturerDropdownLocator;

@FindBy(xpath="//input[contains(@id,'brandListComboIdcomboboxField')]")
private WebElement brandDropdownLocator;

@FindBy(xpath="//input[contains(@id,'linkedItemsComboIdcomboboxField')]")
private WebElement itemLinkTypeDropdownLocator;

@FindBy(xpath="//a[@title='History']")
private WebElement historyLinkLocator;


@FindBy(xpath="//td[@id='KWTab_lbl']")
private WebElement keyWordsTabLocator;

@FindBy(xpath="//td[@id='CpnumTab_lbl']")
private WebElement cpnTabLocator;

@FindBy(xpath="//tr[@class='tabContentTopStrip']/td/input")
private WebElement addNewCpnLocator;


@FindBy(xpath="//input[contains(@id,'buyingCompanyId')]")
private WebElement addNewCpnTextboxLocator;


@FindBy(xpath=".//*[@id='custPrtNumFormId:CPNFormId:addNewcstPnumId']")
private WebElement addNewNumber;

@FindBy(xpath="//input[@id='custPrtNumFormId:CPNFormId:cstTable:0:cstpNumId']")
private WebElement enterNewNumberLocator;

@FindBy(xpath=".//*[@id='custPrtNumFormId:CPNFormId:savecstPnumId']")
private WebElement saveNewCpn;

@FindBy(xpath=".//*[@id='custPrtNumFormId:CPNFormId:insertMsg']")
private WebElement cpnSuccessMessageLocator;

@FindBy(xpath="//input[@id='generalInfoFormId:btnReset']")
private WebElement resetButtonLocator;

@FindBy(xpath="//a[@title='History']")
private WebElement historyButtonLocator;

@FindBy(xpath="//form[@id='generalInfoFormId']/div[1]/ul/span/li[1]/input")
private WebElement itemUpdateButtonLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[2]/td[3]")
private WebElement itemEditRightMPNLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[3]/td[3]")
private WebElement itemEditRightPNLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[4]/td[3]")
private WebElement itemEditRightListPriceLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[5]/td[3]")
private WebElement itemEditRightCostPriceLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[6]/td[1]/strong")
private WebElement itemEditRightUserRatingLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[7]/td[1]/strong")
private WebElement itemEditRightHitsgLocator;

@FindBy(xpath="//form[@id='itemDtlFm']/table/tbody/tr[8]/td[1]/strong")
private WebElement itemEditRightPopularityLocator;  

@FindBy(xpath="//a[@title='Goto PreviousPage']/span")
private WebElement itemEditRightResultButtonLocator; 

@FindBy(xpath="//a[@class='resultBtnLabel']")
private WebElement itemEditRightItemButtonLocator; 

@FindBy(xpath="//form[@id='itemNavigateForm']/div/input[1]")
private WebElement itemEditRightSearchButtonLocator; 

@FindBy(xpath="//input[@id='itemNavigateForm:previousItemIcon']")
private WebElement itemEditRightpreviousButtonLocator; 

@FindBy(xpath="//input[@id='itemNavigateForm:nextItemIcon']")
private WebElement itemEditRightnextButtonLocator; 

@FindBy(xpath="//span[contains(text(),'Updated Successfully')]")
private WebElement itemupdatemsgLocator; 

@FindBy(xpath="//td[@id='DescTab_lbl']")
private WebElement itemDescriptionLocator; 

@FindBy(xpath="//select[@id='itemDescFormId:locidDesc']")
private WebElement langDescriptionLocator;

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[1]/div[1]")
private WebElement pageTitleDescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[2]/div[1]")
private WebElement shortDescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[3]/div[1]")
private WebElement Long1DescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[4]/div[1]")
private WebElement Long2DescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[5]/div[1]")
private WebElement itemFeaturesDescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[6]/div[1]")
private WebElement MetaDescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[7]/div[1]")
private WebElement InvoiceDescriptionLocator; 

@FindBy(xpath="//div[@class='tab_descriptionForm']/div[1]/span[8]/div[1]")
private WebElement ItemMarketDescriptionLocator; 

@FindBy(xpath="(//div[@id='noEditor'])[1]")
private WebElement ItemPageTitleDescriptionLocator;

@FindBy(xpath="//div[@id='shortDescriptionEditor']")
private WebElement ItemshortDescriptionLocator; 

@FindBy(xpath="//div[@id='longDescEditor']")
private WebElement Itemlong1DescriptionLocator; 

@FindBy(xpath="//div[@id='longDesc2Editor']")
private WebElement ItemLongDescription2TextboxLocator; 

@FindBy(xpath="//div[@id='itemFeatureEditor']")
private WebElement ItemItemFeaturesDescriptionTextboxLocator; 

@FindBy(xpath="(//div[@id='noEditor'])[2]")
private WebElement ItemMetaDescriptionTextboxLocator; 

@FindBy(xpath="//div[@id='invoiceEditor']")
private WebElement IteminvoiceDescriptionTextboxLocator; 

@FindBy(xpath="//div[@id='marketEditor']")
private WebElement ItemMarketDescriptionTextboxLocator; 

@FindBy(xpath="//span[@id='descFormId:discEditPanel']/a/img")
private WebElement ItemSaveDescriptionLocator; 

@FindBy(xpath="//span[@id='descFormId:saveMessageId2']")
private WebElement ItemSaveDescriptionMSGLocator; 

@FindBy(xpath="(//div[@role='application'])[1]")
private WebElement ShortTinyMCEeditorLocator; 

@FindBy(xpath="(//div[@role='application'])[2]")
private WebElement long1TinyMCEeditorLocator; 

@FindBy(xpath="(//div[@role='application'])[3]")
private WebElement long2TinyMCEeditorLocator; 

@FindBy(xpath="(//div[@role='application'])[4]")
private WebElement itemFeaturesTinyMCEeditorLocator; 

@FindBy(xpath="(//div[@role='application'])[5]")
private WebElement InvoiceTinyMCEeditorLocator; 

@FindBy(xpath="(//div[@role='application'])[6]")
private WebElement ItemMarketingTinyMCEeditorLocator; 

@FindBy(xpath="//td[@id='PROTab_lbl']")
private WebElement productslinkLocator; 

@FindBy(xpath="//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[1]/td[1]")
private WebElement productNameFieldLocator;

@FindBy(xpath="//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[2]/td[1]")
private WebElement productNumberFieldLocator;

@FindBy(xpath="//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[3]/td[1]")
private WebElement productdescFieldLocator;

@FindBy(xpath="//span[@id='productDetailsFormId:prodDetailsId']/div[3]")
private WebElement productDelinkLocator;

@FindBy(xpath="//input[@id='listProductForm:searchKeywordId']")
private WebElement productSearchFieldLocator;

@FindBy(xpath="//a[@id='listProductForm:goBtn']/i")
private WebElement productSearchButtonLocator;

@FindBy(xpath="//span[@id='listProductForm:productTableID:ACTION']")
private WebElement productActionLabelLocator;

@FindBy(xpath="//span[@id='listProductForm:productTableID:ITMIMGH']")
private WebElement productNameImageLabelLocator;

@FindBy(xpath="//table[@id='listProductForm:productTableID']/thead/tr/th[3]")
private WebElement productDescLocator;

@FindBy(xpath="//td[@id='KWTab_lbl']")
private WebElement keywordlinkLocator;


@FindBy(xpath="//form[@id='keywordsFormId']/div[2]/div/span[1]/div[1]")
private WebElement CustomkeywordlinkLocator;

@FindBy(xpath="//form[@id='keywordsFormId']/div[2]/div/span[2]/div[1]")
private WebElement MetakeywordlinkLocator;

@FindBy(xpath="//form[@id='keywordsFormId']/div[2]/div/span[3]/div[1]")
private WebElement keywordautomgeneratedlinkLocator;


@FindBy(xpath="//form[@id='keywordsFormId']/div[2]/div/span[4]/div[1]")
private WebElement PartNumberKeywordslinkLocator;

@FindBy(xpath="//textarea[@id='keywordsFormId:customKeywordsId']")
private WebElement CustomKeywordsTextboxLocator;

@FindBy(xpath="//textarea[@id='keywordsFormId:metaKeywordId']")
private WebElement MetaKeywordsTextboxLocator;

@FindBy(xpath="//input[@id='keywordsFormId:keywordSaveBtn' and @title='Action Buttons']")
private WebElement KeywordsSaveLocator;

@FindBy(xpath="//span[@id='keywordsFormId:saveMessageId']")
private WebElement keywordsSuccessMsgLocator;


@FindBy(xpath="//ul[@class='buttonList']/li[2]/a[@title='Revision History Link']")
private WebElement KeywordsRevisionLocator;

@FindBy(xpath="//td[@id='DocTab_lbl']")
private WebElement DocumentsLinkLocator;

@FindBy(xpath="//td[@id='ImgTab_lbl']")
private WebElement imagesLinkLocator;

@FindBy(xpath="//select[@id='solrForm:locidDoc']")
private WebElement DocumentLangLocator;

@FindBy(xpath="//div[@class='cimmDocInstruction']")
private WebElement DocumentindtructionLocator;

@FindBy(xpath="(//select[@class='cimmDocInputText'])[2]")
private WebElement DocumentcatdropdownLocator;

@FindBy(xpath="//input[@id='addDocumentId']")
private WebElement DocumentAddlinkLocator;

@FindBy(xpath="//a[@title='Revision History Link']")
private WebElement DocumentRevisionHistorylinkLocator;

@FindAll(value={@FindBy(xpath="(//select[@class='cimmDocInputText'])[2]")})
private List<WebElement> documentCatDropdownLocator;

@FindBy(xpath="//select[@id='documentUploadFormId:categoryList']")
private WebElement AddnewDocumentcatdropdownLocator;

@FindBy(xpath="//a[@id='documentUploadFormId:link']")
private WebElement AddnewDocumentcatlinkLocator;

@FindBy(xpath="//input[@id='documentUploadFormId:captionId']")
private WebElement AddnewDocumentcaptionLocator;

@FindBy(xpath="//input[@id='documentUploadFormId:addDocUrl']")
private WebElement AddnewDocumentURLLocator;

@FindBy(xpath="//div[@id='documentUploadFormId:itemDocumentUploadId']/table/tbody/tr/td")
private WebElement AddnewDocumentuploadIconLocator;

@FindBy(xpath="//input[@id='documentUploadFormId:docOwId']")
private WebElement AddnewDocumentOverwritecheckLocator;

@FindBy(xpath="//input[@title='Save URL']")
private WebElement AddnewDocumentSaveButtonLocator;

@FindBy(xpath="//input[@id='documentUploadFormId:btnReset']")
private WebElement AddnewDocumentResetButtonLocator;

@FindBy(xpath="//span[@id='errorImageNameForDoc']")
private WebElement DocumentSuccessMsgLocator;

@FindBy(xpath="//span[@id='listDocFromId:panalDocId']/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td[2]/input")
private WebElement DocumentURLcheckboxLocator;

@FindBy(xpath="//input[@id='listDocFromId:mainDocRemoveAll']")
private WebElement DocumentdeleteButtonLocator;

@FindBy(xpath="//input[@title='Edit Caption']")
private WebElement EditAssignedDocumentLocator;

@FindBy(xpath="//input[@id='editCaptionFormID:editCaptionId']")
private WebElement EditDocumentCapLocator;

@FindBy(xpath="//input[@title='Update Caption']")
private WebElement UpdateDocumentCapLocator;

@FindBy(xpath="//span[@id='editCaptionFormID:updateCaptionNameId']")
private WebElement UpdateDocumentCapSuccessMsgLocator;

@FindBy(xpath="//img[@id='hideEditDoc']")
private WebElement UpdateDocumentCapCancelLocator;

@FindBy(xpath="//a[@id='documentUploadFormId:link']")
private WebElement DocumentCatPopupLocator;

@FindBy(xpath="//img[@id='hidelink']")
private WebElement DocumentCatCloseLocator;

@FindBy(xpath="//input[contains(@id,'docCategoryName')]")
private WebElement DocumentCatnameLocator;

@FindBy(xpath="//textarea[contains(@id,'docDesc')]")
private WebElement DocumentCatdescriptionLocator;

@FindBy(xpath="//input[@title='Save Category ']")
private WebElement DocumentCatSaveLocator;

@FindBy(xpath="//span[contains(@id,'docatNamsg')]")
private WebElement DocumentCatSaveErrorMsgLocator;

@FindBy(xpath="//span[@id='documentUploadFormId:captionMsgId']")
private WebElement DocumentCaptionErrorMsgLocator;

@FindBy(xpath="//ul[@class='buttonList']/li[2]/form/a[@title='Revision History Link']")
private WebElement DocumentHistoryLocator;

@FindBy(xpath="//td[@id='VideoTab_lbl']")
private WebElement VideosTablinkLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/div[1]/b")
private WebElement AssignedvideoLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/span/table/thead/tr/th[1]/div")
private WebElement AssignedActionLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/span/table/thead/tr/th[3]/div")
private WebElement AssignedItemVideoLabelLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/span/table/thead/tr/th[4]/div")
private WebElement AssignedItemVideoURLLabelLocator;

@FindBy(xpath="//div[@class='tab-title']/div/b")
private WebElement VideoLibraryLabelLocator;

@FindBy(xpath="//input[contains(@id,'vidInfoId:input')]")
private WebElement VideoLibrarySearchFieldLocator;

@FindBy(xpath="//a[contains(@id,'vidInfoId:searchAtt')]")
private WebElement VideoLibrarySearchButtonLocator;

@FindBy(xpath="//input[@id='addVideo']")
private WebElement addNewVideoButtonLocator;

@FindBy(xpath="//input[@id='videoFormId:vcaptionId']")
private WebElement AddVideoCaptionFieldLocator;

@FindBy(xpath="//input[@id='videoFormId:vurlId']")
private WebElement AddVideoURLFieldLocator;

@FindBy(xpath="//input[@title='Save URL']")
private WebElement AddVideoSaveButtonLocator;

@FindBy(xpath="//input[@title='Reset']")
private WebElement AddVideoResetButtonLocator;

@FindBy(xpath="//*[@id='videoFormId']/div/div[1]/img")
private WebElement AddVideoClosebuttonLocator;

@FindBy(xpath="//span[@id='videoFormId:itemVideoSavemessage']")
private WebElement VideomsgVerifyLocator;

@FindBy(xpath="//input[@id='listVideoFromId:mainVideoRemoveAll']")
private WebElement DeleteAllVideoLocator;

@FindBy(xpath="//span[@id='deleteVidMsgId']")
private WebElement DeleteVideoAlertMsgLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/span/table/tbody/tr/td[2]/div/input")
private WebElement assignedVideoCheckboxLocator;

@FindBy(xpath="//form[@id = 'listVideoFromId']/span/table/tbody/tr/td[1]/div/input[2]")
private WebElement assignedVideoDeleteButtonLocator;

@FindBy(xpath="//td[contains(text(),'Available Linked Items')]")
private WebElement AvailableLinkedItemsLinkLocator;
@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[1]/span")
private WebElement AvailableLinkedItemsItemIdLocator;
@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[2]/div/span")
private WebElement AvailableLinkedItemsItemImageLocator;

@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[3]/span")
private WebElement AvailableLinkedItemsPartNumberLocator;


@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[4]/span")
private WebElement AvailableLinkedItemsMPNLocator;

@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[5]/span")
private WebElement AvailableLinkedItemsItemStatusLocator;

@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[6]/span")
private WebElement AvailableLinkedItemsDisplayOnlineLocator;

@FindBy(xpath="//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[7]/span")
private WebElement AvailableLinkedItemsLinkeditemsQTYLocator;

@FindBy(xpath="//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[1]/div/span")
private WebElement ListItemLinkTypesActionLabelLocator;
@FindBy(xpath="//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[2]/span")
private WebElement ListItemLinkTypesSLLabelLocator;
@FindBy(xpath="//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[3]/div/span")
private WebElement ListItemLinkTypesNameLabelLocator;
@FindBy(xpath="//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[4]/div/span")
private WebElement ListItemLinkTypesDescriptionLabelLocator;
@FindBy(xpath="//a[@title='Add New Item Link Type']")
private WebElement AddNewLinkTypeLocator;

@FindBy(xpath="//input[@id='addNewItemLinkTypeForm:lNameId']")
private WebElement LinkTypeNameFieldLocator;
@FindBy(xpath="//textarea[@id='addNewItemLinkTypeForm:linkId']")
private WebElement LinkTypeDescriptionFieldLocator;
@FindBy(xpath="//input[@title='Save New Item Link Type']")
private WebElement saveLinkTypeLocator;
@FindBy(xpath="//input[@id='addNewItemLinkTypeForm:btnReset']")
private WebElement resetLinkTypeLocator;
@FindBy(xpath="//form[@id='addNewItemLinkTypeForm']/div[2]/img")
private WebElement closeLinkTypeForm;

@FindBy(xpath="//span[@id='msg']")
private WebElement linktypeSuccessMsg;

@FindBy(xpath="//span[@id='msg2']")
private WebElement linktypeDeleteMsg;

@FindBy(xpath="//span[contains(text(),'Test_New_link1')]/ancestor::td/preceding-sibling::td/descendant::input[@title='Remove']")
private WebElement deleteButtonLinkType;

@FindBy(xpath="//span[contains(text(),'Test_New_link1')]/ancestor::td/preceding-sibling::td/descendant::input[@title='Edit Item Link Type']")
private WebElement linkTypeEditbutton;

@FindBy(xpath="//input[@id='EditItemLinkTypeForm:lNameId']")
private WebElement EditFormlinktypeNameLocator;
@FindBy(xpath="//textarea[@id='EditItemLinkTypeForm:linkDesc']")
private WebElement EditFormlinktypeDescLocator;
@FindBy(xpath="//input[@title='Update']")
private WebElement EditFormlinktypeSaveLocator;
@FindBy(xpath="//input[@id='EditItemLinkTypeForm:btnReset']")
private WebElement EditFormlinktypeResetLocator;

@FindBy(xpath="//form[@id='EditItemLinkTypeForm']/div[2]/img")
private WebElement EditFormlinktypeCloseLocator;

//form[@id='EditItemLinkTypeForm']/div[2]/img

@FindBy(xpath="//td[@id='CPTab_lbl']")
private WebElement customPricesLink;

@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[4]/div/input")
private WebElement OverPriceCheckboxLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[5]/div/input")
private WebElement featuredProductCheckboxLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[6]/div/input")
private WebElement displayPricingCheckboxLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[7]/div/input")
private WebElement addTocartCheckboxLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[8]/div/div/input")
private WebElement clearanceItemLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[9]/div/input")
private WebElement imapIdItemLocator;


@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[10]/input")
private WebElement IMAPPriceTextFieldLocator;
@FindBy(xpath="//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[12]/input")
private WebElement NetPriceTextFieldLocator;









@Step("click on categorization tab")
	public EditItemsPageObjects clickOnCategorizationTab(){
			Waiting.explicitWaitVisibilityOfElement(categorizationTabLocator, 14);
			categorizationTabLocator.click();
			return this;
	}

@Step("verify whether the product has the category {0}")
	public EditItemsPageObjects verifyWhetherTheProductBelongsToTheCategory(String categoryToSearch) {
		
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}

	
	Assert.assertTrue(driver.findElement(By.xpath("//table[@id='tabs']/descendant::span[text()='"+categoryToSearch+"']")).isDisplayed(),"The item does not belong to the category that was filtered.");
	return this;
	}

	@Step("click on results link.")
	public EditItemsPageObjects clickOnResultsLink() {
	Waiting.explicitWaitVisibilityOfElement(resultsLinkLocator, 6);
	resultsLinkLocator.click();
	return this;	
	}

	@Step("store the edit items breadcrumb")
	public String getCimmItemId() {
		
		return cimmItemIdValueLocator.getText().trim();
	}

	@Step("store the edit items breadcrumb")
	public String getEditItemsBreadCrump() {
		return editItemsBreadcrumbLocator.getText().trim();
	}

	
	@Step("click on item link in the right navigation bar")
	public EditItemsPageObjects clickOnItemLink() {
		Waiting.explicitWaitVisibilityOfElement(itemLinkLocator, 6);
		itemLinkLocator.click();
		return this;
	}
	
	@Step("verify whether the cimmBreadcrump {0} that was taken before clicking on Item link is the same as {1} ")
	public boolean assertEditItemsBreadCrumb(String actualBreadCrump, String expectedBreadCrump) {
		return actualBreadCrump.equals(expectedBreadCrump);
	}

	@Step("verify whether the cimmItemIdValue {0} that was taken before clicking on Item link is the same as {1} ")
	public boolean assertEditItemsCimmItemIdValue(String actualCimmItemIdValue, String expectedCimmItemIdValue) {
		return actualCimmItemIdValue.equals(expectedCimmItemIdValue);
	}
	

	public EditItemsPageObjects verifyEditItemsBreadCrumbAndCimmItemIdValue(String getBreadCrump, String itemId) {
		Waiting.explicitWaitVisibilityOfElement(cimmItemIdValueLocator, 10);
		Assert.assertTrue(assertEditItemsCimmItemIdValue(cimmItemIdValueLocator.getText().trim(), itemId));
		Waiting.explicitWaitVisibilityOfElement(editItemsBreadcrumbLocator, 4);
		Assert.assertTrue(assertEditItemsBreadCrumb(editItemsBreadcrumbLocator.getText().trim(), getBreadCrump));
		return this;
	}


	@Step("click on linked items tab.")
	public EditItemsPageObjects clickOnLinkedItemsTab() {
		Waiting.explicitWaitVisibilityOfElement(linkedItemsTabLocator, 10);
		linkedItemsTabLocator.click();
		return this;
	}

	@Step("verify tabs under Linked Items tab to be setUpLinkedItemsLocator,availableLinkedItemsLocator,listItemLinkTypesLocator.")
	public EditItemsPageObjects verifyTabsUnderLinkedItemsTab() {
		Waiting.explicitWaitVisibilityOfElement(setUpLinkedItemsLocator, 10);
		Assert.assertTrue(setUpLinkedItemsLocator.getAttribute("class").contains("active"),"Setup Linked Items tab is by default not active.");
		Assert.assertTrue(availableLinkedItemsLocator.getAttribute("class").contains("inactive"),"Available linked items tab is by default active.");
		Assert.assertTrue(listItemLinkTypesLocator.getAttribute("class").contains("inactive"),"List Item Link Types tab is by default active.");
		return this;
	}

	@Step("verify tabs under Linked Items tab to be setUpLinkedItemsLocator,availableLinkedItemsLocator,listItemLinkTypesLocator.")
	
	public EditItemsPageObjects verifySetUpLinkedItemsTab(String [] getExepectedSearchInDropdownValues) {
		Waiting.explicitWaitVisibilityOfElement(searchItemsForItemLinkTypeTabNameLocator, 10);
		Assert.assertTrue(searchItemsForItemLinkTypeTabNameLocator.isDisplayed(),"Search Items For LinkType tab name is not displayed.");
		Assert.assertTrue(searchItemLinkTypeSearchTextboxLocator.isDisplayed(),"Search Item For Link Type textbox is not displayed.");
		Assert.assertTrue(searchButtonLocator.isDisplayed(),"Search Item For Link Type textbox is not displayed.");
		for(int i=0;i<searchInDropdownValuesLocator.size();i++)
		{
			Assert.assertEquals(searchInDropdownValuesLocator.get(i).getText().trim(), getExepectedSearchInDropdownValues[i]);
		}
		Assert.assertTrue(manufacturerDropdownLocator.isDisplayed(),"manufacturer dropdown is not displayed.");
		Assert.assertTrue(brandDropdownLocator.isDisplayed(),"brand dropdown is not displayed.");
		Assert.assertTrue(itemLinkTypeDropdownLocator.isDisplayed(),"item link type dropdown is not displayed.");
		return this;
	}

	public EditItemsPageObjects clickOnHistoryLink() {
		Waiting.explicitWaitVisibilityOfElement(historyLinkLocator, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",historyLinkLocator);
		return this;
	}
	
	
	public boolean assertAlertMsg(String alertText) {
		boolean t = TestUtility.getAlertText().trim().equals(alertText.trim());
		TestUtility.alertAccept();
		return t;
	}
	
	public EditItemsPageObjects verifyAlertMsg(String alertText) {
		Assert.assertTrue(assertAlertMsg(alertText));
		return this;
	}

	@Step("click on keywords tab")
	public EditItemsPageObjects clickOnKeywordsTab() {
		keyWordsTabLocator.click();
		return this;
	}

	public EditItemsPageObjects enterMetaKeyword(String metaKeywordText) {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Step("click on CPN tab")
	public EditItemsPageObjects clickonCpnTab() {
		Waiting.explicitWaitVisibilityOfElement(cpnTabLocator, 10);
		cpnTabLocator.click();
		return this;
		
	}
	
	@Step("click on add button")
	public EditItemsPageObjects clickOnAddNewCpn() {
		Waiting.explicitWaitVisibilityOfElement(addNewCpnLocator, 10);
		addNewCpnLocator.click();
		return this;

		
	}
	
	@Step("enter customer name")
	public EditItemsPageObjects enterNewCpn(String cpnTextEnter) {
		Waiting.explicitWaitVisibilityOfElement(addNewCpnTextboxLocator, 3);
		addNewCpnTextboxLocator.sendKeys(cpnTextEnter);
		return this;
		// TODO Auto-generated method stub
		
	}


	@Step("click on add new number")
	public EditItemsPageObjects clickOnAddNewNumber() {
		Waiting.explicitWaitVisibilityOfElement(addNewNumber, 3);
		addNewNumber.click();
		return this;
		
	}

	@Step("enter new CPN")
	public EditItemsPageObjects enterNewNumber(String cpnNumberEnter) {		
		Waiting.explicitWaitVisibilityOfElement(enterNewNumberLocator, 5);
		enterNewNumberLocator.sendKeys(cpnNumberEnter);
		return this;
		
	}

	@Step("click on save new cpn")
	public EditItemsPageObjects clickOnSaveCpn() {
		saveNewCpn.click();
		return this;
		
	}

	@Step("verify the success message")
	public EditItemsPageObjects verifyNewCpnSavedSuccessMessage(String successMessageOfCreationOfNewCpn) {
		Waiting.explicitWaitVisibilityOfElement(cpnSuccessMessageLocator, 8);
		Assert.assertEquals(cpnSuccessMessageLocator.getText().trim(), "Customer Part Numbers Saved Successfully .");
		return this;
		// TODO Auto-generated method stub
		
	}

	public EditItemsPageObjects VerifyPartnumber(String partNumberField) {
		Assert.assertEquals(addNewItemPage().enterPartNumberLocator.getAttribute("value"),partNumberField);
		return this;
	}

	public EditItemsPageObjects verifSaveResethistory() throws InterruptedException {
	Thread.sleep(2000);
	Assert.assertTrue(itemUpdateButtonLocator.isDisplayed(), "Save button is not displayed");
	Assert.assertTrue(resetButtonLocator.isDisplayed(), "reset button is not displayed");
	Assert.assertTrue(historyButtonLocator.isDisplayed(), "history button is not displayed");
	return this;	
	}

	public EditItemsPageObjects verifyRightPanelItemFieds(String getmanufacturerPartNumber,String partNumberField,
		String getlistPrice, String getcostPrice, String getuserrating, String hits, String popularity) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(itemEditRightMPNLocator.getText().trim(), getmanufacturerPartNumber);
		Assert.assertEquals(itemEditRightPNLocator.getText().trim(), partNumberField);
		Assert.assertEquals(itemEditRightListPriceLocator.getText().trim(), getlistPrice);
		Assert.assertEquals(itemEditRightCostPriceLocator.getText().trim(), getcostPrice);
		Assert.assertEquals(itemEditRightUserRatingLocator.getText().trim(), getuserrating);
		Assert.assertEquals(itemEditRightHitsgLocator.getText().trim(), hits);
		Assert.assertEquals(itemEditRightPopularityLocator.getText().trim(), popularity);
		Assert.assertTrue(itemEditRightResultButtonLocator.isDisplayed(),"Result button is not displayed");
		Assert.assertTrue(itemEditRightItemButtonLocator.isDisplayed(),"item button is not displayed");
		Assert.assertTrue(itemEditRightSearchButtonLocator.isDisplayed(),"search icon button is not displayed");
		Assert.assertTrue(itemEditRightpreviousButtonLocator.isDisplayed(),"previous button is not displayed");
		Assert.assertTrue(itemEditRightnextButtonLocator.isDisplayed(),"next button is not displayed");
		return this;
	}

	public EditItemsPageObjects verificationBrandManufacturerdropdown() {
		Assert.assertTrue(manufacturerDropdownLocator.isDisplayed(),"manufacturer dropdown is not displayed.");
		Assert.assertTrue(brandDropdownLocator.isDisplayed(),"brand dropdown is not displayed.");
		return this;
	}

	public EditItemsPageObjects reenterPartnumber(String getupdatepartnumber) throws InterruptedException {
		Thread.sleep(2000);
		addNewItemPage().enterPartNumberLocator.clear();
		addNewItemPage().enterPartNumberLocator.sendKeys(getupdatepartnumber);
		return this;
	}

	public EditItemsPageObjects clickonUpdateItemButton() {
		itemUpdateButtonLocator.click();
		return this;
	}

	public EditItemsPageObjects VerificationOfUpdateItemMsg(String itemUpdateMSG) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(itemupdatemsgLocator.getText().trim(), itemUpdateMSG);
		return this;
	}

	public EditItemsPageObjects clickOnResetButton() throws InterruptedException {
		resetButtonLocator.click();
		Thread.sleep(2000);
		return this;
	}

	public EditItemsPageObjects clickOnDescriptionTabLink() {
		itemDescriptionLocator.click();
		return this;
	}

	public EditItemsPageObjects verifyFieldsDescriptionFields() {
		Assert.assertTrue(langDescriptionLocator.isDisplayed());
		Assert.assertTrue(pageTitleDescriptionLocator.isDisplayed());
		Assert.assertTrue(shortDescriptionLocator.isDisplayed());
		Assert.assertTrue(Long1DescriptionLocator.isDisplayed());
		Assert.assertTrue(Long2DescriptionLocator.isDisplayed());
		Assert.assertTrue(itemFeaturesDescriptionLocator.isDisplayed());
		Assert.assertTrue(MetaDescriptionLocator.isDisplayed());
		Assert.assertTrue(InvoiceDescriptionLocator.isDisplayed());
		Assert.assertTrue(ItemMarketDescriptionLocator.isDisplayed());
		return this;
	}

	public EditItemsPageObjects verifyTinyMceEditor() throws InterruptedException {
		ItemshortDescriptionLocator.click();
		Assert.assertTrue(ShortTinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		Itemlong1DescriptionLocator.click();
		Assert.assertTrue(long1TinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		ItemLongDescription2TextboxLocator.click();
		Assert.assertTrue(long2TinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		ItemItemFeaturesDescriptionTextboxLocator.click();
		Assert.assertTrue(itemFeaturesTinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		IteminvoiceDescriptionTextboxLocator.click();
		Assert.assertTrue(InvoiceTinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		ItemMarketDescriptionTextboxLocator.click();
		Assert.assertTrue(ItemMarketingTinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		Thread.sleep(2000);
		return this;
	}
	
	public EditItemsPageObjects verificationOfDescription(String descOptions, String testData) throws Exception {
	switch(descOptions){
	case "Page Title":
		ItemPageTitleDescriptionLocator.sendKeys(testData);
		break;
	case "Short Description":
		ItemshortDescriptionLocator.sendKeys(testData);
		break;
	case "Long Description":
		Itemlong1DescriptionLocator.clear();
		Itemlong1DescriptionLocator.sendKeys(testData);
		Thread.sleep(4000);
		break;
	case "Long Description 2":
		ItemLongDescription2TextboxLocator.sendKeys(testData);
		break;
	case "Item Features":
		ItemItemFeaturesDescriptionTextboxLocator.sendKeys(testData);
		break;
	case "Meta Description":
		ItemMetaDescriptionTextboxLocator.sendKeys(testData);
		break;
	case "Invoice Description":
		IteminvoiceDescriptionTextboxLocator.sendKeys(testData);
		break;
	case "Item Market Description":
		ItemMarketDescriptionTextboxLocator.sendKeys(testData);
		break;
	default: throw new Exception("invalid input");
	
	}
		return this;
	}

	public EditItemsPageObjects clickonSavedescriptionButton() {
		ItemSaveDescriptionLocator.click();
		return this;
	}

	public EditItemsPageObjects verifyDacriptionUpdateMsg(String itemUpdateMSG) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(ItemSaveDescriptionMSGLocator.getText().trim(), itemUpdateMSG);
		return this;
	}

	public EditItemsPageObjects clickOnProductsTabLink() throws InterruptedException {
		productslinkLocator.click();
		Thread.sleep(2000);
		return this;
	}

	public EditItemsPageObjects verifyFieldsProductsFields() {
		Assert.assertTrue(productNameFieldLocator.isDisplayed(), "Product Name field is not displayed");
		Assert.assertTrue(productNumberFieldLocator.isDisplayed(), "Product Number field is not displayed");
		Assert.assertTrue(productdescFieldLocator.isDisplayed(), "Product Description field is not displayed");
		Assert.assertTrue(productDelinkLocator.isDisplayed(), "Product Delink button field is not displayed");
		Assert.assertTrue(productSearchFieldLocator.isDisplayed(), "Product search text field is not displayed");
		Assert.assertTrue(productSearchButtonLocator.isDisplayed(), "Product search button is not displayed");
		Assert.assertTrue(productActionLabelLocator.isDisplayed(), "Action label is not displayed");
		Assert.assertTrue(productNameImageLabelLocator.isDisplayed(), "Product Name & image label is not displayed");
		Assert.assertTrue(productDescLocator.isDisplayed(), "Product Description label is not displayed");
		return this;
	}

	public EditItemsPageObjects clickOnKeywordsTabLink() {
		keywordlinkLocator.click();
		return this;
	}

	public EditItemsPageObjects verifyKeywordsTabFields() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(CustomkeywordlinkLocator.isDisplayed(), "Custom keywords label is not displayed");
		Assert.assertTrue(MetakeywordlinkLocator.isDisplayed(), "Meta keywords label is not displayed");
		Assert.assertTrue(keywordautomgeneratedlinkLocator.isDisplayed(), "keywords auto generated label is not displayed");
		Assert.assertTrue(PartNumberKeywordslinkLocator.isDisplayed(), "part Number auto genrated keywords label is not displayed");
		return this;
	}
	
	@Step("click on custom keyword field and entering the data")
	public EditItemsPageObjects enterDataToCustomKeywordsField(String getcustomKeyword) throws InterruptedException {
		Thread.sleep(2000);
		CustomKeywordsTextboxLocator.clear();
		CustomKeywordsTextboxLocator.sendKeys(getcustomKeyword);
		return this;
	}
	
	@Step("click on meta keyword field and entering the data")
	public EditItemsPageObjects enterDataToMetaKeywordsField(String metaKeywordText) throws InterruptedException {
		Thread.sleep(2000);
		MetaKeywordsTextboxLocator.click();
		MetaKeywordsTextboxLocator.sendKeys(metaKeywordText);
		return this;
	}
	
	@Step("click on keyword save icon")
	public EditItemsPageObjects clickOnKeywordSaveIcon() throws InterruptedException {
		KeywordsSaveLocator.click();
		Thread.sleep(2000);
		return this;
	}
	
	@Step("Verify item Update success message")
	public EditItemsPageObjects VerifyItemupdateSuccessMsg(String itemUpdateMSG) throws InterruptedException {
		Thread.sleep(2000);
	Assert.assertEquals(keywordsSuccessMsgLocator.getText().trim(), itemUpdateMSG);
		return this;
	}
	
	@Step("click on revision history link")
	public EditItemsPageObjects clickOnHistoryLinkInKeywordsTab() {
		KeywordsRevisionLocator.click();
		return this;
	}
	
	@Step("click on documents tab link")
	public EditItemsPageObjects clickOnDoucmentsTabLink() {
		DocumentsLinkLocator.click();
		return this;
	}
	
	@Step("Verify the fields present in documents tab")
	public EditItemsPageObjects verifyDocumentTabFields() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(DocumentLangLocator.isDisplayed(), "Document language drop down is not displayed");
		Assert.assertTrue(DocumentindtructionLocator.isDisplayed(),"Document instruction is not displayed");
		Assert.assertTrue(DocumentcatdropdownLocator.isDisplayed(),"Document category drop down is not displayed");
		Assert.assertTrue(DocumentAddlinkLocator.isDisplayed(),"Add new document icon is not displayed");
		Assert.assertTrue(DocumentRevisionHistorylinkLocator.isDisplayed(),"Document history icon is not displayed");
		DocumentcatdropdownLocator.click();
		Thread.sleep(5000);
		return this;
	}
	
	@Step("Selecting document category from document category drop down in documents tab")
	public EditItemsPageObjects verifySelectingDocumentCategory(String getdocumentcategory) throws InterruptedException {
		Thread.sleep(3000);
		DocumentcatdropdownLocator.click();
		Thread.sleep(2000);
		for(WebElement catdropdown : documentCatDropdownLocator){
			if(catdropdown.getText().trim().equals(getdocumentcategory)){
				catdropdown.click();
				break;
			}
		}
		return this;
	}
	
	@Step("Click on add new document button in documents tab")
	public EditItemsPageObjects clickOnAddnewDocumentIcon() throws InterruptedException {
		Thread.sleep(3000);
		DocumentAddlinkLocator.click();		
		return this;
	}
	
	@Step("Verify the fields present in add new document form")
	public EditItemsPageObjects verifyAddnewDocumentFormFields() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(AddnewDocumentcatdropdownLocator.isDisplayed(),"Document category dropdown is not displayed");
		Assert.assertTrue(AddnewDocumentcatlinkLocator.isDisplayed(),"Add new document category link is not displayed ");
		Assert.assertTrue(AddnewDocumentcaptionLocator.isDisplayed(),"Document caption field is not displayed");
		Assert.assertTrue(AddnewDocumentURLLocator.isDisplayed(),"Document URL field is not displayed");
		Assert.assertTrue(AddnewDocumentuploadIconLocator.isDisplayed(),"Document upload button is not displayed");
		Assert.assertTrue(AddnewDocumentOverwritecheckLocator.isDisplayed(),"Document overwrite checkbox is not displayed");
		Assert.assertTrue(AddnewDocumentSaveButtonLocator.isDisplayed(),"Document save button is not displayed");
		Assert.assertTrue(AddnewDocumentResetButtonLocator.isDisplayed(),"Document reset button is not displayed");
		return this;
	}
	
	@Step("uploading an document using Document URL in documents tab ")
	public EditItemsPageObjects addNewDocumentURL(String documentCaption,String getdocumentURL) {
		AddnewDocumentcaptionLocator.sendKeys(documentCaption);
		AddnewDocumentURLLocator.sendKeys(getdocumentURL);
		AddnewDocumentSaveButtonLocator.click();
		return this;
	}
	
	@Step("verify success message after uploading an documents in documents tab ")
	public EditItemsPageObjects verifySuccessMSG(String getdocumentSuccessmsg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(), getdocumentSuccessmsg);
		return this;
	}
	
	@Step("Remove assigned document from the assigned documents tab ")
	public PageFactoryInitializer removeAssignedDocument(String documentremoveMsg) throws InterruptedException {
		DocumentURLcheckboxLocator.click();
		DocumentdeleteButtonLocator.click();
		TestUtility.alertAccept();
		Thread.sleep(3000);
		Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(), documentremoveMsg);
		return this;
	}
	
	@Step("click on edit button in assigned document")
	public EditItemsPageObjects clickOnEditCaption() throws InterruptedException {
		EditAssignedDocumentLocator.click();
		Thread.sleep(2000);
		return this;
	}
	
	@Step("enter document caption for update")
	public EditItemsPageObjects updateDocumentCaption(String updateddocumentCaption) {
		EditDocumentCapLocator.clear();
		EditDocumentCapLocator.sendKeys(updateddocumentCaption);
		return this;
	}
	
	@Step("click on Update caption save button")
	public EditItemsPageObjects clickOnUpdateDocumentButton() throws InterruptedException {
		UpdateDocumentCapLocator.click();
		Thread.sleep(2000);
		return this;
	}
	
	@Step("Verify Success message of update document caption")
	public EditItemsPageObjects verifySuccessMSgDocumentUpdate(String getupdateDocumentCaptionMsg) {
		Assert.assertEquals(UpdateDocumentCapSuccessMsgLocator.getText().trim(), getupdateDocumentCaptionMsg);
		return this;
	}
		
	@Step("Click on cancel button in document caption update form")
	public EditItemsPageObjects clickCancelButton() throws InterruptedException {
		UpdateDocumentCapCancelLocator.click();
		Thread.sleep(2000);
		return this;
	}
	@Step("click on add new document category pop up")
	public EditItemsPageObjects clickOnDocumentCatLink() throws InterruptedException {
		DocumentCatPopupLocator.click();
		Thread.sleep(1000);
		return this;
	}
	@Step("click on close icon of add new document cateory popup")
	public EditItemsPageObjects closeCatPopUp() {
		DocumentCatCloseLocator.click();
		return this;
	}
	@Step("Enter document category name in document category pop up")
	public EditItemsPageObjects enterdocumentname(String documentcategoryname) {
		DocumentCatnameLocator.sendKeys(documentcategoryname);
		return this;
	}
	@Step("Enter document Description in document category pop up")
	public EditItemsPageObjects enterdocumentdescription(String documentCatDescription) {
		DocumentCatdescriptionLocator.sendKeys(documentCatDescription);
		return this;
	}
	@Step("Enter document category name in document category pop up")
	public EditItemsPageObjects clickOnDocumentCatSaveButton() {
		DocumentCatSaveLocator.click();
		return this;
	}
	@Step("Verifying document category name required message in document category popup")
	public EditItemsPageObjects verifyDocmentCatNameErrorMsg(String documentCatErrorMsg) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(DocumentCatSaveErrorMsgLocator.getText().trim(), documentCatErrorMsg);
		return this;
	}
	@Step("Verifying document caption field in add new document form")
	public PageFactoryInitializer verifyDocumentCaption(String DocumentRequiredCaptionMsg,String documentCaption) throws InterruptedException {
		AddnewDocumentSaveButtonLocator.click();
		Thread.sleep(2000);
		Assert.assertEquals(DocumentCaptionErrorMsgLocator.getText().trim(), DocumentRequiredCaptionMsg);
		AddnewDocumentcaptionLocator.sendKeys(documentCaption);
		return this;
	}
	@Step("Verifying document URL field in add new document form")
	public PageFactoryInitializer verifyDocumentURL(String getdocumentCaption, String getDocumentRequiredURLMsg, String DocumentURL) throws InterruptedException {
		AddnewDocumentcaptionLocator.sendKeys(getdocumentCaption);
		AddnewDocumentSaveButtonLocator.click();
		Thread.sleep(2000);
		Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(), getDocumentRequiredURLMsg);
		AddnewDocumentURLLocator.sendKeys(DocumentURL);
		return this;
	}
	@Step("clicking on history link in documents tab")
	public EditItemsPageObjects clickOnDocumentHistoryLink() throws InterruptedException {
		DocumentHistoryLocator.click();
		Thread.sleep(2000);
		return this;
	}
	
	@Step("clicking on videos tab link")
	public EditItemsPageObjects clickonVideosTabLink() throws InterruptedException {
		VideosTablinkLocator.click();
		Thread.sleep(2000);
		return this;
	}
	@Step("Verify the content of videos tab")
	public EditItemsPageObjects verifyContentofVideosTab() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(AssignedvideoLocator.isDisplayed(), "Assigned Video label is not diaplayed");
		Assert.assertTrue(AssignedActionLocator.isDisplayed(), "Action label is not diaplayed");
		Assert.assertTrue(AssignedItemVideoLabelLocator.isDisplayed(), "Assinged video label is not diaplayed");
		Assert.assertTrue(AssignedItemVideoURLLabelLocator.isDisplayed(), "Assinged video URL label is not diaplayed");
		Assert.assertTrue(VideoLibraryLabelLocator.isDisplayed(), "Video library label is not diaplayed");
		Assert.assertTrue(VideoLibrarySearchFieldLocator.isDisplayed(), "Video search field is not diaplayed");
		Assert.assertTrue(VideoLibrarySearchButtonLocator.isDisplayed(), "Video search button is not diaplayed");
		Assert.assertTrue(addNewVideoButtonLocator.isDisplayed(), "Add new video button is not diaplayed");
		return this;
	}
	@Step("click on add new video button in new videos tab")
	public EditItemsPageObjects clickAddNewVideoButton() {
		addNewVideoButtonLocator.click();
		return this;
	}
	@Step("Verify the content in add new video form")
	public EditItemsPageObjects verifyAddnewVideoForm() {
		Assert.assertTrue(AddVideoCaptionFieldLocator.isDisplayed(), "video caption field is not diaplayed");
		Assert.assertTrue(AddVideoURLFieldLocator.isDisplayed(), "video URL field is not diaplayed");
		Assert.assertTrue(AddVideoSaveButtonLocator.isDisplayed(), "save video button is not diaplayed");
		Assert.assertTrue(AddVideoResetButtonLocator.isDisplayed(), "reset video button is not diaplayed");
		Assert.assertTrue(AddVideoClosebuttonLocator.isDisplayed(), "close button  is not diaplayed");
		return this;
	}
	@Step("Entering video caption and video URL in add new video form")
	public EditItemsPageObjects addNewVideoURL(String getvideoCaption, String getvideoURl) {
		AddVideoCaptionFieldLocator.sendKeys(getvideoCaption);
		AddVideoURLFieldLocator.sendKeys(getvideoURl);
		return this;
	}
	@Step("click on save button in add new video form")
	public EditItemsPageObjects clickOnSaveVideoButton() {
		AddVideoSaveButtonLocator.click();
		return this;
	}
	@Step("Verify success message after addindg an video")
	public EditItemsPageObjects verifyAddVideoSaveMsg(String getvideoSaveMsg) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(VideomsgVerifyLocator.getText().trim(), getvideoSaveMsg);
		return this;
	}
	@Step("Click on delete button without selecting an video chekbox")
	public EditItemsPageObjects clickOnAllVideoDeleteButton() throws InterruptedException {
		DeleteAllVideoLocator.click();
		TestUtility.alertDismiss();
		Thread.sleep(2000);
		return this;
	}
	@Step("verify delete video alert message")
	public EditItemsPageObjects verifyDeleteVideoAlertMsg(String getdeleteVideoMsg) {
		Assert.assertEquals(DeleteVideoAlertMsgLocator.getText().trim(), getdeleteVideoMsg);
		return this;
	}
	@Step("clicking on assigned video checkbox")
	public EditItemsPageObjects clickOnVideoCheckbox() {
		assignedVideoCheckboxLocator.click();
		return this;
	}
	@Step("clicking on assigned video delete button")
	public EditItemsPageObjects clickOnAssignedVideoDeleteButton() {
		assignedVideoDeleteButtonLocator.click();
		TestUtility.alertAccept();
		return this;
	}
	@Step("Verifying success Message after removing an video")
	public EditItemsPageObjects VerifyVideoRemoveSuccessMsg(String videotRemoveMsg) {
		Assert.assertEquals(DeleteVideoAlertMsgLocator.getText().trim(), videotRemoveMsg);
		return this;
	}
	@Step("click on Available Linked Items link")
	public EditItemsPageObjects clickOnAvailableLinkedItems() {
		AvailableLinkedItemsLinkLocator.click();
		return this;
	}
	@Step("Verify the content under Available Linked Items tab")
	public EditItemsPageObjects verifyContentunderAvailableLinkedItems() {
		Assert.assertTrue(AvailableLinkedItemsItemIdLocator.isDisplayed(), "Item Id label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsItemImageLocator.isDisplayed(), "Item Image label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsPartNumberLocator.isDisplayed(), "Part Number label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsMPNLocator.isDisplayed(), "Manufacturer Part Number label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsItemStatusLocator.isDisplayed(), "Item Status label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsDisplayOnlineLocator.isDisplayed(), "Display Online label is not diaplayed");
		Assert.assertTrue(AvailableLinkedItemsLinkeditemsQTYLocator.isDisplayed(), "Linked Items Qty Intervals label is not diaplayed");
		return this;
	}
	@Step("Verify the content under List Item Link Types tab")
	public EditItemsPageObjects clickOnListItemLinkTypes() throws InterruptedException {
		Thread.sleep(2000);
		listItemLinkTypesLocator.click();
		return this;
	}
	@Step("Verify the content under List Item Link Types tab")
	public EditItemsPageObjects verifyContentunderListItemLinkTypes() {
		Assert.assertTrue(ListItemLinkTypesActionLabelLocator.isDisplayed(), "Action label is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesSLLabelLocator.isDisplayed(), "Sl No label is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesNameLabelLocator.isDisplayed(), "Link Type Name is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesDescriptionLabelLocator.isDisplayed(), "Link type description label is not diaplayed");
		Assert.assertTrue(AddNewLinkTypeLocator.isDisplayed(), "Add new link type button is not diaplayed");
		return this;
	}
	@Step("click on add new link type button")
	public EditItemsPageObjects clickonAddnewLinkTypeButton() {
		AddNewLinkTypeLocator.click();
		return this;
	}
	@Step("Verify the content in add new link type form")
	public EditItemsPageObjects verifyContentAddNewLinkTypeForm() {
		Assert.assertTrue(LinkTypeNameFieldLocator.isDisplayed(), "Link type name text field is not diaplayed");
		Assert.assertTrue(LinkTypeDescriptionFieldLocator.isDisplayed(), "Link type description field is not diaplayed");
		Assert.assertTrue(saveLinkTypeLocator.isDisplayed(), "Save Link Type Button is not diaplayed");
		Assert.assertTrue(resetLinkTypeLocator.isDisplayed(), "Reset Link type Button is not diaplayed");
		Assert.assertTrue(closeLinkTypeForm.isDisplayed(), "Close add new link type form is not diaplayed");
		return this;
	}
	@Step("Adding new link type in list item link types")
	public EditItemsPageObjects savingNewlinkType(String getlinktypename, String getlinktypedescription) throws InterruptedException {
		LinkTypeNameFieldLocator.sendKeys(getlinktypename);
		LinkTypeDescriptionFieldLocator.sendKeys(getlinktypedescription);
		saveLinkTypeLocator.click();
		Thread.sleep(2000);
		return this;
	}
	@Step("Verify Success message after creating new link type")
	public EditItemsPageObjects verifyLinktypeSuccessMsg(String getlinktypeSuccessMsg) {
		Assert.assertEquals(linktypeSuccessMsg.getText().trim(), getlinktypeSuccessMsg);
		return this;
	}
	@Step("deleting created link type and alert pop up close ")
	public EditItemsPageObjects deletelinktype(String getlinktypename) throws InterruptedException {
		deleteButtonLinkType.click();
		TestUtility.alertDismiss();
		Thread.sleep(2000);
		deleteButtonLinkType.click();
		TestUtility.alertAccept();
		return this;
	}
	@Step("Verify delete link type message")
	public EditItemsPageObjects verifyLinkTypeDeleteSuccessMsg(String getlinktypename) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(linktypeDeleteMsg.getText().trim(), "ItemLinkType - : '"+getlinktypename+"' removed Successfully");
			return this;
		}
	@Step("clicking on edit link type form")
	public EditItemsPageObjects verificationEditingLinkTypeForm() {
		linkTypeEditbutton.click();
		
		return this;
	}
	@Step("verifying and updateing created link type")
	public EditItemsPageObjects updatelinktype(String getlinktypeupdatedescription, String getlinktypeupdatemsg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(EditFormlinktypeNameLocator.isDisplayed(), "Link type name text field is not diaplayed");
		Assert.assertTrue(EditFormlinktypeDescLocator.isDisplayed(), "Link type description field is not diaplayed");
		Assert.assertTrue(EditFormlinktypeSaveLocator.isDisplayed(), "Save Link Type Button is not diaplayed");
		Assert.assertTrue(EditFormlinktypeResetLocator.isDisplayed(), "Reset Link type Button is not diaplayed");
		Assert.assertTrue(EditFormlinktypeCloseLocator.isDisplayed(), "Close add new link type form is not diaplayed");
		Thread.sleep(2000);
		EditFormlinktypeDescLocator.sendKeys(getlinktypeupdatedescription);
		EditFormlinktypeSaveLocator.click();
		Thread.sleep(3000);
		Assert.assertEquals(linktypeSuccessMsg.getText().trim(), getlinktypeupdatemsg);
		return this;
	}
	@Step("click on custom prices link")
	public EditItemsPageObjects clickOnCustomPricesTab() {
		customPricesLink.click();
		return this;
	}
	@Step("Verifying custom fields in custom prices tab")
	public EditItemsPageObjects verifyCustomPricesTabFields() {
		Assert.assertTrue(OverPriceCheckboxLocator.isDisplayed(), "Over price checkbox is not diaplayed");
		Assert.assertTrue(featuredProductCheckboxLocator.isDisplayed(), "featured Product checkbox is not diaplayed");
		Assert.assertTrue(displayPricingCheckboxLocator.isDisplayed(), "display Pricing checkbox is not diaplayed");
		Assert.assertTrue(displayPricingCheckboxLocator.isDisplayed(), "addTocart checkbox is not diaplayed");
		Assert.assertTrue(clearanceItemLocator.isDisplayed(), "clearance checkbox is not diaplayed");
		Assert.assertTrue(imapIdItemLocator.isDisplayed(), "Imap checkbox is not diaplayed");
		return this;
	}

	



	}
