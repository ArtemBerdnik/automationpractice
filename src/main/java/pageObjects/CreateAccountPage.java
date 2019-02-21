package pageObjects;

import enums.UsersForSignIn;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static base.TestNGBase.driver;
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

    @FindBy(css = "[class='alert alert-danger'] li")
    private List<WebElement> errorMessages;
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
        } catch (Exception e) {
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

    public void checkMessagesInAlertsPopup(UsersForSignIn user) {
        submitButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(alertWindow));
            List<WebElement> errors = driver.findElements(By.cssSelector("[class='alert alert-danger'] li"));
            List<String> messages = new ArrayList<>();
            errors.forEach(x -> messages.add(x.getText()));

            if (!user.getPasswd().isEmpty() && user.getPasswd().length() < 5) {
                assertTrue(messages.contains("passwd is invalid."));
            }

            if (!user.getZip().matches("[0-9]{5}")) {
                assertTrue(messages.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
            }

            if (!user.getlName().matches("[a-zA-Z]*")) {
                assertTrue(messages.contains("lastname is invalid."));
            }

            if (!user.getfName().matches("[a-zA-Z]*")) {
                assertTrue(messages.contains("firstname is invalid."));
            }

            if (user.getState().isEmpty() || user.getState().equals("-")) {
                assertTrue(messages.contains("This country requires you to choose a State."));
            }

            if (user.getMobile().isEmpty()) {
                assertTrue(messages.contains("You must register at least one phone number."));
            }

            if (user.getfName().isEmpty()) {
                assertTrue(messages.contains("firstname is required."));
            }

            if (user.getlName().isEmpty()) {
                assertTrue(messages.contains("lastname is required."));
            }

            if (user.getAddress().isEmpty()) {
                assertTrue(messages.contains("address1 is required."));
            }

            if (user.getCity().isEmpty()) {
                assertTrue(messages.contains("city is required."));
            }


        } catch (TimeoutException ex) {
            System.out.println("No errors in the form");
        }

    }
}
