package com.emi.calculator.test.pages;

import com.emi.calculator.test.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    @FindBy(id = "btnStart")
    WebElement btnStart;

    @FindBy(id = "btnCompare")
    WebElement compareLoanBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage tapEmiCalculatorBtn() {
        btnStart.isDisplayed();
        btnStart.click();
        return new CalculatorPage();
    }

    public CompareLoanPage tapCompareLoanBtn() {
        compareLoanBtn.isDisplayed();
        compareLoanBtn.click();
        return new CompareLoanPage();
    }
}
