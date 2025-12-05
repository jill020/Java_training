package com.bpi.oop3;

public class Car {
	//Attributes
	private String color;
	private String model;
	private int year;

	//Parameterized Constructor
	public Car(String model, String color, int year) {
		this.model = model;
		this.color = color;
		this.year = year;
	}

	// No-Args 
	public Car() {
	}

	// Getters
	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	// Setters
	public void setBrand(String brand) {
		this.model = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setYear(int year) {
		this.year = year;
	}

	//Methods
	void colorName() {
		System.out.println("Ang kotse ay color " + color + ".");
	}

	void brandName() {
		System.out.println("Ang brand ng kotse ko ay " + model + " year " + year + ".");
	}
}
