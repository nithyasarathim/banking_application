package model;

public class CurrentAccount extends Account{

	private double overdraft_limit;
	
	public CurrentAccount(int account_id, int customer_id, String accountType,Bank bank, double balance,double overdraft_limit) {
		super(account_id, customer_id, bank, accountType, balance);
		this.overdraft_limit=overdraft_limit;
	}

	public double getOverdraft_limit() {
		return overdraft_limit;
	}

	public void setOverdraft_limit(double overdraft_limit) {
		this.overdraft_limit = overdraft_limit;
	}

	@Override
	public String getAccountDetails() {
		return "This is current account with overdraft limit :"+this.overdraft_limit;
	}

	

	
	

}
