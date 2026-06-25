class Notification {
	protected String recipientName;
	protected String message;

	Notification(String recipientName, String message) {
		this.recipientName = recipientName;
		this.message = message;
	}

	void sendNotification() {
		System.out.println("Notification to " + recipientName + ": " + message);
	}
}

class EmailNotification extends Notification {
	EmailNotification(String recipientName, String message) {
		super(recipientName, message);
	}

	@Override
	void sendNotification() {
		System.out.println("EMAIL to " + recipientName + ": " + message);
	}
}

class SMSNotification extends Notification {
	SMSNotification(String recipientName, String message) {
		super(recipientName, message);
	}

	@Override
	void sendNotification() {
		System.out.println("SMS to " + recipientName + ": " + message);
	}
}

class PushNotification extends Notification {
	PushNotification(String recipientName, String message) {
		super(recipientName, message);
	}

	@Override
	void sendNotification() {
		System.out.println("PUSH NOTIFICATION to " + recipientName + ": " + message);
	}
}

class SmartNotificationSystem {
	public static void main(String[] args) {
		Notification[] notifications = {
			new EmailNotification("Alice", "Your order has been confirmed"),
			new SMSNotification("Bob", "Your delivery is on the way"),
			new PushNotification("Charlie", "Flash sale happening now!"),
			new EmailNotification("Diana", "Password reset link sent"),
			new SMSNotification("Eve", "OTP: 123456")
		};

		System.out.println("=== Sending Notifications ===\n");
		for (Notification notification : notifications) {
			notification.sendNotification();
		}
	}
}
