package modules;

import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import static supports.CommonFunctions.*;

public class JavaScriptAlerts {
    @Test(enabled = false)
    public void JSAlert(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/javascript_alerts");
        //*[@id='content']/div/ul/li[1]/button
        //button[.='Click for JS Alert']
        click(How.XPATH,"//ul/li[1]/button");
        driver.switchTo().alert().accept();
        Assert.assertEquals(getText(How.ID,"result"),"You successfuly clicked an alert");
    }
    @Test(enabled = false)
    public void JSConfirm(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/javascript_alerts");
        click(How.XPATH,"//ul/li[2]/button");
        driver.switchTo().alert().accept();
        Assert.assertEquals(getText(How.ID,"result"),"You clicked: Ok");
        click(How.XPATH,"//ul/li[2]/button");
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(getText(How.ID,"result"),"You clicked: Cancel");
    }
    @Test
    public void JSPrompt(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/javascript_alerts");
        click(How.XPATH,"//ul/li[3]/button");
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(getText(How.ID,"result"),"You entered: null");

        click(How.XPATH,"//ul/li[3]/button");
        driver.switchTo().alert().accept();
        Assert.assertEquals(getText(How.ID,"result"),"You entered:");

        click(How.XPATH,"//ul/li[3]/button");
        driver.switchTo().alert().sendKeys("Test JSPrompt");
        driver.switchTo().alert().accept();
        Assert.assertEquals(getText(How.ID,"result"),"You entered: Test JSPrompt");

    }
}
