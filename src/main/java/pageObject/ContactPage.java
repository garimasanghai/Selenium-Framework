package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethod;

public class ContactPage extends GenericMethod{

	WebDriver driver;

	/*
	 * @FindBy(xpath = "//a[text() = 'Contacts']") private WebElement
	 * contactTextBtn;
	 */

	@FindBy(xpath = "//img[contains(@title, 'Create Contact')]")
	private WebElement createContactPlusBtn;

	@FindBy(name = "lastname")
	private WebElement contactNametext;

	@FindBy(name = "lastname")
	private WebElement contactNametb;

	/*
	 * @FindBy(xpath = "//*[contains(@title, 'Select')]") private WebElement
	 * orgNameBtn;
	 */

	@FindBy(name = "button")
	private WebElement savebtn;

	// Plus button for Organisation

	@FindBy(xpath = "//img[@title ='Select']")
	private WebElement plusOrgBtn;

	@FindBy(xpath = "//input[@id = 'search_txt']")
	private WebElement orgInputTextbox;

	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement orgSearchBtn;
	
	/*
	 * @FindBy(xpath = "//a[text()=  'very']") private WebElement
	 * organisationNameFromChildWin;
	 */
	
	
	// Driver assign to page object (to run this page) to Run
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createContact(WebDriver driver, String contactname) throws Exception {
		// creating organisation

		createContactPlusBtn.click();
		Thread.sleep(2000);
		contactNametext.click();
		contactNametext.sendKeys(contactname);
		savebtn.click();
	}

	public void createContactWithOrg(WebDriver driver, String contactname, String orgname) throws Exception {
		createContactPlusBtn.click();
		Thread.sleep(2000);
		contactNametext.click();
		contactNametext.sendKeys(contactname);
		Thread.sleep(2000);
		plusOrgBtn.click();
		Thread.sleep(2000);
		switchToWindow(driver, "Accounts");
		orgInputTextbox.sendKeys(orgname);
		Thread.sleep(2000);
		orgSearchBtn.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();
		// because its dynamic, it cannot be stored under private element & will run on runtime
		switchToWindow(driver, "Contacts");//com
		Thread.sleep(2000);
		savebtn.click();
	}
}