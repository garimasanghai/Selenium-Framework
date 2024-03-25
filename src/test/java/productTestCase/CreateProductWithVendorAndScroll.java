package productTestCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.ProductPage;
import pageObject.VendorPage;
import randomUtils.RandomUtils;
import utils.BaseClass;
import utils.ReadDataFromExcelFile;

public class CreateProductWithVendorAndScroll extends BaseClass { //test driven

	@Test(dataProvider = "getData") // method name
	public void createProductWithVendorTest(String glAccountDrpvalue) throws Exception {
	
		RandomUtils ru = new RandomUtils(); // 1st page will be called only once for each module link
		String vendorName = ru.vendorName();

		Dashboard db = new Dashboard(driver); // 2nd page will be called asa u want to click on another module link
		// Creating Vendor
		db.clickOnVendorLink(driver);

		VendorPage vp = new VendorPage(driver); // 3rd page will be called once
		vp.createVendor(vendorName);
		
		db.clickOnProductLink();

		String productName = ru.productName();
		String date = ru.currentDateInFormatted();
		String amt = ru.getPrice();
		
		ProductPage pp = new ProductPage(driver);
		pp.createProductWithVendorAndScroll(driver, productName, date, vendorName, glAccountDrpvalue, amt);

	}

	@DataProvider
	public Object[][] getData() throws Exception {
		return ReadDataFromExcelFile.readMultipleDataFromExcel("GLAccount");
		// u can write this type of return statement only if the method is static
	}
}
