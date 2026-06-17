public class PalindromeChecker {
	public static boolean isPalindrome(String str) {
		str=str.toLowerCase();
		return isPalindromeHelper(str, 0, str.length()-1);
	}
	private static boolean isPalindromeHelper(String str, int start, int end) {
		if(start>=end) {
			return true;
		}
		if(str.charAt(start)!=str.charAt(end)) {
			return false;
		}
		return isPalindromeHelper(str, start+1, end-1);
	}
	public static void main(String[] args) {
		String input="madam";
		if(isPalindrome(input)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}
	}
}
