/**
 * 
 */
package org.cimm2touch.utils;

import org.framework.maincontroller.MainController;
import org.framework.utils.PropertyFileReader;

/**
 * @author Thiruveedhi chinna
 *
 */
public class TaxonomyDataPropertyFile extends MainController
{
	private String taxonomyName = PropertyFileReader.propertiesReader(TaxonomyData, "TaxonomyName");
	private String invalidTaxonomyName =  PropertyFileReader.propertiesReader(TaxonomyData, "InvalidTaxonomyName");
	private String taxonomyTableHeaders=PropertyFileReader.propertiesReader(TaxonomyData, "taxonomyTableHeaders");
	private String taxonomyDescription=PropertyFileReader.propertiesReader(TaxonomyData, "taxonomyDescription");
	private String errorOnTaxonomyCreationWithoutName=PropertyFileReader.propertiesReader(TaxonomyData, "errorMessageOnTaxonomyCreationWithoutName");
	private String errorOnTaxonomyCreationWithoutDesc=PropertyFileReader.propertiesReader(TaxonomyData, "errorMessageOnTaxonomyCreationWithoutDesc");
	private String enterMoreThan30CharactersForTaxonomyName=PropertyFileReader.propertiesReader(TaxonomyData, "charactersLimitTaxonomyName");
	
	public String getTaxonomyName() 
	{
		return taxonomyName;
	}

	public String getInvalidTaxonomyName()
	{
		return invalidTaxonomyName;
	}

	public String getTaxonomyTableHeaders() 
	{
		return taxonomyTableHeaders;
	}

	public String getTaxonomyDescription() 
	{
		return taxonomyDescription;
	}

	public String getErrorOnTaxonomyCreationWithoutName() 
	{
		return errorOnTaxonomyCreationWithoutName;
	}

	public String getErrorOnTaxonomyCreationWithoutDesc() 
	{
		return errorOnTaxonomyCreationWithoutDesc;
	}

	public String getEnterMoreThan30CharactersForTaxonomyName() 
	{
		return enterMoreThan30CharactersForTaxonomyName;
	}

}
