package testFramework;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    static String quitBROWSER = "no";

    public static WebDriver getDriver() {
        return driver;
    }
    static int sessionCount = 1;



    public void waitForElementDisplay(final WebElement element, int time) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
                       @Override
                       public Boolean apply(WebDriver input) {
                           return element.isDisplayed();
                       }
                   }
        );
    }


    public void forceSleep(int i) {
        try {
            Thread.sleep(i * 1000);
            System.out.println("waiting for some time");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ceaseProductionTests() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("https://www.zopa")) {
            Assert.fail("CAUTION ! -- Tests Running in Production ");
        }
    }

}
