package Homework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.user.login("muthA@dg.com", "QwEr!2#5");
    }

    @Test
    public void addItemToCartTest() {
        String productName = "14.1-inch Laptop";
        app.cart.addItemToCart(productName);

        Assert.assertTrue(app.cart.isItemInCart(productName),
                "Ошибка: товар " + productName + " не найден в корзине!");
    }

    @AfterMethod
    public void postcondition() {
        app.cart.clearCart();
    }
}
