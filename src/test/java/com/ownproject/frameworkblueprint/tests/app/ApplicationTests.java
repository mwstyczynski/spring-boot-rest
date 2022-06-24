package com.ownproject.frameworkblueprint.tests.app;

import com.ownproject.TaxCalculation;
import com.ownproject.model.User;
import org.assertj.core.data.Percentage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


public class ApplicationTests {

    @Autowired
    TaxCalculation taxCalculation;

    @Test
    public void firstTest() {
        Double tax = taxCalculation.calculateTax(setIncome(2317.97), 2022);
        assertThat(tax).isCloseTo(350.00, Percentage.withPercentage(5.00));
    }

    private User setIncome(Double income) {
        return new User("Adam", "Whatever", LocalDate.of(1990, Month.DECEMBER, 16), "Japan", income);
    }


}
