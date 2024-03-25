package productTestCase;

import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.ProductPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws Exception {
		RandomUtils ru = new RandomUtils();
		
		String productName = ru.productName();
		String date =ru.currentDateInFormatted();
		// storing it in ref variable and passing that in args while calling the main method
		
		Dashboard db = new Dashboard(driver);
		db.clickOnProductLink();
		
		ProductPage pp= new ProductPage(driver);
		pp.createProduct(driver, productName,date);
	}
}
