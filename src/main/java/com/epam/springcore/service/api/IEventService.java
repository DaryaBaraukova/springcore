package com.epam.springcore.service.api;

import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.RatingEnum;

import java.util.Date;
import java.util.List;

/**
 * Interface represented service for managing events (movie shows).
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IEventService {

    Event create(String id, String name, Date airDate, Date airTime, double price, RatingEnum rating);

    void remove(Event event);

    Event getByName(String name);

    List<Event> getAll();

    //getForDateRange(from, to) optional
    //getNextEvents(to)

    void assignAuditorium(Event event, Auditorium auditorium, Date date);
}
