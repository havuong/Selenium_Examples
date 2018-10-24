package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.openqa.selenium.support.How.*;
import static supports.CommonFunctions.*;

public class LoginTestWithScreenshot {
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        report = new ExtentReports("./src/test/resources/ExtentReport.html");
        test = report.startTest("Verify Welcome Text");
        test.log(LogStatus.INFO, "Browser Started...");
        setBrowser("ff");
        visit("http://www.letskodeit.com/");
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        Thread.sleep(10000);
        click(CSS, "div[title='Back to site']>svg");

        moveToElement(ID, "DrpDwnMn00label");

        click(ID, "comp-iiqg1vggactionTitle");
        test.log(LogStatus.INFO, "Clicked on signup link");

        click(ID, "signUpDialogswitchDialogLink");
        test.log(LogStatus.INFO, "Clicked on login link");

        fill(XPATH, "//div[@id='memberLoginDialogemail']//input", "test1@email.com");
        test.log(LogStatus.INFO, "Enter email");

        fill(XPATH, "//div[@id='memberLoginDialogpassword']//input", "abcabc");
        test.log(LogStatus.INFO, "Enter password");

        click(ID, "memberLoginDialogokButton");
        test.log(LogStatus.INFO, "Clicked Go button");

        Thread.sleep(3000);

//        Assert.assertTrue(getText(XPATH, "//div[text()='Hello test1']") != null); //correct
        Assert.assertTrue(getText(XPATH, "//div[text()='Hello test']") != null); //incorrect
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }
        report.endTest(test);
        report.flush();
        driver.quit();
    }
}
