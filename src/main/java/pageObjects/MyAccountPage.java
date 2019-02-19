package pageObjects;

import enums.UsersForSignIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static base.TestNGBase.wait;
import static org.testng.Assert.assertEquals;

public class MyAccountPage extends DefaultPage {

    @FindBy(css = ".page-heading")
    private WebElement pageHeading;

    @FindBy(css = "[class='row addresses-lists'] li")
    private List<WebElement> optionsOnMyAccountPage;

    @FindBy(css = "[class='header_user_info'] span")
    private WebElement logginedInUser;

    //===================================methods=====================================


    //===================================checks======================================
    public void checkElementsOnMyAccountPage() {
        wait.until(ExpectedConditions.visibilityOf(pageHeading));

        assertEquals(pageHeading.getText(), "MY ACCOUNT");
        assertEquals(optionsOnMyAccountPage.size(), 5);
    }

    public void checkThatCorrectUserIsLogginedIn(UsersForSignIn user) {
        assertEquals(logginedInUser.getText(), user.getfName() + " " + user.getlName());
    }
}
