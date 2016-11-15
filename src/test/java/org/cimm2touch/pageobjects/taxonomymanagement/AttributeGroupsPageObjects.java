package org.cimm2touch.pageobjects.taxonomymanagement;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;
/**
 * 
 * @author thiruveedhi Chinna
 *
 */
public class AttributeGroupsPageObjects extends PageFactoryInitializer{
	
	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="(//a[contains(.,'PIM')])[1]/ancestor::li/ul/descendant::a[contains(.,'Taxonomy Management')]/following-sibling::ul/descendant::a[contains(.,'Attribute Groups')]")
	private WebElement attributesGroupsLinkLocator;
	
	@FindBy(xpath="//span[@id='listGroupAttribute1:attributeGroupsTableId:AH']")
	private WebElement actionLocator;
	 
	@FindBy(xpath="//span[@id='listGroupAttribute1:attributeGroupsTableId:SsLNoL']")
	private WebElement siNoLocator;
	
	@FindBy(xpath="//span[contains(text(),'Attribute Group Name')]")
	private WebElement attributeGroupNameLocator;
	 
	@FindBy(xpath="//span[contains(text(),'Attribute Group Desc')]")
	private WebElement attributeGroupDescLocator;
	
	@FindBy(xpath="//input[@name='listGroupAttribute1:searchKeywordId']")
	private WebElement attributeGroupNameSearchPlaceHolder;
	
	@FindBy(xpath="(//i[@class='list-search-icn fa fa-search'])[2]")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@title='New Attribute Group']")
	private WebElement addNewAttributeGroupsLocator;
	 
	@FindBy(xpath="//textarea[@id='addNewAttrGroup:attrGrpTextArea']")
	private WebElement attributeGroupDesTextBoxLocator;
	
	@FindBy(xpath="//div[contains(@class,'cimm_formInput')]/input[@id='addNewAttrGroup:attrgrpName']") //input[contains(@name,'addNewAttrGroup:attrgrpName')]
	private WebElement attributeGroupNameTextBoxLocator;
	
	@FindBy(xpath="//input[@name='addNewAttrGroup:attrgrpName']")
	private WebElement updateAttributeGroupNameTextBoxLocator;
	
	
	@FindBy(xpath="//textarea[@id='addNewAttrGroup:attrGrpTextArea']")
	private WebElement attributeGroupDescriptionTextBoxLocator;
	
	@FindBy(xpath="//input[@title='Save Attribute Group']")
	private WebElement attributeGroupSaveButtonLocator;
	
	@FindBy(xpath="//input[@title='Update Attribute Group']")
	private WebElement attributeGroupUpdateButtonLocator;
	
	@FindBy(xpath="//input[@title='Save Attribute Group']")
	private WebElement withoutEnteringFieldSaveButtonLocator;
	
	@FindBy(xpath="//span[@id='listGroupAttribute1:savemsg1']")
	private WebElement attributeGroupSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//span[contains(text(),'No results Found')]")
	private WebElement noResultsFoundErrorMessageLocator;
	
	@FindBy(xpath="//span[contains(text(),'Attribute Group Name Required')]")
	private WebElement attributeGroupNameRequiredMessageLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_formLabel']")})
	private List<WebElement> fieldNamesInAddNewAttributeGroupLocator;
	
	@FindBy(xpath="//input[@title='Save Attribute Group']")
	private WebElement saveLinkIconLocator;
	
	@FindBy(xpath="//input[@title='Reset']")
	private WebElement resetIconLocator;
	
	@FindBy(xpath="//input[@title='Edit Attribute Group']")
	private WebElement editAttributeGroupLocator;
	
	@FindBy(xpath="//input[@title='Update Attribute Group']")
	private WebElement updateAttributeGroupNameButtonLocator;
	
	@FindBy(xpath="//span[contains(text(),'Updated Successfully')]")
	private WebElement  attributeUpdateSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//a[@title='History']")
	private WebElement historylinkLocator;
	
	@FindBy(xpath="(//span[@class='total-count-size'])[1]")
	private WebElement currentPageCountTextLocator;
	
	@FindBy(xpath="(//ul[contains(@class,'pagination-container')]/li)[4]")
	private WebElement paginationNextLinkLocator;
	
	@FindBy(xpath="(//ul[contains(@class,'pagination-container')]/li)[2]")
	private WebElement paginationPreviousLinkLocator;
	
	@FindBy(xpath="(//ul[contains(@class,'pagination-container')]/li)[5]")
	private WebElement paginationLastPageLocator;
	
	@FindBy(xpath="(//ul[contains(@class,'pagination-container')]/li)[1]")
	private WebElement paginationFirstPageLocator;
	
	@FindBy(xpath="(//span[@class='total-count-size'])[2]")
	private WebElement totalCountTextLocator;
	
	@FindBy(xpath="//input[@id='listGroupAttribute1:attributeGroupsTableId:1:j_id1354']")
	private WebElement removeAttributeGroupLink;
	
	@FindBy(xpath="//span[contains(text(),'Attribute Removed Successfully')]")
	private WebElement deletedSuccessfulMessageOfAttributeGroupLocator;
	
	///HARD CODED THE VALUES!!!!!!!!!!!!!!!!!!!
	 @FindBy(xpath="//td[contains(text(),'example')]")
	 private WebElement attributeGroupNameColumn;
	 
	 @FindBy(xpath="//td[contains(text(),'example12')]")
	 private WebElement updateAttributeGroupNameColumn;
	 
	 @FindBy(xpath="//input[@id='listGroupAttribute1:searchKeywordId']")
	 private WebElement attributeGroupSearchPlaceHolder;
	 
	 @FindBy(xpath="//input[@id='listGroupAttribute1:searchKeywordId']")
	 private WebElement invalidAttributeGroupNameLocator;
	 
	
	@Step("clicking on attribute Groups link")
	public AttributeGroupsPageObjects clickOnAttributeGroupsLink() {
	((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",attributesGroupsLinkLocator);
	return this;
	}
	
	 @Step("This method is used verify the Action In AttributeGroupsPage")
		public AttributeGroupsPageObjects verifyActionInAttributeGroupsPage() {	
		Assert.assertTrue(actionLocator.isDisplayed(),"Action is not displayed.");
		return this;
	 }
	 
	 @Step("This method is used verify the Si.No In AttributeGroupsPage")
		public AttributeGroupsPageObjects verifySiNoInAttributeGroupsPage() {	
		Assert.assertTrue(siNoLocator.isDisplayed(),"Si.No is not displayed.");
		return this;
	 }
	 
	 @Step("This method is used verify the attribute GroupName In AttributeGroupsPage")
		public AttributeGroupsPageObjects verifyAttributeGroupNameInAttributeGroupsPage() {	
		Assert.assertTrue(attributeGroupNameLocator.isDisplayed(),"attribute GroupName is not displayed.");
		return this;
	 }
	 
	 @Step("This method is used verify the attribute GroupDesc In AttributeGroupsPage")
		public AttributeGroupsPageObjects verifyAttributeGroupDescInAttributeGroupsPage() {	
		Assert.assertTrue(attributeGroupDescLocator.isDisplayed(),"attribute GroupDesc is not displayed.");
		return this;
	 }
	 
	  @Step("This method is used to enter the Attribute GroupName in search field {0}")
	   public AttributeGroupsPageObjects enterTheAttributeGroupNameInSearchField(String attributeGroupName) {
	    waiting.explicitWaitVisibilityOfElement(attributeGroupNameSearchPlaceHolder, 15);
	    attributeGroupNameSearchPlaceHolder.sendKeys(attributeGroupName);
	    return this;
	   }
	  
	  
	  @Step("This method is used to clickon search buton in products page")
	   public AttributeGroupsPageObjects clickOnSearchButton()  {
	    waiting.explicitWaitVisibilityOfElement(searchButton, 15);
	    searchButton.click(); 
	    return this;
	   }
	  
	  @Step("click on add new Attribute Group ")
		public AttributeGroupsPageObjects clickOnAddNewAttributeGroupLink() {
		waiting.explicitWaitVisibilityOfElement(addNewAttributeGroupsLocator, 40);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",addNewAttributeGroupsLocator);
		return this;
	   }
		
		@Step("This method is used verify the Attribute Group field")
		public AttributeGroupsPageObjects enterAttributeGroupField(String attributeGroupName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(attributeGroupNameTextBoxLocator, 15);
		Assert.assertTrue(attributeGroupNameTextBoxLocator.isDisplayed(),"Attribute Group Name textbox is not displayed.");
     	Thread.sleep(2000);
     	attributeGroupNameTextBoxLocator.clear();
		attributeGroupNameTextBoxLocator.sendKeys(attributeGroupName);	 
		return this;
		}
		
		@Step("This method is used verify the Attribute Group field")
		public AttributeGroupsPageObjects enterEditAttributeGroupField(String editAttributeGroupName) throws InterruptedException {
		waiting.explicitWaitVisibilityOfElement(attributeGroupNameTextBoxLocator, 15);
		Assert.assertTrue(attributeGroupNameTextBoxLocator.isDisplayed(),"Attribute Group Name textbox is not displayed.");
     	Thread.sleep(2000);
     	attributeGroupNameTextBoxLocator.clear();
		attributeGroupNameTextBoxLocator.sendKeys(editAttributeGroupName);	 
		return this;
		}
		
		 @Step("This method is used to enter the product number in search field {0}")
		 public AttributeGroupsPageObjects enterTheUpdateAttributeGroupNameInSearchField(String updateAttributeGroupName) throws InterruptedException {
		 waiting.explicitWaitVisibilityOfElement(attributeGroupSearchPlaceHolder, 6);
		 attributeGroupSearchPlaceHolder.sendKeys(updateAttributeGroupName);
			
		 return this;
		 }
		 
		 @Step("This method is used to enter the product number in search field {0}")
		 public AttributeGroupsPageObjects enterInvalidAttributeGroupNameInSearchField(String invalidAttributeGroupName) {
		 waiting.explicitWaitVisibilityOfElement(invalidAttributeGroupNameLocator, 6);
		 invalidAttributeGroupNameLocator.sendKeys(invalidAttributeGroupName);
		 return this;
		 }
	    
		@Step("This method is used verify the Attribute Group Description field")
		public AttributeGroupsPageObjects enterAttributeGroupDescriptionField(String attributeGroupDescription) throws InterruptedException {
		Thread.sleep(2000);
		attributeGroupDescriptionTextBoxLocator.sendKeys(attributeGroupDescription);	 
		return this;
		}
		
		@Step("This method is used verify the Attribute SaveButtonLink ")
		public AttributeGroupsPageObjects clickOnAttributeGroupSaveButtonLink() {	
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",attributeGroupSaveButtonLocator); 
		return this;
		}
		
		 @Step("This method is used verify Attribute UpdateButton Link ")
		 public AttributeGroupsPageObjects clickOnAttributeGroupUpdateButtonLink() {
		 waiting.explicitWaitVisibilityOfElement(attributeGroupUpdateButtonLocator, 60);
		 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",attributeGroupUpdateButtonLocator);
		 return this;
		}
		
		@Step("This method is used verify the Attribute SavedSuccessfulMessage ")
		public AttributeGroupsPageObjects verifyAttributeGroupSavedSuccessfulMessage(String attributeGroupSavedSuccessfulMessage) { 
		waiting.explicitWaitVisibilityOfElement(attributeGroupSavedSuccessfulMessageLocator, 6);
		Assert.assertEquals(attributeGroupSavedSuccessfulMessageLocator.getText().trim(),attributeGroupSavedSuccessfulMessage.trim(),"Invalid  message. Getting "+attributeGroupSavedSuccessfulMessageLocator.getText().trim()+".");
		return this;
		}
		
		@Step("This method is used verify the Attribute SavedSuccessfulMessage ")
		public AttributeGroupsPageObjects verifyNoResultsFoundMessage(String noResultsFoundErrorMessage) { 
		waiting.explicitWaitVisibilityOfElement(noResultsFoundErrorMessageLocator, 6);
		Assert.assertEquals(noResultsFoundErrorMessageLocator.getText().trim(),noResultsFoundErrorMessage.trim(),"Invalid  message. Getting "+noResultsFoundErrorMessageLocator.getText().trim()+".");
		return this;
		}
		
		@Step("This method is used verify Attribute GroupName Required Message ")
		public AttributeGroupsPageObjects verifyAttributeGroupNameRequiredMessage(String attributeGroupNameRequiredMessage) { 
		waiting.explicitWaitVisibilityOfElement(attributeGroupNameRequiredMessageLocator, 30);
		Assert.assertEquals(attributeGroupNameRequiredMessageLocator.getText().trim(),attributeGroupNameRequiredMessage.trim(),"Invalid  message. Getting "+attributeGroupNameRequiredMessageLocator.getText().trim()+".");
		return this;
		}
		
		 @Step("This method is used verify FieldNames In Add New AttributeGroup")
		 public AttributeGroupsPageObjects verifyFieldNamesInAddNewAttributeGroup() throws Exception{
				
		 String fieldNamesInAddNewAttributeGroup[] =data.getFieldNamesInAddNewAttributeGroup().split(",");
				
				for(int i=0;i<fieldNamesInAddNewAttributeGroupLocator.size();i++)
				{
					Assert.assertEquals(fieldNamesInAddNewAttributeGroupLocator.get(i).getText().trim(), fieldNamesInAddNewAttributeGroup[i].trim());
				}
				  
				return this;
		 }
		
		 @Step("verify display of save link Icon in Add New Attribute Group")
		 public AttributeGroupsPageObjects verifySaveLinkIconInAddNewAttributeGroup() {	
		 Assert.assertTrue(saveLinkIconLocator.isDisplayed(),"saveUR Icon is not displayed.");
		 return this;
		 }
		  
		  @Step("verify display of Reset Icon in AddNewProductImage")
		  public AttributeGroupsPageObjects verifyResetLinkIconInAddNewAttributeGroup() {
		  Assert.assertTrue(resetIconLocator.isDisplayed()," Reset Icon is not displayed.");
		  return this;
		  }
		  
		  @Step("This method is used verify the Edit Attribute link ")
		  public AttributeGroupsPageObjects clickOnEditGroupAttributeGroup() {
		  waiting.explicitWaitVisibilityOfElement(editAttributeGroupLocator, 30);
		  editAttributeGroupLocator.click();
		  return this;
		  }
		  
	
		   @Step("This method is used verify Attribute Update Saved SuccessfulMessage ")
		   public AttributeGroupsPageObjects verifyAttributeGroupUpdateSavedSuccessfulMessage(String attributeGroupUpdateSavedSuccessfulMessage) { 
		   waiting.explicitWaitVisibilityOfElement(attributeUpdateSavedSuccessfulMessageLocator, 6);
		   Assert.assertTrue(attributeUpdateSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(attributeGroupUpdateSavedSuccessfulMessage),"Invalid  message. Getting "+attributeUpdateSavedSuccessfulMessageLocator.getText().trim()+".");
		   return this;
		   } 
		   
		   @Step("This method is used to remove the Attribute ")
			 public AttributeGroupsPageObjects clickOnRemoveUpdateAttributeGroup(String updateAttributeGroupName) throws InterruptedException {
			   Thread.sleep(3000);
			   WebElement wb=getDriver().findElement(By.xpath("(//td[contains(text(),'"+updateAttributeGroupName+"')]/preceding-sibling::td[@class='rich-table-cell']/div/input)[2]"));
			   wb.click();
			 return this;
			}
		   
		   @Step("This method is used to remove the Attribute ")
			 public AttributeGroupsPageObjects clickOnRemoveAttributeGroup(String attributeGroupName) throws InterruptedException {
			   Thread.sleep(3000);
			   WebElement wb=getDriver().findElement(By.xpath("(//td[contains(text(),'"+attributeGroupName+"')]/preceding-sibling::td[@class='rich-table-cell']/div/input)[2]"));
			   wb.click();
			 return this;
			}
		 
		  @Step("This method is used accept the alert popup")
			  public boolean assertAlertToAccept(String removeAttributeGroupsAlertText) {
			  boolean t = tu.getAlertText().trim().equals(removeAttributeGroupsAlertText.trim());
			  tu.alertAccept();
			  return t;  
			}
			 
			 public AttributeGroupsPageObjects verifyRemoveAttributeGroupsAlertMsg(String removeAttributeGroupsAlertText) {
			 Assert.assertTrue(assertAlertToAccept(removeAttributeGroupsAlertText));
			 return this;
			}
			 
			 @Step("This method is used accept the alert popup")
			  public AttributeGroupsPageObjects alertToAccept() {
			  waiting.explicitWaitForAlert(15);
			  tu.alertAccept();
			  return this;  
			}
			 
			 @Step("This method is used accept the alert popup")
			  public boolean assertAlertMsg(String alertText) {
			  boolean t = tu.getAlertText().trim().equals(alertText.trim());
			  tu.alertAccept();
			  return t;  
			}
			 
			 public AttributeGroupsPageObjects verifyAlertMsg(String alertText) {
				 Assert.assertTrue(assertAlertMsg(alertText));
				 return this;
			}
				
			 
			 @Step("This method is used verify the message after deleting the Attribute Group")
			 public AttributeGroupsPageObjects verifySuccessfulMessageAfterDeletionAttributeGroup(String attributeGroupRemovedSuccessfulMessage) {
			 waiting.explicitWaitVisibilityOfElement(deletedSuccessfulMessageOfAttributeGroupLocator, 15);
			 Assert.assertEquals(deletedSuccessfulMessageOfAttributeGroupLocator.getText().trim().equals(attributeGroupRemovedSuccessfulMessage.trim()),"Invalid  message. Getting "+deletedSuccessfulMessageOfAttributeGroupLocator.getText().trim()+".");
			 return this;
			}
		   
		   @Step("clicking on History link")
		   public AttributeGroupsPageObjects clickOnHistoryLinkInAttributeGroup() throws InterruptedException {
		   Thread.sleep(3000);
		   ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",historylinkLocator);
		   return this;
		   }
		   
		   @Step("This method is used verify the attribute group")
			 public AttributeGroupsPageObjects verifyAttributeGroup(String editAttributeGroupName) {
			 waiting.explicitWaitVisibilityOfElement(attributeGroupNameColumn, 15);
			 Assert.assertEquals(attributeGroupNameColumn.getText(), editAttributeGroupName);
			 return this;
			  }
			 
			 @Step("This method is used verify the update attribute Group")
			 public AttributeGroupsPageObjects verifyUpdateAttributeGroup(String updateAttributeGroupName) {
			 waiting.explicitWaitVisibilityOfElement(updateAttributeGroupNameColumn, 15);
			 System.out.println(updateAttributeGroupNameColumn.getText());
			 Assert.assertEquals(updateAttributeGroupNameColumn.getText(), updateAttributeGroupName);
			 return this;
			  }
			 
		   	  
		   @Step("verify pagination in Attributes page")
			public boolean verifyPaginationInAttributeGroupsPage() throws InterruptedException {
				int totalCount = Integer.parseInt(totalCountTextLocator.getText());
				boolean pagination=false;
				if(totalCount>1){
					int currentPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
					Assert.assertEquals(currentPageCount, 1);
					paginationNextLinkLocator.click();
					Thread.sleep(3000);
					
					int nextPageCount=Integer.parseInt(currentPageCountTextLocator.getText());
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
		   
		 
		   
		   public boolean assertUpdateAttributeGroupNameDeletion(String updateAttributeGroupName)
		   {
			   try
			   {
				   if(getDriver().findElement(By.xpath("updateAttributeGroupName")).isDisplayed())
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
			  
			public AttributeGroupsPageObjects verifyUpdateAttributeGroupDeletion(String updateAttributeGroupName){		   
			   Assert.assertTrue(assertUpdateAttributeGroupNameDeletion(updateAttributeGroupName),"Group name is not deleted");
			   return this;
			}
			   
			   
		   public boolean assertAttributeGroupNameDeletion(String attributeGroupName)
		   {
			   try
			   {
				   if(getDriver().findElement(By.xpath("attributeGroupName")).isDisplayed())
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
			  
			public AttributeGroupsPageObjects verifyAttributeGroupDeletion(String attributeGroupName){  
				Assert.assertTrue(assertAttributeGroupNameDeletion(attributeGroupName),"Group name is not deleted");
				return this;
			}
			
			@Step("enter {0} with text {1}. verify whether the value of the textbox contains {2} characters.")
			public AttributeGroupsPageObjects verifyTextboxValidation(String fieldName, String textToBeEnterInTheTextbox,int maximumNumberOfCharactersAcceptedByTheTexbox) throws InterruptedException  {
				
				switch(fieldName)
				{
				
				case "Attribute GroupName":
					Thread.sleep(4000);
					waiting.explicitWaitVisibilityOfElement(attributeGroupNameTextBoxLocator, 15);
					attributeGroupNameTextBoxLocator.click();
					attributeGroupNameTextBoxLocator.clear();
					attributeGroupNameTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
					Assert.assertEquals(attributeGroupNameTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
					break;
					
				case "Attribute GroupDes":
					Thread.sleep(4000);
					waiting.explicitWaitVisibilityOfElement(attributeGroupDesTextBoxLocator, 15);
					attributeGroupDesTextBoxLocator.sendKeys(textToBeEnterInTheTextbox);
					Assert.assertEquals(attributeGroupDesTextBoxLocator.getAttribute("value").trim(), textToBeEnterInTheTextbox.substring(0,Math.min(textToBeEnterInTheTextbox.length(),maximumNumberOfCharactersAcceptedByTheTexbox)));
					break;
				}
				
				return this;
			}
		  
        }
