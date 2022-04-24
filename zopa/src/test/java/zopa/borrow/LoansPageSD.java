package zopa.borrow;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import zopa.BrowserFactory;

public class LoansPageSD  {


    LoanPage loanPage = PageFactory.initElements(BrowserFactory.driver,LoanPage.class);


    @When("^I enter the \"([^\"]*)\" I want to borrow$")
    public void iEnterTheSomethingIWantToBorrow(String amount){
        loanPage.enterLoanAmount(amount);
    }

    @Then("^I should be on Zopa Loan Page$")
    public void iShouldBeOnZopaLoanPage(){
        loanPage.verifyLoanPage();
    }

    @And("^I select the \"([^\"]*)\" for my loan$")
    public void iSelectTheSomethingForMyLoan(String term){
        loanPage.selectLoanTerm(term);
    }

    @And("I click on the Get My personalised rates button")
    public void iClickOnTheGetMyPersonalisedRatesButton() {
        loanPage.clickGetPersonalRateButton();
    }
}
