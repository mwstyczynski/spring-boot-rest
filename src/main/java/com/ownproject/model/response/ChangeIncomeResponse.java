package com.ownproject.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor

public class ChangeIncomeResponse {

    protected final UUID userId;
    protected final String message;

}
