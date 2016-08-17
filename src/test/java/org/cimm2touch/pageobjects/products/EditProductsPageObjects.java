/**
 * 
 */
package org.cimm2touch.pageobjects.products;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.cimm2touch.utils.SearchDataPropertyFile;
import org.cimm2touch.utils.TestUtility;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class EditProductsPageObjects  extends PageFactoryInitializer{
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindAll(value={@FindBy(xpath="//td[@onmouseout='RichFaces.outTab(this);']")})
	private List<WebElement> productPageTabsLocator;
	

	@FindBy(xpath="//td[contains(text(),'General Info')]")
	private WebElement generalInfoTabLocator;
	
	@FindBy(xpath="//td[contains(text(),'Product Images')]")
	private WebElement productImagesTabLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='tabContainerLabel']")})
	private List<WebElement> fieldNamesInGeneralInfoTabLocator;
	
	@FindAll(value={@FindBy(xpath="//th[@class='rich-table-subheadercell']")})
	private List<WebElement> fieldNamesInProductImagesTabLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='tabContainerLabel']")})
	private List<WebElement> fieldNamesInAddNewProductImageLocator;
	
	@FindBy(xpath="//textarea[@name='editProductForm:eproductCustomKeywordsId']")
	private WebElement productEditCustomKeywordsTextBoxLocator;
	
	@FindBy(xpath="//input[@title='Update Product']")
	private WebElement productUpdateButtonLocator;
	
	@FindBy(xpath="//span[contains(text(),'Updated Successfully')]")
	private WebElement  productUpdateSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement addNewProductImageLocator;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement imageDescTextBoxLocator;
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement productImageURLTextBoxLocator;
	
	@FindBy(xpath="//input[@title='Save URL']")
	private WebElement saveProductImageURLLocator;
	
	@FindBy(xpath="//span[contains(text(),'Product Image URL saved Successfully')]")
	private WebElement  ImageURLSavedSuccessfulMessageLocator;
	
	@FindBy(xpath="//input[@id='editProductForm:eproductNameId']")
	private WebElement updateProductNameTextBoxLocator;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	private WebElement productImageCheckboxLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement productImageLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement saveUrlIconLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement resetIconLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement orTextLocator;
	
	@FindBy(xpath="//input[@title='Add New Product Image']")
	private WebElement overwriteImageTextLocator;
	
	@FindBy(xpath="//div[@id='editProductImageTabForm:productImageUploadId:upload2']")
	private WebElement uploadImageLinkLocator;
	
	@FindBy(xpath="//input[@id='lnkditmSrchIdf:searchKeywordId']")
	private WebElement searchForItemsListFieldLocator;
	
	@FindBy(xpath="//a[@id='lnkditmSrchIdf:goBtn']")
	private WebElement searchIconLocator;
	
	@FindBy(xpath="//input[@id='lnkditmSrchIdf:manufacturerListComboIdcomboboxButton']")
	private WebElement manufacturerDropDownLocator;
	
	@FindBy(xpath="//input[@id='lnkditmSrchIdf:brandListComboIdcomboboxButton']")
	private WebElement brandDropDownLocator;
	
	@FindBy(xpath="//input[@title='Save Items To Product ']")
	private WebElement saveIconLocator;
	
	@FindBy(xpath="//td[contains(text(),'Item List')]")
	private WebElement itemListTabLocator;
	
	@FindBy(xpath="//input[@title='???delPrdctImg???']")
	private WebElement removeProductImageLocator;
	
	@FindBy(id="editProductImageTabForm:productImageUploadId:flashContainer")
	private WebElement productUploadImageLocator;
	
	 @Step("This method is used verify product page all tabs")
	 public EditProductsPageObjects verifyProductsPageTabs() throws Exception{
	
		String productPageTabsNames[] =data.getProductPageTabsNames().split(",");
		
		for(int i=0;i<productPageTabsLocator.size();i++)
		{
			Assert.assertEquals(productPageTabsLocator.get(i).getText().trim(), productPageTabsNames[i].trim());
		}
		return this;
     }
	
	  @Step("This method is used verify General Info tab")
	  public EditProductsPageObjects clickOnGeneralInfoTab() throws Exception {
		   	Waiting.explicitWaitVisibilityOfElement(generalInfoTabLocator, 6);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",generalInfoTabLocator);
			return this;
	  }
	
	  @Step("This method is used verify FieldNames InGeneralInfoTab")
	  public EditProductsPageObjects verifyFieldNamesInGeneralInfoTab() throws Exception{
			
			String fieldNamesInGeneralInfoTab[] =data.getFieldNamesInGeneralInfoTab().split(",");
			
			for(int i=0;i<fieldNamesInGeneralInfoTabLocator.size();i++)
			{
				Assert.assertEquals(fieldNamesInGeneralInfoTabLocator.get(i).getText().trim(), fieldNamesInGeneralInfoTab[i].trim());
			}
			return this;
	     }
	  
	  @Step("This method is used verify Product Images tab")
		public EditProductsPageObjects clickOnProductImagesTab() throws Exception {
		   	Waiting.explicitWaitVisibilityOfElement(productImagesTabLocator, 6);
		   	productImagesTabLocator.click();
			return this;
	  }
	  
	  @Step("This method is used verify FieldNames InProductImagesTab")
	  public EditProductsPageObjects verifyFieldNamesInProductImagesTab() throws Exception{
			
			String fieldNamesInProductImagesTab[] =data.getFieldNamesInProductImagesTab().split(",");
			
			for(int i=0;i<fieldNamesInProductImagesTabLocator.size();i++)
			{
				Assert.assertEquals(fieldNamesInProductImagesTabLocator.get(i).getText().trim(), fieldNamesInProductImagesTab[i].trim());
			}
			 
			return this;
	     }
	  
	  @Step("This method is used verify display of product image checkbox in ProductImagesTab")
		public EditProductsPageObjects verifyProductImageCheckbox() {
		 	Waiting.explicitWaitVisibilityOfElement(productImageCheckboxLocator, 6);
		    Assert.assertTrue(productImageCheckboxLocator.isDisplayed(),"productImageCheckbox link is not displayed.");
			return this;
		}
	  
	  @Step("This method is used verify display of AddNewProductImage link in ProductImagesTab")
		public EditProductsPageObjects verifyAddNewProductImage() {
		   Assert.assertTrue(productImageLocator.isDisplayed(),"AddNewProductImage link is not displayed.");
			return this;
		}
	  
	  @Step("This method is used verify Add New Product Image")
		public EditProductsPageObjects clickOnAddNewProductImage() throws Exception {
		   	Waiting.explicitWaitVisibilityOfElement(addNewProductImageLocator, 15);
		   	
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",addNewProductImageLocator);
			return this;
	    }
	  
	  @Step("This method is used verify FieldNames InAddNewProductImage")
	  public EditProductsPageObjects verifyFieldNamesInAddNewProductImage() throws Exception{
			
			String fieldNamesInAddNewProductImage[] =data.getFieldNamesInAddNewProductImage().split(",");
			
			for(int i=0;i<fieldNamesInAddNewProductImageLocator.size();i++)
			{
				Assert.assertEquals(fieldNamesInAddNewProductImageLocator.get(i).getText().trim(), fieldNamesInAddNewProductImage[i].trim());
			}
			  
			return this;
	     }
	  
	  @Step("verify display of saveUR Icon in AddNewProductImage")
		public EditProductsPageObjects verifySaveURIconInAddNewProductImage() {
		 	
		  Assert.assertTrue(saveUrlIconLocator.isDisplayed(),"saveUR Icon is not displayed.");
			return this;
		}
	  
	  @Step("verify display of Reset Icon in AddNewProductImage")
		public EditProductsPageObjects verifyResetIconInAddNewProductImage() {
		  Assert.assertTrue(resetIconLocator.isDisplayed()," Reset Icon is not displayed.");
			return this;
		}
	  
	  @Step("verify display of OR Text in AddNewProductImage")
		public EditProductsPageObjects verifyORTextInAddNewProductImage() {	
		  Assert.assertTrue(orTextLocator.isDisplayed(),"saveUR Icon is not displayed.");
			return this;
		}
	  
	  @Step("verify display of Overwrite Image text in AddNewProductImage")
		public EditProductsPageObjects verifyOverwriteImageTextInAddNewProductImage() {
		  Assert.assertTrue(overwriteImageTextLocator.isDisplayed()," Overwrite Image text is not displayed.");
			return this;
		}
	  
	  
	  @Step("This method is used verify Item List tab")
		public EditProductsPageObjects clickOnItemListTab() throws Exception {
		   	Waiting.explicitWaitVisibilityOfElement(itemListTabLocator, 15);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",itemListTabLocator);
			return this;
	  }
	  
	  @Step("This method is used verify edit ProductName Field ")
	  public EditProductsPageObjects editProductNameField(String updateProductName) {
			 Waiting.explicitWaitVisibilityOfElement(updateProductNameTextBoxLocator, 15);
			 updateProductNameTextBoxLocator.sendKeys(updateProductName);
			 return this;
		}
	  
	   @Step("This method is used verify Produc UpdateButton Link ")
	   public EditProductsPageObjects clickOnProducUpdateButtonLink() {
			 Waiting.explicitWaitVisibilityOfElement(productUpdateButtonLocator, 60);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",productUpdateButtonLocator);
		     return this;
		    }
	  
	   @Step("This method is used verify Produc Update Saved SuccessfulMessage ")
	   public EditProductsPageObjects verifyProductUpdateSavedSuccessfulMessage(String productUpdateSuccessfulMessage) { 
		   	 Waiting.explicitWaitVisibilityOfElement(productUpdateSavedSuccessfulMessageLocator, 6);
		     Assert.assertTrue(productUpdateSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(productUpdateSuccessfulMessage),"Invalid  message. Getting "+productUpdateSavedSuccessfulMessageLocator.getText().trim()+".");
		     return this;
			}
	  
	   @Step("This method is used verify Produc ImageDesc Field ")
	   public EditProductsPageObjects enterImageDescField(String textToBeEnterInImageDesc) {
			 Waiting.explicitWaitVisibilityOfElement(imageDescTextBoxLocator, 15);
			 imageDescTextBoxLocator.sendKeys(textToBeEnterInImageDesc);
			 return this;
			}
		  
	   @Step("This method is used verify Produc ImageURL Field")
	   public EditProductsPageObjects enterProductImageURLField(String textToBeEnterInProductImageURL) {
			Waiting.explicitWaitVisibilityOfElement(productImageURLTextBoxLocator, 15);
			productImageURLTextBoxLocator.sendKeys(textToBeEnterInProductImageURL);
			return this;
			}
		  
	   @Step("This method is used verify Produc SaveImageURL Link ")
	   public EditProductsPageObjects clickOnSaveImageURLLink() {
			Waiting.explicitWaitVisibilityOfElement(saveProductImageURLLocator, 60);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",saveProductImageURLLocator);
			return this;
			}
	  
	  @Step("This method is used verify Produc UploadImage Link ") 
	  public EditProductsPageObjects clickOnUploadImageLink() throws Exception { 
		   Waiting.explicitWaitVisibilityOfElement(uploadImageLinkLocator, 15);
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click();",uploadImageLinkLocator);
			Thread.sleep(10000);
			return this;
			}
	   
	   
	   @Step("This method is used verify Produc FileUpload")
		  public EditProductsPageObjects verifyFileUpload(String fileLocation) throws Exception{
		   Thread.sleep(2000);
		   WebElement imageButton = driver.findElement(By.xpath("//td/div[contains(@class,'fileupload')]/descendant::div[text()='Image']"));
		   Actions action = new Actions(driver);
		   action.click(imageButton).build().perform();
		   Thread.sleep(2500);
		   Robot robot = new Robot();
		   StringSelection ss = new StringSelection(fileLocation);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		   robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);	
           Thread.sleep(2500);
		  return this;
			   }
	   
	  @Step("This method is used verify Produc UpdateButton Link ")
	  public EditProductsPageObjects verifyImageURLSavedSuccessfulMessage(String imageURLSuccessfulMessage) {
			 Waiting.explicitWaitVisibilityOfElement(ImageURLSavedSuccessfulMessageLocator, 6);
			 Assert.assertTrue(ImageURLSavedSuccessfulMessageLocator.getText().trim().equalsIgnoreCase(imageURLSuccessfulMessage),"Invalid  message. Getting "+ImageURLSavedSuccessfulMessageLocator.getText().trim()+".");
			 return this;	
		   }

	  
	  @Step("This method is used verify the searchForItemsList Field")
		    public EditProductsPageObjects verifySearchForItemsListField() {
		    Waiting.explicitWaitVisibilityOfElement(searchForItemsListFieldLocator, 10);
		    Assert.assertTrue(searchForItemsListFieldLocator.isDisplayed(),"searchForItemsList Field is not displayed.");
		    return this;
	      }
	  
	  @Step("This method is used verify the SearchIcon ")
	       public EditProductsPageObjects verifySearchIconLocator() {
		   Waiting.explicitWaitVisibilityOfElement(searchIconLocator, 10);
	       Assert.assertTrue(searchIconLocator.isDisplayed(),"searchForItemsList Field is not displayed.");
	       return this;
          }
	  
	  
	  @Step("This method is used verify the manufacturerDropDown")
	       public EditProductsPageObjects verifyManufacturerDropDown() {	
	       Assert.assertTrue(manufacturerDropDownLocator.isDisplayed(),"manufacturerDropDown is not displayed.");
	       return this;
          }

	  @Step("This method is used verify the brandDropDown")
          public EditProductsPageObjects verifyBrandDropDown() {	
          Assert.assertTrue(brandDropDownLocator.isDisplayed(),"brandDropDown is not displayed.");
          return this;
          }
	  
	 @Step("This method is used verify the saveIcon")
          public EditProductsPageObjects verifySaveIcon() {	
          Assert.assertTrue(saveIconLocator.isDisplayed(),"saveIcon is not displayed.");
          return this;
        }
	 
	@Step("This method is used verify the itemListTab")
          public EditProductsPageObjects verifyitemListTab() {	
          Assert.assertTrue(itemListTabLocator.isDisplayed(),"itemListTab is not displayed.");
          return this;
        }
	
	 @Step("This method is used to remove the product image")
	     public EditProductsPageObjects clickOnRemoveProductImage() {
		 Waiting.explicitWaitVisibilityOfElement(removeProductImageLocator, 10);
		 removeProductImageLocator.click();
	     return this;
	   }
	 
	 @Step("This method is used accept the alert popup")
	    public EditProductsPageObjects alertToAccept() {
	    Waiting.explicitWaitForAlert(15);
	    TestUtility.alertAccept();
	    return this; 
	   }
		  
		
}

