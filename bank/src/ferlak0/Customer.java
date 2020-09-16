package ferlak0;
import java.util.ArrayList;

public class Customer {

	private String name;
	private String surname;
	private String pNr;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public Customer() {
		this(null,null,null);
	}
	
	public Customer(String name, String surname, String pNr) {
		this.name = name;
		this.surname = surname;
		this.pNr = pNr;		
	}
	
	public String newAccount() {
		Account newAccount = new Account();
		this.accounts.add(newAccount);
		return newAccount.getAccountNumber();
	}
	
	public boolean deposit(int accountNr, double amount) {
		boolean success = false;
		for(int i = 0;i < this.accounts.size();i++) {
			if(this.accounts.get(i).getAccountNumber() == String.valueOf(accountNr)) {
				this.accounts.get(i).deposit(amount);
				success = true;
			}
		}
		return success;
	}
	
	public boolean withdraw(int accountNr, double amount) {
		boolean success = false;
		for(int i = 0;i < this.accounts.size();i++) {
			if(this.accounts.get(i).getAccountNumber() == String.valueOf(accountNr)) {
				if( this.accounts.get(i).withdraw(amount) ) {
					success = true;
				}
			}
		}
		return success;
	}
	
	
	/*--- getters and setters ---*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getpNr() {
		return this.pNr;
	}
	public void setpNr(String pNr) {
		this.pNr = pNr;
	}
	public void setAccount() {
		Account newAccount = new Account();
		this.accounts.add(newAccount);
	}
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}
}
