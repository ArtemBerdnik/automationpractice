import base.TestNGBase;
import enums.PaymentMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import static enums.Colors.ORANGE;
import static enums.Credentials.USER_WITH_CORRECT_EMAIL_AND_PASSWORD;
import static enums.Materials.COTTON;
import static enums.PaymentMethods.PAY_BY_BANK_WIRE;
import static enums.Sizes.M;

public class PurchaseTest extends TestNGBase {
    private HomePage homePage;
    private DressesPage dressesPage;
    private ProductPage productPage;
    private CheckoutProcessPage checkoutProcessPage;
    private SignInPage signInPage;


    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        dressesPage = PageFactory.initElements(driver, DressesPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        checkoutProcessPage = PageFactory.initElements(driver, CheckoutProcessPage.class);
    }

    @Test
    public void checkPurchaseOfOneThing() throws InterruptedException {

        homePage.openDressesPage();

        dressesPage.filterOutByColor(COTTON);

        dressesPage.goToProductPage();

        productPage.clickSizesDropdown();

        productPage.chooseSize(M);

        productPage.selectColor(ORANGE);

        productPage.addToCart();

        productPage.verifyConfirmationPopup();

        productPage.checkProductAttributes(ORANGE, M);

        productPage.proceedToCheckout();

        checkoutProcessPage.completeSummaryStep();

        signInPage.fillInEmailAddressForSignIn(USER_WITH_CORRECT_EMAIL_AND_PASSWORD);

        signInPage.clickSignInButton();

        checkoutProcessPage.checkAddresses();

        checkoutProcessPage.completeAddressStep();

        checkoutProcessPage.clickTermsAndConditionsCheckbox();

        checkoutProcessPage.completeDeliveryStep();

        checkoutProcessPage.selectPaymentMethod(PAY_BY_BANK_WIRE);

        checkoutProcessPage.checkCorrectPaymentIsSelected(PAY_BY_BANK_WIRE);

        checkoutProcessPage.confirmOrder();

        checkoutProcessPage.checkThatOrderIsTaken(PAY_BY_BANK_WIRE);
    }
}
