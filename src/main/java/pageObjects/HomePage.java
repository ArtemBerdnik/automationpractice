package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;


public class HomePage extends DefaultPage{

    //Main content


    //============================methods=======================================




    //============================checks========================================

    public void checkBannerIsDispalyed() {
        assertTrue(banner.isDisplayed());
    }
}
