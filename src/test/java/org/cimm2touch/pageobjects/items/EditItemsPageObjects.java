package org.cimm2touch.pageobjects.items;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class EditItemsPageObjects extends PageFactoryInitializer {
	
	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());
	Waiting waiting = new Waiting(getDriver());
	RandomGenerator random = new RandomGenerator();

	@FindBy(xpath = "//td[contains(text(),'Categorization')]")
	private WebElement categorizationTabLocator;

	@FindBy(xpath = "//span[contains(text(),'Results')]")
	private WebElement resultsLinkLocator;

	@FindBy(xpath = "//div[@class='tabContentTopStrip']/descendant::span[contains(@id,'itemIdValueDisplayId')]")
	private WebElement cimmItemIdValueLocator;

	@FindBy(xpath = "//span[contains(text(),'Edit Item')]")
	private WebElement editItemsBreadcrumbLocator;

	@FindBy(xpath = "//a[text()='Item']")
	private WebElement itemLinkLocator;

	@FindBy(xpath = "//td[contains(text(),'Linked Items')]")
	private WebElement linkedItemsTabLocator;

	@FindBy(xpath = "//td[contains(text(),'Setup Linked Items')]")
	private WebElement setUpLinkedItemsLocator;

	@FindBy(xpath = "//td[contains(text(),'Available Linked Items')]")
	private WebElement availableLinkedItemsLocator;

	@FindBy(xpath = "//td[contains(text(),'List Item Link Types')]")
	private WebElement listItemLinkTypesLocator;

	@FindBy(xpath = "//span[contains(text(),'Search Items for Item LinkType')]")
	private WebElement searchItemsForItemLinkTypeTabNameLocator;

	@FindBy(xpath = "//input[@placeholder='Search Item LinkType']")
	private WebElement searchItemLinkTypeSearchTextboxLocator;

	@FindBy(xpath = "//input[@id='lnkditmSrchIdf:searchKeywordId']")
	private WebElement searchItemLinkTypeSearchTextboxLoc;

	@FindBy(xpath = "//span[contains(text(),'Search Items for Item LinkType')]/ancestor::div/following-sibling::div/descendant::a[contains(@id,'goBtn')]")
	private WebElement searchButtonLocator;

	@FindAll(value = { @FindBy(xpath = "//select[@id='lnkditmSrchIdf:searchInId']/option") })
	private List<WebElement> searchInDropdownValuesLocator;

	@FindBy(xpath = "//input[contains(@id,'manufacturerListComboIdcomboboxField')]")
	private WebElement manufacturerDropdownLocator;

	@FindBy(xpath = "//input[contains(@id,'brandListComboIdcomboboxField')]")
	private WebElement brandDropdownLocator;

	@FindBy(xpath = "//input[contains(@id,'linkedItemsComboIdcomboboxField')]")
	private WebElement itemLinkTypeDropdownLocator;

	@FindBy(xpath = "//a[@title='History']")
	private WebElement historyLinkLocator;

	@FindBy(xpath = "//td[@id='KWTab_lbl']")
	private WebElement keyWordsTabLocator;

	@FindBy(xpath = "//td[@id='CpnumTab_lbl']")
	private WebElement cpnTabLocator;

	@FindBy(xpath = "//input[@id='warehouseListFormId:warehouseDataTable:warehouseNameColfsp']")
	private WebElement warehouseSearchInputLocator;

	@FindBy(xpath = "//input[@title='Add Customer Part Number']")
	private WebElement addNewCpnLocator;

	@FindBy(xpath = "//input[contains(@id,'buyingCompanyId')]")
	private WebElement addNewCpnTextboxLocator;

	@FindBy(xpath = "//td[contains(text(),'General Info')]")
	private WebElement generalInfoTabLocator;

	@FindBy(xpath = "//input[@id='itemNavigateForm:nextItemIcon']")
	private WebElement nextItemIconLocator;

	@FindBy(xpath = ".//*[@id='custPrtNumFormId:CPNFormId:addNewcstPnumId']")
	private WebElement addNewNumber;

	@FindBy(xpath = "//input[@id='custPrtNumFormId:CPNFormId:cstTable:0:cstpNumId']")
	private WebElement enterNewNumberLocator;

	@FindBy(xpath = ".//*[@id='custPrtNumFormId:CPNFormId:savecstPnumId']")
	private WebElement saveNewCpn;

	@FindBy(xpath = ".//*[@id='custPrtNumFormId:CPNFormId:insertMsg']")
	private WebElement cpnSuccessMessageLocator;

	@FindBy(xpath = "//input[@id='generalInfoFormId:btnReset']")
	private WebElement resetButtonLocator;

	@FindBy(xpath = "//a[@title='History']")
	private WebElement historyButtonLocator;

	@FindBy(xpath = "//form[@id='generalInfoFormId']/descendant::input[contains(@title,'Update Item')]")
	private WebElement itemUpdateButtonLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[2]/td[3]")
	private WebElement itemEditRightMPNLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[3]/td[3]")
	private WebElement itemEditRightPNLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[4]/td[3]")
	private WebElement itemEditRightListPriceLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[5]/td[3]")
	private WebElement itemEditRightCostPriceLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[6]/td[1]/strong")
	private WebElement itemEditRightUserRatingLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[7]/td[1]/strong")
	private WebElement itemEditRightHitsgLocator;

	@FindBy(xpath = "//form[@id='itemDtlFm']/table/tbody/tr[8]/td[1]/strong")
	private WebElement itemEditRightPopularityLocator;

	@FindBy(xpath = "//a[@title='Goto PreviousPage']/span")
	private WebElement itemEditRightResultButtonLocator;

	@FindBy(xpath = "//a[@class='resultBtnLabel']")
	private WebElement itemEditRightItemButtonLocator;

	@FindBy(xpath = "//form[@id='itemNavigateForm']/descendant::input[@title='Search']")
	private WebElement itemEditRightSearchButtonLocator;

	@FindBy(xpath = "//input[@id='itemNavigateForm:previousItemIcon']")
	private WebElement itemEditRightpreviousButtonLocator;

	@FindBy(xpath = "//input[@id='itemNavigateForm:nextItemIcon']")
	private WebElement itemEditRightnextButtonLocator;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement itemupdatemsgLocator;

	@FindBy(xpath = "//td[@id='DescTab_lbl']")
	private WebElement itemDescriptionLocator;

	@FindBy(xpath = "//select[@id='itemDescFormId:locidDesc']")
	private WebElement langDescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[1]/div[1]")
	private WebElement pageTitleDescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[2]/div[1]")
	private WebElement shortDescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[3]/div[1]")
	private WebElement Long1DescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[4]/div[1]")
	private WebElement Long2DescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[5]/div[1]")
	private WebElement itemFeaturesDescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[6]/div[1]")
	private WebElement MetaDescriptionLocator;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[7]/div[1]")
	private WebElement InvoiceDescriptionLocator;

	@FindBy(xpath = "//input[@id='advSearchFm:goBtn']")
	private WebElement searchButtonInEditPage;

	@FindBy(xpath = "//div[@class='tab_descriptionForm']/div[1]/span[8]/div[1]")
	private WebElement ItemMarketDescriptionLocator;

	@FindBy(xpath = "//input[@id='generalInfoFormId:partNumberId']")
	private WebElement partNumberInputFieldItemEditPage;

	@FindBy(xpath = "(//div[@id='noEditor'])[1]")
	private WebElement ItemPageTitleDescriptionLocator;

	@FindBy(xpath = "//div[@id='shortDescriptionEditor']")
	private WebElement ItemshortDescriptionLocator;

	@FindBy(xpath = "//div[@id='longDescEditor']")
	private WebElement Itemlong1DescriptionLocator;

	@FindBy(xpath = "//div[@id='longDesc2Editor']")
	private WebElement ItemLongDescription2TextboxLocator;

	@FindBy(xpath = "//div[@id='itemFeatureEditor']")
	private WebElement ItemItemFeaturesDescriptionTextboxLocator;

	@FindBy(xpath = "(//div[@id='noEditor'])[2]")
	private WebElement ItemMetaDescriptionTextboxLocator;

	@FindBy(xpath = "//div[@id='invoiceEditor']")
	private WebElement IteminvoiceDescriptionTextboxLocator;

	@FindBy(xpath = "//div[@id='marketEditor']")
	private WebElement ItemMarketDescriptionTextboxLocator;

	@FindBy(xpath = "//span[@id='descFormId:discEditPanel']/a/img")
	private WebElement ItemSaveDescriptionLocator;

	@FindBy(xpath = "//span[@id='descFormId:saveMessageId2']")
	private WebElement ItemSaveDescriptionMSGLocator;

	@FindBy(xpath = "(//div[@role='application'])[1]")
	private WebElement ShortTinyMCEeditorLocator;

	@FindBy(xpath = "(//div[@role='application'])[2]")
	private WebElement long1TinyMCEeditorLocator;

	@FindBy(xpath = "(//div[@role='application'])[3]")
	private WebElement long2TinyMCEeditorLocator;

	@FindBy(xpath = "(//div[@role='application'])[4]")
	private WebElement itemFeaturesTinyMCEeditorLocator;

	@FindBy(xpath = "(//div[@role='application'])[5]")
	private WebElement InvoiceTinyMCEeditorLocator;

	@FindBy(xpath = "(//div[@role='application'])[6]")
	private WebElement ItemMarketingTinyMCEeditorLocator;

	@FindBy(xpath = "//td[@id='PROTab_lbl']")
	private WebElement productslinkLocator;

	@FindBy(xpath = "//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[1]/td[1]")
	private WebElement productNameFieldLocator;

	@FindBy(xpath = "//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[2]/td[1]")
	private WebElement productNumberFieldLocator;

	@FindBy(xpath = "//span[@id='productDetailsFormId:prodDetailsId']/div[1]/table/tbody/tr[3]/td[1]")
	private WebElement productdescFieldLocator;

	@FindBy(xpath = "//span[@id='productDetailsFormId:prodDetailsId']/descendant::input[contains(@title,'Delink Item From Above Product')]")
	private WebElement productDelinkLocator;

	@FindBy(xpath = "//input[@id='listProductForm:searchKeywordId']")
	private WebElement productSearchFieldLocator;

	@FindBy(xpath = "//a[@id='listProductForm:goBtn']/i")
	private WebElement productSearchButtonLocator;

	@FindBy(xpath = "//span[@id='listProductForm:productTableID:ACTION']")
	private WebElement productActionLabelLocator;

	@FindBy(xpath = "//input[@id='advSearchFm:searchKeywordId']")
	private WebElement searchFieldInEditPage;

	@FindBy(xpath = "//span[@id='listProductForm:productTableID:ITMIMGH']")
	private WebElement productNameImageLabelLocator;

	@FindBy(xpath = "//table[@id='listProductForm:productTableID']/thead/tr/th[3]")
	private WebElement productDescLocator;

	@FindBy(xpath = "//td[@id='KWTab_lbl']")
	private WebElement keywordlinkLocator;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:customKeywordsId']")
	private WebElement CustomkeywordlinkLocator;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:metaKeywordId']")
	private WebElement MetakeywordlinkLocator;

	@FindBy(xpath = "//input[@id='generalInfoFormId:manufacturerListComboIdcomboboxField']")
	private WebElement manufacturerInputFieldInItemEdit;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:keywordsId']")
	private WebElement keywordautomgeneratedlinkLocator;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:partNumKeywordsId']")
	private WebElement PartNumberKeywordslinkLocator;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:customKeywordsId']")
	private WebElement CustomKeywordsTextboxLocator;

	@FindBy(xpath = "//textarea[@id='keywordsFormId:metaKeywordId']")
	private WebElement MetaKeywordsTextboxLocator;

	@FindBy(xpath = "//input[@id='keywordsFormId:keywordSaveBtn' and @title='Action Buttons']")
	private WebElement KeywordsSaveLocator;

	@FindBy(xpath = "//span[@id='keywordsFormId:saveMessageId']")
	private WebElement keywordsSuccessMsgLocator;

	@FindBy(xpath = "//ul[@class='buttonList']/li[2]/a[@title='Revision History Link']")
	private WebElement KeywordsRevisionLocator;

	@FindBy(xpath = "//td[@id='DocTab_lbl']")
	private WebElement DocumentsLinkLocator;

	@FindBy(xpath = "//input[@id='warehouseListFormId:warehouseDataTable:SALL1']")
	private WebElement warehouseSelectAllCheckBox;

	@FindBy(xpath = "//td[@id='ImgTab_lbl']")
	private WebElement imagesLinkLocator;

	@FindBy(xpath = "//select[@id='solrForm:locidDoc']")
	private WebElement DocumentLangLocator;

	@FindBy(xpath = "//select[@id='itemDescFormId:locidDesc']")
	private WebElement languageOptionLocator;

	@FindBy(xpath = "//select[@id='itemDescFormId:locidDesc']/option")
	private WebElement languageOptionValueLocator;

	@FindBy(xpath = "//div[@class='cimmDocInstruction']")
	private WebElement DocumentindtructionLocator;

	@FindBy(xpath = "(//select[@class='cimmDocInputText'])[2]")
	private WebElement DocumentcatdropdownLocator;

	@FindBy(xpath = "//input[@id='generalInfoFormId:brandListComboIdcomboboxField']")
	private WebElement brandInputLocatorInItemEditPage;

	@FindBy(xpath = "//input[@id='generalInfoFormId:mpnTxtId']")
	private WebElement mpnInputLocatorInItemEditPage;

	@FindBy(xpath = "//input[@id='addDocumentId']")
	private WebElement DocumentAddlinkLocator;

	@FindBy(xpath = "//a[@title='Revision History Link']")
	private WebElement DocumentRevisionHistorylinkLocator;

	@FindAll(value = {
			@FindBy(xpath = "//form[@id='tabs:_form']/table/tbody/tr//td[contains(@class,'rich-tabhdr-cell-active')]"
					+ "|"
					+ "//form[@id='tabs:_form']/table/tbody/tr//td[contains(@class,'rich-tabhdr-cell-inactive')]") })
	private List<WebElement> itemsTableHeaderTitlesLink;

	@FindAll(value = {
			@FindBy(xpath = "//div[contains(.,'Document Category ')]/descendant::select[contains(@class,'cimmDocInputText') and not(@name='editCaptionFormID:editCategoryList') ]/option") })
	private List<WebElement> documentCatDropdownLocator;

	@FindBy(xpath = "//input[contains(@title,'Delink Item From Above Product')]")
	private WebElement delinkProductLocator;

	@FindBy(xpath = "//select[@id='documentUploadFormId:categoryList']")
	private WebElement AddnewDocumentcatdropdownLocator;

	@FindBy(xpath = "//a[@id='documentUploadFormId:link']")
	private WebElement AddnewDocumentcatlinkLocator;

	@FindBy(xpath = "//input[@id='documentUploadFormId:captionId']")
	private WebElement AddnewDocumentcaptionLocator;

	@FindBy(xpath = "//input[@id='documentUploadFormId:addDocUrl']")
	private WebElement AddnewDocumentURLLocator;

	@FindBy(xpath = "//span[@id='productDetailsFormId:deleteMessage']")
	private WebElement delinkSuccesfulMessageLocator;

	@FindBy(xpath = "//div[@id='documentUploadFormId:itemDocumentUploadId']/table/tbody/tr/td")
	private WebElement AddnewDocumentuploadIconLocator;

	@FindBy(xpath = "//input[@id='documentUploadFormId:docOwId']")
	private WebElement AddnewDocumentOverwritecheckLocator;

	@FindBy(xpath = "//input[@title='Save URL']")
	private WebElement AddnewDocumentSaveButtonLocator;

	@FindBy(xpath = "//th[@id='warehouseListFormId:warehouseDataTable:warehouseAdd1Colheader']")
	private WebElement warehouseAddress1HeaderLocator;

	@FindBy(xpath = "//input[@id='documentUploadFormId:btnReset']")
	private WebElement AddnewDocumentResetButtonLocator;

	@FindBy(xpath = "//span[@id='errorImageNameForDoc']")
	private WebElement DocumentSuccessMsgLocator;

	@FindBy(xpath = "//span[@id='listDocFromId:panalDocId']/descendant::input[@type='checkbox' and contains(@id,'selectedURLId')]")
	private WebElement DocumentURLcheckboxLocator;

	@FindBy(xpath = "//input[@id='listDocFromId:mainDocRemoveAll']")
	private WebElement DocumentdeleteButtonLocator;

	@FindBy(xpath = "//input[@title='Edit Caption']")
	private WebElement EditAssignedDocumentLocator;

	@FindBy(xpath = "//input[@id='editCaptionFormID:editCaptionId']")
	private WebElement EditDocumentCapLocator;

	@FindBy(xpath = "//a[@id='lnkditmSrchIdf:goBtn']/i")
	private WebElement searchButtonForLinkedItems;

	@FindBy(xpath = "//input[@title='Update Caption']")
	private WebElement UpdateDocumentCapLocator;

	@FindBy(xpath = "//span[@id='editCaptionFormID:updateCaptionNameId']")
	private WebElement UpdateDocumentCapSuccessMsgLocator;

	@FindBy(xpath = "//img[@id='hideEditDoc']")
	private WebElement UpdateDocumentCapCancelLocator;

	@FindBy(xpath = "//a[@id='documentUploadFormId:link']")
	private WebElement DocumentCatPopupLocator;

	@FindBy(xpath = "//input[contains(@title,'Save Items to Warehouse')]")
	private WebElement saveWarehouseToItems;

	@FindBy(xpath = "//span[@id='listProductForm:saveMessagef2IdFR']")
	private WebElement productAssignSucessfulMessageLocator;

	@FindBy(xpath = "//img[@id='hidelink']")
	private WebElement DocumentCatCloseLocator;

	@FindBy(xpath = "//input[contains(@id,'docCategoryName')]")
	private WebElement DocumentCatnameLocator;

	@FindBy(xpath = "//textarea[contains(@id,'docDesc')]")
	private WebElement DocumentCatdescriptionLocator;

	@FindBy(xpath = "//table[@id='categoryPanelContentTable']/descendant::input[contains(@title,'Save Category')]")
	private WebElement DocumentCatSaveLocator;

	@FindBy(xpath = "//span[contains(@id,'docatNamsg')]")
	private WebElement DocumentCatSaveErrorMsgLocator;

	@FindBy(xpath = "//span[@id='documentUploadFormId:captionMsgId']")
	private WebElement DocumentCaptionErrorMsgLocator;

	@FindBy(xpath = "//ul[@class='buttonList']/descendant::a[@title='Revision History Link']")
	private WebElement DocumentHistoryLocator;

	@FindBy(xpath = "//td[@id='VideoTab_lbl']")
	private WebElement VideosTablinkLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/descendant::b")
	private WebElement AssignedvideoLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/descendant::div[contains(text(),'Action')]")
	private WebElement AssignedActionLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/descendant::div[contains(text(),'Item Video Caption')]")
	private WebElement AssignedItemVideoLabelLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/descendant::div[contains(text(),'Item Video URL')]")
	private WebElement AssignedItemVideoURLLabelLocator;

	@FindBy(xpath = "//div[@class='tab-title']/descendant::b[contains(text(),'Video Library')]")
	private WebElement VideoLibraryLabelLocator;

	@FindBy(xpath = "//input[contains(@id,'vidInfoId:input')]")
	private WebElement VideoLibrarySearchFieldLocator;

	@FindBy(xpath = "//a[contains(@id,'vidInfoId:searchAtt')]")
	private WebElement VideoLibrarySearchButtonLocator;

	@FindBy(xpath = "//input[@id='addVideo']")
	private WebElement addNewVideoButtonLocator;

	@FindBy(xpath = "//input[@id='custPrtNumFormId:CPNFormId:hideCPN']")
	private WebElement closeCpnFieldsLocator;

	@FindBy(xpath = "//input[@id='keywordsFormId:keywordSaveBtn']")
	private WebElement saveKeywordsUpdateLocator;

	@FindBy(xpath = "//input[@id='videoFormId:vcaptionId']")
	private WebElement AddVideoCaptionFieldLocator;

	@FindBy(xpath = "//input[@id='videoFormId:vurlId']")
	private WebElement AddVideoURLFieldLocator;

	@FindBy(xpath = "//input[@title='Save URL']")
	private WebElement AddVideoSaveButtonLocator;

	@FindBy(xpath = "//input[@title='Add/Remove the items from warehouse']")
	private WebElement removeWarehouseToItems;

	@FindBy(xpath = "//img[contains(@src,'history.png')]")
	private WebElement warehouseItemsHistory;

	@FindBy(xpath = "//a[@id='itemCategoryFormId:sbmtBtn']/img[contains(@src,'save')]")
	private WebElement categorySaveLocator;

	@FindBy(xpath = "//table[@id='categoryPanelContentTable']/descendant::input[contains(@id,'docCategoryName')]")
	private WebElement itemDocumentCategoryNameLocator;

	@FindBy(xpath = "//input[@title='Reset']")
	private WebElement AddVideoResetButtonLocator;

	@FindBy(xpath = "//form[@id='videoFormId']/descendant::img[@title='Cancel']")
	private WebElement AddVideoClosebuttonLocator;

	@FindBy(xpath = "//span[@id='videoFormId:itemVideoSavemessage']")
	private WebElement VideomsgVerifyLocator;

	@FindBy(xpath = "//input[@id='listVideoFromId:mainVideoRemoveAll']")
	private WebElement DeleteAllVideoLocator;

	@FindBy(xpath = "//span[@id='deleteVidMsgId']")
	private WebElement DeleteVideoAlertMsgLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/span/table/tbody/tr/td[2]/div/input")
	private WebElement assignedVideoCheckboxLocator;

	@FindBy(xpath = "//form[@id = 'listVideoFromId']/span/table/tbody/tr/td[1]/div/input[2]")
	private WebElement assignedVideoDeleteButtonLocator;

	@FindBy(xpath = "//td[contains(text(),'Available Linked Items')]")
	private WebElement AvailableLinkedItemsLinkLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[1]/span")
	private WebElement AvailableLinkedItemsItemIdLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[2]/div/span")
	private WebElement AvailableLinkedItemsItemImageLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[3]/span")
	private WebElement AvailableLinkedItemsPartNumberLocator;

	@FindBy(xpath = "//span[@id='itemCategoryFormId:saveMsgId']")
	private WebElement itemCategorySaveMessageLoator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[4]/span")
	private WebElement AvailableLinkedItemsMPNLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[5]/span")
	private WebElement AvailableLinkedItemsItemStatusLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[6]/span")
	private WebElement AvailableLinkedItemsDisplayOnlineLocator;

	@FindBy(xpath = "//table[@id='listForm:assignedItemsTable3']/thead/tr[1]/th[7]/span")
	private WebElement AvailableLinkedItemsLinkeditemsQTYLocator;

	@FindBy(xpath = "//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[1]/div/span")
	private WebElement ListItemLinkTypesActionLabelLocator;
	@FindBy(xpath = "//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[2]/span")
	private WebElement ListItemLinkTypesSLLabelLocator;
	@FindBy(xpath = "//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[3]/div/span")
	private WebElement ListItemLinkTypesNameLabelLocator;
	@FindBy(xpath = "//table[@id='linkdtabsid:itemLinkTypeTableId']/thead/tr[1]/th[4]/div/span")
	private WebElement ListItemLinkTypesDescriptionLabelLocator;

	@FindBy(xpath = "//a[@title='Add New Item Link Type']")
	private WebElement AddNewLinkTypeLocator;

	@FindBy(xpath = "//td[@id='whTab_lbl']")
	private WebElement warehouseTabLocator;

	@FindAll(value = { @FindBy(xpath = "//thead[@class='rich-table-thead']/descendant::span") })
	private List<WebElement> customPriceTabHeaders;

	@FindBy(xpath = "//input[@id='addNewItemLinkTypeForm:lNameId']")
	private WebElement LinkTypeNameFieldLocator;

	@FindBy(xpath = "//textarea[@id='addNewItemLinkTypeForm:linkId']")
	private WebElement LinkTypeDescriptionFieldLocator;

	@FindBy(xpath = "//input[@title='Save New Item Link Type']")
	private WebElement saveLinkTypeLocator;

	@FindBy(xpath = "//td[@id='cfTab']/descendant::td[contains(text(),'Table')]")
	private WebElement customFieldTableDataTabLocator;

	@FindBy(xpath = "//td[@id='cfTab']/descendant::td[contains(text(),'Simple')]")
	private WebElement customFieldSimpleDataLocator;

	@FindBy(xpath = "//input[@id='addNewItemLinkTypeForm:btnReset']")
	private WebElement resetLinkTypeLocator;

	@FindBy(xpath = "//form[@id='addNewItemLinkTypeForm']/div[2]/img")
	private WebElement closeLinkTypeForm;

	@FindBy(xpath = "//div[@id='warehouseListFormId:warehouseDataTable:warehouseNameColheader:sortDiv']")
	private WebElement warehouseNameHeaderLocator;

	@FindBy(xpath = "//span[@id='msg']")
	private WebElement linktypeSuccessMsg;

	@FindBy(xpath = "//span[@id='msg2']")
	private WebElement linktypeDeleteMsg;

	@FindAll(value = { @FindBy(xpath = "//tr[contains(@class,'rich-table-subheader')]/descendant::span") })
	private List<WebElement> attributesHeadersTextLocator;

	@FindBy(xpath = "//span[@id='hereFormId:deleteMessage']")
	private WebElement successFulMessageForRemoveLinkedItem;

	@FindBy(xpath = "//span[contains(text(),'Test_New_link1')]/ancestor::td/preceding-sibling::td/descendant::input[@title='Remove']")
	private WebElement deleteButtonLinkType;

	@FindBy(xpath = "//input[@id='custPrtNumFormId:CPNFormId:buyingCompanyId']")
	private WebElement customerInputLocator;

	@FindBy(xpath = "//input[@id='custPrtNumFormId:CPNFormId:addNewcstPnumId']")
	private WebElement addcustomerFieldLocator;

	@FindBy(xpath = "//span[contains(text(),'Test_New_link1')]/ancestor::td/preceding-sibling::td/descendant::input[@title='Edit Item Link Type']")
	private WebElement linkTypeEditbutton;

	@FindBy(xpath = "//input[@title='Save Assigned Linked Items']")
	private WebElement saveAssignedLinkedListIcon;

	@FindBy(xpath = "//input[@id='EditItemLinkTypeForm:lNameId']")
	private WebElement EditFormlinktypeNameLocator;

	@FindBy(xpath = "//textarea[@id='EditItemLinkTypeForm:linkDesc']")
	private WebElement EditFormlinktypeDescLocator;

	@FindBy(xpath = "//input[@title='Update']")
	private WebElement EditFormlinktypeSaveLocator;

	@FindAll(value = {
			@FindBy(xpath = "//tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::input[contains(@id,'itemInwhse')]") })
	private List<WebElement> multipleWarehousesCheckBoxes;

	@FindBy(xpath = "//input[@id='atf:attTableId:searchIT']")
	private WebElement attributeSearchInputField;

	@FindBy(xpath = "//input[@id='EditItemLinkTypeForm:btnReset']")
	private WebElement EditFormlinktypeResetLocator;

	@FindBy(xpath = "//form[@id='EditItemLinkTypeForm']/div[2]/img")
	private WebElement EditFormlinktypeCloseLocator;

	@FindBy(xpath = "//tbody[@id='itemCategoryFormId:categoryListTableId:tb']/tr")
	private WebElement categoryUnderCategorizationTab;

	@FindBy(id = "CPsaveMsgId")
	private WebElement subsetassigntoitemmessageloc;

	@FindBy(xpath = "//input[@id='taxonomyListId:taxonomyListComboIdcomboboxField']")
	private WebElement taxonomySearchFieldLocator;

	// form[@id='EditItemLinkTypeForm']/div[2]/img

	@FindBy(xpath = "//div[@id='attributePanelIdContentDiv']/descendant::img[@class='hidelink']")
	private WebElement cancelButtonInAlertWindow;

	@FindBy(xpath = "//input[@id='itemLinkTypeSelectedFormId:linkedItemsComboIdcomboboxField']")
	private WebElement selectLinkedItemTypeFieldLocator;

	// form[@id='EditItemLinkTypeForm']/div[2]/img

	@FindBy(xpath = "//td[@id='CPTab_lbl']")
	private WebElement customPricesLink;

	@FindBy(xpath = "//td[@id='AttrTab_lbl']")
	private WebElement attributesLink;

	@FindBy(xpath = "//a[@id='atf:attTableId:goBtn']/i")
	private WebElement searchButtonForAttributeList;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[4]/div/input")
	private WebElement OverPriceCheckboxLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[5]/div/input")
	private WebElement featuredProductCheckboxLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[6]/div/input")
	private WebElement displayPricingCheckboxLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[7]/div/input")
	private WebElement addTocartCheckboxLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[8]/div/div/input")
	private WebElement clearanceItemLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[9]/div/input")
	private WebElement imapIdItemLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[10]/input")
	private WebElement imapPriceTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[12]/input")
	private WebElement netPriceTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[13]/input")
	private WebElement PackDescTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[14]/input")
	private WebElement SSalesUOMTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[15]/input")
	private WebElement PricePerTextfieldLocator;

	@FindBy(xpath = "//table[@id='categoryPanelContentTable']/descendant::textarea[contains(@id,'docDesc')]")
	private WebElement itemdocumentCategoryDescription;

	@FindAll(value = { @FindBy(xpath = "//span[@id='productDetailsFormId:prodDetailsId']/descendant::b") })
	private List<WebElement> productFielsLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[16]/input")
	private WebElement MinOrderQTYTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[17]/input")
	private WebElement OrderQtyntervalTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[18]/input")
	private WebElement materialGroupTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[19]/input")
	private WebElement materialNumberTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[20]/input")
	private WebElement unspscTextfieldLocator;

	@FindBy(xpath = "//div[@class='Item-Drag-Drop-Wrap']/descendant::span[@id='hereFormId:sm2']")
	private WebElement saveAssignedSuccessMessageLocator;

	@FindBy(xpath = "//span[@id='errorImageNameForDoc']")
	private WebElement removeDocumentSuccessMessageLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[21]/input")
	private WebElement CustomerPNTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[22]/input")
	private WebElement CustomerPartNumberWPrefixTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[23]/input")
	private WebElement DescTextfieldLocator;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[3]/select/option[@value='A']")
	private WebElement ItemstatusCP;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[1]/input")
	private WebElement AddItemToSubset;

	@FindBy(id = "DescTab_lbl")
	private WebElement descriptionTab;

	@FindBy(id = "longDescEditor")
	private WebElement longDescription;

	@FindBy(id = "longDesc2Editor")
	private WebElement longDescription2;

	@FindBy(xpath = "//select[@id='atf:taxonomyListSelectOneId']/option")
	private WebElement selectedTaxonomyDropdownLocator;

	@FindBy(xpath = "//a[@title='Save']")
	private WebElement saveDescription;

	@FindBy(id = "ImgTab_lbl")
	private WebElement imagesTab;

	@FindBy(xpath = "//input[@title='Add New Item Image ']")
	private WebElement addNewImageButton;

	@FindBy(id = "imageUploadFormId:itemImageInput1")
	private WebElement enterImageURL;

	@FindBy(xpath = "//input[@id='imageUploadFormId:captionId']")
	private WebElement imageCaption;

	@FindAll(value = { @FindBy(xpath = "//tr[contains(@class,'rich-table-subheader')]/descendant::span") })
	private List<WebElement> listItemLinkTypeHeaderFields;

	@FindBy(xpath = "//input[@title='Save URL']")
	private WebElement saveImageURL;

	@FindBy(id = "DocTab_lbl")
	private WebElement documentsTab;

	@FindBy(xpath = "//input[@id='addDocumentId']") // or @title='Add New Item
													// Document'
	private WebElement addNewDocumentButton;

	@FindBy(xpath = "//span[@id='keywordsFormId:saveMessageId']")
	private WebElement succesMessageForKeywordUpdate;

	@FindBy(xpath = "//input[@id='documentUploadFormId:captionId' and @type='text']")
	private WebElement documentCaption;

	@FindBy(xpath = "//td[@id='cfTab_lbl']")
	private WebElement customFieldsTab;

	@FindBy(xpath = "//td/descendant::div[@id='documentUploadFormId:itemDocumentUploadId:add1']")
	private WebElement addDocumentButton;

	@FindAll(value = { @FindBy(xpath = "//form[@id='listForm']/descendant::span") })
	private List<WebElement> availableLinkedItemsHeaderFields;

	@FindBy(xpath = "//td/descendant::div[@id='documentUploadFormId:itemDocumentUploadId:upload1']")
	private WebElement uploadDocumentButton;

	@FindBy(xpath = "//input[@title='Assign']")
	private WebElement assignDocument;

	@FindBy(xpath = "//div[@id='longDescEditor']/*[string-length(//div[@id='longDescEditor']) > 1]")
	private WebElement longDescription_SubFilter;

	@FindBy(xpath = "//div[@id='longDescEditor']/*[string-length(//div[@id='longDescEditor']) = 0]")
	private WebElement noLongDescription_SubFilter;

	@FindBy(xpath = "//div[@id='longDescEditor']/*[string-length(//div[@id='longDescEditor']) = 0 or 1]")
	private WebElement ignoreLongDescription_SubFilter;

	@FindBy(xpath = "//input[@id=('itemNavigateForm:nextItemIcon')]")
	private WebElement clickOnNextItem_EditPage;

	/*
	 * @Step("click on categorization tab") public EditItemsPageObjects
	 * clickOnCategorizationTab() {
	 * 
	 * waiting.explicitWaitVisibilityOfElement(categorizationTabLocator, 14);
	 * ======= Waiting.explicitWaitVisibilityOfElement(categorizationTabLocator,
	 * 14); >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74
	 * categorizationTabLocator.click(); return this; }
	 */
	@FindBy(xpath = "//input[@id='custPrtNumFormId:CPNFormId:savecstPnumId']")
	private WebElement saveNewCpnLocator;

	@FindBy(xpath = "//input[@title='Reset']")
	private WebElement resetCpnFieldsLocator;

	/*
	 * @Step("click on categorization tab") public EditItemsPageObjects
	 * clickOnCategorizationTab() {
	 * 
	 * waiting.explicitWaitVisibilityOfElement(categorizationTabLocator, 14);
	 * ======= Waiting.explicitWaitVisibilityOfElement(categorizationTabLocator,
	 * 14); >>>>>>> 5156c7bcecaa5c6359b3f6773425cda6ccfadb74
	 * categorizationTabLocator.click(); return this; }
	 */

	@Step("verify whether the product has the category {0}")
	public EditItemsPageObjects verifyWhetherTheProductBelongsToTheCategory(String categoryToSearch) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Assert.assertTrue(getDriver()
				.findElement(By.xpath("//table[@id='tabs']/descendant::span[text()='" + categoryToSearch + "']"))
				.isDisplayed(), "The item does not belong to the category that was filtered.");
		return this;
	}

	@Step("click on results link.")
	public EditItemsPageObjects clickOnResultsLink() {

		waiting.explicitWaitVisibilityOfElement(resultsLinkLocator, 6);
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

		waiting.explicitWaitVisibilityOfElement(itemLinkLocator, 20);
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

		waiting.explicitWaitVisibilityOfElement(cimmItemIdValueLocator, 20);
		Assert.assertTrue(assertEditItemsCimmItemIdValue(cimmItemIdValueLocator.getText().trim(), itemId));
		waiting.explicitWaitVisibilityOfElement(editItemsBreadcrumbLocator, 20);

		Assert.assertTrue(assertEditItemsBreadCrumb(editItemsBreadcrumbLocator.getText().trim(), getBreadCrump));
		return this;
	}

	@Step("click on linked items tab.")
	public EditItemsPageObjects clickOnLinkedItemsTab() {

		waiting.explicitWaitVisibilityOfElement(linkedItemsTabLocator, 40);

		linkedItemsTabLocator.click();
		return this;
	}

	@Step("verify tabs under Linked Items tab to be setUpLinkedItemsLocator,availableLinkedItemsLocator,listItemLinkTypesLocator.")
	public EditItemsPageObjects verifyTabsUnderLinkedItemsTab() {

		waiting.explicitWaitVisibilityOfElement(setUpLinkedItemsLocator, 50);
		Assert.assertTrue(setUpLinkedItemsLocator.getAttribute("class").contains("active"),
				"Setup Linked Items tab is by default not active.");
		Assert.assertTrue(availableLinkedItemsLocator.getAttribute("class").contains("inactive"),
				"Available linked items tab is by default active.");
		Assert.assertTrue(listItemLinkTypesLocator.getAttribute("class").contains("inactive"),
				"List Item Link Types tab is by default active.");
		return this;
	}

	@Step("verify tabs under Linked Items tab to be setUpLinkedItemsLocator,availableLinkedItemsLocator,listItemLinkTypesLocator.")

	public EditItemsPageObjects verifySetUpLinkedItemsTab(String[] getExepectedSearchInDropdownValues) {

		waiting.explicitWaitVisibilityOfElement(searchItemsForItemLinkTypeTabNameLocator, 40);
		Assert.assertTrue(searchItemsForItemLinkTypeTabNameLocator.isDisplayed(),
				"Search Items For LinkType tab name is not displayed.");
		Assert.assertTrue(searchItemLinkTypeSearchTextboxLocator.isDisplayed(),
				"Search Item For Link Type textbox is not displayed.");
		Assert.assertTrue(searchButtonLocator.isDisplayed(), "Search Item For Link Type textbox is not displayed.");
		for (int i = 0; i < searchInDropdownValuesLocator.size(); i++) {

			Assert.assertEquals(searchInDropdownValuesLocator.get(i).getText().trim(),
					getExepectedSearchInDropdownValues[i]);
		}
		Assert.assertTrue(manufacturerDropdownLocator.isDisplayed(), "manufacturer dropdown is not displayed.");
		Assert.assertTrue(brandDropdownLocator.isDisplayed(), "brand dropdown is not displayed.");
		Assert.assertTrue(itemLinkTypeDropdownLocator.isDisplayed(), "item link type dropdown is not displayed.");
		return this;
	}

	public EditItemsPageObjects clickOnHistoryLink() {

		waiting.explicitWaitVisibilityOfElement(historyLinkLocator, 10);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", historyLinkLocator);
		return this;
	}

	public boolean assertAlertMsg(String alertText) {
		waiting.explicitWaitForAlert(5);

		boolean t = tu.getAlertText().trim().equals(alertText.trim());
		tu.alertAccept();
		return t;
	}

	public EditItemsPageObjects verifyAlertMsg(String alertText) {
		Assert.assertTrue(assertAlertMsg(alertText));
		utility.switchToRecentWindow();
		return this;
	}

	@Step("click on keywords tab")
	public EditItemsPageObjects clickOnKeywordsTab() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(keyWordsTabLocator, 20);
		keyWordsTabLocator.click();
		Thread.sleep(2500);
		return this;
	}

	public EditItemsPageObjects enterMetaKeyword(String metaKeywordText) {
		// TODO Auto-generated method stub
		return this;
	}

	@Step("click on CPN tab")
	public EditItemsPageObjects clickonCpnTab() {
		waiting.explicitWaitVisibilityOfElement(cpnTabLocator, 40);
		cpnTabLocator.click();
		return this;

	}

	@Step("click on add button")
	public EditItemsPageObjects clickOnAddNewCpn() {

		waiting.explicitWaitVisibilityOfElement(addNewCpnLocator, 10);
		addNewCpnLocator.click();
		return this;

	}

	@Step("enter customer name")
	public EditItemsPageObjects enterNewCpn(String cpnTextEnter) {

		waiting.explicitWaitVisibilityOfElement(addNewCpnTextboxLocator, 3);
		addNewCpnTextboxLocator.sendKeys(cpnTextEnter);
		return this;

	}

	@Step("click on add new number")
	public EditItemsPageObjects clickOnAddNewNumber() {

		waiting.explicitWaitVisibilityOfElement(addNewNumber, 3);
		addNewNumber.click();
		return this;

	}

	@Step("enter new CPN")
	public EditItemsPageObjects enterNewNumber(String cpnNumberEnter) {

		waiting.explicitWaitVisibilityOfElement(enterNewNumberLocator, 5);
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

		waiting.explicitWaitVisibilityOfElement(cpnSuccessMessageLocator, 8);
		Assert.assertEquals(cpnSuccessMessageLocator.getText().trim(), "Customer Part Numbers Saved Successfully .");
		return this;

	}

	public EditItemsPageObjects VerifyPartnumber(String partNumberField) {

		waiting.explicitWaitVisibilityOfElement(addNewItemPage().enterPartNumberLocator, 10);
		Assert.assertEquals(addNewItemPage().enterPartNumberLocator.getAttribute("value"), partNumberField);
		return this;
	}

	public EditItemsPageObjects verifSaveResethistory() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemUpdateButtonLocator.isDisplayed(), "Save button is not displayed");
		Assert.assertTrue(resetButtonLocator.isDisplayed(), "reset button is not displayed");
		Assert.assertTrue(historyButtonLocator.isDisplayed(), "history button is not displayed");
		return this;
	}

	public EditItemsPageObjects verifyRightPanelItemFieds(String getmanufacturerPartNumber, String partNumberField,
			String getlistPrice, String getcostPrice, String getuserrating, String hits, String popularity)
			throws InterruptedException {

		String ele = "//table[@class='itemAttrValueDisplayTable']/descendant::td[contains(text(),'"
				+ getmanufacturerPartNumber + "')]";
		waiting.explicitWaitVisibilityOfElement(By.xpath(ele), 10);
		WebElement mpnLoc = getDriver()
				.findElement(By.xpath("//table[@class='itemAttrValueDisplayTable']/descendant::td[contains(text(),'"
						+ getmanufacturerPartNumber + "')]"));
		WebElement partNumberLoc = getDriver()
				.findElement(By.xpath("//table[@class='itemAttrValueDisplayTable']/descendant::td[contains(text(),'"
						+ partNumberField + "')]"));
		WebElement listpriceLoc = getDriver().findElement(By
				.xpath("//table[@class='itemAttrValueDisplayTable']/descendant::strong[contains(.,'List Price')]/ancestor::td/following-sibling::td[contains(text(),'"
						+ getlistPrice + "')]"));
		WebElement costPriceLoc = getDriver().findElement(By
				.xpath("//table[@class='itemAttrValueDisplayTable']/descendant::strong[contains(.,'Cost Price')]/ancestor::td/following-sibling::td[contains(text(),'"
						+ getcostPrice + "')]"));
		WebElement userRatingLoc = getDriver().findElement(By.xpath(
				"//table[@class='itemAttrValueDisplayTable']/descendant::strong[contains(.,'User Rating')]/ancestor::td/following-sibling::td/span"));
		WebElement hitsLoc = getDriver().findElement(By.xpath(
				"//table[@class='itemAttrValueDisplayTable']/descendant::strong[contains(.,'Hits')]/ancestor::td/following-sibling::td/span"));
		WebElement popularityLoc = getDriver().findElement(By.xpath(
				"//table[@class='itemAttrValueDisplayTable']/descendant::strong[contains(.,'Popularity')]/ancestor::td/following-sibling::td/span"));

		Assert.assertEquals(mpnLoc.getText().trim(), getmanufacturerPartNumber);
		Assert.assertEquals(partNumberLoc.getText().trim(), partNumberField);
		Assert.assertEquals(listpriceLoc.getText().trim(), getlistPrice);
		Assert.assertEquals(costPriceLoc.getText().trim(), getcostPrice);
		Assert.assertEquals(userRatingLoc.getText().trim(), getuserrating);
		Assert.assertEquals(hitsLoc.getText().trim(), hits);
		Assert.assertEquals(popularityLoc.getText().trim(), popularity);
		Assert.assertTrue(itemEditRightResultButtonLocator.isDisplayed(), "Result button is not displayed");
		Assert.assertTrue(itemEditRightItemButtonLocator.isDisplayed(), "item button is not displayed");
		Assert.assertTrue(itemEditRightSearchButtonLocator.isDisplayed(), "search icon button is not displayed");
		Assert.assertTrue(itemEditRightpreviousButtonLocator.isDisplayed(), "previous button is not displayed");
		Assert.assertTrue(itemEditRightnextButtonLocator.isDisplayed(), "next button is not displayed");
		return this;
	}

	public EditItemsPageObjects verificationBrandManufacturerdropdown() {
		Assert.assertTrue(manufacturerDropdownLocator.isDisplayed(), "manufacturer dropdown is not displayed.");
		Assert.assertTrue(brandDropdownLocator.isDisplayed(), "brand dropdown is not displayed.");
		return this;
	}

	public EditItemsPageObjects reenterPartnumber(String getupdatepartnumber) throws InterruptedException {
		Thread.sleep(2000);
		addNewItemPage().enterPartNumberLocator.clear();
		addNewItemPage().enterPartNumberLocator.sendKeys(getupdatepartnumber);
		return this;
	}

	public EditItemsPageObjects clickonUpdateItemButton() {
		waiting.explicitWaitElementToBeClickable(itemUpdateButtonLocator, 20);
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

		waiting.explicitWaitVisibilityOfElement(itemDescriptionLocator, 40);

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
		waiting.explicitWaitVisibilityOfElement(ItemshortDescriptionLocator, 20);
		ItemshortDescriptionLocator.click();
		Assert.assertTrue(ShortTinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		waiting.explicitWaitVisibilityOfElement(Itemlong1DescriptionLocator, 20);
		Itemlong1DescriptionLocator.click();
		Assert.assertTrue(long1TinyMCEeditorLocator.isDisplayed(), "TinyMCE editor is not displayed");
		waiting.explicitWaitVisibilityOfElement(Itemlong1DescriptionLocator, 20);
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

		switch (descOptions) {
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
		default:
			throw new Exception("invalid input");

		}
		return this;
	}

	public EditItemsPageObjects clickonSavedescriptionButton() {
		waiting.explicitWaitElementToBeClickable(ItemSaveDescriptionLocator, 40);
		ItemSaveDescriptionLocator.click();
		return this;
	}

	public EditItemsPageObjects verifyDacriptionUpdateMsg(String itemUpdateMSG) throws InterruptedException {
		Thread.sleep(3000);
		waiting.explicitWaitVisibilityOfElement(ItemSaveDescriptionMSGLocator, 40);
		Assert.assertEquals(ItemSaveDescriptionMSGLocator.getText().trim(), itemUpdateMSG);
		return this;
	}

	public EditItemsPageObjects clickOnProductsTabLink() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(productslinkLocator, 40);
		productslinkLocator.click();
		Thread.sleep(4000);
		return this;
	}

	public EditItemsPageObjects verifyFieldsProductsFields() {

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
		Assert.assertTrue(keywordautomgeneratedlinkLocator.isDisplayed(),
				"keywords auto generated label is not displayed");
		Assert.assertTrue(PartNumberKeywordslinkLocator.isDisplayed(),
				"part Number auto genrated keywords label is not displayed");
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
		MetaKeywordsTextboxLocator.clear();
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
		waiting.explicitWaitElementToBeClickable(KeywordsRevisionLocator, 20);
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
		Assert.assertTrue(DocumentindtructionLocator.isDisplayed(), "Document instruction is not displayed");
		Assert.assertTrue(DocumentcatdropdownLocator.isDisplayed(), "Document category drop down is not displayed");
		Assert.assertTrue(DocumentAddlinkLocator.isDisplayed(), "Add new document icon is not displayed");
		Assert.assertTrue(DocumentRevisionHistorylinkLocator.isDisplayed(), "Document history icon is not displayed");
		DocumentcatdropdownLocator.click();
		Thread.sleep(5000);
		return this;
	}

	@Step("Selecting document category from document category drop down in documents tab")
	public EditItemsPageObjects verifySelectingDocumentCategory(String getdocumentcategory)
			throws InterruptedException {
		Thread.sleep(3000);
		DocumentcatdropdownLocator.click();
		Thread.sleep(2000);
		for (WebElement catdropdown : documentCatDropdownLocator) {
			if (catdropdown.getText().trim().equals(getdocumentcategory)) {
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
		Assert.assertTrue(AddnewDocumentcatdropdownLocator.isDisplayed(),
				"Document category dropdown is not displayed");
		Assert.assertTrue(AddnewDocumentcatlinkLocator.isDisplayed(),
				"Add new document category link is not displayed ");
		Assert.assertTrue(AddnewDocumentcaptionLocator.isDisplayed(), "Document caption field is not displayed");
		Assert.assertTrue(AddnewDocumentURLLocator.isDisplayed(), "Document URL field is not displayed");
		Assert.assertTrue(AddnewDocumentuploadIconLocator.isDisplayed(), "Document upload button is not displayed");
		Assert.assertTrue(AddnewDocumentOverwritecheckLocator.isDisplayed(),
				"Document overwrite checkbox is not displayed");
		Assert.assertTrue(AddnewDocumentSaveButtonLocator.isDisplayed(), "Document save button is not displayed");
		Assert.assertTrue(AddnewDocumentResetButtonLocator.isDisplayed(), "Document reset button is not displayed");
		return this;
	}

	@Step("uploading an document using Document URL in documents tab ")
	public EditItemsPageObjects addNewDocumentURL(String documentCaption, String getdocumentURL) {
		waiting.explicitWaitVisibilityOfElement(AddnewDocumentcaptionLocator, 30);
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
	public PageFactoryInitializer removeAssignedDocument() throws InterruptedException {
		Thread.sleep(2500);
		try {
			if (DocumentURLcheckboxLocator.isDisplayed()) {
				waiting.explicitWaitVisibilityOfElement(DocumentURLcheckboxLocator, 40);
				DocumentURLcheckboxLocator.click();
				DocumentdeleteButtonLocator.click();
				tu.alertAccept();
				Thread.sleep(3000);
			}
			// Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(),
			// documentremoveMsg);
		} catch (NoSuchElementException e) {
			return this;
		}
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
	public EditItemsPageObjects verifySuccessMSgDocumentUpdate(String getupdateDocumentCaptionMsg)
			throws InterruptedException {
		Thread.sleep(2500);
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
		waiting.explicitWaitElementToBeClickable(DocumentCatSaveLocator, 30);
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
	public PageFactoryInitializer verifyDocumentCaption(String DocumentRequiredCaptionMsg, String documentCaption)
			throws InterruptedException {
		AddnewDocumentSaveButtonLocator.click();
		Thread.sleep(2000);
		Assert.assertEquals(DocumentCaptionErrorMsgLocator.getText().trim(), DocumentRequiredCaptionMsg);
		AddnewDocumentcaptionLocator.sendKeys(documentCaption);
		return this;
	}

	@Step("Verifying document URL field in add new document form")
	public PageFactoryInitializer verifyDocumentURL(String getdocumentCaption, String getDocumentRequiredURLMsg,
			String DocumentURL) throws InterruptedException {
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
		waiting.explicitWaitVisibilityOfElement(AssignedvideoLocator, 50);
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
		waiting.explicitWaitVisibilityOfElement(AddVideoCaptionFieldLocator, 50);
		AddVideoCaptionFieldLocator.sendKeys(getvideoCaption);
		AddVideoURLFieldLocator.sendKeys(getvideoURl);
		return this;
	}

	@Step("click on save button in add new video form")
	public EditItemsPageObjects clickOnSaveVideoButton() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(AddVideoSaveButtonLocator, 50);
		AddVideoSaveButtonLocator.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("Verify success message after addindg an video")
	public EditItemsPageObjects verifyAddVideoSaveMsg(String getvideoSaveMsg) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(VideomsgVerifyLocator, 50);
		Assert.assertEquals(VideomsgVerifyLocator.getText().trim(), getvideoSaveMsg);
		return this;
	}

	@Step("Click on delete button without selecting an video chekbox")
	public EditItemsPageObjects clickOnAllVideoDeleteButton() throws InterruptedException {
		DeleteAllVideoLocator.click();

		tu.alertDismiss();
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

		tu.alertAccept();
		return this;
	}

	@Step("Verifying success Message after removing an video")
	public EditItemsPageObjects VerifyVideoRemoveSuccessMsg(String videotRemoveMsg) {
		Assert.assertEquals(DeleteVideoAlertMsgLocator.getText().trim(), videotRemoveMsg);
		return this;
	}

	@Step("click on Available Linked Items link")
	public EditItemsPageObjects clickOnAvailableLinkedItems() {
		waiting.explicitWaitVisibilityOfElement(AvailableLinkedItemsLinkLocator, 50);
		AvailableLinkedItemsLinkLocator.click();
		return this;
	}

	@Step("Verify the content under Available Linked Items tab")
	public EditItemsPageObjects verifyContentunderAvailableLinkedItems(String availableLinkedItemsHeaders) {
		String expHeaders[] = availableLinkedItemsHeaders.split(",");
		waiting.explicitWaitVisibilityOfElements(availableLinkedItemsHeaderFields, 40);
		for (int i = 0; i < availableLinkedItemsHeaderFields.size(); i++) {
			// System.out.println(availableLinkedItemsHeaderFields.get(i).getText().trim());

			Assert.assertEquals(availableLinkedItemsHeaderFields.get(i).getText(), expHeaders[i],
					"expe :" + expHeaders[i] + " but found :" + availableLinkedItemsHeaderFields.get(i).getText() + "");
		}
		return this;
	}

	@Step("Verify the content under List Item Link Types tab")
	public EditItemsPageObjects clickOnListItemLinkTypes() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(listItemLinkTypesLocator, 50);
		listItemLinkTypesLocator.click();
		return this;
	}

	@Step("Verify the content under List Item Link Types tab")
	public EditItemsPageObjects verifyContentunderListItemLinkTypes() {
		Assert.assertTrue(ListItemLinkTypesActionLabelLocator.isDisplayed(), "Action label is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesSLLabelLocator.isDisplayed(), "Sl No label is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesNameLabelLocator.isDisplayed(), "Link Type Name is not diaplayed");
		Assert.assertTrue(ListItemLinkTypesDescriptionLabelLocator.isDisplayed(),
				"Link type description label is not diaplayed");
		Assert.assertTrue(AddNewLinkTypeLocator.isDisplayed(), "Add new link type button is not diaplayed");
		return this;
	}

	@Step("click on add new link type button")
	public EditItemsPageObjects clickonAddnewLinkTypeButton() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(AddNewLinkTypeLocator, 50);
		AddNewLinkTypeLocator.click();
		Thread.sleep(1500);
		return this;
	}

	@Step("Verify the content in add new link type form")
	public EditItemsPageObjects verifyContentAddNewLinkTypeForm() {
		Assert.assertTrue(LinkTypeNameFieldLocator.isDisplayed(), "Link type name text field is not diaplayed");
		Assert.assertTrue(LinkTypeDescriptionFieldLocator.isDisplayed(),
				"Link type description field is not diaplayed");
		Assert.assertTrue(saveLinkTypeLocator.isDisplayed(), "Save Link Type Button is not diaplayed");
		Assert.assertTrue(resetLinkTypeLocator.isDisplayed(), "Reset Link type Button is not diaplayed");
		Assert.assertTrue(closeLinkTypeForm.isDisplayed(), "Close add new link type form is not diaplayed");
		return this;
	}

	@Step("Adding new link type in list item link types")
	public EditItemsPageObjects savingNewlinkType(String getlinktypename, String getlinktypedescription)
			throws InterruptedException {
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

		tu.alertDismiss();
		Thread.sleep(2000);
		deleteButtonLinkType.click();
		tu.alertAccept();
		return this;
	}

	@Step("Verify delete link type message")
	public EditItemsPageObjects verifyLinkTypeDeleteSuccessMsg(String getlinktypename) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(linktypeDeleteMsg.getText().trim(),
				"ItemLinkType - : '" + getlinktypename + "' removed Successfully");
		return this;
	}

	@Step("clicking on edit link type form")
	public EditItemsPageObjects verificationEditingLinkTypeForm() {
		linkTypeEditbutton.click();

		return this;
	}

	@Step("verifying and updateing created link type")
	public EditItemsPageObjects updatelinktype(String getlinktypeupdatedescription, String getlinktypeupdatemsg)
			throws InterruptedException {
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
	public EditItemsPageObjects clickOnCustomPricesTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customPricesLink, 70);
		customPricesLink.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("click on Attributes link")
	public EditItemsPageObjects clickOnAttributesTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(attributesLink, 50);
		waiting.explicitWaitVisibilityOfElement(attributesLink, 40);
		attributesLink.click();
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
		Assert.assertTrue(imapPriceTextfieldLocator.isDisplayed(), "Imap price text field is not diaplayed");
		Assert.assertTrue(netPriceTextfieldLocator.isDisplayed(), "net price text field is not diaplayed");
		Assert.assertTrue(PackDescTextfieldLocator.isDisplayed(), "pack description text field is not diaplayed");
		Assert.assertTrue(SSalesUOMTextfieldLocator.isDisplayed(), "Sales UOM text field is not diaplayed");
		Assert.assertTrue(PricePerTextfieldLocator.isDisplayed(), "price per text field is not diaplayed");
		Assert.assertTrue(MinOrderQTYTextfieldLocator.isDisplayed(), "min order qty text field is not diaplayed");
		Assert.assertTrue(OrderQtyntervalTextfieldLocator.isDisplayed(), "Qty interval text field is not diaplayed");
		Assert.assertTrue(materialGroupTextfieldLocator.isDisplayed(), "material group text field is not diaplayed");
		Assert.assertTrue(materialNumberTextfieldLocator.isDisplayed(), "material number text field is not diaplayed");
		Assert.assertTrue(unspscTextfieldLocator.isDisplayed(), "Unspc text field is not diaplayed");
		Assert.assertTrue(CustomerPNTextfieldLocator.isDisplayed(), "Customer Part number text field is not diaplayed");
		Assert.assertTrue(CustomerPartNumberWPrefixTextfieldLocator.isDisplayed(),
				"Customer part number w prefix text field is not diaplayed");
		Assert.assertTrue(DescTextfieldLocator.isDisplayed(), "Description text field is not diaplayed");
		return this;
	}

	@Step("checking and unchecking overprice item checkbox")
	public EditItemsPageObjects CheckuncheckOverpricecheckbox() throws InterruptedException {
		OverPriceCheckboxLocator.click();
		Thread.sleep(2000);
		OverPriceCheckboxLocator.click();
		return this;
	}

	@Step("checking and unchecking IFP item checkbox")
	public EditItemsPageObjects CheckuncheckIFPcheckbox() {
		featuredProductCheckboxLocator.click();
		// Thread.sleep(2000);
		featuredProductCheckboxLocator.click();
		return this;
	}

	@Step("Enter the data to net price field")
	public EditItemsPageObjects EnterNetPrice(String itemNetPrice) {
		netPriceTextfieldLocator.sendKeys(itemNetPrice);
		return this;
	}

	@Step("Enter the data to package description field")
	public EditItemsPageObjects EnterpackageDescription(String getitemPackDesc) {
		PackDescTextfieldLocator.sendKeys(getitemPackDesc);
		return this;
	}

	@Step("Enter the data to sales UOM field")
	public EditItemsPageObjects EnterItemUOM(String getitemUom) {
		SSalesUOMTextfieldLocator.sendKeys(getitemUom);
		return this;
	}

	@Step("Enter the data to sales UOM field")
	public EditItemsPageObjects EnterPricePer(String pricePer) {
		PricePerTextfieldLocator.sendKeys(pricePer);
		return this;
	}

	@Step("Enter the data in min order qty field")
	public EditItemsPageObjects EnterMinorderQTY(String getminorderQty) {
		MinOrderQTYTextfieldLocator.sendKeys(getminorderQty);
		return this;
	}

	@Step("Enter the data to qty interval field")
	public EditItemsPageObjects EnterQtyInteral(String qtyinterval) {
		OrderQtyntervalTextfieldLocator.sendKeys(qtyinterval);
		return this;
	}

	@Step("Enter the CPN to CPN field")
	public EditItemsPageObjects EnterCPN(String cpn) {
		CustomerPNTextfieldLocator.sendKeys(cpn);
		return this;
	}

	@Step("Enter data to material group field")
	public EditItemsPageObjects EnterMaterialGroup(String getMaterialGroup) {
		materialGroupTextfieldLocator.sendKeys(getMaterialGroup);
		return this;
	}

	@Step("Enter data to material number field")
	public EditItemsPageObjects EnterMaterialNumber(String materialNumber) {
		materialNumberTextfieldLocator.sendKeys(materialNumber);
		return this;
	}

	@Step("Enter data to Unspsc field")
	public EditItemsPageObjects EnterUnspsc(String unspsc) {
		unspscTextfieldLocator.sendKeys(unspsc);
		return this;
	}

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[10]/input")
	private WebElement IMAPPriceTextFieldLocator;
	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[12]/input")
	private WebElement NetPriceTextFieldLocator;

	@FindBy(xpath = "(//input[@alt='Assign'])[1]")
	private WebElement assignItemLocator;

	@FindBy(xpath = "//table[@id='attributePanelIdContentTable']/tbody/tr[2]/td/form/table/tbody/tr[3]/td/div/input[1]")
	private WebElement assignItemAttributeLocator;

	@FindBy(xpath = "//input[@id='atf:atdt:0:colAVD']")
	private WebElement AttributeValueLocator;

	@FindBy(xpath = "//input[@id='atf:atdt:0:colUOMD']")
	private WebElement AttributeUOMLocator;

	@FindBy(xpath = "//input[@id='atf:atdt:0:colVGD']")
	private WebElement AttributeValueGroupLocator;

	@FindBy(xpath = "//input[@id='atf:savBtnId']")
	private WebElement attributevaluesavelocator;

	@FindBy(xpath = "//span[@id='atf:saveMsgIdAT']")
	private WebElement attributevaluesaveMsglocator;

	@Step("Verifying attribute fields in attribute tab")
	public EditItemsPageObjects verifyAttributesTabFileds(String attributeHeaders, String taxonomyName)
			throws InterruptedException {

		String expFields[] = attributeHeaders.split(",");
		waiting.explicitWaitVisibilityOfElements(attributesHeadersTextLocator, 50);
		Assert.assertTrue(attributeSearchInputField.isDisplayed(), "attribute list Search field is not available");
		Assert.assertEquals(selectedTaxonomyDropdownLocator.getAttribute("value"), taxonomyName);
		for (int i = 0; i < attributesHeadersTextLocator.size(); i++) {

			Assert.assertEquals(attributesHeadersTextLocator.get(i).getText().trim(), expFields[i]);

		}
		return this;
	}

	@Step("Entering value to assigned attribute")
	public EditItemsPageObjects AddingValueToAttributes(String attributeValue, String getattributeUOM,
			String getattributegroup) throws InterruptedException {
		AttributeValueLocator.sendKeys(attributeValue);
		AttributeUOMLocator.sendKeys(getattributeUOM);
		AttributeValueGroupLocator.sendKeys(getattributegroup);
		attributevaluesavelocator.click();
		Thread.sleep(2000);
		return this;
	}

	public EditItemsPageObjects VerifyAttributeValueMsg(String getattributesaveMsg) {
		Assert.assertEquals(attributevaluesaveMsglocator.getText().trim(), getattributesaveMsg);
		return this;
	}

	@Step("selecting item status")
	public EditItemsPageObjects selectingItemStatus(String itemStatus, String subsetName) throws InterruptedException {
		Thread.sleep(2500);
		WebElement sel = getDriver().findElement(By.xpath("//span[contains(text(),'" + subsetName
				+ "')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::select[contains(@id,'status')]"));
		Select select = new Select(sel);
		select.selectByVisibleText(itemStatus);
		WebElement option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), itemStatus);

		// select.selectByVisibleText(itemStatus);

		return this;
	}

	@Step("click on add item to subset")
	public EditItemsPageObjects ClickonAddsubsetItem() {
		AddItemToSubset.click();
		return this;
	}

	@FindBy(xpath = "//span[@id='CPsaveMsgId']")
	private WebElement custompricessuccessmsgx;

	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[1]/input[1]")
	private WebElement saveMsgbuttonLocator;
	@FindBy(xpath = "//table[@id='customPricesForm:customPricesTable']/tbody/tr[1]/td[1]/input[2]")
	private WebElement DeleteButtonCFLocator;

	@Step("Verifying the subset after click on dave button")
	public EditItemsPageObjects verifysucessmsg() {
		Assert.assertTrue(custompricessuccessmsgx.getText().trim().contains("Item added to Subset"),
				"item is not added successfully to the subset");
		return this;
	}

	@Step("Verifying add and delete buttons in custom prices tab")
	public EditItemsPageObjects verifyaddandDeleteIcons() {
		Assert.assertTrue(saveMsgbuttonLocator.isDisplayed(), "Save button is not diaplayed");
		Assert.assertTrue(DeleteButtonCFLocator.isDisplayed(), "Reset button is not diaplayed");
		return this;
	}

	@Step("click on item save button in custom prices tab")
	public EditItemsPageObjects clickonSaveButtonCustomPrices() throws InterruptedException {
		saveMsgbuttonLocator.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("Verifying item update success message in custom prices tab")
	public EditItemsPageObjects VerifyUpdateitemSuccessMsg(String successMessage) {
		waiting.explicitWaitVisibilityOfElement(custompricessuccessmsgx, 20);
		Assert.assertEquals(custompricessuccessmsgx.getText().trim(), successMessage);
		Assert.assertTrue(custompricessuccessmsgx.getText().trim().contains(" Item Updated Successfully"),
				"item is not updated successfully to the subset");
		return this;
	}

	@Step("Verifying item update success message in custom prices tab")
	public EditItemsPageObjects deleteItemFromSubset() {
		DeleteButtonCFLocator.click();

		tu.alertAccept();

		return this;
	}

	@FindBy(xpath = "//img[@src='/CIMM2Touch/images/small/history.png']")
	private WebElement CustomPricesHistoryLocator;

	@Step("click on history in custom prices tab")
	public EditItemsPageObjects clickOnCPhistoryLink() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(CustomPricesHistoryLocator, 10);
		CustomPricesHistoryLocator.click();
		Thread.sleep(2000);
		return this;
	}

	@Step("To Edit the Long Description in the Descriptions Tab")
	public EditItemsPageObjects editLongDescription(String longdesc)

	{
		waiting.explicitWaitVisibilityOfElement(longDescription, 10);
		longDescription.clear();
		longDescription.sendKeys(longdesc);
		return this;
	}

	@Step("To Edit the Long Description2 in the Descriptions Tab")
	public EditItemsPageObjects editLongDescription2(String longdesc) {
		longDescription2.clear();
		longDescription2.sendKeys(longdesc);
		return this;
	}

	@Step("To Save the Descriptions in the Edit Items Page")
	public EditItemsPageObjects saveDescription() {
		saveDescription.click();
		return this;
	}

	@Step("To Click On Images Tab")
	public EditItemsPageObjects clickOnImagesTab() {

		waiting.explicitWaitVisibilityOfElement(imagesTab, 15);
		imagesTab.click();
		return this;
	}

	@Step("To Click on 'Add New Image' Button in the Images Tab")
	public EditItemsPageObjects clickOnAddNewImageButton() throws Exception {

		waiting.explicitWaitVisibilityOfElement(addNewImageButton, 15);
		addNewImageButton.click();
		return this;
	}

	@Step("To Enter the URL of the Image in the Image Tab")
	public EditItemsPageObjects enterImageURL(String imageURL) {

		waiting.explicitWaitVisibilityOfElement(enterImageURL, 15);
		enterImageURL.sendKeys(imageURL);
		return this;
	}

	@Step("To Click on 'Save Image URL' ")
	public EditItemsPageObjects clickSaveImageURL() throws Exception {

		waiting.explicitWaitVisibilityOfElement(saveImageURL, 15);
		saveImageURL.click();

		return this;
	}

	@Step("To Enter the 'Image Caption' in the Images Tab")
	public EditItemsPageObjects enterImageCaption() {

		waiting.explicitWaitVisibilityOfElement(imageCaption, 15);
		imageCaption.clear();
		imageCaption.sendKeys("Image Caption");
		return this;
	}

	@Step("To Click on 'Documents' Tab")
	public EditItemsPageObjects clickOnDocumentsTab() throws Exception {
		waiting.explicitWaitVisibilityOfElement(documentsTab, 40);
		documentsTab.click();
		Thread.sleep(5000);
		return this;
	}

	@Step("To Click on 'Add New Document Button' in 'Documents' Tab")
	public EditItemsPageObjects clickOnAddNewDocumentButton() {
		waiting.explicitWaitElementToBeClickable(addNewDocumentButton, 30);
		addNewDocumentButton.click();
		return this;
	}

	@Step("To Enter the 'Document Caption' in 'Documents' Tab")
	public EditItemsPageObjects enterDocumentCaption(String docCaption) {

		waiting.explicitWaitVisibilityOfElement(documentCaption, 50);
		documentCaption.sendKeys(docCaption);
		return this;
	}

	@Step("To Upload a Document from Specified Location in 'Documents' Tab")
	@SuppressWarnings("static-access")
	public EditItemsPageObjects UploadDocument(String fileToUpload) throws Exception {

		waiting.explicitWaitVisibilityOfElement(addDocumentButton, 30);
		addDocumentButton.click();
		tu.fileUpload(fileToUpload);
		return this;
	}

	@Step("To Assign a Document")
	public EditItemsPageObjects assignDocument() throws Exception {
		Thread.sleep(3000);
		assignDocument.click();
		return this;

	}

	@Step("To Verify the Long Descriptions in the 'Descriptions' Tab")
	@SuppressWarnings("static-access")
	public EditItemsPageObjects verifyLongDescription() throws Exception {
		Thread.sleep(2000);

		utility.assertElementPresent(longDescription_SubFilter);
		return this;
	}

	@Step("To Verify that the Long Descriptions is not present in the 'Descriptions' Tab")
	public EditItemsPageObjects verifyLongDescription(String longDescription) throws Exception {

		Thread.sleep(2500);
		switch (longDescription) {

		case "LongDesc":
			utility.assertElementPresent(longDescription_SubFilter);
			break;

		case "No LongDesc":
			utility.assertElementPresent(noLongDescription_SubFilter);
			break;

		case "Ignore":
			Assert.assertTrue(utility.assertElementPresent(longDescription_SubFilter)
					|| utility.assertElementPresent(noLongDescription_SubFilter));
			break;

		default:
			throw new Exception("invalid selection");

		}
		return this;
	}

	/*
	 * Assert.assertEquals(((JavascriptExecutor) getDriver()).executeScript(
	 * "return $x('boolean(//div[@id=\"longDescEditor\"]/*[string-length(//div[@id=\"longDescEditor\"]) > 0])');"
	 * ),true,"remember me checkbox is not checked"); ======= /*
	 * Assert.assertEquals(((JavascriptExecutor) driver).executeScript(
	 * "return $x('boolean(//div[@id=\"longDescEditor\"]/*[string-length(//div[@id=\"longDescEditor\"]) > 0])');"
	 * ),true,"remember me checkbox is not checked"); >>>>>>>
	 * 5156c7bcecaa5c6359b3f6773425cda6ccfadb74 Thread.sleep(2000);
	 * tu.assertElementPresent(noLongDescription_SubFilter); return this; }
	 */

	@Step("To Verify after ignoring Long Descriptions 'Descriptions' Tab")
	@SuppressWarnings("static-access")
	public EditItemsPageObjects verifyIgnorelongDescPartNumbers() throws Exception {
		Thread.sleep(2000);

		utility.assertElementPresent(longDescription);
		return this;

	}

	@Step("verificaton of Attributes dropdown {0} ")
	public EditItemsPageObjects verifyAttributesSection(String attributeValue, String expMsgForNoAttribute)
			throws Exception {

		Thread.sleep(2500);
		switch (attributeValue) {

		case "Attributes":

			Thread.sleep(2000);
			utility.assertElementPresent(
					getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and @value]")));
			break;

		case "No Attributes":
			Thread.sleep(2000);
			Assert.assertTrue(utility
					.assertElementPresent(getDriver()
							.findElement(By.xpath("//span[contains(text(),'" + expMsgForNoAttribute + "')]")))
					|| utility.assertElementPresent(
							getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and not (@value)])"))));
			break;

		case "Ignore":
			Thread.sleep(2000);
			Assert.assertTrue(utility.assertElementPresent(
					getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and @value]")))
					|| utility.assertElementPresent(getDriver()
							.findElement(By.xpath("//span[contains(text(),'" + expMsgForNoAttribute + "')]"))));

			break;

		default:
			throw new Exception("invalid selection");

		}
		return this;
	}

	@Step("verification of Attributes dropdown - Attributes ")
	public boolean verifyadvse030() throws Exception {
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;

		int var = 5;
		for (int i = 0; i <= var; i++) {

			try {

				bool1 = utility.assertElementPresent(
						getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and @value]")));
			} catch (Exception e) {
				bool1 = false;
			}

			try {

				bool2 = utility.assertElementPresent(getDriver()
						.findElement(By.xpath("//span/table/tbody/tr/td/table/tbody/tr[*]/td[5]/input[@value])")));
			}

			catch (Exception e) {
				bool2 = false;
			}

			try {

				bool3 = utility.assertElementPresent(getDriver()
						.findElement(By.xpath("//span/table/tbody/tr/td/table/tbody/tr[*]/td[6]/input[@value])")));
			}

			catch (Exception e) {
				bool3 = false;
			}

			if (bool1 || bool2 || bool3 == true) {
				return true;
			}
			clickOnNextItem_EditPage.click();
			clickOnAttributesTab();

		}
		return false;
	}

	@Step("verification of Attributes dropdown - No Attributes ")
	public boolean verifyadvse031() throws Exception {
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;

		int var = 5;
		for (int i = 0; i <= var; i++) {

			try {

				bool1 = utility.assertElementPresent(getDriver()
						.findElement(By.xpath("//span/table/tbody/tr/td/table/tbody/tr[*]/td[4]/input[@value])")));
			} catch (Exception e) {
				bool1 = false;
			}

			try {

				bool2 = utility.assertElementPresent(getDriver()
						.findElement(By.xpath("//span/table/tbody/tr/td/table/tbody/tr[*]/td[5]/input[@value])")));
			}

			catch (Exception e) {
				bool2 = false;
			}

			try {

				bool3 = utility.assertElementPresent(getDriver()
						.findElement(By.xpath("//span/table/tbody/tr/td/table/tbody/tr[*]/td[6]/input[@value])")));

			}

			catch (Exception e) {
				bool3 = false;
			}

			if (bool1 && bool2 && bool3 == false) {
				return true;
			}
			clickOnNextItem_EditPage.click();
			clickOnAttributesTab();
		}
		return false;
	}

	@Step("click on categorization tab")
	public EditItemsPageObjects clickOnCategorizationTab() throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(categorizationTabLocator, 50);
		categorizationTabLocator.click();
		Thread.sleep(5000);
		return this;
	}

	@Step("verification of Categorized dropdown - Categorized ")
	public EditItemsPageObjects verifyadvsearchResultsForCategory(String categoryStatus, String noOfItemToBeVerify)
			throws Exception {
		Thread.sleep(2000);
		int var = Integer.parseInt(noOfItemToBeVerify);
		for (int i = 0; i < var; i++)

		{
			clickOnCategorizationTab();
			Thread.sleep(2000);

			switch (categoryStatus) {
			case "Categorized":

				Assert.assertTrue(assertCategorized(), "Shown items are uncategorized.");
				break;
			case "UnCategorized":

				Assert.assertFalse(assertCategorized(), "Shown items are Categorized.");
				break;

			case "Ignore":
				Thread.sleep(2500);
				waiting.explicitWaitVisibilityOfElement(categoryUnderCategorizationTab, 40);
				Assert.assertTrue(utility.assertElementPresent(categoryUnderCategorizationTab)
						|| utility.assertElementnotPresent(categoryUnderCategorizationTab));

				break;
			default:
				throw new Exception("invalid Category selection selection");
			}

			waiting.explicitWaitVisibilityOfElement(nextItemIconLocator, 50);
			nextItemIconLocator.click();
			Thread.sleep(2000);

		}
		return this;
	}

	private boolean assertCategorized() throws InterruptedException {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (categoryUnderCategorizationTab.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}

		return false;

	}

	@Step("verification of categorized dropdown ")
	public EditItemsPageObjects verifyadvse043() throws InterruptedException {
		int var = 5;
		for (int i = 0; i <= var; i++) {
			// String
			// count="count(//table[@id='searchFormId:itemListTableId']/thead/tr/th/div/span/span[text()='Display
			// Online']/../../../preceding-sibling::*)+1";
			String xpath = "//table[@id='itemCategoryFormId:categoryListTableId']/tbody[not(tr)]";

			Assert.assertFalse(getDriver().findElement(By.xpath(xpath)).isDisplayed());
		}
		clickOnNextItem_EditPage.click();
		clickOnCategorizationTab();

		return this;
	}

	@Step("verification of item attribute {0} and image status")
	public EditItemsPageObjects verifyItemAttributeAndImage(String operator) throws Exception {
		Thread.sleep(2500);
		switch (operator) {

		case "AND":
			Thread.sleep(3000);
			Assert.assertTrue(utility.assertElementPresent(
					getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and @value]")))
					&& utility.assertElementPresent(
							getDriver().findElement(By.xpath("//div[@class='imageHolder']/descendant::img"))));
			break;

		case "OR":
			Thread.sleep(3000);
			Assert.assertTrue(utility.assertElementPresent(
					getDriver().findElement(By.xpath("//input[contains(@id,':colAVD') and @value]")))
					|| utility.assertElementPresent(
							getDriver().findElement(By.xpath("//div[@class='imageHolder']/descendant::img"))));

			break;

		default:
			throw new Exception("invalid selection");

		}
		return this;
	}

	@Step("search for taxonomy {0}")
	public EditItemsPageObjects searchForTaxonomy(String taxonomyName) throws AWTException {

		waiting.explicitWaitVisibilityOfElement(taxonomySearchFieldLocator, 10);
		taxonomySearchFieldLocator.clear();
		taxonomySearchFieldLocator.sendKeys(taxonomyName);
		tu.hitEnter();

		return this;
	}

	@Step("assign tem(s) to category {0}")
	public EditItemsPageObjects assignItemToCategory(String categoryName, String noOfitemsToBeCategorized,
			String taxonomyName, String expSuccessMessage) throws AWTException, InterruptedException {

		int var = Integer.parseInt(noOfitemsToBeCategorized);
		for (int i = 1; i <= var; i++) {

			waiting.explicitWaitElementToBeClickable(categorizationTabLocator, 20);
			categorizationTabLocator.click();
			verifyCategoryAlreadyAssigned(categoryName + i);
			searchForTaxonomy(taxonomyName);
			selectCategory(categoryName + i);
			selectRadioButton(categoryName + i);
			saveCategory();
			verifySuccessMessageForCategoryAssign(expSuccessMessage);
			clickOnNextItem_EditPage.click();
			Thread.sleep(3000);

		}
		return this;

	}

	@Step("verification Of category: {0} already assigned or not ")
	public EditItemsPageObjects verifyCategoryAlreadyAssigned(String categoryName) throws InterruptedException {
		Thread.sleep(2000);
		try {
			Thread.sleep(1500);
			waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'" + categoryName
					+ "')]/ancestor::tbody/descendant::input[contains(@onclick,'defaultCtgInTaxonomy')]"), 15);
			getDriver()
					.findElement(By.xpath("//span[contains(text(),'" + categoryName
							+ "')]/ancestor::tbody/descendant::input[contains(@onclick,'defaultCtgInTaxonomy')]"))
					.isDisplayed();
			getDriver().findElement(By.xpath(
					"//span[contains(text(),'" + categoryName + "')]/ancestor::tbody/descendant::input[@alt='Remove']"))
					.click();
			tu.alertAccept();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		return this;

	}

	@Step("select rspective category radio button {0}")
	public EditItemsPageObjects selectRadioButton(String categoryName) throws InterruptedException {

		Thread.sleep(1000);
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'" + categoryName
				+ "')]/ancestor::tbody/descendant::input[contains(@onclick,'defaultCtgInTaxonomy')]"), 15);
		getDriver().findElement(By.xpath("//span[contains(text(),'" + categoryName
				+ "')]/ancestor::tbody/descendant::input[contains(@onclick,'defaultCtgInTaxonomy')]")).click();
		return this;

	}

	@Step(" verification of success message for categorization {0}")
	public EditItemsPageObjects verifySuccessMessageForCategoryAssign(String expSuccessMessage) {

		waiting.explicitWaitVisibilityOfElement(itemCategorySaveMessageLoator, 20);
		Assert.assertEquals(itemCategorySaveMessageLoator.getText(), expSuccessMessage);

		return this;
	}

	@Step("seect category to assign {0}")
	public EditItemsPageObjects selectCategory(String categoryName) throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(By
				.xpath("//div[@id='ttformid:taxonomyTreeId']/descendant::span[contains(@id,'ttformid:taxonomyTreeId') and text()='"
						+ categoryName + "']"),
				20);
		WebElement element = getDriver().findElement(By
				.xpath("//div[@id='ttformid:taxonomyTreeId']/descendant::td/descendant::span[contains(@id,'ttformid:taxonomyTreeId') and text()='"
						+ categoryName + "']"));
		WebElement target = getDriver().findElement(By.xpath("//form[@id='itemCategoryFormId']/descendant::thead"));
		utility.DragandDrop(element, target);
		// (new Actions(getDriver())).dragAndDrop(element, target).perform();
		Thread.sleep(3000);
		return this;

	}

	@Step("click on save link")
	public EditItemsPageObjects saveCategory() throws InterruptedException {

		waiting.explicitWaitElementToBeClickable(categorySaveLocator, 10);
		categorySaveLocator.click();
		Thread.sleep(2500);
		return this;
	}

	@Step(" search for items in edit items page")
	public EditItemsPageObjects searchForItem(String partNumber) throws InterruptedException {
		Thread.sleep(2500);
		getDriver().findElement(By.xpath("//input[@title='Search']")).click();
		Thread.sleep(3500);
		waiting.explicitWaitElementToBeClickable(searchFieldInEditPage, 30);
		searchFieldInEditPage.click();
		searchFieldInEditPage.clear();
		searchFieldInEditPage.sendKeys(partNumber);
		return this;

	}

	@Step("Click on SearchButton In edit items page")
	public EditItemsPageObjects clckOnSearchButton() throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitElementToBeClickable(searchButtonInEditPage, 30);
		searchButtonInEditPage.click();
		return this;
	}

	@Step("")
	public EditItemsPageObjects clickOnNextItemIcon() {
		waiting.explicitWaitVisibilityOfElement(nextItemIconLocator, 20);
		Assert.assertTrue(nextItemIconLocator.isDisplayed(), "next item locator is not displayed");
		nextItemIconLocator.click();

		return this;
	}

	@Step("verify The Results For NextItem is not equals to previous search results{0}")
	public EditItemsPageObjects verifyTheResultsForNextItem(String previousSearchResultsPartNumber) {

		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 20);
		String currentPageResults = partNumberInputFieldItemEditPage.getAttribute("value");
		Assert.assertNotEquals(currentPageResults, previousSearchResultsPartNumber,
				"next item page results are equal to previous page resuts");

		return this;
	}

	@Step("return the value of partNumber {0}")
	public String getTheItemPartNumber(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 20);
		String getPartNumber = partNumberInputFieldItemEditPage.getAttribute("value");
		return getPartNumber;
	}

	@Step("click on previous button")
	public EditItemsPageObjects clickOnPreviousItemIcon() {
		waiting.explicitWaitElementToBeClickable(itemEditRightpreviousButtonLocator, 20);
		itemEditRightpreviousButtonLocator.click();
		return this;
	}

	@Step("verify The Results For Previous button {0}")
	public EditItemsPageObjects verifyTheResultsForPrevious(String searchResults) {
		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 20);
		String currentPageResults = partNumberInputFieldItemEditPage.getAttribute("value");
		Assert.assertEquals(currentPageResults, searchResults);

		return this;
	}

	@Step("verification of prefilled data in edit item page")
	public EditItemsPageObjects verifyGeneralInfoTabWithPreFilledData(String partNumber, String manufacturerName,
			String brandName, String mpn) {

		waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 10);
		Assert.assertTrue(generalInfoTabLocator.getAttribute("class").contains("active"),
				"General info tab is enabled");
		Assert.assertTrue(partNumberInputFieldItemEditPage.getAttribute("value").contains(partNumber),
				"partNumber data is not available");
		Assert.assertTrue(manufacturerInputFieldInItemEdit.getAttribute("value").contains(manufacturerName),
				"ManufactureName data is not available");
		Assert.assertTrue(mpnInputLocatorInItemEditPage.getAttribute("value").contains(mpn),
				"ManufacturerpartNumber data is not available");
		Assert.assertTrue(brandInputLocatorInItemEditPage.getAttribute("value").contains(brandName),
				"brand data is not available");

		return this;

	}

	public EditItemsPageObjects updateThePartNumber(String updatedPartNumber) {
		waiting.explicitWaitElementToBeClickable(partNumberInputFieldItemEditPage, 10);
		partNumberInputFieldItemEditPage.click();
		partNumberInputFieldItemEditPage.clear();
		partNumberInputFieldItemEditPage.sendKeys(updatedPartNumber);

		return this;
	}

	@Step("update the all the mandatory fields with new values {0}")
	public EditItemsPageObjects updateThefields(String data) {

		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 20);

		partNumberInputFieldItemEditPage.clear();
		partNumberInputFieldItemEditPage.sendKeys(data);

		manufacturerInputFieldInItemEdit.clear();
		manufacturerInputFieldInItemEdit.sendKeys(data);

		mpnInputLocatorInItemEditPage.clear();
		mpnInputLocatorInItemEditPage.sendKeys(data);

		brandInputLocatorInItemEditPage.clear();
		brandInputLocatorInItemEditPage.sendKeys(data);
		return this;

	}

	@Step("verification of description fields {0}")
	public EditItemsPageObjects verifyDescriptionFields(String descriptionFields) {
		String expected[] = descriptionFields.split(",");
		List<WebElement> allAvailableFields = getDriver()
				.findElements(By.xpath("//span[@id='descFormId:discEditPanel']//div[@class='tab_Label']"));

		for (int i = 0; i < allAvailableFields.size(); i++) {

			for (int j = 0; j < expected.length; j++) {

				if (allAvailableFields.get(i).getText().equals(expected[j])) {
					Assert.assertEquals(allAvailableFields.get(i).getText(), expected[j],
							"Fields available in Description: " + allAvailableFields.get(i).getText() + "");
				}
			}
		}

		return this;
	}

	@Step("verification of description fields {0}")
	public EditItemsPageObjects enterTheDataInRespectiveField() {

		return this;
	}

	@Step("verify the available languages: {0} in descriprtion section")
	public EditItemsPageObjects verifyLanguageOptions(String languageCode) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(languageOptionLocator, 40);
		Select sel = new Select(languageOptionLocator);
		sel.selectByVisibleText(languageCode);
		Thread.sleep(2500);
		Assert.assertTrue(languageOptionValueLocator.getText().contains(languageCode),
				"language:" + languageCode + " is not selected");
		return this;

	}

	@Step("verify the product fields {0}in item edit page")
	public EditItemsPageObjects verifyProductFields(String productFields) {
		String expFields[] = productFields.split(",");
		for (int i = 0; i < productFielsLocator.size(); i++) {
			for (int j = 0; j < expFields.length; j++) {
				if (productFielsLocator.get(i).getText().equals(expFields[j])) {
					Assert.assertEquals(productFielsLocator.get(i).getText(), expFields[j],
							"products fields are not same");
				}
			}

		}
		return this;
	}

	@Step("Search for product{0}")
	public EditItemsPageObjects serchForItemInProductsTab(String productName) {
		waiting.explicitWaitVisibilityOfElement(productSearchFieldLocator, 30);
		productSearchFieldLocator.sendKeys(productName);
		productSearchButtonLocator.click();

		return this;

	}

	@Step("Save this as Product Item{0}")
	public EditItemsPageObjects clickOnSaveThisProductLink(String productName) throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(By.xpath("//div[contains(text(),'" + productName
				+ "')]/ancestor::tbody/descendant::input[@title='Save this as Product Item']"), 30);
		getDriver().findElement(By.xpath("//div[contains(text(),'" + productName
				+ "')]/ancestor::tbody/descendant::input[@title='Save this as Product Item']")).click();
		Thread.sleep(2500);

		return this;

	}

	@Step("Success messgae{0} for product assign ")
	public EditItemsPageObjects verifySuccessMessageForProductAssign(String succesMessage) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(productAssignSucessfulMessageLocator, 30);
		Assert.assertEquals(productAssignSucessfulMessageLocator.getText(), succesMessage,
				"error message has been displayed as : " + productAssignSucessfulMessageLocator.getText() + "");

		return this;
	}

	@Step("click on delink product link")
	public EditItemsPageObjects clickOnDelinkProductLink() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(delinkProductLocator, 30);
		delinkProductLocator.click();
		Thread.sleep(2500);

		return this;
	}

	@Step("verify success message for product delink{0}")
	public EditItemsPageObjects verifySuccessMessageForDelink(String delinkSuccessMessage) {
		waiting.explicitWaitVisibilityOfElement(delinkSuccesfulMessageLocator, 30);
		Assert.assertEquals(delinkSuccesfulMessageLocator.getText().trim(), delinkSuccessMessage.trim(),
				"error message has been displayed:" + delinkSuccesfulMessageLocator.getText() + "");

		return this;
	}

	@Step("verify max acceptance alphanumeric values by meta keyword data{0}")
	public EditItemsPageObjects verifyMetaKeywordEnteredData(String metaKeywordText,
			int maximumNumberOfCharactersAcceptedByTheTexbox) {

		Assert.assertEquals(MetaKeywordsTextboxLocator.getAttribute("value").trim(),
				metaKeywordText.substring(0,
						Math.min(metaKeywordText.length(), maximumNumberOfCharactersAcceptedByTheTexbox)),
				"meta keyword input Field is allowing more than acceptance value.exp: "
						+ maximumNumberOfCharactersAcceptedByTheTexbox + "");

		return this;
	}

	@Step("verify max acceptance alphanumeric values by custom keyword data{0}")
	public EditItemsPageObjects verifyCustomFieldEnteredData(String customKeyword,
			int maximumNumberOfCharactersAcceptedByTheTexbox) {
		Assert.assertEquals(CustomKeywordsTextboxLocator.getAttribute("value").trim(),
				customKeyword.substring(0,
						Math.min(customKeyword.length(), maximumNumberOfCharactersAcceptedByTheTexbox)),
				"custom keyword input Field is allowing more than acceptance value. exp:"
						+ maximumNumberOfCharactersAcceptedByTheTexbox + "");

		return this;

	}

	@Step("click on save keywords link")
	public EditItemsPageObjects clickOnSaveKeywordsButton() throws InterruptedException {
		Thread.sleep(1000);
		waiting.explicitWaitElementToBeClickable(saveKeywordsUpdateLocator, 30);
		saveKeywordsUpdateLocator.click();

		return this;
	}

	@Step("verify update success message {0}")
	public EditItemsPageObjects verifyUpdateKeywordSuccessMessage(String updateSuccessMessageForKeywords)
			throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(succesMessageForKeywordUpdate, 30);
		Assert.assertEquals(succesMessageForKeywordUpdate.getText().trim(), updateSuccessMessageForKeywords.trim(),
				"keywords not updated exp: " + updateSuccessMessageForKeywords + "");

		return this;
	}

	@Step("click on add new url save button")
	public EditItemsPageObjects clickOnAddnewDocumentUrlButton() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(AddnewDocumentSaveButtonLocator, 20);
		AddnewDocumentSaveButtonLocator.click();
		Thread.sleep(2000);

		return this;

	}

	@Step("verify success message for added url to document")
	public EditItemsPageObjects verifysuccessMessageForUrlAdded(String successMessageForUrlAdded) {
		waiting.explicitWaitVisibilityOfElement(DocumentSuccessMsgLocator, 30);
		Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(), successMessageForUrlAdded);

		return this;
	}

	@Step("remove assigned doccument by the url{0}")
	public EditItemsPageObjects verifyAssignedDocumentByTheUrl(String documentDescription, String documentURL)
			throws InterruptedException {

		Thread.sleep(2500);
		try {
			if (getDriver().findElement(By.xpath("//a[contains(@href,'" + documentURL
					+ "')]/ancestor::tbody/descendant::input[contains(@id,'selectedURLId')]")).isDisplayed()) {
				waiting.explicitWaitElementToBeClickable(By.xpath("//a[contains(@href,'" + documentURL
						+ "')]/ancestor::tbody/descendant::input[contains(@id,'selectedURLId')]"), 20);

				getDriver().findElement(By.xpath("//a[contains(@href,'" + documentURL
						+ "')]/ancestor::tbody/descendant::input[contains(@id,'selectedURLId')]")).click();
				Thread.sleep(500);
				getDriver()
						.findElement(By.xpath("//a[@href='" + documentURL
								+ "']/ancestor::tbody/descendant::input/following-sibling::input[@title='Remove selected Documents']"))
						.click();
				tu.alertAccept();
				Thread.sleep(2000);
				Assert.assertEquals(removeDocumentSuccessMessageLocator.getText(),
						"'" + documentDescription + "' Document removed Successfully");
			}
		} catch (NoSuchElementException e) {

		}

		return this;
	}

	@Step("remove assigned doccument by the url{0}")
	public EditItemsPageObjects removeAssignedDocumentByTheUrl(String documentDescription, String documentURL)
			throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(DocumentURLcheckboxLocator, 30);
		DocumentURLcheckboxLocator.click();
		getDriver()
				.findElement(By.xpath("//a[@href='" + documentURL
						+ "']/ancestor::tbody/descendant::input/following-sibling::input[@title='Remove selected Documents']"))
				.click();
		tu.alertAccept();
		Thread.sleep(2000);
		Assert.assertEquals(removeDocumentSuccessMessageLocator.getText(),
				"'" + documentDescription + "' Document removed Successfully");

		return this;

	}

	@Step("click on edit document cation added by url{0}")
	public EditItemsPageObjects clickOnEditCaptionIcon(String documentURL) throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(
				By.xpath("//a[@href='" + documentURL + "']/ancestor::tbody/descendant::input[@title='Edit Caption']"),
				30);
		getDriver()
				.findElement(By.xpath(
						"//a[@href='" + documentURL + "']/ancestor::tbody/descendant::input[@title='Edit Caption']"))
				.click();
		Thread.sleep(2000);

		return this;

	}

	@Step("verify cancel functionality")
	public EditItemsPageObjects verifyCancelFunctionality() {
		Assert.assertFalse(assertVerifyAddDocFields(), "cancel functionality is not working");

		return this;
	}

	@Step("verification of Edit Product's Item header titles: {0}.")

	public EditItemsPageObjects verifyItemsTableHeaders(String expectedTableHeaders[]) {

		waiting.explicitWaitVisibilityOfElements(itemsTableHeaderTitlesLink, 15);
		for (int i = 0; i < itemsTableHeaderTitlesLink.size(); i++) {
			Assert.assertEquals(itemsTableHeaderTitlesLink.get(i).getText().trim().toLowerCase(),
					expectedTableHeaders[i].trim().toLowerCase());
		}
		return this;
	}

	/*
	 * private boolean verifyLanguageOptionSelected(String languageCode) {
	 * getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * try{ if(languageOptionValueLocator.getAttribute("selected").contains(
	 * languageCode)) {
	 * 
	 * return true; } }catch(NoSuchElementException e) { return false; }
	 * 
	 * return false;
	 * 
	 * }
	 */
	private boolean assertVerifyAddDocFields() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (AddnewDocumentcaptionLocator.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;
		}

		return false;
	}

	@Step("verify error messages")
	public EditItemsPageObjects verifyErrorMessages(String fieldName, String errorMessage) throws Exception {
		switch (fieldName) {

		case "Document Caption":
			Thread.sleep(2000);
			waiting.explicitWaitVisibilityOfElement(DocumentCaptionErrorMsgLocator, 40);
			Assert.assertEquals(DocumentCaptionErrorMsgLocator.getText().trim(), errorMessage);

			break;
		case "Document URL":
			Thread.sleep(2000);
			waiting.explicitWaitVisibilityOfElement(DocumentSuccessMsgLocator, 40);
			Assert.assertEquals(DocumentSuccessMsgLocator.getText().trim(), errorMessage);
			break;
		default:
			throw new Exception("invalid options");

		}
		return this;

	}

	@Step("click on add new item document link")
	public EditItemsPageObjects clickOnAddNewItemDocumentCategoryLink() throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitElementToBeClickable(AddnewDocumentcatlinkLocator, 30);
		AddnewDocumentcatlinkLocator.click();
		return this;
	}

	@Step("enter document category name{0}")
	public EditItemsPageObjects addNewDocumentCategoryName(String documentCategoryName) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(itemDocumentCategoryNameLocator, 50);
		itemDocumentCategoryNameLocator.sendKeys(documentCategoryName);

		return this;

	}

	@Step("enter document category description{0}")
	public EditItemsPageObjects addNewDocumentCategoryDescription(String documentCategoryDescription)
			throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(itemdocumentCategoryDescription, 50);
		itemdocumentCategoryDescription.sendKeys(documentCategoryDescription);
		return this;

	}

	@Step("verify success Message for document category save{0}")
	public EditItemsPageObjects verifySuccessMessageForDocumentCategorySave(String docCategorySaveSuccessMessage)
			throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//table[@id='categoryPanelContentTable']/descendant::span[contains(text(),'"
						+ docCategorySaveSuccessMessage + "')]"),
				50);
		Assert.assertEquals(
				getDriver().findElement(
						By.xpath("//table[@id='categoryPanelContentTable']/descendant::span[contains(text(),'"
								+ docCategorySaveSuccessMessage + "')]"))
						.getText().trim(),
				docCategorySaveSuccessMessage.trim());

		return this;

	}

	@Step("validate document category name{0}")
	public EditItemsPageObjects verifyDocCategoryName(String documentCategoryName,
			int maximumNumberOfCharactersAcceptedByTheTexbox) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(itemDocumentCategoryNameLocator.getAttribute("value").trim(),
				documentCategoryName.substring(0,
						Math.min(documentCategoryName.length(), maximumNumberOfCharactersAcceptedByTheTexbox)),
				"category name input Field is allowing more than acceptance value.");

		return this;
	}

	@Step("validate document category description{0}")
	public EditItemsPageObjects validateDocCategoryDescription(String documentCategoryDescription,
			int maximumNumberOfCharactersAcceptedByTheTexbox) {
		waiting.explicitWaitVisibilityOfElement(itemdocumentCategoryDescription, 30);
		Assert.assertEquals(itemdocumentCategoryDescription.getAttribute("value").trim(),
				documentCategoryDescription.substring(0,
						Math.min(documentCategoryDescription.length(), maximumNumberOfCharactersAcceptedByTheTexbox)),
				"category description input Field is allowing more than acceptance value.");

		return this;
	}

	@Step("remove assigned video {0} from the item")
	public EditItemsPageObjects removeAssignedVideoFromItem(String videoCaption, String videoRemoveSuccessMessage)
			throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(
					By.xpath("//tbody[@id='listVideoFromId:assignedItemVideosId:tb']/descendant::span[contains(text(),'"
							+ videoCaption + "')]"))
					.isDisplayed()) {

				getDriver()
						.findElement(By.xpath("//span[contains(text(),'" + videoCaption
								+ "')]/ancestor::tbody[@id='listVideoFromId:assignedItemVideosId:tb']/descendant::input[@type='checkbox']"))
						.click();
				getDriver()
						.findElement(By.xpath("//span[contains(text(),'" + videoCaption
								+ "')]/ancestor::tbody[@id='listVideoFromId:assignedItemVideosId:tb']/descendant::input[@title='Remove selected Videos']"))
						.click();
				tu.alertAccept();
				Thread.sleep(2000);
				waiting.explicitWaitVisibilityOfElement(DeleteVideoAlertMsgLocator, 50);
				Assert.assertEquals(DeleteVideoAlertMsgLocator.getText().trim(), videoRemoveSuccessMessage.trim());
			}
		} catch (NoSuchElementException e) {

		}

		return this;

	}

	@Step("verify alert message when check box is not checket {0}")
	public EditItemsPageObjects verifyAlertCheckBoxNotChecked(String videoCaption, String alertMessageText) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(
					By.xpath("//tbody[@id='listVideoFromId:assignedItemVideosId:tb']/descendant::span[contains(text(),'"
							+ videoCaption + "')]"))
					.isDisplayed()) {

				getDriver()
						.findElement(By.xpath("//span[contains(text(),'" + videoCaption
								+ "')]/ancestor::tbody[@id='listVideoFromId:assignedItemVideosId:tb']/descendant::input[@title='Remove selected Videos']"))
						.click();
				String alertText = tu.getAlertText();
				tu.alertDismiss();
				Assert.assertEquals(alertText.trim(), alertMessageText.trim(), "alert message was not displayed");

			}
		} catch (NoSuchElementException e) {

		}

		return this;
	}

	@Step("enter part number to be assign {0}")
	public EditItemsPageObjects searchForItems(String partNumber) {
		waiting.explicitWaitVisibilityOfElement(searchItemLinkTypeSearchTextboxLoc, 40);
		searchItemLinkTypeSearchTextboxLoc.sendKeys(partNumber);
		searchButtonForLinkedItems.click();

		return this;
	}

	@Step("drag and drop the items to be link")
	public EditItemsPageObjects assignLinkedItems(String partNumber) throws InterruptedException {
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath(
						"//div[@class='tab_ColumnLeft linkedTabColLeft']/descendant::td[contains(text(),'AutomationTestPN1')]"),
				50);
		WebElement source = getDriver().findElement(By.xpath(
				"//div[@class='tab_ColumnLeft linkedTabColLeft']/descendant::td[contains(text(),'AutomationTestPN1')]"));
		WebElement target = getDriver().findElement(
				By.xpath(".//*[@id='hereFormId:assignedItemsTable2']/descendant::span[contains(text(),'Action')]"));

		utility.DragandDrop(source, target);
		Thread.sleep(2500);
		Assert.assertFalse(assertVerifyAssignedItem(partNumber), "item not assigned to linked list");

		return this;

	}

	private boolean assertVerifyAssignedItem(String partNumber) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver()
					.findElement(By.xpath("//td[contains(text()," + partNumber
							+ ")]/preceding-sibling::td/descendant::input[@title='Remove from this LinkType']"))
					.isDisplayed()) {
				return false;

			}
		} catch (NoSuchElementException e) {
			return true;

		}

		return false;
	}

	private boolean removeAssignedLinkedItem(String partNumber, String getItemId) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver()
					.findElement(By.xpath("//td[contains(text()," + partNumber
							+ ")]/preceding-sibling::td/descendant::input[@title='Remove from this LinkType']"))
					.isDisplayed()) {
				getDriver()
						.findElement(By.xpath("//td[contains(text()," + partNumber
								+ ")]/preceding-sibling::td/descendant::input[@title='Remove from this LinkType']"))
						.click();
				tu.alertAccept();
				waiting.explicitWaitVisibilityOfElement(successFulMessageForRemoveLinkedItem, 60);
				Assert.assertEquals(successFulMessageForRemoveLinkedItem.getText().trim(),
						"Searched Item Id : " + getItemId + ";P.No: " + partNumber + " ) removed Successfully".trim(),
						"");
				return false;
			}

		} catch (NoSuchElementException e) {
			return true;
		}

		return false;
	}

	@Step("item link type name {0}")
	public EditItemsPageObjects verifyItemLinkType(String itemLinkTypeName) throws InterruptedException {
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifyLinkTypeNamePresent(itemLinkTypeName), "Unable to delete the created link type");
		return this;
	}

	private boolean assertVerifyLinkTypeNamePresent(String itemLinkTypeName) throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(
					By.xpath("//tbody[@id='linkdtabsid:itemLinkTypeTableId:tb']/descendant::span[contains(text(),'"
							+ itemLinkTypeName + "')]"))
					.isDisplayed()) {
				getDriver().findElement(By.xpath("//span[contains(text(),'" + itemLinkTypeName
						+ "')]/ancestor::tbody/descendant::input[@title='Remove']")).click();
				tu.alertAccept();
				Thread.sleep(2000);
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}

		return false;
	}

	@Step("enter item link type name {0}")
	public EditItemsPageObjects enterItemLinkTypeName(String itemLinkTypeName, String linkedItemSaveMessage)
			throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(LinkTypeNameFieldLocator, 50);
		LinkTypeNameFieldLocator.sendKeys(itemLinkTypeName);
		saveLinkTypeLocator.click();
		Thread.sleep(2000);
		waiting.explicitWaitVisibilityOfElement(linktypeSuccessMsg, 50);
		Assert.assertEquals(linktypeSuccessMsg.getText().trim(), linkedItemSaveMessage.trim());

		return this;
	}

	@Step("click on setup linked items tab")
	public EditItemsPageObjects clickOnSetupLinkedItemsTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(setUpLinkedItemsLocator, 50);
		setUpLinkedItemsLocator.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("remove assigned linked items from the list{0}")
	public EditItemsPageObjects removeAssignedLinkedItems(String partNumber, String itemLinkTypeName,
			String getItemId) {
		waiting.explicitWaitVisibilityOfElement(selectLinkedItemTypeFieldLocator, 50);
		selectLinkedItemTypeFieldLocator.clear();
		selectLinkedItemTypeFieldLocator.sendKeys(itemLinkTypeName);

		Assert.assertTrue(removeAssignedLinkedItem(partNumber, getItemId), "assigned item can't be remove");

		return this;
	}

	@Step("click on save assigned linked lst icon")
	public EditItemsPageObjects clickOnSaveAssignedLinkedListIcon() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(saveAssignedLinkedListIcon, 50);
		saveAssignedLinkedListIcon.click();
		Thread.sleep(2500);

		return this;

	}

	@Step("verify success message{0} after click on save assigned linked items")
	public EditItemsPageObjects verifySuccessMessageForSaveAssignedList(String assignedSaveMessage) {
		waiting.explicitWaitVisibilityOfElement(saveAssignedSuccessMessageLocator, 50);
		Assert.assertEquals(saveAssignedSuccessMessageLocator.getText().trim(), assignedSaveMessage.trim());

		return this;

	}

	@Step("verify list item link type {0}")
	public EditItemsPageObjects verifyListItemLinkTypeHeaders(String listItemLinkTypeHeaders) {

		String expectedFields[] = listItemLinkTypeHeaders.split(",");
		waiting.explicitWaitVisibilityOfElements(listItemLinkTypeHeaderFields, 50);
		for (int i = 0; i < listItemLinkTypeHeaderFields.size(); i++) {
			Assert.assertEquals(listItemLinkTypeHeaderFields.get(i).getText().trim(), expectedFields[i]);
		}
		return this;

	}

	@Step(" click on update item link type")
	public EditItemsPageObjects clickOnEditItemLinkType(String itemLinkTypeName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'" + itemLinkTypeName
				+ "')]/ancestor::tbody/descendant::input[@title='Edit Item Link Type']"), 50);
		getDriver().findElement(By.xpath("//span[contains(text(),'" + itemLinkTypeName
				+ "')]/ancestor::tbody/descendant::input[@title='Edit Item Link Type']")).click();
		Thread.sleep(3000);
		return this;

	}

	@Step(" search for attributeList {0}")
	public EditItemsPageObjects searchForAttibuteList(String attributeListName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(attributeSearchInputField, 50);
		attributeSearchInputField.clear();
		attributeSearchInputField.sendKeys(attributeListName);
		searchButtonForAttributeList.click();
		Thread.sleep(2500);

		return this;
	}

	@Step("verify attribute{0} and assign it to item")
	public EditItemsPageObjects verifyAndAssignAttribute(String attributeListName) throws InterruptedException {
		Assert.assertTrue(assertVerifyAttributeNamePresents(attributeListName),
				"attribute is not available, please create before assign");
		getDriver().findElement(By.xpath(
				"//span[contains(text(),'" + attributeListName + "')]/ancestor::tr/descendant::input[@alt='Assign']"))
				.click();
		Thread.sleep(2500);
		getDriver()
				.findElement(By
						.xpath("//td[contains(text(),'Selected Attribute')]/ancestor::tr/descendant::input[contains(@title,'Save')]"))
				.click();
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifyAssignedAttribute(attributeListName),
				"Assigned attribute is displayed under the list");
		Thread.sleep(1500);
		attributevaluesavelocator.click();

		return this;

	}

	private boolean assertVerifyAssignedAttribute(String attributeListName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(By
					.xpath("//tbody[@id='atf:atdt:tb']/descendant::span[contains(text(),'" + attributeListName + "')]"))
					.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	private boolean assertVerifyAttributeNamePresents(String attributeListName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(By.xpath("//span[contains(text(),'" + attributeListName
					+ "')]/ancestor::tr/descendant::input[@alt='Assign']")).isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	@Step("verify success message for attribute save {0}")
	public EditItemsPageObjects verifySuccessMessageForAttributeAssign(String attributeListName,
			String expSuccessMessageForAttributeSave) {
		waiting.explicitWaitVisibilityOfElement(attributevaluesaveMsglocator, 50);
		Assert.assertEquals(attributevaluesaveMsglocator.getText().trim(), expSuccessMessageForAttributeSave.trim());
		Assert.assertTrue(assertVerifyAssignedAttribute(attributeListName),
				"Attribute value is not displayed under assigned list");

		return this;
	}

	@Step("verify cancel functionality")
	public EditItemsPageObjects verifyCancelFuctionality(String attributeListName) throws InterruptedException {
		Assert.assertTrue(assertVerifyAttributeNamePresents(attributeListName),
				"attribute is not available, please create before assign");
		getDriver().findElement(By.xpath(
				"//span[contains(text(),'" + attributeListName + "')]/ancestor::tr/descendant::input[@alt='Assign']"))
				.click();
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(cancelButtonInAlertWindow, 50);
		cancelButtonInAlertWindow.click();
		Thread.sleep(1500);
		Assert.assertFalse(assertVerifyCancelFunctionality(), "cancel functionality is not working.");

		return this;

	}

	private boolean assertVerifyCancelFunctionality() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (cancelButtonInAlertWindow.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;
		}
		return false;
	}

	public EditItemsPageObjects verifyCustomPriceTabHeaders(String customePriceHeaders) {
		String expHeaders[] = customePriceHeaders.split(",");
		waiting.explicitWaitVisibilityOfElements(customPriceTabHeaders, 50);
		for (int i = 0; i < customPriceTabHeaders.size(); i++) {

			Assert.assertEquals(customPriceTabHeaders.get(i).getText().trim(), expHeaders[i]);
		}

		return this;

	}

	public EditItemsPageObjects verifyCustomPriceTabCheckBoxes() throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElements(
				By.xpath(
						"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[@type='checkbox']"),
				50);
		List<WebElement> checkBoxes = getDriver().findElements(By.xpath(
				"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[@type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (!checkBoxes.get(i).isSelected()) {
				checkBoxes.get(i).click();
				checkBoxes.get(i).click();
			}
		}
		return this;

	}

	@Step("verify custome price tab input fields")
	public EditItemsPageObjects verifyCustomPriceTabInputTextFields(String testData) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElements(
				By.xpath(
						"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[@type='text']"),
				50);
		List<WebElement> textFields = getDriver().findElements(By.xpath(
				"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[@type='text']"));
		for (int i = 0; i < textFields.size(); i++) {
			if (textFields.get(i).getAttribute("value").isEmpty()) {
				textFields.get(i).sendKeys(testData);
				textFields.get(i).clear();
			}
		}

		return this;
	}

	@Step("validate custom price input text fields")
	public EditItemsPageObjects validateCustomPriceInputTextFields(String fields, String allowedChars, String testChars)
			throws InterruptedException {
		Thread.sleep(2500);
		int noOfChars = Integer.parseInt(allowedChars);
		String textToBeEntered = random.random(Integer.parseInt(testChars), PermittedCharacters.ALPHABETS);
		switch (fields) {
		case "IMAP Price":
			Thread.sleep(2000);
			WebElement ele = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'imapPriceId')]"));
			ele.clear();
			ele.sendKeys(textToBeEntered);
			Assert.assertEquals(ele.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"IMAP Price is allowing more than accepted values");
			break;
		case "Net Price":
			Thread.sleep(2000);
			WebElement ele1 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'netPrice')]"));
			ele1.clear();
			ele1.sendKeys(textToBeEntered);
			Assert.assertEquals(ele1.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Net Price is allowing more than accepted values");
			break;

		case "Pack Desc":
			Thread.sleep(2000);
			WebElement ele2 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'packDesc')]"));
			ele2.clear();
			ele2.sendKeys(textToBeEntered);
			Assert.assertEquals(ele2.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Pack description is allowing more than accepted values");
			break;
		case "Sales UOM":
			Thread.sleep(2000);
			WebElement ele3 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'salesUOM')]"));
			ele3.clear();
			ele3.sendKeys(textToBeEntered);
			Assert.assertEquals(ele3.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Sales UOM is allowing more than accepted values");
			break;
		case "Price Per":
			Thread.sleep(2000);
			WebElement ele4 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'salQty')]"));
			ele4.clear();
			ele4.sendKeys(textToBeEntered);
			Assert.assertEquals(ele4.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Price Per is allowing more than accepted values");
			break;

		case "Min Order Qty":
			Thread.sleep(2000);
			WebElement ele5 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'minOrderQty')]"));
			ele5.clear();
			ele5.sendKeys(textToBeEntered);
			Assert.assertEquals(ele5.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Min Order Qty is allowing more than accepted values");
			break;

		case "Order Qty Interval":
			Thread.sleep(2000);
			WebElement ele6 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'orderQtyInterval')]"));
			ele6.clear();
			ele6.sendKeys(textToBeEntered);
			Assert.assertEquals(ele6.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Order Qty Interval is allowing more than accepted values");
			break;
		case "Customer PN":
			Thread.sleep(2000);
			WebElement ele7 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'CPNUMVal')]"));
			ele7.clear();
			ele7.sendKeys(textToBeEntered);
			Assert.assertEquals(ele7.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Customer PN is allowing more than accepted values");
			break;
		case "UNSPSC":
			Thread.sleep(2000);
			WebElement ele8 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'unspsc')]"));
			ele8.clear();
			ele8.sendKeys(textToBeEntered);
			Assert.assertEquals(ele8.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"UNSPSC is allowing more than accepted values");
			break;
		case "Material Group":
			Thread.sleep(2000);
			WebElement ele9 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'materialGroup')]"));
			ele9.clear();
			ele9.sendKeys(textToBeEntered);
			Assert.assertEquals(ele9.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Material Group is allowing more than accepted values");
			break;
		case "Material Number":
			Thread.sleep(2000);
			WebElement ele10 = getDriver().findElement(By.xpath(
					"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'materialNumber')]"));
			ele10.clear();
			ele10.sendKeys(textToBeEntered);
			Assert.assertEquals(ele10.getAttribute("value").trim(),
					textToBeEntered.substring(0, Math.min(textToBeEntered.length(), noOfChars)),
					"Material Number is allowing more than accepted values");
			break;
		default:
			break;
		}

		return this;
	}

	@Step("update item price{0}")
	public EditItemsPageObjects updateItemPriceInSubset(String subset, String price) throws InterruptedException {
		Thread.sleep(2000);
		WebElement ele1 = getDriver().findElement(By.xpath(
				"//input[contains(@title,'Update Item Prices in Subset')]/ancestor::tr[@class='rich-table-row rich-table-firstrow']/descendant::input[contains(@id,'netPrice')]"));
		ele1.clear();
		ele1.sendKeys(price);
		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//tbody[@id='customPricesForm:customPricesTable:tb']/tr/descendant::span[text()='" + subset
						+ "']/../preceding-sibling::td/descendant::input[@title='Update Item Prices in Subset']"),
				50);
		getDriver()
				.findElement(By.xpath(
						"//tbody[@id='customPricesForm:customPricesTable:tb']/tr/descendant::span[text()='" + subset
								+ "']/../preceding-sibling::td/descendant::input[@title='Update Item Prices in Subset']"))
				.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("verify the update success message {0}")
	public EditItemsPageObjects verifyCustomePriceUpdateSuccessMessage(String subsetName) throws InterruptedException {
		Thread.sleep(2500);
		waiting.explicitWaitVisibilityOfElement(subsetassigntoitemmessageloc, 30);
		Assert.assertEquals(subsetassigntoitemmessageloc.getText().trim(),
				"Item Updated Successfully in - \"" + subsetName + "\" Subset");

		return this;

	}

	public EditItemsPageObjects clickOnCustomFieldsTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customFieldsTab, 50);
		customFieldsTab.click();
		Thread.sleep(2500);
		return this;
	}

	@Step("verify table data {0}tabs")
	public EditItemsPageObjects verifyCustomFieldsTableTab() {
		waiting.explicitWaitVisibilityOfElement(customFieldTableDataTabLocator, 50);
		Assert.assertTrue(customFieldTableDataTabLocator.isDisplayed(), "custom table data tab is not displayed");
		customFieldTableDataTabLocator.click();

		return this;

	}

	@Step("verify simple data{0}")
	public EditItemsPageObjects verifyCustomFieldsSimpleTab() {
		waiting.explicitWaitVisibilityOfElement(customFieldSimpleDataLocator, 50);
		Assert.assertTrue(customFieldSimpleDataLocator.isDisplayed(), " simple data tab is not displayed");
		return this;
	}

	@Step("verify simple date {0} present")
	public EditItemsPageObjects verifySimpleDataAvailable(String expSimpleData) {
		waiting.explicitWaitVisibilityOfElement(By
				.xpath("//tbody[@id='customFieldsFormIdITEM:customFieldsTableIdITEM:tb']/descendant::td[contains(text(),'"
						+ expSimpleData + "')]"),
				40);
		Assert.assertFalse(assertVerifySimpleField(expSimpleData),
				"simple data: " + expSimpleData + " is not available, please create");

		return this;
	}

	private boolean assertVerifySimpleField(String expSimpleData) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(By
					.xpath("//tbody[@id='customFieldsFormIdITEM:customFieldsTableIdITEM:tb']/descendant::td[contains(text(),'"
							+ expSimpleData + "')]"))
					.isDisplayed()) {
				return false;

			}
		} catch (Exception e) {
			return true;
		}

		return false;
	}

	@Step("verify customer panrt number tab is present or not")
	public EditItemsPageObjects verifyCustomerPartNumberTab() {
		waiting.explicitWaitVisibilityOfElement(cpnTabLocator, 40);
		Assert.assertTrue(assertVerifyCPTab(), "customer part number tab is not available");

		return this;

	}

	private boolean assertVerifyCPTab() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (cpnTabLocator.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Step("verify create new customer part number fields")
	public EditItemsPageObjects verifyCreateNewCPFields() {
		waiting.explicitWaitVisibilityOfElement(addNewCpnLocator, 30);
		Assert.assertTrue(addNewCpnLocator.isDisplayed(), "add new loacroe is not available");
		addNewCpnLocator.click();
		waiting.explicitWaitVisibilityOfElement(customerInputLocator, 30);
		Assert.assertTrue(customerInputLocator.isDisplayed(), "cpn input field is not available");
		Assert.assertTrue(addcustomerFieldLocator.isDisplayed(), " add customer input field is not available");
		Assert.assertTrue(saveNewCpnLocator.isDisplayed(), " add new cpn link is not available");
		Assert.assertTrue(resetCpnFieldsLocator.isDisplayed(), " add new cpn link is not available");
		Assert.assertTrue(closeCpnFieldsLocator.isDisplayed(), "close cpn fields link is not available");

		return this;

	}

	@Step("select the customer{0} from dropdown")
	public EditItemsPageObjects selectCustomerFromDropDown(String customerName) {
		waiting.explicitWaitVisibilityOfElement(customerInputLocator, 30);
		customerInputLocator.click();
		customerInputLocator.clear();
		customerInputLocator.sendKeys(customerName);

		return this;
	}

	public EditItemsPageObjects clickOnCPNResetButton() {
		resetCpnFieldsLocator.click();

		return this;
	}

	public EditItemsPageObjects enterDataToCustomerField(String customerName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customerInputLocator, 30);
		customerInputLocator.sendKeys(customerName);
		Thread.sleep(2500);

		return this;
	}

	@Step("verify cpn reset functionality")
	public EditItemsPageObjects verifyCPNResetFunctionality() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(customerInputLocator, 30);
		Thread.sleep(1500);
		Assert.assertTrue(customerInputLocator.getAttribute("value").isEmpty(), "reset functionality is not working");

		return this;
	}

	@Step("verify warehouse tab is prerest")
	public EditItemsPageObjects verifyWarehouseTabPresent() {
		waiting.explicitWaitVisibilityOfElement(warehouseTabLocator, 30);
		Assert.assertTrue(warehouseTabLocator.isDisplayed(), " warehouse tab is not present");

		return this;
	}

	@Step("click on warehouse tab")
	public EditItemsPageObjects clickOnWarehouseTab() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(warehouseTabLocator, 30);
		warehouseTabLocator.click();
		Thread.sleep(2000);

		return this;
	}

	@Step("verify warehouse tab in edit items page")
	public EditItemsPageObjects verifyWarehousePage() {

		waiting.explicitWaitVisibilityOfElement(warehouseSearchInputLocator, 30);
		Assert.assertTrue(warehouseSearchInputLocator.isDisplayed(), "search field is not displayed");
		Assert.assertTrue(warehouseSelectAllCheckBox.isDisplayed(), "select all check box is not displayed");
		Assert.assertTrue(warehouseNameHeaderLocator.isDisplayed(), "warehouse name column was not displayed.");
		Assert.assertTrue(warehouseAddress1HeaderLocator.isDisplayed(), "warehouse address1 column was not displayed.");
		Assert.assertTrue(saveWarehouseToItems.isDisplayed(), "save warehouse to item link was not displayed");
		Assert.assertTrue(removeWarehouseToItems.isDisplayed(), "remove warehouse to item link was not displayed");
		Assert.assertTrue(warehouseItemsHistory.isDisplayed(), "ware house history link was not displayed");

		return this;
	}

	@Step("search for warehouse name {0}")
	public EditItemsPageObjects searchForwareHouse(String warehouseName) {
		waiting.explicitWaitVisibilityOfElement(warehouseSearchInputLocator, 30);
		warehouseSearchInputLocator.clear();
		warehouseSearchInputLocator.sendKeys(warehouseName);

		return this;
	}

	@Step("verify ware house {0} displayed or not")
	public EditItemsPageObjects verifySearchResults(String warehouseName) throws InterruptedException {
		Thread.sleep(2500);
		Assert.assertTrue(assertVerifyWarehousePresent(warehouseName),
				"ware house :" + warehouseName + " is not displayed");
		return this;
	}

	private boolean assertVerifyWarehousePresent(String warehouseName) {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(
					By.xpath("//tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::span[text()='"
							+ warehouseName + "']"))
					.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@Step("verify warehouse search results for invalid name {0}")
	public EditItemsPageObjects verifySearchResultsInvalid(String warehouseNameInvalid) throws InterruptedException {

		Thread.sleep(2500);
		Assert.assertFalse(assertVerifyWarehousePresent(warehouseNameInvalid),
				"ware house :" + warehouseNameInvalid + " is displayed");

		return this;
	}

	@Step("select the warehouse{0} to item")
	public EditItemsPageObjects selectWarehouseToSave(String warehouseName) {

		waiting.explicitWaitVisibilityOfElement(
				By.xpath("//span[text()='" + warehouseName
						+ "']/ancestor::tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::input[@type='checkbox']"),
				30);
		Assert.assertTrue(selectWareHouseToItem(warehouseName), "unable to select warehouse" + warehouseName + "");

		return this;
	}

	private boolean selectWareHouseToItem(String warehouseName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver()
					.findElement(By.xpath("//span[text()='" + warehouseName
							+ "']/ancestor::tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::input[@type='checkbox']"))
					.isDisplayed()) {
				if (getDriver()
						.findElement(By.xpath("//span[text()='" + warehouseName
								+ "']/ancestor::tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::input[@type='checkbox']"))
						.isSelected()) {
					return true;
				} else {
					getDriver()
							.findElement(By.xpath("//span[text()='" + warehouseName
									+ "']/ancestor::tbody[@id='warehouseListFormId:warehouseDataTable:tb']/descendant::input[@type='checkbox']"))
							.click();
					Thread.sleep(1500);
					return true;
				}

			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@Step("click on save icon")
	public EditItemsPageObjects saveWarehouseToItem() throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(saveWarehouseToItems, 30);
		saveWarehouseToItems.click();
		Thread.sleep(1500);

		return this;
	}

	@Step("verify save success message for warehouse added to item")
	public EditItemsPageObjects verifyWarehouseSaveSuccessMessage(String expSuccessMessage) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'" + expSuccessMessage + "')]"), 30);
		Assert.assertEquals(getDriver().findElement(By.xpath("//span[contains(text(),'" + expSuccessMessage + "')]"))
				.getText().trim(), expSuccessMessage.trim());

		return this;
	}

	@Step("click on select all warehouses check boxes.")
	public EditItemsPageObjects selectSelectAllWarehouses() {
		waiting.explicitWaitVisibilityOfElement(warehouseSelectAllCheckBox, 30);
		Assert.assertTrue(selectSelectAllCheckBoxes(), "unable to select multiple warehouses");

		return this;
	}

	private boolean selectSelectAllCheckBoxes() {
		try {
			if (warehouseSelectAllCheckBox.isDisplayed()) {
				if (warehouseSelectAllCheckBox.isSelected()) {
					return true;
				} else {
					warehouseSelectAllCheckBox.click();
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Step("click on remove selected warehouse from item")
	public EditItemsPageObjects removeWarehouseToItem() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(removeWarehouseToItems, 30);
		removeWarehouseToItems.click();
		Thread.sleep(2500);
		return this;
	}

	public EditItemsPageObjects selectMultipleWarehouses(String noOfWareHosesToBeselect) {

		int noOfWarehousesselect = Integer.parseInt(noOfWareHosesToBeselect);

		for (int i = 0; i < noOfWarehousesselect; i++) {
			if (multipleWarehousesCheckBoxes.get(i).isSelected()) {
				multipleWarehousesCheckBoxes.get(i).click();
				multipleWarehousesCheckBoxes.get(i).click();
			} else {
				multipleWarehousesCheckBoxes.get(i).click();
			}
		}

		return this;
	}

	@Step("click on warehouse history link")
	public EditItemsPageObjects clickOnWareHouseHistoryLink() {
		waiting.explicitWaitElementToBeClickable(warehouseItemsHistory, 30);
		warehouseItemsHistory.click();

		return this;
	}

	@Step("remove copied item {0}")
	public EditItemsPageObjects removeCopiedItem(String testData) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(partNumberInputFieldItemEditPage, 30);
		Assert.assertEquals(partNumberInputFieldItemEditPage.getAttribute("value").trim(), testData);
		Assert.assertTrue(asserRemoveCopiedItem(testData),
				"copied item was unable to delete, please delete it manualy");
		return this;
	}

	private boolean asserRemoveCopiedItem(String testData) throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (getDriver().findElement(By.xpath("//input[@title='Delete Item']")).isDisplayed()) {
				getDriver().findElement(By.xpath("//input[@title='Delete Item']")).click();
				;
				waiting.explicitWaitForAlert(6);
				tu.alertAccept();
				Thread.sleep(2500);
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}