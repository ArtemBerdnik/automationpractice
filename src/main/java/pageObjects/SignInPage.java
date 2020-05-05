package pageObjects;

import enums.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogCapturer;

import static base.TestNGBase.wait;
import static enums.Credentials.*;
import static org.testng.Assert.assertEquals;

public class SignInPage extends DefaultPage {

    private static final Logger LOGGER = LogManager.getLogger(SignInPage.class);

    @FindBy(css = "#email_create")
    private WebElement newEmailInput;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#email")
    private WebElement existingEmailInput;

    @FindBy(css = "#passwd")
    private WebElement passwordInput;

    @FindBy(css = "#SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "[class ='lost_password form-group'] > a")
    private WebElement forgotPasswordLink;

    @FindBy(css = "[class = 'alert alert-danger'] p")
    private WebElement amountOfErrorsHappened;

    @FindBy(css = "[class = 'alert alert-danger'] li")
    private WebElement textOfError;

    @FindBy(css = "#create_account_error")
    private WebElement emailAlreadyRegistred;


    //===================================methods=====================================

    public void fillInEmailAddressForLogIn(Credentials user) {
        LogCapturer.logInfoEventWithScreenshot(String.format("Filling in user's creds: %s, %s", user.getEmail(), user.getPass()));
        existingEmailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPass());
    }

    public void fillInEmailAddressToSignIn(Credentials credentials) {

        newEmailInput.sendKeys(credentials.getEmail());
        LOGGER.info(String.format("Filling in user's email address: %s", credentials.getEmail()));
        createAccountButton.click();

        try {
            wait.until(ExpectedConditions.visibilityOf(emailAlreadyRegistred));
            credentials.setEmail("1" + credentials.getEmail());
            newEmailInput.clear();
            fillInEmailAddressToSignIn(credentials);
        }
        catch(TimeoutException e) {
            System.out.println("No alert is being displayed");
        }
    }

    public void clickSignInButton() {
        LogCapturer.logInfoEventWithoutScreenshot("Clicking Sing in button");
        signInButton.click();
    }

    //===================================checks======================================

    public void checkErrorMessage(Credentials user) {
        assertEquals(amountOfErrorsHappened.getText(), "There is 1 error");

        if (user.equals(USER_WITHOUT_EMAIL)) {
            assertEquals(textOfError.getText(), "An email address required.");
        }
        if (user.equals(USER_WITH_INCORRECT_EMAIL)) {
            assertEquals(textOfError.getText(), "Invalid email address.");
        }
        if (user.equals(USER_WITH_INCORRECT_PASSWORD)) {
            assertEquals(textOfError.getText(), "Invalid password.");
        }
        if (user.equals(USER_WITHOUT_PASSWORD)) {
            assertEquals(textOfError.getText(), "Password is required.");
        }
        LogCapturer.logInfoEventWithScreenshot("Result is: ");
    }

    public void checkSuccessfulLogin(Credentials user) {
        assertEquals(logginedInUserName.getText(), user.getFirstName() + " " + user.getLastName());
        LogCapturer.logInfoEventWithScreenshot("Result is: ");
    }
}

