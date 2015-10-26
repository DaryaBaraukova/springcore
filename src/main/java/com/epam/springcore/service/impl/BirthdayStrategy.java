package com.epam.springcore.service.impl;

import com.epam.springcore.domain.User;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BirthdayStrategy
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/28/15
 *
 * @author Darya Baraukova
 */
@Component("birthdayStrategy")
public class BirthdayStrategy extends DiscountStrategy {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected double getDiscount(User user, Date date) {
        double discount = 0;
        if (dateFormat.format(date).equals(user.getBirthDay())) {
            discount = 0.05;
            System.out.println("User '" + user.getName() + "' had got 5% discount by Birthday Strategy");
        }
        return discount;
    }
}
