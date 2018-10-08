package selenium;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static supports.CommonFunctions.*;

public class ScreenShot {

    @Rule
    public TestRule watcher =  new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrFile,
                        new File("failshot_"
                                + description.getClassName()
                                + "_" + description.getMethodName()
                                + ".jpg"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };
    @Test
    public void onError(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/");
        Assert.assertEquals(false,true);
    }
}
