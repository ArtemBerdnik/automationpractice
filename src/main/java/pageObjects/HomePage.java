package pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static base.TestNGBase.driver;
import static base.TestNGBase.wait;
import static enums.Urls.HOME_PAGE;
import static org.testng.Assert.assertTrue;


public class HomePage extends DefaultPage {


    //Main content


    //============================methods=======================================

    public void openSite() {
        driver.get(HOME_PAGE.url);
    }

    public void clickSignInButton() {
        singInButton.click();
    }

    public void openSummerDressesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(dressesDroddown).build().perform();
        wait.until(ExpectedConditions.visibilityOf(summerDressesMenu));
        summerDressesMenu.click();
    }

    public void searchExactText(String text) {
        String filledText = searchInput.getAttribute("value");
        if (!filledText.isEmpty()) {
            searchInput.clear();
        }
        searchInput.sendKeys(text);
        submitSearch.click();
    }

    public void openDressesPage() {
        dressesDroddown.click();
    }

    public void openContactUsPage() {
        contactUsButton.click();
    }


    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
