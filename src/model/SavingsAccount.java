package model;

public class SavingsAccount extends Account{
	
	private double interest_rate;
	
	public SavingsAccount(int account_id, int customer_id, Bank bank, String account_type, double balance,double interest_rate) {
		super(account_id, customer_id, bank, account_type, balance);
		this.interest_rate=interest_rate;
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	@Override
	public String getAccountDetails() {
		return "This is a Savings Account with interest rate :"+this.interest_rate;
	}
	

	
	
}
