package zopa.borrow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import zopa.BasePage;

import java.util.List;

public class PersonalLoanFormPage extends BasePage {


    ////    Your loan section
    @FindBy(css = "div > div > fieldset > div > div:nth-child(1) > div > div > label")
    private List<WebElement> loanType;


    ///About You section
    @FindBy(css = "#text-id-email")
    private WebElement emailInput;

    @FindBy(id = "radio-id-Mr")
    private WebElement titleMR;

    @FindBy(id = "radio-id-Ms")
    private WebElement titleMs;

    @FindBy(id = "radio-id-Miss")
    private WebElement titleMiss;

    @FindBy(css = "input[value=Mrs]")
    private WebElement titleMrs;

    @FindBy(css = "input[name=firstName]")
    private WebElement firstName;

    @FindBy(css = "input[name=lastName]")
    private WebElement lastName;

    @FindBy(css = "input[name=day]")
    private WebElement dobDAY;

    @FindBy(css = "input[name=month]")
    private WebElement dobMonth;

    @FindBy(css = "input[name=year]")
    private WebElement dobYear;


    ///// Your Finances section

    @FindBy(css = "#radio-id-EMPLOYED_FULL_TIME")
    private WebElement employedFullTime;

    @FindBy(css = "#SELF_EMPLOYED")
    private WebElement selfEmployed;

    @FindBy(css = "#annualIncome")
    private WebElement annualIncome;

    @FindBy(css = "#radio-id-OWNER_WITH_MORTGAGE")
    private WebElement homeOwnerWithMortgage;

    @FindBy(id = "postCode")
    private WebElement postCodeInput;

    @FindBy(css = "#address-history > div > div > button")
    private WebElement lookupAddressButton;

    @FindBy(id = "select-address")
    private WebElement selectAddress;

    @FindBy(id = "month-select")
    private WebElement monthSinceAddress;

    @FindBy(id = "year-select")
    private WebElement yearSinceAddress;

    @FindBy(css = "div.llkp3g-3.fNcomY > button")
    private WebElement useAddressButton;


    public void selectLoanType(String loantype) {

        WebElement loan = null;
        forceSleep(2);
        switch (loantype) {
            case "car loan":
                loan = loanType.get(0);
                break;
            case "Home improvement":
                loan = loanType.get(1);
                break;
            case "debt consolidation":
                loan = loanType.get(2);
                break;
            default:
                loan = loanType.get(3);
        }

        loan.click();

    }

    public void enterEmailID(String email) {
        waitForElementDisplay(emailInput, 60);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void selectTitle(String title) {

        if (title.equalsIgnoreCase("Mr")) {
            titleMR.click();
        } else if (title.equalsIgnoreCase("Ms")) {
            titleMs.click();
        } else if (title.equalsIgnoreCase("Miss")) {
            titleMiss.click();
        } else {
            titleMrs.click();
        }
    }

    public void selectEmploymentStatus(String employmentStatus) {
        waitForElementDisplay(employedFullTime, 60);
        employedFullTime.click();
    }

    public void enterAnnualIncome(String annualIncome) {
        waitForElementDisplay(this.annualIncome, 60);
        this.annualIncome.sendKeys(annualIncome);
    }

    public void selectHomeOwner(String homeowner) {
        waitForElementDisplay(homeOwnerWithMortgage, 60);
        homeOwnerWithMortgage.click();
    }

    public void enterPostCode(String postcode) {
        waitForElementDisplay(postCodeInput, 60);
        postCodeInput.sendKeys(postcode);
    }

    public void selectGivenAddress() {
        waitForElementDisplay(selectAddress, 60);
        new Select(selectAddress).selectByValue("74 Udall Gardens, Romford, RM5 2LA ");
    }

    public void selectMonthAndYearSincePresentAddress(String month, String year) {
        waitForElementDisplay(monthSinceAddress, 60);
        new Select(monthSinceAddress).selectByVisibleText(month);
        new Select(monthSinceAddress).selectByVisibleText(year);
    }
}
