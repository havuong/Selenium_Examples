package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.XPATH;
import static supports.CommonFunctions.*;
import static supports.CommonFunctions.driver;

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
        hp.clickSignUpLink();

        click(ID, "signUpDialogswitchDialogLink");
        test.log(LogStatus.INFO, "Clicked on login link");

        fill(XPATH, "//div[@id='memberLoginDialogemail']//input", "test1@email.com");
        test.log(LogStatus.INFO, "Enter email");

        fill(XPATH, "//div[@id='memberLoginDialogpassword']//input", "abcabc");
        test.log(LogStatus.INFO, "Enter password");

        click(ID, "memberLoginDialogokButton");
        test.log(LogStatus.INFO, "Clicked Go button");

        Thread.sleep(3000);

        Assert.assertTrue(getText(XPATH, "//div[text()='Hello test1']") != null); //correct
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
        report.endTest(test);
        report.flush();

    }
}
