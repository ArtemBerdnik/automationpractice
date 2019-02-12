import base.TestNGBase;
import dataProviders.DataProviders;
import enums.Credentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class LoginTest extends TestNGBase {

    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test(dataProvider = "usernamesAndPasswords", dataProviderClass = DataProviders.class)
    public void checkFailedLoginTypes(Credentials user) {
        //Open Sign in page
        homePage.clickSignInButton();

        //Fill in data for user with incorrect pass
        signInPage.fillInEmailAddressForSignIn(user);

        //Click sign in button
        signInPage.clickSignInButton();

        //Verify errors displayed
        signInPage.checkErrorMessage(user);
    }
}
