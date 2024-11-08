package model;

import java.util.Date;

public class WithdrawTransaction extends Transaction {
	
	private String withdrawMethod;

	public WithdrawTransaction(int transaction_id, int account_id, String transaction_type, double amount,
			Date transaction_date,String withdrawMethod) {
		super(transaction_id, account_id, transaction_type, amount, transaction_date);
		this.withdrawMethod=withdrawMethod;
	}

	public String getWithdrawMethod() {
		return withdrawMethod;
	}

	public void setWithdrawMethod(String withdrawMethod) {
		this.withdrawMethod = withdrawMethod;
	}

	@Override
	public String getTransaction_type() {
		return "The transaction type is :"+this.withdrawMethod;
	}

	@Override
	public String toString() {
		return "WithdrawTransaction [withdrawMethod=" + withdrawMethod + ", WithdrawMethod=" + getWithdrawMethod()
				+ ", Transaction_type=" + getTransaction_type() + ", Transaction_id=" + getTransaction_id()
				+ ", Account_id=" + getAccount_id() + ", Amount=" + getAmount() + ", Transaction_date="
				+ getTransaction_date() + ", Class=" + getClass() + ", hashCode=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	

}
