abstract class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;

	BankAccount(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	String getAccountNumber() {
		return accountNumber;
	}

	void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	String getHolderName() {
		return holderName;
	}

	void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	double getBalance() {
		return balance;
	}

	void setBalance(double balance) {
		this.balance = balance;
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.printf("Deposited: %.2f\n", amount);
		}
	}

	void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.printf("Withdrawn: %.2f\n", amount);
		} else {
			System.out.println("Invalid withdrawal amount");
		}
	}

	void displayAccountDetails() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Holder Name: " + holderName);
		System.out.printf("Balance: %.2f\n", balance);
	}

	abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
	private double interestRate;

	SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
	}

	void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	double getInterestRate() {
		return interestRate;
	}

	@Override
	double calculateInterest() {
		return getBalance() * interestRate / 100;
	}
}

class CurrentAccount extends BankAccount {
	private double monthlyBonusRate;

	CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
		super(accountNumber, holderName, balance);
		this.monthlyBonusRate = monthlyBonusRate;
	}

	void setMonthlyBonusRate(double monthlyBonusRate) {
		this.monthlyBonusRate = monthlyBonusRate;
	}

	double getMonthlyBonusRate() {
		return monthlyBonusRate;
	}

	@Override
	double calculateInterest() {
		return getBalance() * monthlyBonusRate / 100;
	}
}

class BankingSystem {
	public static void main(String[] args) {
		BankAccount savings = new SavingsAccount("SAV001", "John Doe", 10000, 5);
		BankAccount current = new CurrentAccount("CUR001", "Jane Smith", 20000, 3);

		System.out.println("=== Savings Account ===");
		savings.displayAccountDetails();
		savings.deposit(2000);
		savings.withdraw(1000);
		System.out.printf("Interest: %.2f\n\n", savings.calculateInterest());

		System.out.println("=== Current Account ===");
		current.displayAccountDetails();
		current.deposit(5000);
		current.withdraw(2000);
		System.out.printf("Interest: %.2f\n", current.calculateInterest());
	}
}
