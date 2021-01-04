package com.calculator.test;

import com.calculator.modules.CalculatorModule;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.apache.commons.exec.util.StringUtils;
import org.assertj.core.api.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Witold Dolowicz on 16.12.2020
 */

public class calculationTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private CalculatorModule calculatorModule;
    private List list;

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        String driverPath = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        calculatorModule = PageFactory.initElements(driver, CalculatorModule.class);
        driver.get("https://web2.0calc.com/?action=checkadblock");
    }

    @Test(priority = 1)
    public void mathSequenceTest() {
        calculatorModule.inputText("35*999+(100/4)");
        calculatorModule.clickEquals();
        assertThat(calculatorModule.inputValue().equals("34990"));
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
        String[] expected = {"= 9", "sqrt(81)", "= -1", "cos(pi)", "= 34990", "35*999+(100/4)"};
        List<WebElement> historyList = driver.findElements(By.xpath("//div[@id='histframe']/ul/li"));
        
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}