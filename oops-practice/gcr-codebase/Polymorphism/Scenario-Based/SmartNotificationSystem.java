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
			new EmailNotification("Sakshi", "Your order has been confirmed"),
			new SMSNotification("Bobby", "Your delivery is on the way"),
			new PushNotification("Charu", "Flash sale happening now!"),
			new EmailNotification("Dia", "Password reset link sent"),
			new SMSNotification("jai", "OTP: 123456")
		};

		System.out.println("Sending Notifications\n");
		for (Notification notification : notifications) {
			notification.sendNotification();
		}
	}
}
