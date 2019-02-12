package pageObjects;

import enums.Credentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static enums.Credentials.*;
import static org.testng.Assert.assertEquals;

public class SignInPage extends DefaultPage {

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


    //===================================methods=====================================

    public void fillInEmailAddressForSignIn(Credentials user) {
        existingEmailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPass());
    }

    public void clickSignInButton() {
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
    }

    public void checkSuccessfulLogin(Credentials user) {
        assertEquals(logginedInUserName.getText(), user.getFirstName()+ " " + user.getLastName());
    }
}

