package model;

import java.util.Date;

public abstract class Transaction {

	private int transaction_id;
	private int account_id;
	private String transaction_type;
	private double amount;
	private Date transaction_date;

	public Transaction(int transaction_id, int account_id, String transaction_type, double amount, Date transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.account_id = account_id;
		this.transaction_type = transaction_type;
		this.amount = amount;
		this.transaction_date = transaction_date;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
	
}
