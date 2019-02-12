import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static enums.Credentials.USER_WITH_INCORRECT_PASSWORD;

public class LoginTest extends TestNGBase {

    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test
    public void checkLoginWithIncorrectCreds() {
        //Open Sign in page
        homePage.clickSignInButton();

        //Fill in data for user with incorrect pass
        signInPage.fillInEmailAddressForSignIn(USER_WITH_INCORRECT_PASSWORD);

        //Click sign in button
        signInPage.clickSignInButton();

        //Verify errors displayed
        signInPage.checkErrorMessage();
    }
}
