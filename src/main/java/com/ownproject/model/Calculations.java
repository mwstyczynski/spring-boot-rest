package com.ownproject.model;

import com.ownproject.model.enums.Threshold;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculations {

    private Double calculatedTax;
    private Threshold threshold;

}
