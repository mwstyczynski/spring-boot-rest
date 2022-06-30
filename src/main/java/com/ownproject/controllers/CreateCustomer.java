package com.ownproject.controllers;

import com.ownproject.model.request.CreateCustomerRequest;
import com.ownproject.model.response.CreateCustomerResponse;
import com.ownproject.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@ResponseStatus(CREATED)
public class CreateCustomer {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        UUID id = customerService.createCustomer(request);
        return new CreateCustomerResponse(id, "New customer created");
        // @TODO how to sent an Object as part of log message
        // log.info("Following request was sent: ", request);
    }

}
