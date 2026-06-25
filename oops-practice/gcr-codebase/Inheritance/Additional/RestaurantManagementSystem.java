class Person {
	private String name;
	private String id;

	Person(String name, String id) {
		this.name = name;
		this.id = id;
	}

	String getName() {
		return name;
	}

	String getId() {
		return id;
	}
}

interface Worker {
	void performDuties();
}

class Chef extends Person implements Worker {
	private String specialization;

	Chef(String name, String id, String specialization) {
		super(name, id);
		this.specialization = specialization;
	}

	String getSpecialization() {
		return specialization;
	}

	@Override
	public void performDuties() {
		System.out.println("Chef " + getName() + " specializes in " + specialization + " cuisine and is preparing dishes");
	}
}

class Waiter extends Person implements Worker {
	private String section;

	Waiter(String name, String id, String section) {
		super(name, id);
		this.section = section;
	}

	String getSection() {
		return section;
	}

	@Override
	public void performDuties() {
		System.out.println("Waiter " + getName() + " is serving customers in " + section + " section");
	}
}

class RestaurantManagementSystem {
	public static void main(String[] args) {
		Chef chef = new Chef("Marco Rossi", "CH001", "Italian");
		Waiter waiter = new Waiter("Sarah Johnson", "WT001", "A");

		System.out.println("=== Chef Details ===");
		System.out.println("Name: " + chef.getName());
		System.out.println("ID: " + chef.getId());
		chef.performDuties();

		System.out.println("\n=== Waiter Details ===");
		System.out.println("Name: " + waiter.getName());
		System.out.println("ID: " + waiter.getId());
		waiter.performDuties();
	}
}
