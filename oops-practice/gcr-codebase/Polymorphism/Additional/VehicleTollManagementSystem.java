class Vehicle {
	protected String vehicleNumber;
	protected String ownerName;

	Vehicle(String vehicleNumber, String ownerName) {
		this.vehicleNumber = vehicleNumber;
		this.ownerName = ownerName;
	}

	double calculateToll() {
		return 0;
	}

	void displayInfo() {
		System.out.println("Vehicle: " + vehicleNumber + " (" + ownerName + ")");
	}
}

class Car extends Vehicle {
	Car(String vehicleNumber, String ownerName) {
		super(vehicleNumber, ownerName);
	}

	@Override
	double calculateToll() {
		return 100;
	}
}

class Bus extends Vehicle {
	Bus(String vehicleNumber, String ownerName) {
		super(vehicleNumber, ownerName);
	}

	@Override
	double calculateToll() {
		return 200;
	}
}

class Truck extends Vehicle {
	Truck(String vehicleNumber, String ownerName) {
		super(vehicleNumber, ownerName);
	}

	@Override
	double calculateToll() {
		return 300;
	}
}

class SmartVehicleTollManagementSystem {
	static double calculateTotalRevenue(Vehicle[] vehicles) {
		double total = 0;
		for (Vehicle vehicle : vehicles) {
			total += vehicle.calculateToll();
		}
		return total;
	}

	static Vehicle searchVehicle(String vehicleNumber, Vehicle[] vehicles) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.vehicleNumber.equals(vehicleNumber)) {
				return vehicle;
			}
		}
		return null;
	}

	static Vehicle getHighestTollVehicle(Vehicle[] vehicles) {
		Vehicle highest = vehicles[0];
		for (Vehicle vehicle : vehicles) {
			if (vehicle.calculateToll() > highest.calculateToll()) {
				highest = vehicle;
			}
		}
		return highest;
	}

	public static void main(String[] args) {
		Vehicle[] vehicles = {
			new Car("CAR001", "John"),
			new Bus("BUS001", "City Transport"),
			new Truck("TRUCK001", "Logistics Co"),
			new Car("CAR002", "Alice"),
			new Bus("BUS002", "Metro Services")
		};

		System.out.println("=== Toll Management System ===\n");

		System.out.println("All Vehicles:");
		int cars = 0, buses = 0, trucks = 0;
		for (Vehicle vehicle : vehicles) {
			vehicle.displayInfo();
			System.out.printf("Toll: %.2f\n\n", vehicle.calculateToll());
			if (vehicle instanceof Car) cars++;
			else if (vehicle instanceof Bus) buses++;
			else if (vehicle instanceof Truck) trucks++;
		}

		System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));
		System.out.println("\nVehicle Count: Cars=" + cars + ", Buses=" + buses + ", Trucks=" + trucks);

		Vehicle highest = getHighestTollVehicle(vehicles);
		System.out.println("\nHighest Toll Vehicle:");
		highest.displayInfo();
		System.out.printf("Toll: %.2f\n", highest.calculateToll());
	}
}
