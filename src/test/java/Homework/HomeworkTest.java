package Homework;

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
    @Test
    public void findElementByCssSelector() {
        driver.findElement(By.cssSelector("h3"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector(".header"));
        driver.findElement(By.cssSelector("[type='text/javascript']"));
        driver.findElement(By.cssSelector("[href='/books']"));
        driver.findElement(By.cssSelector("[href*='/computers']"));

        driver.findElement(By.cssSelector("[href*='ico']"));

        driver.findElement(By.cssSelector("[href^='/desktops']"));
        driver.findElement(By.cssSelector("[href$='/register']"));

        driver.findElement(By.cssSelector(".header-logo img"));

        driver.findElement(By.cssSelector(".top-menu-triangle:nth-child(2)"));
        driver.findElement(By.cssSelector(".inactive:nth-child(3)"));
        driver.findElement(By.cssSelector(".active:nth-child(1)"));

    }

    @Test
    public void findElementByXpath() {

        driver.findElement(By.xpath("//h3"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));
        driver.findElement(By.xpath("//*[@class='header']"));
        driver.findElement(By.xpath("//*[@type='text/javascript']"));
        driver.findElement(By.xpath("//*[@href='/books']"));
        driver.findElement(By.xpath("//*[contains(.,'Sign up for')]"));
        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter:']"));
        driver.findElement(By.xpath("//*[.='Sign up for our newsletter:']"));
        driver.findElement(By.xpath("//*[contains(@href,'ico')]"));
        driver.findElement(By.xpath("//*[starts-with(@href,'/desktops')]"));

        driver.findElement(By.xpath("//h3/.."));
        driver.findElement(By.xpath("//h3/parent::*"));
        driver.findElement(By.xpath("//h3/parent::div"));

        driver.findElement(By.xpath("//h3/ancestor::*"));
        driver.findElement(By.xpath("//h3/ancestor::div"));
        driver.findElement(By.xpath("//h3/ancestor::div[2]"));



    }
    @AfterMethod(enabled = false)
    public void tearDown(){

    }


}