package com.ownproject.model.response;

import com.ownproject.model.Customer;
import com.ownproject.model.enums.Threshold;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class GetCustomerResponse {

    protected final Customer customer;
    protected final Double calculatedTax;
    protected final Threshold establishedThreshold;

}
