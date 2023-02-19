package com.emi.calculator.test.pages;

import com.emi.calculator.test.basetest.BaseTest;
import com.emi.calculator.test.util.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends BaseTest {
    @FindBy(id = "etLoanAmount")
    WebElement etLoanAmount;

    @FindBy(id = "etInterest")
    WebElement etInterest;

    @FindBy(id = "etYears")
    WebElement etYears;

    @FindBy(id = "etMonths")
    WebElement etMonths;

    @FindBy(id = "etFee")
    WebElement etFee;

    @FindBy(id = "btnCalculate")
    WebElement btnCalculate;

    @FindBy(id = "btnReset")
    WebElement btnReset;

    @FindBy(id = "btnDetail")
    WebElement btnDetail;

    public CalculatorPage() {
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage fillAmount(int amount) {
        etLoanAmount.isDisplayed();
        etLoanAmount.clear();
        etLoanAmount.sendKeys(String.valueOf(amount));
        return this;
    }

    public CalculatorPage fillInterest(double interest) {
        etInterest.isDisplayed();
        etInterest.clear();
        etInterest.sendKeys(String.valueOf(interest));
        return this;
    }

    public CalculatorPage fillYear(int year) {
        etYears.isDisplayed();
        etYears.clear();
        etYears.sendKeys(String.valueOf(year));
        return this;
    }

    public CalculatorPage fillMonth(int months) {
        etMonths.isDisplayed();
        etMonths.clear();
        etMonths.sendKeys(String.valueOf(months));
        return this;
    }

    public CalculatorPage fillProcessFee(int fee) {
        etFee.isDisplayed();
        etFee.clear();
        etFee.sendKeys(String.valueOf(fee));
        return this;
    }

    public CalculatorPage tapCalculatorBtn() {
        btnCalculate.isDisplayed();
        btnCalculate.click();
        General.waitForDomStable();
        return this;
    }

    public CalculatorPage tapResetBtn() {
        btnReset.isDisplayed();
        btnReset.click();
        return this;
    }

    public boolean hasDetailBtn() {
        return btnDetail.isDisplayed();
    }

}
