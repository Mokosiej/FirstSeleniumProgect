package Homework.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart(String productName) {
        click(By.linkText(productName));
        click(By.id("add-to-cart-button-31"));
    }

    public boolean isItemInCart(String productName) {
        click(By.cssSelector(".cart-label"));
        return isElementPresent(By.linkText(productName));
    }

    public void clearCart() {
        click(By.cssSelector(".cart-label"));
        if (isElementPresent(By.name("updatecart"))) {
            click(By.name("updatecart"));
        }
    }
}

