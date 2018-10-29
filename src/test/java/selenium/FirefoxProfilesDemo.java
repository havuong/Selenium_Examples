package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxProfilesDemo {
    // Create a FF profile with name "automationprofile"
    //  Add some plugins and run this file
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver;

        String baseURL = "http://www.letskodeit.com";

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile fxProfile = profile.getProfile("automationprofile");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(fxProfile);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
}
