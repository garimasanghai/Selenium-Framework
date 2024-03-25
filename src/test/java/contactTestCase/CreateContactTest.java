package contactTestCase;

import org.testng.annotations.Test;

import pageObject.ContactPage;
import pageObject.Dashboard;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test
	public void createContactTest() throws Exception {

		RandomUtils ru = new RandomUtils();
		String contactName = ru.contactName();

		Dashboard db = new Dashboard(driver);
		db.clickOnContactLink();

		ContactPage cp = new ContactPage(driver);
		cp.createContact(driver, contactName);
	}

}
