package com.calculator.test;

import com.calculator.modules.AgreementModule;
import com.calculator.modules.CalculatorModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Witold Dolowicz on 16.12.2020
 */

public class calculationTest {

    public WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private CalculatorModule calculatorModule;
    String[] expected = {"9", "sqrt(81)", "-1", "cos(pi)", "34990", "35*999+(100/4)"};

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String driverPath = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        calculatorModule = PageFactory.initElements(driver, CalculatorModule.class);
        driver.get("https://web2.0calc.com/");
        AgreementModule agree = new AgreementModule(driver);
        agree.clickAgreeButton();
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(agree.agreeButton));
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@class=\"sc-ifAKCX ivrbXK\"]")).click();
//        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void mathSequenceTest() throws InterruptedException {
        calculatorModule.inputText(expected[5]);
//        calculatorModule.inputText("35*999+(100/4)");
        calculatorModule.clickEquals();
        assertThat(calculatorModule.inputValue().equals(expected[4]));
//        assertThat(calculatorModule.inputValue().equals("34990"));
        calculatorModule.clickClear();
    }

    @Test(priority = 2)
    public void cosPiTest(){
        calculatorModule.inputText("cos(pi)");
        calculatorModule.clickRadRadio();
        calculatorModule.clickEquals();
        assertThat(calculatorModule.inputValue().equals("-1"));
        calculatorModule.clickClear();
    }

    @Test(priority = 3)
    public void sqrtTest(){
        calculatorModule.inputText("sqrt(81)");
        calculatorModule.clickEquals();
        assertThat(calculatorModule.inputValue().equals("9"));
        calculatorModule.clickClear();
    }

    @Test(priority = 4)
    public void mathHistoryTest() {
        calculatorModule.clickHistoryDropdown();
//        List<WebElement> historyList = driver.findElements(By.xpath("//div[@id='histframe']/ul/li"));
        assertThat(driver.findElement(By.xpath("//div[@id='histframe']/ul/li/p[@title= '" + expected[0] + "']")).isDisplayed());
        assertThat(driver.findElement(By.xpath("//div[@id='histframe']/ul/li/p[@data-inp= '" + expected[1] + "']")).isDisplayed());
        assertThat(driver.findElement(By.xpath("//div[@id='histframe']/ul/li[p[@title=\"10\"] and p[@data-inp=\"5+5\"]]")).isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}