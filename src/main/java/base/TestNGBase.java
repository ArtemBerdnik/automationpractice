package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.TestUtils;

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
