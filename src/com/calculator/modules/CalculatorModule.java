package com.calculator.modules;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Witold Dołowicz on 03.01.2021
 */


public final class CalculatorModule {


    @FindBy(how = How.ID, using = "input")
    private WebElement inputElement;

    @FindBy(how = How.ID, using = "BtnCalc")
    private WebElement equalsButton;

    @FindBy(how = How.ID, using = "trigorad")
    private WebElement radRadioButton;

    @FindBy(how = How.ID, using = "BtnClear")
    private WebElement clearButton;

    @FindBy(xpath = "//div[@id='hist']/button[2]/span")
    private WebElement historyDropdown;

    @FindBy(xpath = "//div[@id='histframe']/ul/li")
    public WebElement historyContent;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[1]/p[2]")
    private WebElement firstEquation;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[2]/p[2]")
    private WebElement secondEquation;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[3]/p[2]")
    private WebElement thirdEquation;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[1]/p[1]")
    private WebElement firstResult;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[2]/p[1]")
    private WebElement secondResult;

    @FindBy(xpath = "//div[@id='histframe']/ul/li[3]/p[1]")
    private WebElement thirdResult;

    @Step
    public void clickEquals() {
        equalsButton.click();
    }

    @Step
    public void clickRadRadio(){
        radRadioButton.click();
    }

    @Step
    public void clickClear() {
        clearButton.click();
    }

    @Step
    public void inputText(String value) {
        inputElement.sendKeys(value);
    }

    @Step
    public void clickHistoryDropdown() {
        historyDropdown.click();
    }

    @Step
    public WebElement getHistoryContent() {
        return historyContent;
    }

    @Step
    public String inputValue() {
        return inputElement.getText();
    }

    @Step
    public boolean firstEquationVisible() {
        return firstEquation.isDisplayed();
    }

    @Step
    public boolean secondEquationVisible() {
        return secondEquation.isDisplayed();
    }

    @Step
    public boolean thirdEquationVisible() {
        return thirdEquation.isDisplayed();
    }

    @Step
    public boolean firstResultVisible() {
        return firstResult.isDisplayed();
    }

    @Step
    public boolean secondResultVisible() {
        return secondResult.isDisplayed();
    }

    @Step
    public boolean thirdResultVisible() {
        return thirdResult.isDisplayed();
    }
}