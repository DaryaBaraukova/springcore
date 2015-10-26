package com.epam.springcore.service.api;

import com.epam.springcore.domain.Auditorium;

import java.util.Set;

/**
 * Interface represented service for managing information about auditoriums and places.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public interface IAuditoriumService {

    void addAuditorium(Auditorium auditorium);
    Set<Auditorium> getAuditoriums();
    int getSeatsNumber(Auditorium auditorium);
    String getVipSeats(Auditorium auditorium);
}
