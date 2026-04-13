package com.bpi.activity6;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private final SingletonService singleton1;
    private final SingletonService singleton2;

    private final PrototypeService prototype1;
    private final PrototypeService prototype2;

    public DemoService(SingletonService singleton1,
                       SingletonService singleton2,
                       PrototypeService prototype1,
                       PrototypeService prototype2) {
        this.singleton1 = singleton1;
        this.singleton2 = singleton2;
        this.prototype1 = prototype1;
        this.prototype2 = prototype2;
    }

    public void testScopes() {
        System.out.println("\nTesting Singleton:");
        singleton1.print();
        singleton2.print();
        System.out.println("Are singletons same? " + (singleton1 == singleton2));

        System.out.println("\nTesting Prototype:");
        prototype1.print();
        prototype2.print();
        System.out.println("Are prototypes same? " + (prototype1 == prototype2));
    }
}
