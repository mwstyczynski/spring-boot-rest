package com.ownproject.controllers;

import com.ownproject.TaxCalculation;
import com.ownproject.model.Customer;
import com.ownproject.model.enums.Threshold;
import com.ownproject.model.response.GetCustomerResponse;
import com.ownproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseStatus(OK)
public class GetCustomer {

    @Autowired
    CustomerService customerService;

    @Autowired
    TaxCalculation taxCalculation;

    @GetMapping(path = "/user", params = "id", produces = APPLICATION_JSON_VALUE)
    @ResponseBody()
    public GetCustomerResponse getCustomer(@RequestParam UUID id) {
        Customer customer = customerService.getCustomer(id);
        Double tax = taxCalculation.calculateTax(customer, 2022);
        Threshold threshold = taxCalculation.establishThreshold(customer);

        return GetCustomerResponse.builder()
                .customer(customer)
                .calculatedTax(tax)
                .establishedThreshold(threshold)
                .build();

    }
}
