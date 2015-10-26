package com.epam.springcore.dao.api;

import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.domain.Event;

import java.util.List;

/**
 * IEventDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IEventDao {

    void insert(Event event);

    void remove(String id);

    Event getByName(String name);

    List<Event> getAll();

    void assignAuditorium(String eventId, Auditorium auditorium);
}
