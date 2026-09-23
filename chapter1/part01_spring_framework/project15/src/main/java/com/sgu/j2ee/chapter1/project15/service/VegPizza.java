package com.sgu.j2ee.chapter1.project15.service;

import org.springframework.stereotype.Component;

@Component("vegPizza")
public class VegPizza implements Pizza {

    @Override
    public String getPizza() {
        return "Veg Pizza";
    }
}
