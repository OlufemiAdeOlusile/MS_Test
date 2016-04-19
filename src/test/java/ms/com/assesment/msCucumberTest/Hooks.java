package ms.com.assesment.msCucumberTest;

import cucumber.api.java.Before;
import ms.com.assesment.driver.Browser;
import ms.com.assesment.driver.DriverListener;
import ms.com.assesment.driver.DriverManager;
import org.testng.annotations.Listeners;

/**
 * Created by ${Femi} on ${15/03/2016}.
 */

@Listeners(value = DriverListener.class)
public class Hooks {

    Browser browser;
    String url = "http://www.marksandspencer.com/";


    @Before
    public void setup() {
        browser = DriverManager.getInstance();
        browser.navigateToUrl(url);

    }
}
