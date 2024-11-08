package dao;
import java.sql.SQLException;

import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;

public interface AccountDAO {
	
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException;
	public void updateAccount(Account account) throws SQLException, UpdateFailureException;
	
}
