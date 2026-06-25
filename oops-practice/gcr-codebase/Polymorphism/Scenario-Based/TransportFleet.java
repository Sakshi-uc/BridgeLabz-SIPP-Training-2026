abstract class Vehicle {
	protected String vehicleNumber;

	Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	abstract double fuelCost(int km);

	void displayInfo() {
		System.out.println("Vehicle: " + vehicleNumber);
	}
}

class Car extends Vehicle {
	Car(String vehicleNumber) {
		super(vehicleNumber);
	}

	@Override
	double fuelCost(int km) {
		return km * 8;
	}
}

class Bus extends Vehicle {
	Bus(String vehicleNumber) {
		super(vehicleNumber);
	}

	@Override
	double fuelCost(int km) {
		return km * 5;
	}
}

class Bike extends Vehicle {
	Bike(String vehicleNumber) {
		super(vehicleNumber);
	}

	@Override
	double fuelCost(int km) {
		return km * 2;
	}
}

class ElectricCar extends Vehicle {
	ElectricCar(String vehicleNumber) {
		super(vehicleNumber);
	}

	@Override
	double fuelCost(int km) {
		return km * 3;
	}
}

class TransportFleet {
	public static void main(String[] args) {
		Vehicle[] fleet = {
			new Car("CAR001"),
			new Bus("BUS001"),
			new Bike("BIKE001"),
			new ElectricCar("ECAR001")
		};

		int distance = 100;
		System.out.println("=== Fuel Cost for " + distance + "km ===\n");

		for (Vehicle vehicle : fleet) {
			vehicle.displayInfo();
			System.out.printf("Fuel Cost: %.2f\n\n", vehicle.fuelCost(distance));
		}
	}
}
