package zopa;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class Hooks extends BasePage {

    @Before
    public void beforeScenario(Scenario scenario) {
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        embededScreenshots(scenario);
    }


    private void embededScreenshots(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                TakesScreenshot ts = (TakesScreenshot) BrowserFactory.driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src,"image/png","screenshot");
                //  mmsLogout();
            } catch (WebDriverException somePlatFormDontSupportScreenshot) {
            }
        }
    }
}
