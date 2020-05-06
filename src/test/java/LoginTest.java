import base.TestNGBase;
import dataProviders.DataProviders;
import enums.Credentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static enums.Credentials.USER_WITH_CORRECT_EMAIL_AND_PASSWORD;

public class LoginTest extends TestNGBase {

    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test(dataProvider = "usernamesAndPasswords", dataProviderClass = DataProviders.class, description = "Check loggining in functionality with incorrect creds")
    public void checkFailedLoginTypes(Credentials user) {
        //Open Sign in page
        homePage.openSite()
                .clickSignInButton();

        //Fill in data for user with incorrect pass
        //Verify errors displayed
        signInPage.fillInEmailAddressForLogIn(user)
                .clickSignInButton()
                .checkErrorMessage(user);
    }

    @Test(description = "Check loggining in functionality with correct creds")
    public void checkSuccessfulLogin() {
        //Open Sign in page
        homePage.openSite()
                .clickSignInButton();

        //Fill in data for user with incorrect pass
        //Verify that the correct user is logged in
        signInPage.fillInEmailAddressForLogIn(USER_WITH_CORRECT_EMAIL_AND_PASSWORD)
                .clickSignInButton()
                .checkSuccessfulLogin(USER_WITH_CORRECT_EMAIL_AND_PASSWORD);
    }
}
