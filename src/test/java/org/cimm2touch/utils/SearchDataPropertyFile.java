package org.cimm2touch.utils;

import org.framework.maincontroller.MainController;
import org.framework.utils.PropertyFileReader;

public class SearchDataPropertyFile extends MainController {
	
	// Chinna Code Begins
	private String numberOfRecordsToDisplay;

	PropertyFileReader propertyFileReader = new PropertyFileReader();
	
	// Chinna Code Ends
	
	// Priya Code Begins

	// Priya Code Ends

	// Vadi Code Begins
	
	// Vadi Code Ends
	
	//Rameshwar Code Begins
	private String loginData="resources/LoginData.properties";
	private String productData="resources/ProductData.properties";
	private String workbookData="resources/WorkbookData.properties";
	
	private String userName = propertyFileReader.propertiesReader(loginData, "userName");
	private String password = propertyFileReader.propertiesReader(loginData, "password");
	private String welcomeMessage = propertyFileReader.propertiesReader(loginData, "welcomeMessage");
	
	private String productName = propertyFileReader.propertiesReader(productData, "productName");
	private String productNumber = propertyFileReader.propertiesReader(productData, "productNumber");
	private String productCreationSuccessMsg = propertyFileReader.propertiesReader(productData, "productCreationSuccessMsg");
	
	private String workbookName = propertyFileReader.propertiesReader(workbookData, "workbookName");
	private String workbookCreationSuccessMsg = propertyFileReader.propertiesReader(workbookData, "workbookCreationSuccessMsg");
	
	public void setNumberOfRecordsToDisplay(String numberOfRecordsToDisplay) {
		this.numberOfRecordsToDisplay = numberOfRecordsToDisplay;

	}

	public String getNumberOfRecordsToDisplay() {
		return numberOfRecordsToDisplay;
	}

	public void setTheNumberofRecordsToDisplay(String numberOfRecordsToDisplay) {
		this.numberOfRecordsToDisplay = numberOfRecordsToDisplay;
	}

	public String getUsername(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public String getWelcomeMessage(){
		return welcomeMessage;
	}
	
	public String getProductName(){
		return productName;
	}
	public String getProductNumber(){
		return productNumber;
	}
	public String getProductCreationSuccessMsg(){
		return productCreationSuccessMsg;
	}
	
	
	public String getWorkbookName(){
		return workbookName;
	}
	
	public String getWorkbookCreationSuccessMsg(){
		return workbookCreationSuccessMsg;
	}
	//Rameshwar Code Ends
}
