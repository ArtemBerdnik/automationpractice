package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogCapturer;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultsPage extends DefaultPage {

    @FindBy(css = "#selectProductSort")
    private WebElement sortingDropdown;

    @FindBy(css = "#grid")
    private WebElement grisView;

    @FindBy(css = "#list")
    private WebElement listView;

    @FindBy(css = "[class='product_list grid row'] a[class='product-name']")
    private List<WebElement> namesOfProducts;

    //=============================methods======================================


    //=============================checks=======================================
    public void verifyProductNames(String text) {
        LogCapturer.logInfoEventWithScreenshot("Result is : ");
        namesOfProducts.forEach(name -> assertTrue(name.getText().contains(text), String.format("Search results should contain specified text: '%s'", text)));
    }
}
