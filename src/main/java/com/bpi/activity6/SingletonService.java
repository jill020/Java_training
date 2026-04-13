package com.bpi.activity6;


import org.springframework.stereotype.Component;

@Component
public class SingletonService {
    public SingletonService() {
        System.out.println("SingletonService Created");
    }

    public void print() {
        System.out.println("SingletonService Instance: " + this);
    }
}
