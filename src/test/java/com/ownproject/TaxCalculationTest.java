package com.ownproject;

import com.ownproject.model.Customer;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaxCalculationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    TaxCalculation taxCalculation;

    // Spring Boot was added only for Educational purposes and to develop POST and GET endpoint in the future
    // Without that it could have as well been set as new instance of TaxCalculation
    // TaxCalculation taxCalculation = new TaxCalculation();

    @DisplayName("Single test successful")
    @Test
    void firstTest() {
        Double tax = taxCalculation.calculateTax(setIncome(2317.97), 2022);
        assertThat(tax).isCloseTo(350.00, Percentage.withPercentage(5.00));
    }

    private Customer setIncome(Double income) {
        return new Customer("Adam", "Whatever", LocalDate.of(1990, Month.DECEMBER, 16), "Japan", income);
    }

}