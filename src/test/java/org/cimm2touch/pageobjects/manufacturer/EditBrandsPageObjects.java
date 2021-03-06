
package org.cimm2touch.pageobjects.manufacturer;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Thiruveedhi Chinna
 *
 */
public class EditBrandsPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());

	@FindBy(xpath = "//select[@id='EditBrandForm:manufacturerListComboId']")
	private WebElement tab_GeneralInfo;

	@FindBy(xpath = "//select[@id='EditBrandForm:manufacturerListComboId']")
	private WebElement tab_CustomFields;

	@FindBy(xpath = "//select[@id='EditBrandForm:manufacturerListComboId']")
	private WebElement editBrand_ManufacturerName;

	@FindBy(xpath = "//input[@id='EditBrandForm:brandId']")
	private WebElement editBrand_BrandName;

	@FindBy(xpath = "//textarea[@id='EditBrandForm:bDesc']")
	private WebElement editBrand_BrandDesc;

	@FindBy(xpath = "//input[@id='EditBrandForm:statusBooleanId' and @type='checkbox']")
	private WebElement editBrand_BrandActiveStatus;

	@FindBy(xpath = "//input[@id='EditBrandForm:brandUrlInputText']")
	private WebElement editBrand_BrandURL;

	@FindBy(xpath = "//td/div/div[@id='EditBrandForm:itemImageUploadId:add1']")
	private WebElement editBrand_AddLogo;

	@FindBy(xpath = "//td/div/div[@id='EditBrandForm:itemImageUploadId:upload1']")
	private WebElement editBrand_UploadLogo;

	@FindBy(xpath = "//input[@id='EditBrandForm:delBrandLogo']")
	private WebElement editBrand_DeleteLogo;

	@FindBy(xpath = "//input[@title='Update Brand']")
	private WebElement editBrand_UpdateBrand;

	@FindBy(xpath = "//input[@id='EditBrandForm:btnReset']")
	private WebElement editBrand_ResetBrands;

	@Step("To Verify the 'Edit Page' Items")
	public EditBrandsPageObjects verifyEditBrandsPageItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(editBrand_ManufacturerName.isDisplayed(), "Manufacturer Name Field is not Displaying");
		Assert.assertTrue(editBrand_BrandName.isDisplayed(), "Brand Name Field is not Displaying");
		Assert.assertTrue(editBrand_BrandDesc.isDisplayed(), "Brand Desc Field is not Displaying");
		Assert.assertTrue(editBrand_BrandActiveStatus.isDisplayed(), "Manufacturer Name Field is not Displaying");
		Assert.assertTrue(editBrand_BrandURL.isDisplayed(), "Brand Active Status Checkbox is not Displaying");
		Assert.assertTrue(editBrand_AddLogo.isDisplayed(), "Add Logo Button is not Displaying");
		Assert.assertTrue(editBrand_DeleteLogo.isDisplayed(), "Delete Logo Button is not Displaying");
		Assert.assertTrue(editBrand_UpdateBrand.isDisplayed(), "Update Brands Button is not Displaying");
		Assert.assertTrue(editBrand_ResetBrands.isDisplayed(), "Reset Brands Button is not Displaying");
		return this;
	}

	@Step("To Clear the 'Brand Name' Field")
	public EditBrandsPageObjects clearEditBrandsField() {
		editBrand_BrandName.clear();
		return this;
	}

	@Step("To Update the Editied Brands")
	public EditBrandsPageObjects clickOnUpdateBrand() {
		editBrand_UpdateBrand.click();
		return this;
	}

	@Step("To Update the Editied Brands")
	public EditBrandsPageObjects verifyTheMessageAfterSavingBrandWithoutName(String errorMessage) throws Exception {
		Thread.sleep(5000);

		assertThat(getDriver()
				.findElement(By
						.xpath("//input[@id='EditBrandForm:brandId']//following-sibling::span[contains(@style,'red')]"))
				.getText(), containsString(errorMessage));
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand Name'")
	public EditBrandsPageObjects verifyCharacterLimitForEditBrandName() {

		waiting.explicitWaitVisibilityOfElement(editBrand_BrandName, 5);
		editBrand_BrandName.clear();
		for (int i = 0; i < 100; i++) {
			editBrand_BrandName.sendKeys("0");
		}
		String enteredText = editBrand_BrandName.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(editBrand_BrandName.getAttribute("maxlength")));
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand Desc'")
	public EditBrandsPageObjects verifyCharacterLimitForEditBrandDesc() {

		waiting.explicitWaitVisibilityOfElement(editBrand_BrandDesc, 5);
		editBrand_BrandDesc.clear();
		for (int i = 0; i < 500; i++) {
			editBrand_BrandDesc.sendKeys("0");
		}
		String enteredText = editBrand_BrandDesc.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, 500);
		return this;
	}

	@Step("To Verify the Character Limit for 'Brand Desc'")
	public EditBrandsPageObjects verifyCharacterLimitForEditBrandURL() {

		waiting.explicitWaitVisibilityOfElement(editBrand_BrandURL, 5);
		editBrand_BrandURL.clear();
		for (int i = 0; i < 400; i++) {
			editBrand_BrandURL.sendKeys("0");
		}
		String enteredText = editBrand_BrandURL.getAttribute("value");
		int enteredTextLength = enteredText.length();
		Assert.assertEquals(enteredTextLength, Integer.parseInt(editBrand_BrandURL.getAttribute("maxlength")));
		return this;
	}

	@Step("To Click on Back Button'")
	public EditBrandsPageObjects clickOnBackButtonInEditBrandsPage() {

		getDriver()
				.findElement(By
						.xpath("//div[@class='breadCrumbs']/ul/li/form/input[@type='image'and @title='Goto PreviousPage']"))
				.click();
		return this;
	}

	@Step("To Click on Custom Fields Tab'")
	public EditBrandsPageObjects clickOnCustomFieldsTab() {

		waiting.explicitWaitVisibilityOfElement(tab_CustomFields, 5);
		tab_CustomFields.click();
		return this;
	}
	// Chinna Code Ends

	// Priya Code Begins

	// Priya Code Ends

	// Rameshwar Code Begins

	// Rameshwar Code Ends

	// Vadi Code Begins

	// Vadi Code Ends
}
