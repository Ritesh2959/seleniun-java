package testFramework.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.BasePage;
import testFramework.LoadProps;

public class HomePage extends BasePage {


    @FindBy(css = "#onetrust-close-btn-container > button")
    private WebElement cookiesCloseButton;




    public void homePageNavigation() {
        driver.get(LoadProps.getProperty("googleUrl"));
    }

    public void closeCookiesBar() {
        forceSleep(2);
        waitForElementDisplay(cookiesCloseButton, 60);
        cookiesCloseButton.click();
    }
}
