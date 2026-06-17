public class UsernameValidator {
	public static boolean isValidUsername(String username) {
		return isValidHelper(username, 0);
	}
	private static boolean isValidHelper(String username, int index) {
		if(index==username.length()) {
			return true;
		}
		char ch=username.charAt(index);
		if(ch<'a'||ch>'z') {
			return false;
		}
		return isValidHelper(username, index+1);
	}
	public static void main(String[] args) {
		System.out.println(isValidUsername("abcdxyz"));
		System.out.println(isValidUsername("abcD123"));
	}
}
