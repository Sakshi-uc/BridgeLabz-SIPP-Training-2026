interface CouponValidator {
	boolean validateCoupon(String code);

	static boolean isLengthValid(String code) {
		return code.length() >= 6 && code.length() <= 12;
	}
}

class ShoppingCart implements CouponValidator {
	private String[] coupons;

	ShoppingCart(String[] coupons) {
		this.coupons = coupons;
	}

	@Override
	public boolean validateCoupon(String code) {
		if (!CouponValidator.isLengthValid(code)) {
			return false;
		}
		for (String coupon : coupons) {
			if (coupon.equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}

	void checkCoupons(String[] codestoCheck) {
		System.out.println("=== Coupon Validation ===\n");
		for (String code : codestoCheck) {
			boolean valid = validateCoupon(code);
			System.out.println("Code: " + code + " -> " + (valid ? "VALID" : "INVALID"));
		}
	}
}

class CouponValidatorSystem {
	public static void main(String[] args) {
		String[] validCoupons = { "SUMMER20", "FLAT50", "WELCOME10", "SPECIAL99" };
		String[] codestoCheck = { "SUMMER20", "INVALID", "FLAT50", "TEST", "WELCOME10", "NOTEXIST" };

		ShoppingCart cart = new ShoppingCart(validCoupons);
		cart.checkCoupons(codestoCheck);
	}
}
