interface LuggageScanner {
	boolean scanLuggage(String passengerName);
	default void displaySecurityGuidelines() {
		System.out.println("Luggage must not exceed 25kg weight limit");
	}
}

interface PassportVerifier {
	boolean verifyPassport(String passportNo);
	default void displaySecurityGuidelines() {
		System.out.println("Passport must be valid for minimum 6 months");
	}
	static boolean isPassportNumberValid(String passportNo) {
		return passportNo.matches("[A-Z]{2}\\d{7}");
	}
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
	private String[] validPassports = { "AB1234567", "CD2345678", "EF3456789" };

	@Override
	public boolean scanLuggage(String passengerName) {
		System.out.println("Scanning luggage for " + passengerName);
		return true;
	}

	@Override
	public boolean verifyPassport(String passportNo) {
		for (String valid : validPassports) {
			if (valid.equals(passportNo)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void displaySecurityGuidelines() {
		System.out.println("Complete Security Protocol: Luggage + Passport verification required");
	}

	boolean canBoard(String passengerName, String passportNo) {
		if (!PassportVerifier.isPassportNumberValid(passportNo)) {
			System.out.println(passengerName + ": INVALID PASSPORT FORMAT");
			return false;
		}
		if (!verifyPassport(passportNo)) {
			System.out.println(passengerName + ": PASSPORT NOT FOUND IN DATABASE");
			return false;
		}
		if (!scanLuggage(passengerName)) {
			System.out.println(passengerName + ": LUGGAGE SCAN FAILED");
			return false;
		}
		System.out.println(passengerName + ": CLEARED FOR BOARDING");
		return true;
	}
}

class AirportSecurityDemo {
	public static void main(String[] args) {
		AirportSecuritySystem security = new AirportSecuritySystem();
		security.displaySecurityGuidelines();
		System.out.println();

		System.out.println("=== Passenger 1 ===");
		security.canBoard("John Doe", "AB1234567");

		System.out.println("\n=== Passenger 2 ===");
		security.canBoard("Jane Smith", "XY9999999");

		System.out.println("\n=== Passenger 3 ===");
		security.canBoard("Bob Wilson", "CD2345678");
	}
}
