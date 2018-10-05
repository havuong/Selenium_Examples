package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
    public static WebDriver driver;
    final static Logger logger = LogManager.getLogger(CommonFunctions.class);

    public static WebElement getElement(How how, String locator) {
        switch (how) {
            case CLASS_NAME:
                return driver.findElement(By.className(locator));
            case CSS:
                return driver.findElement(By.cssSelector(locator));
            case ID:
                return driver.findElement(By.id(locator));
            case ID_OR_NAME:
                break;
            case LINK_TEXT:
                return driver.findElement(By.linkText(locator));
            case NAME:
                return driver.findElement(By.name(locator));
            case PARTIAL_LINK_TEXT:
                return driver.findElement(By.partialLinkText(locator));
            case TAG_NAME:
                return driver.findElement(By.tagName(locator));
            case XPATH:
                return driver.findElement(By.xpath(locator));
            case UNSET:
                break;
        }
        return null;
    }

    public static WebDriver setBrowser(String browserName) {
        logger.info("========== Open browser ==========");
        if (driver == null) {
            switch (browserName) {
                case "ff":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "chr":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }

        }
        return driver;
    }

    public static void visit(String url) {
        logger.info("Get: " + url);
        driver.get(url);
    }

    public static void closeBrowser() {
        logger.info("========== Close browser ==========");
        driver.quit();
    }

    public static void waitForElement(How how, String locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(getElement(how, locator)));
    }

    public static void click(How how, String locator) {
        logger.info("Click: " + locator);
        waitForElement(how, locator, 30);
        getElement(how, locator).click();
    }

    public static void dblClick(How how, String locator) {
        Actions actions = new Actions(driver);
        waitForElement(how, locator, 30);
        actions.doubleClick(getElement(how, locator)).perform();
    }

    public static void fill(How how, String locator, String withText) {
        waitForElement(how, locator, 30);
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(withText);
    }

    public static void fillKeys(How how, String locator, Keys withKey) {
        waitForElement(how, locator, 30);
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(withKey);
    }

    public static String getText(How how, String locator) {
        waitForElement(how, locator, 30);
        return getElement(how, locator).getText();
    }

    public static String getAttri(How how, String locator, String attribute) {
        waitForElement(how, locator, 30);
        return getElement(how, locator).getAttribute(attribute);
    }

    public static String getCSSValue(How how, String locator, String CSSValue) {
        waitForElement(how, locator, 30);
        return getElement(how, locator).getCssValue(CSSValue);
    }

    public static boolean isElementDisplayed(How how, String locator) {
        waitForElement(how, locator, 30);
        return getElement(how, locator).isDisplayed();
    }

    public static boolean isElementSelected(How how, String locator) {
        waitForElement(how, locator, 30);
        return getElement(how, locator).isSelected();
    }
}




