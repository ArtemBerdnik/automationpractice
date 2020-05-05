package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LogCapturer;

import static base.TestNGBase.driver;
import static base.TestNGBase.wait;
import static enums.Urls.HOME_PAGE;
import static org.testng.Assert.assertTrue;


public class HomePage extends DefaultPage {


    //Main content
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    //============================methods=======================================

    public void openSite() {
        driver.get(HOME_PAGE.url);
        LogCapturer.logInfoEventWithScreenshot(String.format("Opening %s", HOME_PAGE.url));
    }

    public void clickSignInButton() {
        LogCapturer.logInfoEventWithoutScreenshot(String.format("Clicking %s", singInButton.getText()));
        singInButton.click();
    }

    public void openSummerDressesPage() {
        Actions action = new Actions(driver);
        LOGGER.info(String.format("Scrolling down to %s", dressesDroddown.getText()));
        action.moveToElement(dressesDroddown).build().perform();
        wait.until(ExpectedConditions.visibilityOf(summerDressesMenu));
        LOGGER.info(String.format("Opening %s", dressesDroddown.getText()));
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
        LOGGER.info(String.format("Clicking %s", contactUsButton.getText()));
        contactUsButton.click();
    }


    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
