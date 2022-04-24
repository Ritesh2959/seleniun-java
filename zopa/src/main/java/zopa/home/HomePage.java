package zopa.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import zopa.BasePage;
import zopa.LoadProps;

public class HomePage extends BasePage {


    @FindBy(css = "#onetrust-close-btn-container > button")
    private WebElement cookiesCloseButton;

    // Borrow Menu list
    @FindBy(css = "ul > li:nth-child(1) > a > span.sc-dfVpRl.dfKDn")
    private  WebElement borrowMenuLink;

    @FindBy(css = "ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement loanSubMenuLink;

    //Save Menu list
    @FindBy(css = "li:nth-child(2) > a > span.sc-dfVpRl.dfKDn")
    private WebElement saveMenuLink;

//    @FindBy(css = "li:nth-child(3) > a > span.sc-dfVpRl.dfKDn")
//    WebElement aboutMenuLink;

    public void homePageNavigation() {
        driver.get(LoadProps.getProperty("zopaProdUrl"));
    }

    public void closeCookiesBar() {
        forceSleep(2);
        waitForElementDisplay(cookiesCloseButton, 60);
        cookiesCloseButton.click();
    }

    public void clickMenuTab(String mainMenu) {
        System.out.println(" Clicking on " + mainMenu + " link");
            borrowMenuLink.click();
    }

    public void clickSubMenuTab(String submenu) {
        waitForElementDisplay(loanSubMenuLink,60);
        loanSubMenuLink.click();
    }
}
