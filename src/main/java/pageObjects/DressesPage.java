package pageObjects;

import enums.Materials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static base.TestNGBase.driver;
import static base.TestNGBase.wait;

public class DressesPage extends DefaultPage {

    @FindBy(css = "#ul_layered_id_feature_6 > li:nth-child(1)")
    WebElement casualStyle;

    @FindBy(css = "#ul_layered_id_feature_6 > li:nth-child(2)")
    WebElement girlyStyle;

    @FindBy(css = "#layered_price_range")
    WebElement priceRange;

    @FindBy(css = "[class='ui-sliderTest-range ui-widget-header ui-corner-all']")
    WebElement slider;

    @FindBy(css = "#layered_price_slider > a:nth-of-type(1)")
    WebElement leftSliderControl;

    @FindBy(css = "#layered_price_slider > a:nth-of-type(2)")
    WebElement rightSliderControl;

    @FindBy(css = "[class='product_list grid row'] div[class='right-block'] span[itemprop='price']")
    List<WebElement> displayedPrices;

    @FindBy(css = "[class='product_list grid row'] > p img")
    WebElement loader;

    @FindBy(css = "#ul_layered_id_attribute_group_3 > li a")
    List<WebElement> colorFilters;

    @FindBy(css = "#ul_layered_id_feature_5 label")
    List<WebElement> compositionsFilers;

    @FindBy(css = "[class='product_list grid row'] [itemprop='image']")
    List<WebElement> productImages;

    @FindBy(css = ".right-block span[itemprop='price']")
    List<WebElement> productPrices;

    @FindBy(css = "[class='button lnk_view btn btn-default']")
    List<WebElement> moreButtons;

    //====================================methods================================

    public String trimWordsBySpace(String word) {
        int spacePos = word.indexOf(" ");
        if (spacePos > 0) {
            return word.substring(0, spacePos);
        }
        return word;
    }

    public void filterOutByMaterial(Materials desiredMaterial) {

        for (WebElement material : compositionsFilers) {
            if (trimWordsBySpace(material.getText()).toUpperCase().equals(desiredMaterial.name())) {
                material.click();
            }
        }
    }

    public void goToProductPage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='product_list grid row'] > p img")));
//        productImages.get(0).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(productPrices.get(0)).build().perform();
        actions.click(moreButtons.get(0)).build().perform();
    }

    //====================================checks==================================

}
