package org.cimm2touch.utils;

import org.cimm2touch.maincontroller.MainController;

public class ApplicationSetUpPropertyFile extends MainController{

	
	public String getURL() throws Exception{
		String url = PropertyFileReader.propertiesReader(applicationSetUp, "url");
		return url;
		
	}
	
	
	public String getBrowser() throws Exception{
		String browser = PropertyFileReader.propertiesReader(applicationSetUp, "browser");
		return browser;
		
	}
	
	public String getProductName() throws Exception{
		String productName = PropertyFileReader.propertiesReader(applicationSetUp, "productName");
		return productName;
	}
}
