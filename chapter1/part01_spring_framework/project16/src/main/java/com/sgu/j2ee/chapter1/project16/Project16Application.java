package com.sgu.j2ee.chapter1.project16;

import com.sgu.j2ee.chapter1.project16.service.MyBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Project16Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Project16Application.class);

        Runnable task = () -> {

            MyBean bean1 = context.getBean(MyBean.class);
            MyBean bean2 = context.getBean(MyBean.class);

            System.out.println(Thread.currentThread().getName()
                    + " : " + (bean1 == bean2));
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
