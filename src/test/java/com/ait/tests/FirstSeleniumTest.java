package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {

    WebDriver driver;

    //before-setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app"); //without history
        //driver.navigate().to( "https://ilcarro.web.app"); //with history

  //      driver.navigate().back();
  //      driver.navigate().forward();
  //      driver.navigate().refresh();
        //maximize browser to window;
        driver.manage().window().maximize();

        //wail for all elements on the website to load before staring test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    //test
    @Test
    public void openChromTest(){
        System.out.println("Browser opens!");
    }

    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("h2"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.tagName("a"));
        System.out.println(element2.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementByld(){
        driver.findElements(By.id("city"));
        driver.findElements(By.id("dates"));
    }

    @Test
    public void findElementByClassName(){
        WebElement element = driver.findElement(By.className("header"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.className("logo"));
        System.out.println(elements.size());

        WebElement element1 = driver.findElement(By.className("navigation-link"));
        System.out.println(element1.getText());

        driver.findElements(By.className("fas"));
    }


    //after-tearDown
    @AfterMethod(enabled = false)//отключает работу меетода
    public void tearDown(){
        //driver.quit(); all tabs & close browser
        //driwer.close();//only one tab(if tab only one -> browser)
    }
}
