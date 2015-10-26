package com.epam.springcore;

import com.epam.springcore.aop.CounterAspect;
import com.epam.springcore.domain.Auditorium;
import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.RatingEnum;
import com.epam.springcore.domain.Ticket;
import com.epam.springcore.domain.User;
import com.epam.springcore.service.api.IAuditoriumService;
import com.epam.springcore.service.api.IDiscountService;
import com.epam.springcore.service.api.IEventService;
import com.epam.springcore.service.api.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * App
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/22/15
 *
 * @author Darya Baraukova
 */
public class App {

    private static final String EVENT_KEY = "EVENT";
    private static final String PRICE_KEY = "PRICE";
    private static final String TICKET_KEY = "TICKET";
    private IUserService userService;
    private IEventService eventService;
    private IAuditoriumService audirotiumService;
    private IDiscountService discountService;
    private CounterAspect counterAspect;

    App(IUserService userService, IEventService eventService, IAuditoriumService audirotiumService,
        IDiscountService discountService, CounterAspect counterAspect) {
        this.userService = userService;
        this.eventService = eventService;
        this.audirotiumService = audirotiumService;
        this.discountService = discountService;
        this.counterAspect = counterAspect;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        User user = (User) context.getBean("user");
        Auditorium auditorium = (Auditorium) context.getBean("auditorium");
        IUserService userService = (IUserService) context.getBean("userService");
        IEventService eventService = (IEventService) context.getBean("eventService");
        IAuditoriumService audirotiumService = (IAuditoriumService) context.getBean("auditoriumService");
        IDiscountService discountService = (IDiscountService) context.getBean("discountService");
        CounterAspect counterAspect = (CounterAspect) context.getBean("counterAspect");
        App app = new App(userService, eventService, audirotiumService, discountService, counterAspect);
        app.exec(user, auditorium);
    }

    public void exec(User user, Auditorium auditorium) {
        //registrate user
        userService.register(user);
        //get list of booked tickets
        List<Ticket> tickets = userService.getBookedTickets(user);
        System.out.println("Tickets for user '" + user.getName() + "':");
        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
        //add auditorium
        audirotiumService.addAuditorium(auditorium);
        System.out.println("Avalable auditoriums: ");
        for (Auditorium avalAuditorium: audirotiumService.getAuditoriums()) {
            System.out.println(avalAuditorium);
        }
        //create event
        Date date = new Date();
        Event event = eventService.create("1", "The Best Comedy", date, date, 3.5, RatingEnum.HIGH);
        //assign auditorium for event
        eventService.assignAuditorium(event, auditorium, date);
        System.out.println("Created event: " + eventService.getByName("The Best Comedy"));
        //get discount for user
        discountService.getDiscount(user, event, date);
        //get information about aspect calls
        counterAspect.getAspectInfo();
    }
}
