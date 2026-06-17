public class ReverseInteger {
	public static int reverseInteger(int x) {
		long result=0;
		while(x!=0) {
			int digit=x%10;
			result=result*10+digit;
			if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) {
				return 0;
			}
			x/=10;
		}
		return (int)result;
	}
	public static void main(String[] args) {
		System.out.println(reverseInteger(123));
		System.out.println(reverseInteger(-123));
	}
}
