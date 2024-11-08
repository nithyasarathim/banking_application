package model;

import java.util.Date;

public class DepositTransaction extends Transaction {
	
	private String depositMethod;
	
	public DepositTransaction(int transaction_id, int account_id, String transaction_type, double amount, 
			Date transaction_date,String depositMethod) {
		
		super(transaction_id, account_id, transaction_type, amount, transaction_date);
		this.depositMethod=depositMethod;
	}

	public String getDepositMethod() {
		return depositMethod;
	}

	public void setDepositMethod(String depositMethod) {
		this.depositMethod = depositMethod;
	}

	@Override
	public String getTransaction_type() {
		return "Transaction type is :"+this.depositMethod;
	}

	@Override
	public String toString() {
		return "DepositTransaction [depositMethod=" + depositMethod + ", DepositMethod=" + getDepositMethod()
				+ ", Transaction_type=" + getTransaction_type() + ", Transaction_id=" + getTransaction_id()
				+ ", Account_id=" + getAccount_id() + ", Amount=" + getAmount() + ", Transaction_date="
				+ getTransaction_date() + ", Class=" + getClass() + ", hashCode=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}
