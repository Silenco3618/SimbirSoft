package org.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }


    @Test
    void testSuccessBuy() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector("[class='shopping_cart_container']")).click();
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Наталья");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Иванова");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        driver.findElement(By.xpath("//*[@id='finish']")).click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Swag Labs"));
        String expected = "Thank you for your order!";
        String actual = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void NonExistentLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@data-test='password']")).sendKeys("test");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.cssSelector("[data-test='error']")).getText().trim();
        assertEquals(expected, actual);
    }

}