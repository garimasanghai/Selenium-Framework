package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethod;

public class ProductPage extends GenericMethod {

	@FindBy(xpath = "//img[contains(@title, 'Create Product')]")
	private WebElement createProductPlusBtn;

	@FindBy(xpath = "//input[@name = 'productname']")
	private WebElement productNameTextbox;

	@FindBy(xpath = "//input[@name = 'sales_start_date']")
	private WebElement salesStartDate;
	
	@FindBy(xpath = "//img[@title = 'Select']")
	private WebElement vendorPlusWindowBtn;
	
	@FindBy (id = "search_txt")
	private WebElement commonInputTextbox;
	
	@FindBy (name = "search")
	private WebElement commonSearchBtn;
	
	@FindBy(name= "glacct")
	private WebElement glAccountDD;
	
	@FindBy(id = "unit_price")
	private WebElement scrollToUnitPrice;
	
	@FindBy(name = "button")
	private WebElement saveProdBtn;
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createProduct(WebDriver driver, String product,String date ) throws Exception {
		createProductPlusBtn.click();
		Thread.sleep(2000);
		productNameTextbox.sendKeys(product);
		//salesStartDate.click();
		salesStartDate.sendKeys(date); //(yyyy-mm-dd) <<<<<<<<<<<<
		Thread.sleep(2000);
		saveProdBtn.click();
	}
	
	
/**
 * 
 * @param driver
 * @param product
 * @param date
 * @param vendorName
 * @param glAccountDrpvalue
 * @param amt
 * @throws Exception
 */
	public void createProductWithVendorAndScroll (WebDriver driver, String product,String date, String vendorName, String glAccountDrpvalue, String amt) throws Exception {
		createProductPlusBtn.click();
		Thread.sleep(2000);
		productNameTextbox.sendKeys(product);
		salesStartDate.sendKeys(date);
		vendorPlusWindowBtn.click();
		Thread.sleep(3000);
		switchToWindow(driver, "Vendors");// passing the partial window title
		Thread.sleep(1000);
		commonInputTextbox.sendKeys(vendorName);
		Thread.sleep(2000);
		commonSearchBtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(. , '" + vendorName + "')]")).click();
		Thread.sleep(2000);
		switchToWindow(driver, "Products");
		handleDropDown(glAccountDD, glAccountDrpvalue);
		Thread.sleep(1000);
		scrollToWebElement(driver, scrollToUnitPrice);
		scrollToUnitPrice.sendKeys(amt); //why data type of amt cannot be changed to int/double
		scrollToWebElement(driver, saveProdBtn);
		Thread.sleep(2000);
		saveProdBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		
		
	}

}
