package com.ownproject.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeIncomeRequest {

    private Double newIncomeValue;
    private String reason;

}
