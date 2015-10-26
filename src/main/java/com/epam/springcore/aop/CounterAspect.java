package com.epam.springcore.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * CounterAspect.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 11/04/15
 *
 * @author Darya Baraukova
 */
@Aspect
@Component("counterAspect")
public class CounterAspect {

    private static final String EVENT_KEY = "EVENT";
    private static final String PRICE_KEY = "PRICE";
    private static final String TICKET_KEY = "TICKET";
    private Map<String, Integer> counterMap = new HashMap<>();
    int eventCounter = 0;
    int priceCounter = 0;
    int ticketCounter = 0;

    @AfterReturning("execution(* com.epam.springcore.service.impl.EventService.getByName(..))")
    public void countGetEventByNameAccess() {
        eventCounter++;
        counterMap.put(EVENT_KEY, eventCounter);
        System.out.println("Get event by name Aspect Counter was called");
    }

    @AfterReturning("execution(* com.epam.springcore.service.impl.BookingService.getTicketPrice(..))")
    public void countGetTicketPriceAccess() {
        priceCounter++;
        counterMap.put(PRICE_KEY, priceCounter);
        System.out.println("Get Ticket price Aspect Counter was called");
    }

    @AfterReturning("execution(* com.epam.springcore.service.impl.BookingService.bookTicket(..))")
    public void countBookTicketAccess() {
        ticketCounter++;
        counterMap.put(TICKET_KEY, ticketCounter);
        System.out.println("Get Ticket price Aspect Counter was called");
    }

    public void getAspectInfo() {
        Integer count = null != counterMap.get(EVENT_KEY) ? counterMap.get(EVENT_KEY) : 0;
        System.out.println("Get Event by name Aspect was called " + count + " times");
        count = null != counterMap.get(PRICE_KEY) ? counterMap.get(PRICE_KEY) : 0;
        System.out.println("Get Ticket price Aspect was called " + count + " times");
        count = null != counterMap.get(TICKET_KEY) ? counterMap.get(TICKET_KEY) : 0;
        System.out.println("Book Ticket Aspect was called " + count + " times");
    }
}
