class Person {
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
}

class Student extends Person {
	private String studentId;
	private double gpa;

	Student(String name, int age, String studentId, double gpa) {
		super(name, age);
		this.studentId = studentId;
		this.gpa = gpa;
	}

	String getStudentId() {
		return studentId;
	}

	double getGPA() {
		return gpa;
	}

	@Override
	public String toString() {
		return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
	}
}

class GradStudent extends Student {
	private final String studentId;
	private String thesisTopic;

	GradStudent(String name, int age, String studentId, double gpa, String thesisTopic) {
		super(name, age, studentId, gpa);
		this.studentId = studentId;
		this.thesisTopic = thesisTopic;
	}

	String getThesisTopic() {
		return thesisTopic;
	}

	void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}

	@Override
	public String toString() {
		return super.toString() + ", Thesis: " + thesisTopic;
	}
}

class UniversitySystem {
	public static void main(String[] args) {
		GradStudent grad = new GradStudent("Emily Davis", 24, "GS001", 3.9, "ML Algorithms");

		System.out.println("=== Demonstrating IS-A Relationship ===");
		System.out.println(grad.toString());

		System.out.println("\n=== Type Checking ===");
		System.out.println("grad instanceof GradStudent: " + (grad instanceof GradStudent));
		System.out.println("grad instanceof Student: " + (grad instanceof Student));
		System.out.println("grad instanceof Person: " + (grad instanceof Person));
	}
}
