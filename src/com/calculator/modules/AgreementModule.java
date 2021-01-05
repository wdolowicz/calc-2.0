package com.calculator.modules;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgreementModule {

    public AgreementModule(WebDriver xyz) {
        driver = xyz;
    }
    private WebDriver driver;

//    @FindBy(xpath = "//button[@class=\"sc-ifAKCX ivrbXK\"]")
//    public WebElement agreeButton;

//    private WebElement agreeButton() {
//        return driver.findElement(By.xpath("//button[@class=\"sc-ifAKCX ivrbXK\"]"));
//    }

    @Step
    public void clickAgreeButton() throws InterruptedException {
//        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
//        Thread.sleep(2000);
//        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"sc-ifAKCX ivrbXK\"]")));
//        wait.until(ExpectedConditions.visibilityOf(agreeButton()));
        driver.findElement(By.xpath("//button[@class=\"sc-ifAKCX ivrbXK\"]")).click();
//        agreeButton().click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[@class=\"sc-ifAKCX ivrbXK\"]"), 0));
        }
}
