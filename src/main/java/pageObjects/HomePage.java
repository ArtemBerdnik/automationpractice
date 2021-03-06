package pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogCapturer;

import static base.TestNGBase.driver;
import static base.TestNGBase.wait;
import static enums.Urls.HOME_PAGE;
import static org.testng.Assert.assertTrue;


public class HomePage extends DefaultPage {


    //Main content

    //============================methods=======================================

    public HomePage openSite() {
        driver.get(HOME_PAGE.url);
        LogCapturer.logInfoEventWithScreenshot(String.format("Opening %s", HOME_PAGE.url));
        return this;
    }

    public SignInPage clickSignInButton() {
        if (!singInButton.getText().equals("Sign in")) {
            LogCapturer.logInfoEventWithScreenshot(String.format("User '%s' has already been logged in. Logging out", singInButton.getText()));
            logOutButton.click();
            wait.until(ExpectedConditions.textToBePresentInElement(singInButton, "Sign in"));
        }
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Clicking %s", singInButton.getText()));
        singInButton.click();
        return new SignInPage();
    }

    public void openSummerDressesPage() {
        Actions action = new Actions(driver);
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Scrolling down to %s", dressesDroddown.getText()));
        action.moveToElement(dressesDroddown).build().perform();
        wait.until(ExpectedConditions.visibilityOf(summerDressesMenu));
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Opening %s", dressesDroddown.getText()));
        summerDressesMenu.click();
    }

    public void searchExactText(String text) {
        String filledText = searchInput.getAttribute("value");
        if (!filledText.isEmpty()) {
            LogCapturer.logInfoEventWithScreenshot(String.format("Search input is not empty (text is in %s). Clearing the field", filledText));
            searchInput.clear();
        }
        LogCapturer.logInfoEventWithScreenshot(String.format("Specifying desired text: %s", text));
        searchInput.sendKeys(text);
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Clicking %s", submitSearch.getText()));
        submitSearch.click();
    }

    public void openDressesPage() {
        LogCapturer.logInfoEventWithScreenshot(String.format("Opening %s", dressesDroddown.getText()));
        dressesDroddown.click();
    }

    public void openContactUsPage() {
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Clicking %s", contactUsButton.getText()));
        contactUsButton.click();
    }


    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
