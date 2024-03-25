package contactTestCase;

import org.testng.annotations.Test;

import pageObject.ContactPage;
import pageObject.Dashboard;
import pageObject.OrganisationPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateContactWithOrganisationTest extends BaseClass {
	
		@Test
		public void createContactwithOrganisation() throws Exception {
			//common data
			RandomUtils ru = new RandomUtils();
			String contactName = ru.contactName();
			String orgname = ru.companyName();
			
			Dashboard db = new Dashboard(driver);
			
			//Creating new org 
			db.clickOnOrganisation();
			
			OrganisationPage op = new OrganisationPage(driver);
			op.createOrganisation(driver, orgname);
			
			//creating contact with organisation
			db.clickOnContactLink();
			ContactPage cp =new ContactPage(driver);
			cp.createContactWithOrg(driver, contactName, orgname);
		}

	
	
}
