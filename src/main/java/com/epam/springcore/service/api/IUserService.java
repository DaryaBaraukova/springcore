package com.epam.springcore.service.api;

import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;

import java.util.List;

/**
 * Interface represented service for managing registered users.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IUserService {

    void register(User user);

    void remove(User user);

    User getById(String id);

    User getUsersByName(String name);

    User getUserByEmail(String email);

    //TODO analyze params and return value
    List<Ticket> getBookedTickets(User user);
}
