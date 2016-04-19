package ms.com.assesment.modular;

import ms.com.assesment.driver.Browser;
import org.testng.Assert;
import org.testng.Reporter;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by ${Femi} on ${15/03/2016}.
 */
public class MsSearchFunction {

    Browser browser;
    String searchIdKey = "global-search";
    String searchGoButtonKey = "goButton";
    String searchResultsKey = "p.criteria";
    String searchItemCountKey = "span.count";
    String noResultsKey = "div.no-results";
    String searchResultList = "img.model-view";

    public MsSearchFunction(Browser browser) {
        this.browser = browser;
    }


    public void insertProductAndClickToSearch(String product) {

        browser.waitHTMLID(searchIdKey);
        browser.mySendKeys(product, searchIdKey);
        browser.waitHTMLID(searchGoButtonKey);
        browser.getAllElement(searchGoButtonKey).click();

    }


    public void validateVisibilityOfValidSearchedProduct(String product) {

        browser.waitHTMLCSS(searchResultsKey);

        browser.checkElementIsDisplayed(searchResultList);

        String expectedResultsMessage = browser.getAllElement(searchResultsKey).getText();

        String actualResultsMessage = "Search results for " + product;

        Assert.assertEquals(actualResultsMessage, expectedResultsMessage, "Search results do not show the correct result");


        String expectedItemCount = browser.getAllElement(searchItemCountKey).getText();

        assertThat("Count is not higher than 0", (Integer.parseInt(expectedItemCount)), greaterThan(0));

        Reporter.log(product + " has " + expectedItemCount + " items", true);
    }


    public void validateInvalidSearchedProduct(String product) {

        browser.waitHTMLCSS(searchResultsKey);

        String expectedResultsMessage = browser.getAllElement(searchResultsKey).getText();

        String actualResultsMessage1 = "You searched for " + product + ", we're sorry we couldn't find anything to match your search";


        browser.checkElementIsDisplayed(noResultsKey);


            Assert.assertEquals(actualResultsMessage1, expectedResultsMessage, "Search results do not show the correct result");
            Reporter.log("Your search for " + product + " returned: " + actualResultsMessage1, true);

    }

}
