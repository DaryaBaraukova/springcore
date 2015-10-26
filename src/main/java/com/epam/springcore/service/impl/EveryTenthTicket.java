package com.epam.springcore.service.impl;

import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * EveryTenthTicket
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/28/15
 *
 * @author Darya Baraukova
 */
@Component("everyTenthTicket")
public class EveryTenthTicket extends DiscountStrategy {

    @Override
    protected double getDiscount(User user, Date date) {
        double discount = 0;
        List<Ticket> purchesedTickets = user.getTickets();
        if (null != user.getTickets() && !purchesedTickets.isEmpty() && 0 == purchesedTickets.size()%10 ) {
            discount = 0.5;
            System.out.println("User ' " + user.getName() + "' has got 50% discount by Every 10th Tiket Strategy");
        }
        return discount;
    }
}
