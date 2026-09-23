package com.sgu.j2ee.chapter1.project11;

public class GreetingService {
    private String message;
    public GreetingService(String message){this.message = message;}
    public void printMessage(){System.out.println(this.message);}
}
