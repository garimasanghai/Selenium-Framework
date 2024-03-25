package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Login_LogoutPage;

//TestNG methods

public class BaseClass {

	// making it global so that all classes can access it

	public GetDataFromPropertyFile getDataProperty = new GetDataFromPropertyFile();

	public WebDriver driver = null; // u need to assign the value. It works on compile time
	// entire @beforeclass will run, then at last the value of driver will go n sit
	// on sDriver

	// the value is fixed
	public static WebDriver sDriver; // So that it can work on runtime
	
	/*
	 * @BeforeSuite public void bsConfig() { System.out.println("---DB connected ");
	 * }
	 */
	
	@BeforeClass(alwaysRun = true) //so that it doesn't skip
	@Parameters("browser")
	public void bcConfig( /*String browser*/) throws Exception {

		// we r reading the data from propertyfile. We need to read it only in this
		// message..
		// hence we r not declaring in global

		String browser = getDataProperty.readFilesFromProperty("browser");
		String url = getDataProperty.readFilesFromProperty("url");

		// whatever browser is there in propertyfile it will access that and execute
		// in propertyfile only one browser will exist else it will give compile time
		// error
		// various browser option can be read by XML while doing parallel/cross browser
		// execution
		// Since we r not aware what browser user has given in property file, it is
		// dynamic.
		// Whatever is given in propertyfile it will read n execute that.
		// If it will fulfill that condition and execute

		if (browser.equalsIgnoreCase("Chrome")) {
			// System.setProperty("webdriver.chrome.driver", "the path where driver exe is
			// available ");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Driver Launched");

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Driver Launched");

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Driver Launched");

		} else {
			System.out.println("Invalid driver");

		}
		// we have assigned the value of compiletime driver to runtime driver
		// to avoid checking condition at runtime, we have kept it static
		// so whatever value is given at compiletime the same is assigned at runtime as
		// well

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		System.out.println("------ Its a before class");
	}

	@BeforeMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void bmConfig() throws Exception {
		String username = getDataProperty.readFilesFromProperty("username");
		String password = getDataProperty.readFilesFromProperty("password");

		Login_LogoutPage llp = new Login_LogoutPage(driver);
		llp.loginToApp(username, password);
		System.out.println("====== DB Connection SuccessFull ======");

	}

	@AfterMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void afConfig() throws Exception {
		Login_LogoutPage llp = new Login_LogoutPage(driver);
		llp.logoutFromApp(driver);
		System.out.println("------ Its an after method");
	}

	@AfterClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void acConfig() {
		System.out.println("------ Its an after class");
	}
	
	/*
	 * @AfterSuite
	 * 
	 * public void asConfig() {
	 * System.out.println("---- DB Connection Eliminated----"); }
	 */
}
