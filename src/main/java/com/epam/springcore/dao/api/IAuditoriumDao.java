package com.epam.springcore.dao.api;

import com.epam.springcore.domain.Auditorium;

import java.util.Set;

/**
 * IAuditoriumDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/22/15
 *
 * @author Darya Baraukova
 */
public interface IAuditoriumDao {

    void add(Auditorium auditorium);

    Set<Auditorium> getAuditoriums();

    int getSeatsNumber(String auditoriumId);

    String getVipSeats(String auditoriumId);
}
