package org.cimm2touch.initializer;
import org.cimm2touch.pageobjects.landingpage.LandingPageObjects;
import org.cimm2touch.pageobjects.manufacturer.EditBrandsPageObjects;
import org.cimm2touch.pageobjects.manufacturer.EditManufacturerPageObjects;
import org.cimm2touch.pageobjects.manufacturer.ManufacturerPageObjects;
import org.cimm2touch.pageobjects.products.AddNewProductPageObjects;
import org.cimm2touch.pageobjects.products.EditProductsPageObjects;
import org.cimm2touch.pageobjects.products.ProductEditPageObjects;
import org.cimm2touch.pageobjects.products.ProductItemsPageObjects;
import org.cimm2touch.pageobjects.products.ProductsListPageObjects;
import org.cimm2touch.pageobjects.products.ProductsPageObjects;
import org.cimm2touch.pageobjects.adminstration.SystemSettingsPageObjects;
import org.cimm2touch.pageobjects.items.AddNewItemPageObjects;
import org.cimm2touch.pageobjects.items.EditItemsPageObjects;
import org.cimm2touch.pageobjects.items.HistoryPageObjects;
import org.cimm2touch.pageobjects.items.ItemsPageObjects;
import org.cimm2touch.pageobjects.userconfiguration.UserConfigurationPageObjects;
import org.cimm2touch.pageobjects.vendors.EditVendorsPageObjects;
import org.cimm2touch.pageobjects.vendors.VendorsPageObjects;
import org.framework.maincontroller.CallApplication;
import org.framework.maincontroller.MainController;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributeGroupsPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.AttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.CategoryAndAttributesPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.ImageUploadSectionPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.ManageTaxonomyPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyMappingPageObjects;
import org.cimm2touch.pageobjects.taxonomymanagement.TaxonomyPageObjects;
import org.cimm2touch.pageobjects.uom.UOMPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.cimm2touch.pageobjects.subset.CatalogBuilderPageObjects;
import org.cimm2touch.pageobjects.subset.SubsetPageObjects;
import org.cimm2touch.pageobjects.homepage.HomePageObjects;

