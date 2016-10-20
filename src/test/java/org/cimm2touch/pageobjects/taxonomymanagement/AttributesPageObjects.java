package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.List;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class AttributesPageObjects extends PageFactoryInitializer
{
	TestUtility tu = new TestUtility();
	
	@FindAll(value={@FindBy(xpath="//tr[contains(@class,'rich-table-subheader')]/th")})
	private List<WebElement> attributesHeaderTitlesLink;

	@FindBy(xpath="//input[contains(@title,'New Attribute')]")
	private WebElement createNewAttributeLink;

	@FindBy(xpath="//input[contains(@name,'addnewAttribute:attrName1')]")
	private WebElement enterAttributeNameTextField;

	@FindBy(xpath="//textarea[contains(@name,'addnewAttribute:attrbuteDesc1')]")
	private WebElement enterAttributeDescriptionTextField;

	@FindBy(xpath="//input[contains(@title,'Save Attribute')]")
	private WebElement saveLinkForAttributes;

	@FindBy(xpath="//input[contains(@placeholder,'Enter Attribute Name to Search')]")
	private WebElement searchFieldForAttribute;

	@FindBy(xpath="//a[contains(@name,'listAttribute1:goBtn')]/i")
	private WebElement searchButton;

	@FindBy(xpath="//span[contains(text(),'Attribute Name Required')]")
	private WebElement actualErrorMessage;

	@FindBy(xpath="//span[contains(text(),'New Attribute save Unsuccessfull')]")
	private WebElement errorMessageDescription;

	@FindBy(xpath="//span[contains(text(),' Attribute saved Successfully')]")
	private WebElement succesfulMessageForAttributeNameExceed50Char;

	@FindBy(xpath="(//span[@class='total-count-size'])[2]") 
	private  WebElement totalCountTextLocator;

	@FindBy(xpath="(//span[@class='total-count-size'])[1]") 
	private  WebElement currentPageCountTextLocator;

	@FindBy(xpath="//a[@title='Next']")
	private WebElement paginationNextLinkLocator;

	@FindBy(xpath="//a[@title='Previous']")
	private WebElement paginationPreviousLinkLocator;

	@FindBy(xpath="(//ul[@class='pagination-container']/li)[5]")
	private WebElement paginationLastPageLocator;

	@FindBy(xpath="(//ul[@class='pagination-container']/li)[1]")
	private WebElement paginationFirstPageLocator;

	@FindBy(xpath="//div[contains(text(),'Display')]/select")
	private WebElement selectRecordsDropdownInAttributesLocator;

	@FindAll(value={@FindBy(xpath="//input[@title='Edit Attribute']")})
	private List<WebElement> editThisAttributeLocator;
	
	@FindBy(xpath="//div[@id='searchFormId:taxonomyListComboIdcombobox']/div/input[@id='searchFormId:taxonomyListComboIdcomboboxField']")
	private WebElement taxonomyNameComboBoxField;


	@Step("verification of attribute list page {0}")
	public AttributesPageObjects verifyAttributesTableHeaders(String expectedAttributsTableHeaders) {

		Waiting.explicitWaitVisibilityOfElements(attributesHeaderTitlesLink, 15);
		String expData[]=expectedAttributsTableHeaders.split(",");

		for(int i=0;i<attributesHeaderTitlesLink.size();i++){
			//System.out.println(attributesHeaderTitlesLink.get(i).getText().trim());
			Assert.assertEquals(attributesHeaderTitlesLink.get(i).getText().trim(),expData[i].trim());

		}return this;
	}


	@Step("click on new Attribute creation link")
	public AttributesPageObjects clickOnNewAttributeToCreate() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(createNewAttributeLink, 10);
		createNewAttributeLink.click();
		Thread.sleep(5000);
		return this;
	}


	@Step("enter attribute name {0}")
	public AttributesPageObjects enterAttributeName(String attributeName) {
		Waiting.explicitWaitVisibilityOfElement(enterAttributeNameTextField, 10);
		Assert.assertTrue(enterAttributeNameTextField.isDisplayed());
		enterAttributeNameTextField.sendKeys(attributeName);

		return this;

	}


	@Step("enter attribute description {0}")
	public AttributesPageObjects enterAttributeDescription(String attributeDescription) {
		Waiting.explicitWaitVisibilityOfElement(enterAttributeDescriptionTextField, 10);
		Assert.assertTrue(enterAttributeDescriptionTextField.isDisplayed());
		enterAttributeDescriptionTextField.sendKeys(attributeDescription);

		return this;		
	}

	@Step("click on save attribute.")
	public AttributesPageObjects clickOnSaveAttribute() {
		Waiting.explicitWaitVisibilityOfElement(saveLinkForAttributes, 10);
		saveLinkForAttributes.click();
		return this;

	}

	@Step("verify created Attributes.")
	public AttributesPageObjects verifyCreatedAttribute(String attributeName) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(searchFieldForAttribute, 10);
		searchFieldForAttribute.sendKeys(attributeName);
		searchButton.click();
		Thread.sleep(5000);
		return this;

	}
	@Step("remove created attribute.")
	public AttributesPageObjects removeAttribute(String attributeName) throws InterruptedException{
		Thread.sleep(5000);
		WebElement wb=driver.findElement(By.xpath("((//tr[@class='rich-table-row rich-table-firstrow']/td)[1]/div/input)[2]"));
		wb.click();
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//td[contains(text(),'"+attributeName+"')]/preceding-sibling::td/descendant::input[@src='/CIMM2Touch/images/small/delete.png']")));
		//Waiting.explicitWaitForAlert(5);
		TestUtility.alertAccept();
		Thread.sleep(4000);
		return this;
	}

	@Step("verify error message {0} for attributes if the attributes not getting saved.")
	public AttributesPageObjects verifyErrorMessage(String errorMessage) {

		Waiting.explicitWaitVisibilityOfElement(actualErrorMessage, 10);
		Assert.assertEquals(actualErrorMessage.getText().trim(), errorMessage);
		return this;
	}

	@Step("verify error message{0} description if description exceeds more than 500 chars.")
	public AttributesPageObjects verifyErrorMessageMoreDescription(String expErrorMessageIfDesc) {
		Waiting.explicitWaitVisibilityOfElement(errorMessageDescription, 10);
		Assert.assertEquals(errorMessageDescription.getText().trim(),expErrorMessageIfDesc);

		return this;
	}

	@Step("verify error message {0} if Attribute name exceeds more than 50 chars.")
	public AttributesPageObjects verifyErrorMessageMoreAttributeName(String expAttributeName) {

		Waiting.explicitWaitVisibilityOfElement(succesfulMessageForAttributeNameExceed50Char, 10);
		Assert.assertNotEquals(succesfulMessageForAttributeNameExceed50Char.getText().trim(), expAttributeName, "Attribute name allowing morethan 50 chars");


		return this;
	}

	@Step("verify pagination in Attributes page")
	public boolean verifyPaginationInAttributesPage() throws InterruptedException {
		int totalCount = Integer.parseInt(totalCountTextLocator.getText());
		boolean pagination=false;
		if(totalCount>1){
			int currentPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			Assert.assertEquals(currentPageCount, 1);
			paginationNextLinkLocator.click();
			Thread.sleep(3000);

			int nextPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			System.out.println(nextPageCount);
			Thread.sleep(3000);

			paginationPreviousLinkLocator.click();
			Thread.sleep(3000);
			Assert.assertEquals(currentPageCount, 1);
			Thread.sleep(3000);

			paginationLastPageLocator.click();
			Thread.sleep(3000);
			int lastPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
			Assert.assertEquals(lastPageCount, totalCount);
			Thread.sleep(3000);

			paginationFirstPageLocator.click();
			Thread.sleep(3000);
			Assert.assertEquals(currentPageCount, 1);


		}
		return pagination;
	}
	@Step("selecting {0} number of records to display.")
	public AttributesPageObjects selectNumberOfRecordsToDisplayInThePage(String selectNumberOfRecordsToDisplay) throws Exception{

		Select select = new Select(selectRecordsDropdownInAttributesLocator);
		select.selectByVisibleText(selectNumberOfRecordsToDisplay);
		Thread.sleep(3000);
		return this;

	}


	@Step("verifying whether {0} is the number of records that is displayed.")
	public AttributesPageObjects verifyTheNumberOfRecordsDisplayed(String getNumberOfRecordsToDisplay) throws Exception{
		try
		{
			Thread.sleep(2800);
			Assert.assertTrue(assertForNumberOfRowsDisplayed(editThisAttributeLocator.size(),Integer.parseInt(getNumberOfRecordsToDisplay)));
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyTheNumberOfRecordsDisplayed(getNumberOfRecordsToDisplay);
		}
		return this;
	}

	private boolean assertForNumberOfRowsDisplayed(int editButtons, int numberOfRecordsToDisplay) {
		if(editButtons<=numberOfRecordsToDisplay)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}


	SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::a[contains(.,'Taxonomy Management')]/following-sibling::ul/descendant::a[contains(.,'Attributes')]")
	private WebElement attributeslinkLocator;

	@FindBy(xpath="//input[@title='New Attribute']")
	private WebElement addNewAttributeLocator;

	@FindBy(xpath="//input[contains(@name,'addnewAttribute:attrName1')]") //input[@name='addnewAttribute:attrName1']/following-sibling::span[@id='addnewAttribute:attname']
	private WebElement attributeNameTextBoxLocator;

	@FindBy(xpath="//input[@name='addnewAttribute:attrName1']")
	private WebElement updateAttributeNameTextBoxLocator;

	@FindBy(xpath="//textarea[contains(@name,'addnewAttribute:attrbuteDesc1')]")
	private WebElement attributeDescriptionTextBoxLocator;

	@FindBy(xpath="//input[@title='Save Attribute']")
	private WebElement attributeSaveButtonLocator;

	@FindBy(xpath="//span[@id='listAttribute1:savemsg']")
	private WebElement attributeSavedSuccessfulMessageLocator;

	@FindBy(xpath="//input[@placeholder='Enter Attribute Name to Search ']")
	private WebElement attributeSearchPlaceHolder;



	@FindBy(xpath="//input[@alt='Edit']")
	private WebElement editAttributeLocator;

	@FindBy(xpath="//input[@title='Update Attribute']")
	private WebElement attributeUpdateButtonLocator;

	@FindBy(xpath="//span[contains(text(),'Updated Successfully')]")
	private WebElement  attributetUpdateSavedSuccessfulMessageLocator;

	@FindBy(xpath="//input[@id='listAttribute1:attributeDataTableId:0:j_id1277']")
	private WebElement removeAttributeLink;

	@FindBy(xpath="//span[@id='listAttribute1:savemsg1']")
	private WebElement deletedSuccessfulMessageOfAttributeLocator;

	@FindBy(xpath="//a[@title='History']")
	private WebElement historylinkLocator;

	@FindBy(xpath="//td[contains(text(),'Testing24')]")
	private WebElement attributeNameColumn;

	@FindBy(xpath="//td[contains(text(),'Testing2434')]")
	private WebElement updateAttributeNameColumn;

	@FindAll(value={@FindBy(xpath="//div[@class='cimm_formLabel']")})
	private List<WebElement> fieldNamesInAddNewAttributeLocator;

	@FindBy(xpath="//input[@id='listAttribute1:attributeDataTableId:0:j_id1277']")
	private WebElement removeUpdateAttributeLink;



	@Step("clicking on attributes link")
	public AttributesPageObjects clickOnAttributesLink() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",attributeslinkLocator);
		return this;
	}

	@Step("click on add new product")
	public AttributesPageObjects clickOnAddNewAttributeLink() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(addNewAttributeLocator, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",addNewAttributeLocator);
		return this;
	}

	@Step(" verify the attributeName field")
	public AttributesPageObjects enterAttributeNameField(String attributeName) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(attributeNameTextBoxLocator, 10);
		Assert.assertTrue(attributeNameTextBoxLocator.isDisplayed(),"Attribute Name textbox is not displayed.");
		Thread.sleep(2000);
		attributeNameTextBoxLocator.clear();
		attributeNameTextBoxLocator.sendKeys(attributeName);

		return this;
	}

	@Step(" verify the attributeDescription field")
	public AttributesPageObjects enterAttributeDescriptionField(String attributeDescription) {
		Waiting.explicitWaitVisibilityOfElement(attributeDescriptionTextBoxLocator, 10);
		Assert.assertTrue(attributeDescriptionTextBoxLocator.isDisplayed());
		attributeDescriptionTextBoxLocator.sendKeys(attributeDescription);	 
		return this;
	}

	@Step(" verify the Attribute SaveButtonLink ")
	public AttributesPageObjects clickOnAttributeSaveButtonLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",attributeSaveButtonLocator); 
		return this;
	}

	@Step("This method is used verify the Attribute SavedSuccessfulMessage ")
	public AttributesPageObjects verifyAttributeSavedSuccessfulMessage(String attributeSavedSuccessfulMessage) throws Exception { 
		Thread.sleep(1500);
		Assert.assertEquals(attributeSavedSuccessfulMessageLocator.getText().trim(),attributeSavedSuccessfulMessage.trim(),"Invalid  message. Getting "+attributeSavedSuccessfulMessageLocator.getText().trim()+".");
		return this;
	}

	@Step("This method is used to enter the Attribute name in search field {0}")
	public AttributesPageObjects enterTheAttributeNameInSearchField(String attributeName) {
		attributeSearchPlaceHolder.sendKeys(attributeName);
		return this;
	}

	@Step("This method is used to clickon search buton in Attributes page")
	public AttributesPageObjects clickOnSearchButton(){
		Waiting.explicitWaitVisibilityOfElement(searchButton, 15);
		searchButton.click(); 
		return this;
	}

	@Step("This method is used verify the attribute name")
	public AttributesPageObjects verifyAttribute(String attributeName) {
		Waiting.explicitWaitVisibilityOfElement(attributeNameColumn, 15);
		System.out.println(attributeNameColumn.getText());
		Assert.assertEquals(attributeNameColumn.getText(), attributeName);
		return this;
	}

	@Step("This method is used verify the update attribute name")
	public AttributesPageObjects verifyUpdateAttribute(String updateAttributeName) {
		Waiting.explicitWaitVisibilityOfElement(updateAttributeNameColumn, 15);
		System.out.println(updateAttributeNameColumn.getText());
		Assert.assertEquals(updateAttributeNameColumn.getText(), updateAttributeName);
		return this;
	}

	@Step("This method is used verify the Edit Attribute link ")
	public AttributesPageObjects clickOnEditAttribute() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(editAttributeLocator, 30);
		editAttributeLocator.click();
		Thread.sleep(4000);
		return this;
	}

	@Step("This method is used verify edit AttributeName Field ")
	public AttributesPageObjects editAttributeNameField(String editAttributeName) {
		Waiting.explicitWaitVisibilityOfElement(updateAttributeNameTextBoxLocator, 15);
		updateAttributeNameTextBoxLocator.sendKeys(editAttributeName);
		return this;
	}

	@Step("This method is used verify Attribute UpdateButton Link ")
	public AttributesPageObjects clickOnAttributeUpdateButtonLink() {
		Waiting.explicitWaitVisibilityOfElement(attributeUpdateButtonLocator, 60);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",attributeUpdateButtonLocator);
		return this;
	}

	@Step("This method is used verify Attribute Update Saved SuccessfulMessage ")
	public AttributesPageObjects verifyAttributeUpdateSavedSuccessfulMessage(String attributeUpdateSuccessfulMessage) { 
		Waiting.explicitWaitVisibilityOfElement(attributetUpdateSavedSuccessfulMessageLocator, 6);
		Assert.assertTrue(attributetUpdateSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(attributeUpdateSuccessfulMessage),"Invalid  message. Getting "+attributetUpdateSavedSuccessfulMessageLocator.getText().trim()+".");
		return this;
	}

	@Step("This method is used to enter the product number in search field {0}")
	public AttributesPageObjects enterTheUpdateAttributeNameInSearchField(String updateAttributeName) {
		Waiting.explicitWaitVisibilityOfElement(attributeSearchPlaceHolder, 6);
		attributeSearchPlaceHolder.sendKeys(updateAttributeName);
		return this;
	}


	@Step("This method is used to remove the Attribute")
	public AttributesPageObjects clickOnRemoveAttribute(String attributeName) throws InterruptedException {
		Thread.sleep(3000);
		WebElement wb=driver.findElement(By.xpath("(//td[contains(text(),'"+attributeName+"')]/preceding-sibling::td[@class='rich-table-cell']/div/input)[2]"));
		wb.click();
		return this;
	}


	@Step("This method is used to remove the Attribute ")
	public AttributesPageObjects clickOnRemoveUpdateAttribute(String updateAttributeName) throws InterruptedException {
		Thread.sleep(3000);
		WebElement wb=driver.findElement(By.xpath("(//td[contains(text(),'"+updateAttributeName+"')]/preceding-sibling::td[@class='rich-table-cell']/div/input)[2]"));
		wb.click(); 
		return this;
	}

	@Step("This method is used accept the alert popup")
	public boolean assertAlertToAccept(String removeAlertText) {
		boolean t = TestUtility.getAlertText().trim().equals(removeAlertText.trim());
		TestUtility.alertAccept();
		return t;  
	}

	public AttributesPageObjects verifyRemoveAlertMsg(String removeAlertText) {
		Assert.assertTrue(assertAlertToAccept(removeAlertText));
		return this;
	}


	@Step("This method is used accept the alert popup")
	public boolean assertAlertMsg(String alertText) {
		boolean t = TestUtility.getAlertText().trim().equals(alertText.trim());
		TestUtility.alertAccept();
		return t;  
	}

	public AttributesPageObjects verifyAlertMsg(String alertText) {
		Assert.assertTrue(assertAlertMsg(alertText));
		return this;
	}

	@Step("This method is used verify the message after deleting the Attribute")
	public AttributesPageObjects verifySuccessfulMessageAfterDeletionAttribute(String attributeRemovedSuccessfulMessage) {
		Waiting.explicitWaitVisibilityOfElement(deletedSuccessfulMessageOfAttributeLocator, 30);
		Assert.assertEquals(deletedSuccessfulMessageOfAttributeLocator.getText().trim(),attributeRemovedSuccessfulMessage.trim(),"Invalid  message. Getting "+deletedSuccessfulMessageOfAttributeLocator.getText().trim()+".");
		return this;
	}

	@Step("clicking on History link")
	public AttributesPageObjects clickOnHistoryLink() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",historylinkLocator);
		return this;
	}


	@Step("This method is used verify FieldNames In Add New Attribute")
	public AttributesPageObjects verifyFieldNamesInAddNewAttribute() throws Exception{

		String fieldNamesInAddNewAttribute[] =data.getFieldNamesInAddNewAttribute().split(",");

		for(int i=0;i<fieldNamesInAddNewAttributeLocator.size();i++)
		{
			Assert.assertEquals(fieldNamesInAddNewAttributeLocator.get(i).getText().trim(), fieldNamesInAddNewAttribute[i].trim());
		}

		return this;
	}


	public boolean assertAttributeNameDeletion(String attributeName)
	{
		try
		{
			if(driver.findElement(By.xpath("attributeName")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;
	}

	public AttributesPageObjects verifyeAttributeDeletion(String attributeName){	   
		Assert.assertTrue(assertAttributeNameDeletion(attributeName),"Group name is not deleted");
		return this;
	}


	public boolean assertUpdateAttributeNameDeletion(String updateAttributeName)
	{
		try
		{
			if(driver.findElement(By.xpath("updateAttributeName")).isDisplayed())
			{
				return false;
			}
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;
	}

	public AttributesPageObjects verifyUpdateAttributeDeletion(String updateAttributeName)
	{   
		Assert.assertTrue(assertUpdateAttributeNameDeletion(updateAttributeName),"Group name is not deleted");
		return this;
	}

	@SuppressWarnings("static-access")
	@Step("To Select a Specific Taxonomy in the Left Side Bar of the Attributes Page.")
	public AttributesPageObjects selectSpecificTaxonomy(String string) throws Exception 
	{
		Thread.sleep(5000);
/*		taxonomyNameComboBoxField.click();
		taxonomyNameComboBoxField.clear();
		taxonomyNameComboBoxField.sendKeys(string);
		tu.hitEnter();*/
		driver.findElement(By.id("searchFormId:taxonomyListComboIdcomboboxButton")).click();
		return this;
	}	


}
