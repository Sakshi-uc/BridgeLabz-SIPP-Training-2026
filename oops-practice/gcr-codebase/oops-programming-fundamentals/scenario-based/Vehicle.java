class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
}

public class SmartParkingManagement {

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Vehicle("UP85-6525", "Sakshi", "Car"),
                new Vehicle("UP82-9235", "Aman", "Bike"),
                new Vehicle("DL03-4523", "Love", "Car"),
                new Vehicle("UP85-0001", "Abhay", "Car"),
                new Vehicle("UP80-2035", "tanishq", "Car"),
                new Vehicle("BR65-1228", "jai", "Bike"),
                new Vehicle("UP85-4621", "angle", "Car"),
                new Vehicle("UP85-4624", "Rohit", "Bike"),
                new Vehicle("UP85-4621", "dabbu", "Car"),
                new Vehicle("UP62-4615", "Rameshwar", "Bike")
        };

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}
