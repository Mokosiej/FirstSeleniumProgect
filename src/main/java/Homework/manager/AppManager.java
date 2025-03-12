package Homework.manager;

import Homework.helpers.CartHelper;
import Homework.helpers.NavigationHelper;
import Homework.helpers.UserHelper;
import Homework.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AppManager {

    String browser;
    WebDriver driver;
    public static SoftAssert softAssert = new SoftAssert();
    Logger logger = LoggerFactory.getLogger(AppManager.class);

    UserHelper user;
    CartHelper cart;
    NavigationHelper navigation;

    public AppManager(String browser) {
        this.browser=browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Tests start in Chrome browser");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Tests start in Firefox browser");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Tests start in Edge browser");
        }


        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();

        user = new UserHelper(driver);
        cart = new CartHelper(driver);
        navigation = new NavigationHelper(driver);
    }

    public UserHelper getUserHelper() {
        return user;
    }

    public CartHelper getCartHelper() {
        return cart;
    }

    public NavigationHelper getNavigationHelper() {
        return navigation;
    }

    public void stop() {
        driver.quit();
    }


}