package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.api.IUserDao;
import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/22/15
 *
 * @author Darya Baraukova
 */
@Repository("userDao")
public class UserDao implements IUserDao {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void register(User user) {
        if (null != user.getId() && !users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            System.out.println("User was successfully registrated: " + user);
        } else {
            System.out.println("User id should not be null");
        }
    }

    @Override
    public void remove(String id) {
        users.remove(id);
    }

    @Override
    public User getById(String id) {
        return users.get(id);
    }

    @Override
    public User getUserByEmail(String email) {
        for (Map.Entry<String, User> user: users.entrySet()) {
            if (email.equals(user.getValue().getEmail())) {
                return user.getValue();
            }
        }
        return null;
    }

    @Override
    public User getUsersByName(String name) {
        for (Map.Entry<String, User> user: users.entrySet()) {
            if (name.equals(user.getValue().getName())) {
                return user.getValue();
            }
        }
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(String userId) {
        List<Ticket> tickets = Collections.emptyList();
        User user = users.get(userId);
        if (null != user) {
            tickets = user.getTickets();
        }
        return tickets;
    }
}
