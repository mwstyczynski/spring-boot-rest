package com.ownproject.services;

import com.ownproject.model.User;
import com.ownproject.model.request.ChangeIncomeRequest;
import com.ownproject.model.request.CreateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    Map<UUID, User> mapOfUsers = new HashMap<>();

    public UUID createUser(CreateUserRequest request) {
        UUID id = UUID.randomUUID();
        mapOfUsers.put(id, request.getUser());
        log.info("Tax calculation account was created by:" + request.getActor());
        return id;
    }

    public User getUser(UUID id) {
        return mapOfUsers.get(id);
    }

    public void changeIncome(UUID id, ChangeIncomeRequest request) {
        User user = mapOfUsers.get(id);
        user.setIncomeLastYear(request.getNewIncomeValue());
        log.info("Yearly income for user: " + id + " was changed due to: " + request.getReason());
    }

}
