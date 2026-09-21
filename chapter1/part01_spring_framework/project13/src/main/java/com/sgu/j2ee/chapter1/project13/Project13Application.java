package com.sgu.j2ee.chapter1.project13;

import com.sgu.j2ee.chapter1.project13.scope.AppConfig;
import com.sgu.j2ee.chapter1.project13.scope.MessageService;
import com.sgu.j2ee.chapter1.project13.scope.TwitterMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Project13Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = context.getBean(TwitterMessageService.class);
        messageService.setMessage("TwitterMessageService Implementation");
        System.out.println(messageService.getMessage());

        MessageService messageService1 = context.getBean(MessageService.class);
        System.out.println(messageService1.getMessage());
        context.close();
    }

}
