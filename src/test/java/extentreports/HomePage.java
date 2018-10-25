package extentreports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;
import static supports.CommonFunctions.click;
import static supports.CommonFunctions.moveToElement;

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
}
