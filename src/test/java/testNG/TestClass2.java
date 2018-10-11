package testNG;

import org.testng.annotations.*;

public class TestClass2 extends BaseTestSuite{
    @BeforeClass
    public void setUp() {
        System.out.println("\nTestNG_TestClass2 -> before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("\nTestNG_TestClass2 -> after class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\nTestNG_TestClass2 -> before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\nTestNG_TestClass2 -> after method");
    }

    @Test
    public void testMethod1() {
        System.out.println("\nTestNG_TestClass2 -> testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("\nTestNG_TestClass2 -> testMethod2");
    }
}
