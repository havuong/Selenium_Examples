package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

public class RightClick {
    @Test
    public void rightClick() throws InterruptedException {
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/context_menu");
        WebElement menu = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver).contextClick(menu);
//        action.moveToElement(menu).perform();
        action.build().perform();
        action.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
//        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");


    }
}
