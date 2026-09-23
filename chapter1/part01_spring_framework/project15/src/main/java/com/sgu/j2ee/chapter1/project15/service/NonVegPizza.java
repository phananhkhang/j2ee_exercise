package com.sgu.j2ee.chapter1.project15.service;

import org.springframework.stereotype.Component;

@Component("nonVegPizza")
public class NonVegPizza implements Pizza {

    @Override
    public String getPizza() {
        return "Non-veg Pizza";
    }
}
