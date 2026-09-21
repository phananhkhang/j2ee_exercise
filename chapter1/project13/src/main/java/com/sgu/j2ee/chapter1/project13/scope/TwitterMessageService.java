package com.sgu.j2ee.chapter1.project13.scope;


public class TwitterMessageService implements MessageService {
    private String message;
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
