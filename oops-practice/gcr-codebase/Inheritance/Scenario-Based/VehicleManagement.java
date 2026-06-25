class Vehicle {
	private double maxSpeed;
	private String model;

	Vehicle(double maxSpeed, String model) {
		this.maxSpeed = maxSpeed;
		this.model = model;
	}

	double getMaxSpeed() {
		return maxSpeed;
	}

	String getModel() {
		return model;
	}

	void displayInfo() {
		System.out.println("Model: " + model);
		System.out.println("Max Speed: " + maxSpeed + " km/h");
	}
}

interface Refuelable {
	void refuel();
}

class ElectricVehicle extends Vehicle {
	private double batteryCapacity;

	ElectricVehicle(double maxSpeed, String model, double batteryCapacity) {
		super(maxSpeed, model);
		this.batteryCapacity = batteryCapacity;
	}

	double getBatteryCapacity() {
		return batteryCapacity;
	}

	void charge() {
		System.out.println("Charging... Battery: " + batteryCapacity + " kWh");
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		charge();
	}
}

class PetrolVehicle extends Vehicle implements Refuelable {
	private double fuelCapacity;

	PetrolVehicle(double maxSpeed, String model, double fuelCapacity) {
		super(maxSpeed, model);
		this.fuelCapacity = fuelCapacity;
	}

	double getFuelCapacity() {
		return fuelCapacity;
	}

	@Override
	public void refuel() {
		System.out.println("Refueling... Fuel capacity: " + fuelCapacity + " liters");
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		refuel();
	}
}

class VehicleManagement {
	public static void main(String[] args) {
		ElectricVehicle ev = new ElectricVehicle(200, "Tesla Model 3", 75);
		PetrolVehicle pv = new PetrolVehicle(220, "BMW X5", 80);

		System.out.println("=== Electric Vehicle ===");
		ev.displayInfo();

		System.out.println("\n=== Petrol Vehicle ===");
		pv.displayInfo();

		System.out.println("\n=== Interface Check ===");
		System.out.println("pv implements Refuelable: " + (pv instanceof Refuelable));
	}
}
