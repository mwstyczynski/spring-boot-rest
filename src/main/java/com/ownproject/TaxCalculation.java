package com.ownproject;

import com.ownproject.model.Customer;
import com.ownproject.model.enums.Threshold;
import org.springframework.stereotype.Component;

import static com.ownproject.model.enums.Threshold.FIRST;
import static com.ownproject.model.enums.Threshold.SECOND;
import static com.ownproject.model.enums.Threshold.THIRD;
import static com.ownproject.model.enums.Threshold.UNDEFINED;

@Component
public class TaxCalculation {

    public Double calculateTax(Customer customer, Integer year) {
        Double income = customer.getIncomeLastYear();
        double tax = 0.00;

        if (income <= 10000.00) {
            tax = income * 0.15;
        } else if (income > 10000.00 && income <= 100000.00) {
            tax = income * 0.25;
        } else if (income > 100000.00) {
            tax = income * 0.32;
        }

        return tax;
    }

    public Threshold establishThreshold(Customer customer) {
        Double income = customer.getIncomeLastYear();
        Threshold threshold = UNDEFINED;

        if (income <= 10000.00) {
            threshold = FIRST;
        } else if (income > 10000.00 && income <= 100000.00) {
            threshold = SECOND;
        } else if (income > 100000.00) {
            threshold = THIRD;
        }

        return threshold;
    }


}
