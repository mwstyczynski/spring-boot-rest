package com.ownproject.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Actor {

    accountant,
    owner,
    @JsonProperty("tax reporter")
    taxReporter

}
