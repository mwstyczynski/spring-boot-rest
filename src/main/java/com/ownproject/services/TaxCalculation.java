package com.ownproject.services;

import com.ownproject.model.TaxCustomer;
import com.ownproject.model.enums.Threshold;
import org.springframework.stereotype.Component;

import static com.ownproject.model.enums.Threshold.*;

@Component
public class TaxCalculation {

    public Double calculateTax(TaxCustomer taxCustomer, Integer year) {
        Double income = taxCustomer.getIncomeLastYear();
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

    public Threshold establishThreshold(TaxCustomer taxCustomer) {
        Double income = taxCustomer.getIncomeLastYear();
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
