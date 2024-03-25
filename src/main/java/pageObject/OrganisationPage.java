package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethod;

public class OrganisationPage extends GenericMethod{
	
WebDriver driver;
	
	@FindBy(xpath = "//img[contains(@title , 'Create Organization')]")
	private WebElement createOrganisationPlusBtn;
	
	@FindBy(name = "accountname")
	private WebElement accountNametext;
	
	@FindBy(name = "accountname")
	private WebElement accountNametb;
	
	@FindBy(xpath = "//select[@name ='industry']")
	private WebElement industryDropdownBtn;
	
	/*
	 * @FindBy(xpath = "//*[@value = 'Communications']") private WebElement
	 * industryDD;
	 */
	@FindBy(name = "button")
	private WebElement saveOrgBtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdOrg;
	
	
	//Driver assign to page object (to run this page) to  Run 

	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getcreatedOrgText() {
		return createdOrg.getText();
	}
	
	public void createOrganisation(WebDriver driver, String orgname) throws Exception {
		// creating organisation
		createOrganisationPlusBtn.click();
		Thread.sleep(2000);
		accountNametext.click();
		accountNametb.sendKeys(orgname);
		saveOrgBtn.click();
		
		Thread.sleep(2000);
	}
	
	public void createOrgWithIndustry(WebDriver driver, String orgname,String industryDrpValue) throws Exception {
		createOrganisationPlusBtn.click();
		//Thread.sleep(2000);
	//	accountNametext.click();
		Thread.sleep(3000);
		accountNametb.sendKeys(orgname);
		Thread.sleep(2000);
		//industryDropdownBtn.sendKeys();
		handleDropDown(industryDropdownBtn, industryDrpValue);
		Thread.sleep(3000);
		saveOrgBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		
		
		
	}
}
