package com.sgu.j2ee.chapter1.project15;

import com.sgu.j2ee.chapter1.project15.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Project15Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Project15Application.class, args);
        System.out.println("calling pizzaController.getPizza()");
        PizzaController pizzaController = context.getBean(PizzaController.class);
        String message = pizzaController.getPizza();
        System.out.println(message);
    }

}
