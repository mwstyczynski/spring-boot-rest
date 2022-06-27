package com.ownproject.controllers;

import com.ownproject.model.CreateUserResponse;
import com.ownproject.model.User;
import com.ownproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseStatus(CREATED)
public class CreateUser {

    @Autowired
    UserService userService;

    @PostMapping(path = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CreateUserResponse createUser(@RequestBody User user) {
        UUID id = userService.createUser(user);
        return new CreateUserResponse(id, "New customer created");
    }

}
