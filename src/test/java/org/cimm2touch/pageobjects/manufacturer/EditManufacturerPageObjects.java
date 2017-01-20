
package org.cimm2touch.pageobjects.manufacturer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

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
public class EditManufacturerPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	TestUtility tu = new TestUtility(getDriver());
	Waiting waiting = new Waiting(getDriver());

	@FindBy(xpath = "//div[@class='breadCrumbs']//input[@type='image' and @title='Goto PreviousPage']")
	private WebElement editManu_BackButton;

	@FindBy(xpath = "//td[@id='ManfGInfoTab_lbl']")
	private WebElement tabs_GeneralInfo;

	@FindBy(xpath = "//td[@id='mfCfTab_lbl']")
	private WebElement tabs_CustomFields;

	@FindBy(xpath = "//input[@id='EditManufacturerForm:manfName']")
	private WebElement editManu_ManufacturerName;

	@FindBy(xpath = "//input[@id='EditManufacturerForm:manfCode']")
	private WebElement editManu_ManufacturerCode;

	@FindBy(xpath = "//input[@id='EditManufacturerForm:activeId']")
	private WebElement editManu_ManufacturerActiveStatus;

	@FindBy(xpath = "//div[@id='EditManufacturerForm:mnfLogoUploadId:add1']")
	private WebElement editManu_AddLogo;

	@FindBy(xpath = "//div[@id='EditManufacturerForm:mnfLogoUploadId:upload1']")
	private WebElement editManu_UploadLogo;

	@FindBy(xpath = "//input[@id='EditManufacturerForm:delManufactureLogo']")
	private WebElement editManu_DeleteLogo;

	@FindBy(xpath = "//div[@id='listShuttleForm:assignSupplierListShuttlecontentBox']")
	private WebElement editManu_SuppliersTable;

	@FindBy(xpath = "//div[@id='listShuttleForm:assignSupplierListShuttlecontentBox']//following::div[contains(@id,'copyAll')]/div/a/div")
	private WebElement editManu_SuppliersTable_CopyAll;

	@FindBy(xpath = "//div[@id='listShuttleForm:assignSupplierListShuttlecontentBox']//following::div[@id='listShuttleForm:assignSupplierListShuttlecopy']/div/a/div")
	private WebElement editManu_SuppliersTable_Copy;

	@FindBy(xpath = "//div[@id='listShuttleForm:assignSupplierListShuttlecontentBox']//following::div[@id='listShuttleForm:assignSupplierListShuttledisremoveAll']/div")
	private WebElement editManu_SuppliersTable_RemoveAll;

	@FindBy(xpath = "//div[@id='listShuttleForm:assignSupplierListShuttlecontentBox']//following::div[@id='listShuttleForm:assignSupplierListShuttledisremove']/div")
	private WebElement editManu_SuppliersTable_Remove;

	@FindBy(xpath = "//div[@class='float-right']/input[contains(@src,'save')]")
	private WebElement editManu_UpdateManufacturer;

	@FindBy(xpath = "//div[@class='float-right']/input[@title='Reset']")
	private WebElement editManu_ResetManufacturer;

	@Step("To Verify the 'Edit Manufacturer Page' Items")
	public EditManufacturerPageObjects verifyEditManufacturersAndBrandsPageItems() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(tabs_GeneralInfo.isDisplayed(), "General Info TAB is not Displayed");
		Assert.assertTrue(tabs_CustomFields.isDisplayed(), "Custom Fields TAB is not Displayed");
		Assert.assertTrue(editManu_ManufacturerName.isDisplayed(), "Manufacturer Name Field is not Displayed");
		Assert.assertTrue(editManu_ManufacturerCode.isDisplayed(), "Manufacturer Code Field is not Displayed");
		Assert.assertTrue(editManu_ManufacturerActiveStatus.isDisplayed(),
				"Manufacturer Active Status Checkbox is not Displayed");
		Assert.assertTrue(editManu_AddLogo.isDisplayed(), "Manufacturer Add Logo is not Displayed");
		Assert.assertTrue(editManu_DeleteLogo.isDisplayed(), "Manufacturer Delete Logo is not Displayed");
		Assert.assertTrue(editManu_UpdateManufacturer.isDisplayed(), "Update Manufacturer Button is not Displayed");
		Assert.assertTrue(editManu_ResetManufacturer.isDisplayed(), "Reset Manufacturer Button is not Displayed");
		return this;
	}

	@Step("To Clear Manufacturer Name")
	public EditManufacturerPageObjects clearEditManufacturerNameField() {

		waiting.explicitWaitElementToBeClickable(editManu_ManufacturerName, 5);

		editManu_ManufacturerName.clear();
		return this;
	}

	@Step("To Update Edited Manufacturer")
	public EditManufacturerPageObjects clickOnUpdateEditedManufacturer() {

		waiting.explicitWaitElementToBeClickable(editManu_UpdateManufacturer, 5);
		editManu_UpdateManufacturer.click();
		return this;
	}

	@Step("To Verify the Message after Updating Manufacturer without Name")
	public EditManufacturerPageObjects verifyMessageAfterUpdatingManufacturer(String errorMessage) throws Exception {
		Thread.sleep(5000);

		assertThat(getDriver().findElement(By.xpath("//span[@id='EditManufacturerForm:MName']")).getText(),
				containsString(errorMessage));
		return this;
	}

	@Step("To Click on 'Back Button' in Edit Manufacturer's Page")
	public EditManufacturerPageObjects clickOnBackButtonInEditPage() {

		waiting.explicitWaitElementToBeClickable(editManu_BackButton, 5);
		editManu_BackButton.click();
		return this;
	}

	@Step("To Verify the Message after Updating Manufacturer without Name")
	public EditManufacturerPageObjects clickOnCustomFieldsTab() {

		waiting.explicitWaitElementToBeClickable(tabs_CustomFields, 5);
		tabs_CustomFields.click();
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
