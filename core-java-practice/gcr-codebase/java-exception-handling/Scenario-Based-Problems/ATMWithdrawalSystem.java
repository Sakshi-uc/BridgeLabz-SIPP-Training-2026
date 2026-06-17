import java.util.*;
class InsufficientBalanceException extends Exception {
	private double balance;
	private double requestedAmount;
	public InsufficientBalanceException(String message, double balance, double requestedAmount) {
		super(message);
		this.balance=balance;
		this.requestedAmount=requestedAmount;
	}
	public double getBalance() {
		return balance;
	}
	public double getRequestedAmount() {
		return requestedAmount;
	}
	public double getShortfall() {
		return requestedAmount-balance;
	}
}
public class ATMWithdrawalSystem {
	private double balance;
	public ATMWithdrawalSystem(double balance) {
		this.balance=balance;
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient balance. Shortfall: "+
				(amount-balance), balance, amount);
		}
		balance-=amount;
		System.out.println("Withdrawal successful. New balance: "+balance);
	}
	public static void main(String[] args) {
		ATMWithdrawalSystem atm=new ATMWithdrawalSystem(5000);
		try {
			atm.withdraw(8000);
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			System.out.println("Current balance: "+e.getBalance());
			System.out.println("Requested: "+e.getRequestedAmount());
		}
	}
}
