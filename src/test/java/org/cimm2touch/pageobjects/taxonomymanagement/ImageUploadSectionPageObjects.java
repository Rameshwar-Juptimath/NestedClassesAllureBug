package org.cimm2touch.pageobjects.taxonomymanagement;

import org.cimm2touch.maincontroller.PageFactoryInitializer;
import org.cimm2touch.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;

public class ImageUploadSectionPageObjects extends PageFactoryInitializer{
	
	@FindBy(xpath=".//*[@id='main-item-container']/li[1]/figure/a/div[1]/div/img")   //((//ul[contains(@id,'main-item-container')]/li)[1]//a)[1]
	private WebElement imageLocatorSelection;
	
	@FindBy(xpath="//a[contains(text(),'Choose Existing Images from Repository')]")  
	private WebElement selectImageOptionToChooseFromRepLocation;

	
	@Step("select image from the repositorey.")
	public ImageUploadSectionPageObjects clickOnImageToSelectFromRep() throws InterruptedException {
		/*Set<String> set=driver.getWindowHandles();
		System.out.println(set.size());
		
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();*/
		//driver.switchTo().window("ifame");
		//driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
	
		Waiting.explicitWaitVisibilityOfElement(selectImageOptionToChooseFromRepLocation, 10);
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",selectImageOptionToChooseFromRepLocation);
		
		selectImageOptionToChooseFromRepLocation.click();
		Thread.sleep(4000);
		
		return this;
	}
	@Step("select image from existing repository.")
	public ImageUploadSectionPageObjects SelectImageFromRepo() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(imageLocatorSelection, 10);
		imageLocatorSelection.click();
		Thread.sleep(4000);
		return this;
	}
	

}
