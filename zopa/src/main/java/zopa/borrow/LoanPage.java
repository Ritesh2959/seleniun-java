package zopa.borrow;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import zopa.BasePage;
import zopa.Utilities;

public class LoanPage extends BasePage {


    @FindBy(css = "div > div:nth-child(1) > div > h1")
    private WebElement headingTag;

    @FindBy(name = "loan-amount-input")
    private WebElement loanAmountInputField;

    @FindBy(css = "div:nth-child(7) > div div:nth-child(5) > div:nth-child(1)")
    private WebElement loanTerm;

    @FindBy(css = "div:nth-child(1) form > div > button")
    private WebElement getPersonalLoanButton;

    public void verifyLoanPage() {
        forceSleep(3);
        String currentUrl = driver.getCurrentUrl();
        waitForElementDisplay(headingTag, 60);
        String heading = headingTag.getText();
        System.out.println(currentUrl + " Current URL");
        Assert.assertTrue(currentUrl.contains("/loans"));
        Assert.assertEquals("Personal loan", heading);
    }

    public void enterLoanAmount(String amount) {
        forceSleep(2);
        waitForElementDisplay(loanAmountInputField, 60);
        loanAmountInputField.clear();
        loanAmountInputField.sendKeys(amount);
    }

    public void selectLoanTerm(String term) {
        waitForElementDisplay(loanTerm, 60);
        System.out.println("Clicking on " + term + " year term ");
        driver.findElement(By.cssSelector("div:nth-child(7) > div div:nth-child(5) > div:nth-child(" + term + ")")).click();
    }

    public void clickGetPersonalRateButton() {
//        ceaseProductionTests();
        forceSleep(2);
        waitForElementDisplay(getPersonalLoanButton, 60);
//        Utilities.scrollIntoView(getPersonalLoanButton);
        getPersonalLoanButton.click();
    }
}
