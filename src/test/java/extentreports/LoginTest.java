package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;
    HomePage hp;

    @BeforeClass
    public void beforeClass() {
        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        test.log(LogStatus.INFO, "Browser Started...");
        setBrowser("ff");
        visit("http://www.letskodeit.com/");
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        hp = new HomePage(driver, test);
        hp.login("test@email.com", "abcabc");

        Thread.sleep(3000);

        boolean result = hp.isWelcomeTextPresent();

        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
        report.endTest(test);
        report.flush();

    }
}
