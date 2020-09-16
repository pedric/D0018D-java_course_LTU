package ferlak0;
import java.util.*;

public class BankLogic {

	private ArrayList<Customer> customers;
	private int numberOfAccounts;
	
	public BankLogic() {
		this.customers = new ArrayList<Customer>();
		numberOfAccounts = 1000;
	}
	
	public ArrayList<String> getAllCustomers(){
		ArrayList<String> customers = new ArrayList<String>();
		for(int i = 0; i < this.customers.size(); i++) {
			String customer = "";
			customer += this.customers.get(i).getpNr();
			customer += " " + this.customers.get(i).getName() + " " + this.customers.get(i).getSurname();
			customers.add(customer);
		}
		return customers;
	}
	
	public boolean createCustomer(String name, String surname, String pNo) {
		boolean unique_customer = true;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				unique_customer = false;
			}
		}
		
		if(unique_customer) {
			Customer newCustomer = new Customer(name, surname, pNo);
			this.customers.add(newCustomer);
			return true;
		} else {
			return false;
		}
		
	}
	
	public ArrayList<String> getCustomer(String pNo) {
		boolean customerFound = false;
		ArrayList<String> customerData = new ArrayList<String>();
		Customer customer = new Customer();
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				customer = this.customers.get(i);
				customerFound = true;
			}
		}
		String customerDescription = customer.getpNr() + " " + customer.getName() + " " + customer.getSurname();
		customerData.add(customerDescription);
		ArrayList<Account> customerAccounts = customer.getAccounts();

		for(int i = 0; i < customerAccounts.size(); i++) {
			String accountInfo =
							customerAccounts.get(i).getAccountNumber() + " "
							+ String.valueOf(customerAccounts.get(i).getBalance()) + " kr "
							+ customerAccounts.get(i).getAccountType() + " "
							+ String.valueOf(customerAccounts.get(i).getInterestRate()) + " %";
			customerData.add(accountInfo);
		}
		if(customerFound) {
			return customerData;
		} else {
			return null;
		}
	}
	
	public boolean changeCustomerName(String name, String surname, String pNo) {
		boolean customerFound = false;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				customerFound = true;
				if(name.length() > 0) { this.customers.get(i).setName(name); } else { customerFound = false; }
				if(surname.length() > 0) {this.customers.get(i).setSurname(surname); }  else { customerFound = false; }
			}
		}
		return customerFound;
	}
	
	// BUGGAR
	public int createSavingsAccount(String pNo) {
		boolean accountIsSet = false;
		String accountNumber = "";
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				accountNumber = this.customers.get(i).newAccount();
				accountIsSet = true;
			}
		}
		if(accountIsSet) {
			int nr = Integer.parseInt(accountNumber);
			return nr;
		} else {
			return -1;
		}
	}
	
	public String getAccount(String pNo, int accountId) {
		String account = null;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				for(int j = 0; j < this.customers.get(i).getAccounts().size();j++) {
					if(this.customers.get(i).getAccounts().get(j).getAccountNumber().equals(String.valueOf(accountId))) {
						Account foundAccount = this.customers.get(i).getAccounts().get(j);
						account = 
								foundAccount.getAccountNumber() + " " 
								+ foundAccount.getBalance() + "kr " 
								+ foundAccount.getAccountType() + " " 
								+ foundAccount.getInterestRate() + "%";
					}
				}
			}
		}
		return account;
	}
	
	// BUGGAR
	public boolean deposit(String pNo, int accountId, double amount) {
		boolean depositDone = false;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				for(int j = 0; j < this.customers.get(i).getAccounts().size();j++) {
					if(this.customers.get(i).getAccounts().get(j).getAccountNumber().equals(String.valueOf(accountId))) {
						Account foundAccount = this.customers.get(i).getAccounts().get(j);
						if(foundAccount.deposit(amount)) {
							depositDone = true;
						}
					}
				}
			}
		}
		return depositDone;
	}
	
	public boolean withdraw(String pNo, int accountId, double amount) {
		boolean withdrawDone = false;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNo) {
				for(int j = 0; j < this.customers.get(i).getAccounts().size();j++) {
					if(this.customers.get(i).getAccounts().get(j).getAccountNumber().equals(String.valueOf(accountId)) && this.customers.get(i).getAccounts().get(j).getBalance() >= amount) {
						Account foundAccount = this.customers.get(i).getAccounts().get(j);
						if(foundAccount.withdraw(amount)) {
							withdrawDone = true;
						}
					}
				}
			}
		}
		return withdrawDone;
	}
	
	public String closeAccount(String pNr, int accountId) {
		String summaryOfClosedAccount = null;
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr() == pNr) {
				for(int j = 0; j < this.customers.get(i).getAccounts().size();j++) {
					if(this.customers.get(i).getAccounts().get(j).getAccountNumber().equals(String.valueOf(accountId))) {
						Account foundAccount = this.customers.get(i).getAccounts().get(j);
						summaryOfClosedAccount = 
								foundAccount.getAccountNumber() + " " 
								+ foundAccount.getBalance() + "kr " 
								+ foundAccount.getAccountType() + " "
								+ (foundAccount.getBalance() * foundAccount.getInterestRate() / 100) + " kr";
						this.customers.get(i).getAccounts().remove(j);
					}
				}
			}
		}
		return summaryOfClosedAccount;
	}
	
	public ArrayList<String> deleteCustomer(String pNo){
		ArrayList<String> customerData = new ArrayList<String>();
		Customer customer = new Customer();
		for(int i = 0; i < this.customers.size(); i++) {
			if(this.customers.get(i).getpNr().equals(pNo)) {
				customer = this.customers.get(i);
				this.customers.remove(i);
			}
		}
		String customerDescription = customer.getpNr() + " " + customer.getName() + " " + customer.getSurname();
		customerData.add(customerDescription);
		ArrayList<Account> customerAccounts = customer.getAccounts();
		
		for(int i = 0; i < customerAccounts.size(); i++) {
			String accountInfo = 
							customerAccounts.get(i).getAccountNumber() + " " 
							+ String.valueOf(customerAccounts.get(i).getBalance()) + " kr " 
							+ customerAccounts.get(i).getAccountType() + " " 
							+ String.valueOf( customerAccounts.get(i).getBalance() * customerAccounts.get(i).getInterestRate() / 100) + " kr";
			customerData.add(accountInfo);
		}
		if(customerData.size() > 0) {
			customer = null;
			return customerData;
		} else {
			return null;
		}
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts() {
		this.numberOfAccounts += 1;
	}
	
//	public Account getAccountFromPnoAndAccountId(String pNo, int accountId) {
//		Account foundAccount = new Account();
//		for(int i = 0; i < this.customers.size(); i++) {
//			if(this.customers.get(i).getpNr() == pNo) {
//				for(int j = 0; j < this.customers.get(i).getAccounts().size();j++) {
//					if(this.customers.get(i).getAccounts().get(j).getAccountNumber() == String.valueOf(accountId)) {
//						foundAccount = this.customers.get(i).getAccounts().get(j);
//					}
//				}
//			}
//		}
//		return foundAccount;
//	}
}















