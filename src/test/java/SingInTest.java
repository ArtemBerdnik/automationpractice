import base.TestNGBase;
import dataProviders.DataProviders;
import enums.UsersForSignIn;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;

import static enums.Credentials.NEW_USER;
import static enums.UsersForSignIn.USER_WITHOUT_ERRORS;

public class SingInTest extends TestNGBase {

    private HomePage homePage = new HomePage();
    private SignInPage signInPage = new SignInPage();
    private CreateAccountPage createAccountPage = new CreateAccountPage();
    private MyAccountPage myAccountPage = new MyAccountPage();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    }


    @Test(dataProvider = "usersForSignInWithErrors", dataProviderClass = DataProviders.class, groups = "TestGroup")
    public void checkErrorsDuringSigningIn(UsersForSignIn user) {
        //Open tested site
        homePage.openSite();

        //Open Sign in page
        homePage.clickSignInButton();

        //Specify an email for login
        signInPage.fillInEmailAddressToSignIn(NEW_USER);

        //Click submit button to check if a warning is displayed
        createAccountPage.clickSubmitButton();

        //Assert alert
        createAccountPage.alertPopupIdDisplayed();

        //Fill in all required fields
        createAccountPage.fillInUserData(user);

        //Check error messages (if any)
        createAccountPage.checkMessagesInAlertsPopup(user);

//        //Assert that signing in successful and my account page is displayed
//        myAccountPage.checkElementsOnMyAccountPage();
//        myAccountPage.checkThatCorrectUserIsLogginedIn(user);
    }

    @Test(groups = "TestGroup")
    public void checkSuccessfulSigningIn() {
        //Open Sign in page
        homePage.clickSignInButton();

        //Specify an email for login
        signInPage.fillInEmailAddressToSignIn(NEW_USER);

        //Fill in all required fields
        createAccountPage.fillInUserData(USER_WITHOUT_ERRORS);
        createAccountPage.clickSubmitButton();

        //Assert that signing in successful and my account page is displayed
        myAccountPage.checkElementsOnMyAccountPage();
        myAccountPage.checkThatCorrectUserIsLogginedIn(USER_WITHOUT_ERRORS);
    }
}
