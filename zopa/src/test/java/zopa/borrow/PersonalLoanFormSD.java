package zopa.borrow;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import zopa.BrowserFactory;

public class PersonalLoanFormSD {


    PersonalLoanFormPage personalLoanFormPage = PageFactory.initElements(BrowserFactory.driver, PersonalLoanFormPage.class);

    @When("^I select the loan type \"([^\"]*)\"$")
    public void iSelectTheLoanTypeSomething(String loantype) {
        personalLoanFormPage.selectLoanType(loantype);
    }

    @When("^I select employment status \"([^\"]*)\" from your finances section$")
    public void iSelectEmploymentStatusSomethingFromYourFinancesSection(String employmentStatus) {
        personalLoanFormPage.selectEmploymentStatus(employmentStatus);
    }

    @Then("^I should see signup form for personal loan$")
    public void iShouldSeeSignupFormForPersonalLoan() {
    }

    @And("^I enter my email \"([^\"]*)\" Id in about you section$")
    public void iEnterMyEmailSomethingIdInAboutYouSection(String email) {
        personalLoanFormPage.enterEmailID(email);
    }

    @And("^I select title \"([^\"]*)\" in about you section$")
    public void iSelectTitleSomethingInAboutYouSection(String title) {
        personalLoanFormPage.selectTitle(title);
    }

    @And("^I enter first name \"([^\"]*)\"$")
    public void iEnterFirstNameSomething(String strArg1) {
    }

    @And("^I enter last name \"([^\"]*)\"$")
    public void iEnterLastNameSomething(String strArg1) {
    }

    @And("^I enter date of birth \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterDateOfBirthSomethingSomethingSomething(String dd, String mm, String yyyy) {
    }

    @And("^I enter annual income as \"([^\"]*)\"$")
    public void iEnterAnnualIncomeAsSomething(String annualIncome) {
        personalLoanFormPage.enterAnnualIncome(annualIncome);
    }

    @And("^I select home owner \"([^\"]*)\" section$")
    public void iSelectHomeOwnerSomethingSection(String homeowner) {
        personalLoanFormPage.selectHomeOwner(homeowner);
    }

    @And("^I enter postcode \"([^\"]*)\"$")
    public void iEnterPostcodeSomething(String postcode) {
        personalLoanFormPage.enterPostCode(postcode);
    }

    @And("^I click on lookup address button$")
    public void iClickOnLookupAddressButton() {
    }

    @And("^I select the address from the given list$")
    public void iSelectTheAddressFromTheGivenList() {
        personalLoanFormPage.selectGivenAddress();
    }

    @And("^I select monthe \"([^\"]*)\" and year \"([^\"]*)\"$")
    public void iSelectMontheSomethingAndYearSomething(String month, String year) {
        personalLoanFormPage.selectMonthAndYearSincePresentAddress(month,year);
    }

    @And("^I click on the use this address button$")
    public void iClickOnTheUseThisAddressButton() {
    }

}
