package org.cimm2touch.pageobjects.adminstration;
import org.cimm2touch.initializer.PageFactoryInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SitesPageObjects extends PageFactoryInitializer{
		
	
	@FindBy(xpath="//span[contains(text(),'ACTIVE_TAXONOMY_VERSION')]/ancestor::td/following-sibling::td[1]/span")
	private WebElement defaultTaxonomyLocator;

	@Step("retrieving the taxonomy")
	public String getDefaultTaxonomy() {

		return defaultTaxonomyLocator.getText().trim();
	}

	public SitesPageObjects clickAddNewWebsite() {
		return this;
	}
}