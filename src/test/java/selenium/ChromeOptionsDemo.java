package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeOptionsDemo {
    // Extract CRX File: Go to http://crxextractor.com/ and click start button
    // Enter the chrome extension: https://chrome.google.com/webstore/detail/adblock/gighmmpiobklfepjocnamgkkbiglidom
    // Click on Get .CRX button, CRX file corresponding to the extension will be downloaded
    public static void main(String[] args) {
        String baseURL = "http://www.google.com";
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Set the path to CRX File to add extensions method
        options.addExtensions(new File("extension.crx"));

        //  From Selenium 3.8.1 version, driver capabilities class is deprecated
        //  and you need to merge capabilities object with Chrome Options object before passing the same as an argument to Chrome Driver constructor
        /*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        */

        driver = new ChromeDriver(options);
        driver.get(baseURL);
    }
}
