package com.epam.springcore.service.impl;

import com.epam.springcore.dao.api.IAuditoriumDao;
import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.service.api.IAuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Implementation of {@link IAuditoriumService}.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
@Service("auditoriumService")
public class AuditoriumService implements IAuditoriumService {

    @Autowired
    private IAuditoriumDao auditoriumDao;

    @Override
    public void addAuditorium(Auditorium auditorium) {
        auditoriumDao.add(auditorium);
    }

    @Override
    public Set<Auditorium> getAuditoriums() {
        return auditoriumDao.getAuditoriums();
    }

    @Override
    public int getSeatsNumber(Auditorium auditorium) {
        return auditoriumDao.getSeatsNumber(auditorium.getId());
    }

    @Override
    public String getVipSeats(Auditorium auditorium) {
        return auditoriumDao.getVipSeats(auditorium.getId());
    }
}
