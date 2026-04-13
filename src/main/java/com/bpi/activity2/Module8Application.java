package com.bpi.activity2;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Module8Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Module8Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9080"));

        ApplicationContext context = app.run(args);

        BookService bookService = context.getBean(BookService.class);

        bookService.performBookOperation();
    }
}
