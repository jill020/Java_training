package com.bpi.oop5;

public abstract class Vehicle {
	int numberOfWheels;
	String brand;

	public Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
	}

	public abstract void startEngine();

	public void destroy() {
		System.out.println("Destroying " + brand);
	}
}
