package Homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @Test
    public void addItemToCartTest() {

        login("muthA@dg.com", "QwEr!2#5");

        String productName = "14.1-inch Laptop";

        click(By.linkText(productName));
        click(By.id("add-to-cart-button-31"));


        click(By.cssSelector(".cart-label"));


        Assert.assertTrue(isElementPresent(By.linkText(productName)),
                "Ошибка: товар " + productName + " не найден в корзине!");


        clearCart();
    }


    private void login(String email, String password) {
        click(By.cssSelector(".ico-login"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));
    }


    private void clearCart() {
        click(By.cssSelector(".cart-label"));
        if (isElementPresent(By.name("updatecart"))) {
            click(By.name("updatecart"));
        }
    }
}
