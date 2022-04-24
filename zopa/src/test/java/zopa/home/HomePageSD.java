package zopa.home;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import zopa.BrowserFactory;

public class HomePageSD {

    HomePage homePage = PageFactory.initElements(BrowserFactory.driver,HomePage.class);

    @Given("^I navigate to zopa home page$")
    public void iNavigateToZopaHomePage() {
        homePage.homePageNavigation();
    }

    @And("I close cookies notifications at the end of page")
    public void iCloseCookiesNotificationsAtTheEndOfPage() {
        homePage.closeCookiesBar();
    }

    @When("^I click on the \"([^\"]*)\" menu link$")
    public void iClickOnTheSomethingMenuLink(String maninmenu){
        homePage.clickMenuTab(maninmenu);
    }

    @And("^I click on the \"([^\"]*)\" sub menu link$")
    public void iClickOnTheSomethingSubMenuLink(String submenu){
        homePage.clickSubMenuTab(submenu);
    }
}
