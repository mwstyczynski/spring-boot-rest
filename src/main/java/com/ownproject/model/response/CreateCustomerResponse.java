package com.ownproject.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor

public class CreateCustomerResponse {

    protected final UUID customerId;
    protected final String message;

}
