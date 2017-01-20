package org.cimm2touch.pageobjects.items;

import java.util.List;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CopyOfItemPageObjects extends PageFactoryInitializer {

	// Chinna Code Begins
	Waiting waiting = new Waiting(getDriver());
	TestUtility utility = new TestUtility(getDriver());

	@FindAll(value = {
			@FindBy(xpath = "//tbody[@id='copyOfItemFormId:optionsTable:tb']/descendant::td[@class='rich-table-cell ']") })
	private List<WebElement> itemDataTabsNames;

	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement saveCopyItemsLocator;

	@FindBy(xpath = "//input[@id='copyOfItemFormId:btnReset']")
	private WebElement resetCopyItemsLink;

	@Step("verify input fields {0} of copy items page")
	public CopyOfItemPageObjects verifyCopyItemInputFields(String inputFieldNames) throws InterruptedException {
		Thread.sleep(3000);
		String[] fields = inputFieldNames.split(",");

		for (int i = 0; i < fields.length; i++) {
			waiting.explicitWaitVisibilityOfElement(
					By.xpath("//table[@class='CopyItemsTable']/descendant::td[contains(text(),'" + fields[i] + "')]"),
					30);
			Assert.assertTrue(getDriver()
					.findElement(By.xpath(
							"//table[@class='CopyItemsTable']/descendant::td[contains(text(),'" + fields[i] + "')]"))
					.isDisplayed(), "" + fields[i] + " was not displayed");

		}
		return this;
	}

	public CopyOfItemPageObjects verifyItemInFormationTabs(String itemInfoTabs) {

		String[] tabNames = itemInfoTabs.split(",");
		for (int i = 0; i < itemDataTabsNames.size(); i++) {
			// System.out.println(itemDataTabsNames.get(i).getText().trim());
			Assert.assertEquals(itemDataTabsNames.get(i).getText().trim(), tabNames[i].trim());
		}
		return this;
	}

	@Step("validate input fields{0}")
	public CopyOfItemPageObjects validateInputFields(String inputField, String testData) {

		WebElement wb = getDriver()
				.findElement(By.xpath("//table[@class='CopyItemsTable']/descendant::input[contains(@id,'" + inputField
						+ "') and @type='text']"));

		Assert.assertEquals(wb.getAttribute("value").trim(), testData,
				" input field " + inputField + "was not taking the enterde " + testData + "value.");

		return this;
	}

	@Step("enter search data for respective{0} field")
	public CopyOfItemPageObjects enterSearchDataForRespectiveField(String inputField, String testData)
			throws Exception {

		switch (inputField) {
		case "partNumber":
			WebElement wb1 = getDriver()
					.findElement(By.xpath("//table[@class='CopyItemsTable']/descendant::input[contains(@id,'"
							+ inputField + "') and @type='text']"));
			wb1.clear();
			wb1.sendKeys(testData);
			break;
		case "noOfCopies":
			WebElement wb2 = getDriver()
					.findElement(By.xpath("//table[@class='CopyItemsTable']/descendant::input[contains(@id,'"
							+ inputField + "') and @type='text']"));
			wb2.clear();
			wb2.sendKeys(testData);
			break;
		default:
			throw new Exception("invalid input");

		}
		return this;
	}

	@Step("verify error message {0}")
	public CopyOfItemPageObjects verifyErrorMessage(String expErrorMessage) {
		Assert.assertEquals(getDriver().findElement(By.xpath("//span[contains(text(),'" + expErrorMessage + "')]"))
				.getText().trim(), expErrorMessage.trim());
		return this;
	}

	@Step("click on save copy items link")
	public CopyOfItemPageObjects clickOnSaveCopyItem() throws InterruptedException {
		waiting.explicitWaitElementToBeClickable(saveCopyItemsLocator, 40);
		saveCopyItemsLocator.click();
		Thread.sleep(2000);
		utility.alertAccept();
		return this;
	}

	@Step("click on reset icon")
	public CopyOfItemPageObjects clickOnResetCopyItemsLink() {
		waiting.explicitWaitElementToBeClickable(resetCopyItemsLink, 30);
		resetCopyItemsLink.click();

		return this;
	}

	@Step("verify reset functionality")
	public CopyOfItemPageObjects verifyResetFunctionality(String fieldName, String testData) {

		WebElement wb = getDriver()
				.findElement(By.xpath("//table[@class='CopyItemsTable']/descendant::input[contains(@id,'" + fieldName
						+ "') and @type='text']"));
		Assert.assertTrue(wb.getAttribute("value").isEmpty(),
				"" + fieldName + " is not getting cleared.expected fields get cleared but Actual value was: "
						+ wb.getAttribute("value") + "");

		return this;
	}

	@Step("verify save success message {0} for copy items")
	public CopyOfItemPageObjects verifySaveSuccessMessage(String saveSuccessMessage) {
		waiting.explicitWaitVisibilityOfElement(By.xpath("//span[contains(text(),'" + saveSuccessMessage + "')]"), 40);

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
