class Subscription {
	protected String subscriberName;
	protected String subscriptionId;

	Subscription(String subscriberName, String subscriptionId) {
		this.subscriberName = subscriberName;
		this.subscriptionId = subscriptionId;
	}

	double calculateMonthlyCharge() {
		return 0;
	}

	void displayInfo() {
		System.out.println("Subscriber: " + subscriberName + " (ID: " + subscriptionId + ")");
	}
}

class BasicPlan extends Subscription {
	BasicPlan(String subscriberName, String subscriptionId) {
		super(subscriberName, subscriptionId);
	}

	@Override
	double calculateMonthlyCharge() {
		return 299;
	}
}

class PremiumPlan extends Subscription {
	PremiumPlan(String subscriberName, String subscriptionId) {
		super(subscriberName, subscriptionId);
	}

	@Override
	double calculateMonthlyCharge() {
		return 699;
	}
}

class FamilyPlan extends Subscription {
	FamilyPlan(String subscriberName, String subscriptionId) {
		super(subscriberName, subscriptionId);
	}

	@Override
	double calculateMonthlyCharge() {
		return 999;
	}
}

class StreamingPlatformSubscriptionAnalyzer {
	static Subscription searchById(String subscriptionId, Subscription[] subscriptions) {
		for (Subscription sub : subscriptions) {
			if (sub.subscriptionId.equals(subscriptionId)) {
				return sub;
			}
		}
		return null;
	}

	static void displayByPrefix(char prefix, Subscription[] subscriptions) {
		System.out.println("\nSubscribers starting with '" + prefix + "':");
		for (Subscription sub : subscriptions) {
			if (sub.subscriberName.charAt(0) == prefix) {
				sub.displayInfo();
				System.out.printf("Charge: %.2f\n\n", sub.calculateMonthlyCharge());
			}
		}
	}

	static double calculateTotalRevenue(Subscription[] subscriptions) {
		double total = 0;
		for (Subscription sub : subscriptions) {
			total += sub.calculateMonthlyCharge();
		}
		return total;
	}

	static Subscription getMostExpensive(Subscription[] subscriptions) {
		Subscription most = subscriptions[0];
		for (Subscription sub : subscriptions) {
			if (sub.calculateMonthlyCharge() > most.calculateMonthlyCharge()) {
				most = sub;
			}
		}
		return most;
	}

	public static void main(String[] args) {
		Subscription[] subscriptions = {
			new BasicPlan("Alice", "SUB001"),
			new PremiumPlan("Bob", "SUB002"),
			new FamilyPlan("Charlie", "SUB003"),
			new BasicPlan("Diana", "SUB004"),
			new PremiumPlan("Eve", "SUB005"),
			new FamilyPlan("Frank", "SUB006")
		};

		System.out.println("=== Streaming Platform Subscription Analysis ===\n");

		System.out.println("All Subscriptions:");
		for (Subscription sub : subscriptions) {
			sub.displayInfo();
			System.out.printf("Monthly Charge: %.2f\n\n", sub.calculateMonthlyCharge());
		}

		System.out.println("Total Monthly Revenue: " + calculateTotalRevenue(subscriptions));

		displayByPrefix('A', subscriptions);

		Subscription searched = searchById("SUB003", subscriptions);
		if (searched != null) {
			System.out.println("Search Result for SUB003:");
			searched.displayInfo();
		}

		Subscription expensive = getMostExpensive(subscriptions);
		System.out.println("\nMost Expensive Plan:");
		expensive.displayInfo();
		System.out.printf("Monthly Charge: %.2f\n", expensive.calculateMonthlyCharge());
	}
}
