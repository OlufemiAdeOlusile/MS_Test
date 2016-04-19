package ms.com.assesment.driver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverManager implements Browser {

    private DriverManager() {
    }

    public static Browser getInstance() {
        return new DriverManager();
    }


    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();


    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public void navigateToUrl(String url) {

        getDriver().get(url);
    }

    public void waitHTMLCSS(String key) {
        By elementToWaitBy = By.cssSelector(key);
        waitBy(elementToWaitBy);
    }

    public void waitBy(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
    }

    public void waitHTMLID(String key) {

        By elementToWaitBy = By.id(key);
        waitBy(elementToWaitBy);
    }


    public void waitHTMLClass(String key) {

        By elementToWaitBy = By.className(key);
        waitBy(elementToWaitBy);
    }

    public void waitHTMLLinkedText(String key) {

        By elementToWaitBy = By.linkText(key);
        waitBy(elementToWaitBy);
    }

    public void mySendKeys(String input, String key) {

        try {
            WebElement element = getAllElement(key);
            element.clear();
            element.sendKeys(input);
            Reporter.log("Inputted: " + input, true);
        } catch (Throwable e) {
            Reporter.log(input + " could not be inputted", true);
        }

    }

    public void waitSeconds(Integer seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public void newUrl(String newUrl) {
        String url = getDriver().getCurrentUrl();
        String myurl = url + newUrl;
        getDriver().get(myurl);
    }


    public boolean checkElementIsDisplayed(String key) {
        try {
            WebElement Element = getAllElement(key);
            return Element.isDisplayed();
        } catch (NullPointerException e) {
            return false;
        }
    }


    public WebElement getAllElement(String key) {
        try {
            return getDriver().findElement(By.id(key));

        } catch (Throwable ignored) {
        }

        try {
            return getDriver().findElement(By.name(key));

        } catch (Throwable ignored) {
        }

        try {
            return getDriver().findElement(By.xpath(key));

        } catch (Throwable ignored) {
        }

        try {
            return getDriver().findElement(By.className(key));

        } catch (Throwable ignored) {
        }

        try {
            return getDriver()
                    .findElement(By.cssSelector(key));

        } catch (Throwable ignored) {

        }

        try {
            return getDriver()
                    .findElement(By.linkText(key));

        } catch (Throwable ignored) {

        }

        Reporter.log("Object not found", true);
        return null;
    }

    public List<WebElement> getListXpathElement(String key) {

            return getDriver().findElements(By.xpath(key));
    }

    public void waitHTMLXpath(String key) {

        By elementToWaitBy = By.xpath(key);
        waitBy(elementToWaitBy);
    }


    public void waitHTMLName(String key) {

        By elementToWaitBy = By.name(key);
        waitBy(elementToWaitBy);
    }

}
