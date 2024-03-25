package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethod;

public class OpprtunitiesPage extends GenericMethod {
	
	@FindBy (xpath = "//img[contains(@title , 'Create Opportunity')]")
	private WebElement createOpportunitiesPlusBtn;
	
	@FindBy (name = "potentialname")
	private WebElement opportunitiesNameTextbox;
	
	@FindBy (id = "related_to_type")
	private WebElement relatedToDD;
	
	@FindBy (xpath = "(//*[@value ='Contacts'])[2]")
	private WebElement selectContactFromDD ;
	
	@FindBy (xpath = "//img[@title = 'Select']")
	private WebElement relatedToPlusWindowBtn;
	
	@FindBy (id = "search_txt")
	private WebElement commonInputTextbox;
	
	@FindBy (name = "search")
	private WebElement commonSearchBtn;
	
	@FindBy (id = "i")
	private WebElement selectOrgName;
	
	@FindBy (name = "sales_stage")
	private WebElement salesStageDropdownBtn;
	
	@FindBy(name = "button")
	private WebElement saveOpportunitiesBtn;

	
	public OpprtunitiesPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createOpportunitiesWithOrg(WebDriver driver, String potentialName, String orgname) throws Exception {
	
		createOpportunitiesPlusBtn.click();
		Thread.sleep(2000);
		opportunitiesNameTextbox.sendKeys(potentialName);
		Thread.sleep(2000);
		//selectOrgFromDD.click();
		//handleDropDown(relatedToDD, "Accounts");
		relatedToPlusWindowBtn.click();
		Thread.sleep(3000);
		switchToWindow(driver, "Accounts"); // passing the partial window title
		commonInputTextbox.sendKeys(orgname);
		Thread.sleep(2000);
		commonSearchBtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();
		Thread.sleep(2000);
		switchToWindow(driver, "Potentials");
		saveOpportunitiesBtn.click();
		Thread.sleep(2000);
	
	}
	
	public void createOpportunitiesWithContacts(WebDriver driver,String potentialName, String contact) throws InterruptedException {
		createOpportunitiesPlusBtn.click();
		Thread.sleep(2000);
		opportunitiesNameTextbox.sendKeys(potentialName);
		Thread.sleep(2000);
		relatedToDD.click();
		handleDropDown(relatedToDD, "Contacts");
		relatedToPlusWindowBtn.click();
		Thread.sleep(3000);
		switchToWindow(driver, "Contacts");
		commonInputTextbox.sendKeys(contact);
		Thread.sleep(2000);
		commonSearchBtn.click();
		Thread.sleep(2000);
		System.out.println("Selecting Contact after search");
		//driver.findElement(By.xpath("//a[.='" + contact + "']")).click(); //a[contains(., 'Fermin Balistreri V')]
		driver.findElement(By.xpath("//a[contains(., '" + contact + "')]")).click();
		Thread.sleep(2000);
		System.out.println("Unable to do so");
		switchToWindow(driver, "Potentials");
		saveOpportunitiesBtn.click();
		Thread.sleep(2000);
	}
	
	public void createOpportunitiesWithMandatoryFields(WebDriver driver, String potentialName, String orgname, String salesStageDrpValue) throws Exception {
		createOpportunitiesPlusBtn.click();
		Thread.sleep(2000);
		opportunitiesNameTextbox.sendKeys(potentialName);
		Thread.sleep(2000);
		relatedToPlusWindowBtn.click();
		Thread.sleep(3000);
		switchToWindow(driver, "Accounts");
		commonInputTextbox.sendKeys(orgname);
		Thread.sleep(2000);
		commonSearchBtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();
		Thread.sleep(2000);
		switchToWindow(driver, "Potentials");
		Thread.sleep(1000);
		handleDropDown(salesStageDropdownBtn, salesStageDrpValue);
		Thread.sleep(3000);
		saveOpportunitiesBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		
	}
	
}
