package utils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class GenericMethod {

	// Writing all the generic methods at one place

	public static void switchToWindow(WebDriver driver, String partialWindowTitle) {
		// Step 1: Capture all the window IDs and storing it in a refVariable ---->
		// winIDs
		Set<String> winIDs = driver.getWindowHandles();

		// Syntax:for... each loop
		// (datatype refVariable : array/collection)
		// Step 2: Navigate to each window

		for (String winID : winIDs) {

			// Step 3: capture the title of title of each window
			String actTitle = driver.switchTo().window(winID).getTitle();

			// Step 4: Compare the actual title with partial window title
			if (actTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	// dd

	public static void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		try {
			Thread.sleep(2000);
			sel.selectByValue(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	//scroll by
	
	public void scrollByValue(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");//how to make it dynamic

	}
	
	public void scrollToWebElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");
     // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	//TakesScreenshot
	
	public static String takesScreenshot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots" + screenShotName + ".png");
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	
}
