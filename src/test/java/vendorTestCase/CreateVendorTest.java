package vendorTestCase;

import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.VendorPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateVendorTest extends BaseClass {

	// creating an object of Random Class, Dashboard class and the PageObject class
	@Test
	public void createVendorTest() throws Exception {
		RandomUtils ru = new RandomUtils();
		String vendorName = ru.vendorName();

		Dashboard db = new Dashboard(driver);
		db.clickOnVendorLink(driver);

		VendorPage vp = new VendorPage(driver);
		vp.createVendor( vendorName);

	}
}
