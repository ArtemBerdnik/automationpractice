package base;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestUtils;

@Listeners({ReportPortalTestNGListener.class})
public class TestNGBase {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = TestUtils.getDriver();
        wait = new WebDriverWait(driver, 8);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        TestUtils.closeDriver();
    }
}
