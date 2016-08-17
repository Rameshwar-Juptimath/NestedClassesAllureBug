package org.cimm2touch.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.cimm2touch.maincontroller.MainController;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

/*
 * @author Hemanth.Sridhar
 */
public class Screenshot extends MainController {
	
public static void captureScreenShot(WebDriver driver, String screenshotName,ITestResult testResult) throws IOException{
	String s = "";
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
	for(int i =0;i<testResult.getParameters().length;i++){
		if(!s.isEmpty())
		{
			s += ",";
		}
		s += testResult.getParameters()[i].toString();
	}
	
	File dest = new File(outputFolder + "/"+screenshotName+"_"+s+".png");
	
	FileUtils.copyFile(src,dest);
}
}
