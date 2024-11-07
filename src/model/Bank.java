package model;

public class Bank {
	
	private int bank_id;
	private String bankName;
	private String bankBranch;
	
	public int getBank_id() {
		return bank_id;
	}
	
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	public Bank (int bankID, String bankName, String bankBranch) {
		this.bank_id=bankID;
		this.bankName=bankName;
		this.bankBranch=bankBranch;
	}
	
}
