package com.ownproject.controllers;

import com.ownproject.services.TaxCalculation;
import com.ownproject.model.enums.Threshold;
import com.ownproject.model.request.ChangeIncomeRequest;
import com.ownproject.model.response.ChangeIncomeResponse;
import com.ownproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseStatus(OK)
public class ChangeIncome {

    @Autowired
    CustomerService customerService;

    @Autowired
    TaxCalculation taxCalculation;

    @PutMapping(path = "/user", params = "id", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ChangeIncomeResponse changeIncome(@RequestParam UUID id, @RequestBody ChangeIncomeRequest request) {
        customerService.changeIncome(id, request);
        Double tax = taxCalculation.calculateTax(customerService.getCustomer(id), 2022);
        Threshold threshold = taxCalculation.establishThreshold(customerService.getCustomer(id));

        return ChangeIncomeResponse.builder()
                .customerId(id)
                .message("Customer's income is now set to: " + request.getNewIncomeValue() + "$ by " + request.getActor())
                .updatedTaxCalculation(tax)
                .updatedThreshold(threshold)
                .build();
    }

}
