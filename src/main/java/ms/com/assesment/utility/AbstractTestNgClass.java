package ms.com.assesment.utility;

import cucumber.api.testng.TestNGCucumberRunner;
import ms.com.assesment.driver.DriverListener;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ${Femi} on ${15/03/2016}.
 */

@Listeners(value= DriverListener.class)
public class AbstractTestNgClass  implements IHookable {


    @Test(groups = "cucumber", description = "Runs Cucumber Features")
    public void run_cukes() throws IOException {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
    }

}
