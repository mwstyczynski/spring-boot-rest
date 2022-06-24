package com.ownproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

public class User {

    protected final String firstName;
    protected final String lastName;
    protected final LocalDate dateOfBirth;
    protected final String countryOfResidence;
    protected final Double incomeLastYear;

}
