package com.bpi.activity8_2;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Main.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
		app.run(args);
    }
}

