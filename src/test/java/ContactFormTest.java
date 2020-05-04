import base.TestNGBase;
import dataProviders.DataProviders;
import enums.SubjectsForContactForm;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class ContactFormTest extends TestNGBase {

    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @Test(dataProvider = "dataForContactForm", dataProviderClass = DataProviders.class, groups = "TestGroup")
    public void checkSendingMessageForm(SubjectsForContactForm subject, String email, String reference, String message) {
        //Open tested site
        homePage.openSite();

        //Navigate to contact page
        homePage.openContactUsPage();

        //Fill in form
        contactUsPage.fillInContactForm(subject, email, reference, message);

        //Send message
        contactUsPage.sendMessage();

        //Verify messages received
        contactUsPage.checkOutputOfSendingMessage(subject, email, reference, message);
    }
}
