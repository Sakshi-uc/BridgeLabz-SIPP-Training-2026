interface HeartRateMonitor {
	void monitorHeartRate(String patientId);
	default void displayHealthTips() {
		System.out.println("Maintain heart health: Exercise regularly");
	}
}

interface TemperatureMonitor {
	void monitorTemperature(String patientId);
	default void displayHealthTips() {
		System.out.println("Normal body temperature: 36.5-37.5°C");
	}
	static boolean isPatientIdValid(String patientId) {
		return patientId.matches("P\\d{5}");
	}
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
	private String[] validPatients = { "P10001", "P10002", "P10003", "P10004" };

	@Override
	public void monitorHeartRate(String patientId) {
		if (TemperatureMonitor.isPatientIdValid(patientId)) {
			System.out.println("Monitoring heart rate for " + patientId + ": 72 bpm");
		} else {
			System.out.println("Invalid patient ID format: " + patientId);
		}
	}

	@Override
	public void monitorTemperature(String patientId) {
		if (TemperatureMonitor.isPatientIdValid(patientId)) {
			System.out.println("Monitoring temperature for " + patientId + ": 37.0°C");
		} else {
			System.out.println("Invalid patient ID format: " + patientId);
		}
	}

	@Override
	public void displayHealthTips() {
		System.out.println("Comprehensive Health Monitoring: Regular check-ups essential");
	}

	void monitorPatient(String patientId) {
		System.out.println("\n=== Patient " + patientId + " ===");
		monitorHeartRate(patientId);
		monitorTemperature(patientId);
	}

	void generateHealthReport(String[] patientIds) {
		System.out.println("=== Daily Health Report ===\n");
		displayHealthTips();
		for (String id : patientIds) {
			monitorPatient(id);
		}
	}
}

class HealthcareMonitoringDemo {
	public static void main(String[] args) {
		HealthMonitoringSystem system = new HealthMonitoringSystem();
		String[] patients = { "P10001", "P10002", "P10003" };
		system.generateHealthReport(patients);
	}
}
