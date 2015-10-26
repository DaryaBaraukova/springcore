package com.epam.springcore.dao.api;

import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;

import java.util.List;

/**
 * IUserDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IUserDao {

    void register(User user);

    void remove(String id);

    User getById(String id);

    User getUsersByName(String name);

    User getUserByEmail(String email);

    List<Ticket> getBookedTickets(String userId);
}
