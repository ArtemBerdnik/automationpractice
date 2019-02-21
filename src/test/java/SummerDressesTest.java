import base.TestNGBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SummerDressesPage;

public class SummerDressesTest extends TestNGBase {

    private HomePage homePage;
    private SummerDressesPage summerDressesPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        summerDressesPage = PageFactory.initElements(driver, SummerDressesPage.class);
    }

    @Test
    public void checkSlider() {
        //Open tested site
        homePage.openSite();

        //Open summer dresses page
        homePage.openSummerDressesPage();

        //Move slider to a desired positions
        summerDressesPage.sliderTest(20, 29);

        //Verify that products are filtered out according to set of filters
        summerDressesPage.checkPricesForProducts(20,29);
    }
}
