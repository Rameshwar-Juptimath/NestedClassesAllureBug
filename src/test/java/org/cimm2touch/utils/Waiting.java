package org.cimm2touch.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cimm2touch.maincontroller.MainController;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * @author Hemanth.Sridhar
 */
public class Waiting extends MainController{

	public static void explicitWaitElementToBeClickable(WebElement element, int time){
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitElementToBeSelected(WebElement element, int time){
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public static void explicitWaitTextToBePresentInElement(WebElement element, int time,String text){
		new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void explicitWaitTitleContains(WebElement element, int time,String title){
		new WebDriverWait(driver, time).until(ExpectedConditions.titleContains(title));
	}
	
	public static void explicitWaitTitleIs(WebElement element, int time,String title){
		new WebDriverWait(driver, time).until(ExpectedConditions.titleIs(title));
	}
	
	public static void explicitWaitVisibilityOfElement(WebElement element, int time){
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitSelectionStateToBe(WebElement element, int time,boolean selected){
		new WebDriverWait(driver, time).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}
	public static void explicitWaitForAlert(int time){
		new WebDriverWait(driver, time).until(ExpectedConditions.alertIsPresent());
	}

	public static void explicitWaitVisibilityOfElements(List<WebElement> element, int time)
	{	
		new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void FluentWaitForVisibilityOfElement(int TotalTimeInSeconds, int PollingTimeInMilliSeconds, WebElement element)
	{
		FluentWait<WebDriver> waitForElement = new FluentWait<WebDriver>(driver)
				.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliSeconds,TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
				
		waitForElement.until(ExpectedConditions.visibilityOf(element));
	}
}
