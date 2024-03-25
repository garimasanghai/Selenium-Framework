package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//methods repo

public class Dashboard {
	WebDriver driver;

	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;

	@FindBy(xpath = "//a[text() = 'Contacts']")
	private WebElement contactLink;

	@FindBy(xpath = "//a[text() = 'Products']")
	private WebElement productLink;

	@FindBy(xpath = "//a[text() = 'More']")
	private WebElement moreBtn;

	@FindBy(name = "Vendors")
	private WebElement vendorsLink;

	@FindBy(xpath = "//a[text()= 'Opportunities']")
	private WebElement opportunitiesLink;

	// driver.findElement(By.linkText("Organizations")).click();

	// Driver assign to page object (to run this page) to Run
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnOrganisation() {
		organisationLink.click();
	}

	public void clickOnContactLink() {
		contactLink.click();
	}

	public void clickOnProductLink() {
		productLink.click();
	}

	public void clickOnVendorLink(WebDriver driver) throws Exception {
		moreBtn.click();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(vendorsLink).build().perform();
		Thread.sleep(2000);
		vendorsLink.click();
	}

	public void clickOnOpportunitiesLink() {
		opportunitiesLink.click();
	}
}
