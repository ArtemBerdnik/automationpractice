package pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.TestNGBase.driver;
import static org.testng.Assert.assertTrue;


public class HomePage extends DefaultPage{

    //Main content


    //============================methods=======================================

    public void clickSignInButton() {
        singInButton.click();
    }

    public void openSummerDressesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(dressesDroddown).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(summerDressesMenu));
        summerDressesMenu.click();
    }

    public void searchExactText(String text) {
        String filledText = searchInput.getAttribute("value");
        if (!filledText.isEmpty()){
            searchInput.clear();
        }
        searchInput.sendKeys(text);
        submitSearch.click();
    }

    public void openDressesPage() {
        dressesDroddown.click();
    }


    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
