package pageObjects;

import enums.UsersForSignIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static base.TestNGBase.wait;
import static org.testng.Assert.assertTrue;

public class CreateAccountPage extends DefaultPage {

    @FindBy(css = ".radio-inline input")
    private List<WebElement> titles;

    @FindBy(css = "#customer_lastname")
    private WebElement lastName;

    @FindBy(css = "#customer_firstname")
    private WebElement firstName;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#id_state")
    private WebElement stateDropdown;

    @FindBy(css = "#id_state option")
    private List<WebElement> optionsInStateDropdown;

    @FindBy(css = "#postcode")
    private WebElement zipCode;

    @FindBy(css = "#id_country")
    private WebElement countryDropdown;

    @FindBy(css = "#id_country option")
    private List<WebElement> optionsInCountryDropdown;

    @FindBy(css = "#phone_mobile")
    private WebElement mobilePhone;

    @FindBy(css = "#submitAccount")
    private WebElement submitButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertWindow;
    //===================================methods=====================================

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public void fillInUserData(UsersForSignIn user) {

        try {
            for (WebElement userChoise : titles) {
                if (userChoise.getText().equals(user.getTitle())) {
                    userChoise.click();
                }
            }
        } catch (Exception e) {
            System.out.println("No such title found");
        }

        lastName.sendKeys(user.getlName());
        firstName.sendKeys(user.getfName());
        password.sendKeys(user.getPasswd());
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());

        stateDropdown.click();
        try {
            for (WebElement userChoise : optionsInStateDropdown) {
                if (userChoise.getText().equals(user.getState())) {
                    userChoise.click();
                }
            }
        }
        catch (Exception e) {
            System.out.println("No such state found");
        }

        zipCode.sendKeys(user.getZip());
        mobilePhone.sendKeys(user.getMobile());

    }


    //===================================checks======================================

    public void alertPopupIdDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertWindow));
        assertTrue(alertWindow.isDisplayed());
    }
}
