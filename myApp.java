package com.bpi.oop3;

public class myApp {
	public static void main(String[] args) {
		Car car1 = new Car();

		// Assign values using setters
		car1.setBrand("Vios");
		car1.setColor("Red");
		car1.setYear(2000);

		// Parameterized Constructor
		Car car2 = new Car("Honda", "Blue", 2003);

		// Call methods
		System.out.println("Call the methods without getters:");
		car1.colorName();
		car2.brandName();
		System.out.println();
		
		System.out.println("Call the methods with getters:");
		System.out.println("Car1 brand: " + car1.getModel() + " " + car1.getColor());
		System.out.println("Car2 brand: " + car2.getModel() + " " + car2.getColor());
	}
}
