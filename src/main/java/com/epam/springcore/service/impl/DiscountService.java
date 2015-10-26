package com.epam.springcore.service.impl;

import com.epam.springcore.domain.Event;
import com.epam.springcore.domain.User;
import com.epam.springcore.service.api.IDiscountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation of {@link IDiscountService}.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/21/15
 *
 * @author Darya Baraukova
 */
@Service("discountService")
public class DiscountService implements IDiscountService {

    List<DiscountStrategy> discountStrategyList = new ArrayList<>();

    @Override
    public double getDiscount(User user, Event event, Date date) {
        double discount = 0.0;
        for (DiscountStrategy discountStrategy: discountStrategyList) {
            discount += discountStrategy.getDiscount(user, date);
        }
        System.out.println("Common Dicount: " + (int)(discount*100) + '%');
        return discount;
    }

    public void setDiscountStrategyList(List<DiscountStrategy> discountStrategyList) {
        this.discountStrategyList = discountStrategyList;
    }
}
