package org.cimm2touch.pageobjects.taxonomymanagement;

import org.cimm2touch.initializer.PageFactoryInitializer;
import org.framework.utils.TestUtility;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;

public class ImageUploadSectionPageObjects extends PageFactoryInitializer{
	

	Waiting waiting=new Waiting(getDriver());
	TestUtility tu=new TestUtility(getDriver());
	

	@FindBy(xpath=".//*[@id='main-item-container']/li[1]/figure/a/div[1]/div/img")   //((//ul[contains(@id,'main-item-container')]/li)[1]//a)[1]
	private WebElement imageLocatorSelection;
	
	@FindBy(xpath="//a[contains(text(),'Choose Existing Images from Repository')]")  
	private WebElement selectImageOptionToChooseFromRepLocation;

	
	@Step("select image from the repositorey.")
	public ImageUploadSectionPageObjects clickOnImageToSelectFromRep() throws InterruptedException {

		/*Set<String> set=getDriver().getWindowHandles();

		System.out.println(set.size());
		
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();*/

		//getDriver().switchTo().window("ifame");
		//getDriver().switchTo().frame(1);
		getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
		
	
		waiting.explicitWaitVisibilityOfElement(selectImageOptionToChooseFromRepLocation, 10);
		
		//((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",selectImageOptionToChooseFromRepLocation);
		
		selectImageOptionToChooseFromRepLocation.click();
		Thread.sleep(4000);
		
		return this;
	}
	@Step("select image from existing repository.")
	public ImageUploadSectionPageObjects SelectImageFromRepo() throws InterruptedException {

		waiting.explicitWaitVisibilityOfElement(imageLocatorSelection, 10);
		imageLocatorSelection.click();
		Thread.sleep(4000);
		return this;
	}
	

}
