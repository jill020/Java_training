package com.bpi.activity8_7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/api/welcome")
    public String welcome() {
        return message;
    }
}
