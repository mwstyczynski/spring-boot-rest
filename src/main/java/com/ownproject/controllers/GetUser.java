package com.ownproject.controllers;

import com.ownproject.model.User;
import com.ownproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@ResponseStatus(OK)
public class GetUser {

    @Autowired
    UserService userService;

    @GetMapping(path = "/user", params = "id", produces = APPLICATION_JSON_VALUE)
    @ResponseBody()
    public User getUser(@RequestParam UUID id) {
        return userService.getUser(id);
    }
}
