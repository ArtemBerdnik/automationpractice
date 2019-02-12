import base.TestNGBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class simpleTest extends TestNGBase {

    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void simpleTest() {

    }
}
