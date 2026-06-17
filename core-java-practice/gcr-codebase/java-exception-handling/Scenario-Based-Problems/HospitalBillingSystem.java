import java.util.*;
class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message);
	}
}
public class HospitalBillingSystem {
	public static void processBill(double[] bills, int index, int itemCount) throws InsufficientFundsException {
		try {
			if(itemCount==0) {
				int result=100/itemCount;
			}
			double billAmount=bills[index];
			System.out.println("Bill amount: "+billAmount);
		} catch(ArithmeticException e) {
			System.out.println("Error: Cannot calculate with zero items");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Invalid patient index");
		} catch(NumberFormatException e) {
			System.out.println("Error: Invalid input format");
		}
	}
	public static void main(String[] args) {
		double[] bills={5000, 10000, 15000};
		try {
			processBill(bills, 1, 5);
			processBill(bills, 10, 3);
		} catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
