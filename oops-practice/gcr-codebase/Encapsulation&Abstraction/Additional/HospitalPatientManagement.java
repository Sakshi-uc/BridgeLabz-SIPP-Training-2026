abstract class Patient {
	private String patientId;
	private String name;
	private int age;

	Patient(String patientId, String name, int age) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
	}

	String getPatientId() {
		return patientId;
	}

	void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	abstract double calculateBill();

	void displayPatientDetails() {
		System.out.println("Patient ID: " + patientId);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

class InPatient extends Patient {
	private double roomCharges;
	private double treatmentCharges;

	InPatient(String patientId, String name, int age, double roomCharges, double treatmentCharges) {
		super(patientId, name, age);
		this.roomCharges = roomCharges;
		this.treatmentCharges = treatmentCharges;
	}

	void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}

	void setTreatmentCharges(double treatmentCharges) {
		this.treatmentCharges = treatmentCharges;
	}

	double getRoomCharges() {
		return roomCharges;
	}

	double getTreatmentCharges() {
		return treatmentCharges;
	}

	@Override
	double calculateBill() {
		return roomCharges + treatmentCharges;
	}
}

class OutPatient extends Patient {
	private double consultationFee;
	private double treatmentCharges;

	OutPatient(String patientId, String name, int age, double consultationFee, double treatmentCharges) {
		super(patientId, name, age);
		this.consultationFee = consultationFee;
		this.treatmentCharges = treatmentCharges;
	}

	void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	void setTreatmentCharges(double treatmentCharges) {
		this.treatmentCharges = treatmentCharges;
	}

	double getConsultationFee() {
		return consultationFee;
	}

	double getTreatmentCharges() {
		return treatmentCharges;
	}

	@Override
	double calculateBill() {
		return consultationFee + treatmentCharges;
	}
}

class HospitalPatientManagement {
	public static void main(String[] args) {
		Patient inPatient = new InPatient("IP001", "Alice Brown", 35, 5000, 10000);
		Patient outPatient = new OutPatient("OP001", "Bob Wilson", 42, 500, 2000);

		System.out.println("=== In-Patient ===");
		inPatient.displayPatientDetails();
		System.out.printf("Bill: %.2f\n\n", inPatient.calculateBill());

		System.out.println("=== Out-Patient ===");
		outPatient.displayPatientDetails();
		System.out.printf("Bill: %.2f\n", outPatient.calculateBill());
	}
}
