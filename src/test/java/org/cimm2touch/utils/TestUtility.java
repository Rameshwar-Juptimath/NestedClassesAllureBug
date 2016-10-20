
package org.cimm2touch.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.cimm2touch.maincontroller.MainController;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestUtility extends MainController {

	
	
	public static void openPageInNewTab() throws AWTException {
		Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	}

	public static void fileUpload(String fileLocation) throws AWTException {
		
		 StringSelection stringSelection = new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   Robot robot;
		   
		   robot = new Robot();
		   robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_C);
           robot.keyRelease(KeyEvent.VK_C);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);
           
		}
	

	public static void closeCurrentTab() {
		driver.close();
		
	}

	public static void closeAllTabsExceptFirst() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=1;i<tabs.size();i++)
		{	
	    driver.switchTo().window(tabs.get(i));
	    driver.close();
		}
		driver.switchTo().window(tabs.get(0));
	}

	public static void switchToDialogBox(){
		
	    driver.switchTo().window(driver.getWindowHandle());
	    
	}
	public static void switchToRecentWindow()
	{
		//String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		//driver.switchTo().window(winHandleBefore);
	}
	
	public static void switchToRecentWindow(int windowIndex)
	{
		//String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(windowIndex));
		//driver.switchTo().window(winHandleBefore);
	}
	
	public static void switchBackToFirstWindow() throws Exception{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}


	public static void printAllTheWindows() {
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		for(String window : al)
		{
			System.out.println(window);
		}
		
	}

	public static void hitEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public static void alertAccept() {
		Waiting.explicitWaitForAlert(5);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void selectByVisibleText(WebElement element, String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElement element, int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void mouseHoverActions(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void doubleClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public static void clickAndHoldActions(WebElement element)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
	}
	
	public static String getAlertText()
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText().trim();
		return alertText;
	}

	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		Waiting.explicitWaitForAlert(5);
		alert.dismiss();
		
	}

	public static void verifyToolTip(WebElement element, String expectedToolTip) {
		Assert.assertEquals(element.getAttribute("title").trim(),"Print this page");
		
	}
	
	public static void maximizeScreen(WebDriver driver) {
 	    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 	    Point position = new Point(0, 0);
 	    driver.manage().window().setPosition(position);
 	    Dimension maximizedScreenSize =
 	        new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
 	    driver.manage().window().setSize(maximizedScreenSize);
 	  }
	
	public static void waitforElementPresent(String elementname,int timeout) throws Exception {
		  
		for (int second = 1;second <timeout; second++) 
		{
			Thread.sleep(100);
			try
			{ 
				driver.findElement(By.xpath(elementname));
				System.out.println("Element found at"+second);
				break; 
			} 
			catch (Exception e) {
				System.out.println("Element not found at sec"+second);
				
			}
	  	}
	  
	 }
	
public static void DragandDrop(WebElement source,WebElement Target) throws InterruptedException {
	
		
		Actions builder = new Actions(driver);
		
		elementHighlight(source);
		builder.clickAndHold(source).build().perform();
		Thread.sleep(2000);
		elementHighlight(Target);
		builder.moveToElement(Target, 0, 0).build().perform();
		builder.moveToElement(Target, 0, 5).build().perform();
		builder.moveToElement(Target, 0, 10).build().perform();
		builder.moveToElement(Target, 0, 15).build().perform();
		builder.release().build().perform();
		Thread.sleep(4000);
	}

public static void elementHighlight(WebElement element) {
	for (int i = 0; i < 2; i++) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].setAttribute('style', arguments[1]);",
				element, "color: red; border: 3px solid red;");
		js.executeScript(
				"arguments[0].setAttribute('style', arguments[1]);",
				element, "");
	}
}

//"this will work similar to assertElementnotPresent" - assert if element not present
	public static boolean assertElementPresent(WebElement elementname) throws Exception {
		
		if(elementname.isDisplayed())
		{
			return true;
		}
		
		else{
			throw new Exception("Element is not present");
		}
	}
	
	 public static boolean assertElementnotPresent(WebElement elementname) throws Exception {
		  if(elementname.isDisplayed())
		  {
		   return true;
		  }
		  else{		   
		   throw new Exception("Element is not present");
		  }		   
		 }
}
