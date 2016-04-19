package ms.com.assesment.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public interface Browser {

    WebDriver getDriver();

    void setWebDriver(WebDriver driver);

    void navigateToUrl(String url);

    WebElement getAllElement(String key);

    void waitHTMLCSS(String key);

    void waitHTMLClass(String key);

    void mySendKeys(String input, String key);

    void waitHTMLLinkedText(String key);

    void waitSeconds(Integer seconds);

    void waitBy(By by);

    void waitHTMLID(String key);

    boolean checkElementIsDisplayed(String key);

    void waitHTMLXpath(String key);

    void waitHTMLName(String key);
}
