package com.sgu.j2ee.chapter1.project11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Project11Application {

	public static void main(String[] args) {
		// Khởi tạo Spring Context và lưu vào biến context
		ApplicationContext context = SpringApplication.run(Project11Application.class, args);

		// Truy vấn Bean từ Context
		GreetingService greetingService = context.getBean(GreetingService.class);

		// In lời chào ra màn hình
		greetingService.printMessage();
	}

}
