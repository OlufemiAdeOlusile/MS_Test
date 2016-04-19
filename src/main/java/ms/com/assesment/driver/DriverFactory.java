package ms.com.assesment.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {


    static WebDriver createInstance(String browserName) {
        WebDriver driver = null;

        if (browserName.toLowerCase().equalsIgnoreCase(BrowserName.firefox.name())) {
            driver = BrowserSetup.getFireFoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().equalsIgnoreCase(BrowserName.chrome.name())) {
            driver = BrowserSetup.getChromeDriver();
            return driver;
        }
        if (browserName.toLowerCase().equalsIgnoreCase(BrowserName.unitChrome.name())) {
            driver = BrowserSetup.getHtmlChromeDriver();
            return driver;
        }
        if (browserName.toLowerCase().equalsIgnoreCase(BrowserName.unitFirefox.name())) {
            driver = BrowserSetup.getHtmlFirefoxDriver();
            return driver;
        }

        return  null;
    }


}
