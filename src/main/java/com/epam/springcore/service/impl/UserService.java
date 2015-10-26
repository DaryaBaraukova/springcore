package com.epam.springcore.service.impl;

import com.epam.springcore.dao.api.IUserDao;
import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;
import com.epam.springcore.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of {@link IUserService} for managing registered users.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
@Service("userService")
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public void register(User user) {
        if (null != user) {
            userDao.register(user);
        } else {
            System.out.println("User should not be null");
        }
    }

    @Override
    public void remove(User user) {
        if (null != user && null != user.getId()) {
            userDao.remove(user.getId());
        } else {
            System.out.println("User/user id should not be null");
        }
    }

    @Override
    public User getById(String id) {
        return !StringUtils.isEmpty(id) ? userDao.getById(id) : null;
    }

    @Override
    public User getUserByEmail(String email) {
        return !StringUtils.isEmpty(email) ? userDao.getUserByEmail(email) : null;
    }

    @Override
    public User getUsersByName(String name) {
        return !StringUtils.isEmpty(name) ? userDao.getUsersByName(name) : null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        return null != user && null != user.getId()
            ? userDao.getBookedTickets(user.getId())
            : Collections.<Ticket>emptyList();
    }
}
