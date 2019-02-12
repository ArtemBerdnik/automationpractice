package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;


public class HomePage {

    @FindBy(css = ".banner")
    private WebElement banner;

    @FindBy(css = ".nav")
    private WebElement navigationPanel;

    @FindBy(css = "[class = 'logo img-responsive']")
    private WebElement logo;

    @FindBy(css = "[class = 'search_query form-control ac_input']")
    private WebElement searchInput;

    @FindBy(css = "[name= 'submit_search']")
    private WebElement submitSearch;

    //============================methods=======================================




    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
