import java.util.*;
public class Fibonacci {
	public static long fibonacci(int n) {
		if(n<=1) {
			return n;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static long fibonacciOptimized(int n) {
		Map<Integer,Long> memo=new HashMap<>();
		return fibHelper(n, memo);
	}
	private static long fibHelper(int n, Map<Integer,Long> memo) {
		if(n<=1) {
			return n;
		}
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		long result=fibHelper(n-1, memo)+fibHelper(n-2, memo);
		memo.put(n, result);
		return result;
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(6));
		System.out.println(fibonacciOptimized(6));
	}
}
