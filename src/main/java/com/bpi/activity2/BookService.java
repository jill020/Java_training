package com.bpi.activity2;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    private final LoggerService loggerService;

    public BookService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void performBookOperation() {
        loggerService.log("Connected");
    }
}
