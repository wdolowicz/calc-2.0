package com.calc_2_0;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @author Witold Dolowicz on 03.01.2021
 */

public class CalculationTest {

    @Test(priority = 1)
    public void mathSequenceTest() {
        String driverPath = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //verify if user has logged in
        driver.findElement(By.xpath("//div[@id='inventory_container']/div/div"));
        driver.quit();
    }

    @Test(priority = 2)
    public void cosPiTest(){
        String driverPath = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("fake_user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("fake_sauce");
        driver.findElement(By.id("login-button")).click();
        //verify if user has not logged in
        driver.findElement(By.xpath("//div[@id='login_button_container']/div/form/h3"));
        driver.quit();
    }

    @Test(priority = 3)
    public void sqrtTest(){

    }

    @Test(priority = 4)
    public void mathHistoryTest(){

    }
}
