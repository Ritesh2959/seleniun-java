package zopa;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserFactory extends BasePage {

    public static WebDriver startBrowser(String browsername, String url) throws MalformedURLException, InterruptedException {
        if (driver == null || !isSessionActive()) {
            try {
                driver = startRemoteWebBrowser(browsername, url);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (!browsername.equalsIgnoreCase("htmlunit")) {
            assert driver != null;
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void changeBrowserSize(String mode) {
        driver.manage().window().setSize(new Dimension(768, 1024));
//        driver.manage().window().setSize(new  Dimension (375, 667));
//       WebDriverProvider.get().manage().window().setSize(new Dimension((75,150))));
    }


    public static boolean isSessionActive() {
        sessionCount = sessionCount + 1;

        try {
            return driver.findElements(By.tagName("body")).size() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public static void QuitBrowser() {
        getDriver().quit();
    }

    protected static WebDriver startRemoteWebBrowser(String browsername, String url) {

        //Switch to on or off the selenium grid
        if (LoadProps.getProperty("REMOTE_BROWSER").equals("true")) {
            try {
                // Set Chrome
                if (browsername.toLowerCase().equals("chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();

                    if (LoadProps.getProperty("OS").toLowerCase().equals("linux")) {
                        chromeOptions.setPlatformName("LINUX");
                        System.out.println(" ***************************** MAC machine running *****************************");
                    } else {
                        System.out.println(" ***************************** WIN machine running *****************************");
                        chromeOptions.setPlatformName("Windows 10");
                    }

                    URL GridURL = new URL(LoadProps.getProperty("selgrid"));
                    driver = new RemoteWebDriver(GridURL, chromeOptions);
                    return driver;
                }
                // Set Firefox
                if (browsername.toLowerCase().equals("firefox")) {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    if (LoadProps.getProperty("OS").equals("osx")) {
                        firefoxOptions.setPlatformName("LINUX");
                    } else {
                        firefoxOptions.setPlatformName("Windows 10");
                    }

                    URL GridURL = new URL(LoadProps.getProperty("selgrid"));
                    driver = new RemoteWebDriver(GridURL, firefoxOptions);
                    return driver;
                }

                // Set Safari
                if (browsername.toLowerCase().equals("safari")) {
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPlatformName("MAC");

                    URL GridURL = new URL(LoadProps.getProperty("selgrid"));
                    driver = new RemoteWebDriver(GridURL, safariOptions);
                    return driver;
                }

                // Set Edge
                if (browsername.equals("MicrosoftEdge")) {
                    System.out.println("This is edge !");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPlatformName("Windows 10");

                    URL GridURL = new URL(LoadProps.getProperty("selgrid"));
                    driver = new RemoteWebDriver(GridURL, edgeOptions);
                    return driver;
                }
            } catch (Exception e) {
                return null;
            }

        } else {
            try {
                System.out.println("browser is " + browsername);
                if (browsername.equalsIgnoreCase("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src\\test\\BrowserFiles\\geckodriver.exe");
                    driver = new FirefoxDriver();
                } else if (browsername.equalsIgnoreCase("Chrome")) {
//                    System.setProperty("webdriver.chrome.driver", "src\\test\\BrowserFiles\\chromedriver");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                } else if (browsername.equalsIgnoreCase("IE")) {
                    driver = new InternetExplorerDriver();
                } else if (browsername.equalsIgnoreCase("Edge")) {
                    System.setProperty("webdriver.edge.driver", "src\\test\\BrowserFiles\\msedgedriver.exe");
                    driver = new EdgeDriver();
                } else if (browsername.equalsIgnoreCase("Safari")) {
                    driver = new SafariDriver();
                } else if (browsername.equalsIgnoreCase("htmlUnit")) {
                    driver = new HtmlUnitDriver();
                } else {
                    throw new RuntimeException("Given Browser " + browsername + " binary not available");
                }
            } catch (Exception e) {
                throw new RuntimeException("Given Browser " + browsername + " did not load..");
            }
        }
        return driver;
    }


    public static WebDriver getDriver() {
        return driver;
    }


}