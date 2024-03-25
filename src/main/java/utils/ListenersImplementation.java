/*
 * package utils;
 * 
 * import org.testng.ITestContext; import org.testng.ITestListener; import
 * org.testng.ITestResult; import org.testng.Reporter; import
 * org.testng.annotations.Parameters;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentSparkReporter; import
 * com.aventstack.extentreports.reporter.configuration.Theme;
 * 
 * public class ListenersImplementation implements ITestListener {
 * 
 * ExtentReports report; ExtentTest test;
 * 
 * //Press Alt + Shift + S + V to quickly implement/override methods in Eclipse.
 * 
 * // @Parameters({ "OS", "browser" }) public void onTestStart(ITestResult
 * result) {
 * 
 * // run for every @Test start String methodName =
 * result.getMethod().getMethodName();
 * test.info(" ---- Test Execution Started ----> " + methodName); // Overriding
 * //abstraction
 * 
 * test = report.createTest(methodName);// test script execution is started in
 * report test.log(Status.INFO, methodName + " -> Test execution started");
 * 
 * }
 * 
 * public void onTestSuccess(ITestResult result) { // pass
 * 
 * String methodName = result.getMethod().getMethodName(); test.info(methodName
 * + " ---- Test Execution successfull ----");
 * 
 * test.log(Status.PASS, methodName + result.getTestName() + " -> PASS" +
 * Thread.currentThread().getId()); test.log(Status.INFO, methodName +
 * result.getTestName() + " -> PASS (Status.INFO, details)");
 * 
 * 
 * // Take - Screenshot String screenShotName = methodName + "-" + new
 * JavaUtility().getSystemInFormat(); WebDriverUtility wLib = new
 * WebDriverUtility(); try {
 * 
 * String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
 * test.addScreenCaptureFromPath(path); } catch (IOException e) {
 * e.printStackTrace(); e.getCause(); }
 * 
 * 
 * }
 * 
 * public void onTestFailure(ITestResult result) { // fail
 * 
 * String methodName = result.getMethod().getMethodName() +
 * jUtil.getSystemDateInFormat();
 * 
 * test.log(Status.FAIL, methodName + result.getTestName() + " -> FAIL");
 * test.log(Status.FAIL, " FAILED"); test.log(Status.FAIL,
 * result.getThrowable().toString());
 * 
 * // Take - Screenshot // String screenShotName = methodName + "-" + new //
 * JavaUtility().getSystemInFormat(); // WebDriverUtility wLib = new
 * WebDriverUtility();
 * 
 * }
 * 
 * public void onTestSkipped(ITestResult result) {
 * 
 * String methodName = result.getMethod().getMethodName(); test.info(methodName
 * + result.getTestName() + " ---- Test Execution skipped ----");
 * test.info(result.getThrowable() + result.getTestName());
 * 
 * test.log(Status.SKIP, methodName + " -> SKIP"); test.log(Status.SKIP,
 * result.getThrowable());
 * 
 * }
 * 
 * public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
 * test.info("This method for now not implemented ");
 * 
 * }
 * 
 * public void onTestFailedWithTimeout(ITestResult result) {
 * onTestFailure(result);
 * 
 * }
 * 
 * public void onStart(ITestContext context) {
 * 
 * Reporter.log("Execution of suite started", true);
 * test.info("---- Execution Started ----");
 * 
 * // Configure the extent Reports // Execution of suite starts here, hence
 * configure the extent reports here. // Report-11-11-2022-10-48.html
 * ExtentSparkReporter htmlReport = new ExtentSparkReporter(
 * ".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() +
 * ".html");
 * 
 * htmlReport.config().setDocumentTitle("Vtiger Test Execution Report");
 * htmlReport.config().setReportName("Execution report BuildV2.3.1");
 * htmlReport.config().
 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 * htmlReport.config().setTheme(Theme.DARK);
 * 
 * report = new ExtentReports(); report.attachReporter(htmlReport);
 * 
 * }
 * 
 * public void onFinish(ITestContext context) {
 * 
 * Reporter.log("Execution of suite finished", true);
 * test.info("---- Execution finished ----");
 * 
 * // Flush the report. - Here the execution is finished report.flush();
 * 
 * }
 * 
 * }
 */