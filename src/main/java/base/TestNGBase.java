package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static enums.Urls.HOME_PAGE;

public class TestNGBase {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 8);
        driver.get(HOME_PAGE.url);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
