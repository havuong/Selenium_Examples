package test.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static test.supports.CommonFunctions.*;

public class Checkboxes {

    @Test(enabled = false)
    public void checkboxDiscoveryTest(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("with .attribute('checked')");
        for (WebElement checkbox : checkboxes){
            System.out.println(String.valueOf(checkbox.getAttribute("checked")));
        }
        System.out.println("\nwith .selected?");
        for (WebElement checkbox : checkboxes){
            System.out.println(checkbox.isSelected());
        }
    }

    @Test
    public void checkboxOption1(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/checkboxes");
        Assert.assertNotEquals(getAttri(How.CSS,"form input:nth-of-type(2)","checked"),"nul");
        Assert.assertEquals(getAttri(How.CSS,"form input:nth-of-type(2)","checked"),"true");
    }

    @Test
    public void checkboxOption2(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/checkboxes");
        Assert.assertEquals(isElementSelected(How.CSS,"form input:nth-of-type(2)"),true);
    }

}
