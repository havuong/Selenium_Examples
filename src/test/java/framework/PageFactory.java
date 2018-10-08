package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SearchPageFactory;

import static supports.CommonFunctions.setBrowser;
import static supports.CommonFunctions.visit;

public class PageFactory {
    WebDriver driver;
    SearchPageFactory searchPage;

    @Test
    public void test() throws Exception {
        driver = setBrowser("ff");
        visit("https://www.expedia.com/");
        searchPage = new SearchPageFactory(driver);
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2018");
        searchPage.setReturnDate("10/31/2018");
    }
}

