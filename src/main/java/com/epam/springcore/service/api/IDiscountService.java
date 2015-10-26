package com.epam.springcore.service.api;

import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.User;

import java.util.Date;

/**
 * Interface represented service for counting different discounts for purchased tickets.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IDiscountService {

    double getDiscount(User user, Event event, Date date);

}
