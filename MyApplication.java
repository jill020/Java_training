package com.bpi.oop5;

public class MyApplication {
	public static void main(String[] args) {
        Car car = new Car(4, "Vios car");
        Truck truck = new Truck(10, "Izusu truck");

        // Call inherited/implemented methods
        car.startEngine();
        car.refuel();

        truck.startEngine();
        truck.refuel();

        // Destroy vehicles using helper method
        destroyVehicle(car);
        destroyVehicle(truck);
    }

    private static void destroyVehicle(Vehicle vehicle) {
        vehicle.destroy();
    }
}
