package modules;

import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class MultipleWindows {

    @Test
    public void MultipleWindows() throws InterruptedException {
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/windows");
        click(How.CSS, ".example a");
//        click(How.XPATH,"//*[@id='content']/div/a");
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
//        System.out.println("Window 0: " + driver.getTitle());
        Assert.assertNotEquals(driver.getTitle(), "New Window");
        driver.switchTo().window(allWindows[1].toString());
        Thread.sleep(1000);
//        System.out.println("Window 1: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "New Window");
    }
}
