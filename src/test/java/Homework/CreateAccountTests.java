package Homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewUserPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "muthA" + i + "@dg.com";

        app.getUserHelper().register("Adam", "Muth", email, "QwEr!2#5");

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.cssSelector(".ico-logout")),
                "Ошибка: регистрация не удалась, кнопка 'Logout' не найдена.");
    }
}
