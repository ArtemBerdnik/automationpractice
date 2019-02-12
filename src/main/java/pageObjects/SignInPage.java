package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends DefaultPage{

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

    //===================================methods=====================================


    //===================================checks======================================


}

