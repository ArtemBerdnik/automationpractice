import base.TestNGBase;
import dataProviders.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class SearchTest extends TestNGBase {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    }

    @Test(dataProvider = "textsForSearching", dataProviderClass = DataProviders.class, description = "Check searching functionality")
    public void checkSearchingResults(String text) {
        //Open tested site
        homePage.openSite();

        //Search for a specific text
        homePage.searchExactText(text);

        //Verify that products with specified text only are being displayed in the page
        searchResultsPage.verifyProductNames(text);
    }
}
