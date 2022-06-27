package com.ownproject.services;

import com.ownproject.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {

    Map<UUID, User> mapOfUsers = new HashMap<>();

    public UUID createUser(User user) {
        UUID id = UUID.randomUUID();
        mapOfUsers.put(id, user);
        return id;
    }

    public User getUser(UUID id) {
        return mapOfUsers.get(id);
    }

}
