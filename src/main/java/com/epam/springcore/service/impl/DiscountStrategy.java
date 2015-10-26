package com.epam.springcore.service.impl;

import com.epam.springcore.domain.User;

import java.util.Date;

/**
 * DiscountStrategy
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/28/15
 *
 * @author Darya Baraukova
 */
public abstract class DiscountStrategy {

    protected abstract double getDiscount(User user, Date date);
}
