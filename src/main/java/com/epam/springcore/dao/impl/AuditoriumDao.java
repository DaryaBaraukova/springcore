package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.api.IAuditoriumDao;
import com.epam.springcore.domain.Auditorium;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AuditoriumDao
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/22/15
 *
 * @author Darya Baraukova
 */
@Repository("auditoriumDao")
public class AuditoriumDao implements IAuditoriumDao {

    private Map<String, Auditorium> auditoriums = new HashMap<>();

    @Override
    public void add(Auditorium auditorium) {
        if (null != auditorium.getId() && !auditoriums.containsKey(auditorium.getId())) {
            auditoriums.put(auditorium.getId(), auditorium);
            System.out.println("Auditorium was successfully added: " + auditorium);
        } else {
            System.out.println("Auditorium id should not be null");
        }
    }

    @Override
    public Set<Auditorium> getAuditoriums() {
        return new HashSet<>(auditoriums.values());
    }

    @Override
    public int getSeatsNumber(String auditoriumId) {
        return !StringUtils.isEmpty(auditoriumId)
            ? auditoriums.get(auditoriumId).getSeatsNumber() : 0;
    }

    @Override
    public String getVipSeats(String auditoriumId) {
        String vipSeats = "";
        if (!StringUtils.isEmpty(auditoriumId)) {
            vipSeats = auditoriums.get(auditoriumId).getVipSeats();
        }
        return vipSeats;
    }
}
