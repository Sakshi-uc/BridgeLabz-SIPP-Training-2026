class Course {
	private String courseName;
	private int duration;

	Course(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}

	String getCourseName() {
		return courseName;
	}

	int getDuration() {
		return duration;
	}

	void displayInfo() {
		System.out.println("Course: " + courseName);
		System.out.println("Duration: " + duration + " hours");
	}
}

class OnlineCourse extends Course {
	private String platform;
	private boolean isRecorded;

	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}

	String getPlatform() {
		return platform;
	}

	boolean getIsRecorded() {
		return isRecorded;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Platform: " + platform);
		System.out.println("Recorded: " + isRecorded);
	}
}

class PaidOnlineCourse extends OnlineCourse {
	private double fee;
	private double discount;

	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}

	double getFee() {
		return fee;
	}

	double getDiscount() {
		return discount;
	}

	double getFinalPrice() {
		return fee - (fee * discount / 100);
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Original Fee: " + fee);
		System.out.println("Discount: " + discount + "%");
		System.out.printf("Final Price: %.2f\n", getFinalPrice());
	}
}

class EducationalCourseHierarchy {
	public static void main(String[] args) {
		Course basic = new Course("Java Basics", 40);
		OnlineCourse online = new OnlineCourse("Advanced Java", 80, "Udemy", true);
		PaidOnlineCourse paid = new PaidOnlineCourse("Java Mastery", 120, "Coursera", true, 9999, 20);

		System.out.println("=== Basic Course ===");
		basic.displayInfo();

		System.out.println("\n=== Online Course ===");
		online.displayInfo();

		System.out.println("\n=== Paid Online Course ===");
		paid.displayInfo();
	}
}
