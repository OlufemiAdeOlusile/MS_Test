package ms.com.assesment.driver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;


public class BrowserSetup {

    public static final String MAC_OS_FIREFOX_BIN = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
    public static final String WINDOWS_CHROMEDRIVER = "src/resources/drivers/chromedriver.exe";
    public static final String MAC_CHROMEDRIVER = "src/resources/drivers/chromedriver";


    public static WebDriver getFireFoxDriver() {
        String os = getOS();
        if (os.equalsIgnoreCase("Windows")) {

            FirefoxDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();

            return driver;
        }

        if (os.equalsIgnoreCase("Mac")) {
            File pathToBinary = new File(MAC_OS_FIREFOX_BIN);
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
            driver.manage().window().maximize();

            return driver;
        }

        try {
            throw new Exception("Browser cannot be Instantiated");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    protected static WebDriver getChromeDriver() {

        String os = getOS();

        if (os.equalsIgnoreCase("Windows")) {

            final String chromeDriverSystemProperty = "webdriver.chrome.driver";
            String pathToBinary = WINDOWS_CHROMEDRIVER;
            WebDriver driver = getChromeWebDriver(chromeDriverSystemProperty, pathToBinary);
            driver.manage().window().maximize();
            return driver;
        }

        if (os.equalsIgnoreCase("Mac")) {
            final String chromeDriverSystemProperty = "webdriver.chrome.driver";
            String pathToBinary = MAC_CHROMEDRIVER;
            WebDriver driver = getChromeWebDriver(chromeDriverSystemProperty, pathToBinary);
            driver.manage().window().maximize();
            return driver;
        }
        try {
            throw new Exception("Browser cannot be Instantiated");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    protected static WebDriver getHtmlChromeDriver() {
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.manage().window().maximize();
        return driver;
    }

    protected static WebDriver getHtmlFirefoxDriver() {
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        driver.manage().window().maximize();
        return driver;
    }


    private static String getOS() {
        return System.getProperty("os.name").split(" ")[0];
    }

    private static WebDriver getChromeWebDriver(String chromeDriverSystemProperty, String pathToBinary) {
        System.setProperty(chromeDriverSystemProperty, pathToBinary);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");

        return new ChromeDriver(options);
    }

}
