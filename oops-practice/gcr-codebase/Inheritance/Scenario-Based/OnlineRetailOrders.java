class Order {
	private String orderId;
	private String orderDate;

	Order(String orderId, String orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	String getOrderId() {
		return orderId;
	}

	String getOrderDate() {
		return orderDate;
	}

	String getOrderStatus() {
		return "Order Placed";
	}

	void displayOrder() {
		System.out.println("Order ID: " + orderId);
		System.out.println("Order Date: " + orderDate);
		System.out.println("Status: " + getOrderStatus());
	}
}

class ShippedOrder extends Order {
	private String trackingNumber;

	ShippedOrder(String orderId, String orderDate, String trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}

	String getTrackingNumber() {
		return trackingNumber;
	}

	@Override
	String getOrderStatus() {
		return "Order Shipped";
	}

	@Override
	void displayOrder() {
		super.displayOrder();
		System.out.println("Tracking Number: " + trackingNumber);
	}
}

class DeliveredOrder extends ShippedOrder {
	private String deliveryDate;

	DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
		super(orderId, orderDate, trackingNumber);
		this.deliveryDate = deliveryDate;
	}

	String getDeliveryDate() {
		return deliveryDate;
	}

	@Override
	String getOrderStatus() {
		return "Order Delivered";
	}

	@Override
	void displayOrder() {
		super.displayOrder();
		System.out.println("Delivery Date: " + deliveryDate);
	}
}

class OnlineRetailOrders {
	public static void main(String[] args) {
		Order order = new Order("ORD001", "2024-06-20");
		ShippedOrder shipped = new ShippedOrder("ORD002", "2024-06-21", "TRK12345");
		DeliveredOrder delivered = new DeliveredOrder("ORD003", "2024-06-22", "TRK12346", "2024-06-25");

		System.out.println("=== Order Placed ===");
		order.displayOrder();

		System.out.println("\n=== Order Shipped ===");
		shipped.displayOrder();

		System.out.println("\n=== Order Delivered ===");
		delivered.displayOrder();
	}
}
