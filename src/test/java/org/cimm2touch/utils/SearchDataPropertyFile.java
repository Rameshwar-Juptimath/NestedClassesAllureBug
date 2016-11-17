package org.cimm2touch.utils;

import org.framework.maincontroller.MainController;
import org.framework.utils.PropertyFileReader;

public class SearchDataPropertyFile extends MainController
{
	
	
	

	private String userName = PropertyFileReader.propertiesReader(searchData, "userName");

	private String getactionlabel = PropertyFileReader.propertiesReader(searchData, "actionlabel");

	private String userNameVadirajTest = PropertyFileReader.propertiesReader(searchData, "userNameVadirajTest");

	private String passwordVadirajTest = PropertyFileReader.propertiesReader(searchData, "passwordVadirajTest");

	private String getslNolabel = PropertyFileReader.propertiesReader(searchData, "slNolabel");

	private String getsubsetIdlabel = PropertyFileReader.propertiesReader(searchData, "subsetIdlabel");

	private String getsubsetNamelabel = PropertyFileReader.propertiesReader(searchData, "subsetNamelabel");

	private String getsubsetdescriptionlabel = PropertyFileReader.propertiesReader(searchData, "subsetdescriptionlabel");

	private String getPurposelabel = PropertyFileReader.propertiesReader(searchData, "Purposelabel");

	private String getStatuslabel = PropertyFileReader.propertiesReader(searchData, "Statuslabel");

	private String getsubsetNamedata = PropertyFileReader.propertiesReader(searchData, "subsetName");

	private String SubsetFormLabel = PropertyFileReader.propertiesReader(searchData, "SubsetFormLabel");

	private String SubsetDescription = PropertyFileReader.propertiesReader(searchData, "SubsetDescription");

	private String purpose = PropertyFileReader.propertiesReader(searchData, "purpose");

	private String subsetstatus = PropertyFileReader.propertiesReader(searchData, "status");

	private String Subsetsuccessmessage = PropertyFileReader.propertiesReader(searchData, "Subsetsuccessmessage");

	private String SubsetsearchErrorMsg = PropertyFileReader.propertiesReader(searchData, "SubsetsearchErrorMsg");

	private String subsetNameinvalid = PropertyFileReader.propertiesReader(searchData, "subsetNameinvalid");

	private String subsetformfildbannerText = PropertyFileReader.propertiesReader(searchData, "subsetformfildbannerText");

	private String subsetrequiredmsg = PropertyFileReader.propertiesReader(searchData, "subsetrequiredmsg");

	private String UpdateSubsetDescription = PropertyFileReader.propertiesReader(searchData, "UpdateSubsetDescription");

	private String SubsetUpdatemsg = PropertyFileReader.propertiesReader(searchData, "SubsetUpdatemsg");

	private String manufacturername = PropertyFileReader.propertiesReader(searchData, "manufacturername");

	private String manufacturername1 = PropertyFileReader.propertiesReader(searchData, "manufacturername1");

	private String brandName = PropertyFileReader.propertiesReader(searchData, "brandName");

	private String manufacturerSuccessmessage = PropertyFileReader.propertiesReader(searchData, "manufacturerSuccessmessage");

	private String brandDesc = PropertyFileReader.propertiesReader(searchData, "brandDesc");

	private String brandsavemsg = PropertyFileReader.propertiesReader(searchData, "brandsavemsg");

	private String emailRequiredErrorMessage = PropertyFileReader.propertiesReader(searchData, "emailRequiredErrorMessage");

	private String dynamicSettingsTableHeadings = PropertyFileReader.propertiesReader(searchData, "dynamicSettingsTableHeadings");

	private String dynamicSettingsTableFieldNames = PropertyFileReader.propertiesReader(searchData, "dynamicSettingsTableFieldNames");

	private String dynamicSettingsTableDisplayNames = PropertyFileReader.propertiesReader(searchData, "dynamicSettingsTableDisplayNames");

	private String welcomeMessage = "Welcome, "+getUserName()+" !";

	private String welcomeMessagevadi = "Welcome, "+getUserNameVadirajTest()+" !";

	private String searchCategory = PropertyFileReader.propertiesReader(searchData, "searchCategory");

	private String attributesInRightNavigationBarOfAddNewItemsPage = PropertyFileReader.propertiesReader(searchData, "attributesInRightNavigationBarOfAddNewItemsPage");

	private String allMandatoryFieldsInAddNewItemsPage = PropertyFileReader.propertiesReader(searchData, "allMandatoryFieldsInAddNewItemsPage");

	private String allNonMandatoryFieldsInAddNewItemsPage = PropertyFileReader.propertiesReader(searchData, "allNonMandatoryFieldsInAddNewItemsPage");

	private String errorMessageAddNewItem = PropertyFileReader.propertiesReader(searchData, "errorMessageAddNewItem");

	private String checkboxesInAddNewItemsPage = PropertyFileReader.propertiesReader(searchData, "checkboxesInAddNewItemsPage");

	private String exepectedSearchInDropdownValues = PropertyFileReader.propertiesReader(searchData, "exepectedSearchInDropdownValues");

	private String alertTextWhenHistoryIsClicked = PropertyFileReader.propertiesReader(searchData, "alertTextWhenHistoryIsClicked");

	private String alertTextWhenRemoveAttributeIsClicked = PropertyFileReader.propertiesReader(searchData, "alertTextWhenRemoveAttributeIsClicked");

	private String alertTextWhenRemoveAttributeGroupIsClicked = PropertyFileReader.propertiesReader(searchData, "alertTextWhenRemoveAttributeGroupIsClicked");

	private String expectedHistoryPageTitle = PropertyFileReader.propertiesReader(searchData, "expectedHistoryPageTitle");

	private String expectedAttributesHistoryPageTitle = PropertyFileReader.propertiesReader(searchData, "expectedAttributesHistoryPageTitle");

	private String expectedAttributeGroupHistoryPageTitle = PropertyFileReader.propertiesReader(searchData, "expectedAttributeGroupHistoryPageTitle");

	private String brandDropDownValue = PropertyFileReader.propertiesReader(searchData, "brandDropDownValue");

