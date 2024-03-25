package orgTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.OrganisationPage;
import randomUtils.RandomUtils;
import utils.BaseClass;
import utils.GenericMethod;
import utils.ReadDataFromExcelFile;

public class CreateOrganisationWithIndustry extends BaseClass {

	@Test(dataProvider ="getData")
	public void createOrgTest(String industryType) throws Exception {
		
		
		RandomUtils ru = new RandomUtils();
		String orgName = ru.companyName();

		Dashboard d = new Dashboard(driver);
		d.clickOnOrganisation();

		OrganisationPage op = new OrganisationPage(driver);
		Thread.sleep(3000);
		op.createOrgWithIndustry(driver, orgName, industryType);

	}
	
	
	@DataProvider
	public Object[][] getData() throws Exception {
		return ReadDataFromExcelFile.readMultipleDataFromExcel("IndustryType");
		// u can write this type of return statement only if the method is static
	}
}
