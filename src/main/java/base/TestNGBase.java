package base;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.BrowserDriverFactory;
import utils.TestUtils;

@Listeners({ReportPortalTestNGListener.class})
public class TestNGBase {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    public void beforeSuite(@Optional("chrome") String browser, @Optional("local") String environment) {
        // Create Driver
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        if (environment.equals("grid")) {
            driver = factory.createDriverGrid();
        } else {
            driver = factory.createDriver();
        }

        // maximize browser window
        driver.manage().window().maximize();

//        driver = TestUtils.getDriver();
        wait = new WebDriverWait(driver, 8);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        TestUtils.closeDriver();
    }
}
