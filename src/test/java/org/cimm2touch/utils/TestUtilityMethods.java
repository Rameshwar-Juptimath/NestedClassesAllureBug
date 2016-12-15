
package org.cimm2touch.utils;

import java.util.ArrayList;

import org.framework.maincontroller.MainController;
import org.framework.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class TestUtilityMethods extends MainController {
		
	
	WebDriver driver;
	Waiting waiting = new Waiting(getDriver());
	public TestUtilityMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	
	


		public  void switchToRecentWindow()
	{
		//String winHandleBefore = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs.get(1));
		//getDriver().switchTo().window(winHandleBefore);
	}
	
	public  void switchToRecentWindow(int windowIndex)
	{
		//String winHandleBefore = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs.get(windowIndex));
		//getDriver().switchTo().window(winHandleBefore);
	}
	
	public  void switchBackToFirstWindow() throws Exception{
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(0));
	}

	
	public  void doubleClick(WebElement element)
	{
		Actions action = new Actions(getDriver());
		action.doubleClick(element).build().perform();
	}
	
	public  void waitforElementPresent(String elementname,int timeout) throws Exception {
		  
		for (int second = 1;second <timeout; second++) 
		{
			Thread.sleep(100);
			try
			{ 
				getDriver().findElement(By.xpath(elementname));
				System.out.println("Element found at"+second);
				break; 
			} 
			catch (Exception e) {
				System.out.println("Element not found at sec"+second);
				
			}
	  	}
	  
	 }
	
public  void DragandDrop(WebElement source,WebElement Target) throws InterruptedException {
	
		
		Actions builder = new Actions(getDriver());
		
		elementHighlight(source);
		builder.clickAndHold(source).build().perform();
		Thread.sleep(2000);
		elementHighlight(Target);
		builder.moveToElement(Target, 40, 0).build().perform();
		
		Thread.sleep(4000);
		
		builder.moveToElement(Target, 50, 40).build().perform();
		Thread.sleep(4000);
		builder.release().build().perform();
		Thread.sleep(4000);
	}

public  void elementHighlight(WebElement element) {
	for (int i = 0; i < 2; i++) {
		
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].setAttribute('style', arguments[1]);",
				element, "color: red; border: 3px solid red;");
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].setAttribute('style', arguments[1]);",
				element, "");
	}
}

	public  boolean assertElementPresent(WebElement elementname) throws Exception {
		
		if(elementname.isDisplayed())
		{
			return true;
		}
		
		else{
			throw new Exception("Element is not present");
		}
	}
	
	 public  boolean assertElementnotPresent(WebElement elementname) throws Exception {
		  if(elementname.isDisplayed())
		  {
		   return true;
		  }
		  else{		   
		   throw new Exception("Element is not present");
		  }		   
		 }
}
