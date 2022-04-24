package zopa;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.Random;

//import org.apache.log4j.Logger;
@RunWith(Cucumber.class)
@CucumberOptions(publish = false,
        features = {"src/test/resources"},
        plugin = {"json:target/cucumber.json", "html:target/cucumberReports/cucumberRpt.html", "pretty:target/cucumberReports/cucumber-pretty.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        stepNotifications = true,
        monochrome = true,

        /////////////////////// HOme Page TAGS /////////////////////////

        tags = "@loanSignUp"
)

public class RunTests {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        Date date = new Date();
        System.out.println("Tests Start Time:  " + date);
        BrowserFactory.startBrowser(LoadProps.getProperty("browsername"), LoadProps.getProperty("mmsURL"));
    }


    @AfterClass
    public static void tearDown() {
        System.out.println(" Afters Class - Current URL is : " + BrowserFactory.driver.getCurrentUrl());
        if (BasePage.quitBROWSER.equalsIgnoreCase("yes") && LoadProps.getProperty("quitBrowser").equalsIgnoreCase("yes")) {
            BrowserFactory.driver.quit();
        }

        if (LoadProps.getProperty("browsername").equalsIgnoreCase("Edge")) {
            BrowserFactory.driver.quit();
        }

        if (LoadProps.getProperty("browsername").equalsIgnoreCase("Safari")) {
            BrowserFactory.driver.quit();
        }
        Date date = new Date();
        System.out.println("Tests Finish Time:  " + date);
    }
}

