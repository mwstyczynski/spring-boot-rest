package com.ownproject.controllers;

import com.ownproject.model.request.ChangeIncomeRequest;
import com.ownproject.model.response.ChangeIncomeResponse;
import com.ownproject.services.UserService;
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
    UserService userService;

    @PutMapping(path = "/user", params = "id", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ChangeIncomeResponse changeIncome(@RequestParam UUID id, @RequestBody ChangeIncomeRequest request) {
        userService.changeIncome(id, request);
        return ChangeIncomeResponse.builder()
                .userId(id)
                .message("Customer's income is now set to: " + request.getNewIncomeValue())
                .build();
    }

}
