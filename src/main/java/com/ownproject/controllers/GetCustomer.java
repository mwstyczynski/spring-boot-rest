package com.ownproject.controllers;

import com.ownproject.model.TaxCustomer;
import com.ownproject.model.enums.Threshold;
import com.ownproject.model.response.GetCustomerResponse;
import com.ownproject.services.CustomerService;
import com.ownproject.services.TaxCalculation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseStatus(OK)
@RequiredArgsConstructor
public class GetCustomer {

    private final CustomerService customerService;
    private final TaxCalculation taxCalculation;

    @GetMapping(path = "/user", params = "id", produces = APPLICATION_JSON_VALUE)
    public GetCustomerResponse getCustomer(@RequestParam UUID id) {
        TaxCustomer taxCustomer = customerService.getTaxCustomer(id);
        Double tax = taxCalculation.calculateTax(taxCustomer, 2022);
        Threshold threshold = taxCalculation.establishThreshold(taxCustomer);

        return GetCustomerResponse.builder()
                .taxCustomer(taxCustomer)
                .calculatedTax(tax)
                .establishedThreshold(threshold)
                .build();
    }
}
