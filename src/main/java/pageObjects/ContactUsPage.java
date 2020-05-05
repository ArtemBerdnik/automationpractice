package pageObjects;

import enums.SubjectsForContactForm;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FileManager;
import utils.LogCapturer;

import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactUsPage extends DefaultPage {

    @FindBy(css = "#id_contact")
    private WebElement subjectHeadingDropdown;

    @FindBy(css = "#id_contact option")
    private List<WebElement> optionsInSubjectDropdown;

    @FindBy(css = "[class='alert alert-danger'] li")
    private WebElement errorsInForm;

    @FindBy(css = "#email")
    private WebElement emailInput;

    @FindBy(css = "#id_order")
    private WebElement orderReferenceInput;

    @FindBy(css = "#message")
    private WebElement messageInput;

    @FindBy(css = "#fileUpload")
    private WebElement uploadFileButton;

    @FindBy(css = "#submitMessage")
    private WebElement submitMessage;

    @FindBy(css = "[class='alert alert-success']")
    private WebElement successMessage;

    @FindBy(css = "[class='footer_links clearfix'] [class='btn btn-default button button-small']")
    private WebElement homeButton;

    //====================================methods================================

    @SneakyThrows
    public void fillInContactForm(SubjectsForContactForm subject, String email, String ref, String message) {
        subjectHeadingDropdown.click();
        for (WebElement option : optionsInSubjectDropdown) {
            if (option.getText().equals(subject.getName())) {
                option.click();
            }
        }
        emailInput.sendKeys(email);
        orderReferenceInput.sendKeys(ref);
        messageInput.sendKeys(message);
        uploadFileButton.sendKeys(FileManager.getFileFromResources("example.txt").getAbsolutePath());
//        uploadFileButton.sendKeys(Paths.get(ContactUsPage.class.getClassLoader().getResource("example.txt").toURI()).toString());
        LogCapturer.logInfoEventWithScreenshot(String.format(
                "Filled in contact form with: email: %s, Refs: %s, Message: %s ", email, ref, message));
    }


    public void sendMessage() {
        submitMessage.click();
    }

    //====================================checks=================================

    public void checkOutputOfSendingMessage(SubjectsForContactForm subject, String email, String ref, String message) {
        LogCapturer.logInfoEventWithScreenshot("Result is: ");
        if (!email.matches(".+@.+\\..+")) {
            assertEquals(errorsInForm.getText(), "Invalid email address.");
        }
        if (email.matches(".+@.+\\..+") && message.isEmpty()) {
            assertEquals(errorsInForm.getText(), "The message cannot be blank.");
        }
        if (email.matches(".+@.+\\..+") && !message.isEmpty() && subject.getName().equals("-- Choose --")) {
            assertEquals(errorsInForm.getText(), "Please select a subject from the list provided.");
        }
        if (email.matches(".+@.+\\..+") && !message.isEmpty() && !subject.getName().equals("-- Choose --")) {
            assertEquals(successMessage.getText(), "Your message has been successfully sent to our team.");
        }
    }
}
