public class SumNNumbers {
	public static int sumNNumbers(int n) {
		if(n==0) {
			return 0;
		}
		return n+sumNNumbers(n-1);
	}
	public static void main(String[] args) {
		System.out.println(sumNNumbers(5));
	}
}
