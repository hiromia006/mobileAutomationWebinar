package com.emi.calculator.test.testcases;

import com.emi.calculator.test.basetest.BaseTest;
import com.emi.calculator.test.pages.CompareLoanPage;
import com.emi.calculator.test.pages.HomePage;
import org.testng.annotations.Test;

public class CompareLoanTest extends BaseTest {
    CompareLoanPage compareLoanPage;

    @Test
    public void calculateTwoLoanShouldSucceed() {
        compareLoanPage = new HomePage()
                .tapCompareLoanBtn()
                .fillLoanAmount1(50000)
                .fillLoanAmount2(50000)
                .fillLoanInterest1(9)
                .fillLoanInterest2(8)
                .fillLoanPeriod1(6)
                .fillLoanPeriod2(6)
                .tapCalculateBtn();
    }
}
