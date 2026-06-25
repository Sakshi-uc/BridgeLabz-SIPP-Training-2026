abstract class Vehicle {
	private String vehicleNumber;
	private String vehicleType;

	Vehicle(String vehicleNumber, String vehicleType) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}

	String getVehicleNumber() {
		return vehicleNumber;
	}

	void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	String getVehicleType() {
		return vehicleType;
	}

	void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	abstract double calculateRentalCost(int days);

	void displayVehicleDetails() {
		System.out.println("Vehicle Number: " + vehicleNumber);
		System.out.println("Vehicle Type: " + vehicleType);
	}
}

class Car extends Vehicle {
	private double dailyRate;

	Car(String vehicleNumber, String vehicleType, double dailyRate) {
		super(vehicleNumber, vehicleType);
		this.dailyRate = dailyRate;
	}

	void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	double getDailyRate() {
		return dailyRate;
	}

	@Override
	double calculateRentalCost(int days) {
		return days * dailyRate;
	}
}

class Bike extends Vehicle {
	private double dailyRate;

	Bike(String vehicleNumber, String vehicleType, double dailyRate) {
		super(vehicleNumber, vehicleType);
		this.dailyRate = dailyRate;
	}

	void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	double getDailyRate() {
		return dailyRate;
	}

	@Override
	double calculateRentalCost(int days) {
		return days * dailyRate;
	}
}

class Truck extends Vehicle {
	private double dailyRate;
	private double loadingCharge;

	Truck(String vehicleNumber, String vehicleType, double dailyRate, double loadingCharge) {
		super(vehicleNumber, vehicleType);
		this.dailyRate = dailyRate;
		this.loadingCharge = loadingCharge;
	}

	void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	void setLoadingCharge(double loadingCharge) {
		this.loadingCharge = loadingCharge;
	}

	double getDailyRate() {
		return dailyRate;
	}

	double getLoadingCharge() {
		return loadingCharge;
	}

	@Override
	double calculateRentalCost(int days) {
		return (days * dailyRate) + loadingCharge;
	}
}

class VehicleRentalSystem {
	public static void main(String[] args) {
		Vehicle car = new Car("CAR001", "Sedan", 100);
		Vehicle bike = new Bike("BIKE001", "Sports", 50);
		Vehicle truck = new Truck("TRUCK001", "Heavy", 200, 500);

		int days = 5;

		System.out.println("=== Car Rental ===");
		car.displayVehicleDetails();
		System.out.printf("Cost for %d days: %.2f\n\n", days, car.calculateRentalCost(days));

		System.out.println("=== Bike Rental ===");
		bike.displayVehicleDetails();
		System.out.printf("Cost for %d days: %.2f\n\n", days, bike.calculateRentalCost(days));

		System.out.println("=== Truck Rental ===");
		truck.displayVehicleDetails();
		System.out.printf("Cost for %d days: %.2f\n", days, truck.calculateRentalCost(days));
	}
}
