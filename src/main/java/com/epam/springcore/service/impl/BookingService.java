package com.epam.springcore.service.impl;

import com.epam.springcore.dao.api.IBookingDao;
import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;
import com.epam.springcore.service.api.IBookingService;
import com.epam.springcore.service.api.IDiscountService;
import com.epam.springcore.service.api.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link IBookingService}.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
@Service("bookingService")
public class BookingService implements IBookingService {

    @Autowired
    private IBookingDao bookingDao;

    @Autowired
    private IEventService eventService;

    @Autowired
    private IDiscountService discountService;

    private Map<User, List<Ticket>> bookedTickets = new HashMap<>();

    @Override
    public double getTicketPrice(Event event, Date date, Date time, int seats, User user) {
        double price = 0;
        if (null != eventService.getByName(event.getName())) {
            double dicount = discountService.getDiscount(user, event, date);
            price = event.getPrice() - event.getPrice()*dicount;
        }
        return price;
    }

    @Override
    public void bookTicket(User user, Ticket ticket) {
        List<Ticket> userTickets = user.getTickets();
        userTickets.add(ticket);
        bookedTickets.put(user, bookedTickets.put(user, userTickets));
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        return Collections.emptyList();
    }
}
