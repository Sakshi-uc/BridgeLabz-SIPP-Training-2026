class Device {
	private String deviceId;
	private String status;

	Device(String deviceId, String status) {
		this.deviceId = deviceId;
		this.status = status;
	}

	String getDeviceId() {
		return deviceId;
	}

	String getStatus() {
		return status;
	}

	void setStatus(String status) {
		this.status = status;
	}

	void displayStatus() {
		System.out.println("Device ID: " + deviceId);
		System.out.println("Status: " + status);
	}
}

class Thermostat extends Device {
	private double temperatureSetting;

	Thermostat(String deviceId, String status, double temperatureSetting) {
		super(deviceId, status);
		this.temperatureSetting = temperatureSetting;
	}

	double getTemperatureSetting() {
		return temperatureSetting;
	}

	void setTemperatureSetting(double temperatureSetting) {
		this.temperatureSetting = temperatureSetting;
	}

	@Override
	void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature Setting: " + temperatureSetting + "°C");
	}
}

class SmartHomeDevices {
	public static void main(String[] args) {
		Thermostat thermostat = new Thermostat("THM001", "Active", 22.5);
		Thermostat thermostat2 = new Thermostat("THM002", "Standby", 20.0);

		System.out.println("=== Thermostat 1 ===");
		thermostat.displayStatus();

		System.out.println("\n=== Thermostat 2 ===");
		thermostat2.displayStatus();
	}
}
