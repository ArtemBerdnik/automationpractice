import base.TestNGBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SummerDressesPage;

public class simpleTest extends TestNGBase {

    private HomePage homePage;
    private SummerDressesPage summerDressesPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        summerDressesPage = PageFactory.initElements(driver, SummerDressesPage.class);
    }

    @Test
    public void simpleTest() {
    }
}
