package com.epam.springcore.service.api;

import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Interface represented service for managing tickets, prices, bookings.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IBookingService {

    double getTicketPrice(Event event, Date date, Date time, int seats, User user);

    void bookTicket(User user, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Date date);
}
