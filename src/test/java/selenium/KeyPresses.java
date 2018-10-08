package selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class KeyPresses {

    @Test
    public void KeyPresses(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/key_presses");

//        click(How.XPATH,"/html/body");

        getElement(How.ID,"content").sendKeys(Keys.SPACE);
        Assert.assertEquals(getText(How.ID,"result"),"You entered: SPACE");

        Actions buider = new Actions(driver);
        buider.sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals(getText(How.ID,"result"),"You entered: ENTER");

    }
}
