package test.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import static test.supports.CommonFunctions.*;

public class Frames {

    @Test
    public void nestedFrames(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(getText(How.ID,"content"),"MIDDLE");
    }

    @Test
    public void iFrames(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();
        Assert.assertNotEquals(afterText,beforeText);
        driver.switchTo().defaultContent();
        Assert.assertEquals(getText(How.CSS,"h3"),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}
