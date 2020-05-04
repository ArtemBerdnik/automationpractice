import base.TestNGBase;
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


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        dressesPage = PageFactory.initElements(driver, DressesPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        checkoutProcessPage = PageFactory.initElements(driver, CheckoutProcessPage.class);
    }

    @Test(groups = "TestGroup")
    public void checkPurchaseOfOneThing() {
        //Open tested site
        homePage.openSite();

        //Open dresses page
        homePage.openDressesPage();

        //Filter everything out by desired material
        dressesPage.filterOutByMaterial(COTTON);

        //Go to detailed page of desired product
        dressesPage.goToProductPage();

        //Select desired size
        productPage.clickSizesDropdown();
        productPage.chooseSize(M);

        //Select desired color
        productPage.selectColor(ORANGE);

        //Add product to the cart
        productPage.addToCart();

        //Check the exact product was added
        productPage.verifyConfirmationPopup();
        productPage.checkProductAttributes(ORANGE, M);

        //Go to checkout
        productPage.proceedToCheckout();

        //Review the order and go to sign in page
        checkoutProcessPage.completeSummaryStep();

        //Log in
        signInPage.fillInEmailAddressForLogIn(USER_WITH_CORRECT_EMAIL_AND_PASSWORD);
        signInPage.clickSignInButton();

        //Check delivery address
        checkoutProcessPage.checkAddresses();
        checkoutProcessPage.completeAddressStep();

        //Tick terms and conditions checkbox
        checkoutProcessPage.clickTermsAndConditionsCheckbox();

        //Go to payment page
        checkoutProcessPage.completeDeliveryStep();

        //Select desired payment method
        checkoutProcessPage.selectPaymentMethod(PAY_BY_BANK_WIRE);

        //Check the correct payment is selected
        checkoutProcessPage.checkCorrectPaymentIsSelected(PAY_BY_BANK_WIRE);

        //Finally confirm your order
        checkoutProcessPage.confirmOrder();

        //Check that order is successful
        checkoutProcessPage.checkThatOrderIsTaken(PAY_BY_BANK_WIRE);
    }
}
