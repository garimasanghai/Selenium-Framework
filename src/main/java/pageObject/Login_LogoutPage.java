/*
 * package pageObject;
 * 
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory;
 * 
 * //methods repo
 * 
 * public class PageObject { WebDriver driver;
 * 
 * @FindBy(name = "user_name") private WebElement usernametb;
 * 
 * @FindBy(name = "user_password") private WebElement passwordtb;
 * 
 * @FindBy(id = "submitButton") private WebElement submitbtn;
 * 
 * public PageObject(WebDriver driver) { PageFactory.initElements(driver, this);
 * }
 * 
 * public void loginToApp(WebDriver driver, String username, String password) {
 * usernametb.sendKeys(username); passwordtb.sendKeys(password);
 * submitbtn.click(); }
 * 
 * }
 */
package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_LogoutPage {
	WebDriver driver;

	@FindBy(name = "user_name")
	private WebElement usernametb;

	@FindBy(name = "user_password")
	private WebElement passwordtb;

	@FindBy(id = "submitButton")
	private WebElement submitbtn;
	
	@FindBy (xpath = "(//td[@class = 'small'])[2]")
	private WebElement administrativeLink;
	
	@FindBy (xpath = "//a[text() = 'Sign Out']")
	private WebElement signoutbtn;

	// Driver assign to page object (to run this page) to Run

	public Login_LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String username, String password) {
		usernametb.sendKeys(username);
		passwordtb.sendKeys(password);
		submitbtn.click();
	}

	public void logoutFromApp(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		Thread.sleep(1000);
		a.moveToElement(administrativeLink).perform();
		Thread.sleep(1000);
		signoutbtn.click();
		Thread.sleep(1000);

	}

}