
package com.amrita.jpl.cys21056.ex ;
class Vehicle {
    protected boolean runStatus;

    public void start() {
        runStatus = true;
        System.out.println("[Vehicle] started.");
    }

    public void stop() {
        runStatus = false;
        System.out.println("[Vehicle] stopped.");
    }
}

class Car extends Vehicle {
    private String modelName;
    private int year;
    private int numOfWheels;

    public Car(String modelName, int year, int numOfWheels) {
        this.modelName = modelName;
        this.year = year;
        this.numOfWheels = numOfWheels;
        System.out.println("Car Instantiated with Parameter " + modelName + ", " + year + ", " + numOfWheels);
    }

    public void drive(int gearPosition) {
        if (runStatus) {
            System.out.println("Driving the car in gear position: " + gearPosition);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

class Bike extends Vehicle {
    private String brandName;
    private int year;
    private int numOfGears;

    public Bike(String brandName, int year, int numOfGears) {
        this.brandName = brandName;
        this.year = year;
        this.numOfGears = numOfGears;
        System.out.println("Bike Instantiated with Parameter " + brandName + ", " + year + ", " + numOfGears);
    }

    public void pedal(int pedalSpeed) {
        if (runStatus) {
            System.out.println("Pedaling the bike at speed: " + pedalSpeed);
        } else {
            System.out.println("Error: Vehicle is not running.");
        }
    }
}

public class VehicleExample {
    public static void main(String[] args) {
        Car car = new Car("Jaguar XF", 2022, 4);
        car.start();
        car.drive(3);
        car.stop();

        System.out.println();

        Bike bike = new Bike("Giant", 2021, 18);
        bike.start();
        bike.pedal(10);
        bike.stop();
    }
}

