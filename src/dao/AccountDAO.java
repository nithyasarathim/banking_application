package dao;
import java.sql.SQLException;

import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

public interface AccountDAO {
	
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException;
	public void updateAccount(Account account) throws SQLException, UpdateFailureException;
	public void deleteAccount(int accID) throws SQLException, DeleteAccountException;
	public void viewAccount(int accID) throws SQLException;
	void createSavingsAccount(SavingsAccount account) throws SQLException, InvalidAccountTypeException;
	void createCurrentAccount(CurrentAccount account) throws SQLException, InvalidAccountTypeException;
}
