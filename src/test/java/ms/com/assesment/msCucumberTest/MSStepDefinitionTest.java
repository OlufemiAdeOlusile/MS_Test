package ms.com.assesment.msCucumberTest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ms.com.assesment.driver.Browser;
import ms.com.assesment.driver.DriverManager;
import ms.com.assesment.modular.MsFindAStore;
import ms.com.assesment.modular.MsSearchFunction;


/**
 * Created by ${Femi} on ${15/03/2016}.
 */


public class MSStepDefinitionTest {

    Browser browser = DriverManager.getInstance();
    MsSearchFunction search = new MsSearchFunction(browser);
    MsFindAStore findAStore = new MsFindAStore(browser);


    @When("^a customer searches for a product \"([^\"]*)\"$")
    public void a_customer_searches_for_a_product(String product) throws Throwable {

        search.insertProductAndClickToSearch(product);
    }

    @Then("^that customer can see a view of matching products \"([^\"]*)\"$")
    public void that_customer_can_see_a_view_of_matching_products(String product) throws Throwable {
        search.validateVisibilityOfValidSearchedProduct(product);
    }

    @Then("^that customer will receive an error message if product is invalid \"([^\"]*)\"$")
    public void that_customer_will_receive_an_error_message_if_product_is_invalid(String product) throws Throwable {
        search.validateInvalidSearchedProduct(product);
    }


    @When("^a customer inserts a postcode \"([^\"]*)\"$")
    public void a_customer_inserts_a_postcode(String postcode) throws Throwable {
        findAStore.findAStore(postcode);
    }

    @Then("^error message is displayed for an invalid postcode \"([^\"]*)\"$")
    public void error_message_is_displayed_for_an_invalid_postcode(String postcode) throws Throwable {
        findAStore.incorrectStoreSearchValidation(postcode);
    }


    @Then("^a customer can view a list of stores$")
    public void a_customer_can_view_a_list_of_stores() throws Throwable {
        findAStore.correctStoreSearchValidation();
    }
}
