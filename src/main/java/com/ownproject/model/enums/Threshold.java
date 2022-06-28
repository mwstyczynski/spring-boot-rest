package com.ownproject.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Threshold {

    @JsonProperty("Taxing threshold not yet defined")
    UNDEFINED,

    @JsonProperty("First taxing threshold, below 10k $")
    FIRST,

    @JsonProperty("Second taxing threshold, above 10k $, below 100k $")
    SECOND,

    @JsonProperty("Third taxing threshold, above 100k $")
    THIRD,

}