public class PageFactoryInitializer extends CallApplication
{
	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(getDriver(),HomePageObjects.class);
		return homePage;
	}

	public LandingPageObjects landingPage()
	{
		LandingPageObjects landingPage = PageFactory.initElements(getDriver(),LandingPageObjects.class);
		return landingPage;
	}

	public SubsetPageObjects subsetPage()
	{
		SubsetPageObjects subsetPage = PageFactory.initElements(getDriver(), SubsetPageObjects.class);
		return subsetPage;
	}
	public CatalogBuilderPageObjects catalogBuilderPage()
	{
		CatalogBuilderPageObjects catalogBuilderPage = PageFactory.initElements(getDriver(), CatalogBuilderPageObjects.class);
		return catalogBuilderPage;
	}

	public ItemsPageObjects itemsPage()
	{
		ItemsPageObjects ItemsPage = PageFactory.initElements(getDriver(), ItemsPageObjects.class);
		return ItemsPage;
	}

	public AddNewItemPageObjects addNewItemPage()
	{
		AddNewItemPageObjects addNewItemPage = PageFactory.initElements(getDriver(),AddNewItemPageObjects.class);
		return addNewItemPage;
	}

	public SystemSettingsPageObjects systemSettingsPage()
	{
		SystemSettingsPageObjects systemSettingsPage = PageFactory.initElements(getDriver(),SystemSettingsPageObjects.class);
		return systemSettingsPage;
	}

	public EditItemsPageObjects editItemsPage()
	{
		EditItemsPageObjects editItemsPage = PageFactory.initElements(getDriver(),EditItemsPageObjects.class);
		return editItemsPage;
	}

	public HistoryPageObjects historyPage()
	{
		HistoryPageObjects historyPage = PageFactory.initElements(getDriver(),HistoryPageObjects.class);
		return historyPage;
	}

	public ProductsPageObjects productsPage()
	{
		ProductsPageObjects productsPage = PageFactory.initElements(getDriver(),ProductsPageObjects.class);
		return productsPage;
	}

	public ProductsListPageObjects productsListPage()
	{
		ProductsListPageObjects productsPage = PageFactory.initElements(getDriver(),ProductsListPageObjects.class);
		return productsPage;
	}

	public EditProductsPageObjects editProductsPage()
	{
		EditProductsPageObjects editProductsPage = PageFactory.initElements(getDriver(),EditProductsPageObjects.class);
		return editProductsPage;
	}

	public ManufacturerPageObjects manufacturersAndBrandsPage()
	{
		ManufacturerPageObjects manufacturerPage = PageFactory.initElements(getDriver(),ManufacturerPageObjects.class);
		return manufacturerPage;
	}
	
	public EditManufacturerPageObjects editManufacturersPage()
	{
		EditManufacturerPageObjects editManufacturersPage = PageFactory.initElements(getDriver(),EditManufacturerPageObjects.class);
		return editManufacturersPage;
	}
	
	public EditBrandsPageObjects editBrandsPage()
	{
		EditBrandsPageObjects editBrandsPage = PageFactory.initElements(getDriver(),EditBrandsPageObjects.class);
		return editBrandsPage;
	}
	

	public AddNewProductPageObjects addNewProductPage(){

		AddNewProductPageObjects addNewProductPage=PageFactory.initElements(getDriver(),AddNewProductPageObjects.class);
		return addNewProductPage;
	}
	
	public ProductEditPageObjects editProductPage()
	{
		ProductEditPageObjects editProductPage=PageFactory.initElements(getDriver(),ProductEditPageObjects.class);
		return editProductPage;
	}
	
	public ProductItemsPageObjects productItemPage()
	{
		ProductItemsPageObjects productItemPage=PageFactory.initElements(getDriver(),ProductItemsPageObjects.class);
		return productItemPage;
	}

	public TaxonomyPageObjects taxonomyPageObjects()
	{
		TaxonomyPageObjects taxonomyPageObjects = PageFactory.initElements(getDriver(),TaxonomyPageObjects.class);
		return taxonomyPageObjects;
	}

	public ManageTaxonomyPageObjects manageTaxonomyPageObjects()
	{
		ManageTaxonomyPageObjects manageTaxonomyPageObjects = PageFactory.initElements(getDriver(),ManageTaxonomyPageObjects.class);
		return manageTaxonomyPageObjects;
	}

	public TaxonomyPageObjects taxonomyPage()
	{
		TaxonomyPageObjects taxonomyPage=PageFactory.initElements(getDriver(),TaxonomyPageObjects.class);
		return taxonomyPage;
	}

	public TaxonomyMappingPageObjects taxonomyMappingPage()
	{
		TaxonomyMappingPageObjects taxonomyMappingPage=PageFactory.initElements(getDriver(),TaxonomyMappingPageObjects.class);
		return taxonomyMappingPage;
	}
	
	public AttributeGroupsPageObjects attributeGroupsPage()
	{
		AttributeGroupsPageObjects attributeGroupsPage=PageFactory.initElements(getDriver(),AttributeGroupsPageObjects.class);
		return attributeGroupsPage;
	}
	
	public AttributesPageObjects attributesPage()
	{
		AttributesPageObjects attributesPage=PageFactory.initElements(getDriver(),AttributesPageObjects.class);
		return attributesPage;
	}

	public ManageTaxonomyPageObjects manageTaxonomyPage()
	{
		ManageTaxonomyPageObjects manageTaxonomyPage = PageFactory.initElements(getDriver(),ManageTaxonomyPageObjects.class);
		return manageTaxonomyPage;
	}

	public CategoryAndAttributesPageObjects categoryAndAttributesPage()
	{
		CategoryAndAttributesPageObjects categoryAndAttributesPage=PageFactory.initElements(getDriver(),CategoryAndAttributesPageObjects.class);	
		return categoryAndAttributesPage;
	}

	public ImageUploadSectionPageObjects imageUploadPage()
	{
		ImageUploadSectionPageObjects imageUploadPage=PageFactory.initElements(getDriver(),ImageUploadSectionPageObjects.class);	
		return imageUploadPage;
	}

	public VendorsPageObjects vendorsPage()
	{
		VendorsPageObjects vendorPage=PageFactory.initElements(getDriver(),VendorsPageObjects.class);
		return vendorPage;
	}
	
	public EditVendorsPageObjects editVendorsPage()
	{
		EditVendorsPageObjects editVendorsPage=PageFactory.initElements(getDriver(),EditVendorsPageObjects.class);
		return editVendorsPage;
	}
	public UserConfigurationPageObjects userConfigPage(){
		
		UserConfigurationPageObjects userConfigPage=PageFactory.initElements(getDriver(), UserConfigurationPageObjects.class);
		return userConfigPage;
	}
	public UOMPageObjects uomPage()
	{
		UOMPageObjects uompage = PageFactory.initElements(getDriver(), UOMPageObjects.class);
		return uompage;
	}
}
