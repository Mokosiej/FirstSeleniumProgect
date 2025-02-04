package com.ait.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeworkTest {

    WebDriver driver;


@BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}


@Test
public void openChromTest(){
    System.out.println("Browser opens!");
}

@Test
public void findElementsByTagName() {
    WebElement element = driver.findElement(By.tagName("h2"));
    System.out.println(element.getText());

    WebElement element1 = driver.findElement(By.tagName("h3"));
    System.out.println(element1.getText());

    WebElement element2 = driver.findElement(By.tagName("a"));
    System.out.println(element2.getText());

    List<WebElement> elements = driver.findElements(By.tagName("a"));
    System.out.println(elements.size());

}

@Test
public void findElementByld(){
    driver.findElements(By.id("bar-notification"));
    driver.findElements(By.id("dialog-notifications-success"));
}

@Test
public void findElementByClassName(){
    WebElement element = driver.findElement(By.className("header"));
    System.out.println(element.getText());

    List<WebElement> elements = driver.findElements(By.className("header-logo"));
    System.out.println(elements.size());

    WebElement element1 = driver.findElement(By.className("header-links-wrapper"));
    System.out.println(element1.getText());

    driver.findElements(By.className("header-links"));
}



@AfterMethod(enabled = false)
    public void tearDown(){

    }


}