package ms.com.assesment.modular;

import ms.com.assesment.driver.Browser;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by ${Femi} on ${15/03/2016}.
 */
public class MsFindAStore {


    Browser browser;

    String findAStoreKey = "a.link.touch-hidden";

    String insertPostcodeKey = "searchCriteria";

    String searchPostcodeKey = "//form[@id='store-finder-form']/fieldset/ul/li[2]/input[5]";

    String invalidResultKey = "div.store-finder-container__no-result--title";

    String storeIdSearchKey = "storeFinderSearch";

    String storeResultKey = "storeId_1";


    public MsFindAStore(Browser browser) {
        this.browser = browser;
    }


    public void findAStore(String name) {

        browser.waitHTMLCSS(findAStoreKey);

        browser.getAllElement(findAStoreKey).click();

        browser.waitHTMLName(insertPostcodeKey);

        browser.mySendKeys(name, insertPostcodeKey);

        browser.waitHTMLXpath(searchPostcodeKey);

        browser.getAllElement(searchPostcodeKey).click();

    }

    public void correctStoreSearchValidation() {

        browser.waitHTMLID(storeResultKey);

        boolean check = browser.checkElementIsDisplayed(storeResultKey);

        Assert.assertTrue(check);

        Reporter.log("Search produced valid search results", true);

    }

    public void incorrectStoreSearchValidation(String name) {

        browser.waitHTMLID(storeIdSearchKey);

        String actualErrorMessage = "No results for '" + name + "'";

        String expectedErrorMessage = browser.getAllElement(invalidResultKey).getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "No error message");

        Reporter.log("Error message is shown on page", true);
    }
}
