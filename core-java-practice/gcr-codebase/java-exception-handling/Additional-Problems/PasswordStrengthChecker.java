public class PasswordStrengthChecker {
	public static boolean checkPassword(String password) {
		try {
			if(password==null||password.isEmpty()) {
				throw new IllegalArgumentException("Password cannot be empty");
			}
			if(password.length()<8) {
				throw new IllegalArgumentException("Password must be at least 8 characters");
			}
			if(!Character.isUpperCase(password.charAt(0))) {
				throw new IllegalArgumentException("First character must be uppercase");
			}
			if(!Character.isDigit(password.charAt(password.length()-1))) {
				throw new IllegalArgumentException("Last character must be a digit");
			}
			boolean hasSpecial=false;
			for(char c:password.toCharArray()) {
				if(c=='@'||c=='#'||c=='$'||c=='%'||c=='&'||c=='*') {
					hasSpecial=true;
					break;
				}
			}
			if(!hasSpecial) {
				throw new IllegalArgumentException("Password must contain special character");
			}
			System.out.println("Password is strong");
			return true;
		} catch(NullPointerException e) {
			System.out.println("Error: Password is null");
			return false;
		} catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
			return false;
		}
	}
	public static void main(String[] args) {
		checkPassword("Strong@123");
		checkPassword("weak");
		checkPassword(null);
	}
}
