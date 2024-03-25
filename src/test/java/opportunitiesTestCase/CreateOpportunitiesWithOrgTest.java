package opportunitiesTestCase;

import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.OpprtunitiesPage;
import pageObject.OrganisationPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateOpportunitiesWithOrgTest extends BaseClass {

	@Test
	public void createOpportunityTest() throws Exception {

		RandomUtils ru = new RandomUtils();
		String opprtunitiesName = ru.potentialName();
		String orgname = ru.companyName();
		
		Dashboard db = new Dashboard(driver);
		
		//Creating Organization
		db.clickOnOrganisation();
		
		OrganisationPage org = new OrganisationPage(driver);
		org.createOrganisation(driver, orgname);
		
		//Creating opportunities
		db.clickOnOpportunitiesLink();
		
		OpprtunitiesPage op = new OpprtunitiesPage(driver);
		op.createOpportunitiesWithOrg(driver,opprtunitiesName, orgname);
		
	}
}
