package opportunitiesTestCase;

import org.testng.annotations.Test;

import pageObject.ContactPage;
import pageObject.Dashboard;
import pageObject.OpprtunitiesPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateOpportunitiesWithContactTest extends BaseClass {

	@Test
	public void createOpportunityTest1() throws Exception {

		RandomUtils ru = new RandomUtils();
		String opprtunitiesName = ru.potentialName();
		String contactName = ru.contactName();

		Dashboard db = new Dashboard(driver);

		// Creating Contact
		db.clickOnContactLink();

		ContactPage cp = new ContactPage(driver);
		cp.createContact(driver, contactName);

		// Creating opportunities
		db.clickOnOpportunitiesLink();

		OpprtunitiesPage op = new OpprtunitiesPage(driver);
		op.createOpportunitiesWithContacts(driver, opprtunitiesName, contactName);

	}
}
