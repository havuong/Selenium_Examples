package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "./src/test/resources/ExtentReport.html";
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Selenium Version", "3.13")
                .addSystemInfo("Platform", "Windows");

        return extent;
    }
}
