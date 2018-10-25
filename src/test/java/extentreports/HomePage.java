package extentreports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.How.*;
import static supports.CommonFunctions.*;

public class HomePage {
    ExtentTest test;
    WebDriver driver = null;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSignUpLink() throws InterruptedException {
        Thread.sleep(10000);
        click(CSS, "div[title='Back to site']>svg");

        moveToElement(ID, "DrpDwnMn00label");

        click(ID, "comp-iiqg1vggactionTitle");
        test.log(LogStatus.INFO, "Clicked on signup link");
    }

    public void clickLoginLink() {
        click(ID, "signUpDialogswitchDialogLink");
        test.log(LogStatus.INFO, "Clicked on login link");
    }

    public void enterEmail(String email) {
        fill(XPATH, "//div[@id='memberLoginDialogemail']//input", "test1@email.com");
        test.log(LogStatus.INFO, "Enter email");
    }

    public void enterPassword(String password) {
        fill(XPATH, "//div[@id='memberLoginDialogpassword']//input", "abcabc");
        test.log(LogStatus.INFO, "Enter password");
    }

    public void clickGoLink() {
        click(ID, "memberLoginDialogokButton");
        test.log(LogStatus.INFO, "Clicked Go button");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test1']"));
            if (welcomeText != null) {
                return true;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
    public void login(String email, String password) throws InterruptedException {
        clickSignUpLink();
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickGoLink();
    }
}
