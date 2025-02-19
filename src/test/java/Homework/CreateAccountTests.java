package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewUserPositiveTest() {
        //click on register link
        click(By.cssSelector("[href='/register']"));
        //enter first name
        type(By.name("FirstName"), "Adam");
        //enter last name
        type(By.name("LastName"), "Muth");
        //enter email
        type(By.name("Email"), "muth@dgf.com");
        //enter password
        type(By.name("Password"), "QwEr!2#4");
        //enter confirm password
        type(By.name("ConfirmPassword"), "QwEr!2#4");
        //click on Registration button
        click(By.name("register-button"));


    }
}

