package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.api.IEventDao;
import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EventDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/22/15
 *
 * @author Darya Baraukova
 */
@Repository("eventDao")
public class EventDao implements IEventDao {

    private Map<String, Event> events = new HashMap<>();

    @Override
    public void insert(Event event) {
        events.put(event.getId(), event);
    }

    @Override
    public void remove(String id) {
        events.remove(id);
    }

    @Override
    public Event getByName(String name) {
        Event event = null;
        for (Map.Entry<String, Event> eventEntry: events.entrySet()) {
            if (name.equals(eventEntry.getValue().getName())) {
                event =  eventEntry.getValue();
            }
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList(events.values());
    }

    @Override
    public void assignAuditorium(String eventId, Auditorium auditorium) {
        Event event = events.get(eventId);
        if (null != event) {
            event.setAuditorium(auditorium);
        }
    }
}
