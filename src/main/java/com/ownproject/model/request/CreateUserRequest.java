package com.ownproject.model.request;

import com.ownproject.model.enums.Actor;
import com.ownproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private Actor actor;
    private User user;

}
