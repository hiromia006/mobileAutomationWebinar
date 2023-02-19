package com.emi.calculator.test.testcases;

import com.emi.calculator.test.basetest.BaseTest;
import com.emi.calculator.test.pages.CalculatorPage;
import com.emi.calculator.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
    CalculatorPage calculatorPage;

    @Test
    public void calculateEmiShouldSucceed() {
        calculatorPage = new HomePage()
                .tapEmiCalculatorBtn()
                .fillAmount(50000)
                .fillInterest(9.5)
                .fillYear(1)
                .fillMonth(6)
                .fillProcessFee(2)
                .tapCalculatorBtn();
        Assert.assertTrue(calculatorPage.hasDetailBtn());

    }

    @Test
    public void resetEmiShouldSucceed() {
        calculatorPage = calculatorPage
                .fillAmount(50000)
                .fillInterest(9.5)
                .fillYear(1)
                .fillMonth(6)
                .fillProcessFee(2)
                .tapResetBtn();

    }

}
