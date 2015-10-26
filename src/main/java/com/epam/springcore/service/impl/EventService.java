package com.epam.springcore.service.impl;

import com.epam.springcore.dao.api.IEventDao;
import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.RatingEnum;
import com.epam.springcore.service.api.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link IEventService} for managing  events (movie shows).
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
@Service("eventService")
public class EventService implements IEventService {

    @Autowired
    private IEventDao eventDao;

    //TODO replace with Maps Guava
    private Map<String, Event> events = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    @Override
    public Event create(String id, String name, Date airDate, Date airTime, double price,
                        RatingEnum rating) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        event.setAirDate(dateFormat.format(airDate));
        event.setAirTime(timeFormat.format(airTime));
        event.setPrice(price);
        event.setRating(rating);
        eventDao.insert(event);
        return event;
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getId());
    }

    @Override
    public Event getByName(String name) {
        return !StringUtils.isEmpty(name) ? eventDao.getByName(name) : null;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList(events.values());
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date airDate) {
        if (null != event && null != auditorium) {
            eventDao.assignAuditorium(event.getId(), auditorium);
        } else {
            System.out.println("Event/Auditorium shouldn't be null");
        }
    }
}
