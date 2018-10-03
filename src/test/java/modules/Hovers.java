package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class Hovers {

    @Test
    public void Hovers(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/hovers");

        Actions builder = new Actions(driver);
        builder.moveToElement(getElement(How.CLASS_NAME,"figure")).build().perform();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

        Assert.assertEquals(isElementDisplayed(How.CLASS_NAME,"figcaption"),true);

    }
}
