package base;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.BrowserDriverFactory;

@Listeners({ReportPortalTestNGListener.class})
public class TestNGBase {

    public static WebDriver driver;
    public static WebDriverWait wait;
    protected Logger log;

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    public void beforeSuite(@Optional("chrome") String browser, @Optional("local") String environment, ITestContext ctx) {
        // Create Driver
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        if (environment.equals("grid")) {
            driver = factory.createDriverGrid();
        } else {
            driver = factory.createDriver();
        }

        // maximize browser window
        driver.manage().window().maximize();

        // Set up test name and Logger
        setCurrentThreadName();
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

//        driver = TestUtils.getDriver();
//        wait = new WebDriverWait(driver, 8);
    }

    @AfterMethod(alwaysRun = true)
    public void afterSuite() {
        log.info("[Closing driver]");
        driver.quit();
    }

    private void setCurrentThreadName() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        String threadId = String.valueOf(thread.getId());
        if (!threadName.contains(threadId)) {
            thread.setName(threadName + " " + threadId);
        }
    }
}
