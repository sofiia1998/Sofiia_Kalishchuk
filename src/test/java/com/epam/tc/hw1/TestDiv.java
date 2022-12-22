package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.assertj.core.data.Percentage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestDiv {
    private static final double PRECISION = 0.0000001;

    @DataProvider
    public static Object[][] longData() {
        return new Object[][]{
                {20, 10, 2},
                {5, 5, 1},
                {100, 25, 4}
        };
    }

    @DataProvider
    public static Object[][] doubleData() {
        return new Object[][]{
                {5.7, 2, 2.85},
                {3.3, 3, 1.1},
                {5.6, 0.8, 7}
        };
    }

    @Test(dataProvider = "longData")
    public void divTestLong(long first, long second, long third) {

        Calculator calculator = new Calculator();
        long result = calculator.div(first, second);

        assertThat(result).as("This test is failed").isEqualTo(third);
    }

    @Test(dataProvider = "doubleData")
    public void divTestDouble(double first, double second, double third) {

        Calculator calculator = new Calculator();
        double result = calculator.div(first, second);

        assertThat(result).as("This test is failed")
                .isCloseTo(third, Percentage.withPercentage(PRECISION));
    }
}
