package ms.com.assesment.driver;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class DriverListener implements IInvokedMethodListener{

    public static final String DEFAULT_BROWSER = BrowserName.chrome.name();

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        WebDriver driver;
        if (iInvokedMethod.isTestMethod()) {
            String browser = iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            if (browser != null) {
                driver = DriverFactory.createInstance(browser);
            } else {
                driver = DriverFactory.createInstance(DEFAULT_BROWSER);
            }
            DriverManager.getInstance().setWebDriver(driver);
        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            WebDriver driver = DriverManager.getInstance().getDriver();
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }
    }
}
