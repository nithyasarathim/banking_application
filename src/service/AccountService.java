package service;

import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOimpl;
import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

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
	
	public void deleteAccount(int accID) throws SQLException,DeleteAccountException {
		accountDAO.deleteAccount(accID);
	}
	
	public void viewAccount(int accID) throws SQLException {
		accountDAO.viewAccount(accID);
	}
	
	public void createSavingsAccount(SavingsAccount account) throws SQLException, InvalidAccountTypeException {
		accountDAO.createSavingsAccount(account);
	}
	
	public void createCurrentAccount(CurrentAccount account) throws SQLException, InvalidAccountTypeException {
		accountDAO.createCurrentAccount(account);
	}
}
