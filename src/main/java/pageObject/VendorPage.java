package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	@FindBy(xpath = "//a[@name = 'Vendors']")
	private WebElement mousehoverToVendors;

	@FindBy(xpath = "//img[contains(@title, 'Create Vendor')]")
	private WebElement createVendorPlusBtn;

	@FindBy(xpath = "//input[@name = 'vendorname']")
	private WebElement vendorNameTextbox;

	@FindBy(name = "button")
	private WebElement saveVendorsBtn;

	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createVendor(String vendorName) throws Exception {

		createVendorPlusBtn.click();
		Thread.sleep(2000);
		vendorNameTextbox.sendKeys(vendorName);
		Thread.sleep(2000);
		saveVendorsBtn.click();

	}

}
