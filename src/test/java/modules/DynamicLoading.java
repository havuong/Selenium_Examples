package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class DynamicLoading {

    @Test
    public void noSuchElementErrorTest() {
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dynamic_loading/2");
        click(How.CSS,"#start button");
        Assert.assertEquals(getText(How.XPATH,"//*[@id='finish']/h4"),"Hello World!");
    }
    @Test
    public void webDriverWaitTest(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dynamic_loading/2");
        click(How.CSS,"#start button");
        new WebDriverWait(driver,8).until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        Assert.assertEquals(getText(How.XPATH,"//*[@id='finish']/h4"),"Hello World!");
    }
    @Test
    public void webDriverWaitTimeOutErrorTest(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dynamic_loading/2");
        click(How.CSS,"#start button");
        new WebDriverWait(driver,2).until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        Assert.assertEquals(getText(How.XPATH,"//*[@id='finish']/h4"),"Hello World!");
    }
    @Test
    public void cleanUpTest(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dynamic_loading/2");
        click(How.CSS,"#start button");
        waitFor(By.cssSelector("#finish"));
        Assert.assertEquals(getText(How.XPATH,"//*[@id='finish']/h4"),"Hello World!");
    }
    public void waitFor(By locator){
        new WebDriverWait(driver,8).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
