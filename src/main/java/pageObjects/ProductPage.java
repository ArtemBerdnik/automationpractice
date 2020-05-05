package pageObjects;

import enums.Colors;
import enums.Sizes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogCapturer;

import java.util.Arrays;
import java.util.List;

import static base.TestNGBase.wait;
import static org.testng.Assert.assertEquals;

public class ProductPage extends DefaultPage {

    @FindBy(css = "#group_1")
    private WebElement sizeDropdown;

    @FindBy(css = "#group_1 > option")
    private List<WebElement> sizeDropdownOptions;

    @FindBy(css = "[name = 'Submit']")
    private WebElement submitButton;

    @FindBy(css = "[class = 'layer_cart_product col-xs-12 col-md-6']")
    private WebElement confirmationPopup;

    @FindBy(css = "[class = 'layer_cart_product col-xs-12 col-md-6'] h2")
    private WebElement confirmationPopupText;

    @FindBy(css = "#layer_cart_product_attributes")
    private WebElement orderAttributes;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#color_to_pick_list a")
    private List<WebElement> colorForProduct;

    //====================================methods================================

    public void clickSizesDropdown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bigpic")));
        sizeDropdown.click();
        LogCapturer.logInfoEventWithScreenshot("Expand sized dropdown");
    }

    public void chooseSize(Sizes sizes) {
        for (WebElement option : sizeDropdownOptions) {
            if (option.getText().equals(sizes.name())) {
                option.click();
                LogCapturer.logInfoEventWithScreenshot(String.format("Selected size %s", option.getText()));
            }
        }
    }

    public void selectColor(Colors color) {
        for (WebElement desiredColor : colorForProduct) {
            if (desiredColor.getAttribute("name").toUpperCase().equals(color.name())) {
                desiredColor.click();
                LogCapturer.logInfoEventWithScreenshot(String.format("Selected color %s", desiredColor.getText()));

            }
        }
    }

    public void addToCart() {
        submitButton.click();
        LogCapturer.logInfoEventWithoutScreenshot("Added product to the card");
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
        LogCapturer.logInfoEventWithoutScreenshot("Going to checkout");
    }

    public List<String> findProductAttributes() {
        return Arrays.asList(orderAttributes.getText().split(","));
    }

    //====================================checks================================

    public void verifyConfirmationPopup() {
        wait.until(ExpectedConditions.visibilityOf(confirmationPopup));
        assertEquals(confirmationPopupText.getText(), "Product successfully added to your shopping cart");
        LogCapturer.logInfoEventWithScreenshot("Confirmation popup: ");

    }

    public void checkProductAttributes(Colors color, Sizes size) {
        assertEquals(findProductAttributes().get(0).toUpperCase(), color.name());
        assertEquals(findProductAttributes().get(1).toUpperCase().substring(1), size.name());
        LogCapturer.logInfoEventWithScreenshot("Product attributes are: ");
    }

}
