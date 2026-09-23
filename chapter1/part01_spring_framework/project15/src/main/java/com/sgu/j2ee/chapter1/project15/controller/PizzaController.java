package com.sgu.j2ee.chapter1.project15.controller;

import com.sgu.j2ee.chapter1.project15.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

    private Pizza pizza;

    /**
     * 1. Constructor Injection using @Autowired and @Qualifier
     * Spring resolves ambiguity between VegPizza and NonVegPizza using @Qualifier("vegPizza").
     */
    @Autowired
    public PizzaController(@Qualifier("vegPizza") Pizza pizza) {
        System.out.println("inside PizzaController constructor");
        this.pizza = pizza;
    }

    /*
    // 2. Setter Injection using @Autowired and @Qualifier:
    @Autowired
    @Qualifier("vegPizza")
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    */

    /*
    // 3. Field Injection using @Autowired and @Qualifier:
    @Autowired
    @Qualifier("vegPizza")
    private Pizza pizza;
    */

    public String getPizza() {
        return pizza.getPizza();
    }
}
