package test;

public class Car {
    String location;

    public Car(String location) {
        this.location = location;
    }

    public void start() {
        System.out.println("Start the car... " + location);
    }

    public String toString() {
        return "Start the car... " + location;
    }
}