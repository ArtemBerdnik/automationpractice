package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.TestNGBase.driver;
import static org.testng.Assert.assertTrue;

public class SummerDressesPage extends DressesPage {



    //====================================methods================================


    public double getLeftNumber() {
        return Double.parseDouble(priceRange.getText().substring(1, 6));
    }

    public double getRightNumber() {
        return Double.parseDouble(priceRange.getText().substring(10, 15));
    }

    public void sliderTest(int from, int to) {
        //one shift of slider
        double shift = 0.16;
        //how much times we need to move slider
        double iteration;

        Actions action = new Actions(driver);

        //Work with the left slider
        if (from > getLeftNumber()) {
            iteration = (from - getLeftNumber()) / shift;
            action.click(leftSliderControl);
            for (int i = 0; i < iteration; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }

        //Work with the right slider
        if (to < getRightNumber()) {
            iteration = (getRightNumber() - to) / shift;
            action.click(rightSliderControl);
            for (int i = 0; i < iteration - 1; i++) {
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }

        new WebDriverWait(driver, 55).until(ExpectedConditions
                .invisibilityOfElementLocated(By.cssSelector("[class='product_list grid row'] > p img")));
    }

    public void selectStyle() {
        girlyStyle.click();
    }

    public void test() {
        for (WebElement displayedPrice : displayedPrices) {
            System.out.println(displayedPrice.getText());
        }
    }

    //====================================checks=================================

    public void checkPricesForProducts(int from, int to) {
        driver.findElements(By.cssSelector("[class='product_list grid row'] div[class='right-block'] span[itemprop='price']"))
                .forEach(price -> assertTrue(Double.parseDouble(price.getText().substring(1)) >= from
                        && Double.parseDouble(price.getText().substring(1)) <= to));
    }
}


