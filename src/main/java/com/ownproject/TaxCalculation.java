package com.ownproject;

import com.ownproject.model.User;

public class TaxCalculation {


    public Double calculateTax(User user, Integer year) {
        Double income = user.getIncomeLastYear();
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

}
