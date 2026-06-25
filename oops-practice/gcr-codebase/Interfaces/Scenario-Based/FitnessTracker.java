interface Trackable {
	void logActivity(String activity);
	default void resetData() {
		System.out.println("Data reset to default");
	}
}

interface Reportable {
	void generateReport();
}

interface Notifiable {
	void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
	private java.util.List<String> activities = new java.util.ArrayList<>();
	private int dailySteps = 0;

	@Override
	public void logActivity(String activity) {
		activities.add(activity);
		System.out.println("Activity logged: " + activity);
	}

	@Override
	public void generateReport() {
		System.out.println("=== Fitness Report ===");
		System.out.println("Total activities: " + activities.size());
		for (String activity : activities) {
			System.out.println("- " + activity);
		}
	}

	@Override
	public void sendAlert(String message) {
		System.out.println("ALERT: " + message);
	}

	@Override
	public void resetData() {
		activities.clear();
		dailySteps = 0;
		Trackable.super.resetData();
	}
}

class FitnessTracker {
	public static void main(String[] args) {
		FitnessDevice device = new FitnessDevice();

		device.logActivity("Running 5km");
		device.logActivity("Swimming 30min");
		device.logActivity("Yoga 45min");

		device.generateReport();

		device.sendAlert("Daily step goal reached!");

		device.resetData();
	}
}
