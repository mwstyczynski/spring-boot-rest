package com.ownproject.services;

import com.ownproject.model.TaxCustomer;
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

    Map<UUID, TaxCustomer> mapOfCustomers = new HashMap<>();

    public UUID createCustomer(CreateCustomerRequest request) {
        UUID id = UUID.randomUUID();
        mapOfCustomers.put(id, request.getTaxCustomer());
        log.info("Tax calculation account was created by: " + request.getActor() + " and has id: " + id);
        return id;
    }

    public TaxCustomer getTaxCustomer(UUID id) {
        return mapOfCustomers.get(id);
    }

    public void changeIncome(UUID id, ChangeIncomeRequest request) {
        TaxCustomer taxCustomer = mapOfCustomers.get(id);
        taxCustomer.setIncomeLastYear(request.getNewIncomeValue());
        log.info("Yearly income for customer: " + id + " was changed due to: " + request.getReason());
    }

}
