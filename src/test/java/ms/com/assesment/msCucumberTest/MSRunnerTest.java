package ms.com.assesment.msCucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import ms.com.assesment.utility.AbstractTestNgClass;
import org.junit.runner.RunWith;

/**
 * Created by ${Femi} on ${15/03/2016}.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/resources/msFeatures",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = "@MSFindAStore, @MSSearch"
)


public class MSRunnerTest extends AbstractTestNgClass{

}
