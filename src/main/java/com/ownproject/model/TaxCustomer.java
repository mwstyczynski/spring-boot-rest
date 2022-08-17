package com.ownproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxCustomer {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryOfResidence;
    private Double incomeLastYear;

}
