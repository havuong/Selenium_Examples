package testNG;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ITestResultDemo {
    @Test
    public void testMethod1() {
        System.out.println("Running -> testMethod1");
        Assert.assertTrue(false);
    }

    @Test
    public void testMethod2() {
        System.out.println("Running -> testMethod2");
        Assert.assertTrue(true);
    }

    //We can get the status of the @Test method in @AfterMethod using ITestResult.
    //Once we have the status, then we can use that to decide what action we want to perform.
    //The best example is to take screenshots.
    //If the status of the test method is failed, then we can take a screenshot in the @AfterMethod.
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed: " + testResult.getMethod().getMethodName());
        }
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Successful: " + testResult.getName());
        }
    }
}
