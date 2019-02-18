package pageObjects;

import enums.PaymentMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static base.TestNGBase.driver;
import static enums.PaymentMethods.PAY_BY_BANK_WIRE;
import static enums.PaymentMethods.PAY_BY_CHECK;
import static org.testng.Assert.assertEquals;

public class CheckoutProcessPage extends DefaultPage {

    static WebDriverWait wait = new WebDriverWait(driver, 15);

    @FindBy(css = "[class='cart_navigation clearfix'] a[title='Proceed to checkout'] > span")
    private WebElement proceedToCheckoutButtonStep1;

    @FindBy(css = "#uniform-addressesAreEquals")
    private WebElement useSameAddressForBillingCheckbox;

    @FindBy(css = "button[name='processAddress'] > span")
    private WebElement proceedToCheckoutButtonStep3;

    @FindBy(css = "[class='cart_navigation clearfix'] button")
    private WebElement proceedToCheckoutButtonStep4;

    @FindBy(css = "#cart_navigation button")
    private WebElement proceedToCheckoutButtonStep5;

    @FindBy(css = "#address_delivery li:nth-of-type(n+2):nth-of-type(-n+6)")
    private List<WebElement> deliveryAddressDetails;

    @FindBy(css = "#address_invoice li:nth-of-type(n+2):nth-of-type(-n+6)")
    private List<WebElement> billingAddressDetails;

    @FindBy(css = "#uniform-cgv")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(css = "a[title='Pay by bank wire']")
    private WebElement payByBankWire;

    @FindBy(css = "a[title='Pay by check.']")
    private WebElement payByCheck;

    @FindBy(css = "[class='page-subheading']")
    private WebElement paymentHeader;

    @FindBy(css = "[class='alert alert-success']")
    private WebElement successfullOrderMessageAfterCheckPayment;

    @FindBy(css = ".cheque-indent")
    private WebElement successfullOrderMessageAfterBankWirePayment;


    //====================================methods================================

    public void completeSummaryStep() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButtonStep1));
        proceedToCheckoutButtonStep1.click();
    }

    public void completeAddressStep() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='cart_navigation clearfix'] [class='icon-chevron-right right']")));
        proceedToCheckoutButtonStep3.click();
    }

    public void clickTermsAndConditionsCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(termsAndConditionsCheckbox));
        termsAndConditionsCheckbox.click();
    }

    public void completeDeliveryStep() {
        proceedToCheckoutButtonStep4.click();
    }

    public void selectPaymentMethod(PaymentMethods paymentMethod) {
        if (paymentMethod.equals(PAY_BY_BANK_WIRE)) {
            wait.until(ExpectedConditions.elementToBeClickable(payByBankWire));
            payByBankWire.click();
        }

        if (paymentMethod.equals(PAY_BY_CHECK)) {
            wait.until(ExpectedConditions.elementToBeClickable(payByCheck));
            payByBankWire.click();
        }
    }

    public void confirmOrder() {
        proceedToCheckoutButtonStep5.click();
    }

    //====================================checks================================

    public void checkAddresses() {
        wait.until(ExpectedConditions.visibilityOf(useSameAddressForBillingCheckbox));

        //assertTrue(useSameAddressForBillingCheckbox.isSelected());
        List<String> delivery = new ArrayList<>();
        deliveryAddressDetails.forEach(d -> delivery.add(d.getText()));

        List<String> billing = new ArrayList<>();
        billingAddressDetails.forEach(b -> billing.add(b.getText()));

        assertEquals(delivery, billing);
    }

    public void checkCorrectPaymentIsSelected(PaymentMethods paymentMethod) {
        assertEquals(paymentHeader.getText(), paymentMethod.methodName);
    }

    public void checkThatOrderIsTaken(PaymentMethods paymentMethod) {
        String successfulMessage = "Your order on My Store is complete.";

        if (paymentMethod.equals(PAY_BY_BANK_WIRE)) {
            wait.until(ExpectedConditions.visibilityOf(successfullOrderMessageAfterBankWirePayment));
            assertEquals(successfullOrderMessageAfterBankWirePayment.getText(), successfulMessage);
        }

        if (paymentMethod.equals(PAY_BY_CHECK)) {
            wait.until(ExpectedConditions.visibilityOf(successfullOrderMessageAfterCheckPayment));
            assertEquals(successfullOrderMessageAfterCheckPayment.getText(), successfulMessage);
        }

    }

}
