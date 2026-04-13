package com.bpi.activity6;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Main.class);
    	app.setDefaultProperties(Collections.singletonMap("server.port", "9080"));
    	ApplicationContext context = app.run(args);
    	
        DemoService demoService = context.getBean(DemoService.class);
        demoService.testScopes();
    }
}
