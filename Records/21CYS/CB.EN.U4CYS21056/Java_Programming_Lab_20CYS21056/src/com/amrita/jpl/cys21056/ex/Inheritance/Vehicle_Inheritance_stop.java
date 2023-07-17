package com.amrita.jpl.cys21056.ex.Inheritance ;

 class Vehicle {

    public boolean run_status;

    public void start() {
        run_status = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        run_status = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    public String model;
    public int year;
    public int numWheels;

    public Car(String model, int year, int numWheels) {
        this.model = model;
        this.year = year;
        this.numWheels = numWheels;
        System.out.println("Car Instantiated with Parameter " + model + ", " + year + ", " + numWheels);
    }

    public void drive(int gearPosition) {
        if (run_status) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Cannot drive. Start the car first.");
        }
    }
}

class Bike extends Vehicle {
    public String brand;
    public int year;
    public int numGears;

    public Bike(String brand, int year, int numGears) {
        this.brand = brand;
        this.year = year;
        this.numGears = numGears;
        System.out.println("Bike Instantiated with Parameter " + brand + ", " + year + ", " + numGears);
    }

    public void pedal(int pedalSpeed) {
        if (run_status) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Cannot pedal. Start the bike first.");
        }
    }
}

public class Vehicle_Inheritance_stop {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);

        car.drive(3);
        car.stop();

        Bike bike = new Bike("Giant", 2021, 18);

        bike.pedal(10);
        bike.stop();
    }
}