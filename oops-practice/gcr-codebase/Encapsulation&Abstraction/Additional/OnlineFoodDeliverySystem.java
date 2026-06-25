abstract class FoodItem {
	private String itemName;
	private double price;
	private int quantity;

	FoodItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	String getItemName() {
		return itemName;
	}

	void setItemName(String itemName) {
		this.itemName = itemName;
	}

	double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	int getQuantity() {
		return quantity;
	}

	void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	abstract double calculateTotalPrice();

	void displayItemDetails() {
		System.out.println("Item: " + itemName);
		System.out.println("Price per unit: " + price);
		System.out.println("Quantity: " + quantity);
	}
}

class VegItem extends FoodItem {
	VegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	}

	@Override
	double calculateTotalPrice() {
		return getPrice() * getQuantity();
	}
}

class NonVegItem extends FoodItem {
	private double serviceCharge = 50;

	NonVegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	}

	void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	double getServiceCharge() {
		return serviceCharge;
	}

	@Override
	double calculateTotalPrice() {
		return (getPrice() * getQuantity()) + serviceCharge;
	}
}

class OnlineFoodDeliverySystem {
	public static void main(String[] args) {
		FoodItem veg = new VegItem("Vegetable Biryani", 250, 2);
		FoodItem nonVeg = new NonVegItem("Chicken Biryani", 350, 1);

		System.out.println("=== Vegetarian Item ===");
		veg.displayItemDetails();
		System.out.printf("Total Price: %.2f\n\n", veg.calculateTotalPrice());

		System.out.println("=== Non-Vegetarian Item ===");
		nonVeg.displayItemDetails();
		System.out.printf("Total Price: %.2f\n", nonVeg.calculateTotalPrice());
	}
}
