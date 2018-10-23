package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static supports.CommonFunctions.*;

import java.io.File;
import java.util.UUID;

public class FileDownload {
    WebDriver driver;
    File folder;

    @BeforeTest
    public void setUp(){
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("browser.download.dir",folder.getAbsolutePath());
        firefoxOptions.setCapability("browser.download.folerList",2);
        firefoxOptions.setCapability("browser.helperApps.neverAsk.savetoDisk","image/jpeg, application/pdf, application/octet-stream");
        firefoxOptions.setCapability("pdfjs.disabled",true);
        driver = new FirefoxDriver(firefoxOptions);
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
