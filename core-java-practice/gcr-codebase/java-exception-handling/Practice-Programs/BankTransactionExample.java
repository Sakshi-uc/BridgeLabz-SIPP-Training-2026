import java.util.*;
class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
public class BankTransactionExample {
	private double balance;
	public BankTransactionExample(double initialBalance) {
		this.balance=initialBalance;
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount<0) {
			throw new IllegalArgumentException("Invalid amount!");
		}
		if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient balance!");
		}
		balance-=amount;
		System.out.println("Withdrawal successful, new balance: "+balance);
	}
	public static void main(String[] args) {
		BankTransactionExample account=new BankTransactionExample(5000);
		try {
			account.withdraw(2000);
			account.withdraw(8000);
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
