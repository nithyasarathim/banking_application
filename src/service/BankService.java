package service;

import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOimpl;
import dao.BankDAO;
import dao.BankDAOimpl;
import exception.BankingException;
import model.Bank;

public class BankService {
	private final BankDAO bankDAO;
	private final AccountDAO accountDAO;
	
	public BankService() {
		this.bankDAO = new BankDAOimpl();
		this.accountDAO = new AccountDAOimpl();
	}
	
	public Bank getBankById(int bankId) throws SQLException, BankingException {
		return this.bankDAO.getBankById(bankId);
	}
}

