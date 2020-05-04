import base.TestNGBase;
import dataProviders.DataProviders;
import enums.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static enums.Credentials.USER_WITH_CORRECT_EMAIL_AND_PASSWORD;

public class LoginTest extends TestNGBase {

    private HomePage homePage;
    private SignInPage signInPage;
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test(dataProvider = "usernamesAndPasswords", dataProviderClass = DataProviders.class)
    public void checkFailedLoginTypes(Credentials user) {
        //Open tested site
        LOGGER.info("Opening homepage");
        homePage.openSite();

        //Open Sign in page
        LOGGER.info("Clicking sign-in button");
        homePage.clickSignInButton();

        //Fill in data for user with incorrect pass
        LOGGER.info("Filling in email address");
        signInPage.fillInEmailAddressForLogIn(user);

        //Click sign in button
        LOGGER.info("Clicking Sing in button");
        signInPage.clickSignInButton();

        //Verify errors displayed
        LOGGER.info("Checking Error message");
        signInPage.checkErrorMessage(user);
    }

    @Test(groups = "TestGroup")
    public void checkSuccessfulLogin() {
        //Open tested site
        homePage.openSite();

        //Open Sign in page
        homePage.clickSignInButton();

        //Fill in data for user with incorrect pass
        signInPage.fillInEmailAddressForLogIn(USER_WITH_CORRECT_EMAIL_AND_PASSWORD);

        //Click sign in button
        signInPage.clickSignInButton();

        //Verify that the correct user is logged in
        signInPage.checkSuccessfulLogin(USER_WITH_CORRECT_EMAIL_AND_PASSWORD);
    }
}
