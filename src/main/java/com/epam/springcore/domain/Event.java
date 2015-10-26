package com.epam.springcore.domain;

/**
 * Event domain object.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
public class Event {

    private static final String SEP = " ";
    private String id;
    private String name;
    private String airDate;
    private String airTime;
    private double price;
    private RatingEnum rating;
    private Auditorium auditorium;

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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public String toString() {
        return new StringBuilder(id).append(SEP).append(name).append(SEP).append(airDate)
            .append(SEP).append(airTime).append(SEP).append(rating).append(SEP).append(auditorium)
            .toString();
    }
}
