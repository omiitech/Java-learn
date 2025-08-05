class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}

class Bike extends Vehicle {
    void balance() {
        System.out.println("Bike is balancing");
    }
}

public class Hierarchy {
    public static void main(String[] args) {
        Bike myBike = new Bike();
        myBike.move();    // Inherited from Vehicle
        myBike.balance(); // Specific to Bike
    }
}