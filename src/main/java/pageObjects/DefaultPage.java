package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class DefaultPage {

    //Header
    @FindBy(css = ".banner")
    WebElement banner;

    @FindBy(css = ".nav")
    WebElement navigationPanel;

    @FindBy(css = "#contact-link > a")
    WebElement contactUsButton;

    @FindBy(css = ".header_user_info >a")
    WebElement singInButton;

    @FindBy(css = "[class = 'logo img-responsive']")
    WebElement logo;

    @FindBy(css = "[class = 'search_query form-control ac_input']")
    WebElement searchInput;

    @FindBy(css = "[name= 'submit_search']")
    WebElement submitSearch;


    //Footer

    //Newsletter block
    @FindBy(css = "#newsletter_block_left > h4")
    WebElement newsletterName;

    @FindBy(css = ".newsletter-input")
    WebElement newsletterInputField;

    @FindBy(css = "[name = 'submitNewsletter']")
    WebElement submitNewsletterAdress;

    //Social block
    @FindBy(css = "#social_block > h4")
    WebElement followUsName;

    @FindBy(css = "#social_block li:nth-child(1)")
    WebElement facebookLink;

    @FindBy(css = "#social_block li:nth-child(2)")
    WebElement twitterLink;

    @FindBy(css = "#social_block li:nth-child(3)")
    WebElement youtubeLink;

    @FindBy(css = "#social_block li:nth-child(4)")
    WebElement googlePlusLink;

}