	private String itemSavedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "itemSavedSuccessfulMessage");

	private String manufacturerDropdownValue = PropertyFileReader.propertiesReader(searchData, "manufacturerDropdownValue");

	private String partNumberField = PropertyFileReader.propertiesReader(searchData, "partNumberField");

	private String taxonomyTableHeaders = PropertyFileReader.propertiesReader(searchData, "taxonomyTableHeaders");

	private String searchTaxonomy = PropertyFileReader.propertiesReader(searchData, "taxonomy");

	private String inavalidTaxonomyName = PropertyFileReader.propertiesReader(searchData, "invalidtaxonomy");

	private String taxonomyDescription=PropertyFileReader.propertiesReader(searchData, "taxonomydesciption");

	private String errormessage=PropertyFileReader.propertiesReader(searchData, "taxonomyerrormessage");

	private String taxonomyname=PropertyFileReader.propertiesReader(searchData, "taxonomyName");

	private String taxonomyerr=PropertyFileReader.propertiesReader(searchData, "texonomyerror");

	private String Morethathirtycharacters=PropertyFileReader.propertiesReader(searchData, "characters");

	private String morethanfivehundred=PropertyFileReader.propertiesReader(searchData, "fivehundredcharacters");

	private String taxonomyheaders=PropertyFileReader.propertiesReader(searchData, "taxonomyheaders");

	private String searchCategory1 = PropertyFileReader.propertiesReader(searchData, "tsearchCategory");

	private String allFieldsAddNewProductsPage = PropertyFileReader.propertiesReader(searchData, "allFieldsAddNewProductsPage");

	private String updateProductName = PropertyFileReader.propertiesReader(searchData, "updateProductName");

	private String textToBeEnterInTheProductDescription1Textbox = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInTheProductDescription1Textbox");

	private String textToBeEnterInTheProductDescription2Textbox = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInTheProductDescription2Textbox");

	private String textToBeEnterInTheProductFeaturesTextbox = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInTheProductFeaturesTextbox");

	private String textToBeEnterInTheProductMarketingDescriptionTextbox = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInTheProductMarketingDescriptionTextbox");

	private String textToBeEnterInTheProductCustomKeywordsTextbox = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInTheProductCustomKeywordsTextbox");

	private String poductSavedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "poductSavedSuccessfulMessage");

	private String metaKeywordText = PropertyFileReader.propertiesReader(searchData, "metaKeywordText");

	private String partNumberForCreationOfNewItem = PropertyFileReader.propertiesReader(searchData, "partNumberForCreationOfNewItem");

	private String manufacturerForCreationOfNewItem = PropertyFileReader.propertiesReader(searchData, "manufacturerForCreationOfNewItem");

	private String brandForCreationOfNewItem = PropertyFileReader.propertiesReader(searchData, "brandForCreationOfNewItem");

	private String successMessageOfCreationOfNewItem = PropertyFileReader.propertiesReader(searchData, "successMessageOfCreationOfNewItem");

	private String cpnTextEnter = PropertyFileReader.propertiesReader(searchData, "cpnTextEnter");

	private String cpnNumberEnter = PropertyFileReader.propertiesReader(searchData, "cpnNumberEnter");

	private String successMessageOfCreationOfNewCpn = PropertyFileReader.propertiesReader(searchData, "successMessageOfCreationOfNewCpn");

	private String unsuccessfullMessageOfManufacturerSave = PropertyFileReader.propertiesReader(searchData, "unsuccessfullMessageOfManufacturerSave");

	private String manufacturerNewName = PropertyFileReader.propertiesReader(searchData, "manufacturerNewName");

	private String createdManufacturerToDelete = PropertyFileReader.propertiesReader(searchData, "createdManufacturerToDelete");

	private String alertTextToDeleteManufacturer = PropertyFileReader.propertiesReader(searchData, "alertTextToDeleteManufacturer");

	private String subsetsuccessmsg = PropertyFileReader.propertiesReader(searchData, "subsetsuccessmsg");

	private String selectAction = PropertyFileReader.propertiesReader(searchData, "SelectAction");

	private String SelectEntityName = PropertyFileReader.propertiesReader(searchData, "SelectEntityName");

	private String SelectEntityType = PropertyFileReader.propertiesReader(searchData, "SelectEntityType");

	private String SubsetRuleSaveMsg = PropertyFileReader.propertiesReader(searchData, "SubsetRuleSaveMsg");

	private String subsetdisplayepricing = PropertyFileReader.propertiesReader(searchData, "subsetdisplayepricing");

	private String DiasplyPriceSucessMsg = PropertyFileReader.propertiesReader(searchData, "DiasplyPriceSucessMsg");

	private String workbookname = PropertyFileReader.propertiesReader(searchData, "workbookname");

	private String WorkbookSuccessmsg = PropertyFileReader.propertiesReader(searchData, "WorkbookSuccessmsg");

	private String workbookRemovemsg = PropertyFileReader.propertiesReader(searchData, "workbookRemovemsg");

	private String workbookexistingmsg = PropertyFileReader.propertiesReader(searchData, "workbookexistingmsg");

	private String manufacturerPartNumber = PropertyFileReader.propertiesReader(searchData, "manufacturerPartNumber");

	private String listPrice = PropertyFileReader.propertiesReader(searchData, "listPrice");

	private String costPrice = PropertyFileReader.propertiesReader(searchData, "costPrice");

	private String userrating = PropertyFileReader.propertiesReader(searchData, "userrating");

	private String Hits = PropertyFileReader.propertiesReader(searchData, "Hits");

	private String Popularity = PropertyFileReader.propertiesReader(searchData, "Popularity");

	private String additemWorkbooksuccessmsg = PropertyFileReader.propertiesReader(searchData, "additemWorkbooksuccessmsg");

	private String workbookitemcount = PropertyFileReader.propertiesReader(searchData, "workbookitemcount");

	private String workbookerrormsg = PropertyFileReader.propertiesReader(searchData, "workbookerrormsg");

	private String WorkbookPopupMsg = PropertyFileReader.propertiesReader(searchData, "WorkbookPopupMsg");

	private String updatepartnumber = PropertyFileReader.propertiesReader(searchData, "updatepartnumber");

	private String ItemUpdateMSG = PropertyFileReader.propertiesReader(searchData, "ItemUpdateMSG");

	private String ItemKeywordsHistorypagetitle = PropertyFileReader.propertiesReader(searchData, "ItemKeywordsHistorypagetitle");

	private String customKeyword = PropertyFileReader.propertiesReader(searchData, "customKeyword");

	private String documentcategory = PropertyFileReader.propertiesReader(searchData, "documentcategory");

	private String documentCaption = PropertyFileReader.propertiesReader(searchData, "documentCaption");

	private String documentURL = PropertyFileReader.propertiesReader(searchData, "documentURL");

	private String documentSuccessmsg = PropertyFileReader.propertiesReader(searchData, "documentSuccessmsg");

	private String documentremoveMsg = PropertyFileReader.propertiesReader(searchData, "documentremoveMsg");

	private String updateDocumentCaptionMsg = PropertyFileReader.propertiesReader(searchData, "updateDocumentCaptionMsg");

	private String Documentcategoryname = PropertyFileReader.propertiesReader(searchData, "Documentcategoryname");

	private String DocumentCatDescription = PropertyFileReader.propertiesReader(searchData, "DocumentCatDescription");

	private String DocumentCatErrorMsg = PropertyFileReader.propertiesReader(searchData, "DocumentCatErrorMsg");

	private String DocumentRequiredCaptionMsg = PropertyFileReader.propertiesReader(searchData, "DocumentRequiredCaptionMsg");

	private String DocumentRequiredURLMsg = PropertyFileReader.propertiesReader(searchData, "DocumentRequiredURLMsg");

	private String updateddocumentCaption = PropertyFileReader.propertiesReader(searchData, "updateddocumentCaption");

	private String numberOfRecordsToDisplay;

	private String DocumentHistoryPageTitle = PropertyFileReader.propertiesReader(searchData, "DocumentHistoryPageTitle");

	private String videoCaption = PropertyFileReader.propertiesReader(searchData, "videoCaption");

	private String videoURl = PropertyFileReader.propertiesReader(searchData, "videoURl");

	private String videoSaveMsg = PropertyFileReader.propertiesReader(searchData, "videoSaveMsg");

	private String deleteVideoMsg = PropertyFileReader.propertiesReader(searchData, "deleteVideoMsg");

	private String VideotRemoveMsg = PropertyFileReader.propertiesReader(searchData, "VideotRemoveMsg");

	private String linktypename = PropertyFileReader.propertiesReader(searchData, "linktypename");

	private String linktypedescription = PropertyFileReader.propertiesReader(searchData, "linktypedescription");

	private String linktypeSuccessMsg = PropertyFileReader.propertiesReader(searchData, "linktypeSuccessMsg");

	private String linktypeupdatemsg = PropertyFileReader.propertiesReader(searchData, "linktypeupdatemsg");

	private String linktypeupdatedescription = PropertyFileReader.propertiesReader(searchData, "linktypeupdatedescription");

	private String ItemDesctiptionHistorypagetitle = PropertyFileReader.propertiesReader(searchData, "ItemDesctiptionHistorypagetitle");

	private String productPageBreadCrumbs = PropertyFileReader.propertiesReader(searchData, "productsPageBreadCrumbs");

	private String productName= PropertyFileReader.propertiesReader(searchData, "productName");

	private String productNumber= PropertyFileReader.propertiesReader(searchData, "productNumber");

	private String expectedSuccesfulMessageForNewProductCreation=PropertyFileReader.propertiesReader(searchData, "expectedSuccesfulMessageForNewProductCreation");

	private String expectedSuccessfulMessageAfterDeletionOfProduct=PropertyFileReader.propertiesReader(searchData, "expectedSuccessfulMessageAfterDeletionOfProduct");

	private String expectedSuccessfulMessageAfterAssignItemsToProduct=PropertyFileReader.propertiesReader(searchData, "expectedSuccessfulMessageAfterAssignItemsToProduct");

	private String expectedItemsPageTitle=PropertyFileReader.propertiesReader(searchData, "expectedItemsPageTitle");

	private String expectedItemsTableHeaderTitles[]=PropertyFileReader.propertiesReader(searchData, "expectedItemsTableHeaderTitles").split(",");

	private String ItemPartNumber=PropertyFileReader.propertiesReader(searchData, "ItemPartNumber");

	private String numberOfCopiesForItem=PropertyFileReader.propertiesReader(searchData, "numberOfCopiesForItem");

	private String paginationCount=PropertyFileReader.propertiesReader(searchData, "paginationCount");

	private String taxonomyName=PropertyFileReader.propertiesReader(searchData, "taxonomyName");

	private String categoryName=PropertyFileReader.propertiesReader(searchData, "categoryName");

	private String expSuccessfulMessageAfterCreationOfCategory=PropertyFileReader.propertiesReader(searchData, "expSuccessfulMessageAfterCreationOfCategory");

	private String expAlertMsgCatDel=PropertyFileReader.propertiesReader(searchData, "expAlertMsgCatDel");

	private String expCategoryHistory=PropertyFileReader.propertiesReader(searchData, "expCategoryHistory");

	private String expAttributesListPageHeaders=PropertyFileReader.propertiesReader(searchData, "expAttributesListPageHeaders");

	private String expErrorMessageAttribute=PropertyFileReader.propertiesReader(searchData, "expErrorMessageAttribute");

	private String moreDescription=PropertyFileReader.propertiesReader(searchData, "moreDescription");

	private String expErrorMessagemoreDescrition=PropertyFileReader.propertiesReader(searchData, "errorMessageMoreDescription");

	private String moreAttributeName=PropertyFileReader.propertiesReader(searchData, "moreAttributeName");

	private String successfulMessageForAttributeCreation=PropertyFileReader.propertiesReader(searchData, "successfulMessageForAttributeCreation");

	private String partialAttributeName=PropertyFileReader.propertiesReader(searchData, "partialAttributeName");

	private String manufacturercode = PropertyFileReader.propertiesReader(searchData, "manufacturercode");

	private String brandname = PropertyFileReader.propertiesReader(searchData, "brandname");

	private String branddesc = PropertyFileReader.propertiesReader(searchData, "branddesc");

	private String subsetname=PropertyFileReader.propertiesReader(searchData, "subsetname");

	private String subsetsavemsgexpected=PropertyFileReader.propertiesReader(searchData, "subsetsavemsgexpected");

	private String vendorname=PropertyFileReader.propertiesReader(searchData, "vendorname");

	private String vendorsavemsg=PropertyFileReader.propertiesReader(searchData, "vendorsavemsg");

	private String vendoremailaddress=PropertyFileReader.propertiesReader(searchData, "vendoremailaddress");

	private String vendoraddress=PropertyFileReader.propertiesReader(searchData, "vendoraddress");

	private String vendorshortname=PropertyFileReader.propertiesReader(searchData, "vendorshortname");

	private String itemnametemplate=PropertyFileReader.propertiesReader(searchData, "itemnametemplate");

	private String manufacturernametemplate=PropertyFileReader.propertiesReader(searchData, "manufacturernametemplate");

	private String savenewItemMessage=PropertyFileReader.propertiesReader(searchData, "savenewItemMessage");

	private String Noofitemstobecreated=PropertyFileReader.propertiesReader(searchData, "Noofitemstobecreated");

	private String advSe003searchinput=PropertyFileReader.propertiesReader(searchData, "advSe003searchinput");

	private String advSe004searchinput=PropertyFileReader.propertiesReader(searchData, "advSe004searchinput");

	private String advSe005searchinput=PropertyFileReader.propertiesReader(searchData, "advSe005searchinput");

	private String advSe007searchinput=PropertyFileReader.propertiesReader(searchData, "advSe007searchinput");

	private String advSe008searchinput=PropertyFileReader.propertiesReader(searchData, "advSe008searchinput");

	private String advSe006searchinput=PropertyFileReader.propertiesReader(searchData, "advSe006searchinput");

	private String advSe009searchinput=PropertyFileReader.propertiesReader(searchData, "advSe009searchinput");

	private String advSe010searchinput=PropertyFileReader.propertiesReader(searchData, "advSe010searchinput");

	private String advSe011searchinput=PropertyFileReader.propertiesReader(searchData, "advSe011searchinput");

	private String advSe014searchinput=PropertyFileReader.propertiesReader(searchData, "advSe014searchinput");

	private String advSe015searchinput=PropertyFileReader.propertiesReader(searchData, "advSe015searchinput");

	private String password=PropertyFileReader.propertiesReader(searchData, "passWord");

	private String productPageTabsNames = PropertyFileReader.propertiesReader(searchData, "productPageTabsNames");

	private String fieldNamesInGeneralInfoTab = PropertyFileReader.propertiesReader(searchData, "fieldNamesInGeneralInfoTab");

	private String fieldNamesInProductImagesTab = PropertyFileReader.propertiesReader(searchData, "fieldNamesInProductImagesTab");

	private String fieldNamesInAddNewProductImage = PropertyFileReader.propertiesReader(searchData, "fieldNamesInAddNewProductImage");

	private String productUpdateSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "productUpdateSuccessfulMessage");

	private String editProductName = PropertyFileReader.propertiesReader(searchData, "editProductName");

	private String textToBeEnterInImageDesc = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInImageDesc");

	private String textToBeEnterInProductImageURL = PropertyFileReader.propertiesReader(searchData, "textToBeEnterInProductImageURL");

	private String imageURLSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "imageURLSuccessfulMessage");

	private String productRemovedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "productRemovedSuccessfulMessage");

	private String fileLocation = PropertyFileReader.propertiesReader(searchData, "fileLocation");

	private String breadcrumpsList = PropertyFileReader.propertiesReader(searchData, "breadcrumpsList");

	private String attributeName = PropertyFileReader.propertiesReader(searchData, "attributeName");

	private String invalidAttributeGroupName = PropertyFileReader.propertiesReader(searchData, "invalidAttributeGroupName");

	private String noResultsFoundErrorMessage = PropertyFileReader.propertiesReader(searchData, "noResultsFoundErrorMessage");

	private String attributeDescription = PropertyFileReader.propertiesReader(searchData, "attributeDescription");

	private String attributeSavedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeSavedSuccessfulMessage");

	private String editAttributeName = PropertyFileReader.propertiesReader(searchData, "editAttributeName");

	private String updateAttributeName = PropertyFileReader.propertiesReader(searchData, "updateAttributeName");

	private String attributeUpdateSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeUpdateSuccessfulMessage");

	private String attributeRemovedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeRemovedSuccessfulMessage");

	private String attributeGroupRemovedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeGroupRemovedSuccessfulMessage");

	private String attributeGroupName = PropertyFileReader.propertiesReader(searchData, "attributeGroupName");

	private String editAttributeGroupName = PropertyFileReader.propertiesReader(searchData, "editAttributeGroupName");

	private String updateAttributeGroupName = PropertyFileReader.propertiesReader(searchData, "updateAttributeGroupName");

	private String attributeGroupDescription = PropertyFileReader.propertiesReader(searchData, "attributeGroupDescription");

	private String attributeGroupSavedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeGroupSavedSuccessfulMessage");

	private String attributeGroupUpdateSavedSuccessfulMessage = PropertyFileReader.propertiesReader(searchData, "attributeGroupUpdateSavedSuccessfulMessage");

	private String attributeGroupNameRequiredMessage = PropertyFileReader.propertiesReader(searchData, "attributeGroupNameRequiredMessage");

	private String fieldNamesInAddNewAttributeGroup = PropertyFileReader.propertiesReader(searchData, "fieldNamesInAddNewAttributeGroup");

	private String fieldNamesInAddNewAttribute = PropertyFileReader.propertiesReader(searchData, "fieldNamesInAddNewAttribute");

	public String categoryDescription=PropertyFileReader.propertiesReader(searchData, "categoryDescription");

	public String categorySequence=PropertyFileReader.propertiesReader(searchData, "categorySequence");

	public String categoryfields=PropertyFileReader.propertiesReader(searchData, "categoryfields");

	public String CategorySavedSuccessfulMessage=PropertyFileReader.propertiesReader(searchData, "CategorySavedSuccessfulMessage");

	public String Alphanumericcharacters=PropertyFileReader.propertiesReader(searchData, "Alphanumericcharacters"); 

	public String moreThan100Characters=PropertyFileReader.propertiesReader(searchData, "moreThan100Characters");

	public String ErrorMessageAfterClickingSaveButton=PropertyFileReader.propertiesReader(searchData, "ErrorMessageAfterClickingSaveButton");

	public String categoryCode=PropertyFileReader.propertiesReader(searchData, "categoryCode");

	public String NumaricCharacters=PropertyFileReader.propertiesReader(searchData, "NumaricCharacters");
	
	private String longDescription1 = PropertyFileReader.propertiesReader(searchData, "longDescription1");
	
	private String longDescription2 = PropertyFileReader.propertiesReader(searchData, "longDescription2");
	
	private String imageURL = PropertyFileReader.propertiesReader(searchData, "imageURL");
	
	private String documentLocation = PropertyFileReader.propertiesReader(searchData, "documentUpload");


	public String getdocumentLocation()
	{
		return documentLocation;
	}
	
	public String getLongDescription1()
	{
		return longDescription1;
	}

	public String getLongDescription2()
	{
		return longDescription2;
	}

	public String getImageURL()
	{
		return imageURL;
	}
	

	public String getItemUpdateMSG()
	{
		return ItemUpdateMSG;
	}

	public String getWorkbookPopupMsg(){
		return WorkbookPopupMsg;
	}

	public String getworkbookerrormsg(){
		return workbookerrormsg;
	}

	public String getworkbookitemcount(){
		return workbookitemcount;
	}

	public String getadditemWorkbooksuccessmsg(){
		return additemWorkbooksuccessmsg;
	}

	public String getuserrating(){
		return userrating;
	}

	public String getHits(){
		return Hits;
	}

	public String getPopularity(){
		return Popularity;
	}

	public String getlistPrice(){
		return listPrice;
	}

	public String getcostPrice(){
		return costPrice;
	}

	public String getmanufacturerPartNumber(){
		return manufacturerPartNumber;
	}

	public String getworkbookexistingmsg(){
		return workbookexistingmsg;
	}

	public String getworkbookRemovemsg(){
		return workbookRemovemsg;
	}


	public String getWorkbookSuccessmsg(){
		return WorkbookSuccessmsg;
	}

	public String getworkbookname(){
		return workbookname;
	}

	public String getSubsetUpdatemsg(){
		return SubsetUpdatemsg;
	}

	public String getUpdateSubsetDescription(){
		return UpdateSubsetDescription;
	}

	public String getsubsetRequiredMsg(){
		return subsetrequiredmsg;
	}

	public String getubsetformfildbannerText(){
		return subsetformfildbannerText;
	}

	public String getSubsetSuccessmsg() throws Exception{

		return subsetsuccessmsg ;
	}

	public String getsubsetNameinvalid(){
		return subsetNameinvalid;
	}

	public String getSubsetsearchErrorMsg(){
		return SubsetsearchErrorMsg;
	}

	public String getwelcomeMessagevadi(){
		return welcomeMessagevadi;
	}


	public String getlinktypeupdatedescription(){
		return linktypeupdatedescription;
	}


	public String getlinktypeupdatemsg(){
		return linktypeupdatemsg;
	}



	public String getlinktypeSuccessMsg(){
		return linktypeSuccessMsg;
	}



	public String getlinktypedescription(){
		return linktypedescription;
	}


	public String getlinktypename(){
		return linktypename;
	}

	public String getVideotRemoveMsg(){
		return VideotRemoveMsg;
	}
	public String getdeleteVideoMsg(){
		return deleteVideoMsg;
	}


	public String getvideoSaveMsg(){
		return videoSaveMsg;
	}

	public String getvideoURl(){
		return videoURl;
	}

	public String getvideoCaption(){
		return videoCaption;
	}

	public String getDocumentHistoryPageTitle(){
		return DocumentHistoryPageTitle;
	}	
	public String getDocumentRequiredURLMsg(){
		return DocumentRequiredURLMsg;
	}	

	public String getDocumentRequiredCaptionMsg(){
		return DocumentRequiredCaptionMsg;
	}

	public String getDocumentCatErrorMsg(){
		return DocumentCatErrorMsg;
	}

	public String getDocumentCatDescription(){
		return DocumentCatDescription;
	}

	public String getDocumentcategoryname(){
		return Documentcategoryname;
	}
	public String getupdateDocumentCaptionMsg(){
		return updateDocumentCaptionMsg;
	}

	public String getupdateddocumentCaption(){
		return updateddocumentCaption;
	}

	public String getdocumentremoveMsg(){
		return documentremoveMsg;
	}

	public String getdocumentSuccessmsg(){
		return documentSuccessmsg;
	}

	public String getdocumentURL(){
		return documentURL;
	}

	public String getdocumentCaption(){
		return documentCaption;
	}

	public String getdocumentcategory(){
		return documentcategory;
	}

	public String getItemKeywordsHistorypagetitle(){
		return ItemKeywordsHistorypagetitle;
	}

	public String getcustomKeyword(){
		return customKeyword;
	}

	public String getItemDesctiptionHistorypagetitle(){
		return ItemDesctiptionHistorypagetitle;
	}

	public String getSubsetsuccessmessage(){
		return Subsetsuccessmessage;
	}

	public String getSelectAction() throws Exception{

		return selectAction ;
	}

	public String getSubsetRuleSaveMsg() throws Exception{

		return SubsetRuleSaveMsg;
	}

	public String getsubsetstatus(){
		return subsetstatus;
	}

	public String getpurpose(){
		return purpose;
	}

	public String getSubsetDescription(){
		return SubsetDescription;
	}

	public String getSubsetFormLabel(){
		return SubsetFormLabel;
	}

	public String getDiasplyPriceSucessMsg() throws Exception{

		return DiasplyPriceSucessMsg;
	}

	public String getsubsetNamedata(){
		return getsubsetNamedata;
	}

	public String getSelectEntityName() throws Exception{

		return SelectEntityName;
	}

	public String getSelectEntityType() throws Exception{

		return SelectEntityType;
	}

	public String getsubsetdisplayepricing() throws Exception{

		return subsetdisplayepricing;
	}
	public String getmanufacturername1() throws Exception{

		return manufacturername1;
	}


	public void setTheNumberofRecordsToDisplay(String numberOfRecordsToDisplay) {
		this.numberOfRecordsToDisplay = numberOfRecordsToDisplay;

	}

	public String getwelcomeMessage(){
		return welcomeMessage;
	}

	public String getactionlabel() {
		return getactionlabel;
	}

	public String getslnolabel() {

		return getslNolabel;
	}
	private String SortFieldName = PropertyFileReader.propertiesReader(searchData, "SortFieldName");

	private String DescendingOrderText = PropertyFileReader.propertiesReader(searchData, "DescendingOrderText");

	public String getBrnadName(){
		return brandName;
	}

	public String getmanufacturerSuccessmessage(){
		return manufacturerSuccessmessage;
	}

	public String getbrandDesc(){
		return brandDesc;
	}

	public String getbrandsavemsg(){
		return brandsavemsg;
	}

	public String getsubsetIdlabel() {

		return getsubsetIdlabel;
	}
	public String getsubsetNamelabel() {

		return getsubsetNamelabel;
	}
	public String getsubsetdescriptionlabel() {

		return getsubsetdescriptionlabel;
	}
	public String getPurposelabel() {
		return getPurposelabel;
	}
	public String getStatuslabel() {

		return getStatuslabel;
	}
	public String getmanufacturername() {

		return manufacturername;
	}

	public String getExpectedSuccessfulMessageAfterDeletionOfProduct(){
		return expectedSuccessfulMessageAfterDeletionOfProduct;

	}

	public String getNewProductCreationSuccesfulMessage(){

		return expectedSuccesfulMessageForNewProductCreation;

	}



	public String getProductName() {

		return productName;
	}
	public String getProductNumber() {

		return productNumber;
	}
	public String getProductsPageBreadCrumbs(){

		return productPageBreadCrumbs;

	}



	public String getImageFilePath() {

		return fileLocation;
	}

	private String selectValue;

	public String getUserNameVadirajTest(){
		return userNameVadirajTest;
	}

	public String getPasswordVadirajTest(){
		return passwordVadirajTest;
	}

	public String manufacturerSuccessmessage(){
		return manufacturerSuccessmessage;
	}

	public String manufacturername() {
		return manufacturername;
	}

	public String manufacturercode() {
		return manufacturercode;
	}






	public String getBreadcrumpsList() {

		return breadcrumpsList;
	}



	public String getAlertTextWhenRemoveAttributeIsClicked() {	
		return alertTextWhenRemoveAttributeIsClicked;
	}

	public String getAlertTextWhenRemoveAttributeGroupIsClicked() {	
		return alertTextWhenRemoveAttributeGroupIsClicked;
	}




	public String getExpectedAttributeHistoryPageTitle() {	
		return expectedAttributesHistoryPageTitle;
	}

	public String getExpectedAttributeGroupHistoryPageTitle() {	
		return expectedAttributeGroupHistoryPageTitle;
	}




	public String getAllFieldsAddNewProductsPage() {

		return allFieldsAddNewProductsPage;
	}

	public String getProductNameField() {

		return productName;
	}

	public String getUpdateProductNameField() {

		return updateProductName;
	}

	public String getProductNumberField() {

		return productNumber;
	}

	public String getProductDescription1Field() {

		return textToBeEnterInTheProductDescription1Textbox;
	}

	public String getProductDescription2Field() {

		return textToBeEnterInTheProductDescription2Textbox;
	}

	public String getProductFeaturesField() {

		return textToBeEnterInTheProductFeaturesTextbox;
	}

	public String getProductMarketingDescriptionField() {

		return textToBeEnterInTheProductMarketingDescriptionTextbox;
	}

	public String getProductCustomKeywordsField() {

		return textToBeEnterInTheProductCustomKeywordsTextbox;
	}

	public String getProductSavedSuccessfulMessage() {

		return poductSavedSuccessfulMessage ;
	}



	public String getMetaKeywordText() {

		return metaKeywordText;
	}

	public String getPartNumberForCreationOfNewItem() {
		return partNumberForCreationOfNewItem;
	}

	public String getManufacturerForCreationOfNewItem() {

		return manufacturerForCreationOfNewItem;
	}

	public String getBrandForCreationOfNewItem() {
		return brandForCreationOfNewItem;
	}

	public String getSuccessMessageOfCreationOfNewItem() {

		return successMessageOfCreationOfNewItem;
	}

	public String getCpnText() {

		return cpnTextEnter;
	}

	public String getCpnNumber() {
		return cpnNumberEnter;
	}

	public String getsuccessMessageOfCreationOfNewCpn() {
		return successMessageOfCreationOfNewCpn;
	}

	public String getunsuccessfullMessageOfManufacturerSave() {

		return unsuccessfullMessageOfManufacturerSave;
	}

	public String getmanufacturerNewName(){
		return manufacturerNewName;
	}

	public String getcreatedManufacturerToDelete(){
		return createdManufacturerToDelete;
	}

	public String getAlertTextToDeleteManufacturer() {
		return alertTextToDeleteManufacturer;
	}


	public String getupdatepartnumber() {
		return updatepartnumber;
	}

	public String getExpectedSuccessfulMessageAfterAssignItemsToProduct() {

		return expectedSuccessfulMessageAfterAssignItemsToProduct;
	}

	public String getExpectedItemsPageTitle() {

		return expectedItemsPageTitle;
	}

	public String[] getExpectedItemsTableHeaderTitles() {

		return expectedItemsTableHeaderTitles;
	}

	public String getItemPartNumber() {

		return ItemPartNumber;
	}

	public String getNumberOfCopiesForItem() {

		return numberOfCopiesForItem;
	}

	public String getPaginationCount() {

		return paginationCount;
	}

	public String getTaxonomyName() {

		return taxonomyName;
	}


	public String expSuccesfulMessageForCate() {

		return expSuccessfulMessageAfterCreationOfCategory;
	}







	public String getexpAlertTextForCatDel() {

		return expAlertMsgCatDel;
	}

	public String getExpectedHistoryPageTitleForCategory() {

		return expCategoryHistory;
	}

	public String expectedAttributsTableHeaders() {

		return expAttributesListPageHeaders;
	}

	public String getAttributeName() {

		return attributeName;
	}

	public String getSortFieldName() {
		return SortFieldName;
	}

	public String getDescendingOrderText() {
		return DescendingOrderText;
	}


	public String getProductPageTabsNames() {

		return productPageTabsNames;
	}

	public String getFieldNamesInGeneralInfoTab() {

		return fieldNamesInGeneralInfoTab;
	}

	public String getFieldNamesInProductImagesTab() {

		return fieldNamesInProductImagesTab;
	}

	public String getFieldNamesInAddNewProductImage() {

		return fieldNamesInAddNewProductImage;
	}

	public String getProductUpdateSuccessfulMessage() {
		return productUpdateSuccessfulMessage ;
	}

	public String getEditProductNameField() {
		return editProductName;
	}	    

	public String getImageDescField() {
		return textToBeEnterInImageDesc;
	}

	public String getProductImageURLField() {	
		return textToBeEnterInProductImageURL;
	}

	public String getimageURLSuccessfulMessage() {
		return imageURLSuccessfulMessage;
	}

	public String getProductremoveSuccessfulMessage() {	
		return productRemovedSuccessfulMessage;
	}

	public String getAttributeNameField() {
		return attributeName;
	}

	public String getAttributeDescriptionField() {
		return attributeDescription;
	}

	public String getAttributeSavedSuccessfulMessage() {
		return attributeSavedSuccessfulMessage ;
	}

	public String getEditAttributeNameField() {
		return editAttributeName;
	}

	public String getUpdateAttributeNameField() {
		return updateAttributeName;
	}

	public String getAttributeUpdateSuccessfulMessage() {
		return attributeUpdateSuccessfulMessage ;
	}

	public String getAttributetRemoveSuccessfulMessage() {	
		return attributeRemovedSuccessfulMessage;
	}

	public String getAttributeGroupRemoveSuccessfulMessage() {	
		return attributeGroupRemovedSuccessfulMessage;
	}

	public String getAttributeGroupNameField() {
		return attributeGroupName;
	}

	public String getEditAttributeGroupNameField() {
		return editAttributeGroupName;
	}

	public String getUpdateAttributeGroupNameField() {
		return updateAttributeGroupName;
	}

	public String getAttributeGroupDescriptionField() {
		return attributeGroupDescription;
	}

	public String getAttributeGroupSavedSuccessfulMessage() {
		return attributeGroupSavedSuccessfulMessage ;
	}

	public String getAttributeGroupUpdateSuccessfulMessage() {
		return attributeGroupUpdateSavedSuccessfulMessage ;
	}

	public String getAttributeGroupNameRequiredMessage() {
		return attributeGroupNameRequiredMessage ;
	}

	public String getFieldNamesInAddNewAttributeGroup() {
		return fieldNamesInAddNewAttributeGroup ;
	}

	public String getFieldNamesInAddNewAttribute() {
		return fieldNamesInAddNewAttribute ;
	}

	public String getInvalidAttributeGroupName() {
		return invalidAttributeGroupName;
	}

	public String getNoResultsFoundMessage() {
		return noResultsFoundErrorMessage ;
	}



	public String getAttributeDescription() {

		return attributeDescription;
	}

	public String expErrorMessage() {

		return expErrorMessageAttribute;
	}

	public String getAttributeDescriptionMoreText() {

		return moreDescription;
	}

	public String expErrorMessageIfDesc() {

		return expErrorMessagemoreDescrition;
	}

	public String getAttributeNameMoreThan50Chars() {

		return moreAttributeName;
	}

	public String getSuccessfulMessageAfterCreationAttribute() {

		return successfulMessageForAttributeCreation;
	}

	public String getAttributeNameMoreThan50CharsPartial() {

		return partialAttributeName;
	}

	public String brandname() {

		return brandname;
	}

	public String branddesc() {

		return branddesc;
	}

	public String brandsavemsg() {

		return brandsavemsg;
	}

	public String subsetname() {

		return subsetname;
	}

	public String subsetsavemsgexpected() {

		return subsetsavemsgexpected;
	}

	public String vendorname() {

		return vendorname;
	}

	public String vendorsavemsg() {

		return vendorsavemsg;
	}

	public String vendoremailaddress() {

		return vendoremailaddress;
	}

	public String vendoraddress() {

		return vendoraddress;
	}

	public String vendorshortname() {

		return vendorshortname;
	}

	public String itemnametemplate() {

		return itemnametemplate;
	}

	public String manufacturernametemplate() {

		return manufacturernametemplate;
	}

	public String savenewItemMessage() {

		return savenewItemMessage;
	}

	public String Noofitemstobecreated() {

		return Noofitemstobecreated;
	}

	public String advSe003searchinput() {

		return advSe003searchinput;
	}

	public String advSe004searchinput() {

		return advSe004searchinput;
	}

	public String advSe005searchinput() {

		return advSe005searchinput;
	}

	public String advSe007searchinput() {

		return advSe007searchinput;
	}

	public String advSe008searchinput() {

		return advSe008searchinput;
	}

	public String advSe006searchinput() {

		return advSe006searchinput;
	}

	public String advSe009searchinput() {

		return advSe009searchinput;
	}

	public String advSe010searchinput() {

		return advSe010searchinput;
	}

	public String advSe011searchinput() {

		return advSe011searchinput;
	}

	public String advSe014searchinput() {

		return advSe014searchinput;
	}

	public String advSe015searchinput() {

		return advSe015searchinput;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;

	}

	public String getSelectValue() {

		return selectValue;
	}

	public String getPassword() {

		return password;
	}



	public String getUserName() {

		return userName;
	}
	public String geinavalidTaxonomyName() {

		return inavalidTaxonomyName;
	}



	public String getsearchCategory1() {

		return searchCategory1;
	}

	public String getWelcomeMessage(){
		return welcomeMessage;
	}
	public String getVerifyEmailRequiredErrorMessage() {

		return emailRequiredErrorMessage;
	}

	public void setNumberOfRecordsToDisplay(String numberOfRecordsToDisplay) {
		this.numberOfRecordsToDisplay = numberOfRecordsToDisplay;

	}

	public String getNumberOfRecordsToDisplay() {
		return numberOfRecordsToDisplay;
	}


	public String getDynamicSettingsTableHeadings(){
		return dynamicSettingsTableHeadings;
	}

	public String getDynamicSettingsTableFieldNames() {

		return dynamicSettingsTableFieldNames;
	}

	public String getDisplayNamesInDynamicSettingsTableLocator() {

		return dynamicSettingsTableDisplayNames;
	}

	public String getCategoryToSearch() {

		return searchCategory;
	}
	public String getTaxonomyToSearch() {

		return searchTaxonomy;
	}
	public String getAttributesInRightNavigationBarOfAddNewItemsPage() {

		return attributesInRightNavigationBarOfAddNewItemsPage;
	}

	public String getAllMandatoryFieldsInAddNewItemsPage() {
		return allMandatoryFieldsInAddNewItemsPage;
	}

	public String getAllNonMandatoryFieldsInAddNewItemsPage() {

		return allNonMandatoryFieldsInAddNewItemsPage;
	}

	public String getErrorMessageAddNewItem() {

		return errorMessageAddNewItem;
	}

	public String getCheckboxInAddNewItemsPage() {

		return checkboxesInAddNewItemsPage;
	}

	public String getExepectedSearchInDropdownValues() {

		return exepectedSearchInDropdownValues;
	}

	public String getAlertTextWhenHistoryIsClicked() {

		return alertTextWhenHistoryIsClicked;
	}

	public String getExpectedHistoryPageTitle() {

		return expectedHistoryPageTitle;
	}

	public String getPartNumberField() throws Exception {

		return partNumberField;
	}

	public String getManufacturerDropdownValue() throws Exception{

		return manufacturerDropdownValue ;
	}

	public String getBrandDropDownValue() throws Exception{

		return brandDropDownValue ;
	}

	public String getItemSavedSuccessfulMessage() throws Exception{

		return itemSavedSuccessfulMessage ;
	}
	public String getTaxonomyTableHeaders(){

		return taxonomyTableHeaders;
	}

	public String getInavalidTaxonomyName() {

		return inavalidTaxonomyName;
	}
	public String getTaxonomyDescription() {

		return taxonomyDescription;
	}
	public String getErrormessge() {

		return errormessage;
	}
	public String getTaxonomyname() 
	{

		return taxonomyname;
	}
	public String getTaxonomynameerror() {

		return taxonomyerr;
	}
	public String getenteringMorethathirtycharacters() {

		return Morethathirtycharacters;
	}
	public String getenteringMoretha500characters() {

		return morethanfivehundred;
	}
	public String getTaxonomyHeaders() {

		return taxonomyheaders;
	}
	public String getCategoryName() {

		return categoryName;
	}
	public String getcategoryDescription() {

		return categoryDescription;
	}
	public String getcategorySequence() {

		return categorySequence;
	}
	public String getCategoryFields() {

		return categoryfields;
	}
	public String getCategorySavedSuccessfulMessage() {

		return CategorySavedSuccessfulMessage;
	}
	public String getAlphanumericcharacters() {

		return Alphanumericcharacters;
	}
	public String getMoreThan100Characters() {

		return moreThan100Characters;
	}
	public String getErrorMessageAfterClickingSaveButton() {

		return ErrorMessageAfterClickingSaveButton;
	}
	public String getCategoryCode() {

		return  categoryCode;
	}
	public String getNumaricCharacters() {

		return NumaricCharacters;
	}

	private String AttributeValue = PropertyFileReader.propertiesReader(searchData, "AttributeValue");

	public String getAttributeValue(){
		return AttributeValue;
	}

	private String attributegroup = PropertyFileReader.propertiesReader(searchData, "attributegroup");

	public String getattributegroup(){
		return attributegroup;
	}

	private String attributeUOM = PropertyFileReader.propertiesReader(searchData, "attributeUOM");

	public String getattributeUOM(){
		return attributeUOM;
	}

	private String attributesaveMsg = PropertyFileReader.propertiesReader(searchData, "attributesaveMsg");

	public String getattributesaveMsg(){
		return attributesaveMsg;
	}
	private String ItemNetPrice = PropertyFileReader.propertiesReader(searchData, "ItemNetPrice");

	public String getItemNetPrice(){
		return ItemNetPrice;
	}
	private String itemPackDesc = PropertyFileReader.propertiesReader(searchData, "itemPackDesc");

	public String getitemPackDesc(){
		return itemPackDesc;
	}	 
	private String itemUom = PropertyFileReader.propertiesReader(searchData, "itemUom");

	public String getitemUom(){
		return itemUom;
	}
	private String PricePer = PropertyFileReader.propertiesReader(searchData, "PricePer");

	public String getPricePer(){
		return PricePer;
	}
	private String minorderQty = PropertyFileReader.propertiesReader(searchData, "minorderQty");

	public String getminorderQty(){
		return minorderQty;
	}

	private String Qtyinterval = PropertyFileReader.propertiesReader(searchData, "Qtyinterval");

	public String getQtyinterval(){
		return Qtyinterval;
	}

	private String Unspsc = PropertyFileReader.propertiesReader(searchData, "Unspsc");

	public String getUnspsc(){
		return Unspsc;
	}

	private String CPN = PropertyFileReader.propertiesReader(searchData, "CPN");

	public String getCPN(){
		return CPN;
	}

	private String MaterialGroup = PropertyFileReader.propertiesReader(searchData, "MaterialGroup");

	public String getMaterialGroup(){
		return MaterialGroup;
	}

	private String MaterialNumber = PropertyFileReader.propertiesReader(searchData, "MaterialNumber");

	public String getMaterialNumber(){
		return MaterialNumber;
	}
	private String ItemStatus = PropertyFileReader.propertiesReader(searchData, "ItemStatus");

	public String getItemStatus()
	{
		return ItemStatus;
	}

	private String CPHistoryTitle = PropertyFileReader.propertiesReader(searchData, "CPHistoryTitle");

	public String getCPHistoryTitle(){
		return CPHistoryTitle;
	}


}
