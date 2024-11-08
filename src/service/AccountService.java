package service;

import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOimpl;
import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;

public class AccountService {
	
	private final AccountDAO accountDAO ;
	
	public AccountService()
	{
		this.accountDAO = new AccountDAOimpl();
	}
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException{
		accountDAO.createAccount(account);
	}
	
	public void updateAccount(Account account) throws SQLException, UpdateFailureException {
		accountDAO.updateAccount(account);
	}
	
	public void deleteAccount(int cusID) throws SQLException,DeleteAccountException {
		accountDAO.deleteAccount(cusID);
	}
	
}
