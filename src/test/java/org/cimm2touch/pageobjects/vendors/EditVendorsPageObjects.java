/**
 * 
 */
package org.cimm2touch.pageobjects.vendors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.cimm2touch.utils.TestUtilityMethods;
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
public class EditVendorsPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	TestUtilityMethods utility = new TestUtilityMethods(getDriver());
	Waiting waiting = new Waiting(getDriver());
	TestUtility tu = new TestUtility(getDriver());

	@FindBy(xpath = "//input[@id='editSupplierForm:supplierName']")
	private WebElement editVendors_VendorName;

	@FindBy(xpath = "//input[@id='editSupplierForm:shortName']")
	private WebElement editVendors_ShortName;

	@FindBy(xpath = "//textarea[@id='editSupplierForm:address1']")
	private WebElement editVendors_Address1;

	@FindBy(xpath = "//input[@id='editSupplierForm:city']")
	private WebElement editVendors_City;

	@FindBy(xpath = "//input[@id='editSupplierForm:state']")
	private WebElement editVendors_State;

	@FindBy(xpath = "//input[@id='editSupplierForm:zip']")
	private WebElement editVendors_Zip;

	@FindBy(xpath = "//select[@id='editSupplierForm:country']")
	private WebElement editVendors_Country;

	@FindBy(xpath = "//input[@id='editSupplierForm:email']")
	private WebElement editVendors_Email;

	@FindBy(xpath = "//select[@id='editSupplierForm:subsetId']")
	private WebElement editVendors_SubsetName;

	@FindBy(xpath = "//input[@id='editSupplierForm:url']")
	private WebElement editVendors_URL;

	@FindBy(xpath = "//input[@id='editSupplierForm:taxid']")
	private WebElement editVendors_TaxID;

	@FindBy(xpath = "//select[@id='editSupplierForm:status']")
	private WebElement editVendors_Status;

	@FindBy(xpath = "//div[@id='editSupplierForm:supplierLogoUploadId']/descendant::div[contains(@id,'add') and contains(.,'Add Logo')]")
	private WebElement editVendors_AddLogo;

	@FindBy(xpath = "//div[@id='editSupplierForm:supplierLogoUploadId']/descendant::div[contains(@id,'upload') and contains(.,'Upload Logo')]")
	private WebElement editVendors_UploadLogo;

	@FindBy(xpath = "//a[@title='History']")
	private WebElement editVendors_History;

	@FindBy(xpath = "//input[@title='Update Vendor']")
	private WebElement editVendors_UpdateVendor;

	@FindBy(xpath = "//input[@title='Go Back']")
	private WebElement editVendors_BackButton;

	@Step("To Verify Edit Vendors Page Items")
	public EditVendorsPageObjects verifyEditVendorsPageItems() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(editVendors_VendorName.isDisplayed(),
				"Vendor Name Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_ShortName.isDisplayed(),
				"Short Name Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_Address1.isDisplayed(), "Address Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_City.isDisplayed(), "City Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_State.isDisplayed(), "State Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_Zip.isDisplayed(), "Zip Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_Country.isDisplayed(), "Country Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_SubsetName.isDisplayed(),
				"Subset Name Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_URL.isDisplayed(), "URL Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_TaxID.isDisplayed(), "Tax ID Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_Status.isDisplayed(), "Status Field is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_AddLogo.isDisplayed(), "Add Logo Button is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_History.isDisplayed(), "History Button is not Displayed in Edit Vendors Page.");
		Assert.assertTrue(editVendors_UpdateVendor.isDisplayed(),
				"Update Vendor Button is not Displayed in Edit Vendors Page.");
		return this;
	}

	@Step("To Verify Message after Updating Vendor without Vendors Name")
	public EditVendorsPageObjects verifyMessageOnUpdatingVendorsWithoutName(String vendorNameMessage) throws Exception {
		editVendors_VendorName.clear();
		editVendors_UpdateVendor.click();
		Thread.sleep(5000);

		assertThat(getDriver()
				.findElement(By
						.xpath("//input[@id='editSupplierForm:supplierName']/following-sibling::span[contains(@style,'red')]"))
				.getText(), containsString(vendorNameMessage));
		return this;
	}

	@Step("To Verify Message after Updating Vendor without Short Name")
	public EditVendorsPageObjects verifyMessageOnUpdatingVendorsWithoutShortName(String shortNameMessage)
			throws Exception {
		editVendors_ShortName.clear();
		editVendors_UpdateVendor.click();
		Thread.sleep(5000);

		assertThat(getDriver()
				.findElement(By
						.xpath("//input[@id='editSupplierForm:shortName']/following-sibling::span[contains(@style,'red')]"))
				.getText(), containsString(shortNameMessage));
		return this;
	}

	@Step("To Verify Message after Updating Vendor without Address1")
	public EditVendorsPageObjects verifyMessageOnUpdatingVendorsWithoutAddress1(String address1Message)
			throws Exception {
		editVendors_Address1.clear();
		editVendors_UpdateVendor.click();
		Thread.sleep(5000);

		assertThat(getDriver()
				.findElement(By
						.xpath("//textarea[@id='editSupplierForm:address1']/following-sibling::span[contains(@style,'red')]"))
				.getText(), containsString(address1Message));
		return this;
	}

	@Step("To Verify Message after Updating Vendor without Email ID")
	public EditVendorsPageObjects verifyMessageOnUpdatingVendorsWithoutEmail(String emailMessage) throws Exception {
		editVendors_Email.clear();
		editVendors_UpdateVendor.click();
		Thread.sleep(5000);

		assertThat(getDriver()
				.findElement(By
						.xpath("//input[@id='editSupplierForm:email']/following-sibling::span[contains(@style,'red')]"))
				.getText(), containsString(emailMessage));
		return this;
	}

	@Step("To Click On History Button")
	public EditVendorsPageObjects clickOnHistoryButton() {
		editVendors_History.click();

		tu.alertAccept();
		return this;
	}

	@Step("To Switch to Newly Opened Window and Verify the {0} Vendor Name and Switch Back to Primary Window")
	public EditVendorsPageObjects switchToNewlyOpenedWindowAndVerifyVendorName(String vendorsName) throws Exception {
		Thread.sleep(2000);

		utility.switchToRecentWindow();
		Thread.sleep(2000);
		Assert.assertTrue(getDriver().findElement(By.xpath(
				"//div[@class='tableLayout']/table/tbody/tr/descendant::tr/td[contains(.,'" + vendorsName + "')]"))
				.isDisplayed());
		Thread.sleep(5000);
		utility.switchBackToFirstWindow();
		utility.switchToRecentWindow(0);
		return this;
	}

	@Step("To Click on Back Button in the Edit Vendors Page")
	public EditVendorsPageObjects clickOnBackButtonInEditVendorsPage() {
		editVendors_BackButton.click();
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
