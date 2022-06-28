package com.ownproject.services;

import com.ownproject.model.Customer;
import com.ownproject.model.request.ChangeIncomeRequest;
import com.ownproject.model.request.CreateCustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService {

    Map<UUID, Customer> mapOfCustomers = new HashMap<>();

    public UUID createCustomer(CreateCustomerRequest request) {
        UUID id = UUID.randomUUID();
        mapOfCustomers.put(id, request.getCustomer());
        log.info("Tax calculation account was created by:" + request.getActor());
        return id;
    }

    public Customer getCustomer(UUID id) {
        return mapOfCustomers.get(id);
    }

    public void changeIncome(UUID id, ChangeIncomeRequest request) {
        Customer customer = mapOfCustomers.get(id);
        customer.setIncomeLastYear(request.getNewIncomeValue());
        log.info("Yearly income for customer: " + id + " was changed due to: " + request.getReason());
    }

}
