package org.cimm2touch.pageobjects.items;
import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.PermittedCharacters;
import org.framework.utils.RandomGenerator;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class AddNewItemPageObjects extends PageFactoryInitializer{

	

	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());
	
	@FindBy(xpath="	//span[contains(text(),'Item saved Successfully')]")
	private WebElement itemSuccesMessageLocator;
	
	@FindBy(xpath="//div[contains(text(),'Manufacturer Part Number')]/following-sibling::div[@class='tabContainerTxtBx']/input")
	private WebElement manufacturerpartnumberLocator;
	
	@FindBy(xpath="//input[@id='generalInfoFormId:lpId']")
	private WebElement listPriceLocator;
	
	@FindBy(xpath="//input[@id='generalInfoFormId:cpId']")
	private WebElement costPriceLocator;
	
	


	@FindBy(xpath="//div[contains(text(),'Data Source')]/following-sibling::div/input")
	private WebElement dataSourceTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'List Price')]/following-sibling::div/input")
	private WebElement listPriceTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Cost Price')]/following-sibling::div/input")
	private WebElement costPriceTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Quantity Available')]/following-sibling::div/input")
	private WebElement quantityAvailableTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Length')]/following-sibling::div/input[1]")
	private WebElement lengthTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Width')]/following-sibling::div/input[1]")
	private WebElement widthTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Height')]/following-sibling::div/input[1]")
	private WebElement heightTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Weight')]/following-sibling::div/input[1]")
	private WebElement weightTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Part Number')]/following-sibling::div/input")
	private WebElement partNumberTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Manufacturer Part Number')]/following-sibling::div/input")
	private WebElement manufacturerPartNumberTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'Competitor Part Number')]/following-sibling::div/input")
	private WebElement competitorPartNumberTextBoxLocator;
	
	@FindBy(xpath="//div[contains(text(),'UPC')]/following-sibling::div/input")
	private WebElement upcTextBoxLocator;

	@FindAll(value={@FindBy(xpath="//td/strong")})
	private List<WebElement> attributesInTheRightNavigationBarLocator;
	
	@FindBy(xpath="//td[contains(text(),'General Info')]")
	private WebElement generalInfoTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Descriptions')]")
	private WebElement descriptionsTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Products')]")
	private WebElement productsTabLocator;

	
	@FindBy(xpath="//td[contains(text(),'Keywords')]")
	private WebElement keywordsTabLocator;
	
	
	@FindBy(xpath="//td[contains(text(),'Documents')]")
	private WebElement documentsTabLocator;
	
	
	@FindBy(xpath="//td[contains(text(),'Images')]")
	private WebElement imagesTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Videos')]")
	private WebElement videosTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Linked Items')]")
	private WebElement linkedItemsTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Attributes')]")
	private WebElement attributesTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Custom Prices')]")
	private WebElement customPricesTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Categorization')]")
	private WebElement categorizationTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Custom Fields')]")
	private WebElement customFieldsTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Warehouse')]")
	private WebElement warehouseTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Customer PartNumber')]")
	private WebElement customerPartNumberTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Blog Link')]")
	private WebElement blogLinkTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'User Review')]")
	private WebElement userReviewTabLocator;
	
	@FindAll(value={@FindBy(xpath="//span[contains(text(),'*')]/ancestor::div[@class='tabContainerLabel']")})
	private List<WebElement> mandatoryFieldsLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='tabContainerLabel' and not(contains(descendant::span,'*')) and text()]")})
	private List<WebElement> nonMandatoryFieldsLocator;
	
	@FindBy(xpath="//input[@title='Save New Item']")
	private WebElement ItemsaveButtonLocator;
	
	@FindBy(xpath="//div[contains(@class,'errorMsg')]/span")
	private List<WebElement> errorMessageLocator;
	
	@FindBy(xpath="//input[@id='generalInfoFormId:brandListComboIdcomboboxField']")
	private WebElement brandLocator;
	
	@FindBy(xpath="//input[@id='generalInfoFormId:manufacturerListComboIdcomboboxField']")
	private WebElement manufacturerNameLocator;
	
	@FindBy(xpath="//div[text()='Item Status']/following-sibling::div/descendant::select/option")
	private WebElement itemStatusOptionsLocator;
	
	
	@FindBy(xpath="//div[text()='Item Status']/following-sibling::div/descendant::select")
	private WebElement itemStatusLocator;
	
	@FindBy(xpath="//li[contains(text(),'Display Online')]/input")
	private WebElement displayOnlineCheckboxLocator;
	
	
	@FindBy(xpath="//li[contains(text(),'Drop Ship')]/input")
	private WebElement dropShipCheckboxLocator;
	
	@FindBy(xpath="//li[contains(text(),'Print')]/input")
	private WebElement printCheckboxLocator;
	
	@FindBy(xpath="//input[@id='generalInfoFormId:manufacturerListComboIdcomboboxButton']")
	private WebElement manufacturerDropDownArrowLocator;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@id,'manufacturerListComboIdlist')]/span")})
	private List<WebElement> manufacturerDropdownValuesLocator;
	
	@FindBy(xpath="(//input[@maxlength='50'])[1]")
	public WebElement enterPartNumberLocator;

	@FindBy(xpath="//input[@id='generalInfoFormId:brandListComboIdcomboboxButton']")
	private WebElement brandDropDownLocator;
	
	@FindAll(@FindBy(xpath="//div[contains(@id,'brandListComboIdlist')]/span"))
	private List<WebElement> brandDropDownValuesLocator;
	
	@FindBy(xpath="//input[@title='Save New Item']")
	private WebElement saveButtonLocator;
	
	@FindBy(xpath="//span[contains(text(),'Item saved Successfully')]")
	private WebElement ItemSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//input[@title='Add New Item']")
	private WebElement addNewItemLocator;
	
	
	
	
	
	public AddNewItemPageObjects verifyItemCreationSuccessMessage(String successMessageOfCreationOfNewItem) {
		
		Assert.assertEquals(itemSuccesMessageLocator.getText().trim(), "Item saved Successfully");
		return this;
	}

	 @Step("verify whether general info tab is enabled and others are enabled.")
		public AddNewItemPageObjects verifyEnableTabsOfItemEdit() {

			waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 10);
			Assert.assertTrue(generalInfoTabLocator.getAttribute("class").contains("active"),"General info tab is enabled");
			Assert.assertTrue(descriptionsTabLocator.getAttribute("class").contains("active"),"descriptions tab is  enabled");
			Assert.assertTrue(productsTabLocator.getAttribute("class").contains("active"),"products tab is enabled");
			Assert.assertTrue(keywordsTabLocator.getAttribute("class").contains("active"),"Keywords tab is enabled");
			Assert.assertTrue(documentsTabLocator.getAttribute("class").contains("active"),"Documents info tab is enabled");
			Assert.assertTrue(imagesTabLocator.getAttribute("class").contains("active"),"Images tab is  enabled");
			Assert.assertTrue(videosTabLocator.getAttribute("class").contains("active"),"Videos tab is  enabled");
			Assert.assertTrue(linkedItemsTabLocator.getAttribute("class").contains("active"),"Linked Items tab is  enabled");
			Assert.assertTrue(attributesTabLocator.getAttribute("class").contains("active"),"Attributes tab is enabled");
			Assert.assertTrue(customPricesTabLocator.getAttribute("class").contains("active"),"Custom prices tab is enabled");
			Assert.assertTrue(categorizationTabLocator.getAttribute("class").contains("active"),"categorization tab is enabled");
			Assert.assertTrue(customFieldsTabLocator.getAttribute("class").contains("active"),"Custom fields tab is enabled");
			Assert.assertTrue(warehouseTabLocator.getAttribute("class").contains("active"),"Warehouse tab is enabled");
			Assert.assertTrue(customerPartNumberTabLocator.getAttribute("class").contains("active"),"Customer Part number tab is enabled");
			Assert.assertTrue(blogLinkTabLocator.getAttribute("class").contains("active"),"Blog Link info tab is enabled");
			Assert.assertTrue(userReviewTabLocator.getAttribute("class").contains("active"),"User review info tab is enabled");
			return this;
		}

	public AddNewItemPageObjects enterManufactrerPartNumber(String getmanufacturerPartNumber) throws InterruptedException {
		Thread.sleep(2000);
		manufacturerPartNumberTextBoxLocator.sendKeys(getmanufacturerPartNumber);
		return this;
	}

	public AddNewItemPageObjects enterListPrice(String getlistPrice) {
		listPriceLocator.sendKeys(getlistPrice);
		return this;
	}

	public AddNewItemPageObjects enterCostPrice(String getcostPricer) {
		costPriceLocator.sendKeys(getcostPricer);
		return this;
	}



	
	 public AddNewItemPageObjects clickOnAddNewItemLink() {
	     	addNewItemLocator.click();
	    	return this;
	    }
	@Step("enter {0} with text {1}. verify whether the value of the textbox contains {2} characters.")
	public AddNewItemPageObjects verifyTextboxValidation(String fieldName, String textToBeEnterInTheTextbox,int maximumNumberOfCharactersAcceptedByTheTexbox) throws Exception {
		
		switch(fieldName)
		{
		
		case "Part Number":

			waiting.explicitWaitVisibilityOfElement(partNumberTextBoxLocator, 15);
			partNumberTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(partNumberTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Manufacturer Part Number":

			waiting.explicitWaitVisibilityOfElement(manufacturerPartNumberTextBoxLocator, 15);
			manufacturerPartNumberTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(manufacturerPartNumberTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Competitor Part Number":

			waiting.explicitWaitVisibilityOfElement(competitorPartNumberTextBoxLocator, 15);
			competitorPartNumberTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(competitorPartNumberTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "UPC":

			waiting.explicitWaitVisibilityOfElement(upcTextBoxLocator, 15);
			upcTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(upcTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Data Source":

			waiting.explicitWaitVisibilityOfElement(dataSourceTextBoxLocator, 15);
			dataSourceTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(dataSourceTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Length":

			waiting.explicitWaitVisibilityOfElement(lengthTextBoxLocator, 15);
			lengthTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(lengthTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Width":

			waiting.explicitWaitVisibilityOfElement(widthTextBoxLocator, 15);

			widthTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(widthTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Height":

			waiting.explicitWaitVisibilityOfElement(heightTextBoxLocator, 15);
			heightTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(heightTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Weight":

			waiting.explicitWaitVisibilityOfElement(weightTextBoxLocator, 15);
			weightTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(weightTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Quantity Available":

			waiting.explicitWaitVisibilityOfElement(quantityAvailableTextBoxLocator, 15);
			quantityAvailableTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(quantityAvailableTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "List Price":

			waiting.explicitWaitVisibilityOfElement(listPriceTextBoxLocator, 15);
			listPriceTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(listPriceTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		case "Cost Price":

			waiting.explicitWaitVisibilityOfElement(costPriceTextBoxLocator, 15);
			costPriceTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
			Assert.assertEquals(costPriceTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
			break;
			
		default: throw new Exception("invalid input");
		
		}
		
		return this;
	}

	@Step("verify attributes in the right navigation bar of the add new items page.")
	public AddNewItemPageObjects verifyAttributtesInTheRightNavigationBar(String [] attributesInRightNavigationBarOfAddNewItemsPage) throws Exception {
		Thread.sleep(1500);
		for(int i = 0 ; i<attributesInTheRightNavigationBarLocator.size() ;i++)
		{
			Assert.assertEquals(attributesInTheRightNavigationBarLocator.get(i).getText().trim(),attributesInRightNavigationBarOfAddNewItemsPage[i] );
		}
		
		return this;
	}

	@Step("verify whether general info tab is enabled and others are disabled.")
	public AddNewItemPageObjects verifyEnableAndDisableOfTabs() {

		waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 10);
		Assert.assertTrue(generalInfoTabLocator.getAttribute("class").contains("active"),"General info tab is not enabled");
		Assert.assertFalse(generalInfoTabLocator.getAttribute("class").contains("disabled"),"General info tab is not enabled");
		Assert.assertTrue(descriptionsTabLocator.getAttribute("class").contains("disabled"),"descriptions tab is  enabled");
		Assert.assertTrue(productsTabLocator.getAttribute("class").contains("disabled"),"products tab is  enabled");
		Assert.assertTrue(keywordsTabLocator.getAttribute("class").contains("disabled"),"Keywords tab is  enabled");
		Assert.assertTrue(documentsTabLocator.getAttribute("class").contains("disabled"),"Documents info tab is enabled");
		Assert.assertTrue(imagesTabLocator.getAttribute("class").contains("disabled"),"Images tab is  enabled");
		Assert.assertTrue(videosTabLocator.getAttribute("class").contains("disabled"),"Videos tab is  enabled");
		Assert.assertTrue(linkedItemsTabLocator.getAttribute("class").contains("disabled"),"Linked Items tab is  enabled");
		Assert.assertTrue(attributesTabLocator.getAttribute("class").contains("disabled"),"Attributes tab is enabled");
		Assert.assertTrue(customPricesTabLocator.getAttribute("class").contains("disabled"),"Custom prices tab is enabled");
		Assert.assertTrue(categorizationTabLocator.getAttribute("class").contains("disabled"),"categorization tab is enabled");
		Assert.assertTrue(customFieldsTabLocator.getAttribute("class").contains("disabled"),"Custom fields tab is enabled");
		Assert.assertTrue(warehouseTabLocator.getAttribute("class").contains("disabled"),"Warehouse tab is enabled");
		Assert.assertTrue(customerPartNumberTabLocator.getAttribute("class").contains("disabled"),"Customer Part number tab is enabled");
		Assert.assertTrue(blogLinkTabLocator.getAttribute("class").contains("disabled"),"Blog Link info tab is enabled");
		Assert.assertTrue(userReviewTabLocator.getAttribute("class").contains("disabled"),"User review info tab is enabled");
		return this;
	}

	@Step("verify whether mandatory are {0}")
	public AddNewItemPageObjects verifyAllMandatoryFields(String[] allMandatoryFields) {
		for(int i=0;i<mandatoryFieldsLocator.size();i++)
		{
			Assert.assertEquals(mandatoryFieldsLocator.get(i).getText().replace("*", "").trim(), allMandatoryFields[i]);
		}
		return this;
	}

	@Step("verify whether non mandatory are {0}")
	public AddNewItemPageObjects verifyNonMandatoryFields() {

		System.out.print(nonMandatoryFieldsLocator.size());
		
		for(int i=0;i<mandatoryFieldsLocator.size();i++)
		{
			System.out.print(nonMandatoryFieldsLocator.get(i).getText().trim()+",");
			//Assert.assertEquals(mandatoryFieldsLocator.get(i).getText().replace("*", "").trim(), allMandatoryFields[i]);
		}

		return this;
	}
	
	
	
	@Step("click on save")
	public AddNewItemPageObjects clickOnSave() {
		saveButtonLocator.click();
		return this;
	}

	@Step("verify whether error message is {0} ")
	public AddNewItemPageObjects verifyErrorMessage(String errorMessage[]) {

		waiting.explicitWaitVisibilityOfElements(errorMessageLocator, 10);
		for(int i=0;i<errorMessageLocator.size();i++)
		{
			//System.out.println(errorMessageLocator.get(i).getText());
			Assert.assertEquals(errorMessageLocator.get(i).getText().replace("\n", "").trim(), errorMessage[i]);
		}
		return this;
	}

	@Step("enter manufacturer part number {0}")
	public AddNewItemPageObjects enterManufacturerPartNumber(String manufacturerPartNumber) throws Exception {
		waiting.explicitWaitVisibilityOfElement(manufacturerNameLocator, 15);
		manufacturerNameLocator.sendKeys(manufacturerPartNumber);
		return this;
	}

	@Step("enter part number {0}")
	public AddNewItemPageObjects enterPartNumber(String partNumber) {
		partNumberTextBoxLocator.sendKeys(partNumber);
		return this;
	}

	@Step("enter brand {0}")
	public AddNewItemPageObjects enterBrand(String brand) {
		brandLocator.sendKeys(brand);
		return this;
	}

	@Step("choose {0} and verify {1} is selected.")
	public AddNewItemPageObjects selectAndVerifyItemStatusOptions(String[] itemStatusOptions,String [] valuesAssignedToEachOption) {
		

		waiting.explicitWaitVisibilityOfElement(itemStatusLocator, 10);
		for(int i = 0 ; i < itemStatusOptions.length ; i++)
		{
		Select select = new Select(itemStatusLocator);
		select.selectByVisibleText(itemStatusOptions[i]);
		String idOfSelect = itemStatusLocator.getAttribute("id").trim();

		Assert.assertEquals(((JavascriptExecutor) getDriver()).executeScript("return document.getElementById('"+idOfSelect+"').value;"), valuesAssignedToEachOption[i]);
		
		}		
		return this;
	}

	@Step("click {0} checkbox, verify uncheck and verify again.")
	public AddNewItemPageObjects verifyCheckboxes(String checkboxes) throws Exception {
		
		switch(checkboxes)
		{
		case "Display Online":
			Thread.sleep(1500);

			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",displayOnlineCheckboxLocator);
			Assert.assertTrue(displayOnlineCheckboxLocator.isSelected(),"Display Online Checkbox is not selected.");
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",displayOnlineCheckboxLocator);
			Assert.assertFalse(displayOnlineCheckboxLocator.isSelected(),"Display Online Checkbox is still selected.");
			break;
			
		case "Drop Ship": 
			Thread.sleep(1200);

			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",dropShipCheckboxLocator);
			Assert.assertTrue(dropShipCheckboxLocator.isSelected(),"Drop Ship Checkbox is not selected.");
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",dropShipCheckboxLocator);
			Assert.assertFalse(dropShipCheckboxLocator.isSelected(),"Drop Ship Checkbox is still selected.");
			break;
			
		case "Print": 
			Thread.sleep(1200);

			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",printCheckboxLocator);
			Assert.assertTrue(printCheckboxLocator.isSelected(),"Print Checkbox is not selected.");
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",printCheckboxLocator);
			Assert.assertFalse(printCheckboxLocator.isSelected(),"Print Checkbox is still selected.");
			
			break;	
			
		default: throw new Exception("invalid input");	
		}
		return this;
	}
	
	 public AddNewItemPageObjects clickOnManufacturerDropdown() throws InterruptedException {

			waiting.explicitWaitVisibilityOfElement(manufacturerDropDownArrowLocator, 15);
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",manufacturerDropDownArrowLocator);
			return this;
		}
	 
	 public AddNewItemPageObjects selectManufacturerField(String manufacturerDropdownValue) throws InterruptedException {
		
     for(WebElement dropDownOptions : manufacturerDropdownValuesLocator) {
     	  
     	        if(dropDownOptions.getText().equals(manufacturerDropdownValue))
     	        {
     		    dropDownOptions.click();
     		    break;
     	        }    
         }
          return this;
	  }
	 
	 public AddNewItemPageObjects enterPartNumberField(String partNumberField) {

		 waiting.explicitWaitVisibilityOfElement(enterPartNumberLocator, 30);
		// RandomGenerator generateRandom = new RandomGenerator();
		// generateRandom.random(6, PermittedCharacters.NUMERIC);
		 enterPartNumberLocator.sendKeys(partNumberField);
			return this;
		}
	 
	 public AddNewItemPageObjects clickOnBrandDropdown() throws InterruptedException {
		 
		 Thread.sleep(500);

		 ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",brandDropDownLocator);
			
			return this;
		}
	 
	 public AddNewItemPageObjects selectBrandField (String brandDropDownValue) {


		 for(WebElement brandDropDownOptions : brandDropDownValuesLocator) {
       	  
	        	if(brandDropDownOptions.getText().equals(brandDropDownValue))
	        	{
			    brandDropDownOptions.click();
	        	break;
	        	}
	        }
			return this;
		}
	 

	 public AddNewItemPageObjects clickOnSaveButtonLink() {

		 waiting.explicitWaitVisibilityOfElement(ItemsaveButtonLocator, 30);
		 saveButtonLocator.click();
	    	 return this;
	    }
	 
	 public AddNewItemPageObjects verifyItemSavedSuccessfulMessage(String itemsavedsuccessfulmessage) {
	   	  

	   	 waiting.explicitWaitVisibilityOfElement(ItemSavedSuccessfulMessageLocator, 30);
	     Assert.assertTrue(ItemSavedSuccessfulMessageLocator.getText().equalsIgnoreCase(itemsavedsuccessfulmessage),"Invalid  message. Getting "+ItemSavedSuccessfulMessageLocator.getText()+".");
		 return this;
		
		}

}

