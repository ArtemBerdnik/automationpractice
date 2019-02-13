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

    @FindBy(css = ".account")
    WebElement logginedInUserLink;

    @FindBy(css = ".account span")
    WebElement logginedInUserName;


    //Navigation
    @FindBy(css = "a[title='Women']")
    WebElement womenDropdown;

    @FindBy(css = "[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows'] > li:nth-child(2)")
    WebElement dressesDroddown;

    @FindBy(css = "[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows'] > li:nth-of-type(2) a[title='Casual Dresses']")
    WebElement casualDressesMenu;

    @FindBy(css = "[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows'] > li:nth-of-type(2) a[title='Summer Dresses']")
    WebElement summerDressesMenu;

    @FindBy(css = "[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows'] > li:nth-of-type(3) >a")
    WebElement tShirtsMenu;

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
