package com.ownproject.services;

import com.ownproject.model.TaxCustomer;
import com.ownproject.services.TaxCalculation;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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

    @DisplayName("First Threshold Calculation")
    @Test
    void firstThreshold() {
        Double tax = taxCalculation.calculateTax(setIncome(2317.97), 2022);
        assertThat(tax).isCloseTo(350.00, Percentage.withPercentage(1.00));
    }

    @DisplayName("Second Threshold Calculation")
    @Test
    void secondThreshold() {
        Double tax = taxCalculation.calculateTax(setIncome(23170.97), 2022);
        assertThat(tax).isCloseTo(5790.00, Percentage.withPercentage(1.00));
    }

    @DisplayName("Third Threshold Calculation")
    @Test
    void thirdThreshold() {
        Double tax = taxCalculation.calculateTax(setIncome(231700.97), 2022);
        assertThat(tax).isCloseTo(74150.00, Percentage.withPercentage(1.00));
    }

    private TaxCustomer setIncome(Double income) {
        return new TaxCustomer("Adam", "Whatever", LocalDate.of(1990, Month.DECEMBER, 16), "Japan", income);
    }

}