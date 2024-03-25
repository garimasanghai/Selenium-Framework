package orgTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.OrganisationPage;
import randomUtils.RandomUtils;
import utils.BaseClass;

public class CreateOrgTest extends BaseClass{
	
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createOrgTest() throws Exception {
		RandomUtils ru = new RandomUtils();
		
		String orgName = ru.companyName();
		
		Dashboard d = new Dashboard(driver);
		
		d.clickOnOrganisation();
		
		OrganisationPage op = new OrganisationPage(driver);
		op.createOrganisation(driver, orgName);
		
		//Assertions
		
		String headerText = op.getcreatedOrgText();
		Assert.assertTrue(headerText.contains(headerText));
	
	}

}
