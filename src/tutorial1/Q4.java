package tutorial1;

public class Q4 {
    /*
     * An instance of Vehicle cannot be created since Vehicle is an abstract class that cannot be instantiated.
     * However, we can create an instance of a concrete class that extends Vehicle.
     */
    public static void main(String[] args) {
//        Vehicle vehicle = new Vehicle();
        // Playground
        Vehicle car = new Car(8);
        car.pedalToTheMetal();
    }
}

abstract class Vehicle {
    private double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    abstract void accelerate();

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void pedalToTheMetal() {
        while (currentSpeed != maxSpeed)
            accelerate();
    }
}

// Playground
class Car extends Vehicle {
    public Car(double maxSpeed) {
        super(maxSpeed);
    }

    @Override
    void accelerate() {
        currentSpeed++;
        System.out.println("Current speed is " + currentSpeed);
    }
}
