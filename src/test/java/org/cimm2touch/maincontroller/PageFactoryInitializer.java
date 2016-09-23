package org.cimm2touch.maincontroller;
import org.cimm2touch.pageobjects.landingpage.LandingPageObjects;
import org.cimm2touch.pageobjects.manufacturer.ManufacturerPageObjects;
import org.cimm2touch.pageobjects.products.AddNewProductPageObjects;
import org.cimm2touch.pageobjects.products.ProductEditPageObjects;
import org.cimm2touch.pageobjects.products.ProductItemsPageObjects;
import org.cimm2touch.pageobjects.products.ProductsListPageObjects;
import org.cimm2touch.pageobjects.adminstration.SystemSettingsPageObjects;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;
import org.cimm2touch.pageobjects.items.AddNewItemPageObjects;
import org.cimm2touch.pageobjects.items.EditItemsPageObjects;
import org.cimm2touch.pageobjects.items.HistoryPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.products.EditProductsPageObjects;
import org.cimm2touch.pageobjects.products.ProductsPageObjects;
import org.cimm2touch.pageobjects.subset.SubsetPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyPageObjects;
import org.cimm2touch.pageobjects.vendors.VendorPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributeGroupsPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.CategoryAndAttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.ImageUploadSectionPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.ManageTaxonomyPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyMappingPageObjects;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryInitializer extends MainController
{
	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
		return homePage;
	}

	public LandingPageObjects landingPage()
	{
		LandingPageObjects landingPage = PageFactory.initElements(driver,LandingPageObjects.class);
		return landingPage;
	}

	public SubsetPageObjects subsetPage()
	{
		SubsetPageObjects subsetPage = PageFactory.initElements(driver, SubsetPageObjects.class);
		return subsetPage;
	}

	public ItemsPageObjects itemsPage()
	{
		ItemsPageObjects ItemsPage = PageFactory.initElements(driver, ItemsPageObjects.class);
		return ItemsPage;
	}

	public AddNewItemPageObjects addNewItemPage()
	{
		AddNewItemPageObjects addNewItemPage = PageFactory.initElements(driver,AddNewItemPageObjects.class);
		return addNewItemPage;
	}

	public SystemSettingsPageObjects systemSettingsPage()
	{
		SystemSettingsPageObjects systemSettingsPage = PageFactory.initElements(driver,SystemSettingsPageObjects.class);
		return systemSettingsPage;
	}

	public EditItemsPageObjects editItemsPage()
	{
		EditItemsPageObjects editItemsPage = PageFactory.initElements(driver,EditItemsPageObjects.class);
		return editItemsPage;
	}

	public HistoryPageObjects historyPage()
	{
		HistoryPageObjects historyPage = PageFactory.initElements(driver,HistoryPageObjects.class);
		return historyPage;
	}

	public ProductsPageObjects productsPage()
	{
		ProductsPageObjects productsPage = PageFactory.initElements(driver,ProductsPageObjects.class);
		return productsPage;
	}

	public ProductsListPageObjects productsListPage()
	{
		ProductsListPageObjects productsPage = PageFactory.initElements(driver,ProductsListPageObjects.class);
		return productsPage;
	}

	public EditProductsPageObjects editProductsPage()
	{
		EditProductsPageObjects editProductsPage = PageFactory.initElements(driver,EditProductsPageObjects.class);
		return editProductsPage;
	}

	public ManufacturerPageObjects manufacturerPage()
	{
		ManufacturerPageObjects manufacturerPage = PageFactory.initElements(driver,ManufacturerPageObjects.class);
		return manufacturerPage;
	}

	public AddNewProductPageObjects addNewProductPage(){

		AddNewProductPageObjects addNewProductPage=PageFactory.initElements(driver,AddNewProductPageObjects.class);
		return addNewProductPage;
	}
	public ProductEditPageObjects editProductPage()
	{
		ProductEditPageObjects editProductPage=PageFactory.initElements(driver,ProductEditPageObjects.class);
		return editProductPage;
	}
	
	public ProductItemsPageObjects productItemPage()
	{
		ProductItemsPageObjects productItemPage=PageFactory.initElements(driver,ProductItemsPageObjects.class);
		return productItemPage;
	}

	public TaxonomyPageObjects taxonomyPageObjects()
	{
		TaxonomyPageObjects taxonomyPageObjects = PageFactory.initElements(driver,TaxonomyPageObjects.class);
		return taxonomyPageObjects;
	}

	public ManageTaxonomyPageObjects manageTaxonomyPageObjects()
	{
		ManageTaxonomyPageObjects manageTaxonomyPageObjects = PageFactory.initElements(driver,ManageTaxonomyPageObjects.class);
		return manageTaxonomyPageObjects;
	}

	public TaxonomyPageObjects taxonomyPage()
	{
		TaxonomyPageObjects taxonomyPage=PageFactory.initElements(driver,TaxonomyPageObjects.class);
		return taxonomyPage;
	}

	public TaxonomyMappingPageObjects taxonomyMappingPage()
	{
		TaxonomyMappingPageObjects taxonomyMappingPage=PageFactory.initElements(driver,TaxonomyMappingPageObjects.class);
		return taxonomyMappingPage;
	}
	
	public AttributeGroupsPageObjects attributeGroupsPage()
	{
		AttributeGroupsPageObjects attributeGroupsPage=PageFactory.initElements(driver,AttributeGroupsPageObjects.class);
		return attributeGroupsPage;
	}
	
	public AttributesPageObjects attributesPage()
	{
		AttributesPageObjects attributesPage=PageFactory.initElements(driver,AttributesPageObjects.class);
		return attributesPage;
	}

	public ManageTaxonomyPageObjects manageTaxonomyPage()
	{
		ManageTaxonomyPageObjects manageTaxonomyPage = PageFactory.initElements(driver,ManageTaxonomyPageObjects.class);
		return manageTaxonomyPage;
	}

	public CategoryAndAttributesPageObjects categoryAndAttributesPage()
	{
		CategoryAndAttributesPageObjects categoryAndAttributesPage=PageFactory.initElements(driver,CategoryAndAttributesPageObjects.class);	
		return categoryAndAttributesPage;
	}

	public ImageUploadSectionPageObjects imageUploadPage()
	{
		ImageUploadSectionPageObjects imageUploadPage=PageFactory.initElements(driver,ImageUploadSectionPageObjects.class);	
		return imageUploadPage;
	}

	public VendorPageObjects vendorsPage()
	{
		VendorPageObjects vendorPage=PageFactory.initElements(driver,VendorPageObjects.class);
		return vendorPage;
	}

}
