package com.bpi.oop5;

public class Car extends Vehicle implements Refuelable {

    public Car(int numberOfWheels, String brand) {
        super(numberOfWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println("Starting engine of " + brand);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + brand);
    }
}
