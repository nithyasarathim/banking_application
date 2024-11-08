package dao;
import java.sql.SQLException;

import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;

public interface AccountDAO {
	
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException;
	public void updateAccount(Account account) throws SQLException, UpdateFailureException;
	public void deleteAccount(int cusID) throws SQLException, DeleteAccountException;
}
