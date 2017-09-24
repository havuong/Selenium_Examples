package test.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static test.supports.CommonFunctions.*;

import java.io.File;
import java.util.UUID;

public class FileDownload {
    WebDriver driver;
    File folder;

    @BeforeTest
    public void setUp(){
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir",folder.getAbsolutePath());
        profile.setPreference("browser.download.folerList",2);
        profile.setPreference("browser.helperApps.neverAsk.savetoDisk","image/jpeg, application/pdf, application/octet-stream");
        profile.setPreference("pdfjs.disabled",true);
        driver = new FirefoxDriver(profile);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        for(File file : folder.listFiles()){
            file.delete();
        }
        folder.delete();
    }

    @Test
       public void download(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/download");
        click(How.CSS,".example a");

        File[] listOfFiles = folder.listFiles();
        Assert.assertNotNull(listOfFiles.length);

        for (File file : listOfFiles){
            Assert.assertNotNull(file.length());
        }
     }
}
