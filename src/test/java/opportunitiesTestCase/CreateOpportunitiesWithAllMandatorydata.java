package opportunitiesTestCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.OpprtunitiesPage;
import pageObject.OrganisationPage;
import randomUtils.RandomUtils;
import utils.BaseClass;
import utils.ReadDataFromExcelFile;

public class CreateOpportunitiesWithAllMandatorydata extends BaseClass {

	@Test(dataProvider = "getData" )// method name
	public void createOpportunityTest(String salesStageDrpValue) throws Exception {

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
		op.createOpportunitiesWithMandatoryFields(driver, opprtunitiesName, orgname, salesStageDrpValue);
}
	
	@DataProvider
	public Object[][]getData() throws Exception {
		return ReadDataFromExcelFile.readMultipleDataFromExcel("SalesStage");
		// u can write this type of return statement only if the method is static
	}
}