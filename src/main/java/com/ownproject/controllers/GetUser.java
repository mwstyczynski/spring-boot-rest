package com.ownproject.controllers;

import com.ownproject.model.User;
import com.ownproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@ResponseStatus(OK)
public class GetUser {

    @Autowired
    UserService userService;

    @GetMapping(path = "user", params = "id")
    private User getUser(UUID id) {
        return userService.getUser(id);
    }
}
