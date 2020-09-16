package ferlak0;

public class Account {
	
	private double balance;
	private double interestRate;
	private String accountNumber;
	private static int numberOfAccounts = 1000;
	private String accountType;
	
	public Account() {
		this.setAccountType("Sparkonto");
		this.interestRate = 1;
		this.balance = 0;
		numberOfAccounts++;
		this.accountNumber = String.valueOf(numberOfAccounts);
	}
	
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance = this.balance + amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean withdraw(double amount) {
		if(amount > 0 && amount <= this.balance) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	

	/*--- getters and setters ---*/
	
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

//	public void setAccountNumber() {
//		String accountNumber = String.valueOf(this.numberOfAccounts);
//		String id = String.valueOf(counter);
//		this.accountNumber = id + accountNumber;
//	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
