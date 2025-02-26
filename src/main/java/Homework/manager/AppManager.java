package Homework.manager;

import Homework.helpers.CartHelper;
import Homework.helpers.NavigationHelper;
import Homework.helpers.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AppManager {
    WebDriver driver;
    public UserHelper user;
    public CartHelper cart;
    public NavigationHelper navigation;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com");

        user = new UserHelper(driver);
        cart = new CartHelper(driver);
        navigation = new NavigationHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
}
