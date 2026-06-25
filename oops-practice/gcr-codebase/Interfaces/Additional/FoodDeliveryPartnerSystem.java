interface FoodDelivery {
	void deliverFood(String order);
	default void trackOrder() {
		System.out.println("Tracking food order...");
	}
}

interface GroceryDelivery {
	void deliverGrocery(String order);
	default void trackOrder() {
		System.out.println("Tracking grocery order...");
	}
	static String generateDeliveryCode() {
		return "DEL" + System.currentTimeMillis() % 100000;
	}
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
	private String executiveId;
	private String[] customers;

	DeliveryExecutive(String executiveId, String[] customers) {
		this.executiveId = executiveId;
		this.customers = customers;
	}

	@Override
	public void deliverFood(String order) {
		System.out.println("Executive " + executiveId + " delivering food: " + order);
	}

	@Override
	public void deliverGrocery(String order) {
		System.out.println("Executive " + executiveId + " delivering grocery: " + order);
	}

	@Override
	public void trackOrder() {
		System.out.println("Order tracking code: " + GroceryDelivery.generateDeliveryCode());
	}

	void processAllDeliveries() {
		System.out.println("=== Delivery Service ===\n");
		deliverFood("Pizza from Dominos to " + customers[0]);
		trackOrder();
		System.out.println();
		deliverGrocery("Vegetables from Fresh Market to " + customers[1]);
		trackOrder();
		System.out.println();
		deliverFood("Biryani from Restaurant to " + customers[2]);
		trackOrder();
	}
}

class FoodDeliveryPartnerSystem {
	public static void main(String[] args) {
		String[] customers = { "Alice", "Bob", "Charlie" };
		DeliveryExecutive executive = new DeliveryExecutive("EXE001", customers);
		executive.processAllDeliveries();
	}
}
