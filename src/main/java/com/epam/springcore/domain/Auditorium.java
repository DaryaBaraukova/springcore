package com.epam.springcore.domain;

/**
 * Auditorium domain object.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public class Auditorium {

    private static final String SEP = " ";
    private String id;
    private String name;
    private int seatsNumber;
    private String vipSeats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(String vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public String toString() {
        return new StringBuilder(id).append(SEP).append(name).append(SEP)
                .append(seatsNumber).append(SEP).append(vipSeats).toString();
    }
}
