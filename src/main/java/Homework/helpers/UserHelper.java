package Homework.helpers;

import Homework.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(By.cssSelector(".ico-login"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));
    }

    public void register(String firstName, String lastName, String email, String password) {
        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"), firstName);
        type(By.name("LastName"), lastName);
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);
        click(By.name("register-button"));
    }

    public void openRegistrationPage() {
        click(By.cssSelector(".register-button")); // Правильный селектор кнопки "Register"
    }

    public void fillRegistrationForm(Contact contact) {
        type(By.id("FirstName"), contact.getName());
        type(By.id("LastName"), contact.getLastName());
        type(By.id("Email"), contact.getEmail());
        type(By.id("Password"), contact.getPassword());
        type(By.id("ConfirmPassword"), contact.getPassword());
    }
    public void openRegistrationForm() {
        click(By.cssSelector("a.ico-register"));  // Проверь селектор!
    }

    public void submitRegistration() {
        click(By.id("register-button")); // Селектор кнопки "Submit" на странице регистрации
    }

    public boolean isUserRegistered(String email) {
        return isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }
    public boolean isRegisteredSuccessfully() {
        return isElementPresent(By.cssSelector("div.result")); // Проверь селектор!
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("a.ico-logout"));  // Если кнопка logout видна, значит, пользователь залогинен
    }

    public void logout() {
        if (isLoggedIn()) {
            click(By.cssSelector("a.ico-logout"));
        }
    }

}