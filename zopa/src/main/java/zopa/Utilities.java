package zopa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utilities extends BasePage{

    static JavascriptExecutor js = (JavascriptExecutor) driver;


    public static void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
