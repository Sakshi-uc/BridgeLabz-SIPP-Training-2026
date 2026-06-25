abstract class Employee {
	private String employeeId;
	private String employeeName;

	Employee(String employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	String getEmployeeId() {
		return employeeId;
	}

	void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	String getEmployeeName() {
		return employeeName;
	}

	void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	abstract double calculateSalary();

	void displayEmployeeInfo() {
		System.out.println("Employee ID: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.printf("Salary: %.2f\n", calculateSalary());
	}
}

class FullTimeEmployee extends Employee {
	private double monthlySalary;

	FullTimeEmployee(String employeeId, String employeeName, double monthlySalary) {
		super(employeeId, employeeName);
		this.monthlySalary = monthlySalary;
	}

	void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	double getMonthlySalary() {
		return monthlySalary;
	}

	@Override
	double calculateSalary() {
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee {
	private double hoursWorked;
	private double hourlyRate;

	PartTimeEmployee(String employeeId, String employeeName, double hoursWorked, double hourlyRate) {
		super(employeeId, employeeName);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	double getHoursWorked() {
		return hoursWorked;
	}

	double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
}

class EmployeePayrollSystem {
	public static void main(String[] args) {
		Employee fullTime = new FullTimeEmployee("FT001", "Alice Johnson", 5000);
		Employee partTime = new PartTimeEmployee("PT001", "Bob Smith", 80, 25);

		System.out.println("=== Full Time Employee ===");
		fullTime.displayEmployeeInfo();

		System.out.println("\n=== Part Time Employee ===");
		partTime.displayEmployeeInfo();
	}
}
