package model;

public abstract class Account {
	
	public Account(int account_id, int customer_id, Bank bank, String account_type, double balance) {
		super();
		this.account_id = account_id;
		this.customer_id = customer_id;
		this.bank = bank;
		this.account_type = account_type;
		this.balance = balance;
	}

	private int account_id;
	private int customer_id;
	private Bank bank;
	private String account_type;
	private double balance;
	
	public int getAccount_id() {
		return account_id;
	}
	
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	abstract public String getAccountDetails();
}
