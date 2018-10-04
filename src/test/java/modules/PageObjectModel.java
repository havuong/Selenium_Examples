package modules;

import org.testng.annotations.Test;
import pages.SearchPage;

import static supports.CommonFunctions.*;

public class PageObjectModel {

    @Test
    public void test() {
        setBrowser("ff");
        visit("https://www.expedia.com/");
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.destinationTextBox(driver).sendKeys("Chicago");
        SearchPage.departureDateTextBox(driver).sendKeys("12/25/2017");
        // Added a line to clear the return date text box
        // before entering the return date, because Expedia by default
        // enters the return date same as the departure date
        SearchPage.returnDateTextBox(driver).clear();
        SearchPage.returnDateTextBox(driver).sendKeys("12/31/2017");
        SearchPage.clickOnSearchButton(driver);
    }

}
