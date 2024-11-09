package dao;

import java.sql.SQLException;

import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;

public interface TransactionDAO {
	void deposit(int accountID, double amount) throws InvalidTransactionAmountException, SQLException, TransactionFailureException;
	void withdraw(int accountID,double amount) throws SQLException, TransactionFailureException;
	void transfer(int fromAccount, int toAccount, double amount);
}
